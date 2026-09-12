package com.google.common.collect;

import com.google.common.collect.l3;
import com.google.common.primitives.Ints;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private final transient long[] f30706a;

    /* renamed from: b, reason: collision with root package name */
    private final transient int f30707b;

    /* renamed from: c, reason: collision with root package name */
    private final transient int f30708c;
    final transient RegularImmutableSortedSet<E> elementSet;

    /* renamed from: d, reason: collision with root package name */
    private static final long[] f30705d = {0};
    static final ImmutableSortedMultiset<?> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i11, int i12) {
        this.elementSet = regularImmutableSortedSet;
        this.f30706a = jArr;
        this.f30707b = i11;
        this.f30708c = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.f30706a = f30705d;
        this.f30707b = 0;
        this.f30708c = 0;
    }

    private int h(int i11) {
        long[] jArr = this.f30706a;
        int i12 = this.f30707b;
        return (int) (jArr[(i12 + i11) + 1] - jArr[i12 + i11]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.l3
    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return h(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.l3
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public l3.a firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    l3.a getEntry(int i11) {
        return Multisets.g(this.elementSet.asList().get(i11), h(i11));
    }

    ImmutableSortedMultiset<E> getSubMultiset(int i11, int i12) {
        com.google.common.base.m.t(i11, i12, this.f30708c);
        return i11 == i12 ? ImmutableSortedMultiset.emptyMultiset(comparator()) : (i11 == 0 && i12 == this.f30708c) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i11, i12), this.f30706a, this.f30707b + i11, i12 - i11);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e11, com.google.common.base.m.o(boundType) == BoundType.CLOSED));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ a4 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f30707b > 0 || this.f30708c < this.f30706a.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public l3.a lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.f30708c - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public int size() {
        long[] jArr = this.f30706a;
        int i11 = this.f30707b;
        return Ints.n(jArr[this.f30708c + i11] - jArr[i11]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e11, com.google.common.base.m.o(boundType) == BoundType.CLOSED), this.f30708c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ a4 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }
}
