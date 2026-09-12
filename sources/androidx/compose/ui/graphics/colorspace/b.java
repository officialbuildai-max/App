package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4419a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f4420b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f4421c;

    /* renamed from: d, reason: collision with root package name */
    private static final long f4422d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f4423e;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return b.f4422d;
        }

        public final long b() {
            return b.f4420b;
        }

        public final long c() {
            return b.f4421c;
        }
    }

    static {
        long j11 = 3;
        long j12 = j11 << 32;
        f4420b = d((0 & 4294967295L) | j12);
        f4421c = d((1 & 4294967295L) | j12);
        f4422d = d(j12 | (2 & 4294967295L));
        f4423e = d((j11 & 4294967295L) | (4 << 32));
    }

    public static long d(long j11) {
        return j11;
    }

    public static final boolean e(long j11, long j12) {
        return j11 == j12;
    }

    public static final int f(long j11) {
        return (int) (j11 >> 32);
    }

    public static int g(long j11) {
        return androidx.collection.s.a(j11);
    }

    public static String h(long j11) {
        return e(j11, f4420b) ? "Rgb" : e(j11, f4421c) ? "Xyz" : e(j11, f4422d) ? "Lab" : e(j11, f4423e) ? "Cmyk" : "Unknown";
    }
}
