package xm;

import ak.z;
import android.os.Handler;
import android.os.Looper;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.report.l;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.member.c0;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberTaskGroup;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsnet.downloader.manager.p;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import dz.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import lj.m0;

/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f78504a;

    /* renamed from: b, reason: collision with root package name */
    private static final ILoginApi f78505b;

    /* renamed from: c, reason: collision with root package name */
    private static final List f78506c;

    /* renamed from: d, reason: collision with root package name */
    private static long f78507d;

    /* renamed from: e, reason: collision with root package name */
    private static long f78508e;

    /* renamed from: f, reason: collision with root package name */
    private static long f78509f;

    /* renamed from: g, reason: collision with root package name */
    private static long f78510g;

    /* renamed from: h, reason: collision with root package name */
    private static final List f78511h;

    /* renamed from: i, reason: collision with root package name */
    private static final IFissionProvider f78512i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f78513j;

    /* renamed from: k, reason: collision with root package name */
    private static MemberTaskItem f78514k;

    /* renamed from: l, reason: collision with root package name */
    private static long f78515l;

    /* renamed from: m, reason: collision with root package name */
    private static final b f78516m;

    /* renamed from: n, reason: collision with root package name */
    private static final c f78517n;

    /* renamed from: o, reason: collision with root package name */
    private static final Handler f78518o;

    /* renamed from: p, reason: collision with root package name */
    private static final Runnable f78519p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f78520q;

    /* loaded from: classes6.dex */
    public static final class a implements l.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemberTaskItem f78521a;

        a(MemberTaskItem memberTaskItem) {
            this.f78521a = memberTaskItem;
        }

        @Override // com.transsion.baselib.report.l.a
        public void onBackgroundStatusChange(boolean z10) {
            if (z10) {
                return;
            }
            xm.c cVar = new xm.c();
            Integer rewardAmount = this.f78521a.getRewardAmount();
            cVar.g(rewardAmount != null ? rewardAmount.intValue() : 0);
            com.transsion.baselib.report.l.f43413a.u(this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements m0 {
        b() {
        }

        @Override // lj.m0
        public void a(DownloadBean bean, DownloadException downloadException) {
            Intrinsics.h(bean, "bean");
        }

        @Override // lj.m0
        public void b(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
        }

        @Override // lj.m0
        public void c(DownloadBean bean, long j11, long j12) {
            Intrinsics.h(bean, "bean");
        }

        @Override // lj.m0
        public void d(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
        }

        @Override // lj.m0
        public void e(DownloadBean bean, String str) {
            Intrinsics.h(bean, "bean");
            a.C0856a.f(lg.a.f68962a, "TaskManager", "download success " + bean, false, 4, null);
            k kVar = k.f78504a;
            kVar.m();
            kVar.c0(bean.getSubjectType());
        }

        @Override // lj.m0
        public void f(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
        }

        @Override // lj.m0
        public void g(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements dz.a {
        c() {
        }

        @Override // dz.a
        public void onLogin(UserInfo user) {
            Intrinsics.h(user, "user");
            k kVar = k.f78504a;
            kVar.x();
            kVar.K();
            kVar.y();
        }

        @Override // dz.a
        public void onLogout() {
            k kVar = k.f78504a;
            kVar.x();
            kVar.K();
            kVar.y();
        }

        @Override // dz.a
        public void onUpdateUserInfo(UserInfo userInfo) {
            a.C0761a.c(this, userInfo);
        }
    }

    static {
        k kVar = new k();
        f78504a = kVar;
        f78505b = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        f78506c = new ArrayList();
        f78511h = new ArrayList();
        f78512i = (IFissionProvider) TheRouter.d(IFissionProvider.class, new Object[0]);
        kVar.K();
        f78516m = new b();
        f78517n = new c();
        f78518o = new Handler(Looper.getMainLooper());
        f78519p = new Runnable() { // from class: xm.d
            @Override // java.lang.Runnable
            public final void run() {
                k.A();
            }
        };
        f78520q = 8;
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        f78504a.z();
    }

    private final boolean B(String str, boolean z10) {
        UserInfo i11;
        MMKV b11 = c0.f46483a.b();
        ILoginApi iLoginApi = f78505b;
        return b11.getBoolean(str + "_" + ((iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId()), z10);
    }

    private final int E(String str, int i11) {
        UserInfo i12;
        MMKV b11 = c0.f46483a.b();
        ILoginApi iLoginApi = f78505b;
        return b11.getInt(str + "_" + ((iLoginApi == null || (i12 = iLoginApi.i()) == null) ? null : i12.getUserId()), i11);
    }

    private final long F(String str, long j11) {
        UserInfo i11;
        MMKV b11 = c0.f46483a.b();
        ILoginApi iLoginApi = f78505b;
        return b11.getLong(str + "_" + ((iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId()), j11);
    }

    private final long J() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 4);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        z.f734b.a().d(new Runnable() { // from class: xm.g
            @Override // java.lang.Runnable
            public final void run() {
                k.L();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L() {
        k kVar = f78504a;
        long J = kVar.J();
        if (kVar.F("kv_watch_remember_time", 0L) > J) {
            f78508e = J;
            long F = kVar.F("kv_watch_today_time", 0L);
            f78507d = F;
            f78510g = F;
            a.C0856a.f(lg.a.f68962a, "TaskManager", "init watch time " + f78507d, false, 4, null);
        }
    }

    private final void M() {
        IFissionProvider iFissionProvider = f78512i;
        if (iFissionProvider != null) {
            iFissionProvider.b(f78513j);
        }
    }

    private final void P(String str, boolean z10) {
        UserInfo i11;
        MMKV b11 = c0.f46483a.b();
        ILoginApi iLoginApi = f78505b;
        b11.putBoolean(str + "_" + ((iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId()), z10);
    }

    private final void Q(String str, int i11) {
        UserInfo i12;
        MMKV b11 = c0.f46483a.b();
        ILoginApi iLoginApi = f78505b;
        b11.putInt(str + "_" + ((iLoginApi == null || (i12 = iLoginApi.i()) == null) ? null : i12.getUserId()), i11);
    }

    private final void R(String str, long j11) {
        UserInfo i11;
        MMKV b11 = c0.f46483a.b();
        ILoginApi iLoginApi = f78505b;
        b11.putLong(str + "_" + ((iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId()), j11);
    }

    private final void U() {
        z.f734b.a().d(new Runnable() { // from class: xm.f
            @Override // java.lang.Runnable
            public final void run() {
                k.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V() {
        k kVar = f78504a;
        long J = kVar.J();
        long F = kVar.F("kv_watch_remember_time", 0L);
        if (1 <= F && F < J) {
            a.C0856a.f(lg.a.f68962a, "TaskManager", "clear last day time " + f78507d, false, 4, null);
            f78507d = 30000L;
        }
        kVar.s();
        f78508e = J;
        f78510g = f78507d;
        kVar.R("kv_watch_remember_time", System.currentTimeMillis());
        kVar.R("kv_watch_today_time", f78507d);
        a.C0856a.f(lg.a.f68962a, "TaskManager", "save watch time " + f78507d, false, 4, null);
    }

    private final void Z() {
        p.a aVar = p.f59623a;
        com.transsnet.downloader.manager.g a11 = aVar.a(Utils.a());
        b bVar = f78516m;
        a11.x(bVar);
        aVar.a(Utils.a()).e(bVar);
        ILoginApi iLoginApi = f78505b;
        if (iLoginApi != null) {
            iLoginApi.p(f78517n);
        }
        if (iLoginApi != null) {
            iLoginApi.g(f78517n);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r2.intValue() == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b0(com.transsion.memberapi.MemberTaskItem r2) {
        /*
            r1 = this;
            java.lang.Integer r2 = r2.getStatus()
            if (r2 != 0) goto L7
            goto Lf
        L7:
            int r2 = r2.intValue()
            r0 = 1
            if (r2 != r0) goto Lf
            goto L10
        Lf:
            r0 = 0
        L10:
            xm.k.f78513j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xm.k.b0(com.transsion.memberapi.MemberTaskItem):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(int i11) {
        IFissionProvider iFissionProvider;
        if (f78513j && (iFissionProvider = f78512i) != null) {
            iFissionProvider.f(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        z.f734b.a().d(new Runnable() { // from class: xm.i
            @Override // java.lang.Runnable
            public final void run() {
                k.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        k kVar = f78504a;
        long J = kVar.J();
        long F = kVar.F("kv_watch_download_save_time", 0L);
        int i11 = 0;
        int E = kVar.E("kv_watch_download_count", 0);
        if (1 > F || F >= J) {
            i11 = E;
        } else {
            a.C0856a.f(lg.a.f68962a, "TaskManager", "clear download count", false, 4, null);
        }
        kVar.q(i11);
        kVar.R("kv_watch_download_save_time", System.currentTimeMillis());
        kVar.Q("kv_watch_download_count", i11 + 1);
        a.C0856a.f(lg.a.f68962a, "TaskManager", "save download count " + f78507d, false, 4, null);
    }

    private final void o() {
        MemberTaskItem memberTaskItem;
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = f78515l;
        long j12 = currentTimeMillis - j11;
        long j13 = 0;
        if (j11 <= 0 || j12 <= 0) {
            return;
        }
        long J = J();
        long F = F("kv_game_browse_remember_time", 0L);
        long F2 = j12 + F("kv_game_browse_today_time", 0L);
        boolean B = B("kv_game_browse_complete", false);
        if (J > F) {
            P("kv_game_browse_complete", false);
            B = false;
        } else {
            j13 = F2;
        }
        R("kv_game_browse_remember_time", System.currentTimeMillis());
        if (B || ((memberTaskItem = f78514k) != null && memberTaskItem.isClaimCompleted())) {
            a.C0856a.v(lg.a.f68962a, "TaskManager", "游戏，统计浏览时长任务已经完成", false, 4, null);
            f78518o.removeCallbacksAndMessages(null);
            return;
        }
        MemberTaskItem memberTaskItem2 = f78514k;
        if (memberTaskItem2 != null) {
            long j14 = j13 / 1000;
            Intrinsics.e(memberTaskItem2);
            if (j14 >= (memberTaskItem2.getDurationCondition() != null ? r2.intValue() : 300000)) {
                P("kv_game_browse_complete", true);
                a.C0856a.r(lg.a.f68962a, "TaskManager", new String[]{"游戏，统计浏览时长，任务完成"}, false, 4, null);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: xm.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.p();
                    }
                });
                f78518o.removeCallbacksAndMessages(null);
                R("kv_game_browse_today_time", j13);
            }
        }
        a.C0856a c0856a = lg.a.f68962a;
        long j15 = j13 / 1000;
        MemberTaskItem memberTaskItem3 = f78514k;
        a.C0856a.r(c0856a, "TaskManager", new String[]{"游戏，统计浏览时长，任务未完成，curDuration:" + j15 + ", target:" + (memberTaskItem3 != null ? memberTaskItem3.getDurationCondition() : null)}, false, 4, null);
        P("kv_game_browse_complete", false);
        R("kv_game_browse_today_time", j13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        Integer rewardAmount;
        xm.c cVar = new xm.c();
        MemberTaskItem memberTaskItem = f78514k;
        cVar.g((memberTaskItem == null || (rewardAmount = memberTaskItem.getRewardAmount()) == null) ? 0 : rewardAmount.intValue());
    }

    private final void q(int i11) {
        for (final MemberTaskItem memberTaskItem : f78511h) {
            if (i11 == (memberTaskItem.getTimesCondition() != null ? r2.intValue() : 0) - 1) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: xm.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.r(MemberTaskItem.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MemberTaskItem memberTaskItem) {
        com.transsion.baselib.report.l lVar = com.transsion.baselib.report.l.f43413a;
        if (lVar.q()) {
            lVar.g(new a(memberTaskItem));
            return;
        }
        xm.c cVar = new xm.c();
        Integer rewardAmount = memberTaskItem.getRewardAmount();
        cVar.g(rewardAmount != null ? rewardAmount.intValue() : 0);
    }

    private final void s() {
        if (f78509f == 0) {
            return;
        }
        for (final MemberTaskItem memberTaskItem : f78506c) {
            Integer durationCondition = memberTaskItem.getDurationCondition();
            long j11 = 1000;
            long intValue = durationCondition != null ? durationCondition.intValue() : 0;
            if (f78510g / j11 < intValue && f78507d / j11 >= intValue) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: xm.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.t(MemberTaskItem.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(MemberTaskItem memberTaskItem) {
        xm.c cVar = new xm.c();
        Integer rewardAmount = memberTaskItem.getRewardAmount();
        cVar.g(rewardAmount != null ? rewardAmount.intValue() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        f78507d = 0L;
        f78508e = 0L;
        f78509f = 0L;
        f78510g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.h();
        }
    }

    private final void z() {
        o();
        f78515l = System.currentTimeMillis();
        f78518o.postDelayed(f78519p, MBInterstitialActivity.WEB_LOAD_TIME);
    }

    public final int C() {
        int i11 = 0;
        int E = E("kv_game_download_app_claim", 0);
        if (E <= 0) {
            return E;
        }
        long J = J();
        long F = F("kv_game_download_app_remember_time", 0L);
        if (1 > F || F >= J) {
            i11 = E;
        } else {
            a.C0856a.v(lg.a.f68962a, "TaskManager", "游戏app下载，跨天了，重置状态", false, 4, null);
        }
        R("kv_game_download_app_remember_time", System.currentTimeMillis());
        return i11;
    }

    public final long D() {
        long currentTimeMillis = System.currentTimeMillis() - f78515l;
        long F = F("kv_game_browse_today_time", 0L);
        if (f78515l <= 0 || currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        return (currentTimeMillis + F) / 60000;
    }

    public final int G() {
        long F = F("kv_watch_download_save_time", 0L);
        int E = E("kv_watch_download_count", 0);
        if (J() <= F) {
            return E;
        }
        u();
        return 0;
    }

    public final int H() {
        long F = F("kv_play_save_game_time", 0L);
        long F2 = F("kv_play_game_time", 0L);
        if (J() <= F) {
            return (int) (F2 / 1000);
        }
        w();
        return 0;
    }

    public final int I() {
        if (f78508e != J()) {
            return 0;
        }
        return (int) (f78507d / 60000);
    }

    public final void N(long j11) {
        f78507d += j11 - f78509f;
        f78509f = 0L;
        U();
    }

    public final void O(long j11) {
        long j12 = f78509f;
        if (j11 > j12) {
            f78507d += j11 - j12;
        }
        f78509f = j11;
        if (f78507d - f78510g > 60000) {
            U();
        }
    }

    public final void S(MemberTaskInfo memberTaskInfo) {
        List<MemberTaskGroup> arrayList;
        f78506c.clear();
        f78511h.clear();
        if (memberTaskInfo == null || (arrayList = memberTaskInfo.getList()) == null) {
            arrayList = new ArrayList<>();
        }
        Iterator<MemberTaskGroup> it = arrayList.iterator();
        while (it.hasNext()) {
            for (MemberTaskItem memberTaskItem : it.next().getTaskItems()) {
                Integer taskSubType = memberTaskItem.getTaskSubType();
                int value = TaskType.WATCH.getValue();
                if (taskSubType != null && taskSubType.intValue() == value) {
                    f78506c.add(memberTaskItem);
                } else {
                    int value2 = TaskType.DOWNLOAD_MOVIE.getValue();
                    if (taskSubType != null && taskSubType.intValue() == value2) {
                        f78511h.add(memberTaskItem);
                    } else {
                        int value3 = TaskType.GAME_RES_BROWSE.getValue();
                        if (taskSubType != null && taskSubType.intValue() == value3) {
                            f78514k = memberTaskItem;
                        }
                    }
                }
            }
        }
        Z();
    }

    public final void T(List list) {
        f78506c.clear();
        f78511h.clear();
        if (list == null) {
            list = new ArrayList();
        }
        for (MemberTaskItem memberTaskItem : list) {
            Integer taskSubType = memberTaskItem.getTaskSubType();
            int value = TaskType.WATCH.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                f78506c.add(memberTaskItem);
            } else {
                int value2 = TaskType.DOWNLOAD_MOVIE.getValue();
                if (taskSubType != null && taskSubType.intValue() == value2) {
                    f78511h.add(memberTaskItem);
                } else {
                    int value3 = TaskType.PALM_PAY.getValue();
                    if (taskSubType != null && taskSubType.intValue() == value3) {
                        b0(memberTaskItem);
                    } else {
                        int value4 = TaskType.GAME_RES_BROWSE.getValue();
                        if (taskSubType != null && taskSubType.intValue() == value4) {
                            f78514k = memberTaskItem;
                        } else {
                            a.C0856a.f(lg.a.f68962a, "TaskManager", "taskItem: " + memberTaskItem + " that is not support now, please check it.", false, 4, null);
                        }
                    }
                }
            }
        }
        M();
        Z();
    }

    public final void W() {
        a.C0856a.f(lg.a.f68962a, "TaskManager", "游戏下载任务完成", false, 4, null);
        R("kv_game_download_app_remember_time", System.currentTimeMillis());
        Q("kv_game_download_app_claim", 1);
    }

    public final void X(long j11) {
        if (j11 > H()) {
            R("kv_play_save_game_time", System.currentTimeMillis());
            R("kv_play_game_time", j11);
        }
    }

    public final void Y() {
        if (f78514k == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "TaskManager", "游戏，startGameResDurationTracking", false, 4, null);
        f78515l = System.currentTimeMillis();
        f78518o.post(f78519p);
    }

    public final void a0() {
        if (f78514k == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "TaskManager", "游戏，stopGameResDurationTracking", false, 4, null);
        o();
        f78518o.removeCallbacksAndMessages(null);
    }

    public final void u() {
        R("kv_watch_download_save_time", System.currentTimeMillis());
        Q("kv_watch_download_count", 0);
    }

    public final void v() {
        R("kv_game_download_app_remember_time", System.currentTimeMillis());
        Q("kv_game_download_app_claim", 0);
    }

    public final void w() {
        R("kv_play_save_game_time", System.currentTimeMillis());
        R("kv_play_game_time", 0L);
    }
}
