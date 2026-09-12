package kotlinx.serialization;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.descriptors.h;

/* loaded from: classes7.dex */
public final class PolymorphicSerializer extends kotlinx.serialization.internal.b {

    /* renamed from: a, reason: collision with root package name */
    private final KClass f68145a;

    /* renamed from: b, reason: collision with root package name */
    private List f68146b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f68147c;

    public PolymorphicSerializer(KClass baseClass) {
        Intrinsics.h(baseClass, "baseClass");
        this.f68145a = baseClass;
        this.f68146b = CollectionsKt.l();
        this.f68147c = LazyKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<kotlinx.serialization.descriptors.f>() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final kotlinx.serialization.descriptors.f invoke() {
                final PolymorphicSerializer polymorphicSerializer = PolymorphicSerializer.this;
                return kotlinx.serialization.descriptors.b.c(SerialDescriptorsKt.c("kotlinx.serialization.Polymorphic", d.a.f68174a, new kotlinx.serialization.descriptors.f[0], new Function1<kotlinx.serialization.descriptors.a, Unit>() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((kotlinx.serialization.descriptors.a) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(kotlinx.serialization.descriptors.a buildSerialDescriptor) {
                        List list;
                        Intrinsics.h(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, NativeComponentConstants.KEY_COMPONENT_TYPE, d00.a.G(StringCompanionObject.f67412a).getDescriptor(), null, false, 12, null);
                        kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, AppMeasurementSdk.ConditionalUserProperty.VALUE, SerialDescriptorsKt.d("kotlinx.serialization.Polymorphic<" + PolymorphicSerializer.this.e().g() + '>', h.a.f68191a, new kotlinx.serialization.descriptors.f[0], null, 8, null), null, false, 12, null);
                        list = PolymorphicSerializer.this.f68146b;
                        buildSerialDescriptor.h(list);
                    }
                }), PolymorphicSerializer.this.e());
            }
        });
    }

    @Override // kotlinx.serialization.internal.b
    public KClass e() {
        return this.f68145a;
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return (kotlinx.serialization.descriptors.f) this.f68147c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + e() + ')';
    }
}
