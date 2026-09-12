package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract /* synthetic */ class FlowKt__ShareKt {
    public static final c1 a(x0 x0Var) {
        return new z0(x0Var, null);
    }

    public static final i1 b(y0 y0Var) {
        return new a1(y0Var, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r3 == 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlinx.coroutines.flow.f1 c(kotlinx.coroutines.flow.b r7, int r8) {
        /*
            kotlinx.coroutines.channels.d$a r0 = kotlinx.coroutines.channels.d.f67809m1
            int r0 = r0.a()
            int r0 = kotlin.ranges.RangesKt.f(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3c
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.b r2 = r1.k()
            if (r2 == 0) goto L3c
            kotlinx.coroutines.flow.f1 r7 = new kotlinx.coroutines.flow.f1
            int r3 = r1.f67911b
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f67912c
            kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = r6
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f67912c
            kotlin.coroutines.CoroutineContext r1 = r1.f67910a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            kotlinx.coroutines.flow.f1 r8 = new kotlinx.coroutines.flow.f1
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.c(kotlinx.coroutines.flow.b, int):kotlinx.coroutines.flow.f1");
    }

    private static final t1 d(kotlinx.coroutines.n0 n0Var, CoroutineContext coroutineContext, b bVar, x0 x0Var, g1 g1Var, Object obj) {
        return kotlinx.coroutines.i.c(n0Var, coroutineContext, Intrinsics.c(g1Var, g1.f67906a.c()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(g1Var, bVar, x0Var, obj, null));
    }

    public static final i1 e(b bVar, kotlinx.coroutines.n0 n0Var, g1 g1Var, Object obj) {
        f1 c11 = c(bVar, 1);
        y0 a11 = j1.a(obj);
        return new a1(a11, d(n0Var, c11.f67905d, c11.f67902a, a11, g1Var, obj));
    }
}
