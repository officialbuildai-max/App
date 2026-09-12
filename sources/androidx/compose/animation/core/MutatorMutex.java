package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public final class MutatorMutex {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f2461a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.sync.a f2462b = kotlinx.coroutines.sync.g.b(false, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final MutatePriority f2463a;

        /* renamed from: b, reason: collision with root package name */
        private final t1 f2464b;

        public a(MutatePriority mutatePriority, t1 t1Var) {
            this.f2463a = mutatePriority;
            this.f2464b = t1Var;
        }

        public final boolean a(a aVar) {
            return this.f2463a.compareTo(aVar.f2463a) >= 0;
        }

        public final void b() {
            this.f2464b.cancel(new MutationInterruptedException());
        }
    }

    public static /* synthetic */ Object e(MutatorMutex mutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.d(mutatePriority, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a aVar) {
        a aVar2;
        do {
            aVar2 = (a) this.f2461a.get();
            if (aVar2 != null && !aVar.a(aVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!j0.a(this.f2461a, aVar2, aVar));
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public final Object d(MutatePriority mutatePriority, Function1 function1, Continuation continuation) {
        return kotlinx.coroutines.o0.e(new MutatorMutex$mutate$2(mutatePriority, this, function1, null), continuation);
    }
}
