package androidx.compose.foundation;

import androidx.compose.ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class FocusableNode extends androidx.compose.ui.node.i implements androidx.compose.ui.focus.c, i1, androidx.compose.ui.node.p, androidx.compose.ui.focus.q {

    /* renamed from: p, reason: collision with root package name */
    private final boolean f2669p;

    /* renamed from: q, reason: collision with root package name */
    private androidx.compose.ui.focus.r f2670q;

    /* renamed from: r, reason: collision with root package name */
    private final FocusableInteractionNode f2671r;

    /* renamed from: s, reason: collision with root package name */
    private final FocusablePinnableContainerNode f2672s = (FocusablePinnableContainerNode) D1(new FocusablePinnableContainerNode());

    /* renamed from: t, reason: collision with root package name */
    private final s f2673t = (s) D1(new s());

    public FocusableNode(p.i iVar) {
        this.f2671r = (FocusableInteractionNode) D1(new FocusableInteractionNode(iVar));
        D1(androidx.compose.ui.focus.t.a());
    }

    public final void J1(p.i iVar) {
        this.f2671r.G1(iVar);
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean O() {
        return h1.a(this);
    }

    @Override // androidx.compose.ui.node.i1
    public void R0(androidx.compose.ui.semantics.n nVar) {
        androidx.compose.ui.focus.r rVar = this.f2670q;
        boolean z10 = false;
        if (rVar != null && rVar.isFocused()) {
            z10 = true;
        }
        SemanticsPropertiesKt.w(nVar, z10);
        SemanticsPropertiesKt.o(nVar, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableNode$applySemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(FocusRequesterModifierNodeKt.a(FocusableNode.this));
            }
        }, 1, null);
    }

    @Override // androidx.compose.ui.focus.c
    public void S0(androidx.compose.ui.focus.r rVar) {
        if (Intrinsics.c(this.f2670q, rVar)) {
            return;
        }
        boolean isFocused = rVar.isFocused();
        if (isFocused) {
            kotlinx.coroutines.k.d(d1(), null, null, new FocusableNode$onFocusEvent$1(this, null), 3, null);
        }
        if (k1()) {
            j1.b(this);
        }
        this.f2671r.F1(isFocused);
        this.f2673t.F1(isFocused);
        this.f2672s.E1(isFocused);
        this.f2670q = rVar;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean W0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return this.f2669p;
    }

    @Override // androidx.compose.ui.node.p
    public void v(androidx.compose.ui.layout.l lVar) {
        this.f2673t.v(lVar);
    }
}
