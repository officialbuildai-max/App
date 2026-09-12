package com.transsion.home.adapter.trending.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import ej.f;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f44838e;

    public l(int i11) {
        this.f44838e = (com.blankj.utilcode.util.y.e() - com.blankj.utilcode.util.a0.a(((i11 - 1) * 8) + 24.0f)) / i11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.GRID_SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_grid_feeds_subject;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        String str;
        Cover cover;
        String thumbnail;
        Cover cover2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getView(R$id.iv_cover);
        f.b m11 = ej.f.f62005a.m(k());
        Subject feedsSubject = item.getFeedsSubject();
        String str2 = "";
        if (feedsSubject == null || (cover2 = feedsSubject.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = "";
        }
        f.b g11 = m11.g(str);
        Subject feedsSubject2 = item.getFeedsSubject();
        if (feedsSubject2 != null && (cover = feedsSubject2.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        g11.l(str2).m(this.f44838e).d(shapeableImageView);
        int i11 = R$id.tv_title;
        Subject feedsSubject3 = item.getFeedsSubject();
        helper.setText(i11, feedsSubject3 != null ? feedsSubject3.getTitle() : null);
        CornerTextView cornerTextView = (CornerTextView) helper.getView(R$id.tv_tips);
        Subject feedsSubject4 = item.getFeedsSubject();
        String corner = feedsSubject4 != null ? feedsSubject4.getCorner() : null;
        Subject feedsSubject5 = item.getFeedsSubject();
        cornerTextView.setTextWithType(corner, feedsSubject5 != null ? feedsSubject5.getSubjectType() : null);
    }
}
