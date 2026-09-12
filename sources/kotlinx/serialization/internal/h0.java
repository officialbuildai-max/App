package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class h0 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f68269a = new h0();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68270b = new s1("kotlin.Float", e.C0843e.f68180a);

    private h0() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return Float.valueOf(decoder.t());
    }

    public void b(e00.f encoder, float f11) {
        Intrinsics.h(encoder, "encoder");
        encoder.t(f11);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68270b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((Number) obj).floatValue());
    }
}
