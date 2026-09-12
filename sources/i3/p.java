package i3;

import java.util.List;

/* loaded from: classes2.dex */
public abstract class p extends androidx.media3.decoder.h implements k {

    /* renamed from: a, reason: collision with root package name */
    private k f65043a;

    /* renamed from: b, reason: collision with root package name */
    private long f65044b;

    public void a(long j11, k kVar, long j12) {
        this.timeUs = j11;
        this.f65043a = kVar;
        if (j12 != Long.MAX_VALUE) {
            j11 = j12;
        }
        this.f65044b = j11;
    }

    @Override // androidx.media3.decoder.h, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        this.f65043a = null;
    }

    @Override // i3.k
    public List getCues(long j11) {
        return ((k) androidx.media3.common.util.a.e(this.f65043a)).getCues(j11 - this.f65044b);
    }

    @Override // i3.k
    public long getEventTime(int i11) {
        return ((k) androidx.media3.common.util.a.e(this.f65043a)).getEventTime(i11) + this.f65044b;
    }

    @Override // i3.k
    public int getEventTimeCount() {
        return ((k) androidx.media3.common.util.a.e(this.f65043a)).getEventTimeCount();
    }

    @Override // i3.k
    public int getNextEventTimeIndex(long j11) {
        return ((k) androidx.media3.common.util.a.e(this.f65043a)).getNextEventTimeIndex(j11 - this.f65044b);
    }
}
