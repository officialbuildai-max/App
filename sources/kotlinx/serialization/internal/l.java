package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class l implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final l f68287a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68288b = new s1("kotlin.Byte", e.b.f68177a);

    private l() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Byte deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return Byte.valueOf(decoder.H());
    }

    public void b(e00.f encoder, byte b11) {
        Intrinsics.h(encoder, "encoder");
        encoder.h(b11);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68288b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((Number) obj).byteValue());
    }
}
