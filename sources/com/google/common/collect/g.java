package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class g extends r4 {

    /* renamed from: a, reason: collision with root package name */
    private Object f30842a;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Object obj) {
        this.f30842a = obj;
    }

    protected abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f30842a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj = this.f30842a;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.f30842a = a(obj);
        return obj;
    }
}
