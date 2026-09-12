package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public abstract class v implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    protected AudioProcessor.a f24830b;

    /* renamed from: c, reason: collision with root package name */
    protected AudioProcessor.a f24831c;

    /* renamed from: d, reason: collision with root package name */
    private AudioProcessor.a f24832d;

    /* renamed from: e, reason: collision with root package name */
    private AudioProcessor.a f24833e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f24834f;

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer f24835g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f24836h;

    public v() {
        ByteBuffer byteBuffer = AudioProcessor.f24583a;
        this.f24834f = byteBuffer;
        this.f24835g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f24584e;
        this.f24832d = aVar;
        this.f24833e = aVar;
        this.f24830b = aVar;
        this.f24831c = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.a a(AudioProcessor.a aVar) {
        this.f24832d = aVar;
        this.f24833e = c(aVar);
        return isActive() ? this.f24833e : AudioProcessor.a.f24584e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.f24835g.hasRemaining();
    }

    protected AudioProcessor.a c(AudioProcessor.a aVar) {
        return AudioProcessor.a.f24584e;
    }

    protected void d() {
    }

    protected void e() {
    }

    protected void f() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.f24835g = AudioProcessor.f24583a;
        this.f24836h = false;
        this.f24830b = this.f24832d;
        this.f24831c = this.f24833e;
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuffer g(int i11) {
        if (this.f24834f.capacity() < i11) {
            this.f24834f = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        } else {
            this.f24834f.clear();
        }
        ByteBuffer byteBuffer = this.f24834f;
        this.f24835g = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f24835g;
        this.f24835g = AudioProcessor.f24583a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f24833e != AudioProcessor.a.f24584e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.f24836h && this.f24835g == AudioProcessor.f24583a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.f24836h = true;
        e();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f24834f = AudioProcessor.f24583a;
        AudioProcessor.a aVar = AudioProcessor.a.f24584e;
        this.f24832d = aVar;
        this.f24833e = aVar;
        this.f24830b = aVar;
        this.f24831c = aVar;
        f();
    }
}
