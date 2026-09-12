package kotlinx.serialization;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.internal.l1;

/* loaded from: classes7.dex */
public final class ContextualSerializer implements b {

    /* renamed from: a, reason: collision with root package name */
    private final KClass f68141a;

    /* renamed from: b, reason: collision with root package name */
    private final b f68142b;

    /* renamed from: c, reason: collision with root package name */
    private final List f68143c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68144d;

    public ContextualSerializer(KClass serializableClass, b bVar, b[] typeArgumentsSerializers) {
        Intrinsics.h(serializableClass, "serializableClass");
        Intrinsics.h(typeArgumentsSerializers, "typeArgumentsSerializers");
        this.f68141a = serializableClass;
        this.f68142b = bVar;
        this.f68143c = ArraysKt.i(typeArgumentsSerializers);
        this.f68144d = kotlinx.serialization.descriptors.b.c(SerialDescriptorsKt.c("kotlinx.serialization.ContextualSerializer", h.a.f68191a, new kotlinx.serialization.descriptors.f[0], new Function1<kotlinx.serialization.descriptors.a, Unit>() { // from class: kotlinx.serialization.ContextualSerializer$descriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((kotlinx.serialization.descriptors.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(kotlinx.serialization.descriptors.a buildSerialDescriptor) {
                b bVar2;
                kotlinx.serialization.descriptors.f descriptor;
                Intrinsics.h(buildSerialDescriptor, "$this$buildSerialDescriptor");
                bVar2 = ContextualSerializer.this.f68142b;
                List annotations = (bVar2 == null || (descriptor = bVar2.getDescriptor()) == null) ? null : descriptor.getAnnotations();
                if (annotations == null) {
                    annotations = CollectionsKt.l();
                }
                buildSerialDescriptor.h(annotations);
            }
        }), serializableClass);
    }

    private final b b(f00.c cVar) {
        b b11 = cVar.b(this.f68141a, this.f68143c);
        if (b11 != null || (b11 = this.f68142b) != null) {
            return b11;
        }
        l1.d(this.f68141a);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.a
    public Object deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return decoder.G(b(decoder.a()));
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return this.f68144d;
    }

    @Override // kotlinx.serialization.g
    public void serialize(e00.f encoder, Object value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        encoder.e(b(encoder.a()), value);
    }
}
