package com.transsion.search_pugc.fragment.result.provider;

import android.widget.ImageView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.util.k;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.SearchType;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import ej.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class ResultVerticalRankType2Provider extends BaseItemProvider implements t {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ t f52479e;

    public ResultVerticalRankType2Provider(t reportable) {
        Intrinsics.h(reportable, "reportable");
        this.f52479e = reportable;
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void a(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52479e.a(ugcVideo, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void c(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52479e.c(ugcVideo, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void d(SearchResultItem item, int i11) {
        Intrinsics.h(item, "item");
        this.f52479e.d(item, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void e(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52479e.e(ugcVideo, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return SearchType.VERTICAL_RANK_TYPE2.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_result_vertical_rank_type2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, SearchResultItem item) {
        List<UGCVideo> videos;
        UGCVideo uGCVideo;
        String str;
        String str2;
        UGCVideo uGCVideo2;
        String str3;
        String thumbnail;
        UGCVideo uGCVideo3;
        String str4;
        String str5;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        UGCVerticalRank verticalRank = item.getVerticalRank();
        if (verticalRank == null || (videos = item.getVerticalRank().getVideos()) == null || (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) == null) {
            return;
        }
        f.a aVar = ej.f.f62005a;
        f.b m11 = aVar.m(k());
        Cover cover = uGCVideo.getCover();
        String str6 = "";
        if (cover == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        f.b g11 = m11.g(str);
        Cover cover2 = uGCVideo.getCover();
        if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
            str2 = "";
        }
        g11.l(str2).d((ImageView) helper.getView(R$id.iv_cover));
        List<UGCVideo> videos2 = verticalRank.getVideos();
        if (videos2 == null || (uGCVideo3 = (UGCVideo) CollectionsKt.l0(videos2, 1)) == null) {
            kotlinx.coroutines.j.b(null, new ResultVerticalRankType2Provider$convert$2(helper, null), 1, null);
        } else {
            helper.setVisible(R$id.iv_cover1, true);
            f.b m12 = aVar.m(k());
            Cover cover3 = uGCVideo3.getCover();
            if (cover3 == null || (str4 = cover3.getUrl()) == null) {
                str4 = "";
            }
            f.b g12 = m12.g(str4);
            Cover cover4 = uGCVideo.getCover();
            if (cover4 == null || (str5 = cover4.getThumbnail()) == null) {
                str5 = "";
            }
            g12.l(str5).d((ImageView) helper.getView(R$id.iv_cover1));
        }
        List<UGCVideo> videos3 = verticalRank.getVideos();
        if (videos3 == null || (uGCVideo2 = (UGCVideo) CollectionsKt.l0(videos3, 2)) == null) {
            kotlinx.coroutines.j.b(null, new ResultVerticalRankType2Provider$convert$4(helper, null), 1, null);
        } else {
            helper.setVisible(R$id.iv_cover2, true);
            f.b m13 = aVar.m(k());
            Cover cover5 = uGCVideo2.getCover();
            if (cover5 == null || (str3 = cover5.getUrl()) == null) {
                str3 = "";
            }
            f.b g13 = m13.g(str3);
            Cover cover6 = uGCVideo.getCover();
            if (cover6 != null && (thumbnail = cover6.getThumbnail()) != null) {
                str6 = thumbnail;
            }
            g13.l(str6).d((ImageView) helper.getView(R$id.iv_cover2));
        }
        int i11 = R$id.tv_title;
        String title = verticalRank.getTitle();
        helper.setText(i11, title != null ? com.transsion.search_pugc.constant.a.d(title, k(), com.transsion.search_pugc.g.f52532h.a(k()).e()) : null);
        Integer count = verticalRank.getCount();
        if (count != null) {
            int intValue = count.intValue();
            if (intValue > 1) {
                helper.setText(R$id.tv_view_resource_tag, k().getString(R$string.videos, Integer.valueOf(intValue)));
            } else {
                helper.setText(R$id.tv_view_resource_tag, k().getString(R$string.video, Integer.valueOf(intValue)));
            }
        }
        jg.c.g(helper.getView(R$id.iv_view_resource_tag));
        k.a aVar2 = new k.a(R$drawable.ic_tag_collection);
        String string = k().getString(com.transsion.baseui.R$string.ugc_video_tv_collection);
        Intrinsics.g(string, "getString(...)");
        helper.setText(R$id.tv_info, com.transsion.baseui.util.q.g(CollectionsKt.q(aVar2, new k.b(string, Integer.valueOf(R$color.white_80)), new k.b(com.transsion.baseui.util.j.c(uGCVideo.getWatchNum(), k()), Integer.valueOf(R$color.white_60))), k(), false, 4, null));
    }
}
