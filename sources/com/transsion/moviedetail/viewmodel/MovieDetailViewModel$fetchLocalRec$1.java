package com.transsion.moviedetail.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$fetchLocalRec$1", f = "MovieDetailViewModel.kt", l = {227}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class MovieDetailViewModel$fetchLocalRec$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isTablet;
    final /* synthetic */ int $page;
    final /* synthetic */ String $requestKey;
    final /* synthetic */ Integer $subjectType;
    final /* synthetic */ boolean $useName;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailViewModel$fetchLocalRec$1(boolean z10, String str, Integer num, int i11, boolean z11, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$fetchLocalRec$1> continuation) {
        super(2, continuation);
        this.$useName = z10;
        this.$requestKey = str;
        this.$subjectType = num;
        this.$page = i11;
        this.$isTablet = z11;
        this.this$0 = movieDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$fetchLocalRec$1(this.$useName, this.$requestKey, this.$subjectType, this.$page, this.$isTablet, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MovieDetailViewModel$fetchLocalRec$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x006a, code lost:
    
        if (r12.intValue() != r1) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:5:0x000e, B:6:0x00de, B:8:0x00e2, B:10:0x00ec, B:12:0x00f6, B:13:0x00fc, B:23:0x001e, B:26:0x006c, B:29:0x007e, B:32:0x0084, B:35:0x0093, B:37:0x009c, B:38:0x00a1, B:40:0x00c9, B:44:0x0091, B:46:0x0077, B:49:0x0066), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:5:0x000e, B:6:0x00de, B:8:0x00e2, B:10:0x00ec, B:12:0x00f6, B:13:0x00fc, B:23:0x001e, B:26:0x006c, B:29:0x007e, B:32:0x0084, B:35:0x0093, B:37:0x009c, B:38:0x00a1, B:40:0x00c9, B:44:0x0091, B:46:0x0077, B:49:0x0066), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:5:0x000e, B:6:0x00de, B:8:0x00e2, B:10:0x00ec, B:12:0x00f6, B:13:0x00fc, B:23:0x001e, B:26:0x006c, B:29:0x007e, B:32:0x0084, B:35:0x0093, B:37:0x009c, B:38:0x00a1, B:40:0x00c9, B:44:0x0091, B:46:0x0077, B:49:0x0066), top: B:2:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$fetchLocalRec$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
