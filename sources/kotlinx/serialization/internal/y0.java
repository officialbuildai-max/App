package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public abstract class y0 implements kotlinx.serialization.descriptors.f {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68338a;

    /* renamed from: b, reason: collision with root package name */
    private final int f68339b;

    private y0(kotlinx.serialization.descriptors.f fVar) {
        this.f68338a = fVar;
        this.f68339b = 1;
    }

    public /* synthetic */ y0(kotlinx.serialization.descriptors.f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return f.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        Integer v11 = StringsKt.v(name);
        if (v11 != null) {
            return v11.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.h d() {
        return i.b.f68194a;
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.f68339b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return Intrinsics.c(this.f68338a, y0Var.f68338a) && Intrinsics.c(i(), y0Var.i());
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f(int i11) {
        return String.valueOf(i11);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i11) {
        if (i11 >= 0) {
            return CollectionsKt.l();
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + i() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        return f.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f h(int i11) {
        if (i11 >= 0) {
            return this.f68338a;
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.f68338a.hashCode() * 31) + i().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return f.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean j(int i11) {
        if (i11 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + i() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return i() + '(' + this.f68338a + ')';
    }
}
