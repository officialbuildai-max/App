package e00;

import e00.c;
import e00.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;

/* loaded from: classes7.dex */
public abstract class a implements e, c {
    @Override // e00.c
    public final char A(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return x();
    }

    @Override // e00.c
    public final byte B(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return H();
    }

    @Override // e00.c
    public final boolean C(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return w();
    }

    @Override // e00.e
    public boolean D() {
        return true;
    }

    @Override // e00.c
    public final short E(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return s();
    }

    @Override // e00.c
    public final double F(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return v();
    }

    @Override // e00.e
    public Object G(kotlinx.serialization.a aVar) {
        return e.a.a(this, aVar);
    }

    @Override // e00.e
    public byte H() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) J).byteValue();
    }

    public Object I(kotlinx.serialization.a deserializer, Object obj) {
        Intrinsics.h(deserializer, "deserializer");
        return G(deserializer);
    }

    public Object J() {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // e00.e
    public c b(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return this;
    }

    @Override // e00.c
    public void c(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
    }

    @Override // e00.e
    public int e(kotlinx.serialization.descriptors.f enumDescriptor) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) J).intValue();
    }

    @Override // e00.c
    public final long f(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return l();
    }

    @Override // e00.e
    public int h() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) J).intValue();
    }

    @Override // e00.c
    public final int i(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return h();
    }

    @Override // e00.e
    public Void j() {
        return null;
    }

    @Override // e00.c
    public int k(kotlinx.serialization.descriptors.f fVar) {
        return c.a.a(this, fVar);
    }

    @Override // e00.e
    public long l() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) J).longValue();
    }

    @Override // e00.c
    public final String m(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return z();
    }

    @Override // e00.c
    public final Object n(kotlinx.serialization.descriptors.f descriptor, int i11, kotlinx.serialization.a deserializer, Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || D()) ? I(deserializer, obj) : j();
    }

    @Override // e00.c
    public boolean p() {
        return c.a.b(this);
    }

    @Override // e00.e
    public e q(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return this;
    }

    @Override // e00.c
    public e r(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return q(descriptor.h(i11));
    }

    @Override // e00.e
    public short s() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) J).shortValue();
    }

    @Override // e00.e
    public float t() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) J).floatValue();
    }

    @Override // e00.c
    public final float u(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return t();
    }

    @Override // e00.e
    public double v() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) J).doubleValue();
    }

    @Override // e00.e
    public boolean w() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) J).booleanValue();
    }

    @Override // e00.e
    public char x() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) J).charValue();
    }

    @Override // e00.c
    public Object y(kotlinx.serialization.descriptors.f descriptor, int i11, kotlinx.serialization.a deserializer, Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(deserializer, "deserializer");
        return I(deserializer, obj);
    }

    @Override // e00.e
    public String z() {
        Object J = J();
        Intrinsics.f(J, "null cannot be cast to non-null type kotlin.String");
        return (String) J;
    }
}
