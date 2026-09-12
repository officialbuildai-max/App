package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.edcation.CourseManager;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\rJ-\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/transsion/moviedetail/adapter/ForYouEduAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lr6/i;", "", "data", "<init>", "(Ljava/util/List;)V", "holder", WebConstants.FIELD_ITEM, "", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "C1", "", "", "payloads", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;Ljava/util/List;)V", "", "F", "I", "width", "", "G", "coverW", "H", "coverH", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class ForYouEduAdapter extends BaseQuickAdapter implements r6.i {

    /* renamed from: F, reason: from kotlin metadata */
    private final int width;

    /* renamed from: G, reason: from kotlin metadata */
    private final float coverW;

    /* renamed from: H, reason: from kotlin metadata */
    private final float coverH;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForYouEduAdapter(List<Subject> data) {
        super(R$layout.movie_detail_item_for_you_edu, data);
        Intrinsics.h(data, "data");
        this.width = y.e();
        float a11 = (r2 - a0.a(40.0f)) / 3.0f;
        this.coverW = a11;
        this.coverH = (a11 * 149.0f) / 107.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r0.intValue() == 1) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void E1(com.chad.library.adapter.base.viewholder.BaseViewHolder r3, final com.transsion.moviedetailapi.bean.Subject r4) {
        /*
            r2 = this;
            int r0 = com.transsion.moviedetail.R$id.ivAdd
            android.view.View r3 = r3.getViewOrNull(r0)
            androidx.appcompat.widget.AppCompatImageView r3 = (androidx.appcompat.widget.AppCompatImageView) r3
            if (r3 == 0) goto L25
            java.lang.Integer r0 = r4.getSeenStatus()
            if (r0 != 0) goto L11
            goto L19
        L11:
            int r0 = r0.intValue()
            r1 = 1
            if (r0 != r1) goto L19
            goto L1a
        L19:
            r1 = 0
        L1a:
            r3.setSelected(r1)
            com.transsion.moviedetail.adapter.d r0 = new com.transsion.moviedetail.adapter.d
            r0.<init>()
            r3.setOnClickListener(r0)
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.adapter.ForYouEduAdapter.E1(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.moviedetailapi.bean.Subject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(Subject subject, View view) {
        CourseManager.v(CourseManager.f44139a, subject, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, Subject item) {
        String str;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            if (item.getBuiltIn()) {
                kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new ForYouEduAdapter$convert$1$1(item, shapeableImageView, null), 3, null);
            } else {
                f.a aVar = ej.f.f62005a;
                Context context = shapeableImageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                Cover cover = item.getCover();
                f.b c11 = m11.g(cover != null ? cover.getUrl() : null).m((int) this.coverW).c((int) this.coverH);
                Cover cover2 = item.getCover();
                if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                    str = "";
                }
                c11.l(str).d(shapeableImageView);
            }
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getViewOrNull(R$id.tv_title);
        if (appCompatTextView != null) {
            appCompatTextView.setText(item.getTitle());
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) holder.getViewOrNull(R$id.tvTag);
        if (appCompatTextView2 != null) {
            Context context2 = appCompatTextView2.getContext();
            Intrinsics.g(context2, "getContext(...)");
            appCompatTextView2.setText(defpackage.a.b(context2, item));
        }
        E1(holder, item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, Subject item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        if (!payloads.isEmpty() && (payloads.get(payloads.size() - 1) instanceof Integer)) {
            E1(holder, item);
        }
    }

    @Override // r6.i
    public /* bridge */ /* synthetic */ r6.f b(BaseQuickAdapter baseQuickAdapter) {
        return r6.h.a(this, baseQuickAdapter);
    }
}
