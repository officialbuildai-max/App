package com.transsion.transfer.wifi.create.adapter;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.transsion.transfer.wifi.util.WifiUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$retryCreate$1", f = "P2PWifiAdapter.kt", l = {MiniAppConfigHelper.DEFAULT_MINIAPP_ALL_DATA_MAX_SIZE, 292, 294}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class P2PWifiAdapter$retryCreate$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ P2PWifiAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P2PWifiAdapter$retryCreate$1(P2PWifiAdapter p2PWifiAdapter, Continuation<? super P2PWifiAdapter$retryCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = p2PWifiAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new P2PWifiAdapter$retryCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((P2PWifiAdapter$retryCreate$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.this$0.y();
            if (WifiUtils.f56083a.s()) {
                this.label = 1;
                if (u0.a(1000L, this) == f11) {
                    return f11;
                }
            } else {
                this.label = 2;
                if (u0.a(200L, this) == f11) {
                    return f11;
                }
            }
        } else {
            if (i11 != 1 && i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        P2PWifiAdapter p2PWifiAdapter = this.this$0;
        this.label = 3;
        if (p2PWifiAdapter.a(this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
