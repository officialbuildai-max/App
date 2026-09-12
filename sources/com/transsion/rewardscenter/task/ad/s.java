package com.transsion.rewardscenter.task.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class s extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f51174e = AdTaskType.TITLE.getValue();

    /* renamed from: f, reason: collision with root package name */
    private final int f51175f = R$layout.member_task_title_item;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f51174e;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f51175f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(m(), parent, false);
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, v item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
    }
}
