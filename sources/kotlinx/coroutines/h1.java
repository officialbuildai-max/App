package kotlinx.coroutines;

/* loaded from: classes7.dex */
public abstract class h1 {

    /* renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.z f67957a = new kotlinx.coroutines.internal.z("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.z f67958b = new kotlinx.coroutines.internal.z("CLOSED_EMPTY");

    public static final long c(long j11) {
        if (j11 <= 0) {
            return 0L;
        }
        if (j11 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j11;
    }
}
