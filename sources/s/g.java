package s;

import androidx.compose.runtime.a2;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.o1;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class g extends h {

    /* renamed from: i, reason: collision with root package name */
    public static final a f74941i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final int f74942j = 8;

    /* renamed from: b, reason: collision with root package name */
    private int f74944b;

    /* renamed from: d, reason: collision with root package name */
    private int f74946d;

    /* renamed from: f, reason: collision with root package name */
    private int f74948f;

    /* renamed from: g, reason: collision with root package name */
    private int f74949g;

    /* renamed from: h, reason: collision with root package name */
    private int f74950h;

    /* renamed from: a, reason: collision with root package name */
    private d[] f74943a = new d[16];

    /* renamed from: c, reason: collision with root package name */
    private int[] f74945c = new int[16];

    /* renamed from: e, reason: collision with root package name */
    private Object[] f74947e = new Object[16];

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public final class b implements e {

        /* renamed from: a, reason: collision with root package name */
        private int f74951a;

        /* renamed from: b, reason: collision with root package name */
        private int f74952b;

        /* renamed from: c, reason: collision with root package name */
        private int f74953c;

        public b() {
        }

        @Override // s.e
        public Object a(int i11) {
            return g.this.f74947e[this.f74953c + i11];
        }

        @Override // s.e
        public int b(int i11) {
            return g.this.f74945c[this.f74952b + i11];
        }

        public final d c() {
            d dVar = g.this.f74943a[this.f74951a];
            Intrinsics.e(dVar);
            return dVar;
        }

        public final boolean d() {
            if (this.f74951a >= g.this.f74944b) {
                return false;
            }
            d c11 = c();
            this.f74952b += c11.b();
            this.f74953c += c11.d();
            int i11 = this.f74951a + 1;
            this.f74951a = i11;
            return i11 < g.this.f74944b;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        public static g a(g gVar) {
            return gVar;
        }

        public static final d b(g gVar) {
            return gVar.v();
        }

        public static final void c(g gVar, int i11, int i12) {
            int i13 = 1 << i11;
            if (!((gVar.f74949g & i13) == 0)) {
                o1.b("Already pushed argument " + b(gVar).e(i11));
            }
            gVar.f74949g |= i13;
            gVar.f74945c[gVar.z(i11)] = i12;
        }

        public static final void d(g gVar, int i11, Object obj) {
            int i12 = 1 << i11;
            if (!((gVar.f74950h & i12) == 0)) {
                o1.b("Already pushed argument " + b(gVar).f(i11));
            }
            gVar.f74950h |= i12;
            gVar.f74947e[gVar.A(i11)] = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int A(int i11) {
        return (this.f74948f - v().d()) + i11;
    }

    public static final /* synthetic */ int a(g gVar, int i11) {
        return gVar.n(i11);
    }

    public static final /* synthetic */ int f(g gVar) {
        return gVar.f74949g;
    }

    public static final /* synthetic */ int g(g gVar) {
        return gVar.f74950h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n(int i11) {
        if (i11 == 0) {
            return 0;
        }
        return (-1) >>> (32 - i11);
    }

    private final int o(int i11, int i12) {
        return RangesKt.f(i11 + RangesKt.i(i11, 1024), i12);
    }

    private final void p(int i11) {
        int[] iArr = this.f74945c;
        int length = iArr.length;
        if (i11 > length) {
            int[] copyOf = Arrays.copyOf(iArr, o(length, i11));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f74945c = copyOf;
        }
    }

    private final void q(int i11) {
        Object[] objArr = this.f74947e;
        int length = objArr.length;
        if (i11 > length) {
            Object[] copyOf = Arrays.copyOf(objArr, o(length, i11));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f74947e = copyOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d v() {
        d dVar = this.f74943a[this.f74944b - 1];
        Intrinsics.e(dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int z(int i11) {
        return (this.f74946d - v().b()) + i11;
    }

    public final void m() {
        this.f74944b = 0;
        this.f74946d = 0;
        ArraysKt.w(this.f74947e, null, 0, this.f74948f);
        this.f74948f = 0;
    }

    public final void r(androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
        if (u()) {
            b bVar = new b();
            do {
                bVar.c().a(bVar, fVar, m2Var, a2Var);
            } while (bVar.d());
        }
        m();
    }

    public final int s() {
        return this.f74944b;
    }

    public final boolean t() {
        return s() == 0;
    }

    public String toString() {
        return super.toString();
    }

    public final boolean u() {
        return s() != 0;
    }

    public final void w(g gVar) {
        if (t()) {
            throw new NoSuchElementException("Cannot pop(), because the stack is empty.");
        }
        d[] dVarArr = this.f74943a;
        int i11 = this.f74944b - 1;
        this.f74944b = i11;
        d dVar = dVarArr[i11];
        Intrinsics.e(dVar);
        this.f74943a[this.f74944b] = null;
        gVar.y(dVar);
        int i12 = this.f74948f;
        int i13 = gVar.f74948f;
        int d11 = dVar.d();
        for (int i14 = 0; i14 < d11; i14++) {
            i13--;
            i12--;
            Object[] objArr = gVar.f74947e;
            Object[] objArr2 = this.f74947e;
            objArr[i13] = objArr2[i12];
            objArr2[i12] = null;
        }
        int i15 = this.f74946d;
        int i16 = gVar.f74946d;
        int b11 = dVar.b();
        for (int i17 = 0; i17 < b11; i17++) {
            i16--;
            i15--;
            int[] iArr = gVar.f74945c;
            int[] iArr2 = this.f74945c;
            iArr[i16] = iArr2[i15];
            iArr2[i15] = 0;
        }
        this.f74948f -= dVar.d();
        this.f74946d -= dVar.b();
    }

    public final void x(d dVar) {
        if (!(dVar.b() == 0 && dVar.d() == 0)) {
            o1.a("Cannot push " + dVar + " without arguments because it expects " + dVar.b() + " ints and " + dVar.d() + " objects.");
        }
        y(dVar);
    }

    public final void y(d dVar) {
        this.f74949g = 0;
        this.f74950h = 0;
        int i11 = this.f74944b;
        if (i11 == this.f74943a.length) {
            Object[] copyOf = Arrays.copyOf(this.f74943a, this.f74944b + RangesKt.i(i11, 1024));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f74943a = (d[]) copyOf;
        }
        p(this.f74946d + dVar.b());
        q(this.f74948f + dVar.d());
        d[] dVarArr = this.f74943a;
        int i12 = this.f74944b;
        this.f74944b = i12 + 1;
        dVarArr[i12] = dVar;
        this.f74946d += dVar.b();
        this.f74948f += dVar.d();
    }
}
