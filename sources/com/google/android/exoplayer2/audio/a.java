package com.google.android.exoplayer2.audio;

import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.google.android.exoplayer2.ParserException;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f24650a = {RecorderConstants.RECORD_ENCODING_BITRATE_96000, 88200, RecorderConstants.RECORD_ENCODING_BITRATE_64000, 48000, RecorderConstants.RECORD_SAMPLE_RATE_44100, 32000, 24000, RecorderConstants.RECORD_SAMPLE_RATE_22050, 16000, 12000, RecorderConstants.RECORD_SAMPLE_RATE_11025, 8000, 7350};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f24651b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f24652a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24653b;

        /* renamed from: c, reason: collision with root package name */
        public final String f24654c;

        private b(int i11, int i12, String str) {
            this.f24652a = i11;
            this.f24653b = i12;
            this.f24654c = str;
        }
    }

    public static byte[] a(int i11, int i12) {
        int i13 = 0;
        int i14 = -1;
        int i15 = 0;
        while (true) {
            int[] iArr = f24650a;
            if (i15 >= iArr.length) {
                break;
            }
            if (i11 == iArr[i15]) {
                i14 = i15;
            }
            i15++;
        }
        int i16 = -1;
        while (true) {
            int[] iArr2 = f24651b;
            if (i13 >= iArr2.length) {
                break;
            }
            if (i12 == iArr2[i13]) {
                i16 = i13;
            }
            i13++;
        }
        if (i11 != -1 && i16 != -1) {
            return b(2, i14, i16);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i11 + ", " + i12);
    }

    public static byte[] b(int i11, int i12, int i13) {
        return new byte[]{(byte) (((i11 << 3) & 248) | ((i12 >> 1) & 7)), (byte) (((i12 << 7) & 128) | ((i13 << 3) & 120))};
    }

    private static int c(com.google.android.exoplayer2.util.c0 c0Var) {
        int h11 = c0Var.h(5);
        return h11 == 31 ? c0Var.h(6) + 32 : h11;
    }

    private static int d(com.google.android.exoplayer2.util.c0 c0Var) {
        int h11 = c0Var.h(4);
        if (h11 == 15) {
            return c0Var.h(24);
        }
        if (h11 < 13) {
            return f24650a[h11];
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b e(com.google.android.exoplayer2.util.c0 c0Var, boolean z10) {
        int c11 = c(c0Var);
        int d11 = d(c0Var);
        int h11 = c0Var.h(4);
        String str = "mp4a.40." + c11;
        if (c11 == 5 || c11 == 29) {
            d11 = d(c0Var);
            c11 = c(c0Var);
            if (c11 == 22) {
                h11 = c0Var.h(4);
            }
        }
        if (z10) {
            if (c11 != 1 && c11 != 2 && c11 != 3 && c11 != 4 && c11 != 6 && c11 != 7 && c11 != 17) {
                switch (c11) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported audio object type: " + c11);
                }
            }
            g(c0Var, c11, h11);
            switch (c11) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h12 = c0Var.h(2);
                    if (h12 == 2 || h12 == 3) {
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported epConfig: " + h12);
                    }
            }
        }
        int i11 = f24651b[h11];
        if (i11 != -1) {
            return new b(d11, i11, str);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b f(byte[] bArr) {
        return e(new com.google.android.exoplayer2.util.c0(bArr), false);
    }

    private static void g(com.google.android.exoplayer2.util.c0 c0Var, int i11, int i12) {
        if (c0Var.g()) {
            com.google.android.exoplayer2.util.s.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (c0Var.g()) {
            c0Var.r(14);
        }
        boolean g11 = c0Var.g();
        if (i12 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i11 == 6 || i11 == 20) {
            c0Var.r(3);
        }
        if (g11) {
            if (i11 == 22) {
                c0Var.r(16);
            }
            if (i11 == 17 || i11 == 19 || i11 == 20 || i11 == 23) {
                c0Var.r(3);
            }
            c0Var.r(1);
        }
    }
}
