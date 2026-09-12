package com.google.common.collect;

import com.google.common.collect.Multimaps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class c implements j3 {
    private transient Map<Object, Collection<Object>> asMap;
    private transient Collection<Map.Entry<Object, Object>> entries;
    private transient Set<Object> keySet;
    private transient l3 keys;
    private transient Collection<Object> values;

    /* loaded from: classes4.dex */
    class a extends Multimaps.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        @Override // com.google.common.collect.Multimaps.b
        j3 a() {
            return c.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return c.this.entryIterator();
        }
    }

    /* loaded from: classes4.dex */
    class b extends a implements Set {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            super();
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

    /* renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0413c extends AbstractCollection {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0413c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return c.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return c.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return c.this.size();
        }
    }

    @Override // com.google.common.collect.j3
    public Map<Object, Collection<Object>> asMap() {
        Map<Object, Collection<Object>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<Object, Collection<Object>> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    @Override // com.google.common.collect.j3
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<Object> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(Object obj) {
        Iterator<Collection<Object>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map createAsMap();

    abstract Collection createEntries();

    abstract Set createKeySet();

    abstract l3 createKeys();

    abstract Collection createValues();

    @Override // com.google.common.collect.j3
    public Collection entries() {
        Collection<Map.Entry<Object, Object>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<Object, Object>> createEntries = createEntries();
        this.entries = createEntries;
        return createEntries;
    }

    abstract Iterator entryIterator();

    public boolean equals(Object obj) {
        return Multimaps.a(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.j3
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.j3
    public Set<Object> keySet() {
        Set<Object> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<Object> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    public l3 keys() {
        l3 l3Var = this.keys;
        if (l3Var != null) {
            return l3Var;
        }
        l3 createKeys = createKeys();
        this.keys = createKeys;
        return createKeys;
    }

    @Override // com.google.common.collect.j3
    public abstract boolean put(Object obj, Object obj2);

    @Override // com.google.common.collect.j3
    public boolean putAll(j3 j3Var) {
        boolean z10 = false;
        for (Map.Entry entry : j3Var.entries()) {
            z10 |= put(entry.getKey(), entry.getValue());
        }
        return z10;
    }

    public boolean putAll(Object obj, Iterable<Object> iterable) {
        com.google.common.base.m.o(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return !collection.isEmpty() && get(obj).addAll(collection);
        }
        Iterator<Object> it = iterable.iterator();
        return it.hasNext() && Iterators.a(get(obj), it);
    }

    @Override // com.google.common.collect.j3
    public boolean remove(Object obj, Object obj2) {
        Collection<Object> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return asMap().toString();
    }

    Iterator<Object> valueIterator() {
        return Maps.D(entries().iterator());
    }

    @Override // com.google.common.collect.j3
    public Collection values() {
        Collection<Object> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<Object> createValues = createValues();
        this.values = createValues;
        return createValues;
    }
}
