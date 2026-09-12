package com.transsion.member.premium;

import android.app.Activity;
import android.view.ViewTreeObserver;
import androidx.view.c0;
import androidx.view.u;
import androidx.view.v;
import androidx.view.v0;
import androidx.view.y0;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$string;
import com.transsion.member.MemberViewModel;
import com.transsion.member.dialog.MemberBasicDialog;
import com.transsion.member.dialog.MemberPromoCodeDialog;
import com.transsion.member.premium.PremiumContentController;
import com.transsion.member.promotion.PromotionManager;
import com.transsion.member.view.PremiumContentView;
import com.transsion.memberapi.AllMemberRightsData;
import com.transsion.memberapi.FeatureRights;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberFeatureData;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MemberPriceData;
import com.transsion.memberapi.MemberPriceItem;
import com.transsion.memberapi.RightsMapData;
import com.transsion.memberapi.SkuPromotionDto;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class PremiumContentController {

    /* renamed from: a, reason: collision with root package name */
    private final y0 f46653a;

    /* renamed from: b, reason: collision with root package name */
    private final u f46654b;

    /* renamed from: c, reason: collision with root package name */
    private final PremiumContentView f46655c;

    /* renamed from: d, reason: collision with root package name */
    private final a f46656d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f46657e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f46658f;

    /* renamed from: g, reason: collision with root package name */
    private MemberPriceData f46659g;

    /* renamed from: h, reason: collision with root package name */
    private SkuPromotionDto f46660h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f46661i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f46662j;

    /* renamed from: k, reason: collision with root package name */
    private Activity f46663k;

    /* renamed from: l, reason: collision with root package name */
    private final d f46664l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f46665m;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Function1 f46666a;

        /* renamed from: b, reason: collision with root package name */
        private final Function0 f46667b;

        /* renamed from: c, reason: collision with root package name */
        private final Function0 f46668c;

        public a() {
            this(null, null, null, 7, null);
        }

        public a(Function1 onMemberDetailChanged, Function0 onMemberDetailLoadFailed, Function0 onDismissLoading) {
            Intrinsics.h(onMemberDetailChanged, "onMemberDetailChanged");
            Intrinsics.h(onMemberDetailLoadFailed, "onMemberDetailLoadFailed");
            Intrinsics.h(onDismissLoading, "onDismissLoading");
            this.f46666a = onMemberDetailChanged;
            this.f46667b = onMemberDetailLoadFailed;
            this.f46668c = onDismissLoading;
        }

        public /* synthetic */ a(Function1 function1, Function0 function0, Function0 function02, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new Function1() { // from class: com.transsion.member.premium.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit d11;
                    d11 = PremiumContentController.a.d((MemberDetail) obj);
                    return d11;
                }
            } : function1, (i11 & 2) != 0 ? new Function0() { // from class: com.transsion.member.premium.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit e11;
                    e11 = PremiumContentController.a.e();
                    return e11;
                }
            } : function0, (i11 & 4) != 0 ? new Function0() { // from class: com.transsion.member.premium.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit f11;
                    f11 = PremiumContentController.a.f();
                    return f11;
                }
            } : function02);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(MemberDetail it) {
            Intrinsics.h(it, "it");
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e() {
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f() {
            return Unit.f67184a;
        }

        public final Function0 g() {
            return this.f46668c;
        }

        public final Function1 h() {
            return this.f46666a;
        }

        public final Function0 i() {
            return this.f46667b;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Function0 {
        b() {
        }

        public void a() {
            PremiumContentController.this.I();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f67184a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MemberDetail f46671b;

        c(MemberDetail memberDetail) {
            this.f46671b = memberDetail;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Integer daysLeft;
            PremiumContentController.this.f46655c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            PremiumContentController premiumContentController = PremiumContentController.this;
            MemberInfo memberInfo = this.f46671b.getMemberInfo();
            int i11 = 0;
            int vipLevel = memberInfo != null ? memberInfo.getVipLevel() : 0;
            MemberInfo memberInfo2 = this.f46671b.getMemberInfo();
            if (memberInfo2 != null && (daysLeft = memberInfo2.getDaysLeft()) != null) {
                i11 = daysLeft.intValue();
            }
            premiumContentController.u(vipLevel, i11);
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements zm.f {
        d() {
        }

        @Override // zm.f
        public void a(Integer num, String str) {
        }

        @Override // zm.f
        public void b() {
            PremiumContentController.this.J();
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MemberInfo memberInfo;
            Integer daysLeft;
            MemberInfo memberInfo2;
            PremiumContentController.this.f46655c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            PremiumContentController premiumContentController = PremiumContentController.this;
            MemberDetail memberDetail = (MemberDetail) premiumContentController.v().D().f();
            int i11 = 0;
            int vipLevel = (memberDetail == null || (memberInfo2 = memberDetail.getMemberInfo()) == null) ? 0 : memberInfo2.getVipLevel();
            MemberDetail memberDetail2 = (MemberDetail) PremiumContentController.this.v().D().f();
            if (memberDetail2 != null && (memberInfo = memberDetail2.getMemberInfo()) != null && (daysLeft = memberInfo.getDaysLeft()) != null) {
                i11 = daysLeft.intValue();
            }
            premiumContentController.u(vipLevel, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class f implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f46674a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f46674a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f46674a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f46674a.invoke(obj);
        }
    }

    public PremiumContentController(y0 viewModelStoreOwner, u lifecycleOwner, PremiumContentView contentView, a callbacks) {
        Intrinsics.h(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.h(lifecycleOwner, "lifecycleOwner");
        Intrinsics.h(contentView, "contentView");
        Intrinsics.h(callbacks, "callbacks");
        this.f46653a = viewModelStoreOwner;
        this.f46654b = lifecycleOwner;
        this.f46655c = contentView;
        this.f46656d = callbacks;
        this.f46657e = LazyKt.b(new Function0() { // from class: com.transsion.member.premium.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MemberViewModel C;
                C = PremiumContentController.C(PremiumContentController.this);
                return C;
            }
        });
        this.f46658f = LazyKt.b(new Function0() { // from class: com.transsion.member.premium.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PromotionManager H;
                H = PremiumContentController.H();
                return H;
            }
        });
        this.f46664l = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A() {
        ak.k.h("oneroom://com.community.oneroom/profile/user_center_labels_feedback", null, 1, null);
        return Unit.f67184a;
    }

    private final void B() {
        v().u();
        v().x();
        v().O();
        kotlinx.coroutines.k.d(v.a(this.f46654b), null, null, new PremiumContentController$loadInitialData$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemberViewModel C(PremiumContentController premiumContentController) {
        return (MemberViewModel) new v0(premiumContentController.f46653a).a(MemberViewModel.class);
    }

    private final void D() {
        v().D().j(this.f46654b, new f(new Function1() { // from class: com.transsion.member.premium.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E;
                E = PremiumContentController.E(PremiumContentController.this, (MemberDetail) obj);
                return E;
            }
        }));
        v().E().j(this.f46654b, new f(new Function1() { // from class: com.transsion.member.premium.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = PremiumContentController.F(PremiumContentController.this, (MemberPriceData) obj);
                return F;
            }
        }));
        v().A().j(this.f46654b, new f(new Function1() { // from class: com.transsion.member.premium.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G;
                G = PremiumContentController.G(PremiumContentController.this, (AllMemberRightsData) obj);
                return G;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(PremiumContentController premiumContentController, MemberDetail memberDetail) {
        if (memberDetail != null) {
            premiumContentController.f46655c.setMemberDetail(memberDetail);
            premiumContentController.f46656d.h().invoke(memberDetail);
            premiumContentController.f46655c.getViewTreeObserver().addOnGlobalLayoutListener(new c(memberDetail));
        } else {
            premiumContentController.f46656d.i().invoke();
            if (nh.m.f70597a.e()) {
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.failed_toast);
            } else {
                uh.b.f76876a.d(R$string.no_network_toast);
            }
        }
        premiumContentController.f46656d.g().invoke();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(PremiumContentController premiumContentController, MemberPriceData memberPriceData) {
        a.C0856a.f(lg.a.f68962a, "liyang", "MemberGoods返回！promotionReady ->" + premiumContentController.f46661i, false, 4, null);
        if (premiumContentController.f46661i) {
            SkuPromotionDto skuPromotionDto = premiumContentController.f46660h;
            premiumContentController.s(memberPriceData, skuPromotionDto != null ? skuPromotionDto.getItems() : null);
        } else {
            premiumContentController.f46659g = memberPriceData;
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(PremiumContentController premiumContentController, AllMemberRightsData allMemberRightsData) {
        RightsMapData rightsMap;
        FeatureRights basic;
        RightsMapData rightsMap2;
        FeatureRights pro;
        RightsMapData rightsMap3;
        FeatureRights features;
        List<MemberFeatureData> list = null;
        premiumContentController.f46655c.refreshFeaturesList((allMemberRightsData == null || (rightsMap3 = allMemberRightsData.getRightsMap()) == null || (features = rightsMap3.getFeatures()) == null) ? null : features.getRights());
        premiumContentController.f46655c.setProFeatureData((allMemberRightsData == null || (rightsMap2 = allMemberRightsData.getRightsMap()) == null || (pro = rightsMap2.getPro()) == null) ? null : pro.getRights());
        PremiumContentView premiumContentView = premiumContentController.f46655c;
        if (allMemberRightsData != null && (rightsMap = allMemberRightsData.getRightsMap()) != null && (basic = rightsMap.getBasic()) != null) {
            list = basic.getRights();
        }
        premiumContentView.setBasicFeatureData(list);
        premiumContentController.f46656d.g().invoke();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PromotionManager H() {
        return new PromotionManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        v().v();
    }

    private final void M() {
        MemberBasicDialog memberBasicDialog = new MemberBasicDialog();
        memberBasicDialog.F0(this.f46664l);
        memberBasicDialog.G0("member/memberdetail");
        memberBasicDialog.k0(this.f46663k, "MemberBasicDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(MemberPriceData memberPriceData, List list) {
        List<MemberPriceItem> arrayList;
        List<MemberPriceItem> arrayList2;
        PremiumContentView premiumContentView = this.f46655c;
        if (memberPriceData == null || (arrayList = memberPriceData.getProMembers()) == null) {
            arrayList = new ArrayList<>();
        }
        if (memberPriceData == null || (arrayList2 = memberPriceData.getBasicMember()) == null) {
            arrayList2 = new ArrayList<>();
        }
        premiumContentView.setMemberGoodsData(arrayList, arrayList2, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int i11, int i12) {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean f11 = iMemberApi != null ? iMemberApi.f() : false;
        if (i11 == 1 && i12 <= 7 && !this.f46665m && f11 && Intrinsics.c("video_detail/vip_banner", this.f46655c.getSceneId())) {
            this.f46665m = true;
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MemberViewModel v() {
        return (MemberViewModel) this.f46657e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PromotionManager w() {
        return (PromotionManager) this.f46658f.getValue();
    }

    private final void x(final Activity activity) {
        this.f46663k = activity;
        this.f46655c.setOnPurchaseListener(this.f46664l);
        this.f46655c.setOnBasicRenewClickListener(new Function0() { // from class: com.transsion.member.premium.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit y10;
                y10 = PremiumContentController.y(PremiumContentController.this);
                return y10;
            }
        });
        this.f46655c.initMemberCard(activity);
        this.f46655c.setOnPromoCodeClickListener(new Function0() { // from class: com.transsion.member.premium.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit z10;
                z10 = PremiumContentController.z(activity, this);
                return z10;
            }
        });
        this.f46655c.setOnFeedbackClickListener(new Function0() { // from class: com.transsion.member.premium.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit A;
                A = PremiumContentController.A();
                return A;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(PremiumContentController premiumContentController) {
        premiumContentController.M();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Activity activity, PremiumContentController premiumContentController) {
        MemberPromoCodeDialog.INSTANCE.a(new b()).k0(activity, "MemberPromoCodeDialog");
        return Unit.f67184a;
    }

    public final void I() {
        v().w();
    }

    public final void K() {
        this.f46665m = false;
        this.f46655c.getViewTreeObserver().addOnGlobalLayoutListener(new e());
    }

    public final void L(boolean z10) {
        this.f46665m = z10;
    }

    public final void t(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (this.f46662j) {
            return;
        }
        this.f46662j = true;
        x(activity);
        D();
        B();
    }
}
