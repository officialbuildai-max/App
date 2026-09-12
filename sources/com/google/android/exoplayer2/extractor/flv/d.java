package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.e0;

/* loaded from: classes3.dex */
final class d extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    private final d0 f25120b;

    /* renamed from: c, reason: collision with root package name */
    private final d0 f25121c;

    /* renamed from: d, reason: collision with root package name */
    private int f25122d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25123e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25124f;

    /* renamed from: g, reason: collision with root package name */
    private int f25125g;

    public d(e0 e0Var) {
        super(e0Var);
        this.f25120b = new d0(x.f27718a);
        this.f25121c = new d0(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean b(d0 d0Var) {
        int D = d0Var.D();
        int i11 = (D >> 4) & 15;
        int i12 = D & 15;
        if (i12 == 7) {
            this.f25125g = i11;
            return i11 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i12);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean c(d0 d0Var, long j11) {
        int D = d0Var.D();
        long o11 = j11 + (d0Var.o() * 1000);
        if (D == 0 && !this.f25123e) {
            d0 d0Var2 = new d0(new byte[d0Var.a()]);
            d0Var.j(d0Var2.d(), 0, d0Var.a());
            com.google.android.exoplayer2.video.a b11 = com.google.android.exoplayer2.video.a.b(d0Var2);
            this.f25122d = b11.f27874b;
            this.f25095a.e(new o1.b().e0(MimeTypes.VIDEO_H264).I(b11.f27878f).j0(b11.f27875c).Q(b11.f27876d).a0(b11.f27877e).T(b11.f27873a).E());
            this.f25123e = true;
            return false;
        }
        if (D != 1 || !this.f25123e) {
            return false;
        }
        int i11 = this.f25125g == 1 ? 1 : 0;
        if (!this.f25124f && i11 == 0) {
            return false;
        }
        byte[] d11 = this.f25121c.d();
        d11[0] = 0;
        d11[1] = 0;
        d11[2] = 0;
        int i12 = 4 - this.f25122d;
        int i13 = 0;
        while (d0Var.a() > 0) {
            d0Var.j(this.f25121c.d(), i12, this.f25122d);
            this.f25121c.P(0);
            int H = this.f25121c.H();
            this.f25120b.P(0);
            this.f25095a.c(this.f25120b, 4);
            this.f25095a.c(d0Var, H);
            i13 = i13 + 4 + H;
        }
        this.f25095a.d(o11, i11, i13, 0, null);
        this.f25124f = true;
        return true;
    }
}
