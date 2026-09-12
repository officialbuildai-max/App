package com.squareup.okhttp.internal;

import com.squareup.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final Set f40361a = new LinkedHashSet();

    public synchronized void a(Route route) {
        this.f40361a.remove(route);
    }

    public synchronized void b(Route route) {
        this.f40361a.add(route);
    }

    public synchronized boolean c(Route route) {
        return this.f40361a.contains(route);
    }
}
