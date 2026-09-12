package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt___SequencesKt$minus$4;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$4", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class SequencesKt___SequencesKt$minus$4 implements Sequence<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sequence f67563a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Sequence f67564b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(List list, Object obj) {
        return list.contains(obj);
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getF67553a() {
        final List D = SequencesKt.D(this.f67563a);
        return D.isEmpty() ? this.f67564b.getF67553a() : SequencesKt___SequencesKt.q(this.f67564b, new Function1() { // from class: xz.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean d11;
                d11 = SequencesKt___SequencesKt$minus$4.d(D, obj);
                return Boolean.valueOf(d11);
            }
        }).getF67553a();
    }
}
