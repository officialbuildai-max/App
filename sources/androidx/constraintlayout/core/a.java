package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: l, reason: collision with root package name */
    private static float f6699l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    private final b f6701b;

    /* renamed from: c, reason: collision with root package name */
    protected final c f6702c;

    /* renamed from: a, reason: collision with root package name */
    int f6700a = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f6703d = 8;

    /* renamed from: e, reason: collision with root package name */
    private SolverVariable f6704e = null;

    /* renamed from: f, reason: collision with root package name */
    private int[] f6705f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    private int[] f6706g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    private float[] f6707h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    private int f6708i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f6709j = -1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6710k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f6701b = bVar;
        this.f6702c = cVar;
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean a(SolverVariable solverVariable) {
        int i11 = this.f6708i;
        if (i11 == -1) {
            return false;
        }
        for (int i12 = 0; i11 != -1 && i12 < this.f6700a; i12++) {
            if (this.f6705f[i11] == solverVariable.f6684c) {
                return true;
            }
            i11 = this.f6706g[i11];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable b(int i11) {
        int i12 = this.f6708i;
        for (int i13 = 0; i12 != -1 && i13 < this.f6700a; i13++) {
            if (i13 == i11) {
                return this.f6702c.f6720d[this.f6705f[i12]];
            }
            i12 = this.f6706g[i12];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void c(SolverVariable solverVariable, float f11, boolean z10) {
        float f12 = f6699l;
        if (f11 <= (-f12) || f11 >= f12) {
            int i11 = this.f6708i;
            if (i11 == -1) {
                this.f6708i = 0;
                this.f6707h[0] = f11;
                this.f6705f[0] = solverVariable.f6684c;
                this.f6706g[0] = -1;
                solverVariable.f6694m++;
                solverVariable.a(this.f6701b);
                this.f6700a++;
                if (this.f6710k) {
                    return;
                }
                int i12 = this.f6709j + 1;
                this.f6709j = i12;
                int[] iArr = this.f6705f;
                if (i12 >= iArr.length) {
                    this.f6710k = true;
                    this.f6709j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i13 = -1;
            for (int i14 = 0; i11 != -1 && i14 < this.f6700a; i14++) {
                int i15 = this.f6705f[i11];
                int i16 = solverVariable.f6684c;
                if (i15 == i16) {
                    float[] fArr = this.f6707h;
                    float f13 = fArr[i11] + f11;
                    float f14 = f6699l;
                    if (f13 > (-f14) && f13 < f14) {
                        f13 = 0.0f;
                    }
                    fArr[i11] = f13;
                    if (f13 == 0.0f) {
                        if (i11 == this.f6708i) {
                            this.f6708i = this.f6706g[i11];
                        } else {
                            int[] iArr2 = this.f6706g;
                            iArr2[i13] = iArr2[i11];
                        }
                        if (z10) {
                            solverVariable.e(this.f6701b);
                        }
                        if (this.f6710k) {
                            this.f6709j = i11;
                        }
                        solverVariable.f6694m--;
                        this.f6700a--;
                        return;
                    }
                    return;
                }
                if (i15 < i16) {
                    i13 = i11;
                }
                i11 = this.f6706g[i11];
            }
            int i17 = this.f6709j;
            int i18 = i17 + 1;
            if (this.f6710k) {
                int[] iArr3 = this.f6705f;
                if (iArr3[i17] != -1) {
                    i17 = iArr3.length;
                }
            } else {
                i17 = i18;
            }
            int[] iArr4 = this.f6705f;
            if (i17 >= iArr4.length && this.f6700a < iArr4.length) {
                int i19 = 0;
                while (true) {
                    int[] iArr5 = this.f6705f;
                    if (i19 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i19] == -1) {
                        i17 = i19;
                        break;
                    }
                    i19++;
                }
            }
            int[] iArr6 = this.f6705f;
            if (i17 >= iArr6.length) {
                i17 = iArr6.length;
                int i20 = this.f6703d * 2;
                this.f6703d = i20;
                this.f6710k = false;
                this.f6709j = i17 - 1;
                this.f6707h = Arrays.copyOf(this.f6707h, i20);
                this.f6705f = Arrays.copyOf(this.f6705f, this.f6703d);
                this.f6706g = Arrays.copyOf(this.f6706g, this.f6703d);
            }
            this.f6705f[i17] = solverVariable.f6684c;
            this.f6707h[i17] = f11;
            if (i13 != -1) {
                int[] iArr7 = this.f6706g;
                iArr7[i17] = iArr7[i13];
                iArr7[i13] = i17;
            } else {
                this.f6706g[i17] = this.f6708i;
                this.f6708i = i17;
            }
            solverVariable.f6694m++;
            solverVariable.a(this.f6701b);
            this.f6700a++;
            if (!this.f6710k) {
                this.f6709j++;
            }
            int i21 = this.f6709j;
            int[] iArr8 = this.f6705f;
            if (i21 >= iArr8.length) {
                this.f6710k = true;
                this.f6709j = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i11 = this.f6708i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6700a; i12++) {
            SolverVariable solverVariable = this.f6702c.f6720d[this.f6705f[i11]];
            if (solverVariable != null) {
                solverVariable.e(this.f6701b);
            }
            i11 = this.f6706g[i11];
        }
        this.f6708i = -1;
        this.f6709j = -1;
        this.f6710k = false;
        this.f6700a = 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i11 = this.f6708i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6700a; i12++) {
            float[] fArr = this.f6707h;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f6706g[i11];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float e(SolverVariable solverVariable, boolean z10) {
        if (this.f6704e == solverVariable) {
            this.f6704e = null;
        }
        int i11 = this.f6708i;
        if (i11 == -1) {
            return 0.0f;
        }
        int i12 = 0;
        int i13 = -1;
        while (i11 != -1 && i12 < this.f6700a) {
            if (this.f6705f[i11] == solverVariable.f6684c) {
                if (i11 == this.f6708i) {
                    this.f6708i = this.f6706g[i11];
                } else {
                    int[] iArr = this.f6706g;
                    iArr[i13] = iArr[i11];
                }
                if (z10) {
                    solverVariable.e(this.f6701b);
                }
                solverVariable.f6694m--;
                this.f6700a--;
                this.f6705f[i11] = -1;
                if (this.f6710k) {
                    this.f6709j = i11;
                }
                return this.f6707h[i11];
            }
            i12++;
            i13 = i11;
            i11 = this.f6706g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z10) {
        float i11 = i(bVar.f6711a);
        e(bVar.f6711a, z10);
        b.a aVar = bVar.f6715e;
        int currentSize = aVar.getCurrentSize();
        for (int i12 = 0; i12 < currentSize; i12++) {
            SolverVariable b11 = aVar.b(i12);
            c(b11, aVar.i(b11) * i11, z10);
        }
        return i11;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void g(SolverVariable solverVariable, float f11) {
        if (f11 == 0.0f) {
            e(solverVariable, true);
            return;
        }
        int i11 = this.f6708i;
        if (i11 == -1) {
            this.f6708i = 0;
            this.f6707h[0] = f11;
            this.f6705f[0] = solverVariable.f6684c;
            this.f6706g[0] = -1;
            solverVariable.f6694m++;
            solverVariable.a(this.f6701b);
            this.f6700a++;
            if (this.f6710k) {
                return;
            }
            int i12 = this.f6709j + 1;
            this.f6709j = i12;
            int[] iArr = this.f6705f;
            if (i12 >= iArr.length) {
                this.f6710k = true;
                this.f6709j = iArr.length - 1;
                return;
            }
            return;
        }
        int i13 = -1;
        for (int i14 = 0; i11 != -1 && i14 < this.f6700a; i14++) {
            int i15 = this.f6705f[i11];
            int i16 = solverVariable.f6684c;
            if (i15 == i16) {
                this.f6707h[i11] = f11;
                return;
            }
            if (i15 < i16) {
                i13 = i11;
            }
            i11 = this.f6706g[i11];
        }
        int i17 = this.f6709j;
        int i18 = i17 + 1;
        if (this.f6710k) {
            int[] iArr2 = this.f6705f;
            if (iArr2[i17] != -1) {
                i17 = iArr2.length;
            }
        } else {
            i17 = i18;
        }
        int[] iArr3 = this.f6705f;
        if (i17 >= iArr3.length && this.f6700a < iArr3.length) {
            int i19 = 0;
            while (true) {
                int[] iArr4 = this.f6705f;
                if (i19 >= iArr4.length) {
                    break;
                }
                if (iArr4[i19] == -1) {
                    i17 = i19;
                    break;
                }
                i19++;
            }
        }
        int[] iArr5 = this.f6705f;
        if (i17 >= iArr5.length) {
            i17 = iArr5.length;
            int i20 = this.f6703d * 2;
            this.f6703d = i20;
            this.f6710k = false;
            this.f6709j = i17 - 1;
            this.f6707h = Arrays.copyOf(this.f6707h, i20);
            this.f6705f = Arrays.copyOf(this.f6705f, this.f6703d);
            this.f6706g = Arrays.copyOf(this.f6706g, this.f6703d);
        }
        this.f6705f[i17] = solverVariable.f6684c;
        this.f6707h[i17] = f11;
        if (i13 != -1) {
            int[] iArr6 = this.f6706g;
            iArr6[i17] = iArr6[i13];
            iArr6[i13] = i17;
        } else {
            this.f6706g[i17] = this.f6708i;
            this.f6708i = i17;
        }
        solverVariable.f6694m++;
        solverVariable.a(this.f6701b);
        int i21 = this.f6700a + 1;
        this.f6700a = i21;
        if (!this.f6710k) {
            this.f6709j++;
        }
        int[] iArr7 = this.f6705f;
        if (i21 >= iArr7.length) {
            this.f6710k = true;
        }
        if (this.f6709j >= iArr7.length) {
            this.f6710k = true;
            this.f6709j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public int getCurrentSize() {
        return this.f6700a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i11) {
        int i12 = this.f6708i;
        for (int i13 = 0; i12 != -1 && i13 < this.f6700a; i13++) {
            if (i13 == i11) {
                return this.f6707h[i12];
            }
            i12 = this.f6706g[i12];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float i(SolverVariable solverVariable) {
        int i11 = this.f6708i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6700a; i12++) {
            if (this.f6705f[i11] == solverVariable.f6684c) {
                return this.f6707h[i11];
            }
            i11 = this.f6706g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j(float f11) {
        int i11 = this.f6708i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6700a; i12++) {
            float[] fArr = this.f6707h;
            fArr[i11] = fArr[i11] / f11;
            i11 = this.f6706g[i11];
        }
    }

    public String toString() {
        int i11 = this.f6708i;
        String str = "";
        for (int i12 = 0; i11 != -1 && i12 < this.f6700a; i12++) {
            str = ((str + " -> ") + this.f6707h[i11] + " : ") + this.f6702c.f6720d[this.f6705f[i11]];
            i11 = this.f6706g[i11];
        }
        return str;
    }
}
