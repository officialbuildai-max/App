package q;

import kotlin.jvm.internal.DefaultConstructorMarker;
import o0.i;

/* loaded from: classes2.dex */
final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private final float f73163a;

    private d(float f11) {
        this.f73163a = f11;
    }

    public /* synthetic */ d(float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11);
    }

    @Override // q.b
    public float a(long j11, o0.e eVar) {
        return eVar.E0(this.f73163a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && i.i(this.f73163a, ((d) obj).f73163a);
    }

    public int hashCode() {
        return i.j(this.f73163a);
    }

    public String toString() {
        return "CornerSize(size = " + this.f73163a + ".dp)";
    }
}
