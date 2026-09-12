package org.apache.tools.ant.util;

import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes7.dex */
public class Watchdog implements Runnable {
    public static final String ERROR_INVALID_TIMEOUT = "timeout less than 1.";
    private Vector observers = new Vector(1);
    private volatile boolean stopped = false;
    private long timeout;

    public Watchdog(long j11) {
        this.timeout = -1L;
        if (j11 < 1) {
            throw new IllegalArgumentException(ERROR_INVALID_TIMEOUT);
        }
        this.timeout = j11;
    }

    public void addTimeoutObserver(r rVar) {
        this.observers.addElement(rVar);
    }

    protected final void fireTimeoutOccured() {
        Enumeration elements = this.observers.elements();
        while (elements.hasMoreElements()) {
            ((r) elements.nextElement()).timeoutOccured(this);
        }
    }

    public void removeTimeoutObserver(r rVar) {
        this.observers.removeElement(rVar);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        long currentTimeMillis = System.currentTimeMillis() + this.timeout;
        while (!this.stopped) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis <= currentTimeMillis2) {
                break;
            } else {
                try {
                    wait(currentTimeMillis - currentTimeMillis2);
                } catch (InterruptedException unused) {
                }
            }
        }
        if (!this.stopped) {
            fireTimeoutOccured();
        }
    }

    public synchronized void start() {
        this.stopped = false;
        Thread thread = new Thread(this, "WATCHDOG");
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void stop() {
        this.stopped = true;
        notifyAll();
    }
}
