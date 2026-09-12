package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import androidx.view.LiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class InvalidationTracker {

    /* renamed from: o, reason: collision with root package name */
    public static final a f14526o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f14527a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f14528b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f14529c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f14530d;

    /* renamed from: e, reason: collision with root package name */
    private final TriggerBasedInvalidationTracker f14531e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f14532f;

    /* renamed from: g, reason: collision with root package name */
    private final ReentrantLock f14533g;

    /* renamed from: h, reason: collision with root package name */
    private AutoCloser f14534h;

    /* renamed from: i, reason: collision with root package name */
    private final Function0 f14535i;

    /* renamed from: j, reason: collision with root package name */
    private final Function0 f14536j;

    /* renamed from: k, reason: collision with root package name */
    private final k f14537k;

    /* renamed from: l, reason: collision with root package name */
    private Intent f14538l;

    /* renamed from: m, reason: collision with root package name */
    private MultiInstanceInvalidationClient f14539m;

    /* renamed from: n, reason: collision with root package name */
    private final Object f14540n;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f14541a;

        public b(String[] tables) {
            Intrinsics.h(tables, "tables");
            this.f14541a = tables;
        }

        public final String[] a() {
            return this.f14541a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set set);
    }

    public InvalidationTracker(RoomDatabase database, Map shadowTablesMap, Map viewTables, String... tableNames) {
        Intrinsics.h(database, "database");
        Intrinsics.h(shadowTablesMap, "shadowTablesMap");
        Intrinsics.h(viewTables, "viewTables");
        Intrinsics.h(tableNames, "tableNames");
        this.f14527a = database;
        this.f14528b = shadowTablesMap;
        this.f14529c = viewTables;
        this.f14530d = tableNames;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(database, shadowTablesMap, viewTables, tableNames, database.J(), new InvalidationTracker$implementation$1(this));
        this.f14531e = triggerBasedInvalidationTracker;
        this.f14532f = new LinkedHashMap();
        this.f14533g = new ReentrantLock();
        this.f14535i = new Function0() { // from class: androidx.room.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit w11;
                w11 = InvalidationTracker.w(InvalidationTracker.this);
                return w11;
            }
        };
        this.f14536j = new Function0() { // from class: androidx.room.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit v11;
                v11 = InvalidationTracker.v(InvalidationTracker.this);
                return v11;
            }
        };
        this.f14537k = new k(database);
        this.f14540n = new Object();
        triggerBasedInvalidationTracker.u(new Function0() { // from class: androidx.room.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean d11;
                d11 = InvalidationTracker.d(InvalidationTracker.this);
                return Boolean.valueOf(d11);
            }
        });
    }

    private final boolean A(b bVar) {
        ReentrantLock reentrantLock = this.f14533g;
        reentrantLock.lock();
        try {
            o oVar = (o) this.f14532f.remove(bVar);
            return oVar != null && this.f14531e.q(oVar.b());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.f14527a.K() || invalidationTracker.f14527a.T();
    }

    private final boolean i(b bVar) {
        Pair y10 = this.f14531e.y(bVar.a());
        String[] strArr = (String[]) y10.component1();
        int[] iArr = (int[]) y10.component2();
        o oVar = new o(bVar, iArr, strArr);
        ReentrantLock reentrantLock = this.f14533g;
        reentrantLock.lock();
        try {
            o oVar2 = this.f14532f.containsKey(bVar) ? (o) MapsKt.i(this.f14532f, bVar) : (o) this.f14532f.put(bVar, oVar);
            reentrantLock.unlock();
            return oVar2 == null && this.f14531e.p(iArr);
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    private final List n() {
        ReentrantLock reentrantLock = this.f14533g;
        reentrantLock.lock();
        try {
            return CollectionsKt.R0(this.f14532f.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Set set) {
        ReentrantLock reentrantLock = this.f14533g;
        reentrantLock.lock();
        try {
            List R0 = CollectionsKt.R0(this.f14532f.values());
            reentrantLock.unlock();
            Iterator it = R0.iterator();
            while (it.hasNext()) {
                ((o) it.next()).c(set);
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        synchronized (this.f14540n) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f14539m;
                if (multiInstanceInvalidationClient != null) {
                    List n11 = n();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : n11) {
                        if (!((b) obj).b()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.l();
                    }
                }
                this.f14531e.s();
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.f14534h;
        if (autoCloser != null) {
            autoCloser.g();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.f14534h;
        if (autoCloser != null) {
            autoCloser.j();
        }
        return Unit.f67184a;
    }

    public final void B(AutoCloser autoCloser) {
        Intrinsics.h(autoCloser, "autoCloser");
        this.f14534h = autoCloser;
        autoCloser.n(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void C() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f14539m;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.l();
        }
    }

    public final Object D(Continuation continuation) {
        Object x10;
        return ((!this.f14527a.K() || this.f14527a.T()) && (x10 = this.f14531e.x(continuation)) == IntrinsicsKt.f()) ? x10 : Unit.f67184a;
    }

    public final void E() {
        RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$syncBlocking$1(this, null));
    }

    public void h(b observer) {
        Intrinsics.h(observer, "observer");
        if (i(observer)) {
            RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$addObserver$1(this, null));
        }
    }

    public final void j(b observer) {
        Intrinsics.h(observer, "observer");
        if (!observer.b()) {
            throw new IllegalStateException("isRemote was false of observer argument");
        }
        i(observer);
    }

    public void k(b observer) {
        Intrinsics.h(observer, "observer");
        h(new s0(this, observer));
    }

    public final kotlinx.coroutines.flow.b l(String[] tables, boolean z10) {
        Intrinsics.h(tables, "tables");
        Pair y10 = this.f14531e.y(tables);
        String[] strArr = (String[]) y10.component1();
        kotlinx.coroutines.flow.b m11 = this.f14531e.m(strArr, (int[]) y10.component2(), z10);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f14539m;
        kotlinx.coroutines.flow.b h11 = multiInstanceInvalidationClient != null ? multiInstanceInvalidationClient.h(strArr) : null;
        return h11 != null ? kotlinx.coroutines.flow.d.y(m11, h11) : m11;
    }

    public final LiveData m(String[] tableNames, boolean z10, Function1 computeFunction) {
        Intrinsics.h(tableNames, "tableNames");
        Intrinsics.h(computeFunction, "computeFunction");
        this.f14531e.y(tableNames);
        return this.f14537k.a(tableNames, z10, computeFunction);
    }

    public final RoomDatabase o() {
        return this.f14527a;
    }

    public final String[] p() {
        return this.f14530d;
    }

    public final void q(Context context, String name, Intent serviceIntent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(name, "name");
        Intrinsics.h(serviceIntent, "serviceIntent");
        this.f14538l = serviceIntent;
        this.f14539m = new MultiInstanceInvalidationClient(context, name, this);
    }

    public final void r(z3.b connection) {
        Intrinsics.h(connection, "connection");
        this.f14531e.l(connection);
        synchronized (this.f14540n) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f14539m;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.f14538l;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.k(intent);
                    Unit unit = Unit.f67184a;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void t(Set tables) {
        Intrinsics.h(tables, "tables");
        ReentrantLock reentrantLock = this.f14533g;
        reentrantLock.lock();
        try {
            List<o> R0 = CollectionsKt.R0(this.f14532f.values());
            reentrantLock.unlock();
            for (o oVar : R0) {
                if (!oVar.a().b()) {
                    oVar.d(tables);
                }
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final void x() {
        this.f14531e.r(this.f14535i, this.f14536j);
    }

    public void y() {
        this.f14531e.r(this.f14535i, this.f14536j);
    }

    public void z(b observer) {
        Intrinsics.h(observer, "observer");
        if (A(observer)) {
            RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$removeObserver$1(this, null));
        }
    }
}
