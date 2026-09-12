package nh;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.lib.util.networkinfo.NetworkType;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class l extends ConnectivityManager.NetworkCallback {

    /* renamed from: g, reason: collision with root package name */
    public static final a f70588g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f70589h = LazyKt.b(new Function0() { // from class: nh.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Handler B;
            B = l.B();
            return B;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f70590i = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: nh.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            l k11;
            k11 = l.k();
            return k11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private volatile Boolean f70592b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Boolean f70593c;

    /* renamed from: d, reason: collision with root package name */
    private NetworkType f70594d;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f70591a = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Function0 f70595e = new Function0() { // from class: nh.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit A;
            A = l.A(l.this);
            return A;
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final Function0 f70596f = new Function0() { // from class: nh.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit J;
            J = l.J(l.this);
            return J;
        }
    };

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l a() {
            return (l) l.f70590i.getValue();
        }

        public final Handler b() {
            return (Handler) l.f70589h.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(l lVar) {
        m mVar = m.f70597a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        boolean j11 = mVar.j(a11);
        Application a12 = Utils.a();
        Intrinsics.g(a12, "getApp(...)");
        lVar.f70593c = Boolean.valueOf(mVar.i(a12));
        int v11 = lVar.v();
        if (j11) {
            lVar.f70592b = Boolean.TRUE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(lVar.u());
            sb2.append(" --> onLost() --> disposeOnLost --> lostRunnable --> networkConnected = ");
            sb2.append(j11);
            sb2.append(" netState = ");
            sb2.append(v11);
            sb2.append(" --  网络重新连接了");
            for (n nVar : lVar.f70591a) {
                if (Intrinsics.c(lVar.f70592b, Boolean.TRUE)) {
                    nVar.onConnected();
                }
            }
        } else {
            lVar.G();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(lVar.u());
            sb3.append(" --> onLost() --> disposeOnLost --> lostRunnable --> networkConnected = ");
            sb3.append(j11);
            sb3.append(" netState = ");
            sb3.append(v11);
            sb3.append(" -- 网络断开了");
            for (n nVar2 : lVar.f70591a) {
                if (Intrinsics.c(lVar.f70592b, Boolean.FALSE)) {
                    nVar2.onDisconnected();
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler B() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(l lVar) {
        Context applicationContext;
        try {
            Application a11 = Utils.a();
            Object systemService = (a11 == null || (applicationContext = a11.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), lVar);
            }
        } catch (SecurityException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(l lVar) {
        Context applicationContext;
        try {
            Application a11 = Utils.a();
            Object systemService = (a11 == null || (applicationContext = a11.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), lVar);
            }
        } catch (Exception unused) {
        }
    }

    private final void G() {
        Boolean bool = Boolean.FALSE;
        this.f70592b = bool;
        this.f70593c = bool;
        this.f70594d = null;
    }

    private final void H() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(u());
        sb2.append(" --> startTimer() --> 开启定时任务");
        Handler b11 = f70588g.b();
        final Function0 function0 = this.f70596f;
        b11.postDelayed(new Runnable() { // from class: nh.j
            @Override // java.lang.Runnable
            public final void run() {
                l.I(Function0.this);
            }
        }, TmcConstants.DEBUG_REQUEST_TIME_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(l lVar) {
        m mVar = m.f70597a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        lVar.f70593c = Boolean.valueOf(mVar.i(a11));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(lVar.u());
        sb2.append(" --> timerRunnable --> isValidated = ");
        sb2.append(lVar.f70593c);
        lVar.H();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l k() {
        return new l();
    }

    private final void n(final Network network, final NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasCapability(12)) {
            Boolean bool = this.f70592b;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.c(bool, bool2)) {
                return;
            }
            this.f70592b = bool2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(u());
            sb2.append(" --> onCapabilitiesChanged --> disposeConnect --> 表示是否连接上了互联网（不关心是否可以上网");
            f70588g.b().post(new Runnable() { // from class: nh.c
                @Override // java.lang.Runnable
                public final void run() {
                    l.o(l.this, network, networkCapabilities);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(l lVar, Network network, NetworkCapabilities networkCapabilities) {
        for (n nVar : lVar.f70591a) {
            if (Intrinsics.c(lVar.f70592b, Boolean.TRUE)) {
                nVar.onConnected(network, networkCapabilities);
            }
        }
    }

    private final void p(NetworkCapabilities networkCapabilities) {
        NetworkType w11 = networkCapabilities.hasTransport(1) ? NetworkType.NETWORK_WIFI : networkCapabilities.hasTransport(0) ? w() : NetworkType.NETWORK_UNKNOWN;
        if (this.f70594d == w11) {
            return;
        }
        this.f70594d = w11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当前网络类型是 mNetworkType = ");
        sb2.append(this.f70594d);
    }

    private final void q() {
        a aVar = f70588g;
        Handler b11 = aVar.b();
        final Function0 function0 = this.f70595e;
        b11.removeCallbacks(new Runnable() { // from class: nh.h
            @Override // java.lang.Runnable
            public final void run() {
                l.s(Function0.this);
            }
        });
        Handler b12 = aVar.b();
        final Function0 function02 = this.f70595e;
        b12.postDelayed(new Runnable() { // from class: nh.i
            @Override // java.lang.Runnable
            public final void run() {
                l.r(Function0.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function0 function0) {
        function0.invoke();
    }

    private final void t(NetworkCapabilities networkCapabilities) {
        this.f70593c = Boolean.valueOf(networkCapabilities.hasCapability(16));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(u());
        sb2.append(" --> disposeValidated() --> isValidated = ");
        sb2.append(this.f70593c);
        sb2.append(" netState = ");
        sb2.append(v());
    }

    private final String u() {
        String simpleName = l.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final NetworkType w() {
        Integer num;
        int dataNetworkType;
        if (Build.VERSION.SDK_INT >= 24 && androidx.core.content.b.checkSelfPermission(Utils.a(), "android.permission.READ_PHONE_STATE") == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.a().getSystemService("phone");
            if (telephonyManager != null) {
                dataNetworkType = telephonyManager.getDataNetworkType();
                num = Integer.valueOf(dataNetworkType);
            } else {
                num = null;
            }
            return ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2) || ((num != null && num.intValue() == 4) || ((num != null && num.intValue() == 11) || (num != null && num.intValue() == 7)))) ? NetworkType.NETWORK_2G : ((num != null && num.intValue() == 5) || (num != null && num.intValue() == 6) || ((num != null && num.intValue() == 12) || ((num != null && num.intValue() == 8) || ((num != null && num.intValue() == 9) || ((num != null && num.intValue() == 10) || ((num != null && num.intValue() == 15) || (num != null && num.intValue() == 14))))))) ? NetworkType.NETWORK_3G : ((num != null && num.intValue() == 13) || (num != null && num.intValue() == 19)) ? NetworkType.NETWORK_4G : (num != null && num.intValue() == 20) ? NetworkType.NETWORK_5G : (num != null && num.intValue() == 0) ? NetworkType.NETWORK_UNKNOWN : NetworkType.NETWORK_UNKNOWN;
        }
        return m.f70597a.d();
    }

    private final boolean z() {
        if (this.f70593c != null) {
            return Intrinsics.c(this.f70593c, Boolean.TRUE);
        }
        m mVar = m.f70597a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return mVar.i(a11);
    }

    public final void C() {
        Context applicationContext;
        try {
            Application a11 = Utils.a();
            Object systemService = (a11 == null || (applicationContext = a11.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this);
            }
        } catch (SecurityException unused) {
            f70588g.b().postDelayed(new Runnable() { // from class: nh.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.D(l.this);
                }
            }, 500L);
        } catch (Exception unused2) {
            f70588g.b().postDelayed(new Runnable() { // from class: nh.b
                @Override // java.lang.Runnable
                public final void run() {
                    l.E(l.this);
                }
            }, 2000L);
        }
        H();
    }

    public final void F(n nVar) {
        if (nVar == null || this.f70591a.contains(nVar)) {
            return;
        }
        this.f70591a.add(nVar);
    }

    public final void K(n nVar) {
        if (nVar != null) {
            this.f70591a.remove(nVar);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics.h(network, "network");
        super.onAvailable(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network network, boolean z10) {
        Intrinsics.h(network, "network");
        super.onBlockedStatusChanged(network, z10);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Object m1185constructorimpl;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        try {
            Result.Companion companion = Result.INSTANCE;
            n(network, networkCapabilities);
            t(networkCapabilities);
            p(networkCapabilities);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        Log.e("net_log", u() + " --> it = " + m1188exceptionOrNullimpl);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Intrinsics.h(network, "network");
        Intrinsics.h(linkProperties, "linkProperties");
        super.onLinkPropertiesChanged(network, linkProperties);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLosing(Network network, int i11) {
        Intrinsics.h(network, "network");
        super.onLosing(network, i11);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.h(network, "network");
        super.onLost(network);
        q();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
    }

    public final int v() {
        if (y() && z()) {
            return 2;
        }
        if (y()) {
            return 1;
        }
        return !y() ? 0 : 3;
    }

    public final NetworkType x() {
        NetworkType networkType = this.f70594d;
        if (networkType != null) {
            return networkType;
        }
        m mVar = m.f70597a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        if (mVar.k(a11)) {
            NetworkType networkType2 = NetworkType.NETWORK_WIFI;
            this.f70594d = networkType2;
            return networkType2;
        }
        NetworkType w11 = w();
        this.f70594d = w11;
        return w11;
    }

    public final boolean y() {
        if (this.f70592b == null) {
            m mVar = m.f70597a;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            return mVar.j(a11);
        }
        if (!Intrinsics.c(this.f70592b, Boolean.FALSE)) {
            return Intrinsics.c(this.f70592b, Boolean.TRUE);
        }
        m mVar2 = m.f70597a;
        Application a12 = Utils.a();
        Intrinsics.g(a12, "getApp(...)");
        return mVar2.j(a12);
    }
}
