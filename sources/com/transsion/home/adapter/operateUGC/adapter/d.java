package com.transsion.home.adapter.operateUGC.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListItem;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import hl.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006'"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/adapter/d;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/RankingListItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", "<init>", "(ILcom/transsion/home/bean/OperateItem;I)V", "Landroid/content/Context;", "context", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "ugcVideo", "Landroid/view/ViewGroup;", "parent", RequestParameters.POSITION, "Landroid/view/View;", "F1", "(Landroid/content/Context;Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;Landroid/view/ViewGroup;I)Landroid/view/View;", "pos", "E1", "(I)I", "rankListItem", "", "G1", "(Lcom/transsion/home/bean/RankingListItem;I)V", "H1", "holder", WebConstants.FIELD_ITEM, "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "perWidth", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class d extends BaseQuickAdapter {
    public static final int I = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final int perWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i11, OperateItem operateItem, int i12) {
        super(i11, null, 2, null);
        Intrinsics.h(operateItem, "operateItem");
        this.operateItem = operateItem;
        this.tabId = i12;
        this.perWidth = Math.min(y.e(), y.c()) - a0.a(54.0f);
    }

    public /* synthetic */ d(int i11, OperateItem operateItem, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_ugc_provider_ranklist : i11, operateItem, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(UGCContent uGCContent, d dVar, RankingListItem rankingListItem, int i11, View view) {
        ov.c.h(uGCContent.getVideo(), Integer.valueOf(dVar.tabId), dVar.operateItem.getOpId());
        dVar.H1(rankingListItem, i11);
    }

    private final int E1(int pos) {
        return pos != 0 ? pos != 1 ? pos != 2 ? R$drawable.ic_ugc_rank_default : R$drawable.ic_ugc_rank_03 : R$drawable.ic_ugc_rank_02 : R$drawable.ic_ugc_rank_01;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.view.View F1(android.content.Context r7, com.transsion.ugcvideodetail.api.bean.UGCVideo r8, android.view.ViewGroup r9, int r10) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.operateUGC.adapter.d.F1(android.content.Context, com.transsion.ugcvideodetail.api.bean.UGCVideo, android.view.ViewGroup, int):android.view.View");
    }

    private final void G1(RankingListItem rankListItem, int position) {
        UGCContent uGCContent;
        List<UGCContent> contentList = rankListItem.getContentList();
        UGCVideo video = (contentList == null || (uGCContent = contentList.get(position)) == null) ? null : uGCContent.getVideo();
        d.a aVar = hl.d.f64648c;
        int i11 = this.tabId;
        OperateItem operateItem = this.operateItem;
        String title = rankListItem.getTitle();
        if (title == null) {
            title = "";
        }
        aVar.d(i11, position, operateItem, video, MapsKt.f(TuplesKt.a("page_tab_name", title)));
    }

    private final void H1(RankingListItem rankListItem, int position) {
        UGCContent uGCContent;
        List<UGCContent> contentList = rankListItem.getContentList();
        UGCVideo video = (contentList == null || (uGCContent = contentList.get(position)) == null) ? null : uGCContent.getVideo();
        d.a aVar = hl.d.f64648c;
        int i11 = this.tabId;
        OperateItem operateItem = this.operateItem;
        String title = rankListItem.getTitle();
        if (title == null) {
            title = "";
        }
        aVar.f(i11, position, operateItem, video, MapsKt.f(TuplesKt.a("page_tab_name", title)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final RankingListItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        LinearLayout linearLayout = (LinearLayout) holder.getView(R$id.home_ugc_rankinglist_liner);
        linearLayout.removeAllViews();
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = this.perWidth;
        linearLayout.setLayoutParams(layoutParams);
        List<UGCContent> contentList = item.getContentList();
        if (contentList != null) {
            final int i11 = 0;
            for (Object obj : contentList) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                final UGCContent uGCContent = (UGCContent) obj;
                View F1 = F1(getContext(), uGCContent.getVideo(), linearLayout, i11);
                linearLayout.addView(F1);
                F1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.adapter.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.D1(UGCContent.this, this, item, i11, view);
                    }
                });
                G1(item, i11);
                i11 = i12;
            }
        }
    }
}
