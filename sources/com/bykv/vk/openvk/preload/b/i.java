package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements b {

    /* renamed from: a, reason: collision with root package name */
    protected e f20638a;

    /* renamed from: b, reason: collision with root package name */
    private int f20639b;

    /* renamed from: c, reason: collision with root package name */
    private List<h> f20640c;

    /* renamed from: d, reason: collision with root package name */
    private d f20641d;

    /* loaded from: classes2.dex */
    static final class a extends Exception {
        a(Throwable th2) {
            super(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(List<h> list, int i11, e eVar, d dVar) {
        this.f20640c = list;
        this.f20639b = i11;
        this.f20638a = eVar;
        this.f20641d = dVar;
    }

    private d c(Class cls) {
        d dVar = this.f20641d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f20620a;
        }
        return dVar;
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Class cls) {
        d c11 = c(cls);
        if (c11 != null) {
            return c11.f20621b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Object obj) throws Exception {
        d dVar = this.f20641d;
        if (dVar != null) {
            dVar.f20622c = obj;
            dVar.e();
        }
        if (this.f20639b >= this.f20640c.size()) {
            return obj;
        }
        h hVar = this.f20640c.get(this.f20639b);
        Class<? extends d> cls = hVar.f20632a;
        d dVar2 = (d) this.f20638a.a(cls);
        if (dVar2 == null) {
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + cls);
        }
        com.bykv.vk.openvk.preload.b.b.a a11 = hVar.a();
        i iVar = new i(this.f20640c, this.f20639b + 1, this.f20638a, dVar2);
        dVar2.a(iVar, this.f20641d, obj, a11, hVar.b());
        dVar2.c();
        try {
            Object a12 = dVar2.a(iVar, obj);
            dVar2.d();
            return a12;
        } catch (a e11) {
            dVar2.c(e11.getCause());
            throw e11;
        } catch (Throwable th2) {
            dVar2.b(th2);
            throw new a(th2);
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object b(Class cls) {
        d c11 = c(cls);
        if (c11 != null) {
            return c11.f20622c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }
}
