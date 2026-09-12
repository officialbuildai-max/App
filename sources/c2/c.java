package c2;

import androidx.media3.exoplayer.offline.r;
import androidx.media3.exoplayer.upstream.q;
import java.util.List;

/* loaded from: classes2.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private final e f17064a;

    /* renamed from: b, reason: collision with root package name */
    private final List f17065b;

    public c(e eVar, List list) {
        this.f17064a = eVar;
        this.f17065b = list;
    }

    @Override // c2.e
    public q.a a() {
        return new r(this.f17064a.a(), this.f17065b);
    }

    @Override // c2.e
    public q.a b(androidx.media3.exoplayer.hls.playlist.d dVar, androidx.media3.exoplayer.hls.playlist.c cVar) {
        return new r(this.f17064a.b(dVar, cVar), this.f17065b);
    }
}
