package ga;

import ba.i;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class d implements i {

    /* renamed from: a, reason: collision with root package name */
    private final List f63643a;

    /* renamed from: b, reason: collision with root package name */
    private final List f63644b;

    public d(List list, List list2) {
        this.f63643a = list;
        this.f63644b = list2;
    }

    @Override // ba.i
    public List getCues(long j11) {
        int g11 = p0.g(this.f63644b, Long.valueOf(j11), true, false);
        return g11 == -1 ? Collections.emptyList() : (List) this.f63643a.get(g11);
    }

    @Override // ba.i
    public long getEventTime(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0);
        com.google.android.exoplayer2.util.a.a(i11 < this.f63644b.size());
        return ((Long) this.f63644b.get(i11)).longValue();
    }

    @Override // ba.i
    public int getEventTimeCount() {
        return this.f63644b.size();
    }

    @Override // ba.i
    public int getNextEventTimeIndex(long j11) {
        int d11 = p0.d(this.f63644b, Long.valueOf(j11), false, false);
        if (d11 < this.f63644b.size()) {
            return d11;
        }
        return -1;
    }
}
