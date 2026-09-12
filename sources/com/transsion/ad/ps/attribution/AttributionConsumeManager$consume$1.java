package com.transsion.ad.ps.attribution;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
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
import kotlinx.coroutines.u0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.attribution.AttributionConsumeManager$consume$1", f = "AttributionConsumeManager.kt", l = {42, Sdk$SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class AttributionConsumeManager$consume$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributionConsumeManager$consume$1(Continuation<? super AttributionConsumeManager$consume$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AttributionConsumeManager$consume$1 attributionConsumeManager$consume$1 = new AttributionConsumeManager$consume$1(continuation);
        attributionConsumeManager$consume$1.L$0 = obj;
        return attributionConsumeManager$consume$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AttributionConsumeManager$consume$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        Object q11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            Result.Companion companion2 = Result.INSTANCE;
            AttributionConsumeManager attributionConsumeManager = AttributionConsumeManager.f42231c;
            this.label = 1;
            q11 = attributionConsumeManager.q(this);
            if (q11 == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                AttributionConsumeManager.f42231c.p();
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            oi.a.k(oi.a.f71145a, AttributionConsumeManager.f42231c.e() + " --> consume() --> it = " + m1188exceptionOrNullimpl, 6, false, 4, null);
            this.label = 2;
            if (u0.a(10000L, this) == f11) {
                return f11;
            }
            AttributionConsumeManager.f42231c.p();
        }
        return Unit.f67184a;
    }
}
