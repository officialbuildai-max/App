package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* renamed from: e, reason: collision with root package name */
    private transient int[] f30412e;

    /* renamed from: f, reason: collision with root package name */
    private transient int[] f30413f;

    /* renamed from: g, reason: collision with root package name */
    private transient int f30414g;

    /* renamed from: h, reason: collision with root package name */
    private transient int f30415h;

    CompactLinkedHashSet() {
    }

    CompactLinkedHashSet(int i11) {
        super(i11);
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i11) {
        return new CompactLinkedHashSet<>(i11);
    }

    private int p(int i11) {
        return q()[i11] - 1;
    }

    private int[] q() {
        int[] iArr = this.f30412e;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.f30413f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private void s(int i11, int i12) {
        q()[i11] = i12 + 1;
    }

    private void t(int i11, int i12) {
        if (i11 == -2) {
            this.f30414g = i12;
        } else {
            u(i11, i12);
        }
        if (i12 == -2) {
            this.f30415h = i11;
        } else {
            s(i12, i11);
        }
    }

    private void u(int i11, int i12) {
        r()[i11] = i12 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    int adjustAfterRemove(int i11, int i12) {
        return i11 >= size() ? i12 : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public int allocArrays() {
        int allocArrays = super.allocArrays();
        this.f30412e = new int[allocArrays];
        this.f30413f = new int[allocArrays];
        return allocArrays;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.f30414g = -2;
        this.f30415h = -2;
        int[] iArr = this.f30412e;
        if (iArr != null && this.f30413f != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f30413f, 0, size(), 0);
        }
        super.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.f30412e = null;
        this.f30413f = null;
        return convertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashSet
    int firstEntryIndex() {
        return this.f30414g;
    }

    @Override // com.google.common.collect.CompactHashSet
    int getSuccessor(int i11) {
        return r()[i11] - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void init(int i11) {
        super.init(i11);
        this.f30414g = -2;
        this.f30415h = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int i11, E e11, int i12, int i13) {
        super.insertEntry(i11, e11, i12, i13);
        t(this.f30415h, i11);
        t(i11, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int i11, int i12) {
        int size = size() - 1;
        super.moveLastEntry(i11, i12);
        t(p(i11), getSuccessor(i11));
        if (i11 < size) {
            t(p(size), i11);
            t(i11, getSuccessor(size));
        }
        q()[size] = 0;
        r()[size] = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        this.f30412e = Arrays.copyOf(q(), i11);
        this.f30413f = Arrays.copyOf(r(), i11);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return n3.f(this);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) n3.g(this, tArr);
    }
}
