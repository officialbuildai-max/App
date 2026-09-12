package com.transsion.shorttv.ui.adapter;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import as.b;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/shorttv/ui/adapter/ShortTVHeaderViewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/shorttv/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lxr/b;", "exposureHelper", "<init>", "(Lxr/b;)V", "Landroidx/appcompat/widget/AppCompatImageView;", WebConstants.FIELD_ITEM, "", "C1", "(Landroidx/appcompat/widget/AppCompatImageView;Lcom/transsion/shorttv/bean/Subject;)V", "D1", "holder", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/shorttv/bean/Subject;)V", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "F", "Lxr/b;", "Lss/a;", "G", "Lss/a;", "recReport", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ShortTVHeaderViewAdapter extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final xr.b exposureHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private final ss.a recReport;

    /* JADX WARN: Multi-variable type inference failed */
    public ShortTVHeaderViewAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ShortTVHeaderViewAdapter(xr.b bVar) {
        super(R$layout.short_tv_item_history, null, 2, null);
        this.exposureHelper = bVar;
        this.recReport = new ss.a();
    }

    public /* synthetic */ ShortTVHeaderViewAdapter(xr.b bVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bVar);
    }

    private final void C1(AppCompatImageView appCompatImageView, Subject subject) {
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new ShortTVHeaderViewAdapter$loadBuiltInCover$1(subject, appCompatImageView, null), 3, null);
    }

    private final void D1(AppCompatImageView appCompatImageView, Subject subject) {
        String thumbnail;
        String url;
        b.a aVar = as.b.f16186a;
        Context context = appCompatImageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        Cover cover = subject.getCover();
        String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        int i11 = R$color.short_tv_module_04;
        Cover cover2 = subject.getCover();
        aVar.j(context, appCompatImageView, str, (r30 & 8) != 0 ? aVar.c() : i11, (r30 & 16) != 0 ? aVar.b() : 0, (r30 & 32) != 0, (r30 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (r30 & 128) != 0, (r30 & 256) != 0, (r30 & 512) != 0 ? false : false, (r30 & 1024) != 0 ? false : false, (r30 & 2048) != 0 ? false : false, (r30 & 4096) != 0 ? 25 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        xr.b bVar = this.exposureHelper;
        if (bVar != null) {
            RecyclerView.m layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bVar.g((LinearLayoutManager) layoutManager, bindingAdapterPosition, true, true);
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
    public void F(com.chad.library.adapter.base.viewholder.BaseViewHolder r12, com.transsion.shorttv.bean.Subject r13) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "holder"
            kotlin.jvm.internal.Intrinsics.h(r12, r2)
            java.lang.String r2 = "item"
            kotlin.jvm.internal.Intrinsics.h(r13, r2)
            int r2 = com.transsion.shorttv.R$id.iv_cover
            android.view.View r2 = r12.getView(r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            boolean r3 = r13.getBuiltIn()
            if (r3 == 0) goto L1e
            r11.C1(r2, r13)
            goto L21
        L1e:
            r11.D1(r2, r13)
        L21:
            int r2 = com.transsion.shorttv.R$id.tv_title
            android.view.View r2 = r12.getView(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = r13.getTitle()
            r2.setText(r3)
            java.util.List r2 = r13.getTags()
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
            com.transsion.shorttv.ui.adapter.s r3 = new com.transsion.shorttv.ui.adapter.s
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r4 = kotlin.collections.CollectionsKt.U0(r4)
            r3.<init>(r4)
            int r4 = com.transsion.shorttv.R$id.rv_list
            android.view.View r4 = r12.getView(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            com.transsion.shorttv.bean.ShortTVItem r5 = r13.getShortTVFirstEp()
            if (r5 == 0) goto L7f
            com.transsion.shorttv.bean.ShortTVItem r5 = r13.getShortTVFirstEp()
            kotlin.jvm.internal.Intrinsics.e(r5)
            int r5 = r5.getEp()
            if (r5 > 0) goto L85
        L7f:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L89
        L85:
            yr.b.b(r4)
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
            yr.b.e(r4)
        La4:
            int r2 = com.transsion.shorttv.R$id.tv_ep
            android.view.View r2 = r12.getView(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = r13.getTotalEpisode()
            if (r3 != 0) goto Lcd
            java.util.List r3 = r13.getResourceDetectors()
            if (r3 == 0) goto Lcb
            java.lang.Object r3 = kotlin.collections.CollectionsKt.i0(r3)
            com.transsion.shorttv.bean.ResourceDetectors r3 = (com.transsion.shorttv.bean.ResourceDetectors) r3
            if (r3 == 0) goto Lcb
            java.lang.Integer r3 = r3.getTotalEpisode()
            if (r3 == 0) goto Lcb
            int r3 = r3.intValue()
            goto Ld1
        Lcb:
            r3 = r1
            goto Ld1
        Lcd:
            int r3 = r13.getTotalEpisode()
        Ld1:
            android.app.Application r4 = com.blankj.utilcode.util.Utils.a()
            int r5 = com.transsion.shorttv.R$string.short_tv_watch_ad_tips
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r3
            java.lang.String r0 = r4.getString(r5, r0)
            r2.setText(r0)
            ss.a r3 = r11.recReport
            int r6 = r12.getLayoutPosition()
            r9 = 8
            r10 = 0
            java.lang.String r4 = "minitv_explore"
            r7 = 0
            java.lang.String r8 = "playlist"
            r5 = r13
            ss.a.b(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.adapter.ShortTVHeaderViewAdapter.F(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.shorttv.bean.Subject):void");
    }
}
