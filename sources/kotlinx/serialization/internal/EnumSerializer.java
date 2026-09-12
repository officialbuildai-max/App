package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* loaded from: classes7.dex */
public final class EnumSerializer implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    private final Enum[] f68199a;

    /* renamed from: b, reason: collision with root package name */
    private kotlinx.serialization.descriptors.f f68200b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f68201c;

    public EnumSerializer(final String serialName, Enum[] values) {
        Intrinsics.h(serialName, "serialName");
        Intrinsics.h(values, "values");
        this.f68199a = values;
        this.f68201c = LazyKt.b(new Function0<kotlinx.serialization.descriptors.f>() { // from class: kotlinx.serialization.internal.EnumSerializer$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final kotlinx.serialization.descriptors.f invoke() {
                kotlinx.serialization.descriptors.f fVar;
                kotlinx.serialization.descriptors.f c11;
                fVar = EnumSerializer.this.f68200b;
                if (fVar != null) {
                    return fVar;
                }
                c11 = EnumSerializer.this.c(serialName);
                return c11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.serialization.descriptors.f c(String str) {
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, this.f68199a.length);
        for (Enum r02 : this.f68199a) {
            PluginGeneratedSerialDescriptor.m(enumDescriptor, r02.name(), false, 2, null);
        }
        return enumDescriptor;
    }

    @Override // kotlinx.serialization.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Enum deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        int e11 = decoder.e(getDescriptor());
        if (e11 >= 0) {
            Enum[] enumArr = this.f68199a;
            if (e11 < enumArr.length) {
                return enumArr[e11];
            }
        }
        throw new SerializationException(e11 + " is not among valid " + getDescriptor().i() + " enum values, values size is " + this.f68199a.length);
    }

    @Override // kotlinx.serialization.g
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void serialize(e00.f encoder, Enum value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        int h02 = ArraysKt.h0(this.f68199a, value);
        if (h02 != -1) {
            encoder.k(getDescriptor(), h02);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(value);
        sb2.append(" is not a valid enum ");
        sb2.append(getDescriptor().i());
        sb2.append(", must be one of ");
        String arrays = Arrays.toString(this.f68199a);
        Intrinsics.g(arrays, "toString(this)");
        sb2.append(arrays);
        throw new SerializationException(sb2.toString());
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return (kotlinx.serialization.descriptors.f) this.f68201c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().i() + '>';
    }
}
