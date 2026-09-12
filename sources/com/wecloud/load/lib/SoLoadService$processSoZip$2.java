package com.wecloud.load.lib;

import com.wecloud.load.lib.SoLoadService;
import com.wecloud.load.lib.bean.SoZipInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Lcom/wecloud/load/lib/SoLoadService$b;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lcom/wecloud/load/lib/SoLoadService$b;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.wecloud.load.lib.SoLoadService$processSoZip$2", f = "SoLoadService.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class SoLoadService$processSoZip$2 extends SuspendLambda implements Function2<n0, Continuation<? super SoLoadService.b>, Object> {
    final /* synthetic */ SoZipInfo $soZipInfo;
    final /* synthetic */ int $zipIndex;
    int label;
    final /* synthetic */ SoLoadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoLoadService$processSoZip$2(SoZipInfo soZipInfo, int i11, SoLoadService soLoadService, Continuation<? super SoLoadService$processSoZip$2> continuation) {
        super(2, continuation);
        this.$soZipInfo = soZipInfo;
        this.$zipIndex = i11;
        this.this$0 = soLoadService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SoLoadService$processSoZip$2(this.$soZipInfo, this.$zipIndex, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super SoLoadService.b> continuation) {
        return ((SoLoadService$processSoZip$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 1265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wecloud.load.lib.SoLoadService$processSoZip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
