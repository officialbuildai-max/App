package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* loaded from: classes4.dex */
    private static class Factory<C, V> implements com.google.common.base.q, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // com.google.common.base.q
        public Map<C, V> get() {
            return new TreeMap(this.comparator);
        }
    }

    /* loaded from: classes4.dex */
    class a extends AbstractIterator {

        /* renamed from: c, reason: collision with root package name */
        Object f30754c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Iterator f30755d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Comparator f30756e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TreeBasedTable f30757f;

        a(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.f30755d = it;
            this.f30756e = comparator;
            this.f30757f = treeBasedTable;
        }

        @Override // com.google.common.collect.AbstractIterator
        protected Object a() {
            while (this.f30755d.hasNext()) {
                Object next = this.f30755d.next();
                Object obj = this.f30754c;
                if (obj == null || this.f30756e.compare(next, obj) != 0) {
                    this.f30754c = next;
                    return next;
                }
            }
            this.f30754c = null;
            return b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends StandardTable.g implements SortedMap {

        /* renamed from: d, reason: collision with root package name */
        final Object f30758d;

        /* renamed from: e, reason: collision with root package name */
        final Object f30759e;

        /* renamed from: f, reason: collision with root package name */
        transient SortedMap f30760f;

        b(TreeBasedTable treeBasedTable, Object obj) {
            this(obj, null, null);
        }

        b(Object obj, Object obj2, Object obj3) {
            super(obj);
            this.f30758d = obj2;
            this.f30759e = obj3;
            com.google.common.base.m.d(obj2 == null || obj3 == null || h(obj2, obj3) <= 0);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return k(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.StandardTable.g
        void d() {
            l();
            SortedMap sortedMap = this.f30760f;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.f30742a);
            this.f30760f = null;
            this.f30743b = null;
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            e();
            Map map = this.f30743b;
            if (map != null) {
                return ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        int h(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            com.google.common.base.m.d(k(com.google.common.base.m.o(obj)));
            return new b(this.f30742a, this.f30758d, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedMap c() {
            l();
            SortedMap sortedMap = this.f30760f;
            if (sortedMap == null) {
                return null;
            }
            Object obj = this.f30758d;
            if (obj != null) {
                sortedMap = sortedMap.tailMap(obj);
            }
            Object obj2 = this.f30759e;
            return obj2 != null ? sortedMap.headMap(obj2) : sortedMap;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public SortedSet keySet() {
            return new Maps.n(this);
        }

        boolean k(Object obj) {
            Object obj2;
            Object obj3;
            return obj != null && ((obj2 = this.f30758d) == null || h(obj2, obj) <= 0) && ((obj3 = this.f30759e) == null || h(obj3, obj) > 0);
        }

        void l() {
            SortedMap sortedMap = this.f30760f;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f30742a))) {
                this.f30760f = (SortedMap) TreeBasedTable.this.backingMap.get(this.f30742a);
            }
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            e();
            Map map = this.f30743b;
            if (map != null) {
                return ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            com.google.common.base.m.d(k(com.google.common.base.m.o(obj)));
            return super.put(obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            com.google.common.base.m.d(k(com.google.common.base.m.o(obj)) && k(com.google.common.base.m.o(obj2)));
            return new b(this.f30742a, obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            com.google.common.base.m.d(k(com.google.common.base.m.o(obj)));
            return new b(this.f30742a, obj, this.f30759e);
        }
    }

    TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        com.google.common.base.m.o(comparator);
        com.google.common.base.m.o(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$createColumnKeyIterator$0(Map map) {
        return map.keySet().iterator();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.c4
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.c4
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.c4
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator = columnComparator();
        return new a(this, Iterators.r(g3.s(this.backingMap.values(), new com.google.common.base.f() { // from class: com.google.common.collect.q4
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                Iterator lambda$createColumnKeyIterator$0;
                lambda$createColumnKeyIterator$0 = TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
                return lambda$createColumnKeyIterator$0;
            }
        }), columnComparator), columnComparator);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.c4
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.c4
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ void putAll(c4 c4Var) {
        super.putAll(c4Var);
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((TreeBasedTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.StandardTable
    public SortedMap<C, V> row(R r11) {
        return new b(this, r11);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.c4
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.c4
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.c4
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
