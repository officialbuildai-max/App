package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.l3;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* loaded from: classes4.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements l3 {
    private static final long serialVersionUID = 912559;
    private transient ImmutableList<E> asList;
    private transient ImmutableSet<l3.a> entrySet;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class EntrySet extends IndexedImmutableSet<l3.a> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof l3.a)) {
                return false;
            }
            l3.a aVar = (l3.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.IndexedImmutableSet
        public l3.a get(int i11) {
            return ImmutableMultiset.this.getEntry(i11);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* loaded from: classes4.dex */
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends r4 {

        /* renamed from: a, reason: collision with root package name */
        int f30497a;

        /* renamed from: b, reason: collision with root package name */
        Object f30498b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f30499c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImmutableMultiset f30500d;

        a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.f30499c = it;
            this.f30500d = immutableMultiset;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30497a > 0 || this.f30499c.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f30497a <= 0) {
                l3.a aVar = (l3.a) this.f30499c.next();
                this.f30498b = aVar.getElement();
                this.f30497a = aVar.getCount();
            }
            this.f30497a--;
            Object obj = this.f30498b;
            Objects.requireNonNull(obj);
            return obj;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends ImmutableCollection.b {

        /* renamed from: a, reason: collision with root package name */
        o3 f30501a;

        /* renamed from: b, reason: collision with root package name */
        boolean f30502b;

        /* renamed from: c, reason: collision with root package name */
        boolean f30503c;

        public b() {
            this(4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i11) {
            this.f30502b = false;
            this.f30503c = false;
            this.f30501a = o3.c(i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(boolean z10) {
            this.f30502b = false;
            this.f30503c = false;
            this.f30501a = null;
        }

        static o3 m(Iterable iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public b a(Object obj) {
            return k(obj, 1);
        }

        public b h(Object... objArr) {
            super.b(objArr);
            return this;
        }

        public b i(Iterable iterable) {
            Objects.requireNonNull(this.f30501a);
            if (iterable instanceof l3) {
                l3 d11 = Multisets.d(iterable);
                o3 m11 = m(d11);
                if (m11 != null) {
                    o3 o3Var = this.f30501a;
                    o3Var.d(Math.max(o3Var.C(), m11.C()));
                    for (int e11 = m11.e(); e11 >= 0; e11 = m11.s(e11)) {
                        k(m11.i(e11), m11.k(e11));
                    }
                } else {
                    Set entrySet = d11.entrySet();
                    o3 o3Var2 = this.f30501a;
                    o3Var2.d(Math.max(o3Var2.C(), entrySet.size()));
                    for (l3.a aVar : d11.entrySet()) {
                        k(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public b j(Iterator it) {
            super.d(it);
            return this;
        }

        public b k(Object obj, int i11) {
            Objects.requireNonNull(this.f30501a);
            if (i11 == 0) {
                return this;
            }
            if (this.f30502b) {
                this.f30501a = new o3(this.f30501a);
                this.f30503c = false;
            }
            this.f30502b = false;
            com.google.common.base.m.o(obj);
            o3 o3Var = this.f30501a;
            o3Var.u(obj, i11 + o3Var.f(obj));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableMultiset e() {
            Objects.requireNonNull(this.f30501a);
            if (this.f30501a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.f30503c) {
                this.f30501a = new o3(this.f30501a);
                this.f30503c = false;
            }
            this.f30502b = true;
            return new RegularImmutableMultiset(this.f30501a);
        }
    }

    public static <E> b builder() {
        return new b();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new b().h(eArr).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends l3.a> collection) {
        b bVar = new b(collection.size());
        for (l3.a aVar : collection) {
            bVar.k(aVar.getElement(), aVar.getCount());
        }
        return bVar.e();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(Multisets.h(iterable));
        bVar.i(iterable);
        return bVar.e();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new b().j(it).e();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<l3.a> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$toImmutableMultiset$0(Object obj) {
        return 1;
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E e11) {
        return copyFromElements(e11);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12) {
        return copyFromElements(e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13) {
        return copyFromElements(e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14) {
        return copyFromElements(e11, e12, e13, e14);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15) {
        return copyFromElements(e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        return new b().a(e11).a(e12).a(e13).a(e14).a(e15).a(e16).h(eArr).e();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        Function identity;
        identity = Function.identity();
        return d2.S(identity, new ToIntFunction() { // from class: com.google.common.collect.x2
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                int lambda$toImmutableMultiset$0;
                lambda$toImmutableMultiset$0 = ImmutableMultiset.lambda$toImmutableMultiset$0(obj);
                return lambda$toImmutableMultiset$0;
            }
        });
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> function, ToIntFunction<? super T> toIntFunction) {
        return d2.S(function, toIntFunction);
    }

    @Override // com.google.common.collect.l3
    @Deprecated
    public final int add(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList = super.asList();
        this.asList = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        r4 it = entrySet().iterator();
        while (it.hasNext()) {
            l3.a aVar = (l3.a) it.next();
            Arrays.fill(objArr, i11, aVar.getCount() + i11, aVar.getElement());
            i11 += aVar.getCount();
        }
        return i11;
    }

    public abstract /* synthetic */ int count(Object obj);

    @Override // com.google.common.collect.l3
    public abstract ImmutableSet<E> elementSet();

    @Override // com.google.common.collect.l3
    public ImmutableSet<l3.a> entrySet() {
        ImmutableSet<l3.a> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<l3.a> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.l3
    public boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    abstract l3.a getEntry(int i11);

    @Override // java.util.Collection, com.google.common.collect.l3
    public int hashCode() {
        return Sets.d(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public r4 iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.l3
    @Deprecated
    public final int remove(Object obj, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l3
    @Deprecated
    public final int setCount(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l3
    @Deprecated
    public final boolean setCount(E e11, int i11, int i12) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public abstract Object writeReplace();
}
