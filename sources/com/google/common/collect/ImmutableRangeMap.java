package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collector;

/* loaded from: classes4.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements t3, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        Object createRangeMap() {
            a aVar = new a();
            r4 it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                aVar.c((Range) entry.getKey(), entry.getValue());
            }
            return aVar.a();
        }

        Object readResolve() {
            return this.mapOfRanges.isEmpty() ? ImmutableRangeMap.of() : createRangeMap();
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List f30504a = Lists.i();

        public ImmutableRangeMap a() {
            Collections.sort(this.f30504a, Range.rangeLexOrdering().onKeys());
            ImmutableList.a aVar = new ImmutableList.a(this.f30504a.size());
            ImmutableList.a aVar2 = new ImmutableList.a(this.f30504a.size());
            for (int i11 = 0; i11 < this.f30504a.size(); i11++) {
                Range range = (Range) ((Map.Entry) this.f30504a.get(i11)).getKey();
                if (i11 > 0) {
                    Range range2 = (Range) ((Map.Entry) this.f30504a.get(i11 - 1)).getKey();
                    if (range.isConnected(range2) && !range.intersection(range2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + range2 + " overlaps with entry " + range);
                    }
                }
                aVar.a(range);
                aVar2.a(((Map.Entry) this.f30504a.get(i11)).getValue());
            }
            return new ImmutableRangeMap(aVar.e(), aVar2.e());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(a aVar) {
            this.f30504a.addAll(aVar.f30504a);
            return this;
        }

        public a c(Range range, Object obj) {
            com.google.common.base.m.o(range);
            com.google.common.base.m.o(obj);
            com.google.common.base.m.j(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f30504a.add(Maps.i(range, obj));
            return this;
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> a builder() {
        return new a();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(t3 t3Var) {
        if (t3Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) t3Var;
        }
        Map asMapOfRanges = t3Var.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(asMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(asMapOfRanges.size());
        for (Map.Entry entry : asMapOfRanges.entrySet()) {
            aVar.a((Range) entry.getKey());
            aVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.e(), aVar2.e());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v11) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v11));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> function, Function<? super T, ? extends V> function2) {
        return d2.T(function, function2);
    }

    @Override // 
    /* renamed from: asDescendingMapOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<Range<K>, V> mo833asDescendingMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // com.google.common.collect.t3
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof t3) {
            return asMapOfRanges().equals(((t3) obj).asMapOfRanges());
        }
        return false;
    }

    public V get(K k11) {
        int a11 = SortedLists.a(this.ranges, new z2(), Cut.belowValue(k11), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a11 != -1 && this.ranges.get(a11).contains(k11)) {
            return this.values.get(a11);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k11) {
        int a11 = SortedLists.a(this.ranges, new z2(), Cut.belowValue(k11), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a11 == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(a11);
        if (range.contains(k11)) {
            return Maps.i(range, this.values.get(a11));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public final void put(Range<K> range, V v11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(t3 t3Var) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putCoalescing(Range<K> range, V v11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    @Override // 
    /* renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> mo834subRangeMap(final Range<K> range) {
        if (((Range) com.google.common.base.m.o(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        y2 y2Var = new y2();
        Cut<K> cut = range.lowerBound;
        SortedLists.KeyPresentBehavior keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior keyAbsentBehavior = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        final int a11 = SortedLists.a(immutableList, y2Var, cut, keyPresentBehavior, keyAbsentBehavior);
        int a12 = SortedLists.a(this.ranges, new z2(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        if (a11 >= a12) {
            return of();
        }
        final int i11 = a12 - a11;
        return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(this, new ImmutableList<Range<K>>(this) { // from class: com.google.common.collect.ImmutableRangeMap.1
            final /* synthetic */ ImmutableRangeMap this$0;

            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<K> get(int i12) {
                com.google.common.base.m.m(i12, i11);
                return (i12 == 0 || i12 == i11 + (-1)) ? ((Range) this.this$0.ranges.get(i12 + a11)).intersection(range) : (Range) this.this$0.ranges.get(i12 + a11);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return i11;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
            public Object writeReplace() {
                return super.writeReplace();
            }
        }, this.values.subList(a11, a12)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            final /* synthetic */ ImmutableRangeMap this$0;

            {
                this.this$0 = this;
            }

            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: asDescendingMapOfRanges */
            public /* bridge */ /* synthetic */ Map mo833asDescendingMapOfRanges() {
                return super.mo833asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.t3
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: subRangeMap, reason: merged with bridge method [inline-methods] */
            public ImmutableRangeMap<K, V> mo834subRangeMap(Range<K> range2) {
                return range.isConnected(range2) ? this.mo834subRangeMap((Range) range2.intersection(range)) : ImmutableRangeMap.of();
            }

            @Override // com.google.common.collect.ImmutableRangeMap
            Object writeReplace() {
                return super.writeReplace();
            }
        };
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }
}
