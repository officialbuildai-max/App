package androidx.media3.exoplayer.hls;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.s2;

/* loaded from: classes2.dex */
final class m implements g2.u {

    /* renamed from: a, reason: collision with root package name */
    private final int f11867a;

    /* renamed from: b, reason: collision with root package name */
    private final r f11868b;

    /* renamed from: c, reason: collision with root package name */
    private int f11869c = -1;

    public m(r rVar, int i11) {
        this.f11868b = rVar;
        this.f11867a = i11;
    }

    private boolean b() {
        int i11 = this.f11869c;
        return (i11 == -1 || i11 == -3 || i11 == -2) ? false : true;
    }

    public void a() {
        androidx.media3.common.util.a.a(this.f11869c == -1);
        this.f11869c = this.f11868b.l(this.f11867a);
    }

    @Override // g2.u
    public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (this.f11869c == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (b()) {
            return this.f11868b.W(this.f11869c, s2Var, decoderInputBuffer, i11);
        }
        return -3;
    }

    public void d() {
        if (this.f11869c != -1) {
            this.f11868b.h0(this.f11867a);
            this.f11869c = -1;
        }
    }

    @Override // g2.u
    public boolean isReady() {
        return this.f11869c == -3 || (b() && this.f11868b.G(this.f11869c));
    }

    @Override // g2.u
    public void maybeThrowError() {
        int i11 = this.f11869c;
        if (i11 == -2) {
            throw new SampleQueueMappingException(this.f11868b.getTrackGroups().b(this.f11867a).a(0).f10243o);
        }
        if (i11 == -1) {
            this.f11868b.L();
        } else if (i11 != -3) {
            this.f11868b.M(i11);
        }
    }

    @Override // g2.u
    public int skipData(long j11) {
        if (b()) {
            return this.f11868b.g0(this.f11869c, j11);
        }
        return 0;
    }
}
