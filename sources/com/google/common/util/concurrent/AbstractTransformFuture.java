package com.google.common.util.concurrent;

import com.google.common.util.concurrent.i;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractTransformFuture<I, O, F, T> extends i.a implements Runnable {
    F function;
    r inputFuture;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, f, r> {
        AsyncTransformFuture(r rVar, f fVar) {
            super(rVar, fVar);
        }

        /* renamed from: doTransform, reason: avoid collision after fix types in other method */
        r doTransform2(f fVar, I i11) throws Exception {
            r apply = fVar.apply(i11);
            com.google.common.base.m.q(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fVar);
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ r doTransform(f fVar, Object obj) throws Exception {
            android.support.v4.media.session.c.a(fVar);
            return doTransform2((f) null, (f) obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(r rVar) {
            setFuture(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, com.google.common.base.f, O> {
        TransformFuture(r rVar, com.google.common.base.f fVar) {
            super(rVar, fVar);
        }

        /* renamed from: doTransform, reason: avoid collision after fix types in other method */
        O doTransform2(com.google.common.base.f fVar, I i11) {
            return (O) fVar.apply(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ Object doTransform(com.google.common.base.f fVar, Object obj) throws Exception {
            return doTransform2(fVar, (com.google.common.base.f) obj);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        void setResult(O o11) {
            set(o11);
        }
    }

    AbstractTransformFuture(r rVar, F f11) {
        this.inputFuture = (r) com.google.common.base.m.o(rVar);
        this.function = (F) com.google.common.base.m.o(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> r create(r rVar, com.google.common.base.f fVar, Executor executor) {
        com.google.common.base.m.o(fVar);
        TransformFuture transformFuture = new TransformFuture(rVar, fVar);
        rVar.addListener(transformFuture, MoreExecutors.c(executor, transformFuture));
        return transformFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> r createAsync(r rVar, f fVar, Executor executor) {
        com.google.common.base.m.o(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(rVar, fVar);
        rVar.addListener(asyncTransformFuture, MoreExecutors.c(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    abstract T doTransform(F f11, I i11) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        r rVar = this.inputFuture;
        F f11 = this.function;
        String pendingToString = super.pendingToString();
        if (rVar != null) {
            str = "inputFuture=[" + rVar + "], ";
        } else {
            str = "";
        }
        if (f11 != null) {
            return str + "function=[" + f11 + "]";
        }
        if (pendingToString == null) {
            return null;
        }
        return str + pendingToString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        r rVar = this.inputFuture;
        F f11 = this.function;
        if ((isCancelled() | (rVar == null)) || (f11 == null)) {
            return;
        }
        this.inputFuture = null;
        if (rVar.isCancelled()) {
            setFuture(rVar);
            return;
        }
        try {
            try {
                Object doTransform = doTransform(f11, Futures.d(rVar));
                this.function = null;
                setResult(doTransform);
            } catch (Throwable th2) {
                try {
                    w.b(th2);
                    setException(th2);
                } finally {
                    this.function = null;
                }
            }
        } catch (Error e11) {
            setException(e11);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e12) {
            setException(e12.getCause());
        } catch (Exception e13) {
            setException(e13);
        }
    }

    abstract void setResult(T t11);
}
