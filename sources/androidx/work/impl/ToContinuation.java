package androidx.work.impl;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/work/impl/ToContinuation;", "T", "Ljava/lang/Runnable;", "Lcom/google/common/util/concurrent/r;", "futureToObserve", "Lkotlinx/coroutines/n;", "continuation", "<init>", "(Lcom/google/common/util/concurrent/r;Lkotlinx/coroutines/n;)V", "", "run", "()V", "Lcom/google/common/util/concurrent/r;", "getFutureToObserve", "()Lcom/google/common/util/concurrent/r;", "Lkotlinx/coroutines/n;", "getContinuation", "()Lkotlinx/coroutines/n;", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public final class ToContinuation<T> implements Runnable {
    private final kotlinx.coroutines.n continuation;
    private final com.google.common.util.concurrent.r futureToObserve;

    public ToContinuation(com.google.common.util.concurrent.r futureToObserve, kotlinx.coroutines.n continuation) {
        Intrinsics.h(futureToObserve, "futureToObserve");
        Intrinsics.h(continuation, "continuation");
        this.futureToObserve = futureToObserve;
        this.continuation = continuation;
    }

    public final kotlinx.coroutines.n getContinuation() {
        return this.continuation;
    }

    public final com.google.common.util.concurrent.r getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable f11;
        Object e11;
        if (this.futureToObserve.isCancelled()) {
            n.a.a(this.continuation, null, 1, null);
            return;
        }
        try {
            kotlinx.coroutines.n nVar = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            e11 = r1.e(this.futureToObserve);
            nVar.resumeWith(Result.m1185constructorimpl(e11));
        } catch (ExecutionException e12) {
            kotlinx.coroutines.n nVar2 = this.continuation;
            Result.Companion companion2 = Result.INSTANCE;
            f11 = r1.f(e12);
            nVar2.resumeWith(Result.m1185constructorimpl(ResultKt.a(f11)));
        }
    }
}
