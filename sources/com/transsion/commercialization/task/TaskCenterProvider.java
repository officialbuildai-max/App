package com.transsion.commercialization.task;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.therouter.TheRouter;
import com.transsion.commercialization.task.TaskCenterProvider;
import com.transsion.commercialization.task.treasure.CheckLotteryLoadingDialog;
import com.transsion.commercialization.task.treasure.TreasureStyleADialog;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.OpType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zm.a;

/* loaded from: classes.dex */
public final class TaskCenterProvider implements ITaskCenterApi {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f43937a = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.task.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.commercialization.task.treasure.b l11;
            l11 = TaskCenterProvider.l();
            return l11;
        }
    });

    /* loaded from: classes5.dex */
    public static final class a implements zm.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ok.b f43939b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MemberSceneType f43940c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f43941d;

        a(ok.b bVar, MemberSceneType memberSceneType, String str) {
            this.f43939b = bVar;
            this.f43940c = memberSceneType;
            this.f43941d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(TaskCenterProvider taskCenterProvider, MemberSceneType memberSceneType, Object obj) {
            ok.c.f71157a.a(taskCenterProvider.j() + " --> checkMemberRights() --> sceneType = " + memberSceneType + " --> success");
            return Unit.f67184a;
        }

        @Override // zm.a
        public void a(MemberCheckResult memberCheckResult) {
            TaskCenterProvider.this.m(this.f43939b, memberCheckResult);
        }

        @Override // zm.a
        public void b(MemberCheckResult memberCheckResult) {
            new DownloadInterceptAdHelper(this.f43939b, memberCheckResult, this.f43941d, false, 8, null).h();
        }

        @Override // zm.a
        public void c(MemberCheckResult memberCheckResult) {
            a.C1007a.g(this, memberCheckResult);
            new TreasureStyleADialog().z0(memberCheckResult).x0(this.f43941d).A0(this.f43940c).y0(this.f43939b).k0(com.blankj.utilcode.util.a.b(), "TreasureStyleADialog");
        }

        @Override // zm.a
        public void d(MemberCheckResult memberCheckResult) {
            new DownloadInterceptAdHelper(this.f43939b, memberCheckResult, this.f43941d, false, 8, null).h();
        }

        @Override // zm.a
        public void e() {
            this.f43939b.onSuccess();
            ok.c.f71157a.a(TaskCenterProvider.this.j() + " --> checkMemberRights() --> passed() --> 会员权益通过验证 --> 继续下载任务");
            IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            if (iMemberApi != null) {
                OpType opType = OpType.OP_DOWNLOAD;
                final TaskCenterProvider taskCenterProvider = TaskCenterProvider.this;
                final MemberSceneType memberSceneType = this.f43940c;
                iMemberApi.n(opType, new Function1() { // from class: com.transsion.commercialization.task.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit h11;
                        h11 = TaskCenterProvider.a.h(TaskCenterProvider.this, memberSceneType, obj);
                        return h11;
                    }
                });
            }
        }

        @Override // zm.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C1007a.a(this, memberCheckResult);
            ok.c.f71157a.b(TaskCenterProvider.this.j() + " --> triggerDownload() --> showCheckMemberRights() --> notImplement() --> 当前类型没有实现");
        }

        @Override // zm.a
        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.C1007a.b(this, errorMsg);
            ok.c.f71157a.b(TaskCenterProvider.this.j() + " --> checkMemberRights() --> showCheckMemberRightsDialog() --> " + errorMsg);
            this.f43939b.onFail();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements zm.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ok.b f43943b;

        b(ok.b bVar) {
            this.f43943b = bVar;
        }

        @Override // zm.b
        public void a() {
            ok.c.f71157a.a(TaskCenterProvider.this.j() + " --> showMemberPage() --> checkMember() --> onFailed() --> 开通会员失败");
            ok.b bVar = this.f43943b;
            if (bVar != null) {
                bVar.onFail();
            }
        }

        @Override // zm.b
        public void onSuccess() {
            ok.c.f71157a.a(TaskCenterProvider.this.j() + " --> showMemberPage() --> checkMember() --> onSuccess() --> 开通会员成功，直接下载不需要做任务了");
            ok.b bVar = this.f43943b;
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    private final void i(ok.b bVar, Integer num, String str, MemberSceneType memberSceneType) {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.z(memberSceneType, num, new a(bVar, memberSceneType, str));
        }
    }

    private final com.transsion.commercialization.task.treasure.b k() {
        return (com.transsion.commercialization.task.treasure.b) this.f43937a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.commercialization.task.treasure.b l() {
        return (com.transsion.commercialization.task.treasure.b) zg.c.f79537e.a().h(com.transsion.commercialization.task.treasure.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(ok.b bVar, MemberCheckResult memberCheckResult) {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.w(com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG, memberCheckResult, new b(bVar));
        }
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public Object a(String str, String str2, boolean z10, Continuation continuation) {
        Activity b11 = com.blankj.utilcode.util.a.b();
        if (b11 != null) {
            new CheckLotteryLoadingDialog().x0(str, str2, z10).k0(b11, "CheckLotteryLoadingDialog");
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void b(FragmentActivity fragmentActivity, Function1 function1) {
        new MemberPageVideoTaskDialog().t0(function1).k0(fragmentActivity, "MemberPageVideoTaskDialog");
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void c(ok.b bVar) {
        new DownloadInterceptAdHelper(bVar, null, null, true, 6, null).h();
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void d(String genre, MemberCheckResult memberCheckResult, ok.b bVar) {
        Intrinsics.h(genre, "genre");
        new TreasureStyleADialog().z0(memberCheckResult).x0(genre).A0(MemberSceneType.SCENE_MULTIDL).y0(bVar).k0(com.blankj.utilcode.util.a.b(), "TreasureStyleADialog");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|(1:(1:11)(2:25|26))(3:27|28|(1:30))|12|(1:14)(1:24)|15|16|(2:18|19)(2:21|22)))|33|6|7|8|(0)(0)|12|(0)(0)|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x002c, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r9 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r9));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:11:0x0028, B:12:0x004c, B:14:0x0050, B:15:0x0058, B:28:0x0039), top: B:8:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036  */
    @Override // com.transsion.commercializationapi.ITaskCenterApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1
            if (r0 == 0) goto L14
            r0 = r9
            com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1 r0 = (com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1 r0 = new com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1
            r0.<init>(r8, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r7 = 0
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2c
            goto L4c
        L2c:
            r9 = move-exception
            goto L5d
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            kotlin.ResultKt.b(r9)
            kotlin.Result$Companion r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2c
            com.transsion.commercialization.task.treasure.b r1 = r8.k()     // Catch: java.lang.Throwable -> L2c
            r4.label = r2     // Catch: java.lang.Throwable -> L2c
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r9 = com.transsion.commercialization.task.treasure.b.a.b(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2c
            if (r9 != r0) goto L4c
            return r0
        L4c:
            com.tn.lib.net.bean.BaseDto r9 = (com.tn.lib.net.bean.BaseDto) r9     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto L57
            java.lang.Object r9 = r9.getData()     // Catch: java.lang.Throwable -> L2c
            com.transsion.bean.lottery.LotteryUserInfoEntity r9 = (com.transsion.bean.lottery.LotteryUserInfoEntity) r9     // Catch: java.lang.Throwable -> L2c
            goto L58
        L57:
            r9 = r7
        L58:
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)     // Catch: java.lang.Throwable -> L2c
            goto L67
        L5d:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.a(r9)
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)
        L67:
            java.lang.Throwable r0 = kotlin.Result.m1188exceptionOrNullimpl(r9)
            if (r0 != 0) goto L6f
            r7 = r9
            goto L8c
        L6f:
            ok.c r9 = ok.c.f71157a
            java.lang.String r1 = r8.j()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " --> getLotteryUserInfoEntity() --> it = "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r9.b(r0)
        L8c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.commercialization.task.TaskCenterProvider.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void f(Integer num, String str, ok.b listener, MemberSceneType sceneType) {
        Intrinsics.h(listener, "listener");
        Intrinsics.h(sceneType, "sceneType");
        ok.c.f71157a.b(j() + " --> interception() --> resolution = " + num + " -- genre = " + str + " -- sceneType = " + sceneType.getValue());
        i(listener, num, str, sceneType);
    }

    public final String j() {
        String simpleName = TaskCenterProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}
