package pb;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import ob.g;

/* loaded from: classes5.dex */
public class c implements b, a {

    /* renamed from: a, reason: collision with root package name */
    private final e f72522a;

    /* renamed from: b, reason: collision with root package name */
    private final int f72523b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeUnit f72524c;

    /* renamed from: e, reason: collision with root package name */
    private CountDownLatch f72526e;

    /* renamed from: d, reason: collision with root package name */
    private final Object f72525d = new Object();

    /* renamed from: f, reason: collision with root package name */
    private boolean f72527f = false;

    public c(e eVar, int i11, TimeUnit timeUnit) {
        this.f72522a = eVar;
        this.f72523b = i11;
        this.f72524c = timeUnit;
    }

    @Override // pb.a
    public void a(String str, Bundle bundle) {
        synchronized (this.f72525d) {
            try {
                g.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f72526e = new CountDownLatch(1);
                this.f72527f = false;
                this.f72522a.a(str, bundle);
                g.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f72526e.await(this.f72523b, this.f72524c)) {
                        this.f72527f = true;
                        g.f().i("App exception callback received from Analytics listener.");
                    } else {
                        g.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    g.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f72526e = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // pb.b
    public void c(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f72526e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
