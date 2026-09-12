package com.transsion.home.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.MovieItem;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import r6.h;
import r6.i;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B1\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/transsion/home/adapter/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/MovieItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lr6/i;", "", "dataList", "Lhl/b;", "listExposureHelper", "Lcom/transsion/home/bean/LayoutStyle;", TtmlNode.TAG_STYLE, "", "rowCount", "<init>", "(Ljava/util/List;Lhl/b;Lcom/transsion/home/bean/LayoutStyle;I)V", "holder", WebConstants.FIELD_ITEM, "", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/MovieItem;)V", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "E1", "F", "Lhl/b;", "G", "Lcom/transsion/home/bean/LayoutStyle;", "D1", "()Lcom/transsion/home/bean/LayoutStyle;", "F1", "(Lcom/transsion/home/bean/LayoutStyle;)V", "H", "I", "C1", "()I", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class a extends BaseQuickAdapter implements i {
    public static final int I = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final hl.b listExposureHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private LayoutStyle style;

    /* renamed from: H, reason: from kotlin metadata */
    private final int rowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<MovieItem> dataList, hl.b bVar, LayoutStyle layoutStyle, int i11) {
        super(R$layout.home_adapter_movie, dataList);
        Intrinsics.h(dataList, "dataList");
        this.listExposureHelper = bVar;
        this.style = layoutStyle;
        this.rowCount = i11;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        hl.b bVar = this.listExposureHelper;
        if (bVar != null) {
            RecyclerView.m layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            bVar.h((GridLayoutManager) layoutManager, bindingAdapterPosition, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0144, code lost:
    
        if (r4.intValue() != r6) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0168, code lost:
    
        r0 = r1;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0133, code lost:
    
        if (r9.intValue() != r11) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0166, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r9, com.transsion.home.p004enum.LayoutStyleEnum.Square.getValue()) != false) goto L56;
     */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(com.chad.library.adapter.base.viewholder.BaseViewHolder r13, com.transsion.home.bean.MovieItem r14) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.a.F(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.home.bean.MovieItem):void");
    }

    /* renamed from: C1, reason: from getter */
    public final int getRowCount() {
        return this.rowCount;
    }

    /* renamed from: D1, reason: from getter */
    public final LayoutStyle getStyle() {
        return this.style;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.onViewRecycled(holder);
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView == null || shapeableImageView.getContext() == null) {
            return;
        }
        Context context = shapeableImageView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isDestroyed()) {
            Context context2 = shapeableImageView.getContext();
            Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
            if (activity2 == null || !activity2.isFinishing()) {
                Glide.with(shapeableImageView.getContext()).clear(shapeableImageView);
            }
        }
    }

    public final void F1(LayoutStyle layoutStyle) {
        this.style = layoutStyle;
    }

    @Override // r6.i
    public /* bridge */ /* synthetic */ r6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
