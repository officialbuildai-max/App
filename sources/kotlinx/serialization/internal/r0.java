package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class r0 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final r0 f68315a = new r0();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68316b = new s1("kotlin.Int", e.f.f68181a);

    private r0() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return Integer.valueOf(decoder.h());
    }

    public void b(e00.f encoder, int i11) {
        Intrinsics.h(encoder, "encoder");
        encoder.B(i11);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68316b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((Number) obj).intValue());
    }
}
