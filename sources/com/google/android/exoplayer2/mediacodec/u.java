package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.l;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class u implements l {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f25468a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer[] f25469b;

    /* renamed from: c, reason: collision with root package name */
    private ByteBuffer[] f25470c;

    /* loaded from: classes3.dex */
    public static class b implements l.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.mediacodec.u$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // com.google.android.exoplayer2.mediacodec.l.b
        public l a(l.a aVar) {
            MediaCodec b11;
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                b11 = b(aVar);
            } catch (IOException e11) {
                e = e11;
            } catch (RuntimeException e12) {
                e = e12;
            }
            try {
                m0.a("configureCodec");
                b11.configure(aVar.f25447b, aVar.f25449d, aVar.f25450e, aVar.f25451f);
                m0.c();
                m0.a("startCodec");
                b11.start();
                m0.c();
                return new u(b11);
            } catch (IOException | RuntimeException e13) {
                e = e13;
                mediaCodec = b11;
                if (mediaCodec != 0) {
                    mediaCodec.release();
                }
                throw e;
            }
        }

        protected MediaCodec b(l.a aVar) {
            com.google.android.exoplayer2.util.a.e(aVar.f25446a);
            String str = aVar.f25446a.f25452a;
            m0.a("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            m0.c();
            return createByCodecName;
        }
    }

    private u(MediaCodec mediaCodec) {
        this.f25468a = mediaCodec;
        if (p0.f27680a < 21) {
            this.f25469b = mediaCodec.getInputBuffers();
            this.f25470c = mediaCodec.getOutputBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(l.c cVar, MediaCodec mediaCodec, long j11, long j12) {
        cVar.a(this, j11, j12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f25468a.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void b(Bundle bundle) {
        this.f25468a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public MediaFormat c() {
        return this.f25468a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public ByteBuffer d(int i11) {
        return p0.f27680a >= 21 ? this.f25468a.getInputBuffer(i11) : ((ByteBuffer[]) p0.j(this.f25469b))[i11];
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void e(Surface surface) {
        this.f25468a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void f(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13) {
        this.f25468a.queueSecureInputBuffer(i11, i12, cVar.a(), j11, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void flush() {
        this.f25468a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public boolean g() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void h(int i11, long j11) {
        this.f25468a.releaseOutputBuffer(i11, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public int i() {
        return this.f25468a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public int j(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f25468a.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 && p0.f27680a < 21) {
                this.f25470c = this.f25468a.getOutputBuffers();
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void k(int i11, boolean z10) {
        this.f25468a.releaseOutputBuffer(i11, z10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public ByteBuffer l(int i11) {
        return p0.f27680a >= 21 ? this.f25468a.getOutputBuffer(i11) : ((ByteBuffer[]) p0.j(this.f25470c))[i11];
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void m(final l.c cVar, Handler handler) {
        this.f25468a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.google.android.exoplayer2.mediacodec.t
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                u.this.o(cVar, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void release() {
        this.f25469b = null;
        this.f25470c = null;
        this.f25468a.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.l
    public void setVideoScalingMode(int i11) {
        this.f25468a.setVideoScalingMode(i11);
    }
}
