package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class k1 extends kotlinx.coroutines.flow.internal.c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f67945a = new AtomicReference(null);

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(StateFlowImpl stateFlowImpl) {
        kotlinx.coroutines.internal.z zVar;
        if (kotlinx.coroutines.internal.c.a(this.f67945a) != null) {
            return false;
        }
        AtomicReference atomicReference = this.f67945a;
        zVar = j1.f67943a;
        kotlinx.coroutines.internal.c.b(atomicReference, zVar);
        return true;
    }

    public final Object e(Continuation continuation) {
        kotlinx.coroutines.internal.z zVar;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReference atomicReference = this.f67945a;
        zVar = j1.f67943a;
        if (!androidx.compose.animation.core.j0.a(atomicReference, zVar, cancellableContinuationImpl)) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Continuation[] b(StateFlowImpl stateFlowImpl) {
        kotlinx.coroutines.internal.c.b(this.f67945a, null);
        return kotlinx.coroutines.flow.internal.b.f67930a;
    }

    public final void g() {
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        kotlinx.coroutines.internal.z zVar3;
        kotlinx.coroutines.internal.z zVar4;
        AtomicReference atomicReference = this.f67945a;
        while (true) {
            Object a11 = kotlinx.coroutines.internal.c.a(atomicReference);
            if (a11 == null) {
                return;
            }
            zVar = j1.f67944b;
            if (a11 == zVar) {
                return;
            }
            zVar2 = j1.f67943a;
            if (a11 == zVar2) {
                AtomicReference atomicReference2 = this.f67945a;
                zVar3 = j1.f67944b;
                if (androidx.compose.animation.core.j0.a(atomicReference2, a11, zVar3)) {
                    return;
                }
            } else {
                AtomicReference atomicReference3 = this.f67945a;
                zVar4 = j1.f67943a;
                if (androidx.compose.animation.core.j0.a(atomicReference3, a11, zVar4)) {
                    Result.Companion companion = Result.INSTANCE;
                    ((CancellableContinuationImpl) a11).resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                    return;
                }
            }
        }
    }

    public final boolean h() {
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        AtomicReference atomicReference = this.f67945a;
        zVar = j1.f67943a;
        Object andSet = atomicReference.getAndSet(zVar);
        Intrinsics.e(andSet);
        zVar2 = j1.f67944b;
        return andSet == zVar2;
    }
}
