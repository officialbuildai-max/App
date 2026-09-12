package androidx.room;

import a4.e;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.room.support.AutoCloser;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public abstract class RoomDatabase {

    /* renamed from: o, reason: collision with root package name */
    public static final c f14571o = new c(null);

    /* renamed from: a, reason: collision with root package name */
    protected volatile a4.d f14572a;

    /* renamed from: b, reason: collision with root package name */
    private kotlinx.coroutines.n0 f14573b;

    /* renamed from: c, reason: collision with root package name */
    private CoroutineContext f14574c;

    /* renamed from: d, reason: collision with root package name */
    private Executor f14575d;

    /* renamed from: e, reason: collision with root package name */
    private Executor f14576e;

    /* renamed from: f, reason: collision with root package name */
    private s f14577f;

    /* renamed from: g, reason: collision with root package name */
    private InvalidationTracker f14578g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f14580i;

    /* renamed from: j, reason: collision with root package name */
    protected List f14581j;

    /* renamed from: k, reason: collision with root package name */
    private AutoCloser f14582k;

    /* renamed from: h, reason: collision with root package name */
    private final x3.a f14579h = new x3.a(new RoomDatabase$closeBarrier$1(this));

    /* renamed from: l, reason: collision with root package name */
    private final ThreadLocal f14583l = new ThreadLocal();

    /* renamed from: m, reason: collision with root package name */
    private final Map f14584m = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name */
    private boolean f14585n = true;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "<init>", "(Ljava/lang/String;I)V", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime_release", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class JournalMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ JournalMode[] $VALUES;
        public static final JournalMode AUTOMATIC = new JournalMode("AUTOMATIC", 0);
        public static final JournalMode TRUNCATE = new JournalMode("TRUNCATE", 1);
        public static final JournalMode WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        static {
            JournalMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private JournalMode(String str, int i11) {
        }

        public static EnumEntries<JournalMode> getEntries() {
            return $ENTRIES;
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        public final JournalMode resolve$room_runtime_release(Context context) {
            Intrinsics.h(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CoroutineContext A;
        private boolean B;

        /* renamed from: a, reason: collision with root package name */
        private final KClass f14586a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f14587b;

        /* renamed from: c, reason: collision with root package name */
        private final String f14588c;

        /* renamed from: d, reason: collision with root package name */
        private final Function0 f14589d;

        /* renamed from: e, reason: collision with root package name */
        private final List f14590e;

        /* renamed from: f, reason: collision with root package name */
        private e f14591f;

        /* renamed from: g, reason: collision with root package name */
        private final List f14592g;

        /* renamed from: h, reason: collision with root package name */
        private Executor f14593h;

        /* renamed from: i, reason: collision with root package name */
        private Executor f14594i;

        /* renamed from: j, reason: collision with root package name */
        private e.c f14595j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f14596k;

        /* renamed from: l, reason: collision with root package name */
        private JournalMode f14597l;

        /* renamed from: m, reason: collision with root package name */
        private Intent f14598m;

        /* renamed from: n, reason: collision with root package name */
        private long f14599n;

        /* renamed from: o, reason: collision with root package name */
        private TimeUnit f14600o;

        /* renamed from: p, reason: collision with root package name */
        private final d f14601p;

        /* renamed from: q, reason: collision with root package name */
        private Set f14602q;

        /* renamed from: r, reason: collision with root package name */
        private final Set f14603r;

        /* renamed from: s, reason: collision with root package name */
        private final List f14604s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f14605t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f14606u;

        /* renamed from: v, reason: collision with root package name */
        private boolean f14607v;

        /* renamed from: w, reason: collision with root package name */
        private String f14608w;

        /* renamed from: x, reason: collision with root package name */
        private File f14609x;

        /* renamed from: y, reason: collision with root package name */
        private Callable f14610y;

        /* renamed from: z, reason: collision with root package name */
        private z3.c f14611z;

        public a(Context context, Class klass, String str) {
            Intrinsics.h(context, "context");
            Intrinsics.h(klass, "klass");
            this.f14590e = new ArrayList();
            this.f14592g = new ArrayList();
            this.f14597l = JournalMode.AUTOMATIC;
            this.f14599n = -1L;
            this.f14601p = new d();
            this.f14602q = new LinkedHashSet();
            this.f14603r = new LinkedHashSet();
            this.f14604s = new ArrayList();
            this.f14605t = true;
            this.B = true;
            this.f14586a = JvmClassMappingKt.c(klass);
            this.f14587b = context;
            this.f14588c = str;
            this.f14589d = null;
        }

        public a a(b callback) {
            Intrinsics.h(callback, "callback");
            this.f14590e.add(callback);
            return this;
        }

        public a b(y3.c... migrations) {
            Intrinsics.h(migrations, "migrations");
            for (y3.c cVar : migrations) {
                this.f14603r.add(Integer.valueOf(cVar.f78946a));
                this.f14603r.add(Integer.valueOf(cVar.f78947b));
            }
            this.f14601p.b((y3.c[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        public a c() {
            this.f14596k = true;
            return this;
        }

        public RoomDatabase d() {
            e.c cVar;
            e.c cVar2;
            RoomDatabase roomDatabase;
            Executor executor = this.f14593h;
            if (executor == null && this.f14594i == null) {
                Executor g11 = j.c.g();
                this.f14594i = g11;
                this.f14593h = g11;
            } else if (executor != null && this.f14594i == null) {
                this.f14594i = executor;
            } else if (executor == null) {
                this.f14593h = this.f14594i;
            }
            z.b(this.f14603r, this.f14602q);
            z3.c cVar3 = this.f14611z;
            if (cVar3 == null && this.f14595j == null) {
                cVar = new b4.h();
            } else if (cVar3 == null) {
                cVar = this.f14595j;
            } else {
                if (this.f14595j != null) {
                    throw new IllegalArgumentException("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                }
                cVar = null;
            }
            boolean z10 = this.f14599n > 0;
            boolean z11 = (this.f14608w == null && this.f14609x == null && this.f14610y == null) ? false : true;
            if (cVar != null) {
                if (z10) {
                    if (this.f14588c == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j11 = this.f14599n;
                    TimeUnit timeUnit = this.f14600o;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    cVar = new androidx.room.support.l(cVar, new AutoCloser(j11, timeUnit, null, 4, null));
                }
                if (z11) {
                    if (this.f14588c == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    String str = this.f14608w;
                    int i11 = str == null ? 0 : 1;
                    File file = this.f14609x;
                    int i12 = file == null ? 0 : 1;
                    Callable callable = this.f14610y;
                    if (i11 + i12 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    cVar = new androidx.room.support.n(str, file, callable, cVar);
                }
                cVar2 = cVar;
            } else {
                cVar2 = null;
            }
            if (cVar2 == null) {
                if (z10) {
                    throw new IllegalArgumentException("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                }
                if (z11) {
                    throw new IllegalArgumentException("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                }
            }
            Context context = this.f14587b;
            String str2 = this.f14588c;
            d dVar = this.f14601p;
            List list = this.f14590e;
            boolean z12 = this.f14596k;
            JournalMode resolve$room_runtime_release = this.f14597l.resolve$room_runtime_release(context);
            Executor executor2 = this.f14593h;
            if (executor2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor3 = this.f14594i;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            androidx.room.c cVar4 = new androidx.room.c(context, str2, cVar2, dVar, list, z12, resolve$room_runtime_release, executor2, executor3, this.f14598m, this.f14605t, this.f14606u, this.f14602q, this.f14608w, this.f14609x, this.f14610y, this.f14591f, this.f14592g, this.f14604s, this.f14607v, this.f14611z, this.A);
            cVar4.f(this.B);
            Function0 function0 = this.f14589d;
            if (function0 == null || (roomDatabase = (RoomDatabase) function0.invoke()) == null) {
                roomDatabase = (RoomDatabase) androidx.room.util.f.b(JvmClassMappingKt.a(this.f14586a), null, 2, null);
            }
            roomDatabase.M(cVar4);
            return roomDatabase;
        }

        public a e() {
            this.f14605t = false;
            this.f14606u = true;
            return this;
        }

        public final a f(boolean z10) {
            this.f14605t = false;
            this.f14606u = true;
            this.f14607v = z10;
            return this;
        }

        public a g() {
            this.f14605t = true;
            this.f14606u = true;
            return this;
        }

        public a h(e.c cVar) {
            this.f14595j = cVar;
            return this;
        }

        public a i(Executor executor) {
            Intrinsics.h(executor, "executor");
            if (this.A != null) {
                throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            }
            this.f14593h = executor;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public void a(a4.d db2) {
            Intrinsics.h(db2, "db");
        }

        public void b(z3.b connection) {
            Intrinsics.h(connection, "connection");
            if (connection instanceof androidx.room.driver.a) {
                a(((androidx.room.driver.a) connection).d());
            }
        }

        public void c(a4.d db2) {
            Intrinsics.h(db2, "db");
        }

        public void d(z3.b connection) {
            Intrinsics.h(connection, "connection");
            if (connection instanceof androidx.room.driver.a) {
                c(((androidx.room.driver.a) connection).d());
            }
        }

        public void e(a4.d db2) {
            Intrinsics.h(db2, "db");
        }

        public void f(z3.b connection) {
            Intrinsics.h(connection, "connection");
            if (connection instanceof androidx.room.driver.a) {
                e(((androidx.room.driver.a) connection).d());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final Map f14612a = new LinkedHashMap();

        public final void a(y3.c migration) {
            Intrinsics.h(migration, "migration");
            int i11 = migration.f78946a;
            int i12 = migration.f78947b;
            Map map = this.f14612a;
            Integer valueOf = Integer.valueOf(i11);
            Object obj = map.get(valueOf);
            if (obj == null) {
                obj = new TreeMap();
                map.put(valueOf, obj);
            }
            TreeMap treeMap = (TreeMap) obj;
            if (treeMap.containsKey(Integer.valueOf(i12))) {
                Log.w("ROOM", "Overriding migration " + treeMap.get(Integer.valueOf(i12)) + " with " + migration);
            }
            treeMap.put(Integer.valueOf(i12), migration);
        }

        public void b(y3.c... migrations) {
            Intrinsics.h(migrations, "migrations");
            for (y3.c cVar : migrations) {
                a(cVar);
            }
        }

        public final boolean c(int i11, int i12) {
            return androidx.room.util.g.a(this, i11, i12);
        }

        public List d(int i11, int i12) {
            return androidx.room.util.g.b(this, i11, i12);
        }

        public Map e() {
            return this.f14612a;
        }

        public final Pair f(int i11) {
            TreeMap treeMap = (TreeMap) this.f14612a.get(Integer.valueOf(i11));
            if (treeMap == null) {
                return null;
            }
            return TuplesKt.a(treeMap, treeMap.descendingKeySet());
        }

        public final Pair g(int i11) {
            TreeMap treeMap = (TreeMap) this.f14612a.get(Integer.valueOf(i11));
            if (treeMap == null) {
                return null;
            }
            return TuplesKt.a(treeMap, treeMap.keySet());
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class e {
        public void a(a4.d db2) {
            Intrinsics.h(db2, "db");
        }
    }

    private final void N() {
        i();
        a4.d writableDatabase = z().getWritableDatabase();
        if (!writableDatabase.s0()) {
            y().E();
        }
        if (writableDatabase.w0()) {
            writableDatabase.K();
        } else {
            writableDatabase.A();
        }
    }

    private final void O() {
        z().getWritableDatabase().L();
        if (L()) {
            return;
        }
        y().y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        kotlinx.coroutines.n0 n0Var = this.f14573b;
        s sVar = null;
        if (n0Var == null) {
            Intrinsics.z("coroutineScope");
            n0Var = null;
        }
        kotlinx.coroutines.o0.d(n0Var, null, 1, null);
        y().C();
        s sVar2 = this.f14577f;
        if (sVar2 == null) {
            Intrinsics.z("connectionManager");
        } else {
            sVar = sVar2;
        }
        sVar.F();
    }

    public static /* synthetic */ Cursor X(RoomDatabase roomDatabase, a4.g gVar, CancellationSignal cancellationSignal, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i11 & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.W(gVar, cancellationSignal);
    }

    private final Object Z(final Function0 function0) {
        if (!K()) {
            return androidx.room.util.b.d(this, false, true, new Function1() { // from class: androidx.room.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object d02;
                    d02 = RoomDatabase.d0(Function0.this, (z3.b) obj);
                    return d02;
                }
            });
        }
        k();
        try {
            Object invoke = function0.invoke();
            e0();
            return invoke;
        } finally {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Runnable runnable) {
        runnable.run();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object c0(Callable callable) {
        return callable.call();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d0(Function0 function0, z3.b it) {
        Intrinsics.h(it, "it");
        return function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(RoomDatabase roomDatabase, a4.d it) {
        Intrinsics.h(it, "it");
        roomDatabase.N();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a4.e o(RoomDatabase roomDatabase, androidx.room.c config) {
        Intrinsics.h(config, "config");
        return roomDatabase.s(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(RoomDatabase roomDatabase, a4.d it) {
        Intrinsics.h(it, "it");
        roomDatabase.O();
        return Unit.f67184a;
    }

    public final CoroutineContext A() {
        kotlinx.coroutines.n0 n0Var = this.f14573b;
        if (n0Var == null) {
            Intrinsics.z("coroutineScope");
            n0Var = null;
        }
        return n0Var.getCoroutineContext();
    }

    public Set B() {
        Set C = C();
        ArrayList arrayList = new ArrayList(CollectionsKt.v(C, 10));
        Iterator it = C.iterator();
        while (it.hasNext()) {
            arrayList.add(JvmClassMappingKt.c((Class) it.next()));
        }
        return CollectionsKt.W0(arrayList);
    }

    public Set C() {
        return SetsKt.f();
    }

    protected Map D() {
        Set<Map.Entry> entrySet = F().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            KClass c11 = JvmClassMappingKt.c(cls);
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(JvmClassMappingKt.c((Class) it.next()));
            }
            Pair a11 = TuplesKt.a(c11, arrayList);
            linkedHashMap.put(a11.getFirst(), a11.getSecond());
        }
        return linkedHashMap;
    }

    public final Map E() {
        return D();
    }

    protected Map F() {
        return MapsKt.h();
    }

    public final ThreadLocal G() {
        return this.f14583l;
    }

    public final CoroutineContext H() {
        CoroutineContext coroutineContext = this.f14574c;
        if (coroutineContext != null) {
            return coroutineContext;
        }
        Intrinsics.z("transactionContext");
        return null;
    }

    public Executor I() {
        Executor executor = this.f14576e;
        if (executor != null) {
            return executor;
        }
        Intrinsics.z("internalTransactionExecutor");
        return null;
    }

    public final boolean J() {
        return this.f14585n;
    }

    public final boolean K() {
        s sVar = this.f14577f;
        if (sVar == null) {
            Intrinsics.z("connectionManager");
            sVar = null;
        }
        return sVar.G() != null;
    }

    public boolean L() {
        return T() && z().getWritableDatabase().s0();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010d A[LOOP:0: B:45:0x010d->B:49:0x0116, LOOP_START, PHI: r0
      0x010d: PHI (r0v29 a4.e) = (r0v28 a4.e), (r0v31 a4.e) binds: [B:26:0x0109, B:49:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M(androidx.room.c r8) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.M(androidx.room.c):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(a4.d db2) {
        Intrinsics.h(db2, "db");
        Q(new androidx.room.driver.a(db2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(z3.b connection) {
        Intrinsics.h(connection, "connection");
        y().r(connection);
    }

    public final boolean R() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean S() {
        AutoCloser autoCloser = this.f14582k;
        if (autoCloser != null) {
            return autoCloser.m();
        }
        s sVar = this.f14577f;
        if (sVar == null) {
            Intrinsics.z("connectionManager");
            sVar = null;
        }
        return sVar.J();
    }

    public final boolean T() {
        s sVar = this.f14577f;
        if (sVar == null) {
            Intrinsics.z("connectionManager");
            sVar = null;
        }
        return sVar.J();
    }

    public final Cursor V(a4.g query) {
        Intrinsics.h(query, "query");
        return X(this, query, null, 2, null);
    }

    public Cursor W(a4.g query, CancellationSignal cancellationSignal) {
        Intrinsics.h(query, "query");
        i();
        j();
        return cancellationSignal != null ? z().getWritableDatabase().e0(query, cancellationSignal) : z().getWritableDatabase().b0(query);
    }

    public Object Y(final Callable body) {
        Intrinsics.h(body, "body");
        return Z(new Function0() { // from class: androidx.room.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object c02;
                c02 = RoomDatabase.c0(body);
                return c02;
            }
        });
    }

    public void a0(final Runnable body) {
        Intrinsics.h(body, "body");
        Z(new Function0() { // from class: androidx.room.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit b02;
                b02 = RoomDatabase.b0(body);
                return b02;
            }
        });
    }

    public void e0() {
        z().getWritableDatabase().I();
    }

    public final Object f0(boolean z10, Function2 function2, Continuation continuation) {
        s sVar = this.f14577f;
        if (sVar == null) {
            Intrinsics.z("connectionManager");
            sVar = null;
        }
        return sVar.K(z10, function2, continuation);
    }

    public final void h(KClass kclass, Object converter) {
        Intrinsics.h(kclass, "kclass");
        Intrinsics.h(converter, "converter");
        this.f14584m.put(kclass, converter);
    }

    public void i() {
        if (!this.f14580i && R()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void j() {
        if (K() && !L() && this.f14583l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void k() {
        i();
        AutoCloser autoCloser = this.f14582k;
        if (autoCloser == null) {
            N();
        } else {
            autoCloser.h(new Function1() { // from class: androidx.room.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit l11;
                    l11 = RoomDatabase.l(RoomDatabase.this, (a4.d) obj);
                    return l11;
                }
            });
        }
    }

    public a4.h m(String sql) {
        Intrinsics.h(sql, "sql");
        i();
        j();
        return z().getWritableDatabase().W(sql);
    }

    public List n(Map autoMigrationSpecs) {
        Intrinsics.h(autoMigrationSpecs, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.e(autoMigrationSpecs.size()));
        for (Map.Entry entry : autoMigrationSpecs.entrySet()) {
            linkedHashMap.put(JvmClassMappingKt.a((KClass) entry.getKey()), entry.getValue());
        }
        return v(linkedHashMap);
    }

    public final s p(androidx.room.c configuration) {
        d0 d0Var;
        Intrinsics.h(configuration, "configuration");
        try {
            e0 r11 = r();
            Intrinsics.f(r11, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            d0Var = (d0) r11;
        } catch (NotImplementedError unused) {
            d0Var = null;
        }
        return d0Var == null ? new s(configuration, new Function1() { // from class: androidx.room.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                a4.e o11;
                o11 = RoomDatabase.o(RoomDatabase.this, (c) obj);
                return o11;
            }
        }) : new s(configuration, d0Var);
    }

    protected abstract InvalidationTracker q();

    protected e0 r() {
        throw new NotImplementedError(null, 1, null);
    }

    protected a4.e s(androidx.room.c config) {
        Intrinsics.h(config, "config");
        throw new NotImplementedError(null, 1, null);
    }

    public void t() {
        AutoCloser autoCloser = this.f14582k;
        if (autoCloser == null) {
            O();
        } else {
            autoCloser.h(new Function1() { // from class: androidx.room.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit u11;
                    u11 = RoomDatabase.u(RoomDatabase.this, (a4.d) obj);
                    return u11;
                }
            });
        }
    }

    public List v(Map autoMigrationSpecs) {
        Intrinsics.h(autoMigrationSpecs, "autoMigrationSpecs");
        return CollectionsKt.l();
    }

    public final x3.a w() {
        return this.f14579h;
    }

    public final kotlinx.coroutines.n0 x() {
        kotlinx.coroutines.n0 n0Var = this.f14573b;
        if (n0Var != null) {
            return n0Var;
        }
        Intrinsics.z("coroutineScope");
        return null;
    }

    public InvalidationTracker y() {
        InvalidationTracker invalidationTracker = this.f14578g;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        Intrinsics.z("internalTracker");
        return null;
    }

    public a4.e z() {
        s sVar = this.f14577f;
        if (sVar == null) {
            Intrinsics.z("connectionManager");
            sVar = null;
        }
        a4.e G = sVar.G();
        if (G != null) {
            return G;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }
}
