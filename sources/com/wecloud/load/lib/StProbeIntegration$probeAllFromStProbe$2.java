package com.wecloud.load.lib;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "", "Lcom/wecloud/load/lib/n;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.wecloud.load.lib.StProbeIntegration$probeAllFromStProbe$2", f = "StProbeIntegration.kt", l = {303, Sdk$SDKError.Reason.LINK_COMMAND_OPEN_FAILED_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class StProbeIntegration$probeAllFromStProbe$2 extends SuspendLambda implements Function2<n0, Continuation<? super List<? extends n>>, Object> {
    final /* synthetic */ boolean $ensureInit;
    final /* synthetic */ int $maxConcurrency;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StProbeIntegration$probeAllFromStProbe$2(boolean z10, int i11, Continuation<? super StProbeIntegration$probeAllFromStProbe$2> continuation) {
        super(2, continuation);
        this.$ensureInit = z10;
        this.$maxConcurrency = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StProbeIntegration$probeAllFromStProbe$2 stProbeIntegration$probeAllFromStProbe$2 = new StProbeIntegration$probeAllFromStProbe$2(this.$ensureInit, this.$maxConcurrency, continuation);
        stProbeIntegration$probeAllFromStProbe$2.L$0 = obj;
        return stProbeIntegration$probeAllFromStProbe$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super List<n>> continuation) {
        return ((StProbeIntegration$probeAllFromStProbe$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wecloud.load.lib.StProbeIntegration$probeAllFromStProbe$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
