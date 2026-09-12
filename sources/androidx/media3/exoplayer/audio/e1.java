package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class e1 extends androidx.media3.common.audio.b {

    /* renamed from: i, reason: collision with root package name */
    private static final int f11253i = Float.floatToIntBits(Float.NaN);

    private static void h(int i11, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i11 * 4.656612875245797E-10d));
        if (floatToIntBits == f11253i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // androidx.media3.common.audio.b
    public AudioProcessor.a c(AudioProcessor.a aVar) {
        int i11 = aVar.f9901c;
        if (androidx.media3.common.util.a1.F0(i11)) {
            return i11 != 4 ? new AudioProcessor.a(aVar.f9899a, aVar.f9900b, 4) : AudioProcessor.a.f9898e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        ByteBuffer g11;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        int i12 = this.f9909b.f9901c;
        if (i12 == 21) {
            g11 = g((i11 / 3) * 4);
            while (position < limit) {
                h(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), g11);
                position += 3;
            }
        } else if (i12 == 22) {
            g11 = g(i11);
            while (position < limit) {
                h((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), g11);
                position += 4;
            }
        } else if (i12 == 1342177280) {
            g11 = g((i11 / 3) * 4);
            while (position < limit) {
                h(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), g11);
                position += 3;
            }
        } else {
            if (i12 != 1610612736) {
                throw new IllegalStateException();
            }
            g11 = g(i11);
            while (position < limit) {
                h((byteBuffer.get(position + 3) & 255) | ((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), g11);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        g11.flip();
    }
}
