package com.bykv.vk.openvk.preload.b;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public abstract class d<IN, OUT> {

    /* renamed from: d, reason: collision with root package name */
    private static AtomicLong f20619d = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    d f20620a;

    /* renamed from: b, reason: collision with root package name */
    IN f20621b;

    /* renamed from: c, reason: collision with root package name */
    OUT f20622c;

    /* renamed from: e, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.b.b.a f20623e;

    /* renamed from: f, reason: collision with root package name */
    private b f20624f;

    /* renamed from: g, reason: collision with root package name */
    private long f20625g;

    public abstract Object a(b<OUT> bVar, IN in2) throws Throwable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b bVar, d dVar, IN in2, com.bykv.vk.openvk.preload.b.b.a aVar, Object[] objArr) {
        this.f20624f = new m(bVar);
        this.f20620a = dVar;
        this.f20621b = in2;
        this.f20623e = aVar;
        if (dVar != null) {
            this.f20625g = dVar.f20625g;
        } else {
            long andIncrement = f20619d.getAndIncrement();
            this.f20625g = andIncrement;
            if (andIncrement < 0) {
                throw new RuntimeException("Pipeline ID use up!");
            }
        }
        a(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object... objArr) {
    }

    public final long b() {
        return this.f20625g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Throwable th2) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f20623e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f20624f, this, th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f20623e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f20624f, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Throwable th2) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f20623e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f20624f, this, th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f20623e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f20624f, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(Throwable th2) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f20623e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f20624f, this, th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.f20623e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f20624f, this);
    }

    public final OUT f() {
        return this.f20622c;
    }
}
