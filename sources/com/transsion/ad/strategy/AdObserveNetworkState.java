package com.transsion.ad.strategy;

import android.net.Network;
import android.net.NetworkCapabilities;
import com.transsion.ad.ps.attribution.AttributionConsumeManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import nh.n;

/* loaded from: classes5.dex */
public final class AdObserveNetworkState implements nh.n {

    /* renamed from: a, reason: collision with root package name */
    public static final AdObserveNetworkState f42260a = new AdObserveNetworkState();

    /* renamed from: b, reason: collision with root package name */
    private static String f42261b = "";

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f42262c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f42263d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static boolean f42264e;

    private AdObserveNetworkState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        String simpleName = AdObserveNetworkState.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void f(String adConfigUrl) {
        Intrinsics.h(adConfigUrl, "adConfigUrl");
        f42261b = adConfigUrl;
        if (!f42263d.compareAndSet(false, true)) {
            oi.a.c(oi.a.f71145a, e() + " --> registerNetworkStatusChangedListener() --> 网络变化监听已注册，跳过", 0, false, 6, null);
            return;
        }
        oi.a.c(oi.a.f71145a, e() + " --> registerNetworkStatusChangedListener() --> 网络变化监听 success", 0, false, 6, null);
        nh.m.f70597a.l(this);
    }

    @Override // nh.n
    public void onConnected() {
        n.a.a(this);
    }

    @Override // nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new AdObserveNetworkState$onConnected$1(null), 3, null);
        AttributionConsumeManager.f42231c.n();
        if (!f42262c.compareAndSet(false, true)) {
            oi.a.g(oi.a.f71145a, null, e() + " --> onConnected() --> isLoading == true", 5, false, 9, null);
            return;
        }
        if (!f42264e) {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new AdObserveNetworkState$onConnected$2(null), 3, null);
            return;
        }
        oi.a.g(oi.a.f71145a, null, e() + " --> onConnected() --> result == true --> 生命周期内已经请求成功", 5, false, 9, null);
    }

    @Override // nh.n
    public void onDisconnected() {
    }
}
