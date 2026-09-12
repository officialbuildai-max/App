package com.transsion.edcation.list;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.edcation.CourseManager;
import com.transsion.moviedetailapi.bean.Pager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
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
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2", f = "MyCourseListFragment.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class MyCourseListFragment$initViewModel$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyCourseListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1", f = "MyCourseListFragment.kt", l = {73}, m = "invokeSuspend")
    /* renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MyCourseListFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/transsion/moviedetailapi/bean/Pager;"}, k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1$1", f = "MyCourseListFragment.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C06191 extends SuspendLambda implements Function2<Pager, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MyCourseListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C06191(MyCourseListFragment myCourseListFragment, Continuation<? super C06191> continuation) {
                super(2, continuation);
                this.this$0 = myCourseListFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C06191 c06191 = new C06191(this.this$0, continuation);
                c06191.L$0 = obj;
                return c06191;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Pager pager, Continuation<? super Unit> continuation) {
                return ((C06191) create(pager, continuation)).invokeSuspend(Unit.f67184a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Pager pager = (Pager) this.L$0;
                if (pager != null) {
                    MyCourseListFragment myCourseListFragment = this.this$0;
                    if (Intrinsics.c(pager.getHasMore(), Boxing.a(true))) {
                        String nextPage = pager.getNextPage();
                        if (nextPage == null) {
                            nextPage = "1";
                        }
                        myCourseListFragment.mPageNum = nextPage;
                        myCourseListFragment.B0();
                    } else {
                        BaseListFragment.D0(myCourseListFragment, false, 1, null);
                    }
                }
                if (this.this$0.A0()) {
                    this.this$0.I0(false);
                }
                return Unit.f67184a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MyCourseListFragment myCourseListFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = myCourseListFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
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
                x0 j11 = CourseManager.f44139a.j();
                C06191 c06191 = new C06191(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.d.i(j11, c06191, this) == f11) {
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
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyCourseListFragment$initViewModel$2(MyCourseListFragment myCourseListFragment, Continuation<? super MyCourseListFragment$initViewModel$2> continuation) {
        super(2, continuation);
        this.this$0 = myCourseListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyCourseListFragment$initViewModel$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MyCourseListFragment$initViewModel$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Lifecycle lifecycle = this.this$0.getLifecycle();
            Intrinsics.g(lifecycle, "<get-lifecycle>(...)");
            Lifecycle.State state = Lifecycle.State.RESUMED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == f11) {
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
