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
public final class g implements androidx.work.impl.model.b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15827c = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f15828a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f15829b;

    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, androidx.work.impl.model.a entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.b());
            statement.j(2, entity.a());
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

    public g(RoomDatabase __db) {
        Intrinsics.h(__db, "__db");
        this.f15828a = __db;
        this.f15829b = new a();
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
    public static final boolean j(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            boolean z10 = false;
            if (D0.A0()) {
                z10 = ((int) D0.getLong(0)) != 0;
            }
            return z10;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            boolean z10 = false;
            if (D0.A0()) {
                z10 = ((int) D0.getLong(0)) != 0;
            }
            return z10;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(g gVar, androidx.work.impl.model.a aVar, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        gVar.f15829b.d(_connection, aVar);
        return Unit.f67184a;
    }

    @Override // androidx.work.impl.model.b
    public void a(final androidx.work.impl.model.a dependency) {
        Intrinsics.h(dependency, "dependency");
        androidx.room.util.b.d(this.f15828a, false, true, new Function1() { // from class: androidx.work.impl.model.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l11;
                l11 = g.l(g.this, dependency, (z3.b) obj);
                return l11;
            }
        });
    }

    @Override // androidx.work.impl.model.b
    public List b(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?";
        return (List) androidx.room.util.b.d(this.f15828a, true, false, new Function1() { // from class: androidx.work.impl.model.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List i11;
                i11 = g.i(str, id2, (z3.b) obj);
                return i11;
            }
        });
    }

    @Override // androidx.work.impl.model.b
    public boolean c(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)";
        return ((Boolean) androidx.room.util.b.d(this.f15828a, true, false, new Function1() { // from class: androidx.work.impl.model.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean j11;
                j11 = g.j(str, id2, (z3.b) obj);
                return Boolean.valueOf(j11);
            }
        })).booleanValue();
    }

    @Override // androidx.work.impl.model.b
    public boolean d(final String id2) {
        Intrinsics.h(id2, "id");
        final String str = "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?";
        return ((Boolean) androidx.room.util.b.d(this.f15828a, true, false, new Function1() { // from class: androidx.work.impl.model.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean k11;
                k11 = g.k(str, id2, (z3.b) obj);
                return Boolean.valueOf(k11);
            }
        })).booleanValue();
    }
}
