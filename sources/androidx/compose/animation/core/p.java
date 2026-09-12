package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class p {
    public static final k a(float f11) {
        return new k(f11);
    }

    public static final l b(float f11, float f12) {
        return new l(f11, f12);
    }

    public static final m c(float f11, float f12, float f13) {
        return new m(f11, f12, f13);
    }

    public static final n d(float f11, float f12, float f13, float f14) {
        return new n(f11, f12, f13, f14);
    }

    public static final o e(o oVar) {
        o g11 = g(oVar);
        int b11 = g11.b();
        for (int i11 = 0; i11 < b11; i11++) {
            g11.e(i11, oVar.a(i11));
        }
        return g11;
    }

    public static final void f(o oVar, o oVar2) {
        int b11 = oVar.b();
        for (int i11 = 0; i11 < b11; i11++) {
            oVar.e(i11, oVar2.a(i11));
        }
    }

    public static final o g(o oVar) {
        o c11 = oVar.c();
        Intrinsics.f(c11, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return c11;
    }
}
