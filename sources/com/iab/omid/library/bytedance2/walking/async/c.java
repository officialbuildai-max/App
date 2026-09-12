package com.iab.omid.library.bytedance2.walking.async;

import com.iab.omid.library.bytedance2.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f33579a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f33580b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f33581c = new ArrayDeque<>();

    /* renamed from: d, reason: collision with root package name */
    private b f33582d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f33579a = linkedBlockingQueue;
        this.f33580b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b poll = this.f33581c.poll();
        this.f33582d = poll;
        if (poll != null) {
            poll.a(this.f33580b);
        }
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.a
    public void a(b bVar) {
        this.f33582d = null;
        a();
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f33581c.add(bVar);
        if (this.f33582d == null) {
            a();
        }
    }
}
