package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.l0;
import androidx.compose.ui.input.pointer.n0;
import androidx.compose.ui.input.pointer.q;
import androidx.compose.ui.node.d1;
import androidx.compose.ui.node.e1;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import p.k;

/* loaded from: classes.dex */
public abstract class AbstractClickableNode extends androidx.compose.ui.node.i implements e1, d0.e, androidx.compose.ui.focus.c, i1, m1 {
    public static final a H = new a(null);
    public static final int I = 8;
    private k.b A;
    private p.d B;
    private final Map C;
    private long D;
    private p.i E;
    private boolean F;
    private final Object G;

    /* renamed from: p, reason: collision with root package name */
    private p.i f2599p;

    /* renamed from: q, reason: collision with root package name */
    private b0 f2600q;

    /* renamed from: r, reason: collision with root package name */
    private String f2601r;

    /* renamed from: s, reason: collision with root package name */
    private androidx.compose.ui.semantics.f f2602s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f2603t;

    /* renamed from: u, reason: collision with root package name */
    private Function0 f2604u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f2605v;

    /* renamed from: w, reason: collision with root package name */
    private final q f2606w;

    /* renamed from: x, reason: collision with root package name */
    private final FocusableNode f2607x;

    /* renamed from: y, reason: collision with root package name */
    private n0 f2608y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.compose.ui.node.f f2609z;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private AbstractClickableNode(p.i iVar, b0 b0Var, boolean z10, String str, androidx.compose.ui.semantics.f fVar, Function0 function0) {
        this.f2599p = iVar;
        this.f2600q = b0Var;
        this.f2601r = str;
        this.f2602s = fVar;
        this.f2603t = z10;
        this.f2604u = function0;
        this.f2606w = new q();
        this.f2607x = new FocusableNode(this.f2599p);
        this.C = new LinkedHashMap();
        this.D = y.g.f78593b.c();
        this.E = this.f2599p;
        this.F = a2();
        this.G = H;
    }

