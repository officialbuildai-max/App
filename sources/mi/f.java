package mi;

import androidx.room.RoomDatabase;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.transsion.ad.db.pslink.AppInstalledBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class f implements mi.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69695a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f69696b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f69697c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f69698d = new c();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `app_installed` (`packageName`,`source`,`appName`,`versionName`,`versionCode`,`horizontalImageUrl`,`eCPM`,`installTime`,`lastOpenTime`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AppInstalledBean appInstalledBean) {
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, appInstalledBean.getPackageName());
            }
            if (appInstalledBean.getSource() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, appInstalledBean.getSource());
            }
            if (appInstalledBean.getAppName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, appInstalledBean.getAppName());
            }
            if (appInstalledBean.getVersionName() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, appInstalledBean.getVersionName());
            }
            if (appInstalledBean.getVersionCode() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, appInstalledBean.getVersionCode());
            }
            if (appInstalledBean.getHorizontalImageUrl() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, appInstalledBean.getHorizontalImageUrl());
            }
            if (appInstalledBean.getECPM() == null) {
                eVar.g(7);
            } else {
                eVar.a(7, appInstalledBean.getECPM().doubleValue());
            }
            if (appInstalledBean.getInstallTime() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, appInstalledBean.getInstallTime().longValue());
            }
            if (appInstalledBean.getLastOpenTime() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, appInstalledBean.getLastOpenTime().longValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `app_installed` WHERE `packageName` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AppInstalledBean appInstalledBean) {
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, appInstalledBean.getPackageName());
            }
        }
    }

    /* loaded from: classes6.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `app_installed` SET `packageName` = ?,`source` = ?,`appName` = ?,`versionName` = ?,`versionCode` = ?,`horizontalImageUrl` = ?,`eCPM` = ?,`installTime` = ?,`lastOpenTime` = ? WHERE `packageName` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AppInstalledBean appInstalledBean) {
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, appInstalledBean.getPackageName());
            }
            if (appInstalledBean.getSource() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, appInstalledBean.getSource());
            }
            if (appInstalledBean.getAppName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, appInstalledBean.getAppName());
            }
            if (appInstalledBean.getVersionName() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, appInstalledBean.getVersionName());
            }
            if (appInstalledBean.getVersionCode() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, appInstalledBean.getVersionCode());
            }
            if (appInstalledBean.getHorizontalImageUrl() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, appInstalledBean.getHorizontalImageUrl());
            }
            if (appInstalledBean.getECPM() == null) {
                eVar.g(7);
            } else {
                eVar.a(7, appInstalledBean.getECPM().doubleValue());
            }
            if (appInstalledBean.getInstallTime() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, appInstalledBean.getInstallTime().longValue());
            }
            if (appInstalledBean.getLastOpenTime() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, appInstalledBean.getLastOpenTime().longValue());
            }
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, appInstalledBean.getPackageName());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f69695a = roomDatabase;
    }

    public static List i() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(long j11, z3.b bVar) {
        z3.e D0 = bVar.D0("\n        SELECT * FROM app_installed\n        WHERE lastOpenTime IS NOT NULL\n        AND lastOpenTime >= ?\n    ");
        try {
            D0.c(1, j11);
            int d11 = androidx.room.util.k.d(D0, "packageName");
            int d12 = androidx.room.util.k.d(D0, EventConstants.KEY_SOURCE);
            int d13 = androidx.room.util.k.d(D0, MiniAppIpcConfig.IPC_ADDHOME_APP_NAME);
            int d14 = androidx.room.util.k.d(D0, "versionName");
            int d15 = androidx.room.util.k.d(D0, "versionCode");
            int d16 = androidx.room.util.k.d(D0, "horizontalImageUrl");
            int d17 = androidx.room.util.k.d(D0, "eCPM");
            int d18 = androidx.room.util.k.d(D0, "installTime");
            int d19 = androidx.room.util.k.d(D0, "lastOpenTime");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(new AppInstalledBean(D0.isNull(d11) ? null : D0.n0(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15), D0.isNull(d16) ? null : D0.n0(d16), D0.isNull(d17) ? null : Double.valueOf(D0.getDouble(d17)), D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18)), D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19))));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AppInstalledBean k(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM app_installed WHERE packageName = ? LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "packageName");
            int d12 = androidx.room.util.k.d(D0, EventConstants.KEY_SOURCE);
            int d13 = androidx.room.util.k.d(D0, MiniAppIpcConfig.IPC_ADDHOME_APP_NAME);
            int d14 = androidx.room.util.k.d(D0, "versionName");
            int d15 = androidx.room.util.k.d(D0, "versionCode");
            int d16 = androidx.room.util.k.d(D0, "horizontalImageUrl");
            int d17 = androidx.room.util.k.d(D0, "eCPM");
            int d18 = androidx.room.util.k.d(D0, "installTime");
            int d19 = androidx.room.util.k.d(D0, "lastOpenTime");
            AppInstalledBean appInstalledBean = null;
            if (D0.A0()) {
                appInstalledBean = new AppInstalledBean(D0.isNull(d11) ? null : D0.n0(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15), D0.isNull(d16) ? null : D0.n0(d16), D0.isNull(d17) ? null : Double.valueOf(D0.getDouble(d17)), D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18)), D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19)));
            }
            D0.close();
            return appInstalledBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long l(AppInstalledBean appInstalledBean, z3.b bVar) {
        return Long.valueOf(this.f69696b.e(bVar, appInstalledBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit m(long j11, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("\n        UPDATE app_installed \n        SET lastOpenTime = ? \n        WHERE packageName = ?\n    ");
        try {
            D0.c(1, j11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // mi.a
    public Object a(final AppInstalledBean appInstalledBean, Continuation continuation) {
        appInstalledBean.getClass();
        return androidx.room.util.b.f(this.f69695a, false, true, new Function1() { // from class: mi.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Long l11;
                l11 = f.this.l(appInstalledBean, (z3.b) obj);
                return l11;
            }
        }, continuation);
    }

    @Override // mi.a
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69695a, true, false, new Function1() { // from class: mi.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                AppInstalledBean k11;
                k11 = f.k(str, (z3.b) obj);
                return k11;
            }
        }, continuation);
    }

    @Override // mi.a
    public Object c(final String str, final long j11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69695a, false, true, new Function1() { // from class: mi.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m11;
                m11 = f.m(j11, str, (z3.b) obj);
                return m11;
            }
        }, continuation);
    }

    @Override // mi.a
    public Object d(final long j11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69695a, true, false, new Function1() { // from class: mi.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List j12;
                j12 = f.j(j11, (z3.b) obj);
                return j12;
            }
        }, continuation);
    }
}
