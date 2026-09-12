package com.transsion.moviedetailapi;

import com.transsion.moviedetailapi.bean.LikeBean;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1", f = "AbsSubjectListViewModel.kt", l = {129}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class AbsSubjectListViewModel$like$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    final /* synthetic */ int $reqType;
    int label;
    final /* synthetic */ AbsSubjectListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/LikeBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$1", f = "AbsSubjectListViewModel.kt", l = {Sdk$SDKError.Reason.TPAT_ERROR_VALUE, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        final /* synthetic */ int $reqType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AbsSubjectListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i11, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$postId = str;
            this.$reqType = i11;
            this.this$0 = absSubjectListViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$postId, this.$reqType, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00a3 A[RETURN] */
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L27
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.b(r8)
                goto La4
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                java.lang.Object r1 = r7.L$1
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r7.L$0
                kotlinx.coroutines.flow.c r3 = (kotlinx.coroutines.flow.c) r3
                kotlin.ResultKt.b(r8)
                goto L85
            L27:
                kotlin.ResultKt.b(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.c r8 = (kotlinx.coroutines.flow.c) r8
                com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
                r1.<init>()
                java.lang.String r4 = "postId"
                java.lang.String r5 = r7.$postId
                r1.addProperty(r4, r5)
                int r4 = r7.$reqType
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.d(r4)
                java.lang.String r5 = "reqType"
                r1.addProperty(r5, r4)
                java.lang.String r4 = r7.$postId
                if (r4 == 0) goto L56
                ty.b$a r4 = ty.b.f76540a
                ty.b r4 = r4.a()
                int r5 = r7.$reqType
                java.lang.String r6 = r7.$postId
                r4.g(r5, r6)
            L56:
                bh.b$a r4 = bh.b.f16553a
                java.lang.String r1 = r1.toString()
                java.lang.String r5 = "toString(...)"
                kotlin.jvm.internal.Intrinsics.g(r1, r5)
                okhttp3.RequestBody r1 = r4.a(r1)
                if (r1 == 0) goto La4
                com.transsion.moviedetailapi.AbsSubjectListViewModel r4 = r7.this$0
                java.lang.String r5 = r7.$postId
                kn.a r4 = com.transsion.moviedetailapi.AbsSubjectListViewModel.i(r4)
                vg.a$a r6 = vg.a.f77447a
                java.lang.String r6 = r6.a()
                r7.L$0 = r8
                r7.L$1 = r5
                r7.label = r3
                java.lang.Object r1 = r4.c(r6, r1, r7)
                if (r1 != r0) goto L82
                return r0
            L82:
                r3 = r8
                r8 = r1
                r1 = r5
            L85:
                com.tn.lib.net.bean.BaseDto r8 = (com.tn.lib.net.bean.BaseDto) r8
                java.lang.Object r4 = r8.getData()
                com.transsion.moviedetailapi.bean.LikeBean r4 = (com.transsion.moviedetailapi.bean.LikeBean) r4
                if (r4 == 0) goto L92
                r4.setPostId(r1)
            L92:
                java.lang.Object r8 = r8.getData()
                r1 = 0
                r7.L$0 = r1
                r7.L$1 = r1
                r7.label = r2
                java.lang.Object r8 = r3.emit(r8, r7)
                if (r8 != r0) goto La4
                return r0
            La4:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/LikeBean;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$2", f = "AbsSubjectListViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            a.C0856a.g(lg.a.f68962a, "like error", false, 2, null);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f47516a = new a();

        a() {
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(LikeBean likeBean, Continuation continuation) {
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsSubjectListViewModel$like$1(String str, int i11, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super AbsSubjectListViewModel$like$1> continuation) {
        super(2, continuation);
        this.$postId = str;
        this.$reqType = i11;
        this.this$0 = absSubjectListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsSubjectListViewModel$like$1(this.$postId, this.$reqType, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AbsSubjectListViewModel$like$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$postId, this.$reqType, this.this$0, null)), y0.b()), new AnonymousClass2(null));
            a aVar = a.f47516a;
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
