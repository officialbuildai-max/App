package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f32423a;

    private e() {
        this.f32423a = null;
    }

    private e(Object obj) {
        if (obj == null) {
            throw new NullPointerException("value for optional is empty.");
        }
        this.f32423a = obj;
    }

    public static e a() {
        return new e();
    }

    public static e b(Object obj) {
        return obj == null ? a() : e(obj);
    }

    public static e e(Object obj) {
        return new e(obj);
    }

    public Object c() {
        Object obj = this.f32423a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean d() {
        return this.f32423a != null;
    }
}
