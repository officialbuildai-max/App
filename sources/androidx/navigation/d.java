package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final o f13945a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f13946b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f13947c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f13948d;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private o f13949a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13950b;

        /* renamed from: c, reason: collision with root package name */
        private Object f13951c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f13952d;

        public final d a() {
            o oVar = this.f13949a;
            if (oVar == null) {
                oVar = o.f14018c.c(this.f13951c);
            }
            return new d(oVar, this.f13950b, this.f13951c, this.f13952d);
        }

        public final a b(Object obj) {
            this.f13951c = obj;
            this.f13952d = true;
            return this;
        }

        public final a c(boolean z10) {
            this.f13950b = z10;
            return this;
        }

        public final a d(o type) {
            Intrinsics.h(type, "type");
            this.f13949a = type;
            return this;
        }
    }

    public d(o type, boolean z10, Object obj, boolean z11) {
        Intrinsics.h(type, "type");
        if (!type.c() && z10) {
            throw new IllegalArgumentException(Intrinsics.q(type.b(), " does not allow nullable values").toString());
        }
        if (!z10 && z11 && obj == null) {
            throw new IllegalArgumentException(("Argument with type " + type.b() + " has null value but is not nullable.").toString());
        }
        this.f13945a = type;
        this.f13946b = z10;
        this.f13948d = obj;
        this.f13947c = z11;
    }

    public final o a() {
        return this.f13945a;
    }

    public final boolean b() {
        return this.f13947c;
    }

    public final boolean c() {
        return this.f13946b;
    }

    public final void d(String name, Bundle bundle) {
        Intrinsics.h(name, "name");
        Intrinsics.h(bundle, "bundle");
        if (this.f13947c) {
            this.f13945a.f(bundle, name, this.f13948d);
        }
    }

    public final boolean e(String name, Bundle bundle) {
        Intrinsics.h(name, "name");
        Intrinsics.h(bundle, "bundle");
        if (!this.f13946b && bundle.containsKey(name) && bundle.get(name) == null) {
            return false;
        }
        try {
            this.f13945a.a(bundle, name);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(d.class, obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f13946b != dVar.f13946b || this.f13947c != dVar.f13947c || !Intrinsics.c(this.f13945a, dVar.f13945a)) {
            return false;
        }
        Object obj2 = this.f13948d;
        return obj2 != null ? Intrinsics.c(obj2, dVar.f13948d) : dVar.f13948d == null;
    }

    public int hashCode() {
        int hashCode = ((((this.f13945a.hashCode() * 31) + (this.f13946b ? 1 : 0)) * 31) + (this.f13947c ? 1 : 0)) * 31;
        Object obj = this.f13948d;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }
}
