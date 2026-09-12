package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class k2 extends q2 implements Collection {
    public boolean add(Object obj) {
        return l().add(obj);
    }

    public boolean addAll(Collection<Object> collection) {
        return l().addAll(collection);
    }

    public void clear() {
        l().clear();
    }

    public boolean contains(Object obj) {
        return l().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return l().containsAll(collection);
    }

    @Override // com.google.common.collect.q2
    /* renamed from: delegate */
    protected abstract Collection l();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return l().isEmpty();
    }

    public Iterator<Object> iterator() {
        return l().iterator();
    }

    public boolean remove(Object obj) {
        return l().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return l().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return l().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return l().size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean standardAddAll(Collection<Object> collection) {
        return Iterators.a(this, collection.iterator());
    }

    protected void standardClear() {
        Iterators.d(iterator());
    }

    protected boolean standardContains(Object obj) {
        return Iterators.f(iterator(), obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean standardContainsAll(Collection<?> collection) {
        return f2.a(this, collection);
    }

    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    protected boolean standardRemove(Object obj) {
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            if (com.google.common.base.j.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.u(iterator(), collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.w(iterator(), collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) n3.g(this, tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String standardToString() {
        return f2.e(this);
    }

    public Object[] toArray() {
        return l().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) l().toArray(tArr);
    }
}
