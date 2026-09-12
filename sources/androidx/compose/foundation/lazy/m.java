package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.n0;

/* loaded from: classes.dex */
public final class m implements l, androidx.compose.ui.layout.v {

    /* renamed from: a, reason: collision with root package name */
    private final n f3166a;

    /* renamed from: b, reason: collision with root package name */
    private int f3167b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3168c;

    /* renamed from: d, reason: collision with root package name */
    private float f3169d;

    /* renamed from: e, reason: collision with root package name */
    private final float f3170e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f3171f;

    /* renamed from: g, reason: collision with root package name */
    private final n0 f3172g;

    /* renamed from: h, reason: collision with root package name */
    private final o0.e f3173h;

    /* renamed from: i, reason: collision with root package name */
    private final long f3174i;

    /* renamed from: j, reason: collision with root package name */
    private final List f3175j;

    /* renamed from: k, reason: collision with root package name */
    private final int f3176k;

    /* renamed from: l, reason: collision with root package name */
    private final int f3177l;

    /* renamed from: m, reason: collision with root package name */
    private final int f3178m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f3179n;

    /* renamed from: o, reason: collision with root package name */
    private final Orientation f3180o;

    /* renamed from: p, reason: collision with root package name */
    private final int f3181p;

    /* renamed from: q, reason: collision with root package name */
    private final int f3182q;

    /* renamed from: r, reason: collision with root package name */
    private final /* synthetic */ androidx.compose.ui.layout.v f3183r;

    private m(n nVar, int i11, boolean z10, float f11, androidx.compose.ui.layout.v vVar, float f12, boolean z11, n0 n0Var, o0.e eVar, long j11, List list, int i12, int i13, int i14, boolean z12, Orientation orientation, int i15, int i16) {
        this.f3166a = nVar;
        this.f3167b = i11;
        this.f3168c = z10;
        this.f3169d = f11;
        this.f3170e = f12;
        this.f3171f = z11;
        this.f3172g = n0Var;
        this.f3173h = eVar;
        this.f3174i = j11;
        this.f3175j = list;
        this.f3176k = i12;
        this.f3177l = i13;
        this.f3178m = i14;
        this.f3179n = z12;
        this.f3180o = orientation;
        this.f3181p = i15;
        this.f3182q = i16;
        this.f3183r = vVar;
    }

    public /* synthetic */ m(n nVar, int i11, boolean z10, float f11, androidx.compose.ui.layout.v vVar, float f12, boolean z11, n0 n0Var, o0.e eVar, long j11, List list, int i12, int i13, int i14, boolean z12, Orientation orientation, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(nVar, i11, z10, f11, vVar, f12, z11, n0Var, eVar, j11, list, i12, i13, i14, z12, orientation, i15, i16);
    }

    @Override // androidx.compose.foundation.lazy.l
    public long a() {
        return o0.u.a(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.lazy.l
    public int b() {
        return this.f3181p;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int c() {
        return this.f3177l;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int d() {
        return this.f3178m;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int e() {
        return -g();
    }

    @Override // androidx.compose.foundation.lazy.l
    public int f() {
        return this.f3182q;
    }

    @Override // androidx.compose.foundation.lazy.l
    public int g() {
        return this.f3176k;
    }

    @Override // androidx.compose.ui.layout.v
    public int getHeight() {
        return this.f3183r.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.l
    public Orientation getOrientation() {
        return this.f3180o;
    }

    @Override // androidx.compose.ui.layout.v
    public int getWidth() {
        return this.f3183r.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.l
    public List h() {
        return this.f3175j;
    }

    public final boolean i() {
        n nVar = this.f3166a;
        return ((nVar != null ? nVar.getIndex() : 0) == 0 && this.f3167b == 0) ? false : true;
    }

    public final boolean j() {
        return this.f3168c;
    }

    public final long k() {
        return this.f3174i;
    }

    public final float l() {
        return this.f3169d;
    }

    public final n0 m() {
        return this.f3172g;
    }

    public final o0.e n() {
        return this.f3173h;
    }

    public final n o() {
        return this.f3166a;
    }

    public final int p() {
        return this.f3167b;
    }

    public final float q() {
        return this.f3170e;
    }

    public final boolean r(int i11, boolean z10) {
        n nVar;
        boolean z11 = false;
        z11 = false;
        z11 = false;
        z11 = false;
        z11 = false;
        z11 = false;
        z11 = false;
        z11 = false;
        z11 = false;
        if (!this.f3171f && !h().isEmpty() && (nVar = this.f3166a) != null) {
            int h11 = nVar.h();
            int i12 = this.f3167b - i11;
            if (i12 >= 0 && i12 < h11) {
                n nVar2 = (n) CollectionsKt.i0(h());
                n nVar3 = (n) CollectionsKt.u0(h());
                if (!nVar2.p() && !nVar3.p() && (i11 >= 0 ? Math.min(g() - nVar2.g(), c() - nVar3.g()) > i11 : Math.min((nVar2.g() + nVar2.h()) - g(), (nVar3.g() + nVar3.h()) - c()) > (-i11))) {
                    this.f3167b -= i11;
                    List h12 = h();
                    int size = h12.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        ((n) h12.get(i13)).l(i11, z10);
                    }
                    this.f3169d = i11;
                    z11 = true;
                    z11 = true;
                    z11 = true;
                    if (!this.f3168c && i11 > 0) {
                        this.f3168c = true;
                    }
                }
            }
        }
        return z11;
    }

    @Override // androidx.compose.ui.layout.v
    public Map v() {
        return this.f3183r.v();
    }

    @Override // androidx.compose.ui.layout.v
    public void w() {
        this.f3183r.w();
    }

    @Override // androidx.compose.ui.layout.v
    public Function1 x() {
        return this.f3183r.x();
    }
}
