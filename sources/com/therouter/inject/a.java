package com.therouter.inject;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Class f40806a;

    /* renamed from: b, reason: collision with root package name */
    private String f40807b;

    public a(Class clazz, Object... params) {
        Intrinsics.h(clazz, "clazz");
        Intrinsics.h(params, "params");
        this.f40806a = clazz;
        for (Object obj : params) {
            if (obj != null) {
                this.f40807b = this.f40807b + obj;
            }
        }
    }

    public final Class a() {
        return this.f40806a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return super.equals(obj);
        }
        a aVar = (a) obj;
        return Intrinsics.c(a(), aVar.a()) && Intrinsics.c(this.f40807b, aVar.f40807b);
    }

    public int hashCode() {
        int hashCode = a().hashCode();
        String str = this.f40807b;
        if (str == null) {
            str = "";
        }
        int hashCode2 = str.hashCode();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hashCode);
        sb2.append(hashCode2);
        return sb2.toString().hashCode();
    }
}
