package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.mediacodec.t;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class r0 implements t {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f12327a;

    /* renamed from: b, reason: collision with root package name */
    private final p f12328b;

    /* loaded from: classes2.dex */
    public static class b implements t.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.exoplayer.mediacodec.r0$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // androidx.media3.exoplayer.mediacodec.t.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.media3.exoplayer.mediacodec.t a(androidx.media3.exoplayer.mediacodec.t.a r7) {
            /*
                r6 = this;
                r0 = 0
                android.media.MediaCodec r1 = r6.b(r7)     // Catch: java.lang.RuntimeException -> L40 java.io.IOException -> L42
                java.lang.String r2 = "configureCodec"
                androidx.media3.common.util.q0.a(r2)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                android.view.Surface r2 = r7.f12333d     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                if (r2 != 0) goto L22
                androidx.media3.exoplayer.mediacodec.w r3 = r7.f12330a     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                boolean r3 = r3.f12347k     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                if (r3 == 0) goto L22
                int r3 = androidx.media3.common.util.a1.f10432a     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r4 = 35
                if (r3 < r4) goto L22
                r3 = 8
                goto L23
            L1d:
                r7 = move-exception
            L1e:
                r0 = r1
                goto L43
            L20:
                r7 = move-exception
                goto L1e
            L22:
                r3 = 0
            L23:
                android.media.MediaFormat r4 = r7.f12331b     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                android.media.MediaCrypto r5 = r7.f12334e     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r1.configure(r4, r2, r5, r3)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.common.util.q0.b()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                java.lang.String r2 = "startCodec"
                androidx.media3.common.util.q0.a(r2)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r1.start()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.common.util.q0.b()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.exoplayer.mediacodec.r0 r2 = new androidx.media3.exoplayer.mediacodec.r0     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.exoplayer.mediacodec.p r7 = r7.f12335f     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r2.<init>(r1, r7)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                return r2
            L40:
                r7 = move-exception
                goto L43
            L42:
                r7 = move-exception
            L43:
                if (r0 == 0) goto L48
                r0.release()
            L48:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.r0.b.a(androidx.media3.exoplayer.mediacodec.t$a):androidx.media3.exoplayer.mediacodec.t");
        }

        protected MediaCodec b(t.a aVar) {
            androidx.media3.common.util.a.e(aVar.f12330a);
            String str = aVar.f12330a.f12337a;
            androidx.media3.common.util.q0.a("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            androidx.media3.common.util.q0.b();
            return createByCodecName;
        }
    }

    private r0(MediaCodec mediaCodec, p pVar) {
        this.f12327a = mediaCodec;
        this.f12328b = pVar;
        if (a1.f10432a < 35 || pVar == null) {
            return;
        }
        pVar.b(mediaCodec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(t.d dVar, MediaCodec mediaCodec, long j11, long j12) {
        dVar.a(this, j11, j12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f12327a.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void b(Bundle bundle) {
        this.f12327a.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public MediaFormat c() {
        return this.f12327a.getOutputFormat();
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public ByteBuffer d(int i11) {
        return this.f12327a.getInputBuffer(i11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void e(Surface surface) {
        this.f12327a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        this.f12327a.queueSecureInputBuffer(i11, i12, cVar.a(), j11, i13);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void flush() {
        this.f12327a.flush();
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public boolean g() {
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void h(int i11, long j11) {
        this.f12327a.releaseOutputBuffer(i11, j11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public int i() {
        return this.f12327a.dequeueInputBuffer(0L);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public int j(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f12327a.dequeueOutputBuffer(bufferInfo, 0L);
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void k(int i11, boolean z10) {
        this.f12327a.releaseOutputBuffer(i11, z10);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public ByteBuffer l(int i11) {
        return this.f12327a.getOutputBuffer(i11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public /* synthetic */ boolean m(t.c cVar) {
        return s.a(this, cVar);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void n(final t.d dVar, Handler handler) {
        this.f12327a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: androidx.media3.exoplayer.mediacodec.q0
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                r0.this.q(dVar, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void o() {
        this.f12327a.detachOutputSurface();
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void release() {
        p pVar;
        p pVar2;
        try {
            int i11 = a1.f10432a;
            if (i11 >= 30 && i11 < 33) {
                this.f12327a.stop();
            }
            if (i11 >= 35 && (pVar2 = this.f12328b) != null) {
                pVar2.d(this.f12327a);
            }
            this.f12327a.release();
        } catch (Throwable th2) {
            if (a1.f10432a >= 35 && (pVar = this.f12328b) != null) {
                pVar.d(this.f12327a);
            }
            this.f12327a.release();
            throw th2;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.t
    public void setVideoScalingMode(int i11) {
        this.f12327a.setVideoScalingMode(i11);
    }
}
