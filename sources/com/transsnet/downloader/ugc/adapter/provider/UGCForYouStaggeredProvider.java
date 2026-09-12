package com.transsnet.downloader.ugc.adapter.provider;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
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
import com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredAdapter;
import com.transsnet.downloader.ugc.adapter.c;
import ej.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class UGCForYouStaggeredProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f59745e = dk.a.b(164);

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return UGCDownloadStaggeredAdapter.ItemType.FOR_YOU.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.adapter_ugc_foryou_staggered_item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, com.transsnet.downloader.ugc.adapter.c item) {
        List q11;
        String str;
        String thumbnail;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            ((StaggeredGridLayoutManager.b) layoutParams).c(false);
        }
        UGCVideo a11 = ((c.e) item).a();
        String ugcVideoId = a11.getUgcVideoId();
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            return;
        }
        Context context = helper.itemView.getContext();
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.main_op_trending_grid_image);
        if (shapeableImageView != null) {
            if (a11.getBuiltIn()) {
                k.d(o0.a(y0.c()), null, null, new UGCForYouStaggeredProvider$convert$1$1(a11, context, shapeableImageView, null), 3, null);
            } else {
                shapeableImageView.measure(0, 0);
                f.a aVar = ej.f.f62005a;
                Intrinsics.e(context);
                f.b m11 = aVar.m(context);
                Cover cover = a11.getCover();
                String str2 = "";
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = "";
                }
                f.b m12 = m11.g(str).m(this.f59745e);
                Cover cover2 = a11.getCover();
                if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                m12.l(str2).d(shapeableImageView);
            }
        }
        TextView textView = (TextView) helper.getViewOrNull(R$id.main_op_trending_grid_title);
        if (textView != null) {
            textView.setText(a11.getTitle());
        }
        helper.setText(R$id.main_op_trending_grid_corner, a11.getCorner());
        ImageView imageView = (ImageView) helper.getViewOrNull(R$id.main_op_trending_grid_type_icon);
        if (imageView != null) {
            UGCVideoTypeKt.i(imageView, a11, null, 4, null);
        }
        int i11 = R$id.main_op_trending_grid_time_text;
        Long duration = a11.getDuration();
        helper.setText(i11, TimeUtilKt.a(duration != null ? Integer.valueOf((int) duration.longValue()) : null));
        if (a11.isVerticalImmStyle()) {
            String string = Utils.a().getString(R$string.ugc_video_shorts);
            String watchNum = a11.getWatchNum();
            Intrinsics.e(context);
            q11 = CollectionsKt.q("special_#shorts_icon", string, j.c(watchNum, context));
        } else {
            String watchNum2 = a11.getWatchNum();
            Intrinsics.e(context);
            String c11 = j.c(watchNum2, context);
            Long publishTime = a11.getPublishTime();
            q11 = CollectionsKt.q(c11, TimeUtilKt.k(publishTime != null ? publishTime.longValue() : 0L));
        }
        helper.setText(R$id.main_op_trending_grid_subtitle, q.e(q11, context));
    }
}
