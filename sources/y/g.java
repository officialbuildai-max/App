package y;

import androidx.collection.s;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final a f78593b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f78594c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final long f78595d = e(9187343241974906880L);

    /* renamed from: e, reason: collision with root package name */
    private static final long f78596e = e(9205357640488583168L);

    /* renamed from: a, reason: collision with root package name */
    private final long f78597a;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return g.f78595d;
        }

        public final long b() {
            return g.f78596e;
        }

        public final long c() {
            return g.f78594c;
        }
    }

    private /* synthetic */ g(long j11) {
        this.f78597a = j11;
    }

    public static final /* synthetic */ g d(long j11) {
        return new g(j11);
    }

    public static long e(long j11) {
        return j11;
    }

    public static final long f(long j11, float f11, float f12) {
        return e((Float.floatToRawIntBits(f11) << 32) | (Float.floatToRawIntBits(f12) & 4294967295L));
    }

    public static /* synthetic */ long g(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Float.intBitsToFloat((int) (j11 >> 32));
        }
        if ((i11 & 2) != 0) {
            f12 = Float.intBitsToFloat((int) (4294967295L & j11));
        }
        return f(j11, f11, f12);
    }

    public static final long h(long j11, float f11) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) / f11;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) / f11;
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static boolean i(long j11, Object obj) {
        return (obj instanceof g) && j11 == ((g) obj).v();
    }

    public static final boolean j(long j11, long j12) {
        return j11 == j12;
    }

    public static final float k(long j11) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L));
        return (float) Math.sqrt((intBitsToFloat * intBitsToFloat) + (intBitsToFloat2 * intBitsToFloat2));
    }

    public static final float l(long j11) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L));
        return (intBitsToFloat * intBitsToFloat) + (intBitsToFloat2 * intBitsToFloat2);
    }

    public static final float m(long j11) {
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static final float n(long j11) {
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static int o(long j11) {
        return s.a(j11);
    }

    public static final boolean p(long j11) {
        long j12 = j11 & 9223372034707292159L;
        return (((~j12) & (j12 - 9187343246269874177L)) & (-9223372034707292160L)) == -9223372034707292160L;
    }

    public static final long q(long j11, long j12) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) - Float.intBitsToFloat((int) (j12 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) - Float.intBitsToFloat((int) (j12 & 4294967295L));
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static final long r(long j11, long j12) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat((int) (j12 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat((int) (j12 & 4294967295L));
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static final long s(long j11, float f11) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) * f11;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) * f11;
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static String t(long j11) {
        if (!h.c(j11)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + c.a(m(j11), 1) + ", " + c.a(n(j11), 1) + ')';
    }

    public static final long u(long j11) {
        return e(j11 ^ (-9223372034707292160L));
    }

    public boolean equals(Object obj) {
        return i(this.f78597a, obj);
    }

    public int hashCode() {
        return o(this.f78597a);
    }

    public String toString() {
        return t(this.f78597a);
    }

    public final /* synthetic */ long v() {
        return this.f78597a;
    }
}
