package kotlinx.serialization.json.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public final class j0 implements f00.e {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f68438a;

    /* renamed from: b, reason: collision with root package name */
    private final String f68439b;

    public j0(boolean z10, String discriminator) {
        Intrinsics.h(discriminator, "discriminator");
        this.f68438a = z10;
        this.f68439b = discriminator;
    }

    private final void d(kotlinx.serialization.descriptors.f fVar, KClass kClass) {
        int e11 = fVar.e();
        for (int i11 = 0; i11 < e11; i11++) {
            String f11 = fVar.f(i11);
            if (Intrinsics.c(f11, this.f68439b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + kClass + " has property '" + f11 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    private final void e(kotlinx.serialization.descriptors.f fVar, KClass kClass) {
        kotlinx.serialization.descriptors.h d11 = fVar.d();
        if ((d11 instanceof kotlinx.serialization.descriptors.d) || Intrinsics.c(d11, h.a.f68191a)) {
            throw new IllegalArgumentException("Serializer for " + kClass.g() + " can't be registered as a subclass for polymorphic serialization because its kind " + d11 + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.f68438a) {
            return;
        }
        if (Intrinsics.c(d11, i.b.f68194a) || Intrinsics.c(d11, i.c.f68195a) || (d11 instanceof kotlinx.serialization.descriptors.e) || (d11 instanceof h.b)) {
            throw new IllegalArgumentException("Serializer for " + kClass.g() + " of kind " + d11 + " cannot be serialized polymorphically with class discriminator.");
        }
    }

    @Override // f00.e
    public void a(KClass baseClass, KClass actualClass, kotlinx.serialization.b actualSerializer) {
        Intrinsics.h(baseClass, "baseClass");
        Intrinsics.h(actualClass, "actualClass");
        Intrinsics.h(actualSerializer, "actualSerializer");
        kotlinx.serialization.descriptors.f descriptor = actualSerializer.getDescriptor();
        e(descriptor, actualClass);
        if (this.f68438a) {
            return;
        }
        d(descriptor, actualClass);
    }

    @Override // f00.e
    public void b(KClass baseClass, Function1 defaultDeserializerProvider) {
        Intrinsics.h(baseClass, "baseClass");
        Intrinsics.h(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // f00.e
    public void c(KClass baseClass, Function1 defaultSerializerProvider) {
        Intrinsics.h(baseClass, "baseClass");
        Intrinsics.h(defaultSerializerProvider, "defaultSerializerProvider");
    }
}
