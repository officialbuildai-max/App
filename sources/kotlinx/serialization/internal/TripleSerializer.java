package kotlinx.serialization.internal;

import e00.c;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

/* loaded from: classes7.dex */
public final class TripleSerializer implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.b f68223a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.b f68224b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.serialization.b f68225c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68226d;

    public TripleSerializer(kotlinx.serialization.b aSerializer, kotlinx.serialization.b bSerializer, kotlinx.serialization.b cSerializer) {
        Intrinsics.h(aSerializer, "aSerializer");
        Intrinsics.h(bSerializer, "bSerializer");
        Intrinsics.h(cSerializer, "cSerializer");
        this.f68223a = aSerializer;
        this.f68224b = bSerializer;
        this.f68225c = cSerializer;
        this.f68226d = SerialDescriptorsKt.b("kotlin.Triple", new kotlinx.serialization.descriptors.f[0], new Function1<kotlinx.serialization.descriptors.a, Unit>() { // from class: kotlinx.serialization.internal.TripleSerializer$descriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((kotlinx.serialization.descriptors.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(kotlinx.serialization.descriptors.a buildClassSerialDescriptor) {
                kotlinx.serialization.b bVar;
                kotlinx.serialization.b bVar2;
                kotlinx.serialization.b bVar3;
                Intrinsics.h(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                bVar = TripleSerializer.this.f68223a;
                kotlinx.serialization.descriptors.a.b(buildClassSerialDescriptor, "first", bVar.getDescriptor(), null, false, 12, null);
                bVar2 = TripleSerializer.this.f68224b;
                kotlinx.serialization.descriptors.a.b(buildClassSerialDescriptor, "second", bVar2.getDescriptor(), null, false, 12, null);
                bVar3 = TripleSerializer.this.f68225c;
                kotlinx.serialization.descriptors.a.b(buildClassSerialDescriptor, "third", bVar3.getDescriptor(), null, false, 12, null);
            }
        });
    }

    private final Triple d(e00.c cVar) {
        Object c11 = c.a.c(cVar, getDescriptor(), 0, this.f68223a, null, 8, null);
        Object c12 = c.a.c(cVar, getDescriptor(), 1, this.f68224b, null, 8, null);
        Object c13 = c.a.c(cVar, getDescriptor(), 2, this.f68225c, null, 8, null);
        cVar.c(getDescriptor());
        return new Triple(c11, c12, c13);
    }

    private final Triple e(e00.c cVar) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        obj = d2.f68248a;
        obj2 = d2.f68248a;
        obj3 = d2.f68248a;
        while (true) {
            int o11 = cVar.o(getDescriptor());
            if (o11 == -1) {
                cVar.c(getDescriptor());
                obj4 = d2.f68248a;
                if (obj == obj4) {
                    throw new SerializationException("Element 'first' is missing");
                }
                obj5 = d2.f68248a;
                if (obj2 == obj5) {
                    throw new SerializationException("Element 'second' is missing");
                }
                obj6 = d2.f68248a;
                if (obj3 != obj6) {
                    return new Triple(obj, obj2, obj3);
                }
                throw new SerializationException("Element 'third' is missing");
            }
            if (o11 == 0) {
                obj = c.a.c(cVar, getDescriptor(), 0, this.f68223a, null, 8, null);
            } else if (o11 == 1) {
                obj2 = c.a.c(cVar, getDescriptor(), 1, this.f68224b, null, 8, null);
            } else {
                if (o11 != 2) {
                    throw new SerializationException("Unexpected index " + o11);
                }
                obj3 = c.a.c(cVar, getDescriptor(), 2, this.f68225c, null, 8, null);
            }
        }
    }

    @Override // kotlinx.serialization.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Triple deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        e00.c b11 = decoder.b(getDescriptor());
        return b11.p() ? d(b11) : e(b11);
    }

    @Override // kotlinx.serialization.g
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void serialize(e00.f encoder, Triple value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        e00.d b11 = encoder.b(getDescriptor());
        b11.C(getDescriptor(), 0, this.f68223a, value.getFirst());
        b11.C(getDescriptor(), 1, this.f68224b, value.getSecond());
        b11.C(getDescriptor(), 2, this.f68225c, value.getThird());
        b11.c(getDescriptor());
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return this.f68226d;
    }
}
