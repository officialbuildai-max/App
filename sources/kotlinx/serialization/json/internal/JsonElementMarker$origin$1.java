package kotlinx.serialization.json.internal;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<kotlinx.serialization.descriptors.f, Integer, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(kotlinx.serialization.descriptors.f p02, int i11) {
        boolean e11;
        Intrinsics.h(p02, "p0");
        e11 = ((JsonElementMarker) this.receiver).e(p02, i11);
        return Boolean.valueOf(e11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((kotlinx.serialization.descriptors.f) obj, ((Number) obj2).intValue());
    }
}
