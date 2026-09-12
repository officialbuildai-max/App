package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ReversedListReadOnly extends AbstractList {

    /* renamed from: a, reason: collision with root package name */
    private final List f67255a;

    public ReversedListReadOnly(List delegate) {
        Intrinsics.h(delegate, "delegate");
        this.f67255a = delegate;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i11) {
        int V;
        List list = this.f67255a;
        V = n.V(this, i11);
        return list.get(V);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f67255a.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i11) {
        return new ReversedListReadOnly$listIterator$1(this, i11);
    }
}
