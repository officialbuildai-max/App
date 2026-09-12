package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public abstract class c1 implements kotlinx.serialization.descriptors.f {

    /* renamed from: a, reason: collision with root package name */
    private final String f68239a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68240b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68241c;

    /* renamed from: d, reason: collision with root package name */
    private final int f68242d;

    private c1(String str, kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.descriptors.f fVar2) {
        this.f68239a = str;
        this.f68240b = fVar;
        this.f68241c = fVar2;
        this.f68242d = 2;
    }

    public /* synthetic */ c1(String str, kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.descriptors.f fVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fVar, fVar2);
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
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.h d() {
        return i.c.f68195a;
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.f68242d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return Intrinsics.c(i(), c1Var.i()) && Intrinsics.c(this.f68240b, c1Var.f68240b) && Intrinsics.c(this.f68241c, c1Var.f68241c);
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
            int i12 = i11 % 2;
            if (i12 == 0) {
                return this.f68240b;
            }
            if (i12 == 1) {
                return this.f68241c;
            }
            throw new IllegalStateException("Unreached");
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + this.f68240b.hashCode()) * 31) + this.f68241c.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.f68239a;
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
        return i() + '(' + this.f68240b + ", " + this.f68241c + ')';
    }
}
