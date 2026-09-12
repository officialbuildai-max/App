package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes4.dex */
public abstract class Maps {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum EntryFunction implements com.google.common.base.f {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.f
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.f
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(c cVar) {
            this();
        }

        @Override // com.google.common.base.f
        public abstract /* synthetic */ Object apply(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends com.google.common.collect.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map.Entry f30637a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f30638b;

        a(Map.Entry entry, j jVar) {
            this.f30637a = entry;
            this.f30638b = jVar;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.f30637a.getKey();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            return this.f30638b.a(this.f30637a.getKey(), this.f30637a.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements com.google.common.base.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f30639a;

        b(j jVar) {
            this.f30639a = jVar;
        }

        @Override // com.google.common.base.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry apply(Map.Entry entry) {
            return Maps.z(this.f30639a, entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends o4 {
        c(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.o4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Map.Entry entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends o4 {
        d(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.o4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* loaded from: classes4.dex */
    class e extends o4 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.f f30640b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Iterator it, com.google.common.base.f fVar) {
            super(it);
            this.f30640b = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.o4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(Object obj) {
            return Maps.i(obj, this.f30640b.apply(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends com.google.common.collect.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map.Entry f30641a;

        f(Map.Entry entry) {
            this.f30641a = entry;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.f30641a.getKey();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            return this.f30641a.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.f f30642a;

        g(com.google.common.base.f fVar) {
            this.f30642a = fVar;
        }

        @Override // com.google.common.collect.Maps.j
        public Object a(Object obj, Object obj2) {
            return this.f30642a.apply(obj2);
        }
    }

    /* loaded from: classes4.dex */
    static abstract class h extends n2 implements NavigableMap {

        /* renamed from: a, reason: collision with root package name */
        private transient Comparator f30643a;

        /* renamed from: b, reason: collision with root package name */
        private transient Set f30644b;

        /* renamed from: c, reason: collision with root package name */
        private transient NavigableSet f30645c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends i {
            a() {
            }

            @Override // com.google.common.collect.Maps.i
            Map a() {
                return h.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return h.this.m();
            }
        }

        private static Ordering o(Comparator comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            return n().floorEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return n().floorKey(obj);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            Comparator comparator = this.f30643a;
            if (comparator != null) {
                return comparator;
            }
            Comparator comparator2 = n().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering o11 = o(comparator2);
            this.f30643a = o11;
            return o11;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.q2
        /* renamed from: delegate */
        public final Map l() {
            return n();
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return n().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return n();
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public Set entrySet() {
            Set set = this.f30644b;
            if (set != null) {
                return set;
            }
            Set l11 = l();
            this.f30644b = l11;
            return l11;
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            return n().lastEntry();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return n().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            return n().ceilingEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return n().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z10) {
            return n().tailMap(obj, z10).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            return n().lowerEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return n().lowerKey(obj);
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public Set keySet() {
            return navigableKeySet();
        }

        Set l() {
            return new a();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            return n().firstEntry();
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return n().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            return n().higherEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return n().higherKey(obj);
        }

        abstract Iterator m();

        abstract NavigableMap n();

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            NavigableSet navigableSet = this.f30645c;
            if (navigableSet != null) {
                return navigableSet;
            }
            m mVar = new m(this);
            this.f30645c = mVar;
            return mVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return n().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return n().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
            return n().subMap(obj2, z11, obj, z10).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z10) {
            return n().headMap(obj, z10).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // com.google.common.collect.q2
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public Collection values() {
            return new p(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class i extends Sets.e {
        abstract Map a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object v11 = Maps.v(a(), key);
            if (com.google.common.base.j.a(v11, entry.getValue())) {
                return v11 != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.e, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.m.o(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.j(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.m.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet g11 = Sets.g(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        g11.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(g11);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
        Object a(Object obj, Object obj2);
    }

    /* loaded from: classes4.dex */
    static abstract class k extends AbstractMap {

        /* loaded from: classes4.dex */
        class a extends i {
            a() {
            }

            @Override // com.google.common.collect.Maps.i
            Map a() {
                return k.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return k.this.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Iterator a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.d(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class l extends Sets.e {

        /* renamed from: a, reason: collision with root package name */
        final Map f30648a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public l(Map map) {
            this.f30648a = (Map) com.google.common.base.m.o(map);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public Map b() {
            return this.f30648a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Maps.l(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            b().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class m extends n implements NavigableSet {
        /* JADX INFO: Access modifiers changed from: package-private */
        public m(NavigableMap navigableMap) {
            super(navigableMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.n
        /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap b() {
            return (NavigableMap) this.f30648a;
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return a().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return a().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return a().floorKey(obj);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z10) {
            return a().headMap(obj, z10).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return a().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return a().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Maps.m(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Maps.m(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z10, Object obj2, boolean z11) {
            return a().subMap(obj, z10, obj2, z11).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z10) {
            return a().tailMap(obj, z10).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }
    }

    /* loaded from: classes4.dex */
    static class n extends l implements SortedSet {
        /* JADX INFO: Access modifiers changed from: package-private */
        public n(SortedMap sortedMap) {
            super(sortedMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.l
        public SortedMap b() {
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
            return new n(b().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return b().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return new n(b().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return new n(b().tailMap(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class o extends k {

        /* renamed from: a, reason: collision with root package name */
        final Map f30649a;

        /* renamed from: b, reason: collision with root package name */
        final j f30650b;

        o(Map map, j jVar) {
            this.f30649a = (Map) com.google.common.base.m.o(map);
            this.f30650b = (j) com.google.common.base.m.o(jVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator a() {
            return Iterators.A(this.f30649a.entrySet().iterator(), Maps.a(this.f30650b));
        }

        @Override // com.google.common.collect.Maps.k, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f30649a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f30649a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.f30649a.get(obj);
            if (obj2 != null || this.f30649a.containsKey(obj)) {
                return this.f30650b.a(obj, m3.a(obj2));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.f30649a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (this.f30649a.containsKey(obj)) {
                return this.f30650b.a(obj, m3.a(this.f30649a.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30649a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            return new p(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class p extends AbstractCollection {

        /* renamed from: a, reason: collision with root package name */
        final Map f30651a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public p(Map map) {
            this.f30651a = (Map) com.google.common.base.m.o(map);
        }

        final Map a() {
            return this.f30651a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Maps.D(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : a().entrySet()) {
                    if (com.google.common.base.j.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.m.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet f11 = Sets.f();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        f11.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(f11);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.m.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet f11 = Sets.f();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        f11.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(f11);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class q extends AbstractMap {

        /* renamed from: a, reason: collision with root package name */
        private transient Set f30652a;

        /* renamed from: b, reason: collision with root package name */
        private transient Set f30653b;

        /* renamed from: c, reason: collision with root package name */
        private transient Collection f30654c;

        abstract Set a();

        /* renamed from: c */
        Set i() {
            return new l(this);
        }

        Collection d() {
            return new p(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f30652a;
            if (set != null) {
                return set;
            }
            Set a11 = a();
            this.f30652a = a11;
            return a11;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            Set set = this.f30653b;
            if (set != null) {
                return set;
            }
            Set i11 = i();
            this.f30653b = i11;
            return i11;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.f30654c;
            if (collection != null) {
                return collection;
            }
            Collection d11 = d();
            this.f30654c = d11;
            return d11;
        }
    }

    public static Map A(Map map, com.google.common.base.f fVar) {
        return y(map, b(fVar));
    }

    static Map.Entry B(Map.Entry entry) {
        com.google.common.base.m.o(entry);
        return new f(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.common.base.f C() {
        return EntryFunction.VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator D(Iterator it) {
        return new d(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object E(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.common.base.n F(com.google.common.base.n nVar) {
        return Predicates.e(nVar, C());
    }

    static com.google.common.base.f a(j jVar) {
        com.google.common.base.m.o(jVar);
        return new b(jVar);
    }

    static j b(com.google.common.base.f fVar) {
        com.google.common.base.m.o(fVar);
        return new g(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator c(Set set, com.google.common.base.f fVar) {
        return new e(set.iterator(), fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i11) {
        if (i11 < 3) {
            e2.b(i11, "expectedSize");
            return i11 + 1;
        }
        if (i11 < 1073741824) {
            return (int) Math.ceil(i11 / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Collection collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(B((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Map map, Object obj) {
        return Iterators.f(l(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Map map, Object obj) {
        return Iterators.f(D(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static Map.Entry i(Object obj, Object obj2) {
        return new ImmutableEntry(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableMap j(Collection collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            bVar.h(it.next(), Integer.valueOf(i11));
            i11++;
        }
        return bVar.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.common.base.f k() {
        return EntryFunction.KEY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator l(Iterator it) {
        return new c(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object m(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.common.base.n n(com.google.common.base.n nVar) {
        return Predicates.e(nVar, k());
    }

    public static HashMap o() {
        return new HashMap();
    }

    public static HashMap p(int i11) {
        return new HashMap(d(i11));
    }

    public static IdentityHashMap q() {
        return new IdentityHashMap();
    }

    public static LinkedHashMap r() {
        return new LinkedHashMap();
    }

    public static LinkedHashMap s(int i11) {
        return new LinkedHashMap(d(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void t(Map map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u(Map map, Object obj) {
        com.google.common.base.m.o(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object v(Map map, Object obj) {
        com.google.common.base.m.o(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object w(Map map, Object obj) {
        com.google.common.base.m.o(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String x(Map map) {
        StringBuilder b11 = f2.b(map.size());
        b11.append('{');
        boolean z10 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z10) {
                b11.append(", ");
            }
            b11.append(entry.getKey());
            b11.append('=');
            b11.append(entry.getValue());
            z10 = false;
        }
        b11.append('}');
        return b11.toString();
    }

    public static Map y(Map map, j jVar) {
        return new o(map, jVar);
    }

    static Map.Entry z(j jVar, Map.Entry entry) {
        com.google.common.base.m.o(jVar);
        com.google.common.base.m.o(entry);
        return new a(entry, jVar);
    }
}
