package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.q;

/* loaded from: classes7.dex */
abstract class SingleDelay$Delay implements q {

    /* loaded from: classes7.dex */
    final class OnError implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final Throwable f65592e;
        final /* synthetic */ SingleDelay$Delay this$1;

        OnError(SingleDelay$Delay singleDelay$Delay, Throwable th2) {
            this.f65592e = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* loaded from: classes7.dex */
    final class OnSuccess implements Runnable {
        final /* synthetic */ SingleDelay$Delay this$1;
        private final Object value;

        OnSuccess(SingleDelay$Delay singleDelay$Delay, Object obj) {
            this.value = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
