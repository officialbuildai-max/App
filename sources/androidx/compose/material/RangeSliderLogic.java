package androidx.compose.material;

import androidx.compose.runtime.a3;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RangeSliderLogic {

    /* renamed from: a, reason: collision with root package name */
    private final p.i f3438a;

    /* renamed from: b, reason: collision with root package name */
    private final p.i f3439b;

    /* renamed from: c, reason: collision with root package name */
    private final a3 f3440c;

    /* renamed from: d, reason: collision with root package name */
    private final a3 f3441d;

    /* renamed from: e, reason: collision with root package name */
    private final a3 f3442e;

    public RangeSliderLogic(p.i iVar, p.i iVar2, a3 a3Var, a3 a3Var2, a3 a3Var3) {
        this.f3438a = iVar;
        this.f3439b = iVar2;
        this.f3440c = a3Var;
        this.f3441d = a3Var2;
        this.f3442e = a3Var3;
    }

    public final p.i a(boolean z10) {
        return z10 ? this.f3438a : this.f3439b;
    }

    public final void b(boolean z10, float f11, p.f fVar, n0 n0Var) {
        ((Function2) this.f3442e.getValue()).invoke(Boolean.valueOf(z10), Float.valueOf(f11 - ((Number) (z10 ? this.f3440c : this.f3441d).getValue()).floatValue()));
        kotlinx.coroutines.k.d(n0Var, null, null, new RangeSliderLogic$captureThumb$1(this, z10, fVar, null), 3, null);
    }

    public final int c(float f11) {
        return Float.compare(Math.abs(((Number) this.f3440c.getValue()).floatValue() - f11), Math.abs(((Number) this.f3441d.getValue()).floatValue() - f11));
    }
}
