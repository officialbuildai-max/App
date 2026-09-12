package com.transsion.edcation;

import android.util.Log;
import com.transsion.edcation.bean.CourseBody;
import com.transsion.edcation.c;
import com.transsion.moviedetailapi.bean.Subject;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lz.h;
import sg.d;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.CourseManager$subscribeCourse$1", f = "CourseManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CourseManager$subscribeCourse$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Subject $course;
    final /* synthetic */ Boolean $subscribeStatus;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements h {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44152a = new a();

        a() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m apply(Throwable it) {
            Intrinsics.h(it, "it");
            return j.l(it);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Subject f44153d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f44154e;

        b(Subject subject, int i11) {
            this.f44153d = subject;
            this.f44154e = i11;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error: ");
            sb2.append(str);
            sb2.append(", msg:");
            sb2.append(str2);
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.course_default_failed);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("data:");
            sb2.append(str);
            this.f44153d.setSeenStatus(Integer.valueOf(this.f44154e));
            CourseManager.f44139a.q(uk.a.a(this.f44153d));
            if (this.f44154e == 1) {
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.course_add_success);
            } else {
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.course_remove_success);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$subscribeCourse$1(Subject subject, Boolean bool, Continuation<? super CourseManager$subscribeCourse$1> continuation) {
        super(2, continuation);
        this.$course = subject;
        this.$subscribeStatus = bool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$subscribeCourse$1(this.$course, this.$subscribeStatus, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CourseManager$subscribeCourse$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        String subjectId;
        c l11;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Subject subject = this.$course;
        Boolean bool = this.$subscribeStatus;
        try {
            Result.Companion companion = Result.INSTANCE;
            subjectId = subject.getSubjectId();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (subjectId == null) {
            return Unit.f67184a;
        }
        ?? r32 = 0;
        r32 = 0;
        if (bool != null) {
            r32 = bool.booleanValue();
        } else {
            Integer seenStatus = subject.getSeenStatus();
            if (seenStatus != null && seenStatus.intValue() == 0) {
                r32 = 1;
            }
        }
        l11 = CourseManager.f44139a.l();
        c.a.d(l11, null, new CourseBody(subjectId, r32), 1, null).v(qz.a.c()).x(a.f44152a).f(d.f75472a.c()).subscribe(new b(subject, r32));
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        Unit unit = (Unit) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
        if (unit != null) {
            Log.e("subscribeCourse", "error: " + unit);
        }
        return Unit.f67184a;
    }
}
