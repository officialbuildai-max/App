package androidx.media3.common;

import android.net.Uri;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class o {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c11;
        if (str == null) {
            return -1;
        }
        String u11 = y.u(str);
        u11.hashCode();
        switch (u11.hashCode()) {
            case -2123537834:
                if (u11.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case -1662384011:
                if (u11.equals("video/mp2p")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case -1662384007:
                if (u11.equals("video/mp2t")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case -1662095187:
                if (u11.equals(MimeTypes.VIDEO_WEBM)) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case -1606874997:
                if (u11.equals(MimeTypes.AUDIO_AMR_WB)) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            case -1487656890:
                if (u11.equals("image/avif")) {
                    c11 = 5;
                    break;
                }
                c11 = 65535;
                break;
            case -1487464693:
                if (u11.equals("image/heic")) {
                    c11 = 6;
                    break;
                }
                c11 = 65535;
                break;
            case -1487464690:
                if (u11.equals("image/heif")) {
                    c11 = 7;
                    break;
                }
                c11 = 65535;
                break;
            case -1487394660:
                if (u11.equals("image/jpeg")) {
                    c11 = '\b';
                    break;
                }
                c11 = 65535;
                break;
            case -1487018032:
                if (u11.equals("image/webp")) {
                    c11 = '\t';
                    break;
                }
                c11 = 65535;
                break;
            case -1248337486:
                if (u11.equals(MimeTypes.APPLICATION_MP4)) {
                    c11 = '\n';
                    break;
                }
                c11 = 65535;
                break;
            case -1079884372:
                if (u11.equals("video/x-msvideo")) {
                    c11 = 11;
                    break;
                }
                c11 = 65535;
                break;
            case -1004728940:
                if (u11.equals(MimeTypes.TEXT_VTT)) {
                    c11 = '\f';
                    break;
                }
                c11 = 65535;
                break;
            case -879272239:
                if (u11.equals("image/bmp")) {
                    c11 = '\r';
                    break;
                }
                c11 = 65535;
                break;
            case -879258763:
                if (u11.equals("image/png")) {
                    c11 = 14;
                    break;
                }
                c11 = 65535;
                break;
            case -387023398:
                if (u11.equals("audio/x-matroska")) {
                    c11 = 15;
                    break;
                }
                c11 = 65535;
                break;
            case -43467528:
                if (u11.equals(MimeTypes.APPLICATION_WEBM)) {
                    c11 = 16;
                    break;
                }
                c11 = 65535;
                break;
            case 13915911:
                if (u11.equals("video/x-flv")) {
                    c11 = 17;
                    break;
                }
                c11 = 65535;
                break;
            case 187078296:
                if (u11.equals(MimeTypes.AUDIO_AC3)) {
                    c11 = 18;
                    break;
                }
                c11 = 65535;
                break;
            case 187078297:
                if (u11.equals("audio/ac4")) {
                    c11 = 19;
                    break;
                }
                c11 = 65535;
                break;
            case 187078669:
                if (u11.equals("audio/amr")) {
                    c11 = 20;
                    break;
                }
                c11 = 65535;
                break;
            case 187090232:
                if (u11.equals(MimeTypes.AUDIO_MP4)) {
                    c11 = 21;
                    break;
                }
                c11 = 65535;
                break;
            case 187091926:
                if (u11.equals("audio/ogg")) {
                    c11 = 22;
                    break;
                }
                c11 = 65535;
                break;
            case 187099443:
                if (u11.equals("audio/wav")) {
                    c11 = 23;
                    break;
                }
                c11 = 65535;
                break;
            case 1331848029:
                if (u11.equals(MimeTypes.VIDEO_MP4)) {
                    c11 = 24;
                    break;
                }
                c11 = 65535;
                break;
            case 1503095341:
                if (u11.equals(MimeTypes.AUDIO_AMR_NB)) {
                    c11 = 25;
                    break;
                }
                c11 = 65535;
                break;
            case 1504578661:
                if (u11.equals(MimeTypes.AUDIO_E_AC3)) {
                    c11 = 26;
                    break;
                }
                c11 = 65535;
                break;
            case 1504619009:
                if (u11.equals(MimeTypes.AUDIO_FLAC)) {
                    c11 = 27;
                    break;
                }
                c11 = 65535;
                break;
            case 1504824762:
                if (u11.equals("audio/midi")) {
                    c11 = 28;
                    break;
                }
                c11 = 65535;
                break;
            case 1504831518:
                if (u11.equals(MimeTypes.AUDIO_MPEG)) {
                    c11 = 29;
                    break;
                }
                c11 = 65535;
                break;
            case 1505118770:
                if (u11.equals(MimeTypes.AUDIO_WEBM)) {
                    c11 = 30;
                    break;
                }
                c11 = 65535;
                break;
            case 2039520277:
                if (u11.equals("video/x-matroska")) {
                    c11 = 31;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        switch (c11) {
            case 0:
            case 18:
            case 26:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case 15:
            case 16:
            case 30:
            case TEMPLATE_HTML_SIZE_VALUE:
                return 6;
            case 4:
            case 20:
            case 25:
                return 3;
            case 5:
                return 21;
            case 6:
            case 7:
                return 20;
            case '\b':
                return 14;
            case '\t':
                return 18;
            case '\n':
            case 21:
            case 24:
                return 8;
            case 11:
                return 16;
            case '\f':
                return 13;
            case '\r':
                return 19;
            case 14:
                return 17;
            case 17:
                return 5;
            case 19:
                return 1;
            case 22:
                return 9;
            case 23:
                return 12;
            case 27:
                return 4;
            case 28:
                return 15;
            case NOTIFICATION_REDIRECT_VALUE:
                return 7;
            default:
                return -1;
        }
    }

    public static int b(Map map) {
        List list = (List) map.get(HttpHeaders.CONTENT_TYPE);
        return a((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            return 20;
        }
        return lastPathSegment.endsWith(".avif") ? 21 : -1;
    }
}
