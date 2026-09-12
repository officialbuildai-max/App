package com.transsion.audio.viewmodel;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getAudioList$1", f = "HistoryListManager.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_VISIBILITY_VALUE, 67}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HistoryListManager$getAudioList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$getAudioList$1(HistoryListManager historyListManager, Continuation<? super HistoryListManager$getAudioList$1> continuation) {
        super(2, continuation);
        this.this$0 = historyListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$getAudioList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$getAudioList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.label
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L2b
            if (r1 == r2) goto L27
            if (r1 != r3) goto L1f
            java.lang.Object r1 = r9.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r9.L$1
            com.transsion.baselib.db.audio.AudioBean r2 = (com.transsion.baselib.db.audio.AudioBean) r2
            java.lang.Object r5 = r9.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.b(r10)
            goto L60
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            kotlin.ResultKt.b(r10)
            goto L3f
        L2b:
            kotlin.ResultKt.b(r10)
            com.transsion.audio.viewmodel.HistoryListManager r10 = r9.this$0
            jj.a r10 = com.transsion.audio.viewmodel.HistoryListManager.f(r10)
            if (r10 == 0) goto L42
            r9.label = r2
            java.lang.Object r10 = r10.e(r9)
            if (r10 != r0) goto L3f
            return r0
        L3f:
            java.util.List r10 = (java.util.List) r10
            goto L43
        L42:
            r10 = r4
        L43:
            if (r10 == 0) goto La1
            r1 = r10
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto La1
            com.transsion.audio.player.AudioPlayer$a r1 = com.transsion.audio.player.AudioPlayer.f42943i
            com.transsion.audio.player.AudioPlayer r1 = r1.a()
            com.transsion.baselib.db.audio.AudioBean r1 = r1.t()
            java.util.Iterator r2 = r10.iterator()
            r5 = r10
            r8 = r2
            r2 = r1
            r1 = r8
        L60:
            boolean r10 = r1.hasNext()
            if (r10 == 0) goto La0
            java.lang.Object r10 = r1.next()
            com.transsion.baselib.db.audio.AudioBean r10 = (com.transsion.baselib.db.audio.AudioBean) r10
            int r6 = r10.getStatus()
            r7 = 3
            if (r6 != r7) goto L60
            if (r2 == 0) goto L7a
            java.lang.String r6 = r2.getAudioUrl()
            goto L7b
        L7a:
            r6 = r4
        L7b:
            java.lang.String r7 = r10.getAudioUrl()
            boolean r6 = android.text.TextUtils.equals(r6, r7)
            if (r6 != 0) goto L60
            r6 = 4
            r10.setStatus(r6)
            com.transsion.audio.viewmodel.HistoryListManager r6 = r9.this$0
            jj.a r6 = com.transsion.audio.viewmodel.HistoryListManager.f(r6)
            if (r6 == 0) goto L60
            r9.L$0 = r5
            r9.L$1 = r2
            r9.L$2 = r1
            r9.label = r3
            java.lang.Object r10 = r6.h(r10, r9)
            if (r10 != r0) goto L60
            return r0
        La0:
            r10 = r5
        La1:
            com.transsion.audio.viewmodel.HistoryListManager r0 = r9.this$0
            androidx.lifecycle.b0 r0 = r0.p()
            r0.q(r10)
            lg.a$a r0 = lg.a.f68962a
            if (r10 == 0) goto Lb7
            int r10 = r10.size()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.d(r10)
            goto Lb8
        Lb7:
            r10 = r4
        Lb8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "get getAudioList success"
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r1 = 0
            lg.a.C0856a.g(r0, r10, r1, r3, r4)
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.viewmodel.HistoryListManager$getAudioList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
