package da;

import ba.i;
import java.util.List;

/* loaded from: classes4.dex */
final class c implements i {

    /* renamed from: a, reason: collision with root package name */
    private final List f61427a;

    public c(List list) {
        this.f61427a = list;
    }

    @Override // ba.i
    public List getCues(long j11) {
        return this.f61427a;
    }

    @Override // ba.i
    public long getEventTime(int i11) {
        return 0L;
    }

    @Override // ba.i
    public int getEventTimeCount() {
        return 1;
    }

    @Override // ba.i
    public int getNextEventTimeIndex(long j11) {
        return -1;
    }
}
