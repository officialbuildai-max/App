package com.transsnet.downloader.adapter;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/transsnet/downloader/adapter/v0;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "datas", "<init>", "(Ljava/util/List;)V", "holder", "", RequestParameters.POSITION, "", "w0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", WebConstants.FIELD_ITEM, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class v0 extends BaseQuickAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(List<Subject> datas) {
        super(R$layout.item_movie_rec, datas);
        Intrinsics.h(datas, "datas");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        if (r0.intValue() == 1) goto L32;
     */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(com.chad.library.adapter.base.viewholder.BaseViewHolder r10, com.transsion.moviedetailapi.bean.Subject r11) {
        /*
            r9 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            int r0 = com.transsnet.downloader.R$id.iv_cover
            android.view.View r0 = r10.getViewOrNull(r0)
            com.google.android.material.imageview.ShapeableImageView r0 = (com.google.android.material.imageview.ShapeableImageView) r0
            if (r0 == 0) goto L4b
            ej.f$a r1 = ej.f.f62005a
            android.content.Context r2 = r0.getContext()
            java.lang.String r3 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)
            ej.f$b r1 = r1.m(r2)
            com.transsion.moviedetailapi.bean.Cover r2 = r11.getCover()
            java.lang.String r3 = ""
            if (r2 == 0) goto L31
            java.lang.String r2 = r2.getUrl()
            if (r2 != 0) goto L32
        L31:
            r2 = r3
        L32:
            ej.f$b r1 = r1.g(r2)
            com.transsion.moviedetailapi.bean.Cover r2 = r11.getCover()
            if (r2 == 0) goto L44
            java.lang.String r2 = r2.getThumbnail()
            if (r2 != 0) goto L43
            goto L44
        L43:
            r3 = r2
        L44:
            ej.f$b r1 = r1.l(r3)
            r1.d(r0)
        L4b:
            int r0 = com.transsnet.downloader.R$id.tv_score
            java.lang.String r1 = r11.getImdbRate()
            r10.setText(r0, r1)
            int r0 = com.transsnet.downloader.R$id.tv_title
            java.lang.String r1 = r11.getTitle()
            r10.setText(r0, r1)
            int r0 = com.transsnet.downloader.R$id.download
            android.view.View r0 = r10.getViewOrNull(r0)
            r1 = r0
            com.transsnet.downloader.widget.DownloadView r1 = (com.transsnet.downloader.widget.DownloadView) r1
            if (r1 == 0) goto Lb1
            ak.t r0 = ak.t.f727a
            boolean r0 = r0.b()
            if (r0 == 0) goto L74
            r1.setShowPlayType()
            goto Lb1
        L74:
            java.lang.Boolean r0 = r11.getHasResource()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r2)
            if (r0 == 0) goto Lae
            jg.c.k(r1)
            com.transsion.moviedetailapi.bean.ResourceDetectors r0 = r11.getResourceDetector()
            if (r0 == 0) goto Lb1
            java.lang.String r2 = r11.getSubjectId()
            java.lang.String r3 = r0.getResourceId()
            java.lang.Integer r0 = r0.getType()
            if (r0 != 0) goto L98
            goto La0
        L98:
            int r0 = r0.intValue()
            r4 = 1
            if (r0 != r4) goto La0
            goto La1
        La0:
            r4 = 0
        La1:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r7 = 24
            r8 = 0
            r5 = 0
            r6 = 0
            com.transsnet.downloader.widget.DownloadView.setShowType$default(r1, r2, r3, r4, r5, r6, r7, r8)
            goto Lb1
        Lae:
            jg.c.g(r1)
        Lb1:
            int r0 = com.transsnet.downloader.R$id.icon_download
            android.view.View r0 = r10.getViewOrNull(r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            if (r0 == 0) goto Lca
            ak.t r1 = ak.t.f727a
            boolean r1 = r1.b()
            if (r1 == 0) goto Lc7
            jg.c.g(r0)
            goto Lca
        Lc7:
            jg.c.k(r0)
        Lca:
            int r0 = com.transsnet.downloader.R$id.tv_download_corner
            android.view.View r10 = r10.getView(r0)
            com.tn.lib.view.CornerTextView r10 = (com.tn.lib.view.CornerTextView) r10
            java.lang.String r0 = r11.getCorner()
            java.lang.Integer r11 = r11.getSubjectType()
            r10.setTextWithType(r0, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.adapter.v0.F(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.moviedetailapi.bean.Subject):void");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0 */
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.h(holder, "holder");
        super.onBindViewHolder(holder, position);
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.getViewOrNull(R$id.item);
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.n nVar = (RecyclerView.n) layoutParams;
            if (position == 0) {
                nVar.setMarginStart(com.blankj.utilcode.util.a0.a(16.0f));
                nVar.setMarginEnd(0);
            } else if (position == getItemCount() - 1) {
                nVar.setMarginStart(com.blankj.utilcode.util.a0.a(8.0f));
                nVar.setMarginEnd(com.blankj.utilcode.util.a0.a(16.0f));
            } else {
                nVar.setMarginStart(com.blankj.utilcode.util.a0.a(8.0f));
                nVar.setMarginEnd(0);
            }
        }
    }
}
