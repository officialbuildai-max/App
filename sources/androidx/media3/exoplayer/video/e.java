package androidx.media3.exoplayer.video;

import android.media.MediaFormat;
import android.view.Surface;
import androidx.media3.common.m0;
import androidx.media3.common.r;
import androidx.media3.common.util.l0;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.video.VideoSink;
import androidx.media3.exoplayer.video.e;
import androidx.media3.exoplayer.video.x;
import androidx.media3.exoplayer.w3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements VideoSink {

    /* renamed from: a, reason: collision with root package name */
    private final u f13176a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.i f13177b;

    /* renamed from: c, reason: collision with root package name */
    private final x f13178c;

    /* renamed from: d, reason: collision with root package name */
    private final Queue f13179d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f13180e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.media3.common.r f13181f;

    /* renamed from: g, reason: collision with root package name */
    private long f13182g;

    /* renamed from: h, reason: collision with root package name */
    private long f13183h;

    /* renamed from: i, reason: collision with root package name */
    private VideoSink.a f13184i;

    /* renamed from: j, reason: collision with root package name */
    private Executor f13185j;

    /* renamed from: k, reason: collision with root package name */
    private t f13186k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b implements x.a {

        /* renamed from: a, reason: collision with root package name */
        private androidx.media3.common.r f13187a;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            e.this.f13184i.c(e.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(m0 m0Var) {
            e.this.f13184i.b(e.this, m0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            e.this.f13184i.a(e.this);
        }

        @Override // androidx.media3.exoplayer.video.x.a
        public void a() {
            e.this.f13185j.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.g
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.this.f();
                }
            });
            ((VideoSink.b) e.this.f13179d.remove()).b();
        }

        @Override // androidx.media3.exoplayer.video.x.a
        public void b(long j11, long j12, boolean z10) {
            if (z10 && e.this.f13180e != null) {
                e.this.f13185j.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.this.h();
                    }
                });
            }
            androidx.media3.common.r rVar = this.f13187a;
            if (rVar == null) {
                rVar = new r.b().N();
            }
            e.this.f13186k.f(j12, e.this.f13177b.nanoTime(), rVar, null);
            ((VideoSink.b) e.this.f13179d.remove()).a(j11);
        }

        @Override // androidx.media3.exoplayer.video.x.a
        public void onVideoSizeChanged(final m0 m0Var) {
            this.f13187a = new r.b().B0(m0Var.f10197a).d0(m0Var.f10198b).u0("video/raw").N();
            e.this.f13185j.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.h
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.this.g(m0Var);
                }
            });
        }
    }

    public e(u uVar, androidx.media3.common.util.i iVar) {
        this.f13176a = uVar;
        uVar.o(iVar);
        this.f13177b = iVar;
        this.f13178c = new x(new b(), uVar);
        this.f13179d = new ArrayDeque();
        this.f13181f = new r.b().N();
        this.f13182g = C.TIME_UNSET;
        this.f13184i = VideoSink.a.f13155a;
        this.f13185j = new Executor() { // from class: androidx.media3.exoplayer.video.c
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                e.E(runnable);
            }
        };
        this.f13186k = new t() { // from class: androidx.media3.exoplayer.video.d
            @Override // androidx.media3.exoplayer.video.t
            public final void f(long j11, long j12, androidx.media3.common.r rVar, MediaFormat mediaFormat) {
                e.F(j11, j12, rVar, mediaFormat);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Runnable runnable) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(long j11, long j12, androidx.media3.common.r rVar, MediaFormat mediaFormat) {
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void a(float f11) {
        this.f13176a.r(f11);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean b(long j11, boolean z10, VideoSink.b bVar) {
        this.f13179d.add(bVar);
        this.f13178c.g(j11 - this.f13183h);
        return true;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void c() {
        this.f13176a.a();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void d(t tVar) {
        this.f13186k = tVar;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void e() {
        this.f13178c.l();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void f(long j11, long j12) {
        if (j11 != this.f13182g) {
            this.f13178c.h(j11);
            this.f13182g = j11;
        }
        this.f13183h = j12;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void g() {
        this.f13176a.l();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void h(w3.a aVar) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void i(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean isEnded() {
        return this.f13178c.d();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean isInitialized() {
        return true;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean j(boolean z10) {
        return this.f13176a.d(z10);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean k(androidx.media3.common.r rVar) {
        return true;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void l(boolean z10) {
        this.f13176a.h(z10);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public Surface m() {
        return (Surface) androidx.media3.common.util.a.i(this.f13180e);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void n() {
        this.f13176a.k();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void o(int i11, androidx.media3.common.r rVar, List list) {
        androidx.media3.common.util.a.g(list.isEmpty());
        int i12 = rVar.f10250v;
        androidx.media3.common.r rVar2 = this.f13181f;
        if (i12 != rVar2.f10250v || rVar.f10251w != rVar2.f10251w) {
            this.f13178c.i(i12, rVar.f10251w);
        }
        float f11 = rVar.f10252x;
        if (f11 != this.f13181f.f10252x) {
            this.f13176a.p(f11);
        }
        this.f13181f = rVar;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void p(Surface surface, l0 l0Var) {
        this.f13180e = surface;
        this.f13176a.q(surface);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void q() {
        this.f13176a.g();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void r(int i11) {
        this.f13176a.n(i11);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void release() {
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void render(long j11, long j12) {
        try {
            this.f13178c.j(j11, j12);
        } catch (ExoPlaybackException e11) {
            throw new VideoSink.VideoSinkException(e11, this.f13181f);
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void s() {
        this.f13180e = null;
        this.f13176a.q(null);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void t(boolean z10) {
        if (z10) {
            this.f13176a.m();
        }
        this.f13178c.b();
        this.f13179d.clear();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void u(boolean z10) {
        this.f13176a.e(z10);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void v(VideoSink.a aVar, Executor executor) {
        this.f13184i = aVar;
        this.f13185j = executor;
    }
}
