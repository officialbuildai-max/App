package z6;

import android.content.Context;
import android.view.View;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.api.listener.g;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.i1;
import com.cloud.hisavana.sdk.q3;
import z6.a;

/* loaded from: classes3.dex */
public class f extends z6.a {

    /* renamed from: m, reason: collision with root package name */
    private View f79419m;

    /* renamed from: n, reason: collision with root package name */
    private g f79420n;

    /* renamed from: o, reason: collision with root package name */
    private Context f79421o;

    /* renamed from: p, reason: collision with root package name */
    private String f79422p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f79423q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f79424r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f79425s;

    /* renamed from: t, reason: collision with root package name */
    private Float f79426t;

    /* loaded from: classes3.dex */
    private static class a extends a.C1004a {
        a(f fVar) {
            super(fVar);
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public g f() {
            z6.a aVar = this.f79414a;
            if (aVar instanceof f) {
                return ((f) aVar).f79420n;
            }
            return null;
        }
    }

    public f(Context context, String str) {
        super(str);
        this.f79423q = false;
        this.f79424r = false;
        this.f79425s = false;
        this.f79421o = context;
    }

    @Override // z6.a
    public void c() {
        super.c();
        this.f79419m = null;
    }

    public void t() {
        if (this.f79423q) {
            a7.c.s(this.f79421o, this.f79422p, this.f79424r);
        }
        if (b()) {
            i1 i1Var = new i1(new q3.b().i(4).e(this.f79403b).r(this.f79404c).l(this.f79405d).j(this.f79406e).c(this.f79411j).o(this.f79408g).v(this.f79409h).b(this.f79410i).g());
            i1Var.g(new a(this));
            i1Var.E();
        }
    }

    public f u(String str, boolean z10) {
        this.f79423q = true;
        this.f79422p = str;
        this.f79424r = z10;
        return this;
    }

    public void v(View view) {
        this.f79419m = view;
    }

    public void w(Float f11) {
        this.f79426t = f11;
    }

    public void x(g gVar) {
        this.f79420n = gVar;
    }

    public void y() {
        G g11 = this.f79402a;
        if (g11 == null || !(g11 instanceof i1)) {
            return;
        }
        try {
            ((i1) g11).p0(this.f79425s);
            ((i1) this.f79402a).g0(this.f79426t);
            ((i1) this.f79402a).k0(this.f79419m);
            this.f79413l.add(this.f79402a);
        } catch (Throwable th2) {
            e4.b().w("ssp", "TSplash show error: " + th2.getMessage());
        }
        ((i1) this.f79402a).o0(this.f79421o);
    }
}
