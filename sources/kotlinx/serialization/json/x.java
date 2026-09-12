package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;

/* loaded from: classes7.dex */
public abstract class x implements kotlinx.serialization.b {
    private final kotlinx.serialization.b tSerializer;

    public x(kotlinx.serialization.b tSerializer) {
        Intrinsics.h(tSerializer, "tSerializer");
        this.tSerializer = tSerializer;
    }

    @Override // kotlinx.serialization.a
    public final Object deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        g d11 = k.d(decoder);
        return d11.d().d(this.tSerializer, transformDeserialize(d11.g()));
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return this.tSerializer.getDescriptor();
    }

    @Override // kotlinx.serialization.g
    public final void serialize(e00.f encoder, Object value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        l e11 = k.e(encoder);
        e11.A(transformSerialize(TreeJsonEncoderKt.c(e11.d(), value, this.tSerializer)));
    }

    protected abstract h transformDeserialize(h hVar);

    protected h transformSerialize(h element) {
        Intrinsics.h(element, "element");
        return element;
    }
}
