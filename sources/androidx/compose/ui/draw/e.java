package androidx.compose.ui.draw;

import androidx.compose.ui.f;
import androidx.compose.ui.node.m;
import androidx.compose.ui.node.n;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class e extends f.c implements n {

    /* renamed from: n, reason: collision with root package name */
    private Function1 f4245n;

    public e(Function1 function1) {
        this.f4245n = function1;
    }

    public final void D1(Function1 function1) {
        this.f4245n = function1;
    }

    @Override // androidx.compose.ui.node.n
    public void n(z.c cVar) {
        this.f4245n.invoke(cVar);
        cVar.Y0();
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void w0() {
        m.a(this);
    }
}
