package com.transsion.transfer.wifi.connect.adapter;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiNetworkSpecifier;
import android.text.TextUtils;
import androidx.view.f;
import androidx.view.u;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.bridge.w;
import com.cloud.tmc.integration.bridge.y;
import com.transsion.transfer.wifi.util.g;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class WifiNetworkSpecifierAdapter extends BaseWifiConnectAdapter {

    /* renamed from: g, reason: collision with root package name */
    private boolean f55998g;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f55996e = LazyKt.b(new Function0() { // from class: com.transsion.transfer.wifi.connect.adapter.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ConnectivityManager r11;
            r11 = WifiNetworkSpecifierAdapter.r();
            return r11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f55997f = new a();

    /* renamed from: h, reason: collision with root package name */
    private final b f55999h = new b();

    /* loaded from: classes6.dex */
    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Object m1185constructorimpl;
            Unit unit;
            Intrinsics.h(network, "network");
            super.onAvailable(network);
            g.b(g.f56093a, WifiNetworkSpecifierAdapter.this.e() + " --> connect() --> onAvailable() --> WifiNetworkSpecifier connect success", false, 2, null);
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = WifiNetworkSpecifierAdapter.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                wifiNetworkSpecifierAdapter.q().bindProcessToNetwork(network);
                com.transsion.transfer.wifi.connect.b h11 = wifiNetworkSpecifierAdapter.h();
                if (h11 != null) {
                    h11.c(null);
                    unit = Unit.f67184a;
                } else {
                    unit = null;
                }
                m1185constructorimpl = Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter2 = WifiNetworkSpecifierAdapter.this;
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl == null) {
                return;
            }
            g.d(g.f56093a, wifiNetworkSpecifierAdapter2.e() + " --> connect() --> onAvailable() --> it = " + m1188exceptionOrNullimpl, false, 2, null);
            com.transsion.transfer.wifi.connect.b h12 = wifiNetworkSpecifierAdapter2.h();
            if (h12 != null) {
                h12.b(Sdk$SDKMetric.SDKMetricType.AD_WILL_CLOSE_VALUE);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Object m1185constructorimpl;
            Intrinsics.h(network, "network");
            super.onLost(network);
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = WifiNetworkSpecifierAdapter.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                wifiNetworkSpecifierAdapter.q().bindProcessToNetwork(null);
                g.b(g.f56093a, wifiNetworkSpecifierAdapter.e() + " --> connect() --> onLost() --> bindProcessToNetwork(null) --> success", false, 2, null);
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter2 = WifiNetworkSpecifierAdapter.this;
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                g.b(g.f56093a, wifiNetworkSpecifierAdapter2.e() + " --> connect() --> onLost() --> bindProcessToNetwork() --> 发生异常 --> it = " + m1188exceptionOrNullimpl, false, 2, null);
            }
            com.transsion.transfer.wifi.connect.b h11 = WifiNetworkSpecifierAdapter.this.h();
            if (h11 != null) {
                h11.a(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            g.b(g.f56093a, WifiNetworkSpecifierAdapter.this.e() + " --> connect() --> onUnavailable() --> 如果在指定的超时时间内没有找到网络，则调用,用户主动取消也调用这个。", false, 2, null);
            com.transsion.transfer.wifi.connect.b h11 = WifiNetworkSpecifierAdapter.this.h();
            if (h11 != null) {
                h11.b(Sdk$SDKMetric.SDKMetricType.APP_TERM_DURING_AD_BEFORE_IMPRESSION_VALUE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements f {
        b() {
        }

        @Override // androidx.view.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.view.e.a(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onDestroy(u uVar) {
            androidx.view.e.b(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onPause(u uVar) {
            androidx.view.e.c(this, uVar);
        }

        @Override // androidx.view.f
        public void onResume(u owner) {
            com.transsion.transfer.wifi.connect.b h11;
            Intrinsics.h(owner, "owner");
            androidx.view.e.d(this, owner);
            if (!WifiNetworkSpecifierAdapter.this.f55998g || (h11 = WifiNetworkSpecifierAdapter.this.h()) == null) {
                return;
            }
            h11.b(2012);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.view.e.e(this, uVar);
        }

        @Override // androidx.view.f
        public void onStop(u owner) {
            Intrinsics.h(owner, "owner");
            androidx.view.e.f(this, owner);
            WifiNetworkSpecifierAdapter.this.f55998g = true;
            g.h(g.f56093a, WifiNetworkSpecifierAdapter.this.e() + " --> observer --> onStop() -- isStop = " + WifiNetworkSpecifierAdapter.this.f55998g, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectivityManager q() {
        return (ConnectivityManager) this.f55996e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectivityManager r() {
        Object systemService = Utils.a().getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void c() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            n0 g11 = g();
            if (g11 != null) {
                k.d(g11, null, null, new WifiNetworkSpecifierAdapter$doClose$1$1(this, null), 3, null);
            }
            q().unregisterNetworkCallback(this.f55997f);
            q().bindProcessToNetwork(null);
            g.h(g.f56093a, e() + " --> close() --> end", false, 2, null);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f56093a, e() + " --> close() --> 发生异常 --> it = " + m1188exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void d() {
        String str;
        WifiNetworkSpecifier.Builder ssid;
        WifiNetworkSpecifier build;
        NetworkRequest.Builder networkSpecifier;
        String o11;
        g.b(g.f56093a, e() + " --> connect() --> start connect with WifiNetworkSpecifier --> start ....", false, 2, null);
        n0 g11 = g();
        if (g11 != null) {
            k.d(g11, null, null, new WifiNetworkSpecifierAdapter$doConnect$1(this, null), 3, null);
        }
        WifiNetworkSpecifier.Builder a11 = y.a();
        lv.a i11 = i();
        String str2 = "";
        if (i11 == null || (str = i11.p()) == null) {
            str = "";
        }
        ssid = a11.setSsid(str);
        Intrinsics.g(ssid, "setSsid(...)");
        lv.a i12 = i();
        if (!TextUtils.isEmpty(i12 != null ? i12.o() : null)) {
            lv.a i13 = i();
            if (i13 != null && (o11 = i13.o()) != null) {
                str2 = o11;
            }
            ssid.setWpa2Passphrase(str2);
        }
        NetworkRequest.Builder removeCapability = new NetworkRequest.Builder().addTransportType(1).removeCapability(12);
        build = ssid.build();
        networkSpecifier = removeCapability.setNetworkSpecifier(w.a(build));
        q().requestNetwork(networkSpecifier.build(), this.f55997f);
    }
}
