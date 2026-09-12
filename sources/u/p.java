package u;

import java.util.Iterator;
import kotlin.collections.AbstractSet;

/* loaded from: classes2.dex */
public final class p extends AbstractSet implements t.e {

    /* renamed from: b, reason: collision with root package name */
    private final d f76637b;

    public p(d dVar) {
        this.f76637b = dVar;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f76637b.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f76637b.size();
    }

    @Override // kotlin.collections.AbstractSet, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new q(this.f76637b.u());
    }
}
