package com.google.common.collect;

import com.google.common.collect.b4;
import com.google.common.collect.l3;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* loaded from: classes4.dex */
abstract class h extends d implements a4 {
    final Comparator<Object> comparator;
    private transient a4 descendingMultiset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends i2 {
        a() {
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return h.this.descendingIterator();
        }

        @Override // com.google.common.collect.i2
        Iterator n() {
            return h.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.i2
        a4 o() {
            return h.this;
        }
    }

    h() {
        this(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Comparator comparator) {
        this.comparator = (Comparator) com.google.common.base.m.o(comparator);
    }

    public Comparator comparator() {
        return this.comparator;
    }

    a4 createDescendingMultiset() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public NavigableSet<Object> createElementSet() {
        return new b4.b(this);
    }

    abstract Iterator descendingEntryIterator();

    Iterator<Object> descendingIterator() {
        return Multisets.i(descendingMultiset());
    }

    public a4 descendingMultiset() {
        a4 a4Var = this.descendingMultiset;
        if (a4Var != null) {
            return a4Var;
        }
        a4 createDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = createDescendingMultiset;
        return createDescendingMultiset;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public NavigableSet elementSet() {
        return (NavigableSet) super.elementSet();
    }

    public l3.a firstEntry() {
        Iterator entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return (l3.a) entryIterator.next();
        }
        return null;
    }

    public l3.a lastEntry() {
        Iterator descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return (l3.a) descendingEntryIterator.next();
        }
        return null;
    }

    public l3.a pollFirstEntry() {
        Iterator entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        l3.a aVar = (l3.a) entryIterator.next();
        l3.a g11 = Multisets.g(aVar.getElement(), aVar.getCount());
        entryIterator.remove();
        return g11;
    }

    public l3.a pollLastEntry() {
        Iterator descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        l3.a aVar = (l3.a) descendingEntryIterator.next();
        l3.a g11 = Multisets.g(aVar.getElement(), aVar.getCount());
        descendingEntryIterator.remove();
        return g11;
    }

    public a4 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        com.google.common.base.m.o(boundType);
        com.google.common.base.m.o(boundType2);
        return tailMultiset(obj, boundType).headMultiset(obj2, boundType2);
    }
}
