package androidx.media3.exoplayer.mediacodec;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class j extends DecoderInputBuffer {

    /* renamed from: i, reason: collision with root package name */
    private long f12310i;

    /* renamed from: j, reason: collision with root package name */
    private int f12311j;

    /* renamed from: k, reason: collision with root package name */
    private int f12312k;

    public j() {
        super(2);
        this.f12312k = 32;
    }

    private boolean i(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!m()) {
            return true;
        }
        if (this.f12311j >= this.f12312k) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f11000c;
        return byteBuffer2 == null || (byteBuffer = this.f11000c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    @Override // androidx.media3.decoder.DecoderInputBuffer, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        this.f12311j = 0;
    }

    public boolean h(DecoderInputBuffer decoderInputBuffer) {
        androidx.media3.common.util.a.a(!decoderInputBuffer.e());
        androidx.media3.common.util.a.a(!decoderInputBuffer.hasSupplementalData());
        androidx.media3.common.util.a.a(!decoderInputBuffer.isEndOfStream());
        if (!i(decoderInputBuffer)) {
            return false;
        }
        int i11 = this.f12311j;
        this.f12311j = i11 + 1;
        if (i11 == 0) {
            this.f11002e = decoderInputBuffer.f11002e;
            if (decoderInputBuffer.isKeyFrame()) {
                setFlags(1);
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f11000c;
        if (byteBuffer != null) {
            b(byteBuffer.remaining());
            this.f11000c.put(byteBuffer);
        }
        this.f12310i = decoderInputBuffer.f11002e;
        return true;
    }

    public long j() {
        return this.f11002e;
    }

    public long k() {
        return this.f12310i;
    }

    public int l() {
        return this.f12311j;
    }

    public boolean m() {
        return this.f12311j > 0;
    }

    public void n(int i11) {
        androidx.media3.common.util.a.a(i11 > 0);
        this.f12312k = i11;
    }
}
