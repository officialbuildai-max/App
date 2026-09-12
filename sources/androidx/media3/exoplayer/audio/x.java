package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.x;

/* loaded from: classes2.dex */
public interface x {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f11325a;

        /* renamed from: b, reason: collision with root package name */
        private final x f11326b;

        public a(Handler handler, x xVar) {
            this.f11325a = xVar != null ? (Handler) androidx.media3.common.util.a.e(handler) : null;
            this.f11326b = xVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(String str) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).c(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(androidx.media3.exoplayer.j jVar) {
            jVar.c();
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).t(jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C(androidx.media3.exoplayer.j jVar) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).n(jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).s(rVar, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E(long j11) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).d(j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F(boolean z10) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).onSkipSilenceEnabledChanged(z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void G(int i11, long j11, long j12) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).h(i11, j11, j12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(Exception exc) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).g(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Exception exc) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).a(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(AudioSink.a aVar) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).j(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(AudioSink.a aVar) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).k(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(String str, long j11, long j12) {
            ((x) androidx.media3.common.util.a1.i(this.f11326b)).onAudioDecoderInitialized(str, j11, j12);
        }

        public void H(final long j11) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.E(j11);
                    }
                });
            }
        }

        public void I(final boolean z10) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.F(z10);
                    }
                });
            }
        }

        public void J(final int i11, final long j11, final long j12) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.G(i11, j11, j12);
                    }
                });
            }
        }

        public void m(final Exception exc) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.v(exc);
                    }
                });
            }
        }

        public void n(final Exception exc) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.w(exc);
                    }
                });
            }
        }

        public void o(final AudioSink.a aVar) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.x(aVar);
                    }
                });
            }
        }

        public void p(final AudioSink.a aVar) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.y(aVar);
                    }
                });
            }
        }

        public void q(final String str, final long j11, final long j12) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.z(str, j11, j12);
                    }
                });
            }
        }

        public void r(final String str) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.A(str);
                    }
                });
            }
        }

        public void s(final androidx.media3.exoplayer.j jVar) {
            jVar.c();
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.B(jVar);
                    }
                });
            }
        }

        public void t(final androidx.media3.exoplayer.j jVar) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.C(jVar);
                    }
                });
            }
        }

        public void u(final androidx.media3.common.r rVar, final androidx.media3.exoplayer.k kVar) {
            Handler handler = this.f11325a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.D(rVar, kVar);
                    }
                });
            }
        }
    }

    void a(Exception exc);

    void c(String str);

    void d(long j11);

    void g(Exception exc);

    void h(int i11, long j11, long j12);

    void j(AudioSink.a aVar);

    void k(AudioSink.a aVar);

    void n(androidx.media3.exoplayer.j jVar);

    void onAudioDecoderInitialized(String str, long j11, long j12);

    void onSkipSilenceEnabledChanged(boolean z10);

    void s(androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar);

    void t(androidx.media3.exoplayer.j jVar);
}
