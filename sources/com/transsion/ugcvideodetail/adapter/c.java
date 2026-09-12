package com.transsion.ugcvideodetail.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment;
import com.transsion.ugcvideodetail.widget.UGCImmVideoItemView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final UGCImmVideoDetailFragment f56121e;

    /* renamed from: f, reason: collision with root package name */
    private final String f56122f;

    /* renamed from: g, reason: collision with root package name */
    private final String f56123g;

    /* renamed from: h, reason: collision with root package name */
    private final String f56124h;

    /* renamed from: i, reason: collision with root package name */
    private final int f56125i;

    /* renamed from: j, reason: collision with root package name */
    private final int f56126j;

    public c(UGCImmVideoDetailFragment fragment, String trackId, String str, String str2) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(trackId, "trackId");
        this.f56121e = fragment;
        this.f56122f = trackId;
        this.f56123g = str;
        this.f56124h = str2;
        this.f56125i = 1;
        this.f56126j = R$layout.item_ugc_imm_video_detail;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f56125i;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f56126j;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, UGCImmVideo item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        UGCImmVideoItemView uGCImmVideoItemView = (UGCImmVideoItemView) holder.getView(R$id.viewImmVideoItem);
        BaseProviderMultiAdapter g11 = g();
        uGCImmVideoItemView.setData(g11 != null ? Integer.valueOf(g11.g0(item)) : null, this.f56121e, this.f56122f, this.f56123g, this.f56124h, item);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, UGCImmVideo item, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        Object k02 = CollectionsKt.k0(payloads);
        UGCImmVideoItemView uGCImmVideoItemView = (UGCImmVideoItemView) helper.getView(R$id.viewImmVideoItem);
        if (k02 instanceof Integer) {
            uGCImmVideoItemView.setDownloadStatus(((Number) k02).intValue());
        }
    }
}
