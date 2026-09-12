package com.transsion.subtitle_download.task;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subtitle_download.task.GetInStationSubtitleListTask$downloadUGCVideo$1", f = "GetInStationSubtitleListTask.kt", l = {Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 141, 157}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class GetInStationSubtitleListTask$downloadUGCVideo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ String $idType;
    final /* synthetic */ String $ops;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $ugcVideoId;
    final /* synthetic */ String $videoResourceId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GetInStationSubtitleListTask$downloadUGCVideo$1(String str, String str2, String str3, String str4, String str5, String str6, Function1<? super Boolean, Unit> function1, String str7, Continuation<? super GetInStationSubtitleListTask$downloadUGCVideo$1> continuation) {
        super(2, continuation);
        this.$ugcVideoId = str;
        this.$videoResourceId = str2;
        this.$idType = str3;
        this.$subjectId = str4;
        this.$resourceId = str5;
        this.$collectionId = str6;
        this.$resultCallback = function1;
        this.$ops = str7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetInStationSubtitleListTask$downloadUGCVideo$1 getInStationSubtitleListTask$downloadUGCVideo$1 = new GetInStationSubtitleListTask$downloadUGCVideo$1(this.$ugcVideoId, this.$videoResourceId, this.$idType, this.$subjectId, this.$resourceId, this.$collectionId, this.$resultCallback, this.$ops, continuation);
        getInStationSubtitleListTask$downloadUGCVideo$1.L$0 = obj;
        return getInStationSubtitleListTask$downloadUGCVideo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((GetInStationSubtitleListTask$downloadUGCVideo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:1|(1:2)|(1:(1:(1:(3:7|8|9)(2:11|12))(8:13|14|15|16|17|(2:19|(1:21))|8|9))(3:25|26|27))(3:51|52|(1:54)(1:55))|28|29|30|31|32|33|34|35|36|37|38|39|(1:41)|15|16|17|(0)|8|9|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(23:1|2|(1:(1:(1:(3:7|8|9)(2:11|12))(8:13|14|15|16|17|(2:19|(1:21))|8|9))(3:25|26|27))(3:51|52|(1:54)(1:55))|28|29|30|31|32|33|34|35|36|37|38|39|(1:41)|15|16|17|(0)|8|9|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x017b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0192, code lost:
    
        r2 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x017d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x017e, code lost:
    
        r1 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x018e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x018f, code lost:
    
        r14 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0182, code lost:
    
        r15 = " --> downloadUGCVideo() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
        r23 = " -- resourceId = ";
        r24 = " -- videoResourceId = ";
        r25 = " -- ugcVideoId = ";
        r26 = " -- collectionId = ";
        r27 = " -- idType = ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0181, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01b1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle_download.task.GetInStationSubtitleListTask$downloadUGCVideo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
