package androidx.compose.animation.core;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
public abstract class SuspendAnimationKt {
    public static final Object b(float f11, float f12, float f13, g gVar, Function2 function2, Continuation continuation) {
        Object d11 = d(VectorConvertersKt.b(FloatCompanionObject.f67404a), Boxing.c(f11), Boxing.c(f12), Boxing.c(f13), gVar, function2, continuation);
        return d11 == IntrinsicsKt.f() ? d11 : Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f3 A[Catch: CancellationException -> 0x0045, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x0045, blocks: (B:13:0x0041, B:16:0x00e6, B:18:0x00f3), top: B:12:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r13v1, types: [androidx.compose.animation.core.f, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(final androidx.compose.animation.core.i r25, final androidx.compose.animation.core.c r26, long r27, final kotlin.jvm.functions.Function1 r29, kotlin.coroutines.Continuation r30) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.c(androidx.compose.animation.core.i, androidx.compose.animation.core.c, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object d(final s0 s0Var, Object obj, Object obj2, Object obj3, g gVar, final Function2 function2, Continuation continuation) {
        o g11;
        if (obj3 == null || (g11 = (o) s0Var.a().invoke(obj3)) == null) {
            g11 = p.g((o) s0Var.a().invoke(obj));
        }
        Object f11 = f(new i(s0Var, obj, g11, 0L, 0L, false, 56, null), new p0(gVar, s0Var, obj, obj2, g11), 0L, new Function1<f, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                invoke((f) obj4);
                return Unit.f67184a;
            }

            public final void invoke(f fVar) {
                function2.invoke(fVar.e(), s0Var.b().invoke(fVar.g()));
            }
        }, continuation, 2, null);
        return f11 == IntrinsicsKt.f() ? f11 : Unit.f67184a;
    }

    public static /* synthetic */ Object e(float f11, float f12, float f13, g gVar, Function2 function2, Continuation continuation, int i11, Object obj) {
        float f14 = (i11 & 4) != 0 ? 0.0f : f13;
        if ((i11 & 8) != 0) {
            gVar = h.d(0.0f, 0.0f, null, 7, null);
        }
        return b(f11, f12, f14, gVar, function2, continuation);
    }

    public static /* synthetic */ Object f(i iVar, c cVar, long j11, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = Long.MIN_VALUE;
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((f) obj2);
                    return Unit.f67184a;
                }

                public final void invoke(f fVar) {
                }
            };
        }
        return c(iVar, cVar, j12, function1, continuation);
    }

    public static final Object g(i iVar, w wVar, boolean z10, Function1 function1, Continuation continuation) {
        Object c11 = c(iVar, new v(wVar, iVar.e(), iVar.getValue(), iVar.g()), z10 ? iVar.d() : Long.MIN_VALUE, function1, continuation);
        return c11 == IntrinsicsKt.f() ? c11 : Unit.f67184a;
    }

    public static /* synthetic */ Object h(i iVar, w wVar, boolean z10, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((f) obj2);
                    return Unit.f67184a;
                }

                public final void invoke(f fVar) {
                }
            };
        }
        return g(iVar, wVar, z10, function1, continuation);
    }

    public static final Object i(i iVar, Object obj, g gVar, boolean z10, Function1 function1, Continuation continuation) {
        Object c11 = c(iVar, new p0(gVar, iVar.e(), iVar.getValue(), obj, iVar.g()), z10 ? iVar.d() : Long.MIN_VALUE, function1, continuation);
        return c11 == IntrinsicsKt.f() ? c11 : Unit.f67184a;
    }

    public static /* synthetic */ Object j(i iVar, Object obj, g gVar, boolean z10, Function1 function1, Continuation continuation, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            gVar = h.d(0.0f, 0.0f, null, 7, null);
        }
        g gVar2 = gVar;
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i11 & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((f) obj3);
                    return Unit.f67184a;
                }

                public final void invoke(f fVar) {
                }
            };
        }
        return i(iVar, obj, gVar2, z11, function1, continuation);
    }

    private static final Object k(c cVar, final Function1 function1, Continuation continuation) {
        return cVar.a() ? h0.a(function1, continuation) : androidx.compose.runtime.v0.b(new Function1<Long, Object>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final Object invoke(long j11) {
                return function1.invoke(Long.valueOf(j11));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).longValue());
            }
        }, continuation);
    }

    private static final void l(f fVar, long j11, long j12, c cVar, i iVar, Function1 function1) {
        fVar.j(j11);
        fVar.l(cVar.f(j12));
        fVar.m(cVar.b(j12));
        if (cVar.c(j12)) {
            fVar.i(fVar.c());
            fVar.k(false);
        }
        o(fVar, iVar);
        function1.invoke(fVar);
    }

    public static final void m(f fVar, long j11, float f11, c cVar, i iVar, Function1 function1) {
        l(fVar, j11, f11 == 0.0f ? cVar.d() : ((float) (j11 - fVar.d())) / f11, cVar, iVar, function1);
    }

    public static final float n(CoroutineContext coroutineContext) {
        androidx.compose.ui.j jVar = (androidx.compose.ui.j) coroutineContext.get(androidx.compose.ui.j.f5167a1);
        float k11 = jVar != null ? jVar.k() : 1.0f;
        if (!(k11 >= 0.0f)) {
            k0.b("negative scale factor");
        }
        return k11;
    }

    public static final void o(f fVar, i iVar) {
        iVar.l(fVar.e());
        p.f(iVar.g(), fVar.g());
        iVar.i(fVar.b());
        iVar.j(fVar.c());
        iVar.k(fVar.h());
    }
}
