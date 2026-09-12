package androidx.compose.runtime.snapshots;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z extends y implements Iterator, KMutableIterator {
    public z(t tVar, Iterator it) {
        super(tVar, it);
    }

    @Override // java.util.Iterator
    public Object next() {
        Map.Entry i11 = i();
        if (i11 == null) {
            throw new IllegalStateException();
        }
        e();
        return i11.getKey();
    }
}
