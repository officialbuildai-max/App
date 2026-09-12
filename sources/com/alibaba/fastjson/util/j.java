package com.alibaba.fastjson.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.reflect.Array;
import java.math.BigInteger;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f18343a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f18344b;

    static {
        Class cls = Integer.TYPE;
        f18343a = (int[][]) Array.newInstance((Class<?>) cls, 326, 4);
        f18344b = (int[][]) Array.newInstance((Class<?>) cls, 291, 4);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger subtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger subtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i11 = 0;
        while (i11 < 326) {
            BigInteger pow = BigInteger.valueOf(5L).pow(i11);
            int bitLength = pow.bitLength();
            int i12 = i11 == 0 ? 1 : (int) (((i11 * 23219280) + 9999999) / 10000000);
            if (i12 != bitLength) {
                throw new IllegalStateException(bitLength + " != " + i12);
            }
            if (i11 < f18343a.length) {
                for (int i13 = 0; i13 < 4; i13++) {
                    f18343a[i11][i13] = pow.shiftRight((bitLength - 121) + ((3 - i13) * 31)).and(subtract).intValue();
                }
            }
            if (i11 < f18344b.length) {
                int i14 = bitLength + Sdk$SDKError.Reason.TPAT_ERROR_VALUE;
                BigInteger bigInteger2 = BigInteger.ONE;
                BigInteger add = bigInteger2.shiftLeft(i14).divide(pow).add(bigInteger2);
                for (int i15 = 0; i15 < 4; i15++) {
                    if (i15 == 0) {
                        f18344b[i11][i15] = add.shiftRight((3 - i15) * 31).intValue();
                    } else {
                        f18344b[i11][i15] = add.shiftRight((3 - i15) * 31).and(subtract2).intValue();
                    }
                }
            }
            i11++;
        }
    }

    public static int a(double d11, char[] cArr, int i11) {
        int i12;
        boolean z10;
        boolean z11;
        int i13;
        long j11;
        boolean z12;
        boolean z13;
        long j12;
        long j13;
        long j14;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z14;
        boolean z15;
        int i19;
        int i20;
        int i21;
        int i22;
        if (Double.isNaN(d11)) {
            cArr[i11] = 'N';
            cArr[i11 + 1] = 'a';
            i22 = i11 + 3;
            cArr[i11 + 2] = 'N';
        } else {
            if (d11 == Double.POSITIVE_INFINITY) {
                cArr[i11] = 'I';
                cArr[i11 + 1] = 'n';
                cArr[i11 + 2] = 'f';
                cArr[i11 + 3] = 'i';
                cArr[i11 + 4] = 'n';
                cArr[i11 + 5] = 'i';
                cArr[i11 + 6] = 't';
                cArr[i11 + 7] = 'y';
                return (i11 + 8) - i11;
            }
            if (d11 == Double.NEGATIVE_INFINITY) {
                cArr[i11] = '-';
                cArr[i11 + 1] = 'I';
                cArr[i11 + 2] = 'n';
                cArr[i11 + 3] = 'f';
                cArr[i11 + 4] = 'i';
                cArr[i11 + 5] = 'n';
                cArr[i11 + 6] = 'i';
                cArr[i11 + 7] = 't';
                i22 = i11 + 9;
                cArr[i11 + 8] = 'y';
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d11);
                if (doubleToLongBits != 0) {
                    if (doubleToLongBits == Long.MIN_VALUE) {
                        cArr[i11] = '-';
                        cArr[i11 + 1] = '0';
                        cArr[i11 + 2] = '.';
                        i18 = i11 + 4;
                        cArr[i11 + 3] = '0';
                    } else {
                        int i23 = (int) ((doubleToLongBits >>> 52) & 2047);
                        long j15 = doubleToLongBits & 4503599627370495L;
                        if (i23 == 0) {
                            i12 = -1074;
                        } else {
                            i12 = i23 - 1075;
                            j15 |= 4503599627370496L;
                        }
                        boolean z16 = doubleToLongBits < 0;
                        boolean z17 = (j15 & 1) == 0;
                        long j16 = 4 * j15;
                        long j17 = j16 + 2;
                        int i24 = (j15 != 4503599627370496L || i23 <= 1) ? 1 : 0;
                        long j18 = (j16 - 1) - i24;
                        int i25 = i12 - 2;
                        int i26 = 3;
                        if (i25 >= 0) {
                            int max = Math.max(0, ((int) ((i25 * 3010299) / 10000000)) - 1);
                            int i27 = (((-i25) + max) + ((max == 0 ? 1 : (int) (((max * 23219280) + 9999999) / 10000000)) + Sdk$SDKError.Reason.TPAT_ERROR_VALUE)) - 114;
                            if (i27 < 0) {
                                throw new IllegalArgumentException("" + i27);
                            }
                            int[] iArr = f18344b[max];
                            long j19 = j16 >>> 31;
                            long j20 = j16 & 2147483647L;
                            int i28 = iArr[0];
                            int i29 = iArr[1];
                            z10 = z16;
                            int i30 = iArr[2];
                            z11 = z17;
                            int i31 = iArr[3];
                            long j21 = ((((((((((((j20 * i31) >>> 31) + (i30 * j20)) + (j19 * i31)) >>> 31) + (i29 * j20)) + (i30 * j19)) >>> 31) + (i28 * j20)) + (i29 * j19)) >>> 21) + ((i28 * j19) << 10)) >>> i27;
                            long j22 = j17 >>> 31;
                            long j23 = j17 & 2147483647L;
                            long j24 = ((((((((((((j23 * i31) >>> 31) + (i30 * j23)) + (j22 * i31)) >>> 31) + (i29 * j23)) + (i30 * j22)) >>> 31) + (i28 * j23)) + (i29 * j22)) >>> 21) + ((i28 * j22) << 10)) >>> i27;
                            long j25 = j18 >>> 31;
                            long j26 = j18 & 2147483647L;
                            j11 = j24;
                            long j27 = ((((((((((((j26 * i31) >>> 31) + (i30 * j26)) + (j25 * i31)) >>> 31) + (i29 * j26)) + (i30 * j25)) >>> 31) + (i28 * j26)) + (i29 * j25)) >>> 21) + ((i28 * j25) << 10)) >>> i27;
                            if (max <= 21) {
                                long j28 = j16 % 5;
                                if (j28 == 0) {
                                    if (j28 != 0) {
                                        i21 = 0;
                                    } else if (j16 % 25 != 0) {
                                        i21 = 1;
                                    } else if (j16 % 125 != 0) {
                                        i21 = 2;
                                    } else if (j16 % 625 != 0) {
                                        i21 = 3;
                                    } else {
                                        long j29 = j16 / 625;
                                        i21 = 4;
                                        for (long j30 = 0; j29 > j30 && j29 % 5 == j30; j30 = 0) {
                                            j29 /= 5;
                                            i21++;
                                        }
                                    }
                                    if (i21 >= max) {
                                        z14 = true;
                                        z15 = false;
                                        z13 = z14;
                                        z12 = z15;
                                        i13 = max;
                                        j12 = j27;
                                        j13 = j21;
                                    }
                                } else if (z11) {
                                    if (j18 % 5 != 0) {
                                        i20 = 0;
                                    } else if (j18 % 25 != 0) {
                                        i20 = 1;
                                    } else if (j18 % 125 != 0) {
                                        i20 = 2;
                                    } else if (j18 % 625 != 0) {
                                        i20 = 3;
                                    } else {
                                        long j31 = j18 / 625;
                                        i20 = 4;
                                        for (long j32 = 0; j31 > j32 && j31 % 5 == j32; j32 = 0) {
                                            j31 /= 5;
                                            i20++;
                                        }
                                    }
                                    z15 = i20 >= max;
                                    z14 = false;
                                    z13 = z14;
                                    z12 = z15;
                                    i13 = max;
                                    j12 = j27;
                                    j13 = j21;
                                } else {
                                    if (j17 % 5 != 0) {
                                        i19 = 0;
                                    } else if (j17 % 25 != 0) {
                                        i19 = 1;
                                    } else if (j17 % 125 != 0) {
                                        i19 = 2;
                                    } else if (j17 % 625 != 0) {
                                        i19 = 3;
                                    } else {
                                        long j33 = j17 / 625;
                                        i19 = 4;
                                        for (long j34 = 0; j33 > j34 && j33 % 5 == j34; j34 = 0) {
                                            j33 /= 5;
                                            i19++;
                                        }
                                    }
                                    if (i19 >= max) {
                                        j11--;
                                    }
                                }
                            }
                            z14 = false;
                            z15 = false;
                            z13 = z14;
                            z12 = z15;
                            i13 = max;
                            j12 = j27;
                            j13 = j21;
                        } else {
                            z10 = z16;
                            z11 = z17;
                            int i32 = -i25;
                            int max2 = Math.max(0, ((int) ((i32 * 6989700) / 10000000)) - 1);
                            int i33 = i32 - max2;
                            int i34 = (max2 - ((i33 == 0 ? 1 : (int) (((i33 * 23219280) + 9999999) / 10000000)) - Sdk$SDKError.Reason.TPAT_ERROR_VALUE)) - 114;
                            if (i34 < 0) {
                                throw new IllegalArgumentException("" + i34);
                            }
                            int[] iArr2 = f18343a[i33];
                            long j35 = j16 >>> 31;
                            long j36 = j16 & 2147483647L;
                            int i35 = iArr2[0];
                            int i36 = iArr2[1];
                            int i37 = i24;
                            int i38 = iArr2[2];
                            int i39 = iArr2[3];
                            long j37 = ((((((((((((j36 * i39) >>> 31) + (i38 * j36)) + (j35 * i39)) >>> 31) + (i36 * j36)) + (i38 * j35)) >>> 31) + (i35 * j36)) + (i36 * j35)) >>> 21) + ((i35 * j35) << 10)) >>> i34;
                            long j38 = j17 >>> 31;
                            long j39 = j17 & 2147483647L;
                            long j40 = ((((((((((((i39 * j39) >>> 31) + (i38 * j39)) + (j38 * i39)) >>> 31) + (i36 * j39)) + (i38 * j38)) >>> 31) + (i35 * j39)) + (i36 * j38)) >>> 21) + ((i35 * j38) << 10)) >>> i34;
                            long j41 = j18 >>> 31;
                            long j42 = j18 & 2147483647L;
                            long j43 = ((((((((((((i39 * j42) >>> 31) + (i38 * j42)) + (j41 * i39)) >>> 31) + (i36 * j42)) + (i38 * j41)) >>> 31) + (i35 * j42)) + (i36 * j41)) >>> 21) + ((i35 * j41) << 10)) >>> i34;
                            int i40 = max2 + i25;
                            if (max2 <= 1) {
                                if (z11) {
                                    i13 = i40;
                                    z13 = true;
                                    j11 = j40;
                                    z12 = i37 == 1;
                                    j12 = j43;
                                    j13 = j37;
                                } else {
                                    j11 = j40 - 1;
                                    i13 = i40;
                                    z13 = true;
                                    z12 = false;
                                    j12 = j43;
                                    j13 = j37;
                                }
                            } else if (max2 < 63) {
                                i13 = i40;
                                z13 = (j16 & ((1 << (max2 - 1)) - 1)) == 0;
                                j11 = j40;
                                z12 = false;
                                j12 = j43;
                                j13 = j37;
                            } else {
                                i13 = i40;
                                j11 = j40;
                                z12 = false;
                                z13 = false;
                                j12 = j43;
                                j13 = j37;
                            }
                        }
                        if (j11 >= 1000000000000000000L) {
                            i26 = 19;
                        } else if (j11 >= 100000000000000000L) {
                            i26 = 18;
                        } else if (j11 >= 10000000000000000L) {
                            i26 = 17;
                        } else if (j11 >= 1000000000000000L) {
                            i26 = 16;
                        } else if (j11 >= 100000000000000L) {
                            i26 = 15;
                        } else if (j11 >= 10000000000000L) {
                            i26 = 14;
                        } else if (j11 >= 1000000000000L) {
                            i26 = 13;
                        } else if (j11 >= 100000000000L) {
                            i26 = 12;
                        } else if (j11 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                            i26 = 11;
                        } else if (j11 >= C.NANOS_PER_SECOND) {
                            i26 = 10;
                        } else if (j11 >= 100000000) {
                            i26 = 9;
                        } else if (j11 >= 10000000) {
                            i26 = 8;
                        } else if (j11 >= 1000000) {
                            i26 = 7;
                        } else if (j11 >= 100000) {
                            i26 = 6;
                        } else if (j11 >= 10000) {
                            i26 = 5;
                        } else if (j11 >= 1000) {
                            i26 = 4;
                        } else if (j11 < 100) {
                            i26 = j11 >= 10 ? 2 : 1;
                        }
                        int i41 = i13 + i26;
                        int i42 = i41 - 1;
                        boolean z18 = i42 < -3 || i42 >= 7;
                        if (z12 || z13) {
                            boolean z19 = z12;
                            boolean z20 = z13;
                            int i43 = 0;
                            int i44 = 0;
                            while (true) {
                                long j44 = j11 / 10;
                                long j45 = j12 / 10;
                                if (j44 <= j45 || (j11 < 100 && z18)) {
                                    break;
                                }
                                z19 &= j12 % 10 == 0;
                                z20 &= i43 == 0;
                                i43 = (int) (j13 % 10);
                                j13 /= 10;
                                i44++;
                                j11 = j44;
                                j12 = j45;
                            }
                            if (z19 && z11) {
                                while (j12 % 10 == 0 && (j11 >= 100 || !z18)) {
                                    z20 &= i43 == 0;
                                    i43 = (int) (j13 % 10);
                                    j11 /= 10;
                                    j13 /= 10;
                                    j12 /= 10;
                                    i44++;
                                }
                            }
                            if (z20 && i43 == 5 && j13 % 2 == 0) {
                                i43 = 4;
                            }
                            j14 = j13 + (((j13 != j12 || (z19 && z11)) && i43 < 5) ? 0 : 1);
                            i14 = i44;
                        } else {
                            i14 = 0;
                            int i45 = 0;
                            while (true) {
                                long j46 = j11 / 10;
                                long j47 = j12 / 10;
                                if (j46 <= j47 || (j11 < 100 && z18)) {
                                    break;
                                }
                                i45 = (int) (j13 % 10);
                                j13 /= 10;
                                i14++;
                                j11 = j46;
                                j12 = j47;
                            }
                            j14 = j13 + ((j13 == j12 || i45 >= 5) ? 1 : 0);
                        }
                        int i46 = i26 - i14;
                        if (z10) {
                            i15 = i11 + 1;
                            cArr[i11] = '-';
                        } else {
                            i15 = i11;
                        }
                        if (!z18) {
                            char c11 = '0';
                            if (i42 < 0) {
                                int i47 = i15 + 1;
                                cArr[i15] = '0';
                                int i48 = i15 + 2;
                                cArr[i47] = '.';
                                int i49 = -1;
                                while (i49 > i42) {
                                    cArr[i48] = c11;
                                    i49--;
                                    i48++;
                                    c11 = '0';
                                }
                                i16 = i48;
                                for (int i50 = 0; i50 < i46; i50++) {
                                    cArr[((i48 + i46) - i50) - 1] = (char) ((j14 % 10) + 48);
                                    j14 /= 10;
                                    i16++;
                                }
                            } else if (i41 >= i46) {
                                for (int i51 = 0; i51 < i46; i51++) {
                                    cArr[((i15 + i46) - i51) - 1] = (char) ((j14 % 10) + 48);
                                    j14 /= 10;
                                }
                                int i52 = i15 + i46;
                                while (i46 < i41) {
                                    cArr[i52] = '0';
                                    i46++;
                                    i52++;
                                }
                                cArr[i52] = '.';
                                i16 = i52 + 2;
                                cArr[i52 + 1] = '0';
                            } else {
                                int i53 = i15 + 1;
                                for (int i54 = 0; i54 < i46; i54++) {
                                    if ((i46 - i54) - 1 == i42) {
                                        cArr[((i53 + i46) - i54) - 1] = '.';
                                        i53--;
                                    }
                                    cArr[((i53 + i46) - i54) - 1] = (char) ((j14 % 10) + 48);
                                    j14 /= 10;
                                }
                                i16 = i15 + i46 + 1;
                            }
                            return i16 - i11;
                        }
                        for (int i55 = 0; i55 < i46 - 1; i55++) {
                            int i56 = (int) (j14 % 10);
                            j14 /= 10;
                            cArr[(i15 + i46) - i55] = (char) (i56 + 48);
                        }
                        cArr[i15] = (char) ((j14 % 10) + 48);
                        cArr[i15 + 1] = '.';
                        int i57 = i15 + i46 + 1;
                        if (i46 == 1) {
                            cArr[i57] = '0';
                            i57++;
                        }
                        int i58 = i57 + 1;
                        cArr[i57] = 'E';
                        if (i42 < 0) {
                            cArr[i58] = '-';
                            i42 = -i42;
                            i58 = i57 + 2;
                        }
                        if (i42 >= 100) {
                            int i59 = i58 + 1;
                            i17 = 48;
                            cArr[i58] = (char) ((i42 / 100) + 48);
                            i42 %= 100;
                            i58 += 2;
                            cArr[i59] = (char) ((i42 / 10) + 48);
                        } else {
                            i17 = 48;
                            if (i42 >= 10) {
                                cArr[i58] = (char) ((i42 / 10) + 48);
                                i58++;
                            }
                        }
                        i18 = i58 + 1;
                        cArr[i58] = (char) ((i42 % 10) + i17);
                    }
                    return i18 - i11;
                }
                cArr[i11] = '0';
                cArr[i11 + 1] = '.';
                i22 = i11 + 3;
                cArr[i11 + 2] = '0';
            }
        }
        return i22 - i11;
    }

    public static String b(double d11) {
        char[] cArr = new char[24];
        return new String(cArr, 0, a(d11, cArr, 0));
    }
}
