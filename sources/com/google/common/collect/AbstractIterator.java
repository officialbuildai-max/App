package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class AbstractIterator extends r4 {

    /* renamed from: a, reason: collision with root package name */
    private State f30322a = State.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    private Object f30323b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f30322a = State.FAILED;
        this.f30323b = a();
        if (this.f30322a == State.DONE) {
            return false;
        }
        this.f30322a = State.READY;
        return true;
    }

    protected abstract Object a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object b() {
        this.f30322a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.common.base.m.u(this.f30322a != State.FAILED);
        int ordinal = this.f30322a.ordinal();
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
        this.f30322a = State.NOT_READY;
        Object a11 = m3.a(this.f30323b);
        this.f30323b = null;
        return a11;
    }
}
