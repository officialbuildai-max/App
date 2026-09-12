package com.transsion.edcation;

import com.transsion.edcation.bean.CourseBean;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lz.h;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.CourseManager$subscribeCourseById$1", f = "CourseManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CourseManager$subscribeCourseById$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $status;
    final /* synthetic */ String $subjectId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements h {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44155a = new a();

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
        final /* synthetic */ int f44156d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f44157e;

        b(int i11, String str) {
            this.f44156d = i11;
            this.f44157e = str;
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
            int i11 = this.f44156d;
            if (i11 == 0) {
                CourseManager.f44139a.q(new CourseBean(this.f44157e, null, i11, null, null, null, null, null, null, 0L, null, 2042, null));
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.course_remove_success);
            } else {
                CourseManager.s(CourseManager.f44139a, null, this.f44157e, 1, null);
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.course_add_success);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$subscribeCourseById$1(Integer num, String str, Continuation<? super CourseManager$subscribeCourseById$1> continuation) {
        super(2, continuation);
        this.$status = num;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$subscribeCourseById$1(this.$status, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CourseManager$subscribeCourseById$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r5.label
            if (r0 != 0) goto L84
            kotlin.ResultKt.b(r6)
            java.lang.Integer r6 = r5.$status
            java.lang.String r0 = r5.$subjectId
            r1 = 0
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L54
            r2 = 1
            if (r6 != 0) goto L15
            goto L1d
        L15:
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L54
            if (r6 != 0) goto L1d
            r6 = r2
            goto L1e
        L1d:
            r6 = 0
        L1e:
            com.transsion.edcation.CourseManager r3 = com.transsion.edcation.CourseManager.f44139a     // Catch: java.lang.Throwable -> L54
            com.transsion.edcation.c r3 = com.transsion.edcation.CourseManager.c(r3)     // Catch: java.lang.Throwable -> L54
            com.transsion.edcation.bean.CourseBody r4 = new com.transsion.edcation.bean.CourseBody     // Catch: java.lang.Throwable -> L54
            r4.<init>(r0, r6)     // Catch: java.lang.Throwable -> L54
            io.reactivex.rxjava3.core.j r2 = com.transsion.edcation.c.a.d(r3, r1, r4, r2, r1)     // Catch: java.lang.Throwable -> L54
            io.reactivex.rxjava3.core.Scheduler r3 = qz.a.c()     // Catch: java.lang.Throwable -> L54
            io.reactivex.rxjava3.core.j r2 = r2.v(r3)     // Catch: java.lang.Throwable -> L54
            com.transsion.edcation.CourseManager$subscribeCourseById$1$a r3 = com.transsion.edcation.CourseManager$subscribeCourseById$1.a.f44155a     // Catch: java.lang.Throwable -> L54
            io.reactivex.rxjava3.core.j r2 = r2.x(r3)     // Catch: java.lang.Throwable -> L54
            sg.d r3 = sg.d.f75472a     // Catch: java.lang.Throwable -> L54
            io.reactivex.rxjava3.core.n r3 = r3.c()     // Catch: java.lang.Throwable -> L54
            io.reactivex.rxjava3.core.j r2 = r2.f(r3)     // Catch: java.lang.Throwable -> L54
            com.transsion.edcation.CourseManager$subscribeCourseById$1$b r3 = new com.transsion.edcation.CourseManager$subscribeCourseById$1$b     // Catch: java.lang.Throwable -> L54
            r3.<init>(r6, r0)     // Catch: java.lang.Throwable -> L54
            r2.subscribe(r3)     // Catch: java.lang.Throwable -> L54
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r6 = kotlin.Result.m1185constructorimpl(r6)     // Catch: java.lang.Throwable -> L54
            goto L5f
        L54:
            r6 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.m1185constructorimpl(r6)
        L5f:
            boolean r0 = kotlin.Result.m1191isFailureimpl(r6)
            if (r0 == 0) goto L66
            goto L67
        L66:
            r1 = r6
        L67:
            kotlin.Unit r1 = (kotlin.Unit) r1
            if (r1 == 0) goto L81
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "error: "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "subscribeCourse"
            android.util.Log.e(r0, r6)
        L81:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        L84:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.edcation.CourseManager$subscribeCourseById$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
