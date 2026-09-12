package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class GeneratorSequence implements Sequence {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f67538a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f67539b;

    public GeneratorSequence(Function0 getInitialValue, Function1 getNextValue) {
        Intrinsics.h(getInitialValue, "getInitialValue");
        Intrinsics.h(getNextValue, "getNextValue");
        this.f67538a = getInitialValue;
        this.f67539b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}
