package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes3.dex */
public final class PriorityTaskManager {

    /* renamed from: a, reason: collision with root package name */
    private final Object f27605a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final PriorityQueue f27606b = new PriorityQueue(10, Collections.reverseOrder());

    /* renamed from: c, reason: collision with root package name */
    private int f27607c = Integer.MIN_VALUE;

    /* loaded from: classes3.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i11, int i12) {
            super("Priority too low [priority=" + i11 + ", highest=" + i12 + "]");
        }
    }

    public void a(int i11) {
        synchronized (this.f27605a) {
            this.f27606b.add(Integer.valueOf(i11));
            this.f27607c = Math.max(this.f27607c, i11);
        }
    }

    public void b(int i11) {
        synchronized (this.f27605a) {
            while (this.f27607c != i11) {
                try {
                    this.f27605a.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void c(int i11) {
        synchronized (this.f27605a) {
            try {
                if (this.f27607c != i11) {
                    throw new PriorityTooLowException(i11, this.f27607c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d(int i11) {
        synchronized (this.f27605a) {
            this.f27606b.remove(Integer.valueOf(i11));
            this.f27607c = this.f27606b.isEmpty() ? Integer.MIN_VALUE : ((Integer) p0.j((Integer) this.f27606b.peek())).intValue();
            this.f27605a.notifyAll();
        }
    }
}
