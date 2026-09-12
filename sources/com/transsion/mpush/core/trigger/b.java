package com.transsion.mpush.core.trigger;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f47657a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f47658b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f47659c;

    /* renamed from: d, reason: collision with root package name */
    private final a f47660d;

    /* loaded from: classes6.dex */
    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.h(network, "network");
            super.onAvailable(network);
            b.this.f47658b.invoke();
        }
    }

    public b(Context context, Function0 onNetworkAvailable) {
        Intrinsics.h(context, "context");
        Intrinsics.h(onNetworkAvailable, "onNetworkAvailable");
        this.f47657a = context;
        this.f47658b = onNetworkAvailable;
        this.f47659c = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.trigger.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ConnectivityManager c11;
                c11 = b.c(b.this);
                return c11;
            }
        });
        this.f47660d = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectivityManager c(b bVar) {
        Object systemService = bVar.f47657a.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }

    private final ConnectivityManager d() {
        return (ConnectivityManager) this.f47659c.getValue();
    }

    public final void e() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                d().registerDefaultNetworkCallback(this.f47660d);
            } else {
                d().registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), this.f47660d);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
