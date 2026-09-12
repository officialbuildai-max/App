package com.google.common.collect;

import java.util.Iterator;

/* loaded from: classes4.dex */
abstract class o4 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    final Iterator f30897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o4(Iterator it) {
        this.f30897a = (Iterator) com.google.common.base.m.o(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f30897a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f30897a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f30897a.remove();
    }
}
