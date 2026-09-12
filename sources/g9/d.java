package g9;

import com.google.android.exoplayer2.util.p0;
import g9.b0;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class d implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f63500a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f63501b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f63502c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f63503d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f63504e;

    /* renamed from: f, reason: collision with root package name */
    private final long f63505f;

    public d(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f63501b = iArr;
        this.f63502c = jArr;
        this.f63503d = jArr2;
        this.f63504e = jArr3;
        int length = iArr.length;
        this.f63500a = length;
        if (length > 0) {
            this.f63505f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f63505f = 0L;
        }
    }

    public int b(long j11) {
        return p0.i(this.f63504e, j11, true, true);
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f63505f;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        int b11 = b(j11);
        c0 c0Var = new c0(this.f63504e[b11], this.f63502c[b11]);
        if (c0Var.f63498a >= j11 || b11 == this.f63500a - 1) {
            return new b0.a(c0Var);
        }
        int i11 = b11 + 1;
        return new b0.a(c0Var, new c0(this.f63504e[i11], this.f63502c[i11]));
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f63500a + ", sizes=" + Arrays.toString(this.f63501b) + ", offsets=" + Arrays.toString(this.f63502c) + ", timeUs=" + Arrays.toString(this.f63504e) + ", durationsUs=" + Arrays.toString(this.f63503d) + ")";
    }
}
