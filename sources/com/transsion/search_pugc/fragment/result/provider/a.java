package com.transsion.search_pugc.fragment.result.provider;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f52480e = ResultCollectItemWrapper.Type.FOOTER.ordinal();

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f52480e;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.search_collection_footer;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, ResultCollectItemWrapper item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.n nVar = (RecyclerView.n) layoutParams;
        ((ViewGroup.MarginLayoutParams) nVar).width = com.blankj.utilcode.util.i.e(26.0f);
        ((ViewGroup.MarginLayoutParams) nVar).height = com.blankj.utilcode.util.i.e(102.0f);
        helper.itemView.setLayoutParams(nVar);
    }
}
