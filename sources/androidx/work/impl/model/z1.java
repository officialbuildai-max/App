package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class z1 implements v1 {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15969c = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f15970a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f15971b;

    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, t1 entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.a());
            statement.j(2, entity.b());
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

    public z1(RoomDatabase __db) {
        Intrinsics.h(__db, "__db");
        this.f15970a = __db;
        this.f15971b = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(String str, String str2, z3.b _connection) {
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
    public static final List i(String str, String str2, z3.b _connection) {
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
    public static final Unit j(z1 z1Var, t1 t1Var, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z1Var.f15971b.d(_connection, t1Var);
        return Unit.f67184a;
    }

    @Override // androidx.work.impl.model.v1
    public List a(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?";
        return (List) androidx.room.util.b.d(this.f15970a, true, false, new Function1() { // from class: androidx.work.impl.model.w1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List i11;
                i11 = z1.i(str, id2, (z3.b) obj);
                return i11;
            }
        });
    }

    @Override // androidx.work.impl.model.v1
    public void b(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "DELETE FROM worktag WHERE work_spec_id=?";
        androidx.room.util.b.d(this.f15970a, false, true, new Function1() { // from class: androidx.work.impl.model.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h11;
                h11 = z1.h(str, id2, (z3.b) obj);
                return h11;
            }
        });
    }

    @Override // androidx.work.impl.model.v1
    public void c(final t1 workTag) {
        Intrinsics.h(workTag, "workTag");
        androidx.room.util.b.d(this.f15970a, false, true, new Function1() { // from class: androidx.work.impl.model.x1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j11;
                j11 = z1.j(z1.this, workTag, (z3.b) obj);
                return j11;
            }
        });
    }

    @Override // androidx.work.impl.model.v1
    public /* synthetic */ void d(String str, Set set) {
        u1.a(this, str, set);
    }
}
