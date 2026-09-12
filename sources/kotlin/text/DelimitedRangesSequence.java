package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class DelimitedRangesSequence implements Sequence {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f67616a;

    /* renamed from: b, reason: collision with root package name */
    private final int f67617b;

    /* renamed from: c, reason: collision with root package name */
    private final int f67618c;

    /* renamed from: d, reason: collision with root package name */
    private final Function2 f67619d;

    public DelimitedRangesSequence(CharSequence input, int i11, int i12, Function2 getNextMatch) {
        Intrinsics.h(input, "input");
        Intrinsics.h(getNextMatch, "getNextMatch");
        this.f67616a = input;
        this.f67617b = i11;
        this.f67618c = i12;
        this.f67619d = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
