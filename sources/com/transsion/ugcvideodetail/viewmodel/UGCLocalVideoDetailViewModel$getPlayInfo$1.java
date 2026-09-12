package com.transsion.ugcvideodetail.viewmodel;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel$getPlayInfo$1", f = "UGCLocalVideoDetailViewModel.kt", l = {RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCLocalVideoDetailViewModel$getPlayInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resourceId;
    int label;
    final /* synthetic */ UGCLocalVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/baselib/db/download/DownloadBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel$getPlayInfo$1$1", f = "UGCLocalVideoDetailViewModel.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_BACKGROUND_BEFORE_IMPRESSION_VALUE, Sdk$SDKMetric.SDKMetricType.AD_VISIBILITY_VALUE, 61}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel$getPlayInfo$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $resourceId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ UGCLocalVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, UGCLocalVideoDetailViewModel uGCLocalVideoDetailViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$resourceId = str;
            this.this$0 = uGCLocalVideoDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$resourceId, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.b(r8)
                goto L8b
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$1
                com.transsion.baselib.db.download.DownloadBean r1 = (com.transsion.baselib.db.download.DownloadBean) r1
                java.lang.Object r3 = r7.L$0
                kotlinx.coroutines.flow.c r3 = (kotlinx.coroutines.flow.c) r3
                kotlin.ResultKt.b(r8)
                goto L70
            L2a:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                kotlin.ResultKt.b(r8)
                goto L4f
            L32:
                kotlin.ResultKt.b(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.c r8 = (kotlinx.coroutines.flow.c) r8
                com.transsnet.downloader.manager.DownloadEsHelper$a r1 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
                com.transsnet.downloader.manager.DownloadEsHelper r1 = r1.a()
                java.lang.String r5 = r7.$resourceId
                r7.L$0 = r8
                r7.label = r4
                java.lang.Object r1 = r1.p(r5, r7)
                if (r1 != r0) goto L4c
                return r0
            L4c:
                r6 = r1
                r1 = r8
                r8 = r6
            L4f:
                com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8
                if (r8 == 0) goto L7d
                java.lang.String r4 = r8.getUgcVideoId()
                if (r4 == 0) goto L7d
                com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel r5 = r7.this$0
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao r5 = com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel.c(r5)
                r7.L$0 = r1
                r7.L$1 = r8
                r7.label = r3
                java.lang.Object r3 = r5.r(r4, r7)
                if (r3 != r0) goto L6c
                return r0
            L6c:
                r6 = r1
                r1 = r8
                r8 = r3
                r3 = r6
            L70:
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r8 = (com.transsion.baselib.db.video.UGCVideoDetailPlayBean) r8
                if (r8 == 0) goto L7b
                long r4 = r8.getProgress()
                r1.setReadProgress(r4)
            L7b:
                r8 = r1
                r1 = r3
            L7d:
                r3 = 0
                r7.L$0 = r3
                r7.L$1 = r3
                r7.label = r2
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L8b
                return r0
            L8b:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel$getPlayInfo$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/baselib/db/download/DownloadBean;", "", "e", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel$getPlayInfo$1$2", f = "UGCLocalVideoDetailViewModel.kt", l = {64}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel$getPlayInfo$1$2, reason: invalid class name */
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
    /* loaded from: classes6.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UGCLocalVideoDetailViewModel f56560a;

        a(UGCLocalVideoDetailViewModel uGCLocalVideoDetailViewModel) {
            this.f56560a = uGCLocalVideoDetailViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(DownloadBean downloadBean, Continuation continuation) {
            this.f56560a.i().q(downloadBean);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCLocalVideoDetailViewModel$getPlayInfo$1(String str, UGCLocalVideoDetailViewModel uGCLocalVideoDetailViewModel, Continuation<? super UGCLocalVideoDetailViewModel$getPlayInfo$1> continuation) {
        super(2, continuation);
        this.$resourceId = str;
        this.this$0 = uGCLocalVideoDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCLocalVideoDetailViewModel$getPlayInfo$1(this.$resourceId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCLocalVideoDetailViewModel$getPlayInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$resourceId, this.this$0, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0);
            this.label = 1;
            if (f12.a(aVar, this) == f11) {
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
