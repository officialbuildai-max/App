package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.mediacodec.c;
import androidx.media3.exoplayer.mediacodec.t;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements t {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f12265a;

    /* renamed from: b, reason: collision with root package name */
    private final i f12266b;

    /* renamed from: c, reason: collision with root package name */
    private final v f12267c;

    /* renamed from: d, reason: collision with root package name */
    private final p f12268d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12269e;

    /* renamed from: f, reason: collision with root package name */
    private int f12270f;

    /* loaded from: classes2.dex */
    public static final class b implements t.b {

        /* renamed from: b, reason: collision with root package name */
        private final com.google.common.base.q f12271b;

        /* renamed from: c, reason: collision with root package name */
        private final com.google.common.base.q f12272c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f12273d;

        public b(final int i11) {
            this(new com.google.common.base.q() { // from class: androidx.media3.exoplayer.mediacodec.d
                @Override // com.google.common.base.q
                public final Object get() {
                    HandlerThread f11;
                    f11 = c.b.f(i11);
                    return f11;
                }
            }, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.mediacodec.e
                @Override // com.google.common.base.q
                public final Object get() {
                    HandlerThread g11;
                    g11 = c.b.g(i11);
                    return g11;
                }
            });
        }

        public b(com.google.common.base.q qVar, com.google.common.base.q qVar2) {
            this.f12271b = qVar;
            this.f12272c = qVar2;
            this.f12273d = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i11) {
            return new HandlerThread(c.t(i11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread g(int i11) {
            return new HandlerThread(c.u(i11));
        }

        private static boolean h(androidx.media3.common.r rVar) {
            int i11 = a1.f10432a;
            if (i11 < 34) {
                return false;
            }
            return i11 >= 35 || androidx.media3.common.y.t(rVar.f10243o);
        }

        @Override // androidx.media3.exoplayer.mediacodec.t.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public c a(t.a aVar) {
            MediaCodec mediaCodec;
            v gVar;
            int i11;
            String str = aVar.f12330a.f12337a;
            c cVar = null;
            try {
                androidx.media3.common.util.q0.a("createCodec:" + str);
                mediaCodec = MediaCodec.createByCodecName(str);
                try {
                    if (this.f12273d && h(aVar.f12332c)) {
                        gVar = new s0(mediaCodec);
                        i11 = 4;
                    } else {
                        gVar = new g(mediaCodec, (HandlerThread) this.f12272c.get());
                        i11 = 0;
                    }
                    v vVar = gVar;
                    int i12 = i11;
                    c cVar2 = new c(mediaCodec, (HandlerThread) this.f12271b.get(), vVar, aVar.f12335f);
                    try {
                        androidx.media3.common.util.q0.b();
                        Surface surface = aVar.f12333d;
                        if (surface == null && aVar.f12330a.f12347k && a1.f10432a >= 35) {
                            i12 |= 8;
                        }
                        cVar2.w(aVar.f12331b, surface, aVar.f12334e, i12);
                        return cVar2;
                    } catch (Exception e11) {
                        e = e11;
                        cVar = cVar2;
                        if (cVar != null) {
                            cVar.release();
                        } else if (mediaCodec != null) {
                            mediaCodec.release();
                        }
                        throw e;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
                mediaCodec = null;
            }
        }

        public void e(boolean z10) {
            this.f12273d = z10;
        }
    }

    private c(MediaCodec mediaCodec, HandlerThread handlerThread, v vVar, p pVar) {
        this.f12265a = mediaCodec;
        this.f12266b = new i(handlerThread);
        this.f12267c = vVar;
        this.f12268d = pVar;
        this.f12270f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(int i11) {
        return v(i11, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(int i11) {
        return v(i11, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String v(int i11, String str) {
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
    public void w(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        p pVar;
        this.f12266b.h(this.f12265a);
        androidx.media3.common.util.q0.a("configureCodec");
        this.f12265a.configure(mediaFormat, surface, mediaCrypto, i11);
        androidx.media3.common.util.q0.b();
        this.f12267c.start();
        androidx.media3.common.util.q0.a("startCodec");
        this.f12265a.start();
        androidx.media3.common.util.q0.b();
        if (a1.f10432a >= 35 && (pVar = this.f12268d) != null) {
            pVar.b(this.f12265a);
        }
        this.f12270f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(t.d dVar, MediaCodec mediaCodec, long j11, long j12) {
        dVar.a(this, j11, j12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f12267c.a(i11, i12, i13, j11, i14);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void b(Bundle bundle) {
        this.f12267c.b(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public MediaFormat c() {
        return this.f12266b.g();
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public ByteBuffer d(int i11) {
        return this.f12265a.getInputBuffer(i11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void e(Surface surface) {
        this.f12265a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        this.f12267c.f(i11, i12, cVar, j11, i13);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void flush() {
        this.f12267c.flush();
        this.f12265a.flush();
        this.f12266b.e();
        this.f12265a.start();
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public boolean g() {
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void h(int i11, long j11) {
        this.f12265a.releaseOutputBuffer(i11, j11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public int i() {
        this.f12267c.c();
        return this.f12266b.c();
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public int j(MediaCodec.BufferInfo bufferInfo) {
        this.f12267c.c();
        return this.f12266b.d(bufferInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void k(int i11, boolean z10) {
        this.f12265a.releaseOutputBuffer(i11, z10);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public ByteBuffer l(int i11) {
        return this.f12265a.getOutputBuffer(i11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public boolean m(t.c cVar) {
        this.f12266b.p(cVar);
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void n(final t.d dVar, Handler handler) {
        this.f12265a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: androidx.media3.exoplayer.mediacodec.b
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                c.this.x(dVar, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void o() {
        this.f12265a.detachOutputSurface();
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void release() {
        p pVar;
        p pVar2;
        try {
            if (this.f12270f == 1) {
                this.f12267c.shutdown();
                this.f12266b.q();
            }
            this.f12270f = 2;
            if (this.f12269e) {
                return;
            }
            try {
                int i11 = a1.f10432a;
                if (i11 >= 30 && i11 < 33) {
                    this.f12265a.stop();
                }
                if (i11 >= 35 && (pVar2 = this.f12268d) != null) {
                    pVar2.d(this.f12265a);
                }
                this.f12265a.release();
                this.f12269e = true;
            } finally {
            }
        } catch (Throwable th2) {
            if (!this.f12269e) {
                try {
                    int i12 = a1.f10432a;
                    if (i12 >= 30 && i12 < 33) {
                        this.f12265a.stop();
                    }
                    if (i12 >= 35 && (pVar = this.f12268d) != null) {
                        pVar.d(this.f12265a);
                    }
                    this.f12265a.release();
                    this.f12269e = true;
                } finally {
                }
            }
            throw th2;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void setVideoScalingMode(int i11) {
        this.f12265a.setVideoScalingMode(i11);
    }
}
