package er;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.SearchSuggestItem;
import com.transsion.search_pugc.fragment.suggest.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
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
    public void b(BaseViewHolder helper, SearchSuggestItem item) {
        String str;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        int i11 = R$id.tvSearchSuggest;
        e.Companion companion = e.INSTANCE;
        BaseProviderMultiAdapter g11 = g();
        e eVar = g11 instanceof e ? (e) g11 : null;
        if (eVar == null || (str = eVar.getMKeyWord()) == null) {
            str = "";
        }
        helper.setText(i11, companion.a(str, item.getWord()));
    }
}
