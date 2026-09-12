package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import t.g;

/* loaded from: classes.dex */
public final class t implements c0, Map, KMutableMap {

    /* renamed from: a, reason: collision with root package name */
    private e0 f4094a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f4095b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f4096c;

    /* renamed from: d, reason: collision with root package name */
    private final Collection f4097d;

    /* loaded from: classes.dex */
    public static final class a extends e0 {

        /* renamed from: c, reason: collision with root package name */
        private t.g f4098c;

        /* renamed from: d, reason: collision with root package name */
        private int f4099d;

        public a(t.g gVar) {
            this.f4098c = gVar;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(e0 e0Var) {
            Object obj;
            Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
            a aVar = (a) e0Var;
            obj = u.f4100a;
            synchronized (obj) {
                this.f4098c = aVar.f4098c;
                this.f4099d = aVar.f4099d;
                Unit unit = Unit.f67184a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public e0 d() {
            return new a(this.f4098c);
        }

        public final t.g i() {
            return this.f4098c;
        }

        public final int j() {
            return this.f4099d;
        }

        public final void k(t.g gVar) {
            this.f4098c = gVar;
        }

        public final void l(int i11) {
            this.f4099d = i11;
        }
    }

    public t() {
        t.g a11 = t.a.a();
        a aVar = new a(a11);
        if (j.f4079e.e()) {
            a aVar2 = new a(a11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.f4094a = aVar;
        this.f4095b = new n(this);
        this.f4096c = new o(this);
        this.f4097d = new q(this);
    }

    public Set a() {
        return this.f4095b;
    }

    public Set c() {
        return this.f4096c;
    }

    @Override // java.util.Map
    public void clear() {
        j c11;
        Object obj;
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        a aVar = (a) SnapshotKt.F((a) firstStateRecord);
        aVar.i();
        t.g a11 = t.a.a();
        if (a11 != aVar.i()) {
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj = u.f4100a;
                synchronized (obj) {
                    aVar3.k(a11);
                    aVar3.l(aVar3.j() + 1);
                }
            }
            SnapshotKt.Q(c11, this);
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return f().i().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return f().i().containsValue(obj);
    }

    public final int e() {
        return f().j();
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return a();
    }

    public final a f() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (a) SnapshotKt.X((a) firstStateRecord, this);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return f().i().get(obj);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public e0 getFirstStateRecord() {
        return this.f4094a;
    }

    public int h() {
        return f().i().size();
    }

    public Collection i() {
        return this.f4097d;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return f().i().isEmpty();
    }

    public final boolean j(Object obj) {
        Object obj2;
        Iterator it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.c(((Map.Entry) obj2).getValue(), obj)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj2;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return c();
    }

    public final Map l() {
        return f().i();
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public /* synthetic */ e0 mergeRecords(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        return b0.a(this, e0Var, e0Var2, e0Var3);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(e0 e0Var) {
        Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        this.f4094a = (a) e0Var;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        Object obj3;
        t.g i11;
        int j11;
        Object put;
        j c11;
        Object obj4;
        boolean z10;
        do {
            obj3 = u.f4100a;
            synchronized (obj3) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                i11 = aVar.i();
                j11 = aVar.j();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            g.a builder = i11.builder();
            put = builder.put(obj, obj2);
            t.g build = builder.build();
            if (Intrinsics.c(build, i11)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj4 = u.f4100a;
                synchronized (obj4) {
                    if (aVar3.j() == j11) {
                        aVar3.k(build);
                        z10 = true;
                        aVar3.l(aVar3.j() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return put;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        Object obj;
        t.g i11;
        int j11;
        j c11;
        Object obj2;
        boolean z10;
        do {
            obj = u.f4100a;
            synchronized (obj) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                i11 = aVar.i();
                j11 = aVar.j();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            g.a builder = i11.builder();
            builder.putAll(map);
            t.g build = builder.build();
            if (Intrinsics.c(build, i11)) {
                return;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj2 = u.f4100a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.k(build);
                        z10 = true;
                        aVar3.l(aVar3.j() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        Object obj2;
        t.g i11;
        int j11;
        Object remove;
        j c11;
        Object obj3;
        boolean z10;
        do {
            obj2 = u.f4100a;
            synchronized (obj2) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                i11 = aVar.i();
                j11 = aVar.j();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            g.a builder = i11.builder();
            remove = builder.remove(obj);
            t.g build = builder.build();
            if (Intrinsics.c(build, i11)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj3 = u.f4100a;
                synchronized (obj3) {
                    if (aVar3.j() == j11) {
                        aVar3.k(build);
                        z10 = true;
                        aVar3.l(aVar3.j() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return remove;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return h();
    }

    public String toString() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return "SnapshotStateMap(value=" + ((a) SnapshotKt.F((a) firstStateRecord)).i() + ")@" + hashCode();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return i();
    }
}
