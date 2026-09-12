package com.transsion.usercenter.profile.report;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
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
@DebugMetadata(c = "com.transsion.usercenter.profile.report.ReportViewModel$report$1", f = "ReportViewModel.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ReportViewModel$report$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ JsonObject $json;
    int label;
    final /* synthetic */ ReportViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/tn/lib/net/bean/BaseDto;", "", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.usercenter.profile.report.ReportViewModel$report$1$1", f = "ReportViewModel.kt", l = {40, 41}, m = "invokeSuspend")
    /* renamed from: com.transsion.usercenter.profile.report.ReportViewModel$report$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ JsonObject $json;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ReportViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JsonObject jsonObject, ReportViewModel reportViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$json = jsonObject;
            this.this$0 = reportViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$json, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[RETURN] */
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
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r7.L$0
                okhttp3.RequestBody r0 = (okhttp3.RequestBody) r0
                kotlin.ResultKt.b(r8)
                goto L70
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$1
                okhttp3.RequestBody r1 = (okhttp3.RequestBody) r1
                java.lang.Object r3 = r7.L$0
                kotlinx.coroutines.flow.c r3 = (kotlinx.coroutines.flow.c) r3
                kotlin.ResultKt.b(r8)
                goto L60
            L2a:
                kotlin.ResultKt.b(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.c r8 = (kotlinx.coroutines.flow.c) r8
                bh.b$a r1 = bh.b.f16553a
                com.google.gson.JsonObject r4 = r7.$json
                java.lang.String r4 = r4.toString()
                java.lang.String r5 = "toString(...)"
                kotlin.jvm.internal.Intrinsics.g(r4, r5)
                okhttp3.RequestBody r1 = r1.a(r4)
                if (r1 == 0) goto L70
                com.transsion.usercenter.profile.report.ReportViewModel r4 = r7.this$0
                com.transsion.usercenter.profile.report.b r4 = com.transsion.usercenter.profile.report.ReportViewModel.f(r4)
                vg.a$a r5 = vg.a.f77447a
                java.lang.String r5 = r5.a()
                r7.L$0 = r8
                r7.L$1 = r1
                r7.label = r3
                java.lang.Object r3 = r4.b(r5, r1, r7)
                if (r3 != r0) goto L5d
                return r0
            L5d:
                r6 = r3
                r3 = r8
                r8 = r6
            L60:
                com.tn.lib.net.bean.BaseDto r8 = (com.tn.lib.net.bean.BaseDto) r8
                r7.L$0 = r1
                r1 = 0
                r7.L$1 = r1
                r7.label = r2
                java.lang.Object r8 = r3.emit(r8, r7)
                if (r8 != r0) goto L70
                return r0
            L70:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.report.ReportViewModel$report$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/tn/lib/net/bean/BaseDto;", "", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.usercenter.profile.report.ReportViewModel$report$1$2", f = "ReportViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.usercenter.profile.report.ReportViewModel$report$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ReportViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ReportViewModel reportViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = reportViewModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(this.this$0, continuation).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.this$0.j().q(null);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportViewModel f57372a;

        a(ReportViewModel reportViewModel) {
            this.f57372a = reportViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(BaseDto baseDto, Continuation continuation) {
            this.f57372a.j().q(baseDto);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportViewModel$report$1(JsonObject jsonObject, ReportViewModel reportViewModel, Continuation<? super ReportViewModel$report$1> continuation) {
        super(2, continuation);
        this.$json = jsonObject;
        this.this$0 = reportViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReportViewModel$report$1(this.$json, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ReportViewModel$report$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$json, this.this$0, null)), y0.b()), new AnonymousClass2(this.this$0, null));
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
