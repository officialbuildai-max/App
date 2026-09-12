package androidx.media3.exoplayer.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.m0;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.video.i0;

/* loaded from: classes2.dex */
public interface i0 {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f13217a;

        /* renamed from: b, reason: collision with root package name */
        private final i0 f13218b;

        public a(Handler handler, i0 i0Var) {
            this.f13217a = i0Var != null ? (Handler) androidx.media3.common.util.a.e(handler) : null;
            this.f13218b = i0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j11, long j12) {
            ((i0) a1.i(this.f13218b)).onVideoDecoderInitialized(str, j11, j12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((i0) a1.i(this.f13218b)).b(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(androidx.media3.exoplayer.j jVar) {
            jVar.c();
            ((i0) a1.i(this.f13218b)).v(jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i11, long j11) {
            ((i0) a1.i(this.f13218b)).onDroppedFrames(i11, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(androidx.media3.exoplayer.j jVar) {
            ((i0) a1.i(this.f13218b)).o(jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar) {
            ((i0) a1.i(this.f13218b)).u(rVar, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j11) {
            ((i0) a1.i(this.f13218b)).f(obj, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j11, int i11) {
            ((i0) a1.i(this.f13218b)).i(j11, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((i0) a1.i(this.f13218b)).e(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(m0 m0Var) {
            ((i0) a1.i(this.f13218b)).onVideoSizeChanged(m0Var);
        }

        public void A(final Object obj) {
            if (this.f13217a != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f13217a.post(new Runnable() { // from class: androidx.media3.exoplayer.video.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.w(obj, elapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j11, final int i11) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.x(j11, i11);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.y(exc);
                    }
                });
            }
        }

        public void D(final m0 m0Var) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.z(m0Var);
                    }
                });
            }
        }

        public void k(final String str, final long j11, final long j12) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.q(str, j11, j12);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.r(str);
                    }
                });
            }
        }

        public void m(final androidx.media3.exoplayer.j jVar) {
            jVar.c();
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.s(jVar);
                    }
                });
            }
        }

        public void n(final int i11, final long j11) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.t(i11, j11);
                    }
                });
            }
        }

        public void o(final androidx.media3.exoplayer.j jVar) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.u(jVar);
                    }
                });
            }
        }

        public void p(final androidx.media3.common.r rVar, final androidx.media3.exoplayer.k kVar) {
            Handler handler = this.f13217a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i0.a.this.v(rVar, kVar);
                    }
                });
            }
        }
    }

    void b(String str);

    void e(Exception exc);

    void f(Object obj, long j11);

    void i(long j11, int i11);

    void o(androidx.media3.exoplayer.j jVar);

    void onDroppedFrames(int i11, long j11);

    void onVideoDecoderInitialized(String str, long j11, long j12);

    void onVideoSizeChanged(m0 m0Var);

    void u(androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar);

    void v(androidx.media3.exoplayer.j jVar);
}
