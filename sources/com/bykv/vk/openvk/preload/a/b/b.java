package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, com.bykv.vk.openvk.preload.a.f<?>> f20495a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b.b f20496b = com.bykv.vk.openvk.preload.a.b.b.b.a();

    public b(Map<Type, com.bykv.vk.openvk.preload.a.f<?>> map) {
        this.f20495a = map;
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                this.f20496b.a(declaredConstructor);
            }
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.8
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e11) {
                        throw new AssertionError(e11);
                    } catch (InstantiationException e12) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e12);
                    } catch (InvocationTargetException e13) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e13.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> h<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        final Type b11 = aVar.b();
        final Class<? super T> a11 = aVar.a();
        final com.bykv.vk.openvk.preload.a.f<?> fVar = this.f20495a.get(b11);
        if (fVar != null) {
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.1
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) com.bykv.vk.openvk.preload.a.f.this.a();
                }
            };
        }
        final com.bykv.vk.openvk.preload.a.f<?> fVar2 = this.f20495a.get(a11);
        if (fVar2 != null) {
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.7
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) com.bykv.vk.openvk.preload.a.f.this.a();
                }
            };
        }
        h<T> a12 = a(a11);
        if (a12 != null) {
            return a12;
        }
        h<T> hVar = Collection.class.isAssignableFrom(a11) ? SortedSet.class.isAssignableFrom(a11) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.9
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new TreeSet();
            }
        } : EnumSet.class.isAssignableFrom(a11) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.10
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                Type type = b11;
                if (!(type instanceof ParameterizedType)) {
                    throw new j("Invalid EnumSet type: " + b11.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new j("Invalid EnumSet type: " + b11.toString());
            }
        } : Set.class.isAssignableFrom(a11) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.11
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new LinkedHashSet();
            }
        } : Queue.class.isAssignableFrom(a11) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.12
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ArrayDeque();
            }
        } : new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.13
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(a11) ? ConcurrentNavigableMap.class.isAssignableFrom(a11) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.14
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ConcurrentSkipListMap();
            }
        } : ConcurrentMap.class.isAssignableFrom(a11) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.2
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ConcurrentHashMap();
            }
        } : SortedMap.class.isAssignableFrom(a11) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.3
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new TreeMap();
            }
        } : (!(b11 instanceof ParameterizedType) || String.class.isAssignableFrom(com.bykv.vk.openvk.preload.a.c.a.a(((ParameterizedType) b11).getActualTypeArguments()[0]).a())) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.5
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new g();
            }
        } : new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.4
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new LinkedHashMap();
            }
        } : null;
        return hVar != null ? hVar : new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.6

            /* renamed from: a, reason: collision with root package name */
            private final i f20499a = i.a();

            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                try {
                    return this.f20499a.a(a11);
                } catch (Exception e11) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + b11 + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e11);
                }
            }
        };
    }

    public final String toString() {
        return this.f20495a.toString();
    }
}
