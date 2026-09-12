package androidx.media3.common;

import androidx.media3.common.util.a1;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public final class PriorityTaskManager {

    /* renamed from: a, reason: collision with root package name */
    private final Object f9865a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final PriorityQueue f9866b = new PriorityQueue(10, Collections.reverseOrder());

    /* renamed from: c, reason: collision with root package name */
    private int f9867c = Integer.MIN_VALUE;

    /* loaded from: classes2.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i11, int i12) {
            super("Priority too low [priority=" + i11 + ", highest=" + i12 + "]");
        }
    }

    public void a(int i11) {
        synchronized (this.f9865a) {
            this.f9866b.add(Integer.valueOf(i11));
            this.f9867c = Math.max(this.f9867c, i11);
        }
    }

    public void b(int i11) {
        synchronized (this.f9865a) {
            while (this.f9867c != i11) {
                try {
                    this.f9865a.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void c(int i11) {
        synchronized (this.f9865a) {
            try {
                if (this.f9867c != i11) {
                    throw new PriorityTooLowException(i11, this.f9867c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d(int i11) {
        synchronized (this.f9865a) {
            this.f9866b.remove(Integer.valueOf(i11));
            this.f9867c = this.f9866b.isEmpty() ? Integer.MIN_VALUE : ((Integer) a1.i((Integer) this.f9866b.peek())).intValue();
            this.f9865a.notifyAll();
        }
    }
}
