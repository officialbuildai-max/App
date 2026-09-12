package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class TransferNetworkLossHandler extends BroadcastReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static final Log f18547d = LogFactory.b(TransferNetworkLossHandler.class);

    /* renamed from: e, reason: collision with root package name */
    private static TransferNetworkLossHandler f18548e;

    /* renamed from: a, reason: collision with root package name */
    final ConnectivityManager f18549a;

    /* renamed from: b, reason: collision with root package name */
    private TransferDBUtil f18550b;

    /* renamed from: c, reason: collision with root package name */
    TransferStatusUpdater f18551c;

    private TransferNetworkLossHandler(Context context) {
        this.f18549a = (ConnectivityManager) context.getSystemService("connectivity");
        this.f18550b = new TransferDBUtil(context);
        this.f18551c = TransferStatusUpdater.c(context);
    }

    public static synchronized TransferNetworkLossHandler c() {
        TransferNetworkLossHandler transferNetworkLossHandler;
        synchronized (TransferNetworkLossHandler.class) {
            transferNetworkLossHandler = f18548e;
            if (transferNetworkLossHandler == null) {
                f18547d.f("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
                throw new TransferUtilityException("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
            }
        }
        return transferNetworkLossHandler;
    }

    public static synchronized TransferNetworkLossHandler d(Context context) {
        TransferNetworkLossHandler transferNetworkLossHandler;
        synchronized (TransferNetworkLossHandler.class) {
            try {
                if (f18548e == null) {
                    f18548e = new TransferNetworkLossHandler(context);
                }
                transferNetworkLossHandler = f18548e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return transferNetworkLossHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        for (TransferRecord transferRecord : this.f18551c.e().values()) {
            AmazonS3 a11 = S3ClientReference.a(Integer.valueOf(transferRecord.f18563a));
            if (a11 != null && transferRecord.h(a11, this.f18551c, this.f18549a)) {
                this.f18551c.l(transferRecord.f18563a, TransferState.WAITING_FOR_NETWORK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        TransferRecord d11;
        int i11 = 0;
        synchronized (this) {
            TransferState[] transferStateArr = {TransferState.WAITING_FOR_NETWORK};
            f18547d.a("Loading transfers from database...");
            ArrayList<Integer> arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                cursor = this.f18550b.o(TransferType.ANY, transferStateArr);
                while (cursor.moveToNext()) {
                    int i12 = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                    if (this.f18551c.d(i12) == null) {
                        TransferRecord transferRecord = new TransferRecord(i12);
                        transferRecord.j(cursor);
                        this.f18551c.b(transferRecord);
                        i11++;
                    }
                    arrayList.add(Integer.valueOf(i12));
                }
                f18547d.a("Closing the cursor for resumeAllTransfers");
                cursor.close();
                try {
                    for (Integer num : arrayList) {
                        AmazonS3 a11 = S3ClientReference.a(num);
                        if (a11 != null && (d11 = this.f18551c.d(num.intValue())) != null && !d11.f()) {
                            d11.i(a11, this.f18550b, this.f18551c, this.f18549a);
                        }
                    }
                } catch (Exception e11) {
                    f18547d.f("Error in resuming the transfers." + e11.getMessage());
                }
                f18547d.a(i11 + " transfers are loaded from database.");
            } catch (Throwable th2) {
                if (cursor != null) {
                    f18547d.a("Closing the cursor for resumeAllTransfers");
                    cursor.close();
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        NetworkInfo activeNetworkInfo = this.f18549a.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            Log log = f18547d;
            log.d("Network connectivity changed detected.");
            log.d("Network connected: " + e());
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TransferNetworkLossHandler.this.e()) {
                        TransferNetworkLossHandler.this.g();
                    } else {
                        TransferNetworkLossHandler.this.f();
                    }
                }
            }).start();
        }
    }
}
