package com.transsion.audio.viewmodel;

import com.transsion.baselib.db.audio.AudioBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$insert$1", f = "HistoryListManager.kt", l = {Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class HistoryListManager$insert$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioBean $audioBean;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$insert$1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super HistoryListManager$insert$1> continuation) {
        super(2, continuation);
        this.$audioBean = audioBean;
        this.this$0 = historyListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$insert$1(this.$audioBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$insert$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        jj.a q11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.$audioBean.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            q11 = this.this$0.q();
            if (q11 != null) {
                AudioBean audioBean = this.$audioBean;
                this.label = 1;
                if (q11.h(audioBean, this) == f11) {
                    return f11;
                }
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                a.C0856a.g(lg.a.f68962a, "audio insert ok", false, 2, null);
                my.e eVar = new my.e(true, false);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = my.e.class.getName();
                Intrinsics.g(name, "getName(...)");
                flowEventBus.postEvent(name, eVar, 0L);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
        String resourceId = this.$audioBean.getResourceId();
        if (resourceId == null) {
            resourceId = this.$audioBean.getAudioUrl();
        }
        Long readProcess = this.$audioBean.getReadProcess();
        long longValue = readProcess != null ? readProcess.longValue() : 0L;
        this.label = 2;
        if (a11.e0(resourceId, longValue, this) == f11) {
            return f11;
        }
        a.C0856a.g(lg.a.f68962a, "audio insert ok", false, 2, null);
        my.e eVar2 = new my.e(true, false);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = my.e.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.postEvent(name2, eVar2, 0L);
        return Unit.f67184a;
    }
}
