package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class PairwiseEquivalence<E, T extends E> extends Equivalence implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence elementEquivalence;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PairwiseEquivalence(Equivalence equivalence) {
        this.elementEquivalence = (Equivalence) m.o(equivalence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it = iterable.iterator();
        Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.Equivalence
    public int doHash(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int i11 = 78721;
        while (it.hasNext()) {
            i11 = (i11 * 24943) + this.elementEquivalence.hash(it.next());
        }
        return i11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }
}
