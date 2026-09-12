package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: c, reason: collision with root package name */
    private int f3797c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f3798d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3799e;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public i(Object[] objArr, int i11, int i12, int i13) {
        super(i11, i12);
        this.f3797c = i13;
        Object[] objArr2 = new Object[i13];
        this.f3798d = objArr2;
        ?? r52 = i11 == i12 ? 1 : 0;
        this.f3799e = r52;
        objArr2[0] = objArr;
        l(i11 - r52, 1);
    }

    private final Object j() {
        int e11 = e() & 31;
        Object obj = this.f3798d[this.f3797c - 1];
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return ((Object[]) obj)[e11];
    }

    private final void l(int i11, int i12) {
        int i13 = (this.f3797c - i12) * 5;
        while (i12 < this.f3797c) {
            Object[] objArr = this.f3798d;
            Object obj = objArr[i12 - 1];
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i12] = ((Object[]) obj)[j.a(i11, i13)];
            i13 -= 5;
            i12++;
        }
    }

    private final void m(int i11) {
        int i12 = 0;
        while (j.a(e(), i12) == i11) {
            i12 += 5;
        }
        if (i12 > 0) {
            l(e(), ((this.f3797c - 1) - (i12 / 5)) + 1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final void n(Object[] objArr, int i11, int i12, int i13) {
        h(i11);
        i(i12);
        this.f3797c = i13;
        if (this.f3798d.length < i13) {
            this.f3798d = new Object[i13];
        }
        this.f3798d[0] = objArr;
        ?? r02 = i11 == i12 ? 1 : 0;
        this.f3799e = r02;
        l(i11 - r02, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object j11 = j();
        h(e() + 1);
        if (e() == f()) {
            this.f3799e = true;
            return j11;
        }
        m(0);
        return j11;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        h(e() - 1);
        if (this.f3799e) {
            this.f3799e = false;
            return j();
        }
        m(31);
        return j();
    }
}
