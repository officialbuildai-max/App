package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.view.LiveData;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.f;
import androidx.work.impl.model.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class r1 implements k0 {

    /* renamed from: d, reason: collision with root package name */
    public static final c f15924d = new c(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f15925a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f15926b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f15927c;

    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`backoff_on_system_interruptions`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, j0 entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.f15846a);
            statement.c(2, a2.k(entity.f15847b));
            statement.j(3, entity.f15848c);
            statement.j(4, entity.f15849d);
            f.b bVar = androidx.work.f.f15565b;
            statement.e(5, bVar.e(entity.f15850e));
            statement.e(6, bVar.e(entity.f15851f));
            statement.c(7, entity.f15852g);
            statement.c(8, entity.f15853h);
            statement.c(9, entity.f15854i);
            statement.c(10, entity.f15856k);
            statement.c(11, a2.a(entity.f15857l));
            statement.c(12, entity.f15858m);
            statement.c(13, entity.f15859n);
            statement.c(14, entity.f15860o);
            statement.c(15, entity.f15861p);
            statement.c(16, entity.f15862q ? 1L : 0L);
            statement.c(17, a2.i(entity.f15863r));
            statement.c(18, entity.j());
            statement.c(19, entity.g());
            statement.c(20, entity.h());
            statement.c(21, entity.i());
            statement.c(22, entity.k());
            String l11 = entity.l();
            if (l11 == null) {
                statement.g(23);
            } else {
                statement.j(23, l11);
            }
            Boolean f11 = entity.f();
            if ((f11 != null ? Integer.valueOf(f11.booleanValue() ? 1 : 0) : null) == null) {
                statement.g(24);
            } else {
                statement.c(24, r0.intValue());
            }
            androidx.work.d dVar = entity.f15855j;
            statement.c(25, a2.h(dVar.f()));
            statement.e(26, a2.c(dVar.e()));
            statement.c(27, dVar.i() ? 1L : 0L);
            statement.c(28, dVar.j() ? 1L : 0L);
            statement.c(29, dVar.h() ? 1L : 0L);
            statement.c(30, dVar.k() ? 1L : 0L);
            statement.c(31, dVar.b());
            statement.c(32, dVar.a());
            statement.e(33, a2.j(dVar.c()));
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`trace_tag` = ?,`backoff_on_system_interruptions` = ?,`required_network_type` = ?,`required_network_request` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, j0 entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.f15846a);
            statement.c(2, a2.k(entity.f15847b));
            statement.j(3, entity.f15848c);
            statement.j(4, entity.f15849d);
            f.b bVar = androidx.work.f.f15565b;
            statement.e(5, bVar.e(entity.f15850e));
            statement.e(6, bVar.e(entity.f15851f));
            statement.c(7, entity.f15852g);
            statement.c(8, entity.f15853h);
            statement.c(9, entity.f15854i);
            statement.c(10, entity.f15856k);
            statement.c(11, a2.a(entity.f15857l));
            statement.c(12, entity.f15858m);
            statement.c(13, entity.f15859n);
            statement.c(14, entity.f15860o);
            statement.c(15, entity.f15861p);
            statement.c(16, entity.f15862q ? 1L : 0L);
            statement.c(17, a2.i(entity.f15863r));
            statement.c(18, entity.j());
            statement.c(19, entity.g());
            statement.c(20, entity.h());
            statement.c(21, entity.i());
            statement.c(22, entity.k());
            String l11 = entity.l();
            if (l11 == null) {
                statement.g(23);
            } else {
                statement.j(23, l11);
            }
            Boolean f11 = entity.f();
            if ((f11 != null ? Integer.valueOf(f11.booleanValue() ? 1 : 0) : null) == null) {
                statement.g(24);
            } else {
                statement.c(24, r0.intValue());
            }
            androidx.work.d dVar = entity.f15855j;
            statement.c(25, a2.h(dVar.f()));
            statement.e(26, a2.c(dVar.e()));
            statement.c(27, dVar.i() ? 1L : 0L);
            statement.c(28, dVar.j() ? 1L : 0L);
            statement.c(29, dVar.h() ? 1L : 0L);
            statement.c(30, dVar.k() ? 1L : 0L);
            statement.c(31, dVar.b());
            statement.c(32, dVar.a());
            statement.e(33, a2.j(dVar.c()));
            statement.j(34, entity.f15846a);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.l();
        }
    }

    public r1(RoomDatabase __db) {
        Intrinsics.h(__db, "__db");
        this.f15925a = __db;
        this.f15926b = new a();
        this.f15927c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            D0.A0();
            return androidx.room.util.j.b(_connection);
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(r1 r1Var, j0 j0Var, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        r1Var.f15926b.d(_connection, j0Var);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C0(String str, long j11, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.c(1, j11);
            D0.j(2, str2);
            D0.A0();
            return androidx.room.util.j.b(_connection);
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int D0(String str, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.A0();
            return androidx.room.util.j.b(_connection);
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(String str, String str2, int i11, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            D0.c(2, i11);
            D0.A0();
            D0.close();
            return Unit.f67184a;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int F0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            D0.A0();
            return androidx.room.util.j.b(_connection);
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int G0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            D0.A0();
            return androidx.room.util.j.b(_connection);
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(String str, long j11, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.c(1, j11);
            D0.j(2, str2);
            D0.A0();
            D0.close();
            return Unit.f67184a;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(String str, androidx.work.f fVar, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.e(1, androidx.work.f.f15565b.e(fVar));
            D0.j(2, str2);
            D0.A0();
            D0.close();
            return Unit.f67184a;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J0(String str, WorkInfo.State state, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.c(1, a2.k(state));
            D0.j(2, str2);
            D0.A0();
            return androidx.room.util.j.b(_connection);
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(String str, int i11, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.c(1, i11);
            D0.j(2, str2);
            D0.A0();
            D0.close();
            return Unit.f67184a;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(r1 r1Var, j0 j0Var, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        r1Var.f15927c.c(_connection, j0Var);
        return Unit.f67184a;
    }

    private final void g0(final z3.b bVar, androidx.collection.a aVar) {
        Set<Object> keySet = aVar.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (aVar.size() > 999) {
            androidx.room.util.h.a(aVar, true, new Function1() { // from class: androidx.work.impl.model.e1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h02;
                    h02 = r1.h0(r1.this, bVar, (androidx.collection.a) obj);
                    return h02;
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        androidx.room.util.n.a(sb2, keySet.size());
        sb2.append(")");
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        z3.e D0 = bVar.D0(sb3);
        Iterator<Object> it = keySet.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            D0.j(i11, (String) it.next());
            i11++;
        }
        try {
            int c11 = androidx.room.util.k.c(D0, "work_spec_id");
            if (c11 == -1) {
                return;
            }
            while (D0.A0()) {
                List list = (List) aVar.get(D0.n0(c11));
                if (list != null) {
                    list.add(androidx.work.f.f15565b.a(D0.getBlob(0)));
                }
            }
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(r1 r1Var, z3.b bVar, androidx.collection.a _tmpMap) {
        Intrinsics.h(_tmpMap, "_tmpMap");
        r1Var.g0(bVar, _tmpMap);
        return Unit.f67184a;
    }

    private final void i0(final z3.b bVar, androidx.collection.a aVar) {
        Set<Object> keySet = aVar.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (aVar.size() > 999) {
            androidx.room.util.h.a(aVar, true, new Function1() { // from class: androidx.work.impl.model.f1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j02;
                    j02 = r1.j0(r1.this, bVar, (androidx.collection.a) obj);
                    return j02;
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        androidx.room.util.n.a(sb2, keySet.size());
        sb2.append(")");
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        z3.e D0 = bVar.D0(sb3);
        Iterator<Object> it = keySet.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            D0.j(i11, (String) it.next());
            i11++;
        }
        try {
            int c11 = androidx.room.util.k.c(D0, "work_spec_id");
            if (c11 == -1) {
                return;
            }
            while (D0.A0()) {
                List list = (List) aVar.get(D0.n0(c11));
                if (list != null) {
                    list.add(D0.n0(0));
                }
            }
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(r1 r1Var, z3.b bVar, androidx.collection.a _tmpMap) {
        Intrinsics.h(_tmpMap, "_tmpMap");
        r1Var.i0(bVar, _tmpMap);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k0(String str, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            return D0.A0() ? (int) D0.getLong(0) : 0;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            D0.A0();
            D0.close();
            return Unit.f67184a;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m0(String str, int i11, z3.b _connection) {
        int i12;
        boolean z10;
        String n02;
        int i13;
        int i14;
        int i15;
        int i16;
        Integer valueOf;
        int i17;
        Boolean bool;
        int i18;
        boolean z11;
        int i19;
        boolean z12;
        int i20;
        boolean z13;
        int i21;
        boolean z14;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.c(1, i11);
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "state");
            int d13 = androidx.room.util.k.d(D0, "worker_class_name");
            int d14 = androidx.room.util.k.d(D0, "input_merger_class_name");
            int d15 = androidx.room.util.k.d(D0, "input");
            int d16 = androidx.room.util.k.d(D0, "output");
            int d17 = androidx.room.util.k.d(D0, "initial_delay");
            int d18 = androidx.room.util.k.d(D0, "interval_duration");
            int d19 = androidx.room.util.k.d(D0, "flex_duration");
            int d20 = androidx.room.util.k.d(D0, "run_attempt_count");
            int d21 = androidx.room.util.k.d(D0, "backoff_policy");
            int d22 = androidx.room.util.k.d(D0, "backoff_delay_duration");
            int d23 = androidx.room.util.k.d(D0, "last_enqueue_time");
            int d24 = androidx.room.util.k.d(D0, "minimum_retention_duration");
            int d25 = androidx.room.util.k.d(D0, "schedule_requested_at");
            int d26 = androidx.room.util.k.d(D0, "run_in_foreground");
            int d27 = androidx.room.util.k.d(D0, "out_of_quota_policy");
            int d28 = androidx.room.util.k.d(D0, "period_count");
            int d29 = androidx.room.util.k.d(D0, "generation");
            int d30 = androidx.room.util.k.d(D0, "next_schedule_time_override");
            int d31 = androidx.room.util.k.d(D0, "next_schedule_time_override_generation");
            int d32 = androidx.room.util.k.d(D0, "stop_reason");
            int d33 = androidx.room.util.k.d(D0, "trace_tag");
            int d34 = androidx.room.util.k.d(D0, "backoff_on_system_interruptions");
            int d35 = androidx.room.util.k.d(D0, "required_network_type");
            int d36 = androidx.room.util.k.d(D0, "required_network_request");
            int d37 = androidx.room.util.k.d(D0, "requires_charging");
            int d38 = androidx.room.util.k.d(D0, "requires_device_idle");
            int d39 = androidx.room.util.k.d(D0, "requires_battery_not_low");
            int d40 = androidx.room.util.k.d(D0, "requires_storage_not_low");
            int d41 = androidx.room.util.k.d(D0, "trigger_content_update_delay");
            int d42 = androidx.room.util.k.d(D0, "trigger_max_content_delay");
            int d43 = androidx.room.util.k.d(D0, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n03 = D0.n0(d11);
                int i22 = d23;
                int i23 = d24;
                WorkInfo.State g11 = a2.g((int) D0.getLong(d12));
                String n04 = D0.n0(d13);
                String n05 = D0.n0(d14);
                byte[] blob = D0.getBlob(d15);
                f.b bVar = androidx.work.f.f15565b;
                androidx.work.f a11 = bVar.a(blob);
                androidx.work.f a12 = bVar.a(D0.getBlob(d16));
                long j11 = D0.getLong(d17);
                long j12 = D0.getLong(d18);
                long j13 = D0.getLong(d19);
                int i24 = (int) D0.getLong(d20);
                int i25 = d11;
                int i26 = d12;
                BackoffPolicy d44 = a2.d((int) D0.getLong(d21));
                long j14 = D0.getLong(d22);
                long j15 = D0.getLong(i22);
                long j16 = D0.getLong(i23);
                int i27 = d25;
                long j17 = D0.getLong(i27);
                d25 = i27;
                int i28 = d26;
                int i29 = d13;
                if (((int) D0.getLong(i28)) != 0) {
                    i12 = d27;
                    z10 = true;
                } else {
                    i12 = d27;
                    z10 = false;
                }
                int i30 = d14;
                OutOfQuotaPolicy f11 = a2.f((int) D0.getLong(i12));
                int i31 = d28;
                int i32 = i12;
                int i33 = (int) D0.getLong(i31);
                int i34 = d29;
                int i35 = (int) D0.getLong(i34);
                int i36 = d30;
                long j18 = D0.getLong(i36);
                int i37 = d31;
                int i38 = d15;
                int i39 = (int) D0.getLong(i37);
                int i40 = d17;
                int i41 = d32;
                int i42 = d16;
                int i43 = (int) D0.getLong(i41);
                int i44 = d33;
                if (D0.isNull(i44)) {
                    i13 = i37;
                    i14 = d34;
                    n02 = null;
                } else {
                    n02 = D0.n0(i44);
                    i13 = i37;
                    i14 = d34;
                }
                if (D0.isNull(i14)) {
                    i15 = i44;
                    i16 = d18;
                    valueOf = null;
                } else {
                    i15 = i44;
                    i16 = d18;
                    valueOf = Integer.valueOf((int) D0.getLong(i14));
                }
                if (valueOf != null) {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                    i17 = d35;
                } else {
                    i17 = d35;
                    bool = null;
                }
                int i45 = d19;
                NetworkType e11 = a2.e((int) D0.getLong(i17));
                int i46 = d36;
                androidx.work.impl.utils.v l11 = a2.l(D0.getBlob(i46));
                int i47 = i17;
                int i48 = d37;
                if (((int) D0.getLong(i48)) != 0) {
                    i18 = d38;
                    z11 = true;
                } else {
                    i18 = d38;
                    z11 = false;
                }
                if (((int) D0.getLong(i18)) != 0) {
                    i19 = d39;
                    z12 = true;
                } else {
                    i19 = d39;
                    z12 = false;
                }
                int i49 = d20;
                int i50 = i18;
                if (((int) D0.getLong(i19)) != 0) {
                    i20 = d40;
                    z13 = true;
                } else {
                    i20 = d40;
                    z13 = false;
                }
                int i51 = i19;
                if (((int) D0.getLong(i20)) != 0) {
                    i21 = d41;
                    z14 = true;
                } else {
                    i21 = d41;
                    z14 = false;
                }
                int i52 = d42;
                int i53 = i14;
                int i54 = d43;
                d43 = i54;
                arrayList.add(new j0(n03, g11, n04, n05, a11, a12, j11, j12, j13, new androidx.work.d(l11, e11, z11, z12, z13, z14, D0.getLong(i21), D0.getLong(i52), a2.b(D0.getBlob(i54))), i24, d44, j14, j15, j16, j17, z10, f11, i33, i35, j18, i39, i43, n02, bool));
                d13 = i29;
                d42 = i52;
                d11 = i25;
                d14 = i30;
                d27 = i32;
                d28 = i31;
                d29 = i34;
                d16 = i42;
                d18 = i16;
                d34 = i53;
                d23 = i22;
                d24 = i23;
                d12 = i26;
                d26 = i28;
                d30 = i36;
                d32 = i41;
                d41 = i21;
                d15 = i38;
                d31 = i13;
                d17 = i40;
                d33 = i15;
                d40 = i20;
                d19 = i45;
                d35 = i47;
                d36 = i46;
                d37 = i48;
                d38 = i50;
                d20 = i49;
                d39 = i51;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n0(String str, int i11, z3.b _connection) {
        int i12;
        boolean z10;
        String n02;
        int i13;
        int i14;
        int i15;
        int i16;
        Integer valueOf;
        int i17;
        Boolean bool;
        int i18;
        boolean z11;
        int i19;
        boolean z12;
        int i20;
        boolean z13;
        int i21;
        boolean z14;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.c(1, i11);
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "state");
            int d13 = androidx.room.util.k.d(D0, "worker_class_name");
            int d14 = androidx.room.util.k.d(D0, "input_merger_class_name");
            int d15 = androidx.room.util.k.d(D0, "input");
            int d16 = androidx.room.util.k.d(D0, "output");
            int d17 = androidx.room.util.k.d(D0, "initial_delay");
            int d18 = androidx.room.util.k.d(D0, "interval_duration");
            int d19 = androidx.room.util.k.d(D0, "flex_duration");
            int d20 = androidx.room.util.k.d(D0, "run_attempt_count");
            int d21 = androidx.room.util.k.d(D0, "backoff_policy");
            int d22 = androidx.room.util.k.d(D0, "backoff_delay_duration");
            int d23 = androidx.room.util.k.d(D0, "last_enqueue_time");
            int d24 = androidx.room.util.k.d(D0, "minimum_retention_duration");
            int d25 = androidx.room.util.k.d(D0, "schedule_requested_at");
            int d26 = androidx.room.util.k.d(D0, "run_in_foreground");
            int d27 = androidx.room.util.k.d(D0, "out_of_quota_policy");
            int d28 = androidx.room.util.k.d(D0, "period_count");
            int d29 = androidx.room.util.k.d(D0, "generation");
            int d30 = androidx.room.util.k.d(D0, "next_schedule_time_override");
            int d31 = androidx.room.util.k.d(D0, "next_schedule_time_override_generation");
            int d32 = androidx.room.util.k.d(D0, "stop_reason");
            int d33 = androidx.room.util.k.d(D0, "trace_tag");
            int d34 = androidx.room.util.k.d(D0, "backoff_on_system_interruptions");
            int d35 = androidx.room.util.k.d(D0, "required_network_type");
            int d36 = androidx.room.util.k.d(D0, "required_network_request");
            int d37 = androidx.room.util.k.d(D0, "requires_charging");
            int d38 = androidx.room.util.k.d(D0, "requires_device_idle");
            int d39 = androidx.room.util.k.d(D0, "requires_battery_not_low");
            int d40 = androidx.room.util.k.d(D0, "requires_storage_not_low");
            int d41 = androidx.room.util.k.d(D0, "trigger_content_update_delay");
            int d42 = androidx.room.util.k.d(D0, "trigger_max_content_delay");
            int d43 = androidx.room.util.k.d(D0, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n03 = D0.n0(d11);
                int i22 = d23;
                int i23 = d24;
                WorkInfo.State g11 = a2.g((int) D0.getLong(d12));
                String n04 = D0.n0(d13);
                String n05 = D0.n0(d14);
                byte[] blob = D0.getBlob(d15);
                f.b bVar = androidx.work.f.f15565b;
                androidx.work.f a11 = bVar.a(blob);
                androidx.work.f a12 = bVar.a(D0.getBlob(d16));
                long j11 = D0.getLong(d17);
                long j12 = D0.getLong(d18);
                long j13 = D0.getLong(d19);
                int i24 = (int) D0.getLong(d20);
                int i25 = d11;
                int i26 = d12;
                BackoffPolicy d44 = a2.d((int) D0.getLong(d21));
                long j14 = D0.getLong(d22);
                long j15 = D0.getLong(i22);
                long j16 = D0.getLong(i23);
                int i27 = d25;
                long j17 = D0.getLong(i27);
                d25 = i27;
                int i28 = d26;
                int i29 = d13;
                if (((int) D0.getLong(i28)) != 0) {
                    i12 = d27;
                    z10 = true;
                } else {
                    i12 = d27;
                    z10 = false;
                }
                int i30 = d14;
                OutOfQuotaPolicy f11 = a2.f((int) D0.getLong(i12));
                int i31 = d28;
                int i32 = i12;
                int i33 = (int) D0.getLong(i31);
                int i34 = d29;
                int i35 = (int) D0.getLong(i34);
                int i36 = d30;
                long j18 = D0.getLong(i36);
                int i37 = d31;
                int i38 = d15;
                int i39 = (int) D0.getLong(i37);
                int i40 = d17;
                int i41 = d32;
                int i42 = d16;
                int i43 = (int) D0.getLong(i41);
                int i44 = d33;
                if (D0.isNull(i44)) {
                    i13 = i37;
                    i14 = d34;
                    n02 = null;
                } else {
                    n02 = D0.n0(i44);
                    i13 = i37;
                    i14 = d34;
                }
                if (D0.isNull(i14)) {
                    i15 = i44;
                    i16 = d18;
                    valueOf = null;
                } else {
                    i15 = i44;
                    i16 = d18;
                    valueOf = Integer.valueOf((int) D0.getLong(i14));
                }
                if (valueOf != null) {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                    i17 = d35;
                } else {
                    i17 = d35;
                    bool = null;
                }
                int i45 = d19;
                NetworkType e11 = a2.e((int) D0.getLong(i17));
                int i46 = d36;
                androidx.work.impl.utils.v l11 = a2.l(D0.getBlob(i46));
                int i47 = i17;
                int i48 = d37;
                if (((int) D0.getLong(i48)) != 0) {
                    i18 = d38;
                    z11 = true;
                } else {
                    i18 = d38;
                    z11 = false;
                }
                if (((int) D0.getLong(i18)) != 0) {
                    i19 = d39;
                    z12 = true;
                } else {
                    i19 = d39;
                    z12 = false;
                }
                int i49 = d20;
                int i50 = i18;
                if (((int) D0.getLong(i19)) != 0) {
                    i20 = d40;
                    z13 = true;
                } else {
                    i20 = d40;
                    z13 = false;
                }
                int i51 = i19;
                if (((int) D0.getLong(i20)) != 0) {
                    i21 = d41;
                    z14 = true;
                } else {
                    i21 = d41;
                    z14 = false;
                }
                int i52 = d42;
                int i53 = i14;
                int i54 = d43;
                d43 = i54;
                arrayList.add(new j0(n03, g11, n04, n05, a11, a12, j11, j12, j13, new androidx.work.d(l11, e11, z11, z12, z13, z14, D0.getLong(i21), D0.getLong(i52), a2.b(D0.getBlob(i54))), i24, d44, j14, j15, j16, j17, z10, f11, i33, i35, j18, i39, i43, n02, bool));
                d13 = i29;
                d42 = i52;
                d11 = i25;
                d14 = i30;
                d27 = i32;
                d28 = i31;
                d29 = i34;
                d16 = i42;
                d18 = i16;
                d34 = i53;
                d23 = i22;
                d24 = i23;
                d12 = i26;
                d26 = i28;
                d30 = i36;
                d32 = i41;
                d41 = i21;
                d15 = i38;
                d31 = i13;
                d17 = i40;
                d33 = i15;
                d40 = i20;
                d19 = i45;
                d35 = i47;
                d36 = i46;
                d37 = i48;
                d38 = i50;
                d20 = i49;
                d39 = i51;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List o0(String str, z3.b _connection) {
        int i11;
        boolean z10;
        String n02;
        int i12;
        int i13;
        int i14;
        int i15;
        Integer valueOf;
        int i16;
        Boolean bool;
        int i17;
        boolean z11;
        int i18;
        boolean z12;
        int i19;
        boolean z13;
        int i20;
        boolean z14;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "state");
            int d13 = androidx.room.util.k.d(D0, "worker_class_name");
            int d14 = androidx.room.util.k.d(D0, "input_merger_class_name");
            int d15 = androidx.room.util.k.d(D0, "input");
            int d16 = androidx.room.util.k.d(D0, "output");
            int d17 = androidx.room.util.k.d(D0, "initial_delay");
            int d18 = androidx.room.util.k.d(D0, "interval_duration");
            int d19 = androidx.room.util.k.d(D0, "flex_duration");
            int d20 = androidx.room.util.k.d(D0, "run_attempt_count");
            int d21 = androidx.room.util.k.d(D0, "backoff_policy");
            int d22 = androidx.room.util.k.d(D0, "backoff_delay_duration");
            int d23 = androidx.room.util.k.d(D0, "last_enqueue_time");
            int d24 = androidx.room.util.k.d(D0, "minimum_retention_duration");
            int d25 = androidx.room.util.k.d(D0, "schedule_requested_at");
            int d26 = androidx.room.util.k.d(D0, "run_in_foreground");
            int d27 = androidx.room.util.k.d(D0, "out_of_quota_policy");
            int d28 = androidx.room.util.k.d(D0, "period_count");
            int d29 = androidx.room.util.k.d(D0, "generation");
            int d30 = androidx.room.util.k.d(D0, "next_schedule_time_override");
            int d31 = androidx.room.util.k.d(D0, "next_schedule_time_override_generation");
            int d32 = androidx.room.util.k.d(D0, "stop_reason");
            int d33 = androidx.room.util.k.d(D0, "trace_tag");
            int d34 = androidx.room.util.k.d(D0, "backoff_on_system_interruptions");
            int d35 = androidx.room.util.k.d(D0, "required_network_type");
            int d36 = androidx.room.util.k.d(D0, "required_network_request");
            int d37 = androidx.room.util.k.d(D0, "requires_charging");
            int d38 = androidx.room.util.k.d(D0, "requires_device_idle");
            int d39 = androidx.room.util.k.d(D0, "requires_battery_not_low");
            int d40 = androidx.room.util.k.d(D0, "requires_storage_not_low");
            int d41 = androidx.room.util.k.d(D0, "trigger_content_update_delay");
            int d42 = androidx.room.util.k.d(D0, "trigger_max_content_delay");
            int d43 = androidx.room.util.k.d(D0, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n03 = D0.n0(d11);
                int i21 = d24;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State g11 = a2.g((int) D0.getLong(d12));
                String n04 = D0.n0(d13);
                String n05 = D0.n0(d14);
                byte[] blob = D0.getBlob(d15);
                f.b bVar = androidx.work.f.f15565b;
                androidx.work.f a11 = bVar.a(blob);
                androidx.work.f a12 = bVar.a(D0.getBlob(d16));
                long j11 = D0.getLong(d17);
                long j12 = D0.getLong(d18);
                long j13 = D0.getLong(d19);
                int i22 = (int) D0.getLong(d20);
                int i23 = d12;
                int i24 = d13;
                BackoffPolicy d44 = a2.d((int) D0.getLong(d21));
                long j14 = D0.getLong(d22);
                long j15 = D0.getLong(d23);
                long j16 = D0.getLong(i21);
                int i25 = d25;
                long j17 = D0.getLong(i25);
                int i26 = d11;
                int i27 = d26;
                if (((int) D0.getLong(i27)) != 0) {
                    i11 = d27;
                    z10 = true;
                } else {
                    i11 = d27;
                    z10 = false;
                }
                int i28 = d14;
                OutOfQuotaPolicy f11 = a2.f((int) D0.getLong(i11));
                int i29 = d28;
                int i30 = d15;
                int i31 = (int) D0.getLong(i29);
                int i32 = d29;
                int i33 = i11;
                int i34 = (int) D0.getLong(i32);
                int i35 = d30;
                long j18 = D0.getLong(i35);
                int i36 = d31;
                int i37 = d16;
                int i38 = (int) D0.getLong(i36);
                int i39 = d18;
                int i40 = d32;
                int i41 = d17;
                int i42 = (int) D0.getLong(i40);
                int i43 = d33;
                if (D0.isNull(i43)) {
                    i12 = i36;
                    i13 = d34;
                    n02 = null;
                } else {
                    n02 = D0.n0(i43);
                    i12 = i36;
                    i13 = d34;
                }
                if (D0.isNull(i13)) {
                    i14 = i43;
                    i15 = d19;
                    valueOf = null;
                } else {
                    i14 = i43;
                    i15 = d19;
                    valueOf = Integer.valueOf((int) D0.getLong(i13));
                }
                if (valueOf != null) {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                    i16 = d35;
                } else {
                    i16 = d35;
                    bool = null;
                }
                int i44 = d20;
                NetworkType e11 = a2.e((int) D0.getLong(i16));
                int i45 = d36;
                androidx.work.impl.utils.v l11 = a2.l(D0.getBlob(i45));
                int i46 = i16;
                int i47 = d37;
                if (((int) D0.getLong(i47)) != 0) {
                    i17 = d38;
                    z11 = true;
                } else {
                    i17 = d38;
                    z11 = false;
                }
                if (((int) D0.getLong(i17)) != 0) {
                    i18 = d39;
                    z12 = true;
                } else {
                    i18 = d39;
                    z12 = false;
                }
                int i48 = d21;
                int i49 = i17;
                if (((int) D0.getLong(i18)) != 0) {
                    i19 = d40;
                    z13 = true;
                } else {
                    i19 = d40;
                    z13 = false;
                }
                int i50 = i18;
                if (((int) D0.getLong(i19)) != 0) {
                    i20 = d41;
                    z14 = true;
                } else {
                    i20 = d41;
                    z14 = false;
                }
                int i51 = d42;
                int i52 = i13;
                int i53 = d43;
                d43 = i53;
                arrayList2.add(new j0(n03, g11, n04, n05, a11, a12, j11, j12, j13, new androidx.work.d(l11, e11, z11, z12, z13, z14, D0.getLong(i20), D0.getLong(i51), a2.b(D0.getBlob(i53))), i22, d44, j14, j15, j16, j17, z10, f11, i31, i34, j18, i38, i42, n02, bool));
                d11 = i26;
                d25 = i25;
                d42 = i51;
                d14 = i28;
                d15 = i30;
                d27 = i33;
                d26 = i27;
                d17 = i41;
                d19 = i15;
                d34 = i52;
                d24 = i21;
                d28 = i29;
                d29 = i32;
                d30 = i35;
                d32 = i40;
                d41 = i20;
                d16 = i37;
                d31 = i12;
                d13 = i24;
                d18 = i39;
                d33 = i14;
                arrayList = arrayList2;
                d12 = i23;
                d40 = i19;
                d20 = i44;
                d35 = i46;
                d36 = i45;
                d37 = i47;
                d38 = i49;
                d21 = i48;
                d39 = i50;
            }
            ArrayList arrayList3 = arrayList;
            D0.close();
            return arrayList3;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(androidx.work.f.f15565b.a(D0.getBlob(0)));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q0(String str, long j11, z3.b _connection) {
        int i11;
        int i12;
        boolean z10;
        String n02;
        int i13;
        int i14;
        int i15;
        int i16;
        Integer valueOf;
        int i17;
        Boolean bool;
        int i18;
        boolean z11;
        int i19;
        boolean z12;
        int i20;
        boolean z13;
        int i21;
        boolean z14;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.c(1, j11);
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "state");
            int d13 = androidx.room.util.k.d(D0, "worker_class_name");
            int d14 = androidx.room.util.k.d(D0, "input_merger_class_name");
            int d15 = androidx.room.util.k.d(D0, "input");
            int d16 = androidx.room.util.k.d(D0, "output");
            int d17 = androidx.room.util.k.d(D0, "initial_delay");
            int d18 = androidx.room.util.k.d(D0, "interval_duration");
            int d19 = androidx.room.util.k.d(D0, "flex_duration");
            int d20 = androidx.room.util.k.d(D0, "run_attempt_count");
            int d21 = androidx.room.util.k.d(D0, "backoff_policy");
            int d22 = androidx.room.util.k.d(D0, "backoff_delay_duration");
            int d23 = androidx.room.util.k.d(D0, "last_enqueue_time");
            int d24 = androidx.room.util.k.d(D0, "minimum_retention_duration");
            int d25 = androidx.room.util.k.d(D0, "schedule_requested_at");
            int d26 = androidx.room.util.k.d(D0, "run_in_foreground");
            int d27 = androidx.room.util.k.d(D0, "out_of_quota_policy");
            int d28 = androidx.room.util.k.d(D0, "period_count");
            int d29 = androidx.room.util.k.d(D0, "generation");
            int d30 = androidx.room.util.k.d(D0, "next_schedule_time_override");
            int d31 = androidx.room.util.k.d(D0, "next_schedule_time_override_generation");
            int d32 = androidx.room.util.k.d(D0, "stop_reason");
            int d33 = androidx.room.util.k.d(D0, "trace_tag");
            int d34 = androidx.room.util.k.d(D0, "backoff_on_system_interruptions");
            int d35 = androidx.room.util.k.d(D0, "required_network_type");
            int d36 = androidx.room.util.k.d(D0, "required_network_request");
            int d37 = androidx.room.util.k.d(D0, "requires_charging");
            int d38 = androidx.room.util.k.d(D0, "requires_device_idle");
            int d39 = androidx.room.util.k.d(D0, "requires_battery_not_low");
            int d40 = androidx.room.util.k.d(D0, "requires_storage_not_low");
            int d41 = androidx.room.util.k.d(D0, "trigger_content_update_delay");
            int d42 = androidx.room.util.k.d(D0, "trigger_max_content_delay");
            int d43 = androidx.room.util.k.d(D0, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n03 = D0.n0(d11);
                int i22 = d23;
                int i23 = d24;
                WorkInfo.State g11 = a2.g((int) D0.getLong(d12));
                String n04 = D0.n0(d13);
                String n05 = D0.n0(d14);
                byte[] blob = D0.getBlob(d15);
                f.b bVar = androidx.work.f.f15565b;
                androidx.work.f a11 = bVar.a(blob);
                androidx.work.f a12 = bVar.a(D0.getBlob(d16));
                long j12 = D0.getLong(d17);
                long j13 = D0.getLong(d18);
                long j14 = D0.getLong(d19);
                int i24 = (int) D0.getLong(d20);
                int i25 = d11;
                int i26 = d12;
                BackoffPolicy d44 = a2.d((int) D0.getLong(d21));
                long j15 = D0.getLong(d22);
                long j16 = D0.getLong(i22);
                long j17 = D0.getLong(i23);
                int i27 = d25;
                long j18 = D0.getLong(i27);
                d25 = i27;
                int i28 = d26;
                int i29 = d13;
                if (((int) D0.getLong(i28)) != 0) {
                    i11 = d27;
                    i12 = d14;
                    z10 = true;
                } else {
                    i11 = d27;
                    i12 = d14;
                    z10 = false;
                }
                OutOfQuotaPolicy f11 = a2.f((int) D0.getLong(i11));
                int i30 = d28;
                int i31 = i11;
                int i32 = (int) D0.getLong(i30);
                int i33 = d29;
                int i34 = (int) D0.getLong(i33);
                int i35 = d30;
                long j19 = D0.getLong(i35);
                int i36 = d31;
                int i37 = d15;
                int i38 = (int) D0.getLong(i36);
                int i39 = d17;
                int i40 = d32;
                int i41 = d16;
                int i42 = (int) D0.getLong(i40);
                int i43 = d33;
                if (D0.isNull(i43)) {
                    i13 = i36;
                    i14 = d34;
                    n02 = null;
                } else {
                    n02 = D0.n0(i43);
                    i13 = i36;
                    i14 = d34;
                }
                if (D0.isNull(i14)) {
                    i15 = i43;
                    i16 = d18;
                    valueOf = null;
                } else {
                    i15 = i43;
                    i16 = d18;
                    valueOf = Integer.valueOf((int) D0.getLong(i14));
                }
                if (valueOf != null) {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                    i17 = d35;
                } else {
                    i17 = d35;
                    bool = null;
                }
                int i44 = d19;
                NetworkType e11 = a2.e((int) D0.getLong(i17));
                int i45 = d36;
                androidx.work.impl.utils.v l11 = a2.l(D0.getBlob(i45));
                int i46 = i17;
                int i47 = d37;
                if (((int) D0.getLong(i47)) != 0) {
                    i18 = d38;
                    z11 = true;
                } else {
                    i18 = d38;
                    z11 = false;
                }
                if (((int) D0.getLong(i18)) != 0) {
                    i19 = d39;
                    z12 = true;
                } else {
                    i19 = d39;
                    z12 = false;
                }
                int i48 = d20;
                int i49 = i18;
                if (((int) D0.getLong(i19)) != 0) {
                    i20 = d40;
                    z13 = true;
                } else {
                    i20 = d40;
                    z13 = false;
                }
                int i50 = i19;
                if (((int) D0.getLong(i20)) != 0) {
                    i21 = d41;
                    z14 = true;
                } else {
                    i21 = d41;
                    z14 = false;
                }
                int i51 = d42;
                int i52 = i14;
                int i53 = d43;
                d43 = i53;
                arrayList.add(new j0(n03, g11, n04, n05, a11, a12, j12, j13, j14, new androidx.work.d(l11, e11, z11, z12, z13, z14, D0.getLong(i21), D0.getLong(i51), a2.b(D0.getBlob(i53))), i24, d44, j15, j16, j17, j18, z10, f11, i32, i34, j19, i38, i42, n02, bool));
                d13 = i29;
                d14 = i12;
                d42 = i51;
                d11 = i25;
                d27 = i31;
                d28 = i30;
                d29 = i33;
                d16 = i41;
                d18 = i16;
                d34 = i52;
                d23 = i22;
                d24 = i23;
                d12 = i26;
                d26 = i28;
                d30 = i35;
                d32 = i40;
                d41 = i21;
                d15 = i37;
                d31 = i13;
                d17 = i39;
                d33 = i15;
                d40 = i20;
                d19 = i44;
                d35 = i46;
                d36 = i45;
                d37 = i47;
                d38 = i49;
                d20 = i48;
                d39 = i50;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List r0(String str, z3.b _connection) {
        int i11;
        boolean z10;
        String n02;
        int i12;
        int i13;
        int i14;
        int i15;
        Integer valueOf;
        int i16;
        Boolean bool;
        int i17;
        boolean z11;
        int i18;
        boolean z12;
        int i19;
        boolean z13;
        int i20;
        boolean z14;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "state");
            int d13 = androidx.room.util.k.d(D0, "worker_class_name");
            int d14 = androidx.room.util.k.d(D0, "input_merger_class_name");
            int d15 = androidx.room.util.k.d(D0, "input");
            int d16 = androidx.room.util.k.d(D0, "output");
            int d17 = androidx.room.util.k.d(D0, "initial_delay");
            int d18 = androidx.room.util.k.d(D0, "interval_duration");
            int d19 = androidx.room.util.k.d(D0, "flex_duration");
            int d20 = androidx.room.util.k.d(D0, "run_attempt_count");
            int d21 = androidx.room.util.k.d(D0, "backoff_policy");
            int d22 = androidx.room.util.k.d(D0, "backoff_delay_duration");
            int d23 = androidx.room.util.k.d(D0, "last_enqueue_time");
            int d24 = androidx.room.util.k.d(D0, "minimum_retention_duration");
            int d25 = androidx.room.util.k.d(D0, "schedule_requested_at");
            int d26 = androidx.room.util.k.d(D0, "run_in_foreground");
            int d27 = androidx.room.util.k.d(D0, "out_of_quota_policy");
            int d28 = androidx.room.util.k.d(D0, "period_count");
            int d29 = androidx.room.util.k.d(D0, "generation");
            int d30 = androidx.room.util.k.d(D0, "next_schedule_time_override");
            int d31 = androidx.room.util.k.d(D0, "next_schedule_time_override_generation");
            int d32 = androidx.room.util.k.d(D0, "stop_reason");
            int d33 = androidx.room.util.k.d(D0, "trace_tag");
            int d34 = androidx.room.util.k.d(D0, "backoff_on_system_interruptions");
            int d35 = androidx.room.util.k.d(D0, "required_network_type");
            int d36 = androidx.room.util.k.d(D0, "required_network_request");
            int d37 = androidx.room.util.k.d(D0, "requires_charging");
            int d38 = androidx.room.util.k.d(D0, "requires_device_idle");
            int d39 = androidx.room.util.k.d(D0, "requires_battery_not_low");
            int d40 = androidx.room.util.k.d(D0, "requires_storage_not_low");
            int d41 = androidx.room.util.k.d(D0, "trigger_content_update_delay");
            int d42 = androidx.room.util.k.d(D0, "trigger_max_content_delay");
            int d43 = androidx.room.util.k.d(D0, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n03 = D0.n0(d11);
                int i21 = d24;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State g11 = a2.g((int) D0.getLong(d12));
                String n04 = D0.n0(d13);
                String n05 = D0.n0(d14);
                byte[] blob = D0.getBlob(d15);
                f.b bVar = androidx.work.f.f15565b;
                androidx.work.f a11 = bVar.a(blob);
                androidx.work.f a12 = bVar.a(D0.getBlob(d16));
                long j11 = D0.getLong(d17);
                long j12 = D0.getLong(d18);
                long j13 = D0.getLong(d19);
                int i22 = (int) D0.getLong(d20);
                int i23 = d12;
                int i24 = d13;
                BackoffPolicy d44 = a2.d((int) D0.getLong(d21));
                long j14 = D0.getLong(d22);
                long j15 = D0.getLong(d23);
                long j16 = D0.getLong(i21);
                int i25 = d25;
                long j17 = D0.getLong(i25);
                int i26 = d11;
                int i27 = d26;
                if (((int) D0.getLong(i27)) != 0) {
                    i11 = d27;
                    z10 = true;
                } else {
                    i11 = d27;
                    z10 = false;
                }
                int i28 = d14;
                OutOfQuotaPolicy f11 = a2.f((int) D0.getLong(i11));
                int i29 = d28;
                int i30 = d15;
                int i31 = (int) D0.getLong(i29);
                int i32 = d29;
                int i33 = i11;
                int i34 = (int) D0.getLong(i32);
                int i35 = d30;
                long j18 = D0.getLong(i35);
                int i36 = d31;
                int i37 = d16;
                int i38 = (int) D0.getLong(i36);
                int i39 = d18;
                int i40 = d32;
                int i41 = d17;
                int i42 = (int) D0.getLong(i40);
                int i43 = d33;
                if (D0.isNull(i43)) {
                    i12 = i36;
                    i13 = d34;
                    n02 = null;
                } else {
                    n02 = D0.n0(i43);
                    i12 = i36;
                    i13 = d34;
                }
                if (D0.isNull(i13)) {
                    i14 = i43;
                    i15 = d19;
                    valueOf = null;
                } else {
                    i14 = i43;
                    i15 = d19;
                    valueOf = Integer.valueOf((int) D0.getLong(i13));
                }
                if (valueOf != null) {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                    i16 = d35;
                } else {
                    i16 = d35;
                    bool = null;
                }
                int i44 = d20;
                NetworkType e11 = a2.e((int) D0.getLong(i16));
                int i45 = d36;
                androidx.work.impl.utils.v l11 = a2.l(D0.getBlob(i45));
                int i46 = i16;
                int i47 = d37;
                if (((int) D0.getLong(i47)) != 0) {
                    i17 = d38;
                    z11 = true;
                } else {
                    i17 = d38;
                    z11 = false;
                }
                if (((int) D0.getLong(i17)) != 0) {
                    i18 = d39;
                    z12 = true;
                } else {
                    i18 = d39;
                    z12 = false;
                }
                int i48 = d21;
                int i49 = i17;
                if (((int) D0.getLong(i18)) != 0) {
                    i19 = d40;
                    z13 = true;
                } else {
                    i19 = d40;
                    z13 = false;
                }
                int i50 = i18;
                if (((int) D0.getLong(i19)) != 0) {
                    i20 = d41;
                    z14 = true;
                } else {
                    i20 = d41;
                    z14 = false;
                }
                int i51 = d42;
                int i52 = i13;
                int i53 = d43;
                d43 = i53;
                arrayList2.add(new j0(n03, g11, n04, n05, a11, a12, j11, j12, j13, new androidx.work.d(l11, e11, z11, z12, z13, z14, D0.getLong(i20), D0.getLong(i51), a2.b(D0.getBlob(i53))), i22, d44, j14, j15, j16, j17, z10, f11, i31, i34, j18, i38, i42, n02, bool));
                d11 = i26;
                d25 = i25;
                d42 = i51;
                d14 = i28;
                d15 = i30;
                d27 = i33;
                d26 = i27;
                d17 = i41;
                d19 = i15;
                d34 = i52;
                d24 = i21;
                d28 = i29;
                d29 = i32;
                d30 = i35;
                d32 = i40;
                d41 = i20;
                d16 = i37;
                d31 = i12;
                d13 = i24;
                d18 = i39;
                d33 = i14;
                arrayList = arrayList2;
                d12 = i23;
                d40 = i19;
                d20 = i44;
                d35 = i46;
                d36 = i45;
                d37 = i47;
                d38 = i49;
                d21 = i48;
                d39 = i50;
            }
            ArrayList arrayList3 = arrayList;
            D0.close();
            return arrayList3;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List s0(String str, z3.b _connection) {
        int i11;
        boolean z10;
        String n02;
        int i12;
        int i13;
        int i14;
        int i15;
        Integer valueOf;
        int i16;
        Boolean bool;
        int i17;
        boolean z11;
        int i18;
        boolean z12;
        int i19;
        boolean z13;
        int i20;
        boolean z14;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "state");
            int d13 = androidx.room.util.k.d(D0, "worker_class_name");
            int d14 = androidx.room.util.k.d(D0, "input_merger_class_name");
            int d15 = androidx.room.util.k.d(D0, "input");
            int d16 = androidx.room.util.k.d(D0, "output");
            int d17 = androidx.room.util.k.d(D0, "initial_delay");
            int d18 = androidx.room.util.k.d(D0, "interval_duration");
            int d19 = androidx.room.util.k.d(D0, "flex_duration");
            int d20 = androidx.room.util.k.d(D0, "run_attempt_count");
            int d21 = androidx.room.util.k.d(D0, "backoff_policy");
            int d22 = androidx.room.util.k.d(D0, "backoff_delay_duration");
            int d23 = androidx.room.util.k.d(D0, "last_enqueue_time");
            int d24 = androidx.room.util.k.d(D0, "minimum_retention_duration");
            int d25 = androidx.room.util.k.d(D0, "schedule_requested_at");
            int d26 = androidx.room.util.k.d(D0, "run_in_foreground");
            int d27 = androidx.room.util.k.d(D0, "out_of_quota_policy");
            int d28 = androidx.room.util.k.d(D0, "period_count");
            int d29 = androidx.room.util.k.d(D0, "generation");
            int d30 = androidx.room.util.k.d(D0, "next_schedule_time_override");
            int d31 = androidx.room.util.k.d(D0, "next_schedule_time_override_generation");
            int d32 = androidx.room.util.k.d(D0, "stop_reason");
            int d33 = androidx.room.util.k.d(D0, "trace_tag");
            int d34 = androidx.room.util.k.d(D0, "backoff_on_system_interruptions");
            int d35 = androidx.room.util.k.d(D0, "required_network_type");
            int d36 = androidx.room.util.k.d(D0, "required_network_request");
            int d37 = androidx.room.util.k.d(D0, "requires_charging");
            int d38 = androidx.room.util.k.d(D0, "requires_device_idle");
            int d39 = androidx.room.util.k.d(D0, "requires_battery_not_low");
            int d40 = androidx.room.util.k.d(D0, "requires_storage_not_low");
            int d41 = androidx.room.util.k.d(D0, "trigger_content_update_delay");
            int d42 = androidx.room.util.k.d(D0, "trigger_max_content_delay");
            int d43 = androidx.room.util.k.d(D0, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n03 = D0.n0(d11);
                int i21 = d24;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State g11 = a2.g((int) D0.getLong(d12));
                String n04 = D0.n0(d13);
                String n05 = D0.n0(d14);
                byte[] blob = D0.getBlob(d15);
                f.b bVar = androidx.work.f.f15565b;
                androidx.work.f a11 = bVar.a(blob);
                androidx.work.f a12 = bVar.a(D0.getBlob(d16));
                long j11 = D0.getLong(d17);
                long j12 = D0.getLong(d18);
                long j13 = D0.getLong(d19);
                int i22 = (int) D0.getLong(d20);
                int i23 = d12;
                int i24 = d13;
                BackoffPolicy d44 = a2.d((int) D0.getLong(d21));
                long j14 = D0.getLong(d22);
                long j15 = D0.getLong(d23);
                long j16 = D0.getLong(i21);
                int i25 = d25;
                long j17 = D0.getLong(i25);
                int i26 = d11;
                int i27 = d26;
                if (((int) D0.getLong(i27)) != 0) {
                    i11 = d27;
                    z10 = true;
                } else {
                    i11 = d27;
                    z10 = false;
                }
                int i28 = d14;
                OutOfQuotaPolicy f11 = a2.f((int) D0.getLong(i11));
                int i29 = d28;
                int i30 = d15;
                int i31 = (int) D0.getLong(i29);
                int i32 = d29;
                int i33 = i11;
                int i34 = (int) D0.getLong(i32);
                int i35 = d30;
                long j18 = D0.getLong(i35);
                int i36 = d31;
                int i37 = d16;
                int i38 = (int) D0.getLong(i36);
                int i39 = d18;
                int i40 = d32;
                int i41 = d17;
                int i42 = (int) D0.getLong(i40);
                int i43 = d33;
                if (D0.isNull(i43)) {
                    i12 = i36;
                    i13 = d34;
                    n02 = null;
                } else {
                    n02 = D0.n0(i43);
                    i12 = i36;
                    i13 = d34;
                }
                if (D0.isNull(i13)) {
                    i14 = i43;
                    i15 = d19;
                    valueOf = null;
                } else {
                    i14 = i43;
                    i15 = d19;
                    valueOf = Integer.valueOf((int) D0.getLong(i13));
                }
                if (valueOf != null) {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                    i16 = d35;
                } else {
                    i16 = d35;
                    bool = null;
                }
                int i44 = d20;
                NetworkType e11 = a2.e((int) D0.getLong(i16));
                int i45 = d36;
                androidx.work.impl.utils.v l11 = a2.l(D0.getBlob(i45));
                int i46 = i16;
                int i47 = d37;
                if (((int) D0.getLong(i47)) != 0) {
                    i17 = d38;
                    z11 = true;
                } else {
                    i17 = d38;
                    z11 = false;
                }
                if (((int) D0.getLong(i17)) != 0) {
                    i18 = d39;
                    z12 = true;
                } else {
                    i18 = d39;
                    z12 = false;
                }
                int i48 = d21;
                int i49 = i17;
                if (((int) D0.getLong(i18)) != 0) {
                    i19 = d40;
                    z13 = true;
                } else {
                    i19 = d40;
                    z13 = false;
                }
                int i50 = i18;
                if (((int) D0.getLong(i19)) != 0) {
                    i20 = d41;
                    z14 = true;
                } else {
                    i20 = d41;
                    z14 = false;
                }
                int i51 = d42;
                int i52 = i13;
                int i53 = d43;
                d43 = i53;
                arrayList2.add(new j0(n03, g11, n04, n05, a11, a12, j11, j12, j13, new androidx.work.d(l11, e11, z11, z12, z13, z14, D0.getLong(i20), D0.getLong(i51), a2.b(D0.getBlob(i53))), i22, d44, j14, j15, j16, j17, z10, f11, i31, i34, j18, i38, i42, n02, bool));
                d11 = i26;
                d25 = i25;
                d42 = i51;
                d14 = i28;
                d15 = i30;
                d27 = i33;
                d26 = i27;
                d17 = i41;
                d19 = i15;
                d34 = i52;
                d24 = i21;
                d28 = i29;
                d29 = i32;
                d30 = i35;
                d32 = i40;
                d41 = i20;
                d16 = i37;
                d31 = i12;
                d13 = i24;
                d18 = i39;
                d33 = i14;
                arrayList = arrayList2;
                d12 = i23;
                d40 = i19;
                d20 = i44;
                d35 = i46;
                d36 = i45;
                d37 = i47;
                d38 = i49;
                d21 = i48;
                d39 = i50;
            }
            ArrayList arrayList3 = arrayList;
            D0.close();
            return arrayList3;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkInfo.State t0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            WorkInfo.State state = null;
            if (D0.A0()) {
                Integer valueOf = D0.isNull(0) ? null : Integer.valueOf((int) D0.getLong(0));
                if (valueOf != null) {
                    state = a2.g(valueOf.intValue());
                }
            }
            return state;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(D0.n0(0));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j0 v0(String str, String str2, z3.b _connection) {
        boolean z10;
        int i11;
        String n02;
        int i12;
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        boolean z13;
        int i15;
        boolean z14;
        int i16;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "state");
            int d13 = androidx.room.util.k.d(D0, "worker_class_name");
            int d14 = androidx.room.util.k.d(D0, "input_merger_class_name");
            int d15 = androidx.room.util.k.d(D0, "input");
            int d16 = androidx.room.util.k.d(D0, "output");
            int d17 = androidx.room.util.k.d(D0, "initial_delay");
            int d18 = androidx.room.util.k.d(D0, "interval_duration");
            int d19 = androidx.room.util.k.d(D0, "flex_duration");
            int d20 = androidx.room.util.k.d(D0, "run_attempt_count");
            int d21 = androidx.room.util.k.d(D0, "backoff_policy");
            int d22 = androidx.room.util.k.d(D0, "backoff_delay_duration");
            int d23 = androidx.room.util.k.d(D0, "last_enqueue_time");
            int d24 = androidx.room.util.k.d(D0, "minimum_retention_duration");
            int d25 = androidx.room.util.k.d(D0, "schedule_requested_at");
            int d26 = androidx.room.util.k.d(D0, "run_in_foreground");
            int d27 = androidx.room.util.k.d(D0, "out_of_quota_policy");
            int d28 = androidx.room.util.k.d(D0, "period_count");
            int d29 = androidx.room.util.k.d(D0, "generation");
            int d30 = androidx.room.util.k.d(D0, "next_schedule_time_override");
            int d31 = androidx.room.util.k.d(D0, "next_schedule_time_override_generation");
            int d32 = androidx.room.util.k.d(D0, "stop_reason");
            int d33 = androidx.room.util.k.d(D0, "trace_tag");
            int d34 = androidx.room.util.k.d(D0, "backoff_on_system_interruptions");
            int d35 = androidx.room.util.k.d(D0, "required_network_type");
            int d36 = androidx.room.util.k.d(D0, "required_network_request");
            int d37 = androidx.room.util.k.d(D0, "requires_charging");
            int d38 = androidx.room.util.k.d(D0, "requires_device_idle");
            int d39 = androidx.room.util.k.d(D0, "requires_battery_not_low");
            int d40 = androidx.room.util.k.d(D0, "requires_storage_not_low");
            int d41 = androidx.room.util.k.d(D0, "trigger_content_update_delay");
            int d42 = androidx.room.util.k.d(D0, "trigger_max_content_delay");
            int d43 = androidx.room.util.k.d(D0, "content_uri_triggers");
            j0 j0Var = null;
            Boolean bool = null;
            if (D0.A0()) {
                String n03 = D0.n0(d11);
                WorkInfo.State g11 = a2.g((int) D0.getLong(d12));
                String n04 = D0.n0(d13);
                String n05 = D0.n0(d14);
                byte[] blob = D0.getBlob(d15);
                f.b bVar = androidx.work.f.f15565b;
                androidx.work.f a11 = bVar.a(blob);
                androidx.work.f a12 = bVar.a(D0.getBlob(d16));
                long j11 = D0.getLong(d17);
                long j12 = D0.getLong(d18);
                long j13 = D0.getLong(d19);
                int i17 = (int) D0.getLong(d20);
                BackoffPolicy d44 = a2.d((int) D0.getLong(d21));
                long j14 = D0.getLong(d22);
                long j15 = D0.getLong(d23);
                long j16 = D0.getLong(d24);
                long j17 = D0.getLong(d25);
                if (((int) D0.getLong(d26)) != 0) {
                    i11 = d27;
                    z10 = true;
                } else {
                    z10 = false;
                    i11 = d27;
                }
                OutOfQuotaPolicy f11 = a2.f((int) D0.getLong(i11));
                int i18 = (int) D0.getLong(d28);
                int i19 = (int) D0.getLong(d29);
                long j18 = D0.getLong(d30);
                int i20 = (int) D0.getLong(d31);
                int i21 = (int) D0.getLong(d32);
                if (D0.isNull(d33)) {
                    i12 = d34;
                    n02 = null;
                } else {
                    n02 = D0.n0(d33);
                    i12 = d34;
                }
                Integer valueOf = D0.isNull(i12) ? null : Integer.valueOf((int) D0.getLong(i12));
                if (valueOf != null) {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                }
                Boolean bool2 = bool;
                NetworkType e11 = a2.e((int) D0.getLong(d35));
                androidx.work.impl.utils.v l11 = a2.l(D0.getBlob(d36));
                if (((int) D0.getLong(d37)) != 0) {
                    i13 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i13 = d38;
                }
                if (((int) D0.getLong(i13)) != 0) {
                    i14 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i14 = d39;
                }
                if (((int) D0.getLong(i14)) != 0) {
                    i15 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i15 = d40;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d41;
                    z14 = true;
                } else {
                    z14 = false;
                    i16 = d41;
                }
                j0Var = new j0(n03, g11, n04, n05, a11, a12, j11, j12, j13, new androidx.work.d(l11, e11, z11, z12, z13, z14, D0.getLong(i16), D0.getLong(d42), a2.b(D0.getBlob(d43))), i17, d44, j14, j15, j16, j17, z10, f11, i18, i19, j18, i20, i21, n02, bool2);
            }
            D0.close();
            return j0Var;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List w0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(new j0.b(D0.n0(0), a2.g((int) D0.getLong(1))));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List x0(String str, List list, r1 r1Var, z3.b _connection) {
        int i11;
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            Iterator it = list.iterator();
            int i12 = 1;
            int i13 = 1;
            while (it.hasNext()) {
                D0.j(i13, (String) it.next());
                i13++;
            }
            androidx.collection.a aVar = new androidx.collection.a();
            androidx.collection.a aVar2 = new androidx.collection.a();
            while (true) {
                i11 = 0;
                if (!D0.A0()) {
                    break;
                }
                String n02 = D0.n0(0);
                if (!aVar.containsKey(n02)) {
                    aVar.put(n02, new ArrayList());
                }
                String n03 = D0.n0(0);
                if (!aVar2.containsKey(n03)) {
                    aVar2.put(n03, new ArrayList());
                }
            }
            D0.reset();
            r1Var.i0(_connection, aVar);
            r1Var.g0(_connection, aVar2);
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n04 = D0.n0(i11);
                WorkInfo.State g11 = a2.g((int) D0.getLong(i12));
                androidx.work.f a11 = androidx.work.f.f15565b.a(D0.getBlob(2));
                int i14 = (int) D0.getLong(3);
                int i15 = (int) D0.getLong(4);
                long j11 = D0.getLong(14);
                long j12 = D0.getLong(15);
                long j13 = D0.getLong(16);
                androidx.collection.a aVar3 = aVar2;
                BackoffPolicy d11 = a2.d((int) D0.getLong(17));
                long j14 = D0.getLong(18);
                long j15 = D0.getLong(19);
                int i16 = (int) D0.getLong(20);
                long j16 = D0.getLong(21);
                int i17 = (int) D0.getLong(22);
                androidx.work.d dVar = new androidx.work.d(a2.l(D0.getBlob(6)), a2.e((int) D0.getLong(5)), ((int) D0.getLong(7)) != 0, ((int) D0.getLong(8)) != 0, ((int) D0.getLong(9)) != 0, ((int) D0.getLong(10)) != 0, D0.getLong(11), D0.getLong(12), a2.b(D0.getBlob(13)));
                Object i18 = MapsKt.i(aVar, D0.n0(0));
                Intrinsics.g(i18, "getValue(...)");
                List list2 = (List) i18;
                Object i19 = MapsKt.i(aVar3, D0.n0(0));
                Intrinsics.g(i19, "getValue(...)");
                arrayList.add(new j0.c(n04, g11, a11, j11, j12, j13, dVar, i14, d11, j14, j15, i16, i15, j16, i17, list2, (List) i19));
                aVar2 = aVar3;
                i12 = 1;
                i11 = 0;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y0(String str, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            boolean z10 = false;
            if (D0.A0()) {
                if (((int) D0.getLong(0)) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            D0.A0();
            D0.close();
            return Unit.f67184a;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // androidx.work.impl.model.k0
    public int A() {
        final String str = "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)";
        return ((Number) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int k02;
                k02 = r1.k0(str, (z3.b) obj);
                return Integer.valueOf(k02);
            }
        })).intValue();
    }

    @Override // androidx.work.impl.model.k0
    public void B(final String id2, final int i11) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = r1.E0(str, id2, i11, (z3.b) obj);
                return E0;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public void a(final String id2, final int i11) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET stop_reason=? WHERE id=?";
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = r1.K0(str, i11, id2, (z3.b) obj);
                return K0;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public void b(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "DELETE FROM workspec WHERE id=?";
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.m1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l02;
                l02 = r1.l0(str, id2, (z3.b) obj);
                return l02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public void c(final j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L0;
                L0 = r1.L0(r1.this, workSpec, (z3.b) obj);
                return L0;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public void d(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z02;
                z02 = r1.z0(str, id2, (z3.b) obj);
                return z02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public List e(final long j11) {
        final String str = "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.h1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List q02;
                q02 = r1.q0(str, j11, (z3.b) obj);
                return q02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public void f(final j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit B0;
                B0 = r1.B0(r1.this, workSpec, (z3.b) obj);
                return B0;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public List g() {
        final String str = "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List s02;
                s02 = r1.s0(str, (z3.b) obj);
                return s02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public List h(final String name) {
        Intrinsics.h(name, "name");
        final String str = "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List u02;
                u02 = r1.u0(str, name, (z3.b) obj);
                return u02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public WorkInfo.State i(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "SELECT state FROM workspec WHERE id=?";
        return (WorkInfo.State) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                WorkInfo.State t02;
                t02 = r1.t0(str, id2, (z3.b) obj);
                return t02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public j0 j(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "SELECT * FROM workspec WHERE id=?";
        return (j0) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                j0 v02;
                v02 = r1.v0(str, id2, (z3.b) obj);
                return v02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public int k(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
        return ((Number) androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int G0;
                G0 = r1.G0(str, id2, (z3.b) obj);
                return Integer.valueOf(G0);
            }
        })).intValue();
    }

    @Override // androidx.work.impl.model.k0
    public List l(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.d1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List p02;
                p02 = r1.p0(str, id2, (z3.b) obj);
                return p02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public List m(final int i11) {
        final String str = "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.o1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List m02;
                m02 = r1.m0(str, i11, (z3.b) obj);
                return m02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public int n() {
        final String str = "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        return ((Number) androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.p1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int D0;
                D0 = r1.D0(str, (z3.b) obj);
                return Integer.valueOf(D0);
            }
        })).intValue();
    }

    @Override // androidx.work.impl.model.k0
    public int o(final String id2, final long j11) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        return ((Number) androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int C0;
                C0 = r1.C0(str, j11, id2, (z3.b) obj);
                return Integer.valueOf(C0);
            }
        })).intValue();
    }

    @Override // androidx.work.impl.model.k0
    public List p(final String name) {
        Intrinsics.h(name, "name");
        final String str = "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.q1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List w02;
                w02 = r1.w0(str, name, (z3.b) obj);
                return w02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public kotlinx.coroutines.flow.b q() {
        final String str = "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1";
        return FlowUtil.a(this.f15925a, false, new String[]{"workspec"}, new Function1() { // from class: androidx.work.impl.model.n1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean y02;
                y02 = r1.y0(str, (z3.b) obj);
                return Boolean.valueOf(y02);
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public List r(final int i11) {
        final String str = "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List n02;
                n02 = r1.n0(str, i11, (z3.b) obj);
                return n02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public int s(final WorkInfo.State state, final String id2) {
        Intrinsics.h(state, "state");
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET state=? WHERE id=?";
        return ((Number) androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int J0;
                J0 = r1.J0(str, state, id2, (z3.b) obj);
                return Integer.valueOf(J0);
            }
        })).intValue();
    }

    @Override // androidx.work.impl.model.k0
    public void t(final String id2, final androidx.work.f output) {
        Intrinsics.h(id2, "id");
        Intrinsics.h(output, "output");
        final String str = "UPDATE workspec SET output=? WHERE id=?";
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I0;
                I0 = r1.I0(str, output, id2, (z3.b) obj);
                return I0;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public void u(final String id2, final long j11) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
        androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = r1.H0(str, j11, id2, (z3.b) obj);
                return H0;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public List v() {
        final String str = "SELECT * FROM workspec WHERE state=1";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List r02;
                r02 = r1.r0(str, (z3.b) obj);
                return r02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public List w() {
        final String str = "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time";
        return (List) androidx.room.util.b.d(this.f15925a, true, false, new Function1() { // from class: androidx.work.impl.model.j1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List o02;
                o02 = r1.o0(str, (z3.b) obj);
                return o02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public int x(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        return ((Number) androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int F0;
                F0 = r1.F0(str, id2, (z3.b) obj);
                return Integer.valueOf(F0);
            }
        })).intValue();
    }

    @Override // androidx.work.impl.model.k0
    public LiveData y(final List ids) {
        Intrinsics.h(ids, "ids");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        androidx.room.util.n.a(sb2, ids.size());
        sb2.append(")");
        final String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return this.f15925a.y().m(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Function1() { // from class: androidx.work.impl.model.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List x02;
                x02 = r1.x0(sb3, ids, this, (z3.b) obj);
                return x02;
            }
        });
    }

    @Override // androidx.work.impl.model.k0
    public int z(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        return ((Number) androidx.room.util.b.d(this.f15925a, false, true, new Function1() { // from class: androidx.work.impl.model.i1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int A0;
                A0 = r1.A0(str, id2, (z3.b) obj);
                return Integer.valueOf(A0);
            }
        })).intValue();
    }
}
