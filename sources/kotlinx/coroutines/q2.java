package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes7.dex */
public final class q2 extends kotlinx.coroutines.internal.v {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal f68034a;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q2(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.Continuation r4) {
        /*
            r2 = this;
            kotlinx.coroutines.r2 r0 = kotlinx.coroutines.r2.f68038a
            kotlin.coroutines.CoroutineContext$Element r1 = r3.get(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f68034a = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor.INSTANCE
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.i0
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.g0.i(r3, r4)
            kotlinx.coroutines.internal.g0.f(r3, r4)
            r2.Y(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.q2.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }

    public final boolean X() {
        boolean z10 = this.threadLocalIsSet && this.f68034a.get() == null;
        this.f68034a.remove();
        return !z10;
    }

    public final void Y(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f68034a.set(TuplesKt.a(coroutineContext, obj));
    }

    @Override // kotlinx.coroutines.internal.v, kotlinx.coroutines.a
    protected void afterResume(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.f68034a.get();
            if (pair != null) {
                kotlinx.coroutines.internal.g0.f((CoroutineContext) pair.component1(), pair.component2());
            }
            this.f68034a.remove();
        }
        Object a11 = c0.a(obj, this.uCont);
        Continuation<Object> continuation = this.uCont;
        CoroutineContext context = continuation.getContext();
        Object i11 = kotlinx.coroutines.internal.g0.i(context, null);
        q2 m11 = i11 != kotlinx.coroutines.internal.g0.f67978a ? g0.m(continuation, context, i11) : null;
        try {
            this.uCont.resumeWith(a11);
            Unit unit = Unit.f67184a;
        } finally {
            if (m11 == null || m11.X()) {
                kotlinx.coroutines.internal.g0.f(context, i11);
            }
        }
    }
}
