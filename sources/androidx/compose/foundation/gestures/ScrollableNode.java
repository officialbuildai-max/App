package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.f0;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import d0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import o0.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ScrollableNode extends DragGestureNode implements u0, androidx.compose.ui.node.d, androidx.compose.ui.focus.m, d0.e, i1 {
    private final boolean A;
    private final NestedScrollDispatcher B;
    private final l C;
    private final DefaultFlingBehavior D;
    private final ScrollingLogic E;
    private final ScrollableNestedScrollConnection F;
    private final ContentInViewNode G;
    private j H;
    private Function2 I;
    private Function2 J;

    /* renamed from: y, reason: collision with root package name */
    private f0 f2766y;

    /* renamed from: z, reason: collision with root package name */
    private g f2767z;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.foundation.gestures.g] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ScrollableNode(androidx.compose.foundation.gestures.o r13, androidx.compose.foundation.f0 r14, androidx.compose.foundation.gestures.g r15, androidx.compose.foundation.gestures.Orientation r16, boolean r17, boolean r18, p.i r19, androidx.compose.foundation.gestures.d r20) {
        /*
            r12 = this;
            r0 = r12
            r8 = r16
            r9 = r17
            kotlin.jvm.functions.Function1 r1 = androidx.compose.foundation.gestures.ScrollableKt.a()
            r2 = r19
            r12.<init>(r1, r9, r2, r8)
            r1 = r14
            r0.f2766y = r1
            r1 = r15
            r0.f2767z = r1
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r10 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r10.<init>()
            r0.B = r10
            androidx.compose.foundation.gestures.l r1 = new androidx.compose.foundation.gestures.l
            r1.<init>(r9)
            androidx.compose.ui.node.f r1 = r12.D1(r1)
            androidx.compose.foundation.gestures.l r1 = (androidx.compose.foundation.gestures.l) r1
            r0.C = r1
            androidx.compose.foundation.gestures.DefaultFlingBehavior r1 = new androidx.compose.foundation.gestures.DefaultFlingBehavior
            androidx.compose.foundation.gestures.ScrollableKt$c r2 = androidx.compose.foundation.gestures.ScrollableKt.c()
            androidx.compose.animation.core.w r2 = androidx.compose.animation.f.c(r2)
            r3 = 0
            r4 = 2
            r1.<init>(r2, r3, r4, r3)
            r0.D = r1
            androidx.compose.foundation.f0 r3 = r0.f2766y
            androidx.compose.foundation.gestures.g r2 = r0.f2767z
            if (r2 != 0) goto L41
            r4 = r1
            goto L42
        L41:
            r4 = r2
        L42:
            androidx.compose.foundation.gestures.ScrollingLogic r11 = new androidx.compose.foundation.gestures.ScrollingLogic
            r1 = r11
            r2 = r13
            r5 = r16
            r6 = r18
            r7 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.E = r11
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection r1 = new androidx.compose.foundation.gestures.ScrollableNestedScrollConnection
            r1.<init>(r11, r9)
            r0.F = r1
            androidx.compose.foundation.gestures.ContentInViewNode r2 = new androidx.compose.foundation.gestures.ContentInViewNode
            r3 = r18
            r4 = r20
            r2.<init>(r8, r11, r3, r4)
            androidx.compose.ui.node.f r2 = r12.D1(r2)
            androidx.compose.foundation.gestures.ContentInViewNode r2 = (androidx.compose.foundation.gestures.ContentInViewNode) r2
            r0.G = r2
            androidx.compose.ui.node.f r1 = androidx.compose.ui.input.nestedscroll.d.a(r1, r10)
            r12.D1(r1)
            androidx.compose.ui.focus.s r1 = androidx.compose.ui.focus.t.a()
            r12.D1(r1)
            androidx.compose.foundation.relocation.BringIntoViewResponderNode r1 = new androidx.compose.foundation.relocation.BringIntoViewResponderNode
            r1.<init>(r2)
            r12.D1(r1)
            androidx.compose.foundation.t r1 = new androidx.compose.foundation.t
            androidx.compose.foundation.gestures.ScrollableNode$1 r2 = new androidx.compose.foundation.gestures.ScrollableNode$1
            r2.<init>()
            r1.<init>(r2)
            r12.D1(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableNode.<init>(androidx.compose.foundation.gestures.o, androidx.compose.foundation.f0, androidx.compose.foundation.gestures.g, androidx.compose.foundation.gestures.Orientation, boolean, boolean, p.i, androidx.compose.foundation.gestures.d):void");
    }

    private final void h2() {
        this.I = null;
        this.J = null;
    }

    private final void i2(androidx.compose.ui.input.pointer.o oVar, long j11) {
        List b11 = oVar.b();
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((w) b11.get(i11)).p()) {
                return;
            }
        }
        j jVar = this.H;
        Intrinsics.e(jVar);
        kotlinx.coroutines.k.d(d1(), null, null, new ScrollableNode$processMouseWheelEvent$2$1(this, jVar.a(androidx.compose.ui.node.g.i(this), oVar, j11), null), 3, null);
        List b12 = oVar.b();
        int size2 = b12.size();
        for (int i12 = 0; i12 < size2; i12++) {
            ((w) b12.get(i12)).a();
        }
    }

    private final void j2() {
        this.I = new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1", f = "Scrollable.kt", l = {522}, m = "invokeSuspend")
            /* renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                final /* synthetic */ float $x;
                final /* synthetic */ float $y;
                int label;
                final /* synthetic */ ScrollableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ScrollableNode scrollableNode, float f11, float f12, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = scrollableNode;
                    this.$x = f11;
                    this.$y = f12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$x, this.$y, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    ScrollingLogic scrollingLogic;
                    Object g11;
                    Object f11 = IntrinsicsKt.f();
                    int i11 = this.label;
                    if (i11 == 0) {
                        ResultKt.b(obj);
                        scrollingLogic = this.this$0.E;
                        long a11 = y.h.a(this.$x, this.$y);
                        this.label = 1;
                        g11 = ScrollableKt.g(scrollingLogic, a11, this);
                        if (g11 == f11) {
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
            {
                super(2);
            }

            public final Boolean invoke(float f11, float f12) {
                kotlinx.coroutines.k.d(ScrollableNode.this.d1(), null, null, new AnonymousClass1(ScrollableNode.this, f11, f12, null), 3, null);
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
            }
        };
        this.J = new ScrollableNode$setScrollSemanticsActions$2(this, null);
    }

    private final void l2() {
        v0.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode$updateDefaultFlingBehavior$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m34invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m34invoke() {
                DefaultFlingBehavior defaultFlingBehavior;
                o0.e eVar = (o0.e) androidx.compose.ui.node.e.a(ScrollableNode.this, CompositionLocalsKt.c());
                defaultFlingBehavior = ScrollableNode.this.D;
                defaultFlingBehavior.d(androidx.compose.animation.f.c(eVar));
            }
        });
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.e1
    public void M(androidx.compose.ui.input.pointer.o oVar, PointerEventPass pointerEventPass, long j11) {
        List b11 = oVar.b();
        int size = b11.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            if (((Boolean) T1().invoke((w) b11.get(i11))).booleanValue()) {
                super.M(oVar, pointerEventPass, j11);
                break;
            }
            i11++;
        }
        if (pointerEventPass == PointerEventPass.Main && androidx.compose.ui.input.pointer.q.i(oVar.e(), androidx.compose.ui.input.pointer.q.f5098a.f())) {
            i2(oVar, j11);
        }
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean O() {
        return h1.a(this);
    }

    @Override // androidx.compose.ui.node.i1
    public void R0(androidx.compose.ui.semantics.n nVar) {
        if (U1() && (this.I == null || this.J == null)) {
            j2();
        }
        Function2 function2 = this.I;
        if (function2 != null) {
            SemanticsPropertiesKt.q(nVar, null, function2, 1, null);
        }
        Function2 function22 = this.J;
        if (function22 != null) {
            SemanticsPropertiesKt.r(nVar, function22);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object S1(Function2 function2, Continuation continuation) {
        ScrollingLogic scrollingLogic = this.E;
        Object v11 = scrollingLogic.v(MutatePriority.UserInput, new ScrollableNode$drag$2$1(function2, scrollingLogic, null), continuation);
        return v11 == IntrinsicsKt.f() ? v11 : Unit.f67184a;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean W0() {
        return h1.b(this);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void W1(long j11) {
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void X1(long j11) {
        kotlinx.coroutines.k.d(this.B.e(), null, null, new ScrollableNode$onDragStopped$1(this, j11, null), 3, null);
    }

    @Override // androidx.compose.ui.node.u0
    public void Z() {
        l2();
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean b2() {
        return this.E.w();
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return this.A;
    }

    public final void k2(o oVar, Orientation orientation, f0 f0Var, boolean z10, boolean z11, g gVar, p.i iVar, d dVar) {
        boolean z12;
        Function1 function1;
        if (U1() != z10) {
            this.F.a(z10);
            this.C.E1(z10);
            z12 = true;
        } else {
            z12 = false;
        }
        boolean z13 = z12;
        boolean C = this.E.C(oVar, orientation, f0Var, z11, gVar == null ? this.D : gVar, this.B);
        this.G.a2(orientation, z11, dVar);
        this.f2766y = f0Var;
        this.f2767z = gVar;
        function1 = ScrollableKt.f2760a;
        d2(function1, z10, iVar, this.E.p() ? Orientation.Vertical : Orientation.Horizontal, C);
        if (z13) {
            h2();
            j1.b(this);
        }
    }

    @Override // d0.e
    public boolean l0(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.ui.f.c
    public void n1() {
        l2();
        this.H = b.a(this);
    }

    @Override // androidx.compose.ui.focus.m
    public void r0(androidx.compose.ui.focus.k kVar) {
        kVar.r(false);
    }

    @Override // d0.e
    public boolean s0(KeyEvent keyEvent) {
        long a11;
        if (U1()) {
            long a12 = d0.d.a(keyEvent);
            a.C0752a c0752a = d0.a.f61093b;
            if ((d0.a.p(a12, c0752a.j()) || d0.a.p(d0.d.a(keyEvent), c0752a.k())) && d0.c.e(d0.d.b(keyEvent), d0.c.f61245a.a()) && !d0.d.c(keyEvent)) {
                if (this.E.p()) {
                    int f11 = t.f(this.G.T1());
                    a11 = y.h.a(0.0f, d0.a.p(d0.d.a(keyEvent), c0752a.k()) ? f11 : -f11);
                } else {
                    int g11 = t.g(this.G.T1());
                    a11 = y.h.a(d0.a.p(d0.d.a(keyEvent), c0752a.k()) ? g11 : -g11, 0.0f);
                }
                kotlinx.coroutines.k.d(d1(), null, null, new ScrollableNode$onKeyEvent$1(this, a11, null), 3, null);
                return true;
            }
        }
        return false;
    }
}
