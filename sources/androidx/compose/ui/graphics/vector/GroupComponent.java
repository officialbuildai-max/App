package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.x0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class GroupComponent extends i {

    /* renamed from: b, reason: collision with root package name */
    private float[] f4754b;

    /* renamed from: c, reason: collision with root package name */
    private final List f4755c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4756d;

    /* renamed from: e, reason: collision with root package name */
    private long f4757e;

    /* renamed from: f, reason: collision with root package name */
    private List f4758f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4759g;

    /* renamed from: h, reason: collision with root package name */
    private Path f4760h;

    /* renamed from: i, reason: collision with root package name */
    private Function1 f4761i;

    /* renamed from: j, reason: collision with root package name */
    private final Function1 f4762j;

    /* renamed from: k, reason: collision with root package name */
    private String f4763k;

    /* renamed from: l, reason: collision with root package name */
    private float f4764l;

    /* renamed from: m, reason: collision with root package name */
    private float f4765m;

    /* renamed from: n, reason: collision with root package name */
    private float f4766n;

    /* renamed from: o, reason: collision with root package name */
    private float f4767o;

    /* renamed from: p, reason: collision with root package name */
    private float f4768p;

    /* renamed from: q, reason: collision with root package name */
    private float f4769q;

    /* renamed from: r, reason: collision with root package name */
    private float f4770r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f4771s;

    public GroupComponent() {
        super(null);
        this.f4755c = new ArrayList();
        this.f4756d = true;
        this.f4757e = u1.f4733b.e();
        this.f4758f = k.d();
        this.f4759g = true;
        this.f4762j = new Function1<i, Unit>() { // from class: androidx.compose.ui.graphics.vector.GroupComponent$wrappedListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((i) obj);
                return Unit.f67184a;
            }

            public final void invoke(i iVar) {
                GroupComponent.this.n(iVar);
                Function1 b11 = GroupComponent.this.b();
                if (b11 != null) {
                    b11.invoke(iVar);
                }
            }
        };
        this.f4763k = "";
        this.f4767o = 1.0f;
        this.f4768p = 1.0f;
        this.f4771s = true;
    }

    private final boolean h() {
        return !this.f4758f.isEmpty();
    }

    private final void k() {
        this.f4756d = false;
        this.f4757e = u1.f4733b.e();
    }

    private final void l(j1 j1Var) {
        if (this.f4756d && j1Var != null) {
            if (j1Var instanceof b5) {
                m(((b5) j1Var).b());
            } else {
                k();
            }
        }
    }

    private final void m(long j11) {
        if (this.f4756d && j11 != 16) {
            long j12 = this.f4757e;
            if (j12 == 16) {
                this.f4757e = j11;
            } else {
                if (k.e(j12, j11)) {
                    return;
                }
                k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(i iVar) {
        if (iVar instanceof PathComponent) {
            PathComponent pathComponent = (PathComponent) iVar;
            l(pathComponent.e());
            l(pathComponent.g());
        } else if (iVar instanceof GroupComponent) {
            GroupComponent groupComponent = (GroupComponent) iVar;
            if (groupComponent.f4756d && this.f4756d) {
                m(groupComponent.f4757e);
            } else {
                k();
            }
        }
    }

    private final void x() {
        if (h()) {
            Path path = this.f4760h;
            if (path == null) {
                path = x0.a();
                this.f4760h = path;
            }
            h.c(this.f4758f, path);
        }
    }

    private final void y() {
        float[] fArr = this.f4754b;
        if (fArr == null) {
            fArr = i4.c(null, 1, null);
            this.f4754b = fArr;
        } else {
            i4.h(fArr);
        }
        i4.q(fArr, this.f4765m + this.f4769q, this.f4766n + this.f4770r, 0.0f, 4, null);
        i4.k(fArr, this.f4764l);
        i4.l(fArr, this.f4767o, this.f4768p, 1.0f);
        i4.q(fArr, -this.f4765m, -this.f4766n, 0.0f, 4, null);
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void a(z.g gVar) {
        if (this.f4771s) {
            y();
            this.f4771s = false;
        }
        if (this.f4759g) {
            x();
            this.f4759g = false;
        }
        z.d H0 = gVar.H0();
        long i11 = H0.i();
        H0.e().n();
        try {
            z.j c11 = H0.c();
            float[] fArr = this.f4754b;
            if (fArr != null) {
                c11.d(i4.a(fArr).r());
            }
            Path path = this.f4760h;
            if (h() && path != null) {
                z.i.a(c11, path, 0, 2, null);
            }
            List list = this.f4755c;
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                ((i) list.get(i12)).a(gVar);
            }
            H0.e().j();
            H0.f(i11);
        } catch (Throwable th2) {
            H0.e().j();
            H0.f(i11);
            throw th2;
        }
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public Function1 b() {
        return this.f4761i;
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void d(Function1 function1) {
        this.f4761i = function1;
    }

    public final int f() {
        return this.f4755c.size();
    }

    public final long g() {
        return this.f4757e;
    }

    public final void i(int i11, i iVar) {
        if (i11 < f()) {
            this.f4755c.set(i11, iVar);
        } else {
            this.f4755c.add(iVar);
        }
        n(iVar);
        iVar.d(this.f4762j);
        c();
    }

    public final boolean j() {
        return this.f4756d;
    }

    public final void o(List list) {
        this.f4758f = list;
        this.f4759g = true;
        c();
    }

    public final void p(String str) {
        this.f4763k = str;
        c();
    }

    public final void q(float f11) {
        this.f4765m = f11;
        this.f4771s = true;
        c();
    }

    public final void r(float f11) {
        this.f4766n = f11;
        this.f4771s = true;
        c();
    }

    public final void s(float f11) {
        this.f4764l = f11;
        this.f4771s = true;
        c();
    }

    public final void t(float f11) {
        this.f4767o = f11;
        this.f4771s = true;
        c();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VGroup: ");
        sb2.append(this.f4763k);
        List list = this.f4755c;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = (i) list.get(i11);
            sb2.append("\t");
            sb2.append(iVar.toString());
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public final void u(float f11) {
        this.f4768p = f11;
        this.f4771s = true;
        c();
    }

    public final void v(float f11) {
        this.f4769q = f11;
        this.f4771s = true;
        c();
    }

    public final void w(float f11) {
        this.f4770r = f11;
        this.f4771s = true;
        c();
    }
}
