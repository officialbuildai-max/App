package o9;

import com.google.android.exoplayer2.o1;

/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final int f70999a;

    /* renamed from: b, reason: collision with root package name */
    public final int f71000b;

    /* renamed from: c, reason: collision with root package name */
    public final long f71001c;

    /* renamed from: d, reason: collision with root package name */
    public final long f71002d;

    /* renamed from: e, reason: collision with root package name */
    public final long f71003e;

    /* renamed from: f, reason: collision with root package name */
    public final o1 f71004f;

    /* renamed from: g, reason: collision with root package name */
    public final int f71005g;

    /* renamed from: h, reason: collision with root package name */
    public final long[] f71006h;

    /* renamed from: i, reason: collision with root package name */
    public final long[] f71007i;

    /* renamed from: j, reason: collision with root package name */
    public final int f71008j;

    /* renamed from: k, reason: collision with root package name */
    private final p[] f71009k;

    public o(int i11, int i12, long j11, long j12, long j13, o1 o1Var, int i13, p[] pVarArr, int i14, long[] jArr, long[] jArr2) {
        this.f70999a = i11;
        this.f71000b = i12;
        this.f71001c = j11;
        this.f71002d = j12;
        this.f71003e = j13;
        this.f71004f = o1Var;
        this.f71005g = i13;
        this.f71009k = pVarArr;
        this.f71008j = i14;
        this.f71006h = jArr;
        this.f71007i = jArr2;
    }

    public p a(int i11) {
        p[] pVarArr = this.f71009k;
        if (pVarArr == null) {
            return null;
        }
        return pVarArr[i11];
    }
}
