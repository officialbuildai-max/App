package o3;

import androidx.media3.common.util.a1;
import i3.k;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    private final c f70845a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f70846b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f70847c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f70848d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f70849e;

    public h(c cVar, Map map, Map map2, Map map3) {
        this.f70845a = cVar;
        this.f70848d = map2;
        this.f70849e = map3;
        this.f70847c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f70846b = cVar.j();
    }

    @Override // i3.k
    public List getCues(long j11) {
        return this.f70845a.h(j11, this.f70847c, this.f70848d, this.f70849e);
    }

    @Override // i3.k
    public long getEventTime(int i11) {
        return this.f70846b[i11];
    }

    @Override // i3.k
    public int getEventTimeCount() {
        return this.f70846b.length;
    }

    @Override // i3.k
    public int getNextEventTimeIndex(long j11) {
        int d11 = a1.d(this.f70846b, j11, false, false);
        if (d11 < this.f70846b.length) {
            return d11;
        }
        return -1;
    }
}
