package com.google.common.util.concurrent;

import com.google.common.util.concurrent.i;
import java.lang.Throwable;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends i.a implements Runnable {
    Class<X> exceptionType;
    F fallback;
    r inputFuture;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, f, r> {
        AsyncCatchingFuture(r rVar, Class<X> cls, f fVar) {
            super(rVar, cls, fVar);
        }

        /* renamed from: doFallback, reason: avoid collision after fix types in other method */
        r doFallback2(f fVar, X x10) throws Exception {
            r apply = fVar.apply(x10);
            com.google.common.base.m.q(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fVar);
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ r doFallback(f fVar, Throwable th2) throws Exception {
            android.support.v4.media.session.c.a(fVar);
            return doFallback2((f) null, (f) th2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(r rVar) {
            setFuture(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, com.google.common.base.f, V> {
        CatchingFuture(r rVar, Class<X> cls, com.google.common.base.f fVar) {
            super(rVar, cls, fVar);
        }

        /* renamed from: doFallback, reason: avoid collision after fix types in other method */
        V doFallback2(com.google.common.base.f fVar, X x10) throws Exception {
            return (V) fVar.apply(x10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ Object doFallback(com.google.common.base.f fVar, Throwable th2) throws Exception {
            return doFallback2(fVar, (com.google.common.base.f) th2);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        void setResult(V v11) {
            set(v11);
        }
    }

    AbstractCatchingFuture(r rVar, Class<X> cls, F f11) {
        this.inputFuture = (r) com.google.common.base.m.o(rVar);
        this.exceptionType = (Class) com.google.common.base.m.o(cls);
        this.fallback = (F) com.google.common.base.m.o(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V, X extends Throwable> r create(r rVar, Class<X> cls, com.google.common.base.f fVar, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(rVar, cls, fVar);
        rVar.addListener(catchingFuture, MoreExecutors.c(executor, catchingFuture));
        return catchingFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <X extends Throwable, V> r createAsync(r rVar, Class<X> cls, f fVar, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(rVar, cls, fVar);
        rVar.addListener(asyncCatchingFuture, MoreExecutors.c(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    abstract T doFallback(F f11, X x10) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        r rVar = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f11 = this.fallback;
        String pendingToString = super.pendingToString();
        if (rVar != null) {
            str = "inputFuture=[" + rVar + "], ";
        } else {
            str = "";
        }
        if (cls == null || f11 == null) {
            if (pendingToString == null) {
                return null;
            }
            return str + pendingToString;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f11 + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class<X extends java.lang.Throwable>, F] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r8 = this;
            com.google.common.util.concurrent.r r0 = r8.inputFuture
            java.lang.Class<X extends java.lang.Throwable> r1 = r8.exceptionType
            F r2 = r8.fallback
            r3 = 0
            r4 = 1
            if (r0 != 0) goto Lc
            r5 = r4
            goto Ld
        Lc:
            r5 = r3
        Ld:
            if (r1 != 0) goto L11
            r6 = r4
            goto L12
        L11:
            r6 = r3
        L12:
            r5 = r5 | r6
            if (r2 != 0) goto L16
            r3 = r4
        L16:
            r3 = r3 | r5
            if (r3 != 0) goto La3
            boolean r3 = r8.isCancelled()
            if (r3 == 0) goto L21
            goto La3
        L21:
            r3 = 0
            r8.inputFuture = r3
            boolean r4 = r0 instanceof gb.a     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            if (r4 == 0) goto L34
            r4 = r0
            gb.a r4 = (gb.a) r4     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            java.lang.Throwable r4 = gb.b.a(r4)     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            goto L35
        L30:
            r4 = move-exception
            goto L3c
        L32:
            r4 = move-exception
            goto L3e
        L34:
            r4 = r3
        L35:
            if (r4 != 0) goto L3c
            java.lang.Object r5 = com.google.common.util.concurrent.Futures.d(r0)     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            goto L71
        L3c:
            r5 = r3
            goto L71
        L3e:
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L6f
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Future type "
            r6.append(r7)
            java.lang.Class r7 = r0.getClass()
            r6.append(r7)
            java.lang.String r7 = " threw "
            r6.append(r7)
            java.lang.Class r4 = r4.getClass()
            r6.append(r4)
            java.lang.String r4 = " without a cause"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
        L6f:
            r4 = r5
            goto L3c
        L71:
            if (r4 != 0) goto L7b
            java.lang.Object r0 = com.google.common.util.concurrent.u.a(r5)
            r8.set(r0)
            return
        L7b:
            boolean r1 = com.google.common.util.concurrent.w.a(r4, r1)
            if (r1 != 0) goto L85
            r8.setFuture(r0)
            return
        L85:
            java.lang.Object r0 = r8.doFallback(r2, r4)     // Catch: java.lang.Throwable -> L91
            r8.exceptionType = r3
            r8.fallback = r3
            r8.setResult(r0)
            return
        L91:
            r0 = move-exception
            com.google.common.util.concurrent.w.b(r0)     // Catch: java.lang.Throwable -> L9d
            r8.setException(r0)     // Catch: java.lang.Throwable -> L9d
            r8.exceptionType = r3
            r8.fallback = r3
            return
        L9d:
            r0 = move-exception
            r8.exceptionType = r3
            r8.fallback = r3
            throw r0
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }

    abstract void setResult(T t11);
}
