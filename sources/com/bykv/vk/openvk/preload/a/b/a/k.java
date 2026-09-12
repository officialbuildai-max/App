package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class k<T> extends r<T> {

    /* renamed from: a, reason: collision with root package name */
    private final o<T> f20442a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.h<T> f20443b;

    /* renamed from: c, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.d f20444c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.c.a<T> f20445d;

    /* renamed from: e, reason: collision with root package name */
    private final s f20446e;

    /* renamed from: f, reason: collision with root package name */
    private r<T> f20447f;

    /* loaded from: classes2.dex */
    final class a {
        /* synthetic */ a() {
            this((byte) 0);
        }

        private a(byte b11) {
        }
    }

    public k(o<T> oVar, com.bykv.vk.openvk.preload.a.h<T> hVar, com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar, s sVar) {
        new a();
        this.f20442a = oVar;
        this.f20443b = hVar;
        this.f20444c = dVar;
        this.f20445d = aVar;
        this.f20446e = sVar;
    }

    private r<T> b() {
        r<T> rVar = this.f20447f;
        if (rVar != null) {
            return rVar;
        }
        r<T> a11 = this.f20444c.a(this.f20446e, this.f20445d);
        this.f20447f = a11;
        return a11;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (this.f20443b == null) {
            return b().a(aVar);
        }
        if (com.bykv.vk.openvk.preload.geckox.h.a.a(aVar) instanceof com.bykv.vk.openvk.preload.a.k) {
            return null;
        }
        com.bykv.vk.openvk.preload.a.h<T> hVar = this.f20443b;
        this.f20445d.b();
        return hVar.a();
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
        o<T> oVar = this.f20442a;
        if (oVar == null) {
            b().a(cVar, t11);
        } else if (t11 == null) {
            cVar.h();
        } else {
            this.f20445d.b();
            com.bykv.vk.openvk.preload.geckox.h.a.a(oVar.a(), cVar);
        }
    }
}
