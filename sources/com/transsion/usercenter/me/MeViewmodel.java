package com.transsion.usercenter.me;

import android.app.Application;
import android.content.res.Resources;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.kids.KidsAccountManager;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberInfo;
import com.transsion.push.PushConstants;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.profile.bean.BffFavoriteInfo;
import com.transsion.usercenter.profile.bean.CountInfo;
import com.transsion.usercenter.profile.bean.IconItemInfo;
import com.transsion.usercenter.profile.bean.MeHistoryInfo;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsion.usercenter.profile.bean.MineNoticeConfig;
import com.transsion.usercenter.profile.bean.MineNovel;
import com.transsion.usercenter.profile.bean.MinePageInfo;
import com.transsion.usercenter.profile.bean.MyGroup;
import com.transsion.usercenter.profile.bean.MySubject;
import com.transsion.usercenter.profile.bean.SubscribeInfo;
import com.transsion.usercenter.profile.bean.ZeroConfig;
import com.transsion.usercenter.profile.bean.ZeroInfo;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class MeViewmodel extends androidx.view.b {

    /* renamed from: s, reason: collision with root package name */
    public static final a f57015s = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f57016b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f57017c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f57018d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f57019e;

    /* renamed from: f, reason: collision with root package name */
    private final List f57020f;

    /* renamed from: g, reason: collision with root package name */
    private ZeroConfig f57021g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f57022h;

    /* renamed from: i, reason: collision with root package name */
    private MineNoticeConfig f57023i;

    /* renamed from: j, reason: collision with root package name */
    private final int f57024j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.view.b0 f57025k;

    /* renamed from: l, reason: collision with root package name */
    private volatile List f57026l;

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f57027m;

    /* renamed from: n, reason: collision with root package name */
    private final Lazy f57028n;

    /* renamed from: o, reason: collision with root package name */
    private final Lazy f57029o;

    /* renamed from: p, reason: collision with root package name */
    private MinePageInfo f57030p;

    /* renamed from: q, reason: collision with root package name */
    private final androidx.view.b0 f57031q;

    /* renamed from: r, reason: collision with root package name */
    private t1 f57032r;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeViewmodel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f57016b = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.usercenter.profile.b Q;
                Q = MeViewmodel.Q();
                return Q;
            }
        });
        this.f57017c = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi P;
                P = MeViewmodel.P();
                return P;
            }
        });
        this.f57018d = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IPremiumApi O;
                O = MeViewmodel.O();
                return O;
            }
        });
        this.f57019e = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IMemberApi N;
                N = MeViewmodel.N();
                return N;
            }
        });
        this.f57020f = new ArrayList();
        this.f57022h = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.usercenter.profile.d R;
                R = MeViewmodel.R();
                return R;
            }
        });
        this.f57024j = 10;
        this.f57025k = new androidx.view.b0();
        this.f57026l = new ArrayList();
        this.f57027m = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoDetailPlayDao W;
                W = MeViewmodel.W();
                return W;
            }
        });
        this.f57028n = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortTVPlayDao U;
                U = MeViewmodel.U();
                return U;
            }
        });
        this.f57029o = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UGCVideoDetailPlayDao V;
                V = MeViewmodel.V();
                return V;
            }
        });
        this.f57031q = new androidx.view.b0();
    }

    private final void B() {
        try {
            Result.Companion companion = Result.INSTANCE;
            ConfigBean c11 = sm.f.f75530c.a().c("free_buy_config", true);
            this.f57021g = (ZeroConfig) com.blankj.utilcode.util.o.e(c11 != null ? c11.getValue() : null, com.blankj.utilcode.util.o.h(ZeroConfig.class, new Type[0]));
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final IMemberApi D() {
        return (IMemberApi) this.f57019e.getValue();
    }

    private final IPremiumApi E() {
        return (IPremiumApi) this.f57018d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi F() {
        return (ILoginApi) this.f57017c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b G() {
        return (com.transsion.usercenter.profile.b) this.f57016b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.d H() {
        return (com.transsion.usercenter.profile.d) this.f57022h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        try {
            Result.Companion companion = Result.INSTANCE;
            ConfigBean c11 = sm.f.f75530c.a().c("mine_notice_config_key", true);
            this.f57023i = (MineNoticeConfig) com.blankj.utilcode.util.o.e(c11 != null ? c11.getValue() : null, com.blankj.utilcode.util.o.h(MineNoticeConfig.class, new Type[0]));
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTVPlayDao K() {
        return (ShortTVPlayDao) this.f57028n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCVideoDetailPlayDao L() {
        return (UGCVideoDetailPlayDao) this.f57029o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao M() {
        return (VideoDetailPlayDao) this.f57027m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMemberApi N() {
        return (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPremiumApi O() {
        return (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi P() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b Q() {
        return (com.transsion.usercenter.profile.b) zg.c.f79537e.a().h(com.transsion.usercenter.profile.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.d R() {
        return (com.transsion.usercenter.profile.d) tw.b.f76528c.a().e(com.transsion.usercenter.profile.d.class);
    }

    private final void S() {
        UserInfo i11;
        ArrayList arrayList = new ArrayList();
        Resources resources = Utils.a().getResources();
        MinePageInfo minePageInfo = this.f57030p;
        if (minePageInfo == null || (i11 = minePageInfo.getUserInfo()) == null) {
            ILoginApi F = F();
            i11 = F != null ? F.i() : null;
        }
        arrayList.add(new MeItemInfo(1, i11));
        arrayList.add(new MeItemInfo(4, new MeHistoryInfo(this.f57026l)));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_switch_profile), null, "study_mode_type", R$drawable.ic_me_switch_profile, com.transsion.baseui.R$drawable.bg_radius_bottom_6_color_white_6p, false, 0, false, "study_mode", false, 736, null)));
        this.f57031q.n(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        UserInfo i11;
        String bottomContent;
        String str;
        String noticeContent;
        SubscribeInfo subscribeInfo;
        Integer subscribeCount;
        CountInfo myComment;
        CountInfo myLike;
        CountInfo myPost;
        BffFavoriteInfo favoriteInfo;
        Integer favoriteCount;
        MySubject mySubject;
        MyGroup myGroup;
        ak.o oVar = ak.o.f721a;
        if (oVar.i()) {
            S();
            return;
        }
        ArrayList arrayList = new ArrayList();
        MinePageInfo minePageInfo = this.f57030p;
        Resources resources = Utils.a().getResources();
        if (minePageInfo == null || (i11 = minePageInfo.getUserInfo()) == null) {
            ILoginApi F = F();
            i11 = F != null ? F.i() : null;
        }
        MemberInfo vipInfo = minePageInfo != null ? minePageInfo.getVipInfo() : null;
        MineNovel novelEntry = minePageInfo != null ? minePageInfo.getNovelEntry() : null;
        int count = (minePageInfo == null || (myGroup = minePageInfo.getMyGroup()) == null) ? 0 : myGroup.getCount();
        int wantToSeeCount = (minePageInfo == null || (mySubject = minePageInfo.getMySubject()) == null) ? 0 : mySubject.getWantToSeeCount();
        int intValue = (minePageInfo == null || (favoriteInfo = minePageInfo.getFavoriteInfo()) == null || (favoriteCount = favoriteInfo.getFavoriteCount()) == null) ? 0 : favoriteCount.intValue();
        int count2 = (minePageInfo == null || (myPost = minePageInfo.getMyPost()) == null) ? 0 : myPost.getCount();
        int count3 = (minePageInfo == null || (myLike = minePageInfo.getMyLike()) == null) ? 0 : myLike.getCount();
        int count4 = (minePageInfo == null || (myComment = minePageInfo.getMyComment()) == null) ? 0 : myComment.getCount();
        int intValue2 = (minePageInfo == null || (subscribeInfo = minePageInfo.getSubscribeInfo()) == null || (subscribeCount = subscribeInfo.getSubscribeCount()) == null) ? 0 : subscribeCount.intValue();
        arrayList.add(new MeItemInfo(1, i11));
        MineNoticeConfig mineNoticeConfig = this.f57023i;
        if (mineNoticeConfig != null && mineNoticeConfig.getNoticeEnable() && (noticeContent = mineNoticeConfig.getNoticeContent()) != null && noticeContent.length() != 0) {
            arrayList.add(new MeItemInfo(8, mineNoticeConfig));
        }
        if (vipInfo != null) {
            arrayList.add(new MeItemInfo(2, vipInfo));
            IPremiumApi E = E();
            boolean u11 = E != null ? E.u() : false;
            IPremiumApi E2 = E();
            boolean k11 = E2 != null ? E2.k() : false;
            ILoginApi F2 = F();
            boolean a11 = F2 != null ? F2.a() : false;
            IMemberApi D = D();
            boolean f11 = D != null ? D.f() : false;
            if (a11 && ((u11 || k11) && f11)) {
                String string = resources.getString(R$string.user_linked_devices);
                Integer deviceCount = vipInfo.getDeviceCount();
                if (deviceCount == null || (str = deviceCount.toString()) == null) {
                    str = "0";
                }
                arrayList.add(new MeItemInfo(5, new IconItemInfo(string, str, null, R$drawable.user_linked_devices_icon, com.transsion.baseui.R$drawable.bg_radius_bottom_6_color_white_6p, false, 0, false, "linked_devices", false, 704, null)));
            }
            arrayList.add(new MeItemInfo(11, vipInfo));
        }
        ZeroInfo zeroInfo = (ZeroInfo) CollectionsKt.k0(this.f57020f);
        if (zeroInfo != null) {
            arrayList.add(new MeItemInfo(3, zeroInfo));
        }
        if (novelEntry != null) {
            arrayList.add(new MeItemInfo(7, novelEntry));
        }
        ak.g gVar = ak.g.f714a;
        String str2 = gVar.b() ? "/postdetail/favorite" : "/profile/see";
        if (gVar.b()) {
            wantToSeeCount = intValue;
        }
        arrayList.add(new MeItemInfo(4, new MeHistoryInfo(this.f57026l)));
        if (gVar.b()) {
            arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.profile_my_subscribers), String.valueOf(intValue2), "subscribe_list_type", R$drawable.ic_me_subscriptions, R$color.white_6, true, 0, false, PushConstants.TOPIC_SUBSCRIBE, false, 704, null)));
        }
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.profile_your_list), String.valueOf(wantToSeeCount), "oneroom://com.community.oneroom" + str2, R$drawable.ic_me_my_list, R$color.white_6, true, dk.a.b(0), false, "want_to_see", false, 640, null)));
        arrayList.add(new MeItemInfo(6, null));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_tv_download_web_link), null, null, R$drawable.ic_me_tv_download_web_link, com.transsion.baseui.R$drawable.bg_radius_bottom_6_color_white_6p, false, 0, false, "tv_download_web_link", com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("key_tv_download_web_link_clicked", false) ^ true, PsExtractor.AUDIO_STREAM, null)));
        String string2 = resources.getString(R$string.profile_my_room);
        String valueOf = String.valueOf(count);
        ILoginApi F3 = F();
        arrayList.add(new MeItemInfo(5, new IconItemInfo(string2, valueOf, (F3 == null || !F3.a()) ? "oneroom://com.community.oneroom/room/list?index=1" : "oneroom://com.community.oneroom/room/list", R$drawable.ic_me_room, com.transsion.baseui.R$drawable.bg_radius_top_6_color_white_6p, true, dk.a.b(8), false, "myrooms", false, 512, null)));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(com.tn.lib.widget.R$string.my_activity), String.valueOf(count2 + count3 + count4), "my_activity_type", R$drawable.ic_mine_activity, com.transsion.baseui.R$drawable.bg_radius_bottom_6_color_white_6p, false, 0, false, "my_activity", false, 608, null)));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_setting), null, "oneroom://com.community.oneroom/profile/setting", R$drawable.ic_me_setting, com.transsion.baseui.R$drawable.bg_radius_top_6_color_white_6p, true, dk.a.b(8), false, "setting", false, 640, null)));
        KidsAccountManager kidsAccountManager = KidsAccountManager.f43340a;
        String e11 = kidsAccountManager.e();
        if (e11 != null && e11.length() != 0 && oVar.j()) {
            arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_parental_pin), resources.getString(!kidsAccountManager.i() ? R$string.user_parental_pin_hint : R$string.user_parental_pin_hint_on), "parental_pin_type", R$drawable.ic_user_kids_settings_pin, R$color.white_6, true, 0, false, "parental_pin", false, 704, null)));
        }
        if (oVar.j()) {
            arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_safe_kids), resources.getString((e11 == null || e11.length() == 0) ? R$string.user_create_study_profile : R$string.user_switch_profile), "study_mode_type", R$drawable.ic_me_study_mode, R$color.white_6, true, 0, false, "study_mode", false, 704, null)));
        }
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_setting_feedback), null, "oneroom://com.community.oneroom/profile/user_center_labels_feedback", R$drawable.ic_me_feedback, com.transsion.baseui.R$drawable.bg_radius_bottom_6_color_white_6p, false, 0, false, TmcConstants.MENU_KEY_FEEDBACK, false, 736, null)));
        MineNoticeConfig mineNoticeConfig2 = this.f57023i;
        if (mineNoticeConfig2 != null && (bottomContent = mineNoticeConfig2.getBottomContent()) != null && bottomContent.length() != 0) {
            arrayList.add(new MeItemInfo(9, mineNoticeConfig2));
        }
        this.f57031q.n(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao U() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao V() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao W() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    public final void A() {
        if (this.f57021g == null) {
            B();
        }
        a.C0856a.f(lg.a.f68962a, "MeViewmodel", "zeroConfig:" + this.f57021g, false, 4, null);
        ZeroConfig zeroConfig = this.f57021g;
        if (zeroConfig == null || !zeroConfig.getEnable()) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new MeViewmodel$fetchPurchase$1(this, null), 2, null);
    }

    public final androidx.view.b0 C() {
        return this.f57025k;
    }

    public final androidx.view.b0 I() {
        return this.f57031q;
    }

    public final void y() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new MeViewmodel$fetchHistory$1(this, null), 2, null);
    }

    public final void z() {
        t1 d11;
        y();
        t1 t1Var = this.f57032r;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        d11 = kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new MeViewmodel$fetchProfile$1(this, null), 2, null);
        this.f57032r = d11;
    }
}
