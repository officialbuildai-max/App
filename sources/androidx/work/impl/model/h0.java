package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class h0 implements e0 {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15836c = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f15837a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f15838b;

    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        public /* bridge */ /* synthetic */ void a(z3.e eVar, Object obj) {
            android.support.v4.media.session.c.a(obj);
            f(eVar, null);
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        protected void f(z3.e statement, d0 entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            throw null;
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

    public h0(RoomDatabase __db) {
        Intrinsics.h(__db, "__db");
        this.f15837a = __db;
        this.f15838b = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, String str2, z3.b _connection) {
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
    public static final Unit f(String str, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.A0();
            D0.close();
            return Unit.f67184a;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // androidx.work.impl.model.e0
    public void b(final String workSpecId) {
        Intrinsics.h(workSpecId, "workSpecId");
        final String str = "DELETE from WorkProgress where work_spec_id=?";
        androidx.room.util.b.d(this.f15837a, false, true, new Function1() { // from class: androidx.work.impl.model.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e11;
                e11 = h0.e(str, workSpecId, (z3.b) obj);
                return e11;
            }
        });
    }

    @Override // androidx.work.impl.model.e0
    public void c() {
        final String str = "DELETE FROM WorkProgress";
        androidx.room.util.b.d(this.f15837a, false, true, new Function1() { // from class: androidx.work.impl.model.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f11;
                f11 = h0.f(str, (z3.b) obj);
                return f11;
            }
        });
    }
}
