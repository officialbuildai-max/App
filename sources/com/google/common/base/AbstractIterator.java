package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class AbstractIterator implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private State f30255a = State.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    private Object f30256b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f30255a = State.FAILED;
        this.f30256b = a();
        if (this.f30255a == State.DONE) {
            return false;
        }
        this.f30255a = State.READY;
        return true;
    }

    protected abstract Object a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object b() {
        this.f30255a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        m.u(this.f30255a != State.FAILED);
        int ordinal = this.f30255a.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f30255a = State.NOT_READY;
        Object a11 = i.a(this.f30256b);
        this.f30256b = null;
        return a11;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
