package androidx.media3.extractor.flv;

import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.container.g;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import l2.s0;

/* loaded from: classes2.dex */
final class d extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    private final j0 f13508b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f13509c;

    /* renamed from: d, reason: collision with root package name */
    private int f13510d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f13511e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13512f;

    /* renamed from: g, reason: collision with root package name */
    private int f13513g;

    public d(s0 s0Var) {
        super(s0Var);
        this.f13508b = new j0(g.f10675a);
        this.f13509c = new j0(4);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean b(j0 j0Var) {
        int H = j0Var.H();
        int i11 = (H >> 4) & 15;
        int i12 = H & 15;
        if (i12 == 7) {
            this.f13513g = i11;
            return i11 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i12);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean c(j0 j0Var, long j11) {
        int H = j0Var.H();
        long r11 = j11 + (j0Var.r() * 1000);
        if (H == 0 && !this.f13511e) {
            j0 j0Var2 = new j0(new byte[j0Var.a()]);
            j0Var.l(j0Var2.e(), 0, j0Var.a());
            l2.d b11 = l2.d.b(j0Var2);
            this.f13510d = b11.f68652b;
            this.f13483a.c(new r.b().U("video/x-flv").u0(MimeTypes.VIDEO_H264).S(b11.f68662l).B0(b11.f68653c).d0(b11.f68654d).q0(b11.f68661k).g0(b11.f68651a).N());
            this.f13511e = true;
            return false;
        }
        if (H != 1 || !this.f13511e) {
            return false;
        }
        int i11 = this.f13513g == 1 ? 1 : 0;
        if (!this.f13512f && i11 == 0) {
            return false;
        }
        byte[] e11 = this.f13509c.e();
        e11[0] = 0;
        e11[1] = 0;
        e11[2] = 0;
        int i12 = 4 - this.f13510d;
        int i13 = 0;
        while (j0Var.a() > 0) {
            j0Var.l(this.f13509c.e(), i12, this.f13510d);
            this.f13509c.W(0);
            int L = this.f13509c.L();
            this.f13508b.W(0);
            this.f13483a.b(this.f13508b, 4);
            this.f13483a.b(j0Var, L);
            i13 = i13 + 4 + L;
        }
        this.f13483a.d(r11, i11, i13, 0, null);
        this.f13512f = true;
        return true;
    }
}
