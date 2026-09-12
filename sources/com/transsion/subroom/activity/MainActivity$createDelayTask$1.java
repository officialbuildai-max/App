package com.transsion.subroom.activity;

import com.transsnet.downloader.notification.DownloadNotificationUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subroom.activity.MainActivity$createDelayTask$1", f = "MainActivity.kt", l = {1191, 1192, 1202}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MainActivity$createDelayTask$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$createDelayTask$1(MainActivity mainActivity, Continuation<? super MainActivity$createDelayTask$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        DownloadNotificationUtils.f59629a.G();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$createDelayTask$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MainActivity$createDelayTask$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L26
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.b(r15)
            goto L8e
        L16:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1e:
            kotlin.ResultKt.b(r15)
            goto L50
        L22:
            kotlin.ResultKt.b(r15)
            goto L34
        L26:
            kotlin.ResultKt.b(r15)
            r14.label = r4
            r5 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r15 = kotlinx.coroutines.u0.a(r5, r14)
            if (r15 != r0) goto L34
            return r0
        L34:
            com.transsion.version.update.UpdateManager$a r15 = com.transsion.version.update.UpdateManager.f57641f
            com.transsion.version.update.UpdateManager r5 = r15.a()
            com.transsion.subroom.activity.MainActivity r6 = r14.this$0
            r14.label = r3
            java.lang.String r7 = "main_page"
            java.lang.String r8 = "wefeed-mobile-bff"
            java.lang.String r9 = ""
            r10 = 0
            r12 = 16
            r13 = 0
            r11 = r14
            java.lang.Object r15 = com.transsion.version.update.UpdateManager.j(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r15 != r0) goto L50
            return r0
        L50:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L83
            com.transsion.usercenterapi.UpdateResultEvent r15 = new com.transsion.usercenterapi.UpdateResultEvent
            r15.<init>(r4)
            com.transsnet.flow.event.AppScopeVMlProvider r1 = com.transsnet.flow.event.AppScopeVMlProvider.INSTANCE
            java.lang.Class<com.transsnet.flow.event.FlowEventBus> r3 = com.transsnet.flow.event.FlowEventBus.class
            androidx.lifecycle.t0 r1 = r1.getApplicationScopeViewModel(r3)
            com.transsnet.flow.event.FlowEventBus r1 = (com.transsnet.flow.event.FlowEventBus) r1
            java.lang.Class<com.transsion.usercenterapi.UpdateResultEvent> r3 = com.transsion.usercenterapi.UpdateResultEvent.class
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            r4 = 0
            r1.postEvent(r3, r15, r4)
            lg.a$a r6 = lg.a.f68962a
            r10 = 4
            r11 = 0
            java.lang.String r7 = "update"
            java.lang.String r8 = "NeedUpdate"
            r9 = 0
            lg.a.C0856a.f(r6, r7, r8, r9, r10, r11)
        L83:
            r14.label = r2
            r1 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r15 = kotlinx.coroutines.u0.a(r1, r14)
            if (r15 != r0) goto L8e
            return r0
        L8e:
            com.tn.lib.thread.b r15 = com.tn.lib.thread.b.f40922a
            com.transsion.subroom.activity.x r0 = new com.transsion.subroom.activity.x
            r0.<init>()
            r15.a(r0)
            com.transsion.usercenter.setting.labelsfeedback.sender.FBSender r15 = com.transsion.usercenter.setting.labelsfeedback.sender.FBSender.f57582a
            com.transsion.subroom.activity.MainActivity r0 = r14.this$0
            android.app.Application r0 = r0.getApplication()
            java.lang.String r1 = "getApplication(...)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            r15.j(r0)
            vj.d r15 = vj.d.f77456a
            android.app.Application r0 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r1 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            r15.g(r0)
            kotlin.Unit r15 = kotlin.Unit.f67184a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity$createDelayTask$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
