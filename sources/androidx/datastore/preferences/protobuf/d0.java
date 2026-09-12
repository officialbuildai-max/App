package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.List;

/* loaded from: classes.dex */
final class d0 implements c0 {
    static w.d d(Object obj, long j11) {
        return (w.d) k1.G(obj, j11);
    }

    @Override // androidx.datastore.preferences.protobuf.c0
    public void a(Object obj, long j11) {
        d(obj, j11).makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.c0
    public void b(Object obj, Object obj2, long j11) {
        w.d d11 = d(obj, j11);
        w.d d12 = d(obj2, j11);
        int size = d11.size();
        int size2 = d12.size();
        if (size > 0 && size2 > 0) {
            if (!d11.isModifiable()) {
                d11 = d11.mutableCopyWithCapacity(size2 + size);
            }
            d11.addAll(d12);
        }
        if (size > 0) {
            d12 = d11;
        }
        k1.W(obj, j11, d12);
    }

    @Override // androidx.datastore.preferences.protobuf.c0
    public List c(Object obj, long j11) {
        w.d d11 = d(obj, j11);
        if (d11.isModifiable()) {
            return d11;
        }
        int size = d11.size();
        w.d mutableCopyWithCapacity = d11.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        k1.W(obj, j11, mutableCopyWithCapacity);
        return mutableCopyWithCapacity;
    }
}
