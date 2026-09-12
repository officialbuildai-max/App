package wq;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.suggest.d;
import ej.f;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends BaseItemProvider {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.fragment_search_suggest_list_cover_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, SuggestEntity item) {
        String str;
        String mKeyWord;
        Cover cover;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        f.b m11 = f.f62005a.m(k());
        VerticalRank verticalRank = item.getVerticalRank();
        String str2 = "";
        if (verticalRank == null || (cover = verticalRank.getCover()) == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        m11.g(str).i(R$drawable.ic_list_cover).d((ImageView) helper.getView(R$id.ivCover));
        int i11 = R$id.tvTitle;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        BaseProviderMultiAdapter g11 = g();
        com.transsion.search.fragment.suggest.d dVar = g11 instanceof com.transsion.search.fragment.suggest.d ? (com.transsion.search.fragment.suggest.d) g11 : null;
        if (dVar != null && (mKeyWord = dVar.getMKeyWord()) != null) {
            str2 = mKeyWord;
        }
        VerticalRank verticalRank2 = item.getVerticalRank();
        helper.setText(i11, companion.a(str2, verticalRank2 != null ? verticalRank2.getTitle() : null));
        int i12 = R$id.tvDes;
        VerticalRank verticalRank3 = item.getVerticalRank();
        helper.setText(i12, verticalRank3 != null ? verticalRank3.getDescription() : null);
    }
}
