package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", l = {63, 64, 70}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class SessionFirelogPublisherImpl$logSession$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ t $sessionDetails;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$logSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, t tVar, Continuation<? super SessionFirelogPublisherImpl$logSession$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionFirelogPublisherImpl;
        this.$sessionDetails = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionFirelogPublisherImpl$logSession$1(this.this$0, this.$sessionDetails, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SessionFirelogPublisherImpl$logSession$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L45
            if (r1 == r4) goto L41
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r0 = r10.L$5
            com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
            java.lang.Object r1 = r10.L$4
            com.google.firebase.sessions.t r1 = (com.google.firebase.sessions.t) r1
            java.lang.Object r2 = r10.L$3
            com.google.firebase.f r2 = (com.google.firebase.f) r2
            java.lang.Object r3 = r10.L$2
            com.google.firebase.sessions.v r3 = (com.google.firebase.sessions.v) r3
            java.lang.Object r4 = r10.L$1
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
            java.lang.Object r5 = r10.L$0
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            kotlin.ResultKt.b(r11)
            r7 = r4
            r8 = r3
            r3 = r0
            r0 = r8
            r9 = r2
            r2 = r1
            r1 = r9
            goto L9d
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3d:
            kotlin.ResultKt.b(r11)
            goto L6c
        L41:
            kotlin.ResultKt.b(r11)
            goto L53
        L45:
            kotlin.ResultKt.b(r11)
            com.google.firebase.sessions.SessionFirelogPublisherImpl r11 = r10.this$0
            r10.label = r4
            java.lang.Object r11 = com.google.firebase.sessions.SessionFirelogPublisherImpl.f(r11, r10)
            if (r11 != r0) goto L53
            return r0
        L53:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto Lb0
            com.google.firebase.sessions.InstallationId$Companion r11 = com.google.firebase.sessions.InstallationId.f32632c
            com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = r10.this$0
            jc.e r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.d(r1)
            r10.label = r3
            java.lang.Object r11 = r11.a(r1, r10)
            if (r11 != r0) goto L6c
            return r0
        L6c:
            r5 = r11
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = r10.this$0
            com.google.firebase.sessions.v r3 = com.google.firebase.sessions.v.f32790a
            com.google.firebase.f r11 = com.google.firebase.sessions.SessionFirelogPublisherImpl.c(r4)
            com.google.firebase.sessions.t r1 = r10.$sessionDetails
            com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = r10.this$0
            com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.e(r6)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f32686a
            r10.L$0 = r5
            r10.L$1 = r4
            r10.L$2 = r3
            r10.L$3 = r11
            r10.L$4 = r1
            r10.L$5 = r6
            r10.label = r2
            java.lang.Object r2 = r7.c(r10)
            if (r2 != r0) goto L96
            return r0
        L96:
            r0 = r3
            r7 = r4
            r3 = r6
            r8 = r1
            r1 = r11
            r11 = r2
            r2 = r8
        L9d:
            r4 = r11
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r11 = r5.b()
            java.lang.String r6 = r5.a()
            r5 = r11
            com.google.firebase.sessions.u r11 = r0.a(r1, r2, r3, r4, r5, r6)
            com.google.firebase.sessions.SessionFirelogPublisherImpl.b(r7, r11)
        Lb0:
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
