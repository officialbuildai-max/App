package com.transsion.videodetail;

import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchEpisodeMediaList$1", f = "VideoDetailViewModel.kt", l = {161, 169, 177, 196, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class VideoDetailViewModel$fetchEpisodeMediaList$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ResourcesSeason> $seasons;
    final /* synthetic */ String $subjectId;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ VideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailViewModel$fetchEpisodeMediaList$1(VideoDetailViewModel videoDetailViewModel, List<ResourcesSeason> list, String str, Continuation<? super VideoDetailViewModel$fetchEpisodeMediaList$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDetailViewModel;
        this.$seasons = list;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDetailViewModel$fetchEpisodeMediaList$1(this.this$0, this.$seasons, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((VideoDetailViewModel$fetchEpisodeMediaList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x03f2, code lost:
    
        r16 = r5;
        r25 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0403, code lost:
    
        if (new kotlin.ranges.IntRange(r8, r4).o(r12.intValue()) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0405, code lost:
    
        r3 = new com.transsion.videodetail.bean.VideoDetailMediaSource(r1, r2.getSe(), r12.intValue(), null, r2.getVipInfo(), 8, null);
        r5 = r6.o(r12);
        r3.setName(r5);
        r17 = r4;
        r4 = com.transsnet.downloader.manager.p.f59623a.a(com.blankj.utilcode.util.Utils.a());
        r5 = r3.getSe();
        r4 = r12.intValue();
        r0.L$0 = r1;
        r0.L$1 = r6;
        r0.L$2 = r7;
        r0.L$3 = r2;
        r0.L$4 = r13;
        r0.L$5 = r11;
        r0.L$6 = r11;
        r0.L$7 = r14;
        r0.L$8 = r12;
        r0.L$9 = r3;
        r0.L$10 = r3;
        r0.L$11 = r15;
        r0.I$0 = r10;
        r0.I$1 = r9;
        r0.I$2 = r8;
        r19 = r2;
        r0.I$3 = r17;
        r0.label = 5;
        r2 = r4.u(r1, r5, r4, r0);
        r5 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x046c, code lost:
    
        if (r2 != r5) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x046e, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x046f, code lost:
    
        r18 = r7;
        r7 = r14;
        r4 = r17;
        r14 = r3;
        r17 = r12;
        r12 = r15;
        r15 = r14;
        r3 = r1;
        r1 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x048d, code lost:
    
        r5 = r25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x053c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0326 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x033d  */
    /* JADX WARN: Type inference failed for: r11v38, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v29, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x046f -> B:9:0x047b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x048d -> B:10:0x0493). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x04b1 -> B:13:0x0575). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x04c2 -> B:13:0x0575). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0558 -> B:38:0x04cc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0568 -> B:13:0x0575). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0294 -> B:56:0x0297). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x02a4 -> B:57:0x02a5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0216 -> B:58:0x0226). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x0336 -> B:86:0x02c6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 1495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.VideoDetailViewModel$fetchEpisodeMediaList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
