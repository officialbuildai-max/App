package com.transsnet.downloader.ugc.adapter.provider;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.R$string;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.baseui.util.q;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.ugc.adapter.UGCForYouAdapter;
import ej.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class UGCForYouGridProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f59743e = dk.a.b(164);

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return UGCForYouAdapter.ItemType.UGC_GRID_ITEM.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.adapter_ugc_foryou_grid_item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, UGCVideo item) {
        List q11;
        String str;
        String thumbnail;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        String ugcVideoId = item.getUgcVideoId();
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            return;
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.main_op_trending_grid_image);
        if (shapeableImageView != null) {
            if (item.getBuiltIn()) {
                k.d(o0.a(y0.c()), null, null, new UGCForYouGridProvider$convert$1$1(item, shapeableImageView, null), 3, null);
            } else {
                shapeableImageView.measure(0, 0);
                f.a aVar = ej.f.f62005a;
                Context context = shapeableImageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                Cover cover = item.getCover();
                String str2 = "";
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = "";
                }
                f.b m12 = m11.g(str).m(this.f59743e);
                Cover cover2 = item.getCover();
                if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                m12.l(str2).d(shapeableImageView);
            }
        }
        TextView textView = (TextView) helper.getViewOrNull(R$id.main_op_trending_grid_title);
        if (textView != null) {
            textView.setText(item.getTitle());
        }
        helper.setText(R$id.main_op_trending_grid_corner, item.getCorner());
        ImageView imageView = (ImageView) helper.getViewOrNull(R$id.main_op_trending_grid_type_icon);
        if (imageView != null) {
            UGCVideoTypeKt.i(imageView, item, null, 4, null);
        }
        int i11 = R$id.main_op_trending_grid_time_text;
        Long duration = item.getDuration();
        helper.setText(i11, TimeUtilKt.a(duration != null ? Integer.valueOf((int) duration.longValue()) : null));
        helper.setText(R$id.main_op_trending_grid_title, item.getTitle());
        if (item.isVerticalImmStyle()) {
            q11 = CollectionsKt.q("special_#shorts_icon", Utils.a().getString(R$string.ugc_video_shorts), j.c(item.getWatchNum(), k()));
        } else {
            String c11 = j.c(item.getWatchNum(), k());
            Long publishTime = item.getPublishTime();
            q11 = CollectionsKt.q(c11, TimeUtilKt.k(publishTime != null ? publishTime.longValue() : 0L));
        }
        helper.setText(R$id.main_op_trending_grid_subtitle, q.e(q11, k()));
    }
}
