package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public final class MapEntrySerializer extends t0 {

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68202c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class a implements Map.Entry, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private final Object f68203a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f68204b;

        public a(Object obj, Object obj2) {
            this.f68203a = obj;
            this.f68204b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(getKey(), aVar.getKey()) && Intrinsics.c(getValue(), aVar.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f68203a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f68204b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return ((getKey() == null ? 0 : getKey().hashCode()) * 31) + (getValue() != null ? getValue().hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + getKey() + ", value=" + getValue() + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapEntrySerializer(final kotlinx.serialization.b keySerializer, final kotlinx.serialization.b valueSerializer) {
        super(keySerializer, valueSerializer, null);
        Intrinsics.h(keySerializer, "keySerializer");
        Intrinsics.h(valueSerializer, "valueSerializer");
        this.f68202c = SerialDescriptorsKt.c("kotlin.collections.Map.Entry", i.c.f68195a, new kotlinx.serialization.descriptors.f[0], new Function1<kotlinx.serialization.descriptors.a, Unit>() { // from class: kotlinx.serialization.internal.MapEntrySerializer$descriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((kotlinx.serialization.descriptors.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(kotlinx.serialization.descriptors.a buildSerialDescriptor) {
                Intrinsics.h(buildSerialDescriptor, "$this$buildSerialDescriptor");
                kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, "key", kotlinx.serialization.b.this.getDescriptor(), null, false, 12, null);
                kotlinx.serialization.descriptors.a.b(buildSerialDescriptor, AppMeasurementSdk.ConditionalUserProperty.VALUE, valueSerializer.getDescriptor(), null, false, 12, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.t0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object a(Map.Entry entry) {
        Intrinsics.h(entry, "<this>");
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.t0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Object b(Map.Entry entry) {
        Intrinsics.h(entry, "<this>");
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.t0
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map.Entry c(Object obj, Object obj2) {
        return new a(obj, obj2);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return this.f68202c;
    }
}
