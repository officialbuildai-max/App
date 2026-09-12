package kotlinx.serialization.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: m, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.h f68197m;

    /* renamed from: n, reason: collision with root package name */
    private final Lazy f68198n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(final String name, final int i11) {
        super(name, null, i11, 2, null);
        Intrinsics.h(name, "name");
        this.f68197m = h.b.f68192a;
        this.f68198n = LazyKt.b(new Function0<kotlinx.serialization.descriptors.f[]>() { // from class: kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final kotlinx.serialization.descriptors.f[] invoke() {
                int i12 = i11;
                kotlinx.serialization.descriptors.f[] fVarArr = new kotlinx.serialization.descriptors.f[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    fVarArr[i13] = SerialDescriptorsKt.d(name + '.' + this.f(i13), i.d.f68196a, new kotlinx.serialization.descriptors.f[0], null, 8, null);
                }
                return fVarArr;
            }
        });
    }

    private final kotlinx.serialization.descriptors.f[] r() {
        return (kotlinx.serialization.descriptors.f[]) this.f68198n.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.h d() {
        return this.f68197m;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof kotlinx.serialization.descriptors.f)) {
            return false;
        }
        kotlinx.serialization.descriptors.f fVar = (kotlinx.serialization.descriptors.f) obj;
        return fVar.d() == h.b.f68192a && Intrinsics.c(i(), fVar.i()) && Intrinsics.c(l1.a(this), l1.a(fVar));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f h(int i11) {
        return r()[i11];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int hashCode = i().hashCode();
        int i11 = 1;
        for (String str : kotlinx.serialization.descriptors.g.b(this)) {
            int i12 = i11 * 31;
            i11 = i12 + (str != null ? str.hashCode() : 0);
        }
        return (hashCode * 31) + i11;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public String toString() {
        return CollectionsKt.s0(kotlinx.serialization.descriptors.g.b(this), ", ", i() + '(', ")", 0, null, null, 56, null);
    }
}
