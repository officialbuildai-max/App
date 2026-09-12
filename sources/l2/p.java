package l2;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Settings;

/* loaded from: classes2.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f68785a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f68786b = {-1, 8000, 16000, 32000, -1, -1, RecorderConstants.RECORD_SAMPLE_RATE_11025, RecorderConstants.RECORD_SAMPLE_RATE_22050, RecorderConstants.RECORD_SAMPLE_RATE_44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f68787c = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f68788d = {8000, 16000, 32000, RecorderConstants.RECORD_ENCODING_BITRATE_64000, RecorderConstants.RECORD_ENCODING_BITRATE_128000, RecorderConstants.RECORD_SAMPLE_RATE_22050, RecorderConstants.RECORD_SAMPLE_RATE_44100, 88200, 176400, 352800, 12000, 24000, 48000, RecorderConstants.RECORD_ENCODING_BITRATE_96000, RecorderConstants.RECORD_ENCODING_BITRATE_192000, 384000};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f68789e = {5, 8, 10, 12};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f68790f = {6, 9, 12, 15};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f68791g = {2, 4, 6, 8};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f68792h = {9, 11, 13, 16};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f68793i = {5, 8, 10, 12};

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f68794a;

        /* renamed from: b, reason: collision with root package name */
        public final int f68795b;

        /* renamed from: c, reason: collision with root package name */
        public final int f68796c;

        /* renamed from: d, reason: collision with root package name */
        public final int f68797d;

        /* renamed from: e, reason: collision with root package name */
        public final long f68798e;

        /* renamed from: f, reason: collision with root package name */
        public final int f68799f;

        private b(String str, int i11, int i12, int i13, long j11, int i14) {
            this.f68794a = str;
            this.f68796c = i11;
            this.f68795b = i12;
            this.f68797d = i13;
            this.f68798e = j11;
            this.f68799f = i14;
        }
    }

    private static void a(byte[] bArr, int i11) {
        int i12 = i11 - 2;
        if (((bArr[i11 - 1] & 255) | ((bArr[i12] << 8) & Settings.DEFAULT_INITIAL_WINDOW_SIZE)) != a1.v(bArr, 0, i12, Settings.DEFAULT_INITIAL_WINDOW_SIZE)) {
            throw ParserException.createForMalformedContainer("CRC check failed", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4f
            r2 = -1
            if (r1 == r2) goto L3e
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L20:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5e
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
        L36:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5e
        L3e:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
            goto L36
        L4f:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L20
        L5e:
            if (r0 == 0) goto L64
            int r7 = r7 * 16
            int r7 = r7 / 14
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.p.b(byte[]):int");
    }

    public static int c(int i11) {
        if (i11 == 2147385345 || i11 == -25230976 || i11 == 536864768 || i11 == -14745368) {
            return 1;
        }
        if (i11 == 1683496997 || i11 == 622876772) {
            return 2;
        }
        if (i11 == 1078008818 || i11 == -233094848) {
            return 3;
        }
        return (i11 == 1908687592 || i11 == -398277519) ? 4 : 0;
    }

    private static androidx.media3.common.util.i0 d(byte[] bArr) {
        byte b11 = bArr[0];
        if (b11 == Byte.MAX_VALUE || b11 == 100 || b11 == 64 || b11 == 113) {
            return new androidx.media3.common.util.i0(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (e(copyOf)) {
            for (int i11 = 0; i11 < copyOf.length - 1; i11 += 2) {
                byte b12 = copyOf[i11];
                int i12 = i11 + 1;
                copyOf[i11] = copyOf[i12];
                copyOf[i12] = b12;
            }
        }
        androidx.media3.common.util.i0 i0Var = new androidx.media3.common.util.i0(copyOf);
        if (copyOf[0] == 31) {
            androidx.media3.common.util.i0 i0Var2 = new androidx.media3.common.util.i0(copyOf);
            while (i0Var2.b() >= 16) {
                i0Var2.r(2);
                i0Var.f(i0Var2.h(14), 14);
            }
        }
        i0Var.n(copyOf);
        return i0Var;
    }

    private static boolean e(byte[] bArr) {
        byte b11 = bArr[0];
        return b11 == -2 || b11 == -1 || b11 == 37 || b11 == -14 || b11 == -24;
    }

    public static int f(ByteBuffer byteBuffer) {
        int i11;
        byte b11;
        int i12;
        byte b12;
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return 4096;
        }
        int position = byteBuffer.position();
        byte b13 = byteBuffer.get(position);
        if (b13 != -2) {
            if (b13 == -1) {
                i11 = (byteBuffer.get(position + 4) & 7) << 4;
                b12 = byteBuffer.get(position + 7);
            } else if (b13 != 31) {
                i11 = (byteBuffer.get(position + 4) & 1) << 6;
                b11 = byteBuffer.get(position + 5);
            } else {
                i11 = (byteBuffer.get(position + 5) & 7) << 4;
                b12 = byteBuffer.get(position + 6);
            }
            i12 = b12 & 60;
            return (((i12 >> 2) | i11) + 1) * 32;
        }
        i11 = (byteBuffer.get(position + 5) & 1) << 6;
        b11 = byteBuffer.get(position + 4);
        i12 = b11 & 252;
        return (((i12 >> 2) | i11) + 1) * 32;
    }

    public static int g(byte[] bArr) {
        int i11;
        byte b11;
        int i12;
        byte b12;
        byte b13 = bArr[0];
        if (b13 != -2) {
            if (b13 == -1) {
                i11 = (bArr[4] & 7) << 4;
                b12 = bArr[7];
            } else if (b13 != 31) {
                i11 = (bArr[4] & 1) << 6;
                b11 = bArr[5];
            } else {
                i11 = (bArr[5] & 7) << 4;
                b12 = bArr[6];
            }
            i12 = b12 & 60;
            return (((i12 >> 2) | i11) + 1) * 32;
        }
        i11 = (bArr[5] & 1) << 6;
        b11 = bArr[4];
        i12 = b11 & 252;
        return (((i12 >> 2) | i11) + 1) * 32;
    }

    public static androidx.media3.common.r h(byte[] bArr, String str, String str2, int i11, String str3, DrmInitData drmInitData) {
        androidx.media3.common.util.i0 d11 = d(bArr);
        d11.r(60);
        int i12 = f68785a[d11.h(6)];
        int i13 = f68786b[d11.h(4)];
        int h11 = d11.h(5);
        int[] iArr = f68787c;
        int i14 = h11 >= iArr.length ? -1 : (iArr[h11] * 1000) / 2;
        d11.r(10);
        return new r.b().f0(str).U(str3).u0(MimeTypes.AUDIO_DTS).Q(i14).R(i12 + (d11.h(2) > 0 ? 1 : 0)).v0(i13).Y(drmInitData).j0(str2).s0(i11).N();
    }

    public static b i(byte[] bArr) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j11;
        int i16;
        androidx.media3.common.util.i0 d11 = d(bArr);
        d11.r(40);
        int h11 = d11.h(2);
        if (d11.g()) {
            i11 = 20;
            i12 = 12;
        } else {
            i11 = 16;
            i12 = 8;
        }
        d11.r(i12);
        int h12 = d11.h(i11) + 1;
        boolean g11 = d11.g();
        int i17 = 0;
        if (g11) {
            i13 = d11.h(2);
            int h13 = (d11.h(3) + 1) * 512;
            if (d11.g()) {
                d11.r(36);
            }
            int h14 = d11.h(3) + 1;
            int h15 = d11.h(3) + 1;
            if (h14 != 1 || h15 != 1) {
                throw ParserException.createForUnsupportedContainerFeature("Multiple audio presentations or assets not supported");
            }
            int i18 = h11 + 1;
            int h16 = d11.h(i18);
            for (int i19 = 0; i19 < i18; i19++) {
                if (((h16 >> i19) & 1) == 1) {
                    d11.r(8);
                }
            }
            if (d11.g()) {
                d11.r(2);
                int h17 = (d11.h(2) + 1) << 2;
                int h18 = d11.h(2) + 1;
                while (i17 < h18) {
                    d11.r(h17);
                    i17++;
                }
            }
            i17 = h13;
        } else {
            i13 = -1;
        }
        d11.r(i11);
        d11.r(12);
        if (g11) {
            if (d11.g()) {
                d11.r(4);
            }
            if (d11.g()) {
                d11.r(24);
            }
            if (d11.g()) {
                d11.s(d11.h(10) + 1);
            }
            d11.r(5);
            int i20 = f68788d[d11.h(4)];
            i15 = d11.h(8) + 1;
            i14 = i20;
        } else {
            i14 = -2147483647;
            i15 = -1;
        }
        if (g11) {
            if (i13 == 0) {
                i16 = 32000;
            } else if (i13 == 1) {
                i16 = RecorderConstants.RECORD_SAMPLE_RATE_44100;
            } else {
                if (i13 != 2) {
                    throw ParserException.createForMalformedContainer("Unsupported reference clock code in DTS HD header: " + i13, null);
                }
                i16 = 48000;
            }
            j11 = a1.e1(i17, 1000000L, i16);
        } else {
            j11 = C.TIME_UNSET;
        }
        return new b(MimeTypes.AUDIO_DTS_EXPRESS, i15, i14, h12, j11, 0);
    }

    public static int j(byte[] bArr) {
        androidx.media3.common.util.i0 d11 = d(bArr);
        d11.r(42);
        return d11.h(d11.g() ? 12 : 8) + 1;
    }

    public static b k(byte[] bArr, AtomicInteger atomicInteger) {
        int i11;
        long j11;
        int i12;
        int i13;
        androidx.media3.common.util.i0 d11 = d(bArr);
        int i14 = d11.h(32) == 1078008818 ? 1 : 0;
        int m11 = m(d11, f68789e, true) + 1;
        if (i14 == 0) {
            i11 = -2147483647;
            j11 = C.TIME_UNSET;
        } else {
            if (!d11.g()) {
                throw ParserException.createForUnsupportedContainerFeature("Only supports full channel mask-based audio presentation");
            }
            a(bArr, m11);
            int h11 = d11.h(2);
            if (h11 == 0) {
                i12 = 512;
            } else if (h11 == 1) {
                i12 = 480;
            } else {
                if (h11 != 2) {
                    throw ParserException.createForMalformedContainer("Unsupported base duration index in DTS UHD header: " + h11, null);
                }
                i12 = 384;
            }
            int h12 = i12 * (d11.h(3) + 1);
            int h13 = d11.h(2);
            if (h13 == 0) {
                i13 = 32000;
            } else if (h13 == 1) {
                i13 = RecorderConstants.RECORD_SAMPLE_RATE_44100;
            } else {
                if (h13 != 2) {
                    throw ParserException.createForMalformedContainer("Unsupported clock rate index in DTS UHD header: " + h13, null);
                }
                i13 = 48000;
            }
            if (d11.g()) {
                d11.r(36);
            }
            i11 = (1 << d11.h(2)) * i13;
            j11 = a1.e1(h12, 1000000L, i13);
        }
        int i15 = i11;
        long j12 = j11;
        int i16 = 0;
        for (int i17 = 0; i17 < i14; i17++) {
            i16 += m(d11, f68790f, true);
        }
        if (i14 != 0) {
            atomicInteger.set(m(d11, f68791g, true));
        }
        return new b("audio/vnd.dts.uhd;profile=p2", 2, i15, m11 + i16 + (atomicInteger.get() != 0 ? m(d11, f68792h, true) : 0), j12, 0);
    }

    public static int l(byte[] bArr) {
        androidx.media3.common.util.i0 d11 = d(bArr);
        d11.r(32);
        return m(d11, f68793i, true) + 1;
    }

    private static int m(androidx.media3.common.util.i0 i0Var, int[] iArr, boolean z10) {
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 3 && i0Var.g(); i13++) {
            i12++;
        }
        if (z10) {
            int i14 = 0;
            while (i11 < i12) {
                i14 += 1 << iArr[i11];
                i11++;
            }
            i11 = i14;
        }
        return i11 + i0Var.h(iArr[i12]);
    }
}
