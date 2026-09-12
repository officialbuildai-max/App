package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import androidx.media3.common.u;
import androidx.media3.common.util.q;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes7.dex */
public abstract class FfmpegLibrary {

    /* renamed from: a, reason: collision with root package name */
    private static final q f65406a;

    /* renamed from: b, reason: collision with root package name */
    private static String f65407b;

    /* renamed from: c, reason: collision with root package name */
    private static int f65408c;

    /* loaded from: classes7.dex */
    class a extends q {
        a(String... strArr) {
            super(strArr);
        }

        @Override // androidx.media3.common.util.q
        protected void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        u.a("media3.decoder.ffmpeg");
        f65406a = new a("media3ext");
        f65408c = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1662382439:
                if (str.equals(MimeTypes.VIDEO_MPEG)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1606874997:
                if (str.equals(MimeTypes.AUDIO_AMR_WB)) {
                    c11 = 3;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals(MimeTypes.AUDIO_DTS)) {
                    c11 = 4;
                    break;
                }
                break;
            case -1003765268:
                if (str.equals(MimeTypes.AUDIO_VORBIS)) {
                    c11 = 5;
                    break;
                }
                break;
            case -432837260:
                if (str.equals(MimeTypes.AUDIO_MPEG_L1)) {
                    c11 = 6;
                    break;
                }
                break;
            case -432837259:
                if (str.equals(MimeTypes.AUDIO_MPEG_L2)) {
                    c11 = 7;
                    break;
                }
                break;
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    c11 = '\b';
                    break;
                }
                break;
            case 5751993:
                if (str.equals(MimeTypes.VIDEO_MPEG2)) {
                    c11 = '\t';
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c11 = 11;
                    break;
                }
                break;
            case 1503095341:
                if (str.equals(MimeTypes.AUDIO_AMR_NB)) {
                    c11 = '\f';
                    break;
                }
                break;
            case 1504470054:
                if (str.equals(MimeTypes.AUDIO_ALAC)) {
                    c11 = '\r';
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c11 = 14;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals(MimeTypes.AUDIO_FLAC)) {
                    c11 = 15;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals(MimeTypes.AUDIO_MPEG)) {
                    c11 = 16;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals(MimeTypes.AUDIO_OPUS)) {
                    c11 = 17;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    c11 = 18;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals(MimeTypes.AUDIO_TRUEHD)) {
                    c11 = 19;
                    break;
                }
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c11 = 20;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c11 = 21;
                    break;
                }
                break;
            case 1903231877:
                if (str.equals(MimeTypes.AUDIO_ALAW)) {
                    c11 = 22;
                    break;
                }
                break;
            case 1903589369:
                if (str.equals(MimeTypes.AUDIO_MLAW)) {
                    c11 = 23;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 14:
                return "eac3";
            case 1:
                return "hevc";
            case 2:
                return "mpegvideo";
            case 3:
                return "amrwb";
            case 4:
            case 18:
                return "dca";
            case 5:
                return "vorbis";
            case 6:
            case 7:
            case 16:
                return "mp3";
            case '\b':
                return RecorderConstants.FORMAT_AAC;
            case '\t':
                return "mpeg2video";
            case '\n':
                return "ac3";
            case 11:
                return "h264";
            case '\f':
                return "amrnb";
            case '\r':
                return "alac";
            case 15:
                return "flac";
            case 17:
                return "opus";
            case 19:
                return "truehd";
            case 20:
                return "libvpx";
            case 21:
                return "libvpx-vp9";
            case 22:
                return "pcm_alaw";
            case 23:
                return "pcm_mulaw";
            default:
                return null;
        }
    }

    public static int b() {
        if (!d()) {
            return -1;
        }
        if (f65408c == -1) {
            f65408c = ffmpegGetInputBufferPaddingSize();
        }
        return f65408c;
    }

    public static String c() {
        if (!d()) {
            return null;
        }
        if (f65407b == null) {
            f65407b = ffmpegGetVersion();
        }
        return f65407b;
    }

    public static boolean d() {
        return f65406a.a();
    }

    public static boolean e(String str) {
        String a11;
        if (!d() || (a11 = a(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(a11)) {
            return true;
        }
        androidx.media3.common.util.u.h("FfmpegLibrary", "No " + a11 + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    private static native int ffmpegGetInputBufferPaddingSize();

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);
}
