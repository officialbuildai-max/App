package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: classes4.dex */
public abstract class r2 extends k2 implements Queue {
    @Override // com.google.common.collect.k2, com.google.common.collect.q2
    /* renamed from: delegate */
    protected abstract Queue l();

    @Override // java.util.Queue
    public Object element() {
        return l().element();
    }

    @Override // java.util.Queue
    public Object peek() {
        return l().peek();
    }

    @Override // java.util.Queue
    public Object poll() {
        return l().poll();
    }

    @Override // java.util.Queue
    public Object remove() {
        return l().remove();
    }

    protected boolean standardOffer(Object obj) {
        try {
            return add(obj);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    protected Object standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    protected Object standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
