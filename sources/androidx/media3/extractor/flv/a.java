package androidx.media3.extractor.flv;

import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import l2.a;
import l2.s0;

/* loaded from: classes2.dex */
final class a extends TagPayloadReader {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f13484e = {5512, RecorderConstants.RECORD_SAMPLE_RATE_11025, RecorderConstants.RECORD_SAMPLE_RATE_22050, RecorderConstants.RECORD_SAMPLE_RATE_44100};

    /* renamed from: b, reason: collision with root package name */
    private boolean f13485b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13486c;

    /* renamed from: d, reason: collision with root package name */
    private int f13487d;

    public a(s0 s0Var) {
        super(s0Var);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean b(j0 j0Var) {
        if (this.f13485b) {
            j0Var.X(1);
        } else {
            int H = j0Var.H();
            int i11 = (H >> 4) & 15;
            this.f13487d = i11;
            if (i11 == 2) {
                this.f13483a.c(new r.b().U("video/x-flv").u0(MimeTypes.AUDIO_MPEG).R(1).v0(f13484e[(H >> 2) & 3]).N());
                this.f13486c = true;
            } else if (i11 == 7 || i11 == 8) {
                this.f13483a.c(new r.b().U("video/x-flv").u0(i11 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW).R(1).v0(8000).N());
                this.f13486c = true;
            } else if (i11 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f13487d);
            }
            this.f13485b = true;
        }
        return true;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean c(j0 j0Var, long j11) {
        if (this.f13487d == 2) {
            int a11 = j0Var.a();
            this.f13483a.b(j0Var, a11);
            this.f13483a.d(j11, 1, a11, 0, null);
            return true;
        }
        int H = j0Var.H();
        if (H != 0 || this.f13486c) {
            if (this.f13487d == 10 && H != 1) {
                return false;
            }
            int a12 = j0Var.a();
            this.f13483a.b(j0Var, a12);
            this.f13483a.d(j11, 1, a12, 0, null);
            return true;
        }
        int a13 = j0Var.a();
        byte[] bArr = new byte[a13];
        j0Var.l(bArr, 0, a13);
        a.b e11 = l2.a.e(bArr);
        this.f13483a.c(new r.b().U("video/x-flv").u0(MimeTypes.AUDIO_AAC).S(e11.f68608c).R(e11.f68607b).v0(e11.f68606a).g0(Collections.singletonList(bArr)).N());
        this.f13486c = true;
        return false;
    }
}
