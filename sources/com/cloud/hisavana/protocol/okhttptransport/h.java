package com.cloud.hisavana.protocol.okhttptransport;

import com.google.common.base.m;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private final CronetEngine f21576a;

    /* renamed from: b, reason: collision with root package name */
    private int f21577b = 4;

    /* renamed from: c, reason: collision with root package name */
    private c f21578c = null;

    /* renamed from: d, reason: collision with root package name */
    private final h f21579d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CronetEngine cronetEngine, Class cls) {
        this.f21576a = (CronetEngine) m.o(cronetEngine);
        m.d(getClass().equals(cls));
        this.f21579d = this;
    }

    public Object a() {
        if (this.f21578c == null) {
            this.f21578c = c.a();
        }
        return b(new g(this.f21576a, Executors.newFixedThreadPool(this.f21577b), e.b(Executors.newCachedThreadPool()), new i(), this.f21578c));
    }

    abstract Object b(g gVar);
}
