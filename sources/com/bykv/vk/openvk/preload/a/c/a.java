package com.bykv.vk.openvk.preload.a.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private Class<? super T> f20551a;

    /* renamed from: b, reason: collision with root package name */
    private Type f20552b;

    /* renamed from: c, reason: collision with root package name */
    private int f20553c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        Type a11 = com.bykv.vk.openvk.preload.a.b.a.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.f20552b = a11;
        this.f20551a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(a11);
        this.f20553c = this.f20552b.hashCode();
    }

    private a(Type type) {
        Type a11 = com.bykv.vk.openvk.preload.a.b.a.a((Type) com.bykv.vk.openvk.preload.falconx.a.a.a(type));
        this.f20552b = a11;
        this.f20551a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(a11);
        this.f20553c = this.f20552b.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public final Class<? super T> a() {
        return this.f20551a;
    }

    public final Type b() {
        return this.f20552b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && com.bykv.vk.openvk.preload.a.b.a.a(this.f20552b, ((a) obj).f20552b);
    }

    public final int hashCode() {
        return this.f20553c;
    }

    public final String toString() {
        return com.bykv.vk.openvk.preload.a.b.a.c(this.f20552b);
    }
}
