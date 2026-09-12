package androidx.compose.ui.draw;

import androidx.collection.l0;
import androidx.collection.r0;
import androidx.compose.ui.graphics.a4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;

/* loaded from: classes.dex */
final class k implements a4 {

    /* renamed from: a, reason: collision with root package name */
    private l0 f4251a;

    /* renamed from: b, reason: collision with root package name */
    private a4 f4252b;

    @Override // androidx.compose.ui.graphics.a4
    public GraphicsLayer a() {
        a4 a4Var = this.f4252b;
        if (!(a4Var != null)) {
            g0.a.b("GraphicsContext not provided");
        }
        GraphicsLayer a11 = a4Var.a();
        l0 l0Var = this.f4251a;
        if (l0Var == null) {
            this.f4251a = r0.b(a11);
        } else {
            l0Var.e(a11);
        }
        return a11;
    }

    @Override // androidx.compose.ui.graphics.a4
    public void b(GraphicsLayer graphicsLayer) {
        a4 a4Var = this.f4252b;
        if (a4Var != null) {
            a4Var.b(graphicsLayer);
        }
    }

    public final a4 c() {
        return this.f4252b;
    }

    public final void d() {
        l0 l0Var = this.f4251a;
        if (l0Var != null) {
            Object[] objArr = l0Var.f2319a;
            int i11 = l0Var.f2320b;
            for (int i12 = 0; i12 < i11; i12++) {
                b((GraphicsLayer) objArr[i12]);
            }
            l0Var.f();
        }
    }

    public final void e(a4 a4Var) {
        d();
        this.f4252b = a4Var;
    }
}
