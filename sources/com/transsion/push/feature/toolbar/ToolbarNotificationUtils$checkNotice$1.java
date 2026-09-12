package com.transsion.push.feature.toolbar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.feature.toolbar.ToolbarNotificationUtils$checkNotice$1", f = "ToolbarNotificationUtils.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class ToolbarNotificationUtils$checkNotice$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    ToolbarNotificationUtils$checkNotice$1(Continuation<? super ToolbarNotificationUtils$checkNotice$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ToolbarNotificationUtils$checkNotice$1 toolbarNotificationUtils$checkNotice$1 = new ToolbarNotificationUtils$checkNotice$1(continuation);
        toolbarNotificationUtils$checkNotice$1.L$0 = obj;
        return toolbarNotificationUtils$checkNotice$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ToolbarNotificationUtils$checkNotice$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[Catch: all -> 0x000f, TRY_ENTER, TryCatch #1 {all -> 0x000f, blocks: (B:5:0x000b, B:6:0x0077, B:14:0x0020, B:17:0x002f, B:19:0x003f, B:21:0x0045, B:23:0x0051, B:24:0x0057, B:26:0x0065), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065 A[Catch: all -> 0x000f, TryCatch #1 {all -> 0x000f, blocks: (B:5:0x000b, B:6:0x0077, B:14:0x0020, B:17:0x002f, B:19:0x003f, B:21:0x0045, B:23:0x0051, B:24:0x0057, B:26:0x0065), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> Lf
            goto L77
        Lf:
            r10 = move-exception
            goto L7d
        L11:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L19:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.n0 r10 = (kotlinx.coroutines.n0) r10
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lf
            lg.a$a r3 = lg.a.f68962a     // Catch: java.lang.Throwable -> Lf
            java.lang.String r4 = "ToolbarNo"
            java.lang.String r5 = "checkNotice-----"
            r7 = 4
            r8 = 0
            r6 = 0
            lg.a.C0856a.v(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lf
            r10 = 0
            sm.f$a r1 = sm.f.f75530c     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L4e
            sm.f r1 = r1.a()     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L4e
            java.lang.String r3 = "sa_toolbar_notice"
            r4 = 0
            r5 = 2
            com.transsion.mb.config.manager.ConfigBean r1 = sm.f.d(r1, r3, r4, r5, r10)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L4e
            if (r1 == 0) goto L4e
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L4e
            if (r1 == 0) goto L4e
            java.lang.Class<com.transsion.push.feature.toolbar.ToolbarNoticeConfig> r3 = com.transsion.push.feature.toolbar.ToolbarNoticeConfig.class
            java.lang.Object r1 = com.blankj.utilcode.util.o.d(r1, r3)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L4e
            com.transsion.push.feature.toolbar.ToolbarNoticeConfig r1 = (com.transsion.push.feature.toolbar.ToolbarNoticeConfig) r1     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L4e
            goto L4f
        L4e:
            r1 = r10
        L4f:
            if (r1 == 0) goto L56
            int r3 = r1.getDays()     // Catch: java.lang.Throwable -> Lf
            goto L57
        L56:
            r3 = 3
        L57:
            com.transsion.push.feature.toolbar.ToolbarNotificationUtils.g(r1)     // Catch: java.lang.Throwable -> Lf
            com.transsion.push.feature.toolbar.ToolbarNotificationUtils r4 = com.transsion.push.feature.toolbar.ToolbarNotificationUtils.f50888a     // Catch: java.lang.Throwable -> Lf
            com.transsion.push.feature.toolbar.ToolbarNotificationUtils.e(r4, r1)     // Catch: java.lang.Throwable -> Lf
            boolean r1 = com.transsion.push.feature.toolbar.ToolbarNotificationUtils.c(r4, r3)     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto L77
            kotlinx.coroutines.a2 r1 = kotlinx.coroutines.y0.c()     // Catch: java.lang.Throwable -> Lf
            com.transsion.push.feature.toolbar.ToolbarNotificationUtils$checkNotice$1$1$1 r3 = new com.transsion.push.feature.toolbar.ToolbarNotificationUtils$checkNotice$1$1$1     // Catch: java.lang.Throwable -> Lf
            r3.<init>(r10)     // Catch: java.lang.Throwable -> Lf
            r9.label = r2     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r10 = kotlinx.coroutines.i.g(r1, r3, r9)     // Catch: java.lang.Throwable -> Lf
            if (r10 != r0) goto L77
            return r0
        L77:
            kotlin.Unit r10 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> Lf
            kotlin.Result.m1185constructorimpl(r10)     // Catch: java.lang.Throwable -> Lf
            goto L86
        L7d:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.a(r10)
            kotlin.Result.m1185constructorimpl(r10)
        L86:
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.feature.toolbar.ToolbarNotificationUtils$checkNotice$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
