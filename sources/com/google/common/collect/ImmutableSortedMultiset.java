package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.l3;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* loaded from: classes4.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableMultiset<E> implements a4 {
    private static final long serialVersionUID = 912559;
    transient ImmutableSortedMultiset<E> descendingMultiset;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        SerializedForm(a4 a4Var) {
            this.comparator = a4Var.comparator();
            int size = a4Var.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i11 = 0;
            for (l3.a aVar : a4Var.entrySet()) {
                ((E[]) this.elements)[i11] = aVar.getElement();
                this.counts[i11] = aVar.getCount();
                i11++;
            }
        }

        Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i11 = 0; i11 < length; i11++) {
                aVar.k(this.elements[i11], this.counts[i11]);
            }
            return aVar.e();
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ImmutableMultiset.b {

        /* renamed from: d, reason: collision with root package name */
        private final Comparator f30520d;

        /* renamed from: e, reason: collision with root package name */
        Object[] f30521e;

        /* renamed from: f, reason: collision with root package name */
        private int[] f30522f;

        /* renamed from: g, reason: collision with root package name */
        private int f30523g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f30524h;

        public a(Comparator comparator) {
            super(true);
            this.f30520d = (Comparator) com.google.common.base.m.o(comparator);
            this.f30521e = new Object[4];
            this.f30522f = new int[4];
        }

        private void t(boolean z10) {
            int i11 = this.f30523g;
            if (i11 == 0) {
                return;
            }
            Object[] copyOf = Arrays.copyOf(this.f30521e, i11);
            Arrays.sort(copyOf, this.f30520d);
            int i12 = 1;
            for (int i13 = 1; i13 < copyOf.length; i13++) {
                if (this.f30520d.compare(copyOf[i12 - 1], copyOf[i13]) < 0) {
                    copyOf[i12] = copyOf[i13];
                    i12++;
                }
            }
            Arrays.fill(copyOf, i12, this.f30523g, (Object) null);
            if (z10) {
                int i14 = i12 * 4;
                int i15 = this.f30523g;
                if (i14 > i15 * 3) {
                    copyOf = Arrays.copyOf(copyOf, com.google.common.math.d.h(i15, (i15 / 2) + 1));
                }
            }
            int[] iArr = new int[copyOf.length];
            for (int i16 = 0; i16 < this.f30523g; i16++) {
                int binarySearch = Arrays.binarySearch(copyOf, 0, i12, this.f30521e[i16], this.f30520d);
                int i17 = this.f30522f[i16];
                if (i17 >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + i17;
                } else {
                    iArr[binarySearch] = ~i17;
                }
            }
            this.f30521e = copyOf;
            this.f30522f = iArr;
            this.f30523g = i12;
        }

        private void u() {
            t(false);
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.f30523g;
                if (i11 >= i13) {
                    Arrays.fill(this.f30521e, i12, i13, (Object) null);
                    Arrays.fill(this.f30522f, i12, this.f30523g, 0);
                    this.f30523g = i12;
                    return;
                }
                int[] iArr = this.f30522f;
                int i14 = iArr[i11];
                if (i14 > 0) {
                    Object[] objArr = this.f30521e;
                    objArr[i12] = objArr[i11];
                    iArr[i12] = i14;
                    i12++;
                }
                i11++;
            }
        }

        private void v() {
            int i11 = this.f30523g;
            Object[] objArr = this.f30521e;
            if (i11 == objArr.length) {
                t(true);
            } else if (this.f30524h) {
                this.f30521e = Arrays.copyOf(objArr, objArr.length);
            }
            this.f30524h = false;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            return k(obj, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a h(Object... objArr) {
            for (Object obj : objArr) {
                a(obj);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public a i(Iterable iterable) {
            if (iterable instanceof l3) {
                for (l3.a aVar : ((l3) iterable).entrySet()) {
                    k(aVar.getElement(), aVar.getCount());
                }
            } else {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public a j(Iterator it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public a k(Object obj, int i11) {
            com.google.common.base.m.o(obj);
            e2.b(i11, "occurrences");
            if (i11 == 0) {
                return this;
            }
            v();
            Object[] objArr = this.f30521e;
            int i12 = this.f30523g;
            objArr[i12] = obj;
            this.f30522f[i12] = i11;
            this.f30523g = i12 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMultiset e() {
            u();
            int i11 = this.f30523g;
            if (i11 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.f30520d);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f30520d, i11, this.f30521e);
            long[] jArr = new long[this.f30523g + 1];
            int i12 = 0;
            while (i12 < this.f30523g) {
                int i13 = i12 + 1;
                jArr[i13] = jArr[i12] + this.f30522f[i12];
                i12 = i13;
            }
            this.f30524h = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f30523g);
        }
    }

    @Deprecated
    public static <E> a builder() {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new a(comparator).i(iterable).e();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        com.google.common.base.m.o(comparator);
        return new a(comparator).j(it).e();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    @Deprecated
    public static <Z> ImmutableSortedMultiset<Z> copyOf(Z[] zArr) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(a4 a4Var) {
        return copyOfSortedEntries(a4Var.comparator(), Lists.j(a4Var.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<l3.a> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.a aVar = new ImmutableList.a(collection.size());
        long[] jArr = new long[collection.size() + 1];
        Iterator<l3.a> it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            aVar.a(it.next().getElement());
            int i12 = i11 + 1;
            jArr[i12] = jArr[i11] + r5.getCount();
            i11 = i12;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.e(), comparator), jArr, 0, collection.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$toImmutableSortedMultiset$0(Object obj) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l3 lambda$toImmutableSortedMultiset$3(l3 l3Var, l3 l3Var2) {
        l3Var.addAll(l3Var2);
        return l3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedMultiset lambda$toImmutableSortedMultiset$4(Comparator comparator, l3 l3Var) {
        return copyOfSortedEntries(comparator, l3Var.entrySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T, E> void mapAndAdd(T t11, l3 l3Var, Function<? super T, ? extends E> function, ToIntFunction<? super T> toIntFunction) {
        Object apply;
        int applyAsInt;
        apply = function.apply(t11);
        Object o11 = com.google.common.base.m.o(apply);
        applyAsInt = toIntFunction.applyAsInt(t11);
        l3Var.add(o11, applyAsInt);
    }

    public static <E extends Comparable<?>> a naturalOrder() {
        return new a(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList m11 = Lists.m(comparableArr.length + 6);
        Collections.addAll(m11, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(m11, comparableArr);
        return copyOf(Ordering.natural(), m11);
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e11, E e12) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e11, E e12, E e13) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e11, E e12, E e13, E e14) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e11, E e12, E e13, E e14, E e15) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        throw new UnsupportedOperationException();
    }

    public static <E> a orderedBy(Comparator<E> comparator) {
        return new a(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a reverseOrder() {
        return new a(Ordering.natural().reverse());
    }

    @Deprecated
    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> function, ToIntFunction<? super T> toIntFunction) {
        throw new UnsupportedOperationException();
    }

    public static <E> Collector<E, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> comparator) {
        Function identity;
        identity = Function.identity();
        return toImmutableSortedMultiset(comparator, identity, new ToIntFunction() { // from class: com.google.common.collect.f3
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                int lambda$toImmutableSortedMultiset$0;
                lambda$toImmutableSortedMultiset$0 = ImmutableSortedMultiset.lambda$toImmutableSortedMultiset$0(obj);
                return lambda$toImmutableSortedMultiset$0;
            }
        });
    }

    public static <T, E> Collector<T, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(final Comparator<? super E> comparator, final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        Collector<T, ?, ImmutableSortedMultiset<E>> of2;
        com.google.common.base.m.o(comparator);
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(toIntFunction);
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.b3
            @Override // java.util.function.Supplier
            public final Object get() {
                l3 create;
                create = TreeMultiset.create(comparator);
                return create;
            }
        }, new BiConsumer() { // from class: com.google.common.collect.c3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableSortedMultiset.mapAndAdd(obj2, (l3) obj, function, toIntFunction);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.d3
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                l3 lambda$toImmutableSortedMultiset$3;
                lambda$toImmutableSortedMultiset$3 = ImmutableSortedMultiset.lambda$toImmutableSortedMultiset$3((l3) obj, (l3) obj2);
                return lambda$toImmutableSortedMultiset$3;
            }
        }, new Function() { // from class: com.google.common.collect.e3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ImmutableSortedMultiset lambda$toImmutableSortedMultiset$4;
                lambda$toImmutableSortedMultiset$4 = ImmutableSortedMultiset.lambda$toImmutableSortedMultiset$4(comparator, (l3) obj);
                return lambda$toImmutableSortedMultiset$4;
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    @Override // com.google.common.collect.a4, com.google.common.collect.y3
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.l3
    public abstract /* synthetic */ int count(Object obj);

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.l3
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract /* synthetic */ l3.a firstEntry();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ a4 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    public abstract /* synthetic */ l3.a lastEntry();

    @Override // com.google.common.collect.a4
    @Deprecated
    public final l3.a pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a4
    @Deprecated
    public final l3.a pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a4
    public ImmutableSortedMultiset<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        com.google.common.base.m.k(comparator().compare(e11, e12) <= 0, "Expected lowerBound <= upperBound but %s > %s", e11, e12);
        return tailMultiset((ImmutableSortedMultiset<E>) e11, boundType).headMultiset((ImmutableSortedMultiset<E>) e12, boundType2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a4
    public /* bridge */ /* synthetic */ a4 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ a4 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
