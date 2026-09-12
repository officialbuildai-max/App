package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: e, reason: collision with root package name */
    public a f6715e;

    /* renamed from: a, reason: collision with root package name */
    SolverVariable f6711a = null;

    /* renamed from: b, reason: collision with root package name */
    float f6712b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    boolean f6713c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList f6714d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    boolean f6716f = false;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i11);

        void c(SolverVariable solverVariable, float f11, boolean z10);

        void clear();

        void d();

        float e(SolverVariable solverVariable, boolean z10);

        float f(b bVar, boolean z10);

        void g(SolverVariable solverVariable, float f11);

        int getCurrentSize();

        float h(int i11);

        float i(SolverVariable solverVariable);

        void j(float f11);
    }

    public b() {
    }

    public b(c cVar) {
        this.f6715e = new androidx.constraintlayout.core.a(this, cVar);
    }

    private boolean u(SolverVariable solverVariable, d dVar) {
        return solverVariable.f6694m <= 1;
    }

    private SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.f6715e.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f11 = 0.0f;
        for (int i11 = 0; i11 < currentSize; i11++) {
            float h11 = this.f6715e.h(i11);
            if (h11 < 0.0f) {
                SolverVariable b11 = this.f6715e.b(i11);
                if ((zArr == null || !zArr[b11.f6684c]) && b11 != solverVariable && (((type = b11.f6691j) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && h11 < f11)) {
                    f11 = h11;
                    solverVariable2 = b11;
                }
            }
        }
        return solverVariable2;
    }

    public void A(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable == null || !solverVariable.f6688g) {
            return;
        }
        this.f6712b += solverVariable.f6687f * this.f6715e.i(solverVariable);
        this.f6715e.e(solverVariable, z10);
        if (z10) {
            solverVariable.e(this);
        }
        if (d.f6723t && this.f6715e.getCurrentSize() == 0) {
            this.f6716f = true;
            dVar.f6730a = true;
        }
    }

    public void B(d dVar, b bVar, boolean z10) {
        this.f6712b += bVar.f6712b * this.f6715e.f(bVar, z10);
        if (z10) {
            bVar.f6711a.e(this);
        }
        if (d.f6723t && this.f6711a != null && this.f6715e.getCurrentSize() == 0) {
            this.f6716f = true;
            dVar.f6730a = true;
        }
    }

    public void C(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable == null || !solverVariable.f6695n) {
            return;
        }
        float i11 = this.f6715e.i(solverVariable);
        this.f6712b += solverVariable.f6697p * i11;
        this.f6715e.e(solverVariable, z10);
        if (z10) {
            solverVariable.e(this);
        }
        this.f6715e.c(dVar.f6743n.f6720d[solverVariable.f6696o], i11, z10);
        if (d.f6723t && this.f6715e.getCurrentSize() == 0) {
            this.f6716f = true;
            dVar.f6730a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.f6736g.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int currentSize = this.f6715e.getCurrentSize();
            for (int i11 = 0; i11 < currentSize; i11++) {
                SolverVariable b11 = this.f6715e.b(i11);
                if (b11.f6685d != -1 || b11.f6688g || b11.f6695n) {
                    this.f6714d.add(b11);
                }
            }
            int size = this.f6714d.size();
            if (size > 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    SolverVariable solverVariable = (SolverVariable) this.f6714d.get(i12);
                    if (solverVariable.f6688g) {
                        A(dVar, solverVariable, true);
                    } else if (solverVariable.f6695n) {
                        C(dVar, solverVariable, true);
                    } else {
                        B(dVar, dVar.f6736g[solverVariable.f6685d], true);
                    }
                }
                this.f6714d.clear();
            } else {
                z10 = true;
            }
        }
        if (d.f6723t && this.f6711a != null && this.f6715e.getCurrentSize() == 0) {
            this.f6716f = true;
            dVar.f6730a = true;
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f6711a = null;
            this.f6715e.clear();
            for (int i11 = 0; i11 < bVar.f6715e.getCurrentSize(); i11++) {
                this.f6715e.c(bVar.f6715e.b(i11), bVar.f6715e.h(i11), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        int i11 = solverVariable.f6686e;
        float f11 = 1.0f;
        if (i11 != 1) {
            if (i11 == 2) {
                f11 = 1000.0f;
            } else if (i11 == 3) {
                f11 = 1000000.0f;
            } else if (i11 == 4) {
                f11 = 1.0E9f;
            } else if (i11 == 5) {
                f11 = 1.0E12f;
            }
        }
        this.f6715e.g(solverVariable, f11);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void clear() {
        this.f6715e.clear();
        this.f6711a = null;
        this.f6712b = 0.0f;
    }

    public b d(d dVar, int i11) {
        this.f6715e.g(dVar.o(i11, "ep"), 1.0f);
        this.f6715e.g(dVar.o(i11, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(SolverVariable solverVariable, int i11) {
        this.f6715e.g(solverVariable, i11);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z10;
        SolverVariable g11 = g(dVar);
        if (g11 == null) {
            z10 = true;
        } else {
            x(g11);
            z10 = false;
        }
        if (this.f6715e.getCurrentSize() == 0) {
            this.f6716f = true;
        }
        return z10;
    }

    SolverVariable g(d dVar) {
        boolean u11;
        boolean u12;
        int currentSize = this.f6715e.getCurrentSize();
        SolverVariable solverVariable = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        boolean z10 = false;
        boolean z11 = false;
        SolverVariable solverVariable2 = null;
        for (int i11 = 0; i11 < currentSize; i11++) {
            float h11 = this.f6715e.h(i11);
            SolverVariable b11 = this.f6715e.b(i11);
            if (b11.f6691j == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    u12 = u(b11, dVar);
                } else if (f11 > h11) {
                    u12 = u(b11, dVar);
                } else if (!z10 && u(b11, dVar)) {
                    f11 = h11;
                    solverVariable = b11;
                    z10 = true;
                }
                z10 = u12;
                f11 = h11;
                solverVariable = b11;
            } else if (solverVariable == null && h11 < 0.0f) {
                if (solverVariable2 == null) {
                    u11 = u(b11, dVar);
                } else if (f12 > h11) {
                    u11 = u(b11, dVar);
                } else if (!z11 && u(b11, dVar)) {
                    f12 = h11;
                    solverVariable2 = b11;
                    z11 = true;
                }
                z11 = u11;
                f12 = h11;
                solverVariable2 = b11;
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable getKey() {
        return this.f6711a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12) {
        if (solverVariable2 == solverVariable3) {
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable4, 1.0f);
            this.f6715e.g(solverVariable2, -2.0f);
            return this;
        }
        if (f11 == 0.5f) {
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable2, -1.0f);
            this.f6715e.g(solverVariable3, -1.0f);
            this.f6715e.g(solverVariable4, 1.0f);
            if (i11 > 0 || i12 > 0) {
                this.f6712b = (-i11) + i12;
            }
        } else if (f11 <= 0.0f) {
            this.f6715e.g(solverVariable, -1.0f);
            this.f6715e.g(solverVariable2, 1.0f);
            this.f6712b = i11;
        } else if (f11 >= 1.0f) {
            this.f6715e.g(solverVariable4, -1.0f);
            this.f6715e.g(solverVariable3, 1.0f);
            this.f6712b = -i12;
        } else {
            float f12 = 1.0f - f11;
            this.f6715e.g(solverVariable, f12 * 1.0f);
            this.f6715e.g(solverVariable2, f12 * (-1.0f));
            this.f6715e.g(solverVariable3, (-1.0f) * f11);
            this.f6715e.g(solverVariable4, 1.0f * f11);
            if (i11 > 0 || i12 > 0) {
                this.f6712b = ((-i11) * f12) + (i12 * f11);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(SolverVariable solverVariable, int i11) {
        this.f6711a = solverVariable;
        float f11 = i11;
        solverVariable.f6687f = f11;
        this.f6712b = f11;
        this.f6716f = true;
        return this;
    }

    @Override // androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f6711a == null && this.f6712b == 0.0f && this.f6715e.getCurrentSize() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        this.f6715e.g(solverVariable, -1.0f);
        this.f6715e.g(solverVariable2, f11);
        return this;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.f6715e.g(solverVariable, -1.0f);
        this.f6715e.g(solverVariable2, 1.0f);
        this.f6715e.g(solverVariable3, f11);
        this.f6715e.g(solverVariable4, -f11);
        return this;
    }

    public b l(float f11, float f12, float f13, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f6712b = 0.0f;
        if (f12 == 0.0f || f11 == f13) {
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable2, -1.0f);
            this.f6715e.g(solverVariable4, 1.0f);
            this.f6715e.g(solverVariable3, -1.0f);
        } else if (f11 == 0.0f) {
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable2, -1.0f);
        } else if (f13 == 0.0f) {
            this.f6715e.g(solverVariable3, 1.0f);
            this.f6715e.g(solverVariable4, -1.0f);
        } else {
            float f14 = (f11 / f12) / (f13 / f12);
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable2, -1.0f);
            this.f6715e.g(solverVariable4, f14);
            this.f6715e.g(solverVariable3, -f14);
        }
        return this;
    }

    public b m(SolverVariable solverVariable, int i11) {
        if (i11 < 0) {
            this.f6712b = i11 * (-1);
            this.f6715e.g(solverVariable, 1.0f);
        } else {
            this.f6712b = i11;
            this.f6715e.g(solverVariable, -1.0f);
        }
        return this;
    }

    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, int i11) {
        boolean z10 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z10 = true;
            }
            this.f6712b = i11;
        }
        if (z10) {
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable2, -1.0f);
        } else {
            this.f6715e.g(solverVariable, -1.0f);
            this.f6715e.g(solverVariable2, 1.0f);
        }
        return this;
    }

    public b o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z10 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z10 = true;
            }
            this.f6712b = i11;
        }
        if (z10) {
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable2, -1.0f);
            this.f6715e.g(solverVariable3, -1.0f);
        } else {
            this.f6715e.g(solverVariable, -1.0f);
            this.f6715e.g(solverVariable2, 1.0f);
            this.f6715e.g(solverVariable3, 1.0f);
        }
        return this;
    }

    public b p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z10 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z10 = true;
            }
            this.f6712b = i11;
        }
        if (z10) {
            this.f6715e.g(solverVariable, 1.0f);
            this.f6715e.g(solverVariable2, -1.0f);
            this.f6715e.g(solverVariable3, 1.0f);
        } else {
            this.f6715e.g(solverVariable, -1.0f);
            this.f6715e.g(solverVariable2, 1.0f);
            this.f6715e.g(solverVariable3, -1.0f);
        }
        return this;
    }

    public b q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.f6715e.g(solverVariable3, 0.5f);
        this.f6715e.g(solverVariable4, 0.5f);
        this.f6715e.g(solverVariable, -0.5f);
        this.f6715e.g(solverVariable2, -0.5f);
        this.f6712b = -f11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f11 = this.f6712b;
        if (f11 < 0.0f) {
            this.f6712b = f11 * (-1.0f);
            this.f6715e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        SolverVariable solverVariable = this.f6711a;
        return solverVariable != null && (solverVariable.f6691j == SolverVariable.Type.UNRESTRICTED || this.f6712b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(SolverVariable solverVariable) {
        return this.f6715e.a(solverVariable);
    }

    public String toString() {
        return z();
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f6711a;
        if (solverVariable2 != null) {
            this.f6715e.g(solverVariable2, -1.0f);
            this.f6711a.f6685d = -1;
            this.f6711a = null;
        }
        float e11 = this.f6715e.e(solverVariable, true) * (-1.0f);
        this.f6711a = solverVariable;
        if (e11 == 1.0f) {
            return;
        }
        this.f6712b /= e11;
        this.f6715e.j(e11);
    }

    public void y() {
        this.f6711a = null;
        this.f6715e.clear();
        this.f6712b = 0.0f;
        this.f6716f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String z() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.b.z():java.lang.String");
    }
}
