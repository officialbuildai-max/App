package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment$initViewModel$1$1", f = "DownloadReDetectorSingleResBaseFragment.kt", l = {41}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class DownloadReDetectorSingleResBaseFragment$initViewModel$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $it;
    int label;
    final /* synthetic */ DownloadReDetectorSingleResBaseFragment<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadReDetectorSingleResBaseFragment$initViewModel$1$1(DownloadBean downloadBean, DownloadReDetectorSingleResBaseFragment<T> downloadReDetectorSingleResBaseFragment, Continuation<? super DownloadReDetectorSingleResBaseFragment$initViewModel$1$1> continuation) {
        super(2, continuation);
        this.$it = downloadBean;
        this.this$0 = downloadReDetectorSingleResBaseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadReDetectorSingleResBaseFragment$initViewModel$1$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadReDetectorSingleResBaseFragment$initViewModel$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HashMap g11;
        HashMap g12;
        HashMap g13;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
            String resourceId = this.$it.getResourceId();
            if (resourceId == null) {
                resourceId = this.$it.getUrl();
            }
            this.label = 1;
            obj = a11.p(resourceId, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        DownloadBean downloadBean = (DownloadBean) obj;
        DownloadReDetectorSingleResBaseFragment<T> downloadReDetectorSingleResBaseFragment = this.this$0;
        if (downloadBean != null) {
            a.C0856a c0856a = lg.a.f68962a;
            String tag = downloadReDetectorSingleResBaseFragment.getTAG();
            Intrinsics.g(tag, "<get-TAG>(...)");
            a.C0856a.f(c0856a, tag, "single， get download bean from database", false, 4, null);
        } else {
            a.C0856a c0856a2 = lg.a.f68962a;
            String tag2 = downloadReDetectorSingleResBaseFragment.getTAG();
            Intrinsics.g(tag2, "<get-TAG>(...)");
            a.C0856a.f(c0856a2, tag2, "single， create download bean from observe", false, 4, null);
            downloadBean = this.$it;
        }
        downloadReDetectorSingleResBaseFragment.N0(downloadBean);
        DownloadBean downloadBean2 = this.this$0.getDownloadBean();
        if (downloadBean2 != null) {
            DownloadReDetectorSingleResBaseFragment<T> downloadReDetectorSingleResBaseFragment2 = this.this$0;
            a.C0856a c0856a3 = lg.a.f68962a;
            String tag3 = downloadReDetectorSingleResBaseFragment2.getTAG();
            Intrinsics.g(tag3, "<get-TAG>(...)");
            a.C0856a.f(c0856a3, tag3, "single， add download task， " + downloadBean2, false, 4, null);
            downloadReDetectorSingleResBaseFragment2.Q0(downloadBean2);
            downloadBean2.setCreateAt(System.currentTimeMillis());
            downloadBean2.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            downloadBean2.setTaskId(UUID.randomUUID().toString());
            hj.b logViewConfig = downloadReDetectorSingleResBaseFragment2.getLogViewConfig();
            if (logViewConfig != null && (g13 = logViewConfig.g()) != null) {
                g13.put(WebConstants.PAGE_FROM, downloadBean2.getPageFrom());
            }
            hj.b logViewConfig2 = downloadReDetectorSingleResBaseFragment2.getLogViewConfig();
            if (logViewConfig2 != null && (g12 = logViewConfig2.g()) != null) {
                g12.put("last_page_from", downloadBean2.getLastPageFrom());
            }
            hj.b logViewConfig3 = downloadReDetectorSingleResBaseFragment2.getLogViewConfig();
            if (logViewConfig3 != null && (g11 = logViewConfig3.g()) != null) {
                g11.put("ops", downloadBean2.getOps());
            }
        }
        return Unit.f67184a;
    }
}
