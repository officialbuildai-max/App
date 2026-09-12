package com.transsion.payment.lib.strategy;

import com.android.billingclient.api.Purchase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$purchasesUpdatedListener$1$1", f = "GoogleStrategy.kt", l = {261, 264}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class GoogleStrategy$purchasesUpdatedListener$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Purchase> $purchases;
    Object L$0;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleStrategy$purchasesUpdatedListener$1$1(List<Purchase> list, GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$purchasesUpdatedListener$1$1> continuation) {
        super(2, continuation);
        this.$purchases = list;
        this.this$0 = googleStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$purchasesUpdatedListener$1$1(this.$purchases, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((GoogleStrategy$purchasesUpdatedListener$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r5.L$0
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.ResultKt.b(r6)
            goto L37
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            kotlin.ResultKt.b(r6)
            goto L30
        L22:
            kotlin.ResultKt.b(r6)
            r5.label = r3
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r6 = kotlinx.coroutines.u0.a(r3, r5)
            if (r6 != r0) goto L30
            return r0
        L30:
            java.util.List<com.android.billingclient.api.Purchase> r6 = r5.$purchases
            java.util.Iterator r6 = r6.iterator()
            r1 = r6
        L37:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L50
            java.lang.Object r6 = r1.next()
            com.android.billingclient.api.Purchase r6 = (com.android.billingclient.api.Purchase) r6
            com.transsion.payment.lib.strategy.GoogleStrategy r3 = r5.this$0
            r5.L$0 = r1
            r5.label = r2
            java.lang.Object r6 = com.transsion.payment.lib.strategy.GoogleStrategy.p(r3, r6, r5)
            if (r6 != r0) goto L37
            return r0
        L50:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.strategy.GoogleStrategy$purchasesUpdatedListener$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
