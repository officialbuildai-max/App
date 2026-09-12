package com.google.common.util.concurrent;

import java.util.Deque;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class SequentialExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private static final q f31061a = new q(SequentialExecutor.class);

    /* renamed from: com.google.common.util.concurrent.SequentialExecutor$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ SequentialExecutor this$0;
        final /* synthetic */ Runnable val$task;

        AnonymousClass1(SequentialExecutor sequentialExecutor, Runnable runnable) {
            this.val$task = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$task.run();
        }

        public String toString() {
            return this.val$task.toString();
        }
    }

    /* loaded from: classes4.dex */
    private final class QueueWorker implements Runnable {
        Runnable task;
        final /* synthetic */ SequentialExecutor this$0;

        private QueueWorker(SequentialExecutor sequentialExecutor) {
        }

        /* synthetic */ QueueWorker(SequentialExecutor sequentialExecutor, AnonymousClass1 anonymousClass1) {
            this(sequentialExecutor);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            r8.task.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
        
            r8.task = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
        
            com.google.common.util.concurrent.SequentialExecutor.f31061a.a().log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.task, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void workOnQueue() {
            /*
                r8 = this;
                r0 = 0
                r1 = r0
            L2:
                r2 = 0
                java.util.Deque r3 = com.google.common.util.concurrent.SequentialExecutor.a(r2)     // Catch: java.lang.Throwable -> L52
                monitor-enter(r3)     // Catch: java.lang.Throwable -> L52
                if (r0 != 0) goto L26
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.common.util.concurrent.SequentialExecutor.b(r2)     // Catch: java.lang.Throwable -> L1d
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r4 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L1d
                if (r0 != r4) goto L1f
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
                if (r1 == 0) goto L1c
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1c:
                return
            L1d:
                r0 = move-exception
                goto L7b
            L1f:
                com.google.common.util.concurrent.SequentialExecutor.d(r2)     // Catch: java.lang.Throwable -> L1d
                com.google.common.util.concurrent.SequentialExecutor.c(r2, r4)     // Catch: java.lang.Throwable -> L1d
                r0 = 1
            L26:
                java.util.Deque r4 = com.google.common.util.concurrent.SequentialExecutor.a(r2)     // Catch: java.lang.Throwable -> L1d
                java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L1d
                java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L1d
                r8.task = r4     // Catch: java.lang.Throwable -> L1d
                if (r4 != 0) goto L44
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L1d
                com.google.common.util.concurrent.SequentialExecutor.c(r2, r0)     // Catch: java.lang.Throwable -> L1d
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
                if (r1 == 0) goto L43
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L43:
                return
            L44:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
                boolean r3 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L52
                r1 = r1 | r3
                java.lang.Runnable r3 = r8.task     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
                r3.run()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            L4f:
                r8.task = r2     // Catch: java.lang.Throwable -> L52
                goto L2
            L52:
                r0 = move-exception
                goto L7d
            L54:
                r0 = move-exception
                goto L78
            L56:
                r3 = move-exception
                com.google.common.util.concurrent.q r4 = com.google.common.util.concurrent.SequentialExecutor.e()     // Catch: java.lang.Throwable -> L54
                java.util.logging.Logger r4 = r4.a()     // Catch: java.lang.Throwable -> L54
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L54
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
                r6.<init>()     // Catch: java.lang.Throwable -> L54
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L54
                java.lang.Runnable r7 = r8.task     // Catch: java.lang.Throwable -> L54
                r6.append(r7)     // Catch: java.lang.Throwable -> L54
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L54
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L54
                goto L4f
            L78:
                r8.task = r2     // Catch: java.lang.Throwable -> L52
                throw r0     // Catch: java.lang.Throwable -> L52
            L7b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
                throw r0     // Catch: java.lang.Throwable -> L52
            L7d:
                if (r1 == 0) goto L86
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L86:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e11) {
                synchronized (SequentialExecutor.a(null)) {
                    SequentialExecutor.c(null, WorkerRunningState.IDLE);
                    throw e11;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.task;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.b(null) + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ Deque a(SequentialExecutor sequentialExecutor) {
        throw null;
    }

    static /* synthetic */ WorkerRunningState b(SequentialExecutor sequentialExecutor) {
        throw null;
    }

    static /* synthetic */ WorkerRunningState c(SequentialExecutor sequentialExecutor, WorkerRunningState workerRunningState) {
        throw null;
    }

    static /* synthetic */ long d(SequentialExecutor sequentialExecutor) {
        throw null;
    }
}
