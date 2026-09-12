package com.transsion.shorttv._channel.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv._channel.model.ShortTvLayoutStyle;
import com.transsion.shorttv._channel.model.ShortTvLayoutStyleEnum;
import com.transsion.shorttv._channel.model.ShortTvMovieItem;
import com.transsion.shorttv.base.widget.CornerTextView;
import com.transsion.shorttv.bean.Cover;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r6.h;
import r6.i;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B1\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/adapter/c;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/shorttv/_channel/model/ShortTvMovieItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lr6/i;", "", "dataList", "Lxr/b;", "listExposureHelper", "Lcom/transsion/shorttv/_channel/model/ShortTvLayoutStyle;", TtmlNode.TAG_STYLE, "", "rowCount", "<init>", "(Ljava/util/List;Lxr/b;Lcom/transsion/shorttv/_channel/model/ShortTvLayoutStyle;I)V", "holder", WebConstants.FIELD_ITEM, "", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/shorttv/_channel/model/ShortTvMovieItem;)V", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "E1", "F", "Lxr/b;", "G", "Lcom/transsion/shorttv/_channel/model/ShortTvLayoutStyle;", "D1", "()Lcom/transsion/shorttv/_channel/model/ShortTvLayoutStyle;", "F1", "(Lcom/transsion/shorttv/_channel/model/ShortTvLayoutStyle;)V", "H", "I", "C1", "()I", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class c extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final xr.b listExposureHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private ShortTvLayoutStyle style;

    /* renamed from: H, reason: from kotlin metadata */
    private final int rowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<ShortTvMovieItem> dataList, xr.b bVar, ShortTvLayoutStyle shortTvLayoutStyle, int i11) {
        super(R$layout.short_tv_home_adapter_movie, dataList);
        Intrinsics.h(dataList, "dataList");
        this.listExposureHelper = bVar;
        this.style = shortTvLayoutStyle;
        this.rowCount = i11;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        xr.b bVar = this.listExposureHelper;
        if (bVar != null) {
            RecyclerView.m layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            xr.b.h(bVar, (GridLayoutManager) layoutManager, bindingAdapterPosition, true, false, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, ShortTvMovieItem item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        int a11 = a0.a(107.0f);
        int a12 = a0.a(149.0f);
        int a13 = a0.a(((this.rowCount - 1) * 8.0f) + 24.0f);
        int e11 = y.e();
        int i11 = (e11 - a13) / this.rowCount;
        int i12 = (int) (i11 * ((a12 * 1.0f) / a11));
        int a14 = a0.a(((r6 - 1) * 8.0f) + 24.0f);
        a0.a(109.0f);
        a0.a(109.0f);
        int i13 = e11 - a14;
        int i14 = i13 / this.rowCount;
        int a15 = a0.a(164.0f);
        int a16 = a0.a(92.0f);
        int i15 = i13 / this.rowCount;
        int i16 = (int) (i15 * ((a16 * 1.0f) / a15));
        if (item.getNonAdDelegate() != null) {
            or.a aVar = or.a.f71230a;
            Context context = getContext();
            BiddingNativeManager nonAdDelegate = item.getNonAdDelegate();
            r a17 = aVar.a(context, nonAdDelegate != null ? nonAdDelegate.getMSceneId() : null);
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.nativeView);
            if (nativeWrapperAdView != null) {
                BiddingNativeManager nonAdDelegate2 = item.getNonAdDelegate();
                BiddingNativeManager nonAdDelegate3 = item.getNonAdDelegate();
                nativeWrapperAdView.bindNativeView(nonAdDelegate2, a17, nonAdDelegate3 != null ? nonAdDelegate3.n0() : null);
            }
            ((FrameLayout) holder.getView(R$id.nativeView)).setVisibility(0);
            ((Group) holder.getView(R$id.group)).setVisibility(8);
            return;
        }
        ((FrameLayout) holder.getView(R$id.nativeView)).setVisibility(8);
        ((Group) holder.getView(R$id.group)).setVisibility(0);
        ImageView imageView = (ShapeableImageView) holder.getView(R$id.iv_cover);
        ShortTvLayoutStyle shortTvLayoutStyle = this.style;
        if (shortTvLayoutStyle != null) {
            String shape = shortTvLayoutStyle != null ? shortTvLayoutStyle.getShape() : null;
            if (Intrinsics.c(shape, ShortTvLayoutStyleEnum.Horizontal.getValue())) {
                i12 = i16;
                i11 = i15;
            } else if (Intrinsics.c(shape, ShortTvLayoutStyleEnum.Square.getValue())) {
                i12 = i14;
                i11 = i12;
            }
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = i12;
        imageView.setLayoutParams(bVar);
        f.b m11 = f.f62005a.m(getContext());
        Cover cover = item.getCover();
        String str2 = "";
        if (cover == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        f.b c11 = m11.g(str).i(R$color.short_tv_cl37).m(i11).c(i12);
        Cover cover2 = item.getCover();
        if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        c11.l(str2).d(imageView);
        holder.setText(R$id.tv_title, item.getTitle());
        holder.setText(R$id.tv_tabs, item.getGenre() + "•" + item.getCountryName());
        holder.setText(R$id.tv_score, item.getImdbRatingValue());
        ((CornerTextView) holder.getView(R$id.tv_tips)).setTextWithType(item.getCorner(), item.getSubjectType());
    }

    /* renamed from: C1, reason: from getter */
    public final int getRowCount() {
        return this.rowCount;
    }

    /* renamed from: D1, reason: from getter */
    public final ShortTvLayoutStyle getStyle() {
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

    public final void F1(ShortTvLayoutStyle shortTvLayoutStyle) {
        this.style = shortTvLayoutStyle;
    }

    @Override // r6.i
    public /* bridge */ /* synthetic */ r6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
