package org.apache.tools.ant.types;

import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes7.dex */
class p implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Enumeration f71637a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ q f71638b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q qVar, Enumeration enumeration) {
        this.f71638b = qVar;
        this.f71637a = enumeration;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f71637a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public Object next() {
        return new y00.f(this.f71638b.getProject(), (String) this.f71637a.nextElement());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
