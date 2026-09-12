package kotlinx.serialization.internal;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class v1 implements kotlinx.serialization.descriptors.f, n {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68331a;

    /* renamed from: b, reason: collision with root package name */
    private final String f68332b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f68333c;

    public v1(kotlinx.serialization.descriptors.f original) {
        Intrinsics.h(original, "original");
        this.f68331a = original;
        this.f68332b = original.i() + '?';
        this.f68333c = l1.a(original);
    }

    @Override // kotlinx.serialization.internal.n
    public Set a() {
        return this.f68333c;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        return this.f68331a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.h d() {
        return this.f68331a.d();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.f68331a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v1) && Intrinsics.c(this.f68331a, ((v1) obj).f68331a);
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f(int i11) {
        return this.f68331a.f(i11);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i11) {
        return this.f68331a.g(i11);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        return this.f68331a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f h(int i11) {
        return this.f68331a.h(i11);
    }

    public int hashCode() {
        return this.f68331a.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.f68332b;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return this.f68331a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean j(int i11) {
        return this.f68331a.j(i11);
    }

    public final kotlinx.serialization.descriptors.f k() {
        return this.f68331a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f68331a);
        sb2.append('?');
        return sb2.toString();
    }
}
