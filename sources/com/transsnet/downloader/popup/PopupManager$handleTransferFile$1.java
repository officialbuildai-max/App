package com.transsnet.downloader.popup;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.dialog.DownloadReDetectorSaveDialog;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import uh.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.popup.PopupManager$handleTransferFile$1", f = "PopupManager.kt", l = {TTAdConstant.DEEPLINK_UNAVAILABLE_CODE, 479}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class PopupManager$handleTransferFile$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $checkTransferFailed;
    final /* synthetic */ Context $context;
    final /* synthetic */ my.b $info;
    final /* synthetic */ DownloadReDetectorSaveDialog $loadingDialog;
    final /* synthetic */ Function2<Boolean, Integer, Unit> $resultCallback;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PopupManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.popup.PopupManager$handleTransferFile$1$1", f = "PopupManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.popup.PopupManager$handleTransferFile$1$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $checkTransferFailed;
        final /* synthetic */ DownloadReDetectorSaveDialog $loadingDialog;
        int label;
        final /* synthetic */ PopupManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, PopupManager popupManager, boolean z10, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$loadingDialog = downloadReDetectorSaveDialog;
            this.this$0 = popupManager;
            this.$checkTransferFailed = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$loadingDialog, this.this$0, this.$checkTransferFailed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String y10;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            lg.a.f68962a.c("resource_save", "剧集存储全不符合，都跳过，直接成功", true);
            if (this.$loadingDialog.isAdded()) {
                this.$loadingDialog.dismissAllowingStateLoss();
            }
            b.a aVar = uh.b.f76876a;
            y10 = this.this$0.y(this.$checkTransferFailed);
            aVar.e(y10);
            this.$loadingDialog.J0(100);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PopupManager$handleTransferFile$1(PopupManager popupManager, boolean z10, Context context, my.b bVar, DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, Function2<? super Boolean, ? super Integer, Unit> function2, Continuation<? super PopupManager$handleTransferFile$1> continuation) {
        super(2, continuation);
        this.this$0 = popupManager;
        this.$checkTransferFailed = z10;
        this.$context = context;
        this.$info = bVar;
        this.$loadingDialog = downloadReDetectorSaveDialog;
        this.$resultCallback = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Map map, DownloadBean downloadBean, Ref.LongRef longRef, Ref.LongRef longRef2, DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, long j11, long j12) {
        map.put(downloadBean, Long.valueOf(j11));
        Iterator it = map.values().iterator();
        long j13 = 0;
        while (it.hasNext()) {
            j13 += ((Number) it.next()).longValue();
        }
        longRef.element = j13;
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new PopupManager$handleTransferFile$1$2$2(longRef, longRef2, downloadReDetectorSaveDialog, null), 3, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Ref.LongRef longRef, Ref.LongRef longRef2, PopupManager popupManager, my.b bVar, Function2 function2, DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, boolean z10, boolean z11) {
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        if (z11) {
            long j11 = longRef.element;
            long j12 = longRef2.element;
            if (j11 >= j12 || Math.abs(j11 - j12) < OSSConstants.MIN_PART_SIZE_LIMIT) {
                downloadBean = popupManager.f59643b;
                downloadBean.setRootPath(bVar.b());
                downloadBean2 = popupManager.f59643b;
                downloadBean2.setRootPathType(bVar.e());
                DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, null);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = DownloadRefreshEvent.class.getName();
                Intrinsics.g(name, "getName(...)");
                flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
                kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new PopupManager$handleTransferFile$1$3$1(popupManager, bVar, function2, downloadReDetectorSaveDialog, z10, null), 3, null);
                return Unit.f67184a;
            }
        }
        if (!z11) {
            kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new PopupManager$handleTransferFile$1$3$2(function2, bVar, downloadReDetectorSaveDialog, z10, null), 3, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, PopupManager popupManager, long j11, long j12) {
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new PopupManager$handleTransferFile$1$4$1(downloadReDetectorSaveDialog, j11, popupManager, j12, null), 3, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PopupManager popupManager, Function2 function2, my.b bVar, boolean z10, DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, boolean z11) {
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        downloadBean = popupManager.f59643b;
        String subjectId = downloadBean.getSubjectId();
        downloadBean2 = popupManager.f59643b;
        DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent(subjectId, downloadBean2.getResourceId(), false, false, 12, null);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadRefreshEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new PopupManager$handleTransferFile$1$5$1(function2, z11, bVar, popupManager, z10, downloadReDetectorSaveDialog, null), 3, null);
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PopupManager$handleTransferFile$1(this.this$0, this.$checkTransferFailed, this.$context, this.$info, this.$loadingDialog, this.$resultCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PopupManager$handleTransferFile$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0141  */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.util.Map] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.popup.PopupManager$handleTransferFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
