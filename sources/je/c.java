package je;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import je.b;

/* loaded from: classes5.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue f66127a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f66128b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f66129c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private b f66130d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f66127a = linkedBlockingQueue;
        this.f66128b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b bVar = (b) this.f66129c.poll();
        this.f66130d = bVar;
        if (bVar != null) {
            bVar.b(this.f66128b);
        }
    }

    @Override // je.b.a
    public void a(b bVar) {
        this.f66130d = null;
        b();
    }

    public void c(b bVar) {
        bVar.c(this);
        this.f66129c.add(bVar);
        if (this.f66130d == null) {
            b();
        }
    }
}
