package com.transsion.rewardscenter.task.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.v;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class p extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final MemberTaskAdHelper f51164e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f51165f;

    /* renamed from: g, reason: collision with root package name */
    private final int f51166g = AdTaskType.REWARD_AD.getValue();

    /* renamed from: h, reason: collision with root package name */
    private final int f51167h = R$layout.member_task_reward_layout;

    public p(MemberTaskAdHelper memberTaskAdHelper) {
        this.f51164e = memberTaskAdHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(p pVar, View view) {
        pVar.D(true);
        MemberTaskAdHelper memberTaskAdHelper = pVar.f51164e;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.Y(new Function1() { // from class: com.transsion.rewardscenter.task.ad.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit C;
                    C = p.C(((Boolean) obj).booleanValue());
                    return C;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(boolean z10) {
        return Unit.f67184a;
    }

    private final void D(boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_reward");
        if (z10) {
            hj.i.f64628a.p("MemberAdTask", hashMap);
        } else {
            hj.i.f64628a.D("MemberAdTask", hashMap);
        }
    }

    static /* synthetic */ void E(p pVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        pVar.D(z10);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, v item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (item instanceof v.b) {
            View findViewById = helper.itemView.findViewById(R$id.reward_action);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.task.ad.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.B(p.this, view);
                    }
                });
            }
            if (this.f51165f) {
                return;
            }
            this.f51165f = true;
            E(this, false, 1, null);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f51166g;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f51167h;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(m(), parent, false);
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }
}
