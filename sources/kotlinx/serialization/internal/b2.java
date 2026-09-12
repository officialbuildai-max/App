package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class b2 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b2 f68235a = new b2();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68236b = new s1("kotlin.String", e.i.f68184a);

    private b2() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return decoder.z();
    }

    @Override // kotlinx.serialization.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(e00.f encoder, String value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        encoder.G(value);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68236b;
    }
}
