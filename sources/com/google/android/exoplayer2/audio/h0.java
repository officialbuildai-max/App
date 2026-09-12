package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class h0 extends v {

    /* renamed from: i, reason: collision with root package name */
    private int f24759i;

    /* renamed from: j, reason: collision with root package name */
    private int f24760j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f24761k;

    /* renamed from: l, reason: collision with root package name */
    private int f24762l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f24763m = p0.f27685f;

    /* renamed from: n, reason: collision with root package name */
    private int f24764n;

    /* renamed from: o, reason: collision with root package name */
    private long f24765o;

    @Override // com.google.android.exoplayer2.audio.v
    public AudioProcessor.a c(AudioProcessor.a aVar) {
        if (aVar.f24587c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.f24761k = true;
        return (this.f24759i == 0 && this.f24760j == 0) ? AudioProcessor.a.f24584e : aVar;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void d() {
        if (this.f24761k) {
            this.f24761k = false;
            int i11 = this.f24760j;
            int i12 = this.f24830b.f24588d;
            this.f24763m = new byte[i11 * i12];
            this.f24762l = this.f24759i * i12;
        }
        this.f24764n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void e() {
        if (this.f24761k) {
            if (this.f24764n > 0) {
                this.f24765o += r0 / this.f24830b.f24588d;
            }
            this.f24764n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void f() {
        this.f24763m = p0.f27685f;
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i11;
        if (super.isEnded() && (i11 = this.f24764n) > 0) {
            g(i11).put(this.f24763m, 0, this.f24764n).flip();
            this.f24764n = 0;
        }
        return super.getOutput();
    }

    public long h() {
        return this.f24765o;
    }

    public void i() {
        this.f24765o = 0L;
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.f24764n == 0;
    }

    public void j(int i11, int i12) {
        this.f24759i = i11;
        this.f24760j = i12;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        if (i11 == 0) {
            return;
        }
        int min = Math.min(i11, this.f24762l);
        this.f24765o += min / this.f24830b.f24588d;
        this.f24762l -= min;
        byteBuffer.position(position + min);
        if (this.f24762l > 0) {
            return;
        }
        int i12 = i11 - min;
        int length = (this.f24764n + i12) - this.f24763m.length;
        ByteBuffer g11 = g(length);
        int q11 = p0.q(length, 0, this.f24764n);
        g11.put(this.f24763m, 0, q11);
        int q12 = p0.q(length - q11, 0, i12);
        byteBuffer.limit(byteBuffer.position() + q12);
        g11.put(byteBuffer);
        byteBuffer.limit(limit);
        int i13 = i12 - q12;
        int i14 = this.f24764n - q11;
        this.f24764n = i14;
        byte[] bArr = this.f24763m;
        System.arraycopy(bArr, q11, bArr, 0, i14);
        byteBuffer.get(this.f24763m, this.f24764n, i13);
        this.f24764n += i13;
        g11.flip();
    }
}
