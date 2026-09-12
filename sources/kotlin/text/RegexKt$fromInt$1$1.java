package kotlin.text;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class RegexKt$fromInt$1$1 implements Function1<Enum<Object>, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f67676a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Enum r32) {
        d dVar = (d) r32;
        return Boolean.valueOf((this.f67676a & dVar.getMask()) == dVar.getValue());
    }
}
