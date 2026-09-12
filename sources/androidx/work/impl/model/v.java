package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class v implements q {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15943c = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f15944a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f15945b;

    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, o entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.f15907a);
            statement.c(2, entity.a());
            statement.c(3, entity.f15909c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.l();
        }
    }

    public v(RoomDatabase __db) {
        Intrinsics.h(__db, "__db");
        this.f15944a = __db;
        this.f15945b = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o j(String str, String str2, int i11, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            D0.c(2, i11);
            return D0.A0() ? new o(D0.n0(androidx.room.util.k.d(D0, "work_spec_id")), (int) D0.getLong(androidx.room.util.k.d(D0, "generation")), (int) D0.getLong(androidx.room.util.k.d(D0, "system_id"))) : null;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k(String str, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
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
    public static final Unit l(v vVar, o oVar, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        vVar.f15945b.d(_connection, oVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(String str, String str2, z3.b _connection) {
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

    @Override // androidx.work.impl.model.q
    public /* synthetic */ o a(x xVar) {
        return p.a(this, xVar);
    }

    @Override // androidx.work.impl.model.q
    public o b(final String workSpecId, final int i11) {
        Intrinsics.h(workSpecId, "workSpecId");
        final String str = "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?";
        return (o) androidx.room.util.b.d(this.f15944a, true, false, new Function1() { // from class: androidx.work.impl.model.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                o j11;
                j11 = v.j(str, workSpecId, i11, (z3.b) obj);
                return j11;
            }
        });
    }

    @Override // androidx.work.impl.model.q
    public List c() {
        final String str = "SELECT DISTINCT work_spec_id FROM SystemIdInfo";
        return (List) androidx.room.util.b.d(this.f15944a, true, false, new Function1() { // from class: androidx.work.impl.model.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List k11;
                k11 = v.k(str, (z3.b) obj);
                return k11;
            }
        });
    }

    @Override // androidx.work.impl.model.q
    public void d(final o systemIdInfo) {
        Intrinsics.h(systemIdInfo, "systemIdInfo");
        androidx.room.util.b.d(this.f15944a, false, true, new Function1() { // from class: androidx.work.impl.model.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l11;
                l11 = v.l(v.this, systemIdInfo, (z3.b) obj);
                return l11;
            }
        });
    }

    @Override // androidx.work.impl.model.q
    public void e(final String workSpecId) {
        Intrinsics.h(workSpecId, "workSpecId");
        final String str = "DELETE FROM SystemIdInfo where work_spec_id=?";
        androidx.room.util.b.d(this.f15944a, false, true, new Function1() { // from class: androidx.work.impl.model.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m11;
                m11 = v.m(str, workSpecId, (z3.b) obj);
                return m11;
            }
        });
    }
}
