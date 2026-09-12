package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class c3 implements g3 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3752a;

    public c3(Object obj) {
        this.f3752a = obj;
    }

    @Override // androidx.compose.runtime.g3
    public Object a(n1 n1Var) {
        return this.f3752a;
    }

    public final Object b() {
        return this.f3752a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c3) && Intrinsics.c(this.f3752a, ((c3) obj).f3752a);
    }

    public int hashCode() {
        Object obj = this.f3752a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "StaticValueHolder(value=" + this.f3752a + ')';
    }
}
