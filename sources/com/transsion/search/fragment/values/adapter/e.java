package com.transsion.search.fragment.values.adapter;

import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchValuesRelatedCollectionEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.suggest.d;
import com.transsion.search.fragment.values.SearchValuesFragment;
import ej.f;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f52233e = a0.a(72.0f);

    /* renamed from: f, reason: collision with root package name */
    private final int f52234f = a0.a(96.0f);

    private final String z() {
        String mKeyWord;
        BaseProviderMultiAdapter g11 = g();
        b bVar = g11 instanceof b ? (b) g11 : null;
        return (bVar == null || (mKeyWord = bVar.getMKeyWord()) == null) ? "" : mKeyWord;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_search_values_vertical_rank_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, SearchValuesRelatedCollectionEntity item) {
        String str;
        Cover cover;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        int i11 = R$id.tvTitle;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        String z10 = z();
        VerticalRank verticalRank = item.getVerticalRank();
        helper.setText(i11, companion.a(z10, verticalRank != null ? verticalRank.getTitle() : null));
        int i12 = R$id.tvSubTitle;
        VerticalRank verticalRank2 = item.getVerticalRank();
        helper.setText(i12, verticalRank2 != null ? verticalRank2.getDescription() : null);
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getView(R$id.ivCover);
        f.a aVar = f.f62005a;
        VerticalRank verticalRank3 = item.getVerticalRank();
        if (verticalRank3 == null || (cover = verticalRank3.getCover()) == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        aVar.m(k()).g(f.a.e(aVar, str, this.f52233e, false, false, 12, null)).d(shapeableImageView);
        SearchValuesFragment.Companion companion2 = SearchValuesFragment.INSTANCE;
        Staff staff = item.getStaff();
        companion2.d("", "", staff != null ? staff.getStaffId() : null, "", helper.getBindingAdapterPosition(), 1);
    }
}
