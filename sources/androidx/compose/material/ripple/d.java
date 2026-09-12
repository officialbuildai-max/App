package androidx.compose.material.ripple;

import y.m;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final float f3574a = o0.i.g(10);

    public static final float a(o0.e eVar, boolean z10, long j11) {
        float k11 = y.g.k(y.h.a(m.i(j11), m.g(j11))) / 2.0f;
        return z10 ? k11 + eVar.E0(f3574a) : k11;
    }

    public static final float b(long j11) {
        return Math.max(m.i(j11), m.g(j11)) * 0.3f;
    }
}
