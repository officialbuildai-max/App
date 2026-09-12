package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f20416a;

    /* loaded from: classes2.dex */
    final class a<K, V> extends r<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final r<K> f20417a;

        /* renamed from: b, reason: collision with root package name */
        private final r<V> f20418b;

        /* renamed from: c, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> f20419c;

        public a(f fVar, com.bykv.vk.openvk.preload.a.d dVar, Type type, r<K> rVar, Type type2, r<V> rVar2, com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> hVar) {
            this.f20417a = new l(dVar, rVar, type);
            this.f20418b = new l(dVar, rVar2, type2);
            this.f20419c = hVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            com.bykv.vk.openvk.preload.a.d.b f11 = aVar.f();
            if (f11 == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> a11 = this.f20419c.a();
            if (f11 == com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K a12 = this.f20417a.a(aVar);
                    if (a11.put(a12, this.f20418b.a(aVar)) != null) {
                        throw new p("duplicate key: ".concat(String.valueOf(a12)));
                    }
                    aVar.b();
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.bykv.vk.openvk.preload.a.b.e.f20521a.a(aVar);
                    K a13 = this.f20417a.a(aVar);
                    if (a11.put(a13, this.f20418b.a(aVar)) != null) {
                        throw new p("duplicate key: ".concat(String.valueOf(a13)));
                    }
                }
                aVar.d();
            }
            return a11;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                cVar.h();
                return;
            }
            cVar.f();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                cVar.a(String.valueOf(entry.getKey()));
                this.f20418b.a(cVar, entry.getValue());
            }
            cVar.g();
        }
    }

    public f(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f20416a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Type b11 = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b12 = com.bykv.vk.openvk.preload.a.b.a.b(b11, com.bykv.vk.openvk.preload.a.b.a.b(b11));
        Type type = b12[0];
        return new a(this, dVar, b12[0], (type == Boolean.TYPE || type == Boolean.class) ? m.f20453c : dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)), b12[1], dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(b12[1])), this.f20416a.a(aVar));
    }
}
