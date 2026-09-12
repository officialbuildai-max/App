package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f9903a;

    /* renamed from: b, reason: collision with root package name */
    private final List f9904b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private ByteBuffer[] f9905c = new ByteBuffer[0];

    /* renamed from: d, reason: collision with root package name */
    private AudioProcessor.a f9906d;

    /* renamed from: e, reason: collision with root package name */
    private AudioProcessor.a f9907e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9908f;

    public a(ImmutableList immutableList) {
        this.f9903a = immutableList;
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f9906d = aVar;
        this.f9907e = aVar;
        this.f9908f = false;
    }

    private int c() {
        return this.f9905c.length - 1;
    }

    private void g(ByteBuffer byteBuffer) {
        boolean z10;
        for (boolean z11 = true; z11; z11 = z10) {
            z10 = false;
            int i11 = 0;
            while (i11 <= c()) {
                if (!this.f9905c[i11].hasRemaining()) {
                    AudioProcessor audioProcessor = (AudioProcessor) this.f9904b.get(i11);
                    if (!audioProcessor.isEnded()) {
                        ByteBuffer byteBuffer2 = i11 > 0 ? this.f9905c[i11 - 1] : byteBuffer.hasRemaining() ? byteBuffer : AudioProcessor.f9897a;
                        long remaining = byteBuffer2.remaining();
                        audioProcessor.queueInput(byteBuffer2);
                        this.f9905c[i11] = audioProcessor.getOutput();
                        z10 |= remaining - ((long) byteBuffer2.remaining()) > 0 || this.f9905c[i11].hasRemaining();
                    } else if (!this.f9905c[i11].hasRemaining() && i11 < c()) {
                        ((AudioProcessor) this.f9904b.get(i11 + 1)).queueEndOfStream();
                    }
                }
                i11++;
            }
        }
    }

    public AudioProcessor.a a(AudioProcessor.a aVar) {
        if (aVar.equals(AudioProcessor.a.f9898e)) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        for (int i11 = 0; i11 < this.f9903a.size(); i11++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f9903a.get(i11);
            AudioProcessor.a a11 = audioProcessor.a(aVar);
            if (audioProcessor.isActive()) {
                androidx.media3.common.util.a.g(!a11.equals(AudioProcessor.a.f9898e));
                aVar = a11;
            }
        }
        this.f9907e = aVar;
        return aVar;
    }

    public void b() {
        this.f9904b.clear();
        this.f9906d = this.f9907e;
        this.f9908f = false;
        for (int i11 = 0; i11 < this.f9903a.size(); i11++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f9903a.get(i11);
            audioProcessor.flush();
            if (audioProcessor.isActive()) {
                this.f9904b.add(audioProcessor);
            }
        }
        this.f9905c = new ByteBuffer[this.f9904b.size()];
        for (int i12 = 0; i12 <= c(); i12++) {
            this.f9905c[i12] = ((AudioProcessor) this.f9904b.get(i12)).getOutput();
        }
    }

    public ByteBuffer d() {
        if (!f()) {
            return AudioProcessor.f9897a;
        }
        ByteBuffer byteBuffer = this.f9905c[c()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        g(AudioProcessor.f9897a);
        return this.f9905c[c()];
    }

    public boolean e() {
        return this.f9908f && ((AudioProcessor) this.f9904b.get(c())).isEnded() && !this.f9905c[c()].hasRemaining();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f9903a.size() != aVar.f9903a.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f9903a.size(); i11++) {
            if (this.f9903a.get(i11) != aVar.f9903a.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return !this.f9904b.isEmpty();
    }

    public void h() {
        if (!f() || this.f9908f) {
            return;
        }
        this.f9908f = true;
        ((AudioProcessor) this.f9904b.get(0)).queueEndOfStream();
    }

    public int hashCode() {
        return this.f9903a.hashCode();
    }

    public void i(ByteBuffer byteBuffer) {
        if (!f() || this.f9908f) {
            return;
        }
        g(byteBuffer);
    }

    public void j() {
        for (int i11 = 0; i11 < this.f9903a.size(); i11++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f9903a.get(i11);
            audioProcessor.flush();
            audioProcessor.reset();
        }
        this.f9905c = new ByteBuffer[0];
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f9906d = aVar;
        this.f9907e = aVar;
        this.f9908f = false;
    }
}
