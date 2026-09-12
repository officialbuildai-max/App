package kotlin;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class a extends DeepRecursiveScope implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    private Function3 f67186a;

    /* renamed from: b, reason: collision with root package name */
    private Object f67187b;

    /* renamed from: c, reason: collision with root package name */
    private Continuation f67188c;

    /* renamed from: d, reason: collision with root package name */
    private Object f67189d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Function3 block, Object obj) {
        super(null);
        Object obj2;
        Intrinsics.h(block, "block");
        this.f67186a = block;
        this.f67187b = obj;
        Intrinsics.f(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f67188c = this;
        obj2 = DeepRecursiveKt.f67150a;
        this.f67189d = obj2;
    }

    @Override // kotlin.DeepRecursiveScope
    public Object a(Object obj, Continuation continuation) {
        Intrinsics.f(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f67188c = continuation;
        this.f67187b = obj;
        Object f11 = IntrinsicsKt.f();
        if (f11 == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return f11;
    }

    public final Object e() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = this.f67189d;
            Continuation continuation = this.f67188c;
            if (continuation == null) {
                ResultKt.b(obj3);
                return obj3;
            }
            obj = DeepRecursiveKt.f67150a;
            if (Result.m1187equalsimpl0(obj, obj3)) {
                try {
                    Function3 function3 = this.f67186a;
                    Object obj4 = this.f67187b;
                    Object e11 = !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.e(function3, this, obj4, continuation) : ((Function3) TypeIntrinsics.e(function3, 3)).invoke(this, obj4, continuation);
                    if (e11 != IntrinsicsKt.f()) {
                        continuation.resumeWith(Result.m1185constructorimpl(e11));
                    }
                } catch (Throwable th2) {
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m1185constructorimpl(ResultKt.a(th2)));
                }
            } else {
                obj2 = DeepRecursiveKt.f67150a;
                this.f67189d = obj2;
                continuation.resumeWith(obj3);
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.f67188c = null;
        this.f67189d = obj;
    }
}
