package e7;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private final long f61700a;

    /* renamed from: b, reason: collision with root package name */
    private final long f61701b;

    /* renamed from: c, reason: collision with root package name */
    private long f61702c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f61703d = false;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f61704e = new a();

    /* loaded from: classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j11;
            synchronized (e.this) {
                try {
                    if (e.this.f61703d) {
                        return;
                    }
                    long elapsedRealtime = e.this.f61702c - SystemClock.elapsedRealtime();
                    long j12 = 0;
                    if (elapsedRealtime <= 0) {
                        e.this.e();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        e.this.f(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < e.this.f61701b) {
                            j11 = elapsedRealtime - elapsedRealtime3;
                            if (j11 < 0) {
                                sendMessageDelayed(obtainMessage(1), j12);
                            }
                        } else {
                            j11 = e.this.f61701b - elapsedRealtime3;
                            while (j11 < 0) {
                                j11 += e.this.f61701b;
                            }
                        }
                        j12 = j11;
                        sendMessageDelayed(obtainMessage(1), j12);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public e(long j11, long j12) {
        this.f61700a = j11;
        this.f61701b = j12;
    }

    public final synchronized void d() {
        this.f61703d = true;
        this.f61704e.removeMessages(1);
    }

    public abstract void e();

    public abstract void f(long j11);

    public final synchronized e g() {
        this.f61703d = false;
        if (this.f61700a <= 0) {
            e();
            return this;
        }
        this.f61702c = SystemClock.elapsedRealtime() + this.f61700a;
        Handler handler = this.f61704e;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
