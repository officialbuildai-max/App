package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public abstract class b implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    protected AudioProcessor.a f9909b;

    /* renamed from: c, reason: collision with root package name */
    protected AudioProcessor.a f9910c;

    /* renamed from: d, reason: collision with root package name */
    private AudioProcessor.a f9911d;

    /* renamed from: e, reason: collision with root package name */
    private AudioProcessor.a f9912e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f9913f;

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer f9914g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9915h;

    public b() {
        ByteBuffer byteBuffer = AudioProcessor.f9897a;
        this.f9913f = byteBuffer;
        this.f9914g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f9911d = aVar;
        this.f9912e = aVar;
        this.f9909b = aVar;
        this.f9910c = aVar;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.a a(AudioProcessor.a aVar) {
        this.f9911d = aVar;
        this.f9912e = c(aVar);
        return isActive() ? this.f9912e : AudioProcessor.a.f9898e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.f9914g.hasRemaining();
    }

    protected AudioProcessor.a c(AudioProcessor.a aVar) {
        return AudioProcessor.a.f9898e;
    }

    protected void d() {
    }

    protected void e() {
    }

    protected void f() {
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        this.f9914g = AudioProcessor.f9897a;
        this.f9915h = false;
        this.f9909b = this.f9911d;
        this.f9910c = this.f9912e;
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuffer g(int i11) {
        if (this.f9913f.capacity() < i11) {
            this.f9913f = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        } else {
            this.f9913f.clear();
        }
        ByteBuffer byteBuffer = this.f9913f;
        this.f9914g = byteBuffer;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f9914g;
        this.f9914g = AudioProcessor.f9897a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f9912e != AudioProcessor.a.f9898e;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        return this.f9915h && this.f9914g == AudioProcessor.f9897a;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.f9915h = true;
        e();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f9913f = AudioProcessor.f9897a;
        AudioProcessor.a aVar = AudioProcessor.a.f9898e;
        this.f9911d = aVar;
        this.f9912e = aVar;
        this.f9909b = aVar;
        this.f9910c = aVar;
        f();
    }
}
