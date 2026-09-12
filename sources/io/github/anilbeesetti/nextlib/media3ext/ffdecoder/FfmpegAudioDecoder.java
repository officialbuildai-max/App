package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import androidx.media3.decoder.h;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.http2.Settings;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"UnsafeOptInUsageError"})
/* loaded from: classes7.dex */
public final class FfmpegAudioDecoder extends SimpleDecoder {

    /* renamed from: o, reason: collision with root package name */
    private final String f65398o;

    /* renamed from: p, reason: collision with root package name */
    private final byte[] f65399p;

    /* renamed from: q, reason: collision with root package name */
    private final int f65400q;

    /* renamed from: r, reason: collision with root package name */
    private int f65401r;

    /* renamed from: s, reason: collision with root package name */
    private long f65402s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f65403t;

    /* renamed from: u, reason: collision with root package name */
    private volatile int f65404u;

    /* renamed from: v, reason: collision with root package name */
    private volatile int f65405v;

    public FfmpegAudioDecoder(r rVar, int i11, int i12, int i13, boolean z10) {
        super(new DecoderInputBuffer[i11], new SimpleDecoderOutputBuffer[i12]);
        if (!FfmpegLibrary.d()) {
            throw new FfmpegDecoderException("Failed to load decoder native libraries.");
        }
        androidx.media3.common.util.a.e(rVar.f10243o);
        String str = (String) androidx.media3.common.util.a.e(FfmpegLibrary.a(rVar.f10243o));
        this.f65398o = str;
        byte[] A = A(rVar.f10243o, rVar.f10246r);
        this.f65399p = A;
        this.f65400q = z10 ? 4 : 2;
        this.f65401r = z10 ? 131070 : Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        long ffmpegInitialize = ffmpegInitialize(str, A, z10, rVar.F, rVar.E);
        this.f65402s = ffmpegInitialize;
        if (ffmpegInitialize == 0) {
            throw new FfmpegDecoderException("Initialization failed.");
        }
        s(i13);
    }

    private static byte[] A(String str, List list) {
        if (list.isEmpty()) {
            return null;
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1003765268:
                if (str.equals(MimeTypes.AUDIO_VORBIS)) {
                    c11 = 0;
                    break;
                }
                break;
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1504470054:
                if (str.equals(MimeTypes.AUDIO_ALAC)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals(MimeTypes.AUDIO_OPUS)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return C(list);
            case 1:
            case 3:
                return (byte[]) list.get(0);
            case 2:
                return x(list);
            default:
                return null;
        }
    }

    private static byte[] C(List list) {
        byte[] bArr = (byte[]) list.get(0);
        byte[] bArr2 = (byte[]) list.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & 255);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }

    private native int ffmpegDecode(long j11, ByteBuffer byteBuffer, int i11, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, ByteBuffer byteBuffer2, int i12);

    private native int ffmpegGetChannelCount(long j11);

    private native int ffmpegGetSampleRate(long j11);

    private native long ffmpegInitialize(String str, @Nullable byte[] bArr, boolean z10, int i11, int i12);

    private native void ffmpegRelease(long j11);

    private native long ffmpegReset(long j11, @Nullable byte[] bArr);

    @Keep
    private ByteBuffer growOutputBuffer(SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, int i11) {
        this.f65401r = i11;
        return simpleDecoderOutputBuffer.a(i11);
    }

    private static byte[] x(List list) {
        byte[] bArr = (byte[]) list.get(0);
        int length = bArr.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1634492771);
        allocate.putInt(0);
        allocate.put(bArr, 0, bArr.length);
        return allocate.array();
    }

    public int B() {
        return this.f65405v;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    protected DecoderInputBuffer e() {
        return new DecoderInputBuffer(2, FfmpegLibrary.b());
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f65398o;
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.g
    public void release() {
        super.release();
        ffmpegRelease(this.f65402s);
        this.f65402s = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public SimpleDecoderOutputBuffer f() {
        return new SimpleDecoderOutputBuffer(new h.a() { // from class: io.github.anilbeesetti.nextlib.media3ext.ffdecoder.a
            @Override // androidx.media3.decoder.h.a
            public final void a(h hVar) {
                FfmpegAudioDecoder.this.p((SimpleDecoderOutputBuffer) hVar);
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
    public FfmpegDecoderException h(DecoderInputBuffer decoderInputBuffer, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, boolean z10) {
        if (z10) {
            long ffmpegReset = ffmpegReset(this.f65402s, this.f65399p);
            this.f65402s = ffmpegReset;
            if (ffmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) a1.i(decoderInputBuffer.f11000c);
        int ffmpegDecode = ffmpegDecode(this.f65402s, byteBuffer, byteBuffer.limit(), simpleDecoderOutputBuffer, simpleDecoderOutputBuffer.b(decoderInputBuffer.f11002e, this.f65401r), this.f65401r);
        if (ffmpegDecode == -2) {
            return new FfmpegDecoderException("Error decoding (see logcat).");
        }
        if (ffmpegDecode == -1) {
            simpleDecoderOutputBuffer.shouldBeSkipped = true;
            return null;
        }
        if (ffmpegDecode == 0) {
            simpleDecoderOutputBuffer.shouldBeSkipped = true;
            return null;
        }
        if (!this.f65403t) {
            this.f65404u = ffmpegGetChannelCount(this.f65402s);
            this.f65405v = ffmpegGetSampleRate(this.f65402s);
            if (this.f65405v == 0 && "alac".equals(this.f65398o)) {
                androidx.media3.common.util.a.e(this.f65399p);
                j0 j0Var = new j0(this.f65399p);
                j0Var.W(this.f65399p.length - 4);
                this.f65405v = j0Var.L();
            }
            this.f65403t = true;
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) androidx.media3.common.util.a.e(simpleDecoderOutputBuffer.f11021b);
        byteBuffer2.position(0);
        byteBuffer2.limit(ffmpegDecode);
        return null;
    }

    public int y() {
        return this.f65404u;
    }

    public int z() {
        return this.f65400q;
    }
}
