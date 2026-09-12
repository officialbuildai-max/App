package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f0 implements g3 {

    /* renamed from: a, reason: collision with root package name */
    private final i1 f3806a;

    public f0(i1 i1Var) {
        this.f3806a = i1Var;
    }

    @Override // androidx.compose.runtime.g3
    public Object a(n1 n1Var) {
        return this.f3806a.getValue();
    }

    public final i1 b() {
        return this.f3806a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && Intrinsics.c(this.f3806a, ((f0) obj).f3806a);
    }

    public int hashCode() {
        return this.f3806a.hashCode();
    }

    public String toString() {
        return "DynamicValueHolder(state=" + this.f3806a + ')';
    }
}
