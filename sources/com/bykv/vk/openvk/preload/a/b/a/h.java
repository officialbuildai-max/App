package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class h implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f20423a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.c f20424b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.c f20425c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b.b f20426d = com.bykv.vk.openvk.preload.a.b.b.b.a();

    /* loaded from: classes2.dex */
    public static final class a<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<T> f20433a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, b> f20434b;

        a(com.bykv.vk.openvk.preload.a.b.h<T> hVar, Map<String, b> map) {
            this.f20433a = hVar;
            this.f20434b = map;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a11 = this.f20433a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f20434b.get(aVar.g());
                    if (bVar != null && bVar.f20437c) {
                        bVar.a(aVar, a11);
                    }
                    aVar.n();
                }
                aVar.d();
                return a11;
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            } catch (IllegalStateException e12) {
                throw new p(e12);
            }
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
            if (t11 == null) {
                cVar.h();
                return;
            }
            cVar.f();
            try {
                for (b bVar : this.f20434b.values()) {
                    if (bVar.a(t11)) {
                        cVar.a(bVar.f20435a);
                        bVar.a(cVar, t11);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        final String f20435a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f20436b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f20437c;

        protected b(String str, boolean z10, boolean z11) {
            this.f20435a = str;
            this.f20436b = z10;
            this.f20437c = z11;
        }

        abstract void a(com.bykv.vk.openvk.preload.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean a(Object obj) throws IOException, IllegalAccessException;
    }

    public h(com.bykv.vk.openvk.preload.a.b.b bVar, com.bykv.vk.openvk.preload.a.c cVar, com.bykv.vk.openvk.preload.a.b.c cVar2) {
        this.f20423a = bVar;
        this.f20424b = cVar;
        this.f20425c = cVar2;
    }

    private List<String> a(Field field) {
        com.bykv.vk.openvk.preload.a.a.b bVar = (com.bykv.vk.openvk.preload.a.a.b) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.b.class);
        if (bVar == null) {
            return Collections.singletonList(this.f20424b.a(field));
        }
        String a11 = bVar.a();
        String[] b11 = bVar.b();
        if (b11.length == 0) {
            return Collections.singletonList(a11);
        }
        ArrayList arrayList = new ArrayList(b11.length + 1);
        arrayList.add(a11);
        for (String str : b11) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    private Map<String, b> a(final com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<?> aVar, Class<?> cls) {
        Class<?> cls2;
        int i11;
        boolean z10;
        int i12;
        Field[] fieldArr;
        com.bykv.vk.openvk.preload.a.c.a<?> aVar2;
        h hVar = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b11 = aVar.b();
        com.bykv.vk.openvk.preload.a.c.a<?> aVar3 = aVar;
        Class<?> cls3 = cls;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            int length = declaredFields.length;
            boolean z11 = false;
            int i13 = 0;
            while (i13 < length) {
                Field field = declaredFields[i13];
                boolean a11 = hVar.a(field, true);
                boolean a12 = hVar.a(field, z11);
                if (a11 || a12) {
                    hVar.f20426d.a(field);
                    Type a13 = com.bykv.vk.openvk.preload.a.b.a.a(aVar3.b(), cls3, field.getGenericType());
                    List<String> a14 = hVar.a(field);
                    int size = a14.size();
                    ?? r22 = z11;
                    cls2 = cls3;
                    b bVar = null;
                    while (r22 < size) {
                        com.bykv.vk.openvk.preload.a.c.a<?> aVar4 = aVar3;
                        String str = a14.get(r22);
                        boolean z12 = r22 != 0 ? z11 : a11;
                        final com.bykv.vk.openvk.preload.a.c.a<?> a15 = com.bykv.vk.openvk.preload.a.c.a.a(a13);
                        Class<? super Object> a16 = a15.a();
                        boolean z13 = (a16 instanceof Class) && a16.isPrimitive();
                        com.bykv.vk.openvk.preload.a.a.a aVar5 = (com.bykv.vk.openvk.preload.a.a.a) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class);
                        r<?> a17 = aVar5 != null ? d.a(hVar.f20423a, dVar, a15, aVar5) : null;
                        boolean z14 = a17 != null;
                        if (a17 == null) {
                            a17 = dVar.a((com.bykv.vk.openvk.preload.a.c.a) a15);
                        }
                        final r<?> rVar = a17;
                        int i14 = r22;
                        int i15 = size;
                        List<String> list = a14;
                        final Field field2 = field;
                        Field field3 = field;
                        final boolean z15 = z14;
                        int i16 = i13;
                        int i17 = length;
                        Field[] fieldArr2 = declaredFields;
                        final boolean z16 = z13;
                        b bVar2 = (b) linkedHashMap.put(str, new b(str, z12, a12) { // from class: com.bykv.vk.openvk.preload.a.b.a.h.1
                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            final void a(com.bykv.vk.openvk.preload.a.d.a aVar6, Object obj) throws IOException, IllegalAccessException {
                                Object a18 = rVar.a(aVar6);
                                if (a18 == null && z16) {
                                    return;
                                }
                                field2.set(obj, a18);
                            }

                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                                (z15 ? rVar : new l(dVar, rVar, a15.b())).a(cVar, field2.get(obj));
                            }

                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            public final boolean a(Object obj) throws IOException, IllegalAccessException {
                                return this.f20436b && field2.get(obj) != obj;
                            }
                        });
                        if (bVar == null) {
                            bVar = bVar2;
                        }
                        hVar = this;
                        aVar3 = aVar4;
                        a11 = z12;
                        z11 = false;
                        length = i17;
                        declaredFields = fieldArr2;
                        size = i15;
                        a14 = list;
                        field = field3;
                        i13 = i16;
                        r22 = i14 + 1;
                    }
                    i11 = i13;
                    z10 = z11;
                    i12 = length;
                    fieldArr = declaredFields;
                    aVar2 = aVar3;
                    if (bVar != null) {
                        throw new IllegalArgumentException(b11 + " declares multiple JSON fields named " + bVar.f20435a);
                    }
                } else {
                    i11 = i13;
                    z10 = z11;
                    i12 = length;
                    fieldArr = declaredFields;
                    aVar2 = aVar3;
                    cls2 = cls3;
                }
                i13 = i11 + 1;
                hVar = this;
                cls3 = cls2;
                aVar3 = aVar2;
                z11 = z10;
                length = i12;
                declaredFields = fieldArr;
            }
            Class<?> cls4 = cls3;
            aVar3 = com.bykv.vk.openvk.preload.a.c.a.a(com.bykv.vk.openvk.preload.a.b.a.a(aVar3.b(), cls4, cls4.getGenericSuperclass()));
            cls3 = aVar3.a();
            hVar = this;
        }
        return linkedHashMap;
    }

    private boolean a(Field field, boolean z10) {
        com.bykv.vk.openvk.preload.a.b.c cVar = this.f20425c;
        return (cVar.a(field.getType(), z10) || cVar.a(field, z10)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Class<? super T> a11 = aVar.a();
        if (Object.class.isAssignableFrom(a11)) {
            return new a(this.f20423a.a(aVar), a(dVar, aVar, a11));
        }
        return null;
    }
}
