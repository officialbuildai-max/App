package u;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;

/* loaded from: classes2.dex */
public final class r extends AbstractCollection implements t.b {

    /* renamed from: a, reason: collision with root package name */
    private final d f76638a;

    public r(d dVar) {
        this.f76638a = dVar;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f76638a.containsValue(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f76638a.size();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new s(this.f76638a.u());
    }
}
