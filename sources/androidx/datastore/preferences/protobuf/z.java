package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
class z implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private Iterator f9019a;

    public z(Iterator it) {
        this.f9019a = it;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f9019a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9019a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f9019a.remove();
    }
}
