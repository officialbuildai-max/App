package kotlin.text;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "index", "get", "(I)Lkotlin/text/MatchGroup;", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f67674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f67674a = matcherMatchResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchGroup h(MatcherMatchResult$groups$1 matcherMatchResult$groups$1, int i11) {
        return matcherMatchResult$groups$1.get(i11);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return f((MatchGroup) obj);
        }
        return false;
    }

    public /* bridge */ boolean f(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    @Override // kotlin.text.MatchGroupCollection
    public MatchGroup get(int index) {
        java.util.regex.MatchResult e11;
        IntRange i11;
        java.util.regex.MatchResult e12;
        e11 = this.f67674a.e();
        i11 = RegexKt.i(e11, index);
        if (i11.q().intValue() < 0) {
            return null;
        }
        e12 = this.f67674a.e();
        String group = e12.group(index);
        Intrinsics.g(group, "group(...)");
        return new MatchGroup(group, i11);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        java.util.regex.MatchResult e11;
        e11 = this.f67674a.e();
        return e11.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return SequencesKt.y(CollectionsKt.Z(CollectionsKt.m(this)), new Function1() { // from class: kotlin.text.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MatchGroup h11;
                h11 = MatcherMatchResult$groups$1.h(MatcherMatchResult$groups$1.this, ((Integer) obj).intValue());
                return h11;
            }
        }).getF67553a();
    }
}
