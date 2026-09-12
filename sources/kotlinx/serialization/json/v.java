package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class v implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final v f68489a = new v();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68490b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonPrimitive", e.i.f68184a, new kotlinx.serialization.descriptors.f[0], null, 8, null);

    private v() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public u deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        h g11 = k.d(decoder).g();
        if (g11 instanceof u) {
            return (u) g11;
        }
        throw kotlinx.serialization.json.internal.w.f(-1, "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.b(g11.getClass()), g11.toString());
    }

    @Override // kotlinx.serialization.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(e00.f encoder, u value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        k.h(encoder);
        if (value instanceof JsonNull) {
            encoder.e(r.f68480a, JsonNull.f68349c);
        } else {
            encoder.e(p.f68478a, (o) value);
        }
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68490b;
    }
}
