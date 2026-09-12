package vq;

import android.widget.ImageView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$string;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import ej.f;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends BaseItemProvider {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return ResultType.VERTICAL_RANK.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_result_rank;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, ResultWrapData item) {
        String str;
        String str2;
        String description;
        Integer count;
        Cover cover;
        Cover cover2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        f.b m11 = ej.f.f62005a.m(k());
        VerticalRank verticalRank = item.getVerticalRank();
        String str3 = "";
        if (verticalRank == null || (cover2 = verticalRank.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = "";
        }
        f.b g11 = m11.g(str);
        VerticalRank verticalRank2 = item.getVerticalRank();
        if (verticalRank2 == null || (cover = verticalRank2.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
            str2 = "";
        }
        g11.l(str2).m(a0.a(50.0f)).d((ImageView) helper.getView(R$id.search_result_provider_rank_cover));
        int i11 = R$id.search_result_provider_rank_title;
        VerticalRank verticalRank3 = item.getVerticalRank();
        helper.setText(i11, verticalRank3 != null ? verticalRank3.getTitle() : null);
        VerticalRank verticalRank4 = item.getVerticalRank();
        int intValue = (verticalRank4 == null || (count = verticalRank4.getCount()) == null) ? 0 : count.intValue();
        if (intValue > 0) {
            str3 = k().getString(R$string.sources, Integer.valueOf(intValue));
        } else {
            VerticalRank verticalRank5 = item.getVerticalRank();
            if (verticalRank5 != null && (description = verticalRank5.getDescription()) != null) {
                str3 = description;
            }
        }
        Intrinsics.e(str3);
        helper.setText(R$id.search_result_provider_rank_subtitle, str3);
    }
}
