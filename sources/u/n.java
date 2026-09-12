package u;

import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class n extends AbstractSet implements t.e {

    /* renamed from: b, reason: collision with root package name */
    private final d f76636b;

    public n(d dVar) {
        this.f76636b = dVar;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return e((Map.Entry) obj);
        }
        return false;
    }

    public boolean e(Map.Entry entry) {
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object obj = this.f76636b.get(entry.getKey());
        return obj != null ? Intrinsics.c(obj, entry.getValue()) : entry.getValue() == null && this.f76636b.containsKey(entry.getKey());
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f76636b.size();
    }

    @Override // kotlin.collections.AbstractSet, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new o(this.f76636b.u());
    }
}
