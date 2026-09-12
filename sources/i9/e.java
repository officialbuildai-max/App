package i9;

import com.google.android.exoplayer2.util.p0;
import g9.b0;
import g9.c0;
import g9.e0;
import g9.m;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    protected final e0 f65186a;

    /* renamed from: b, reason: collision with root package name */
    private final int f65187b;

    /* renamed from: c, reason: collision with root package name */
    private final int f65188c;

    /* renamed from: d, reason: collision with root package name */
    private final long f65189d;

    /* renamed from: e, reason: collision with root package name */
    private final int f65190e;

    /* renamed from: f, reason: collision with root package name */
    private int f65191f;

    /* renamed from: g, reason: collision with root package name */
    private int f65192g;

    /* renamed from: h, reason: collision with root package name */
    private int f65193h;

    /* renamed from: i, reason: collision with root package name */
    private int f65194i;

    /* renamed from: j, reason: collision with root package name */
    private int f65195j;

    /* renamed from: k, reason: collision with root package name */
    private long[] f65196k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f65197l;

    public e(int i11, int i12, long j11, int i13, e0 e0Var) {
        boolean z10 = true;
        if (i12 != 1 && i12 != 2) {
            z10 = false;
        }
        com.google.android.exoplayer2.util.a.a(z10);
        this.f65189d = j11;
        this.f65190e = i13;
        this.f65186a = e0Var;
        this.f65187b = d(i11, i12 == 2 ? 1667497984 : 1651965952);
        this.f65188c = i12 == 2 ? d(i11, 1650720768) : -1;
        this.f65196k = new long[512];
        this.f65197l = new int[512];
    }

    private static int d(int i11, int i12) {
        return (((i11 % 10) + 48) << 8) | ((i11 / 10) + 48) | i12;
    }

    private long e(int i11) {
        return (this.f65189d * i11) / this.f65190e;
    }

    private c0 h(int i11) {
        return new c0(this.f65197l[i11] * g(), this.f65196k[i11]);
    }

    public void a() {
        this.f65193h++;
    }

    public void b(long j11) {
        if (this.f65195j == this.f65197l.length) {
            long[] jArr = this.f65196k;
            this.f65196k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f65197l;
            this.f65197l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f65196k;
        int i11 = this.f65195j;
        jArr2[i11] = j11;
        this.f65197l[i11] = this.f65194i;
        this.f65195j = i11 + 1;
    }

    public void c() {
        this.f65196k = Arrays.copyOf(this.f65196k, this.f65195j);
        this.f65197l = Arrays.copyOf(this.f65197l, this.f65195j);
    }

    public long f() {
        return e(this.f65193h);
    }

    public long g() {
        return e(1);
    }

    public b0.a i(long j11) {
        int g11 = (int) (j11 / g());
        int h11 = p0.h(this.f65197l, g11, true, true);
        if (this.f65197l[h11] == g11) {
            return new b0.a(h(h11));
        }
        c0 h12 = h(h11);
        int i11 = h11 + 1;
        return i11 < this.f65196k.length ? new b0.a(h12, h(i11)) : new b0.a(h12);
    }

    public boolean j(int i11) {
        return this.f65187b == i11 || this.f65188c == i11;
    }

    public void k() {
        this.f65194i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f65197l, this.f65193h) >= 0;
    }

    public boolean m(m mVar) {
        int i11 = this.f65192g;
        int b11 = i11 - this.f65186a.b(mVar, i11, false);
        this.f65192g = b11;
        boolean z10 = b11 == 0;
        if (z10) {
            if (this.f65191f > 0) {
                this.f65186a.d(f(), l() ? 1 : 0, this.f65191f, 0, null);
            }
            a();
        }
        return z10;
    }

    public void n(int i11) {
        this.f65191f = i11;
        this.f65192g = i11;
    }

    public void o(long j11) {
        if (this.f65195j == 0) {
            this.f65193h = 0;
        } else {
            this.f65193h = this.f65197l[p0.i(this.f65196k, j11, true, true)];
        }
    }
}
