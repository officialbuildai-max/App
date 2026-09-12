package androidx.compose.ui.semantics;

import androidx.compose.ui.f;
import androidx.compose.ui.node.i1;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class c extends f.c implements i1 {

    /* renamed from: n, reason: collision with root package name */
    private boolean f6031n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6032o;

    /* renamed from: p, reason: collision with root package name */
    private Function1 f6033p;

    public c(boolean z10, boolean z11, Function1 function1) {
        this.f6031n = z10;
        this.f6032o = z11;
        this.f6033p = function1;
    }

    public final void D1(boolean z10) {
        this.f6031n = z10;
    }

    public final void E1(Function1 function1) {
        this.f6033p = function1;
    }

    @Override // androidx.compose.ui.node.i1
    public boolean O() {
        return this.f6032o;
    }

    @Override // androidx.compose.ui.node.i1
    public void R0(n nVar) {
        this.f6033p.invoke(nVar);
    }

    @Override // androidx.compose.ui.node.i1
    public boolean W0() {
        return this.f6031n;
    }
}
