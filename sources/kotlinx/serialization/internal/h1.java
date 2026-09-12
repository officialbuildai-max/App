package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes7.dex */
public final class h1 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.b f68271a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68272b;

    public h1(kotlinx.serialization.b serializer) {
        Intrinsics.h(serializer, "serializer");
        this.f68271a = serializer;
        this.f68272b = new v1(serializer.getDescriptor());
    }

    @Override // kotlinx.serialization.a
    public Object deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return decoder.D() ? decoder.G(this.f68271a) : decoder.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Intrinsics.c(Reflection.b(h1.class), Reflection.b(obj.getClass())) && Intrinsics.c(this.f68271a, ((h1) obj).f68271a);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return this.f68272b;
    }

    public int hashCode() {
        return this.f68271a.hashCode();
    }

    @Override // kotlinx.serialization.g
    public void serialize(e00.f encoder, Object obj) {
        Intrinsics.h(encoder, "encoder");
        if (obj == null) {
            encoder.o();
        } else {
            encoder.v();
            encoder.e(this.f68271a, obj);
        }
    }
}
