package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
public final class Latch {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3688a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private List f3689b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List f3690c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f3691d = true;

    public final Object c(Continuation continuation) {
        if (e()) {
            return Unit.f67184a;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this.f3688a) {
            this.f3689b.add(cancellableContinuationImpl);
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Latch$await$2$2
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
                Object obj = Latch.this.f3688a;
                Latch latch = Latch.this;
                kotlinx.coroutines.n nVar = cancellableContinuationImpl;
                synchronized (obj) {
                    latch.f3689b.remove(nVar);
                    Unit unit = Unit.f67184a;
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    public final void d() {
        synchronized (this.f3688a) {
            this.f3691d = false;
            Unit unit = Unit.f67184a;
        }
    }

    public final boolean e() {
        boolean z10;
        synchronized (this.f3688a) {
            z10 = this.f3691d;
        }
        return z10;
    }

    public final void f() {
        synchronized (this.f3688a) {
            try {
                if (e()) {
                    return;
                }
                List list = this.f3689b;
                this.f3689b = this.f3690c;
                this.f3690c = list;
                this.f3691d = true;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Continuation continuation = (Continuation) list.get(i11);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                }
                list.clear();
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
