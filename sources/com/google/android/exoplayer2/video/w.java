package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.video.w;

/* loaded from: classes3.dex */
public interface w {

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f28059a;

        /* renamed from: b, reason: collision with root package name */
        private final w f28060b;

        public a(Handler handler, w wVar) {
            this.f28059a = wVar != null ? (Handler) com.google.android.exoplayer2.util.a.e(handler) : null;
            this.f28060b = wVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j11, long j12) {
            ((w) p0.j(this.f28060b)).onVideoDecoderInitialized(str, j11, j12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((w) p0.j(this.f28060b)).b(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(com.google.android.exoplayer2.decoder.e eVar) {
            eVar.c();
            ((w) p0.j(this.f28060b)).n(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i11, long j11) {
            ((w) p0.j(this.f28060b)).onDroppedFrames(i11, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(com.google.android.exoplayer2.decoder.e eVar) {
            ((w) p0.j(this.f28060b)).v(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(o1 o1Var, com.google.android.exoplayer2.decoder.g gVar) {
            ((w) p0.j(this.f28060b)).w(o1Var);
            ((w) p0.j(this.f28060b)).k(o1Var, gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j11) {
            ((w) p0.j(this.f28060b)).f(obj, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j11, int i11) {
            ((w) p0.j(this.f28060b)).i(j11, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((w) p0.j(this.f28060b)).e(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(y yVar) {
            ((w) p0.j(this.f28060b)).onVideoSizeChanged(yVar);
        }

        public void A(final Object obj) {
            if (this.f28059a != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f28059a.post(new Runnable() { // from class: com.google.android.exoplayer2.video.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.w(obj, elapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j11, final int i11) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.x(j11, i11);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.y(exc);
                    }
                });
            }
        }

        public void D(final y yVar) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.z(yVar);
                    }
                });
            }
        }

        public void k(final String str, final long j11, final long j12) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.q(str, j11, j12);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.r(str);
                    }
                });
            }
        }

        public void m(final com.google.android.exoplayer2.decoder.e eVar) {
            eVar.c();
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.s(eVar);
                    }
                });
            }
        }

        public void n(final int i11, final long j11) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.t(i11, j11);
                    }
                });
            }
        }

        public void o(final com.google.android.exoplayer2.decoder.e eVar) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.u(eVar);
                    }
                });
            }
        }

        public void p(final o1 o1Var, final com.google.android.exoplayer2.decoder.g gVar) {
            Handler handler = this.f28059a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.v(o1Var, gVar);
                    }
                });
            }
        }
    }

    void b(String str);

    void e(Exception exc);

    void f(Object obj, long j11);

    void i(long j11, int i11);

    void k(o1 o1Var, com.google.android.exoplayer2.decoder.g gVar);

    void n(com.google.android.exoplayer2.decoder.e eVar);

    void onDroppedFrames(int i11, long j11);

    void onVideoDecoderInitialized(String str, long j11, long j12);

    void onVideoSizeChanged(y yVar);

    void v(com.google.android.exoplayer2.decoder.e eVar);

    void w(o1 o1Var);
}
