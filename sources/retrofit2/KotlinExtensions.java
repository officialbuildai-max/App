package retrofit2;

import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
public abstract class KotlinExtensions {

    /* loaded from: classes7.dex */
    public static final class a implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f74458a;

        a(kotlinx.coroutines.n nVar) {
            this.f74458a = nVar;
        }

        @Override // retrofit2.f
        public void a(d call, Throwable t11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(t11, "t");
            kotlinx.coroutines.n nVar = this.f74458a;
            Result.Companion companion = Result.INSTANCE;
            nVar.resumeWith(Result.m1185constructorimpl(ResultKt.a(t11)));
        }

        @Override // retrofit2.f
        public void b(d call, j0 response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            if (!response.e()) {
                kotlinx.coroutines.n nVar = this.f74458a;
                Result.Companion companion = Result.INSTANCE;
                nVar.resumeWith(Result.m1185constructorimpl(ResultKt.a(new HttpException(response))));
                return;
            }
            Object a11 = response.a();
            if (a11 != null) {
                this.f74458a.resumeWith(Result.m1185constructorimpl(a11));
                return;
            }
            Object tag = call.request().tag(v.class);
            Intrinsics.e(tag);
            v vVar = (v) tag;
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + vVar.b().getName() + '.' + vVar.a().getName() + " was null but response body type was declared as non-null");
            kotlinx.coroutines.n nVar2 = this.f74458a;
            Result.Companion companion2 = Result.INSTANCE;
            nVar2.resumeWith(Result.m1185constructorimpl(ResultKt.a(kotlinNullPointerException)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f74459a;

        b(kotlinx.coroutines.n nVar) {
            this.f74459a = nVar;
        }

        @Override // retrofit2.f
        public void a(d call, Throwable t11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(t11, "t");
            kotlinx.coroutines.n nVar = this.f74459a;
            Result.Companion companion = Result.INSTANCE;
            nVar.resumeWith(Result.m1185constructorimpl(ResultKt.a(t11)));
        }

        @Override // retrofit2.f
        public void b(d call, j0 response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            if (response.e()) {
                kotlinx.coroutines.n nVar = this.f74459a;
                Result.Companion companion = Result.INSTANCE;
                nVar.resumeWith(Result.m1185constructorimpl(response.a()));
            } else {
                kotlinx.coroutines.n nVar2 = this.f74459a;
                Result.Companion companion2 = Result.INSTANCE;
                nVar2.resumeWith(Result.m1185constructorimpl(ResultKt.a(new HttpException(response))));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f74460a;

        c(kotlinx.coroutines.n nVar) {
            this.f74460a = nVar;
        }

        @Override // retrofit2.f
        public void a(d call, Throwable t11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(t11, "t");
            kotlinx.coroutines.n nVar = this.f74460a;
            Result.Companion companion = Result.INSTANCE;
            nVar.resumeWith(Result.m1185constructorimpl(ResultKt.a(t11)));
        }

        @Override // retrofit2.f
        public void b(d call, j0 response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            this.f74460a.resumeWith(Result.m1185constructorimpl(response));
        }
    }

    public static final Object a(final d dVar, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f67184a;
            }

            public final void invoke(Throwable th2) {
                dVar.cancel();
            }
        });
        dVar.h(new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final Object b(final d dVar, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f67184a;
            }

            public final void invoke(Throwable th2) {
                dVar.cancel();
            }
        });
        dVar.h(new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final Object c(final d dVar, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f67184a;
            }

            public final void invoke(Throwable th2) {
                dVar.cancel();
            }
        });
        dVar.h(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final Object d(d dVar, Continuation continuation) {
        Intrinsics.f(dVar, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return b(dVar, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(final java.lang.Throwable r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.L$0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            kotlin.ResultKt.b(r5)
            goto L5c
        L35:
            kotlin.ResultKt.b(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.i0 r5 = kotlinx.coroutines.y0.a()
            kotlin.coroutines.CoroutineContext r2 = r0.getF67151a()
            retrofit2.KotlinExtensions$suspendAndThrow$2$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$2$1
            r3.<init>()
            r5.dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.e(java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
