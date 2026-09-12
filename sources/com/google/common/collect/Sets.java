package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.f2;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes4.dex */
public abstract class Sets {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class UnmodifiableNavigableSet<E> extends u2 implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private transient UnmodifiableNavigableSet f30709a;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) com.google.common.base.m.o(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e11) {
            return this.delegate.ceiling(e11);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.s2, com.google.common.collect.k2, com.google.common.collect.q2
        /* renamed from: delegate */
        public SortedSet<E> l() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.B(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet unmodifiableNavigableSet = this.f30709a;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet unmodifiableNavigableSet2 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.f30709a = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.f30709a = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e11) {
            return this.delegate.floor(e11);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e11, boolean z10) {
            return Sets.l(this.delegate.headSet(e11, z10));
        }

        @Override // java.util.NavigableSet
        public E higher(E e11) {
            return this.delegate.higher(e11);
        }

        @Override // java.util.NavigableSet
        public E lower(E e11) {
            return this.delegate.lower(e11);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e11, boolean z10, E e12, boolean z11) {
            return Sets.l(this.delegate.subSet(e11, z10, e12, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e11, boolean z10) {
            return Sets.l(this.delegate.tailSet(e11, z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f30710a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f30711b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.collect.Sets$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0409a extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            final Iterator f30712c;

            /* renamed from: d, reason: collision with root package name */
            final Iterator f30713d;

            C0409a() {
                this.f30712c = a.this.f30710a.iterator();
                this.f30713d = a.this.f30711b.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            protected Object a() {
                if (this.f30712c.hasNext()) {
                    return this.f30712c.next();
                }
                while (this.f30713d.hasNext()) {
                    Object next = this.f30713d.next();
                    if (!a.this.f30710a.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.f30710a = set;
            this.f30711b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r4 iterator() {
            return new C0409a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f30710a.contains(obj) || this.f30711b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f30710a.isEmpty() && this.f30711b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f30710a.size();
            Iterator it = this.f30711b.iterator();
            while (it.hasNext()) {
                if (!this.f30710a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    /* loaded from: classes4.dex */
    class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f30715a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f30716b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            final Iterator f30717c;

            a() {
                this.f30717c = b.this.f30715a.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            protected Object a() {
                while (this.f30717c.hasNext()) {
                    Object next = this.f30717c.next();
                    if (b.this.f30716b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Set set, Set set2) {
            super(null);
            this.f30715a = set;
            this.f30716b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public r4 iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f30715a.contains(obj) && this.f30716b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return this.f30715a.containsAll(collection) && this.f30716b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f30716b, this.f30715a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator it = this.f30715a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (this.f30716b.contains(it.next())) {
                    i11++;
                }
            }
            return i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends f2.a implements Set {
        c(Set set, com.google.common.base.n nVar) {
            super(set, nVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d extends c implements SortedSet {
        d(SortedSet sortedSet, com.google.common.base.n nVar) {
            super(sortedSet, nVar);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return ((SortedSet) this.f30839a).comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return Iterators.l(this.f30839a.iterator(), this.f30840b);
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return new d(((SortedSet) this.f30839a).headSet(obj), this.f30840b);
        }

        @Override // java.util.SortedSet
        public Object last() {
            SortedSet sortedSet = (SortedSet) this.f30839a;
            while (true) {
                Object last = sortedSet.last();
                if (this.f30840b.apply(last)) {
                    return last;
                }
                sortedSet = sortedSet.headSet(last);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return new d(((SortedSet) this.f30839a).subSet(obj, obj2), this.f30840b);
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return new d(((SortedSet) this.f30839a).tailSet(obj), this.f30840b);
        }
    }

    /* loaded from: classes4.dex */
    static abstract class e extends AbstractSet {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return Sets.i(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) com.google.common.base.m.o(collection));
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f extends AbstractSet {
        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        /* renamed from: a */
        public abstract r4 iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static Set b(Set set, com.google.common.base.n nVar) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, nVar);
        }
        if (!(set instanceof c)) {
            return new c((Set) com.google.common.base.m.o(set), (com.google.common.base.n) com.google.common.base.m.o(nVar));
        }
        c cVar = (c) set;
        return new c((Set) cVar.f30839a, Predicates.c(cVar.f30840b, nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SortedSet c(SortedSet sortedSet, com.google.common.base.n nVar) {
        if (!(sortedSet instanceof c)) {
            return new d((SortedSet) com.google.common.base.m.o(sortedSet), (com.google.common.base.n) com.google.common.base.m.o(nVar));
        }
        c cVar = (c) sortedSet;
        return new d((SortedSet) cVar.f30839a, Predicates.c(cVar.f30840b, nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(Set set) {
        Iterator it = set.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i11 = ~(~(i11 + (next != null ? next.hashCode() : 0)));
        }
        return i11;
    }

    public static f e(Set set, Set set2) {
        com.google.common.base.m.p(set, "set1");
        com.google.common.base.m.p(set2, "set2");
        return new b(set, set2);
    }

    public static HashSet f() {
        return new HashSet();
    }

    public static HashSet g(int i11) {
        return new HashSet(Maps.d(i11));
    }

    public static Set h() {
        return Collections.newSetFromMap(Maps.q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Set set, Collection collection) {
        com.google.common.base.m.o(collection);
        if (collection instanceof l3) {
            collection = ((l3) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? j(set, collection.iterator()) : Iterators.u(set.iterator(), collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(Set set, Iterator it) {
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= set.remove(it.next());
        }
        return z10;
    }

    public static f k(Set set, Set set2) {
        com.google.common.base.m.p(set, "set1");
        com.google.common.base.m.p(set2, "set2");
        return new a(set, set2);
    }

    public static NavigableSet l(NavigableSet navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }
}
