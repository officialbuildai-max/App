package com.transsion.postdetail.ui.fragment.preload;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1", f = "ShortTvVideoImmersiveDataLoader.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class ShortTvVideoImmersiveDataLoader$loadDataFromService$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShortTvVideoImmersiveDataLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/ShortTVRespData;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$1", f = "ShortTvVideoImmersiveDataLoader.kt", l = {33, 35, 37, 39}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShortTvVideoImmersiveDataLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = shortTvVideoImmersiveDataLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r9.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                goto L22
            L16:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1e:
                java.lang.Object r0 = r9.L$0
                kotlinx.coroutines.flow.c r0 = (kotlinx.coroutines.flow.c) r0
            L22:
                kotlin.ResultKt.b(r10)
                goto L97
            L26:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                kotlin.ResultKt.b(r10)
                goto L64
            L2e:
                kotlin.ResultKt.b(r10)
                java.lang.Object r10 = r9.L$0
                r1 = r10
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                bh.b$a r10 = bh.b.f16553a
                com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader r7 = r9.this$0
                com.transsion.postdetail.viewmodel.ImmVideoRequestEntity r7 = r7.n()
                java.lang.String r7 = com.blankj.utilcode.util.o.j(r7)
                java.lang.String r8 = "toJson(...)"
                kotlin.jvm.internal.Intrinsics.g(r7, r8)
                okhttp3.RequestBody r10 = r10.a(r7)
                if (r10 == 0) goto L8c
                com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader r2 = r9.this$0
                xo.d r2 = com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader.l(r2)
                vg.a$a r7 = vg.a.f77447a
                java.lang.String r7 = r7.a()
                r9.L$0 = r1
                r9.label = r5
                java.lang.Object r10 = r2.d(r7, r10, r9)
                if (r10 != r0) goto L64
                return r0
            L64:
                com.tn.lib.net.bean.BaseDto r10 = (com.tn.lib.net.bean.BaseDto) r10
                java.lang.String r2 = r10.getCode()
                java.lang.String r5 = "0"
                boolean r2 = kotlin.jvm.internal.Intrinsics.c(r2, r5)
                if (r2 != 0) goto L7d
                r9.L$0 = r1
                r9.label = r4
                java.lang.Object r10 = r1.emit(r6, r9)
                if (r10 != r0) goto L97
                return r0
            L7d:
                java.lang.Object r10 = r10.getData()
                r9.L$0 = r1
                r9.label = r3
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L97
                return r0
            L8c:
                r9.L$0 = r6
                r9.label = r2
                java.lang.Object r10 = r1.emit(r6, r9)
                if (r10 != r0) goto L97
                return r0
            L97:
                kotlin.Unit r10 = kotlin.Unit.f67184a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/ShortTVRespData;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$2", f = "ShortTvVideoImmersiveDataLoader.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$2, reason: invalid class name */
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/ShortTVRespData;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$3", f = "ShortTvVideoImmersiveDataLoader.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShortTvVideoImmersiveDataLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.this$0 = shortTvVideoImmersiveDataLoader;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
            anonymousClass3.L$0 = th2;
            return anonymousClass3.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Throwable th2 = (Throwable) this.L$0;
            a.C0856a c0856a = lg.a.f68962a;
            String b11 = this.this$0.b();
            Intrinsics.g(b11, "<get-TAG>(...)");
            a.C0856a.f(c0856a, b11, String.valueOf(th2.getMessage()), false, 4, null);
            this.this$0.c(null);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass4 implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShortTvVideoImmersiveDataLoader f49838a;

        AnonymousClass4(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader) {
            this.f49838a = shortTvVideoImmersiveDataLoader;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(com.transsion.moviedetailapi.bean.ShortTVRespData r5, kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1 r0 = (com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1 r0 = new com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r5 = r0.L$0
                com.transsion.moviedetailapi.bean.ShortTVRespData r5 = (com.transsion.moviedetailapi.bean.ShortTVRespData) r5
                kotlin.ResultKt.b(r6)
                goto L45
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                kotlin.ResultKt.b(r6)
                com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader r6 = r4.f49838a
                r0.L$0 = r5
                r0.label = r3
                java.lang.Object r6 = com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader.m(r6, r5, r0)
                if (r6 != r1) goto L45
                return r1
            L45:
                com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader r6 = r4.f49838a
                r6.d(r5)
                kotlin.Unit r5 = kotlin.Unit.f67184a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1.AnonymousClass4.emit(com.transsion.moviedetailapi.bean.ShortTVRespData, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoImmersiveDataLoader$loadDataFromService$1(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader, Continuation<? super ShortTvVideoImmersiveDataLoader$loadDataFromService$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvVideoImmersiveDataLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvVideoImmersiveDataLoader$loadDataFromService$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvVideoImmersiveDataLoader$loadDataFromService$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, null)), y0.b()), new AnonymousClass2(null)), new AnonymousClass3(this.this$0, null));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0);
            this.label = 1;
            if (f12.a(anonymousClass4, this) == f11) {
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
