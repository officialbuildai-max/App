package n2;

import androidx.media3.common.util.a1;
import java.util.Arrays;
import l2.m0;
import l2.n0;
import l2.s;
import l2.s0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final d f70276a;

    /* renamed from: b, reason: collision with root package name */
    private final s0 f70277b;

    /* renamed from: c, reason: collision with root package name */
    private final int f70278c;

    /* renamed from: d, reason: collision with root package name */
    private final int f70279d;

    /* renamed from: e, reason: collision with root package name */
    private final long f70280e;

    /* renamed from: f, reason: collision with root package name */
    private int f70281f;

    /* renamed from: g, reason: collision with root package name */
    private int f70282g;

    /* renamed from: h, reason: collision with root package name */
    private int f70283h;

    /* renamed from: i, reason: collision with root package name */
    private int f70284i;

    /* renamed from: j, reason: collision with root package name */
    private int f70285j;

    /* renamed from: k, reason: collision with root package name */
    private int f70286k;

    /* renamed from: l, reason: collision with root package name */
    private long f70287l;

    /* renamed from: m, reason: collision with root package name */
    private long[] f70288m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f70289n;

    public e(int i11, d dVar, s0 s0Var) {
        this.f70276a = dVar;
        int b11 = dVar.b();
        boolean z10 = true;
        if (b11 != 1 && b11 != 2) {
            z10 = false;
        }
        androidx.media3.common.util.a.a(z10);
        this.f70278c = d(i11, b11 == 2 ? 1667497984 : 1651965952);
        this.f70280e = dVar.a();
        this.f70277b = s0Var;
        this.f70279d = b11 == 2 ? d(i11, 1650720768) : -1;
        this.f70287l = -1L;
        this.f70288m = new long[512];
        this.f70289n = new int[512];
        this.f70281f = dVar.f70273e;
    }

    private static int d(int i11, int i12) {
        return (((i11 % 10) + 48) << 8) | ((i11 / 10) + 48) | i12;
    }

    private long e(int i11) {
        return (this.f70280e * i11) / this.f70281f;
    }

    private n0 h(int i11) {
        return new n0(this.f70289n[i11] * g(), this.f70288m[i11]);
    }

    public void a() {
        this.f70284i++;
    }

    public void b(long j11, boolean z10) {
        if (this.f70287l == -1) {
            this.f70287l = j11;
        }
        if (z10) {
            if (this.f70286k == this.f70289n.length) {
                long[] jArr = this.f70288m;
                this.f70288m = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.f70289n;
                this.f70289n = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.f70288m;
            int i11 = this.f70286k;
            jArr2[i11] = j11;
            this.f70289n[i11] = this.f70285j;
            this.f70286k = i11 + 1;
        }
        this.f70285j++;
    }

    public void c() {
        int i11;
        this.f70288m = Arrays.copyOf(this.f70288m, this.f70286k);
        this.f70289n = Arrays.copyOf(this.f70289n, this.f70286k);
        if (!k() || this.f70276a.f70275g == 0 || (i11 = this.f70286k) <= 0) {
            return;
        }
        this.f70281f = i11;
    }

    public long f() {
        return e(this.f70284i);
    }

    public long g() {
        return e(1);
    }

    public m0.a i(long j11) {
        if (this.f70286k == 0) {
            return new m0.a(new n0(0L, this.f70287l));
        }
        int g11 = (int) (j11 / g());
        int g12 = a1.g(this.f70289n, g11, true, true);
        if (this.f70289n[g12] == g11) {
            return new m0.a(h(g12));
        }
        n0 h11 = h(g12);
        int i11 = g12 + 1;
        return i11 < this.f70288m.length ? new m0.a(h11, h(i11)) : new m0.a(h11);
    }

    public boolean j(int i11) {
        return this.f70278c == i11 || this.f70279d == i11;
    }

    public boolean k() {
        return (this.f70278c & 1651965952) == 1651965952;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f70289n, this.f70284i) >= 0;
    }

    public boolean m(s sVar) {
        int i11 = this.f70283h;
        int e11 = i11 - this.f70277b.e(sVar, i11, false);
        this.f70283h = e11;
        boolean z10 = e11 == 0;
        if (z10) {
            if (this.f70282g > 0) {
                this.f70277b.d(f(), l() ? 1 : 0, this.f70282g, 0, null);
            }
            a();
        }
        return z10;
    }

    public void n(int i11) {
        this.f70282g = i11;
        this.f70283h = i11;
    }

    public void o(long j11) {
        if (this.f70286k == 0) {
            this.f70284i = 0;
        } else {
            this.f70284i = this.f70289n[a1.h(this.f70288m, j11, true, true)];
        }
    }
}
