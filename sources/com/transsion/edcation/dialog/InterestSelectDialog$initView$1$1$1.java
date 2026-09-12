package com.transsion.edcation.dialog;

import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.toast.core.h;
import com.transsion.edcation.bean.InterestBody;
import com.transsion.edcation.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.dialog.InterestSelectDialog$initView$1$1$1", f = "InterestSelectDialog.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class InterestSelectDialog$initView$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InterestSelectDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestSelectDialog$initView$1$1$1(InterestSelectDialog interestSelectDialog, Continuation<? super InterestSelectDialog$initView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = interestSelectDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterestSelectDialog$initView$1$1$1 interestSelectDialog$initView$1$1$1 = new InterestSelectDialog$initView$1$1$1(this.this$0, continuation);
        interestSelectDialog$initView$1$1$1.L$0 = obj;
        return interestSelectDialog$initView$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((InterestSelectDialog$initView$1$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        com.transsion.edcation.c w02;
        List list;
        InterestSelectDialog interestSelectDialog;
        List list2;
        String unused;
        String unused2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                InterestSelectDialog interestSelectDialog2 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                w02 = interestSelectDialog2.w0();
                list = interestSelectDialog2.selectIds;
                InterestBody interestBody = new InterestBody(list);
                this.L$0 = interestSelectDialog2;
                this.label = 1;
                Object c11 = c.a.c(w02, null, interestBody, this, 1, null);
                if (c11 == f11) {
                    return f11;
                }
                interestSelectDialog = interestSelectDialog2;
                obj = c11;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interestSelectDialog = (InterestSelectDialog) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            unused = interestSelectDialog.TAG;
            list2 = interestSelectDialog.selectIds;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("res: ");
            sb2.append(baseDto);
            sb2.append(", ids: ");
            sb2.append(list2);
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                interestSelectDialog.a0();
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        InterestSelectDialog interestSelectDialog3 = this.this$0;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null && interestSelectDialog3.isAdded() && !interestSelectDialog3.isDetached() && !interestSelectDialog3.isRemoving()) {
            h.f41533a.l(Utils.a().getString(R$string.no_error_content));
            unused2 = interestSelectDialog3.TAG;
            String message = m1188exceptionOrNullimpl.getMessage();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("error: ");
            sb3.append(message);
        }
        return Unit.f67184a;
    }
}
