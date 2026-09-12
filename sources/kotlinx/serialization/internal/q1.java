package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class q1 extends y0 {

    /* renamed from: c, reason: collision with root package name */
    private final String f68310c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(kotlinx.serialization.descriptors.f primitive) {
        super(primitive, null);
        Intrinsics.h(primitive, "primitive");
        this.f68310c = primitive.i() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.f68310c;
    }
}
