package com.transsion.usercenter.setting;

import com.transsion.usercenter.R$string;
import com.transsion.version.update.UpdateManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.setting.SettingActivity$checkUpdateByUser$1", f = "SettingActivity.kt", l = {252}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class SettingActivity$checkUpdateByUser$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingActivity$checkUpdateByUser$1(SettingActivity settingActivity, Continuation<? super SettingActivity$checkUpdateByUser$1> continuation) {
        super(2, continuation);
        this.this$0 = settingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingActivity$checkUpdateByUser$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SettingActivity$checkUpdateByUser$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            UpdateManager a11 = UpdateManager.f57641f.a();
            SettingActivity settingActivity = this.this$0;
            this.label = 1;
            obj = a11.i(settingActivity, "setting_page", "wefeed-mobile-bff", "", true, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        this.this$0.H0();
        if (!booleanValue) {
            com.tn.lib.widget.toast.core.h.f41533a.l(this.this$0.getString(R$string.profile_setting_check_update_tip));
        }
        return Unit.f67184a;
    }
}
