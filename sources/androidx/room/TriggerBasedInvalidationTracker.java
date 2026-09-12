package androidx.room;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class TriggerBasedInvalidationTracker {

    /* renamed from: l, reason: collision with root package name */
    public static final a f14622l = new a(null);

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f14623m = {"INSERT", "UPDATE", "DELETE"};

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f14624a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f14625b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f14626c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f14627d;

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f14628e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f14629f;

    /* renamed from: g, reason: collision with root package name */
    private final String[] f14630g;

    /* renamed from: h, reason: collision with root package name */
    private final ObservedTableStates f14631h;

    /* renamed from: i, reason: collision with root package name */
    private final ObservedTableVersions f14632i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f14633j;

    /* renamed from: k, reason: collision with root package name */
    private Function0 f14634k;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String str, String str2) {
            return "room_table_modification_trigger_" + str + '_' + str2;
        }
    }

    public TriggerBasedInvalidationTracker(RoomDatabase database, Map shadowTablesMap, Map viewTables, String[] tableNames, boolean z10, Function1 onInvalidatedTablesIds) {
        String str;
        Intrinsics.h(database, "database");
        Intrinsics.h(shadowTablesMap, "shadowTablesMap");
        Intrinsics.h(viewTables, "viewTables");
        Intrinsics.h(tableNames, "tableNames");
        Intrinsics.h(onInvalidatedTablesIds, "onInvalidatedTablesIds");
        this.f14624a = database;
        this.f14625b = shadowTablesMap;
        this.f14626c = viewTables;
        this.f14627d = z10;
        this.f14628e = onInvalidatedTablesIds;
        this.f14633j = new AtomicBoolean(false);
        this.f14634k = new Function0() { // from class: androidx.room.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean o11;
                o11 = TriggerBasedInvalidationTracker.o();
                return Boolean.valueOf(o11);
            }
        };
        this.f14629f = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            String str2 = tableNames[i11];
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            this.f14629f.put(lowerCase, Integer.valueOf(i11));
            String str3 = (String) this.f14625b.get(tableNames[i11]);
            if (str3 != null) {
                str = str3.toLowerCase(locale);
                Intrinsics.g(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr[i11] = lowerCase;
        }
        this.f14630g = strArr;
        for (Map.Entry entry : this.f14625b.entrySet()) {
            String str4 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase2 = str4.toLowerCase(locale2);
            Intrinsics.g(lowerCase2, "toLowerCase(...)");
            if (this.f14629f.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                Intrinsics.g(lowerCase3, "toLowerCase(...)");
                Map map = this.f14629f;
                map.put(lowerCase3, MapsKt.i(map, lowerCase2));
            }
        }
        this.f14631h = new ObservedTableStates(this.f14630g.length);
        this.f14632i = new ObservedTableVersions(this.f14630g.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(androidx.room.p r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$0
            java.util.Set r6 = (java.util.Set) r6
            kotlin.ResultKt.b(r7)
            goto L6e
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.L$0
            androidx.room.p r6 = (androidx.room.p) r6
            kotlin.ResultKt.b(r7)
            goto L55
        L40:
            kotlin.ResultKt.b(r7)
            androidx.room.q0 r7 = new androidx.room.q0
            r7.<init>()
            r0.L$0 = r6
            r0.label = r4
            java.lang.String r2 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r7 = r6.d(r2, r7, r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            java.util.Set r7 = (java.util.Set) r7
            r2 = r7
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L6f
            r0.L$0 = r7
            r0.label = r3
            java.lang.String r2 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r6 = androidx.room.p0.b(r6, r2, r0)
            if (r6 != r1) goto L6d
            return r1
        L6d:
            r6 = r7
        L6e:
            r7 = r6
        L6f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.j(androidx.room.p, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set k(z3.e statement) {
        Intrinsics.h(statement, "statement");
        Set b11 = SetsKt.b();
        while (statement.A0()) {
            b11.add(Integer.valueOf((int) statement.getLong(0)));
        }
        return SetsKt.a(b11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0099 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x008e, B:14:0x0099), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r1 = r0.L$1
            x3.a r1 = (x3.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.TriggerBasedInvalidationTracker r0 = (androidx.room.TriggerBasedInvalidationTracker) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L31
            goto L8e
        L31:
            r8 = move-exception
            goto La7
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3c:
            kotlin.ResultKt.b(r8)
            androidx.room.RoomDatabase r8 = r7.f14624a
            x3.a r8 = r8.w()
            boolean r2 = r8.a()
            if (r2 == 0) goto Lab
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.f14633j     // Catch: java.lang.Throwable -> L5c
            r4 = 0
            boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L5c
            if (r2 != 0) goto L60
            java.util.Set r0 = kotlin.collections.SetsKt.f()     // Catch: java.lang.Throwable -> L5c
            r8.c()
            return r0
        L5c:
            r0 = move-exception
            r1 = r8
            r8 = r0
            goto La7
        L60:
            kotlin.jvm.functions.Function0 r2 = r7.f14634k     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r2 = r2.invoke()     // Catch: java.lang.Throwable -> L5c
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L5c
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L5c
            if (r2 != 0) goto L76
            java.util.Set r0 = kotlin.collections.SetsKt.f()     // Catch: java.lang.Throwable -> L5c
            r8.c()
            return r0
        L76:
            androidx.room.RoomDatabase r2 = r7.f14624a     // Catch: java.lang.Throwable -> L5c
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1     // Catch: java.lang.Throwable -> L5c
            r6 = 0
            r5.<init>(r7, r6)     // Catch: java.lang.Throwable -> L5c
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L5c
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L5c
            r0.label = r3     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r0 = r2.f0(r4, r5, r0)     // Catch: java.lang.Throwable -> L5c
            if (r0 != r1) goto L8b
            return r1
        L8b:
            r1 = r8
            r8 = r0
            r0 = r7
        L8e:
            java.util.Set r8 = (java.util.Set) r8     // Catch: java.lang.Throwable -> L31
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L31
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto La3
            androidx.room.ObservedTableVersions r2 = r0.f14632i     // Catch: java.lang.Throwable -> L31
            r2.b(r8)     // Catch: java.lang.Throwable -> L31
            kotlin.jvm.functions.Function1 r0 = r0.f14628e     // Catch: java.lang.Throwable -> L31
            r0.invoke(r8)     // Catch: java.lang.Throwable -> L31
        La3:
            r1.c()
            return r8
        La7:
            r1.c()
            throw r8
        Lab:
            java.util.Set r8 = kotlin.collections.SetsKt.f()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o() {
        return true;
    }

    private final String[] t(String[] strArr) {
        Set b11 = SetsKt.b();
        for (String str : strArr) {
            Map map = this.f14626c;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            Set set = (Set) map.get(lowerCase);
            if (set != null) {
                b11.addAll(set);
            } else {
                b11.add(str);
            }
        }
        return (String[]) SetsKt.a(b11).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00fe -> B:11:0x00ff). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(androidx.room.p r18, int r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.v(androidx.room.p, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0085 -> B:10:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(androidx.room.p r10, int r11, kotlin.coroutines.Continuation r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            int r10 = r0.I$1
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$2
            java.lang.String[] r2 = (java.lang.String[]) r2
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.L$0
            androidx.room.p r5 = (androidx.room.p) r5
            kotlin.ResultKt.b(r12)
            r12 = r4
            goto L87
        L3a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L42:
            kotlin.ResultKt.b(r12)
            java.lang.String[] r12 = r9.f14630g
            r11 = r12[r11]
            java.lang.String[] r12 = androidx.room.TriggerBasedInvalidationTracker.f14623m
            int r2 = r12.length
            r4 = 0
            r8 = r11
            r11 = r10
            r10 = r2
            r2 = r12
            r12 = r8
        L52:
            if (r4 >= r10) goto L8b
            r5 = r2[r4]
            androidx.room.TriggerBasedInvalidationTracker$a r6 = androidx.room.TriggerBasedInvalidationTracker.f14622l
            java.lang.String r5 = androidx.room.TriggerBasedInvalidationTracker.a.a(r6, r12, r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "DROP TRIGGER IF EXISTS `"
            r6.append(r7)
            r6.append(r5)
            r5 = 96
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r2
            r0.I$0 = r4
            r0.I$1 = r10
            r0.label = r3
            java.lang.Object r5 = androidx.room.p0.b(r11, r5, r0)
            if (r5 != r1) goto L85
            return r1
        L85:
            r5 = r11
            r11 = r4
        L87:
            int r4 = r11 + 1
            r11 = r5
            goto L52
        L8b:
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.w(androidx.room.p, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void l(z3.b connection) {
        Intrinsics.h(connection, "connection");
        z3.e D0 = connection.D0("PRAGMA query_only");
        try {
            D0.A0();
            boolean z10 = D0.getBoolean(0);
            AutoCloseableKt.a(D0, null);
            if (z10) {
                return;
            }
            z3.a.a(connection, "PRAGMA temp_store = MEMORY");
            z3.a.a(connection, "PRAGMA recursive_triggers = 1");
            z3.a.a(connection, "DROP TABLE IF EXISTS room_table_modification_log");
            if (this.f14627d) {
                z3.a.a(connection, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            } else {
                z3.a.a(connection, StringsKt.Q("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", "", false, 4, null));
            }
            this.f14631h.a();
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AutoCloseableKt.a(D0, th2);
                throw th3;
            }
        }
    }

    public final kotlinx.coroutines.flow.b m(String[] resolvedTableNames, int[] tableIds, boolean z10) {
        Intrinsics.h(resolvedTableNames, "resolvedTableNames");
        Intrinsics.h(tableIds, "tableIds");
        return kotlinx.coroutines.flow.d.s(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, z10, resolvedTableNames, null));
    }

    public final boolean p(int[] tableIds) {
        Intrinsics.h(tableIds, "tableIds");
        return this.f14631h.c(tableIds);
    }

    public final boolean q(int[] tableIds) {
        Intrinsics.h(tableIds, "tableIds");
        return this.f14631h.d(tableIds);
    }

    public final void r(Function0 onRefreshScheduled, Function0 onRefreshCompleted) {
        Intrinsics.h(onRefreshScheduled, "onRefreshScheduled");
        Intrinsics.h(onRefreshCompleted, "onRefreshCompleted");
        if (this.f14633j.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            kotlinx.coroutines.k.d(this.f14624a.x(), new kotlinx.coroutines.m0("Room Invalidation Tracker Refresh"), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2, null);
        }
    }

    public final void s() {
        this.f14631h.e();
    }

    public final void u(Function0 function0) {
        Intrinsics.h(function0, "<set-?>");
        this.f14634k = function0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            x3.a r0 = (x3.a) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L2d
            goto L5b
        L2d:
            r8 = move-exception
            goto L63
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            kotlin.ResultKt.b(r8)
            androidx.room.RoomDatabase r8 = r7.f14624a
            x3.a r8 = r8.w()
            boolean r2 = r8.a()
            if (r2 == 0) goto L67
            androidx.room.RoomDatabase r2 = r7.f14624a     // Catch: java.lang.Throwable -> L5f
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1     // Catch: java.lang.Throwable -> L5f
            r5 = 0
            r4.<init>(r7, r5)     // Catch: java.lang.Throwable -> L5f
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L5f
            r0.label = r3     // Catch: java.lang.Throwable -> L5f
            r3 = 0
            java.lang.Object r0 = r2.f0(r3, r4, r0)     // Catch: java.lang.Throwable -> L5f
            if (r0 != r1) goto L5a
            return r1
        L5a:
            r0 = r8
        L5b:
            r0.c()
            goto L67
        L5f:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L63:
            r0.c()
            throw r8
        L67:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Pair y(String[] names) {
        Intrinsics.h(names, "names");
        String[] t11 = t(names);
        int length = t11.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            String str = t11[i11];
            Map map = this.f14629f;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            iArr[i11] = num.intValue();
        }
        return TuplesKt.a(t11, iArr);
    }
}
