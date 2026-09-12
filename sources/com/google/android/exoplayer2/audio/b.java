package com.google.android.exoplayer2.audio;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.nio.ByteBuffer;
import okio.Utf8;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f24656a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f24657b = {48000, RecorderConstants.RECORD_SAMPLE_RATE_44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f24658c = {24000, RecorderConstants.RECORD_SAMPLE_RATE_22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f24659d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f24660e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 384, 448, 512, 576, 640};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f24661f = {69, 87, 104, Sdk$SDKError.Reason.TPAT_ERROR_VALUE, 139, 174, Sdk$SDKError.Reason.INVALID_BID_PAYLOAD_VALUE, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.audio.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0365b {

        /* renamed from: a, reason: collision with root package name */
        public final String f24662a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24663b;

        /* renamed from: c, reason: collision with root package name */
        public final int f24664c;

        /* renamed from: d, reason: collision with root package name */
        public final int f24665d;

        /* renamed from: e, reason: collision with root package name */
        public final int f24666e;

        /* renamed from: f, reason: collision with root package name */
        public final int f24667f;

        private C0365b(String str, int i11, int i12, int i13, int i14, int i15) {
            this.f24662a = str;
            this.f24663b = i11;
            this.f24665d = i12;
            this.f24664c = i13;
            this.f24666e = i14;
            this.f24667f = i15;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i11 = position; i11 <= limit; i11++) {
            if ((p0.I(byteBuffer, i11 + 4) & (-2)) == -126718022) {
                return i11 - position;
            }
        }
        return -1;
    }

    private static int b(int i11, int i12) {
        int i13 = i12 / 2;
        if (i11 < 0) {
            return -1;
        }
        int[] iArr = f24657b;
        if (i11 >= iArr.length || i12 < 0) {
            return -1;
        }
        int[] iArr2 = f24661f;
        if (i13 >= iArr2.length) {
            return -1;
        }
        int i14 = iArr[i11];
        if (i14 == 44100) {
            return (iArr2[i13] + (i12 % 2)) * 2;
        }
        int i15 = f24660e[i13];
        return i14 == 32000 ? i15 * 6 : i15 * 4;
    }

    public static o1 c(com.google.android.exoplayer2.util.d0 d0Var, String str, String str2, DrmInitData drmInitData) {
        int i11 = f24657b[(d0Var.D() & PsExtractor.AUDIO_STREAM) >> 6];
        int D = d0Var.D();
        int i12 = f24659d[(D & 56) >> 3];
        if ((D & 4) != 0) {
            i12++;
        }
        return new o1.b().S(str).e0(MimeTypes.AUDIO_AC3).H(i12).f0(i11).M(drmInitData).V(str2).E();
    }

    public static int d(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f24656a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0365b e(com.google.android.exoplayer2.util.c0 c0Var) {
        int b11;
        int i11;
        int i12;
        int i13;
        int i14;
        String str;
        int h11;
        int i15;
        int i16;
        int i17;
        int i18;
        int e11 = c0Var.e();
        c0Var.r(40);
        boolean z10 = c0Var.h(5) > 10;
        c0Var.p(e11);
        int i19 = -1;
        if (z10) {
            c0Var.r(16);
            int h12 = c0Var.h(2);
            if (h12 == 0) {
                i19 = 0;
            } else if (h12 == 1) {
                i19 = 1;
            } else if (h12 == 2) {
                i19 = 2;
            }
            c0Var.r(3);
            b11 = (c0Var.h(11) + 1) * 2;
            int h13 = c0Var.h(2);
            if (h13 == 3) {
                i11 = f24658c[c0Var.h(2)];
                i15 = 6;
                h11 = 3;
            } else {
                h11 = c0Var.h(2);
                i15 = f24656a[h11];
                i11 = f24657b[h13];
            }
            i13 = i15 * 256;
            int h14 = c0Var.h(3);
            boolean g11 = c0Var.g();
            i12 = f24659d[h14] + (g11 ? 1 : 0);
            c0Var.r(10);
            if (c0Var.g()) {
                c0Var.r(8);
            }
            if (h14 == 0) {
                c0Var.r(5);
                if (c0Var.g()) {
                    c0Var.r(8);
                }
            }
            if (i19 == 1 && c0Var.g()) {
                c0Var.r(16);
            }
            if (c0Var.g()) {
                if (h14 > 2) {
                    c0Var.r(2);
                }
                if ((h14 & 1) == 0 || h14 <= 2) {
                    i17 = 6;
                } else {
                    i17 = 6;
                    c0Var.r(6);
                }
                if ((h14 & 4) != 0) {
                    c0Var.r(i17);
                }
                if (g11 && c0Var.g()) {
                    c0Var.r(5);
                }
                if (i19 == 0) {
                    if (c0Var.g()) {
                        i18 = 6;
                        c0Var.r(6);
                    } else {
                        i18 = 6;
                    }
                    if (h14 == 0 && c0Var.g()) {
                        c0Var.r(i18);
                    }
                    if (c0Var.g()) {
                        c0Var.r(i18);
                    }
                    int h15 = c0Var.h(2);
                    if (h15 == 1) {
                        c0Var.r(5);
                    } else if (h15 == 2) {
                        c0Var.r(12);
                    } else if (h15 == 3) {
                        int h16 = c0Var.h(5);
                        if (c0Var.g()) {
                            c0Var.r(5);
                            if (c0Var.g()) {
                                c0Var.r(4);
                            }
                            if (c0Var.g()) {
                                c0Var.r(4);
                            }
                            if (c0Var.g()) {
                                c0Var.r(4);
                            }
                            if (c0Var.g()) {
                                c0Var.r(4);
                            }
                            if (c0Var.g()) {
                                c0Var.r(4);
                            }
                            if (c0Var.g()) {
                                c0Var.r(4);
                            }
                            if (c0Var.g()) {
                                c0Var.r(4);
                            }
                            if (c0Var.g()) {
                                if (c0Var.g()) {
                                    c0Var.r(4);
                                }
                                if (c0Var.g()) {
                                    c0Var.r(4);
                                }
                            }
                        }
                        if (c0Var.g()) {
                            c0Var.r(5);
                            if (c0Var.g()) {
                                c0Var.r(7);
                                if (c0Var.g()) {
                                    c0Var.r(8);
                                }
                            }
                        }
                        c0Var.r((h16 + 2) * 8);
                        c0Var.c();
                    }
                    if (h14 < 2) {
                        if (c0Var.g()) {
                            c0Var.r(14);
                        }
                        if (h14 == 0 && c0Var.g()) {
                            c0Var.r(14);
                        }
                    }
                    if (c0Var.g()) {
                        if (h11 == 0) {
                            c0Var.r(5);
                        } else {
                            for (int i20 = 0; i20 < i15; i20++) {
                                if (c0Var.g()) {
                                    c0Var.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (c0Var.g()) {
                c0Var.r(5);
                if (h14 == 2) {
                    c0Var.r(4);
                }
                if (h14 >= 6) {
                    c0Var.r(2);
                }
                if (c0Var.g()) {
                    c0Var.r(8);
                }
                if (h14 == 0 && c0Var.g()) {
                    c0Var.r(8);
                }
                if (h13 < 3) {
                    c0Var.q();
                }
            }
            if (i19 == 0 && h11 != 3) {
                c0Var.q();
            }
            if (i19 == 2 && (h11 == 3 || c0Var.g())) {
                i16 = 6;
                c0Var.r(6);
            } else {
                i16 = 6;
            }
            str = (c0Var.g() && c0Var.h(i16) == 1 && c0Var.h(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i14 = i19;
        } else {
            c0Var.r(32);
            int h17 = c0Var.h(2);
            String str2 = h17 == 3 ? null : MimeTypes.AUDIO_AC3;
            b11 = b(h17, c0Var.h(6));
            c0Var.r(8);
            int h18 = c0Var.h(3);
            if ((h18 & 1) != 0 && h18 != 1) {
                c0Var.r(2);
            }
            if ((h18 & 4) != 0) {
                c0Var.r(2);
            }
            if (h18 == 2) {
                c0Var.r(2);
            }
            int[] iArr = f24657b;
            i11 = h17 < iArr.length ? iArr[h17] : -1;
            i12 = f24659d[h18] + (c0Var.g() ? 1 : 0);
            i13 = 1536;
            i14 = -1;
            str = str2;
        }
        return new C0365b(str, i14, i12, i11, b11, i13);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b11 = bArr[4];
        return b((b11 & 192) >> 6, b11 & Utf8.REPLACEMENT_BYTE);
    }

    public static o1 g(com.google.android.exoplayer2.util.d0 d0Var, String str, String str2, DrmInitData drmInitData) {
        d0Var.Q(2);
        int i11 = f24657b[(d0Var.D() & PsExtractor.AUDIO_STREAM) >> 6];
        int D = d0Var.D();
        int i12 = f24659d[(D & 14) >> 1];
        if ((D & 1) != 0) {
            i12++;
        }
        if (((d0Var.D() & 30) >> 1) > 0 && (2 & d0Var.D()) != 0) {
            i12 += 2;
        }
        return new o1.b().S(str).e0((d0Var.a() <= 0 || (d0Var.D() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC).H(i12).f0(i11).M(drmInitData).V(str2).E();
    }

    public static int h(ByteBuffer byteBuffer, int i11) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i11) + ((byteBuffer.get((byteBuffer.position() + i11) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int i(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b11 = bArr[7];
            if ((b11 & 254) == 186) {
                return 40 << ((bArr[(b11 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
