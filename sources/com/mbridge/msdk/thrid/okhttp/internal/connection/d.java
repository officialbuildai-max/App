package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.a0;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<a0> f38009a = new LinkedHashSet();

    public synchronized void a(a0 a0Var) {
        this.f38009a.remove(a0Var);
    }

    public synchronized void b(a0 a0Var) {
        this.f38009a.add(a0Var);
    }

    public synchronized boolean c(a0 a0Var) {
        return this.f38009a.contains(a0Var);
    }
}
