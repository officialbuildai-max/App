package com.google.common.math;

import com.google.common.base.m;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.math.RoundingMode;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f30942a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    static final int[] f30943b = {1, 10, 100, 1000, 10000, DefaultOggSeeker.MATCH_BYTE_RANGE, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f30944c = {3, 31, Sdk$SDKError.Reason.GENERATE_JSON_DATA_ERROR_VALUE, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f30945d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e, reason: collision with root package name */
    static int[] f30946e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* loaded from: classes4.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30947a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f30947a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30947a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30947a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30947a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30947a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30947a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30947a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30947a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i11, int i12) {
        long j11 = i11 + i12;
        int i13 = (int) j11;
        g.b(j11 == ((long) i13), "checkedAdd", i11, i12);
        return i13;
    }

    public static int b(int i11, int i12) {
        long j11 = i11 * i12;
        int i13 = (int) j11;
        g.b(j11 == ((long) i13), "checkedMultiply", i11, i12);
        return i13;
    }

    public static int c(int i11, int i12, RoundingMode roundingMode) {
        m.o(roundingMode);
        if (i12 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i13 = i11 / i12;
        int i14 = i11 - (i12 * i13);
        if (i14 == 0) {
            return i13;
        }
        int i15 = ((i11 ^ i12) >> 31) | 1;
        switch (a.f30947a[roundingMode.ordinal()]) {
            case 1:
                g.g(i14 == 0);
                return i13;
            case 2:
                return i13;
            case 3:
                if (i15 >= 0) {
                    return i13;
                }
                break;
            case 4:
                break;
            case 5:
                if (i15 <= 0) {
                    return i13;
                }
                break;
            case 6:
            case 7:
            case 8:
                int abs = Math.abs(i14);
                int abs2 = abs - (Math.abs(i12) - abs);
                if (abs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i13 & 1) != 0))) {
                            return i13;
                        }
                    }
                } else if (abs2 <= 0) {
                    return i13;
                }
                break;
            default:
                throw new AssertionError();
        }
        return i13 + i15;
    }

    public static boolean d(int i11) {
        return (i11 > 0) & ((i11 & (i11 + (-1))) == 0);
    }

    static int e(int i11, int i12) {
        return (~(~(i11 - i12))) >>> 31;
    }

    public static int f(int i11, RoundingMode roundingMode) {
        g.f("x", i11);
        switch (a.f30947a[roundingMode.ordinal()]) {
            case 1:
                g.g(d(i11));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i11 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i11);
                return (31 - numberOfLeadingZeros) + e((-1257966797) >>> numberOfLeadingZeros, i11);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i11);
    }

    public static int g(int i11, int i12) {
        if (i12 > 0) {
            int i13 = i11 % i12;
            return i13 >= 0 ? i13 : i13 + i12;
        }
        throw new ArithmeticException("Modulus " + i12 + " must be > 0");
    }

    public static int h(int i11, int i12) {
        return Ints.n(i11 + i12);
    }

    public static int i(int i11, int i12) {
        return Ints.n(i11 * i12);
    }
}
