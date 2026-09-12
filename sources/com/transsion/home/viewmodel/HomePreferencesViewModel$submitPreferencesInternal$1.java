package com.transsion.home.viewmodel;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.home.bean.HomePreferencesConfig;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.HomePreferencesViewModel$submitPreferencesInternal$1", f = "HomePreferencesViewModel.kt", l = {TTAdConstant.IMAGE_LIST_SIZE_CODE, TTAdConstant.VIDEO_INFO_CODE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HomePreferencesViewModel$submitPreferencesInternal$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomePreferencesConfig $config;
    final /* synthetic */ boolean $force;
    final /* synthetic */ String $labelId;
    final /* synthetic */ List<String> $normalized;
    final /* synthetic */ String $scene;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ HomePreferencesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePreferencesViewModel$submitPreferencesInternal$1(HomePreferencesViewModel homePreferencesViewModel, String str, List<String> list, boolean z10, HomePreferencesConfig homePreferencesConfig, String str2, Continuation<? super HomePreferencesViewModel$submitPreferencesInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = homePreferencesViewModel;
        this.$labelId = str;
        this.$normalized = list;
        this.$force = z10;
        this.$config = homePreferencesConfig;
        this.$scene = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomePreferencesViewModel$submitPreferencesInternal$1 homePreferencesViewModel$submitPreferencesInternal$1 = new HomePreferencesViewModel$submitPreferencesInternal$1(this.this$0, this.$labelId, this.$normalized, this.$force, this.$config, this.$scene, continuation);
        homePreferencesViewModel$submitPreferencesInternal$1.L$0 = obj;
        return homePreferencesViewModel$submitPreferencesInternal$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HomePreferencesViewModel$submitPreferencesInternal$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r0 = r8.L$1
            com.transsion.home.bean.HomePreferencesConfig r0 = (com.transsion.home.bean.HomePreferencesConfig) r0
            java.lang.Object r1 = r8.L$0
            com.transsion.home.viewmodel.HomePreferencesViewModel r1 = (com.transsion.home.viewmodel.HomePreferencesViewModel) r1
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L1a
            goto L71
        L1a:
            r9 = move-exception
            goto L97
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L25:
            boolean r1 = r8.Z$0
            java.lang.Object r3 = r8.L$1
            com.transsion.home.bean.HomePreferencesConfig r3 = (com.transsion.home.bean.HomePreferencesConfig) r3
            java.lang.Object r4 = r8.L$0
            com.transsion.home.viewmodel.HomePreferencesViewModel r4 = (com.transsion.home.viewmodel.HomePreferencesViewModel) r4
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L1a
            r9 = r4
            goto L5c
        L34:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.n0 r9 = (kotlinx.coroutines.n0) r9
            com.transsion.home.viewmodel.HomePreferencesViewModel r9 = r8.this$0
            java.lang.String r1 = r8.$labelId
            java.util.List<java.lang.String> r4 = r8.$normalized
            boolean r5 = r8.$force
            com.transsion.home.bean.HomePreferencesConfig r6 = r8.$config
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1a
            com.transsion.home.repository.HomePreferencesRepository r7 = com.transsion.home.viewmodel.HomePreferencesViewModel.k(r9)     // Catch: java.lang.Throwable -> L1a
            r8.L$0 = r9     // Catch: java.lang.Throwable -> L1a
            r8.L$1 = r6     // Catch: java.lang.Throwable -> L1a
            r8.Z$0 = r5     // Catch: java.lang.Throwable -> L1a
            r8.label = r3     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = r7.m(r1, r4, r8)     // Catch: java.lang.Throwable -> L1a
            if (r1 != r0) goto L5a
            return r0
        L5a:
            r1 = r5
            r3 = r6
        L5c:
            if (r1 != 0) goto L73
            com.transsion.home.repository.HomePreferencesRepository r1 = com.transsion.home.viewmodel.HomePreferencesViewModel.k(r9)     // Catch: java.lang.Throwable -> L1a
            r8.L$0 = r9     // Catch: java.lang.Throwable -> L1a
            r8.L$1 = r3     // Catch: java.lang.Throwable -> L1a
            r8.label = r2     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = r1.g(r3, r8)     // Catch: java.lang.Throwable -> L1a
            if (r1 != r0) goto L6f
            return r0
        L6f:
            r1 = r9
            r0 = r3
        L71:
            r3 = r0
            r9 = r1
        L73:
            boolean r0 = r3.isPopStyle()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L90
            java.lang.String r0 = r3.getRefreshType()     // Catch: java.lang.Throwable -> L1a
            com.transsion.home.bean.HomePreferencesRefreshType r1 = com.transsion.home.bean.HomePreferencesRefreshType.NO_REFRESH     // Catch: java.lang.Throwable -> L1a
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> L1a
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)     // Catch: java.lang.Throwable -> L1a
            if (r0 != 0) goto L90
            androidx.lifecycle.b0 r9 = r9.x()     // Catch: java.lang.Throwable -> L1a
            r9.n(r3)     // Catch: java.lang.Throwable -> L1a
        L90:
            kotlin.Unit r9 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)     // Catch: java.lang.Throwable -> L1a
            goto La1
        L97:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.a(r9)
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)
        La1:
            java.lang.String r0 = r8.$labelId
            java.lang.String r1 = r8.$scene
            java.lang.Throwable r9 = kotlin.Result.m1188exceptionOrNullimpl(r9)
            if (r9 == 0) goto Lda
            lg.a$a r2 = lg.a.f68962a
            java.lang.String r9 = r9.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "submitPreferences error, labelId="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ", scene="
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = ", msg="
            r3.append(r0)
            r3.append(r9)
            java.lang.String r4 = r3.toString()
            r6 = 4
            r7 = 0
            java.lang.String r3 = "HomePreferencesViewModel"
            r5 = 0
            lg.a.C0856a.l(r2, r3, r4, r5, r6, r7)
        Lda:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.viewmodel.HomePreferencesViewModel$submitPreferencesInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
