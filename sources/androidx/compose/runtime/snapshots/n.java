package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import t.g;

/* loaded from: classes.dex */
final class n extends p {
    public n(t tVar) {
        super(tVar);
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) e((Map.Entry) obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) f(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (TypeIntrinsics.m(obj)) {
            return h((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Void e(Map.Entry entry) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public Void f(Collection collection) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public boolean h(Map.Entry entry) {
        return Intrinsics.c(a().get(entry.getKey()), entry.getValue());
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new x(a(), ((t.e) a().f().i().entrySet()).iterator());
    }

    public boolean j(Map.Entry entry) {
        return a().remove(entry.getKey()) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (TypeIntrinsics.m(obj)) {
            return j((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (a().remove(((Map.Entry) it.next()).getKey()) != null || z10) {
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
        Collection<Map.Entry> collection2 = collection;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(collection2, 10)), 16));
        for (Map.Entry entry : collection2) {
            Pair a11 = TuplesKt.a(entry.getKey(), entry.getValue());
            linkedHashMap.put(a11.getFirst(), a11.getSecond());
        }
        t a12 = a();
        boolean z11 = false;
        do {
            obj = u.f4100a;
            synchronized (obj) {
                e0 firstStateRecord = a12.getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                t.a aVar = (t.a) SnapshotKt.F((t.a) firstStateRecord);
                i11 = aVar.i();
                j11 = aVar.j();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            g.a builder = i11.builder();
            Iterator it = a12.entrySet().iterator();
            while (true) {
                z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry2 = (Map.Entry) it.next();
                if (!linkedHashMap.containsKey(entry2.getKey()) || !Intrinsics.c(linkedHashMap.get(entry2.getKey()), entry2.getValue())) {
                    builder.remove(entry2.getKey());
                    z11 = true;
                }
            }
            Unit unit2 = Unit.f67184a;
            t.g build = builder.build();
            if (Intrinsics.c(build, i11)) {
                break;
            }
            e0 firstStateRecord2 = a12.getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            t.a aVar2 = (t.a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                t.a aVar3 = (t.a) SnapshotKt.h0(aVar2, a12, c11);
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
            SnapshotKt.Q(c11, a12);
        } while (!z10);
        return z11;
    }
}
