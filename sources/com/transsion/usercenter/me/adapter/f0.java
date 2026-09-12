package com.transsion.usercenter.me.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.RoundedLinearLayout;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$string;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MembershipDetailType;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsnet.loginapi.ILoginApi;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class f0 extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final o f57055e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f57056f;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayout f57057g;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f57058h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f57059i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f57060j;

    /* renamed from: k, reason: collision with root package name */
    private RoundedLinearLayout f57061k;

    /* renamed from: l, reason: collision with root package name */
    private final String f57062l;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57063a;

        static {
            int[] iArr = new int[MembershipDetailType.values().length];
            try {
                iArr[MembershipDetailType.TRIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MembershipDetailType.SUBSCRIPTION_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MembershipDetailType.FINANCIAL_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MembershipDetailType.EXPIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MembershipDetailType.GUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f57063a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public f0(o oVar) {
        this.f57055e = oVar;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        this.f57062l = uuid;
    }

    public /* synthetic */ f0(o oVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : oVar);
    }

    private final void B(final MemberInfo memberInfo, final MeItemInfo meItemInfo, final BaseViewHolder baseViewHolder) {
        Integer daysLeft;
        IMemberApi iMemberApi;
        int i11;
        String str;
        IMemberApi iMemberApi2;
        int i12;
        String str2;
        Integer num = 0;
        a.C0856a.g(lg.a.f68962a, "member detail is " + memberInfo, false, 2, null);
        if (memberInfo != null) {
            try {
                daysLeft = memberInfo.getDaysLeft();
            } catch (Throwable unused) {
            }
        } else {
            daysLeft = null;
        }
        if (daysLeft != null) {
            num = memberInfo.getDaysLeft();
        }
        int i13 = a.f57063a[MembershipDetailType.INSTANCE.a(memberInfo).ordinal()];
        if (i13 == 1) {
            LinearLayout linearLayout = this.f57056f;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.f57057g;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            ViewGroup viewGroup = this.f57058h;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            int intValue = num != null ? num.intValue() : 0;
            ViewGroup viewGroup2 = this.f57058h;
            TextView textView = viewGroup2 != null ? (TextView) viewGroup2.findViewById(R$id.tv_member_guide_title) : null;
            ViewGroup viewGroup3 = this.f57058h;
            TextView textView2 = viewGroup3 != null ? (TextView) viewGroup3.findViewById(R$id.tv_member_guide_desc) : null;
            ViewGroup viewGroup4 = this.f57058h;
            TextView textView3 = viewGroup4 != null ? (TextView) viewGroup4.findViewById(R$id.tv_member_guide_btn) : null;
            ViewGroup viewGroup5 = this.f57058h;
            ViewGroup viewGroup6 = viewGroup5 != null ? (ViewGroup) viewGroup5.findViewById(R$id.me_vip_entry_container) : null;
            if (textView3 != null) {
                textView3.setText(k().getString(intValue <= 7 ? R$string.member_banner_vip_btn_content : R$string.me_vip_upgrade));
            }
            if (textView3 != null) {
                textView3.setMinWidth(intValue <= 7 ? gk.b.a(70) : gk.b.a(83));
            }
            if (textView3 != null) {
                textView3.setBackground(k().getDrawable(R$drawable.bg_btn_me_vip_entry_basic));
            }
            ViewGroup viewGroup7 = this.f57058h;
            if (viewGroup7 != null) {
                jg.c.c(viewGroup7, 0L, new Function1() { // from class: com.transsion.usercenter.me.adapter.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit C;
                        C = f0.C(f0.this, memberInfo, baseViewHolder, meItemInfo, (View) obj);
                        return C;
                    }
                }, 1, null);
            }
            if (textView != null) {
                textView.setText(textView.getContext().getString(R$string.me_vip_premium_basic));
                textView.setTextColor(textView.getContext().getColor(R$color.color_1B2743));
            }
            if (textView2 != null) {
                Context k11 = k();
                int i14 = com.transsion.usercenter.R$string.user_date_left;
                if (memberInfo != null) {
                    str = memberInfo.getExpiryDate();
                    i11 = 2;
                } else {
                    i11 = 2;
                    str = null;
                }
                Object[] objArr = new Object[i11];
                objArr[0] = num;
                objArr[1] = str;
                textView2.setText(k11.getString(i14, objArr));
            }
            if (viewGroup6 != null) {
                viewGroup6.setBackground(k().getDrawable(R$drawable.bg_basic_member_banner));
            }
            ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
            if (iLoginApi == null || !iLoginApi.a() || (iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0])) == null || !iMemberApi.f()) {
                RoundedLinearLayout roundedLinearLayout = this.f57061k;
                if (roundedLinearLayout != null) {
                    roundedLinearLayout.setCornerRadius(gk.b.a(8));
                    return;
                }
                return;
            }
            RoundedLinearLayout roundedLinearLayout2 = this.f57061k;
            if (roundedLinearLayout2 != null) {
                roundedLinearLayout2.setCornerRadii(gk.b.a(8), gk.b.a(8), 0.0f, 0.0f);
                return;
            }
            return;
        }
        if (i13 != 2 && i13 != 3) {
            if (i13 != 4 && i13 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            View itemView = baseViewHolder.itemView;
            Intrinsics.g(itemView, "itemView");
            LinearLayout linearLayout3 = this.f57056f;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            LinearLayout linearLayout4 = this.f57057g;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.usercenter.me.adapter.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit E;
                    E = f0.E(f0.this, baseViewHolder, meItemInfo, (View) obj);
                    return E;
                }
            }, 1, null);
            ViewGroup viewGroup8 = this.f57058h;
            if (viewGroup8 != null) {
                viewGroup8.setVisibility(8);
            }
            RoundedLinearLayout roundedLinearLayout3 = this.f57061k;
            if (roundedLinearLayout3 != null) {
                roundedLinearLayout3.setCornerRadius(gk.b.a(8));
                return;
            }
            return;
        }
        LinearLayout linearLayout5 = this.f57056f;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        LinearLayout linearLayout6 = this.f57057g;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        ViewGroup viewGroup9 = this.f57058h;
        if (viewGroup9 != null) {
            viewGroup9.setVisibility(0);
        }
        ViewGroup viewGroup10 = this.f57058h;
        TextView textView4 = viewGroup10 != null ? (TextView) viewGroup10.findViewById(R$id.tv_member_guide_title) : null;
        ViewGroup viewGroup11 = this.f57058h;
        TextView textView5 = viewGroup11 != null ? (TextView) viewGroup11.findViewById(R$id.tv_member_guide_desc) : null;
        ViewGroup viewGroup12 = this.f57058h;
        TextView textView6 = viewGroup12 != null ? (TextView) viewGroup12.findViewById(R$id.tv_member_guide_btn) : null;
        ViewGroup viewGroup13 = this.f57058h;
        ViewGroup viewGroup14 = viewGroup13 != null ? (ViewGroup) viewGroup13.findViewById(R$id.me_vip_entry_container) : null;
        ViewGroup viewGroup15 = this.f57058h;
        if (viewGroup15 != null) {
            jg.c.c(viewGroup15, 0L, new Function1() { // from class: com.transsion.usercenter.me.adapter.d0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit D;
                    D = f0.D(f0.this, memberInfo, baseViewHolder, meItemInfo, (View) obj);
                    return D;
                }
            }, 1, null);
        }
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        boolean u11 = iPremiumApi != null ? iPremiumApi.u() : false;
        if (textView6 != null) {
            int intValue2 = num != null ? num.intValue() : 0;
            textView6.setText(textView6.getContext().getString((u11 || intValue2 <= 7) ? R$string.member_banner_vip_btn_content : R$string.me_vip_upgrade));
            textView6.setTextColor(textView6.getContext().getColor(u11 ? R$color.yellow_dark_10 : R$color.color_1B2743));
            textView6.setBackground(textView6.getContext().getDrawable(u11 ? R$drawable.bg_member_guide_banner_btn : R$drawable.bg_btn_me_vip_entry_basic));
            textView6.setMinWidth((u11 || intValue2 <= 7) ? gk.b.a(70) : gk.b.a(83));
        }
        if (textView4 != null) {
            textView4.setText(textView4.getContext().getString(u11 ? R$string.me_vip_premium_pro : R$string.me_vip_premium_basic));
            textView4.setTextColor(textView4.getContext().getColor(u11 ? R$color.yellow_dark_10 : R$color.color_1B2743));
        }
        if (textView5 != null) {
            Context context = textView5.getContext();
            int i15 = com.transsion.usercenter.R$string.user_date_left;
            if (memberInfo != null) {
                str2 = memberInfo.getExpiryDate();
                i12 = 2;
            } else {
                i12 = 2;
                str2 = null;
            }
            Object[] objArr2 = new Object[i12];
            objArr2[0] = num;
            objArr2[1] = str2;
            textView5.setText(context.getString(i15, objArr2));
            textView5.setTextColor(textView5.getContext().getColor(u11 ? R$color.yellow_dark_10 : R$color.color_1B2743));
        }
        if (viewGroup14 != null) {
            viewGroup14.setBackground(k().getDrawable(u11 ? R$drawable.bg_pro_member_banner : R$drawable.bg_basic_member_banner));
        }
        ILoginApi iLoginApi2 = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        if (iLoginApi2 == null || !iLoginApi2.a() || (iMemberApi2 = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0])) == null || !iMemberApi2.f()) {
            RoundedLinearLayout roundedLinearLayout4 = this.f57061k;
            if (roundedLinearLayout4 != null) {
                roundedLinearLayout4.setCornerRadius(gk.b.a(8));
                return;
            }
            return;
        }
        RoundedLinearLayout roundedLinearLayout5 = this.f57061k;
        if (roundedLinearLayout5 != null) {
            roundedLinearLayout5.setCornerRadii(gk.b.a(8), gk.b.a(8), 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(f0 f0Var, MemberInfo memberInfo, BaseViewHolder baseViewHolder, MeItemInfo meItemInfo, View it) {
        Function1<MeItemInfo, Unit> Q1;
        Intrinsics.h(it, "it");
        com.transsion.usercenter.me.u.f57138a.b("member");
        f0Var.H(f0Var.G(memberInfo));
        Navigator.x(TheRouter.c("/member/MemberActivity").K("scene_id", "me/vip_entry").K("trace_id", f0Var.f57062l), baseViewHolder.itemView.getContext(), null, 2, null);
        o oVar = f0Var.f57055e;
        if (oVar != null && (Q1 = oVar.Q1()) != null) {
            Q1.invoke(meItemInfo);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(f0 f0Var, MemberInfo memberInfo, BaseViewHolder baseViewHolder, MeItemInfo meItemInfo, View it) {
        Function1<MeItemInfo, Unit> Q1;
        Intrinsics.h(it, "it");
        com.transsion.usercenter.me.u.f57138a.b("member");
        f0Var.H(f0Var.G(memberInfo));
        Navigator.x(TheRouter.c("/member/MemberActivity").K("scene_id", "me/vip_entry").K("trace_id", f0Var.f57062l), baseViewHolder.itemView.getContext(), null, 2, null);
        o oVar = f0Var.f57055e;
        if (oVar != null && (Q1 = oVar.Q1()) != null) {
            Q1.invoke(meItemInfo);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(f0 f0Var, BaseViewHolder baseViewHolder, MeItemInfo meItemInfo, View it) {
        Function1<MeItemInfo, Unit> Q1;
        Intrinsics.h(it, "it");
        com.transsion.usercenter.me.u.f57138a.b("member");
        f0Var.H(0);
        Navigator.x(TheRouter.c("/member/MemberActivity").K("scene_id", "me/vip_entry").K("trace_id", f0Var.f57062l), baseViewHolder.itemView.getContext(), null, 2, null);
        o oVar = f0Var.f57055e;
        if (oVar != null && (Q1 = oVar.Q1()) != null) {
            Q1.invoke(meItemInfo);
        }
        return Unit.f67184a;
    }

    private final int G(MemberInfo memberInfo) {
        Integer daysLeft;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        boolean u11 = iPremiumApi != null ? iPremiumApi.u() : false;
        if (memberInfo.isActive() && (daysLeft = memberInfo.getDaysLeft()) != null) {
            return (u11 || daysLeft.intValue() <= 7) ? 3 : 4;
        }
        return 0;
    }

    private final void H(int i11) {
        com.transsion.baselib.helper.f.g(com.transsion.baselib.helper.f.f43323a, "profiledetail", "me/vip_entry", this.f57062l, null, i11, 8, null);
    }

    private final void I(int i11) {
        com.transsion.baselib.helper.f.i(com.transsion.baselib.helper.f.f43323a, "profiledetail", "me/vip_entry", this.f57062l, null, i11, 8, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Object data = item.getData();
        MemberInfo memberInfo = data instanceof MemberInfo ? (MemberInfo) data : null;
        if (memberInfo == null) {
            return;
        }
        this.f57056f = (LinearLayout) helper.getView(com.transsion.usercenter.R$id.top_container);
        this.f57061k = (RoundedLinearLayout) helper.getView(com.transsion.usercenter.R$id.radius_container);
        this.f57057g = (LinearLayout) helper.getView(com.transsion.usercenter.R$id.bottom_container);
        this.f57058h = (ViewGroup) helper.getView(com.transsion.usercenter.R$id.member_guide_banner_container);
        this.f57059i = (TextView) helper.getView(com.transsion.usercenter.R$id.tv_vip_guide_title);
        this.f57060j = (TextView) helper.getView(com.transsion.usercenter.R$id.tv_vip_guide_btn);
        B(memberInfo, item, helper);
        I(G(memberInfo));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.mine_item_member_layout;
    }
}
