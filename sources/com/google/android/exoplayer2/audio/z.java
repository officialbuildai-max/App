package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class z extends v {

    /* renamed from: i, reason: collision with root package name */
    private static final int f24854i = Float.floatToIntBits(Float.NaN);

    private static void h(int i11, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i11 * 4.656612875245797E-10d));
        if (floatToIntBits == f24854i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.android.exoplayer2.audio.v
    public AudioProcessor.a c(AudioProcessor.a aVar) {
        int i11 = aVar.f24587c;
        if (p0.t0(i11)) {
            return i11 != 4 ? new AudioProcessor.a(aVar.f24585a, aVar.f24586b, 4) : AudioProcessor.a.f24584e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        ByteBuffer g11;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        int i12 = this.f24830b.f24587c;
        if (i12 == 536870912) {
            g11 = g((i11 / 3) * 4);
            while (position < limit) {
                h(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), g11);
                position += 3;
            }
        } else {
            if (i12 != 805306368) {
                throw new IllegalStateException();
            }
            g11 = g(i11);
            while (position < limit) {
                h((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), g11);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        g11.flip();
    }
}
