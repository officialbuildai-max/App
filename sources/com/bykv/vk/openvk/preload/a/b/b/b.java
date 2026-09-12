package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.b.d;
import java.lang.reflect.AccessibleObject;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f20504a;

    static {
        f20504a = d.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f20504a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
