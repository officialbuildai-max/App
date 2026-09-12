package androidx.core.os;

import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8239a;

    /* renamed from: b, reason: collision with root package name */
    private a f8240b;

    /* renamed from: c, reason: collision with root package name */
    private Object f8241c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8242d;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    private void c() {
        while (this.f8242d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f8239a) {
                    return;
                }
                this.f8239a = true;
                this.f8242d = true;
                a aVar = this.f8240b;
                Object obj = this.f8241c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th2) {
                        synchronized (this) {
                            this.f8242d = false;
                            notifyAll();
                            throw th2;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f8242d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f8240b == aVar) {
                    return;
                }
                this.f8240b = aVar;
                if (this.f8239a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }
}
