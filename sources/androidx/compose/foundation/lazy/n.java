package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.ui.b;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class n implements j, androidx.compose.foundation.lazy.layout.s {

    /* renamed from: a, reason: collision with root package name */
    private final int f3184a;

    /* renamed from: b, reason: collision with root package name */
    private final List f3185b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3186c;

    /* renamed from: d, reason: collision with root package name */
    private final b.InterfaceC0044b f3187d;

    /* renamed from: e, reason: collision with root package name */
    private final b.c f3188e;

    /* renamed from: f, reason: collision with root package name */
    private final LayoutDirection f3189f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f3190g;

    /* renamed from: h, reason: collision with root package name */
    private final int f3191h;

    /* renamed from: i, reason: collision with root package name */
    private final int f3192i;

    /* renamed from: j, reason: collision with root package name */
    private final int f3193j;

    /* renamed from: k, reason: collision with root package name */
    private final long f3194k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f3195l;

    /* renamed from: m, reason: collision with root package name */
    private final Object f3196m;

    /* renamed from: n, reason: collision with root package name */
    private final LazyLayoutItemAnimator f3197n;

    /* renamed from: o, reason: collision with root package name */
    private final long f3198o;

    /* renamed from: p, reason: collision with root package name */
    private int f3199p;

    /* renamed from: q, reason: collision with root package name */
    private final int f3200q;

    /* renamed from: r, reason: collision with root package name */
    private final int f3201r;

    /* renamed from: s, reason: collision with root package name */
    private final int f3202s;

    /* renamed from: t, reason: collision with root package name */
    private final int f3203t;

    /* renamed from: u, reason: collision with root package name */
    private final int f3204u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f3205v;

    /* renamed from: w, reason: collision with root package name */
    private int f3206w;

    /* renamed from: x, reason: collision with root package name */
    private int f3207x;

    /* renamed from: y, reason: collision with root package name */
    private int f3208y;

    /* renamed from: z, reason: collision with root package name */
    private final int[] f3209z;

    private n(int i11, List list, boolean z10, b.InterfaceC0044b interfaceC0044b, b.c cVar, LayoutDirection layoutDirection, boolean z11, int i12, int i13, int i14, long j11, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j12) {
        this.f3184a = i11;
        this.f3185b = list;
        this.f3186c = z10;
        this.f3187d = interfaceC0044b;
        this.f3188e = cVar;
        this.f3189f = layoutDirection;
        this.f3190g = z11;
        this.f3191h = i12;
        this.f3192i = i13;
        this.f3193j = i14;
        this.f3194k = j11;
        this.f3195l = obj;
        this.f3196m = obj2;
        this.f3197n = lazyLayoutItemAnimator;
        this.f3198o = j12;
        this.f3202s = 1;
        this.f3206w = Integer.MIN_VALUE;
        int size = list.size();
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            g0 g0Var = (g0) list.get(i17);
            i15 += e() ? g0Var.l0() : g0Var.u0();
            i16 = Math.max(i16, !e() ? g0Var.l0() : g0Var.u0());
        }
        this.f3200q = i15;
        this.f3203t = RangesKt.f(getSize() + this.f3193j, 0);
        this.f3204u = i16;
        this.f3209z = new int[this.f3185b.size() * 2];
    }

    public /* synthetic */ n(int i11, List list, boolean z10, b.InterfaceC0044b interfaceC0044b, b.c cVar, LayoutDirection layoutDirection, boolean z11, int i12, int i13, int i14, long j11, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, list, z10, interfaceC0044b, cVar, layoutDirection, z11, i12, i13, i14, j11, obj, obj2, lazyLayoutItemAnimator, j12);
    }

    private final int n(long j11) {
        return e() ? o0.p.i(j11) : o0.p.h(j11);
    }

    private final int o(g0 g0Var) {
        return e() ? g0Var.l0() : g0Var.u0();
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public long a() {
        return this.f3198o;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int b() {
        return this.f3185b.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public void c(boolean z10) {
        this.f3205v = z10;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int d() {
        return this.f3202s;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public boolean e() {
        return this.f3186c;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public void f(int i11, int i12, int i13, int i14) {
        r(i11, i13, i14);
    }

    @Override // androidx.compose.foundation.lazy.j
    public int g() {
        return this.f3199p;
    }

    @Override // androidx.compose.foundation.lazy.j, androidx.compose.foundation.lazy.layout.s
    public int getIndex() {
        return this.f3184a;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public Object getKey() {
        return this.f3195l;
    }

    @Override // androidx.compose.foundation.lazy.j
    public int getSize() {
        return this.f3200q;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int h() {
        return this.f3203t;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public Object i(int i11) {
        return ((g0) this.f3185b.get(i11)).G();
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public long j(int i11) {
        int[] iArr = this.f3209z;
        int i12 = i11 * 2;
        return o0.q.a(iArr[i12], iArr[i12 + 1]);
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int k() {
        return this.f3201r;
    }

    public final void l(int i11, boolean z10) {
        if (p()) {
            return;
        }
        this.f3199p = g() + i11;
        int length = this.f3209z.length;
        for (int i12 = 0; i12 < length; i12++) {
            if ((e() && i12 % 2 == 1) || (!e() && i12 % 2 == 0)) {
                int[] iArr = this.f3209z;
                iArr[i12] = iArr[i12] + i11;
            }
        }
        if (z10) {
            int b11 = b();
            for (int i13 = 0; i13 < b11; i13++) {
                this.f3197n.d(getKey(), i13);
            }
        }
    }

    public final int m() {
        return this.f3204u;
    }

    public boolean p() {
        return this.f3205v;
    }

    public final void q(g0.a aVar, boolean z10) {
        if (this.f3206w == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int b11 = b();
        for (int i11 = 0; i11 < b11; i11++) {
            g0 g0Var = (g0) this.f3185b.get(i11);
            o(g0Var);
            long j11 = j(i11);
            this.f3197n.d(getKey(), i11);
            if (this.f3190g) {
                j11 = o0.q.a(e() ? o0.p.h(j11) : (this.f3206w - o0.p.h(j11)) - o(g0Var), e() ? (this.f3206w - o0.p.i(j11)) - o(g0Var) : o0.p.i(j11));
            }
            long l11 = o0.p.l(j11, this.f3194k);
            if (e()) {
                g0.a.w(aVar, g0Var, l11, 0.0f, null, 6, null);
            } else {
                g0.a.q(aVar, g0Var, l11, 0.0f, null, 6, null);
            }
        }
    }

    public final void r(int i11, int i12, int i13) {
        int u02;
        this.f3199p = i11;
        this.f3206w = e() ? i13 : i12;
        List list = this.f3185b;
        int size = list.size();
        for (int i14 = 0; i14 < size; i14++) {
            g0 g0Var = (g0) list.get(i14);
            int i15 = i14 * 2;
            if (e()) {
                int[] iArr = this.f3209z;
                b.InterfaceC0044b interfaceC0044b = this.f3187d;
                if (interfaceC0044b == null) {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true");
                }
                iArr[i15] = interfaceC0044b.a(g0Var.u0(), i12, this.f3189f);
                this.f3209z[i15 + 1] = i11;
                u02 = g0Var.l0();
            } else {
                int[] iArr2 = this.f3209z;
                iArr2[i15] = i11;
                int i16 = i15 + 1;
                b.c cVar = this.f3188e;
                if (cVar == null) {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false");
                }
                iArr2[i16] = cVar.a(g0Var.l0(), i13);
                u02 = g0Var.u0();
            }
            i11 += u02;
        }
        this.f3207x = -this.f3191h;
        this.f3208y = this.f3206w + this.f3192i;
    }

    public final void s(int i11) {
        this.f3206w = i11;
        this.f3208y = i11 + this.f3192i;
    }
}
