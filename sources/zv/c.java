package zv;

import android.util.Log;
import bw.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.j0;

/* loaded from: classes7.dex */
public final class c implements retrofit2.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f79593a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f79594b;

    public c(d dVar, com.transsion.upgradesdk.manager.h hVar) {
        this.f79593a = dVar;
        this.f79594b = hVar;
    }

    @Override // retrofit2.f
    public final void a(retrofit2.d call, Throwable t11) {
        Intrinsics.h(call, "call");
        Intrinsics.h(t11, "t");
        String msg = "升级信息 - request failure: " + t11;
        Intrinsics.h("UpgradeSdkManager", "tag");
        Intrinsics.h(msg, "msg");
        long currentTimeMillis = System.currentTimeMillis();
        if (!bw.g.f17021a && currentTimeMillis - bw.g.f17022b >= 5000) {
            bw.g.f17022b = currentTimeMillis;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                bw.g.f17021a = true;
            }
            boolean z10 = bw.g.f17021a;
        }
        boolean z11 = yv.f.f79190o.a().f79195d;
        this.f79593a.f79598c = 6;
        l.c(2, 3, t11.getMessage(), "2", null, null, null, 112);
        this.f79594b.invoke(null);
    }

    @Override // retrofit2.f
    public final void b(retrofit2.d call, j0 response) {
        Intrinsics.h(call, "call");
        Intrinsics.h(response, "response");
        if (response.e()) {
            this.f79593a.f79598c = 5;
            this.f79594b.invoke(response.a());
            return;
        }
        this.f79593a.f79598c = 6;
        l.a(2, 3, response.b() + '-' + response.f(), "2", 16);
        this.f79594b.invoke(null);
    }
}
