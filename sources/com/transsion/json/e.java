package com.transsion.json;

import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    final Iterator[] f46107a;

    /* renamed from: b, reason: collision with root package name */
    int f46108b = 0;

    public e(Set... setArr) {
        this.f46107a = new Iterator[setArr.length];
        for (int i11 = 0; i11 < setArr.length; i11++) {
            this.f46107a[i11] = setArr[i11].iterator();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f46107a[this.f46108b].hasNext()) {
            return true;
        }
        int i11 = this.f46108b + 1;
        this.f46108b = i11;
        Iterator[] itArr = this.f46107a;
        return i11 < itArr.length && itArr[i11].hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.f46107a[this.f46108b].next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f46107a[this.f46108b].remove();
    }
}
