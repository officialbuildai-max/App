package com.google.android.exoplayer2.audio;

import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes3.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f24668a = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f24669b = {RecorderConstants.RECORD_SAMPLE_RATE_44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f24670c = {32000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 160000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000, 288000, RecorderConstants.RECORD_ENCODING_BITRATE_320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f24671d = {32000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 144000, 160000, 176000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f24672e = {32000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 160000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000, RecorderConstants.RECORD_ENCODING_BITRATE_320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f24673f = {32000, 40000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 160000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 224000, RecorderConstants.RECORD_ENCODING_BITRATE_256000, RecorderConstants.RECORD_ENCODING_BITRATE_320000};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f24674g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 80000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, 112000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, 144000, 160000};

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f24675a;

        /* renamed from: b, reason: collision with root package name */
        public String f24676b;

        /* renamed from: c, reason: collision with root package name */
        public int f24677c;

        /* renamed from: d, reason: collision with root package name */
        public int f24678d;

        /* renamed from: e, reason: collision with root package name */
        public int f24679e;

        /* renamed from: f, reason: collision with root package name */
        public int f24680f;

        /* renamed from: g, reason: collision with root package name */
        public int f24681g;

        public boolean a(int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (!b0.l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
                return false;
            }
            this.f24675a = i12;
            this.f24676b = b0.f24668a[3 - i13];
            int i16 = b0.f24669b[i15];
            this.f24678d = i16;
            if (i12 == 2) {
                this.f24678d = i16 / 2;
            } else if (i12 == 0) {
                this.f24678d = i16 / 4;
            }
            int i17 = (i11 >>> 9) & 1;
            this.f24681g = b0.k(i12, i13);
            if (i13 == 3) {
                int i18 = i12 == 3 ? b0.f24670c[i14 - 1] : b0.f24671d[i14 - 1];
                this.f24680f = i18;
                this.f24677c = (((i18 * 12) / this.f24678d) + i17) * 4;
            } else {
                if (i12 == 3) {
                    int i19 = i13 == 2 ? b0.f24672e[i14 - 1] : b0.f24673f[i14 - 1];
                    this.f24680f = i19;
                    this.f24677c = ((i19 * 144) / this.f24678d) + i17;
                } else {
                    int i20 = b0.f24674g[i14 - 1];
                    this.f24680f = i20;
                    this.f24677c = (((i13 == 1 ? 72 : 144) * i20) / this.f24678d) + i17;
                }
            }
            this.f24679e = ((i11 >> 6) & 3) == 3 ? 1 : 2;
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
        int i16 = f24669b[i15];
        if (i12 == 2) {
            i16 /= 2;
        } else if (i12 == 0) {
            i16 /= 4;
        }
        int i17 = (i11 >>> 9) & 1;
        if (i13 == 3) {
            return ((((i12 == 3 ? f24670c[i14 - 1] : f24671d[i14 - 1]) * 12) / i16) + i17) * 4;
        }
        int i18 = i12 == 3 ? i13 == 2 ? f24672e[i14 - 1] : f24673f[i14 - 1] : f24674g[i14 - 1];
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
