package com.transsion.baselib.report.launch;

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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baselib.report.launch.RoomInstallReferrer$checkSnowballInstallReferrer$3", f = "RoomInstallReferrer.kt", l = {166}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class RoomInstallReferrer$checkSnowballInstallReferrer$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomInstallReferrer$checkSnowballInstallReferrer$3(Continuation<? super RoomInstallReferrer$checkSnowballInstallReferrer$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomInstallReferrer$checkSnowballInstallReferrer$3 roomInstallReferrer$checkSnowballInstallReferrer$3 = new RoomInstallReferrer$checkSnowballInstallReferrer$3(continuation);
        roomInstallReferrer$checkSnowballInstallReferrer$3.L$0 = obj;
        return roomInstallReferrer$checkSnowballInstallReferrer$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomInstallReferrer$checkSnowballInstallReferrer$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object k11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                Result.Companion companion = Result.INSTANCE;
                RoomInstallReferrer roomInstallReferrer = RoomInstallReferrer.f43420a;
                this.label = 1;
                k11 = roomInstallReferrer.k(this);
                if (k11 == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return Unit.f67184a;
    }
}
