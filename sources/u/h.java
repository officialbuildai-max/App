package u;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class h extends a {

    /* renamed from: a, reason: collision with root package name */
    private final f f76632a;

    public h(f fVar) {
        this.f76632a = fVar;
    }

    @Override // u.a
    public boolean c(Map.Entry entry) {
        Object obj = this.f76632a.get(entry.getKey());
        return obj != null ? Intrinsics.c(obj, entry.getValue()) : entry.getValue() == null && this.f76632a.containsKey(entry.getKey());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f76632a.clear();
    }

    @Override // u.a
    public boolean f(Map.Entry entry) {
        return this.f76632a.remove(entry.getKey(), entry.getValue());
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.f76632a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry entry) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new i(this.f76632a);
    }
}
