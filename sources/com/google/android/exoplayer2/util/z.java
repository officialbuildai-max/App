package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class z {

    /* renamed from: e, reason: collision with root package name */
    private static z f27751e;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f27752a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f27753b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Object f27754c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private int f27755d = 0;

    /* loaded from: classes3.dex */
    private static final class b {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* renamed from: a, reason: collision with root package name */
            private final z f27756a;

            public a(z zVar) {
                this.f27756a = zVar;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType;
                overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f27756a.k(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, z zVar) {
            Executor mainExecutor;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) com.google.android.exoplayer2.util.a.e((TelephonyManager) context.getSystemService("phone"));
                a aVar = new a(zVar);
                mainExecutor = context.getMainExecutor();
                telephonyManager.registerTelephonyCallback(mainExecutor, aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                zVar.k(5);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i11);
    }

    /* loaded from: classes3.dex */
    private final class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int g11 = z.g(context);
            if (p0.f27680a < 31 || g11 != 5) {
                z.this.k(g11);
            } else {
                b.a(context, z.this);
            }
        }
    }

    private z(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new d(), intentFilter);
    }

    public static synchronized z d(Context context) {
        z zVar;
        synchronized (z.class) {
            try {
                if (f27751e == null) {
                    f27751e = new z(context);
                }
                zVar = f27751e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zVar;
    }

    private static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return p0.f27680a >= 29 ? 9 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i11 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i11 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        cVar.a(f());
    }

    private void j() {
        Iterator it = this.f27753b.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                this.f27753b.remove(weakReference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i11) {
        synchronized (this.f27754c) {
            try {
                if (this.f27755d == i11) {
                    return;
                }
                this.f27755d = i11;
                Iterator it = this.f27753b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    c cVar = (c) weakReference.get();
                    if (cVar != null) {
                        cVar.a(i11);
                    } else {
                        this.f27753b.remove(weakReference);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int f() {
        int i11;
        synchronized (this.f27754c) {
            i11 = this.f27755d;
        }
        return i11;
    }

    public void i(final c cVar) {
        j();
        this.f27753b.add(new WeakReference(cVar));
        this.f27752a.post(new Runnable() { // from class: com.google.android.exoplayer2.util.y
            @Override // java.lang.Runnable
            public final void run() {
                z.this.h(cVar);
            }
        });
    }
}
