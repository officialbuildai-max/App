package com.transsion.push;

import com.transsion.mpush.api.LocalPushMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "", "Lcom/transsion/mpush/api/LocalPushMessage;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.PushTestActivity$showLocalPushList$1$list$1", f = "PushTestActivity.kt", l = {151}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class PushTestActivity$showLocalPushList$1$list$1 extends SuspendLambda implements Function2<n0, Continuation<? super List<? extends LocalPushMessage>>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PushTestActivity$showLocalPushList$1$list$1(Continuation<? super PushTestActivity$showLocalPushList$1$list$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushTestActivity$showLocalPushList$1$list$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super List<LocalPushMessage>> continuation) {
        return ((PushTestActivity$showLocalPushList$1$list$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0037  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r4)
            goto L31
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L17:
            kotlin.ResultKt.b(r4)
            ln.a r4 = ln.a.f69101a
            com.transsion.mpush.core.db.PushDatabase r4 = r4.d()
            if (r4 == 0) goto L34
            mn.a r4 = r4.j0()
            if (r4 == 0) goto L34
            r3.label = r2
            java.lang.Object r4 = r4.d(r3)
            if (r4 != r0) goto L31
            return r0
        L31:
            java.util.List r4 = (java.util.List) r4
            goto L35
        L34:
            r4 = 0
        L35:
            if (r4 != 0) goto L3b
            java.util.List r4 = kotlin.collections.CollectionsKt.l()
        L3b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.PushTestActivity$showLocalPushList$1$list$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
