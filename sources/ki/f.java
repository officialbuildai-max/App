package ki;

import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.util.k;
import com.transsion.ad.db.mcc.LocalMcc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class f implements ki.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f66913a;

    /* renamed from: b, reason: collision with root package name */
    private final g f66914b = new a();

    /* loaded from: classes6.dex */
    class a extends g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `local_mcc` (`id`,`Country`,`Mcc`,`Iso`,`CountryCode`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, LocalMcc localMcc) {
            eVar.c(1, localMcc.getId());
            if (localMcc.getCountry() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, localMcc.getCountry());
            }
            if (localMcc.getMcc() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, localMcc.getMcc());
            }
            if (localMcc.getIso() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, localMcc.getIso());
            }
            if (localMcc.getCountryCode() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, localMcc.getCountryCode());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f66913a = roomDatabase;
    }

    public static List i() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM local_mcc");
        try {
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "Country");
            int d13 = k.d(D0, "Mcc");
            int d14 = k.d(D0, "Iso");
            int d15 = k.d(D0, "CountryCode");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(new LocalMcc((int) D0.getLong(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15)));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LocalMcc k(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM local_mcc LIMIT 1");
        try {
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "Country");
            int d13 = k.d(D0, "Mcc");
            int d14 = k.d(D0, "Iso");
            int d15 = k.d(D0, "CountryCode");
            LocalMcc localMcc = null;
            if (D0.A0()) {
                localMcc = new LocalMcc((int) D0.getLong(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15));
            }
            return localMcc;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List l(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM local_mcc WHERE Iso = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "Country");
            int d13 = k.d(D0, "Mcc");
            int d14 = k.d(D0, "Iso");
            int d15 = k.d(D0, "CountryCode");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(new LocalMcc((int) D0.getLong(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15)));
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(List list, z3.b bVar) {
        this.f66914b.c(bVar, list);
        return Unit.f67184a;
    }

    @Override // ki.a
    public Object a(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.f66913a, false, true, new Function1() { // from class: ki.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m11;
                m11 = f.this.m(list, (z3.b) obj);
                return m11;
            }
        }, continuation);
    }

    @Override // ki.a
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f66913a, true, false, new Function1() { // from class: ki.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List l11;
                l11 = f.l(str, (z3.b) obj);
                return l11;
            }
        }, continuation);
    }

    @Override // ki.a
    public Object c(Continuation continuation) {
        return androidx.room.util.b.f(this.f66913a, true, false, new Function1() { // from class: ki.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List j11;
                j11 = f.j((z3.b) obj);
                return j11;
            }
        }, continuation);
    }

    @Override // ki.a
    public Object d(Continuation continuation) {
        return androidx.room.util.b.f(this.f66913a, true, false, new Function1() { // from class: ki.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                LocalMcc k11;
                k11 = f.k((z3.b) obj);
                return k11;
            }
        }, continuation);
    }
}
