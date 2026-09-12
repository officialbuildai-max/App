package ia;

import ba.i;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    private final d f65269a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f65270b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f65271c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f65272d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f65273e;

    public h(d dVar, Map map, Map map2, Map map3) {
        this.f65269a = dVar;
        this.f65272d = map2;
        this.f65273e = map3;
        this.f65271c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f65270b = dVar.j();
    }

    @Override // ba.i
    public List getCues(long j11) {
        return this.f65269a.h(j11, this.f65271c, this.f65272d, this.f65273e);
    }

    @Override // ba.i
    public long getEventTime(int i11) {
        return this.f65270b[i11];
    }

    @Override // ba.i
    public int getEventTimeCount() {
        return this.f65270b.length;
    }

    @Override // ba.i
    public int getNextEventTimeIndex(long j11) {
        int e11 = p0.e(this.f65270b, j11, false, false);
        if (e11 < this.f65270b.length) {
            return e11;
        }
        return -1;
    }
}
