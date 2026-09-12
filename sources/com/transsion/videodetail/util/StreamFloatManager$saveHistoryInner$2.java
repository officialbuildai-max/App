package com.transsion.videodetail.util;

import com.transsion.baselib.db.video.VideoDetailPlayDao;
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
@DebugMetadata(c = "com.transsion.videodetail.util.StreamFloatManager$saveHistoryInner$2", f = "StreamFloatManager.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class StreamFloatManager$saveHistoryInner$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ px.a $floatBean;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFloatManager$saveHistoryInner$2(px.a aVar, Continuation<? super StreamFloatManager$saveHistoryInner$2> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StreamFloatManager$saveHistoryInner$2 streamFloatManager$saveHistoryInner$2 = new StreamFloatManager$saveHistoryInner$2(this.$floatBean, continuation);
        streamFloatManager$saveHistoryInner$2.L$0 = obj;
        return streamFloatManager$saveHistoryInner$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((StreamFloatManager$saveHistoryInner$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        VideoDetailPlayDao n11;
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
                lg.a.f68962a.c("VideoFloat", "stream-----saveHistory, subjectId:" + aVar.r() + " time:" + currentTimeMillis + ",se:" + aVar.q() + " ep:" + aVar.c() + ", progress:" + aVar.n(), true);
                Result.Companion companion2 = Result.INSTANCE;
                n11 = StreamFloatManager.f57996b.n();
                String r11 = aVar.r();
                int q11 = aVar.q();
                int c11 = aVar.c();
                long n12 = aVar.n();
                this.label = 1;
                if (n11.f(r11, q11, c11, currentTimeMillis, n12, this) == f11) {
                    return f11;
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
