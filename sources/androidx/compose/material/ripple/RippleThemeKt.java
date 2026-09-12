package androidx.compose.material.ripple;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public abstract class RippleThemeKt {

    /* renamed from: a, reason: collision with root package name */
    private static final s1 f3560a = CompositionLocalKt.f(new Function0<i>() { // from class: androidx.compose.material.ripple.RippleThemeKt$LocalRippleTheme$1
        @Override // kotlin.jvm.functions.Function0
        public final i invoke() {
            return a.f3569b;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final c f3561b = new c(0.16f, 0.24f, 0.08f, 0.24f);

    /* renamed from: c, reason: collision with root package name */
    private static final c f3562c = new c(0.08f, 0.12f, 0.04f, 0.12f);

    /* renamed from: d, reason: collision with root package name */
    private static final c f3563d = new c(0.08f, 0.12f, 0.04f, 0.1f);

    public static final s1 d() {
        return f3560a;
    }
}
