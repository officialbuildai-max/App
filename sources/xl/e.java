package xl;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map f78446a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final c f78447b = new c(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Lock f78448a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f78449b;

        /* synthetic */ b(a aVar) {
        }
    }

    /* loaded from: classes6.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Queue f78450a = new ArrayDeque();

        /* synthetic */ c(a aVar) {
        }

        b a() {
            b bVar;
            synchronized (this.f78450a) {
                bVar = (b) this.f78450a.poll();
            }
            return bVar == null ? new b(null) : bVar;
        }

        void b(b bVar) {
            synchronized (this.f78450a) {
                try {
                    if (this.f78450a.size() < 10) {
                        this.f78450a.offer(bVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void a(wl.e eVar) {
        b bVar;
        synchronized (this) {
            try {
                bVar = (b) this.f78446a.get(eVar);
                if (bVar == null) {
                    bVar = this.f78447b.a();
                    this.f78446a.put(eVar, bVar);
                }
                bVar.f78449b++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bVar.f78448a.lock();
    }

    public void b(wl.e eVar) {
        b bVar;
        synchronized (this) {
            try {
                bVar = (b) this.f78446a.get(eVar);
                int i11 = bVar.f78449b;
                if (i11 < 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot release a lock that is not held, key: ");
                    sb2.append(eVar);
                    sb2.append(", interestedThreads: ");
                    sb2.append(bVar.f78449b);
                    throw new IllegalStateException(sb2.toString());
                }
                int i12 = i11 - 1;
                bVar.f78449b = i12;
                if (i12 == 0) {
                    b bVar2 = (b) this.f78446a.remove(eVar);
                    if (!bVar2.equals(bVar)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Removed the wrong lock, expected to remove: ");
                        sb3.append(bVar);
                        sb3.append(", but actually removed: ");
                        sb3.append(bVar2);
                        sb3.append(", key: ");
                        sb3.append(eVar);
                        throw new IllegalStateException(sb3.toString());
                    }
                    this.f78447b.b(bVar2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bVar.f78448a.unlock();
    }
}
