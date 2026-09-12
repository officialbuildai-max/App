package wq;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.fragment.suggest.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a extends BaseItemProvider {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.fragment_search_suggest_copy_writing_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, SuggestEntity item) {
        String str;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        int i11 = R$id.tvSearchSuggest;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        BaseProviderMultiAdapter g11 = g();
        com.transsion.search.fragment.suggest.d dVar = g11 instanceof com.transsion.search.fragment.suggest.d ? (com.transsion.search.fragment.suggest.d) g11 : null;
        if (dVar == null || (str = dVar.getMKeyWord()) == null) {
            str = "";
        }
        helper.setText(i11, companion.a(str, item.getWord()));
    }
}
