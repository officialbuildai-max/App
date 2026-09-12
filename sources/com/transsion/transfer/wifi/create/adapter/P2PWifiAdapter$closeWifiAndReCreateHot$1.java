package com.transsion.transfer.wifi.create.adapter;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$closeWifiAndReCreateHot$1", f = "P2PWifiAdapter.kt", l = {Sdk$SDKError.Reason.MRAID_JS_CALL_EMPTY_VALUE, Sdk$SDKError.Reason.EVALUATE_JAVASCRIPT_FAILED_VALUE, Sdk$SDKError.Reason.AD_CLOSED_TEMPLATE_ERROR_VALUE, 327, 328, 330}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class P2PWifiAdapter$closeWifiAndReCreateHot$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $retryCount;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ P2PWifiAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P2PWifiAdapter$closeWifiAndReCreateHot$1(Ref.IntRef intRef, P2PWifiAdapter p2PWifiAdapter, Continuation<? super P2PWifiAdapter$closeWifiAndReCreateHot$1> continuation) {
        super(2, continuation);
        this.$retryCount = intRef;
        this.this$0 = p2PWifiAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new P2PWifiAdapter$closeWifiAndReCreateHot$1(this.$retryCount, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((P2PWifiAdapter$closeWifiAndReCreateHot$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:10:0x001b, B:11:0x00f8, B:19:0x0027, B:20:0x00ed, B:24:0x0034, B:25:0x00ab, B:26:0x008b, B:28:0x0099, B:30:0x009d, B:33:0x00ba, B:37:0x0041, B:39:0x004d, B:40:0x0073, B:44:0x0058), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a8 -> B:25:0x00ab). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$closeWifiAndReCreateHot$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
