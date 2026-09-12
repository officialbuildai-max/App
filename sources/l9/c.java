package l9;

import g9.m;
import g9.w;

/* loaded from: classes4.dex */
final class c extends w {

    /* renamed from: b, reason: collision with root package name */
    private final long f68893b;

    public c(m mVar, long j11) {
        super(mVar);
        com.google.android.exoplayer2.util.a.a(mVar.getPosition() >= j11);
        this.f68893b = j11;
    }

    @Override // g9.w, g9.m
    public long getLength() {
        return super.getLength() - this.f68893b;
    }

    @Override // g9.w, g9.m
    public long getPeekPosition() {
        return super.getPeekPosition() - this.f68893b;
    }

    @Override // g9.w, g9.m
    public long getPosition() {
        return super.getPosition() - this.f68893b;
    }
}
