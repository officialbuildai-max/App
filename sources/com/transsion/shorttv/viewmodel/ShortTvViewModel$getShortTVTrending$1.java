package com.transsion.shorttv.viewmodel;

import com.transsion.shorttv.bean.ImmVideoRequestEntity;
import com.transsion.shorttv.bean.ShortTVRespData;
import com.transsion.shorttv.bean.Subject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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
@DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTVTrending$1", f = "ShortTvViewModel.kt", l = {1028}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTvViewModel$getShortTVTrending$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ ImmVideoRequestEntity $requestEntity;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/shorttv/bean/ShortTVRespData;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTVTrending$1$1", f = "ShortTvViewModel.kt", l = {1023, 1024}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTVTrending$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImmVideoRequestEntity $requestEntity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShortTvViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ImmVideoRequestEntity immVideoRequestEntity, ShortTvViewModel shortTvViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestEntity = immVideoRequestEntity;
            this.this$0 = shortTvViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestEntity, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x008a A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r12.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.b(r13)
                goto L8b
            L13:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1b:
                java.lang.Object r1 = r12.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                kotlin.ResultKt.b(r13)
                goto L79
            L23:
                kotlin.ResultKt.b(r13)
                java.lang.Object r13 = r12.L$0
                r1 = r13
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                bh.b$a r13 = bh.b.f16553a
                com.transsion.shorttv.bean.ImmVideoRequestEntity r4 = r12.$requestEntity
                java.lang.String r4 = com.blankj.utilcode.util.o.j(r4)
                java.lang.String r5 = "toJson(...)"
                kotlin.jvm.internal.Intrinsics.g(r4, r5)
                okhttp3.RequestBody r13 = r13.a(r4)
                if (r13 == 0) goto L8b
                com.transsion.shorttv.viewmodel.ShortTvViewModel r4 = r12.this$0
                lg.a$a r5 = lg.a.f68962a
                vg.a$a r11 = vg.a.f77447a
                java.lang.String r6 = r11.a()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "Trending  host:"
                r7.append(r8)
                r7.append(r6)
                java.lang.String r6 = "/wefeed-mobile-bff/shorts/most-trending"
                r7.append(r6)
                java.lang.String r7 = r7.toString()
                r9 = 4
                r10 = 0
                java.lang.String r6 = "ShortTvViewModel"
                r8 = 0
                lg.a.C0856a.f(r5, r6, r7, r8, r9, r10)
                os.a r4 = com.transsion.shorttv.viewmodel.ShortTvViewModel.t(r4)
                java.lang.String r5 = r11.a()
                r12.L$0 = r1
                r12.label = r3
                java.lang.Object r13 = r4.h(r5, r13, r12)
                if (r13 != r0) goto L79
                return r0
            L79:
                com.tn.lib.net.bean.BaseDto r13 = (com.tn.lib.net.bean.BaseDto) r13
                java.lang.Object r13 = r13.getData()
                r3 = 0
                r12.L$0 = r3
                r12.label = r2
                java.lang.Object r13 = r1.emit(r13, r12)
                if (r13 != r0) goto L8b
                return r0
            L8b:
                kotlin.Unit r13 = kotlin.Unit.f67184a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTVTrending$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/shorttv/bean/ShortTVRespData;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTVTrending$1$2", f = "ShortTvViewModel.kt", l = {1027}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv.viewmodel.ShortTvViewModel$getShortTVTrending$1$2, reason: invalid class name */
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
        final /* synthetic */ ShortTvViewModel f53764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f53765b;

        a(ShortTvViewModel shortTvViewModel, boolean z10) {
            this.f53764a = shortTvViewModel;
            this.f53765b = z10;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(ShortTVRespData shortTVRespData, Continuation continuation) {
            List<Subject> items;
            AtomicBoolean atomicBoolean;
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "ShortTvViewModel", "Trending 接口返回 " + shortTVRespData, false, 4, null);
            if (shortTVRespData != null && (items = shortTVRespData.getItems()) != null && !items.isEmpty()) {
                atomicBoolean = this.f53764a.f53734c;
                atomicBoolean.set(true);
            }
            if (shortTVRespData != null) {
                shortTVRespData.setRefresh(this.f53765b);
            }
            a.C0856a.f(c0856a, "ShortTvViewModel", "设置 TrendingLiveData, " + this.f53764a.K0(), false, 4, null);
            this.f53764a.K0().q(shortTVRespData);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$getShortTVTrending$1(ImmVideoRequestEntity immVideoRequestEntity, ShortTvViewModel shortTvViewModel, boolean z10, Continuation<? super ShortTvViewModel$getShortTVTrending$1> continuation) {
        super(2, continuation);
        this.$requestEntity = immVideoRequestEntity;
        this.this$0 = shortTvViewModel;
        this.$isRefresh = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$getShortTVTrending$1(this.$requestEntity, this.this$0, this.$isRefresh, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$getShortTVTrending$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$requestEntity, this.this$0, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0, this.$isRefresh);
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
