package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class n0 extends PluginGeneratedSerialDescriptor {

    /* renamed from: m, reason: collision with root package name */
    private final boolean f68295m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(String name, i0 generatedSerializer) {
        super(name, generatedSerializer, 1);
        Intrinsics.h(name, "name");
        Intrinsics.h(generatedSerializer, "generatedSerializer");
        this.f68295m = true;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj instanceof n0) {
            kotlinx.serialization.descriptors.f fVar = (kotlinx.serialization.descriptors.f) obj;
            if (Intrinsics.c(i(), fVar.i())) {
                n0 n0Var = (n0) obj;
                if (n0Var.isInline() && Arrays.equals(p(), n0Var.p()) && e() == fVar.e()) {
                    int e11 = e();
                    for (0; i11 < e11; i11 + 1) {
                        i11 = (Intrinsics.c(h(i11).i(), fVar.h(i11).i()) && Intrinsics.c(h(i11).d(), fVar.h(i11).d())) ? i11 + 1 : 0;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return this.f68295m;
    }
}
