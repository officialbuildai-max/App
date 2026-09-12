package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

/* loaded from: classes.dex */
public final class g extends a {

    /* renamed from: c, reason: collision with root package name */
    private final Object f3792c;

    public g(Object obj, int i11) {
        super(i11, 1);
        this.f3792c = obj;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        a();
        h(e() + 1);
        return this.f3792c;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        c();
        h(e() - 1);
        return this.f3792c;
    }
}
