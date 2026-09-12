package androidx.compose.animation.core;

import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    private static final k f2474a = p.a(Float.POSITIVE_INFINITY);

    /* renamed from: b */
    private static final l f2475b = p.b(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: c */
    private static final m f2476c = p.c(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: d */
    private static final n f2477d = p.d(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: e */
    private static final k f2478e = p.a(Float.NEGATIVE_INFINITY);

    /* renamed from: f */
    private static final l f2479f = p.b(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* renamed from: g */
    private static final m f2480g = p.c(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* renamed from: h */
    private static final n f2481h = p.d(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static final Animatable a(float f11, float f12) {
        return new Animatable(Float.valueOf(f11), VectorConvertersKt.b(FloatCompanionObject.f67404a), Float.valueOf(f12), null, 8, null);
    }

    public static /* synthetic */ Animatable b(float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = 0.01f;
        }
        return a(f11, f12);
    }

    public static final /* synthetic */ k c() {
        return f2478e;
    }

    public static final /* synthetic */ l d() {
        return f2479f;
    }

    public static final /* synthetic */ m e() {
        return f2480g;
    }

    public static final /* synthetic */ n f() {
        return f2481h;
    }

    public static final /* synthetic */ k g() {
        return f2474a;
    }

    public static final /* synthetic */ l h() {
        return f2475b;
    }

    public static final /* synthetic */ m i() {
        return f2476c;
    }

    public static final /* synthetic */ n j() {
        return f2477d;
    }
}
