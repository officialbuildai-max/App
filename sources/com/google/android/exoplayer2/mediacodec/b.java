package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.mediacodec.l;
import com.google.android.exoplayer2.util.m0;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements l {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f25393a;

    /* renamed from: b, reason: collision with root package name */
    private final g f25394b;

    /* renamed from: c, reason: collision with root package name */
    private final e f25395c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f25396d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25397e;

    /* renamed from: f, reason: collision with root package name */
    private int f25398f;

    /* renamed from: com.google.android.exoplayer2.mediacodec.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0368b implements l.b {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.common.base.q f25399a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.common.base.q f25400b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f25401c;

        public C0368b(final int i11, boolean z10) {
            this(new com.google.common.base.q() { // from class: com.google.android.exoplayer2.mediacodec.c
                @Override // com.google.common.base.q
                public final Object get() {
                    HandlerThread e11;
                    e11 = b.C0368b.e(i11);
                    return e11;
                }
            }, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.mediacodec.d
                @Override // com.google.common.base.q
                public final Object get() {
                    HandlerThread f11;
                    f11 = b.C0368b.f(i11);
                    return f11;
                }
            }, z10);
        }

        C0368b(com.google.common.base.q qVar, com.google.common.base.q qVar2, boolean z10) {
            this.f25399a = qVar;
            this.f25400b = qVar2;
            this.f25401c = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread e(int i11) {
            return new HandlerThread(b.r(i11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i11) {
            return new HandlerThread(b.s(i11));
        }

        @Override // com.google.android.exoplayer2.mediacodec.l.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a(l.a aVar) {
            MediaCodec mediaCodec;
            b bVar;
            String str = aVar.f25446a.f25452a;
            b bVar2 = null;
            try {
                m0.a("createCodec:" + str);
                mediaCodec = MediaCodec.createByCodecName(str);
                try {
                    bVar = new b(mediaCodec, (HandlerThread) this.f25399a.get(), (HandlerThread) this.f25400b.get(), this.f25401c);
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                e = e12;
                mediaCodec = null;
            }
            try {
                m0.c();
                bVar.u(aVar.f25447b, aVar.f25449d, aVar.f25450e, aVar.f25451f);
                return bVar;
            } catch (Exception e13) {
                e = e13;
                bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.release();
                } else if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        }
    }

    private b(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z10) {
        this.f25393a = mediaCodec;
        this.f25394b = new g(handlerThread);
        this.f25395c = new e(mediaCodec, handlerThread2);
        this.f25396d = z10;
        this.f25398f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String r(int i11) {
        return t(i11, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(int i11) {
        return t(i11, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String t(int i11, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i11 == 1) {
            sb2.append("Audio");
        } else if (i11 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i11);
            sb2.append(")");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        this.f25394b.h(this.f25393a);
        m0.a("configureCodec");
        this.f25393a.configure(mediaFormat, surface, mediaCrypto, i11);
        m0.c();
        this.f25395c.q();
        m0.a("startCodec");
        this.f25393a.start();
        m0.c();
        this.f25398f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(l.c cVar, MediaCodec mediaCodec, long j11, long j12) {
        cVar.a(this, j11, j12);
    }

    private void w() {
        if (this.f25396d) {
            try {
                this.f25395c.r();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f25395c.m(i11, i12, i13, j11, i14);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void b(Bundle bundle) {
        w();
        this.f25393a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public MediaFormat c() {
        return this.f25394b.g();
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public ByteBuffer d(int i11) {
        return this.f25393a.getInputBuffer(i11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void e(Surface surface) {
        w();
        this.f25393a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void f(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13) {
        this.f25395c.n(i11, i12, cVar, j11, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void flush() {
        this.f25395c.i();
        this.f25393a.flush();
        this.f25394b.e();
        this.f25393a.start();
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public boolean g() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void h(int i11, long j11) {
        this.f25393a.releaseOutputBuffer(i11, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public int i() {
        return this.f25394b.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public int j(MediaCodec.BufferInfo bufferInfo) {
        return this.f25394b.d(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void k(int i11, boolean z10) {
        this.f25393a.releaseOutputBuffer(i11, z10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public ByteBuffer l(int i11) {
        return this.f25393a.getOutputBuffer(i11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void m(final l.c cVar, Handler handler) {
        w();
        this.f25393a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.google.android.exoplayer2.mediacodec.a
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                b.this.v(cVar, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void release() {
        try {
            if (this.f25398f == 1) {
                this.f25395c.p();
                this.f25394b.o();
            }
            this.f25398f = 2;
            if (this.f25397e) {
                return;
            }
            this.f25393a.release();
            this.f25397e = true;
        } catch (Throwable th2) {
            if (!this.f25397e) {
                this.f25393a.release();
                this.f25397e = true;
            }
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void setVideoScalingMode(int i11) {
        w();
        this.f25393a.setVideoScalingMode(i11);
    }
}
