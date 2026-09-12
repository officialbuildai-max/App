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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.subscription.SubscriptionFeedListViewModel$getSubscriptionFeedData$1", f = "SubscriptionFeedListViewModel.kt", l = {92}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class SubscriptionFeedListViewModel$getSubscriptionFeedData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cursor;
    int label;
    final /* synthetic */ SubscriptionFeedListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionFeedListViewModel$getSubscriptionFeedData$1(SubscriptionFeedListViewModel subscriptionFeedListViewModel, String str, Continuation<? super SubscriptionFeedListViewModel$getSubscriptionFeedData$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionFeedListViewModel;
        this.$cursor = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionFeedListViewModel$getSubscriptionFeedData$1(this.this$0, this.$cursor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubscriptionFeedListViewModel$getSubscriptionFeedData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        lq.a aVar;
        int i11;
        Object f11 = IntrinsicsKt.f();
        int i12 = this.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                aVar = this.this$0.f51838d;
                String a11 = vg.a.f77447a.a();
                String valueOf = String.valueOf(this.$cursor);
                i11 = SubscriptionFeedListViewModel.f51835g;
                this.label = 1;
                obj = aVar.b(a11, valueOf, i11, this);
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
            Object data = baseDto.getData();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Feed List: ");
            sb2.append(data);
            this.this$0.e().n(baseDto.getData());
        } catch (Exception e11) {
            e11.printStackTrace();
            a.C0856a c0856a = lg.a.f68962a;
            String simpleName = SubscriptionFeedListViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            c0856a.i(simpleName, "exceptionHandler " + e11.getMessage(), true);
        }
        return Unit.f67184a;
    }
}
