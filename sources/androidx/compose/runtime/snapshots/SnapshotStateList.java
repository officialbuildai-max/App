package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.o1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import t.f;

/* loaded from: classes.dex */
public final class SnapshotStateList implements c0, List, RandomAccess, KMutableList {

    /* renamed from: a, reason: collision with root package name */
    private e0 f4009a;

    /* loaded from: classes.dex */
    public static final class a extends e0 {

        /* renamed from: c, reason: collision with root package name */
        private t.f f4010c;

        /* renamed from: d, reason: collision with root package name */
        private int f4011d;

        /* renamed from: e, reason: collision with root package name */
        private int f4012e;

        public a(t.f fVar) {
            this.f4010c = fVar;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(e0 e0Var) {
            Object obj;
            obj = s.f4093a;
            synchronized (obj) {
                Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
                this.f4010c = ((a) e0Var).f4010c;
                this.f4011d = ((a) e0Var).f4011d;
                this.f4012e = ((a) e0Var).f4012e;
                Unit unit = Unit.f67184a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public e0 d() {
            return new a(this.f4010c);
        }

        public final t.f i() {
            return this.f4010c;
        }

        public final int j() {
            return this.f4011d;
        }

        public final int k() {
            return this.f4012e;
        }

        public final void l(t.f fVar) {
            this.f4010c = fVar;
        }

        public final void m(int i11) {
            this.f4011d = i11;
        }

        public final void n(int i11) {
            this.f4012e = i11;
        }
    }

    public SnapshotStateList() {
        t.f b11 = t.a.b();
        a aVar = new a(b11);
        if (j.f4079e.e()) {
            a aVar2 = new a(b11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.f4009a = aVar;
    }

    private final boolean f(Function1 function1) {
        Object obj;
        int j11;
        t.f i11;
        Object invoke;
        j c11;
        Object obj2;
        boolean z10;
        do {
            obj = s.f4093a;
            synchronized (obj) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i11 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            f.a builder = i11.builder();
            invoke = function1.invoke(builder);
            t.f build = builder.build();
            if (Intrinsics.c(build, i11)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj2 = s.f4093a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.l(build);
                        z10 = true;
                        aVar3.m(aVar3.j() + 1);
                        aVar3.n(aVar3.k() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return ((Boolean) invoke).booleanValue();
    }

    public final a a() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (a) SnapshotKt.X((a) firstStateRecord, this);
    }

    @Override // java.util.List
    public void add(int i11, Object obj) {
        Object obj2;
        int j11;
        t.f i12;
        j c11;
        Object obj3;
        boolean z10;
        do {
            obj2 = s.f4093a;
            synchronized (obj2) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i12 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i12);
            t.f add = i12.add(i11, obj);
            if (Intrinsics.c(add, i12)) {
                return;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj3 = s.f4093a;
                synchronized (obj3) {
                    if (aVar3.j() == j11) {
                        aVar3.l(add);
                        z10 = true;
                        aVar3.n(aVar3.k() + 1);
                        aVar3.m(aVar3.j() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        Object obj2;
        int j11;
        t.f i11;
        boolean z10;
        j c11;
        Object obj3;
        do {
            obj2 = s.f4093a;
            synchronized (obj2) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i11 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            t.f add = i11.add(obj);
            z10 = false;
            if (Intrinsics.c(add, i11)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj3 = s.f4093a;
                synchronized (obj3) {
                    if (aVar3.j() == j11) {
                        aVar3.l(add);
                        aVar3.n(aVar3.k() + 1);
                        aVar3.m(aVar3.j() + 1);
                        z10 = true;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int i11, final Collection collection) {
        return f(new Function1<List<Object>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<Object> list) {
                return Boolean.valueOf(list.addAll(i11, collection));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        Object obj;
        int j11;
        t.f i11;
        boolean z10;
        j c11;
        Object obj2;
        do {
            obj = s.f4093a;
            synchronized (obj) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i11 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            t.f addAll = i11.addAll(collection);
            z10 = false;
            if (Intrinsics.c(addAll, i11)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj2 = s.f4093a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.l(addAll);
                        aVar3.n(aVar3.k() + 1);
                        aVar3.m(aVar3.j() + 1);
                        z10 = true;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return true;
    }

    public int c() {
        return a().i().size();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        j c11;
        Object obj;
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        a aVar = (a) firstStateRecord;
        SnapshotKt.J();
        synchronized (SnapshotKt.I()) {
            c11 = j.f4079e.c();
            a aVar2 = (a) SnapshotKt.h0(aVar, this, c11);
            obj = s.f4093a;
            synchronized (obj) {
                aVar2.l(t.a.b());
                aVar2.m(aVar2.j() + 1);
                aVar2.n(aVar2.k() + 1);
            }
        }
        SnapshotKt.Q(c11, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return a().i().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return a().i().containsAll(collection);
    }

    public final int e() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((a) SnapshotKt.F((a) firstStateRecord)).k();
    }

    @Override // java.util.List
    public Object get(int i11) {
        return a().i().get(i11);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public e0 getFirstStateRecord() {
        return this.f4009a;
    }

    public Object h(int i11) {
        Object obj;
        int j11;
        t.f i12;
        j c11;
        Object obj2;
        boolean z10;
        Object obj3 = get(i11);
        do {
            obj = s.f4093a;
            synchronized (obj) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i12 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i12);
            t.f d11 = i12.d(i11);
            if (Intrinsics.c(d11, i12)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj2 = s.f4093a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.l(d11);
                        z10 = true;
                        aVar3.n(aVar3.k() + 1);
                        aVar3.m(aVar3.j() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return obj3;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return a().i().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return a().i().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    public final void j(int i11, int i12) {
        Object obj;
        int j11;
        t.f i13;
        j c11;
        Object obj2;
        boolean z10;
        do {
            obj = s.f4093a;
            synchronized (obj) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i13 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i13);
            f.a builder = i13.builder();
            builder.subList(i11, i12).clear();
            t.f build = builder.build();
            if (Intrinsics.c(build, i13)) {
                return;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj2 = s.f4093a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.l(build);
                        z10 = true;
                        aVar3.m(aVar3.j() + 1);
                        aVar3.n(aVar3.k() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
    }

    public final int l(Collection collection, int i11, int i12) {
        Object obj;
        int j11;
        t.f i13;
        j c11;
        Object obj2;
        boolean z10;
        int size = size();
        do {
            obj = s.f4093a;
            synchronized (obj) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i13 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i13);
            f.a builder = i13.builder();
            builder.subList(i11, i12).retainAll(collection);
            t.f build = builder.build();
            if (Intrinsics.c(build, i13)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj2 = s.f4093a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.l(build);
                        z10 = true;
                        aVar3.m(aVar3.j() + 1);
                        aVar3.n(aVar3.k() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return size - size();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return a().i().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new w(this, 0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i11) {
        return new w(this, i11);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public /* synthetic */ e0 mergeRecords(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        return b0.a(this, e0Var, e0Var2, e0Var3);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(e0 e0Var) {
        e0Var.g(getFirstStateRecord());
        Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.f4009a = (a) e0Var;
    }

    @Override // java.util.List
    public final /* bridge */ Object remove(int i11) {
        return h(i11);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        Object obj2;
        int j11;
        t.f i11;
        boolean z10;
        j c11;
        Object obj3;
        do {
            obj2 = s.f4093a;
            synchronized (obj2) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i11 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            t.f remove = i11.remove(obj);
            z10 = false;
            if (Intrinsics.c(remove, i11)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj3 = s.f4093a;
                synchronized (obj3) {
                    if (aVar3.j() == j11) {
                        aVar3.l(remove);
                        aVar3.n(aVar3.k() + 1);
                        aVar3.m(aVar3.j() + 1);
                        z10 = true;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        Object obj;
        int j11;
        t.f i11;
        boolean z10;
        j c11;
        Object obj2;
        do {
            obj = s.f4093a;
            synchronized (obj) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i11 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i11);
            t.f removeAll = i11.removeAll(collection);
            z10 = false;
            if (Intrinsics.c(removeAll, i11)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj2 = s.f4093a;
                synchronized (obj2) {
                    if (aVar3.j() == j11) {
                        aVar3.l(removeAll);
                        aVar3.n(aVar3.k() + 1);
                        aVar3.m(aVar3.j() + 1);
                        z10 = true;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection collection) {
        return f(new Function1<List<Object>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<Object> list) {
                return Boolean.valueOf(list.retainAll(collection));
            }
        });
    }

    @Override // java.util.List
    public Object set(int i11, Object obj) {
        Object obj2;
        int j11;
        t.f i12;
        j c11;
        Object obj3;
        boolean z10;
        Object obj4 = get(i11);
        do {
            obj2 = s.f4093a;
            synchronized (obj2) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                j11 = aVar.j();
                i12 = aVar.i();
                Unit unit = Unit.f67184a;
            }
            Intrinsics.e(i12);
            t.f fVar = i12.set(i11, obj);
            if (Intrinsics.c(fVar, i12)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                c11 = j.f4079e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, c11);
                obj3 = s.f4093a;
                synchronized (obj3) {
                    if (aVar3.j() == j11) {
                        aVar3.l(fVar);
                        z10 = true;
                        aVar3.m(aVar3.j() + 1);
                    } else {
                        z10 = false;
                    }
                }
            }
            SnapshotKt.Q(c11, this);
        } while (!z10);
        return obj4;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return c();
    }

    @Override // java.util.List
    public List subList(int i11, int i12) {
        if (!(i11 >= 0 && i11 <= i12 && i12 <= size())) {
            o1.a("fromIndex or toIndex are out of bounds");
        }
        return new f0(this, i11, i12);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }

    public String toString() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((a) SnapshotKt.F((a) firstStateRecord)).i() + ")@" + hashCode();
    }
}
