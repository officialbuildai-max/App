package com.transsnet.downloader.fragment;

import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$string;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u001a\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000bR\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/transsnet/downloader/fragment/LocalFileFragment;", "Lcom/transsnet/downloader/fragment/LocalFileBaseFragment;", "<init>", "()V", "", "initViewData", "initViewModel", "onResume", "onDestroy", "", "getEmptyDescText", "()Ljava/lang/String;", "", "T0", "()Z", "initListener", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "getPageName", "Lcom/transsnet/downloader/manager/g;", CampaignEx.JSON_KEY_AD_K, "Lkotlin/Lazy;", "p1", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "com/transsnet/downloader/fragment/LocalFileFragment$b", "l", "Lcom/transsnet/downloader/fragment/LocalFileFragment$b;", "downloadListener", "m", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class LocalFileFragment extends LocalFileBaseFragment {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadManager = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.w6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g o12;
            o12 = LocalFileFragment.o1();
            return o12;
        }
    });

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final b downloadListener = new b();

    /* loaded from: classes7.dex */
    public static final class b extends lj.a {
        b() {
        }

        @Override // lj.a, lj.m0
        public void e(DownloadBean bean, String str) {
            Intrinsics.h(bean, "bean");
            super.e(bean, str);
            LocalFileFragment.this.loadDefaultData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g o1() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    private final com.transsnet.downloader.manager.g p1() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
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
        return "file_manager_tab_all";
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        p1().e(this.downloadListener);
    }

    @Override // com.transsnet.downloader.fragment.LocalFileBaseFragment, com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        r6.f h02;
        TitleLayout titleLayout;
        super.initViewData();
        py.s mViewBinding = getMViewBinding();
        if (mViewBinding != null && (titleLayout = mViewBinding.f73032d) != null) {
            titleLayout.setVisibility(8);
        }
        com.transsnet.downloader.adapter.a mAllHistoricalPlayRecordAdapter = getMAllHistoricalPlayRecordAdapter();
        if (mAllHistoricalPlayRecordAdapter == null || (h02 = mAllHistoricalPlayRecordAdapter.h0()) == null) {
            return;
        }
        h02.z(false);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new LocalFileFragment$initViewModel$1(this, null), 3, null);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        hj.b bVar = new hj.b(getPageName(), false, 2, null);
        bVar.g().put(TmcConstants.MENU_KEY_PERMISSION, com.transsnet.downloader.viewmodel.a0.f60208a.a() ? "1" : "0");
        bVar.g().put(WebConstants.PAGE_FROM, "");
        return bVar;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        p1().x(this.downloadListener);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
