package com.google.common.util.concurrent;

import com.google.common.util.concurrent.i;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class TimeoutFuture extends i.a {

    /* renamed from: a, reason: collision with root package name */
    private r f31062a;

    /* renamed from: b, reason: collision with root package name */
    private ScheduledFuture f31063b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class Fire<V> implements Runnable {
        TimeoutFuture timeoutFutureRef;

        Fire(TimeoutFuture timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            r rVar;
            TimeoutFuture timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null || (rVar = timeoutFuture.f31062a) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (rVar.isDone()) {
                timeoutFuture.setFuture(rVar);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = timeoutFuture.f31063b;
                timeoutFuture.f31063b = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                        }
                    } catch (Throwable th2) {
                        timeoutFuture.setException(new TimeoutFutureException(str));
                        throw th2;
                    }
                }
                timeoutFuture.setException(new TimeoutFutureException(str + ": " + rVar));
            } finally {
                rVar.cancel(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class TimeoutFutureException extends TimeoutException {
        private TimeoutFutureException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    private TimeoutFuture(r rVar) {
        this.f31062a = (r) com.google.common.base.m.o(rVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r v(r rVar, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(rVar);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.f31063b = scheduledExecutorService.schedule(fire, j11, timeUnit);
        rVar.addListener(fire, MoreExecutors.a());
        return timeoutFuture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.f31062a);
        ScheduledFuture scheduledFuture = this.f31063b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f31062a = null;
        this.f31063b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        r rVar = this.f31062a;
        ScheduledFuture scheduledFuture = this.f31063b;
        if (rVar == null) {
            return null;
        }
        String str = "inputFuture=[" + rVar + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
