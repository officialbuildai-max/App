package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class f1 extends androidx.media3.common.audio.b {

    /* renamed from: i, reason: collision with root package name */
    private int f11256i;

    /* renamed from: j, reason: collision with root package name */
    private int f11257j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11258k;

    /* renamed from: l, reason: collision with root package name */
    private int f11259l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f11260m = androidx.media3.common.util.a1.f10437f;

    /* renamed from: n, reason: collision with root package name */
    private int f11261n;

    /* renamed from: o, reason: collision with root package name */
    private long f11262o;

    @Override // androidx.media3.common.audio.b
    public AudioProcessor.a c(AudioProcessor.a aVar) {
        int i11 = aVar.f9901c;
        if (i11 != 2 && i11 != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.f11258k = true;
        return (this.f11256i == 0 && this.f11257j == 0) ? AudioProcessor.a.f9898e : aVar;
    }

    @Override // androidx.media3.common.audio.b
    protected void d() {
        if (this.f11258k) {
            this.f11258k = false;
            int i11 = this.f11257j;
            int i12 = this.f9909b.f9902d;
            this.f11260m = new byte[i11 * i12];
            this.f11259l = this.f11256i * i12;
        }
        this.f11261n = 0;
    }

    @Override // androidx.media3.common.audio.b
    protected void e() {
        if (this.f11258k) {
            if (this.f11261n > 0) {
                this.f11262o += r0 / this.f9909b.f9902d;
            }
            this.f11261n = 0;
        }
    }

    @Override // androidx.media3.common.audio.b
    protected void f() {
        this.f11260m = androidx.media3.common.util.a1.f10437f;
    }

    @Override // androidx.media3.common.audio.b, androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i11;
        if (super.isEnded() && (i11 = this.f11261n) > 0) {
            g(i11).put(this.f11260m, 0, this.f11261n).flip();
            this.f11261n = 0;
        }
        return super.getOutput();
    }

    public long h() {
        return this.f11262o;
    }

    public void i() {
        this.f11262o = 0L;
    }

    @Override // androidx.media3.common.audio.b, androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.f11261n == 0;
    }

    public void j(int i11, int i12) {
        this.f11256i = i11;
        this.f11257j = i12;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        if (i11 == 0) {
            return;
        }
        int min = Math.min(i11, this.f11259l);
        this.f11262o += min / this.f9909b.f9902d;
        this.f11259l -= min;
        byteBuffer.position(position + min);
        if (this.f11259l > 0) {
            return;
        }
        int i12 = i11 - min;
        int length = (this.f11261n + i12) - this.f11260m.length;
        ByteBuffer g11 = g(length);
        int p11 = androidx.media3.common.util.a1.p(length, 0, this.f11261n);
        g11.put(this.f11260m, 0, p11);
        int p12 = androidx.media3.common.util.a1.p(length - p11, 0, i12);
        byteBuffer.limit(byteBuffer.position() + p12);
        g11.put(byteBuffer);
        byteBuffer.limit(limit);
        int i13 = i12 - p12;
        int i14 = this.f11261n - p11;
        this.f11261n = i14;
        byte[] bArr = this.f11260m;
        System.arraycopy(bArr, p11, bArr, 0, i14);
        byteBuffer.get(this.f11260m, this.f11261n, i13);
        this.f11261n += i13;
        g11.flip();
    }
}
