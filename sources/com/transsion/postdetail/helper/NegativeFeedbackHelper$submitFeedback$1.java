package com.transsion.postdetail.helper;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.baseui.util.m;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.NegativeFeedbackRequest;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;
import xo.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.helper.NegativeFeedbackHelper$submitFeedback$1", f = "NegativeFeedbackHelper.kt", l = {Sdk$SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class NegativeFeedbackHelper$submitFeedback$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $authorId;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ String $postId;
    final /* synthetic */ String $submitToastText;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NegativeFeedbackHelper$submitFeedback$1(String str, String str2, String str3, String str4, Function0<Unit> function0, Continuation<? super NegativeFeedbackHelper$submitFeedback$1> continuation) {
        super(2, continuation);
        this.$postId = str;
        this.$authorId = str2;
        this.$actionType = str3;
        this.$submitToastText = str4;
        this.$onSuccess = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NegativeFeedbackHelper$submitFeedback$1 negativeFeedbackHelper$submitFeedback$1 = new NegativeFeedbackHelper$submitFeedback$1(this.$postId, this.$authorId, this.$actionType, this.$submitToastText, this.$onSuccess, continuation);
        negativeFeedbackHelper$submitFeedback$1.L$0 = obj;
        return negativeFeedbackHelper$submitFeedback$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((NegativeFeedbackHelper$submitFeedback$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        String str;
        String str2;
        xo.b g11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                String str3 = this.$postId;
                String str4 = this.$authorId;
                String str5 = this.$actionType;
                Result.Companion companion = Result.INSTANCE;
                g11 = NegativeFeedbackHelper.f48903a.g();
                NegativeFeedbackRequest negativeFeedbackRequest = new NegativeFeedbackRequest(str3, (str4 == null || str4.length() <= 0) ? null : str4, str5, null, null, null, null, 120, null);
                this.label = 1;
                obj = b.a.b(g11, null, negativeFeedbackRequest, this, 1, null);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            m1185constructorimpl = Result.m1185constructorimpl((BaseDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        String str6 = this.$submitToastText;
        Function0<Unit> function0 = this.$onSuccess;
        if (Result.m1192isSuccessimpl(m1185constructorimpl)) {
            BaseDto baseDto = (BaseDto) m1185constructorimpl;
            if (str6 != null) {
                m.d(str6);
            }
            if (function0 != null) {
                function0.invoke();
            }
            a.C0856a c0856a = lg.a.f68962a;
            str2 = NegativeFeedbackHelper.f48904b;
            c0856a.c(str2, "postNegativeFeedback success: code=" + baseDto.getCode() + ", msg=" + baseDto.getMsg(), true);
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a c0856a2 = lg.a.f68962a;
            str = NegativeFeedbackHelper.f48904b;
            c0856a2.i(str, "postNegativeFeedback error: " + m1188exceptionOrNullimpl.getMessage(), true);
            m.e(R$string.post_feedback_fail);
        }
        return Unit.f67184a;
    }
}
