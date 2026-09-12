package com.google.common.collect;

import com.google.common.collect.Sets;
import com.google.common.collect.l3;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
public abstract class Multisets {

    /* loaded from: classes4.dex */
    private static final class DecreasingCount implements Comparator<l3.a> {
        static final Comparator<l3.a> INSTANCE = new DecreasingCount();

        private DecreasingCount() {
        }

        @Override // java.util.Comparator
        public int compare(l3.a aVar, l3.a aVar2) {
            return aVar2.getCount() - aVar.getCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class ImmutableEntry<E> extends b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        ImmutableEntry(E e11, int i11) {
            this.element = e11;
            this.count = i11;
            e2.b(i11, "count");
        }

        @Override // com.google.common.collect.l3.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.l3.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class a extends o4 {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.o4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(l3.a aVar) {
            return aVar.getElement();
        }
    }

    /* loaded from: classes4.dex */
    static abstract class b implements l3.a {
        public boolean equals(Object obj) {
            if (!(obj instanceof l3.a)) {
                return false;
            }
            l3.a aVar = (l3.a) obj;
            return getCount() == aVar.getCount() && com.google.common.base.j.a(getElement(), aVar.getElement());
        }

        public int hashCode() {
            Object element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.l3.a
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    /* loaded from: classes4.dex */
    static abstract class c extends Sets.e {
        abstract l3 a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    /* loaded from: classes4.dex */
    static abstract class d extends Sets.e {
        abstract l3 a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof l3.a)) {
                return false;
            }
            l3.a aVar = (l3.a) obj;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof l3.a) {
                l3.a aVar = (l3.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    static final class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private final l3 f30668a;

        /* renamed from: b, reason: collision with root package name */
        private final Iterator f30669b;

        /* renamed from: c, reason: collision with root package name */
        private l3.a f30670c;

        /* renamed from: d, reason: collision with root package name */
        private int f30671d;

        /* renamed from: e, reason: collision with root package name */
        private int f30672e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f30673f;

        e(l3 l3Var, Iterator it) {
            this.f30668a = l3Var;
            this.f30669b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30671d > 0 || this.f30669b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f30671d == 0) {
                l3.a aVar = (l3.a) this.f30669b.next();
                this.f30670c = aVar;
                int count = aVar.getCount();
                this.f30671d = count;
                this.f30672e = count;
            }
            this.f30671d--;
            this.f30673f = true;
            l3.a aVar2 = this.f30670c;
            Objects.requireNonNull(aVar2);
            return aVar2.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            e2.e(this.f30673f);
            if (this.f30672e == 1) {
                this.f30669b.remove();
            } else {
                l3 l3Var = this.f30668a;
                l3.a aVar = this.f30670c;
                Objects.requireNonNull(aVar);
                l3Var.remove(aVar.getElement());
            }
            this.f30672e--;
            this.f30673f = false;
        }
    }

    private static boolean a(l3 l3Var, AbstractMapBasedMultiset abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(l3Var);
        return true;
    }

    private static boolean b(l3 l3Var, l3 l3Var2) {
        if (l3Var2 instanceof AbstractMapBasedMultiset) {
            return a(l3Var, (AbstractMapBasedMultiset) l3Var2);
        }
        if (l3Var2.isEmpty()) {
            return false;
        }
        for (l3.a aVar : l3Var2.entrySet()) {
            l3Var.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(l3 l3Var, Collection collection) {
        com.google.common.base.m.o(l3Var);
        com.google.common.base.m.o(collection);
        if (collection instanceof l3) {
            return b(l3Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(l3Var, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l3 d(Iterable iterable) {
        return (l3) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator e(Iterator it) {
        return new a(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(l3 l3Var, Object obj) {
        if (obj == l3Var) {
            return true;
        }
        if (obj instanceof l3) {
            l3 l3Var2 = (l3) obj;
            if (l3Var.size() == l3Var2.size() && l3Var.entrySet().size() == l3Var2.entrySet().size()) {
                for (l3.a aVar : l3Var2.entrySet()) {
                    if (l3Var.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static l3.a g(Object obj, int i11) {
        return new ImmutableEntry(obj, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(Iterable iterable) {
        if (iterable instanceof l3) {
            return ((l3) iterable).elementSet().size();
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator i(l3 l3Var) {
        return new e(l3Var, l3Var.entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean j(l3 l3Var, Collection collection) {
        if (collection instanceof l3) {
            collection = ((l3) collection).elementSet();
        }
        return l3Var.elementSet().removeAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean k(l3 l3Var, Collection collection) {
        com.google.common.base.m.o(collection);
        if (collection instanceof l3) {
            collection = ((l3) collection).elementSet();
        }
        return l3Var.elementSet().retainAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(l3 l3Var, Object obj, int i11) {
        e2.b(i11, "count");
        int count = l3Var.count(obj);
        int i12 = i11 - count;
        if (i12 > 0) {
            l3Var.add(obj, i12);
        } else if (i12 < 0) {
            l3Var.remove(obj, -i12);
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(l3 l3Var, Object obj, int i11, int i12) {
        e2.b(i11, "oldCount");
        e2.b(i12, "newCount");
        if (l3Var.count(obj) != i11) {
            return false;
        }
        l3Var.setCount(obj, i12);
        return true;
    }
}
