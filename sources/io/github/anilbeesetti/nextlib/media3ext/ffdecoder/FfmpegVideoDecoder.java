package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.h;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class FfmpegVideoDecoder extends SimpleDecoder {

    /* renamed from: o, reason: collision with root package name */
    private final String f65409o;

    /* renamed from: p, reason: collision with root package name */
    private long f65410p;

    /* renamed from: q, reason: collision with root package name */
    private final byte[] f65411q;

    /* renamed from: r, reason: collision with root package name */
    private r f65412r;

    /* renamed from: s, reason: collision with root package name */
    private volatile int f65413s;

    public FfmpegVideoDecoder(int i11, int i12, int i13, int i14, r rVar) {
        super(new DecoderInputBuffer[i11], new VideoDecoderOutputBuffer[i12]);
        if (!FfmpegLibrary.d()) {
            throw new FfmpegDecoderException("Failed to load decoder native library.");
        }
        String str = (String) androidx.media3.common.util.a.e(FfmpegLibrary.a(rVar.f10243o));
        this.f65409o = str;
        byte[] x10 = x(rVar.f10243o, rVar.f10246r);
        this.f65411q = x10;
        this.f65412r = rVar;
        long ffmpegInitialize = ffmpegInitialize(str, x10, i14);
        this.f65410p = ffmpegInitialize;
        if (ffmpegInitialize == 0) {
            throw new FfmpegDecoderException("Failed to initialize decoder.");
        }
        s(i13);
    }

    private native long ffmpegInitialize(String str, @Nullable byte[] bArr, int i11);

    private native int ffmpegReceiveFrame(long j11, int i11, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z10);

    private native void ffmpegRelease(long j11);

    private native int ffmpegRenderFrame(long j11, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer, int i11, int i12);

    private native long ffmpegReset(long j11);

    private native int ffmpegSendPacket(long j11, ByteBuffer byteBuffer, int i11, long j12);

    private static byte[] x(String str, List list) {
        if (list.isEmpty()) {
            return null;
        }
        str.hashCode();
        if (str.equals(MimeTypes.VIDEO_H265)) {
            return (byte[]) list.get(0);
        }
        if (!str.equals(MimeTypes.VIDEO_H264)) {
            return null;
        }
        byte[] bArr = (byte[]) list.get(0);
        byte[] bArr2 = (byte[]) list.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public void A(int i11) {
        this.f65413s = i11;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    protected DecoderInputBuffer e() {
        return new DecoderInputBuffer(2);
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f65409o;
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.g
    public void release() {
        super.release();
        ffmpegRelease(this.f65410p);
        this.f65410p = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public VideoDecoderOutputBuffer f() {
        return new VideoDecoderOutputBuffer(new h.a() { // from class: io.github.anilbeesetti.nextlib.media3ext.ffdecoder.c
            @Override // androidx.media3.decoder.h.a
            public final void a(h hVar) {
                FfmpegVideoDecoder.this.p((VideoDecoderOutputBuffer) hVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException g(Throwable th2) {
        return new FfmpegDecoderException("Unexpected decode error", th2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException h(DecoderInputBuffer decoderInputBuffer, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z10) {
        if (z10) {
            long ffmpegReset = ffmpegReset(this.f65410p);
            this.f65410p = ffmpegReset;
            if (ffmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) a1.i(decoderInputBuffer.f11000c);
        int ffmpegSendPacket = ffmpegSendPacket(this.f65410p, byteBuffer, byteBuffer.limit(), decoderInputBuffer.f11002e);
        if (ffmpegSendPacket == -1) {
            videoDecoderOutputBuffer.shouldBeSkipped = true;
            return null;
        }
        if (ffmpegSendPacket == -3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VIDEO_DECODER_ERROR_READ_FRAME: timeUs=");
            sb2.append(decoderInputBuffer.f11002e);
        } else if (ffmpegSendPacket == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        boolean l11 = l(decoderInputBuffer.f11002e);
        int ffmpegReceiveFrame = ffmpegReceiveFrame(this.f65410p, this.f65413s, videoDecoderOutputBuffer, !l11);
        if (ffmpegReceiveFrame == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        if (ffmpegReceiveFrame == -1) {
            videoDecoderOutputBuffer.shouldBeSkipped = true;
        }
        if (l11) {
            videoDecoderOutputBuffer.format = decoderInputBuffer.f10998a;
        }
        return null;
    }

    public void z(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) {
        if (videoDecoderOutputBuffer.mode != 1) {
            throw new FfmpegDecoderException("Invalid output mode.");
        }
        if (ffmpegRenderFrame(this.f65410p, surface, videoDecoderOutputBuffer, videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height) == -2) {
            throw new FfmpegDecoderException("Buffer render error: ");
        }
    }
}
