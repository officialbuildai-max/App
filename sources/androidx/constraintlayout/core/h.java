package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class h implements b.a {

    /* renamed from: n, reason: collision with root package name */
    private static float f6776n = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    private final int f6777a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f6778b = 16;

    /* renamed from: c, reason: collision with root package name */
    private int f6779c = 16;

    /* renamed from: d, reason: collision with root package name */
    int[] f6780d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    int[] f6781e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    int[] f6782f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    float[] f6783g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    int[] f6784h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    int[] f6785i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    int f6786j = 0;

    /* renamed from: k, reason: collision with root package name */
    int f6787k = -1;

    /* renamed from: l, reason: collision with root package name */
    private final b f6788l;

    /* renamed from: m, reason: collision with root package name */
    protected final c f6789m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, c cVar) {
        this.f6788l = bVar;
        this.f6789m = cVar;
        clear();
    }

    private void k(SolverVariable solverVariable, int i11) {
        int[] iArr;
        int i12 = solverVariable.f6684c % this.f6779c;
        int[] iArr2 = this.f6780d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            iArr2[i12] = i11;
        } else {
            while (true) {
                iArr = this.f6781e;
                int i14 = iArr[i13];
                if (i14 == -1) {
                    break;
                } else {
                    i13 = i14;
                }
            }
            iArr[i13] = i11;
        }
        this.f6781e[i11] = -1;
    }

    private void l(int i11, SolverVariable solverVariable, float f11) {
        this.f6782f[i11] = solverVariable.f6684c;
        this.f6783g[i11] = f11;
        this.f6784h[i11] = -1;
        this.f6785i[i11] = -1;
        solverVariable.a(this.f6788l);
        solverVariable.f6694m++;
        this.f6786j++;
    }

    private int m() {
        for (int i11 = 0; i11 < this.f6778b; i11++) {
            if (this.f6782f[i11] == -1) {
                return i11;
            }
        }
        return -1;
    }

    private void n() {
        int i11 = this.f6778b * 2;
        this.f6782f = Arrays.copyOf(this.f6782f, i11);
        this.f6783g = Arrays.copyOf(this.f6783g, i11);
        this.f6784h = Arrays.copyOf(this.f6784h, i11);
        this.f6785i = Arrays.copyOf(this.f6785i, i11);
        this.f6781e = Arrays.copyOf(this.f6781e, i11);
        for (int i12 = this.f6778b; i12 < i11; i12++) {
            this.f6782f[i12] = -1;
            this.f6781e[i12] = -1;
        }
        this.f6778b = i11;
    }

    private void p(int i11, SolverVariable solverVariable, float f11) {
        int m11 = m();
        l(m11, solverVariable, f11);
        if (i11 != -1) {
            this.f6784h[m11] = i11;
            int[] iArr = this.f6785i;
            iArr[m11] = iArr[i11];
            iArr[i11] = m11;
        } else {
            this.f6784h[m11] = -1;
            if (this.f6786j > 0) {
                this.f6785i[m11] = this.f6787k;
                this.f6787k = m11;
            } else {
                this.f6785i[m11] = -1;
            }
        }
        int i12 = this.f6785i[m11];
        if (i12 != -1) {
            this.f6784h[i12] = m11;
        }
        k(solverVariable, m11);
    }

    private void q(SolverVariable solverVariable) {
        int[] iArr;
        int i11;
        int i12 = solverVariable.f6684c;
        int i13 = i12 % this.f6779c;
        int[] iArr2 = this.f6780d;
        int i14 = iArr2[i13];
        if (i14 == -1) {
            return;
        }
        if (this.f6782f[i14] == i12) {
            int[] iArr3 = this.f6781e;
            iArr2[i13] = iArr3[i14];
            iArr3[i14] = -1;
            return;
        }
        while (true) {
            iArr = this.f6781e;
            i11 = iArr[i14];
            if (i11 == -1 || this.f6782f[i11] == i12) {
                break;
            } else {
                i14 = i11;
            }
        }
        if (i11 == -1 || this.f6782f[i11] != i12) {
            return;
        }
        iArr[i14] = iArr[i11];
        iArr[i11] = -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean a(SolverVariable solverVariable) {
        return o(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable b(int i11) {
        int i12 = this.f6786j;
        if (i12 == 0) {
            return null;
        }
        int i13 = this.f6787k;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11 && i13 != -1) {
                return this.f6789m.f6720d[this.f6782f[i13]];
            }
            i13 = this.f6785i[i13];
            if (i13 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void c(SolverVariable solverVariable, float f11, boolean z10) {
        float f12 = f6776n;
        if (f11 <= (-f12) || f11 >= f12) {
            int o11 = o(solverVariable);
            if (o11 == -1) {
                g(solverVariable, f11);
                return;
            }
            float[] fArr = this.f6783g;
            float f13 = fArr[o11] + f11;
            fArr[o11] = f13;
            float f14 = f6776n;
            if (f13 <= (-f14) || f13 >= f14) {
                return;
            }
            fArr[o11] = 0.0f;
            e(solverVariable, z10);
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void clear() {
        int i11 = this.f6786j;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable b11 = b(i12);
            if (b11 != null) {
                b11.e(this.f6788l);
            }
        }
        for (int i13 = 0; i13 < this.f6778b; i13++) {
            this.f6782f[i13] = -1;
            this.f6781e[i13] = -1;
        }
        for (int i14 = 0; i14 < this.f6779c; i14++) {
            this.f6780d[i14] = -1;
        }
        this.f6786j = 0;
        this.f6787k = -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i11 = this.f6786j;
        int i12 = this.f6787k;
        for (int i13 = 0; i13 < i11; i13++) {
            float[] fArr = this.f6783g;
            fArr[i12] = fArr[i12] * (-1.0f);
            i12 = this.f6785i[i12];
            if (i12 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float e(SolverVariable solverVariable, boolean z10) {
        int o11 = o(solverVariable);
        if (o11 == -1) {
            return 0.0f;
        }
        q(solverVariable);
        float f11 = this.f6783g[o11];
        if (this.f6787k == o11) {
            this.f6787k = this.f6785i[o11];
        }
        this.f6782f[o11] = -1;
        int[] iArr = this.f6784h;
        int i11 = iArr[o11];
        if (i11 != -1) {
            int[] iArr2 = this.f6785i;
            iArr2[i11] = iArr2[o11];
        }
        int i12 = this.f6785i[o11];
        if (i12 != -1) {
            iArr[i12] = iArr[o11];
        }
        this.f6786j--;
        solverVariable.f6694m--;
        if (z10) {
            solverVariable.e(this.f6788l);
        }
        return f11;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z10) {
        float i11 = i(bVar.f6711a);
        e(bVar.f6711a, z10);
        h hVar = (h) bVar.f6715e;
        int currentSize = hVar.getCurrentSize();
        int i12 = 0;
        int i13 = 0;
        while (i12 < currentSize) {
            int i14 = hVar.f6782f[i13];
            if (i14 != -1) {
                c(this.f6789m.f6720d[i14], hVar.f6783g[i13] * i11, z10);
                i12++;
            }
            i13++;
        }
        return i11;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void g(SolverVariable solverVariable, float f11) {
        float f12 = f6776n;
        if (f11 > (-f12) && f11 < f12) {
            e(solverVariable, true);
            return;
        }
        if (this.f6786j == 0) {
            l(0, solverVariable, f11);
            k(solverVariable, 0);
            this.f6787k = 0;
            return;
        }
        int o11 = o(solverVariable);
        if (o11 != -1) {
            this.f6783g[o11] = f11;
            return;
        }
        if (this.f6786j + 1 >= this.f6778b) {
            n();
        }
        int i11 = this.f6786j;
        int i12 = this.f6787k;
        int i13 = -1;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = this.f6782f[i12];
            int i16 = solverVariable.f6684c;
            if (i15 == i16) {
                this.f6783g[i12] = f11;
                return;
            }
            if (i15 < i16) {
                i13 = i12;
            }
            i12 = this.f6785i[i12];
            if (i12 == -1) {
                break;
            }
        }
        p(i13, solverVariable, f11);
    }

    @Override // androidx.constraintlayout.core.b.a
    public int getCurrentSize() {
        return this.f6786j;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i11) {
        int i12 = this.f6786j;
        int i13 = this.f6787k;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11) {
                return this.f6783g[i13];
            }
            i13 = this.f6785i[i13];
            if (i13 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float i(SolverVariable solverVariable) {
        int o11 = o(solverVariable);
        if (o11 != -1) {
            return this.f6783g[o11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j(float f11) {
        int i11 = this.f6786j;
        int i12 = this.f6787k;
        for (int i13 = 0; i13 < i11; i13++) {
            float[] fArr = this.f6783g;
            fArr[i12] = fArr[i12] / f11;
            i12 = this.f6785i[i12];
            if (i12 == -1) {
                return;
            }
        }
    }

    public int o(SolverVariable solverVariable) {
        if (this.f6786j != 0 && solverVariable != null) {
            int i11 = solverVariable.f6684c;
            int i12 = this.f6780d[i11 % this.f6779c];
            if (i12 == -1) {
                return -1;
            }
            if (this.f6782f[i12] == i11) {
                return i12;
            }
            do {
                i12 = this.f6781e[i12];
                if (i12 == -1) {
                    break;
                }
            } while (this.f6782f[i12] != i11);
            if (i12 != -1 && this.f6782f[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i11 = this.f6786j;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable b11 = b(i12);
            if (b11 != null) {
                String str2 = str + b11 + " = " + h(i12) + " ";
                int o11 = o(b11);
                String str3 = str2 + "[p: ";
                String str4 = (this.f6784h[o11] != -1 ? str3 + this.f6789m.f6720d[this.f6782f[this.f6784h[o11]]] : str3 + "none") + ", n: ";
                str = (this.f6785i[o11] != -1 ? str4 + this.f6789m.f6720d[this.f6782f[this.f6785i[o11]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
