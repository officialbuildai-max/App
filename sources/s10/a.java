package s10;

import java.util.Iterator;

/* loaded from: classes7.dex */
public class a implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f74977a;

    /* renamed from: b, reason: collision with root package name */
    private int f74978b = 0;

    public a(Object[] objArr) {
        this.f74977a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f74978b != this.f74977a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object[] objArr = this.f74977a;
        int i11 = this.f74978b;
        this.f74978b = i11 + 1;
        return objArr[i11];
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
