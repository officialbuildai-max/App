package com.transsion.ugcvideodetail.hepler;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.hepler.UGCLocalVideoFloatManager$saveHistoryInner$2", f = "UGCLocalVideoFloatManager.kt", l = {TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCLocalVideoFloatManager$saveHistoryInner$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ px.a $floatBean;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCLocalVideoFloatManager$saveHistoryInner$2(px.a aVar, Continuation<? super UGCLocalVideoFloatManager$saveHistoryInner$2> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UGCLocalVideoFloatManager$saveHistoryInner$2 uGCLocalVideoFloatManager$saveHistoryInner$2 = new UGCLocalVideoFloatManager$saveHistoryInner$2(this.$floatBean, continuation);
        uGCLocalVideoFloatManager$saveHistoryInner$2.L$0 = obj;
        return uGCLocalVideoFloatManager$saveHistoryInner$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCLocalVideoFloatManager$saveHistoryInner$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String ugcVideoId;
        UGCVideoDetailPlayDao g11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            px.a aVar = this.$floatBean;
            if (aVar != null) {
                long currentTimeMillis = System.currentTimeMillis();
                lg.a.f68962a.c("VideoFloat", "local-----saveHistory, subjectId:" + aVar.r() + " time:" + currentTimeMillis + ",se:" + aVar.q() + " ep:" + aVar.c() + ", progress:" + aVar.n(), true);
                Result.Companion companion2 = Result.INSTANCE;
                DownloadBean b11 = aVar.b();
                if (b11 != null && (ugcVideoId = b11.getUgcVideoId()) != null) {
                    g11 = UGCLocalVideoFloatManager.f56410b.g();
                    String r11 = aVar.r();
                    long n11 = aVar.n();
                    this.label = 1;
                    if (g11.k(r11, ugcVideoId, currentTimeMillis, n11, this) == f11) {
                        return f11;
                    }
                }
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "saveHistory--end", false, 4, null);
        Result.m1185constructorimpl(Unit.f67184a);
        return Unit.f67184a;
    }
}
