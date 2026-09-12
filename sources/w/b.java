package w;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f77609a;

    public b() {
        this(0, 1, null);
    }

    public b(int i11) {
        this.f77609a = i11;
    }

    public /* synthetic */ b(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public final int a() {
        return this.f77609a;
    }

    public final void b(int i11) {
        this.f77609a += i11;
    }

    public final void c(int i11) {
        this.f77609a = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f77609a == ((b) obj).f77609a;
    }

    public int hashCode() {
        return this.f77609a;
    }

    public String toString() {
        return "DeltaCounter(count=" + this.f77609a + ')';
    }
}
