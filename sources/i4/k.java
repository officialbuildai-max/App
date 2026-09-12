package i4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.impl.utils.o;
import androidx.work.t;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class k extends g {

    /* renamed from: f, reason: collision with root package name */
    private final ConnectivityManager f65080f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f65081g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f65082h;

    /* renamed from: i, reason: collision with root package name */
    private final a f65083i;

    /* loaded from: classes2.dex */
    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z10) {
            String str;
            Intrinsics.h(network, "network");
            if (Intrinsics.c(network, k.this.f65080f.getActiveNetwork())) {
                t e11 = t.e();
                str = i.f65078a;
                e11.a(str, "Network blocked status changed: " + z10);
                androidx.work.impl.constraints.g gVar = (androidx.work.impl.constraints.g) k.this.e();
                Object obj = k.this.f65081g;
                k kVar = k.this;
                synchronized (obj) {
                    if (kVar.f65082h == z10) {
                        return;
                    }
                    kVar.f65082h = z10;
                    Unit unit = Unit.f67184a;
                    k.this.h(androidx.work.impl.constraints.g.b(gVar, false, false, false, false, z10, 15, null));
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
            String str;
            Intrinsics.h(network, "network");
            Intrinsics.h(capabilities, "capabilities");
            t e11 = t.e();
            str = i.f65078a;
            e11.a(str, "Network capabilities changed: " + capabilities);
            k kVar = k.this;
            kVar.h(i.c(kVar.f65080f, k.this.f65082h));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            String str;
            Intrinsics.h(network, "network");
            t e11 = t.e();
            str = i.f65078a;
            e11.a(str, "Network connection lost");
            k.this.h(new androidx.work.impl.constraints.g(false, false, false, false, false));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, j4.c taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.h(context, "context");
        Intrinsics.h(taskExecutor, "taskExecutor");
        Object systemService = d().getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f65080f = (ConnectivityManager) systemService;
        this.f65081g = new Object();
        this.f65083i = new a();
    }

    @Override // i4.g
    public void i() {
        String str;
        String str2;
        String str3;
        try {
            t e11 = t.e();
            str3 = i.f65078a;
            e11.a(str3, "Registering network callback");
            o.a(this.f65080f, this.f65083i);
        } catch (IllegalArgumentException e12) {
            t e13 = t.e();
            str2 = i.f65078a;
            e13.d(str2, "Received exception while registering network callback", e12);
        } catch (SecurityException e14) {
            t e15 = t.e();
            str = i.f65078a;
            e15.d(str, "Received exception while registering network callback", e14);
        }
    }

    @Override // i4.g
    public void j() {
        String str;
        String str2;
        String str3;
        try {
            t e11 = t.e();
            str3 = i.f65078a;
            e11.a(str3, "Unregistering network callback");
            this.f65080f.unregisterNetworkCallback(this.f65083i);
        } catch (IllegalArgumentException e12) {
            t e13 = t.e();
            str2 = i.f65078a;
            e13.d(str2, "Received exception while unregistering network callback", e12);
        } catch (SecurityException e14) {
            t e15 = t.e();
            str = i.f65078a;
            e15.d(str, "Received exception while unregistering network callback", e14);
        }
    }

    @Override // i4.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public androidx.work.impl.constraints.g f() {
        return i.c(this.f65080f, this.f65082h);
    }
}
