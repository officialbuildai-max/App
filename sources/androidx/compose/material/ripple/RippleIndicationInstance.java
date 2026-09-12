package androidx.compose.material.ripple;

import androidx.compose.foundation.y;
import androidx.compose.runtime.a3;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.n0;
import p.k;

/* loaded from: classes.dex */
public abstract class RippleIndicationInstance implements y {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3545a;

    /* renamed from: b, reason: collision with root package name */
    private final StateLayer f3546b;

    public RippleIndicationInstance(boolean z10, final a3 a3Var) {
        this.f3545a = z10;
        this.f3546b = new StateLayer(z10, new Function0<c>() { // from class: androidx.compose.material.ripple.RippleIndicationInstance$stateLayer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) a3.this.getValue();
            }
        });
    }

    public abstract void b(k.b bVar, n0 n0Var);

    public final void c(z.g gVar, float f11, long j11) {
        this.f3546b.b(gVar, Float.isNaN(f11) ? d.a(gVar, this.f3545a, gVar.i()) : gVar.E0(f11), j11);
    }

    public abstract void d(k.b bVar);

    public final void e(p.f fVar, n0 n0Var) {
        this.f3546b.c(fVar, n0Var);
    }
}
