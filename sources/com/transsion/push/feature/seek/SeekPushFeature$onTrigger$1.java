package com.transsion.push.feature.seek;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.feature.seek.SeekPushFeature$onTrigger$1", f = "SeekPushFeature.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class SeekPushFeature$onTrigger$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $source;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SeekPushFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekPushFeature$onTrigger$1(SeekPushFeature seekPushFeature, int i11, Continuation<? super SeekPushFeature$onTrigger$1> continuation) {
        super(2, continuation);
        this.this$0 = seekPushFeature;
        this.$source = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SeekPushFeature$onTrigger$1 seekPushFeature$onTrigger$1 = new SeekPushFeature$onTrigger$1(this.this$0, this.$source, continuation);
        seekPushFeature$onTrigger$1.L$0 = obj;
        return seekPushFeature$onTrigger$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SeekPushFeature$onTrigger$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        SeekPushFeature seekPushFeature = this.this$0;
        int i11 = this.$source;
        try {
            Result.Companion companion = Result.INSTANCE;
            seekPushFeature.b(i11);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        int i12 = this.$source;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "PushRegisterManager", "【求片推送】处理触发异常，触发源：" + i12 + "，异常：" + m1188exceptionOrNullimpl, false, 4, null);
        }
        return Unit.f67184a;
    }
}
