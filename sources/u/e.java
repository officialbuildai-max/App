package u;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes2.dex */
public abstract class e implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final u[] f76619a;

    /* renamed from: b, reason: collision with root package name */
    private int f76620b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f76621c = true;

    public e(t tVar, u[] uVarArr) {
        this.f76619a = uVarArr;
        uVarArr[0].m(tVar.p(), tVar.m() * 2);
        this.f76620b = 0;
        e();
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void e() {
        if (this.f76619a[this.f76620b].h()) {
            return;
        }
        for (int i11 = this.f76620b; -1 < i11; i11--) {
            int h11 = h(i11);
            if (h11 == -1 && this.f76619a[i11].i()) {
                this.f76619a[i11].l();
                h11 = h(i11);
            }
            if (h11 != -1) {
                this.f76620b = h11;
                return;
            }
            if (i11 > 0) {
                this.f76619a[i11 - 1].l();
            }
            this.f76619a[i11].m(t.f76639e.a().p(), 0);
        }
        this.f76621c = false;
    }

    private final int h(int i11) {
        if (this.f76619a[i11].h()) {
            return i11;
        }
        if (!this.f76619a[i11].i()) {
            return -1;
        }
        t c11 = this.f76619a[i11].c();
        if (i11 == 6) {
            this.f76619a[i11 + 1].m(c11.p(), c11.p().length);
        } else {
            this.f76619a[i11 + 1].m(c11.p(), c11.m() * 2);
        }
        return h(i11 + 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object c() {
        a();
        return this.f76619a[this.f76620b].a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u[] f() {
        return this.f76619a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f76621c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(int i11) {
        this.f76620b = i11;
    }

    @Override // java.util.Iterator
    public Object next() {
        a();
        Object next = this.f76619a[this.f76620b].next();
        e();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
