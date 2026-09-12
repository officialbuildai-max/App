package com.transsion.home.adapter.suboperate.provider;

import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1", f = "SubFeedsEducationProvider.kt", l = {168}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class SubFeedsEducationProvider$MyViewHolder$registerCourse$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubFeedsEducationProvider.MyViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFeedsEducationProvider$MyViewHolder$registerCourse$1(SubFeedsEducationProvider.MyViewHolder myViewHolder, Continuation<? super SubFeedsEducationProvider$MyViewHolder$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = myViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubFeedsEducationProvider$MyViewHolder$registerCourse$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubFeedsEducationProvider$MyViewHolder$registerCourse$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            x0 k11 = CourseManager.f44139a.k();
            final SubFeedsEducationProvider.MyViewHolder myViewHolder = this.this$0;
            kotlinx.coroutines.flow.c cVar = new kotlinx.coroutines.flow.c() { // from class: com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1.1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
                @DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1$1$1", f = "SubFeedsEducationProvider.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes5.dex */
                public static final class C06231 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ SubFeedsEducationProvider.MyViewHolder this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C06231(SubFeedsEducationProvider.MyViewHolder myViewHolder, Continuation<? super C06231> continuation) {
                        super(2, continuation);
                        this.this$0 = myViewHolder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C06231(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
                        return ((C06231) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        this.this$0.k();
                        return Unit.f67184a;
                    }
                }

                @Override // kotlinx.coroutines.flow.c
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(CourseBean courseBean, Continuation continuation) {
                    OperateItem operateItem;
                    OperateItem operateItem2;
                    Subject feedsSubject;
                    Subject feedsSubject2;
                    operateItem = SubFeedsEducationProvider.MyViewHolder.this.mCurrentItem;
                    if (!Intrinsics.c((operateItem == null || (feedsSubject2 = operateItem.getFeedsSubject()) == null) ? null : feedsSubject2.getSubjectId(), courseBean.getSubjectId())) {
                        return Unit.f67184a;
                    }
                    operateItem2 = SubFeedsEducationProvider.MyViewHolder.this.mCurrentItem;
                    if (operateItem2 != null && (feedsSubject = operateItem2.getFeedsSubject()) != null) {
                        feedsSubject.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                    }
                    Object g11 = kotlinx.coroutines.i.g(y0.c(), new C06231(SubFeedsEducationProvider.MyViewHolder.this, null), continuation);
                    return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
                }
            };
            this.label = 1;
            if (k11.a(cVar, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
