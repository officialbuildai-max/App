package y;

import androidx.collection.s;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0992a f78587a = new C0992a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f78588b = b.b(0.0f, 0.0f, 2, null);

    /* renamed from: y.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0992a {
        private C0992a() {
        }

        public /* synthetic */ C0992a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f78588b;
        }
    }

    public static long b(long j11) {
        return j11;
    }

    public static final boolean c(long j11, long j12) {
        return j11 == j12;
    }

    public static final float d(long j11) {
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static final float e(long j11) {
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static int f(long j11) {
        return s.a(j11);
    }

    public static String g(long j11) {
        if (d(j11) == e(j11)) {
            return "CornerRadius.circular(" + c.a(d(j11), 1) + ')';
        }
        return "CornerRadius.elliptical(" + c.a(d(j11), 1) + ", " + c.a(e(j11), 1) + ')';
    }
}
