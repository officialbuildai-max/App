package com.transsion.ad.test.ad_config;

import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.test.ad_config.TestAdPsOfferActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import ji.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import mi.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2", f = "TestAdPsOfferActivity.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class TestAdPsOfferActivity$onCreate$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestAdPsOfferActivity.a $mAdPlanAdapter;
    int label;
    final /* synthetic */ TestAdPsOfferActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1", f = "TestAdPsOfferActivity.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE, 50}, m = "invokeSuspend")
    /* renamed from: com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ TestAdPsOfferActivity.a $mAdPlanAdapter;
        int label;
        final /* synthetic */ TestAdPsOfferActivity this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
        @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1$1", f = "TestAdPsOfferActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C06001 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<PsLinkAdPlan> $allPslink;
            final /* synthetic */ TestAdPsOfferActivity.a $mAdPlanAdapter;
            int label;
            final /* synthetic */ TestAdPsOfferActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C06001(TestAdPsOfferActivity.a aVar, List<PsLinkAdPlan> list, TestAdPsOfferActivity testAdPsOfferActivity, Continuation<? super C06001> continuation) {
                super(2, continuation);
                this.$mAdPlanAdapter = aVar;
                this.$allPslink = list;
                this.this$0 = testAdPsOfferActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C06001(this.$mAdPlanAdapter, this.$allPslink, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                return ((C06001) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                y yVar;
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$mAdPlanAdapter.n1(this.$allPslink);
                List<PsLinkAdPlan> list = this.$allPslink;
                y yVar2 = null;
                String str = "计划数量 = " + (list != null ? Boxing.d(list.size()) : null);
                yVar = this.this$0.binding;
                if (yVar == null) {
                    Intrinsics.z("binding");
                } else {
                    yVar2 = yVar;
                }
                yVar2.f66320f.setText(str);
                return Unit.f67184a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TestAdPsOfferActivity testAdPsOfferActivity, TestAdPsOfferActivity.a aVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = testAdPsOfferActivity;
            this.$mAdPlanAdapter = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$mAdPlanAdapter, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                l A0 = MbAdDatabase.INSTANCE.b(this.this$0).A0();
                this.label = 1;
                obj = A0.a(this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f67184a;
                }
                ResultKt.b(obj);
            }
            a2 c11 = y0.c();
            C06001 c06001 = new C06001(this.$mAdPlanAdapter, (List) obj, this.this$0, null);
            this.label = 2;
            if (kotlinx.coroutines.i.g(c11, c06001, this) == f11) {
                return f11;
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdPsOfferActivity$onCreate$2(TestAdPsOfferActivity testAdPsOfferActivity, TestAdPsOfferActivity.a aVar, Continuation<? super TestAdPsOfferActivity$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = testAdPsOfferActivity;
        this.$mAdPlanAdapter = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdPsOfferActivity$onCreate$2(this.this$0, this.$mAdPlanAdapter, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TestAdPsOfferActivity$onCreate$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            i0 b11 = y0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$mAdPlanAdapter, null);
            this.label = 1;
            if (kotlinx.coroutines.i.g(b11, anonymousClass1, this) == f11) {
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
