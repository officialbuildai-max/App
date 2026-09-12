package com.transsion.shorttv.ui.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.bean.BannerData;
import com.transsion.shorttv.bean.CustomData;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.ui.adapter.ShortTvOpCustomAdapter;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010B1\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0011B;\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/transsion/shorttv/ui/widget/ShortTvOpCustomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "pageName", "Lcom/transsion/shorttv/bean/OperateItem;", WebConstants.FIELD_ITEM, "", "tabId", "", "isTablet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/OperateItem;IZLandroid/content/Context;Landroid/util/AttributeSet;I)V", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/OperateItem;IZLandroid/content/Context;)V", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/OperateItem;IZLandroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/transsion/shorttv/bean/BannerData;", "bannerData", "", "l", "(Lcom/transsion/shorttv/bean/BannerData;)V", RequestParameters.POSITION, "operateItem", CampaignEx.JSON_KEY_AD_K, "(Lcom/transsion/shorttv/bean/BannerData;ILcom/transsion/shorttv/bean/OperateItem;)V", com.mbridge.msdk.foundation.same.report.j.f35620b, "(Lcom/transsion/shorttv/bean/OperateItem;)V", "updateData", "a", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/shorttv/bean/OperateItem;", "c", "I", "d", "Z", "Lms/n0;", "e", "Lms/n0;", "viewBinding", "Lcom/transsion/shorttv/ui/adapter/ShortTvOpCustomAdapter;", "f", "Lcom/transsion/shorttv/ui/adapter/ShortTvOpCustomAdapter;", "mAdapter", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvOpCustomView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String pageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final OperateItem item;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int tabId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isTablet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ms.n0 viewBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ShortTvOpCustomAdapter mAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvOpCustomView(String pageName, OperateItem item, int i11, boolean z10, Context context) {
        this(pageName, item, i11, z10, context, null);
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvOpCustomView(String pageName, OperateItem item, int i11, boolean z10, Context context, AttributeSet attributeSet) {
        this(pageName, item, i11, z10, context, attributeSet, 0);
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvOpCustomView(String pageName, OperateItem item, int i11, boolean z10, Context context, AttributeSet attributeSet, int i12) {
        super(context, attributeSet, i12);
        List<BannerData> items;
        List<BannerData> items2;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Intrinsics.h(context, "context");
        this.pageName = pageName;
        this.item = item;
        this.tabId = i11;
        this.isTablet = z10;
        View.inflate(context, R$layout.short_tv_op_custom, this);
        ms.n0 a11 = ms.n0.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        a11.f69999c.setText(item.getTitle());
        RecyclerView subOperationVariableRecycle = a11.f69998b;
        Intrinsics.g(subOperationVariableRecycle, "subOperationVariableRecycle");
        CustomData customData = item.getCustomData();
        CustomData customData2 = item.getCustomData();
        ShortTvOpCustomAdapter shortTvOpCustomAdapter = new ShortTvOpCustomAdapter(0, pageName, customData, (customData2 == null || (items2 = customData2.getItems()) == null) ? null : items2.get(0), z10, 1, null);
        this.mAdapter = shortTvOpCustomAdapter;
        subOperationVariableRecycle.setAdapter(shortTvOpCustomAdapter);
        subOperationVariableRecycle.setLayoutManager(new LinearLayoutManager(context, 0, false));
        if (subOperationVariableRecycle.getItemDecorationCount() == 0) {
            subOperationVariableRecycle.addItemDecoration(new com.transsion.shorttv.base.widget.m(8.0f, 0.0f, 12.0f, 2, null));
        }
        CustomData customData3 = item.getCustomData();
        shortTvOpCustomAdapter.n1((customData3 == null || (items = customData3.getItems()) == null) ? new ArrayList<>() : items);
        shortTvOpCustomAdapter.w1(new p6.d() { // from class: com.transsion.shorttv.ui.widget.q
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                ShortTvOpCustomView.i(ShortTvOpCustomView.this, baseQuickAdapter, view, i13);
            }
        });
        ShortTvOpCustomAdapter shortTvOpCustomAdapter2 = this.mAdapter;
        if (shortTvOpCustomAdapter2 != null) {
            shortTvOpCustomAdapter2.D1(item);
        }
        j(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ShortTvOpCustomView shortTvOpCustomView, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<BannerData> items;
        BannerData bannerData;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        CustomData customData = shortTvOpCustomView.item.getCustomData();
        if (customData == null || (items = customData.getItems()) == null || (bannerData = items.get(i11)) == null) {
            return;
        }
        shortTvOpCustomView.l(bannerData);
        shortTvOpCustomView.k(bannerData, i11, shortTvOpCustomView.item);
    }

    private final void j(OperateItem item) {
        String str;
        String opId;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_custom");
        String str2 = "";
        if (item == null || (str = item.getTitle()) == null) {
            str = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, str);
        if (item != null && (opId = item.getOpId()) != null) {
            str2 = opId;
        }
        hashMap.put("opId", str2);
        if (item != null) {
            com.transsion.shorttv.utils.i.a(item, hashMap);
        }
        ks.b.f68513a.a();
        hj.i.f64628a.D(this.pageName, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        if (r3 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void k(com.transsion.shorttv.bean.BannerData r6, int r7, com.transsion.shorttv.bean.OperateItem r8) {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "event_type"
            java.lang.String r2 = "click_custom_item"
            r0.put(r1, r2)
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r2 = "sequence"
            r0.put(r2, r1)
            r1 = 0
            if (r6 == 0) goto L28
            java.lang.String r3 = r6.getOps()
            if (r3 == 0) goto L28
            int r4 = r3.length()
            if (r4 <= 0) goto L25
            goto L26
        L25:
            r3 = r1
        L26:
            if (r3 != 0) goto L47
        L28:
            if (r6 == 0) goto L47
            com.transsion.shorttv.bean.Subject r3 = r6.getSubject()
            if (r3 == 0) goto L47
            java.lang.String r3 = r3.getOps()
            if (r3 == 0) goto L47
            int r4 = r3.length()
            if (r4 <= 0) goto L3d
            goto L3e
        L3d:
            r3 = r1
        L3e:
            if (r3 == 0) goto L47
            java.lang.String r4 = "ops"
            r0.put(r4, r3)
            kotlin.Unit r3 = kotlin.Unit.f67184a
        L47:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.put(r2, r7)
            com.transsion.shorttv.bean.CustomData r7 = r8.getCustomData()
            if (r7 == 0) goto L5c
            int r7 = r7.getRowCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
        L5c:
            java.lang.String r7 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "rowCount"
            r0.put(r1, r7)
            if (r6 == 0) goto L6a
            com.transsion.shorttv.utils.i.b(r6, r0)
        L6a:
            com.transsion.shorttv.utils.i.a(r8, r0)
            ks.b r6 = ks.b.f68513a
            r6.a()
            hj.i r6 = hj.i.f64628a
            java.lang.String r7 = r5.pageName
            r6.p(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvOpCustomView.k(com.transsion.shorttv.bean.BannerData, int, com.transsion.shorttv.bean.OperateItem):void");
    }

    private final void l(BannerData bannerData) {
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            Uri a11 = zr.a.f79573a.a(Uri.parse(deepLink + "&module_name=opt_custom&ops=" + bannerData.getOps()));
            if (a11 != null) {
                ds.c.j(a11);
            }
        }
    }

    public final void updateData(OperateItem item) {
        List<BannerData> items;
        Intrinsics.h(item, "item");
        ShortTvOpCustomAdapter shortTvOpCustomAdapter = this.mAdapter;
        if (shortTvOpCustomAdapter != null) {
            shortTvOpCustomAdapter.D1(item);
        }
        this.viewBinding.f69999c.setText(item.getTitle());
        ShortTvOpCustomAdapter shortTvOpCustomAdapter2 = this.mAdapter;
        if (shortTvOpCustomAdapter2 != null) {
            CustomData customData = item.getCustomData();
            shortTvOpCustomAdapter2.n1((customData == null || (items = customData.getItems()) == null) ? new ArrayList<>() : items);
        }
    }
}
