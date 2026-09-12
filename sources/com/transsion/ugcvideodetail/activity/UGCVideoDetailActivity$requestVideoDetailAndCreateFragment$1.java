package com.transsion.ugcvideodetail.activity;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.activity.UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1", f = "UGCVideoDetailActivity.kt", l = {PsExtractor.AUDIO_STREAM, 198}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UGCVideoDetailActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1(UGCVideoDetailActivity uGCVideoDetailActivity, Continuation<? super UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCVideoDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1 uGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1 = new UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1(this.this$0, continuation);
        uGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1.L$0 = obj;
        return uGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|2|(1:(1:(5:6|7|8|9|(1:11))(2:34|35))(5:36|37|38|39|(1:41)))(6:42|43|(4:48|(1:50)|39|(0))|51|(4:56|(1:58)|9|(0))|59)|(5:13|14|15|16|17)(7:22|(1:24)(1:33)|25|26|27|28|29)|60|61|62|63|28|29|(1:(1:64))) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0195, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0196, code lost:
    
        r1 = kotlin.Result.INSTANCE;
        kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r0));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00bc A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:7:0x001a, B:9:0x00b0, B:11:0x00bc, B:13:0x00d2, B:16:0x010b, B:21:0x0102, B:22:0x010e, B:24:0x0116, B:25:0x0134, B:32:0x014d, B:33:0x0129, B:37:0x0030, B:39:0x0070, B:41:0x007c, B:43:0x003d, B:45:0x0043, B:48:0x004a, B:51:0x0084, B:53:0x008a, B:56:0x0091, B:59:0x00c4, B:15:0x00eb, B:27:0x0136), top: B:2:0x0010, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:7:0x001a, B:9:0x00b0, B:11:0x00bc, B:13:0x00d2, B:16:0x010b, B:21:0x0102, B:22:0x010e, B:24:0x0116, B:25:0x0134, B:32:0x014d, B:33:0x0129, B:37:0x0030, B:39:0x0070, B:41:0x007c, B:43:0x003d, B:45:0x0043, B:48:0x004a, B:51:0x0084, B:53:0x008a, B:56:0x0091, B:59:0x00c4, B:15:0x00eb, B:27:0x0136), top: B:2:0x0010, inners: #0, #3 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r16) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.activity.UGCVideoDetailActivity$requestVideoDetailAndCreateFragment$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
