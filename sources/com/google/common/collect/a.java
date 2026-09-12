package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class a extends s4 {

    /* renamed from: a, reason: collision with root package name */
    private final int f30809a;

    /* renamed from: b, reason: collision with root package name */
    private int f30810b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i11) {
        this(i11, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i11, int i12) {
        com.google.common.base.m.r(i12, i11);
        this.f30809a = i11;
        this.f30810b = i12;
    }

    protected abstract Object a(int i11);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f30810b < this.f30809a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f30810b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f30810b;
        this.f30810b = i11 + 1;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f30810b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f30810b - 1;
        this.f30810b = i11;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f30810b - 1;
    }
}
