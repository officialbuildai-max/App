package l2;

import l2.m0;

/* loaded from: classes2.dex */
public abstract class d0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final m0 f68663a;

    public d0(m0 m0Var) {
        this.f68663a = m0Var;
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f68663a.getDurationUs();
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        return this.f68663a.getSeekPoints(j11);
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return this.f68663a.isSeekable();
    }
}
