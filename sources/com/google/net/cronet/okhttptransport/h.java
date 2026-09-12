package com.google.net.cronet.okhttptransport;

import com.google.common.base.m;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private final CronetEngine f32857a;

    /* renamed from: b, reason: collision with root package name */
    private int f32858b = 4;

    /* renamed from: c, reason: collision with root package name */
    private c f32859c = null;

    /* renamed from: d, reason: collision with root package name */
    private final h f32860d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CronetEngine cronetEngine, Class cls) {
        this.f32857a = (CronetEngine) m.o(cronetEngine);
        m.d(getClass().equals(cls));
        this.f32860d = this;
    }

    public Object a() {
        if (this.f32859c == null) {
            this.f32859c = c.a();
        }
        return b(new g(this.f32857a, Executors.newFixedThreadPool(this.f32858b), e.b(Executors.newCachedThreadPool()), new i(), this.f32859c));
    }

    abstract Object b(g gVar);
}
