package kotlinx.serialization.internal;

import e00.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* loaded from: classes7.dex */
public abstract class b implements kotlinx.serialization.b {
    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(e00.c cVar) {
        return c.a.c(cVar, getDescriptor(), 1, kotlinx.serialization.d.a(this, cVar, cVar.m(getDescriptor(), 0)), null, 8, null);
    }

    public kotlinx.serialization.a c(e00.c decoder, String str) {
        Intrinsics.h(decoder, "decoder");
        return decoder.a().d(e(), str);
    }

    public kotlinx.serialization.g d(e00.f encoder, Object value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        return encoder.a().e(e(), value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.String] */
    @Override // kotlinx.serialization.a
    public final Object deserialize(e00.e decoder) {
        Object obj;
        Intrinsics.h(decoder, "decoder");
        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
        e00.c b11 = decoder.b(descriptor);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (b11.p()) {
            obj = b(b11);
        } else {
            obj = null;
            while (true) {
                int o11 = b11.o(getDescriptor());
                if (o11 != -1) {
                    if (o11 == 0) {
                        objectRef.element = b11.m(getDescriptor(), o11);
                    } else {
                        if (o11 != 1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) objectRef.element;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb2.append(str);
                            sb2.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb2.append(o11);
                            throw new SerializationException(sb2.toString());
                        }
                        T t11 = objectRef.element;
                        if (t11 == 0) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        objectRef.element = t11;
                        obj = c.a.c(b11, getDescriptor(), o11, kotlinx.serialization.d.a(this, b11, (String) t11), null, 8, null);
                    }
                } else {
                    if (obj == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) objectRef.element)).toString());
                    }
                    Intrinsics.f(obj, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                }
            }
        }
        b11.c(descriptor);
        return obj;
    }

    public abstract KClass e();

    @Override // kotlinx.serialization.g
    public final void serialize(e00.f encoder, Object value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        kotlinx.serialization.g b11 = kotlinx.serialization.d.b(this, encoder, value);
        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
        e00.d b12 = encoder.b(descriptor);
        b12.y(getDescriptor(), 0, b11.getDescriptor().i());
        kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
        Intrinsics.f(b11, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        b12.C(descriptor2, 1, b11, value);
        b12.c(descriptor);
    }
}
