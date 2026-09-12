package com.transsion.mbwidget.data;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.o;
import com.transsion.gslb.GslbSdk;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.y0;
import kotlinx.coroutines.o0;
import lg.a;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public final class SportWidgetDataManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile long f46301b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f46302c;

    /* renamed from: e, reason: collision with root package name */
    private static SportMatch f46304e;

    /* renamed from: f, reason: collision with root package name */
    private static final y0 f46305f;

    /* renamed from: g, reason: collision with root package name */
    private static final i1 f46306g;

    /* renamed from: a, reason: collision with root package name */
    public static final SportWidgetDataManager f46300a = new SportWidgetDataManager();

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f46303d = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a n11;
            n11 = SportWidgetDataManager.n();
            return n11;
        }
    });

    static {
        y0 a11 = j1.a(null);
        f46305f = a11;
        f46306g = a11;
    }

    private SportWidgetDataManager() {
    }

    private final void d() {
        f46301b = 0L;
        int i11 = Build.VERSION.SDK_INT;
        Context createDeviceProtectedStorageContext = i11 >= 24 ? GslbSdk.context.createDeviceProtectedStorageContext() : GslbSdk.context;
        Intent intent = new Intent(createDeviceProtectedStorageContext, (Class<?>) SportWidgetRefreshReceiver.class);
        intent.setAction("com.transsion.mbwidget.ACTION_MATCH_REFRESH");
        PendingIntent broadcast = PendingIntent.getBroadcast(createDeviceProtectedStorageContext, 202603051, intent, i11 >= 31 ? 201326592 : ASTNode.NOJIT);
        Object systemService = createDeviceProtectedStorageContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
        if (alarmManager != null) {
            alarmManager.cancel(broadcast);
        }
        lg.a.f68962a.c("SportWidget", "Cancel match refresh alarm", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        f46304e = null;
        kotlinx.coroutines.k.d(o0.a(kotlinx.coroutines.y0.b()), null, null, new SportWidgetDataManager$forceRefresh$1(null), 3, null);
    }

    private final SportMatch i() {
        try {
            String string = com.transsion.mbwidget.d.f46293a.k().getString("sport_widget_match_cache", null);
            if (string != null) {
                return (SportMatch) o.d(string, SportMatch.class);
            }
            return null;
        } catch (Exception e11) {
            a.C0856a.k(lg.a.f68962a, "SportWidget", "Get cached match error: " + e11.getMessage(), e11, false, 8, null);
            return null;
        }
    }

    private final a j() {
        return (a) f46303d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a n() {
        return (a) zg.c.f79537e.a().h(a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:12:0x003a, B:13:0x008d, B:17:0x00a0, B:19:0x00aa, B:21:0x00b2, B:22:0x00b6, B:24:0x00d4, B:26:0x00dc, B:27:0x011a, B:40:0x0104, B:42:0x0111), top: B:11:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:12:0x003a, B:13:0x008d, B:17:0x00a0, B:19:0x00aa, B:21:0x00b2, B:22:0x00b6, B:24:0x00d4, B:26:0x00dc, B:27:0x011a, B:40:0x0104, B:42:0x0111), top: B:11:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0111 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:12:0x003a, B:13:0x008d, B:17:0x00a0, B:19:0x00aa, B:21:0x00b2, B:22:0x00b6, B:24:0x00d4, B:26:0x00dc, B:27:0x011a, B:40:0x0104, B:42:0x0111), top: B:11:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.transsion.mbwidget.data.SportMatch, T] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.transsion.mbwidget.data.SportMatch, T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.data.SportWidgetDataManager.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void r(SportMatch sportMatch) {
        try {
            com.transsion.mbwidget.d.f46293a.k().putString("sport_widget_match_cache", o.j(sportMatch));
        } catch (Exception e11) {
            a.C0856a.k(lg.a.f68962a, "SportWidget", "Save cache error: " + e11.getMessage(), e11, false, 8, null);
        }
    }

    private final void s(SportMatch sportMatch) {
        if (sportMatch.getStatus() == MatchStatus.NOT_START && sportMatch.getMatchTime() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long matchTime = sportMatch.getMatchTime() + 300000;
            long j11 = matchTime - currentTimeMillis;
            if (j11 <= 0) {
                lg.a.f68962a.c("SportWidget", "Skip scheduleMatchRefresh: triggerAt=" + matchTime + ", now=" + currentTimeMillis + ", delta=" + j11 + ", matchId=" + sportMatch.getMatchId() + ", status=" + sportMatch.getStatus(), true);
                return;
            }
            long j12 = f46301b;
            if (currentTimeMillis + 1 <= j12 && j12 < matchTime) {
                lg.a.f68962a.c("SportWidget", "Skip scheduleMatchRefresh: keep earlier alarm at " + j12 + ", new trigger " + matchTime + " is later, matchId=" + sportMatch.getMatchId(), true);
                return;
            }
            int i11 = Build.VERSION.SDK_INT;
            Context createDeviceProtectedStorageContext = i11 >= 24 ? GslbSdk.context.createDeviceProtectedStorageContext() : GslbSdk.context;
            Intent intent = new Intent(createDeviceProtectedStorageContext, (Class<?>) SportWidgetRefreshReceiver.class);
            intent.setAction("com.transsion.mbwidget.ACTION_MATCH_REFRESH");
            PendingIntent broadcast = PendingIntent.getBroadcast(createDeviceProtectedStorageContext, 202603051, intent, i11 >= 31 ? 201326592 : ASTNode.NOJIT);
            Object systemService = createDeviceProtectedStorageContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
            if (alarmManager != null) {
                alarmManager.setAndAllowWhileIdle(0, matchTime, broadcast);
                f46301b = matchTime;
            }
            lg.a.f68962a.c("SportWidget", "Schedule match refresh at " + matchTime + " (in " + j11 + "ms), matchId=" + sportMatch.getMatchId(), true);
        }
    }

    private final SportMatch t() {
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("SportWidget", "Using fallback data...", true);
        SportMatch i11 = i();
        if (i11 == null) {
            c0856a.c("SportWidget", "Mock fallback disabled, return null to show Fallback UI", true);
            return null;
        }
        c0856a.c("SportWidget", "Use cached match as fallback: " + i11.getMatchId(), true);
        f46304e = i11;
        f46305f.setValue(i11);
        s(i11);
        return i11;
    }

    public final void e() {
        f46304e = null;
        f46305f.setValue(null);
    }

    public final Object g(Continuation continuation) {
        lg.a.f68962a.c("SportWidget", "Force refresh for match change (periodic or after match start)", true);
        Object q11 = q(continuation);
        return q11 == IntrinsicsKt.f() ? q11 : Unit.f67184a;
    }

    public final void h() {
        f46302c = true;
        lg.a.f68962a.c("SportWidget", "[Lab] forceRefresh triggered from Laboratory", true);
        f();
    }

    public final Object k(Continuation continuation) {
        if (f46304e == null) {
            return q(continuation);
        }
        a.C0856a c0856a = lg.a.f68962a;
        SportMatch sportMatch = f46304e;
        c0856a.c("SportWidget", "Return memory cached match: " + (sportMatch != null ? sportMatch.getMatchId() : null), true);
        return f46304e;
    }

    public final boolean l(SportMatch sportMatch) {
        return sportMatch != null && d.f46322a.a(sportMatch);
    }

    public final boolean m(SportMatch sportMatch) {
        return sportMatch != null && d.f46322a.b(sportMatch);
    }

    public final void o() {
        lg.a.f68962a.c("SportWidget", "All sport widgets removed, clear memory and persistent cache", true);
        d();
        f46304e = null;
        f46305f.setValue(null);
        try {
            com.transsion.mbwidget.d.f46293a.k().remove("sport_widget_match_cache");
        } catch (Exception e11) {
            a.C0856a.k(lg.a.f68962a, "SportWidget", "Clear persistent cache error: " + e11.getMessage(), e11, false, 8, null);
        }
    }

    public final void p() {
        lg.a.f68962a.c("SportWidget", "Refresh on user click (likely viewing live match)", true);
        kotlinx.coroutines.k.d(o0.a(kotlinx.coroutines.y0.c()), null, null, new SportWidgetDataManager$refreshOnUserClick$1(null), 3, null);
    }
}
