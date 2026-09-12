package androidx.compose.ui.platform;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class k2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f5913a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f5914b;

    public k2(String str, Object obj) {
        this.f5913a = str;
        this.f5914b = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k2)) {
            return false;
        }
        k2 k2Var = (k2) obj;
        return Intrinsics.c(this.f5913a, k2Var.f5913a) && Intrinsics.c(this.f5914b, k2Var.f5914b);
    }

    public int hashCode() {
        int hashCode = this.f5913a.hashCode() * 31;
        Object obj = this.f5914b;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "ValueElement(name=" + this.f5913a + ", value=" + this.f5914b + ')';
    }
}
