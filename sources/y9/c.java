package y9;

import com.google.android.exoplayer2.upstream.b0;
import java.util.List;

/* loaded from: classes4.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private final e f79071a;

    /* renamed from: b, reason: collision with root package name */
    private final List f79072b;

    public c(e eVar, List list) {
        this.f79071a = eVar;
        this.f79072b = list;
    }

    @Override // y9.e
    public b0.a a() {
        return new com.google.android.exoplayer2.offline.d(this.f79071a.a(), this.f79072b);
    }

    @Override // y9.e
    public b0.a b(com.google.android.exoplayer2.source.hls.playlist.e eVar, com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        return new com.google.android.exoplayer2.offline.d(this.f79071a.b(eVar, dVar), this.f79072b);
    }
}
