package com.transsion.mpush.core.features;

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
@DebugMetadata(c = "com.transsion.mpush.core.features.PermanentPushFeature$onTrigger$1", f = "PermanentPushFeature.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class PermanentPushFeature$onTrigger$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $source;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PermanentPushFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermanentPushFeature$onTrigger$1(PermanentPushFeature permanentPushFeature, int i11, Continuation<? super PermanentPushFeature$onTrigger$1> continuation) {
        super(2, continuation);
        this.this$0 = permanentPushFeature;
        this.$source = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PermanentPushFeature$onTrigger$1 permanentPushFeature$onTrigger$1 = new PermanentPushFeature$onTrigger$1(this.this$0, this.$source, continuation);
        permanentPushFeature$onTrigger$1.L$0 = obj;
        return permanentPushFeature$onTrigger$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PermanentPushFeature$onTrigger$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        String str;
        Object n11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                PermanentPushFeature permanentPushFeature = this.this$0;
                int i12 = this.$source;
                Result.Companion companion = Result.INSTANCE;
                this.label = 1;
                n11 = permanentPushFeature.n(i12, this);
                if (n11 == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        PermanentPushFeature permanentPushFeature2 = this.this$0;
        int i13 = this.$source;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a c0856a = lg.a.f68962a;
            str = permanentPushFeature2.f47586a;
            a.C0856a.l(c0856a, str, "【常驻推送】处理触发异常，触发源：" + i13 + "，异常：" + m1188exceptionOrNullimpl, false, 4, null);
        }
        return Unit.f67184a;
    }
}
