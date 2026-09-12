package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes7.dex */
final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    private final f f68171a;

    /* renamed from: b, reason: collision with root package name */
    public final KClass f68172b;

    /* renamed from: c, reason: collision with root package name */
    private final String f68173c;

    public c(f original, KClass kClass) {
        Intrinsics.h(original, "original");
        Intrinsics.h(kClass, "kClass");
        this.f68171a = original;
        this.f68172b = kClass;
        this.f68173c = original.i() + '<' + kClass.g() + '>';
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return this.f68171a.b();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        return this.f68171a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.f
    public h d() {
        return this.f68171a.d();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.f68171a.e();
    }

    public boolean equals(Object obj) {
        c cVar = obj instanceof c ? (c) obj : null;
        return cVar != null && Intrinsics.c(this.f68171a, cVar.f68171a) && Intrinsics.c(cVar.f68172b, this.f68172b);
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f(int i11) {
        return this.f68171a.f(i11);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i11) {
        return this.f68171a.g(i11);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        return this.f68171a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.f
    public f h(int i11) {
        return this.f68171a.h(i11);
    }

    public int hashCode() {
        return (this.f68172b.hashCode() * 31) + i().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.f68173c;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return this.f68171a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean j(int i11) {
        return this.f68171a.j(i11);
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.f68172b + ", original: " + this.f68171a + ')';
    }
}
