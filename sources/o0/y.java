package o0;

import com.cloud.tmc.kernel.constants.TmcConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    public static final a f70755b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f70756c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final long f70757d = e(TmcConstants.TEMP_FILE_RUNTIME_MAX_SIZE);

    /* renamed from: e, reason: collision with root package name */
    private static final long f70758e = e(8589934592L);

    /* renamed from: a, reason: collision with root package name */
    private final long f70759a;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return y.f70758e;
        }

        public final long b() {
            return y.f70757d;
        }

        public final long c() {
            return y.f70756c;
        }
    }

    private /* synthetic */ y(long j11) {
        this.f70759a = j11;
    }

    public static final /* synthetic */ y d(long j11) {
        return new y(j11);
    }

    public static long e(long j11) {
        return j11;
    }

    public static boolean f(long j11, Object obj) {
        return (obj instanceof y) && j11 == ((y) obj).j();
    }

    public static final boolean g(long j11, long j12) {
        return j11 == j12;
    }

    public static int h(long j11) {
        return androidx.collection.s.a(j11);
    }

    public static String i(long j11) {
        return g(j11, f70756c) ? "Unspecified" : g(j11, f70757d) ? "Sp" : g(j11, f70758e) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.f70759a, obj);
    }

    public int hashCode() {
        return h(this.f70759a);
    }

    public final /* synthetic */ long j() {
        return this.f70759a;
    }

    public String toString() {
        return i(this.f70759a);
    }
}
