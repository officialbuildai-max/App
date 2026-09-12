package hf;

import androidx.core.view.InputDeviceCompat;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.tencent.tinker.android.dex.DexException;
import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class b {
    public static short A(int i11) {
        return (short) (i11 >> 16);
    }

    public static short B(long j11) {
        return (short) (j11 >> 16);
    }

    public static short C(long j11) {
        return (short) (j11 >> 32);
    }

    public static short D(long j11) {
        return (short) (j11 >> 48);
    }

    public static short a(int i11) {
        if (((-65536) & i11) == 0) {
            return (short) i11;
        }
        throw new IllegalArgumentException("bogus unsigned code unit");
    }

    private static int b(int i11) {
        return i11 & 255;
    }

    private static int c(int i11) {
        return (i11 >> 8) & 255;
    }

    public static short d(int i11, int i12) {
        if ((i11 & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("bogus lowByte");
        }
        if ((i12 & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) (i11 | (i12 << 8));
        }
        throw new IllegalArgumentException("bogus highByte");
    }

    public static short e(int i11, int i12, int i13, int i14) {
        if ((i11 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus nibble0");
        }
        if ((i12 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus nibble1");
        }
        if ((i13 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus nibble2");
        }
        if ((i14 & (-16)) == 0) {
            return (short) (i11 | (i12 << 4) | (i13 << 8) | (i14 << 12));
        }
        throw new IllegalArgumentException("bogus nibble3");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0022. Please report as an issue. */
    public static void f(h hVar, e eVar) {
        hVar.d();
        while (hVar.f()) {
            int c11 = hVar.c();
            int g11 = hVar.g();
            int a11 = g.a(g11);
            int k11 = k(a11);
            int i11 = 0;
            boolean z10 = true;
            switch (k11) {
                case 1:
                    eVar.l(c11, a11, 0, 1, 0, 0L);
                case 2:
                    eVar.l(c11, a11, 0, 1, c11 + ((byte) c(g11)), 0L);
                case 3:
                    eVar.l(c11, a11, 0, 1, 0, c(g11));
                case 4:
                    eVar.f(c11, a11, 0, 1, 0, (x(g11) << 28) >> 28, w(g11));
                case 5:
                    eVar.f(c11, a11, 0, 1, 0, 0L, c(g11));
                case 6:
                    eVar.k(c11, a11, 0, 1, 0, 0L, w(g11), x(g11));
                case 7:
                    eVar.l(c11, a11, 0, 1, c11 + ((short) hVar.g()), c(g11));
                case 8:
                    eVar.f(c11, a11, hVar.g(), l(a11), 0, 0L, c(g11));
                case 9:
                    eVar.f(c11, a11, 0, 1, 0, ((short) hVar.g()) << (a11 == 21 ? (char) 16 : '0'), c(g11));
                case 10:
                    eVar.f(c11, a11, 0, 1, 0, (short) hVar.g(), c(g11));
                case 11:
                    eVar.f(c11, a11, 0, 1, c11 + ((short) hVar.g()), 0L, c(g11));
                case 12:
                    eVar.k(c11, a11, 0, 1, 0, (byte) c(r0), c(g11), b(hVar.g()));
                case 13:
                    eVar.k(c11, a11, hVar.g(), l(a11), 0, 0L, w(g11), x(g11));
                case 14:
                    eVar.k(c11, a11, 0, 1, 0, (short) hVar.g(), w(g11), x(g11));
                case 15:
                    eVar.k(c11, a11, 0, 1, c11 + ((short) hVar.g()), 0L, w(g11), x(g11));
                case 16:
                    eVar.k(c11, a11, 0, 1, 0, 0L, c(g11), hVar.g());
                case 17:
                    int c12 = c(g11);
                    int g12 = hVar.g();
                    eVar.j(c11, a11, 0, 1, 0, 0L, c12, b(g12), c(g12));
                case 18:
                    eVar.l(c11, a11, 0, 1, c11 + hVar.h(), c(g11));
                case 19:
                    eVar.f(c11, a11, hVar.h(), l(a11), 0, 0L, c(g11));
                case 20:
                    eVar.f(c11, a11, 0, 1, 0, hVar.h(), c(g11));
                case 21:
                    int c13 = c(g11);
                    int h11 = c11 + hVar.h();
                    if (a11 == 43 || a11 == 44) {
                        hVar.e(h11 + 1, c11);
                    }
                    eVar.f(c11, a11, 0, 1, h11, 0L, c13);
                    break;
                case 22:
                    eVar.k(c11, a11, 0, 1, 0, c(g11), hVar.g(), hVar.g());
                case 23:
                    int w11 = w(g11);
                    int x10 = x(g11);
                    int g13 = hVar.g();
                    int g14 = hVar.g();
                    int u11 = u(g14);
                    int v11 = v(g14);
                    int w12 = w(g14);
                    int x11 = x(g14);
                    int l11 = l(a11);
                    if (x10 == 0) {
                        eVar.l(c11, a11, g13, l11, 0, 0L);
                    } else if (x10 == 1) {
                        eVar.f(c11, a11, g13, l11, 0, 0L, u11);
                    } else if (x10 == 2) {
                        eVar.k(c11, a11, g13, l11, 0, 0L, u11, v11);
                    } else if (x10 == 3) {
                        eVar.j(c11, a11, g13, l11, 0, 0L, u11, v11, w12);
                    } else if (x10 == 4) {
                        eVar.c(c11, a11, g13, l11, 0, 0L, u11, v11, w12, x11);
                    } else {
                        if (x10 != 5) {
                            throw new DexException("bogus registerCount: " + p008if.a.f(x10));
                        }
                        eVar.b(c11, a11, g13, l11, 0, 0L, u11, v11, w12, x11, w11);
                    }
                case 24:
                    eVar.h(c11, a11, hVar.g(), l(a11), 0, 0L, hVar.g(), c(g11));
                case 25:
                    eVar.f(c11, a11, 0, 1, 0, hVar.i(), c(g11));
                case 26:
                    if (a11 != 250) {
                        throw new UnsupportedOperationException(String.valueOf(a11));
                    }
                    int w13 = w(g11);
                    int x12 = x(g11);
                    int g15 = hVar.g();
                    int g16 = hVar.g();
                    int u12 = u(g16);
                    int v12 = v(g16);
                    int w14 = w(g16);
                    int x13 = x(g16);
                    int g17 = hVar.g();
                    int l12 = l(a11);
                    if (x12 < 1 || x12 > 5) {
                        throw new DexException("bogus registerCount: " + p008if.a.f(x12));
                    }
                    eVar.d(c11, a11, g15, l12, g17, Arrays.copyOfRange(new int[]{u12, v12, w14, x13, w13}, 0, x12));
                    break;
                case 27:
                    if (a11 != 251) {
                        throw new UnsupportedOperationException(String.valueOf(a11));
                    }
                    eVar.e(c11, a11, hVar.g(), l(a11), hVar.g(), c(g11), hVar.g());
                case 28:
                    int b11 = hVar.b();
                    int g18 = hVar.g();
                    int h12 = hVar.h();
                    int[] iArr = new int[g18];
                    while (i11 < g18) {
                        iArr[i11] = hVar.h() + b11;
                        i11++;
                    }
                    eVar.g(c11, g11, h12, iArr);
                case NOTIFICATION_REDIRECT_VALUE:
                    int b12 = hVar.b();
                    int g19 = hVar.g();
                    int[] iArr2 = new int[g19];
                    int[] iArr3 = new int[g19];
                    for (int i12 = 0; i12 < g19; i12++) {
                        iArr2[i12] = hVar.h();
                    }
                    while (i11 < g19) {
                        iArr3[i11] = hVar.h() + b12;
                        i11++;
                    }
                    eVar.i(c11, g11, iArr2, iArr3);
                case 30:
                    int g20 = hVar.g();
                    int h13 = hVar.h();
                    if (g20 == 1) {
                        byte[] bArr = new byte[h13];
                        int i13 = 0;
                        while (i11 < h13) {
                            if (z10) {
                                i13 = hVar.g();
                            }
                            bArr[i11] = (byte) (i13 & 255);
                            i13 >>= 8;
                            i11++;
                            z10 = !z10;
                        }
                        eVar.a(c11, g11, bArr, h13, 1);
                    } else if (g20 == 2) {
                        short[] sArr = new short[h13];
                        while (i11 < h13) {
                            sArr[i11] = (short) hVar.g();
                            i11++;
                        }
                        eVar.a(c11, g11, sArr, h13, 2);
                    } else if (g20 == 4) {
                        int[] iArr4 = new int[h13];
                        while (i11 < h13) {
                            iArr4[i11] = hVar.h();
                            i11++;
                        }
                        eVar.a(c11, g11, iArr4, h13, 4);
                    } else {
                        if (g20 != 8) {
                            throw new DexException("bogus element_width: " + p008if.a.b(g20));
                        }
                        long[] jArr = new long[h13];
                        while (i11 < h13) {
                            jArr[i11] = hVar.i();
                            i11++;
                        }
                        eVar.a(c11, g11, jArr, h13, 8);
                    }
                default:
                    throw new DexException("Unknown instruction format: " + k11);
            }
        }
    }

    public static void g(i iVar, f fVar) {
        int i11 = fVar.f64560e;
        int k11 = k(i11);
        int i12 = 0;
        switch (k11) {
            case 1:
            case 3:
                iVar.h((short) i11);
                return;
            case 2:
                iVar.h(d(i11, r(fVar.f64562g, iVar.c())));
                return;
            case 4:
                iVar.h(d(i11, t(fVar.f64565j, o(fVar.f64563h))));
                return;
            case 5:
                iVar.h(d(i11, fVar.f64565j));
                return;
            case 6:
                iVar.h(d(i11, t(fVar.f64565j, fVar.f64566k)));
                return;
            case 7:
                iVar.i((short) i11, s(fVar.f64562g, iVar.c()));
                return;
            case 8:
                iVar.i(d(i11, fVar.f64565j), (short) fVar.f64561f);
                return;
            case 9:
                iVar.i(d(i11, fVar.f64565j), (short) (fVar.f64563h >> (i11 == 21 ? (char) 16 : '0')));
                return;
            case 10:
                iVar.i(d(i11, fVar.f64565j), p(fVar.f64563h));
                return;
            case 11:
                iVar.i(d(i11, fVar.f64565j), s(fVar.f64562g, iVar.c()));
                return;
            case 12:
                iVar.i(d(i11, fVar.f64565j), d(fVar.f64566k, m(fVar.f64563h)));
                return;
            case 13:
                iVar.i(d(i11, t(fVar.f64565j, fVar.f64566k)), (short) fVar.f64561f);
                return;
            case 14:
                iVar.i(d(i11, t(fVar.f64565j, fVar.f64566k)), p(fVar.f64563h));
                return;
            case 15:
                iVar.i(d(i11, t(fVar.f64565j, fVar.f64566k)), s(fVar.f64562g, iVar.c()));
                return;
            case 16:
                iVar.i(d(i11, fVar.f64565j), i(fVar.f64566k));
                return;
            case 17:
                iVar.i(d(i11, fVar.f64565j), d(fVar.f64566k, fVar.f64567l));
                return;
            case 18:
                int q11 = q(fVar.f64562g, iVar.c());
                iVar.j((short) i11, y(q11), A(q11));
                return;
            case 19:
                int i13 = fVar.f64561f;
                iVar.j(d(i11, fVar.f64565j), y(i13), A(i13));
                return;
            case 20:
                int n11 = n(fVar.f64563h);
                iVar.j(d(i11, fVar.f64565j), y(n11), A(n11));
                return;
            case 21:
                if (i11 == 43 || i11 == 44) {
                    iVar.e(fVar.f64562g, iVar.c());
                }
                int q12 = q(fVar.f64562g, iVar.c());
                iVar.j(d(i11, fVar.f64565j), y(q12), A(q12));
                return;
            case 22:
                iVar.j((short) i11, h(fVar.f64565j), i(fVar.f64566k));
                return;
            case 23:
                iVar.j(d(i11, t(fVar.f64569n, fVar.f64564i)), (short) fVar.f64561f, e(fVar.f64565j, fVar.f64566k, fVar.f64567l, fVar.f64568m));
                return;
            case 24:
                iVar.j(d(i11, fVar.f64564i), (short) fVar.f64561f, h(fVar.f64565j));
                return;
            case 25:
                long j11 = fVar.f64563h;
                iVar.l(d(i11, fVar.f64565j), z(j11), B(j11), C(j11), D(j11));
                return;
            case 26:
                iVar.k(d(i11, t(fVar.f64571p, fVar.f64564i)), (short) fVar.f64561f, e(fVar.f64567l, fVar.f64568m, fVar.f64569n, fVar.f64570o), (short) fVar.f64572q);
                return;
            case 27:
                iVar.k(d(i11, fVar.f64564i), (short) fVar.f64561f, j(fVar.f64567l), (short) fVar.f64572q);
                return;
            case 28:
                int[] iArr = fVar.f64574s;
                int b11 = iVar.b();
                iVar.h((short) i11);
                iVar.h(a(iArr.length));
                iVar.q(fVar.f64575t);
                int length = iArr.length;
                while (i12 < length) {
                    iVar.q(iArr[i12] - b11);
                    i12++;
                }
                return;
            case NOTIFICATION_REDIRECT_VALUE:
                int[] iArr2 = fVar.f64573r;
                int[] iArr3 = fVar.f64574s;
                int b12 = iVar.b();
                iVar.h((short) i11);
                iVar.h(a(iArr3.length));
                for (int i14 : iArr2) {
                    iVar.q(i14);
                }
                int length2 = iArr3.length;
                while (i12 < length2) {
                    iVar.q(iArr3[i12] - b12);
                    i12++;
                }
                return;
            case 30:
                short s11 = (short) fVar.f64576u;
                iVar.h((short) i11);
                iVar.h(s11);
                iVar.q(fVar.f64578w);
                Object obj = fVar.f64577v;
                if (s11 == 1) {
                    iVar.m((byte[]) obj);
                    return;
                }
                if (s11 == 2) {
                    iVar.p((short[]) obj);
                    return;
                }
                if (s11 == 4) {
                    iVar.n((int[]) obj);
                    return;
                } else {
                    if (s11 == 8) {
                        iVar.o((long[]) obj);
                        return;
                    }
                    throw new DexException("bogus element_width: " + p008if.a.b(s11));
                }
            default:
                throw new DexException("Unknown instruction format: " + k11);
        }
    }

    public static short h(int i11) {
        if (((-65536) & i11) == 0) {
            return (short) i11;
        }
        throw new DexException("Register A out of range: " + p008if.a.e(i11));
    }

    public static short i(int i11) {
        if (((-65536) & i11) == 0) {
            return (short) i11;
        }
        throw new DexException("Register B out of range: " + p008if.a.e(i11));
    }

    public static short j(int i11) {
        if (((-65536) & i11) == 0) {
            return (short) i11;
        }
        throw new DexException("Register C out of range: " + p008if.a.e(i11));
    }

    public static int k(int i11) {
        if (i11 == 512) {
            return 29;
        }
        if (i11 == 768) {
            return 30;
        }
        switch (i11) {
            case -1:
                return 1;
            case 0:
            case 14:
                return 3;
            case 1:
            case 4:
            case 7:
            case 33:
                return 6;
            case 2:
            case 5:
            case 8:
                return 16;
            case 3:
            case 6:
            case 9:
                return 22;
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
            case 39:
                return 5;
            case 18:
                return 4;
            case 19:
            case 22:
                return 10;
            case 20:
            case 23:
                return 20;
            case 21:
            case 25:
                return 9;
            case 24:
                return 25;
            case 26:
            case 28:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 34:
                return 8;
            case 27:
                return 19;
            case 32:
            case 35:
                return 13;
            case 36:
                return 23;
            case 37:
                return 24;
            case 38:
            case 43:
            case 44:
                return 21;
            case 40:
                return 2;
            case 41:
                return 7;
            case 42:
                return 18;
            case 45:
            case 46:
            case 47:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                return 17;
            case 50:
            case AD_REWARD_USER_VALUE:
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                return 15;
            case AD_VISIBILITY_VALUE:
            case 57:
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
            case 59:
            case 60:
            case 61:
                return 11;
            default:
                switch (i11) {
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                        return 17;
                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW /* 82 */:
                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                    case TmcConstants.NOTIFY_ADDHOME_API_SHOW /* 90 */:
                    case 91:
                    case 92:
                    case 93:
                    case MBSupportMuteAdType.REWARD_VIDEO /* 94 */:
                    case 95:
                        return 13;
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                    case 109:
                        return 8;
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case ASSET_WRITE_ERROR_VALUE:
                        return 23;
                    default:
                        switch (i11) {
                            case GZIP_ENCODE_ERROR_VALUE:
                            case ASSET_FAILED_STATUS_CODE_VALUE:
                            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                            case JSON_ENCODE_ERROR_VALUE:
                            case 120:
                                return 24;
                            default:
                                switch (i11) {
                                    case INVALID_RI_ENDPOINT_VALUE:
                                    case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                                    case INVALID_METRICS_ENDPOINT_VALUE:
                                    case 126:
                                    case 127:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case MRAID_JS_WRITE_FAILED_VALUE:
                                    case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
                                    case OMSDK_JS_WRITE_FAILED_VALUE:
                                    case 134:
                                    case 135:
                                    case PRIVACY_URL_ERROR_VALUE:
                                    case TPAT_RETRY_FAILED_VALUE:
                                    case 138:
                                    case 139:
                                    case 140:
                                    case 141:
                                    case 142:
                                    case 143:
                                    case 176:
                                    case 177:
                                    case 178:
                                    case 179:
                                    case 180:
                                    case 181:
                                    case 182:
                                    case 183:
                                    case 184:
                                    case 185:
                                    case 186:
                                    case 187:
                                    case 188:
                                    case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                                    case 190:
                                    case 191:
                                    case PsExtractor.AUDIO_STREAM /* 192 */:
                                    case 193:
                                    case 194:
                                    case 195:
                                    case 196:
                                    case 197:
                                    case 198:
                                    case 199:
                                    case 200:
                                    case 201:
                                    case AD_CONSUMED_VALUE:
                                    case AD_IS_LOADING_VALUE:
                                    case AD_ALREADY_LOADED_VALUE:
                                    case AD_IS_PLAYING_VALUE:
                                    case AD_ALREADY_FAILED_VALUE:
                                    case PLACEMENT_AD_TYPE_MISMATCH_VALUE:
                                        return 6;
                                    case 144:
                                    case 145:
                                    case 146:
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    case 151:
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 159:
                                    case 160:
                                    case 161:
                                    case 162:
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case 167:
                                    case 168:
                                    case 169:
                                    case 170:
                                    case 171:
                                    case 172:
                                    case 173:
                                    case 174:
                                    case 175:
                                        return 17;
                                    case INVALID_BID_PAYLOAD_VALUE:
                                    case INVALID_JSON_BID_PAYLOAD_VALUE:
                                    case AD_NOT_LOADED_VALUE:
                                    case 211:
                                    case PLACEMENT_SLEEP_VALUE:
                                    case INVALID_ADUNIT_BID_PAYLOAD_VALUE:
                                    case INVALID_GZIP_BID_PAYLOAD_VALUE:
                                    case AD_RESPONSE_EMPTY_VALUE:
                                        return 14;
                                    case AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE:
                                    case AD_RESPONSE_TIMED_OUT_VALUE:
                                    case MRAID_JS_DOES_NOT_EXIST_VALUE:
                                    case MRAID_JS_COPY_FAILED_VALUE:
                                    case AD_RESPONSE_RETRY_AFTER_VALUE:
                                    case AD_LOAD_FAIL_RETRY_AFTER_VALUE:
                                    case INVALID_WATERFALL_PLACEMENT_ID_VALUE:
                                    case STALE_CACHED_RESPONSE_VALUE:
                                    case 224:
                                    case 225:
                                    case 226:
                                        return 12;
                                    default:
                                        switch (i11) {
                                            case 250:
                                                return 26;
                                            case 251:
                                                return 27;
                                            case 252:
                                                return 23;
                                            case 253:
                                                return 24;
                                            case 254:
                                            case 255:
                                                return 8;
                                            case 256:
                                                return 28;
                                            default:
                                                return 0;
                                        }
                                }
                        }
                }
        }
    }

    public static int l(int i11) {
        if (i11 == 512 || i11 == 768) {
            return 1;
        }
        switch (i11) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
            case 50:
            case AD_REWARD_USER_VALUE:
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case AD_VISIBILITY_VALUE:
            case 57:
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
            case 59:
            case 60:
            case 61:
                return 1;
            case 26:
            case 27:
                return 3;
            case 28:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 32:
            case 34:
            case 35:
            case 36:
            case 37:
                return 2;
            default:
                switch (i11) {
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                        return 1;
                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW /* 82 */:
                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                    case TmcConstants.NOTIFY_ADDHOME_API_SHOW /* 90 */:
                    case 91:
                    case 92:
                    case 93:
                    case MBSupportMuteAdType.REWARD_VIDEO /* 94 */:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                    case 109:
                        return 5;
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case ASSET_WRITE_ERROR_VALUE:
                        return 4;
                    default:
                        switch (i11) {
                            case GZIP_ENCODE_ERROR_VALUE:
                            case ASSET_FAILED_STATUS_CODE_VALUE:
                            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                            case JSON_ENCODE_ERROR_VALUE:
                            case 120:
                                return 4;
                            default:
                                switch (i11) {
                                    case INVALID_RI_ENDPOINT_VALUE:
                                    case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                                    case INVALID_METRICS_ENDPOINT_VALUE:
                                    case 126:
                                    case 127:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case MRAID_JS_WRITE_FAILED_VALUE:
                                    case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
                                    case OMSDK_JS_WRITE_FAILED_VALUE:
                                    case 134:
                                    case 135:
                                    case PRIVACY_URL_ERROR_VALUE:
                                    case TPAT_RETRY_FAILED_VALUE:
                                    case 138:
                                    case 139:
                                    case 140:
                                    case 141:
                                    case 142:
                                    case 143:
                                    case 144:
                                    case 145:
                                    case 146:
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    case 151:
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 159:
                                    case 160:
                                    case 161:
                                    case 162:
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case 167:
                                    case 168:
                                    case 169:
                                    case 170:
                                    case 171:
                                    case 172:
                                    case 173:
                                    case 174:
                                    case 175:
                                    case 176:
                                    case 177:
                                    case 178:
                                    case 179:
                                    case 180:
                                    case 181:
                                    case 182:
                                    case 183:
                                    case 184:
                                    case 185:
                                    case 186:
                                    case 187:
                                    case 188:
                                    case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                                    case 190:
                                    case 191:
                                    case PsExtractor.AUDIO_STREAM /* 192 */:
                                    case 193:
                                    case 194:
                                    case 195:
                                    case 196:
                                    case 197:
                                    case 198:
                                    case 199:
                                    case 200:
                                    case 201:
                                    case AD_CONSUMED_VALUE:
                                    case AD_IS_LOADING_VALUE:
                                    case AD_ALREADY_LOADED_VALUE:
                                    case AD_IS_PLAYING_VALUE:
                                    case AD_ALREADY_FAILED_VALUE:
                                    case PLACEMENT_AD_TYPE_MISMATCH_VALUE:
                                    case INVALID_BID_PAYLOAD_VALUE:
                                    case INVALID_JSON_BID_PAYLOAD_VALUE:
                                    case AD_NOT_LOADED_VALUE:
                                    case 211:
                                    case PLACEMENT_SLEEP_VALUE:
                                    case INVALID_ADUNIT_BID_PAYLOAD_VALUE:
                                    case INVALID_GZIP_BID_PAYLOAD_VALUE:
                                    case AD_RESPONSE_EMPTY_VALUE:
                                    case AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE:
                                    case AD_RESPONSE_TIMED_OUT_VALUE:
                                    case MRAID_JS_DOES_NOT_EXIST_VALUE:
                                    case MRAID_JS_COPY_FAILED_VALUE:
                                    case AD_RESPONSE_RETRY_AFTER_VALUE:
                                    case AD_LOAD_FAIL_RETRY_AFTER_VALUE:
                                    case INVALID_WATERFALL_PLACEMENT_ID_VALUE:
                                    case STALE_CACHED_RESPONSE_VALUE:
                                    case 224:
                                    case 225:
                                    case 226:
                                        return 1;
                                    default:
                                        switch (i11) {
                                            case 250:
                                            case 251:
                                                return 6;
                                            case 252:
                                            case 253:
                                                return 7;
                                            case 254:
                                                return 8;
                                            case 255:
                                                return 9;
                                            case 256:
                                                return 1;
                                            default:
                                                return 0;
                                        }
                                }
                        }
                }
        }
    }

    public static int m(long j11) {
        int i11 = (int) j11;
        if (j11 == ((byte) i11)) {
            return i11 & 255;
        }
        throw new DexException("Literal out of range: " + p008if.a.e(j11));
    }

    public static int n(long j11) {
        int i11 = (int) j11;
        if (j11 == i11) {
            return i11;
        }
        throw new DexException("Literal out of range: " + p008if.a.e(j11));
    }

    public static int o(long j11) {
        if (j11 >= -8 && j11 <= 7) {
            return ((int) j11) & 15;
        }
        throw new DexException("Literal out of range: " + p008if.a.e(j11));
    }

    public static short p(long j11) {
        short s11 = (short) j11;
        if (j11 == s11) {
            return s11;
        }
        throw new DexException("Literal out of range: " + p008if.a.e(j11));
    }

    public static int q(int i11, int i12) {
        return i11 - i12;
    }

    public static int r(int i11, int i12) {
        int q11 = q(i11, i12);
        if (q11 == ((byte) q11)) {
            return q11 & 255;
        }
        throw new DexException("Target out of range: " + p008if.a.a(q11) + ", perhaps you need to enable force jumbo mode.");
    }

    public static short s(int i11, int i12) {
        int q11 = q(i11, i12);
        short s11 = (short) q11;
        if (q11 == s11) {
            return s11;
        }
        throw new DexException("Target out of range: " + p008if.a.a(q11) + ", perhaps you need to enable force jumbo mode.");
    }

    public static int t(int i11, int i12) {
        if ((i11 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus lowNibble");
        }
        if ((i12 & (-16)) == 0) {
            return i11 | (i12 << 4);
        }
        throw new IllegalArgumentException("bogus highNibble");
    }

    private static int u(int i11) {
        return i11 & 15;
    }

    private static int v(int i11) {
        return (i11 >> 4) & 15;
    }

    private static int w(int i11) {
        return (i11 >> 8) & 15;
    }

    private static int x(int i11) {
        return (i11 >> 12) & 15;
    }

    public static short y(int i11) {
        return (short) i11;
    }

    public static short z(long j11) {
        return (short) j11;
    }
}
