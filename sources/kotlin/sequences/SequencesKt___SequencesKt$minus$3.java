package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt___SequencesKt$minus$3;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$3", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class SequencesKt___SequencesKt$minus$3 implements Sequence<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterable f67561a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Sequence f67562b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Collection collection, Object obj) {
        return collection.contains(obj);
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getF67553a() {
        final Collection D = CollectionsKt.D(this.f67561a);
        return D.isEmpty() ? this.f67562b.getF67553a() : SequencesKt___SequencesKt.q(this.f67562b, new Function1() { // from class: xz.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean d11;
                d11 = SequencesKt___SequencesKt$minus$3.d(D, obj);
                return Boolean.valueOf(d11);
            }
        }).getF67553a();
    }
}
