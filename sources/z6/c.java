package z6;

import com.cloud.hisavana.sdk.q3;
import com.cloud.hisavana.sdk.x3;
import kotlin.jvm.internal.Intrinsics;
import z6.a;

/* loaded from: classes3.dex */
public final class c extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String placementId) {
        super(placementId);
        Intrinsics.h(placementId, "placementId");
    }

    @Override // z6.e
    public void s() {
        if (b()) {
            q3 g11 = new q3.b().i(7).e(this.f79403b).r(this.f79404c).l(this.f79405d).j(this.f79406e).c(this.f79411j).o(this.f79408g).v(this.f79409h).b(this.f79410i).g();
            Intrinsics.e(g11);
            x3 x3Var = new x3(g11);
            x3Var.g(new a.C1004a(this));
            x3Var.E();
        }
    }
}
