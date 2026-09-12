package com.android.volley;

import com.android.volley.Request;
import com.android.volley.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class m implements Request.a {

    /* renamed from: b, reason: collision with root package name */
    private final j f19347b;

    /* renamed from: d, reason: collision with root package name */
    private final CacheDispatcher f19349d;

    /* renamed from: e, reason: collision with root package name */
    private final BlockingQueue f19350e;

    /* renamed from: a, reason: collision with root package name */
    private final Map f19346a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final h f19348c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(CacheDispatcher cacheDispatcher, BlockingQueue blockingQueue, j jVar) {
        this.f19347b = jVar;
        this.f19349d = cacheDispatcher;
        this.f19350e = blockingQueue;
    }

    @Override // com.android.volley.Request.a
    public void a(Request request, i iVar) {
        List list;
        c.a aVar = iVar.f19334b;
        if (aVar == null || aVar.a()) {
            b(request);
            return;
        }
        String cacheKey = request.getCacheKey();
        synchronized (this) {
            list = (List) this.f19346a.remove(cacheKey);
        }
        if (list != null) {
            if (l.f19338b) {
                l.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), cacheKey);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f19347b.a((Request) it.next(), iVar);
            }
        }
    }

    @Override // com.android.volley.Request.a
    public synchronized void b(Request request) {
        BlockingQueue blockingQueue;
        try {
            String cacheKey = request.getCacheKey();
            List list = (List) this.f19346a.remove(cacheKey);
            if (list != null && !list.isEmpty()) {
                if (l.f19338b) {
                    l.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), cacheKey);
                }
                Request request2 = (Request) list.remove(0);
                this.f19346a.put(cacheKey, list);
                request2.setNetworkRequestCompleteListener(this);
                h hVar = this.f19348c;
                if (hVar != null) {
                    hVar.f(request2);
                } else if (this.f19349d != null && (blockingQueue = this.f19350e) != null) {
                    try {
                        blockingQueue.put(request2);
                    } catch (InterruptedException e11) {
                        l.c("Couldn't add request to queue. %s", e11.toString());
                        Thread.currentThread().interrupt();
                        this.f19349d.quit();
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean c(Request request) {
        try {
            String cacheKey = request.getCacheKey();
            if (!this.f19346a.containsKey(cacheKey)) {
                this.f19346a.put(cacheKey, null);
                request.setNetworkRequestCompleteListener(this);
                if (l.f19338b) {
                    l.b("new request, sending to network %s", cacheKey);
                }
                return false;
            }
            List list = (List) this.f19346a.get(cacheKey);
            if (list == null) {
                list = new ArrayList();
            }
            request.addMarker("waiting-for-response");
            list.add(request);
            this.f19346a.put(cacheKey, list);
            if (l.f19338b) {
                l.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
