package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.s0;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.d0;
import androidx.compose.foundation.lazy.layout.e0;
import androidx.compose.foundation.lazy.layout.x;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.snapshots.j;
import androidx.compose.runtime.u2;
import androidx.compose.ui.layout.h0;
import androidx.compose.ui.layout.i0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.n0;

/* loaded from: classes.dex */
public final class LazyListState implements androidx.compose.foundation.gestures.o {

    /* renamed from: y, reason: collision with root package name */
    public static final a f2981y = new a(null);

    /* renamed from: z, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f2982z = ListSaverKt.a(new Function2<androidx.compose.runtime.saveable.e, LazyListState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Integer> invoke(androidx.compose.runtime.saveable.e eVar, LazyListState lazyListState) {
            return CollectionsKt.o(Integer.valueOf(lazyListState.o()), Integer.valueOf(lazyListState.p()));
        }
    }, new Function1<List<? extends Integer>, LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final LazyListState invoke(List<Integer> list) {
            return new LazyListState(list.get(0).intValue(), list.get(1).intValue());
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final r f2983a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2984b;

    /* renamed from: c, reason: collision with root package name */
    private m f2985c;

    /* renamed from: d, reason: collision with root package name */
    private final v f2986d;

    /* renamed from: e, reason: collision with root package name */
    private final e f2987e;

    /* renamed from: f, reason: collision with root package name */
    private final i1 f2988f;

    /* renamed from: g, reason: collision with root package name */
    private final p.i f2989g;

    /* renamed from: h, reason: collision with root package name */
    private float f2990h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.compose.foundation.gestures.o f2991i;

    /* renamed from: j, reason: collision with root package name */
    private int f2992j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2993k;

    /* renamed from: l, reason: collision with root package name */
    private h0 f2994l;

    /* renamed from: m, reason: collision with root package name */
    private final i0 f2995m;

    /* renamed from: n, reason: collision with root package name */
    private final AwaitFirstLayoutModifier f2996n;

    /* renamed from: o, reason: collision with root package name */
    private final LazyLayoutItemAnimator f2997o;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.compose.foundation.lazy.layout.e f2998p;

    /* renamed from: q, reason: collision with root package name */
    private final x f2999q;

    /* renamed from: r, reason: collision with root package name */
    private final p f3000r;

    /* renamed from: s, reason: collision with root package name */
    private final androidx.compose.foundation.lazy.layout.w f3001s;

    /* renamed from: t, reason: collision with root package name */
    private final i1 f3002t;

    /* renamed from: u, reason: collision with root package name */
    private final i1 f3003u;

    /* renamed from: v, reason: collision with root package name */
    private final i1 f3004v;

    /* renamed from: w, reason: collision with root package name */
    private final i1 f3005w;

