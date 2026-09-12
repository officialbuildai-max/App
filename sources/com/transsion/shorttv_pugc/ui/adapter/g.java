package com.transsion.shorttv_pugc.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment;
import com.transsion.shorttv_pugc.ui.widget.ShortTvVideoItemView;
import com.transsion.shorttv_pugc.ui.widget.a;
import com.transsion.shorttv_pugc.utils.e;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final ShortTvDetailListFragment f54073e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f54074f;

    /* renamed from: g, reason: collision with root package name */
    private final String f54075g;

    /* renamed from: h, reason: collision with root package name */
    private final String f54076h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f54077i;

    /* renamed from: j, reason: collision with root package name */
    private final int f54078j;

    /* renamed from: k, reason: collision with root package name */
    private final int f54079k;

    public g(ShortTvDetailListFragment fragment, boolean z10, String str, String str2, boolean z11) {
        Intrinsics.h(fragment, "fragment");
        this.f54073e = fragment;
        this.f54074f = z10;
        this.f54075g = str;
        this.f54076h = str2;
        this.f54077i = z11;
        this.f54078j = 1;
        this.f54079k = R$layout.pugc_short_tv_item_video;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f54078j;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f54079k;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        e.a aVar = com.transsion.shorttv_pugc.utils.e.f54495c;
        if (!aVar.a().d().isEmpty()) {
            View view = (View) aVar.a().d().remove(0);
            if (view.getParent() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new BaseViewHolder(view);
            }
        }
        return super.r(parent, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, ShorttvModel.UGCVideo item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShortTvVideoItemView shortTvVideoItemView = (ShortTvVideoItemView) holder.getView(R$id.view_video_item);
        ShortTvDetailListFragment shortTvDetailListFragment = this.f54073e;
        BaseProviderMultiAdapter g11 = g();
        a.C0665a.a(shortTvVideoItemView, item, shortTvDetailListFragment, g11 != null ? Integer.valueOf(g11.g0(item)) : null, this.f54074f, this.f54075g, this.f54076h, false, this.f54077i, 64, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, ShorttvModel.UGCVideo item, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        Object k02 = CollectionsKt.k0(payloads);
        ShortTvVideoItemView shortTvVideoItemView = (ShortTvVideoItemView) helper.getView(R$id.view_video_item);
        if (k02 instanceof Integer) {
            ShortTvDetailListFragment shortTvDetailListFragment = this.f54073e;
            BaseProviderMultiAdapter g11 = g();
            shortTvVideoItemView.setData(item, shortTvDetailListFragment, g11 != null ? Integer.valueOf(g11.g0(item)) : null, this.f54074f, this.f54075g, this.f54076h, true, this.f54077i);
        } else if (k02 instanceof Boolean) {
            shortTvVideoItemView.updateLockState(item);
        }
    }
}
