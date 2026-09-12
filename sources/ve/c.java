package ve;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ve.b;

/* loaded from: classes5.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue f77398a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f77399b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f77400c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private b f77401d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f77398a = linkedBlockingQueue;
        this.f77399b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b bVar = (b) this.f77400c.poll();
        this.f77401d = bVar;
        if (bVar != null) {
            bVar.b(this.f77399b);
        }
    }

    @Override // ve.b.a
    public void a(b bVar) {
        this.f77401d = null;
        b();
    }

    public void c(b bVar) {
        bVar.c(this);
        this.f77400c.add(bVar);
        if (this.f77401d == null) {
            b();
        }
    }
}
