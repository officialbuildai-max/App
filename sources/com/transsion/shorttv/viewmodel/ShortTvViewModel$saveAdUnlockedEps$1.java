package com.transsion.shorttv.viewmodel;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$saveAdUnlockedEps$1", f = "ShortTvViewModel.kt", l = {838}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTvViewModel$saveAdUnlockedEps$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<Integer> $eps;
    final /* synthetic */ String $subjectId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$saveAdUnlockedEps$1(String str, Set<Integer> set, ShortTvViewModel shortTvViewModel, Continuation<? super ShortTvViewModel$saveAdUnlockedEps$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$eps = set;
        this.this$0 = shortTvViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvViewModel$saveAdUnlockedEps$1 shortTvViewModel$saveAdUnlockedEps$1 = new ShortTvViewModel$saveAdUnlockedEps$1(this.$subjectId, this.$eps, this.this$0, continuation);
        shortTvViewModel$saveAdUnlockedEps$1.L$0 = obj;
        return shortTvViewModel$saveAdUnlockedEps$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$saveAdUnlockedEps$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
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
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> Lf
            goto L4d
        Lf:
            r15 = move-exception
            goto L56
        L11:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L19:
            kotlin.ResultKt.b(r15)
            java.lang.Object r15 = r14.L$0
            kotlinx.coroutines.n0 r15 = (kotlinx.coroutines.n0) r15
            java.lang.String r15 = r14.$subjectId
            java.util.Set<java.lang.Integer> r1 = r14.$eps
            com.transsion.shorttv.viewmodel.ShortTvViewModel r3 = r14.this$0
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lf
            com.transsion.shorttv.db.e r4 = new com.transsion.shorttv.db.e     // Catch: java.lang.Throwable -> Lf
            r5 = r1
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> Lf
            java.lang.String r6 = ","
            r12 = 62
            r13 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r1 = kotlin.collections.CollectionsKt.s0(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> Lf
            r4.<init>(r15, r1)     // Catch: java.lang.Throwable -> Lf
            com.transsion.shorttv.db.ShortTvAdUnlockDao r15 = com.transsion.shorttv.viewmodel.ShortTvViewModel.n(r3)     // Catch: java.lang.Throwable -> Lf
            if (r15 == 0) goto L50
            r14.label = r2     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r15 = r15.b(r4, r14)     // Catch: java.lang.Throwable -> Lf
            if (r15 != r0) goto L4d
            return r0
        L4d:
            kotlin.Unit r15 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> Lf
            goto L51
        L50:
            r15 = 0
        L51:
            java.lang.Object r15 = kotlin.Result.m1185constructorimpl(r15)     // Catch: java.lang.Throwable -> Lf
            goto L60
        L56:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r15 = kotlin.ResultKt.a(r15)
            java.lang.Object r15 = kotlin.Result.m1185constructorimpl(r15)
        L60:
            java.lang.Throwable r15 = kotlin.Result.m1188exceptionOrNullimpl(r15)
            if (r15 == 0) goto L81
            lg.a$a r0 = lg.a.f68962a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "saveAdUnlockedEps error: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = r1.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "ShortTvViewModel"
            r3 = 0
            lg.a.C0856a.l(r0, r1, r2, r3, r4, r5)
        L81:
            kotlin.Unit r15 = kotlin.Unit.f67184a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.viewmodel.ShortTvViewModel$saveAdUnlockedEps$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
