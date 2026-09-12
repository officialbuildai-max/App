package n9;

import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.t;
import g9.b0;
import g9.c0;

/* loaded from: classes4.dex */
final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long f70375a;

    /* renamed from: b, reason: collision with root package name */
    private final t f70376b;

    /* renamed from: c, reason: collision with root package name */
    private final t f70377c;

    /* renamed from: d, reason: collision with root package name */
    private long f70378d;

    public b(long j11, long j12, long j13) {
        this.f70378d = j11;
        this.f70375a = j13;
        t tVar = new t();
        this.f70376b = tVar;
        t tVar2 = new t();
        this.f70377c = tVar2;
        tVar.a(0L);
        tVar2.a(j12);
    }

    @Override // n9.g
    public long a() {
        return this.f70375a;
    }

    public boolean b(long j11) {
        t tVar = this.f70376b;
        return j11 - tVar.b(tVar.c() - 1) < 100000;
    }

    public void c(long j11, long j12) {
        if (b(j11)) {
            return;
        }
        this.f70376b.a(j11);
        this.f70377c.a(j12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(long j11) {
        this.f70378d = j11;
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f70378d;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        int f11 = p0.f(this.f70376b, j11, true, true);
        c0 c0Var = new c0(this.f70376b.b(f11), this.f70377c.b(f11));
        if (c0Var.f63498a == j11 || f11 == this.f70376b.c() - 1) {
            return new b0.a(c0Var);
        }
        int i11 = f11 + 1;
        return new b0.a(c0Var, new c0(this.f70376b.b(i11), this.f70377c.b(i11)));
    }

    @Override // n9.g
    public long getTimeUs(long j11) {
        return this.f70376b.b(p0.f(this.f70377c, j11, true, true));
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return true;
    }
}
