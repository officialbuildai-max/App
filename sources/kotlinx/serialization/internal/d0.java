package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class d0 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f68244a = new d0();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68245b = new s1("kotlin.time.Duration", e.i.f68184a);

    private d0() {
    }

    public long a(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return Duration.INSTANCE.d(decoder.z());
    }

    public void b(e00.f encoder, long j11) {
        Intrinsics.h(encoder, "encoder");
        encoder.G(Duration.H(j11));
    }

    @Override // kotlinx.serialization.a
    public /* bridge */ /* synthetic */ Object deserialize(e00.e eVar) {
        return Duration.g(a(eVar));
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68245b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((Duration) obj).getRawValue());
    }
}
