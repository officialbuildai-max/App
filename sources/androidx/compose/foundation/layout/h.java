package androidx.compose.foundation.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class h implements g, f {

    /* renamed from: a, reason: collision with root package name */
    private final o0.e f2931a;

    /* renamed from: b, reason: collision with root package name */
    private final long f2932b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ BoxScopeInstance f2933c;

    private h(o0.e eVar, long j11) {
        this.f2931a = eVar;
        this.f2932b = j11;
        this.f2933c = BoxScopeInstance.f2819a;
    }

    public /* synthetic */ h(o0.e eVar, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, j11);
    }

    @Override // androidx.compose.foundation.layout.g
    public long a() {
        return this.f2932b;
    }

    @Override // androidx.compose.foundation.layout.f
    public androidx.compose.ui.f b(androidx.compose.ui.f fVar, androidx.compose.ui.b bVar) {
        return this.f2933c.b(fVar, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.c(this.f2931a, hVar.f2931a) && o0.b.f(this.f2932b, hVar.f2932b);
    }

    public int hashCode() {
        return (this.f2931a.hashCode() * 31) + o0.b.o(this.f2932b);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.f2931a + ", constraints=" + ((Object) o0.b.q(this.f2932b)) + ')';
    }
}
