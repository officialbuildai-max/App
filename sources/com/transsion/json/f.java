package com.transsion.json;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
public class f implements Set {

    /* renamed from: a, reason: collision with root package name */
    final Set f46109a;

    /* renamed from: b, reason: collision with root package name */
    final Set f46110b = new HashSet();

    public f(Set set) {
        this.f46109a = set;
    }

    public Set a() {
        return this.f46109a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.f46110b.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f46110b.addAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f46110b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f46110b.contains(obj) || this.f46109a.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f46110b.containsAll(collection) || this.f46109a.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f46110b.isEmpty() && this.f46109a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new e(this.f46110b, this.f46109a);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.f46110b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f46110b.removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f46110b.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.f46110b.size() + this.f46109a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        Object[] array = this.f46110b.toArray();
        Object[] array2 = this.f46109a.toArray();
        Object[] objArr = new Object[array.length + array2.length];
        System.arraycopy(array, 0, objArr, 0, array.length);
        System.arraycopy(array2, 0, objArr, array.length, array2.length);
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        throw new IllegalStateException("Not implemeneted");
    }
}
