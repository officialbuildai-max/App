package com.transsion.edcation;

import com.transsion.edcation.bean.CourseBean;
import com.transsion.edcation.bean.CourseListResp;
import com.transsion.moviedetailapi.bean.Pager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.CourseManager$refreshCourseList$2$onSuccess$1", f = "CourseManager.kt", l = {87}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class CourseManager$refreshCourseList$2$onSuccess$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ CourseListResp $data;
    final /* synthetic */ String $updateId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$refreshCourseList$2$onSuccess$1(CourseListResp courseListResp, String str, Continuation<? super CourseManager$refreshCourseList$2$onSuccess$1> continuation) {
        super(2, continuation);
        this.$data = courseListResp;
        this.$updateId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$refreshCourseList$2$onSuccess$1(this.$data, this.$updateId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CourseManager$refreshCourseList$2$onSuccess$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<CourseBean> items;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        Object obj2 = null;
        if (i11 == 0) {
            ResultKt.b(obj);
            x0 j11 = CourseManager.f44139a.j();
            CourseListResp courseListResp = this.$data;
            Pager pager = courseListResp != null ? courseListResp.getPager() : null;
            this.label = 1;
            if (j11.emit(pager, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        CourseListResp courseListResp2 = this.$data;
        if (courseListResp2 != null && (items = courseListResp2.getItems()) != null) {
            String str = this.$updateId;
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.c(((CourseBean) next).getSubjectId(), str)) {
                    obj2 = next;
                    break;
                }
            }
            CourseBean courseBean = (CourseBean) obj2;
            if (courseBean != null) {
                CourseManager.f44139a.q(courseBean);
            }
        }
        return Unit.f67184a;
    }
}
