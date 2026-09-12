package u;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes2.dex */
public abstract class u implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f76648a = t.f76639e.a().p();

    /* renamed from: b, reason: collision with root package name */
    private int f76649b;

    /* renamed from: c, reason: collision with root package name */
    private int f76650c;

    public final Object a() {
        w.a.a(h());
        return this.f76648a[this.f76650c];
    }

    public final t c() {
        w.a.a(i());
        Object obj = this.f76648a[this.f76650c];
        Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (t) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object[] e() {
        return this.f76648a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        return this.f76650c;
    }

    public final boolean h() {
        return this.f76650c < this.f76649b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return h();
    }

    public final boolean i() {
        w.a.a(this.f76650c >= this.f76649b);
        return this.f76650c < this.f76648a.length;
    }

    public final void j() {
        w.a.a(h());
        this.f76650c += 2;
    }

    public final void l() {
        w.a.a(i());
        this.f76650c++;
    }

    public final void m(Object[] objArr, int i11) {
        n(objArr, i11, 0);
    }

    public final void n(Object[] objArr, int i11, int i12) {
        this.f76648a = objArr;
        this.f76649b = i11;
        this.f76650c = i12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(int i11) {
        this.f76650c = i11;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
