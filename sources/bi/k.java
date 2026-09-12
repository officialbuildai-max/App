package bi;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.transsion.ga.AthenaAnalytics;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f16616a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f16617b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f16618c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f16619d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f16620e;

    /* renamed from: f, reason: collision with root package name */
    private static long f16621f;

    /* loaded from: classes5.dex */
    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.h(network, "network");
            super.onAvailable(network);
            o.f16629a.h("NetworkMonitor", "onAvailable : " + network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z10) {
            Intrinsics.h(network, "network");
            super.onBlockedStatusChanged(network, z10);
            o.f16629a.h("NetworkMonitor", "onBlockedStatusChanged");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            boolean hasCapability = networkCapabilities.hasCapability(16);
            k kVar = k.f16616a;
            kVar.k(networkCapabilities.hasCapability(12));
            kVar.i(kVar.g() && !hasCapability);
            kVar.j(true);
            o.f16629a.h("NetworkMonitor", "isNetworkConnected : " + kVar.g() + ",  isFakeNetwork : " + kVar.e());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i11) {
            Intrinsics.h(network, "network");
            super.onLosing(network, i11);
            o.f16629a.h("NetworkMonitor", "onLosing");
            k.f16616a.k(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.h(network, "network");
            super.onLost(network);
            o.f16629a.h("NetworkMonitor", "onLost");
            k.f16616a.k(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            o.f16629a.h("NetworkMonitor", "onUnavailable");
        }
    }

    private k() {
    }

    public static final void c(Application application, boolean z10) {
        Intrinsics.h(application, "application");
        d(application, new String[0], z10);
    }

    public static final void d(Application application, String[] hosts, boolean z10) {
        Intrinsics.h(application, "application");
        Intrinsics.h(hosts, "hosts");
        f16617b = z10;
        AthenaAnalytics.Q(application, "NetworkMonitor", 1814, z10, false);
        d.f16556a.e(hosts);
        k kVar = f16616a;
        kVar.h(application);
        f16621f = SystemClock.uptimeMillis();
        kVar.l();
    }

    private final void h(Context context) {
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new a());
    }

    private final void l() {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: bi.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.m();
                }
            }, 5000L);
        } catch (Exception e11) {
            o.f16629a.j("NetworkMonitor", Log.getStackTraceString(e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        String str = f16618c ? "0" : "1";
        if (f16619d) {
            str = "2";
        }
        new yi.a("monitor_init", 1814).c(androidx.core.os.d.b(TuplesKt.a("net_status", str)), null).b();
    }

    public final long b() {
        return f16621f;
    }

    public final boolean e() {
        return f16619d;
    }

    public final boolean f() {
        return f16620e;
    }

    public final boolean g() {
        return f16618c;
    }

    public final void i(boolean z10) {
        f16619d = z10;
    }

    public final void j(boolean z10) {
        f16620e = z10;
    }

    public final void k(boolean z10) {
        f16618c = z10;
    }
}
