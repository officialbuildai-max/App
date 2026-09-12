package com.transsion.home.adapter.suboperate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R$layout;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class u extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private List f44560a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44561b;

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.home.adapter.suboperate.provider.i f44562c;

    /* renamed from: d, reason: collision with root package name */
    private final OperateItem f44563d;

    /* renamed from: e, reason: collision with root package name */
    private final int f44564e;

    /* renamed from: f, reason: collision with root package name */
    private final int f44565f;

    public u(List banners, int i11, com.transsion.home.adapter.suboperate.provider.i bannerProvider, OperateItem operateItem) {
        Intrinsics.h(banners, "banners");
        Intrinsics.h(bannerProvider, "bannerProvider");
        Intrinsics.h(operateItem, "operateItem");
        this.f44560a = banners;
        this.f44561b = i11;
        this.f44562c = bannerProvider;
        this.f44563d = operateItem;
        this.f44565f = 1;
    }

    private final BannerData h(int i11) {
        int size;
        if (!this.f44560a.isEmpty() && (size = i11 % this.f44560a.size()) >= 0 && size < this.f44560a.size()) {
            return (BannerData) this.f44560a.get(size);
        }
        return null;
    }

    public final List g() {
        return this.f44560a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        BannerData h11 = h(i11);
        return (h11 != null ? h11.getBiddingAdData() : null) != null ? this.f44565f : this.f44564e;
    }

    public final void i(List list) {
        Intrinsics.h(list, "<set-?>");
        this.f44560a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.b0 holder, int i11) {
        Intrinsics.h(holder, "holder");
        if (this.f44560a.isEmpty()) {
            return;
        }
        int size = i11 % this.f44560a.size();
        if (getItemViewType(i11) == this.f44565f) {
            SubBannerADViewHolder subBannerADViewHolder = holder instanceof SubBannerADViewHolder ? (SubBannerADViewHolder) holder : null;
            if (subBannerADViewHolder != null) {
                subBannerADViewHolder.i(h(i11));
                return;
            }
            return;
        }
        SubBannerViewHolder subBannerViewHolder = holder instanceof SubBannerViewHolder ? (SubBannerViewHolder) holder : null;
        if (subBannerViewHolder != null) {
            subBannerViewHolder.g(h(i11), size);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.b0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        if (i11 == this.f44565f) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_banner_ad, parent, false);
            Intrinsics.e(inflate);
            return new SubBannerADViewHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_view_pager, parent, false);
        Intrinsics.e(inflate2);
        return new SubBannerViewHolder(inflate2, this.f44561b, this.f44562c, this.f44563d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.b0 holder) {
        Intrinsics.h(holder, "holder");
        super.onViewRecycled(holder);
        boolean z10 = holder instanceof SubBannerADViewHolder;
        if ((z10 ? (SubBannerADViewHolder) holder : null) != null) {
            SubBannerADViewHolder subBannerADViewHolder = z10 ? (SubBannerADViewHolder) holder : null;
            if (subBannerADViewHolder != null) {
                subBannerADViewHolder.k();
            }
        }
    }
}
