package ba;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class n extends com.google.android.exoplayer2.decoder.f implements i {

    /* renamed from: d, reason: collision with root package name */
    private i f16393d;

    /* renamed from: e, reason: collision with root package name */
    private long f16394e;

    @Override // com.google.android.exoplayer2.decoder.a
    public void b() {
        super.b();
        this.f16393d = null;
    }

    @Override // ba.i
    public List getCues(long j11) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f16393d)).getCues(j11 - this.f16394e);
    }

    @Override // ba.i
    public long getEventTime(int i11) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f16393d)).getEventTime(i11) + this.f16394e;
    }

    @Override // ba.i
    public int getEventTimeCount() {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f16393d)).getEventTimeCount();
    }

    @Override // ba.i
    public int getNextEventTimeIndex(long j11) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f16393d)).getNextEventTimeIndex(j11 - this.f16394e);
    }

    public void m(long j11, i iVar, long j12) {
        this.f24941b = j11;
        this.f16393d = iVar;
        if (j12 != Long.MAX_VALUE) {
            j11 = j12;
        }
        this.f16394e = j11;
    }
}
