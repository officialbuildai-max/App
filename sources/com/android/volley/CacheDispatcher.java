package com.android.volley;

import android.os.Process;
import com.android.volley.c;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class CacheDispatcher extends Thread {
    private static final boolean DEBUG = l.f19338b;
    private final c mCache;
    private final BlockingQueue<Request> mCacheQueue;
    private final j mDelivery;
    private final BlockingQueue<Request> mNetworkQueue;
    private volatile boolean mQuit = false;
    private final m mWaitingRequestManager;

    public CacheDispatcher(BlockingQueue<Request> blockingQueue, BlockingQueue<Request> blockingQueue2, c cVar, j jVar) {
        this.mCacheQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
        this.mCache = cVar;
        this.mDelivery = jVar;
        this.mWaitingRequestManager = new m(this, blockingQueue2, jVar);
    }

    private void processRequest() throws InterruptedException {
        processRequest(this.mCacheQueue.take());
    }

    void processRequest(final Request request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.sendEvent(1);
        try {
            if (request.isCanceled()) {
                request.finish("cache-discard-canceled");
                return;
            }
            c.a a11 = this.mCache.a(request.getCacheKey());
            if (a11 == null) {
                request.addMarker("cache-miss");
                if (!this.mWaitingRequestManager.c(request)) {
                    this.mNetworkQueue.put(request);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a11.b(currentTimeMillis)) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(a11);
                if (!this.mWaitingRequestManager.c(request)) {
                    this.mNetworkQueue.put(request);
                }
                return;
            }
            request.addMarker("cache-hit");
            i parseNetworkResponse = request.parseNetworkResponse(new g(a11.f19302a, a11.f19308g));
            request.addMarker("cache-hit-parsed");
            if (!parseNetworkResponse.b()) {
                request.addMarker("cache-parsing-failed");
                this.mCache.b(request.getCacheKey(), true);
                request.setCacheEntry(null);
                if (!this.mWaitingRequestManager.c(request)) {
                    this.mNetworkQueue.put(request);
                }
                return;
            }
            if (a11.c(currentTimeMillis)) {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a11);
                parseNetworkResponse.f19336d = true;
                if (this.mWaitingRequestManager.c(request)) {
                    this.mDelivery.a(request, parseNetworkResponse);
                } else {
                    this.mDelivery.b(request, parseNetworkResponse, new Runnable() { // from class: com.android.volley.CacheDispatcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CacheDispatcher.this.mNetworkQueue.put(request);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });
                }
            } else {
                this.mDelivery.a(request, parseNetworkResponse);
            }
        } finally {
            request.sendEvent(2);
        }
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (DEBUG) {
            l.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.mCache.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    Thread.currentThread().interrupt();
                    return;
                }
                l.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
