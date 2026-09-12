package com.transsion.rewardscenter.prize;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R$drawable;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.prize.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final Function0 f51044e;

    public d(Function0 onToggle) {
        Intrinsics.h(onToggle, "onToggle");
        this.f51044e = onToggle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(d dVar, View it) {
        Intrinsics.h(it, "it");
        dVar.f51044e.invoke();
        return Unit.f67184a;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PrizeItemType.FOOTER.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.prize_footer_item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, e item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (item instanceof e.b) {
            Context context = helper.itemView.getContext();
            if (((e.b) item).a()) {
                helper.setText(R$id.tv_toggle, context.getString(R$string.prize_hide));
                helper.setImageResource(R$id.iv_arrow, R$drawable.ic_arrow_up);
            } else {
                helper.setText(R$id.tv_toggle, context.getString(R$string.prize_view_more));
                helper.setImageResource(R$id.iv_arrow, R$drawable.ic_arrow_down);
            }
            View itemView = helper.itemView;
            Intrinsics.g(itemView, "itemView");
            jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.rewardscenter.prize.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = d.A(d.this, (View) obj);
                    return A;
                }
            }, 1, null);
        }
    }
}
