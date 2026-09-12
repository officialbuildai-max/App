package com.transsion.ad.ps.distribute;

import bh.b;
import com.transsion.ad.ps.PSReportUtil;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import hi.f;
import java.util.List;
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
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.distribute.PsDistributeRequestManager$getPsLinkListBySlot$2", f = "PsDistributeRequestManager.kt", l = {92, 106}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class PsDistributeRequestManager$getPsLinkListBySlot$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nonId;
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ Integer $psScene;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PsDistributeRequestManager$getPsLinkListBySlot$2(int i11, int i12, Integer num, String str, Continuation<? super PsDistributeRequestManager$getPsLinkListBySlot$2> continuation) {
        super(2, continuation);
        this.$pageIndex = i11;
        this.$pageSize = i12;
        this.$psScene = num;
        this.$nonId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PsDistributeRequestManager$getPsLinkListBySlot$2(this.$pageIndex, this.$pageSize, this.$psScene, this.$nonId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PsDistributeRequestManager$getPsLinkListBySlot$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String k11;
        ConcurrentHashMap concurrentHashMap;
        JSONObject l11;
        qi.a o11;
        String k12;
        Object h11;
        List<RecommendInfo> data;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            try {
            } catch (Exception e11) {
                oi.a aVar = oi.a.f71145a;
                k11 = PsDistributeRequestManager.f42245a.k();
                oi.a.k(aVar, k11 + " --> getPsLinkList() --> psScene = " + this.$psScene + " --> it = " + e11, 6, false, 4, null);
                PSReportUtil.f42224a.d(PSReportUtil.PSRequestState.REQUEST_FAIL, null, String.valueOf(e11.getMessage()), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue(), String.valueOf(this.$psScene));
            }
            if (i11 == 0) {
                ResultKt.b(obj);
                PsDistributeRequestManager psDistributeRequestManager = PsDistributeRequestManager.f42245a;
                l11 = psDistributeRequestManager.l(this.$pageIndex, this.$pageSize, this.$psScene);
                f fVar = f.f64595a;
                String str = fVar.e() ? "https://feature-api.palmplaystore.com" : "https://test-feature-api.palmplaystore.com";
                if (fVar.b()) {
                    oi.a aVar2 = oi.a.f71145a;
                    k12 = psDistributeRequestManager.k();
                    oi.a.k(aVar2, k12 + " --> getPsLinkListBySlot() --> psScene = " + this.$psScene + " --> url = " + str + " --> jsonObject = " + l11, 0, false, 6, null);
                }
                o11 = psDistributeRequestManager.o();
                b.a aVar3 = bh.b.f16553a;
                String jSONObject = l11.toString();
                Intrinsics.g(jSONObject, "toString(...)");
                RequestBody a11 = aVar3.a(jSONObject);
                this.label = 1;
                obj = o11.b(a11, str, this);
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
            PsLinkDto psLinkDto = (PsLinkDto) obj;
            PSReportUtil.f42224a.d(PSReportUtil.PSRequestState.REQUEST_SUCCESS, (psLinkDto == null || (data = psLinkDto.getData()) == null) ? null : Boxing.d(data.size()), "", String.valueOf(this.$psScene), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue());
            PsDistributeRequestManager psDistributeRequestManager2 = PsDistributeRequestManager.f42245a;
            String valueOf = String.valueOf(this.$psScene);
            String str2 = this.$nonId;
            this.label = 2;
            h11 = psDistributeRequestManager2.h(valueOf, str2, psLinkDto, this);
            if (h11 == f11) {
                return f11;
            }
            return Unit.f67184a;
        } finally {
            concurrentHashMap = PsDistributeRequestManager.f42247c;
            concurrentHashMap.remove(this.$psScene);
        }
    }
}
