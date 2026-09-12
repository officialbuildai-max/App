package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class c0 extends androidx.media3.common.audio.b {

    /* renamed from: i, reason: collision with root package name */
    private int[] f11218i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f11219j;

    @Override // androidx.media3.common.audio.b
    public AudioProcessor.a c(AudioProcessor.a aVar) {
        int[] iArr = this.f11218i;
        if (iArr == null) {
            return AudioProcessor.a.f9898e;
        }
        int i11 = aVar.f9901c;
        if (i11 != 2 && i11 != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z10 = aVar.f9900b != iArr.length;
        int i12 = 0;
        while (i12 < iArr.length) {
            int i13 = iArr[i12];
            if (i13 >= aVar.f9900b) {
                throw new AudioProcessor.UnhandledAudioFormatException("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", aVar);
            }
            z10 |= i13 != i12;
            i12++;
        }
        return z10 ? new AudioProcessor.a(aVar.f9899a, iArr.length, aVar.f9901c) : AudioProcessor.a.f9898e;
    }

    @Override // androidx.media3.common.audio.b
    protected void d() {
        this.f11219j = this.f11218i;
    }

    @Override // androidx.media3.common.audio.b
    protected void f() {
        this.f11219j = null;
        this.f11218i = null;
    }

    public void h(int[] iArr) {
        this.f11218i = iArr;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) androidx.media3.common.util.a.e(this.f11219j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer g11 = g(((limit - position) / this.f9909b.f9902d) * this.f9910c.f9902d);
        while (position < limit) {
            for (int i11 : iArr) {
                int Q = (androidx.media3.common.util.a1.Q(this.f9909b.f9901c) * i11) + position;
                int i12 = this.f9909b.f9901c;
                if (i12 == 2) {
                    g11.putShort(byteBuffer.getShort(Q));
                } else {
                    if (i12 != 4) {
                        throw new IllegalStateException("Unexpected encoding: " + this.f9909b.f9901c);
                    }
                    g11.putFloat(byteBuffer.getFloat(Q));
                }
            }
            position += this.f9909b.f9902d;
        }
        byteBuffer.position(limit);
        g11.flip();
    }
}
