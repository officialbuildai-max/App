package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.e;

/* loaded from: classes7.dex */
public final class i implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final i f68275a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68276b = new s1("kotlin.Boolean", e.a.f68176a);

    private i() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return Boolean.valueOf(decoder.w());
    }

    public void b(e00.f encoder, boolean z10) {
        Intrinsics.h(encoder, "encoder");
        encoder.r(z10);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68276b;
    }

    @Override // kotlinx.serialization.g
    public /* bridge */ /* synthetic */ void serialize(e00.f fVar, Object obj) {
        b(fVar, ((Boolean) obj).booleanValue());
    }
}
