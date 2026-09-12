package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.c;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends com.google.common.collect.c implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* loaded from: classes4.dex */
    class a extends d {
        a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        Object a(Object obj, Object obj2) {
            return obj2;
        }
    }

    /* loaded from: classes4.dex */
    class b extends d {
        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(Object obj, Object obj2) {
            return Maps.i(obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends Maps.q {

        /* renamed from: d, reason: collision with root package name */
        final transient Map f30326d;

        /* loaded from: classes4.dex */
        class a extends Maps.i {
            a() {
            }

            @Override // com.google.common.collect.Maps.i
            Map a() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return f2.c(c.this.f30326d.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new b();
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.c(entry.getKey());
                return true;
            }
        }

        /* loaded from: classes4.dex */
        class b implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            final Iterator f30329a;

            /* renamed from: b, reason: collision with root package name */
            Collection f30330b;

            b() {
                this.f30329a = c.this.f30326d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.f30329a.next();
                this.f30330b = (Collection) entry.getValue();
                return c.this.h(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f30329a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.m.v(this.f30330b != null, "no calls to next() since the last call to remove()");
                this.f30329a.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.f30330b.size());
                this.f30330b.clear();
                this.f30330b = null;
            }
        }

        c(Map map) {
            this.f30326d = map;
        }

        @Override // com.google.common.collect.Maps.q
        protected Set a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f30326d == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.d(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.u(this.f30326d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection<V> collection = (Collection) Maps.v(this.f30326d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f30326d.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection<? extends V> collection = (Collection) this.f30326d.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(collection);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
            collection.clear();
            return createCollection;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Map.Entry h(Map.Entry entry) {
            Object key = entry.getKey();
            return Maps.i(key, AbstractMapBasedMultimap.this.wrapCollection(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f30326d.hashCode();
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30326d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f30326d.toString();
        }
    }

    /* loaded from: classes4.dex */
    private abstract class d implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        final Iterator f30332a;

        /* renamed from: b, reason: collision with root package name */
        Object f30333b = null;

        /* renamed from: c, reason: collision with root package name */
        Collection f30334c = null;

        /* renamed from: d, reason: collision with root package name */
        Iterator f30335d = Iterators.j();

        d() {
            this.f30332a = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30332a.hasNext() || this.f30335d.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f30335d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f30332a.next();
                this.f30333b = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.f30334c = collection;
                this.f30335d = collection.iterator();
            }
            return a(m3.a(this.f30333b), this.f30335d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f30335d.remove();
            Collection collection = this.f30334c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f30332a.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* loaded from: classes4.dex */
    private class e extends Maps.l {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            Map.Entry f30338a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f30339b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f30340c;

            a(e eVar, Iterator it) {
                this.f30339b = it;
                this.f30340c = eVar;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f30339b.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.f30339b.next();
                this.f30338a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.m.v(this.f30338a != null, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) this.f30338a.getValue();
                this.f30339b.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
                collection.clear();
                this.f30338a = null;
            }
        }

        e(Map map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(this, b().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i11;
            Collection collection = (Collection) b().remove(obj);
            if (collection != null) {
                i11 = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i11);
            } else {
                i11 = 0;
            }
            return i11 > 0;
        }
    }

    /* loaded from: classes4.dex */
    private final class f extends i implements NavigableMap {
        f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry<K, V> ceilingEntry = k().ceilingEntry(obj);
            if (ceilingEntry == null) {
                return null;
            }
            return h(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return k().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return new f(k().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry<K, V> firstEntry = k().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return h(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry<K, V> floorEntry = k().floorEntry(obj);
            if (floorEntry == null) {
                return null;
            }
            return h(floorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return k().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z10) {
            return new f(k().headMap(obj, z10));
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry<K, V> higherEntry = k().higherEntry(obj);
            if (higherEntry == null) {
                return null;
            }
            return h(higherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return k().higherKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet i() {
            return new g(k());
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry<K, V> lastEntry = k().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return h(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry<K, V> lowerEntry = k().lowerEntry(obj);
            if (lowerEntry == null) {
                return null;
            }
            return h(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return k().lowerKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        /* renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return j();
        }

        Map.Entry o(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll((Collection) entry.getValue());
            it.remove();
            return Maps.i(entry.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public NavigableMap k() {
            return (NavigableMap) super.k();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return o(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return o(descendingMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
            return new f(k().subMap(obj, z10, obj2, z11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z10) {
            return new f(k().tailMap(obj, z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class g extends j implements NavigableSet {
        g(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return b().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return new g(b().descendingMap());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap b() {
            return (NavigableMap) super.b();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return b().floorKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z10) {
            return new g(b().headMap(obj, z10));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return b().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return b().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Iterators.t(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Iterators.t(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z10, Object obj2, boolean z11) {
            return new g(b().subMap(obj, z10, obj2, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z10) {
            return new g(b().tailMap(obj, z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class h extends l implements RandomAccess {
        h(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class i extends c implements SortedMap {

        /* renamed from: f, reason: collision with root package name */
        SortedSet f30344f;

        i(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return k().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return k().firstKey();
        }

        public SortedMap headMap(Object obj) {
            return new i(k().headMap(obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.q
        public SortedSet i() {
            return new j(k());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        /* renamed from: j */
        public SortedSet keySet() {
            SortedSet sortedSet = this.f30344f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet i11 = i();
            this.f30344f = i11;
            return i11;
        }

        SortedMap k() {
            return (SortedMap) this.f30326d;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return k().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return new i(k().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return new i(k().tailMap(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class j extends e implements SortedSet {
        j(SortedMap sortedMap) {
            super(sortedMap);
        }

        SortedMap b() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return b().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return new j(b().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return b().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return new j(b().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return new j(b().tailMap(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class k extends AbstractCollection {

        /* renamed from: a, reason: collision with root package name */
        final Object f30347a;

        /* renamed from: b, reason: collision with root package name */
        Collection f30348b;

        /* renamed from: c, reason: collision with root package name */
        final k f30349c;

        /* renamed from: d, reason: collision with root package name */
        final Collection f30350d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            final Iterator f30352a;

            /* renamed from: b, reason: collision with root package name */
            final Collection f30353b;

            a() {
                Collection collection = k.this.f30348b;
                this.f30353b = collection;
                this.f30352a = AbstractMapBasedMultimap.b(collection);
            }

            a(Iterator it) {
                this.f30353b = k.this.f30348b;
                this.f30352a = it;
            }

            Iterator a() {
                b();
                return this.f30352a;
            }

            void b() {
                k.this.f();
                if (k.this.f30348b != this.f30353b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f30352a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                b();
                return this.f30352a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f30352a.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                k.this.g();
            }
        }

        k(Object obj, Collection collection, k kVar) {
            this.f30347a = obj;
            this.f30348b = collection;
            this.f30349c = kVar;
            this.f30350d = kVar == null ? null : kVar.c();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            k kVar = this.f30349c;
            if (kVar != null) {
                kVar.a();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.f30347a, this.f30348b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            f();
            boolean isEmpty = this.f30348b.isEmpty();
            boolean add = this.f30348b.add(obj);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f30348b.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f30348b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        k b() {
            return this.f30349c;
        }

        Collection c() {
            return this.f30348b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f30348b.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            f();
            return this.f30348b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            f();
            return this.f30348b.containsAll(collection);
        }

        Object e() {
            return this.f30347a;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.f30348b.equals(obj);
        }

        void f() {
            Collection collection;
            k kVar = this.f30349c;
            if (kVar != null) {
                kVar.f();
                if (this.f30349c.c() != this.f30350d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f30348b.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.f30347a)) == null) {
                    return;
                }
                this.f30348b = collection;
            }
        }

        void g() {
            k kVar = this.f30349c;
            if (kVar != null) {
                kVar.g();
            } else if (this.f30348b.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.f30347a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f30348b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f();
            boolean remove = this.f30348b.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                g();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f30348b.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f30348b.size() - size);
                g();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            com.google.common.base.m.o(collection);
            int size = size();
            boolean retainAll = this.f30348b.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f30348b.size() - size);
                g();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f30348b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f30348b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class l extends k implements List {

        /* loaded from: classes4.dex */
        private class a extends k.a implements ListIterator {
            a() {
                super();
            }

            public a(int i11) {
                super(l.this.h().listIterator(i11));
            }

            private ListIterator c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean isEmpty = l.this.isEmpty();
                c().add(obj);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    l.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c().set(obj);
            }
        }

        l(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }

        @Override // java.util.List
        public void add(int i11, Object obj) {
            f();
            boolean isEmpty = c().isEmpty();
            h().add(i11, obj);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = h().addAll(i11, collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        @Override // java.util.List
        public Object get(int i11) {
            f();
            return h().get(i11);
        }

        List h() {
            return (List) c();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            f();
            return h().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            f();
            return h().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            f();
            return new a();
        }

        @Override // java.util.List
        public ListIterator listIterator(int i11) {
            f();
            return new a(i11);
        }

        @Override // java.util.List
        public Object remove(int i11) {
            f();
            Object remove = h().remove(i11);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            g();
            return remove;
        }

        @Override // java.util.List
        public Object set(int i11, Object obj) {
            f();
            return h().set(i11, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List subList(int i11, int i12) {
            f();
            return AbstractMapBasedMultimap.this.wrapList(e(), h().subList(i11, i12), b() == null ? this : b());
        }
    }

    /* loaded from: classes4.dex */
    class m extends o implements NavigableSet {
        /* JADX INFO: Access modifiers changed from: package-private */
        public m(Object obj, NavigableSet navigableSet, k kVar) {
            super(obj, navigableSet, kVar);
        }

        private NavigableSet l(NavigableSet navigableSet) {
            return new m(this.f30347a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return h().ceiling(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return new k.a(h().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return l(h().descendingSet());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return h().floor(obj);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z10) {
            return l(h().headSet(obj, z10));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return h().higher(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableSet h() {
            return (NavigableSet) super.h();
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return h().lower(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Iterators.t(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Iterators.t(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z10, Object obj2, boolean z11) {
            return l(h().subSet(obj, z10, obj2, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z10) {
            return l(h().tailSet(obj, z10));
        }
    }

    /* loaded from: classes4.dex */
    class n extends k implements Set {
        /* JADX INFO: Access modifiers changed from: package-private */
        public n(Object obj, Set set) {
            super(obj, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean i11 = Sets.i((Set) this.f30348b, collection);
            if (i11) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f30348b.size() - size);
                g();
            }
            return i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class o extends k implements SortedSet {
        /* JADX INFO: Access modifiers changed from: package-private */
        public o(Object obj, SortedSet sortedSet, k kVar) {
            super(obj, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return h().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            f();
            return h().first();
        }

        SortedSet h() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            f();
            return new o(e(), h().headSet(obj), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public Object last() {
            f();
            return h().last();
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            f();
            return new o(e(), h().subSet(obj, obj2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            f();
            return new o(e(), h().tailSet(obj), b() == null ? this : b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        com.google.common.base.m.d(map.isEmpty());
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Collection a(Object obj) {
        Collection<V> collection = this.map.get(obj);
        if (collection != null) {
            return collection;
        }
        Collection<V> createCollection = createCollection(obj);
        this.map.put(obj, createCollection);
        return createCollection;
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i11 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i11 + 1;
        return i11;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i11 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i11 - 1;
        return i11;
    }

    static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i11) {
        int i12 = abstractMapBasedMultimap.totalSize + i11;
        abstractMapBasedMultimap.totalSize = i12;
        return i12;
    }

    static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i11) {
        int i12 = abstractMapBasedMultimap.totalSize - i11;
        abstractMapBasedMultimap.totalSize = i12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterator b(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj) {
        Collection collection = (Collection) Maps.w(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.j3
    public void clear() {
        Iterator<Collection<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.j3
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    abstract Collection<V> createCollection();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<V> createCollection(K k11) {
        return createCollection();
    }

    @Override // com.google.common.collect.c
    Collection<Map.Entry<K, V>> createEntries() {
        return this instanceof x3 ? new c.b() : new c.a();
    }

    @Override // com.google.common.collect.c
    Set<K> createKeySet() {
        return new e(this.map);
    }

    @Override // com.google.common.collect.c
    l3 createKeys() {
        return new Multimaps.c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof NavigableMap ? new f((NavigableMap) this.map) : map instanceof SortedMap ? new i((SortedMap) this.map) : new c(this.map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof NavigableMap ? new g((NavigableMap) this.map) : map instanceof SortedMap ? new j((SortedMap) this.map) : new e(this.map);
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.c
    Collection<V> createValues() {
        return new c.C0413c();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.c
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.j3
    public Collection<V> get(K k11) {
        Collection<V> collection = this.map.get(k11);
        if (collection == null) {
            collection = createCollection(k11);
        }
        return wrapCollection(k11, collection);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public boolean put(K k11, V v11) {
        Collection<V> collection = this.map.get(k11);
        if (collection != null) {
            if (!collection.add(v11)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection<V> createCollection = createCollection(k11);
        if (!createCollection.add(v11)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(k11, createCollection);
        return true;
    }

    @Override // com.google.common.collect.j3
    public Collection<V> removeAll(Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    public Collection<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k11);
        }
        Collection a11 = a(k11);
        Collection createCollection = createCollection();
        createCollection.addAll(a11);
        this.totalSize -= a11.size();
        a11.clear();
        while (it.hasNext()) {
            if (a11.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.m.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.j3
    public int size() {
        return this.totalSize;
    }

    <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.c
    Iterator<V> valueIterator() {
        return new a();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public Collection<V> values() {
        return super.values();
    }

    Collection<V> wrapCollection(K k11, Collection<V> collection) {
        return new k(k11, collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<V> wrapList(K k11, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(k11, list, kVar) : new l(k11, list, kVar);
    }
}
