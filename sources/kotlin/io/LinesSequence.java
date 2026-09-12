package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes7.dex */
final class LinesSequence implements Sequence {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedReader f67356a;

    public LinesSequence(BufferedReader reader) {
        Intrinsics.h(reader, "reader");
        this.f67356a = reader;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
