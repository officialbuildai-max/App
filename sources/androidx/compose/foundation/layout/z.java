package androidx.compose.foundation.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private float f2961a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2962b;

    /* renamed from: c, reason: collision with root package name */
    private m f2963c;

    public z() {
        this(0.0f, false, null, null, 15, null);
    }

    public z(float f11, boolean z10, m mVar, p pVar) {
        this.f2961a = f11;
        this.f2962b = z10;
        this.f2963c = mVar;
    }

    public /* synthetic */ z(float f11, boolean z10, m mVar, p pVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? true : z10, (i11 & 4) != 0 ? null : mVar, (i11 & 8) != 0 ? null : pVar);
    }

    public final m a() {
        return this.f2963c;
    }

    public final boolean b() {
        return this.f2962b;
    }

    public final p c() {
        return null;
    }

    public final float d() {
        return this.f2961a;
    }

    public final void e(m mVar) {
        this.f2963c = mVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return Float.compare(this.f2961a, zVar.f2961a) == 0 && this.f2962b == zVar.f2962b && Intrinsics.c(this.f2963c, zVar.f2963c) && Intrinsics.c(null, null);
    }

    public final void f(boolean z10) {
        this.f2962b = z10;
    }

    public final void g(float f11) {
        this.f2961a = f11;
    }

    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.f2961a) * 31) + androidx.compose.foundation.e.a(this.f2962b)) * 31;
        m mVar = this.f2963c;
        return (floatToIntBits + (mVar == null ? 0 : mVar.hashCode())) * 31;
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.f2961a + ", fill=" + this.f2962b + ", crossAxisAlignment=" + this.f2963c + ", flowLayoutData=" + ((Object) null) + ')';
    }
}
