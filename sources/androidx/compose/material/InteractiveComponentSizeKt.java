package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public abstract class InteractiveComponentSizeKt {

    /* renamed from: a, reason: collision with root package name */
    private static final s1 f3434a;

    /* renamed from: b, reason: collision with root package name */
    private static final s1 f3435b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f3436c;

    static {
        s1 f11 = CompositionLocalKt.f(new Function0<Boolean>() { // from class: androidx.compose.material.InteractiveComponentSizeKt$LocalMinimumInteractiveComponentEnforcement$1
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        });
        f3434a = f11;
        f3435b = f11;
        float f12 = 48;
        f3436c = o0.j.b(o0.i.g(f12), o0.i.g(f12));
    }

    public static final s1 b() {
        return f3434a;
    }

    public static final androidx.compose.ui.f c(androidx.compose.ui.f fVar) {
        return fVar.e(MinimumInteractiveModifier.f3437b);
    }
}
