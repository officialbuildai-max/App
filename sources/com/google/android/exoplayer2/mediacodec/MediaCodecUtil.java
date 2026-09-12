package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public abstract class MediaCodecUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f25383a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap f25384b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static int f25385c = -1;

    /* loaded from: classes3.dex */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th2) {
            super("Failed to query underlying media codecs", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f25386a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f25387b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f25388c;

        public b(String str, boolean z10, boolean z11) {
            this.f25386a = str;
            this.f25387b = z10;
            this.f25388c = z11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f25386a, bVar.f25386a) && this.f25387b == bVar.f25387b && this.f25388c == bVar.f25388c;
        }

        public int hashCode() {
            return ((((this.f25386a.hashCode() + 31) * 31) + (this.f25387b ? 1231 : 1237)) * 31) + (this.f25388c ? 1231 : 1237);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface c {
        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i11);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d implements c {
        private d() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i11) {
            return MediaCodecList.getCodecInfoAt(i11);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        private final int f25389a;

        /* renamed from: b, reason: collision with root package name */
        private MediaCodecInfo[] f25390b;

        public e(boolean z10, boolean z11) {
            this.f25389a = (z10 || z11) ? 1 : 0;
        }

        private void c() {
            if (this.f25390b == null) {
                this.f25390b = new MediaCodecList(this.f25389a).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            c();
            return this.f25390b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i11) {
            c();
            return this.f25390b[i11];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface f {
        int a(Object obj);
    }

    private static boolean A(MediaCodecInfo mediaCodecInfo) {
        return p0.f27680a >= 29 && B(mediaCodecInfo);
    }

    private static boolean B(MediaCodecInfo mediaCodecInfo) {
        boolean isAlias;
        isAlias = mediaCodecInfo.isAlias();
        return isAlias;
    }

    private static boolean C(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z10 && str.endsWith(".secure"))) {
            return false;
        }
        int i11 = p0.f27680a;
        if (i11 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i11 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = p0.f27681b;
            if ("a70".equals(str3) || ("Xiaomi".equals(p0.f27682c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = p0.f27681b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = p0.f27681b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i11 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(p0.f27682c))) {
            String str6 = p0.f27681b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i11 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(p0.f27682c)) {
            String str7 = p0.f27681b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i11 <= 19 && p0.f27681b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i11 <= 23 && MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static boolean D(MediaCodecInfo mediaCodecInfo, String str) {
        return p0.f27680a >= 29 ? E(mediaCodecInfo) : !F(mediaCodecInfo, str);
    }

    private static boolean E(MediaCodecInfo mediaCodecInfo) {
        boolean isHardwareAccelerated;
        isHardwareAccelerated = mediaCodecInfo.isHardwareAccelerated();
        return isHardwareAccelerated;
    }

    private static boolean F(MediaCodecInfo mediaCodecInfo, String str) {
        if (p0.f27680a >= 29) {
            return G(mediaCodecInfo);
        }
        if (w.p(str)) {
            return true;
        }
        String e11 = com.google.common.base.a.e(mediaCodecInfo.getName());
        if (e11.startsWith("arc.")) {
            return false;
        }
        if (e11.startsWith("omx.google.") || e11.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((e11.startsWith("omx.sec.") && e11.contains(".sw.")) || e11.equals("omx.qcom.video.decoder.hevcswvdec") || e11.startsWith("c2.android.") || e11.startsWith("c2.google.")) {
            return true;
        }
        return (e11.startsWith("omx.") || e11.startsWith("c2.")) ? false : true;
    }

    private static boolean G(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
        return isSoftwareOnly;
    }

    private static boolean H(MediaCodecInfo mediaCodecInfo) {
        if (p0.f27680a >= 29) {
            return I(mediaCodecInfo);
        }
        String e11 = com.google.common.base.a.e(mediaCodecInfo.getName());
        return (e11.startsWith("omx.google.") || e11.startsWith("c2.android.") || e11.startsWith("c2.google.")) ? false : true;
    }

    private static boolean I(MediaCodecInfo mediaCodecInfo) {
        boolean isVendor;
        isVendor = mediaCodecInfo.isVendor();
        return isVendor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int J(m mVar) {
        String str = mVar.f25452a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (p0.f27680a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(m mVar) {
        return mVar.f25452a.startsWith("OMX.google") ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L(o1 o1Var, m mVar) {
        try {
            return mVar.m(o1Var) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int M(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    public static int N() {
        if (f25385c == -1) {
            int i11 = 0;
            m r11 = r(MimeTypes.VIDEO_H264, false, false);
            if (r11 != null) {
                MediaCodecInfo.CodecProfileLevel[] g11 = r11.g();
                int length = g11.length;
                int i12 = 0;
                while (i11 < length) {
                    i12 = Math.max(h(g11[i11].level), i12);
                    i11++;
                }
                i11 = Math.max(i12, p0.f27680a >= 21 ? 345600 : 172800);
            }
            f25385c = i11;
        }
        return f25385c;
    }

    private static int O(int i11) {
        int i12 = 17;
        if (i11 != 17) {
            i12 = 20;
            if (i11 != 20) {
                i12 = 23;
                if (i11 != 23) {
                    i12 = 29;
                    if (i11 != 29) {
                        i12 = 39;
                        if (i11 != 39) {
                            i12 = 42;
                            if (i11 != 42) {
                                switch (i11) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i12;
    }

    private static void P(List list, final f fVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.exoplayer2.mediacodec.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int M;
                M = MediaCodecUtil.M(MediaCodecUtil.f.this, obj, obj2);
                return M;
            }
        });
    }

    private static int Q(int i11) {
        if (i11 == 10) {
            return 1;
        }
        if (i11 == 11) {
            return 2;
        }
        if (i11 == 20) {
            return 4;
        }
        if (i11 == 21) {
            return 8;
        }
        if (i11 == 30) {
            return 16;
        }
        if (i11 == 31) {
            return 32;
        }
        if (i11 == 40) {
            return 64;
        }
        if (i11 == 41) {
            return 128;
        }
        if (i11 == 50) {
            return 256;
        }
        if (i11 == 51) {
            return 512;
        }
        switch (i11) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int R(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? -1 : 8;
        }
        return 4;
    }

    private static void e(String str, List list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (p0.f27680a < 26 && p0.f27681b.equals("R9") && list.size() == 1 && ((m) list.get(0)).f25452a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(m.C("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            P(list, new f() { // from class: com.google.android.exoplayer2.mediacodec.p
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                public final int a(Object obj) {
                    int J;
                    J = MediaCodecUtil.J((m) obj);
                    return J;
                }
            });
        }
        int i11 = p0.f27680a;
        if (i11 < 21 && list.size() > 1) {
            String str2 = ((m) list.get(0)).f25452a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                P(list, new f() { // from class: com.google.android.exoplayer2.mediacodec.q
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                    public final int a(Object obj) {
                        int K;
                        K = MediaCodecUtil.K((m) obj);
                        return K;
                    }
                });
            }
        }
        if (i11 >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((m) list.get(0)).f25452a)) {
            return;
        }
        list.add((m) list.remove(0));
    }

    private static int f(int i11) {
        switch (i11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int g(int i11) {
        switch (i11) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i11) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i11) {
                            case 30:
                                return 256;
                            case TEMPLATE_HTML_SIZE_VALUE:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i11) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i11) {
                                            case 50:
                                                return 16384;
                                            case AD_REWARD_USER_VALUE:
                                                return 32768;
                                            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int h(int i11) {
        if (i11 == 1 || i11 == 2) {
            return 25344;
        }
        switch (i11) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int i(int i11) {
        if (i11 == 66) {
            return 1;
        }
        if (i11 == 77) {
            return 2;
        }
        if (i11 == 88) {
            return 4;
        }
        if (i11 == 100) {
            return 8;
        }
        if (i11 == 110) {
            return 16;
        }
        if (i11 != 122) {
            return i11 != 244 ? -1 : 64;
        }
        return 32;
    }

    private static Integer j(String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1568:
                if (str.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1570:
                if (str.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                    c11 = '\f';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case '\b':
                return 256;
            case '\t':
                return 512;
            case '\n':
                return 1024;
            case 11:
                return 2048;
            case '\f':
                return 4096;
            default:
                return null;
        }
    }

    private static Integer k(String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals("01")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c11 = '\t';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case '\b':
                return 256;
            case '\t':
                return 512;
            default:
                return null;
        }
    }

    private static Pair l(String str, String[] strArr) {
        int O;
        if (strArr.length != 3) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (MimeTypes.AUDIO_AAC.equals(w.h(Integer.parseInt(strArr[1], 16))) && (O = O(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(O), 0);
            }
        } catch (NumberFormatException unused) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    public static String m(o1 o1Var) {
        Pair q11;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(o1Var.f25550l)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (!"video/dolby-vision".equals(o1Var.f25550l) || (q11 = q(o1Var)) == null) {
            return null;
        }
        int intValue = ((Integer) q11.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return MimeTypes.VIDEO_H265;
        }
        if (intValue == 512) {
            return MimeTypes.VIDEO_H264;
        }
        return null;
    }

    private static Pair n(String str, String[] strArr, com.google.android.exoplayer2.video.c cVar) {
        int i11;
        if (strArr.length < 4) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown AV1 profile: " + parseInt);
                return null;
            }
            if (parseInt3 != 8 && parseInt3 != 10) {
                com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown AV1 bit depth: " + parseInt3);
                return null;
            }
            int i12 = parseInt3 != 8 ? (cVar == null || !(cVar.f27883d != null || (i11 = cVar.f27882c) == 7 || i11 == 6)) ? 2 : 4096 : 1;
            int f11 = f(parseInt2);
            if (f11 != -1) {
                return new Pair(Integer.valueOf(i12), Integer.valueOf(f11));
            }
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown AV1 level: " + parseInt2);
            return null;
        } catch (NumberFormatException unused) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static Pair o(String str, String[] strArr) {
        int parseInt;
        int i11;
        if (strArr.length < 2) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i11 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                parseInt = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int parseInt2 = Integer.parseInt(strArr[1]);
                parseInt = Integer.parseInt(strArr[2]);
                i11 = parseInt2;
            }
            int i12 = i(i11);
            if (i12 == -1) {
                com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown AVC profile: " + i11);
                return null;
            }
            int g11 = g(parseInt);
            if (g11 != -1) {
                return new Pair(Integer.valueOf(i12), Integer.valueOf(g11));
            }
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown AVC level: " + parseInt);
            return null;
        } catch (NumberFormatException unused) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static String p(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
    
        if (r3.equals("av01") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair q(com.google.android.exoplayer2.o1 r6) {
        /*
            r0 = 0
            java.lang.String r1 = r6.f25547i
            r2 = 0
            if (r1 != 0) goto L7
            return r2
        L7:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r6.f25550l
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L1e
            java.lang.String r6 = r6.f25547i
            android.util.Pair r6 = w(r6, r1)
            return r6
        L1e:
            r3 = r1[r0]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3004662: goto L6f;
                case 3006243: goto L64;
                case 3006244: goto L59;
                case 3199032: goto L4e;
                case 3214780: goto L43;
                case 3356560: goto L38;
                case 3624515: goto L2d;
                default: goto L2b;
            }
        L2b:
            r0 = r4
            goto L78
        L2d:
            java.lang.String r0 = "vp09"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L36
            goto L2b
        L36:
            r0 = 6
            goto L78
        L38:
            java.lang.String r0 = "mp4a"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L41
            goto L2b
        L41:
            r0 = 5
            goto L78
        L43:
            java.lang.String r0 = "hvc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L4c
            goto L2b
        L4c:
            r0 = 4
            goto L78
        L4e:
            java.lang.String r0 = "hev1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L57
            goto L2b
        L57:
            r0 = 3
            goto L78
        L59:
            java.lang.String r0 = "avc2"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L62
            goto L2b
        L62:
            r0 = 2
            goto L78
        L64:
            java.lang.String r0 = "avc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L6d
            goto L2b
        L6d:
            r0 = 1
            goto L78
        L6f:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L78
            goto L2b
        L78:
            switch(r0) {
                case 0: goto L98;
                case 1: goto L91;
                case 2: goto L91;
                case 3: goto L8a;
                case 4: goto L8a;
                case 5: goto L83;
                case 6: goto L7c;
                default: goto L7b;
            }
        L7b:
            return r2
        L7c:
            java.lang.String r6 = r6.f25547i
            android.util.Pair r6 = y(r6, r1)
            return r6
        L83:
            java.lang.String r6 = r6.f25547i
            android.util.Pair r6 = l(r6, r1)
            return r6
        L8a:
            java.lang.String r6 = r6.f25547i
            android.util.Pair r6 = x(r6, r1)
            return r6
        L91:
            java.lang.String r6 = r6.f25547i
            android.util.Pair r6 = o(r6, r1)
            return r6
        L98:
            java.lang.String r0 = r6.f25547i
            com.google.android.exoplayer2.video.c r6 = r6.f25562x
            android.util.Pair r6 = n(r0, r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.q(com.google.android.exoplayer2.o1):android.util.Pair");
    }

    public static m r(String str, boolean z10, boolean z11) {
        List s11 = s(str, z10, z11);
        if (s11.isEmpty()) {
            return null;
        }
        return (m) s11.get(0);
    }

    public static synchronized List s(String str, boolean z10, boolean z11) {
        synchronized (MediaCodecUtil.class) {
            try {
                b bVar = new b(str, z10, z11);
                HashMap hashMap = f25384b;
                List list = (List) hashMap.get(bVar);
                if (list != null) {
                    return list;
                }
                int i11 = p0.f27680a;
                ArrayList t11 = t(bVar, i11 >= 21 ? new e(z10, z11) : new d());
                if (z10 && t11.isEmpty() && 21 <= i11 && i11 <= 23) {
                    t11 = t(bVar, new d());
                    if (!t11.isEmpty()) {
                        com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((m) t11.get(0)).f25452a);
                    }
                }
                e(str, t11);
                ImmutableList copyOf = ImmutableList.copyOf((Collection) t11);
                hashMap.put(bVar, copyOf);
                return copyOf;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:28|(4:(2:72|73)|53|(9:56|57|58|59|60|61|62|64|65)|9)|32|33|34|36|9) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x008c, code lost:
    
        if (r1.f25387b == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105 A[Catch: Exception -> 0x012e, TRY_ENTER, TryCatch #1 {Exception -> 0x012e, blocks: (B:3:0x0008, B:5:0x001b, B:9:0x0124, B:10:0x002d, B:13:0x0038, B:39:0x00fd, B:42:0x0105, B:44:0x010b, B:47:0x0130, B:48:0x0153), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList t(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b r24, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c r25) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.t(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c):java.util.ArrayList");
    }

    public static List u(List list, final o1 o1Var) {
        ArrayList arrayList = new ArrayList(list);
        P(arrayList, new f() { // from class: com.google.android.exoplayer2.mediacodec.r
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
            public final int a(Object obj) {
                int L;
                L = MediaCodecUtil.L(o1.this, (m) obj);
                return L;
            }
        });
        return arrayList;
    }

    public static m v() {
        return r(MimeTypes.AUDIO_RAW, false, false);
    }

    private static Pair w(String str, String[] strArr) {
        if (strArr.length < 3) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f25383a.matcher(strArr[1]);
        if (!matcher.matches()) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        Integer k11 = k(group);
        if (k11 == null) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown Dolby Vision profile string: " + group);
            return null;
        }
        String str2 = strArr[2];
        Integer j11 = j(str2);
        if (j11 != null) {
            return new Pair(k11, j11);
        }
        com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    private static Pair x(String str, String[] strArr) {
        if (strArr.length < 4) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i11 = 1;
        Matcher matcher = f25383a.matcher(strArr[1]);
        if (!matcher.matches()) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if (!"2".equals(group)) {
                com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
            i11 = 2;
        }
        String str2 = strArr[3];
        Integer z10 = z(str2);
        if (z10 != null) {
            return new Pair(Integer.valueOf(i11), z10);
        }
        com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    private static Pair y(String str, String[] strArr) {
        if (strArr.length < 3) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int R = R(parseInt);
            if (R == -1) {
                com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown VP9 profile: " + parseInt);
                return null;
            }
            int Q = Q(parseInt2);
            if (Q != -1) {
                return new Pair(Integer.valueOf(R), Integer.valueOf(Q));
            }
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Unknown VP9 level: " + parseInt2);
            return null;
        } catch (NumberFormatException unused) {
            com.google.android.exoplayer2.util.s.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static Integer z(String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c11 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c11 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c11 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c11 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c11 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c11 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c11 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c11 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c11 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c11 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c11 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c11 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c11 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c11 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c11 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c11 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c11 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c11 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c11 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c11 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c11 = 25;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case '\b':
                return 64;
            case '\t':
                return 256;
            case '\n':
                return 2048;
            case 11:
                return 8192;
            case '\f':
                return 32768;
            case '\r':
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return Integer.valueOf(ASTNode.PCTX_STORED);
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }
}
