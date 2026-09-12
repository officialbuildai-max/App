package com.transsion.ugcvideodetail.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1", f = "UGCImmVideoDetailViewModel.kt", l = {199}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ Ref.ObjectRef<String> $curUgcVideoId;
    final /* synthetic */ String $ugcVideoId;
    int label;
    final /* synthetic */ UGCImmVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006*(\u0012$\u0012\"\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lkotlin/Triple;", "", "Lcom/transsion/baselib/db/video/UGCVideoDetailPlayBean;", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1$1", f = "UGCImmVideoDetailViewModel.kt", l = {174, 177, 178, 180, 182, 185, 187, 193, 194}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ Ref.ObjectRef<String> $curUgcVideoId;
        final /* synthetic */ String $ugcVideoId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ UGCImmVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str2, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$collectionId = str;
            this.this$0 = uGCImmVideoDetailViewModel;
            this.$ugcVideoId = str2;
            this.$curUgcVideoId = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$collectionId, this.this$0, this.$ugcVideoId, this.$curUgcVideoId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0169 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x014f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01a7  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x019d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x019e  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x017f A[RETURN] */
        /* JADX WARN: Type inference failed for: r1v17, types: [T, com.transsion.baselib.db.video.UGCVideoDetailPlayBean] */
        /* JADX WARN: Type inference failed for: r9v2, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 496
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b*(\u0012$\u0012\"\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lkotlin/Triple;", "", "Lcom/transsion/baselib/db/video/UGCVideoDetailPlayBean;", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1$2", f = "UGCImmVideoDetailViewModel.kt", l = {198}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = cVar;
            return anonymousClass2.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.c cVar = (kotlinx.coroutines.flow.c) this.L$0;
                this.label = 1;
                if (cVar.emit(null, this) == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1(String str, UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str2, Ref.ObjectRef<String> objectRef, Continuation<? super UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1> continuation) {
        super(2, continuation);
        this.$collectionId = str;
        this.this$0 = uGCImmVideoDetailViewModel;
        this.$ugcVideoId = str2;
        this.$curUgcVideoId = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1(this.$collectionId, this.this$0, this.$ugcVideoId, this.$curUgcVideoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$collectionId, this.this$0, this.$ugcVideoId, this.$curUgcVideoId, null)), y0.b()), new AnonymousClass2(null));
            final UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = this.this$0;
            final Ref.ObjectRef<String> objectRef = this.$curUgcVideoId;
            kotlinx.coroutines.flow.c cVar = new kotlinx.coroutines.flow.c() { // from class: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1.3
                /* JADX WARN: Removed duplicated region for block: B:108:0x0263  */
                /* JADX WARN: Removed duplicated region for block: B:112:0x028b  */
                /* JADX WARN: Removed duplicated region for block: B:126:0x02b8  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00d9  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00f3  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0107  */
                /* JADX WARN: Removed duplicated region for block: B:44:0x0159  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x015e  */
                /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x00d5  */
                /* JADX WARN: Removed duplicated region for block: B:51:0x00ca  */
                /* JADX WARN: Removed duplicated region for block: B:52:0x00ac  */
                /* JADX WARN: Removed duplicated region for block: B:53:0x0098  */
                @Override // kotlinx.coroutines.flow.c
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(kotlin.Triple r58, kotlin.coroutines.Continuation r59) {
                    /*
                        Method dump skipped, instructions count: 779
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1.AnonymousClass3.emit(kotlin.Triple, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.label = 1;
            if (f12.a(cVar, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
