package com.transsion.mpush.core.renderer;

import android.content.Context;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.db.PushDatabase;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.transsion.mpush.core.renderer.AbsNotificationRenderer$updateMsgStatus$1", f = "AbsNotificationRenderer.kt", l = {266, 276}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class AbsNotificationRenderer$updateMsgStatus$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ LocalPushMessage $msgBean;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsNotificationRenderer$updateMsgStatus$1(LocalPushMessage localPushMessage, Context context, Continuation<? super AbsNotificationRenderer$updateMsgStatus$1> continuation) {
        super(2, continuation);
        this.$msgBean = localPushMessage;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsNotificationRenderer$updateMsgStatus$1(this.$msgBean, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AbsNotificationRenderer$updateMsgStatus$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        mn.a j02;
        LocalPushMessage localPushMessage;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "updateMsgStatus: updating status for " + this.$msgBean.getMessageId(), false, 4, null);
            j02 = PushDatabase.INSTANCE.b(this.$context).j0();
            localPushMessage = this.$msgBean;
            String messageId = localPushMessage.getMessageId();
            if (messageId == null) {
                messageId = "";
            }
            this.L$0 = localPushMessage;
            this.L$1 = j02;
            this.label = 1;
            obj = j02.g(messageId, this);
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
            j02 = (mn.a) this.L$1;
            localPushMessage = (LocalPushMessage) this.L$0;
            ResultKt.b(obj);
        }
        LocalPushMessage localPushMessage2 = (LocalPushMessage) obj;
        if (localPushMessage2 != null) {
            localPushMessage2.setMsgStatus(1);
            localPushMessage2.setShowTime(System.currentTimeMillis());
            if (localPushMessage.getTriggerSource() == 1) {
                localPushMessage2.setHasScreenOn(true);
            }
            if (localPushMessage.getTriggerSource() == 2) {
                localPushMessage2.setForceShow(true);
            }
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (j02.f(localPushMessage2, this) == f11) {
                return f11;
            }
        }
        return Unit.f67184a;
    }
}
