package androidx.compose.animation.core;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class Animatable {

    /* renamed from: a, reason: collision with root package name */
    private final s0 f2449a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f2450b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2451c;

    /* renamed from: d, reason: collision with root package name */
    private final i f2452d;

    /* renamed from: e, reason: collision with root package name */
    private final i1 f2453e;

    /* renamed from: f, reason: collision with root package name */
    private final i1 f2454f;

    /* renamed from: g, reason: collision with root package name */
    private final MutatorMutex f2455g;

    /* renamed from: h, reason: collision with root package name */
    private final o0 f2456h;

    /* renamed from: i, reason: collision with root package name */
    private final o f2457i;

    /* renamed from: j, reason: collision with root package name */
    private final o f2458j;

    /* renamed from: k, reason: collision with root package name */
    private o f2459k;

    /* renamed from: l, reason: collision with root package name */
    private o f2460l;

    public Animatable(Object obj, s0 s0Var, Object obj2, String str) {
        i1 c11;
        i1 c12;
        this.f2449a = s0Var;
        this.f2450b = obj2;
        this.f2451c = str;
        this.f2452d = new i(s0Var, obj, null, 0L, 0L, false, 60, null);
        c11 = u2.c(Boolean.FALSE, null, 2, null);
        this.f2453e = c11;
        c12 = u2.c(obj, null, 2, null);
        this.f2454f = c12;
        this.f2455g = new MutatorMutex();
        this.f2456h = new o0(0.0f, 0.0f, obj2, 3, null);
        o m11 = m();
        o c13 = m11 instanceof k ? a.c() : m11 instanceof l ? a.d() : m11 instanceof m ? a.e() : a.f();
        Intrinsics.f(c13, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.f2457i = c13;
        o m12 = m();
        o g11 = m12 instanceof k ? a.g() : m12 instanceof l ? a.h() : m12 instanceof m ? a.i() : a.j();
        Intrinsics.f(g11, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.f2458j = g11;
        this.f2459k = c13;
        this.f2460l = g11;
    }

    public /* synthetic */ Animatable(Object obj, s0 s0Var, Object obj2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, s0Var, (i11 & 4) != 0 ? null : obj2, (i11 & 8) != 0 ? "Animatable" : str);
    }

    public static /* synthetic */ Object f(Animatable animatable, Object obj, g gVar, Object obj2, Function1 function1, Continuation continuation, int i11, Object obj3) {
        if ((i11 & 2) != 0) {
            gVar = animatable.f2456h;
        }
        g gVar2 = gVar;
        if ((i11 & 4) != 0) {
            obj2 = animatable.l();
        }
        Object obj4 = obj2;
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        return animatable.e(obj, gVar2, obj4, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(Object obj) {
        if (Intrinsics.c(this.f2459k, this.f2457i) && Intrinsics.c(this.f2460l, this.f2458j)) {
            return obj;
        }
        o oVar = (o) this.f2449a.a().invoke(obj);
        int b11 = oVar.b();
        boolean z10 = false;
        for (int i11 = 0; i11 < b11; i11++) {
            if (oVar.a(i11) < this.f2459k.a(i11) || oVar.a(i11) > this.f2460l.a(i11)) {
                oVar.e(i11, RangesKt.l(oVar.a(i11), this.f2459k.a(i11), this.f2460l.a(i11)));
                z10 = true;
            }
        }
        return z10 ? this.f2449a.b().invoke(oVar) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        i iVar = this.f2452d;
        iVar.g().d();
        iVar.j(Long.MIN_VALUE);
        o(false);
    }

    private final Object n(c cVar, Object obj, Function1 function1, Continuation continuation) {
        return MutatorMutex.e(this.f2455g, null, new Animatable$runAnimation$2(this, obj, cVar, this.f2452d.d(), function1, null), continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(boolean z10) {
        this.f2453e.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Object obj) {
        this.f2454f.setValue(obj);
    }

    public final Object e(Object obj, g gVar, Object obj2, Function1 function1, Continuation continuation) {
        return n(d.a(gVar, this.f2449a, k(), obj, obj2), obj2, function1, continuation);
    }

    public final i i() {
        return this.f2452d;
    }

    public final s0 j() {
        return this.f2449a;
    }

    public final Object k() {
        return this.f2452d.getValue();
    }

    public final Object l() {
        return this.f2449a.b().invoke(m());
    }

    public final o m() {
        return this.f2452d.g();
    }
}
