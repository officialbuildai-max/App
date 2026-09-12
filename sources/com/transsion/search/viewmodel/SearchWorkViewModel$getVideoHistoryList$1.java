package com.transsion.search.viewmodel;

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
@DebugMetadata(c = "com.transsion.search.viewmodel.SearchWorkViewModel$getVideoHistoryList$1", f = "SearchWorkViewModel.kt", l = {44}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchWorkViewModel$getVideoHistoryList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefreshAll;
    int label;
    final /* synthetic */ SearchWorkViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchWorkViewModel$getVideoHistoryList$1(boolean z10, SearchWorkViewModel searchWorkViewModel, Continuation<? super SearchWorkViewModel$getVideoHistoryList$1> continuation) {
        super(2, continuation);
        this.$isRefreshAll = z10;
        this.this$0 = searchWorkViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchWorkViewModel$getVideoHistoryList$1(this.$isRefreshAll, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SearchWorkViewModel$getVideoHistoryList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0065, code lost:
    
        if (r0 < r1) goto L21;
     */
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
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 != r3) goto L10
            kotlin.ResultKt.b(r6)
            goto L4d
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlin.ResultKt.b(r6)
            boolean r6 = r5.$isRefreshAll
            if (r6 == 0) goto L32
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            r6.m(r2)
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            com.transsion.search.viewmodel.SearchWorkViewModel.f(r6, r3)
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            java.util.List r6 = com.transsion.search.viewmodel.SearchWorkViewModel.c(r6)
            r6.clear()
        L32:
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            com.transsion.baselib.db.video.VideoDetailPlayDao r6 = com.transsion.search.viewmodel.SearchWorkViewModel.e(r6)
            com.transsion.search.viewmodel.SearchWorkViewModel r1 = r5.this$0
            int r1 = r1.i()
            com.transsion.search.viewmodel.SearchWorkViewModel r4 = r5.this$0
            int r4 = com.transsion.search.viewmodel.SearchWorkViewModel.d(r4)
            r5.label = r3
            java.lang.Object r6 = r6.d(r1, r4, r5)
            if (r6 != r0) goto L4d
            return r0
        L4d:
            java.util.List r6 = (java.util.List) r6
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L67
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L5b
            goto L67
        L5b:
            int r0 = r6.size()
            com.transsion.search.viewmodel.SearchWorkViewModel r1 = r5.this$0
            int r1 = com.transsion.search.viewmodel.SearchWorkViewModel.d(r1)
            if (r0 >= r1) goto L6c
        L67:
            com.transsion.search.viewmodel.SearchWorkViewModel r0 = r5.this$0
            com.transsion.search.viewmodel.SearchWorkViewModel.f(r0, r2)
        L6c:
            r0 = 0
            if (r6 == 0) goto L95
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L7a:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L96
            java.lang.Object r2 = r6.next()
            r3 = r2
            com.transsion.baselib.db.video.VideoDetailPlayBean r3 = (com.transsion.baselib.db.video.VideoDetailPlayBean) r3
            java.lang.String r3 = r3.getId()
            boolean r3 = android.text.TextUtils.isDigitsOnly(r3)
            if (r3 == 0) goto L7a
            r1.add(r2)
            goto L7a
        L95:
            r1 = r0
        L96:
            if (r1 == 0) goto La0
            int r6 = r1.size()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.d(r6)
        La0:
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            boolean r6 = r6.g()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "获取视频播放记录 数量： "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "，hasMore:"
            r2.append(r0)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            java.lang.String r0 = "SearchWork"
            android.util.Log.e(r0, r6)
            if (r1 != 0) goto Lc9
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        Lc9:
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            java.util.List r6 = com.transsion.search.viewmodel.SearchWorkViewModel.c(r6)
            r6.addAll(r1)
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            int r0 = r6.i()
            int r1 = r1.size()
            int r0 = r0 + r1
            r6.m(r0)
            com.transsion.search.viewmodel.SearchWorkViewModel r6 = r5.this$0
            androidx.lifecycle.b0 r6 = r6.h()
            com.transsion.search.viewmodel.SearchWorkViewModel r0 = r5.this$0
            java.util.List r0 = com.transsion.search.viewmodel.SearchWorkViewModel.c(r0)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.U0(r0)
            r6.n(r0)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.viewmodel.SearchWorkViewModel$getVideoHistoryList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
