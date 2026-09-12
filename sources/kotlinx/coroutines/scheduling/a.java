package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.k1;

/* loaded from: classes7.dex */
public final class a extends k1 implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final a f68054b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final i0 f68055c;

    static {
        int e11;
        h hVar = h.f68069a;
        e11 = c0.e("kotlinx.coroutines.io.parallelism", RangesKt.f(64, a0.a()), 0, 0, 12, null);
        f68055c = i0.limitedParallelism$default(hVar, e11, null, 2, null);
    }

    private a() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.k1
    public Executor d() {
        return this;
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f68055c.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.i0
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f68055c.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int i11, String str) {
        return h.f68069a.limitedParallelism(i11, str);
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return "Dispatchers.IO";
    }
}