    /* renamed from: x, reason: collision with root package name */
    private androidx.compose.animation.core.i f3006x;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final androidx.compose.runtime.saveable.d a() {
            return LazyListState.f2982z;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements p {
        b() {
        }

        @Override // androidx.compose.foundation.lazy.p
        public x.b a(int i11) {
            j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
            LazyListState lazyListState = LazyListState.this;
            androidx.compose.runtime.snapshots.j d11 = aVar.d();
            Function1 h11 = d11 != null ? d11.h() : null;
            androidx.compose.runtime.snapshots.j f11 = aVar.f(d11);
            try {
                long k11 = ((m) lazyListState.f2988f.getValue()).k();
                aVar.m(d11, f11, h11);
                return LazyListState.this.z().e(i11, k11);
            } catch (Throwable th2) {
                aVar.m(d11, f11, h11);
                throw th2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements i0 {
        c() {
        }

        @Override // androidx.compose.ui.f
        public /* synthetic */ Object b(Object obj, Function2 function2) {
            return androidx.compose.ui.g.b(this, obj, function2);
        }

        @Override // androidx.compose.ui.f
        public /* synthetic */ boolean c(Function1 function1) {
            return androidx.compose.ui.g.a(this, function1);
        }

        @Override // androidx.compose.ui.layout.i0
        public void d(h0 h0Var) {
            LazyListState.this.f2994l = h0Var;
        }

        @Override // androidx.compose.ui.f
        public /* synthetic */ androidx.compose.ui.f e(androidx.compose.ui.f fVar) {
            return androidx.compose.ui.e.a(this, fVar);
        }
    }

    public LazyListState() {
        this(0, 0, null, 7, null);
    }

    public LazyListState(int i11, int i12) {
        this(i11, i12, s.b(0, 1, null));
    }

    public LazyListState(final int i11, int i12, r rVar) {
        m mVar;
        i1 c11;
        i1 c12;
        androidx.compose.animation.core.i b11;
        this.f2983a = rVar;
        v vVar = new v(i11, i12);
        this.f2986d = vVar;
        this.f2987e = new e(this);
        mVar = LazyListStateKt.f3010b;
        this.f2988f = r2.e(mVar, r2.g());
        this.f2989g = p.h.a();
        this.f2991i = androidx.compose.foundation.gestures.p.a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.LazyListState$scrollableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float f11) {
                return Float.valueOf(-LazyListState.this.F(-f11));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        });
        this.f2993k = true;
        this.f2995m = new c();
        this.f2996n = new AwaitFirstLayoutModifier();
        this.f2997o = new LazyLayoutItemAnimator();
        this.f2998p = new androidx.compose.foundation.lazy.layout.e();
        this.f2999q = new x(rVar.c(), new Function1<d0, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListState$prefetchState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((d0) obj);
                return Unit.f67184a;
            }

            public final void invoke(d0 d0Var) {
                r rVar2;
                rVar2 = LazyListState.this.f2983a;
                int i13 = i11;
                j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
                androidx.compose.runtime.snapshots.j d11 = aVar.d();
                aVar.m(d11, aVar.f(d11), d11 != null ? d11.h() : null);
                rVar2.a(d0Var, i13);
            }
        });
        this.f3000r = new b();
        this.f3001s = new androidx.compose.foundation.lazy.layout.w();
        vVar.b();
        this.f3002t = e0.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        c11 = u2.c(bool, null, 2, null);
        this.f3003u = c11;
        c12 = u2.c(bool, null, 2, null);
        this.f3004v = c12;
        this.f3005w = e0.c(null, 1, null);
        s0 b12 = VectorConvertersKt.b(FloatCompanionObject.f67404a);
        Float valueOf = Float.valueOf(0.0f);
        b11 = androidx.compose.animation.core.j.b(b12, valueOf, valueOf, (r19 & 8) != 0 ? Long.MIN_VALUE : 0L, (r19 & 16) != 0 ? Long.MIN_VALUE : 0L, (r19 & 32) != 0 ? false : false);
        this.f3006x = b11;
    }

