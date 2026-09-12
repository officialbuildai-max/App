package com.transsion.shorttv.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment;
import com.transsion.shorttv.ui.widget.ShortTvVideoItemView;
import com.transsion.shorttv.ui.widget.d;
import com.transsion.shorttv.utils.e;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class j extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final ShortTvDetailListFragment f53181e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f53182f;

    /* renamed from: g, reason: collision with root package name */
    private final String f53183g;

    /* renamed from: h, reason: collision with root package name */
    private final String f53184h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f53185i;

    /* renamed from: j, reason: collision with root package name */
    private final int f53186j;

    /* renamed from: k, reason: collision with root package name */
    private final int f53187k;

    public j(ShortTvDetailListFragment fragment, boolean z10, String str, String str2, boolean z11) {
        Intrinsics.h(fragment, "fragment");
        this.f53181e = fragment;
        this.f53182f = z10;
        this.f53183g = str;
        this.f53184h = str2;
        this.f53185i = z11;
        this.f53186j = 1;
        this.f53187k = R$layout.short_tv_item_video;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f53186j;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f53187k;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        e.a aVar = com.transsion.shorttv.utils.e.f53703c;
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
    public void b(BaseViewHolder holder, js.k item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (item instanceof js.e) {
            ShortTvVideoItemView shortTvVideoItemView = (ShortTvVideoItemView) holder.getView(R$id.view_video_item);
            js.e eVar = (js.e) item;
            ShortTvDetailListFragment shortTvDetailListFragment = this.f53181e;
            BaseProviderMultiAdapter g11 = g();
            d.a.a(shortTvVideoItemView, eVar, shortTvDetailListFragment, g11 != null ? Integer.valueOf(g11.g0(item)) : null, this.f53182f, this.f53183g, this.f53184h, false, this.f53185i, 64, null);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, js.k item, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        if (item instanceof js.e) {
            Object k02 = CollectionsKt.k0(payloads);
            ShortTvVideoItemView shortTvVideoItemView = (ShortTvVideoItemView) helper.getView(R$id.view_video_item);
            if (!(k02 instanceof Integer)) {
                if (k02 instanceof Boolean) {
                    shortTvVideoItemView.updateLockState((js.e) item);
                }
            } else {
                js.e eVar = (js.e) item;
                ShortTvDetailListFragment shortTvDetailListFragment = this.f53181e;
                BaseProviderMultiAdapter g11 = g();
                shortTvVideoItemView.setData(eVar, shortTvDetailListFragment, g11 != null ? Integer.valueOf(g11.g0(item)) : null, this.f53182f, this.f53183g, this.f53184h, true, this.f53185i);
            }
        }
    }
}
