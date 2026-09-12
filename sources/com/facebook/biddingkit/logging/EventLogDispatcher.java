package com.facebook.biddingkit.logging;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class EventLogDispatcher {

    /* renamed from: g, reason: collision with root package name */
    private static volatile EventLogDispatcher f24168g;

    /* renamed from: a, reason: collision with root package name */
    private int f24169a;

    /* renamed from: f, reason: collision with root package name */
    private i f24174f;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f24170b = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private final ThreadPoolExecutor f24173e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f24171c = new Runnable() { // from class: com.facebook.biddingkit.logging.EventLogDispatcher.1
        @Override // java.lang.Runnable
        public void run() {
            EventLogDispatcher.this.g();
            EventLogDispatcher.this.f24170b.postDelayed(EventLogDispatcher.this.f24172d, EventLogDispatcher.this.f24169a);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f24172d = new Runnable() { // from class: com.facebook.biddingkit.logging.EventLogDispatcher.2
        @Override // java.lang.Runnable
        public void run() {
            if (EventLogDispatcher.this.f24173e.getQueue().isEmpty()) {
                EventLogDispatcher.this.f24173e.execute(EventLogDispatcher.this.f24171c);
            }
        }
    };

    private EventLogDispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077 A[Catch: all -> 0x0031, LOOP:1: B:22:0x0071->B:24:0x0077, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:3:0x000c, B:5:0x0012, B:10:0x0019, B:11:0x001d, B:13:0x0023, B:15:0x0033, B:17:0x0053, B:20:0x005c, B:21:0x006d, B:22:0x0071, B:24:0x0077, B:28:0x0065), top: B:2:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g() {
        /*
            r5 = this;
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r2 = 10
            java.util.List r2 = com.facebook.biddingkit.logging.f.e(r2)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto L85
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L19
            goto L85
        L19:
            java.util.Iterator r3 = r2.iterator()     // Catch: java.lang.Throwable -> L31
        L1d:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L33
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L31
            com.facebook.biddingkit.logging.e r4 = (com.facebook.biddingkit.logging.e) r4     // Catch: java.lang.Throwable -> L31
            org.json.JSONObject r4 = r4.m()     // Catch: java.lang.Throwable -> L31
            r0.put(r4)     // Catch: java.lang.Throwable -> L31
            goto L1d
        L31:
            r0 = move-exception
            goto L86
        L33:
            java.lang.String r3 = "tokens"
            org.json.JSONObject r4 = com.facebook.biddingkit.logging.a.a()     // Catch: java.lang.Throwable -> L31
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "events"
            r1.put(r3, r0)     // Catch: java.lang.Throwable -> L31
            com.facebook.biddingkit.logging.i r0 = r5.f24174f     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r0.b()     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L31
            r3 = 2000(0x7d0, float:2.803E-42)
            l8.e r0 = m8.b.b(r0, r3, r1)     // Catch: java.lang.Throwable -> L31
            if (r0 == 0) goto L65
            int r0 = r0.a()     // Catch: java.lang.Throwable -> L31
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L5c
            goto L65
        L5c:
            com.facebook.biddingkit.logging.i r0 = r5.f24174f     // Catch: java.lang.Throwable -> L31
            int r0 = r0.a()     // Catch: java.lang.Throwable -> L31
            r5.f24169a = r0     // Catch: java.lang.Throwable -> L31
            goto L6d
        L65:
            com.facebook.biddingkit.logging.i r0 = r5.f24174f     // Catch: java.lang.Throwable -> L31
            int r0 = r0.c()     // Catch: java.lang.Throwable -> L31
            r5.f24169a = r0     // Catch: java.lang.Throwable -> L31
        L6d:
            java.util.Iterator r0 = r2.iterator()     // Catch: java.lang.Throwable -> L31
        L71:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L8d
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L31
            com.facebook.biddingkit.logging.e r1 = (com.facebook.biddingkit.logging.e) r1     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = r1.k()     // Catch: java.lang.Throwable -> L31
            com.facebook.biddingkit.logging.f.b(r1)     // Catch: java.lang.Throwable -> L31
            goto L71
        L85:
            return
        L86:
            java.lang.String r1 = "EventLogDispatcher"
            java.lang.String r2 = "Failed dispatching events"
            com.facebook.biddingkit.logging.b.b(r1, r2, r0)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.biddingkit.logging.EventLogDispatcher.g():void");
    }

    public static EventLogDispatcher h() {
        if (f24168g == null) {
            synchronized (EventLogDispatcher.class) {
                try {
                    if (f24168g == null) {
                        f24168g = new EventLogDispatcher();
                    }
                } finally {
                }
            }
        }
        return f24168g;
    }

    public static void j(i iVar) {
        h().i(iVar);
        h().k();
    }

    public void i(i iVar) {
        this.f24174f = iVar;
        this.f24169a = iVar.a();
    }

    protected void k() {
        this.f24170b.postDelayed(this.f24172d, this.f24169a);
    }
}
