package com.transsion.rewardscenter.task.ad;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.v;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final BaseStageTaskAdHelper f51170e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f51171f;

    /* renamed from: g, reason: collision with root package name */
    private final int f51172g = AdTaskType.STAGE_AD.getValue();

    /* renamed from: h, reason: collision with root package name */
    private final int f51173h = R$layout.member_task_stage_item_layout;

    public r(BaseStageTaskAdHelper baseStageTaskAdHelper) {
        this.f51170e = baseStageTaskAdHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(r rVar, v vVar, v.c it) {
        Intrinsics.h(it, "it");
        rVar.B((v.c) vVar);
        return Unit.f67184a;
    }

    private final void B(v.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_stage");
        hashMap.put("ad_state", cVar.e().name());
        hj.i.f64628a.p("MemberAdTask", hashMap);
    }

    private final void C() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_stage");
        hj.i.f64628a.D("MemberAdTask", hashMap);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f51172g;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f51173h;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final v item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (item instanceof v.c) {
            View view = helper.itemView;
            Intrinsics.f(view, "null cannot be cast to non-null type com.transsion.rewardscenter.task.ad.StageTaskAdView");
            StageTaskAdView stageTaskAdView = (StageTaskAdView) view;
            stageTaskAdView.setAdHelper(this.f51170e);
            stageTaskAdView.setData((v.c) item);
            stageTaskAdView.setClickCallback(new Function1() { // from class: com.transsion.rewardscenter.task.ad.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = r.A(r.this, item, (v.c) obj);
                    return A;
                }
            });
            if (this.f51171f) {
                return;
            }
            this.f51171f = true;
            C();
        }
    }
}
