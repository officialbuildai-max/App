package androidx.collection;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
public final class MutableScatterSet$MutableSetWrapper$iterator$1 implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    private int f2316a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final Iterator f2317b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableScatterSet f2318c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet mutableScatterSet) {
        this.f2318c = mutableScatterSet;
        this.f2317b = SequencesKt.a(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(mutableScatterSet, this, null));
    }

    public final void a(int i11) {
        this.f2316a = i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2317b.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.f2317b.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i11 = this.f2316a;
        if (i11 != -1) {
            this.f2318c.y(i11);
            this.f2316a = -1;
        }
    }
}
