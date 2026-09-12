package androidx.compose.ui.layout;

import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class c implements j, x {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.node.y f5236a;

    /* loaded from: classes.dex */
    public static final class a implements v {

        /* renamed from: a, reason: collision with root package name */
        private final int f5237a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5238b;

        /* renamed from: c, reason: collision with root package name */
        private final Map f5239c;

        /* renamed from: d, reason: collision with root package name */
        private final Function1 f5240d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f5241e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f5242f;

        a(int i11, int i12, Map map, Function1 function1, Function1 function12, c cVar) {
            this.f5241e = function12;
            this.f5242f = cVar;
            this.f5237a = i11;
            this.f5238b = i12;
            this.f5239c = map;
            this.f5240d = function1;
        }

        @Override // androidx.compose.ui.layout.v
        public int getHeight() {
            return this.f5238b;
        }

        @Override // androidx.compose.ui.layout.v
        public int getWidth() {
            return this.f5237a;
        }

        @Override // androidx.compose.ui.layout.v
        public Map v() {
            return this.f5239c;
        }

        @Override // androidx.compose.ui.layout.v
        public void w() {
            this.f5241e.invoke(this.f5242f.v().d1());
        }

        @Override // androidx.compose.ui.layout.v
        public Function1 x() {
            return this.f5240d;
        }
    }

    public c(androidx.compose.ui.node.y yVar, b bVar) {
        this.f5236a = yVar;
    }

    public final void B(b bVar) {
    }

    @Override // o0.n
    public float C0() {
        return this.f5236a.C0();
    }

    @Override // o0.e
    public float E0(float f11) {
        return this.f5236a.E0(f11);
    }

    @Override // o0.n
    public long H(float f11) {
        return this.f5236a.H(f11);
    }

    @Override // o0.n
    public float J(long j11) {
        return this.f5236a.J(j11);
    }

    @Override // androidx.compose.ui.layout.x
    public v M0(int i11, int i12, Map map, Function1 function1, Function1 function12) {
        if (!((i11 & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & i12) == 0)) {
            g0.a.b("Size(" + i11 + " x " + i12 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new a(i11, i12, map, function1, function12, this);
    }

    @Override // o0.e
    public long Q(float f11) {
        return this.f5236a.Q(f11);
    }

    @Override // o0.e
    public long Q0(long j11) {
        return this.f5236a.Q0(j11);
    }

    @Override // androidx.compose.ui.layout.j
    public boolean W() {
        return false;
    }

    @Override // o0.e
    public int c0(float f11) {
        return this.f5236a.c0(f11);
    }

    @Override // o0.e
    public float getDensity() {
        return this.f5236a.getDensity();
    }

    @Override // androidx.compose.ui.layout.j
    public LayoutDirection getLayoutDirection() {
        return this.f5236a.getLayoutDirection();
    }

    @Override // o0.e
    public float h0(long j11) {
        return this.f5236a.h0(j11);
    }

    public final b n() {
        return null;
    }

    @Override // androidx.compose.ui.layout.x
    public v p0(int i11, int i12, Map map, Function1 function1) {
        return this.f5236a.p0(i11, i12, map, function1);
    }

    public final androidx.compose.ui.node.y v() {
        return this.f5236a;
    }

    @Override // o0.e
    public float x0(int i11) {
        return this.f5236a.x0(i11);
    }

    @Override // o0.e
    public float y0(float f11) {
        return this.f5236a.y0(f11);
    }

    public long z() {
        androidx.compose.ui.node.j0 U1 = this.f5236a.U1();
        Intrinsics.e(U1);
        v b12 = U1.b1();
        return o0.u.a(b12.getWidth(), b12.getHeight());
    }
}
