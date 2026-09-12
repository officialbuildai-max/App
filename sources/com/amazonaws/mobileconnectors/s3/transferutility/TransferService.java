package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class TransferService extends Service {

    /* renamed from: d, reason: collision with root package name */
    private static final Log f18589d = LogFactory.b(TransferService.class);

    /* renamed from: e, reason: collision with root package name */
    static TransferNetworkLossHandler f18590e;

    /* renamed from: a, reason: collision with root package name */
    boolean f18591a = true;

    /* renamed from: b, reason: collision with root package name */
    private int f18592b = 1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18593c = true;

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) == 0) {
            return;
        }
        printWriter.printf("network status: %s\n", Boolean.valueOf(f18590e.e()));
        Map e11 = TransferStatusUpdater.c(this).e();
        printWriter.printf("# of active transfers: %d\n", Integer.valueOf(e11.size()));
        for (TransferRecord transferRecord : e11.values()) {
            printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", transferRecord.f18578p, transferRecord.f18579q, transferRecord.f18577o, Long.valueOf(transferRecord.f18570h), Long.valueOf(transferRecord.f18571i));
        }
        printWriter.flush();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log log = f18589d;
        log.d("Starting Transfer Service to listen for network connectivity changes.");
        f18590e = TransferNetworkLossHandler.d(getApplicationContext());
        synchronized (this) {
            if (this.f18591a) {
                try {
                    log.d("Registering the network receiver");
                    registerReceiver(f18590e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f18591a = false;
                } catch (IllegalArgumentException unused) {
                    f18589d.j("Ignoring the exception trying to register the receiver for connectivity change.");
                } catch (IllegalStateException unused2) {
                    f18589d.j("Ignoring the leak in registering the receiver.");
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|2|(6:4|d|23|24|25|26)|16|17|36|(2:(0)|(1:32))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        com.amazonaws.mobileconnectors.s3.transferutility.TransferService.f18589d.j("Exception trying to de-register the network receiver");
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDestroy() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L18
            r1 = 26
            if (r0 < r1) goto L2f
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.f18589d     // Catch: java.lang.Exception -> L18
            java.lang.String r1 = "Moving the service out of the Foreground state."
            r0.d(r1)     // Catch: java.lang.Exception -> L18
            monitor-enter(r4)     // Catch: java.lang.Exception -> L18
            boolean r0 = r4.f18593c     // Catch: java.lang.Throwable -> L15
            r4.stopForeground(r0)     // Catch: java.lang.Throwable -> L15
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            goto L2f
        L15:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            throw r0     // Catch: java.lang.Exception -> L18
        L18:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.f18589d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error in moving the service out of the foreground state: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.f(r0)
        L2f:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.f18589d     // Catch: java.lang.IllegalArgumentException -> L4d
            java.lang.String r1 = "De-registering the network receiver."
            r0.d(r1)     // Catch: java.lang.IllegalArgumentException -> L4d
            monitor-enter(r4)     // Catch: java.lang.IllegalArgumentException -> L4d
            boolean r0 = r4.f18591a     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L49
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.f18590e     // Catch: java.lang.Throwable -> L47
            r4.unregisterReceiver(r0)     // Catch: java.lang.Throwable -> L47
            r0 = 1
            r4.f18591a = r0     // Catch: java.lang.Throwable -> L47
            r0 = 0
            com.amazonaws.mobileconnectors.s3.transferutility.TransferService.f18590e = r0     // Catch: java.lang.Throwable -> L47
            goto L49
        L47:
            r0 = move-exception
            goto L4b
        L49:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L47
            goto L54
        L4b:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L47
            throw r0     // Catch: java.lang.IllegalArgumentException -> L4d
        L4d:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.f18589d
            java.lang.String r1 = "Exception trying to de-register the network receiver"
            r0.j(r1)
        L54:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onDestroy():void");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                synchronized (this) {
                    try {
                        Notification notification = (Notification) intent.getParcelableExtra("notification");
                        if (notification != null) {
                            this.f18592b = intent.getIntExtra("ongoing-notification-id", this.f18592b);
                            this.f18593c = intent.getBooleanExtra("remove-notification", this.f18593c);
                            f18589d.d("Putting the service in Foreground state.");
                            startForeground(this.f18592b, notification);
                        } else {
                            f18589d.f("No notification is passed in the intent. Unable to transition to foreground.");
                        }
                    } finally {
                    }
                }
            } catch (Exception e11) {
                f18589d.f("Error in moving the service to foreground state: " + e11);
            }
            return 1;
        }
        synchronized (this) {
            if (this.f18591a) {
                try {
                    try {
                        f18589d.d("Registering the network receiver");
                        registerReceiver(f18590e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        this.f18591a = false;
                    } catch (IllegalStateException unused) {
                        f18589d.j("Ignoring the leak in registering the receiver.");
                    }
                } catch (IllegalArgumentException unused2) {
                    f18589d.j("Ignoring the exception trying to register the receiver for connectivity change.");
                }
            }
            return 1;
        }
    }
}
