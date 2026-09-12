package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.l0;
import androidx.compose.ui.input.pointer.n0;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.node.d1;
import androidx.compose.ui.node.e1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p.a;

/* loaded from: classes.dex */
public abstract class DragGestureNode extends androidx.compose.ui.node.i implements e1, androidx.compose.ui.node.d {

    /* renamed from: p, reason: collision with root package name */
    private Orientation f2737p;

    /* renamed from: q, reason: collision with root package name */
    private Function1 f2738q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2739r;

    /* renamed from: s, reason: collision with root package name */
    private p.i f2740s;

    /* renamed from: t, reason: collision with root package name */
    private final Function1 f2741t = new Function1<w, Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(w wVar) {
            return (Boolean) DragGestureNode.this.T1().invoke(wVar);
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private kotlinx.coroutines.channels.d f2742u;

    /* renamed from: v, reason: collision with root package name */
    private a.b f2743v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f2744w;

    /* renamed from: x, reason: collision with root package name */
    private n0 f2745x;

    public DragGestureNode(Function1 function1, boolean z10, p.i iVar, Orientation orientation) {
        this.f2737p = orientation;
        this.f2738q = function1;
        this.f2739r = z10;
        this.f2740s = iVar;
    }

    private final n0 V1() {
        return l0.a(new DragGestureNode$initializePointerInputNode$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y1(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.b(r6)
            goto L51
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.b(r6)
            p.a$b r6 = r5.f2743v
            if (r6 == 0) goto L55
            p.i r2 = r5.f2740s
            if (r2 == 0) goto L50
            p.a$a r4 = new p.a$a
            r4.<init>(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r2.c(r4, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            r0 = r5
        L51:
            r6 = 0
            r0.f2743v = r6
            goto L56
        L55:
            r0 = r5
        L56:
            o0.z$a r6 = o0.z.f70760b
            long r1 = r6.a()
            r0.X1(r1)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.Y1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Z1(androidx.compose.foundation.gestures.e.c r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$2
            p.a$b r7 = (p.a.b) r7
            java.lang.Object r1 = r0.L$1
            androidx.compose.foundation.gestures.e$c r1 = (androidx.compose.foundation.gestures.e.c) r1
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.b(r8)
            goto L85
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.L$1
            androidx.compose.foundation.gestures.e$c r7 = (androidx.compose.foundation.gestures.e.c) r7
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r2 = (androidx.compose.foundation.gestures.DragGestureNode) r2
            kotlin.ResultKt.b(r8)
            goto L6a
        L4c:
            kotlin.ResultKt.b(r8)
            p.a$b r8 = r6.f2743v
            if (r8 == 0) goto L69
            p.i r2 = r6.f2740s
            if (r2 == 0) goto L69
            p.a$a r5 = new p.a$a
            r5.<init>(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r2.c(r5, r0)
            if (r8 != r1) goto L69
            return r1
        L69:
            r2 = r6
        L6a:
            p.a$b r8 = new p.a$b
            r8.<init>()
            p.i r4 = r2.f2740s
            if (r4 == 0) goto L88
            r0.L$0 = r2
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r0 = r4.c(r8, r0)
            if (r0 != r1) goto L82
            return r1
        L82:
            r1 = r7
            r7 = r8
            r0 = r2
        L85:
            r8 = r7
            r2 = r0
            r7 = r1
        L88:
            r2.f2743v = r8
            long r7 = r7.a()
            r2.W1(r7)
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.Z1(androidx.compose.foundation.gestures.e$c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a2(androidx.compose.foundation.gestures.e.d r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            androidx.compose.foundation.gestures.e$d r6 = (androidx.compose.foundation.gestures.e.d) r6
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.b(r7)
            goto L57
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.b(r7)
            p.a$b r7 = r5.f2743v
            if (r7 == 0) goto L5b
            p.i r2 = r5.f2740s
            if (r2 == 0) goto L56
            p.a$c r4 = new p.a$c
            r4.<init>(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r2.c(r4, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r0 = r5
        L57:
            r7 = 0
            r0.f2743v = r7
            goto L5c
        L5b:
            r0 = r5
        L5c:
            long r6 = r6.a()
            r0.X1(r6)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.a2(androidx.compose.foundation.gestures.e$d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2() {
        this.f2744w = true;
        kotlinx.coroutines.k.d(d1(), null, null, new DragGestureNode$startListeningForEvents$1(this, null), 3, null);
    }

    @Override // androidx.compose.ui.node.e1
    public void M(androidx.compose.ui.input.pointer.o oVar, PointerEventPass pointerEventPass, long j11) {
        if (this.f2739r && this.f2745x == null) {
            this.f2745x = (n0) D1(V1());
        }
        n0 n0Var = this.f2745x;
        if (n0Var != null) {
            n0Var.M(oVar, pointerEventPass, j11);
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean P0() {
        return d1.d(this);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean R() {
        return d1.a(this);
    }

    public final void R1() {
        a.b bVar = this.f2743v;
        if (bVar != null) {
            p.i iVar = this.f2740s;
            if (iVar != null) {
                iVar.a(new a.C0907a(bVar));
            }
            this.f2743v = null;
        }
    }

    public abstract Object S1(Function2 function2, Continuation continuation);

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void T0() {
        d1.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function1 T1() {
        return this.f2738q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean U1() {
        return this.f2739r;
    }

    public abstract void W1(long j11);

    public abstract void X1(long j11);

    public abstract boolean b2();

    public final void d2(Function1 function1, boolean z10, p.i iVar, Orientation orientation, boolean z11) {
        n0 n0Var;
        this.f2738q = function1;
        boolean z12 = true;
        if (this.f2739r != z10) {
            this.f2739r = z10;
            if (!z10) {
                R1();
                n0 n0Var2 = this.f2745x;
                if (n0Var2 != null) {
                    G1(n0Var2);
                }
                this.f2745x = null;
            }
            z11 = true;
        }
        if (!Intrinsics.c(this.f2740s, iVar)) {
            R1();
            this.f2740s = iVar;
        }
        if (this.f2737p != orientation) {
            this.f2737p = orientation;
        } else {
            z12 = z11;
        }
        if (!z12 || (n0Var = this.f2745x) == null) {
            return;
        }
        n0Var.j0();
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        this.f2744w = false;
        R1();
    }

    @Override // androidx.compose.ui.node.e1
    public void t0() {
        n0 n0Var = this.f2745x;
        if (n0Var != null) {
            n0Var.t0();
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void z0() {
        d1.b(this);
    }
}
