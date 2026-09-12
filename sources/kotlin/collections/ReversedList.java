package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ReversedList extends AbstractMutableList {

    /* renamed from: a, reason: collision with root package name */
    private final List f67252a;

    public ReversedList(List delegate) {
        Intrinsics.h(delegate, "delegate");
        this.f67252a = delegate;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i11, Object obj) {
        int X;
        List list = this.f67252a;
        X = n.X(this, i11);
        list.add(X, obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f67252a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i11) {
        int V;
        List list = this.f67252a;
        V = n.V(this, i11);
        return list.get(V);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f67252a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i11) {
        return new ReversedList$listIterator$1(this, i11);
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object removeAt(int i11) {
        int V;
        List list = this.f67252a;
        V = n.V(this, i11);
        return list.remove(V);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i11, Object obj) {
        int V;
        List list = this.f67252a;
        V = n.V(this, i11);
        return list.set(V, obj);
    }
}
