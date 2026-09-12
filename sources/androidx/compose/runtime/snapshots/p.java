package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class p implements Set, KMutableSet {

    /* renamed from: a, reason: collision with root package name */
    private final t f4092a;

    public p(t tVar) {
        this.f4092a = tVar;
    }

    public final t a() {
        return this.f4092a;
    }

    public int c() {
        return this.f4092a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f4092a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f4092a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return c();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }
}
