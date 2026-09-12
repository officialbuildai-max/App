package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final a f70735a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f70736b = b(0);

    /* renamed from: c, reason: collision with root package name */
    private static final long f70737c = b(9205357640488583168L);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return l.f70736b;
        }
    }

    public static long b(long j11) {
        return j11;
    }

    public static final float c(long j11) {
        return i.g(Float.intBitsToFloat((int) (j11 & 4294967295L)));
    }

    public static final float d(long j11) {
        return i.g(Float.intBitsToFloat((int) (j11 >> 32)));
    }
}