    public /* synthetic */ AbstractClickableNode(p.i iVar, b0 b0Var, boolean z10, String str, androidx.compose.ui.semantics.f fVar, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, b0Var, z10, str, fVar, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R1() {
        return ClickableKt.e(this) || f.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        if (this.B == null) {
            p.d dVar = new p.d();
            p.i iVar = this.f2599p;
            if (iVar != null) {
                kotlinx.coroutines.k.d(d1(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(iVar, dVar, null), 3, null);
            }
            this.B = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1() {
        p.d dVar = this.B;
        if (dVar != null) {
            p.e eVar = new p.e(dVar);
            p.i iVar = this.f2599p;
            if (iVar != null) {
                kotlinx.coroutines.k.d(d1(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(iVar, eVar, null), 3, null);
            }
            this.B = null;
        }
    }

    private final void Y1() {
        b0 b0Var;
        if (this.f2609z == null && (b0Var = this.f2600q) != null) {
            if (this.f2599p == null) {
                this.f2599p = p.h.a();
            }
            this.f2607x.J1(this.f2599p);
            p.i iVar = this.f2599p;
            Intrinsics.e(iVar);
            androidx.compose.ui.node.f b11 = b0Var.b(iVar);
            D1(b11);
            this.f2609z = b11;
        }
    }

    private final boolean a2() {
        return this.E == null && this.f2600q != null;
    }

    @Override // androidx.compose.ui.node.m1
    public Object D() {
        return this.G;
    }

    @Override // androidx.compose.ui.node.e1
    public final void M(androidx.compose.ui.input.pointer.o oVar, PointerEventPass pointerEventPass, long j11) {
        long b11 = o0.u.b(j11);
        this.D = y.h.a(o0.p.h(b11), o0.p.i(b11));
        Y1();
        if (this.f2603t && pointerEventPass == PointerEventPass.Main) {
            int e11 = oVar.e();
            q.a aVar = androidx.compose.ui.input.pointer.q.f5098a;
            if (androidx.compose.ui.input.pointer.q.i(e11, aVar.a())) {
                kotlinx.coroutines.k.d(d1(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
            } else if (androidx.compose.ui.input.pointer.q.i(e11, aVar.b())) {
                kotlinx.coroutines.k.d(d1(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
        if (this.f2608y == null) {
            this.f2608y = (n0) D1(l0.a(new AbstractClickableNode$onPointerEvent$3(this, null)));
        }
        n0 n0Var = this.f2608y;
        if (n0Var != null) {
            n0Var.M(oVar, pointerEventPass, j11);
        }
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean O() {
        return h1.a(this);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean P0() {
        return d1.d(this);
    }

    public void P1(androidx.compose.ui.semantics.n nVar) {
    }

    public abstract Object Q1(androidx.compose.ui.input.pointer.e0 e0Var, Continuation continuation);

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean R() {
        return d1.a(this);
    }

    @Override // androidx.compose.ui.node.i1
    public final void R0(androidx.compose.ui.semantics.n nVar) {
        androidx.compose.ui.semantics.f fVar = this.f2602s;
        if (fVar != null) {
            Intrinsics.e(fVar);
            SemanticsPropertiesKt.B(nVar, fVar.n());
        }
        SemanticsPropertiesKt.l(nVar, this.f2601r, new Function0<Boolean>() { // from class: androidx.compose.foundation.AbstractClickableNode$applySemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                AbstractClickableNode.this.W1().invoke();
                return Boolean.TRUE;
            }
        });
        if (this.f2603t) {
            this.f2607x.R0(nVar);
        } else {
            SemanticsPropertiesKt.f(nVar);
        }
        P1(nVar);
    }

    @Override // androidx.compose.ui.focus.c
    public final void S0(androidx.compose.ui.focus.r rVar) {
        if (rVar.isFocused()) {
            Y1();
        }
        if (this.f2603t) {
            this.f2607x.S0(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void S1() {
        p.i iVar = this.f2599p;
        if (iVar != null) {
            k.b bVar = this.A;
            if (bVar != null) {
                iVar.a(new k.a(bVar));
            }
            p.d dVar = this.B;
            if (dVar != null) {
                iVar.a(new p.e(dVar));
            }
            Iterator it = this.C.values().iterator();
            while (it.hasNext()) {
                iVar.a(new k.a((k.b) it.next()));
            }
        }
        this.A = null;
        this.B = null;
        this.C.clear();
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void T0() {
        d1.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean V1() {
        return this.f2603t;
    }

    @Override // androidx.compose.ui.node.i1
    public final boolean W0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function0 W1() {
        return this.f2604u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object X1(androidx.compose.foundation.gestures.i iVar, long j11, Continuation continuation) {
        Object e11;
        p.i iVar2 = this.f2599p;
        return (iVar2 == null || (e11 = o0.e(new AbstractClickableNode$handlePressInteraction$2$1(iVar, j11, iVar2, this, null), continuation)) != IntrinsicsKt.f()) ? Unit.f67184a : e11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Unit Z1() {
        n0 n0Var = this.f2608y;
        if (n0Var == null) {
            return null;
        }
        n0Var.j0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r2.f2609z == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b2(p.i r3, androidx.compose.foundation.b0 r4, boolean r5, java.lang.String r6, androidx.compose.ui.semantics.f r7, kotlin.jvm.functions.Function0 r8) {
        /*
            r2 = this;
            p.i r0 = r2.E
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r3)
            r1 = 1
            if (r0 != 0) goto L12
            r2.S1()
            r2.E = r3
            r2.f2599p = r3
            r3 = r1
            goto L13
        L12:
            r3 = 0
        L13:
            androidx.compose.foundation.b0 r0 = r2.f2600q
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r4)
            if (r0 != 0) goto L1e
            r2.f2600q = r4
            r3 = r1
        L1e:
            boolean r4 = r2.f2603t
            if (r4 == r5) goto L41
            if (r5 == 0) goto L2f
            androidx.compose.foundation.q r4 = r2.f2606w
            r2.D1(r4)
            androidx.compose.foundation.FocusableNode r4 = r2.f2607x
            r2.D1(r4)
            goto L3c
        L2f:
            androidx.compose.foundation.q r4 = r2.f2606w
            r2.G1(r4)
            androidx.compose.foundation.FocusableNode r4 = r2.f2607x
            r2.G1(r4)
            r2.S1()
        L3c:
            androidx.compose.ui.node.j1.b(r2)
            r2.f2603t = r5
        L41:
            java.lang.String r4 = r2.f2601r
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r4, r6)
            if (r4 != 0) goto L4e
            r2.f2601r = r6
            androidx.compose.ui.node.j1.b(r2)
        L4e:
            androidx.compose.ui.semantics.f r4 = r2.f2602s
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r4, r7)
            if (r4 != 0) goto L5b
            r2.f2602s = r7
            androidx.compose.ui.node.j1.b(r2)
        L5b:
            r2.f2604u = r8
            boolean r4 = r2.F
            boolean r5 = r2.a2()
            if (r4 == r5) goto L72
            boolean r4 = r2.a2()
            r2.F = r4
            if (r4 != 0) goto L72
            androidx.compose.ui.node.f r4 = r2.f2609z
            if (r4 != 0) goto L72
            goto L73
        L72:
            r1 = r3
        L73:
            if (r1 == 0) goto L88
            androidx.compose.ui.node.f r3 = r2.f2609z
            if (r3 != 0) goto L7d
            boolean r4 = r2.F
            if (r4 != 0) goto L88
        L7d:
            if (r3 == 0) goto L82
            r2.G1(r3)
        L82:
            r3 = 0
            r2.f2609z = r3
            r2.Y1()
        L88:
            androidx.compose.foundation.FocusableNode r3 = r2.f2607x
            p.i r4 = r2.f2599p
            r3.J1(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.b2(p.i, androidx.compose.foundation.b0, boolean, java.lang.String, androidx.compose.ui.semantics.f, kotlin.jvm.functions.Function0):void");
    }

    @Override // androidx.compose.ui.f.c
    public final boolean i1() {
        return this.f2605v;
    }

    @Override // d0.e
    public final boolean l0(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.ui.f.c
    public final void n1() {
        if (!this.F) {
            Y1();
        }
        if (this.f2603t) {
            D1(this.f2606w);
            D1(this.f2607x);
        }
    }

    @Override // androidx.compose.ui.f.c
    public final void o1() {
        S1();
        if (this.E == null) {
            this.f2599p = null;
        }
        androidx.compose.ui.node.f fVar = this.f2609z;
        if (fVar != null) {
            G1(fVar);
        }
        this.f2609z = null;
    }

    @Override // d0.e
    public final boolean s0(KeyEvent keyEvent) {
        Y1();
        if (this.f2603t && f.f(keyEvent)) {
            if (this.C.containsKey(d0.a.m(d0.d.a(keyEvent)))) {
                return false;
            }
            k.b bVar = new k.b(this.D, null);
            this.C.put(d0.a.m(d0.d.a(keyEvent)), bVar);
            if (this.f2599p != null) {
                kotlinx.coroutines.k.d(d1(), null, null, new AbstractClickableNode$onKeyEvent$1(this, bVar, null), 3, null);
            }
        } else {
            if (!this.f2603t || !f.b(keyEvent)) {
                return false;
            }
            k.b bVar2 = (k.b) this.C.remove(d0.a.m(d0.d.a(keyEvent)));
            if (bVar2 != null && this.f2599p != null) {
                kotlinx.coroutines.k.d(d1(), null, null, new AbstractClickableNode$onKeyEvent$2$1(this, bVar2, null), 3, null);
            }
            this.f2604u.invoke();
        }
        return true;
    }

    @Override // androidx.compose.ui.node.e1
    public final void t0() {
        p.d dVar;
        p.i iVar = this.f2599p;
        if (iVar != null && (dVar = this.B) != null) {
            iVar.a(new p.e(dVar));
        }
        this.B = null;
        n0 n0Var = this.f2608y;
        if (n0Var != null) {
            n0Var.t0();
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void z0() {
        d1.b(this);
    }
}
