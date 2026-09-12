package com.transsion.ugcvideodetail.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1", f = "UGCImmVideoDetailViewModel.kt", l = {303}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel$getFirstVideoDetail$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ String $ugcVideoId;
    int label;
    final /* synthetic */ UGCImmVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1$1", f = "UGCImmVideoDetailViewModel.kt", l = {327, 328, 330}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $ugcVideoId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ UGCImmVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = uGCImmVideoDetailViewModel;
            this.$ugcVideoId = str;
            this.$collectionId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$ugcVideoId, this.$collectionId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x008c A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r13.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L2f
                if (r1 == r4) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                kotlin.ResultKt.b(r14)
                goto L8d
            L17:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1f:
                java.lang.Object r1 = r13.L$0
                com.transsion.ugcvideodetail.api.bean.UGCVideo r1 = (com.transsion.ugcvideodetail.api.bean.UGCVideo) r1
                kotlin.ResultKt.b(r14)
                goto L7e
            L27:
                java.lang.Object r1 = r13.L$0
                kotlinx.coroutines.r0 r1 = (kotlinx.coroutines.r0) r1
                kotlin.ResultKt.b(r14)
                goto L6e
            L2f:
                kotlin.ResultKt.b(r14)
                java.lang.Object r14 = r13.L$0
                kotlinx.coroutines.n0 r14 = (kotlinx.coroutines.n0) r14
                kotlinx.coroutines.i0 r7 = kotlinx.coroutines.y0.b()
                com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1$1$detailDeferred$1 r9 = new com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1$1$detailDeferred$1
                com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel r1 = r13.this$0
                java.lang.String r6 = r13.$ugcVideoId
                java.lang.String r8 = r13.$collectionId
                r9.<init>(r1, r6, r8, r5)
                r10 = 2
                r11 = 0
                r8 = 0
                r6 = r14
                kotlinx.coroutines.r0 r1 = kotlinx.coroutines.i.b(r6, r7, r8, r9, r10, r11)
                kotlinx.coroutines.i0 r7 = kotlinx.coroutines.y0.b()
                com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1$1$playInfoDeferred$1 r9 = new com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1$1$playInfoDeferred$1
                com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel r6 = r13.this$0
                java.lang.String r8 = r13.$ugcVideoId
                r9.<init>(r6, r8, r5)
                r8 = 0
                r6 = r14
                kotlinx.coroutines.r0 r14 = kotlinx.coroutines.i.b(r6, r7, r8, r9, r10, r11)
                r13.L$0 = r14
                r13.label = r4
                java.lang.Object r1 = r1.i(r13)
                if (r1 != r0) goto L6b
                return r0
            L6b:
                r12 = r1
                r1 = r14
                r14 = r12
            L6e:
                com.transsion.ugcvideodetail.api.bean.UGCVideo r14 = (com.transsion.ugcvideodetail.api.bean.UGCVideo) r14
                r13.L$0 = r14
                r13.label = r3
                java.lang.Object r1 = r1.i(r13)
                if (r1 != r0) goto L7b
                return r0
            L7b:
                r12 = r1
                r1 = r14
                r14 = r12
            L7e:
                com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo r14 = (com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo) r14
                com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel r3 = r13.this$0
                r13.L$0 = r5
                r13.label = r2
                java.lang.Object r14 = com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel.z0(r3, r1, r14, r13)
                if (r14 != r0) goto L8d
                return r0
            L8d:
                kotlin.Unit r14 = kotlin.Unit.f67184a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetail$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoDetailViewModel$getFirstVideoDetail$1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, String str2, Continuation<? super UGCImmVideoDetailViewModel$getFirstVideoDetail$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCImmVideoDetailViewModel;
        this.$ugcVideoId = str;
        this.$collectionId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoDetailViewModel$getFirstVideoDetail$1(this.this$0, this.$ugcVideoId, this.$collectionId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoDetailViewModel$getFirstVideoDetail$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$ugcVideoId, this.$collectionId, null);
            this.label = 1;
            if (o0.e(anonymousClass1, this) == f11) {
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
