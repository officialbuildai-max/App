package mj;

import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.util.k;
import com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import z3.e;

/* loaded from: classes6.dex */
public final class d implements mj.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69733a;

    /* renamed from: b, reason: collision with root package name */
    private final g f69734b = new a();

    /* loaded from: classes6.dex */
    class a extends g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `home_preferences_interval_time` (`id`,`showTime`,`closeTime`,`chooseTime`,`showIntervalSeconds`,`closeIntervalSeconds`,`chooseIntervalSeconds`) VALUES (?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(e eVar, HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean) {
            if (homePreferencesIntervalTimeDbBean.getId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, homePreferencesIntervalTimeDbBean.getId());
            }
            eVar.c(2, homePreferencesIntervalTimeDbBean.getShowTime());
            eVar.c(3, homePreferencesIntervalTimeDbBean.getCloseTime());
            eVar.c(4, homePreferencesIntervalTimeDbBean.getChooseTime());
            eVar.c(5, homePreferencesIntervalTimeDbBean.getShowIntervalSeconds());
            eVar.c(6, homePreferencesIntervalTimeDbBean.getCloseIntervalSeconds());
            eVar.c(7, homePreferencesIntervalTimeDbBean.getChooseIntervalSeconds());
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.f69733a = roomDatabase;
    }

    public static List e() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit f(HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, z3.b bVar) {
        this.f69734b.d(bVar, homePreferencesIntervalTimeDbBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HomePreferencesIntervalTimeDbBean g(String str, z3.b bVar) {
        e D0 = bVar.D0("\n        SELECT * FROM home_preferences_interval_time\n        WHERE id = ?\n        LIMIT 1\n    ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "showTime");
            int d13 = k.d(D0, "closeTime");
            int d14 = k.d(D0, "chooseTime");
            int d15 = k.d(D0, "showIntervalSeconds");
            int d16 = k.d(D0, "closeIntervalSeconds");
            int d17 = k.d(D0, "chooseIntervalSeconds");
            HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean = null;
            if (D0.A0()) {
                homePreferencesIntervalTimeDbBean = new HomePreferencesIntervalTimeDbBean(D0.isNull(d11) ? null : D0.n0(d11), D0.getLong(d12), D0.getLong(d13), D0.getLong(d14), D0.getLong(d15), D0.getLong(d16), D0.getLong(d17));
            }
            D0.close();
            return homePreferencesIntervalTimeDbBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // mj.a
    public Object a(final HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, Continuation continuation) {
        homePreferencesIntervalTimeDbBean.getClass();
        return androidx.room.util.b.f(this.f69733a, false, true, new Function1() { // from class: mj.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f11;
                f11 = d.this.f(homePreferencesIntervalTimeDbBean, (z3.b) obj);
                return f11;
            }
        }, continuation);
    }

    @Override // mj.a
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69733a, true, false, new Function1() { // from class: mj.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomePreferencesIntervalTimeDbBean g11;
                g11 = d.g(str, (z3.b) obj);
                return g11;
            }
        }, continuation);
    }
}
