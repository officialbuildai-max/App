package zv;

import android.util.Log;
import bw.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.j0;

/* loaded from: classes7.dex */
public final class b implements retrofit2.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f79591a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f79592b;

    public b(d dVar, com.transsion.upgradesdk.manager.g gVar) {
        this.f79591a = dVar;
        this.f79592b = gVar;
    }

    @Override // retrofit2.f
    public final void a(retrofit2.d call, Throwable t11) {
        Intrinsics.h(call, "call");
        Intrinsics.h(t11, "t");
        this.f79591a.f79598c = 3;
        new StringBuilder("CDN - 请求CDN配置失败:").append(t11.getMessage());
        l.c(2, 3, t11.getMessage(), "1", null, null, null, 112);
        this.f79592b.invoke(null);
    }

    @Override // retrofit2.f
    public final void b(retrofit2.d call, j0 response) {
        Intrinsics.h(call, "call");
        Intrinsics.h(response, "response");
        String msg = "CDN - requestSuccess: " + response;
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
        if (response.e()) {
            this.f79591a.f79598c = 2;
            this.f79592b.invoke(response.a());
            return;
        }
        this.f79591a.f79598c = 3;
        l.a(2, 3, response.b() + '-' + response.f(), "1", 16);
        this.f79592b.invoke(null);
    }
}
