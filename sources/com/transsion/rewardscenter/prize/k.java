package com.transsion.rewardscenter.prize;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.event.EventConstants;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$mipmap;
import com.transsion.rewardscenter.prize.e;
import com.transsion.rewardscenter.ui.RewardsCenterFragment;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.DrawResult;
import ej.f;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nh.m;

/* loaded from: classes6.dex */
public final class k extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final wp.a f51058e;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51059a;

        static {
            int[] iArr = new int[PrizeButtonState.values().length];
            try {
                iArr[PrizeButtonState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrizeButtonState.CLAIMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrizeButtonState.CLAIMING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f51059a = iArr;
        }
    }

    public k(wp.a config) {
        Intrinsics.h(config, "config");
        this.f51058e = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(PrizeButtonState prizeButtonState, Context context, k kVar, DrawResult drawResult, View it) {
        Intrinsics.h(it, "it");
        if (prizeButtonState == PrizeButtonState.ACTIVE) {
            if (m.f70597a.e()) {
                RewardsCenterFragment rewardsCenterFragment = (RewardsCenterFragment) kVar.f51058e.a().get();
                if (rewardsCenterFragment != null) {
                    rewardsCenterFragment.u1(drawResult);
                }
                kVar.C(drawResult);
            } else {
                String string = context.getString(R$string.no_network_toast);
                Intrinsics.g(string, "getString(...)");
                p.a(false, string);
            }
        }
        return Unit.f67184a;
    }

    private final PrizeButtonState B(DrawResult drawResult) {
        return Intrinsics.c(drawResult.getClaimStatus(), "CLAIM_STATUS_TOP_UP") ? PrizeButtonState.CLAIMING : (Intrinsics.c(drawResult.getClaimStatus(), "CLAIM_STATUS_UNCLAIM") && Intrinsics.c(drawResult.getNeedFill(), "LOTTERY_NEED_FILL_YES") && Intrinsics.c(drawResult.getFillStatus(), "FILL_STATUS_NO")) ? PrizeButtonState.ACTIVE : (Intrinsics.c(drawResult.getClaimStatus(), "CLAIM_STATUS_UNCLAIM") && Intrinsics.c(drawResult.getNeedFill(), "LOTTERY_NEED_FILL_NO")) ? PrizeButtonState.ACTIVE : PrizeButtonState.CLAIMED;
    }

    private final void C(DrawResult drawResult) {
        HashMap hashMap = new HashMap();
        String prizeType = drawResult.getPrizeType();
        if (prizeType == null) {
            prizeType = "";
        }
        hashMap.put(EventConstants.KEY_SOURCE, prizeType);
        q.a("prize_list", hashMap);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PrizeItemType.ROW.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.prize_row_item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, e item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (item instanceof e.c) {
            final DrawResult a11 = ((e.c) item).a();
            final Context context = helper.itemView.getContext();
            f.a aVar = ej.f.f62005a;
            Intrinsics.e(context);
            aVar.m(context).g(a11.getImgUrl()).d((ImageView) helper.getView(R$id.icon));
            int i11 = R$id.tv_title;
            String title = a11.getTitle();
            if (title == null) {
                title = "";
            }
            helper.setText(i11, title);
            helper.setText(R$id.tv_count, "x 1");
            TextView textView = (TextView) helper.getView(R$id.btn_action);
            final PrizeButtonState B = B(a11);
            int i12 = a.f51059a[B.ordinal()];
            if (i12 == 1) {
                textView.setBackgroundResource(R$mipmap.btn_claim_normal);
                textView.setText(context.getString(com.transsion.rewardscenter.R$string.prize_btn_claim));
                textView.setTextColor(context.getColor(R$color.white));
                textView.setEnabled(true);
                textView.setAlpha(1.0f);
            } else if (i12 == 2) {
                textView.setBackgroundResource(R$mipmap.btn_claim_done);
                textView.setText(context.getString(com.transsion.rewardscenter.R$string.prize_btn_claimed));
                textView.setTextColor(context.getColor(com.transsion.rewardscenter.R$color.prize_btn_claimed_text));
                textView.setEnabled(false);
                textView.setAlpha(1.0f);
            } else {
                if (i12 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                textView.setBackgroundResource(R$mipmap.btn_claim_normal);
                textView.setText(context.getString(com.transsion.rewardscenter.R$string.prize_btn_Topping));
                textView.setTextColor(context.getColor(R$color.white));
                textView.setEnabled(false);
                textView.setAlpha(0.5f);
            }
            jg.c.c(textView, 0L, new Function1() { // from class: com.transsion.rewardscenter.prize.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = k.A(PrizeButtonState.this, context, this, a11, (View) obj);
                    return A;
                }
            }, 1, null);
        }
    }
}
