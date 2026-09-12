package com.mbridge.msdk.playercommon.exoplayer2.util;

/* loaded from: classes5.dex */
public final class ConditionVariable {
    private boolean isOpen;

    public synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public synchronized boolean block(long j11) throws InterruptedException {
        boolean z10;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j12 = j11 + elapsedRealtime;
        while (true) {
            z10 = this.isOpen;
            if (z10 || elapsedRealtime >= j12) {
                break;
            }
            wait(j12 - elapsedRealtime);
            elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        }
        return z10;
    }

    public synchronized boolean close() {
        boolean z10;
        z10 = this.isOpen;
        this.isOpen = false;
        return z10;
    }

    public synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }
}
