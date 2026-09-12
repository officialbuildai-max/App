package com.transsion.usercenter.profile;

import com.transsnet.downloader.DownloadManagerApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.profile.ProfileViewModel$fetchLatestDownloadList$1", f = "ProfileViewModel.kt", l = {102}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ProfileViewModel$fetchLatestDownloadList$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel$fetchLatestDownloadList$1(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$fetchLatestDownloadList$1> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileViewModel$fetchLatestDownloadList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$fetchLatestDownloadList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        androidx.view.b0 b0Var;
        androidx.view.b0 b0Var2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            b0Var = this.this$0.f57221e;
            DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
            this.L$0 = b0Var;
            this.label = 1;
            Object l02 = a11.l0(this);
            if (l02 == f11) {
                return f11;
            }
            b0Var2 = b0Var;
            obj = l02;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b0Var2 = (androidx.view.b0) this.L$0;
            ResultKt.b(obj);
        }
        b0Var2.q(obj);
        return Unit.f67184a;
    }
}