    public /* synthetic */ LazyListState(int i11, int i12, r rVar, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? s.b(0, 1, null) : rVar);
    }

    private final void E(float f11, l lVar) {
        if (this.f2993k) {
            this.f2983a.b(this.f3000r, f11, lVar);
        }
    }

    public static /* synthetic */ Object H(LazyListState lazyListState, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return lazyListState.G(i11, i12, continuation);
    }

    private void I(boolean z10) {
        this.f3004v.setValue(Boolean.valueOf(z10));
    }

    private void J(boolean z10) {
        this.f3003u.setValue(Boolean.valueOf(z10));
    }

    private final void L(float f11, o0.e eVar, n0 n0Var) {
        float f12;
        f12 = LazyListStateKt.f3009a;
        if (f11 <= eVar.E0(f12)) {
            return;
        }
        j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
        androidx.compose.runtime.snapshots.j d11 = aVar.d();
        Function1 h11 = d11 != null ? d11.h() : null;
        androidx.compose.runtime.snapshots.j f13 = aVar.f(d11);
        try {
            float floatValue = ((Number) this.f3006x.getValue()).floatValue();
            if (this.f3006x.h()) {
                this.f3006x = androidx.compose.animation.core.j.g(this.f3006x, floatValue - f11, 0.0f, 0L, 0L, false, 30, null);
                kotlinx.coroutines.k.d(n0Var, null, null, new LazyListState$updateScrollDeltaForPostLookahead$2$1(this, null), 3, null);
            } else {
                this.f3006x = new androidx.compose.animation.core.i(VectorConvertersKt.b(FloatCompanionObject.f67404a), Float.valueOf(-f11), null, 0L, 0L, false, 60, null);
                kotlinx.coroutines.k.d(n0Var, null, null, new LazyListState$updateScrollDeltaForPostLookahead$2$2(this, null), 3, null);
            }
            aVar.m(d11, f13, h11);
        } catch (Throwable th2) {
            aVar.m(d11, f13, h11);
            throw th2;
        }
    }

    public static /* synthetic */ void l(LazyListState lazyListState, m mVar, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        lazyListState.k(mVar, z10, z11);
    }

    public final h0 A() {
        return this.f2994l;
    }

    public final i0 B() {
        return this.f2995m;
    }

    public final float C() {
        return ((Number) this.f3006x.getValue()).floatValue();
    }

    public final float D() {
        return this.f2990h;
    }

    public final float F(float f11) {
        if ((f11 < 0.0f && !d()) || (f11 > 0.0f && !b())) {
            return 0.0f;
        }
        if (Math.abs(this.f2990h) > 0.5f) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.f2990h).toString());
        }
        float f12 = this.f2990h + f11;
        this.f2990h = f12;
        if (Math.abs(f12) > 0.5f) {
            m mVar = (m) this.f2988f.getValue();
            float f13 = this.f2990h;
            int round = Math.round(f13);
            m mVar2 = this.f2985c;
            boolean r11 = mVar.r(round, !this.f2984b);
            if (r11 && mVar2 != null) {
                r11 = mVar2.r(round, true);
            }
            if (r11) {
                k(mVar, this.f2984b, true);
                e0.d(this.f3005w);
                E(f13 - this.f2990h, mVar);
            } else {
                h0 h0Var = this.f2994l;
                if (h0Var != null) {
                    h0Var.d();
                }
                E(f13 - this.f2990h, t());
            }
        }
        if (Math.abs(this.f2990h) <= 0.5f) {
            return f11;
        }
        float f14 = f11 - this.f2990h;
        this.f2990h = 0.0f;
        return f14;
    }

    public final Object G(int i11, int i12, Continuation continuation) {
        Object c11 = androidx.compose.foundation.gestures.n.c(this, null, new LazyListState$scrollToItem$2(this, i11, i12, null), continuation, 1, null);
        return c11 == IntrinsicsKt.f() ? c11 : Unit.f67184a;
    }

    public final void K(int i11, int i12, boolean z10) {
        if (this.f2986d.a() != i11 || this.f2986d.c() != i12) {
            this.f2997o.n();
        }
        this.f2986d.d(i11, i12);
        if (!z10) {
            e0.d(this.f3002t);
            return;
        }
        h0 h0Var = this.f2994l;
        if (h0Var != null) {
            h0Var.d();
        }
    }

    public final int M(k kVar, int i11) {
        return this.f2986d.j(kVar, i11);
    }

    @Override // androidx.compose.foundation.gestures.o
    public boolean a() {
        return this.f2991i.a();
    }

    @Override // androidx.compose.foundation.gestures.o
    public boolean b() {
        return ((Boolean) this.f3004v.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.LazyListState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L6c
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.L$2
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.L$1
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.lazy.LazyListState r2 = (androidx.compose.foundation.lazy.LazyListState) r2
            kotlin.ResultKt.b(r8)
            goto L5a
        L45:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.f2996n
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r8.a(r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            r2 = r5
        L5a:
            androidx.compose.foundation.gestures.o r8 = r2.f2991i
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.c(r6, r7, r0)
            if (r6 != r1) goto L6c
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.c(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.o
    public boolean d() {
        return ((Boolean) this.f3003u.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.o
    public float e(float f11) {
        return this.f2991i.e(f11);
    }

    public final void k(m mVar, boolean z10, boolean z11) {
        if (!z10 && this.f2984b) {
            this.f2985c = mVar;
            return;
        }
        if (z10) {
            this.f2984b = true;
        }
        I(mVar.i());
        J(mVar.j());
        this.f2990h -= mVar.l();
        this.f2988f.setValue(mVar);
        if (z11) {
            this.f2986d.i(mVar.p());
        } else {
            this.f2986d.h(mVar);
            if (this.f2993k) {
                this.f2983a.d(this.f3000r, mVar);
            }
        }
        if (z10) {
            L(mVar.q(), mVar.n(), mVar.m());
        }
        this.f2992j++;
    }

    public final AwaitFirstLayoutModifier m() {
        return this.f2996n;
    }

    public final androidx.compose.foundation.lazy.layout.e n() {
        return this.f2998p;
    }

    public final int o() {
        return this.f2986d.a();
    }

    public final int p() {
        return this.f2986d.c();
    }

    public final boolean q() {
        return this.f2984b;
    }

    public final p.i r() {
        return this.f2989g;
    }

    public final LazyLayoutItemAnimator s() {
        return this.f2997o;
    }

    public final l t() {
        return (l) this.f2988f.getValue();
    }

    public final i1 u() {
        return this.f3002t;
    }

    public final IntRange v() {
        return (IntRange) this.f2986d.b().getValue();
    }

    public final androidx.compose.foundation.lazy.layout.w w() {
        return this.f3001s;
    }

    public final i1 x() {
        return this.f3005w;
    }

    public final m y() {
        return this.f2985c;
    }

    public final x z() {
        return this.f2999q;
    }
}
