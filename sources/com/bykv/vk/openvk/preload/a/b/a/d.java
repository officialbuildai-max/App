package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;

/* loaded from: classes2.dex */
public final class d implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f20414a;

    public d(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f20414a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r<?> a(com.bykv.vk.openvk.preload.a.b.b bVar, com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<?> aVar, com.bykv.vk.openvk.preload.a.a.a aVar2) {
        r<?> kVar;
        Object a11 = bVar.a(com.bykv.vk.openvk.preload.a.c.a.a((Class) aVar2.a())).a();
        if (a11 instanceof r) {
            kVar = (r) a11;
        } else if (a11 instanceof s) {
            kVar = ((s) a11).a(dVar, aVar);
        } else {
            boolean z10 = a11 instanceof o;
            if (!z10 && !(a11 instanceof com.bykv.vk.openvk.preload.a.h)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a11.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            kVar = new k<>(z10 ? (o) a11 : null, a11 instanceof com.bykv.vk.openvk.preload.a.h ? (com.bykv.vk.openvk.preload.a.h) a11 : null, dVar, aVar, null);
        }
        return (kVar == null || !aVar2.b()) ? kVar : kVar.a();
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        com.bykv.vk.openvk.preload.a.a.a aVar2 = (com.bykv.vk.openvk.preload.a.a.a) aVar.a().getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class);
        if (aVar2 == null) {
            return null;
        }
        return (r<T>) a(this.f20414a, dVar, aVar, aVar2);
    }
}
