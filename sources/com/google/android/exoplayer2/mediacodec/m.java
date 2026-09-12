package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.w;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f25452a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25453b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25454c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f25455d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f25456e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f25457f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f25458g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f25459h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f25460i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f25461j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f25462k;

    m(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f25452a = (String) com.google.android.exoplayer2.util.a.e(str);
        this.f25453b = str2;
        this.f25454c = str3;
        this.f25455d = codecCapabilities;
        this.f25459h = z10;
        this.f25460i = z11;
        this.f25461j = z12;
        this.f25456e = z13;
        this.f25457f = z14;
        this.f25458g = z15;
        this.f25462k = w.t(str2);
    }

    private static boolean A(String str, int i11) {
        if (MimeTypes.VIDEO_H265.equals(str) && 2 == i11) {
            String str2 = p0.f27681b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean B(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(p0.f27681b)) ? false : true;
    }

    public static m C(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return new m(str, str2, str3, codecCapabilities, z10, z11, z12, (z13 || codecCapabilities == null || !h(codecCapabilities) || z(str)) ? false : true, codecCapabilities != null && s(codecCapabilities), z14 || (codecCapabilities != null && q(codecCapabilities)));
    }

    private static int a(String str, String str2, int i11) {
        if (i11 > 1 || ((p0.f27680a >= 26 && i11 > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i11;
        }
        int i12 = MimeTypes.AUDIO_AC3.equals(str2) ? 6 : MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
        com.google.android.exoplayer2.util.s.i(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i11 + " to " + i12 + "]");
        return i12;
    }

    private static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(p0.l(i11, widthAlignment) * widthAlignment, p0.l(i12, heightAlignment) * heightAlignment);
    }

    private static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        Point c11 = c(videoCapabilities, i11, i12);
        int i13 = c11.x;
        int i14 = c11.y;
        return (d11 == -1.0d || d11 < 1.0d) ? videoCapabilities.isSizeSupported(i13, i14) : videoCapabilities.areSizeAndRateSupported(i13, i14, Math.floor(d11));
    }

    private static MediaCodecInfo.CodecProfileLevel[] f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int intValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : videoCapabilities.getBitrateRange().getUpper().intValue();
        int i11 = intValue >= 180000000 ? 1024 : intValue >= 120000000 ? 512 : intValue >= 60000000 ? 256 : intValue >= 30000000 ? 128 : intValue >= 18000000 ? 64 : intValue >= 12000000 ? 32 : intValue >= 7200000 ? 16 : intValue >= 3600000 ? 8 : intValue >= 1800000 ? 4 : intValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i11;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    private static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return p0.f27680a >= 19 && i(codecCapabilities);
    }

    private static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean l(o1 o1Var) {
        Pair q11;
        if (o1Var.f25547i == null || (q11 = MediaCodecUtil.q(o1Var)) == null) {
            return true;
        }
        int intValue = ((Integer) q11.first).intValue();
        int intValue2 = ((Integer) q11.second).intValue();
        if ("video/dolby-vision".equals(o1Var.f25550l)) {
            if (!MimeTypes.VIDEO_H264.equals(this.f25453b)) {
                intValue = MimeTypes.VIDEO_H265.equals(this.f25453b) ? 2 : 8;
            }
            intValue2 = 0;
        }
        if (!this.f25462k && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] g11 = g();
        if (p0.f27680a <= 23 && MimeTypes.VIDEO_VP9.equals(this.f25453b) && g11.length == 0) {
            g11 = f(this.f25455d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g11) {
            if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2 && !A(this.f25453b, intValue)) {
                return true;
            }
        }
        w("codec.profileLevel, " + o1Var.f25547i + ", " + this.f25454c);
        return false;
    }

    private boolean o(o1 o1Var) {
        return this.f25453b.equals(o1Var.f25550l) || this.f25453b.equals(MediaCodecUtil.m(o1Var));
    }

    private static boolean q(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return p0.f27680a >= 21 && r(codecCapabilities);
    }

    private static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return p0.f27680a >= 21 && t(codecCapabilities);
    }

    private static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void v(String str) {
        com.google.android.exoplayer2.util.s.b(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + str + "] [" + this.f25452a + ", " + this.f25453b + "] [" + p0.f27684e + "]");
    }

    private void w(String str) {
        com.google.android.exoplayer2.util.s.b(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.f25452a + ", " + this.f25453b + "] [" + p0.f27684e + "]");
    }

    private static boolean x(String str) {
        return MimeTypes.AUDIO_OPUS.equals(str);
    }

    private static boolean y(String str) {
        return p0.f27683d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean z(String str) {
        if (p0.f27680a <= 22) {
            String str2 = p0.f27683d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public Point b(int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25455d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i11, i12);
    }

    public com.google.android.exoplayer2.decoder.g e(o1 o1Var, o1 o1Var2) {
        int i11 = !p0.c(o1Var.f25550l, o1Var2.f25550l) ? 8 : 0;
        if (this.f25462k) {
            if (o1Var.f25558t != o1Var2.f25558t) {
                i11 |= 1024;
            }
            if (!this.f25456e && (o1Var.f25555q != o1Var2.f25555q || o1Var.f25556r != o1Var2.f25556r)) {
                i11 |= 512;
            }
            if (!p0.c(o1Var.f25562x, o1Var2.f25562x)) {
                i11 |= 2048;
            }
            if (y(this.f25452a) && !o1Var.g(o1Var2)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new com.google.android.exoplayer2.decoder.g(this.f25452a, o1Var, o1Var2, o1Var.g(o1Var2) ? 3 : 2, 0);
            }
        } else {
            if (o1Var.f25563y != o1Var2.f25563y) {
                i11 |= 4096;
            }
            if (o1Var.f25564z != o1Var2.f25564z) {
                i11 |= 8192;
            }
            if (o1Var.A != o1Var2.A) {
                i11 |= 16384;
            }
            if (i11 == 0 && MimeTypes.AUDIO_AAC.equals(this.f25453b)) {
                Pair q11 = MediaCodecUtil.q(o1Var);
                Pair q12 = MediaCodecUtil.q(o1Var2);
                if (q11 != null && q12 != null) {
                    int intValue = ((Integer) q11.first).intValue();
                    int intValue2 = ((Integer) q12.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new com.google.android.exoplayer2.decoder.g(this.f25452a, o1Var, o1Var2, 3, 0);
                    }
                }
            }
            if (!o1Var.g(o1Var2)) {
                i11 |= 32;
            }
            if (x(this.f25453b)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new com.google.android.exoplayer2.decoder.g(this.f25452a, o1Var, o1Var2, 1, 0);
            }
        }
        return new com.google.android.exoplayer2.decoder.g(this.f25452a, o1Var, o1Var2, 0, i11);
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25455d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean j(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25455d;
        if (codecCapabilities == null) {
            w("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("channelCount.aCaps");
            return false;
        }
        if (a(this.f25452a, this.f25453b, audioCapabilities.getMaxInputChannelCount()) >= i11) {
            return true;
        }
        w("channelCount.support, " + i11);
        return false;
    }

    public boolean k(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25455d;
        if (codecCapabilities == null) {
            w("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i11)) {
            return true;
        }
        w("sampleRate.support, " + i11);
        return false;
    }

    public boolean m(o1 o1Var) {
        int i11;
        if (!o(o1Var) || !l(o1Var)) {
            return false;
        }
        if (!this.f25462k) {
            if (p0.f27680a >= 21) {
                int i12 = o1Var.f25564z;
                if (i12 != -1 && !k(i12)) {
                    return false;
                }
                int i13 = o1Var.f25563y;
                if (i13 != -1 && !j(i13)) {
                    return false;
                }
            }
            return true;
        }
        int i14 = o1Var.f25555q;
        if (i14 <= 0 || (i11 = o1Var.f25556r) <= 0) {
            return true;
        }
        if (p0.f27680a >= 21) {
            return u(i14, i11, o1Var.f25557s);
        }
        boolean z10 = i14 * i11 <= MediaCodecUtil.N();
        if (!z10) {
            w("legacyFrameSize, " + o1Var.f25555q + "x" + o1Var.f25556r);
        }
        return z10;
    }

    public boolean n() {
        if (p0.f27680a >= 29 && MimeTypes.VIDEO_VP9.equals(this.f25453b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean p(o1 o1Var) {
        if (this.f25462k) {
            return this.f25456e;
        }
        Pair q11 = MediaCodecUtil.q(o1Var);
        return q11 != null && ((Integer) q11.first).intValue() == 42;
    }

    public String toString() {
        return this.f25452a;
    }

    public boolean u(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25455d;
        if (codecCapabilities == null) {
            w("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            w("sizeAndRate.vCaps");
            return false;
        }
        if (d(videoCapabilities, i11, i12, d11)) {
            return true;
        }
        if (i11 < i12 && B(this.f25452a) && d(videoCapabilities, i12, i11, d11)) {
            v("sizeAndRate.rotated, " + i11 + "x" + i12 + "x" + d11);
            return true;
        }
        w("sizeAndRate.support, " + i11 + "x" + i12 + "x" + d11);
        return false;
    }
}
