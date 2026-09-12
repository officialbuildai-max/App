package l2;

import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes2.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f68722a = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f68723b = {RecorderConstants.RECORD_SAMPLE_RATE_44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f68724c = {32000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 160000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000, 288000, RecorderConstants.RECORD_ENCODING_BITRATE_320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f68725d = {32000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 144000, 160000, 176000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f68726e = {32000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 160000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000, RecorderConstants.RECORD_ENCODING_BITRATE_320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f68727f = {32000, 40000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 160000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000, RecorderConstants.RECORD_ENCODING_BITRATE_320000};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f68728g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 144000, 160000};

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f68729a;

        /* renamed from: b, reason: collision with root package name */
        public String f68730b;

        /* renamed from: c, reason: collision with root package name */
        public int f68731c;

        /* renamed from: d, reason: collision with root package name */
        public int f68732d;

        /* renamed from: e, reason: collision with root package name */
        public int f68733e;

        /* renamed from: f, reason: collision with root package name */
        public int f68734f;

        /* renamed from: g, reason: collision with root package name */
        public int f68735g;

        public a() {
        }

        public a(a aVar) {
            this.f68729a = aVar.f68729a;
            this.f68730b = aVar.f68730b;
            this.f68731c = aVar.f68731c;
            this.f68732d = aVar.f68732d;
            this.f68733e = aVar.f68733e;
            this.f68734f = aVar.f68734f;
            this.f68735g = aVar.f68735g;
        }

        public boolean a(int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (!i0.l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
                return false;
            }
            this.f68729a = i12;
            this.f68730b = i0.f68722a[3 - i13];
            int i16 = i0.f68723b[i15];
            this.f68732d = i16;
            if (i12 == 2) {
                this.f68732d = i16 / 2;
            } else if (i12 == 0) {
                this.f68732d = i16 / 4;
            }
            int i17 = (i11 >>> 9) & 1;
            this.f68735g = i0.k(i12, i13);
            if (i13 == 3) {
                int i18 = i12 == 3 ? i0.f68724c[i14 - 1] : i0.f68725d[i14 - 1];
                this.f68734f = i18;
                this.f68731c = (((i18 * 12) / this.f68732d) + i17) * 4;
            } else {
                if (i12 == 3) {
                    int i19 = i13 == 2 ? i0.f68726e[i14 - 1] : i0.f68727f[i14 - 1];
                    this.f68734f = i19;
                    this.f68731c = ((i19 * 144) / this.f68732d) + i17;
                } else {
                    int i20 = i0.f68728g[i14 - 1];
                    this.f68734f = i20;
                    this.f68731c = (((i13 == 1 ? 72 : 144) * i20) / this.f68732d) + i17;
                }
            }
            this.f68733e = ((i11 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (!l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return -1;
        }
        int i16 = f68723b[i15];
        if (i12 == 2) {
            i16 /= 2;
        } else if (i12 == 0) {
            i16 /= 4;
        }
        int i17 = (i11 >>> 9) & 1;
        if (i13 == 3) {
            return ((((i12 == 3 ? f68724c[i14 - 1] : f68725d[i14 - 1]) * 12) / i16) + i17) * 4;
        }
        int i18 = i12 == 3 ? i13 == 2 ? f68726e[i14 - 1] : f68727f[i14 - 1] : f68728g[i14 - 1];
        if (i12 == 3) {
            return ((i18 * 144) / i16) + i17;
        }
        return (((i13 == 1 ? 72 : 144) * i18) / i16) + i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i11, int i12) {
        if (i12 == 1) {
            return i11 == 3 ? 1152 : 576;
        }
        if (i12 == 2) {
            return 1152;
        }
        if (i12 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i11) {
        return (i11 & (-2097152)) == -2097152;
    }

    public static int m(int i11) {
        int i12;
        int i13;
        if (!l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0) {
            return -1;
        }
        int i14 = (i11 >>> 12) & 15;
        int i15 = (i11 >>> 10) & 3;
        if (i14 == 0 || i14 == 15 || i15 == 3) {
            return -1;
        }
        return k(i12, i13);
    }
}
