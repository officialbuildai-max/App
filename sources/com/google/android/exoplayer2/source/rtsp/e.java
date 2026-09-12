package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import com.google.android.exoplayer2.source.rtsp.c;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Loader.d {

    /* renamed from: a, reason: collision with root package name */
    public final int f26397a;

    /* renamed from: b, reason: collision with root package name */
    public final t f26398b;

    /* renamed from: c, reason: collision with root package name */
    private final a f26399c;

    /* renamed from: d, reason: collision with root package name */
    private final g9.n f26400d;

    /* renamed from: f, reason: collision with root package name */
    private final c.a f26402f;

    /* renamed from: g, reason: collision with root package name */
    private f f26403g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f26404h;

    /* renamed from: j, reason: collision with root package name */
    private volatile long f26406j;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f26401e = p0.w();

    /* renamed from: i, reason: collision with root package name */
    private volatile long f26405i = C.TIME_UNSET;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, c cVar);
    }

    public e(int i11, t tVar, a aVar, g9.n nVar, c.a aVar2) {
        this.f26397a = i11;
        this.f26398b = tVar;
        this.f26399c = aVar;
        this.f26400d = nVar;
        this.f26402f = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, c cVar) {
        this.f26399c.a(str, cVar);
    }

    public void c() {
        ((f) com.google.android.exoplayer2.util.a.e(this.f26403g)).f();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
        this.f26404h = true;
    }

    public void d(long j11, long j12) {
        this.f26405i = j11;
        this.f26406j = j12;
    }

    public void e(int i11) {
        if (((f) com.google.android.exoplayer2.util.a.e(this.f26403g)).e()) {
            return;
        }
        this.f26403g.g(i11);
    }

    public void f(long j11) {
        if (j11 == C.TIME_UNSET || ((f) com.google.android.exoplayer2.util.a.e(this.f26403g)).e()) {
            return;
        }
        this.f26403g.h(j11);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() {
        final c cVar = null;
        try {
            cVar = this.f26402f.a(this.f26397a);
            final String c11 = cVar.c();
            this.f26401e.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.b(c11, cVar);
                }
            });
            g9.f fVar = new g9.f((com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.e(cVar), 0L, -1L);
            f fVar2 = new f(this.f26398b.f26540a, this.f26397a);
            this.f26403g = fVar2;
            fVar2.b(this.f26400d);
            while (!this.f26404h) {
                if (this.f26405i != C.TIME_UNSET) {
                    this.f26403g.seek(this.f26406j, this.f26405i);
                    this.f26405i = C.TIME_UNSET;
                }
                if (this.f26403g.c(fVar, new g9.a0()) == -1) {
                    break;
                }
            }
            com.google.android.exoplayer2.upstream.m.a(cVar);
        } catch (Throwable th2) {
            com.google.android.exoplayer2.upstream.m.a(cVar);
            throw th2;
        }
    }
}
