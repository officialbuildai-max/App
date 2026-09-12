package com.mbridge.msdk.tracker.network;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes5.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<t<?>> f38638a;

    /* renamed from: b, reason: collision with root package name */
    private final m f38639b;

    /* renamed from: c, reason: collision with root package name */
    private final b f38640c;

    /* renamed from: d, reason: collision with root package name */
    private final w f38641d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f38642e = false;

    public n(BlockingQueue<t<?>> blockingQueue, m mVar, b bVar, w wVar) {
        this.f38638a = blockingQueue;
        this.f38639b = mVar;
        this.f38640c = bVar;
        this.f38641d = wVar;
    }

    private void a() throws InterruptedException {
        b(this.f38638a.take());
    }

    private void a(t<?> tVar) {
        TrafficStats.setThreadStatsTag(tVar.s());
    }

    private void a(t<?> tVar, b0 b0Var) {
        this.f38641d.a(tVar, tVar.c(b0Var));
    }

    void b(t<?> tVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tVar.a(3);
        try {
            try {
                try {
                    tVar.a("network-queue-take");
                } catch (Exception e11) {
                    c0.a(e11, "Unhandled exception %s", e11.toString());
                    a0 a0Var = new a0(e11);
                    a0Var.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f38641d.a(tVar, a0Var);
                    tVar.x();
                }
            } catch (b0 e12) {
                e12.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                a(tVar, e12);
                tVar.x();
            }
            if (tVar.v()) {
                tVar.c("network-discard-cancelled");
                tVar.x();
                return;
            }
            if (tVar.y()) {
                a(tVar);
            }
            q a11 = this.f38639b.a(tVar);
            tVar.a("network-http-complete");
            if (a11.f38673e && tVar.u()) {
                tVar.c("not-modified");
                tVar.x();
                return;
            }
            v<?> a12 = tVar.a(a11);
            tVar.a("network-parse-complete");
            if (tVar.z() && a12.f38746b != null) {
                this.f38640c.a(tVar.e(), a12.f38746b);
                tVar.a("network-cache-written");
            }
            tVar.w();
            this.f38641d.a(tVar, a12);
            tVar.a(a12);
        } finally {
            tVar.a(4);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f38642e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                c0.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
