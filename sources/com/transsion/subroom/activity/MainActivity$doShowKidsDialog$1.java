package com.transsion.subroom.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subroom.activity.MainActivity$doShowKidsDialog$1", f = "MainActivity.kt", l = {342, 354}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class MainActivity$doShowKidsDialog$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$doShowKidsDialog$1(MainActivity mainActivity, Continuation<? super MainActivity$doShowKidsDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$doShowKidsDialog$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MainActivity$doShowKidsDialog$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a6  */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r11)
            goto L9e
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            kotlin.ResultKt.b(r11)
            goto L53
        L1f:
            kotlin.ResultKt.b(r11)
            ak.o r11 = ak.o.f721a
            boolean r11 = r11.j()
            if (r11 != 0) goto L2d
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        L2d:
            com.transsion.baselib.kids.KidsAccountManager r11 = com.transsion.baselib.kids.KidsAccountManager.f43340a
            com.transsion.baselib.kids.KidsProfile r1 = r11.f()
            if (r1 == 0) goto L80
            boolean r1 = r11.j()
            if (r1 == 0) goto L4a
            lg.a$a r4 = lg.a.f68962a
            r8 = 4
            r9 = 0
            java.lang.String r5 = "MainActivity"
            java.lang.String r6 = "switchDialogSuppressed."
            r7 = 0
            lg.a.C0856a.f(r4, r5, r6, r7, r8, r9)
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        L4a:
            r10.label = r3
            java.lang.Object r11 = r11.o(r10)
            if (r11 != r0) goto L53
            return r0
        L53:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L5e
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        L5e:
            com.transsion.subroom.activity.MainActivity r11 = r10.this$0
            boolean r11 = r11.isDestroyed()
            if (r11 != 0) goto L7d
            com.transsion.subroom.activity.MainActivity r11 = r10.this$0
            boolean r11 = r11.isFinishing()
            if (r11 == 0) goto L6f
            goto L7d
        L6f:
            com.transsion.usercenter.kids.AccountSwitchDialog$a r11 = com.transsion.usercenter.kids.AccountSwitchDialog.INSTANCE
            com.transsion.usercenter.kids.AccountSwitchDialog r11 = r11.a(r3)
            com.transsion.subroom.activity.MainActivity r0 = r10.this$0
            java.lang.String r1 = "AccountSwitchDialog"
            r11.X(r0, r1)
            goto Lcc
        L7d:
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        L80:
            boolean r1 = r11.g()
            if (r1 == 0) goto L95
            lg.a$a r3 = lg.a.f68962a
            r7 = 4
            r8 = 0
            java.lang.String r4 = "MainActivity"
            java.lang.String r5 = "createDialogSuppressed."
            r6 = 0
            lg.a.C0856a.f(r3, r4, r5, r6, r7, r8)
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        L95:
            r10.label = r2
            java.lang.Object r11 = r11.o(r10)
            if (r11 != r0) goto L9e
            return r0
        L9e:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto La9
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        La9:
            com.transsion.subroom.activity.MainActivity r11 = r10.this$0
            boolean r11 = r11.isDestroyed()
            if (r11 != 0) goto Lcf
            com.transsion.subroom.activity.MainActivity r11 = r10.this$0
            boolean r11 = r11.isFinishing()
            if (r11 == 0) goto Lba
            goto Lcf
        Lba:
            com.transsion.usercenter.kids.CreateKidsProfileDialog$a r0 = com.transsion.usercenter.kids.CreateKidsProfileDialog.INSTANCE
            r4 = 1
            r5 = 0
            r1 = 0
            r2 = 1
            r3 = 0
            com.transsion.usercenter.kids.CreateKidsProfileDialog r11 = com.transsion.usercenter.kids.CreateKidsProfileDialog.Companion.b(r0, r1, r2, r3, r4, r5)
            com.transsion.subroom.activity.MainActivity r0 = r10.this$0
            java.lang.String r1 = "CreateKidsProfileDialog"
            r11.X(r0, r1)
        Lcc:
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        Lcf:
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity$doShowKidsDialog$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
