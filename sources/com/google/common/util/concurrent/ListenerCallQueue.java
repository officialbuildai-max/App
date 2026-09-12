package com.google.common.util.concurrent;

import com.google.common.collect.s3;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/* loaded from: classes4.dex */
abstract class ListenerCallQueue {

    /* renamed from: a, reason: collision with root package name */
    private static final q f31055a = new q(ListenerCallQueue.class);

    /* loaded from: classes4.dex */
    private static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final L listener;
        final Queue<a> waitQueue = s3.a();
        final Queue<Object> labelQueue = s3.a();

        PerListenerQueue(L l11, Executor executor) {
            this.listener = (L) com.google.common.base.m.o(l11);
            this.executor = (Executor) com.google.common.base.m.o(executor);
        }

        synchronized void add(a aVar, Object obj) {
            this.waitQueue.add(aVar);
            this.labelQueue.add(obj);
        }

        void dispatch() {
            boolean z10;
            synchronized (this) {
                try {
                    if (this.isThreadScheduled) {
                        z10 = false;
                    } else {
                        z10 = true;
                        this.isThreadScheduled = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                try {
                    this.executor.execute(this);
                } catch (Exception e11) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.f31055a.a().log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e11);
                        throw e11;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        
            r2.call(r9.listener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.f31055a.a().log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.listener + " " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r9 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L2b
                boolean r2 = r9.isThreadScheduled     // Catch: java.lang.Throwable -> L1f
                com.google.common.base.m.u(r2)     // Catch: java.lang.Throwable -> L1f
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$a> r2 = r9.waitQueue     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L1f
                com.google.common.util.concurrent.ListenerCallQueue$a r2 = (com.google.common.util.concurrent.ListenerCallQueue.a) r2     // Catch: java.lang.Throwable -> L1f
                java.util.Queue<java.lang.Object> r3 = r9.labelQueue     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1f
                if (r2 != 0) goto L24
                r9.isThreadScheduled = r0     // Catch: java.lang.Throwable -> L1f
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = r0
                goto L57
            L1f:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L57
            L24:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1f
                L r4 = r9.listener     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                r2.call(r4)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                goto L0
            L2b:
                r2 = move-exception
                goto L60
            L2d:
                r2 = move-exception
                com.google.common.util.concurrent.q r4 = com.google.common.util.concurrent.ListenerCallQueue.a()     // Catch: java.lang.Throwable -> L2b
                java.util.logging.Logger r4 = r4.a()     // Catch: java.lang.Throwable -> L2b
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L2b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
                r6.<init>()     // Catch: java.lang.Throwable -> L2b
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                L r7 = r9.listener     // Catch: java.lang.Throwable -> L2b
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r7 = " "
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                r6.append(r3)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L2b
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L2b
                goto L0
            L57:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L5e
                throw r1     // Catch: java.lang.Throwable -> L59
            L59:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L60
            L5e:
                r1 = move-exception
                goto L57
            L60:
                if (r1 == 0) goto L6a
                monitor-enter(r9)
                r9.isThreadScheduled = r0     // Catch: java.lang.Throwable -> L67
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L67
                goto L6a
            L67:
                r0 = move-exception
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L67
                throw r0
            L6a:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    /* loaded from: classes4.dex */
    interface a {
        void call(Object obj);
    }
}
