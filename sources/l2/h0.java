package l2;

import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.m0;

/* loaded from: classes2.dex */
public final class h0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.v f68712a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.v f68713b;

    /* renamed from: c, reason: collision with root package name */
    private long f68714c;

    public h0(long[] jArr, long[] jArr2, long j11) {
        androidx.media3.common.util.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            this.f68712a = new androidx.media3.common.util.v(length);
            this.f68713b = new androidx.media3.common.util.v(length);
        } else {
            int i11 = length + 1;
            androidx.media3.common.util.v vVar = new androidx.media3.common.util.v(i11);
            this.f68712a = vVar;
            androidx.media3.common.util.v vVar2 = new androidx.media3.common.util.v(i11);
            this.f68713b = vVar2;
            vVar.a(0L);
            vVar2.a(0L);
        }
        this.f68712a.b(jArr);
        this.f68713b.b(jArr2);
        this.f68714c = j11;
    }

    public void b(long j11, long j12) {
        if (this.f68713b.d() == 0 && j11 > 0) {
            this.f68712a.a(0L);
            this.f68713b.a(0L);
        }
        this.f68712a.a(j12);
        this.f68713b.a(j11);
    }

    public boolean c(long j11, long j12) {
        if (this.f68713b.d() == 0) {
            return false;
        }
        androidx.media3.common.util.v vVar = this.f68713b;
        return j11 - vVar.c(vVar.d() - 1) < j12;
    }

    public void d(long j11) {
        this.f68714c = j11;
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f68714c;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        if (this.f68713b.d() == 0) {
            return new m0.a(n0.f68772c);
        }
        int e11 = a1.e(this.f68713b, j11, true, true);
        n0 n0Var = new n0(this.f68713b.c(e11), this.f68712a.c(e11));
        if (n0Var.f68773a == j11 || e11 == this.f68713b.d() - 1) {
            return new m0.a(n0Var);
        }
        int i11 = e11 + 1;
        return new m0.a(n0Var, new n0(this.f68713b.c(i11), this.f68712a.c(i11)));
    }

    public long getTimeUs(long j11) {
        if (this.f68713b.d() == 0) {
            return C.TIME_UNSET;
        }
        return this.f68713b.c(a1.e(this.f68712a, j11, true, true));
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return this.f68713b.d() > 0;
    }
}
