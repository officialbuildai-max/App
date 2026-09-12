package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f3780c;

    public b(Object[] objArr, int i11, int i12) {
        super(i11, i12);
        this.f3780c = objArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.f3780c;
        int e11 = e();
        h(e11 + 1);
        return objArr[e11];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.f3780c;
        h(e() - 1);
        return objArr[e()];
    }
}
