package com.transsion.edcation;

import androidx.fragment.app.FragmentManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.edcation.bean.CourseListResp;
import com.transsion.edcation.c;
import com.transsion.edcation.dialog.InterestSelectDialog;
import com.transsion.moviedetailapi.bean.Subject;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.flow.y0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import lz.h;
import sg.d;

/* loaded from: classes5.dex */
public final class CourseManager implements n0 {

    /* renamed from: i, reason: collision with root package name */
    private static t1 f44147i;

    /* renamed from: a, reason: collision with root package name */
    public static final CourseManager f44139a = new CourseManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f44140b = LazyKt.b(new Function0() { // from class: com.transsion.edcation.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            c p11;
            p11 = CourseManager.p();
            return p11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f44141c = LazyKt.b(new Function0() { // from class: com.transsion.edcation.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean o11;
            o11 = CourseManager.o();
            return Boolean.valueOf(o11);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static boolean f44142d = true;

    /* renamed from: e, reason: collision with root package name */
    private static final x0 f44143e = d1.b(0, 0, null, 7, null);

    /* renamed from: f, reason: collision with root package name */
    private static final y0 f44144f = j1.a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final y0 f44145g = j1.a(new ArrayList());

    /* renamed from: h, reason: collision with root package name */
    private static final x0 f44146h = d1.b(0, 0, null, 7, null);

    /* renamed from: j, reason: collision with root package name */
    private static final CoroutineContext f44148j = kotlinx.coroutines.y0.b().plus(l2.b(null, 1, null));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements h {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44149a = new a();

        a() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m apply(Throwable it) {
            Intrinsics.h(it, "it");
            return j.l(it);
        }
    }

    private CourseManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c l() {
        return (c) f44140b.getValue();
    }

    private final boolean n() {
        return ((Boolean) f44141c.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o() {
        return com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("edu_interest_dialog", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c p() {
        return (c) zg.c.f79537e.a().h(c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(CourseBean courseBean) {
        t1 d11;
        t1 t1Var = f44147i;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        d11 = k.d(this, null, null, new CourseManager$notifyCourse$1(courseBean, null), 3, null);
        f44147i = d11;
    }

    public static /* synthetic */ void s(CourseManager courseManager, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "1";
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        courseManager.r(str, str2);
    }

    public static /* synthetic */ void v(CourseManager courseManager, Subject subject, Boolean bool, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bool = null;
        }
        courseManager.u(subject, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(com.transsion.edcation.bean.CourseBean r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.transsion.edcation.CourseManager$updateCourse$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.edcation.CourseManager$updateCourse$1 r0 = (com.transsion.edcation.CourseManager$updateCourse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.edcation.CourseManager$updateCourse$1 r0 = new com.transsion.edcation.CourseManager$updateCourse$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r11)
            goto Lad
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            java.lang.Object r10 = r0.L$0
            java.util.List r10 = (java.util.List) r10
            kotlin.ResultKt.b(r11)
            goto L96
        L3e:
            kotlin.ResultKt.b(r11)
            kotlinx.coroutines.flow.y0 r11 = com.transsion.edcation.CourseManager.f44145g
            java.lang.Object r11 = r11.getValue()
            java.util.List r11 = (java.util.List) r11
            if (r11 == 0) goto L72
            r2 = r11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L52:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r2.next()
            r7 = r6
            com.transsion.edcation.bean.CourseBean r7 = (com.transsion.edcation.bean.CourseBean) r7
            java.lang.String r7 = r7.getSubjectId()
            java.lang.String r8 = r10.getSubjectId()
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r7, r8)
            if (r7 == 0) goto L52
            goto L6f
        L6e:
            r6 = r5
        L6f:
            com.transsion.edcation.bean.CourseBean r6 = (com.transsion.edcation.bean.CourseBean) r6
            goto L73
        L72:
            r6 = r5
        L73:
            if (r6 == 0) goto L7c
            boolean r2 = r11.remove(r6)
            kotlin.coroutines.jvm.internal.Boxing.a(r2)
        L7c:
            int r2 = r10.getSeenStatus()
            if (r2 != r4) goto L88
            if (r11 == 0) goto L88
            r2 = 0
            r11.add(r2, r10)
        L88:
            kotlinx.coroutines.flow.y0 r10 = com.transsion.edcation.CourseManager.f44145g
            r0.L$0 = r11
            r0.label = r4
            java.lang.Object r10 = r10.emit(r11, r0)
            if (r10 != r1) goto L95
            return r1
        L95:
            r10 = r11
        L96:
            kotlinx.coroutines.flow.y0 r11 = com.transsion.edcation.CourseManager.f44144f
            if (r10 == 0) goto La1
            java.lang.Object r10 = kotlin.collections.CollectionsKt.k0(r10)
            com.transsion.edcation.bean.CourseBean r10 = (com.transsion.edcation.bean.CourseBean) r10
            goto La2
        La1:
            r10 = r5
        La2:
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r10 = r11.emit(r10, r0)
            if (r10 != r1) goto Lad
            return r1
        Lad:
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.edcation.CourseManager.x(com.transsion.edcation.bean.CourseBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(List list, String str) {
        k.d(this, null, null, new CourseManager$updateCourseList$1(str, list, null), 3, null);
    }

    @Override // kotlinx.coroutines.n0
    public CoroutineContext getCoroutineContext() {
        return f44148j;
    }

    public final void h(FragmentManager fragmentManager) {
        Intrinsics.h(fragmentManager, "fragmentManager");
        if (n() && f44142d) {
            new InterestSelectDialog().show(fragmentManager, "InterestSelectDialog");
        }
    }

    public final y0 i() {
        return f44145g;
    }

    public final x0 j() {
        return f44146h;
    }

    public final x0 k() {
        return f44143e;
    }

    public final y0 m() {
        return f44144f;
    }

    public final void r(final String page, final String str) {
        Intrinsics.h(page, "page");
        c.a.b(l(), null, page, 0, 5, null).v(qz.a.c()).x(a.f44149a).f(d.f75472a.c()).subscribe(new sg.a() { // from class: com.transsion.edcation.CourseManager$refreshCourseList$2
            @Override // sg.a
            public void a(String str2, String str3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("error: ");
                sb2.append(str2);
                sb2.append(", msg:");
                sb2.append(str3);
            }

            @Override // sg.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(CourseListResp courseListResp) {
                List<CourseBean> items;
                List<CourseBean> items2;
                super.c(courseListResp);
                List list = null;
                Integer valueOf = (courseListResp == null || (items2 = courseListResp.getItems()) == null) ? null : Integer.valueOf(items2.size());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("list is empty: ");
                sb2.append(valueOf);
                CourseManager courseManager = CourseManager.f44139a;
                k.d(courseManager, null, null, new CourseManager$refreshCourseList$2$onSuccess$1(courseListResp, str, null), 3, null);
                if (courseListResp != null && (items = courseListResp.getItems()) != null) {
                    list = CollectionsKt.U0(items);
                }
                courseManager.y(list, page);
            }
        });
    }

    public final void t(boolean z10) {
        f44142d = z10;
    }

    public final void u(Subject subject, Boolean bool) {
        if (subject == null) {
            return;
        }
        k.d(this, null, null, new CourseManager$subscribeCourse$1(subject, bool, null), 3, null);
    }

    public final void w(String str, Integer num) {
        if (str == null) {
            return;
        }
        k.d(this, null, null, new CourseManager$subscribeCourseById$1(num, str, null), 3, null);
    }
}
