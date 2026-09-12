package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class b1 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b1 f68233a = new b1();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68234b = new s1("kotlin.Long", e.g.f68182a);

    private b1() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return Long.valueOf(decoder.l());
    }

    public void b(e00.f encoder, long j11) {
        Intrinsics.h(encoder, "encoder");
        encoder.m(j11);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68234b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((Number) obj).longValue());
    }
}
