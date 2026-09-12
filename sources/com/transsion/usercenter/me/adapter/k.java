package com.transsion.usercenter.me.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.kids.KidsAccountManager;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.kids.PinInputDialog;
import com.transsion.usercenter.profile.bean.IconItemInfo;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsion.version.update.UpdateManager;
import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class k extends BaseItemProvider {

    /* renamed from: i, reason: collision with root package name */
    public static final a f57073i = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final o f57074e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f57075f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f57076g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f57077h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public k(o oVar) {
        this.f57074e = oVar;
        this.f57075f = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.adapter.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IMovieDetailService L;
                L = k.L();
                return L;
            }
        });
        this.f57076g = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.adapter.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                k.C();
                return null;
            }
        });
        this.f57077h = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.adapter.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi K;
                K = k.K();
                return K;
            }
        });
    }

    public /* synthetic */ k(o oVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : oVar);
    }

    public static /* synthetic */ aq.b C() {
        J();
        return null;
    }

    private final void D(BaseViewHolder baseViewHolder, IconItemInfo iconItemInfo) {
        int b11 = TextUtils.equals(iconItemInfo.getModuleName(), "linked_devices") ? dk.a.b(36) : dk.a.b(52);
        ViewGroup.LayoutParams layoutParams = baseViewHolder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams.height != b11) {
            layoutParams.height = b11;
            baseViewHolder.itemView.setLayoutParams(layoutParams);
        }
        ((TextView) baseViewHolder.getView(R$id.desTv)).setTextColor(androidx.core.content.b.getColor(k(), TextUtils.equals(iconItemInfo.getModuleName(), "linked_devices") ? R$color.white_60 : R$color.text_03));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dc, code lost:
    
        if (r1.equals("like_list_type") == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0171, code lost:
    
        if (ak.g.f714a.b() == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x017b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r8.getDeepLink(), "post_list_type") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x017d, code lost:
    
        com.therouter.router.Navigator.x(com.therouter.TheRouter.c("/postdetail/favorite"), r11.itemView.getContext(), null, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x018d, code lost:
    
        new android.os.Bundle();
        com.therouter.router.Navigator.x(com.therouter.TheRouter.c("/ugc/likes"), r11.itemView.getContext(), null, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a2, code lost:
    
        r11 = new android.os.Bundle();
        r11.putInt(com.cloud.tmc.integration.event.EventConstants.KEY_SOURCE, !kotlin.jvm.internal.Intrinsics.c(r8.getDeepLink(), "post_list_type") ? 1 : 0);
        r0 = r9.G();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b9, code lost:
    
        if (r0 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01bb, code lost:
    
        r0 = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01bf, code lost:
    
        if (r0 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01c1, code lost:
    
        r4 = r0.getUserId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c5, code lost:
    
        r11.putString("userId", r4);
        r0 = r9.H();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ce, code lost:
    
        if (r0 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01d0, code lost:
    
        r0.b(r9.k(), r11, com.transsion.usercenter.profile.ProfileSubjectListViewModel.class, r8.getTitle());
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0167, code lost:
    
        if (r1.equals("post_list_type") == false) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit F(com.transsion.usercenter.profile.bean.IconItemInfo r8, com.transsion.usercenter.me.adapter.k r9, com.transsion.usercenter.profile.bean.MeItemInfo r10, com.chad.library.adapter.base.viewholder.BaseViewHolder r11, android.view.View r12) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.me.adapter.k.F(com.transsion.usercenter.profile.bean.IconItemInfo, com.transsion.usercenter.me.adapter.k, com.transsion.usercenter.profile.bean.MeItemInfo, com.chad.library.adapter.base.viewholder.BaseViewHolder, android.view.View):kotlin.Unit");
    }

    private final ILoginApi G() {
        return (ILoginApi) this.f57077h.getValue();
    }

    private final IMovieDetailService H() {
        return (IMovieDetailService) this.f57075f.getValue();
    }

    private final boolean I(String str) {
        return TextUtils.equals(str, "linked_devices") || TextUtils.equals(str, "tv_download_web_link") || TextUtils.equals(str, "my_activity");
    }

    private static final aq.b J() {
        android.support.v4.media.session.c.a(TheRouter.d(aq.b.class, new Object[0]));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi K() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMovieDetailService L() {
        return (IMovieDetailService) TheRouter.d(IMovieDetailService.class, new Object[0]);
    }

    private final void M() {
        KidsAccountManager kidsAccountManager = KidsAccountManager.f43340a;
        final String e11 = kidsAccountManager.e();
        if (e11 == null) {
            e11 = "";
        }
        if (kidsAccountManager.i()) {
            Navigator.x(TheRouter.c("/kids/pin_management").K("arg_kids_id", e11), null, null, 3, null);
        } else {
            PinInputDialog.Companion.b(PinInputDialog.INSTANCE, false, new Function1() { // from class: com.transsion.usercenter.me.adapter.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit N;
                    N = k.N(e11, (String) obj);
                    return N;
                }
            }, null, 5, null).X(k(), "PinInputDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(String str, String pin) {
        Intrinsics.h(pin, "pin");
        KidsAccountManager.f43340a.p(pin);
        Navigator.x(TheRouter.c("/kids/pin_management").K("arg_kids_id", str), null, null, 3, null);
        return Unit.f67184a;
    }

    private final void O(String str) {
        if (I(str)) {
            com.transsion.usercenter.me.u uVar = com.transsion.usercenter.me.u.f57138a;
            if (str == null) {
                str = "";
            }
            uVar.a(str);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder helper, final MeItemInfo item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Object data = item.getData();
        final IconItemInfo iconItemInfo = data instanceof IconItemInfo ? (IconItemInfo) data : null;
        if (iconItemInfo == null) {
            return;
        }
        View itemView = helper.itemView;
        Intrinsics.g(itemView, "itemView");
        jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.usercenter.me.adapter.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = k.F(IconItemInfo.this, this, item, helper, (View) obj);
                return F;
            }
        }, 1, null);
        ((TextView) helper.getView(R$id.titleTv)).setText(iconItemInfo.getTitle());
        ((TextView) helper.getView(R$id.desTv)).setText(iconItemInfo.getDes());
        helper.getView(R$id.divider).setVisibility(iconItemInfo.getDivider() ? 0 : 8);
        helper.getView(R$id.bgView).setBackgroundResource(iconItemInfo.getBgRes());
        ((ImageView) helper.getView(R$id.icIV)).setImageResource(iconItemInfo.getIconRes());
        helper.getView(R$id.newBadgeTv).setVisibility(iconItemInfo.getShowNewBadge() ? 0 : 8);
        D(helper, iconItemInfo);
        O(iconItemInfo.getModuleName());
        ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = iconItemInfo.getTop();
        }
        if (!TextUtils.equals(iconItemInfo.getModuleName(), "setting")) {
            helper.getView(R$id.setting_tv_tips).setVisibility(8);
            helper.getView(R$id.image_red_tips).setVisibility(8);
            return;
        }
        View view = helper.getView(R$id.image_red_tips);
        View view2 = helper.getView(R$id.setting_tv_tips);
        boolean z10 = !ak.o.f721a.j() && com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_is_family_mode_badge", true);
        boolean g11 = UpdateManager.f57641f.a().g();
        view.setVisibility(z10 ? 0 : 8);
        view2.setVisibility(!z10 && g11 ? 0 : 8);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 5;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.mine_item_icon_layout;
    }
}
