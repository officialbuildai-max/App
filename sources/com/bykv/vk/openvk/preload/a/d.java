package com.bykv.vk.openvk.preload.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final com.bykv.vk.openvk.preload.a.c.a<?> f20554a = com.bykv.vk.openvk.preload.a.c.a.a(Object.class);

    /* renamed from: b, reason: collision with root package name */
    private final ThreadLocal<Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>>> f20555b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<com.bykv.vk.openvk.preload.a.c.a<?>, r<?>> f20556c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f20557d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.a.d f20558e;

    /* renamed from: f, reason: collision with root package name */
    private List<s> f20559f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f20560g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private r<T> f20563a;

        a() {
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            r<T> rVar = this.f20563a;
            if (rVar != null) {
                return rVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
            r<T> rVar = this.f20563a;
            if (rVar == null) {
                throw new IllegalStateException();
            }
            rVar.a(cVar, t11);
        }

        public final void a(r<T> rVar) {
            if (this.f20563a != null) {
                throw new AssertionError();
            }
            this.f20563a = rVar;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d() {
        /*
            r7 = this;
            com.bykv.vk.openvk.preload.a.b.c r1 = com.bykv.vk.openvk.preload.a.b.c.f20508a
            com.bykv.vk.openvk.preload.a.b r2 = com.bykv.vk.openvk.preload.a.b.f20392a
            java.util.Map r3 = java.util.Collections.emptyMap()
            com.bykv.vk.openvk.preload.a.q r5 = com.bykv.vk.openvk.preload.a.q.f20615a
            java.util.Collections.emptyList()
            java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            r4 = 1
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.<init>():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.bykv.vk.openvk.preload.a.b.c cVar, c cVar2, Map<Type, f<?>> map, boolean z10, q qVar, List<s> list) {
        this.f20555b = new ThreadLocal<>();
        this.f20556c = new ConcurrentHashMap();
        com.bykv.vk.openvk.preload.a.b.b bVar = new com.bykv.vk.openvk.preload.a.b.b(map);
        this.f20557d = bVar;
        this.f20560g = z10;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.B);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.g.f20420a);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20466p);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20457g);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20454d);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20455e);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20456f);
        final r<Number> rVar = qVar == q.f20615a ? com.bykv.vk.openvk.preload.a.b.a.m.f20461k : new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.3
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    cVar3.b(number2.toString());
                }
            }
        };
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Long.TYPE, Long.class, rVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Double.TYPE, Double.class, new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.1
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.doubleValue());
                    cVar3.a(number2);
                }
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Float.TYPE, Float.class, new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.2
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.floatValue());
                    cVar3.a(number2);
                }
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20462l);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20458h);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20459i);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLong.class, new r<AtomicLong>() { // from class: com.bykv.vk.openvk.preload.a.d.4
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicLong a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) r.this.a(aVar)).longValue());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLong atomicLong) throws IOException {
                r.this.a(cVar3, Long.valueOf(atomicLong.get()));
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLongArray.class, new r<AtomicLongArray>() { // from class: com.bykv.vk.openvk.preload.a.d.5
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicLongArray a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList2.add(Long.valueOf(((Number) r.this.a(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i11 = 0; i11 < size; i11++) {
                    atomicLongArray.set(i11, ((Long) arrayList2.get(i11)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLongArray atomicLongArray) throws IOException {
                AtomicLongArray atomicLongArray2 = atomicLongArray;
                cVar3.d();
                int length = atomicLongArray2.length();
                for (int i11 = 0; i11 < length; i11++) {
                    r.this.a(cVar3, Long.valueOf(atomicLongArray2.get(i11)));
                }
                cVar3.e();
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20460j);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20463m);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20467q);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20468r);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigDecimal.class, com.bykv.vk.openvk.preload.a.b.a.m.f20464n));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigInteger.class, com.bykv.vk.openvk.preload.a.b.a.m.f20465o));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20469s);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20470t);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20472v);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20473w);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20476z);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20471u);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20452b);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.c.f20410a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20475y);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.j.f20440a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.i.f20438a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20474x);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.a.f20399a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f20451a);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.b(bVar));
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.f(bVar));
        com.bykv.vk.openvk.preload.a.b.a.d dVar = new com.bykv.vk.openvk.preload.a.b.a.d(bVar);
        this.f20558e = dVar;
        arrayList.add(dVar);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.C);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.h(bVar, cVar2, cVar));
        this.f20559f = Collections.unmodifiableList(arrayList);
    }

    private static com.bykv.vk.openvk.preload.a.d.c a(Writer writer) throws IOException {
        com.bykv.vk.openvk.preload.a.d.c cVar = new com.bykv.vk.openvk.preload.a.d.c(writer);
        cVar.c(false);
        return cVar;
    }

    private <T> T a(com.bykv.vk.openvk.preload.a.d.a aVar, Type type) throws j, p {
        boolean p11 = aVar.p();
        boolean z10 = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z10 = false;
                    return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)).a(aVar);
                } catch (EOFException e11) {
                    if (!z10) {
                        throw new p(e11);
                    }
                    aVar.a(p11);
                    return null;
                } catch (IllegalStateException e12) {
                    throw new p(e12);
                }
            } catch (IOException e13) {
                throw new p(e13);
            } catch (AssertionError e14) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e14.getMessage());
                assertionError.initCause(e14);
                throw assertionError;
            }
        } finally {
            aVar.a(p11);
        }
    }

    static void a(double d11) {
        if (Double.isNaN(d11) || Double.isInfinite(d11)) {
            throw new IllegalArgumentException(d11 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean z10;
        r<T> rVar = (r) this.f20556c.get(aVar == null ? f20554a : aVar);
        if (rVar != null) {
            return rVar;
        }
        Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>> map = this.f20555b.get();
        if (map == null) {
            map = new HashMap<>();
            this.f20555b.set(map);
            z10 = true;
        } else {
            z10 = false;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            Iterator<s> it = this.f20559f.iterator();
            while (it.hasNext()) {
                r<T> a11 = it.next().a(this, aVar);
                if (a11 != null) {
                    aVar3.a((r<?>) a11);
                    this.f20556c.put(aVar, a11);
                    return a11;
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle ".concat(String.valueOf(aVar)));
        } finally {
            map.remove(aVar);
            if (z10) {
                this.f20555b.remove();
            }
        }
    }

    public final <T> r<T> a(s sVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        if (!this.f20559f.contains(sVar)) {
            sVar = this.f20558e;
        }
        boolean z10 = false;
        for (s sVar2 : this.f20559f) {
            if (z10) {
                r<T> a11 = sVar2.a(this, aVar);
                if (a11 != null) {
                    return a11;
                }
            } else if (sVar2 == sVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> r<T> a(Class<T> cls) {
        return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Class) cls));
    }

    public final <T> T a(Reader reader, Type type) throws j, p {
        com.bykv.vk.openvk.preload.a.d.a aVar = new com.bykv.vk.openvk.preload.a.d.a(reader);
        aVar.a(false);
        T t11 = (T) a(aVar, type);
        if (t11 != null) {
            try {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT) {
                    throw new j("JSON document was not fully consumed.");
                }
            } catch (com.bykv.vk.openvk.preload.a.d.d e11) {
                throw new p(e11);
            } catch (IOException e12) {
                throw new j(e12);
            }
        }
        return t11;
    }

    public final String a(Object obj) {
        com.bykv.vk.openvk.preload.a.d.c a11;
        boolean a12;
        boolean b11;
        boolean c11;
        if (obj == null) {
            k kVar = k.f20612a;
            StringWriter stringWriter = new StringWriter();
            try {
                a11 = a((Writer) stringWriter);
                a12 = a11.a();
                a11.a(true);
                b11 = a11.b();
                a11.b(this.f20560g);
                c11 = a11.c();
                a11.c(false);
                try {
                    try {
                        com.bykv.vk.openvk.preload.geckox.h.a.a(kVar, a11);
                        return stringWriter.toString();
                    } finally {
                    }
                } catch (IOException e11) {
                    throw new j(e11);
                } catch (AssertionError e12) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e12.getMessage());
                    assertionError.initCause(e12);
                    throw assertionError;
                }
            } catch (IOException e13) {
                throw new j(e13);
            }
        }
        Class<?> cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            a11 = a((Writer) stringWriter2);
            r a13 = a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Type) cls));
            a12 = a11.a();
            a11.a(true);
            b11 = a11.b();
            a11.b(this.f20560g);
            c11 = a11.c();
            a11.c(false);
            try {
                try {
                    a13.a(a11, obj);
                    return stringWriter2.toString();
                } catch (IOException e14) {
                    throw new j(e14);
                } catch (AssertionError e15) {
                    AssertionError assertionError2 = new AssertionError("AssertionError (GSON pangle-v3200): " + e15.getMessage());
                    assertionError2.initCause(e15);
                    throw assertionError2;
                }
            } finally {
            }
        } catch (IOException e16) {
            throw new j(e16);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f20559f + ",instanceCreators:" + this.f20557d + "}";
    }
}
