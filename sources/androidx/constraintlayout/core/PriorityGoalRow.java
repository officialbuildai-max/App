package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class PriorityGoalRow extends b {

    /* renamed from: g, reason: collision with root package name */
    private int f6672g;

    /* renamed from: h, reason: collision with root package name */
    private SolverVariable[] f6673h;

    /* renamed from: i, reason: collision with root package name */
    private SolverVariable[] f6674i;

    /* renamed from: j, reason: collision with root package name */
    private int f6675j;

    /* renamed from: k, reason: collision with root package name */
    a f6676k;

    /* renamed from: l, reason: collision with root package name */
    c f6677l;

    /* loaded from: classes.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        SolverVariable f6678a;

        /* renamed from: b, reason: collision with root package name */
        PriorityGoalRow f6679b;

        public a(PriorityGoalRow priorityGoalRow) {
            this.f6679b = priorityGoalRow;
        }

        public boolean a(SolverVariable solverVariable, float f11) {
            boolean z10 = true;
            if (!this.f6678a.f6682a) {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f12 = solverVariable.f6690i[i11];
                    if (f12 != 0.0f) {
                        float f13 = f12 * f11;
                        if (Math.abs(f13) < 1.0E-4f) {
                            f13 = 0.0f;
                        }
                        this.f6678a.f6690i[i11] = f13;
                    } else {
                        this.f6678a.f6690i[i11] = 0.0f;
                    }
                }
                return true;
            }
            for (int i12 = 0; i12 < 9; i12++) {
                float[] fArr = this.f6678a.f6690i;
                float f14 = fArr[i12] + (solverVariable.f6690i[i12] * f11);
                fArr[i12] = f14;
                if (Math.abs(f14) < 1.0E-4f) {
                    this.f6678a.f6690i[i12] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                PriorityGoalRow.this.G(this.f6678a);
            }
            return false;
        }

        public void b(SolverVariable solverVariable) {
            this.f6678a = solverVariable;
        }

        public final boolean c() {
            for (int i11 = 8; i11 >= 0; i11--) {
                float f11 = this.f6678a.f6690i[i11];
                if (f11 > 0.0f) {
                    return false;
                }
                if (f11 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i11 = 8;
            while (true) {
                if (i11 < 0) {
                    break;
                }
                float f11 = solverVariable.f6690i[i11];
                float f12 = this.f6678a.f6690i[i11];
                if (f12 == f11) {
                    i11--;
                } else if (f12 < f11) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f6678a.f6690i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f6678a != null) {
                for (int i11 = 0; i11 < 9; i11++) {
                    str = str + this.f6678a.f6690i[i11] + " ";
                }
            }
            return str + "] " + this.f6678a;
        }
    }

    public PriorityGoalRow(c cVar) {
        super(cVar);
        this.f6672g = 128;
        this.f6673h = new SolverVariable[128];
        this.f6674i = new SolverVariable[128];
        this.f6675j = 0;
        this.f6676k = new a(this);
        this.f6677l = cVar;
    }

    private final void F(SolverVariable solverVariable) {
        int i11;
        int i12 = this.f6675j + 1;
        SolverVariable[] solverVariableArr = this.f6673h;
        if (i12 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f6673h = solverVariableArr2;
            this.f6674i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f6673h;
        int i13 = this.f6675j;
        solverVariableArr3[i13] = solverVariable;
        int i14 = i13 + 1;
        this.f6675j = i14;
        if (i14 > 1 && solverVariableArr3[i13].f6684c > solverVariable.f6684c) {
            int i15 = 0;
            while (true) {
                i11 = this.f6675j;
                if (i15 >= i11) {
                    break;
                }
                this.f6674i[i15] = this.f6673h[i15];
                i15++;
            }
            Arrays.sort(this.f6674i, 0, i11, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f6684c - solverVariable3.f6684c;
                }
            });
            for (int i16 = 0; i16 < this.f6675j; i16++) {
                this.f6673h[i16] = this.f6674i[i16];
            }
        }
        solverVariable.f6682a = true;
        solverVariable.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(SolverVariable solverVariable) {
        int i11 = 0;
        while (i11 < this.f6675j) {
            if (this.f6673h[i11] == solverVariable) {
                while (true) {
                    int i12 = this.f6675j;
                    if (i11 >= i12 - 1) {
                        this.f6675j = i12 - 1;
                        solverVariable.f6682a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f6673h;
                        int i13 = i11 + 1;
                        solverVariableArr[i11] = solverVariableArr[i13];
                        i11 = i13;
                    }
                }
            } else {
                i11++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b
    public void B(d dVar, b bVar, boolean z10) {
        SolverVariable solverVariable = bVar.f6711a;
        if (solverVariable == null) {
            return;
        }
        b.a aVar = bVar.f6715e;
        int currentSize = aVar.getCurrentSize();
        for (int i11 = 0; i11 < currentSize; i11++) {
            SolverVariable b11 = aVar.b(i11);
            float h11 = aVar.h(i11);
            this.f6676k.b(b11);
            if (this.f6676k.a(solverVariable, h11)) {
                F(b11);
            }
            this.f6712b += bVar.f6712b * h11;
        }
        G(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        int i11 = -1;
        for (int i12 = 0; i12 < this.f6675j; i12++) {
            SolverVariable solverVariable = this.f6673h[i12];
            if (!zArr[solverVariable.f6684c]) {
                this.f6676k.b(solverVariable);
                if (i11 == -1) {
                    if (!this.f6676k.c()) {
                    }
                    i11 = i12;
                } else {
                    if (!this.f6676k.d(this.f6673h[i11])) {
                    }
                    i11 = i12;
                }
            }
        }
        if (i11 == -1) {
            return null;
        }
        return this.f6673h[i11];
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        this.f6676k.b(solverVariable);
        this.f6676k.e();
        solverVariable.f6690i[solverVariable.f6686e] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void clear() {
        this.f6675j = 0;
        this.f6712b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f6675j == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = " goal -> (" + this.f6712b + ") : ";
        for (int i11 = 0; i11 < this.f6675j; i11++) {
            this.f6676k.b(this.f6673h[i11]);
            str = str + this.f6676k + " ";
        }
        return str;
    }
}
