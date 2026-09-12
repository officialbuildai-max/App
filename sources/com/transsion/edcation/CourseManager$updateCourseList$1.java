package com.transsion.edcation;

import com.transsion.edcation.bean.CourseBean;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.y0;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.CourseManager$updateCourseList$1", f = "CourseManager.kt", l = {Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk$SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CourseManager$updateCourseList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CourseBean> $list;
    final /* synthetic */ String $page;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$updateCourseList$1(String str, List<CourseBean> list, Continuation<? super CourseManager$updateCourseList$1> continuation) {
        super(2, continuation);
        this.$page = str;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$updateCourseList$1(this.$page, this.$list, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CourseManager$updateCourseList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<CourseBean> list;
        List<CourseBean> list2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (Intrinsics.c(this.$page, "1")) {
                list = this.$list;
            } else {
                list = (List) CourseManager.f44139a.i().getValue();
                if (list == null) {
                    list = new ArrayList<>();
                }
                List<CourseBean> list3 = this.$list;
                if (list3 != null) {
                    list.addAll(list3);
                }
            }
            list2 = list;
            y0 i12 = CourseManager.f44139a.i();
            this.L$0 = list2;
            this.label = 1;
            if (i12.emit(list2, this) == f11) {
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
            list2 = (List) this.L$0;
            ResultKt.b(obj);
        }
        y0 m11 = CourseManager.f44139a.m();
        CourseBean courseBean = list2 != null ? (CourseBean) CollectionsKt.k0(list2) : null;
        this.L$0 = null;
        this.label = 2;
        if (m11.emit(courseBean, this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
