package com.transsion.postdetail.shorttv.adapter;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lsj/b;", "exposureHelper", "<init>", "(Lsj/b;)V", "Landroidx/appcompat/widget/AppCompatImageView;", WebConstants.FIELD_ITEM, "", "C1", "(Landroidx/appcompat/widget/AppCompatImageView;Lcom/transsion/moviedetailapi/bean/Subject;)V", "D1", "holder", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "F", "Lsj/b;", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ShortTVHeaderViewAdapter extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final sj.b exposureHelper;

    /* JADX WARN: Multi-variable type inference failed */
    public ShortTVHeaderViewAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ShortTVHeaderViewAdapter(sj.b bVar) {
        super(R$layout.item_short_tv_history, null, 2, null);
        this.exposureHelper = bVar;
    }

    public /* synthetic */ ShortTVHeaderViewAdapter(sj.b bVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bVar);
    }

    private final void C1(AppCompatImageView appCompatImageView, Subject subject) {
        k.d(o0.a(y0.c()), null, null, new ShortTVHeaderViewAdapter$loadBuiltInCover$1(subject, appCompatImageView, null), 3, null);
    }

    private final void D1(AppCompatImageView appCompatImageView, Subject subject) {
        String str;
        String thumbnail;
        f.a aVar = f.f62005a;
        Context context = appCompatImageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m11 = aVar.m(context);
        Cover cover = subject.getCover();
        String str2 = "";
        if (cover == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        f.b i11 = m11.g(str).i(R$color.module_04);
        Cover cover2 = subject.getCover();
        if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        i11.l(str2).d(appCompatImageView);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            RecyclerView.m layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bVar.i((LinearLayoutManager) layoutManager, bindingAdapterPosition, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007d, code lost:
    
        if (r5.getEp() <= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0052, code lost:
    
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(com.chad.library.adapter.base.viewholder.BaseViewHolder r7, com.transsion.moviedetailapi.bean.Subject r8) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "holder"
            kotlin.jvm.internal.Intrinsics.h(r7, r2)
            java.lang.String r2 = "item"
            kotlin.jvm.internal.Intrinsics.h(r8, r2)
            int r2 = com.transsion.postdetail.R$id.iv_cover
            android.view.View r2 = r7.getView(r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            boolean r3 = r8.getBuiltIn()
            if (r3 == 0) goto L1e
            r6.C1(r2, r8)
            goto L21
        L1e:
            r6.D1(r2, r8)
        L21:
            int r2 = com.transsion.postdetail.R$id.tv_title
            android.view.View r2 = r7.getView(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = r8.getTitle()
            r2.setText(r3)
            java.util.List r2 = r8.getTags()
            if (r2 == 0) goto L54
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L4e
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.f(r2)
            java.lang.Object r2 = kotlin.collections.CollectionsKt.i0(r2)
            java.util.List r2 = kotlin.collections.CollectionsKt.e(r2)
            goto L52
        L4e:
            java.util.List r2 = kotlin.collections.CollectionsKt.l()
        L52:
            if (r2 != 0) goto L58
        L54:
            java.util.List r2 = kotlin.collections.CollectionsKt.l()
        L58:
            com.transsion.postdetail.shorttv.adapter.a r3 = new com.transsion.postdetail.shorttv.adapter.a
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r4 = kotlin.collections.CollectionsKt.U0(r4)
            r3.<init>(r4)
            int r4 = com.transsion.postdetail.R$id.rv_list
            android.view.View r4 = r7.getView(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            com.transsion.moviedetailapi.bean.ShortTVItem r5 = r8.getShortTVFirstEp()
            if (r5 == 0) goto L7f
            com.transsion.moviedetailapi.bean.ShortTVItem r5 = r8.getShortTVFirstEp()
            kotlin.jvm.internal.Intrinsics.e(r5)
            int r5 = r5.getEp()
            if (r5 > 0) goto L85
        L7f:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L89
        L85:
            jg.c.g(r4)
            goto La4
        L89:
            com.google.android.flexbox.FlexboxLayoutManager r2 = new com.google.android.flexbox.FlexboxLayoutManager
            android.content.Context r5 = r4.getContext()
            r2.<init>(r5)
            r2.c0(r1)
            r2.d0(r0)
            r2.e0(r1)
            r4.setLayoutManager(r2)
            r4.setAdapter(r3)
            jg.c.k(r4)
        La4:
            int r2 = com.transsion.postdetail.R$id.tv_ep
            android.view.View r7 = r7.getView(r2)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r2 = r8.getTotalEpisode()
            if (r2 != 0) goto Lcd
            java.util.List r8 = r8.getResourceDetectors()
            if (r8 == 0) goto Lcb
            java.lang.Object r8 = kotlin.collections.CollectionsKt.i0(r8)
            com.transsion.moviedetailapi.bean.ResourceDetectors r8 = (com.transsion.moviedetailapi.bean.ResourceDetectors) r8
            if (r8 == 0) goto Lcb
            java.lang.Integer r8 = r8.getTotalEpisode()
            if (r8 == 0) goto Lcb
            int r8 = r8.intValue()
            goto Ld1
        Lcb:
            r8 = r1
            goto Ld1
        Lcd:
            int r8 = r8.getTotalEpisode()
        Ld1:
            android.app.Application r2 = com.blankj.utilcode.util.Utils.a()
            int r3 = com.transsion.postdetail.R$string.short_tv_watch_ad_tips
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r8
            java.lang.String r8 = r2.getString(r3, r0)
            r7.setText(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter.F(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.moviedetailapi.bean.Subject):void");
    }
}
