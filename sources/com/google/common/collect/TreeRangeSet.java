package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient u3 complement;
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes4.dex */
    private final class Complement extends TreeRangeSet<C> {
        Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.u3
        public u3 complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c11) {
            return !TreeRangeSet.this.contains(c11);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* loaded from: classes4.dex */
    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        SubRangeSet(com.google.common.collect.Range<C> r5) {
            /*
                r3 = this;
                com.google.common.collect.TreeRangeSet.this = r4
                com.google.common.collect.TreeRangeSet$e r0 = new com.google.common.collect.TreeRangeSet$e
                com.google.common.collect.Range r1 = com.google.common.collect.Range.all()
                java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> r4 = r4.rangesByLowerBound
                r2 = 0
                r0.<init>(r1, r5, r4)
                r3.<init>(r0)
                r3.restriction = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeRangeSet.SubRangeSet.<init>(com.google.common.collect.TreeRangeSet, com.google.common.collect.Range):void");
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            com.google.common.base.m.k(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c11) {
            return this.restriction.contains(c11) && TreeRangeSet.this.contains(c11);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.u3
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public Range<C> rangeContaining(C c11) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c11) && (rangeContaining = TreeRangeSet.this.rangeContaining(c11)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet
        public u3 subRangeSet(Range<C> range) {
            return range.encloses(this.restriction) ? this : range.isConnected(this.restriction) ? new SubRangeSet(this, this.restriction.intersection(range)) : ImmutableRangeSet.of();
        }
    }

    /* loaded from: classes4.dex */
    final class b extends k2 implements Set {

        /* renamed from: a, reason: collision with root package name */
        final Collection f30781a;

        b(Collection collection) {
            this.f30781a = collection;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.q2
        /* renamed from: delegate */
        public Collection l() {
            return this.f30781a;
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
    public static final class c extends com.google.common.collect.e {

        /* renamed from: a, reason: collision with root package name */
        private final NavigableMap f30783a;

        /* renamed from: b, reason: collision with root package name */
        private final NavigableMap f30784b;

        /* renamed from: c, reason: collision with root package name */
        private final Range f30785c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            Cut f30786c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Cut f30787d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ q3 f30788e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f30789f;

            a(c cVar, Cut cut, q3 q3Var) {
                this.f30787d = cut;
                this.f30788e = q3Var;
                this.f30789f = cVar;
                this.f30786c = cut;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry a() {
                Range create;
                if (this.f30789f.f30785c.upperBound.isLessThan(this.f30786c) || this.f30786c == Cut.aboveAll()) {
                    return (Map.Entry) b();
                }
                if (this.f30788e.hasNext()) {
                    Range range = (Range) this.f30788e.next();
                    create = Range.create(this.f30786c, range.lowerBound);
                    this.f30786c = range.upperBound;
                } else {
                    create = Range.create(this.f30786c, Cut.aboveAll());
                    this.f30786c = Cut.aboveAll();
                }
                return Maps.i(create.lowerBound, create);
            }
        }

        /* loaded from: classes4.dex */
        class b extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            Cut f30790c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Cut f30791d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ q3 f30792e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f30793f;

            b(c cVar, Cut cut, q3 q3Var) {
                this.f30791d = cut;
                this.f30792e = q3Var;
                this.f30793f = cVar;
                this.f30790c = cut;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry a() {
                if (this.f30790c == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (this.f30792e.hasNext()) {
                    Range range = (Range) this.f30792e.next();
                    Range create = Range.create(range.upperBound, this.f30790c);
                    this.f30790c = range.lowerBound;
                    if (this.f30793f.f30785c.lowerBound.isLessThan(create.lowerBound)) {
                        return Maps.i(create.lowerBound, create);
                    }
                } else if (this.f30793f.f30785c.lowerBound.isLessThan(Cut.belowAll())) {
                    Range create2 = Range.create(Cut.belowAll(), this.f30790c);
                    this.f30790c = Cut.belowAll();
                    return Maps.i(Cut.belowAll(), create2);
                }
                return (Map.Entry) b();
            }
        }

        c(NavigableMap navigableMap) {
            this(navigableMap, Range.all());
        }

        private c(NavigableMap navigableMap, Range range) {
            this.f30783a = navigableMap;
            this.f30784b = new d(navigableMap);
            this.f30785c = range;
        }

        private NavigableMap i(Range range) {
            if (!this.f30785c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.f30783a, range.intersection(this.f30785c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator a() {
            Collection values;
            Cut cut;
            if (this.f30785c.hasLowerBound()) {
                values = this.f30784b.tailMap((Cut) this.f30785c.lowerEndpoint(), this.f30785c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                values = this.f30784b.values();
            }
            q3 s11 = Iterators.s(values.iterator());
            if (this.f30785c.contains(Cut.belowAll()) && (!s11.hasNext() || ((Range) s11.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else {
                if (!s11.hasNext()) {
                    return Iterators.h();
                }
                cut = ((Range) s11.next()).upperBound;
            }
            return new a(this, cut, s11);
        }

        @Override // com.google.common.collect.e
        Iterator c() {
            Object obj;
            q3 s11 = Iterators.s(this.f30784b.headMap(this.f30785c.hasUpperBound() ? (Cut) this.f30785c.upperEndpoint() : Cut.aboveAll(), this.f30785c.hasUpperBound() && this.f30785c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (s11.hasNext()) {
                obj = ((Range) s11.peek()).upperBound == Cut.aboveAll() ? ((Range) s11.next()).lowerBound : (Cut) this.f30783a.higherKey(((Range) s11.peek()).upperBound);
            } else {
                if (!this.f30785c.contains(Cut.belowAll()) || this.f30783a.containsKey(Cut.belowAll())) {
                    return Iterators.h();
                }
                obj = (Cut) this.f30783a.higherKey(Cut.belowAll());
            }
            return new b(this, (Cut) com.google.common.base.h.a(obj, Cut.aboveAll()), s11);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    Map.Entry firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && ((Cut) firstEntry.getKey()).equals(cut)) {
                        return (Range) firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Cut cut, boolean z10) {
            return i(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Cut cut, boolean z10, Cut cut2, boolean z11) {
            return i(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Cut cut, boolean z10) {
            return i(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.y(a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class d extends com.google.common.collect.e {

        /* renamed from: a, reason: collision with root package name */
        private final NavigableMap f30794a;

        /* renamed from: b, reason: collision with root package name */
        private final Range f30795b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f30796c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f30797d;

            a(d dVar, Iterator it) {
                this.f30796c = it;
                this.f30797d = dVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry a() {
                if (!this.f30796c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f30796c.next();
                return this.f30797d.f30795b.upperBound.isLessThan(range.upperBound) ? (Map.Entry) b() : Maps.i(range.upperBound, range);
            }
        }

        /* loaded from: classes4.dex */
        class b extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ q3 f30798c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f30799d;

            b(d dVar, q3 q3Var) {
                this.f30798c = q3Var;
                this.f30799d = dVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry a() {
                if (!this.f30798c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f30798c.next();
                return this.f30799d.f30795b.lowerBound.isLessThan(range.upperBound) ? Maps.i(range.upperBound, range) : (Map.Entry) b();
            }
        }

        d(NavigableMap navigableMap) {
            this.f30794a = navigableMap;
            this.f30795b = Range.all();
        }

        private d(NavigableMap navigableMap, Range range) {
            this.f30794a = navigableMap;
            this.f30795b = range;
        }

        private NavigableMap i(Range range) {
            return range.isConnected(this.f30795b) ? new d(this.f30794a, range.intersection(this.f30795b)) : ImmutableSortedMap.of();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator a() {
            Iterator it;
            if (this.f30795b.hasLowerBound()) {
                Map.Entry lowerEntry = this.f30794a.lowerEntry((Cut) this.f30795b.lowerEndpoint());
                it = lowerEntry == null ? this.f30794a.values().iterator() : this.f30795b.lowerBound.isLessThan(((Range) lowerEntry.getValue()).upperBound) ? this.f30794a.tailMap((Cut) lowerEntry.getKey(), true).values().iterator() : this.f30794a.tailMap((Cut) this.f30795b.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.f30794a.values().iterator();
            }
            return new a(this, it);
        }

        @Override // com.google.common.collect.e
        Iterator c() {
            q3 s11 = Iterators.s((this.f30795b.hasUpperBound() ? this.f30794a.headMap((Cut) this.f30795b.upperEndpoint(), false).descendingMap().values() : this.f30794a.descendingMap().values()).iterator());
            if (s11.hasNext() && this.f30795b.upperBound.isLessThan(((Range) s11.peek()).upperBound)) {
                s11.next();
            }
            return new b(this, s11);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            Map.Entry lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    if (this.f30795b.contains(cut) && (lowerEntry = this.f30794a.lowerEntry(cut)) != null && ((Range) lowerEntry.getValue()).upperBound.equals(cut)) {
                        return (Range) lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Cut cut, boolean z10) {
            return i(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Cut cut, boolean z10, Cut cut2, boolean z11) {
            return i(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f30795b.equals(Range.all()) ? this.f30794a.isEmpty() : !a().hasNext();
        }

        @Override // java.util.NavigableMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Cut cut, boolean z10) {
            return i(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30795b.equals(Range.all()) ? this.f30794a.size() : Iterators.y(a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class e extends com.google.common.collect.e {

        /* renamed from: a, reason: collision with root package name */
        private final Range f30800a;

        /* renamed from: b, reason: collision with root package name */
        private final Range f30801b;

        /* renamed from: c, reason: collision with root package name */
        private final NavigableMap f30802c;

        /* renamed from: d, reason: collision with root package name */
        private final NavigableMap f30803d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f30804c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Cut f30805d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ e f30806e;

            a(e eVar, Iterator it, Cut cut) {
                this.f30804c = it;
                this.f30805d = cut;
                this.f30806e = eVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry a() {
                if (!this.f30804c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f30804c.next();
                if (this.f30805d.isLessThan(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(this.f30806e.f30801b);
                return Maps.i(intersection.lowerBound, intersection);
            }
        }

        /* loaded from: classes4.dex */
        class b extends AbstractIterator {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f30807c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f30808d;

            b(e eVar, Iterator it) {
                this.f30807c = it;
                this.f30808d = eVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry a() {
                if (!this.f30807c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f30807c.next();
                if (this.f30808d.f30801b.lowerBound.compareTo((Cut) range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(this.f30808d.f30801b);
                return this.f30808d.f30800a.contains(intersection.lowerBound) ? Maps.i(intersection.lowerBound, intersection) : (Map.Entry) b();
            }
        }

        private e(Range range, Range range2, NavigableMap navigableMap) {
            this.f30800a = (Range) com.google.common.base.m.o(range);
            this.f30801b = (Range) com.google.common.base.m.o(range2);
            this.f30802c = (NavigableMap) com.google.common.base.m.o(navigableMap);
            this.f30803d = new d(navigableMap);
        }

        private NavigableMap j(Range range) {
            return !range.isConnected(this.f30800a) ? ImmutableSortedMap.of() : new e(this.f30800a.intersection(range), this.f30801b, this.f30802c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator a() {
            Iterator it;
            if (!this.f30801b.isEmpty() && !this.f30800a.upperBound.isLessThan(this.f30801b.lowerBound)) {
                if (this.f30800a.lowerBound.isLessThan(this.f30801b.lowerBound)) {
                    it = this.f30803d.tailMap(this.f30801b.lowerBound, false).values().iterator();
                } else {
                    it = this.f30802c.tailMap((Cut) this.f30800a.lowerBound.endpoint(), this.f30800a.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(this, it, (Cut) Ordering.natural().min(this.f30800a.upperBound, Cut.belowValue(this.f30801b.upperBound)));
            }
            return Iterators.h();
        }

        @Override // com.google.common.collect.e
        Iterator c() {
            if (this.f30801b.isEmpty()) {
                return Iterators.h();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f30800a.upperBound, Cut.belowValue(this.f30801b.upperBound));
            return new b(this, this.f30802c.headMap((Cut) cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    if (this.f30800a.contains(cut) && cut.compareTo((Cut) this.f30801b.lowerBound) >= 0 && cut.compareTo((Cut) this.f30801b.upperBound) < 0) {
                        if (cut.equals(this.f30801b.lowerBound)) {
                            Range range = (Range) Maps.E(this.f30802c.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.f30801b.lowerBound) > 0) {
                                return range.intersection(this.f30801b);
                            }
                        } else {
                            Range range2 = (Range) this.f30802c.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f30801b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Cut cut, boolean z10) {
            return j(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Cut cut, boolean z10, Cut cut2, boolean z11) {
            return j(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Cut cut, boolean z10) {
            return j(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.y(a());
        }
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(u3 u3Var) {
        TreeRangeSet<C> create = create();
        create.addAll(u3Var);
        return create;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        com.google.common.base.m.o(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // com.google.common.collect.f
    public void add(Range<C> range) {
        com.google.common.base.m.o(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(u3 u3Var) {
        super.addAll(u3Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.u3
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.u3
    public u3 complement() {
        u3 u3Var = this.complement;
        if (u3Var != null) {
            return u3Var;
        }
        Complement complement = new Complement();
        this.complement = complement;
        return complement;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.u3
    public boolean encloses(Range<C> range) {
        com.google.common.base.m.o(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(u3 u3Var) {
        return super.enclosesAll(u3Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean intersects(Range<C> range) {
        com.google.common.base.m.o(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.u3
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.f
    public Range<C> rangeContaining(C c11) {
        com.google.common.base.m.o(c11);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c11));
        if (floorEntry == null || !floorEntry.getValue().contains(c11)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.f
    public void remove(Range<C> range) {
        com.google.common.base.m.o(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.u3
    public /* bridge */ /* synthetic */ void removeAll(u3 u3Var) {
        super.removeAll(u3Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry == null || lastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
    }

    public u3 subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(this, range);
    }
}
