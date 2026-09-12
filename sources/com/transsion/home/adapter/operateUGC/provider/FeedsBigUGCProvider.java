package com.transsion.home.adapter.operateUGC.provider;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.R$string;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import com.transsion.wrapperad.R$color;
import ej.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class FeedsBigUGCProvider extends com.transsion.home.adapter.trending.provider.b {

    /* renamed from: e, reason: collision with root package name */
    private final int f44359e;

    /* renamed from: f, reason: collision with root package name */
    private final int f44360f = com.blankj.utilcode.util.y.e() - (com.blankj.utilcode.util.a0.a(12.0f) * 2);

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f44361g = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.operateUGC.provider.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            hl.d I;
            I = FeedsBigUGCProvider.I(FeedsBigUGCProvider.this);
            return I;
        }
    });

    public FeedsBigUGCProvider(int i11) {
        this.f44359e = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(OperateItem operateItem, FeedsBigUGCProvider feedsBigUGCProvider, BaseViewHolder baseViewHolder, View view) {
        UGCVideo feedsUGCVideo = operateItem.getFeedsUGCVideo();
        if (feedsUGCVideo != null) {
            Integer valueOf = Integer.valueOf(feedsBigUGCProvider.f44359e);
            String opId = operateItem.getOpId();
            if (opId == null) {
                OperateItem originalOperateItem = operateItem.getOriginalOperateItem();
                opId = originalOperateItem != null ? originalOperateItem.getOpId() : null;
            }
            ov.c.h(feedsUGCVideo, valueOf, opId);
        }
        hl.d.f64648c.c(baseViewHolder.getLayoutPosition(), operateItem, feedsBigUGCProvider.f44359e);
    }

    private final hl.d H() {
        return (hl.d) this.f44361g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final hl.d I(FeedsBigUGCProvider feedsBigUGCProvider) {
        return new hl.d(SubTabFragment.INSTANCE.a(feedsBigUGCProvider.f44359e));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder helper, final OperateItem item) {
        String ugcVideoId;
        String i11;
        List q11;
        String nickname;
        String str;
        String str2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        helper.itemView.setTag("UGCFeedsBig");
        UGCVideo feedsUGCVideo = item.getFeedsUGCVideo();
        if (feedsUGCVideo == null || (ugcVideoId = feedsUGCVideo.getUgcVideoId()) == null || ugcVideoId.length() == 0) {
            return;
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.main_op_trending_grid_image);
        String str3 = "";
        if (shapeableImageView != null) {
            if (feedsUGCVideo.getBuiltIn()) {
                kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new FeedsBigUGCProvider$convert$1$1(feedsUGCVideo, shapeableImageView, null), 3, null);
            } else {
                f.a aVar = ej.f.f62005a;
                Context context = shapeableImageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                Cover cover = feedsUGCVideo.getCover();
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = "";
                }
                f.b m12 = m11.g(str).m(this.f44360f);
                Cover cover2 = feedsUGCVideo.getCover();
                if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                    str2 = "";
                }
                m12.l(str2).i(R$color.module_01).d(shapeableImageView);
            }
        }
        TextView textView = (TextView) helper.getViewOrNull(R$id.main_op_trending_grid_title);
        if (textView != null) {
            textView.setText(feedsUGCVideo.getTitle());
        }
        helper.setText(R$id.main_op_trending_grid_corner, feedsUGCVideo.getCorner());
        ImageView imageView = (ImageView) helper.getViewOrNull(R$id.main_op_trending_grid_type_icon);
        if (imageView != null) {
            UGCVideoTypeKt.i(imageView, feedsUGCVideo, null, 4, null);
        }
        helper.setText(R$id.main_op_trending_grid_time_text, feedsUGCVideo.getTimeOrCount(k()));
        helper.setText(R$id.main_op_trending_grid_title, feedsUGCVideo.getTitle());
        if (feedsUGCVideo.isVerticalImmStyle()) {
            q11 = CollectionsKt.q("special_#shorts_icon", Utils.a().getString(R$string.ugc_video_shorts), com.transsion.baseui.util.j.c(feedsUGCVideo.getWatchNum(), k()));
        } else {
            if (HomeTabId.INSTANCE.h(Integer.valueOf(this.f44359e), false)) {
                UGCVideoCreator creator = feedsUGCVideo.getCreator();
                String nickname2 = creator != null ? creator.getNickname() : null;
                if (nickname2 != null && nickname2.length() != 0) {
                    String c11 = com.transsion.baseui.util.j.c(feedsUGCVideo.getWatchNum(), k());
                    UGCVideoCreator creator2 = feedsUGCVideo.getCreator();
                    if (creator2 != null && (nickname = creator2.getNickname()) != null) {
                        str3 = nickname;
                    }
                    q11 = CollectionsKt.q(c11, "special_#user_icon", str3);
                }
            }
            String c12 = com.transsion.baseui.util.j.c(feedsUGCVideo.getWatchNum(), k());
            if (this.f44359e == HomeTabId.UGC_Trending.getValue()) {
                Long publishTime = feedsUGCVideo.getPublishTime();
                i11 = TimeUtilKt.j(publishTime != null ? publishTime.longValue() : 0L);
            } else {
                Long publishTime2 = feedsUGCVideo.getPublishTime();
                i11 = TimeUtilKt.i(publishTime2 != null ? publishTime2.longValue() : 0L);
            }
            q11 = CollectionsKt.q(c12, i11);
        }
        helper.setText(R$id.main_op_trending_grid_subtitle, com.transsion.baseui.util.q.e(q11, k()));
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsBigUGCProvider.G(OperateItem.this, this, helper, view);
            }
        });
        if (this.f44359e != HomeTabId.UGC_Trending.getValue()) {
            H().a(item, helper.getLayoutPosition(), 0L);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.TRENDING_FEES_BIG.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_ugc_item_big;
    }
}
