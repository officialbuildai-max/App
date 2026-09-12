package com.transsion.ad.monopoly.intercept;

import android.app.Application;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlans;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import ti.p;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager$saveShowedTimes$3", f = "NonAdShowedTimesManager.kt", l = {112, Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, Sdk$SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class NonAdShowedTimesManager$saveShowedTimes$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdPlans $mAdPlans;
    final /* synthetic */ MbAdDbPlans $nonAdPlans;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonAdShowedTimesManager$saveShowedTimes$3(MbAdDbPlans mbAdDbPlans, AdPlans adPlans, Continuation<? super NonAdShowedTimesManager$saveShowedTimes$3> continuation) {
        super(2, continuation);
        this.$nonAdPlans = mbAdDbPlans;
        this.$mAdPlans = adPlans;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NonAdShowedTimesManager$saveShowedTimes$3(this.$nonAdPlans, this.$mAdPlans, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((NonAdShowedTimesManager$saveShowedTimes$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            MbAdDbPlans mbAdDbPlans = this.$nonAdPlans;
            concurrentHashMap = NonAdShowedTimesManager.f42189b;
            ShowedTimesMemoryBean showedTimesMemoryBean = (ShowedTimesMemoryBean) concurrentHashMap.get(this.$nonAdPlans.getId());
            mbAdDbPlans.setShowedTimes(Boxing.d(showedTimesMemoryBean != null ? showedTimesMemoryBean.getShowedTimes() : 0));
            this.$nonAdPlans.setShowDate(p.f76389a.c());
            MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            li.b z02 = companion.b(a11).z0();
            String id2 = this.$mAdPlans.getId();
            this.label = 1;
            obj = z02.h(id2, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2 && i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        MbAdDbPlans mbAdDbPlans2 = (MbAdDbPlans) obj;
        if (TextUtils.equals(mbAdDbPlans2 != null ? mbAdDbPlans2.getAdPlanUpdateTime() : null, this.$nonAdPlans.getAdPlanUpdateTime())) {
            MbAdDatabase.Companion companion2 = MbAdDatabase.INSTANCE;
            Application a12 = Utils.a();
            Intrinsics.g(a12, "getApp(...)");
            li.b z03 = companion2.b(a12).z0();
            MbAdDbPlans mbAdDbPlans3 = this.$nonAdPlans;
            this.label = 2;
            if (z03.i(mbAdDbPlans3, this) == f11) {
                return f11;
            }
        } else {
            if (mbAdDbPlans2 != null) {
                mbAdDbPlans2.setShowedTimes(this.$nonAdPlans.getShowedTimes());
            }
            if (mbAdDbPlans2 != null) {
                mbAdDbPlans2.setShowDate(this.$nonAdPlans.getShowDate());
            }
            if (mbAdDbPlans2 != null) {
                MbAdDatabase.Companion companion3 = MbAdDatabase.INSTANCE;
                Application a13 = Utils.a();
                Intrinsics.g(a13, "getApp(...)");
                li.b z04 = companion3.b(a13).z0();
                this.label = 3;
                if (z04.i(mbAdDbPlans2, this) == f11) {
                    return f11;
                }
            }
        }
        return Unit.f67184a;
    }
}
