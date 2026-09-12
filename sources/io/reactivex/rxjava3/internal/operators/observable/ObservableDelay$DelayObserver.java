package io.reactivex.rxjava3.internal.operators.observable;

/* loaded from: classes7.dex */
abstract class ObservableDelay$DelayObserver implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

    /* loaded from: classes7.dex */
    final class OnComplete implements Runnable {
        final /* synthetic */ ObservableDelay$DelayObserver this$0;

        OnComplete(ObservableDelay$DelayObserver observableDelay$DelayObserver) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r1 = this;
                r0 = 0
                throw r0     // Catch: java.lang.Throwable -> L2
            L2:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableDelay$DelayObserver.OnComplete.run():void");
        }
    }

    /* loaded from: classes7.dex */
    final class OnError implements Runnable {
        final /* synthetic */ ObservableDelay$DelayObserver this$0;
        private final Throwable throwable;

        OnError(ObservableDelay$DelayObserver observableDelay$DelayObserver, Throwable th2) {
            this.throwable = th2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r1 = this;
                r0 = 0
                throw r0     // Catch: java.lang.Throwable -> L2
            L2:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableDelay$DelayObserver.OnError.run():void");
        }
    }

    /* loaded from: classes7.dex */
    final class OnNext implements Runnable {

        /* renamed from: t, reason: collision with root package name */
        private final Object f65517t;
        final /* synthetic */ ObservableDelay$DelayObserver this$0;

        OnNext(ObservableDelay$DelayObserver observableDelay$DelayObserver, Object obj) {
            this.f65517t = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
