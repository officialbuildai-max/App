package org.apache.tools.ant.taskdefs;

import java.util.Vector;
import org.apache.tools.ant.u;
import org.apache.tools.ant.v;

/* loaded from: classes7.dex */
public class Parallel extends u implements v {

    /* renamed from: k, reason: collision with root package name */
    private long f71458k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f71459l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f71460m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f71461n;

    /* renamed from: g, reason: collision with root package name */
    private Vector f71454g = new Vector();

    /* renamed from: h, reason: collision with root package name */
    private final Object f71455h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private int f71456i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f71457j = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f71462o = 0;

    /* renamed from: org.apache.tools.ant.taskdefs.Parallel$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 extends Thread {
        AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public synchronized void run() {
            try {
                wait(Parallel.this.f71458k);
                synchronized (Parallel.this.f71455h) {
                    Parallel.this.f71459l = false;
                    Parallel.this.f71460m = true;
                    Parallel.this.f71455h.notifyAll();
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    private class TaskRunnable implements Runnable {
        private Throwable exception;
        private boolean finished;
        private u task;

        TaskRunnable(u uVar) {
            this.task = uVar;
        }

        public Throwable getException() {
            return this.exception;
        }

        boolean isFinished() {
            return this.finished;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.task.n();
                synchronized (Parallel.this.f71455h) {
                    this.finished = true;
                    Parallel.this.f71455h.notifyAll();
                }
            } catch (Throwable th2) {
                try {
                    this.exception = th2;
                    if (Parallel.this.f71461n) {
                        Parallel.this.f71459l = false;
                    }
                    synchronized (Parallel.this.f71455h) {
                        this.finished = true;
                        Parallel.this.f71455h.notifyAll();
                    }
                } catch (Throwable th3) {
                    synchronized (Parallel.this.f71455h) {
                        this.finished = true;
                        Parallel.this.f71455h.notifyAll();
                        throw th3;
                    }
                }
            }
        }
    }

    @Override // org.apache.tools.ant.v
    public void b(u uVar) {
        this.f71454g.addElement(uVar);
    }
}
