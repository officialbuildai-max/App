package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t.g;

/* loaded from: classes.dex */
final class o extends p {
    public o(t tVar) {
        super(tVar);
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) e(obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) f(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return a().containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!a().containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Void e(Object obj) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public Void f(Collection collection) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public z iterator() {
        return new z(a(), ((t.e) a().f().i().entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return a().remove(obj) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (a().remove(it.next()) != null || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        Object obj;
        t.g i11;
        int j11;
        boolean z10;
        j c11;
        Object obj2;
        Set W0 = CollectionsKt.W0(collection);
        t a11 = a();
        boolean z11 = false;
        do {
            obj = u.f4100a;
            synchronized (obj) {
                e0 firstStateRecord = a11.getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                t.a aVar = (t.a) SnapshotKt.F((t.a) firstStateRecord);
                i11 = aVar.i();
                j11 = aVar.j();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            g.a builder = i11.builder();
            Iterator it = a11.entrySet().iterator();
            while (true) {
                z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (!W0.contains(entry.getKey())) {
                    builder.remove(entry.getKey());
                    z11 = true;
                }
            }
            Unit unit2 = Unit.f67184a;
            t.g build = builder.build();
            if (Intrinsics.c(build, i11)) {
                break;
            }
            e0 firstStateRecord2 = a11.getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            t.a aVar2 = (t.a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                t.a aVar3 = (t.a) SnapshotKt.h0(aVar2, a11, c11);
                obj2 = u.f4100a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.k(build);
                        aVar3.l(aVar3.j() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, a11);
        } while (!z10);
        return z11;
    }
}
