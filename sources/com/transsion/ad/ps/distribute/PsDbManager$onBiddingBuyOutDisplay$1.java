package com.transsion.ad.ps.distribute;

import android.text.TextUtils;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import ti.p;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.distribute.PsDbManager$onBiddingBuyOutDisplay$1", f = "PsDbManager.kt", l = {100, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class PsDbManager$onBiddingBuyOutDisplay$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PsLinkAdPlan $psLinkAdPlan;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PsDbManager$onBiddingBuyOutDisplay$1(PsLinkAdPlan psLinkAdPlan, Continuation<? super PsDbManager$onBiddingBuyOutDisplay$1> continuation) {
        super(2, continuation);
        this.$psLinkAdPlan = psLinkAdPlan;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PsDbManager$onBiddingBuyOutDisplay$1(this.$psLinkAdPlan, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PsDbManager$onBiddingBuyOutDisplay$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String e11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PsDbManager psDbManager = PsDbManager.f42243a;
            int id2 = this.$psLinkAdPlan.getId();
            this.label = 1;
            obj = psDbManager.g(id2, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        PsLinkAdPlan psLinkAdPlan = (PsLinkAdPlan) obj;
        if (psLinkAdPlan != null) {
            String c11 = p.f76389a.c();
            if (TextUtils.equals(c11, psLinkAdPlan.getShowDate())) {
                psLinkAdPlan.setShowedTimes(psLinkAdPlan.getShowedTimes() + 1);
            } else {
                psLinkAdPlan.setShowedTimes(1);
                psLinkAdPlan.setShowDate(c11);
            }
            oi.a aVar = oi.a.f71145a;
            PsDbManager psDbManager2 = PsDbManager.f42243a;
            e11 = psDbManager2.e();
            oi.a.k(aVar, e11 + " --> onBiddingBuyOutDisplay() --> id = " + psLinkAdPlan.getId() + " --> showMax = " + psLinkAdPlan.getShowMax() + " --> showHours = " + psLinkAdPlan.getShowHours() + " --> showedTimes = " + psLinkAdPlan.getShowedTimes() + " --> showDate = " + psLinkAdPlan.getShowDate() + " --> currentDate = " + c11, 0, false, 6, null);
            this.label = 2;
            if (psDbManager2.j(psLinkAdPlan, this) == f11) {
                return f11;
            }
        }
        return Unit.f67184a;
    }
}
