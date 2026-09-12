package com.transsion.http.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class q implements r {

    /* renamed from: a, reason: collision with root package name */
    private Handler f46040a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f46041b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f46042c;

    /* renamed from: d, reason: collision with root package name */
    private Looper f46043d;

    /* loaded from: classes5.dex */
    private static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final q f46044a;

        a(q qVar, Looper looper) {
            super(looper);
            this.f46044a = qVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f46044a.g(message);
        }
    }

    public q() {
        this(null);
    }

    public q(Looper looper) {
        this(looper == null ? Looper.myLooper() : looper, false);
    }

    private q(Looper looper, boolean z10) {
        this.f46043d = null;
        if (z10) {
            cm.b.a(looper == null, "use pool thread, looper should be null!");
            this.f46043d = null;
            this.f46040a = null;
        } else {
            cm.b.a(looper != null, "use looper thread, must call Looper.prepare() first!");
            this.f46043d = looper;
            this.f46040a = new a(this, looper);
        }
        this.f46042c = z10;
    }

    @Override // com.transsion.http.impl.r
    public void a() {
        i(f(2, null));
    }

    @Override // com.transsion.http.impl.r
    public void b() {
        i(f(3, null));
    }

    @Override // com.transsion.http.impl.r
    public void c(int i11, byte[] bArr) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i11 >= 300) {
            d(i11, bArr, new IOException());
        } else {
            v(i11, bArr);
        }
    }

    @Override // com.transsion.http.impl.r
    public void d(int i11, byte[] bArr, Throwable th2) {
        i(f(1, new Object[]{Integer.valueOf(i11), bArr, th2}));
    }

    @Override // com.transsion.http.impl.r
    public final void e() {
        i(f(6, null));
    }

    protected Message f(int i11, Object obj) {
        return Message.obtain(this.f46040a, i11, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0007. Please report as an issue. */
    protected void g(Message message) {
        try {
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 2) {
                        bm.a.f16706a.e("HttpCallbackImpl", "SUCCESS_MESSAGE didn't got enough params");
                    } else {
                        s(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                    }
                    return;
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2 == null || objArr2.length < 3) {
                        bm.a.f16706a.e("HttpCallbackImpl", "FAILURE_MESSAGE didn't got enough params");
                    } else {
                        m(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Throwable) objArr2[2]);
                    }
                    return;
                case 2:
                    r();
                    return;
                case 3:
                    n();
                    return;
                case 4:
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3 == null || objArr3.length < 2) {
                        bm.a.f16706a.e("HttpCallbackImpl", "PROGRESS_MESSAGE didn't got enough params");
                    } else {
                        try {
                            p(((Long) objArr3[0]).longValue(), ((Long) objArr3[1]).longValue());
                        } catch (Throwable th2) {
                            bm.a.f16706a.e("HttpCallbackImpl", "custom onProgress contains an error", th2);
                        }
                    }
                    return;
                case 5:
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4 == null || objArr4.length != 1) {
                        bm.a.f16706a.e("HttpCallbackImpl", "RETRY_MESSAGE didn't get enough params");
                    } else {
                        q(((Integer) objArr4[0]).intValue());
                    }
                    return;
                case 6:
                    l();
                    return;
                case 7:
                    o();
                    return;
                default:
                    return;
            }
        } catch (Throwable th3) {
            t(th3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Runnable runnable) {
        Handler handler;
        if (runnable != null) {
            if (k() || (handler = this.f46040a) == null) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    protected void i(Message message) {
        if (k() || this.f46040a == null) {
            g(message);
        } else {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            cm.b.a(this.f46040a != null, "handler should not be null!");
            this.f46040a.sendMessage(message);
        }
    }

    public boolean j() {
        return this.f46042c;
    }

    public boolean k() {
        return this.f46041b;
    }

    public void l() {
        bm.a.f16706a.d("HttpCallbackImpl", "Request got cancelled");
    }

    public abstract void m(int i11, byte[] bArr, Throwable th2);

    public void n() {
    }

    public void o() {
        bm.a.f16706a.d("HttpCallbackImpl", "Request got onPaused");
    }

    public void p(long j11, long j12) {
        bm.a.f16706a.v("HttpCallbackImpl", String.format("Progress %d from %d (%2.0f%%)", Long.valueOf(j11), Long.valueOf(j12), Double.valueOf(j12 > 0 ? ((j11 * 1.0d) / j12) * 100.0d : -1.0d)));
    }

    public void q(int i11) {
        bm.a.f16706a.d("HttpCallbackImpl", String.format("Request retry no. %d", Integer.valueOf(i11)));
    }

    public void r() {
    }

    public abstract void s(int i11, byte[] bArr);

    public void t(Throwable th2) {
        bm.a.f16706a.e("HttpCallbackImpl", "User-space exception detected!", th2);
        throw new RuntimeException(th2);
    }

    public void u() {
        i(f(7, null));
    }

    public void v(int i11, byte[] bArr) {
        i(f(0, new Object[]{Integer.valueOf(i11), bArr}));
    }
}
