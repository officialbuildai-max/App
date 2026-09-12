package com.transsion.lib_web.download_render.init;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import nh.l;

/* loaded from: classes5.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f46236a;

    public d(Context context) {
        Intrinsics.h(context, "context");
        this.f46236a = context;
    }

    @Override // com.transsion.lib_web.download_render.init.c
    public void invoke() {
        Object systemService = this.f46236a.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(l.f70588g.a());
        } else {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), l.f70588g.a());
        }
        com.transsion.lib_web.download_render.utils.d.f46242a.d();
        om.e.f71160a.d();
    }
}
