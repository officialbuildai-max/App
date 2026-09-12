package com.transsion.commercialization.aha;

import androidx.view.b0;
import bh.b;
import com.transsion.bean.AhaGameResponse;
import java.util.Map;
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
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.aha.GameRecommendViewModel$getAllGame$1", f = "GameRecommendViewModel.kt", l = {37}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class GameRecommendViewModel$getAllGame$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GameRecommendViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRecommendViewModel$getAllGame$1(GameRecommendViewModel gameRecommendViewModel, Continuation<? super GameRecommendViewModel$getAllGame$1> continuation) {
        super(2, continuation);
        this.this$0 = gameRecommendViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameRecommendViewModel$getAllGame$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((GameRecommendViewModel$getAllGame$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        String j11;
        String j12;
        b0 b0Var;
        g k11;
        int i11;
        GameRecommendViewModel gameRecommendViewModel;
        int i12;
        b0 b0Var2;
        String j13;
        String j14;
        Object f11 = IntrinsicsKt.f();
        int i13 = this.label;
        try {
            if (i13 == 0) {
                ResultKt.b(obj);
                GameRecommendViewModel gameRecommendViewModel2 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                k11 = gameRecommendViewModel2.k();
                Map a11 = g.INSTANCE.a();
                b.a aVar = bh.b.f16553a;
                i11 = gameRecommendViewModel2.f43803c;
                RequestBody a12 = aVar.a(new AhaGameRequest(new AhaGameQuery(i11, 10)));
                this.L$0 = gameRecommendViewModel2;
                this.label = 1;
                Object a13 = k11.a(a11, a12, this);
                if (a13 == f11) {
                    return f11;
                }
                gameRecommendViewModel = gameRecommendViewModel2;
                obj = a13;
            } else {
                if (i13 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                gameRecommendViewModel = (GameRecommendViewModel) this.L$0;
                ResultKt.b(obj);
            }
            AhaGameResponse ahaGameResponse = (AhaGameResponse) obj;
            Integer code = ahaGameResponse.getCode();
            if (code != null && code.intValue() == 1000) {
                i12 = gameRecommendViewModel.f43803c;
                gameRecommendViewModel.f43803c = i12 + 1;
            }
            b0Var2 = gameRecommendViewModel.f43801a;
            b0Var2.n(ahaGameResponse);
            a.C0856a c0856a = lg.a.f68962a;
            j13 = gameRecommendViewModel.j();
            j14 = gameRecommendViewModel.j();
            c0856a.c(j13, j14 + " --> getAllGame() --> postAhaGameRecommendList = " + ahaGameResponse, true);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        GameRecommendViewModel gameRecommendViewModel3 = this.this$0;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a c0856a2 = lg.a.f68962a;
            j11 = gameRecommendViewModel3.j();
            j12 = gameRecommendViewModel3.j();
            c0856a2.c(j11, j12 + " --> getAllGame() --> 加载失败了 it = " + m1188exceptionOrNullimpl, true);
            b0Var = gameRecommendViewModel3.f43801a;
            b0Var.n(null);
        }
        return Unit.f67184a;
    }
}
