package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.animation.core.u;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.r;
import androidx.compose.runtime.s1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public abstract class BringIntoViewSpec_androidKt {

    /* renamed from: a, reason: collision with root package name */
    private static final s1 f2705a = CompositionLocalKt.e(new Function1<r, d>() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1
        @Override // kotlin.jvm.functions.Function1
        public final d invoke(r rVar) {
            return !((Context) rVar.c(AndroidCompositionLocals_androidKt.g())).getPackageManager().hasSystemFeature("android.software.leanback") ? d.f2791a.b() : BringIntoViewSpec_androidKt.b();
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final d f2706b = new a();

    /* loaded from: classes.dex */
    public static final class a implements d {

        /* renamed from: c, reason: collision with root package name */
        private final float f2708c;

        /* renamed from: b, reason: collision with root package name */
        private final float f2707b = 0.3f;

        /* renamed from: d, reason: collision with root package name */
        private final androidx.compose.animation.core.g f2709d = androidx.compose.animation.core.h.f(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 0, new u(0.25f, 0.1f, 0.25f, 1.0f), 2, null);

        a() {
        }

        @Override // androidx.compose.foundation.gestures.d
        public float a(float f11, float f12, float f13) {
            float abs = Math.abs((f12 + f11) - f11);
            boolean z10 = abs <= f13;
            float f14 = (this.f2707b * f13) - (this.f2708c * abs);
            float f15 = f13 - f14;
            if (z10 && f15 < abs) {
                f14 = f13 - abs;
            }
            return f11 - f14;
        }

        @Override // androidx.compose.foundation.gestures.d
        public androidx.compose.animation.core.g b() {
            return this.f2709d;
        }
    }

    public static final s1 a() {
        return f2705a;
    }

    public static final d b() {
        return f2706b;
    }
}
