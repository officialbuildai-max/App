package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.u0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
public final class AndroidUiFrameClock implements androidx.compose.runtime.u0 {

    /* renamed from: a, reason: collision with root package name */
    private final Choreographer f5676a;

    /* renamed from: b, reason: collision with root package name */
    private final AndroidUiDispatcher f5677b;

    /* loaded from: classes.dex */
    static final class a implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f5678a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AndroidUiFrameClock f5679b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f5680c;

        a(kotlinx.coroutines.n nVar, AndroidUiFrameClock androidUiFrameClock, Function1 function1) {
            this.f5678a = nVar;
            this.f5679b = androidUiFrameClock;
            this.f5680c = function1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j11) {
            Object m1185constructorimpl;
            kotlinx.coroutines.n nVar = this.f5678a;
            Function1 function1 = this.f5680c;
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(function1.invoke(Long.valueOf(j11)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            nVar.resumeWith(m1185constructorimpl);
        }
    }

    public AndroidUiFrameClock(Choreographer choreographer, AndroidUiDispatcher androidUiDispatcher) {
        this.f5676a = choreographer;
        this.f5677b = androidUiDispatcher;
    }

    public final Choreographer a() {
        return this.f5676a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return u0.a.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return u0.a.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public /* synthetic */ CoroutineContext.Key getKey() {
        return androidx.compose.runtime.t0.a(this);
    }

    @Override // androidx.compose.runtime.u0
    public Object l(Function1 function1, Continuation continuation) {
        final AndroidUiDispatcher androidUiDispatcher = this.f5677b;
        if (androidUiDispatcher == null) {
            CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.INSTANCE);
            androidUiDispatcher = element instanceof AndroidUiDispatcher ? (AndroidUiDispatcher) element : null;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final a aVar = new a(cancellableContinuationImpl, this, function1);
        if (androidUiDispatcher == null || !Intrinsics.c(androidUiDispatcher.x(), a())) {
            a().postFrameCallback(aVar);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$2
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
                    AndroidUiFrameClock.this.a().removeFrameCallback(aVar);
                }
            });
        } else {
            androidUiDispatcher.a0(aVar);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$1
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
                    AndroidUiDispatcher.this.c0(aVar);
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return u0.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return u0.a.d(this, coroutineContext);
    }
}
