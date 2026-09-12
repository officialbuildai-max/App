package io.reactivex.rxjava3.internal.operators.flowable;

/* loaded from: classes7.dex */
abstract class FlowableDelay$DelaySubscriber implements io.reactivex.rxjava3.core.f, u10.d {

    /* loaded from: classes7.dex */
    final class OnComplete implements Runnable {
        final /* synthetic */ FlowableDelay$DelaySubscriber this$0;

        OnComplete(FlowableDelay$DelaySubscriber flowableDelay$DelaySubscriber) {
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableDelay$DelaySubscriber.OnComplete.run():void");
        }
    }

    /* loaded from: classes7.dex */
    final class OnError implements Runnable {

        /* renamed from: t, reason: collision with root package name */
        private final Throwable f65478t;
        final /* synthetic */ FlowableDelay$DelaySubscriber this$0;

        OnError(FlowableDelay$DelaySubscriber flowableDelay$DelaySubscriber, Throwable th2) {
            this.f65478t = th2;
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableDelay$DelaySubscriber.OnError.run():void");
        }
    }

    /* loaded from: classes7.dex */
    final class OnNext implements Runnable {

        /* renamed from: t, reason: collision with root package name */
        private final Object f65479t;
        final /* synthetic */ FlowableDelay$DelaySubscriber this$0;

        OnNext(FlowableDelay$DelaySubscriber flowableDelay$DelaySubscriber, Object obj) {
            this.f65479t = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
