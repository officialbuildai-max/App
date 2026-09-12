package com.transsion.rewardscenter.task.dada;

import androidx.view.b0;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.rewardscenter.model.RewardsCenterModel;
import com.transsion.rewardscenter.ui.RewardsCenterFragment;
import com.transsion.rewardscenter.utils.RewardsCenterApiHelper;
import com.transsion.rewardscenterapi.DaDaInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.task.dada.DadaActivateView$checkSetDefault$1", f = "DaDaActivateView.kt", l = {401, TTAdConstant.DEEPLINK_UNAVAILABLE_CODE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class DadaActivateView$checkSetDefault$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onFailure;
    final /* synthetic */ Function1<Boolean, Unit> $onSuccess;
    final /* synthetic */ long $time;
    int label;
    final /* synthetic */ DadaActivateView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DadaActivateView$checkSetDefault$1(DadaActivateView dadaActivateView, long j11, Function1<? super String, Unit> function1, Function1<? super Boolean, Unit> function12, Continuation<? super DadaActivateView$checkSetDefault$1> continuation) {
        super(2, continuation);
        this.this$0 = dadaActivateView;
        this.$time = j11;
        this.$onFailure = function1;
        this.$onSuccess = function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(DadaActivateView dadaActivateView, Function1 function1, String str, String str2) {
        wp.a aVar;
        RewardsCenterModel c11;
        b0 o11;
        aVar = dadaActivateView.ctxConfig;
        if (aVar != null && (c11 = aVar.c()) != null && (o11 = c11.o()) != null) {
            o11.n(Boolean.FALSE);
        }
        if (function1 != null) {
            function1.invoke(str2);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(DadaActivateView dadaActivateView, Function1 function1, DaDaInfo daDaInfo) {
        wp.a aVar;
        RewardsCenterModel c11;
        b0 o11;
        aVar = dadaActivateView.ctxConfig;
        if (aVar != null && (c11 = aVar.c()) != null && (o11 = c11.o()) != null) {
            o11.n(Boolean.FALSE);
        }
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(daDaInfo != null ? daDaInfo.isSetDefault() : false));
        }
        a.C0856a.f(lg.a.f68962a, "RewardsCenter", "--> checkDadaSetDefault: " + daDaInfo, false, 4, null);
        if (daDaInfo != null && daDaInfo.isSetDefault()) {
            dadaActivateView.setTaskState(DadaTaskState.SET_DEFAULT);
        }
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DadaActivateView$checkSetDefault$1(this.this$0, this.$time, this.$onFailure, this.$onSuccess, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DadaActivateView$checkSetDefault$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        wp.a aVar;
        WeakReference a11;
        RewardsCenterFragment rewardsCenterFragment;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            aVar = this.this$0.ctxConfig;
            if (aVar != null && (a11 = aVar.a()) != null && (rewardsCenterFragment = (RewardsCenterFragment) a11.get()) != null) {
                rewardsCenterFragment.showLoading();
            }
            long j11 = this.$time;
            if (j11 > 0) {
                this.label = 1;
                if (u0.a(j11, this) == f11) {
                    return f11;
                }
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
        RewardsCenterApiHelper rewardsCenterApiHelper = RewardsCenterApiHelper.f51346a;
        final DadaActivateView dadaActivateView = this.this$0;
        final Function1<String, Unit> function1 = this.$onFailure;
        Function2 function2 = new Function2() { // from class: com.transsion.rewardscenter.task.dada.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                Unit g11;
                g11 = DadaActivateView$checkSetDefault$1.g(DadaActivateView.this, function1, (String) obj2, (String) obj3);
                return g11;
            }
        };
        final DadaActivateView dadaActivateView2 = this.this$0;
        final Function1<Boolean, Unit> function12 = this.$onSuccess;
        Function1 function13 = new Function1() { // from class: com.transsion.rewardscenter.task.dada.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit h11;
                h11 = DadaActivateView$checkSetDefault$1.h(DadaActivateView.this, function12, (DaDaInfo) obj2);
                return h11;
            }
        };
        this.label = 2;
        if (rewardsCenterApiHelper.j(function2, function13, this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
