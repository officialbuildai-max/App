package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class w extends v {

    /* renamed from: i, reason: collision with root package name */
    private int[] f24837i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f24838j;

    @Override // com.google.android.exoplayer2.audio.v
    public AudioProcessor.a c(AudioProcessor.a aVar) {
        int[] iArr = this.f24837i;
        if (iArr == null) {
            return AudioProcessor.a.f24584e;
        }
        if (aVar.f24587c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z10 = aVar.f24586b != iArr.length;
        int i11 = 0;
        while (i11 < iArr.length) {
            int i12 = iArr[i11];
            if (i12 >= aVar.f24586b) {
                throw new AudioProcessor.UnhandledAudioFormatException(aVar);
            }
            z10 |= i12 != i11;
            i11++;
        }
        return z10 ? new AudioProcessor.a(aVar.f24585a, iArr.length, 2) : AudioProcessor.a.f24584e;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void d() {
        this.f24838j = this.f24837i;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void f() {
        this.f24838j = null;
        this.f24837i = null;
    }

    public void h(int[] iArr) {
        this.f24837i = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) com.google.android.exoplayer2.util.a.e(this.f24838j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer g11 = g(((limit - position) / this.f24830b.f24588d) * this.f24831c.f24588d);
        while (position < limit) {
            for (int i11 : iArr) {
                g11.putShort(byteBuffer.getShort((i11 * 2) + position));
            }
            position += this.f24830b.f24588d;
        }
        byteBuffer.position(limit);
        g11.flip();
    }
}
