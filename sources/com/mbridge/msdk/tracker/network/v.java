package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.tracker.network.b;

/* loaded from: classes5.dex */
public class v<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f38745a;

    /* renamed from: b, reason: collision with root package name */
    public final b.a f38746b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f38747c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f38748d;

    /* loaded from: classes5.dex */
    public interface a {
        void a(b0 b0Var);
    }

    /* loaded from: classes5.dex */
    public interface b<T> {
        void a(T t11);
    }

    private v(b0 b0Var) {
        this.f38748d = false;
        this.f38745a = null;
        this.f38746b = null;
        this.f38747c = b0Var;
    }

    private v(T t11, b.a aVar) {
        this.f38748d = false;
        this.f38745a = t11;
        this.f38746b = aVar;
        this.f38747c = null;
    }

    public static <T> v<T> a(b0 b0Var) {
        return new v<>(b0Var);
    }

    public static <T> v<T> a(T t11, b.a aVar) {
        return new v<>(t11, aVar);
    }

    public boolean a() {
        return this.f38747c == null;
    }
}
