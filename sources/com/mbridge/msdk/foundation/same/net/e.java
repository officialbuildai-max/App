package com.mbridge.msdk.foundation.same.net;

/* loaded from: classes5.dex */
public class e<T> {

    /* renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.net.exception.a f35480a = null;

    /* renamed from: b, reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.net.toolbox.a f35481b;

    /* renamed from: c, reason: collision with root package name */
    public T f35482c;

    private e(T t11, com.mbridge.msdk.foundation.same.net.toolbox.a aVar) {
        this.f35482c = t11;
        this.f35481b = aVar;
    }

    public static <T> e<T> a(T t11, com.mbridge.msdk.foundation.same.net.toolbox.a aVar) {
        return new e<>(t11, aVar);
    }
}
