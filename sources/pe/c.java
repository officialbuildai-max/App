package pe;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pe.b;

/* loaded from: classes5.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue f72565a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f72566b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f72567c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private b f72568d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f72565a = linkedBlockingQueue;
        this.f72566b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b bVar = (b) this.f72567c.poll();
        this.f72568d = bVar;
        if (bVar != null) {
            bVar.b(this.f72566b);
        }
    }

    @Override // pe.b.a
    public void a(b bVar) {
        this.f72568d = null;
        b();
    }

    public void c(b bVar) {
        bVar.c(this);
        this.f72567c.add(bVar);
        if (this.f72568d == null) {
            b();
        }
    }
}
