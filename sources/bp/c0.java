package bp;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.ui.view.ShortTvImmVideoItemView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c0 extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final Fragment f16750e;

    /* renamed from: f, reason: collision with root package name */
    private final String f16751f;

    /* renamed from: g, reason: collision with root package name */
    private final String f16752g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f16753h;

    /* renamed from: i, reason: collision with root package name */
    private final int f16754i;

    /* renamed from: j, reason: collision with root package name */
    private final int f16755j;

    public c0(Fragment fragment, String str, String str2, boolean z10) {
        Intrinsics.h(fragment, "fragment");
        this.f16750e = fragment;
        this.f16751f = str;
        this.f16752g = str2;
        this.f16753h = z10;
        this.f16754i = 1;
        this.f16755j = R$layout.item_short_tv_immersion_video;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f16754i;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f16755j;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        ShortTvImmVideoHelper.a aVar = ShortTvImmVideoHelper.f48908k;
        if (!aVar.a().l().isEmpty()) {
            View view = (View) aVar.a().l().remove(0);
            if (view.getParent() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new BaseViewHolder(view);
            }
        }
        return super.r(parent, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, Subject item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ((ShortTvImmVideoItemView) holder.getView(R$id.video_item)).setData(item, this.f16750e, Integer.valueOf(holder.getAdapterPosition()), this.f16751f, this.f16752g, this.f16753h);
    }
}
