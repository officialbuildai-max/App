package u;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes2.dex */
public final class i implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    private final g f76633a;

    public i(f fVar) {
        u[] uVarArr = new u[8];
        for (int i11 = 0; i11 < 8; i11++) {
            uVarArr[i11] = new y(this);
        }
        this.f76633a = new g(fVar, uVarArr);
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        return (Map.Entry) this.f76633a.next();
    }

    public final void c(Object obj, Object obj2) {
        this.f76633a.n(obj, obj2);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f76633a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f76633a.remove();
    }
}
