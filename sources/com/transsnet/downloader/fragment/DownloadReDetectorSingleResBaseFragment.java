package com.transsnet.downloader.fragment;

import android.os.Bundle;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import g4.a;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005JU\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0005R$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0015R\"\u0010%\u001a\u00020\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorSingleResBaseFragment;", "Lg4/a;", "T", "Lcom/transsnet/downloader/fragment/DownloadReDetectorBaseFragment;", "<init>", "()V", "", "pageName", "pageFrom", "subjectId", "postId", "ops", "resourceId", "taskId", "", "J0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "initViewModel", "Lcom/transsion/baselib/db/download/DownloadBean;", WebConstants.FIELD_ITEM, "Q0", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "R0", "onDestroy", "l", "Lcom/transsion/baselib/db/download/DownloadBean;", "K0", "()Lcom/transsion/baselib/db/download/DownloadBean;", "N0", "downloadBean", "", "m", "Z", "getExecuteDownload", "()Z", "O0", "(Z)V", "executeDownload", "n", "Ljava/lang/String;", "getModuleName", "()Ljava/lang/String;", "P0", "(Ljava/lang/String;)V", "moduleName", "Lcom/transsnet/downloader/manager/StartDownloadHelper;", "o", "Lkotlin/Lazy;", "L0", "()Lcom/transsnet/downloader/manager/StartDownloadHelper;", "startDownloadHelper", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public abstract class DownloadReDetectorSingleResBaseFragment<T extends g4.a> extends DownloadReDetectorBaseFragment<T> {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private DownloadBean downloadBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean executeDownload;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy startDownloadHelper = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.s4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            StartDownloadHelper S0;
            S0 = DownloadReDetectorSingleResBaseFragment.S0();
            return S0;
        }
    });

    /* loaded from: classes7.dex */
    static final class a implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59127a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59127a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59127a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59127a.invoke(obj);
        }
    }

    private final void J0(String pageName, String pageFrom, String subjectId, String postId, String ops, String resourceId, String taskId) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebConstants.PAGE_FROM, pageFrom);
        hashMap.put("subject_id", subjectId);
        hashMap.put("post_id", postId);
        hashMap.put("ops", ops);
        hashMap.put("resource_id", resourceId);
        hashMap.put("task_id", taskId);
        hashMap.put("module_name", this.moduleName);
        hj.i iVar = hj.i.f64628a;
        if (pageName == null) {
            pageName = "download_click";
        }
        iVar.s(pageName, "download_click", hashMap);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", resourceId);
        bundle.putString("subject_id", subjectId);
        com.transsion.baselib.report.e.f43398a.l("download_click", bundle, getContext());
    }

    private final StartDownloadHelper L0() {
        return (StartDownloadHelper) this.startDownloadHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(DownloadReDetectorSingleResBaseFragment downloadReDetectorSingleResBaseFragment, DownloadBean downloadBean) {
        kotlinx.coroutines.k.d(androidx.view.v.a(downloadReDetectorSingleResBaseFragment), null, null, new DownloadReDetectorSingleResBaseFragment$initViewModel$1$1(downloadBean, downloadReDetectorSingleResBaseFragment, null), 3, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartDownloadHelper S0() {
        return new StartDownloadHelper();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K0, reason: from getter */
    public final DownloadBean getDownloadBean() {
        return this.downloadBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N0(DownloadBean downloadBean) {
        this.downloadBean = downloadBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O0(boolean z10) {
        this.executeDownload = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P0(String str) {
        this.moduleName = str;
    }

    public void Q0(DownloadBean item) {
        Intrinsics.h(item, "item");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R0() {
        DownloadBean downloadBean;
        androidx.view.b0 p11;
        String str;
        androidx.view.b0 i11;
        Long size;
        DownloadBean downloadBean2 = this.downloadBean;
        if (u0((downloadBean2 == null || (size = downloadBean2.getSize()) == null) ? 0L : size.longValue()) || (downloadBean = this.downloadBean) == null) {
            return;
        }
        lg.a.f68962a.p("download", new String[]{"单资源，下载点击，开始下载:subjectId = " + downloadBean.getSubjectId() + ", resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getTotalTitleName()}, true);
        J0(downloadBean.getPageFrom(), downloadBean.getLastPageFrom(), downloadBean.getSubjectId(), downloadBean.getPostId(), downloadBean.getOps(), downloadBean.getResourceId(), downloadBean.getTaskId());
        p0().p(downloadBean);
        L0().f(CollectionsKt.h(downloadBean));
        DownloadBean downloadBean3 = this.downloadBean;
        if (downloadBean3 != null) {
            Long size2 = downloadBean3.getSize();
            if (size2 == null || (str = oh.b.a(size2.longValue(), 1)) == null) {
                str = "";
            }
            DownloadResourcesDetectorViewModel viewModel = getViewModel();
            if (viewModel != null && (i11 = viewModel.i()) != null) {
                i11.q(new com.transsnet.downloader.viewmodel.b(1, str, downloadBean3, false));
            }
        }
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 == null || (p11 = viewModel2.p()) == null) {
            return;
        }
        p11.q(3);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.view.b0 D;
        if (this.executeDownload && (D = DownloadListManager.f60117m.a().D()) != null) {
            D.j(this, new a(new Function1() { // from class: com.transsnet.downloader.fragment.r4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit M0;
                    M0 = DownloadReDetectorSingleResBaseFragment.M0(DownloadReDetectorSingleResBaseFragment.this, (DownloadBean) obj);
                    return M0;
                }
            }));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        aVar.a().Y(null);
        aVar.a().Z(null);
        aVar.a().b0(null);
    }
}
