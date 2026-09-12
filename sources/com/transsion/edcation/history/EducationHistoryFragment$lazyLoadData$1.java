package com.transsion.edcation.history;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1", f = "EducationHistoryFragment.kt", l = {72, 74}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class EducationHistoryFragment$lazyLoadData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EducationHistoryFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1$1", f = "EducationHistoryFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<VideoDetailPlayBean> $list;
        int label;
        final /* synthetic */ EducationHistoryFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EducationHistoryFragment educationHistoryFragment, List<VideoDetailPlayBean> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = educationHistoryFragment;
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$list, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
        
            r4 = r3.this$0.mAdapter;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r3.label
                if (r0 != 0) goto L58
                kotlin.ResultKt.b(r4)
                com.transsion.edcation.history.EducationHistoryFragment r4 = r3.this$0
                int r4 = com.transsion.edcation.history.EducationHistoryFragment.h0(r4)
                if (r4 <= 0) goto L22
                com.transsion.edcation.history.EducationHistoryFragment r4 = r3.this$0
                com.transsion.edcation.history.EducationHistoryAdapter r4 = com.transsion.edcation.history.EducationHistoryFragment.f0(r4)
                if (r4 == 0) goto L33
                java.util.List<com.transsion.baselib.db.video.VideoDetailPlayBean> r0 = r3.$list
                java.util.Collection r0 = (java.util.Collection) r0
                r4.n1(r0)
                goto L33
            L22:
                com.transsion.edcation.history.EducationHistoryFragment r4 = r3.this$0
                com.transsion.edcation.history.EducationHistoryAdapter r4 = com.transsion.edcation.history.EducationHistoryFragment.f0(r4)
                if (r4 == 0) goto L33
                com.transsion.edcation.history.EducationHistoryFragment r0 = r3.this$0
                android.view.View r0 = com.transsion.edcation.history.EducationHistoryFragment.e0(r0)
                r4.Y0(r0)
            L33:
                java.util.List<com.transsion.baselib.db.video.VideoDetailPlayBean> r4 = r3.$list
                int r4 = r4.size()
                com.transsion.edcation.history.EducationHistoryFragment r0 = r3.this$0
                int r0 = com.transsion.edcation.history.EducationHistoryFragment.g0(r0)
                if (r4 >= r0) goto L55
                com.transsion.edcation.history.EducationHistoryFragment r4 = r3.this$0
                com.transsion.edcation.history.EducationHistoryAdapter r4 = com.transsion.edcation.history.EducationHistoryFragment.f0(r4)
                if (r4 == 0) goto L55
                r6.f r4 = r4.h0()
                if (r4 == 0) goto L55
                r0 = 1
                r1 = 0
                r2 = 0
                r6.f.u(r4, r2, r0, r1)
            L55:
                kotlin.Unit r4 = kotlin.Unit.f67184a
                return r4
            L58:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EducationHistoryFragment$lazyLoadData$1(EducationHistoryFragment educationHistoryFragment, Continuation<? super EducationHistoryFragment$lazyLoadData$1> continuation) {
        super(2, continuation);
        this.this$0 = educationHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EducationHistoryFragment$lazyLoadData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((EducationHistoryFragment$lazyLoadData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            EducationHistoryFragment educationHistoryFragment = this.this$0;
            this.label = 1;
            obj = educationHistoryFragment.i0(true, this);
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
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (List) obj, null);
        this.label = 2;
        if (i.g(c11, anonymousClass1, this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
