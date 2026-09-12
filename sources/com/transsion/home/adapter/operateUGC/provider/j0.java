package com.transsion.home.adapter.operateUGC.provider;

import android.view.View;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class j0 extends BaseItemProvider {

    /* renamed from: f, reason: collision with root package name */
    public static final a f44424f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final int f44425g = 8;

    /* renamed from: e, reason: collision with root package name */
    private final int f44426e;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j0(int i11) {
        this.f44426e = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(OperateItem operateItem, j0 j0Var) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null && deepLink.length() != 0) {
            j0Var.G(operateItem);
            String deepLink2 = operateItem.getDeepLink();
            if (deepLink2 != null) {
                ak.k.h(deepLink2, null, 1, null);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function0 function0, View view) {
        function0.invoke();
    }

    private final void F(OperateItem operateItem) {
        List<Object> data;
        Pair a11 = TuplesKt.a("module_name", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);
        BaseProviderMultiAdapter g11 = g();
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        Map m11 = MapsKt.m(a11, a12, TuplesKt.a(CampaignEx.JSON_KEY_TITLE, title), TuplesKt.a("tabId", String.valueOf(this.f44426e)));
        il.b.a(operateItem, m11);
        hj.i.f64628a.D(SubTabFragment.INSTANCE.a(this.f44426e), m11);
    }

    private final void G(OperateItem operateItem) {
        List<Object> data;
        Pair a11 = TuplesKt.a("module_name", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);
        BaseProviderMultiAdapter g11 = g();
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        Map m11 = MapsKt.m(a11, a12, TuplesKt.a(CampaignEx.JSON_KEY_TITLE, title), TuplesKt.a("tabId", String.valueOf(this.f44426e)));
        il.b.a(operateItem, m11);
        hj.i.f64628a.p(SubTabFragment.INSTANCE.a(this.f44426e), m11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ad, code lost:
    
        if (r9 == null) goto L22;
     */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(com.chad.library.adapter.base.viewholder.BaseViewHolder r9, final com.transsion.home.bean.OperateItem r10) {
        /*
            r8 = this;
            java.lang.String r0 = "helper"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            com.transsion.home.adapter.operateUGC.provider.g0 r0 = new com.transsion.home.adapter.operateUGC.provider.g0
            r0.<init>()
            int r1 = com.transsion.home.R$id.tvProviderVerticalTitle
            android.view.View r1 = r9.getView(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.transsion.home.adapter.operateUGC.provider.h0 r2 = new com.transsion.home.adapter.operateUGC.provider.h0
            r2.<init>()
            r1.setOnClickListener(r2)
            int r1 = com.transsion.home.R$id.tvProviderVerticalMore
            android.view.View r1 = r9.getView(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r10.getDeepLink()
            if (r2 == 0) goto L38
            int r2 = r2.length()
            if (r2 != 0) goto L34
            goto L38
        L34:
            jg.c.k(r1)
            goto L3b
        L38:
            jg.c.g(r1)
        L3b:
            com.transsion.home.adapter.operateUGC.provider.i0 r2 = new com.transsion.home.adapter.operateUGC.provider.i0
            r2.<init>()
            r1.setOnClickListener(r2)
            r8.F(r10)
            java.lang.String r0 = r10.getTitle()
            if (r0 == 0) goto L62
            int r0 = r0.length()
            if (r0 != 0) goto L53
            goto L62
        L53:
            int r0 = com.transsion.home.R$id.tvProviderVerticalTitle
            android.view.View r0 = r9.getView(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r10.getTitle()
            r0.setText(r1)
        L62:
            com.transsion.home.adapter.operateUGC.adapter.VerticalContentUGCAdapter r0 = new com.transsion.home.adapter.operateUGC.adapter.VerticalContentUGCAdapter
            int r4 = r8.f44426e
            r6 = 4
            r7 = 0
            r5 = 0
            r2 = r0
            r3 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            int r1 = com.transsion.home.R$id.rvProviderVerticalPost
            android.view.View r9 = r9.getView(r1)
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            com.tn.lib.view.layoutmanager.NpaGridLayoutManager r1 = new com.tn.lib.view.layoutmanager.NpaGridLayoutManager
            android.content.Context r2 = r9.getContext()
            r3 = 3
            r1.<init>(r2, r3)
            r9.setLayoutManager(r1)
            int r1 = r9.getItemDecorationCount()
            if (r1 != 0) goto L98
            ig.a r1 = new ig.a
            r2 = 8
            int r2 = dk.a.b(r2)
            r4 = 0
            r1.<init>(r2, r4, r4, r4)
            r9.addItemDecoration(r1)
        L98:
            r9.setAdapter(r0)
            java.util.List r9 = r10.getContentList()
            if (r9 == 0) goto Laf
            int r10 = r9.size()
            int r10 = r10 / r3
            int r10 = r10 * r3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.List r9 = kotlin.collections.CollectionsKt.K0(r9, r10)
            if (r9 != 0) goto Lb3
        Laf:
            java.util.List r9 = kotlin.collections.CollectionsKt.l()
        Lb3:
            java.util.Collection r9 = (java.util.Collection) r9
            r0.n1(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.operateUGC.provider.j0.b(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.home.bean.OperateItem):void");
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.UGC_PORTRAIT_GRID.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_ugc_vertical_content;
    }
}
