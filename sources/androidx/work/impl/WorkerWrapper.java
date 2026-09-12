package androidx.work.impl;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import androidx.work.ListenableFutureKt;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.model.s1;
import androidx.work.s;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt__JobKt;

/* loaded from: classes.dex */
public final class WorkerWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.work.impl.model.j0 f15595a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15596b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15597c;

    /* renamed from: d, reason: collision with root package name */
    private final WorkerParameters.a f15598d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.work.s f15599e;

    /* renamed from: f, reason: collision with root package name */
    private final j4.c f15600f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.work.b f15601g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.work.a f15602h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.work.impl.foreground.a f15603i;

    /* renamed from: j, reason: collision with root package name */
    private final WorkDatabase f15604j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.work.impl.model.k0 f15605k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.work.impl.model.b f15606l;

    /* renamed from: m, reason: collision with root package name */
    private final List f15607m;

    /* renamed from: n, reason: collision with root package name */
    private final String f15608n;

    /* renamed from: o, reason: collision with root package name */
    private final kotlinx.coroutines.z f15609o;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.work.b f15610a;

        /* renamed from: b, reason: collision with root package name */
        private final j4.c f15611b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.work.impl.foreground.a f15612c;

        /* renamed from: d, reason: collision with root package name */
        private final WorkDatabase f15613d;

        /* renamed from: e, reason: collision with root package name */
        private final androidx.work.impl.model.j0 f15614e;

        /* renamed from: f, reason: collision with root package name */
        private final List f15615f;

        /* renamed from: g, reason: collision with root package name */
        private final Context f15616g;

        /* renamed from: h, reason: collision with root package name */
        private androidx.work.s f15617h;

        /* renamed from: i, reason: collision with root package name */
        private WorkerParameters.a f15618i;

        public a(Context context, androidx.work.b configuration, j4.c workTaskExecutor, androidx.work.impl.foreground.a foregroundProcessor, WorkDatabase workDatabase, androidx.work.impl.model.j0 workSpec, List tags) {
            Intrinsics.h(context, "context");
            Intrinsics.h(configuration, "configuration");
            Intrinsics.h(workTaskExecutor, "workTaskExecutor");
            Intrinsics.h(foregroundProcessor, "foregroundProcessor");
            Intrinsics.h(workDatabase, "workDatabase");
            Intrinsics.h(workSpec, "workSpec");
            Intrinsics.h(tags, "tags");
            this.f15610a = configuration;
            this.f15611b = workTaskExecutor;
            this.f15612c = foregroundProcessor;
            this.f15613d = workDatabase;
            this.f15614e = workSpec;
            this.f15615f = tags;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            this.f15616g = applicationContext;
            this.f15618i = new WorkerParameters.a();
        }

        public final WorkerWrapper a() {
            return new WorkerWrapper(this);
        }

        public final Context b() {
            return this.f15616g;
        }

        public final androidx.work.b c() {
            return this.f15610a;
        }

        public final androidx.work.impl.foreground.a d() {
            return this.f15612c;
        }

        public final WorkerParameters.a e() {
            return this.f15618i;
        }

        public final List f() {
            return this.f15615f;
        }

        public final WorkDatabase g() {
            return this.f15613d;
        }

        public final androidx.work.impl.model.j0 h() {
            return this.f15614e;
        }

        public final j4.c i() {
            return this.f15611b;
        }

        public final androidx.work.s j() {
            return this.f15617h;
        }

        public final a k(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f15618i = aVar;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class b {

        /* loaded from: classes2.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            private final s.a f15619a;

            /* JADX WARN: Multi-variable type inference failed */
            public a() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(s.a result) {
                super(null);
                Intrinsics.h(result, "result");
                this.f15619a = result;
            }

            public /* synthetic */ a(s.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this((i11 & 1) != 0 ? new s.a.C0144a() : aVar);
            }

            public final s.a a() {
                return this.f15619a;
            }
        }

        /* renamed from: androidx.work.impl.WorkerWrapper$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0140b extends b {

            /* renamed from: a, reason: collision with root package name */
            private final s.a f15620a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0140b(s.a result) {
                super(null);
                Intrinsics.h(result, "result");
                this.f15620a = result;
            }

            public final s.a a() {
                return this.f15620a;
            }
        }

        /* loaded from: classes2.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            private final int f15621a;

            public c() {
                this(0, 1, null);
            }

            public c(int i11) {
                super(null);
                this.f15621a = i11;
            }

            public /* synthetic */ c(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
                this((i12 & 1) != 0 ? InputDeviceCompat.SOURCE_ANY : i11);
            }

            public final int a() {
                return this.f15621a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WorkerWrapper(a builder) {
        kotlinx.coroutines.z b11;
        Intrinsics.h(builder, "builder");
        androidx.work.impl.model.j0 h11 = builder.h();
        this.f15595a = h11;
        this.f15596b = builder.b();
        this.f15597c = h11.f15846a;
        this.f15598d = builder.e();
        this.f15599e = builder.j();
        this.f15600f = builder.i();
        androidx.work.b c11 = builder.c();
        this.f15601g = c11;
        this.f15602h = c11.a();
        this.f15603i = builder.d();
        WorkDatabase g11 = builder.g();
        this.f15604j = g11;
        this.f15605k = g11.l0();
        this.f15606l = g11.g0();
        List f11 = builder.f();
        this.f15607m = f11;
        this.f15608n = l(f11);
        b11 = JobKt__JobKt.b(null, 1, null);
        this.f15609o = b11;
    }

    private final boolean B(s.a aVar) {
        String str;
        this.f15605k.s(WorkInfo.State.SUCCEEDED, this.f15597c);
        Intrinsics.f(aVar, "null cannot be cast to non-null type androidx.work.ListenableWorker.Result.Success");
        androidx.work.f d11 = ((s.a.c) aVar).d();
        Intrinsics.g(d11, "getOutputData(...)");
        this.f15605k.t(this.f15597c, d11);
        long currentTimeMillis = this.f15602h.currentTimeMillis();
        for (String str2 : this.f15606l.b(this.f15597c)) {
            if (this.f15605k.i(str2) == WorkInfo.State.BLOCKED && this.f15606l.c(str2)) {
                str = r1.f15992a;
                androidx.work.t.e().f(str, "Setting status to enqueued for " + str2);
                this.f15605k.s(WorkInfo.State.ENQUEUED, str2);
                this.f15605k.u(str2, currentTimeMillis);
            }
        }
        return false;
    }

    private final boolean C() {
        Object Y = this.f15604j.Y(new Callable() { // from class: androidx.work.impl.p1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean D;
                D = WorkerWrapper.D(WorkerWrapper.this);
                return D;
            }
        });
        Intrinsics.g(Y, "runInTransaction(...)");
        return ((Boolean) Y).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean D(WorkerWrapper workerWrapper) {
        boolean z10;
        if (workerWrapper.f15605k.i(workerWrapper.f15597c) == WorkInfo.State.ENQUEUED) {
            workerWrapper.f15605k.s(WorkInfo.State.RUNNING, workerWrapper.f15597c);
            workerWrapper.f15605k.z(workerWrapper.f15597c);
            workerWrapper.f15605k.a(workerWrapper.f15597c, InputDeviceCompat.SOURCE_ANY);
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    private final String l(List list) {
        return "Work [ id=" + this.f15597c + ", tags={ " + CollectionsKt.s0(list, ",", null, null, 0, null, null, 62, null) + " } ]";
    }

    private final boolean o(s.a aVar) {
        String str;
        String str2;
        String str3;
        if (aVar instanceof s.a.c) {
            str3 = r1.f15992a;
            androidx.work.t.e().f(str3, "Worker result SUCCESS for " + this.f15608n);
            return this.f15595a.o() ? v() : B(aVar);
        }
        if (aVar instanceof s.a.b) {
            str2 = r1.f15992a;
            androidx.work.t.e().f(str2, "Worker result RETRY for " + this.f15608n);
            return u(InputDeviceCompat.SOURCE_ANY);
        }
        str = r1.f15992a;
        androidx.work.t.e().f(str, "Worker result FAILURE for " + this.f15608n);
        if (this.f15595a.o()) {
            return v();
        }
        if (aVar == null) {
            aVar = new s.a.C0144a();
        }
        return A(aVar);
    }

    private final void q(String str) {
        List q11 = CollectionsKt.q(str);
        while (!q11.isEmpty()) {
            String str2 = (String) CollectionsKt.L(q11);
            if (this.f15605k.i(str2) != WorkInfo.State.CANCELLED) {
                this.f15605k.s(WorkInfo.State.FAILED, str2);
            }
            q11.addAll(this.f15606l.b(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(s.a aVar) {
        String str;
        str = r1.f15992a;
        androidx.work.t.e().f(str, "Worker result FAILURE for " + this.f15608n);
        if (this.f15595a.o()) {
            v();
            return false;
        }
        A(aVar);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t(s.a aVar) {
        WorkInfo.State i11 = this.f15605k.i(this.f15597c);
        this.f15604j.k0().b(this.f15597c);
        if (i11 == null) {
            return false;
        }
        if (i11 == WorkInfo.State.RUNNING) {
            return o(aVar);
        }
        if (i11.isFinished()) {
            return false;
        }
        return u(-512);
    }

    private final boolean u(int i11) {
        this.f15605k.s(WorkInfo.State.ENQUEUED, this.f15597c);
        this.f15605k.u(this.f15597c, this.f15602h.currentTimeMillis());
        this.f15605k.B(this.f15597c, this.f15595a.i());
        this.f15605k.o(this.f15597c, -1L);
        this.f15605k.a(this.f15597c, i11);
        return true;
    }

    private final boolean v() {
        this.f15605k.u(this.f15597c, this.f15602h.currentTimeMillis());
        this.f15605k.s(WorkInfo.State.ENQUEUED, this.f15597c);
        this.f15605k.x(this.f15597c);
        this.f15605k.B(this.f15597c, this.f15595a.i());
        this.f15605k.d(this.f15597c);
        this.f15605k.o(this.f15597c, -1L);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w(int i11) {
        String str;
        String str2;
        String str3;
        if (Intrinsics.c(this.f15595a.f(), Boolean.TRUE)) {
            str3 = r1.f15992a;
            androidx.work.t.e().a(str3, "Worker " + this.f15595a.f15848c + " was interrupted. Backing off.");
            u(i11);
            return true;
        }
        WorkInfo.State i12 = this.f15605k.i(this.f15597c);
        if (i12 == null || i12.isFinished()) {
            str = r1.f15992a;
            androidx.work.t.e().a(str, "Status for " + this.f15597c + " is " + i12 + " ; not doing any work");
            return false;
        }
        str2 = r1.f15992a;
        androidx.work.t.e().a(str2, "Status for " + this.f15597c + " is " + i12 + "; not doing any work and rescheduling for later execution");
        this.f15605k.s(WorkInfo.State.ENQUEUED, this.f15597c);
        this.f15605k.a(this.f15597c, i11);
        this.f15605k.o(this.f15597c, -1L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(kotlin.coroutines.Continuation r24) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean y(WorkerWrapper workerWrapper) {
        String str;
        String str2;
        androidx.work.impl.model.j0 j0Var = workerWrapper.f15595a;
        if (j0Var.f15847b != WorkInfo.State.ENQUEUED) {
            str2 = r1.f15992a;
            androidx.work.t.e().a(str2, workerWrapper.f15595a.f15848c + " is not in ENQUEUED state. Nothing more to do");
            return Boolean.TRUE;
        }
        if ((!j0Var.o() && !workerWrapper.f15595a.n()) || workerWrapper.f15602h.currentTimeMillis() >= workerWrapper.f15595a.c()) {
            return Boolean.FALSE;
        }
        androidx.work.t e11 = androidx.work.t.e();
        str = r1.f15992a;
        e11.a(str, "Delaying execution for " + workerWrapper.f15595a.f15848c + " because it is being executed before schedule.");
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(androidx.work.s sVar, boolean z10, String str, WorkerWrapper workerWrapper, Throwable th2) {
        if (th2 instanceof WorkerStoppedException) {
            sVar.m(((WorkerStoppedException) th2).getReason());
        }
        if (z10 && str != null) {
            workerWrapper.f15601g.n().b(str, workerWrapper.f15595a.hashCode());
        }
        return Unit.f67184a;
    }

    public final boolean A(s.a result) {
        Intrinsics.h(result, "result");
        q(this.f15597c);
        androidx.work.f d11 = ((s.a.C0144a) result).d();
        Intrinsics.g(d11, "getOutputData(...)");
        this.f15605k.B(this.f15597c, this.f15595a.i());
        this.f15605k.t(this.f15597c, d11);
        return false;
    }

    public final androidx.work.impl.model.x m() {
        return s1.a(this.f15595a);
    }

    public final androidx.work.impl.model.j0 n() {
        return this.f15595a;
    }

    public final void p(int i11) {
        this.f15609o.cancel(new WorkerStoppedException(i11));
    }

    public final com.google.common.util.concurrent.r r() {
        kotlinx.coroutines.z b11;
        kotlinx.coroutines.i0 b12 = this.f15600f.b();
        b11 = JobKt__JobKt.b(null, 1, null);
        return ListenableFutureKt.k(b12.plus(b11), null, new WorkerWrapper$launch$1(this, null), 2, null);
    }
}
