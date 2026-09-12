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
import com.transsion.rewardscenter.model.RewardsCenterModel;
import com.transsion.rewardscenter.prize.e;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.DrawChance;
import ej.f;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nh.m;

/* loaded from: classes6.dex */
public final class b extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final wp.a f51041e;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51042a;

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
            f51042a = iArr;
        }
    }

    public b(wp.a config) {
        Intrinsics.h(config, "config");
        this.f51041e = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(boolean z10, Context context, b bVar, boolean z11, View it) {
        Intrinsics.h(it, "it");
        if (z10) {
            if (m.f70597a.e()) {
                RewardsCenterModel.h(bVar.f51041e.c(), null, true, 1, null);
                bVar.D();
            } else {
                String string = context.getString(R$string.no_network_toast);
                Intrinsics.g(string, "getString(...)");
                p.a(false, string);
            }
        } else if (z11) {
            String string2 = context.getString(com.transsion.rewardscenter.R$string.prize_limit_tips);
            Intrinsics.g(string2, "getString(...)");
            p.a(false, string2);
        }
        return Unit.f67184a;
    }

    private final void D() {
        HashMap hashMap = new HashMap();
        hashMap.put(EventConstants.KEY_SOURCE, "draw_chance");
        q.a("prize_list", hashMap);
    }

    public final boolean B(DrawChance drawChance) {
        Intrinsics.h(drawChance, "drawChance");
        return drawChance.getRemain() > 0 && drawChance.getTodayRemain() > 0;
    }

    public final boolean C(DrawChance drawChance) {
        Intrinsics.h(drawChance, "drawChance");
        return drawChance.getTodayRemain() <= 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PrizeItemType.DRAW_CHANCE.getValue();
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
        if (item instanceof e.a) {
            DrawChance a11 = ((e.a) item).a();
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
            helper.setText(R$id.tv_count, "x " + a11.getRemain());
            TextView textView = (TextView) helper.getView(R$id.btn_action);
            final boolean B = B(a11);
            final boolean C = C(a11);
            PrizeButtonState prizeButtonState = B ? PrizeButtonState.ACTIVE : PrizeButtonState.CLAIMED;
            textView.setText(context.getString(B ? com.transsion.rewardscenter.R$string.prize_btn_claim : C ? com.transsion.rewardscenter.R$string.prize_btn_limit : com.transsion.rewardscenter.R$string.prize_btn_claimed));
            int i12 = a.f51042a[prizeButtonState.ordinal()];
            if (i12 == 1) {
                textView.setBackgroundResource(R$mipmap.btn_claim_normal);
                textView.setTextColor(context.getColor(R$color.white));
                textView.setEnabled(true);
            } else if (i12 == 2) {
                textView.setBackgroundResource(R$mipmap.btn_claim_done);
                textView.setTextColor(context.getColor(com.transsion.rewardscenter.R$color.prize_btn_claimed_text));
                textView.setEnabled(false);
            }
            jg.c.c(textView, 0L, new Function1() { // from class: com.transsion.rewardscenter.prize.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = b.A(B, context, this, C, (View) obj);
                    return A;
                }
            }, 1, null);
        }
    }
}
