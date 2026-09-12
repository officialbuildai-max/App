package com.transsion.usercenter.me.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.view.v0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.message.UserMessageActivity;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final o f57081e;

    /* renamed from: f, reason: collision with root package name */
    private com.transsion.usercenter.profile.f f57082f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57083a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57083a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57083a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f57083a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public n(o oVar) {
        this.f57081e = oVar;
    }

    public /* synthetic */ n(o oVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(TextView textView, Integer num) {
        textView.setVisibility(num.intValue() > 0 ? 0 : 8);
        textView.setText(num.toString());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(n nVar, MeItemInfo meItemInfo, View it) {
        Function1<MeItemInfo, Unit> Q1;
        Intrinsics.h(it, "it");
        com.transsion.usercenter.me.u.f57138a.b("notice");
        nVar.k().startActivity(new Intent(nVar.k(), (Class<?>) UserMessageActivity.class));
        com.transsion.usercenter.profile.f fVar = nVar.f57082f;
        if (fVar != null) {
            fVar.e();
        }
        o oVar = nVar.f57081e;
        if (oVar != null && (Q1 = oVar.Q1()) != null) {
            Q1.invoke(meItemInfo);
        }
        return Unit.f67184a;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final MeItemInfo item) {
        androidx.view.b0 h11;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Context k11 = k();
        BaseActivity baseActivity = k11 instanceof BaseActivity ? (BaseActivity) k11 : null;
        if (baseActivity != null) {
            final TextView textView = (TextView) helper.getView(R$id.desTv);
            com.transsion.usercenter.profile.f fVar = this.f57082f;
            if (fVar != null && (h11 = fVar.h()) != null) {
                h11.j(baseActivity, new a(new Function1() { // from class: com.transsion.usercenter.me.adapter.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit B;
                        B = n.B(textView, (Integer) obj);
                        return B;
                    }
                }));
            }
        }
        ((TextView) helper.getView(R$id.titleTv)).setText(k().getString(R$string.messages_title_name));
        View itemView = helper.itemView;
        Intrinsics.g(itemView, "itemView");
        jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.usercenter.me.adapter.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C;
                C = n.C(n.this, item, (View) obj);
                return C;
            }
        }, 1, null);
        helper.getView(R$id.divider).setVisibility(0);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 6;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.message_item_icon_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void v(BaseViewHolder viewHolder, int i11) {
        Intrinsics.h(viewHolder, "viewHolder");
        super.v(viewHolder, i11);
        TextView textView = (TextView) viewHolder.getView(R$id.desTv);
        textView.setTextSize(11.0f);
        textView.setPadding(dk.a.b(4), dk.a.b(1), dk.a.b(4), dk.a.b(1));
        textView.setTextColor(k().getResources().getColor(R$color.white));
        textView.setBackgroundResource(R$drawable.bg_red_r7);
        viewHolder.getView(R$id.bgView).setBackgroundResource(R$color.white_6);
        ((ImageView) viewHolder.getView(R$id.icIV)).setImageResource(com.tn.lib.widget.R$drawable.ic_me_message);
        Context k11 = k();
        BaseActivity baseActivity = k11 instanceof BaseActivity ? (BaseActivity) k11 : null;
        if (baseActivity != null) {
            this.f57082f = (com.transsion.usercenter.profile.f) new v0(baseActivity).a(com.transsion.usercenter.profile.f.class);
        }
    }
}
