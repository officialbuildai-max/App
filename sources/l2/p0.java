package l2;

import l2.m0;

/* loaded from: classes2.dex */
public final class p0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f68800a;

    /* renamed from: b, reason: collision with root package name */
    private final long f68801b;

    public p0(long j11) {
        this(j11, 0L);
    }

    public p0(long j11, long j12) {
        this.f68800a = j11;
        this.f68801b = j12;
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f68800a;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        return new m0.a(new n0(j11, this.f68801b));
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return true;
    }
}
