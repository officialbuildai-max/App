package com.transsion.home.fragment.home;

import android.app.Activity;
import com.transsion.version.update.UpdateManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.fragment.home.HomeSearchViewManager$handleUpdateIcon$1$1", f = "HomeSearchViewManager.kt", l = {Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HomeSearchViewManager$handleUpdateIcon$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeSearchViewManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeSearchViewManager$handleUpdateIcon$1$1(HomeSearchViewManager homeSearchViewManager, Continuation<? super HomeSearchViewManager$handleUpdateIcon$1$1> continuation) {
        super(2, continuation);
        this.this$0 = homeSearchViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeSearchViewManager$handleUpdateIcon$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HomeSearchViewManager$handleUpdateIcon$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            UpdateManager a11 = UpdateManager.f57641f.a();
            Object obj2 = this.this$0.f45189d;
            if (obj2 == null) {
                Intrinsics.z("context");
                obj2 = null;
            }
            this.label = 1;
            obj = a11.i((Activity) obj2, "app_center", "wefeed-mobile-bff", "", true, this);
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
        a.C0856a.f(lg.a.f68962a, "update", "checkUpdate " + booleanValue, false, 4, null);
        return Unit.f67184a;
    }
}
