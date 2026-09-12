package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class s2 extends k2 implements Set {
    @Override // com.google.common.collect.k2, com.google.common.collect.q2
    /* renamed from: delegate */
    protected abstract Set l();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || l().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return l().hashCode();
    }

    protected boolean standardEquals(Object obj) {
        return Sets.a(this, obj);
    }

    protected int standardHashCode() {
        return Sets.d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.k2
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.i(this, (Collection) com.google.common.base.m.o(collection));
    }
}
