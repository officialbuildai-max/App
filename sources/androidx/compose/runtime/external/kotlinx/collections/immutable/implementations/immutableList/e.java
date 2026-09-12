package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f3786c;

    /* renamed from: d, reason: collision with root package name */
    private final i f3787d;

    public e(Object[] objArr, Object[] objArr2, int i11, int i12, int i13) {
        super(i11, i12);
        this.f3786c = objArr2;
        int d11 = j.d(i12);
        this.f3787d = new i(objArr, RangesKt.i(i11, d11), d11, i13);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        a();
        if (this.f3787d.hasNext()) {
            h(e() + 1);
            return this.f3787d.next();
        }
        Object[] objArr = this.f3786c;
        int e11 = e();
        h(e11 + 1);
        return objArr[e11 - this.f3787d.f()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        c();
        if (e() <= this.f3787d.f()) {
            h(e() - 1);
            return this.f3787d.previous();
        }
        Object[] objArr = this.f3786c;
        h(e() - 1);
        return objArr[e() - this.f3787d.f()];
    }
}
