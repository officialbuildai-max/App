package com.transsion.shorttv.viewmodel;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.shorttv.bean.Subject;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
@DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTvEpisodes$1", f = "ShortTvViewModel.kt", l = {249, 272, 295, Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 328, 332, 338, 351, 367, 373, TTAdConstant.DEEPLINK_UNAVAILABLE_CODE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvViewModel$getShortTvEpisodes$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentSubjectId;
    final /* synthetic */ Integer $dataSource;
    final /* synthetic */ int $ep;
    final /* synthetic */ boolean $isHistoryFirst;
    final /* synthetic */ Subject $subject;
    final /* synthetic */ String $subjectId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$getShortTvEpisodes$1(Integer num, ShortTvViewModel shortTvViewModel, String str, String str2, Subject subject, int i11, boolean z10, Continuation<? super ShortTvViewModel$getShortTvEpisodes$1> continuation) {
        super(2, continuation);
        this.$dataSource = num;
        this.this$0 = shortTvViewModel;
        this.$subjectId = str;
        this.$currentSubjectId = str2;
        this.$subject = subject;
        this.$ep = i11;
        this.$isHistoryFirst = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvViewModel$getShortTvEpisodes$1 shortTvViewModel$getShortTvEpisodes$1 = new ShortTvViewModel$getShortTvEpisodes$1(this.$dataSource, this.this$0, this.$subjectId, this.$currentSubjectId, this.$subject, this.$ep, this.$isHistoryFirst, continuation);
        shortTvViewModel$getShortTvEpisodes$1.L$0 = obj;
        return shortTvViewModel$getShortTvEpisodes$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$getShortTvEpisodes$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x04d5 A[Catch: all -> 0x005a, TryCatch #3 {all -> 0x005a, blocks: (B:94:0x0053, B:96:0x04a0, B:98:0x04a4, B:100:0x04aa, B:102:0x04d5, B:103:0x04de, B:104:0x04e2, B:130:0x0470, B:132:0x048b), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0573  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0395 A[Catch: Exception -> 0x0388, TryCatch #2 {Exception -> 0x0388, blocks: (B:185:0x0381, B:162:0x038e, B:164:0x0395, B:166:0x0399, B:167:0x039f, B:169:0x03a4, B:171:0x03aa, B:172:0x03b0, B:174:0x03b5, B:176:0x03bd), top: B:184:0x0381 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03aa A[Catch: Exception -> 0x0388, TryCatch #2 {Exception -> 0x0388, blocks: (B:185:0x0381, B:162:0x038e, B:164:0x0395, B:166:0x0399, B:167:0x039f, B:169:0x03a4, B:171:0x03aa, B:172:0x03b0, B:174:0x03b5, B:176:0x03bd), top: B:184:0x0381 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03b5 A[Catch: Exception -> 0x0388, TryCatch #2 {Exception -> 0x0388, blocks: (B:185:0x0381, B:162:0x038e, B:164:0x0395, B:166:0x0399, B:167:0x039f, B:169:0x03a4, B:171:0x03aa, B:172:0x03b0, B:174:0x03b5, B:176:0x03bd), top: B:184:0x0381 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0381 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0254 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x06e3  */
    /* JADX WARN: Type inference failed for: r1v146, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v149, types: [java.util.List] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 1966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTvEpisodes$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
