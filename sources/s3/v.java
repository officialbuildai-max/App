package s3;

import androidx.media3.common.ParserException;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;

/* loaded from: classes2.dex */
abstract class v {

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f75375a;

        /* renamed from: b, reason: collision with root package name */
        public long f75376b;

        /* renamed from: c, reason: collision with root package name */
        public int f75377c;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f75378a;

        /* renamed from: b, reason: collision with root package name */
        public final int f75379b;

        /* renamed from: c, reason: collision with root package name */
        public final int f75380c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f75381d;

        private c(int i11, int i12, int i13, byte[] bArr) {
            this.f75378a = i11;
            this.f75379b = i12;
            this.f75380c = i13;
            this.f75381d = bArr;
        }
    }

    private static int a(int i11) {
        if (i11 == 0) {
            return 768;
        }
        if (i11 == 1) {
            return 1024;
        }
        if (i11 == 2 || i11 == 3) {
            return 2048;
        }
        if (i11 == 4) {
            return 4096;
        }
        throw ParserException.createForUnsupportedContainerFeature("Unsupported coreSbrFrameLengthIndex " + i11);
    }

    private static double b(int i11) {
        switch (i11) {
            case 14700:
            case 16000:
                return 3.0d;
            case RecorderConstants.RECORD_SAMPLE_RATE_22050 /* 22050 */:
            case 24000:
                return 2.0d;
            case 29400:
            case 32000:
            case 58800:
            case RecorderConstants.RECORD_ENCODING_BITRATE_64000 /* 64000 */:
                return 1.5d;
            case RecorderConstants.RECORD_SAMPLE_RATE_44100 /* 44100 */:
            case 48000:
            case 88200:
            case RecorderConstants.RECORD_ENCODING_BITRATE_96000 /* 96000 */:
                return 1.0d;
            default:
                throw ParserException.createForUnsupportedContainerFeature("Unsupported sampling rate " + i11);
        }
    }

    private static int c(int i11) {
        switch (i11) {
            case 0:
                return RecorderConstants.RECORD_ENCODING_BITRATE_96000;
            case 1:
                return 88200;
            case 2:
                return RecorderConstants.RECORD_ENCODING_BITRATE_64000;
            case 3:
                return 48000;
            case 4:
                return RecorderConstants.RECORD_SAMPLE_RATE_44100;
            case 5:
                return 32000;
            case 6:
                return 24000;
            case 7:
                return RecorderConstants.RECORD_SAMPLE_RATE_22050;
            case 8:
                return 16000;
            case 9:
                return 12000;
            case 10:
                return RecorderConstants.RECORD_SAMPLE_RATE_11025;
            case 11:
                return 8000;
            case 12:
                return 7350;
            case 13:
            case 14:
            default:
                throw ParserException.createForUnsupportedContainerFeature("Unsupported sampling rate index " + i11);
            case 15:
                return 57600;
            case 16:
                return com.transsnet.downloader.core.thread.b.SPEED_THRESHOLD;
            case 17:
                return 40000;
            case 18:
                return 38400;
            case 19:
                return 34150;
            case 20:
                return 28800;
            case 21:
                return 25600;
            case 22:
                return 20000;
            case 23:
                return 19200;
            case 24:
                return 17075;
            case 25:
                return 14400;
            case 26:
                return 12800;
            case 27:
                return 9600;
        }
    }

    private static int d(int i11) {
        if (i11 == 0 || i11 == 1) {
            return 0;
        }
        int i12 = 2;
        if (i11 != 2) {
            i12 = 3;
            if (i11 != 3) {
                if (i11 == 4) {
                    return 1;
                }
                throw ParserException.createForUnsupportedContainerFeature("Unsupported coreSbrFrameLengthIndex " + i11);
            }
        }
        return i12;
    }

    public static boolean e(int i11) {
        return (i11 & 16777215) == 12583333;
    }

    public static int f(androidx.media3.common.util.i0 i0Var) {
        if (!i0Var.g()) {
            return 0;
        }
        i0Var.r(2);
        return i0Var.h(13);
    }

    public static boolean g(androidx.media3.common.util.i0 i0Var, b bVar) {
        i0Var.d();
        int k11 = k(i0Var, 3, 8, 8);
        bVar.f75375a = k11;
        if (k11 == -1) {
            return false;
        }
        long l11 = l(i0Var, 2, 8, 32);
        bVar.f75376b = l11;
        if (l11 == -1) {
            return false;
        }
        if (l11 > 16) {
            throw ParserException.createForUnsupportedContainerFeature("Contains sub-stream with an invalid packet label " + bVar.f75376b);
        }
        if (l11 == 0) {
            int i11 = bVar.f75375a;
            if (i11 == 1) {
                throw ParserException.createForMalformedContainer("Mpegh3daConfig packet with invalid packet label 0", null);
            }
            if (i11 == 2) {
                throw ParserException.createForMalformedContainer("Mpegh3daFrame packet with invalid packet label 0", null);
            }
            if (i11 == 17) {
                throw ParserException.createForMalformedContainer("AudioTruncation packet with invalid packet label 0", null);
            }
        }
        int k12 = k(i0Var, 11, 24, 24);
        bVar.f75377c = k12;
        return k12 != -1;
    }

    public static c h(androidx.media3.common.util.i0 i0Var) {
        int h11 = i0Var.h(8);
        int h12 = i0Var.h(5);
        int h13 = h12 == 31 ? i0Var.h(24) : c(h12);
        int h14 = i0Var.h(3);
        int a11 = a(h14);
        int d11 = d(h14);
        i0Var.r(2);
        p(i0Var);
        m(i0Var, j(i0Var), d11);
        byte[] bArr = null;
        if (i0Var.g()) {
            int k11 = k(i0Var, 2, 4, 8) + 1;
            for (int i11 = 0; i11 < k11; i11++) {
                int k12 = k(i0Var, 4, 8, 16);
                int k13 = k(i0Var, 4, 8, 16);
                if (k12 == 7) {
                    int h15 = i0Var.h(4) + 1;
                    i0Var.r(4);
                    byte[] bArr2 = new byte[h15];
                    for (int i12 = 0; i12 < h15; i12++) {
                        bArr2[i12] = (byte) i0Var.h(8);
                    }
                    bArr = bArr2;
                } else {
                    i0Var.r(k13 * 8);
                }
            }
        }
        byte[] bArr3 = bArr;
        double b11 = b(h13);
        return new c(h11, (int) (h13 * b11), (int) (a11 * b11), bArr3);
    }

    private static boolean i(androidx.media3.common.util.i0 i0Var) {
        i0Var.r(3);
        boolean g11 = i0Var.g();
        if (g11) {
            i0Var.r(13);
        }
        return g11;
    }

    private static int j(androidx.media3.common.util.i0 i0Var) {
        int h11 = i0Var.h(5);
        int i11 = 0;
        for (int i12 = 0; i12 < h11 + 1; i12++) {
            int h12 = i0Var.h(3);
            i11 += k(i0Var, 5, 8, 16) + 1;
            if ((h12 == 0 || h12 == 2) && i0Var.g()) {
                p(i0Var);
            }
        }
        return i11;
    }

    private static int k(androidx.media3.common.util.i0 i0Var, int i11, int i12, int i13) {
        androidx.media3.common.util.a.a(Math.max(Math.max(i11, i12), i13) <= 31);
        int i14 = (1 << i11) - 1;
        int i15 = (1 << i12) - 1;
        com.google.common.math.d.a(com.google.common.math.d.a(i14, i15), 1 << i13);
        if (i0Var.b() < i11) {
            return -1;
        }
        int h11 = i0Var.h(i11);
        if (h11 != i14) {
            return h11;
        }
        if (i0Var.b() < i12) {
            return -1;
        }
        int h12 = i0Var.h(i12);
        int i16 = h11 + h12;
        if (h12 != i15) {
            return i16;
        }
        if (i0Var.b() < i13) {
            return -1;
        }
        return i16 + i0Var.h(i13);
    }

    private static long l(androidx.media3.common.util.i0 i0Var, int i11, int i12, int i13) {
        androidx.media3.common.util.a.a(Math.max(Math.max(i11, i12), i13) <= 63);
        long j11 = (1 << i11) - 1;
        long j12 = (1 << i12) - 1;
        com.google.common.math.f.a(com.google.common.math.f.a(j11, j12), 1 << i13);
        if (i0Var.b() < i11) {
            return -1L;
        }
        long j13 = i0Var.j(i11);
        if (j13 != j11) {
            return j13;
        }
        if (i0Var.b() < i12) {
            return -1L;
        }
        long j14 = i0Var.j(i12);
        long j15 = j13 + j14;
        if (j14 != j12) {
            return j15;
        }
        if (i0Var.b() < i13) {
            return -1L;
        }
        return j15 + i0Var.j(i13);
    }

    private static void m(androidx.media3.common.util.i0 i0Var, int i11, int i12) {
        int i13;
        int k11 = k(i0Var, 4, 8, 16) + 1;
        i0Var.q();
        for (int i14 = 0; i14 < k11; i14++) {
            int h11 = i0Var.h(2);
            if (h11 == 0) {
                i(i0Var);
                if (i12 > 0) {
                    o(i0Var);
                }
            } else if (h11 == 1) {
                if (i(i0Var)) {
                    i0Var.q();
                }
                if (i12 > 0) {
                    o(i0Var);
                    i13 = i0Var.h(2);
                } else {
                    i13 = 0;
                }
                if (i13 > 0) {
                    i0Var.r(6);
                    int h12 = i0Var.h(2);
                    i0Var.r(4);
                    if (i0Var.g()) {
                        i0Var.r(5);
                    }
                    if (i13 == 2 || i13 == 3) {
                        i0Var.r(6);
                    }
                    if (h12 == 2) {
                        i0Var.q();
                    }
                }
                int floor = ((int) Math.floor(Math.log(i11 - 1) / Math.log(2.0d))) + 1;
                int h13 = i0Var.h(2);
                if (h13 > 0 && i0Var.g()) {
                    i0Var.r(floor);
                }
                if (i0Var.g()) {
                    i0Var.r(floor);
                }
                if (i12 == 0 && h13 == 0) {
                    i0Var.q();
                }
            } else if (h11 == 3) {
                k(i0Var, 4, 8, 16);
                int k12 = k(i0Var, 4, 8, 16);
                if (i0Var.g()) {
                    k(i0Var, 8, 16, 0);
                }
                i0Var.q();
                if (k12 > 0) {
                    i0Var.r(k12 * 8);
                }
            }
        }
    }

    private static void n(androidx.media3.common.util.i0 i0Var, int i11) {
        int h11;
        boolean g11 = i0Var.g();
        int i12 = g11 ? 1 : 5;
        int i13 = g11 ? 7 : 5;
        int i14 = g11 ? 8 : 6;
        int i15 = 0;
        while (i15 < i11) {
            if (i0Var.g()) {
                i0Var.r(7);
                h11 = 0;
            } else {
                if (i0Var.h(2) == 3 && i0Var.h(i13) * i12 != 0) {
                    i0Var.q();
                }
                h11 = i0Var.h(i14) * i12;
                if (h11 != 0 && h11 != 180) {
                    i0Var.q();
                }
                i0Var.q();
            }
            if (h11 != 0 && h11 != 180 && i0Var.g()) {
                i15++;
            }
            i15++;
        }
    }

    private static void o(androidx.media3.common.util.i0 i0Var) {
        i0Var.r(3);
        i0Var.r(8);
        boolean g11 = i0Var.g();
        boolean g12 = i0Var.g();
        if (g11) {
            i0Var.r(5);
        }
        if (g12) {
            i0Var.r(6);
        }
    }

    private static void p(androidx.media3.common.util.i0 i0Var) {
        int h11 = i0Var.h(2);
        if (h11 == 0) {
            i0Var.r(6);
            return;
        }
        int k11 = k(i0Var, 5, 8, 16) + 1;
        if (h11 == 1) {
            i0Var.r(k11 * 7);
        } else if (h11 == 2) {
            n(i0Var, k11);
        }
    }
}
