package com.transsion.home.tv.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.base.report.athena.BrowseType;
import com.transsion.base.report.athena.ClickType;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.CustomData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.tv.fragment.TVChannelHomeFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
public final class n extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f45657e;

    public n(int i11) {
        this.f45657e = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(OperateItem operateItem, n nVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<BannerData> items;
        BannerData bannerData;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        CustomData customData = operateItem.getCustomData();
        if (customData == null || (items = customData.getItems()) == null || (bannerData = (BannerData) CollectionsKt.l0(items, i11)) == null) {
            return;
        }
        nVar.D(bannerData, operateItem.getOpId());
        nVar.C(bannerData, i11, operateItem);
    }

    private final void B(OperateItem operateItem) {
        String str;
        String opId;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_custom");
        String str2 = "";
        if (operateItem == null || (str = operateItem.getTitle()) == null) {
            str = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, str);
        if (operateItem != null && (opId = operateItem.getOpId()) != null) {
            str2 = opId;
        }
        hashMap.put("opId", str2);
        hashMap.put("tabId", String.valueOf(this.f45657e));
        if (operateItem != null) {
            il.b.b(operateItem, hashMap);
        }
        hj.i.f64628a.E(TVChannelHomeFragment.INSTANCE.b(this.f45657e), hashMap, BrowseType.CONTENT);
    }

    private final void C(BannerData bannerData, int i11, OperateItem operateItem) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_custom_item");
        hashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        CustomData customData = operateItem.getCustomData();
        hashMap.put("rowCount", String.valueOf(customData != null ? Integer.valueOf(customData.getRowCount()) : null));
        hashMap.put("tabId", String.valueOf(this.f45657e));
        if (bannerData == null || (str = bannerData.getDeepLink()) == null) {
            str = "";
        }
        hashMap.put("content_id", str);
        if (bannerData != null) {
            il.b.g(bannerData, hashMap);
        }
        il.b.b(operateItem, hashMap);
        hj.i.f64628a.q(TVChannelHomeFragment.INSTANCE.b(this.f45657e), hashMap, ClickType.CONTENT);
    }

    private final void D(BannerData bannerData, String str) {
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            ak.k.g(deepLink, "&module_name=opt_custom&from_opt_id=" + str + "&ops=" + bannerData.getOps() + "&tab_id=" + this.f45657e);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.MULTILINE_SUBJECTS_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_tv_multiline_subjects;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        Integer showLine;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        int i11 = R$id.tvMultilineTitle;
        String title = item.getTitle();
        if (title == null) {
            title = "";
        }
        helper.setText(i11, title);
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.tvMultilineRecycler);
        CustomData customData = item.getCustomData();
        int f11 = RangesKt.f((customData == null || (showLine = customData.getShowLine()) == null) ? 1 : showLine.intValue(), 1);
        TvMultilineSubjectsCardAdapter tvMultilineSubjectsCardAdapter = new TvMultilineSubjectsCardAdapter(item, this.f45657e);
        recyclerView.setAdapter(tvMultilineSubjectsCardAdapter);
        NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(k(), f11, 0, false);
        npaGridLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(npaGridLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.a(dk.a.b(8), dk.a.b(8), dk.a.b(12), dk.a.b(12)));
        }
        CustomData customData2 = item.getCustomData();
        List<BannerData> items = customData2 != null ? customData2.getItems() : null;
        if (items == null) {
            items = CollectionsKt.l();
        }
        tvMultilineSubjectsCardAdapter.n1(items);
        tvMultilineSubjectsCardAdapter.w1(new p6.d() { // from class: com.transsion.home.tv.adapter.m
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                n.A(OperateItem.this, this, baseQuickAdapter, view, i12);
            }
        });
        B(item);
    }
}
