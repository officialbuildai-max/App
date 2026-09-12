package androidx.compose.ui.graphics;

import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4733b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f4734c = w1.d(4278190080L);

    /* renamed from: d, reason: collision with root package name */
    private static final long f4735d = w1.d(4282664004L);

    /* renamed from: e, reason: collision with root package name */
    private static final long f4736e = w1.d(4287137928L);

    /* renamed from: f, reason: collision with root package name */
    private static final long f4737f = w1.d(4291611852L);

    /* renamed from: g, reason: collision with root package name */
    private static final long f4738g = w1.d(4294967295L);

    /* renamed from: h, reason: collision with root package name */
    private static final long f4739h = w1.d(4294901760L);

    /* renamed from: i, reason: collision with root package name */
    private static final long f4740i = w1.d(4278255360L);

    /* renamed from: j, reason: collision with root package name */
    private static final long f4741j = w1.d(4278190335L);

    /* renamed from: k, reason: collision with root package name */
    private static final long f4742k = w1.d(4294967040L);

    /* renamed from: l, reason: collision with root package name */
    private static final long f4743l = w1.d(4278255615L);

    /* renamed from: m, reason: collision with root package name */
    private static final long f4744m = w1.d(4294902015L);

    /* renamed from: n, reason: collision with root package name */
    private static final long f4745n = w1.b(0);

    /* renamed from: o, reason: collision with root package name */
    private static final long f4746o = w1.a(0.0f, 0.0f, 0.0f, 0.0f, androidx.compose.ui.graphics.colorspace.g.f4428a.y());

    /* renamed from: a, reason: collision with root package name */
    private final long f4747a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return u1.f4734c;
        }

        public final long b() {
            return u1.f4741j;
        }

        public final long c() {
            return u1.f4739h;
        }

        public final long d() {
            return u1.f4745n;
        }

        public final long e() {
            return u1.f4746o;
        }

        public final long f() {
            return u1.f4738g;
        }
    }

    private /* synthetic */ u1(long j11) {
        this.f4747a = j11;
    }

    public static final /* synthetic */ u1 g(long j11) {
        return new u1(j11);
    }

    public static long h(long j11) {
        return j11;
    }

    public static final long i(long j11, androidx.compose.ui.graphics.colorspace.c cVar) {
        return androidx.compose.ui.graphics.colorspace.d.i(p(j11), cVar, 0, 2, null).a(j11);
    }

    public static final long j(long j11, float f11, float f12, float f13, float f14) {
        return w1.a(f12, f13, f14, f11, p(j11));
    }

    public static /* synthetic */ long k(long j11, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = n(j11);
        }
        float f15 = f11;
        if ((i11 & 2) != 0) {
            f12 = r(j11);
        }
        float f16 = f12;
        if ((i11 & 4) != 0) {
            f13 = q(j11);
        }
        float f17 = f13;
        if ((i11 & 8) != 0) {
            f14 = o(j11);
        }
        return j(j11, f15, f16, f17, f14);
    }

    public static boolean l(long j11, Object obj) {
        return (obj instanceof u1) && j11 == ((u1) obj).u();
    }

    public static final boolean m(long j11, long j12) {
        return ULong.e(j11, j12);
    }

    public static final float n(long j11) {
        float c11;
        float f11;
        if (ULong.b(63 & j11) == 0) {
            c11 = (float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 56) & 255));
            f11 = 255.0f;
        } else {
            c11 = (float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 6) & 1023));
            f11 = 1023.0f;
        }
        return c11 / f11;
    }

    public static final float o(long j11) {
        int i11;
        int i12;
        int i13;
        float f11;
        if (ULong.b(63 & j11) == 0) {
            return ((float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 32) & 255))) / 255.0f;
        }
        short b11 = (short) ULong.b(ULong.b(j11 >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i14 = 32768 & b11;
        int i15 = ((65535 & b11) >>> 10) & 31;
        int i16 = b11 & 1023;
        if (i15 != 0) {
            int i17 = i16 << 13;
            if (i15 == 31) {
                i11 = 255;
                if (i17 != 0) {
                    i17 |= 4194304;
                }
            } else {
                i11 = i15 + 112;
            }
            int i18 = i11;
            i12 = i17;
            i13 = i18;
        } else {
            if (i16 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i16 + 1056964608);
                f11 = z3.f4995c;
                float f12 = intBitsToFloat - f11;
                return i14 == 0 ? f12 : -f12;
            }
            i13 = 0;
            i12 = 0;
        }
        return Float.intBitsToFloat((i13 << 23) | (i14 << 16) | i12);
    }

    public static final androidx.compose.ui.graphics.colorspace.c p(long j11) {
        androidx.compose.ui.graphics.colorspace.g gVar = androidx.compose.ui.graphics.colorspace.g.f4428a;
        return gVar.l()[(int) ULong.b(j11 & 63)];
    }

    public static final float q(long j11) {
        int i11;
        int i12;
        int i13;
        float f11;
        if (ULong.b(63 & j11) == 0) {
            return ((float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 40) & 255))) / 255.0f;
        }
        short b11 = (short) ULong.b(ULong.b(j11 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i14 = 32768 & b11;
        int i15 = ((65535 & b11) >>> 10) & 31;
        int i16 = b11 & 1023;
        if (i15 != 0) {
            int i17 = i16 << 13;
            if (i15 == 31) {
                i11 = 255;
                if (i17 != 0) {
                    i17 |= 4194304;
                }
            } else {
                i11 = i15 + 112;
            }
            int i18 = i11;
            i12 = i17;
            i13 = i18;
        } else {
            if (i16 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i16 + 1056964608);
                f11 = z3.f4995c;
                float f12 = intBitsToFloat - f11;
                return i14 == 0 ? f12 : -f12;
            }
            i13 = 0;
            i12 = 0;
        }
        return Float.intBitsToFloat((i13 << 23) | (i14 << 16) | i12);
    }

    public static final float r(long j11) {
        int i11;
        int i12;
        int i13;
        float f11;
        if (ULong.b(63 & j11) == 0) {
            return ((float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 48) & 255))) / 255.0f;
        }
        short b11 = (short) ULong.b(ULong.b(j11 >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i14 = 32768 & b11;
        int i15 = ((65535 & b11) >>> 10) & 31;
        int i16 = b11 & 1023;
        if (i15 != 0) {
            int i17 = i16 << 13;
            if (i15 == 31) {
                i11 = 255;
                if (i17 != 0) {
                    i17 |= 4194304;
                }
            } else {
                i11 = i15 + 112;
            }
            int i18 = i11;
            i12 = i17;
            i13 = i18;
        } else {
            if (i16 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i16 + 1056964608);
                f11 = z3.f4995c;
                float f12 = intBitsToFloat - f11;
                return i14 == 0 ? f12 : -f12;
            }
            i13 = 0;
            i12 = 0;
        }
        return Float.intBitsToFloat((i13 << 23) | (i14 << 16) | i12);
    }

    public static int s(long j11) {
        return ULong.f(j11);
    }

    public static String t(long j11) {
        return "Color(" + r(j11) + ", " + q(j11) + ", " + o(j11) + ", " + n(j11) + ", " + p(j11).f() + ')';
    }

    public boolean equals(Object obj) {
        return l(this.f4747a, obj);
    }

    public int hashCode() {
        return s(this.f4747a);
    }

    public String toString() {
        return t(this.f4747a);
    }

    public final /* synthetic */ long u() {
        return this.f4747a;
    }
}
