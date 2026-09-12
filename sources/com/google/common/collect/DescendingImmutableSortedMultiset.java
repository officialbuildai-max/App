package com.google.common.collect;

import com.google.common.collect.l3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private final transient ImmutableSortedMultiset f30431a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.f30431a = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.l3
    public int count(Object obj) {
        return this.f30431a.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f30431a;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.l3
    public ImmutableSortedSet<E> elementSet() {
        return this.f30431a.elementSet().descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public l3.a firstEntry() {
        return this.f30431a.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    l3.a getEntry(int i11) {
        return this.f30431a.entrySet().asList().reverse().get(i11);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return this.f30431a.tailMultiset((ImmutableSortedMultiset) e11, boundType).descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ a4 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f30431a.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public l3.a lastEntry() {
        return this.f30431a.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public int size() {
        return this.f30431a.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return this.f30431a.headMultiset((ImmutableSortedMultiset) e11, boundType).descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ a4 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }
}
