package com.transsion.ad.test.ad_config;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.test.ad_config.TestAdPlansActivity;
import java.util.List;
import ji.x;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4", f = "TestAdPlansActivity.kt", l = {64}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class TestAdPlansActivity$onCreate$4 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestAdPlansActivity.AdPlansAdapter $mAdPlanAdapter;
    int label;
    final /* synthetic */ TestAdPlansActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1", f = "TestAdPlansActivity.kt", l = {RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH, 66}, m = "invokeSuspend")
    /* renamed from: com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ TestAdPlansActivity.AdPlansAdapter $mAdPlanAdapter;
        int label;
        final /* synthetic */ TestAdPlansActivity this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
        @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1$1", f = "TestAdPlansActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C05991 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<MbAdDbPlans> $allAdPlans;
            final /* synthetic */ TestAdPlansActivity.AdPlansAdapter $mAdPlanAdapter;
            int label;
            final /* synthetic */ TestAdPlansActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C05991(TestAdPlansActivity.AdPlansAdapter adPlansAdapter, List<MbAdDbPlans> list, TestAdPlansActivity testAdPlansActivity, Continuation<? super C05991> continuation) {
                super(2, continuation);
                this.$mAdPlanAdapter = adPlansAdapter;
                this.$allAdPlans = list;
                this.this$0 = testAdPlansActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C05991(this.$mAdPlanAdapter, this.$allAdPlans, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                return ((C05991) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                x xVar;
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$mAdPlanAdapter.n1(this.$allAdPlans);
                List<MbAdDbPlans> list = this.$allAdPlans;
                x xVar2 = null;
                String str = "计划数量 = " + (list != null ? Boxing.d(list.size()) : null);
                xVar = this.this$0.binding;
                if (xVar == null) {
                    Intrinsics.z("binding");
                } else {
                    xVar2 = xVar;
                }
                xVar2.f66314d.setText(str);
                return Unit.f67184a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TestAdPlansActivity.AdPlansAdapter adPlansAdapter, TestAdPlansActivity testAdPlansActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mAdPlanAdapter = adPlansAdapter;
            this.this$0 = testAdPlansActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$mAdPlanAdapter, this.this$0, continuation);
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
                AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f42207a;
                this.label = 1;
                obj = AdPlansStorageManager.m(adPlansStorageManager, null, this, 1, null);
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
            C05991 c05991 = new C05991(this.$mAdPlanAdapter, (List) obj, this.this$0, null);
            this.label = 2;
            if (kotlinx.coroutines.i.g(c11, c05991, this) == f11) {
                return f11;
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdPlansActivity$onCreate$4(TestAdPlansActivity.AdPlansAdapter adPlansAdapter, TestAdPlansActivity testAdPlansActivity, Continuation<? super TestAdPlansActivity$onCreate$4> continuation) {
        super(2, continuation);
        this.$mAdPlanAdapter = adPlansAdapter;
        this.this$0 = testAdPlansActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdPlansActivity$onCreate$4(this.$mAdPlanAdapter, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TestAdPlansActivity$onCreate$4) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            i0 b11 = y0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mAdPlanAdapter, this.this$0, null);
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
