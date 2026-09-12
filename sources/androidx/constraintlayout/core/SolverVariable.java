package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class SolverVariable implements Comparable {

    /* renamed from: r, reason: collision with root package name */
    private static int f6681r = 1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6682a;

    /* renamed from: b, reason: collision with root package name */
    private String f6683b;

    /* renamed from: f, reason: collision with root package name */
    public float f6687f;

    /* renamed from: j, reason: collision with root package name */
    Type f6691j;

    /* renamed from: c, reason: collision with root package name */
    public int f6684c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f6685d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f6686e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6688g = false;

    /* renamed from: h, reason: collision with root package name */
    float[] f6689h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    float[] f6690i = new float[9];

    /* renamed from: k, reason: collision with root package name */
    b[] f6692k = new b[16];

    /* renamed from: l, reason: collision with root package name */
    int f6693l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f6694m = 0;

    /* renamed from: n, reason: collision with root package name */
    boolean f6695n = false;

    /* renamed from: o, reason: collision with root package name */
    int f6696o = -1;

    /* renamed from: p, reason: collision with root package name */
    float f6697p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    HashSet f6698q = null;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f6691j = type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        f6681r++;
    }

    public final void a(b bVar) {
        int i11 = 0;
        while (true) {
            int i12 = this.f6693l;
            if (i11 >= i12) {
                b[] bVarArr = this.f6692k;
                if (i12 >= bVarArr.length) {
                    this.f6692k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f6692k;
                int i13 = this.f6693l;
                bVarArr2[i13] = bVar;
                this.f6693l = i13 + 1;
                return;
            }
            if (this.f6692k[i11] == bVar) {
                return;
            } else {
                i11++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(SolverVariable solverVariable) {
        return this.f6684c - solverVariable.f6684c;
    }

    public final void e(b bVar) {
        int i11 = this.f6693l;
        int i12 = 0;
        while (i12 < i11) {
            if (this.f6692k[i12] == bVar) {
                while (i12 < i11 - 1) {
                    b[] bVarArr = this.f6692k;
                    int i13 = i12 + 1;
                    bVarArr[i12] = bVarArr[i13];
                    i12 = i13;
                }
                this.f6693l--;
                return;
            }
            i12++;
        }
    }

    public void f() {
        this.f6683b = null;
        this.f6691j = Type.UNKNOWN;
        this.f6686e = 0;
        this.f6684c = -1;
        this.f6685d = -1;
        this.f6687f = 0.0f;
        this.f6688g = false;
        this.f6695n = false;
        this.f6696o = -1;
        this.f6697p = 0.0f;
        int i11 = this.f6693l;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6692k[i12] = null;
        }
        this.f6693l = 0;
        this.f6694m = 0;
        this.f6682a = false;
        Arrays.fill(this.f6690i, 0.0f);
    }

    public void g(d dVar, float f11) {
        this.f6687f = f11;
        this.f6688g = true;
        this.f6695n = false;
        this.f6696o = -1;
        this.f6697p = 0.0f;
        int i11 = this.f6693l;
        this.f6685d = -1;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6692k[i12].A(dVar, this, false);
        }
        this.f6693l = 0;
    }

    public void h(Type type, String str) {
        this.f6691j = type;
    }

    public final void i(d dVar, b bVar) {
        int i11 = this.f6693l;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6692k[i12].B(dVar, bVar, false);
        }
        this.f6693l = 0;
    }

    public String toString() {
        if (this.f6683b != null) {
            return "" + this.f6683b;
        }
        return "" + this.f6684c;
    }
}
