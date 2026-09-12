package vu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import nu.h;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f77568a;

    /* renamed from: b, reason: collision with root package name */
    private static ConnectivityManager.NetworkCallback f77569b;

    /* renamed from: vu.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0980a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f77570a;

        C0980a(Context context) {
            this.f77570a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            synchronized (a.class) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a.f77568a < 300000) {
                        ShareTinkerLog.d("Tinker.NetworkRetryMgr", "network restored, but within retry interval, skip (last=%d, now=%d)", Long.valueOf(a.f77568a), Long.valueOf(currentTimeMillis));
                        return;
                    }
                    long unused = a.f77568a = currentTimeMillis;
                    ShareTinkerLog.i("Tinker.NetworkRetryMgr", "network restored, retry checkPendingPatch", new Object[0]);
                    h.l(this.f77570a);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void c(Context context) {
        if (context == null) {
            ShareTinkerLog.w("Tinker.NetworkRetryMgr", "register: context is null, skip", new Object[0]);
            return;
        }
        synchronized (a.class) {
            try {
                if (f77569b != null) {
                    ShareTinkerLog.d("Tinker.NetworkRetryMgr", "NetworkRetryManager already registered, skip", new Object[0]);
                    return;
                }
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    ShareTinkerLog.w("Tinker.NetworkRetryMgr", "register: ConnectivityManager is null, skip", new Object[0]);
                    return;
                }
                f77569b = new C0980a(context);
                try {
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), f77569b);
                    ShareTinkerLog.i("Tinker.NetworkRetryMgr", "NetworkRetryManager registered successfully", new Object[0]);
                } catch (RuntimeException e11) {
                    f77569b = null;
                    ShareTinkerLog.e("Tinker.NetworkRetryMgr", "register network callback failed, degrade gracefully: " + e11, e11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void d() {
        synchronized (a.class) {
            f77568a = 0L;
        }
    }
}
