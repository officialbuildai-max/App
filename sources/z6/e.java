package z6;

import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.q3;
import com.cloud.hisavana.sdk.x3;
import kotlin.jvm.internal.Intrinsics;
import z6.a;

/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: m, reason: collision with root package name */
    private final String f79418m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String placementId) {
        super(placementId);
        Intrinsics.h(placementId, "placementId");
        this.f79418m = placementId;
    }

    public void s() {
        if (b()) {
            q3 g11 = new q3.b().i(5).e(this.f79403b).r(this.f79404c).l(this.f79405d).j(this.f79406e).c(this.f79411j).o(this.f79408g).v(this.f79409h).b(this.f79410i).g();
            Intrinsics.e(g11);
            x3 x3Var = new x3(g11);
            x3Var.g(new a.C1004a(this));
            x3Var.E();
        }
    }

    public final void t(com.cloud.hisavana.sdk.api.listener.d dVar) {
        p(dVar);
    }

    public final void u() {
        G g11 = this.f79402a;
        if (g11 instanceof x3) {
            try {
                this.f79413l.add(g11);
            } catch (Throwable unused) {
            }
            G g12 = this.f79402a;
            Intrinsics.f(g12, "null cannot be cast to non-null type com.cloud.hisavana.sdk.internal.rewarded.TranRewarded");
            ((x3) g12).L();
        }
    }
}
