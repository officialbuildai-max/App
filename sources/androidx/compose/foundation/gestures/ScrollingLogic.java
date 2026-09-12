package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.f0;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import o0.z;

/* loaded from: classes.dex */
public final class ScrollingLogic {

    /* renamed from: a, reason: collision with root package name */
    private o f2768a;

    /* renamed from: b, reason: collision with root package name */
    private f0 f2769b;

    /* renamed from: c, reason: collision with root package name */
    private g f2770c;

    /* renamed from: d, reason: collision with root package name */
    private Orientation f2771d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2772e;

    /* renamed from: f, reason: collision with root package name */
    private NestedScrollDispatcher f2773f;

    /* renamed from: g, reason: collision with root package name */
    private int f2774g = androidx.compose.ui.input.nestedscroll.e.f5014a.b();

    /* renamed from: h, reason: collision with root package name */
    private k f2775h = ScrollableKt.b();

    /* renamed from: i, reason: collision with root package name */
    private final a f2776i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final Function1 f2777j = new Function1<y.g, y.g>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return y.g.d(m36invokeMKHz9U(((y.g) obj).v()));
        }

        /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m36invokeMKHz9U(long j11) {
            k kVar = ScrollingLogic.this.f2775h;
            ScrollingLogic scrollingLogic = ScrollingLogic.this;
            return scrollingLogic.s(kVar, j11, scrollingLogic.f2774g);
        }
    };

    /* loaded from: classes.dex */
    public static final class a implements h {
        a() {
        }

        @Override // androidx.compose.foundation.gestures.h
        public long a(long j11, int i11) {
            ScrollingLogic.this.f2774g = i11;
            f0 f0Var = ScrollingLogic.this.f2769b;
            if (f0Var != null && ScrollingLogic.this.o()) {
                return f0Var.c(j11, ScrollingLogic.this.f2774g, ScrollingLogic.this.f2777j);
            }
            return ScrollingLogic.this.s(ScrollingLogic.this.f2775h, j11, i11);
        }

        @Override // androidx.compose.foundation.gestures.h
        public long b(long j11, int i11) {
            return ScrollingLogic.this.s(ScrollingLogic.this.f2775h, j11, i11);
        }
    }

    public ScrollingLogic(o oVar, f0 f0Var, g gVar, Orientation orientation, boolean z10, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f2768a = oVar;
        this.f2769b = f0Var;
        this.f2770c = gVar;
        this.f2771d = orientation;
        this.f2772e = z10;
        this.f2773f = nestedScrollDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long D(long j11, float f11) {
        return this.f2771d == Orientation.Horizontal ? z.e(j11, f11, 0.0f, 2, null) : z.e(j11, 0.0f, f11, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o() {
        return this.f2768a.d() || this.f2768a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long s(k kVar, long j11, int i11) {
        long d11 = this.f2773f.d(j11, i11);
        long q11 = y.g.q(j11, d11);
        long u11 = u(B(kVar.a(A(u(x(q11))))));
        return y.g.r(y.g.r(d11, u11), this.f2773f.b(u11, y.g.q(q11, u11), i11));
    }

    private final long y(long j11) {
        return this.f2771d == Orientation.Horizontal ? z.e(j11, 0.0f, 0.0f, 1, null) : z.e(j11, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float z(long j11) {
        return this.f2771d == Orientation.Horizontal ? z.h(j11) : z.i(j11);
    }

    public final float A(long j11) {
        return this.f2771d == Orientation.Horizontal ? y.g.m(j11) : y.g.n(j11);
    }

    public final long B(float f11) {
        return f11 == 0.0f ? y.g.f78593b.c() : this.f2771d == Orientation.Horizontal ? y.h.a(f11, 0.0f) : y.h.a(0.0f, f11);
    }

    public final boolean C(o oVar, Orientation orientation, f0 f0Var, boolean z10, g gVar, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z11;
        boolean z12 = true;
        if (Intrinsics.c(this.f2768a, oVar)) {
            z11 = false;
        } else {
            this.f2768a = oVar;
            z11 = true;
        }
        this.f2769b = f0Var;
        if (this.f2771d != orientation) {
            this.f2771d = orientation;
            z11 = true;
        }
        if (this.f2772e != z10) {
            this.f2772e = z10;
        } else {
            z12 = z11;
        }
        this.f2770c = gVar;
        this.f2773f = nestedScrollDispatcher;
        return z12;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(long r12, kotlin.coroutines.Continuation r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            kotlin.ResultKt.b(r14)
            goto L57
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            kotlin.ResultKt.b(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r12
            androidx.compose.foundation.MutatePriority r2 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r10 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r9 = 0
            r4 = r10
            r5 = r11
            r6 = r14
            r7 = r12
            r4.<init>(r5, r6, r7, r9)
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r12 = r11.v(r2, r10, r0)
            if (r12 != r1) goto L56
            return r1
        L56:
            r12 = r14
        L57:
            long r12 = r12.element
            o0.z r12 = o0.z.b(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.n(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean p() {
        return this.f2771d == Orientation.Vertical;
    }

    public final Object q(long j11, Continuation continuation) {
        long y10 = y(j11);
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
        f0 f0Var = this.f2769b;
        if (f0Var == null || !o()) {
            Object invoke = scrollingLogic$onDragStopped$performFling$1.invoke(z.b(y10), continuation);
            return invoke == IntrinsicsKt.f() ? invoke : Unit.f67184a;
        }
        Object d11 = f0Var.d(y10, scrollingLogic$onDragStopped$performFling$1, continuation);
        return d11 == IntrinsicsKt.f() ? d11 : Unit.f67184a;
    }

    public final long r(long j11) {
        return this.f2768a.a() ? y.g.f78593b.c() : B(t(this.f2768a.e(t(A(j11)))));
    }

    public final float t(float f11) {
        return this.f2772e ? f11 * (-1) : f11;
    }

    public final long u(long j11) {
        return this.f2772e ? y.g.s(j11, -1.0f) : j11;
    }

    public final Object v(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object c11 = this.f2768a.c(mutatePriority, new ScrollingLogic$scroll$2(this, function2, null), continuation);
        return c11 == IntrinsicsKt.f() ? c11 : Unit.f67184a;
    }

    public final boolean w() {
        if (!this.f2768a.a()) {
            f0 f0Var = this.f2769b;
            if (!(f0Var != null ? f0Var.a() : false)) {
                return false;
            }
        }
        return true;
    }

    public final long x(long j11) {
        return this.f2771d == Orientation.Horizontal ? y.g.g(j11, 0.0f, 0.0f, 1, null) : y.g.g(j11, 0.0f, 0.0f, 2, null);
    }
}
