package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.StartDownloadHelper;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$initData$2$1", f = "DownloadBottomAnalyzeFragment.kt", l = {194}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadBottomAnalyzeFragment$initData$2$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadBean> $it;
    int label;
    final /* synthetic */ DownloadBottomAnalyzeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadBottomAnalyzeFragment$initData$2$1(List<? extends DownloadBean> list, DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, Continuation<? super DownloadBottomAnalyzeFragment$initData$2$1> continuation) {
        super(2, continuation);
        this.$it = list;
        this.this$0 = downloadBottomAnalyzeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadBottomAnalyzeFragment$initData$2$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadBottomAnalyzeFragment$initData$2$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloadBean downloadBean;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.transsnet.downloader.manager.g K0;
        StartDownloadHelper L0;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            List<DownloadBean> list = this.$it;
            if (list == null || list.isEmpty()) {
                return Unit.f67184a;
            }
            DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
            String resourceId = this.$it.get(0).getResourceId();
            if (resourceId == null) {
                resourceId = this.$it.get(0).getUrl();
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
        DownloadBean downloadBean2 = (DownloadBean) obj;
        if (downloadBean2 != null) {
            a.C0856a.f(lg.a.f68962a, "downloadAna", "single， get download bean from database", false, 4, null);
            this.this$0.downloadBean = downloadBean2;
        } else {
            a.C0856a.f(lg.a.f68962a, "downloadAna", "single， create download bean from subject", false, 4, null);
            if (!this.$it.isEmpty()) {
                this.this$0.downloadBean = this.$it.get(0);
            }
        }
        downloadBean = this.this$0.downloadBean;
        if (downloadBean != null) {
            DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment = this.this$0;
            a.C0856a.f(lg.a.f68962a, "downloadAna", "single， add download task， " + downloadBean, false, 4, null);
            downloadBottomAnalyzeFragment.U0(downloadBean);
            downloadBean.setCreateAt(System.currentTimeMillis());
            downloadBean.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            str = downloadBottomAnalyzeFragment.pageFrom;
            downloadBean.setPageFrom(str);
            str2 = downloadBottomAnalyzeFragment.lastPageFrom;
            downloadBean.setLastPageFrom(str2);
            str3 = downloadBottomAnalyzeFragment.ops;
            downloadBean.setOps(str3);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "toString(...)");
            downloadBean.setTaskId(uuid);
            str4 = downloadBottomAnalyzeFragment.pageFrom;
            str5 = downloadBottomAnalyzeFragment.lastPageFrom;
            String subjectId = downloadBean.getSubjectId();
            String postId = downloadBean.getPostId();
            str6 = downloadBottomAnalyzeFragment.ops;
            downloadBottomAnalyzeFragment.J0(str4, str5, subjectId, postId, str6, downloadBean.getResourceId(), uuid);
            K0 = downloadBottomAnalyzeFragment.K0();
            K0.p(downloadBean);
            L0 = downloadBottomAnalyzeFragment.L0();
            L0.f(CollectionsKt.h(downloadBean));
        }
        return Unit.f67184a;
    }
}
