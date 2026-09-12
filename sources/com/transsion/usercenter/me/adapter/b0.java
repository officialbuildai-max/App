package com.transsion.usercenter.me.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.widget.GradientBorderTagView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$mipmap;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.edit.ProfileEditCenterActivity;
import com.transsion.usercenter.kids.AccountSwitchDialog;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import ej.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b0 extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final o f57038e;

    /* renamed from: f, reason: collision with root package name */
    private UserInfo f57039f;

    /* JADX WARN: Multi-variable type inference failed */
    public b0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public b0(o oVar) {
        this.f57038e = oVar;
    }

    public /* synthetic */ b0(o oVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : oVar);
    }

    private final boolean C() {
        UserInfo userInfo = this.f57039f;
        return userInfo == null || (userInfo != null && userInfo.getUserType() == 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void D(com.chad.library.adapter.base.viewholder.BaseViewHolder r10, com.transsnet.loginapi.bean.UserInfo r11) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.me.adapter.b0.D(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsnet.loginapi.bean.UserInfo):void");
    }

    private final void E(final BaseViewHolder baseViewHolder, final UserInfo userInfo) {
        Function1<MeItemInfo, Unit> R1;
        Function1<MeItemInfo, Unit> R12;
        boolean z10 = true;
        baseViewHolder.getView(R$id.loginTv).setVisibility(8);
        baseViewHolder.getView(R$id.avatarIV).setVisibility(0);
        View itemView = baseViewHolder.itemView;
        Intrinsics.g(itemView, "itemView");
        jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.usercenter.me.adapter.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = b0.F(UserInfo.this, this, (View) obj);
                return F;
            }
        }, 1, null);
        if (userInfo == null) {
            return;
        }
        if (ak.g.f714a.b()) {
            baseViewHolder.getView(R$id.tvLoginMyChannel).setVisibility(!ak.o.f721a.i() ? 0 : 8);
            ((TextView) baseViewHolder.getView(R$id.tvLoginMyChannel)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.me.adapter.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b0.G(UserInfo.this, baseViewHolder, view);
                }
            });
        }
        baseViewHolder.getView(R$id.safeKidsGroup).setVisibility(0);
        MeItemInfo meItemInfo = new MeItemInfo(1, userInfo);
        o oVar = this.f57038e;
        if (oVar != null && (R12 = oVar.R1()) != null) {
            R12.invoke(meItemInfo);
        }
        baseViewHolder.getView(R$id.safeKidsGroup).setVisibility(0);
        MeItemInfo meItemInfo2 = new MeItemInfo(1, userInfo);
        o oVar2 = this.f57038e;
        if (oVar2 != null && (R1 = oVar2.R1()) != null) {
            R1.invoke(meItemInfo2);
        }
        ak.o oVar3 = ak.o.f721a;
        if (oVar3.i()) {
            D(baseViewHolder, userInfo);
            return;
        }
        TextView textView = (TextView) baseViewHolder.getView(R$id.nameTv);
        textView.setText(userInfo.getNickname());
        textView.setCompoundDrawables(null, null, null, null);
        GradientBorderTagView gradientBorderTagView = (GradientBorderTagView) baseViewHolder.getView(R$id.safeKidsTv);
        gradientBorderTagView.setVisibility(oVar3.j() ? 0 : 8);
        String string = Utils.a().getResources().getString(R$string.user_safe_kids);
        Intrinsics.g(string, "getString(...)");
        gradientBorderTagView.setText(string);
        ((TextView) baseViewHolder.getView(R$id.idTv)).setText(Utils.a().getResources().getString(R$string.user_id_show, userInfo.getUsername()));
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.genderTv);
        textView2.setCompoundDrawablesWithIntrinsicBounds(userInfo.getGender() == 0 ? 0 : userInfo.getGender() == 1 ? R$mipmap.profile_man : R$mipmap.profile_female, 0, 0, 0);
        if (userInfo.getAge() <= 0) {
            textView2.setText("");
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            jn.e.f66368a.b(spannableStringBuilder);
            spannableStringBuilder.append((CharSequence) String.valueOf(userInfo.getAge()));
            textView2.setText(spannableStringBuilder);
        }
        if (userInfo.getGender() == 0 && userInfo.getAge() <= 0) {
            z10 = false;
        }
        textView2.setVisibility(z10 ? 0 : 8);
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.avatarIV);
        f.a aVar = ej.f.f62005a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        aVar.m(context).g(userInfo.getAvatar()).i(com.tn.lib.widget.R$mipmap.profile_default_avatar).d(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(UserInfo userInfo, b0 b0Var, View it) {
        Function1<MeItemInfo, Unit> Q1;
        Intrinsics.h(it, "it");
        MeItemInfo meItemInfo = new MeItemInfo(1, userInfo);
        if (ak.o.f721a.j()) {
            AccountSwitchDialog.Companion.b(AccountSwitchDialog.INSTANCE, false, 1, null).X(b0Var.k(), "AccountSwitchDialog");
        } else {
            ProfileEditCenterActivity.INSTANCE.a(b0Var.k(), userInfo);
        }
        o oVar = b0Var.f57038e;
        if (oVar != null && (Q1 = oVar.Q1()) != null) {
            Q1.invoke(meItemInfo);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(UserInfo userInfo, BaseViewHolder baseViewHolder, View view) {
        Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userInfo.getUserId()), baseViewHolder.itemView.getContext(), null, 2, null);
    }

    private final void H(BaseViewHolder baseViewHolder, UserInfo userInfo) {
        baseViewHolder.getView(R$id.genderTv).setVisibility(8);
        baseViewHolder.getView(R$id.avatarIV).setVisibility(8);
        baseViewHolder.getView(R$id.safeKidsGroup).setVisibility(8);
        TextView textView = (TextView) baseViewHolder.getView(R$id.loginTv);
        textView.setVisibility(0);
        textView.setText(R$string.user_login);
        jg.c.c(textView, 0L, new Function1() { // from class: com.transsion.usercenter.me.adapter.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I;
                I = b0.I(b0.this, (View) obj);
                return I;
            }
        }, 1, null);
        baseViewHolder.itemView.setOnClickListener(null);
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.nameTv);
        textView2.setText(R$string.user_login_title);
        textView2.setCompoundDrawables(null, null, null, null);
        ((TextView) baseViewHolder.getView(R$id.idTv)).setText(Utils.a().getResources().getString(R$string.user_id_show, userInfo != null ? userInfo.getUsername() : null));
        baseViewHolder.getView(R$id.tvLoginMyChannel).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(b0 b0Var, View it) {
        Intrinsics.h(it, "it");
        com.transsion.usercenter.me.u.f57138a.b("login");
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        if (iLoginApi != null) {
            iLoginApi.j(b0Var.k());
        }
        return Unit.f67184a;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Object data = item.getData();
        UserInfo userInfo = data instanceof UserInfo ? (UserInfo) data : null;
        this.f57039f = userInfo;
        com.transsion.usercenter.me.u.f57138a.d(userInfo != null ? userInfo.getUserId() : null);
        if (!C() || ak.o.f721a.i()) {
            E(helper, this.f57039f);
        } else {
            H(helper, this.f57039f);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.mine_item_header_layout;
    }
}
