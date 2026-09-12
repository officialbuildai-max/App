package androidx.compose.ui.layout;

import androidx.compose.ui.f;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
final class d0 extends f.c implements androidx.compose.ui.node.p {

    /* renamed from: n, reason: collision with root package name */
    private Function1 f5250n;

    public d0(Function1 function1) {
        this.f5250n = function1;
    }

    public final void D1(Function1 function1) {
        this.f5250n = function1;
    }

    @Override // androidx.compose.ui.node.p
    public void v(l lVar) {
        this.f5250n.invoke(lVar);
    }
}
