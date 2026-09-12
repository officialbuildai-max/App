package com.transsion.ad.ps.activate;

import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.activate.PSActivateRequest$getPsActivateList$3", f = "PSActivateRequest.kt", l = {MBSupportMuteAdType.REWARD_VIDEO, Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class PSActivateRequest$getPsActivateList$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PSActivateRequest$getPsActivateList$3(Continuation<? super PSActivateRequest$getPsActivateList$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PSActivateRequest$getPsActivateList$3(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PSActivateRequest$getPsActivateList$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1 A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:7:0x0017, B:8:0x0167, B:19:0x002b, B:21:0x00e7, B:23:0x00f1, B:25:0x00fb, B:27:0x0101, B:28:0x010b, B:30:0x012c, B:32:0x0132, B:34:0x0138, B:35:0x0145, B:37:0x0156, B:38:0x015c, B:44:0x003f, B:46:0x0070, B:49:0x0080, B:51:0x0086, B:52:0x00b0, B:57:0x004a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0156 A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:7:0x0017, B:8:0x0167, B:19:0x002b, B:21:0x00e7, B:23:0x00f1, B:25:0x00fb, B:27:0x0101, B:28:0x010b, B:30:0x012c, B:32:0x0132, B:34:0x0138, B:35:0x0145, B:37:0x0156, B:38:0x015c, B:44:0x003f, B:46:0x0070, B:49:0x0080, B:51:0x0086, B:52:0x00b0, B:57:0x004a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0166 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.activate.PSActivateRequest$getPsActivateList$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
