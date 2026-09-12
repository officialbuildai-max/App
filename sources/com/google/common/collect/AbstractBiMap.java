package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractBiMap<K, V> extends n2 implements k, Serializable {
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Object readObject = objectInputStream.readObject();
            Objects.requireNonNull(readObject);
            setInverse((AbstractBiMap) readObject);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        K checkKey(K k11) {
            return this.inverse.checkValue(k11);
        }

        @Override // com.google.common.collect.AbstractBiMap
        V checkValue(V v11) {
            return this.inverse.checkKey(v11);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.q2
        /* renamed from: delegate */
        protected /* bridge */ /* synthetic */ Object l() {
            return super.l();
        }

        Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.n2, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        Map.Entry f30312a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f30313b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractBiMap f30314c;

        a(AbstractBiMap abstractBiMap, Iterator it) {
            this.f30313b = it;
            this.f30314c = abstractBiMap;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Map.Entry entry = (Map.Entry) this.f30313b.next();
            this.f30312a = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30313b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry entry = this.f30312a;
            if (entry == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            Object value = entry.getValue();
            this.f30313b.remove();
            this.f30314c.n(value);
            this.f30312a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends o2 {

        /* renamed from: a, reason: collision with root package name */
        private final Map.Entry f30315a;

        b(Map.Entry entry) {
            this.f30315a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.q2
        public Map.Entry l() {
            return this.f30315a;
        }

        @Override // com.google.common.collect.o2, java.util.Map.Entry
        public Object setValue(Object obj) {
            AbstractBiMap.this.checkValue(obj);
            com.google.common.base.m.v(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (com.google.common.base.j.a(obj, getValue())) {
                return obj;
            }
            com.google.common.base.m.j(!AbstractBiMap.this.containsValue(obj), "value already present: %s", obj);
            Object value = this.f30315a.setValue(obj);
            com.google.common.base.m.v(com.google.common.base.j.a(obj, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.o(getKey(), true, value, obj);
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends s2 {

        /* renamed from: a, reason: collision with root package name */
        final Set f30317a;

        private c() {
            this.f30317a = AbstractBiMap.this.delegate.entrySet();
        }

        /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.e(l(), obj);
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return standardContainsAll(collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.k2, com.google.common.collect.q2
        /* renamed from: delegate */
        public Set l() {
            return this.f30317a;
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f30317a.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((AbstractBiMap) AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
            this.f30317a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return standardToArray(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class d extends s2 {
        private d() {
        }

        /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.k2, com.google.common.collect.q2
        /* renamed from: delegate */
        public Set l() {
            return AbstractBiMap.this.delegate.keySet();
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Maps.l(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.m(obj);
            return true;
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return standardRetainAll(collection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class e extends s2 {

        /* renamed from: a, reason: collision with root package name */
        final Set f30320a;

        private e() {
            this.f30320a = AbstractBiMap.this.inverse.keySet();
        }

        /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.k2, com.google.common.collect.q2
        /* renamed from: delegate */
        public Set l() {
            return this.f30320a;
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Maps.D(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return standardToArray(objArr);
        }

        @Override // com.google.common.collect.q2
        public String toString() {
            return standardToString();
        }
    }

    private AbstractBiMap(Map map, AbstractBiMap abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, a aVar) {
        this(map, abstractBiMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object l(Object obj, Object obj2, boolean z10) {
        checkKey(obj);
        checkValue(obj2);
        boolean containsKey = containsKey(obj);
        if (containsKey && com.google.common.base.j.a(obj2, get(obj))) {
            return obj2;
        }
        if (z10) {
            inverse().remove(obj2);
        } else {
            com.google.common.base.m.j(!containsValue(obj2), "value already present: %s", obj2);
        }
        V put = this.delegate.put(obj, obj2);
        o(obj, containsKey, put, obj2);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object m(Object obj) {
        Object a11 = m3.a(this.delegate.remove(obj));
        n(a11);
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Object obj) {
        this.inverse.delegate.remove(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj, boolean z10, Object obj2, Object obj3) {
        if (z10) {
            n(m3.a(obj2));
        }
        this.inverse.delegate.put(obj3, obj);
    }

    K checkKey(K k11) {
        return k11;
    }

    V checkValue(V v11) {
        return v11;
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.q2
    /* renamed from: delegate */
    public Map<K, V> l() {
        return this.delegate;
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this, this.delegate.entrySet().iterator());
    }

    public V forcePut(K k11, V v11) {
        return (V) l(k11, v11, true);
    }

    @Override // com.google.common.collect.k
    public k inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        d dVar = new d(this, null);
        this.keySet = dVar;
        return dVar;
    }

    AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public V put(K k11, V v11) {
        return (V) l(k11, v11, false);
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return (V) m(obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        com.google.common.base.m.u(this.delegate == null);
        com.google.common.base.m.u(this.inverse == null);
        com.google.common.base.m.d(map.isEmpty());
        com.google.common.base.m.d(map2.isEmpty());
        com.google.common.base.m.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override // com.google.common.collect.n2, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.valueSet = eVar;
        return eVar;
    }
}
