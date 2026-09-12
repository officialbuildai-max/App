package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.c0;

/* loaded from: classes7.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f68063a = a0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b, reason: collision with root package name */
    public static final long f68064b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f68065c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f68066d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f68067e;

    /* renamed from: f, reason: collision with root package name */
    public static f f68068f;

    static {
        long f11;
        int e11;
        int e12;
        long f12;
        f11 = c0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f68064b = f11;
        e11 = c0.e("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.f(a0.a(), 2), 1, 0, 8, null);
        f68065c = e11;
        e12 = c0.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f68066d = e12;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f12 = c0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f68067e = timeUnit.toNanos(f12);
        f68068f = d.f68057a;
    }

    public static final Task b(Runnable runnable, long j11, boolean z10) {
        return new TaskImpl(runnable, j11, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(boolean z10) {
        return z10 ? "Blocking" : "Non-blocking";
    }
}
