package androidx.compose.ui.node;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: c, reason: collision with root package name */
    public static final int f5490c = androidx.compose.runtime.collection.b.f3755d;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5491a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f5492b;

    public n0(androidx.compose.runtime.collection.b bVar, Function0 function0) {
        this.f5491a = bVar;
        this.f5492b = function0;
    }

    public final void a(int i11, Object obj) {
        this.f5491a.a(i11, obj);
        this.f5492b.invoke();
    }

    public final List b() {
        return this.f5491a.g();
    }

    public final void c() {
        this.f5491a.h();
        this.f5492b.invoke();
    }

    public final Object d(int i11) {
        return this.f5491a.m()[i11];
    }

    public final int e() {
        return this.f5491a.n();
    }

    public final androidx.compose.runtime.collection.b f() {
        return this.f5491a;
    }

    public final Object g(int i11) {
        Object v11 = this.f5491a.v(i11);
        this.f5492b.invoke();
        return v11;
    }
}
