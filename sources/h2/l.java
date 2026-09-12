package h2;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import h2.f;

/* loaded from: classes2.dex */
public final class l extends e {

    /* renamed from: j, reason: collision with root package name */
    private final f f64468j;

    /* renamed from: k, reason: collision with root package name */
    private f.b f64469k;

    /* renamed from: l, reason: collision with root package name */
    private l2.h f64470l;

    /* renamed from: m, reason: collision with root package name */
    private long f64471m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f64472n;

    public l(androidx.media3.datasource.a aVar, w1.h hVar, r rVar, int i11, Object obj, f fVar) {
        super(aVar, hVar, 2, rVar, i11, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.f64468j = fVar;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void cancelLoad() {
        this.f64472n = true;
    }

    public void e(f.b bVar) {
        this.f64469k = bVar;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void load() {
        if (this.f64471m == 0) {
            this.f64468j.d(this.f64469k, C.TIME_UNSET, C.TIME_UNSET);
        }
        try {
            w1.h e11 = this.f64420b.e(this.f64471m);
            w1.l lVar = this.f64427i;
            l2.j jVar = new l2.j(lVar, e11.f77640g, lVar.a(e11));
            while (!this.f64472n && this.f64468j.a(jVar)) {
                try {
                } finally {
                    this.f64471m = jVar.getPosition() - this.f64420b.f77640g;
                    this.f64470l = this.f64468j.b();
                }
            }
        } finally {
            w1.g.a(this.f64427i);
        }
    }
}
