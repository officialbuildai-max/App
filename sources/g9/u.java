package g9;

import com.google.android.exoplayer2.util.p0;
import g9.b0;
import g9.v;

/* loaded from: classes4.dex */
public final class u implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final v f63580a;

    /* renamed from: b, reason: collision with root package name */
    private final long f63581b;

    public u(v vVar, long j11) {
        this.f63580a = vVar;
        this.f63581b = j11;
    }

    private c0 b(long j11, long j12) {
        return new c0((j11 * 1000000) / this.f63580a.f63586e, this.f63581b + j12);
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f63580a.f();
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        com.google.android.exoplayer2.util.a.i(this.f63580a.f63592k);
        v vVar = this.f63580a;
        v.a aVar = vVar.f63592k;
        long[] jArr = aVar.f63594a;
        long[] jArr2 = aVar.f63595b;
        int i11 = p0.i(jArr, vVar.i(j11), true, false);
        c0 b11 = b(i11 == -1 ? 0L : jArr[i11], i11 != -1 ? jArr2[i11] : 0L);
        if (b11.f63498a == j11 || i11 == jArr.length - 1) {
            return new b0.a(b11);
        }
        int i12 = i11 + 1;
        return new b0.a(b11, b(jArr[i12], jArr2[i12]));
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return true;
    }
}
