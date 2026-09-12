package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class a2 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final a2 f68230a = new a2();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68231b = new s1("kotlin.Short", e.h.f68183a);

    private a2() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Short deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return Short.valueOf(decoder.s());
    }

    public void b(e00.f encoder, short s11) {
        Intrinsics.h(encoder, "encoder");
        encoder.q(s11);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68231b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((Number) obj).shortValue());
    }
}
