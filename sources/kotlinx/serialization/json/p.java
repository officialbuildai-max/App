package kotlinx.serialization.json;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
final class p implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final p f68478a = new p();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68479b = SerialDescriptorsKt.a("kotlinx.serialization.json.JsonLiteral", e.i.f68184a);

    private p() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        h g11 = k.d(decoder).g();
        if (g11 instanceof o) {
            return (o) g11;
        }
        throw kotlinx.serialization.json.internal.w.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.b(g11.getClass()), g11.toString());
    }

    @Override // kotlinx.serialization.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(e00.f encoder, o value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        k.h(encoder);
        if (value.c()) {
            encoder.G(value.a());
            return;
        }
        Long n11 = j.n(value);
        if (n11 != null) {
            encoder.m(n11.longValue());
            return;
        }
        ULong h11 = UStringsKt.h(value.a());
        if (h11 != null) {
            encoder.l(d00.a.v(ULong.INSTANCE).getDescriptor()).m(h11.getData());
            return;
        }
        Double h12 = j.h(value);
        if (h12 != null) {
            encoder.g(h12.doubleValue());
            return;
        }
        Boolean e11 = j.e(value);
        if (e11 != null) {
            encoder.r(e11.booleanValue());
        } else {
            encoder.G(value.a());
        }
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68479b;
    }
}
