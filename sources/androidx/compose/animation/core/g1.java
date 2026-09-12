package androidx.compose.animation.core;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import o0.i;
import y.g;
import y.i;
import y.m;

/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    private static final y.i f2523a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map f2524b;

    static {
        Float valueOf = Float.valueOf(0.5f);
        f2523a = new y.i(0.5f, 0.5f, 0.5f, 0.5f);
        s0 c11 = VectorConvertersKt.c(IntCompanionObject.f67405a);
        Float valueOf2 = Float.valueOf(1.0f);
        Pair a11 = TuplesKt.a(c11, valueOf2);
        Pair a12 = TuplesKt.a(VectorConvertersKt.g(o0.t.f70747b), valueOf2);
        Pair a13 = TuplesKt.a(VectorConvertersKt.f(o0.p.f70738b), valueOf2);
        Pair a14 = TuplesKt.a(VectorConvertersKt.b(FloatCompanionObject.f67404a), Float.valueOf(0.01f));
        Pair a15 = TuplesKt.a(VectorConvertersKt.i(y.i.f78598e), valueOf);
        Pair a16 = TuplesKt.a(VectorConvertersKt.j(y.m.f78614b), valueOf);
        Pair a17 = TuplesKt.a(VectorConvertersKt.h(y.g.f78593b), valueOf);
        s0 d11 = VectorConvertersKt.d(o0.i.f70726b);
        Float valueOf3 = Float.valueOf(0.1f);
        f2524b = MapsKt.l(a11, a12, a13, a14, a15, a16, a17, TuplesKt.a(d11, valueOf3), TuplesKt.a(VectorConvertersKt.e(o0.k.f70731b), valueOf3));
    }

    public static final float a(i.a aVar) {
        return o0.i.g(0.1f);
    }

    public static final long b(g.a aVar) {
        return y.h.a(0.5f, 0.5f);
    }

    public static final long c(m.a aVar) {
        return y.n.a(0.5f, 0.5f);
    }

    public static final y.i d(i.a aVar) {
        return f2523a;
    }
}
