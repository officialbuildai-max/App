package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList f27714a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f27715b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f27716a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27717b;

        public a(int i11, int i12) {
            this.f27716a = i11;
            this.f27717b = i12;
        }

        public int a() {
            int i11 = this.f27717b;
            if (i11 == 2) {
                return 10;
            }
            if (i11 == 5) {
                return 11;
            }
            if (i11 == 29) {
                return 12;
            }
            if (i11 == 42) {
                return 16;
            }
            if (i11 != 22) {
                return i11 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(String str, String str2) {
        a i11;
        if (str == null) {
            return false;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c11 = 0;
                    break;
                }
                break;
            case -432837260:
                if (str.equals(MimeTypes.AUDIO_MPEG_L1)) {
                    c11 = 1;
                    break;
                }
                break;
            case -432837259:
                if (str.equals(MimeTypes.AUDIO_MPEG_L2)) {
                    c11 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    c11 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c11 = 4;
                    break;
                }
                break;
            case 187094639:
                if (str.equals(MimeTypes.AUDIO_RAW)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c11 = 6;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals(MimeTypes.AUDIO_FLAC)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals(MimeTypes.AUDIO_MPEG)) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1903231877:
                if (str.equals(MimeTypes.AUDIO_ALAW)) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1903589369:
                if (str.equals(MimeTypes.AUDIO_MLAW)) {
                    c11 = '\n';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                return true;
            case 3:
                if (str2 == null || (i11 = i(str2)) == null) {
                    return false;
                }
                int a11 = i11.a();
                return (a11 == 0 || a11 == 16) ? false : true;
            default:
                return false;
        }
    }

    public static boolean b(String str, String str2) {
        return d(str, str2) != null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : p0.U0(str)) {
            String g11 = g(str2);
            if (g11 != null && p(g11)) {
                return g11;
            }
        }
        return null;
    }

    public static String d(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] U0 = p0.U0(str);
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : U0) {
            if (str2.equals(g(str3))) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    private static String e(String str) {
        ArrayList arrayList = f27714a;
        if (arrayList.size() <= 0) {
            return null;
        }
        android.support.v4.media.session.c.a(arrayList.get(0));
        throw null;
    }

    public static int f(String str, String str2) {
        a i11;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals(MimeTypes.AUDIO_DTS)) {
                    c11 = 1;
                    break;
                }
                break;
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    c11 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c11 = 3;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals(MimeTypes.AUDIO_MPEG)) {
                    c11 = 6;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals(MimeTypes.AUDIO_TRUEHD)) {
                    c11 = '\b';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 18;
            case 1:
                return 7;
            case 2:
                if (str2 == null || (i11 = i(str2)) == null) {
                    return 0;
                }
                return i11.a();
            case 3:
                return 5;
            case 4:
                return 17;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 8;
            case '\b':
                return 14;
            default:
                return 0;
        }
    }

    public static String g(String str) {
        a i11;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String e11 = com.google.common.base.a.e(str.trim());
        if (e11.startsWith("avc1") || e11.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (e11.startsWith("hev1") || e11.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (e11.startsWith("dvav") || e11.startsWith("dva1") || e11.startsWith("dvhe") || e11.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (e11.startsWith("av01")) {
            return "video/av01";
        }
        if (e11.startsWith("vp9") || e11.startsWith("vp09")) {
            return MimeTypes.VIDEO_VP9;
        }
        if (e11.startsWith("vp8") || e11.startsWith("vp08")) {
            return MimeTypes.VIDEO_VP8;
        }
        if (!e11.startsWith("mp4a")) {
            return e11.startsWith("mha1") ? "audio/mha1" : e11.startsWith("mhm1") ? "audio/mhm1" : (e11.startsWith("ac-3") || e11.startsWith("dac3")) ? MimeTypes.AUDIO_AC3 : (e11.startsWith("ec-3") || e11.startsWith("dec3")) ? MimeTypes.AUDIO_E_AC3 : e11.startsWith("ec+3") ? MimeTypes.AUDIO_E_AC3_JOC : (e11.startsWith("ac-4") || e11.startsWith("dac4")) ? "audio/ac4" : e11.startsWith("dtsc") ? MimeTypes.AUDIO_DTS : e11.startsWith("dtse") ? MimeTypes.AUDIO_DTS_EXPRESS : (e11.startsWith("dtsh") || e11.startsWith("dtsl")) ? MimeTypes.AUDIO_DTS_HD : e11.startsWith("dtsx") ? "audio/vnd.dts.uhd;profile=p2" : e11.startsWith("opus") ? MimeTypes.AUDIO_OPUS : e11.startsWith("vorbis") ? MimeTypes.AUDIO_VORBIS : e11.startsWith("flac") ? MimeTypes.AUDIO_FLAC : e11.startsWith("stpp") ? MimeTypes.APPLICATION_TTML : e11.startsWith("wvtt") ? MimeTypes.TEXT_VTT : e11.contains("cea708") ? MimeTypes.APPLICATION_CEA708 : (e11.contains("eia608") || e11.contains("cea608")) ? MimeTypes.APPLICATION_CEA608 : e(e11);
        }
        if (e11.startsWith("mp4a.") && (i11 = i(e11)) != null) {
            str2 = h(i11.f27716a);
        }
        return str2 == null ? MimeTypes.AUDIO_AAC : str2;
    }

    public static String h(int i11) {
        if (i11 == 32) {
            return MimeTypes.VIDEO_MP4V;
        }
        if (i11 == 33) {
            return MimeTypes.VIDEO_H264;
        }
        if (i11 == 35) {
            return MimeTypes.VIDEO_H265;
        }
        if (i11 == 64) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i11 == 163) {
            return MimeTypes.VIDEO_VC1;
        }
        if (i11 == 177) {
            return MimeTypes.VIDEO_VP9;
        }
        if (i11 == 165) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i11 == 166) {
            return MimeTypes.AUDIO_E_AC3;
        }
        switch (i11) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return MimeTypes.VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return MimeTypes.AUDIO_AAC;
            case 105:
            case 107:
                return MimeTypes.AUDIO_MPEG;
            case 106:
                return MimeTypes.VIDEO_MPEG;
            default:
                switch (i11) {
                    case 169:
                    case 172:
                        return MimeTypes.AUDIO_DTS;
                    case 170:
                    case 171:
                        return MimeTypes.AUDIO_DTS_HD;
                    case 173:
                        return MimeTypes.AUDIO_OPUS;
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    static a i(String str) {
        Matcher matcher = f27715b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        String group = matcher.group(2);
        try {
            return new a(Integer.parseInt(str2, 16), group != null ? Integer.parseInt(group) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String j(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : p0.U0(str)) {
            String g11 = g(str2);
            if (g11 != null && s(g11)) {
                return g11;
            }
        }
        return null;
    }

    private static String k(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int l(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (p(str)) {
            return 1;
        }
        if (t(str)) {
            return 2;
        }
        if (s(str)) {
            return 3;
        }
        if (q(str)) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        return m(str);
    }

    private static int m(String str) {
        ArrayList arrayList = f27714a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        android.support.v4.media.session.c.a(arrayList.get(0));
        throw null;
    }

    public static int n(String str) {
        return l(g(str));
    }

    public static String o(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : p0.U0(str)) {
            String g11 = g(str2);
            if (g11 != null && t(g11)) {
                return g11;
            }
        }
        return null;
    }

    public static boolean p(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(k(str));
    }

    public static boolean q(String str) {
        return "image".equals(k(str));
    }

    public static boolean r(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM) || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean s(String str) {
        return MimeTypes.BASE_TYPE_TEXT.equals(k(str)) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str);
    }

    public static boolean t(String str) {
        return "video".equals(k(str));
    }

    public static String u(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1007807498:
                if (str.equals("audio/x-flac")) {
                    c11 = 0;
                    break;
                }
                break;
            case -586683234:
                if (str.equals("audio/x-wav")) {
                    c11 = 1;
                    break;
                }
                break;
            case 187090231:
                if (str.equals("audio/mp3")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return MimeTypes.AUDIO_FLAC;
            case 1:
                return "audio/wav";
            case 2:
                return MimeTypes.AUDIO_MPEG;
            default:
                return str;
        }
    }
}
