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
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$fetchRec$1", f = "MovieDetailViewModel.kt", l = {193}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class MovieDetailViewModel$fetchRec$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isTablet;
    final /* synthetic */ int $page;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ Integer $subjectType;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailViewModel$fetchRec$1(String str, Integer num, int i11, boolean z10, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$fetchRec$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$subjectType = num;
        this.$page = i11;
        this.$isTablet = z10;
        this.this$0 = movieDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$fetchRec$1(this.$subjectId, this.$subjectType, this.$page, this.$isTablet, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MovieDetailViewModel$fetchRec$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0063, code lost:
    
        if (r1.intValue() != r4) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:5:0x000c, B:6:0x00be, B:8:0x00c2, B:10:0x00ce, B:12:0x00d8, B:13:0x00de, B:23:0x001c, B:26:0x0065, B:29:0x0077, B:32:0x007d, B:34:0x00a9, B:38:0x0070, B:41:0x005f), top: B:2:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$fetchRec$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
