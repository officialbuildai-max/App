package androidx.compose.material;

import androidx.compose.foundation.b0;
import androidx.compose.foundation.x;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import androidx.compose.ui.graphics.u1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import o0.i;

/* loaded from: classes.dex */
public abstract class RippleKt {

    /* renamed from: a, reason: collision with root package name */
    private static final s1 f3443a = CompositionLocalKt.f(new Function0<Boolean>() { // from class: androidx.compose.material.RippleKt$LocalUseFallbackRippleImplementation$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final s1 f3444b = CompositionLocalKt.d(null, new Function0<g>() { // from class: androidx.compose.material.RippleKt$LocalRippleConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        public final g invoke() {
            return new g(0L, null, 3, null);
        }
    }, 1, null);

    /* renamed from: c, reason: collision with root package name */
    private static final i f3445c;

    /* renamed from: d, reason: collision with root package name */
    private static final i f3446d;

    /* renamed from: e, reason: collision with root package name */
    private static final androidx.compose.material.ripple.c f3447e;

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.compose.material.ripple.c f3448f;

    /* renamed from: g, reason: collision with root package name */
    private static final androidx.compose.material.ripple.c f3449g;

    static {
        i.a aVar = o0.i.f70726b;
        float b11 = aVar.b();
        u1.a aVar2 = u1.f4733b;
        f3445c = new i(true, b11, aVar2.e(), (DefaultConstructorMarker) null);
        f3446d = new i(false, aVar.b(), aVar2.e(), (DefaultConstructorMarker) null);
        f3447e = new androidx.compose.material.ripple.c(0.16f, 0.24f, 0.08f, 0.24f);
        f3448f = new androidx.compose.material.ripple.c(0.08f, 0.12f, 0.04f, 0.12f);
        f3449g = new androidx.compose.material.ripple.c(0.08f, 0.12f, 0.04f, 0.1f);
    }

    public static final s1 d() {
        return f3444b;
    }

    public static final b0 e(boolean z10, float f11, long j11) {
        return (o0.i.i(f11, o0.i.f70726b.b()) && u1.m(j11, u1.f4733b.e())) ? z10 ? f3445c : f3446d : new i(z10, f11, j11, (DefaultConstructorMarker) null);
    }

    public static final x f(boolean z10, float f11, long j11, androidx.compose.runtime.i iVar, int i11, int i12) {
        x e11;
        if ((i12 & 1) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i12 & 2) != 0) {
            f11 = o0.i.f70726b.b();
        }
        float f12 = f11;
        if ((i12 & 4) != 0) {
            j11 = u1.f4733b.e();
        }
        long j12 = j11;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-58830494, i11, -1, "androidx.compose.material.rippleOrFallbackImplementation (Ripple.kt:264)");
        }
        if (((Boolean) iVar.l(f3443a)).booleanValue()) {
            iVar.P(96412190);
            e11 = androidx.compose.material.ripple.h.f(z11, f12, j12, iVar, i11 & 1022, 0);
            iVar.K();
        } else {
            iVar.P(96503175);
            iVar.K();
            e11 = e(z11, f12, j12);
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return e11;
    }
}
