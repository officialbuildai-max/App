package g9;

import com.google.android.exoplayer2.util.p0;
import g9.b0;

/* loaded from: classes4.dex */
public final class z implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f63601a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f63602b;

    /* renamed from: c, reason: collision with root package name */
    private final long f63603c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f63604d;

    public z(long[] jArr, long[] jArr2, long j11) {
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z10 = length > 0;
        this.f63604d = z10;
        if (!z10 || jArr2[0] <= 0) {
            this.f63601a = jArr;
            this.f63602b = jArr2;
        } else {
            int i11 = length + 1;
            long[] jArr3 = new long[i11];
            this.f63601a = jArr3;
            long[] jArr4 = new long[i11];
            this.f63602b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f63603c = j11;
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f63603c;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        if (!this.f63604d) {
            return new b0.a(c0.f63497c);
        }
        int i11 = p0.i(this.f63602b, j11, true, true);
        c0 c0Var = new c0(this.f63602b[i11], this.f63601a[i11]);
        if (c0Var.f63498a == j11 || i11 == this.f63602b.length - 1) {
            return new b0.a(c0Var);
        }
        int i12 = i11 + 1;
        return new b0.a(c0Var, new c0(this.f63602b[i12], this.f63601a[i12]));
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return this.f63604d;
    }
}
