package z6;

import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.q3;
import com.cloud.hisavana.sdk.s3;
import z6.a;

/* loaded from: classes3.dex */
public final class b extends a {
    public b(String str) {
        super(str);
    }

    public void s() {
        if (b()) {
            s3 s3Var = new s3(new q3.b().i(3).e(this.f79403b).r(this.f79404c).l(this.f79405d).j(this.f79406e).c(this.f79411j).o(this.f79408g).v(this.f79409h).b(this.f79410i).g());
            s3Var.g(new a.C1004a(this));
            s3Var.E();
        }
    }

    public void t() {
        G g11 = this.f79402a;
        if (g11 instanceof s3) {
            try {
                this.f79413l.add(g11);
            } catch (Throwable unused) {
            }
            ((s3) this.f79402a).M();
        }
    }
}
