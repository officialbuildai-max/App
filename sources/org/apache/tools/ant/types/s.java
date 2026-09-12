package org.apache.tools.ant.types;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
class s implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private boolean f71654a = false;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ t f71655b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(t tVar) {
        this.f71655b = tVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f71654a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.f71654a) {
            throw new NoSuchElementException();
        }
        this.f71654a = true;
        return this.f71655b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
