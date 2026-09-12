package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.a.h;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l<T> extends r<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.d f20448a;

    /* renamed from: b, reason: collision with root package name */
    private final r<T> f20449b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f20450c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.bykv.vk.openvk.preload.a.d dVar, r<T> rVar, Type type) {
        this.f20448a = dVar;
        this.f20449b = rVar;
        this.f20450c = type;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        return this.f20449b.a(aVar);
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
        r<T> rVar = this.f20449b;
        Type type = this.f20450c;
        if (t11 != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t11.getClass();
        }
        if (type != this.f20450c) {
            rVar = this.f20448a.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type));
            if (rVar instanceof h.a) {
                r<T> rVar2 = this.f20449b;
                if (!(rVar2 instanceof h.a)) {
                    rVar = rVar2;
                }
            }
        }
        rVar.a(cVar, t11);
    }
}
