package com.therouter.router;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Navigator f40845a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f40846b;

    public g(Navigator navigator, Function0 action) {
        Intrinsics.h(navigator, "navigator");
        Intrinsics.h(action, "action");
        this.f40845a = navigator;
        this.f40846b = action;
    }

    public final Function0 a() {
        return this.f40846b;
    }

    public boolean equals(Object obj) {
        return obj instanceof g ? Intrinsics.c(((g) obj).f40845a, this.f40845a) : super.equals(obj);
    }

    public int hashCode() {
        return this.f40845a.hashCode() + 1;
    }
}
