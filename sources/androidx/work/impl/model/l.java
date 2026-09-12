package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class l implements i {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15896c = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f15897a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f15898b;

    /* loaded from: classes2.dex */
    public static final class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, h entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.a());
            Long b11 = entity.b();
            if (b11 == null) {
                statement.g(2);
            } else {
                statement.c(2, b11.longValue());
            }
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

    public l(RoomDatabase __db) {
        Intrinsics.h(__db, "__db");
        this.f15897a = __db;
        this.f15898b = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long d(String str, String str2, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        z3.e D0 = _connection.D0(str);
        try {
            D0.j(1, str2);
            Long l11 = null;
            if (D0.A0() && !D0.isNull(0)) {
                l11 = Long.valueOf(D0.getLong(0));
            }
            return l11;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(l lVar, h hVar, z3.b _connection) {
        Intrinsics.h(_connection, "_connection");
        lVar.f15898b.d(_connection, hVar);
        return Unit.f67184a;
    }

    @Override // androidx.work.impl.model.i
    public void a(final h preference) {
        Intrinsics.h(preference, "preference");
        androidx.room.util.b.d(this.f15897a, false, true, new Function1() { // from class: androidx.work.impl.model.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e11;
                e11 = l.e(l.this, preference, (z3.b) obj);
                return e11;
            }
        });
    }

    @Override // androidx.work.impl.model.i
    public Long getLongValue(final String key) {
        Intrinsics.h(key, "key");
        final String str = "SELECT long_value FROM Preference where `key`=?";
        return (Long) androidx.room.util.b.d(this.f15897a, true, false, new Function1() { // from class: androidx.work.impl.model.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Long d11;
                d11 = l.d(str, key, (z3.b) obj);
                return d11;
            }
        });
    }
}
