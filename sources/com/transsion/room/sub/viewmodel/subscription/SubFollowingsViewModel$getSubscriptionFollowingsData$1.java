package com.transsion.room.sub.viewmodel.subscription;

import com.tn.lib.net.bean.BaseDto;
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
import lq.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.subscription.SubFollowingsViewModel$getSubscriptionFollowingsData$1", f = "SubFollowingsViewModel.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class SubFollowingsViewModel$getSubscriptionFollowingsData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cursor;
    int label;
    final /* synthetic */ SubFollowingsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFollowingsViewModel$getSubscriptionFollowingsData$1(SubFollowingsViewModel subFollowingsViewModel, String str, Continuation<? super SubFollowingsViewModel$getSubscriptionFollowingsData$1> continuation) {
        super(2, continuation);
        this.this$0 = subFollowingsViewModel;
        this.$cursor = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubFollowingsViewModel$getSubscriptionFollowingsData$1(this.this$0, this.$cursor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubFollowingsViewModel$getSubscriptionFollowingsData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b bVar;
        int i11;
        Object f11 = IntrinsicsKt.f();
        int i12 = this.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                bVar = this.this$0.f51832e;
                String a11 = vg.a.f77447a.a();
                String valueOf = String.valueOf(this.$cursor);
                i11 = this.this$0.f51830c;
                this.label = 1;
                obj = bVar.a(a11, valueOf, i11, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            a.C0856a.f(lg.a.f68962a, "SubFollowingsViewModel", "Followings List data " + baseDto, false, 4, null);
            this.this$0.e().n(baseDto.getData());
        } catch (Exception e11) {
            e11.printStackTrace();
            a.C0856a c0856a = lg.a.f68962a;
            String simpleName = SubFollowingsViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            c0856a.i(simpleName, "exceptionHandler " + e11.getMessage(), true);
        }
        return Unit.f67184a;
    }
}
