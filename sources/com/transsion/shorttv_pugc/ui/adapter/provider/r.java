package com.transsion.shorttv_pugc.ui.adapter.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.bean.OperateItem;
import com.transsion.shorttv_pugc.bean.ShortTvItemType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final String f54146e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f54147f;

    public r(String pageName, boolean z10) {
        Intrinsics.h(pageName, "pageName");
        this.f54146e = pageName;
        this.f54147f = z10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return ShortTvItemType.TRENDING.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.pugc_short_tv_item_trending;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, OperateItem data) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(data, "data");
    }
}
