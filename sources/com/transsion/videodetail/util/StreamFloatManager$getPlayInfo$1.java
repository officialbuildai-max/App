package com.transsion.videodetail.util;

import com.transsion.videodetail.bean.VideoDetailStreamList;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.videodetail.util.StreamFloatManager$getPlayInfo$1", f = "StreamFloatManager.kt", l = {Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 227, 237}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class StreamFloatManager$getPlayInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<VideoDetailStreamList, Unit> $callback;
    final /* synthetic */ int $ep;
    final /* synthetic */ int $se;
    final /* synthetic */ String $subjectId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StreamFloatManager$getPlayInfo$1(String str, int i11, int i12, Function1<? super VideoDetailStreamList, Unit> function1, Continuation<? super StreamFloatManager$getPlayInfo$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$se = i11;
        this.$ep = i12;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StreamFloatManager$getPlayInfo$1 streamFloatManager$getPlayInfo$1 = new StreamFloatManager$getPlayInfo$1(this.$subjectId, this.$se, this.$ep, this.$callback, continuation);
        streamFloatManager$getPlayInfo$1.L$0 = obj;
        return streamFloatManager$getPlayInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((StreamFloatManager$getPlayInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0125  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.util.StreamFloatManager$getPlayInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
