package com.transsion.moviedetail.viewmodel;

import androidx.view.b0;
import com.transsion.moviedetailapi.bean.RoomBean;
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
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.HotViewModel$getRecommendRooms$1", f = "HotViewModel.kt", l = {173}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class HotViewModel$getRecommendRooms$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ HotViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/RoomBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.HotViewModel$getRecommendRooms$1$1", f = "HotViewModel.kt", l = {153, 164, 166, 168}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.viewmodel.HotViewModel$getRecommendRooms$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ HotViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HotViewModel hotViewModel, String str, int i11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = hotViewModel;
            this.$page = str;
            this.$perPage = i11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$page, this.$perPage, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                if (r2 == 0) goto L33
                if (r2 == r6) goto L2f
                if (r2 == r5) goto L25
                if (r2 == r4) goto L20
                if (r2 != r3) goto L18
                goto L20
            L18:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L20:
                kotlin.ResultKt.b(r19)
                goto Lbc
            L25:
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
                kotlin.ResultKt.b(r19)
                r5 = r19
                goto L94
            L2f:
                kotlin.ResultKt.b(r19)
                goto L4b
            L33:
                kotlin.ResultKt.b(r19)
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
                com.transsion.moviedetail.viewmodel.HotViewModel r8 = r0.this$0
                java.lang.String r8 = r8.f0()
                if (r8 != 0) goto L4e
                r0.label = r6
                java.lang.Object r2 = r2.emit(r7, r0)
                if (r2 != r1) goto L4b
                return r1
            L4b:
                kotlin.Unit r1 = kotlin.Unit.f67184a
                return r1
            L4e:
                okhttp3.RequestBody$Companion r6 = okhttp3.RequestBody.INSTANCE
                com.transsion.room.api.bean.RoomRequestEntity r17 = new com.transsion.room.api.bean.RoomRequestEntity
                java.lang.String r9 = r0.$page
                int r10 = r0.$perPage
                com.transsion.moviedetail.viewmodel.HotViewModel r8 = r0.this$0
                java.lang.String r14 = r8.f0()
                r15 = 24
                r16 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r8 = r17
                r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
                java.lang.String r8 = com.blankj.utilcode.util.o.j(r17)
                java.lang.String r9 = "toJson(...)"
                kotlin.jvm.internal.Intrinsics.g(r8, r9)
                okhttp3.MediaType$Companion r9 = okhttp3.MediaType.INSTANCE
                java.lang.String r10 = "application/json"
                okhttp3.MediaType r9 = r9.parse(r10)
                okhttp3.RequestBody r6 = r6.create(r8, r9)
                com.transsion.moviedetail.viewmodel.HotViewModel r8 = r0.this$0
                fn.a r8 = com.transsion.moviedetail.viewmodel.HotViewModel.V(r8)
                vg.a$a r9 = vg.a.f77447a
                java.lang.String r9 = r9.a()
                r0.L$0 = r2
                r0.label = r5
                java.lang.Object r5 = r8.b(r9, r6, r0)
                if (r5 != r1) goto L94
                return r1
            L94:
                com.tn.lib.net.bean.BaseDto r5 = (com.tn.lib.net.bean.BaseDto) r5
                java.lang.String r6 = r5.getCode()
                java.lang.String r8 = "0"
                boolean r6 = kotlin.jvm.internal.Intrinsics.c(r6, r8)
                if (r6 != 0) goto Lad
                r0.L$0 = r7
                r0.label = r4
                java.lang.Object r2 = r2.emit(r7, r0)
                if (r2 != r1) goto Lbc
                return r1
            Lad:
                java.lang.Object r4 = r5.getData()
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r2 = r2.emit(r4, r0)
                if (r2 != r1) goto Lbc
                return r1
            Lbc:
                kotlin.Unit r1 = kotlin.Unit.f67184a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.viewmodel.HotViewModel$getRecommendRooms$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/RoomBean;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.HotViewModel$getRecommendRooms$1$2", f = "HotViewModel.kt", l = {172}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.viewmodel.HotViewModel$getRecommendRooms$1$2, reason: invalid class name */
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
        final /* synthetic */ HotViewModel f47483a;

        a(HotViewModel hotViewModel) {
            this.f47483a = hotViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(RoomBean roomBean, Continuation continuation) {
            b0 b0Var;
            b0Var = this.f47483a.f47480p;
            b0Var.n(roomBean);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotViewModel$getRecommendRooms$1(HotViewModel hotViewModel, String str, int i11, Continuation<? super HotViewModel$getRecommendRooms$1> continuation) {
        super(2, continuation);
        this.this$0 = hotViewModel;
        this.$page = str;
        this.$perPage = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotViewModel$getRecommendRooms$1(this.this$0, this.$page, this.$perPage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HotViewModel$getRecommendRooms$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, this.$page, this.$perPage, null)), y0.b()), new AnonymousClass2(null));
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
