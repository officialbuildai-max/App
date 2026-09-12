package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class n2 extends q2 implements Map {
    public void clear() {
        l().clear();
    }

    public boolean containsKey(Object obj) {
        return l().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return l().containsValue(obj);
    }

    @Override // com.google.common.collect.q2
    /* renamed from: delegate */
    protected abstract Map l();

    public Set<Map.Entry<Object, Object>> entrySet() {
        return l().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || l().equals(obj);
    }

    public Object get(Object obj) {
        return l().get(obj);
    }

    public int hashCode() {
        return l().hashCode();
    }

    public boolean isEmpty() {
        return l().isEmpty();
    }

    public Set<Object> keySet() {
        return l().keySet();
    }

    public Object put(Object obj, Object obj2) {
        return l().put(obj, obj2);
    }

    public void putAll(Map<Object, Object> map) {
        l().putAll(map);
    }

    public Object remove(Object obj) {
        return l().remove(obj);
    }

    public int size() {
        return l().size();
    }

    protected void standardClear() {
        Iterators.d(entrySet().iterator());
    }

    protected boolean standardContainsKey(Object obj) {
        return Maps.f(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean standardContainsValue(Object obj) {
        return Maps.g(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean standardEquals(Object obj) {
        return Maps.h(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int standardHashCode() {
        return Sets.d(entrySet());
    }

    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    protected void standardPutAll(Map<Object, Object> map) {
        Maps.t(this, map);
    }

    protected Object standardRemove(Object obj) {
        Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> next = it.next();
            if (com.google.common.base.j.a(next.getKey(), obj)) {
                Object value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String standardToString() {
        return Maps.x(this);
    }

    public Collection<Object> values() {
        return l().values();
    }
}
