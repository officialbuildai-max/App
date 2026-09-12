package androidx.media3.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.media3.common.util.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class z {

    /* renamed from: f, reason: collision with root package name */
    private static z f10558f;

    /* renamed from: a, reason: collision with root package name */
    private final Executor f10559a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f10560b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f10561c;

    /* renamed from: d, reason: collision with root package name */
    private int f10562d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10563e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* renamed from: a, reason: collision with root package name */
            private final z f10564a;

            public a(z zVar) {
                this.f10564a = zVar;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType;
                overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f10564a.n(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, z zVar) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) androidx.media3.common.util.a.e((TelephonyManager) context.getSystemService("phone"));
                a aVar = new a(zVar);
                telephonyManager.registerTelephonyCallback(zVar.f10559a, aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                zVar.n(5);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f10565a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f10566b;

        public d(c cVar, Executor executor) {
            this.f10565a = new WeakReference(cVar);
            this.f10566b = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            c cVar = (c) this.f10565a.get();
            if (cVar != null) {
                cVar.a(z.this.g());
            }
        }

        public void b() {
            this.f10566b.execute(new Runnable() { // from class: androidx.media3.common.util.d0
                @Override // java.lang.Runnable
                public final void run() {
                    z.d.this.d();
                }
            });
        }

        public boolean c() {
            return this.f10565a.get() == null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class e extends BroadcastReceiver {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Context context) {
            z.this.i(context);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            z.this.f10559a.execute(new Runnable() { // from class: androidx.media3.common.util.e0
                @Override // java.lang.Runnable
                public final void run() {
                    z.e.this.b(context);
                }
            });
        }
    }

    private z(final Context context) {
        Executor a11 = androidx.media3.common.util.c.a();
        this.f10559a = a11;
        this.f10560b = new CopyOnWriteArrayList();
        this.f10561c = new Object();
        this.f10562d = 0;
        a11.execute(new Runnable() { // from class: androidx.media3.common.util.y
            @Override // java.lang.Runnable
            public final void run() {
                z.this.k(context);
            }
        });
    }

    public static synchronized z e(Context context) {
        z zVar;
        synchronized (z.class) {
            try {
                if (f10558f == null) {
                    f10558f = new z(context);
                }
                zVar = f10558f;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zVar;
    }

    private static int f(NetworkInfo networkInfo) {
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
                return a1.f10432a >= 29 ? 9 : 0;
        }
    }

    private static int h(Context context) {
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
                return f(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context) {
        int h11 = h(context);
        if (a1.f10432a < 31 || h11 != 5) {
            n(h11);
        } else {
            b.a(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void k(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new e(), intentFilter);
    }

    private void m() {
        Iterator it = this.f10560b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.c()) {
                this.f10560b.remove(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i11) {
        m();
        synchronized (this.f10561c) {
            try {
                if (this.f10563e && this.f10562d == i11) {
                    return;
                }
                this.f10563e = true;
                this.f10562d = i11;
                Iterator it = this.f10560b.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int g() {
        int i11;
        synchronized (this.f10561c) {
            i11 = this.f10562d;
        }
        return i11;
    }

    public void l(c cVar, Executor executor) {
        boolean z10;
        m();
        d dVar = new d(cVar, executor);
        synchronized (this.f10561c) {
            this.f10560b.add(dVar);
            z10 = this.f10563e;
        }
        if (z10) {
            dVar.b();
        }
    }
}
