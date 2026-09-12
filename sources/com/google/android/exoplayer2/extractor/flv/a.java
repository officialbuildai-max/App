package com.google.android.exoplayer2.extractor.flv;

import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.e0;
import java.util.Collections;

/* loaded from: classes3.dex */
final class a extends TagPayloadReader {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f25096e = {5512, RecorderConstants.RECORD_SAMPLE_RATE_11025, RecorderConstants.RECORD_SAMPLE_RATE_22050, RecorderConstants.RECORD_SAMPLE_RATE_44100};

    /* renamed from: b, reason: collision with root package name */
    private boolean f25097b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f25098c;

    /* renamed from: d, reason: collision with root package name */
    private int f25099d;

    public a(e0 e0Var) {
        super(e0Var);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean b(d0 d0Var) {
        if (this.f25097b) {
            d0Var.Q(1);
        } else {
            int D = d0Var.D();
            int i11 = (D >> 4) & 15;
            this.f25099d = i11;
            if (i11 == 2) {
                this.f25095a.e(new o1.b().e0(MimeTypes.AUDIO_MPEG).H(1).f0(f25096e[(D >> 2) & 3]).E());
                this.f25098c = true;
            } else if (i11 == 7 || i11 == 8) {
                this.f25095a.e(new o1.b().e0(i11 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW).H(1).f0(8000).E());
                this.f25098c = true;
            } else if (i11 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f25099d);
            }
            this.f25097b = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean c(d0 d0Var, long j11) {
        if (this.f25099d == 2) {
            int a11 = d0Var.a();
            this.f25095a.c(d0Var, a11);
            this.f25095a.d(j11, 1, a11, 0, null);
            return true;
        }
        int D = d0Var.D();
        if (D != 0 || this.f25098c) {
            if (this.f25099d == 10 && D != 1) {
                return false;
            }
            int a12 = d0Var.a();
            this.f25095a.c(d0Var, a12);
            this.f25095a.d(j11, 1, a12, 0, null);
            return true;
        }
        int a13 = d0Var.a();
        byte[] bArr = new byte[a13];
        d0Var.j(bArr, 0, a13);
        a.b f11 = com.google.android.exoplayer2.audio.a.f(bArr);
        this.f25095a.e(new o1.b().e0(MimeTypes.AUDIO_AAC).I(f11.f24654c).H(f11.f24653b).f0(f11.f24652a).T(Collections.singletonList(bArr)).E());
        this.f25098c = true;
        return false;
    }
}
