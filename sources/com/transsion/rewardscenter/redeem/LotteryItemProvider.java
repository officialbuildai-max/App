package com.transsion.rewardscenter.redeem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.event.EventConstants;
import com.tn.lib.widget.R$color;
import com.transsion.rewardscenter.R$drawable;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$mipmap;
import com.transsion.rewardscenter.redeem.e;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.LotteryPrize;
import com.transsion.rewardscenterapi.User;
import ej.f;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class LotteryItemProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final wp.a f51060e;

    public LotteryItemProvider(wp.a config) {
        Intrinsics.h(config, "config");
        this.f51060e = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (r7 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit B(boolean r7, com.transsion.rewardscenter.redeem.LotteryItemProvider r8, com.transsion.rewardscenter.redeem.e r9, com.transsion.rewardscenterapi.LotteryPrize r10, android.view.View r11) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            if (r7 != 0) goto La
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        La:
            nh.m r7 = nh.m.f70597a
            boolean r7 = r7.e()
            java.lang.String r11 = "getString(...)"
            r0 = 0
            if (r7 != 0) goto L28
            android.content.Context r7 = r8.k()
            int r8 = com.tn.lib.widget.R$string.no_network_toast
            java.lang.String r7 = r7.getString(r8)
            kotlin.jvm.internal.Intrinsics.g(r7, r11)
            com.transsion.rewardscenter.utils.p.a(r0, r7)
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        L28:
            com.transsion.rewardscenter.redeem.e$a r9 = (com.transsion.rewardscenter.redeem.e.a) r9
            boolean r7 = r9.a()
            if (r7 == 0) goto L7f
            wp.a r7 = r8.f51060e
            java.lang.ref.WeakReference r7 = r7.a()
            java.lang.Object r7 = r7.get()
            com.transsion.rewardscenter.ui.RewardsCenterFragment r7 = (com.transsion.rewardscenter.ui.RewardsCenterFragment) r7
            if (r7 == 0) goto L41
            r7.showLoading()
        L41:
            java.lang.String r7 = r10.getActivityId()
            if (r7 == 0) goto L5d
            wp.a r10 = r8.f51060e
            kotlinx.coroutines.n0 r1 = r10.b()
            com.transsion.rewardscenter.redeem.LotteryItemProvider$convert$1$1$1 r4 = new com.transsion.rewardscenter.redeem.LotteryItemProvider$convert$1$1$1
            r10 = 0
            r4.<init>(r7, r8, r10)
            r5 = 3
            r6 = 0
            r2 = 0
            r3 = 0
            kotlinx.coroutines.t1 r7 = kotlinx.coroutines.i.d(r1, r2, r3, r4, r5, r6)
            if (r7 != 0) goto L90
        L5d:
            wp.a r7 = r8.f51060e
            com.transsion.rewardscenter.model.RewardsCenterModel r7 = r7.c()
            androidx.lifecycle.b0 r7 = r7.o()
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r7.n(r10)
            android.content.Context r7 = r8.k()
            int r10 = com.transsion.rewardscenter.R$string.redeem_failed_tips
            java.lang.String r7 = r7.getString(r10)
            kotlin.jvm.internal.Intrinsics.g(r7, r11)
            com.transsion.rewardscenter.utils.p.a(r0, r7)
            kotlin.Unit r7 = kotlin.Unit.f67184a
            goto L90
        L7f:
            wp.a r7 = r8.f51060e
            com.transsion.rewardscenterapi.TopUpType r10 = com.transsion.rewardscenterapi.TopUpType.REDEEM
            com.transsion.rewardscenter.model.RewardsCenterModel r11 = r7.c()
            com.transsion.rewardscenterapi.SkuPoint r11 = r11.l()
            com.transsion.rewardscenter.utils.f.c(r7, r10, r11)
            kotlin.Unit r7 = kotlin.Unit.f67184a
        L90:
            boolean r7 = r9.a()
            r8.C(r7)
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.redeem.LotteryItemProvider.B(boolean, com.transsion.rewardscenter.redeem.LotteryItemProvider, com.transsion.rewardscenter.redeem.e, com.transsion.rewardscenterapi.LotteryPrize, android.view.View):kotlin.Unit");
    }

    private final void C(boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_paid", z10 ? "1" : "0");
        hashMap.put(EventConstants.KEY_SOURCE, "lottery");
        q.a("redeem_rewards", hashMap);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final e item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (item instanceof e.a) {
            e.a aVar = (e.a) item;
            final LotteryPrize b11 = aVar.b();
            helper.setText(R$id.title, b11.getPrizeName());
            helper.setText(R$id.point, "-" + b11.getPointCost());
            ImageView imageView = (ImageView) helper.getView(R$id.icon);
            f.a aVar2 = ej.f.f62005a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar2.m(context).g(aVar.b().getPrizeUrl()).i(R$mipmap.ic_redeem_lottery).d(imageView);
            User w11 = this.f51060e.c().w();
            final boolean z10 = (w11 != null ? w11.getPoint() : 0) >= b11.getPointCost();
            TextView textView = (TextView) helper.getView(R$id.action);
            if (z10) {
                textView.setEnabled(true);
                textView.setBackgroundResource(R$mipmap.ic_redeem_btn_bg_orange);
                textView.setBackgroundTintList(null);
                textView.setTextColor(k().getColor(R$color.white));
            } else {
                textView.setEnabled(false);
                textView.setBackgroundResource(R$drawable.shape_r6_tint);
                textView.setBackgroundTintList(ColorStateList.valueOf(k().getColor(com.transsion.rewardscenter.R$color.redeem_disable_bg)));
                textView.setTextColor(k().getColor(R$color.white_80));
            }
            jg.c.c(textView, 0L, new Function1() { // from class: com.transsion.rewardscenter.redeem.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit B;
                    B = LotteryItemProvider.B(z10, this, item, b11, (View) obj);
                    return B;
                }
            }, 1, null);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return RedeemType.LOTTERY.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.redeem_lottery_item;
    }
}
