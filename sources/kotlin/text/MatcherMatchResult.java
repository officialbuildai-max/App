package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class MatcherMatchResult implements MatchResult {

    /* renamed from: a, reason: collision with root package name */
    private final Matcher f67669a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f67670b;

    /* renamed from: c, reason: collision with root package name */
    private final MatchGroupCollection f67671c;

    /* renamed from: d, reason: collision with root package name */
    private List f67672d;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.h(matcher, "matcher");
        Intrinsics.h(input, "input");
        this.f67669a = matcher;
        this.f67670b = input;
        this.f67671c = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult e() {
        return this.f67669a;
    }

    @Override // kotlin.text.MatchResult
    public List a() {
        if (this.f67672d == null) {
            this.f67672d = new AbstractList<String>() { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return e((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean e(String str) {
                    return super.contains(str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public String get(int index) {
                    java.util.regex.MatchResult e11;
                    e11 = MatcherMatchResult.this.e();
                    String group = e11.group(index);
                    return group == null ? "" : group;
                }

                @Override // kotlin.collections.AbstractCollection
                /* renamed from: getSize */
                public int get_size() {
                    java.util.regex.MatchResult e11;
                    e11 = MatcherMatchResult.this.e();
                    return e11.groupCount() + 1;
                }

                public /* bridge */ int h(String str) {
                    return super.indexOf(str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return h((String) obj);
                    }
                    return -1;
                }

                public /* bridge */ int j(String str) {
                    return super.lastIndexOf(str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return j((String) obj);
                    }
                    return -1;
                }
            };
        }
        List list = this.f67672d;
        Intrinsics.e(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public IntRange b() {
        IntRange h11;
        h11 = RegexKt.h(e());
        return h11;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection c() {
        return this.f67671c;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        MatchResult f11;
        int end = e().end() + (e().end() == e().start() ? 1 : 0);
        if (end > this.f67670b.length()) {
            return null;
        }
        Matcher matcher = this.f67669a.pattern().matcher(this.f67670b);
        Intrinsics.g(matcher, "matcher(...)");
        f11 = RegexKt.f(matcher, end, this.f67670b);
        return f11;
    }
}
