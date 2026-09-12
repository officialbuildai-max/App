package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.StartDownloadHelper;
import java.util.HashMap;
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
import okhttp3.internal.http2.Settings;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$initData$3$1", f = "DownloadBottomAnalyzeFragment.kt", l = {226}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadBottomAnalyzeFragment$initData$3$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Subject $it;
    int label;
    final /* synthetic */ DownloadBottomAnalyzeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadBottomAnalyzeFragment$initData$3$1(Subject subject, DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, Continuation<? super DownloadBottomAnalyzeFragment$initData$3$1> continuation) {
        super(2, continuation);
        this.$it = subject;
        this.this$0 = downloadBottomAnalyzeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadBottomAnalyzeFragment$initData$3$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadBottomAnalyzeFragment$initData$3$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String downloadUrl;
        Object p11;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        DownloadBean downloadBean3;
        DownloadBean downloadBean4;
        DownloadBean downloadBean5;
        DownloadBean downloadBean6;
        DownloadBean downloadBean7;
        String resourceLink;
        String str;
        String resourceId;
        String downloadUrl2;
        DownloadBean downloadBean8;
        HashMap g11;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        com.transsnet.downloader.manager.g K0;
        StartDownloadHelper L0;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        String str8 = "";
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
            ResourceDetectors resourceDetector = this.$it.getResourceDetector();
            if (resourceDetector == null || (downloadUrl = resourceDetector.getResourceId()) == null) {
                ResourceDetectors resourceDetector2 = this.$it.getResourceDetector();
                downloadUrl = resourceDetector2 != null ? resourceDetector2.getDownloadUrl() : null;
                if (downloadUrl == null) {
                    downloadUrl = "";
                }
            }
            this.label = 1;
            p11 = a11.p(downloadUrl, this);
            if (p11 == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            p11 = obj;
        }
        DownloadBean downloadBean9 = (DownloadBean) p11;
        if (downloadBean9 != null) {
            a.C0856a.f(lg.a.f68962a, "downloadAna", "single， get download bean from database", false, 4, null);
            this.this$0.downloadBean = downloadBean9;
        } else {
            DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment = this.this$0;
            ResourceDetectors resourceDetector3 = this.$it.getResourceDetector();
            String str9 = (resourceDetector3 == null || (downloadUrl2 = resourceDetector3.getDownloadUrl()) == null) ? "" : downloadUrl2;
            ResourceDetectors resourceDetector4 = this.$it.getResourceDetector();
            String str10 = (resourceDetector4 == null || (resourceId = resourceDetector4.getResourceId()) == null) ? "" : resourceId;
            String title = this.$it.getTitle();
            String str11 = title == null ? "" : title;
            Cover cover = this.$it.getCover();
            String url = cover != null ? cover.getUrl() : null;
            ResourceDetectors resourceDetector5 = this.$it.getResourceDetector();
            downloadBottomAnalyzeFragment.downloadBean = new DownloadBean(str9, str10, str11, url, resourceDetector5 != null ? resourceDetector5.getTotalSize() : null, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            downloadBean = this.this$0.downloadBean;
            if (downloadBean != null) {
                ResourceDetectors resourceDetector6 = this.$it.getResourceDetector();
                downloadBean.setPostId(resourceDetector6 != null ? resourceDetector6.getPostId() : null);
            }
            downloadBean2 = this.this$0.downloadBean;
            if (downloadBean2 != null) {
                downloadBean2.setSubjectId(this.$it.getSubjectId());
            }
            downloadBean3 = this.this$0.downloadBean;
            if (downloadBean3 != null) {
                str = this.this$0.groupId;
                downloadBean3.setGroupId(str);
            }
            downloadBean4 = this.this$0.downloadBean;
            if (downloadBean4 != null) {
                downloadBean4.setSubjectName(this.$it.getTitle());
            }
            downloadBean5 = this.this$0.downloadBean;
            if (downloadBean5 != null) {
                downloadBean5.setType(DownloadBean.INSTANCE.c(this.$it.getSubjectType()));
            }
            downloadBean6 = this.this$0.downloadBean;
            if (downloadBean6 != null) {
                ResourceDetectors resourceDetector7 = this.$it.getResourceDetector();
                downloadBean6.setUploadBy(resourceDetector7 != null ? resourceDetector7.getUploadBy() : null);
            }
            downloadBean7 = this.this$0.downloadBean;
            if (downloadBean7 != null) {
                ResourceDetectors resourceDetector8 = this.$it.getResourceDetector();
                if (resourceDetector8 != null && (resourceLink = resourceDetector8.getResourceLink()) != null) {
                    str8 = resourceLink;
                }
                downloadBean7.setSourceUrl(str8);
            }
        }
        downloadBean8 = this.this$0.downloadBean;
        if (downloadBean8 != null) {
            DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment2 = this.this$0;
            Subject subject = this.$it;
            a.C0856a.f(lg.a.f68962a, "downloadAna", "single， add download task， " + downloadBean8, false, 4, null);
            downloadBottomAnalyzeFragment2.U0(downloadBean8);
            downloadBean8.setCreateAt(System.currentTimeMillis());
            downloadBean8.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            str2 = downloadBottomAnalyzeFragment2.pageFrom;
            downloadBean8.setPageFrom(str2);
            str3 = downloadBottomAnalyzeFragment2.lastPageFrom;
            downloadBean8.setLastPageFrom(str3);
            str4 = downloadBottomAnalyzeFragment2.ops;
            downloadBean8.setOps(str4);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "toString(...)");
            downloadBean8.setTaskId(uuid);
            downloadBean8.setDuration(Boxing.e(subject.getResourceAboutDuration()));
            str5 = downloadBottomAnalyzeFragment2.pageFrom;
            str6 = downloadBottomAnalyzeFragment2.lastPageFrom;
            String subjectId = subject.getSubjectId();
            String postId = downloadBean8.getPostId();
            str7 = downloadBottomAnalyzeFragment2.ops;
            ResourceDetectors resourceDetector9 = subject.getResourceDetector();
            downloadBottomAnalyzeFragment2.J0(str5, str6, subjectId, postId, str7, resourceDetector9 != null ? resourceDetector9.getResourceId() : null, uuid);
            K0 = downloadBottomAnalyzeFragment2.K0();
            K0.p(downloadBean8);
            L0 = downloadBottomAnalyzeFragment2.L0();
            L0.f(CollectionsKt.h(downloadBean8));
        }
        hj.b logViewConfig = this.this$0.getLogViewConfig();
        if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            g11.put("subject_id", this.$it.getSubjectId());
        }
        return Unit.f67184a;
    }
}
