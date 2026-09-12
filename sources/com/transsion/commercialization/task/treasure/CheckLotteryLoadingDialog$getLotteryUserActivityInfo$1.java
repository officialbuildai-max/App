package com.transsion.commercialization.task.treasure;

import com.blankj.utilcode.util.ToastUtils;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.bean.lottery.LotteryUserActivityInfoEntity;
import com.transsion.bean.lottery.LotteryUserActivityInfoUserLotteryBean;
import com.transsion.commercialization.R$string;
import com.transsion.commercialization.task.treasure.b;
import com.transsion.commercialization.task.wheel.TreasureWheelDialog;
import com.transsion.core.utils.ToastUtil;
import com.transsion.payment.lib.bean.HttpErrorBodyBean;
import kotlin.Metadata;
import kotlin.Result;
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
import retrofit2.HttpException;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.task.treasure.CheckLotteryLoadingDialog$getLotteryUserActivityInfo$1", f = "CheckLotteryLoadingDialog.kt", l = {69}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CheckLotteryLoadingDialog$getLotteryUserActivityInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CheckLotteryLoadingDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckLotteryLoadingDialog$getLotteryUserActivityInfo$1(CheckLotteryLoadingDialog checkLotteryLoadingDialog, Continuation<? super CheckLotteryLoadingDialog$getLotteryUserActivityInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = checkLotteryLoadingDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckLotteryLoadingDialog$getLotteryUserActivityInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CheckLotteryLoadingDialog$getLotteryUserActivityInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        Boolean bool;
        String str;
        b u02;
        String str2;
        String str3;
        CheckLotteryLoadingDialog checkLotteryLoadingDialog;
        Boolean bool2;
        LotteryUserActivityInfoUserLotteryBean userLottery;
        Integer todayRemain;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                CheckLotteryLoadingDialog checkLotteryLoadingDialog2 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                u02 = checkLotteryLoadingDialog2.u0();
                str2 = checkLotteryLoadingDialog2.activityId;
                str3 = checkLotteryLoadingDialog2.orderId;
                this.L$0 = checkLotteryLoadingDialog2;
                this.label = 1;
                Object a11 = b.a.a(u02, null, str2, str3, this, 1, null);
                if (a11 == f11) {
                    return f11;
                }
                checkLotteryLoadingDialog = checkLotteryLoadingDialog2;
                obj = a11;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                checkLotteryLoadingDialog = (CheckLotteryLoadingDialog) this.L$0;
                ResultKt.b(obj);
            }
            LotteryUserActivityInfoEntity lotteryUserActivityInfoEntity = (LotteryUserActivityInfoEntity) ((BaseDto) obj).getData();
            if (((lotteryUserActivityInfoEntity == null || (userLottery = lotteryUserActivityInfoEntity.getUserLottery()) == null || (todayRemain = userLottery.getTodayRemain()) == null) ? 0 : todayRemain.intValue()) >= 1) {
                new TreasureWheelDialog().D0(lotteryUserActivityInfoEntity).k0(com.blankj.utilcode.util.a.b(), "WheelViewDialog");
            } else {
                ok.c.f71157a.b(checkLotteryLoadingDialog.getClassTag() + " --> getLotteryUserActivityInfo() --> 当前没有抽奖次数了");
                bool2 = checkLotteryLoadingDialog.showErrorToast;
                if (Intrinsics.c(bool2, Boxing.a(true))) {
                    ToastUtils.r(R$string.daily_spin_limit_reached);
                }
            }
            checkLotteryLoadingDialog.dismissAllowingStateLoss();
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        CheckLotteryLoadingDialog checkLotteryLoadingDialog3 = this.this$0;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            ok.c.f71157a.b(checkLotteryLoadingDialog3.getClassTag() + " --> getLotteryUserActivityInfo() ---> getOrElse() --> it = " + m1188exceptionOrNullimpl);
            bool = checkLotteryLoadingDialog3.showErrorToast;
            if (Intrinsics.c(bool, Boxing.a(true)) && (m1188exceptionOrNullimpl instanceof HttpException)) {
                HttpErrorBodyBean a12 = HttpErrorBodyBean.INSTANCE.a((HttpException) m1188exceptionOrNullimpl);
                if (a12 == null || (str = a12.getMessage()) == null) {
                    str = "";
                }
                ToastUtil.f(str);
            }
            checkLotteryLoadingDialog3.dismissAllowingStateLoss();
        }
        return Unit.f67184a;
    }
}
