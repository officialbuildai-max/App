package com.transsion.usercenter.setting.labelsfeedback;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsion.usercenter.setting.labelsfeedback.model.FbOption;
import com.transsion.usercenter.setting.labelsfeedback.model.FbOptionList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity$onCreate$5", f = "LabelsFeedbackActivity.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class LabelsFeedbackActivity$onCreate$5 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LabelsFeedbackActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelsFeedbackActivity$onCreate$5(LabelsFeedbackActivity labelsFeedbackActivity, Continuation<? super LabelsFeedbackActivity$onCreate$5> continuation) {
        super(2, continuation);
        this.this$0 = labelsFeedbackActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LabelsFeedbackActivity$onCreate$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LabelsFeedbackActivity$onCreate$5) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FbDataModel fbDataModel;
        c s02;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                yw.a aVar = (yw.a) zg.c.f79537e.a().h(yw.a.class);
                String a11 = vg.a.f77447a.a();
                this.label = 1;
                obj = aVar.b(a11, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            FbOptionList fbOptionList = (FbOptionList) ((BaseDto) obj).getData();
            if (fbOptionList != null) {
                LabelsFeedbackActivity labelsFeedbackActivity = this.this$0;
                fbDataModel = labelsFeedbackActivity.model;
                if (fbDataModel == null) {
                    Intrinsics.z("model");
                    fbDataModel = null;
                }
                fbDataModel.setOptions(fbOptionList.getLabelList());
                s02 = labelsFeedbackActivity.s0();
                s02.notifyDataSetChanged();
                FbOption.INSTANCE.d(fbOptionList);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return Unit.f67184a;
    }
}
