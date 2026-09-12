package com.transsnet.downloader.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/transsnet/downloader/fragment/LocalFileSingleTabFragment;", "Lcom/transsnet/downloader/fragment/LocalFileBaseFragment;", "<init>", "()V", "", "receiveArguments", "initViewData", "initViewModel", "", "getEmptyDescText", "()Ljava/lang/String;", "", "T0", "()Z", "getPageName", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", CampaignEx.JSON_KEY_AD_K, "Ljava/lang/String;", "tabName", "", "l", "I", "tabIndex", "m", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class LocalFileSingleTabFragment extends LocalFileBaseFragment {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String tabName = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int tabIndex;

    /* loaded from: classes7.dex */
    public static final class b extends RecyclerView.l {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() == null || childAdapterPosition != 0) {
                return;
            }
            outRect.top = com.blankj.utilcode.util.a0.a(12.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(LocalFileSingleTabFragment localFileSingleTabFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        localFileSingleTabFragment.V0(adapter, view, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(LocalFileSingleTabFragment localFileSingleTabFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object obj = adapter.getData().get(i11);
        localFileSingleTabFragment.Y0(obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null, i11, localFileSingleTabFragment.tabIndex);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public boolean T0() {
        return true;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String getEmptyDescText() {
        String string = getString(R$string.download_no_local_file_tips_2);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public String getPageName() {
        String lowerCase = this.tabName.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return "file_manager_tab_" + lowerCase;
    }

    @Override // com.transsnet.downloader.fragment.LocalFileBaseFragment, com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        RecyclerView recyclerView;
        r6.f h02;
        TitleLayout titleLayout;
        py.s mViewBinding = getMViewBinding();
        if (mViewBinding != null && (titleLayout = mViewBinding.f73032d) != null) {
            titleLayout.setVisibility(8);
        }
        com.transsnet.downloader.adapter.a mAllHistoricalPlayRecordAdapter = getMAllHistoricalPlayRecordAdapter();
        if (mAllHistoricalPlayRecordAdapter != null && (h02 = mAllHistoricalPlayRecordAdapter.h0()) != null) {
            h02.z(false);
        }
        py.s mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f73030b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        com.transsnet.downloader.adapter.a aVar = new com.transsnet.downloader.adapter.a(T0());
        aVar.w1(new p6.d() { // from class: com.transsnet.downloader.fragment.d7
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                LocalFileSingleTabFragment.p1(LocalFileSingleTabFragment.this, baseQuickAdapter, view, i11);
            }
        });
        aVar.l(R$id.ivTopRightCornerPoint);
        aVar.s1(new p6.b() { // from class: com.transsnet.downloader.fragment.e7
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                LocalFileSingleTabFragment.q1(LocalFileSingleTabFragment.this, baseQuickAdapter, view, i11);
            }
        });
        b1(aVar);
        recyclerView.setAdapter(getMAllHistoricalPlayRecordAdapter());
        recyclerView.addItemDecoration(new b());
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new LocalFileSingleTabFragment$initViewModel$1(this, null), 3, null);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        String str;
        super.receiveArguments();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("extra_download_out_file_tab_name")) == null) {
            str = "";
        }
        this.tabName = str;
        Bundle arguments2 = getArguments();
        this.tabIndex = arguments2 != null ? arguments2.getInt("extra_position") : 0;
    }
}
