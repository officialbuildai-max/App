package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final v f6527a;

    /* renamed from: b, reason: collision with root package name */
    private final u f6528b;

    public w(v vVar, u uVar) {
        this.f6527a = vVar;
        this.f6528b = uVar;
    }

    public w(boolean z10) {
        this(null, new u(z10));
    }

    public final u a() {
        return this.f6528b;
    }

    public final v b() {
        return this.f6527a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.c(this.f6528b, wVar.f6528b) && Intrinsics.c(this.f6527a, wVar.f6527a);
    }

    public int hashCode() {
        v vVar = this.f6527a;
        int hashCode = (vVar != null ? vVar.hashCode() : 0) * 31;
        u uVar = this.f6528b;
        return hashCode + (uVar != null ? uVar.hashCode() : 0);
    }

    public String toString() {
        return "PlatformTextStyle(spanStyle=" + this.f6527a + ", paragraphSyle=" + this.f6528b + ')';
    }
}
