package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* loaded from: classes7.dex */
public final class p2 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final p2 f68306a = new p2();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68307b = o0.a("kotlin.UShort", d00.a.F(ShortCompanionObject.f67411a));

    private p2() {
    }

    public short a(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return UShort.b(decoder.q(getDescriptor()).s());
    }

    public void b(e00.f encoder, short s11) {
        Intrinsics.h(encoder, "encoder");
        encoder.l(getDescriptor()).q(s11);
    }

    @Override // kotlinx.serialization.a
    public /* bridge */ /* synthetic */ Object deserialize(e00.e eVar) {
        return UShort.a(a(eVar));
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68307b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((UShort) obj).getData());
    }
}
