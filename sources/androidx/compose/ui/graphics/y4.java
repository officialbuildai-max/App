package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.graphics.u1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class y4 extends j1 {

    /* renamed from: c, reason: collision with root package name */
    private Shader f4991c;

    /* renamed from: d, reason: collision with root package name */
    private long f4992d;

    public y4() {
        super(null);
        this.f4992d = y.m.f78614b.a();
    }

    @Override // androidx.compose.ui.graphics.j1
    public final void a(long j11, m4 m4Var, float f11) {
        Shader shader = this.f4991c;
        if (shader == null || !y.m.f(this.f4992d, j11)) {
            if (y.m.k(j11)) {
                shader = null;
                this.f4991c = null;
                this.f4992d = y.m.f78614b.a();
            } else {
                shader = b(j11);
                this.f4991c = shader;
                this.f4992d = j11;
            }
        }
        long a11 = m4Var.a();
        u1.a aVar = u1.f4733b;
        if (!u1.m(a11, aVar.a())) {
            m4Var.s(aVar.a());
        }
        if (!Intrinsics.c(m4Var.y(), shader)) {
            m4Var.x(shader);
        }
        if (m4Var.getAlpha() == f11) {
            return;
        }
        m4Var.setAlpha(f11);
    }

    public abstract Shader b(long j11);
}
