package com.transsion.ugcvideodetail.viewmodel;

import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$loadHistory$1", f = "UGCVideoDetailViewModel.kt", l = {177}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class UGCVideoDetailViewModel$loadHistory$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ugcVideoId;
    int label;
    final /* synthetic */ UGCVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/baselib/db/video/UGCVideoDetailPlayBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$loadHistory$1$1", f = "UGCVideoDetailViewModel.kt", l = {159, 161, 162, 164, 166, 169, 172}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$loadHistory$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $ugcVideoId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ UGCVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UGCVideoDetailViewModel uGCVideoDetailViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = uGCVideoDetailViewModel;
            this.$ugcVideoId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$ugcVideoId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
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
                switch(r1) {
                    case 0: goto L33;
                    case 1: goto L2b;
                    case 2: goto L23;
                    case 3: goto L1b;
                    case 4: goto L12;
                    case 5: goto L12;
                    case 6: goto L16;
                    case 7: goto L16;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L12:
                java.lang.Object r0 = r5.L$0
                kotlinx.coroutines.flow.c r0 = (kotlinx.coroutines.flow.c) r0
            L16:
                kotlin.ResultKt.b(r6)
                goto Lb1
            L1b:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                kotlin.ResultKt.b(r6)
                goto L7d
            L23:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                kotlin.ResultKt.b(r6)
                goto L67
            L2b:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                kotlin.ResultKt.b(r6)
                goto L4f
            L33:
                kotlin.ResultKt.b(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel r6 = r5.this$0
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao r6 = r6.K()
                java.lang.String r3 = r5.$ugcVideoId
                r5.L$0 = r1
                r4 = 1
                r5.label = r4
                java.lang.Object r6 = r6.r(r3, r5)
                if (r6 != r0) goto L4f
                return r0
            L4f:
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r6 = (com.transsion.baselib.db.video.UGCVideoDetailPlayBean) r6
                if (r6 != 0) goto La5
                com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel r6 = r5.this$0
                com.transsion.baselib.db.video.UGCCollectionVideoGroupDao r6 = r6.z()
                java.lang.String r3 = r5.$ugcVideoId
                r5.L$0 = r1
                r4 = 2
                r5.label = r4
                java.lang.Object r6 = r6.c(r3, r5)
                if (r6 != r0) goto L67
                return r0
            L67:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 == 0) goto L99
                com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel r3 = r5.this$0
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao r3 = r3.K()
                r5.L$0 = r1
                r4 = 3
                r5.label = r4
                java.lang.Object r6 = r3.c(r6, r5)
                if (r6 != r0) goto L7d
                return r0
            L7d:
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r6 = (com.transsion.baselib.db.video.UGCVideoDetailPlayBean) r6
                if (r6 != 0) goto L8d
                r5.L$0 = r1
                r6 = 4
                r5.label = r6
                java.lang.Object r6 = r1.emit(r2, r5)
                if (r6 != r0) goto Lb1
                return r0
            L8d:
                r5.L$0 = r1
                r2 = 5
                r5.label = r2
                java.lang.Object r6 = r1.emit(r6, r5)
                if (r6 != r0) goto Lb1
                return r0
            L99:
                r5.L$0 = r2
                r6 = 6
                r5.label = r6
                java.lang.Object r6 = r1.emit(r2, r5)
                if (r6 != r0) goto Lb1
                return r0
            La5:
                r5.L$0 = r2
                r2 = 7
                r5.label = r2
                java.lang.Object r6 = r1.emit(r6, r5)
                if (r6 != r0) goto Lb1
                return r0
            Lb1:
                kotlin.Unit r6 = kotlin.Unit.f67184a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$loadHistory$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/baselib/db/video/UGCVideoDetailPlayBean;", "", "e", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$loadHistory$1$2", f = "UGCVideoDetailViewModel.kt", l = {176}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$loadHistory$1$2, reason: invalid class name */
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
        final /* synthetic */ UGCVideoDetailViewModel f56596a;

        a(UGCVideoDetailViewModel uGCVideoDetailViewModel) {
            this.f56596a = uGCVideoDetailViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
            this.f56596a.Y().q(uGCVideoDetailPlayBean);
            this.f56596a.H().q(uGCVideoDetailPlayBean);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCVideoDetailViewModel$loadHistory$1(UGCVideoDetailViewModel uGCVideoDetailViewModel, String str, Continuation<? super UGCVideoDetailViewModel$loadHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCVideoDetailViewModel;
        this.$ugcVideoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCVideoDetailViewModel$loadHistory$1(this.this$0, this.$ugcVideoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCVideoDetailViewModel$loadHistory$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, this.$ugcVideoId, null)), y0.b()), new AnonymousClass2(null));
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
