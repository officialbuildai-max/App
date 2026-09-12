package kotlinx.serialization.json;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.d;

/* loaded from: classes7.dex */
public final class JsonElementSerializer implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonElementSerializer f68347a = new JsonElementSerializer();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68348b = SerialDescriptorsKt.c("kotlinx.serialization.json.JsonElement", d.b.f68175a, new kotlinx.serialization.descriptors.f[0], new Function1<kotlinx.serialization.descriptors.a, Unit>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((kotlinx.serialization.descriptors.a) obj);
            return Unit.f67184a;
        }

        public final void invoke(kotlinx.serialization.descriptors.a buildSerialDescriptor) {
            kotlinx.serialization.descriptors.f f11;
            kotlinx.serialization.descriptors.f f12;
            kotlinx.serialization.descriptors.f f13;
            kotlinx.serialization.descriptors.f f14;
            kotlinx.serialization.descriptors.f f15;
            Intrinsics.h(buildSerialDescriptor, "$this$buildSerialDescriptor");
            f11 = k.f(new Function0<kotlinx.serialization.descriptors.f>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.1
                @Override // kotlin.jvm.functions.Function0
                public final kotlinx.serialization.descriptors.f invoke() {
                    return v.f68489a.getDescriptor();
                }
            });
            kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, "JsonPrimitive", f11, null, false, 12, null);
            f12 = k.f(new Function0<kotlinx.serialization.descriptors.f>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.2
                @Override // kotlin.jvm.functions.Function0
                public final kotlinx.serialization.descriptors.f invoke() {
                    return r.f68480a.getDescriptor();
                }
            });
            kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, "JsonNull", f12, null, false, 12, null);
            f13 = k.f(new Function0<kotlinx.serialization.descriptors.f>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.3
                @Override // kotlin.jvm.functions.Function0
                public final kotlinx.serialization.descriptors.f invoke() {
                    return p.f68478a.getDescriptor();
                }
            });
            kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, "JsonLiteral", f13, null, false, 12, null);
            f14 = k.f(new Function0<kotlinx.serialization.descriptors.f>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.4
                @Override // kotlin.jvm.functions.Function0
                public final kotlinx.serialization.descriptors.f invoke() {
                    return t.f68483a.getDescriptor();
                }
            });
            kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, "JsonObject", f14, null, false, 12, null);
            f15 = k.f(new Function0<kotlinx.serialization.descriptors.f>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.5
                @Override // kotlin.jvm.functions.Function0
                public final kotlinx.serialization.descriptors.f invoke() {
                    return c.f68360a.getDescriptor();
                }
            });
            kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, "JsonArray", f15, null, false, 12, null);
        }
    });

    private JsonElementSerializer() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return k.d(decoder).g();
    }

    @Override // kotlinx.serialization.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(e00.f encoder, h value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        k.c(encoder);
        if (value instanceof u) {
            encoder.e(v.f68489a, value);
        } else if (value instanceof JsonObject) {
            encoder.e(t.f68483a, value);
        } else if (value instanceof b) {
            encoder.e(c.f68360a, value);
        }
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68348b;
    }
}
