package androidx.compose.ui.input.pointer;

/* loaded from: classes.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    public static final int f5090b = androidx.compose.runtime.collection.b.f3755d;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5091a = new androidx.compose.runtime.collection.b(new l[16], 0);

    public boolean a(androidx.collection.x xVar, androidx.compose.ui.layout.l lVar, g gVar, boolean z10) {
        androidx.compose.runtime.collection.b bVar = this.f5091a;
        int n11 = bVar.n();
        if (n11 <= 0) {
            return false;
        }
        Object[] m11 = bVar.m();
        int i11 = 0;
        boolean z11 = false;
        do {
            z11 = ((l) m11[i11]).a(xVar, lVar, gVar, z10) || z11;
            i11++;
        } while (i11 < n11);
        return z11;
    }

    public void b(g gVar) {
        int n11 = this.f5091a.n();
        while (true) {
            n11--;
            if (-1 >= n11) {
                return;
            }
            if (((l) this.f5091a.m()[n11]).l().g()) {
                this.f5091a.v(n11);
            }
        }
    }

    public final void c() {
        this.f5091a.h();
    }

    public void d() {
        androidx.compose.runtime.collection.b bVar = this.f5091a;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i11 = 0;
            do {
                ((l) m11[i11]).d();
                i11++;
            } while (i11 < n11);
        }
    }

    public boolean e(g gVar) {
        androidx.compose.runtime.collection.b bVar = this.f5091a;
        int n11 = bVar.n();
        boolean z10 = false;
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i11 = 0;
            boolean z11 = false;
            do {
                z11 = ((l) m11[i11]).e(gVar) || z11;
                i11++;
            } while (i11 < n11);
            z10 = z11;
        }
        b(gVar);
        return z10;
    }

    public boolean f(androidx.collection.x xVar, androidx.compose.ui.layout.l lVar, g gVar, boolean z10) {
        androidx.compose.runtime.collection.b bVar = this.f5091a;
        int n11 = bVar.n();
        if (n11 <= 0) {
            return false;
        }
        Object[] m11 = bVar.m();
        int i11 = 0;
        boolean z11 = false;
        do {
            z11 = ((l) m11[i11]).f(xVar, lVar, gVar, z10) || z11;
            i11++;
        } while (i11 < n11);
        return z11;
    }

    public final androidx.compose.runtime.collection.b g() {
        return this.f5091a;
    }

    public final void h() {
        int i11 = 0;
        while (i11 < this.f5091a.n()) {
            l lVar = (l) this.f5091a.m()[i11];
            if (lVar.k().k1()) {
                i11++;
                lVar.h();
            } else {
                lVar.d();
                this.f5091a.v(i11);
            }
        }
    }

    public void i(long j11, androidx.collection.l0 l0Var) {
        androidx.compose.runtime.collection.b bVar = this.f5091a;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i11 = 0;
            do {
                ((l) m11[i11]).i(j11, l0Var);
                i11++;
            } while (i11 < n11);
        }
    }
}
