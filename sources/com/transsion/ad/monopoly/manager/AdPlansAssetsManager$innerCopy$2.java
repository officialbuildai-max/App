package com.transsion.ad.monopoly.manager;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdPlansAssetsManager$innerCopy$2", f = "AdPlansAssetsManager.kt", l = {Sdk$SDKMetric.SDKMetricType.TEMPLATE_HTML_SIZE_VALUE, 44}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AdPlansAssetsManager$innerCopy$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdPlansAssetsManager$innerCopy$2(Continuation<? super AdPlansAssetsManager$innerCopy$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdPlansAssetsManager$innerCopy$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AdPlansAssetsManager$innerCopy$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0077 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:7:0x0012, B:8:0x0068, B:10:0x0077, B:11:0x007d, B:13:0x0088, B:15:0x008e, B:16:0x0098, B:18:0x009e, B:19:0x00a2, B:20:0x00e0, B:32:0x0021, B:33:0x0035, B:35:0x003d, B:37:0x004b, B:41:0x00c5, B:42:0x00d3, B:44:0x0028), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009e A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:7:0x0012, B:8:0x0068, B:10:0x0077, B:11:0x007d, B:13:0x0088, B:15:0x008e, B:16:0x0098, B:18:0x009e, B:19:0x00a2, B:20:0x00e0, B:32:0x0021, B:33:0x0035, B:35:0x003d, B:37:0x004b, B:41:0x00c5, B:42:0x00d3, B:44:0x0028), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansAssetsManager$innerCopy$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
