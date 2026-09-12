package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.EmptyIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class b implements Sequence, DropTakeSequence {

    /* renamed from: a, reason: collision with root package name */
    public static final b f67596a = new b();

    private b() {
    }

    @Override // kotlin.sequences.DropTakeSequence
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(int i11) {
        return f67596a;
    }

    @Override // kotlin.sequences.DropTakeSequence
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b b(int i11) {
        return f67596a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return EmptyIterator.f67243a;
    }
}
