package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class b implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f20404a;

    /* loaded from: classes2.dex */
    static final class a<E> extends r<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final r<E> f20408a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<? extends Collection<E>> f20409b;

        public a(com.bykv.vk.openvk.preload.a.d dVar, Type type, r<E> rVar, com.bykv.vk.openvk.preload.a.b.h<? extends Collection<E>> hVar) {
            this.f20408a = new l(dVar, rVar, type);
            this.f20409b = hVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> a11 = this.f20409b.a();
            aVar.a();
            while (aVar.e()) {
                a11.add(this.f20408a.a(aVar));
            }
            aVar.b();
            return a11;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Collection collection = (Collection) obj;
            if (collection == null) {
                cVar.h();
                return;
            }
            cVar.d();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f20408a.a(cVar, it.next());
            }
            cVar.e();
        }
    }

    public b(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f20404a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Type b11 = aVar.b();
        Class<? super T> a11 = aVar.a();
        if (!Collection.class.isAssignableFrom(a11)) {
            return null;
        }
        Type a12 = com.bykv.vk.openvk.preload.a.b.a.a(b11, (Class<?>) a11);
        return new a(dVar, a12, dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(a12)), this.f20404a.a(aVar));
    }
}
