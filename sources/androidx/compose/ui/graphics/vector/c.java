package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.u1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: k, reason: collision with root package name */
    public static final b f4821k = new b(null);

    /* renamed from: l, reason: collision with root package name */
    private static int f4822l;

    /* renamed from: a, reason: collision with root package name */
    private final String f4823a;

    /* renamed from: b, reason: collision with root package name */
    private final float f4824b;

    /* renamed from: c, reason: collision with root package name */
    private final float f4825c;

    /* renamed from: d, reason: collision with root package name */
    private final float f4826d;

    /* renamed from: e, reason: collision with root package name */
    private final float f4827e;

    /* renamed from: f, reason: collision with root package name */
    private final j f4828f;

    /* renamed from: g, reason: collision with root package name */
    private final long f4829g;

    /* renamed from: h, reason: collision with root package name */
    private final int f4830h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4831i;

    /* renamed from: j, reason: collision with root package name */
    private final int f4832j;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f4833a;

        /* renamed from: b, reason: collision with root package name */
        private final float f4834b;

        /* renamed from: c, reason: collision with root package name */
        private final float f4835c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4836d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4837e;

        /* renamed from: f, reason: collision with root package name */
        private final long f4838f;

        /* renamed from: g, reason: collision with root package name */
        private final int f4839g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f4840h;

        /* renamed from: i, reason: collision with root package name */
        private final ArrayList f4841i;

        /* renamed from: j, reason: collision with root package name */
        private C0048a f4842j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f4843k;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: androidx.compose.ui.graphics.vector.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0048a {

            /* renamed from: a, reason: collision with root package name */
            private String f4844a;

            /* renamed from: b, reason: collision with root package name */
            private float f4845b;

            /* renamed from: c, reason: collision with root package name */
            private float f4846c;

            /* renamed from: d, reason: collision with root package name */
            private float f4847d;

            /* renamed from: e, reason: collision with root package name */
            private float f4848e;

            /* renamed from: f, reason: collision with root package name */
            private float f4849f;

            /* renamed from: g, reason: collision with root package name */
            private float f4850g;

            /* renamed from: h, reason: collision with root package name */
            private float f4851h;

            /* renamed from: i, reason: collision with root package name */
            private List f4852i;

            /* renamed from: j, reason: collision with root package name */
            private List f4853j;

            public C0048a() {
                this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            }

            public C0048a(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, List list2) {
                this.f4844a = str;
                this.f4845b = f11;
                this.f4846c = f12;
                this.f4847d = f13;
                this.f4848e = f14;
                this.f4849f = f15;
                this.f4850g = f16;
                this.f4851h = f17;
                this.f4852i = list;
                this.f4853j = list2;
            }

            public /* synthetic */ C0048a(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0.0f : f11, (i11 & 4) != 0 ? 0.0f : f12, (i11 & 8) != 0 ? 0.0f : f13, (i11 & 16) != 0 ? 1.0f : f14, (i11 & 32) == 0 ? f15 : 1.0f, (i11 & 64) != 0 ? 0.0f : f16, (i11 & 128) == 0 ? f17 : 0.0f, (i11 & 256) != 0 ? k.d() : list, (i11 & 512) != 0 ? new ArrayList() : list2);
            }

            public final List a() {
                return this.f4853j;
            }

            public final List b() {
                return this.f4852i;
            }

            public final String c() {
                return this.f4844a;
            }

            public final float d() {
                return this.f4846c;
            }

            public final float e() {
                return this.f4847d;
            }

            public final float f() {
                return this.f4845b;
            }

            public final float g() {
                return this.f4848e;
            }

            public final float h() {
                return this.f4849f;
            }

            public final float i() {
                return this.f4850g;
            }

            public final float j() {
                return this.f4851h;
            }
        }

        private a(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z10) {
            this.f4833a = str;
            this.f4834b = f11;
            this.f4835c = f12;
            this.f4836d = f13;
            this.f4837e = f14;
            this.f4838f = j11;
            this.f4839g = i11;
            this.f4840h = z10;
            ArrayList arrayList = new ArrayList();
            this.f4841i = arrayList;
            C0048a c0048a = new C0048a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            this.f4842j = c0048a;
            d.f(arrayList, c0048a);
        }

        public /* synthetic */ a(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z10, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? "" : str, f11, f12, f13, f14, (i12 & 32) != 0 ? u1.f4733b.e() : j11, (i12 & 64) != 0 ? c1.f4367a.z() : i11, (i12 & 128) != 0 ? false : z10, null);
        }

        public /* synthetic */ a(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f11, f12, f13, f14, j11, i11, z10);
        }

        private final j d(C0048a c0048a) {
            return new j(c0048a.c(), c0048a.f(), c0048a.d(), c0048a.e(), c0048a.g(), c0048a.h(), c0048a.i(), c0048a.j(), c0048a.b(), c0048a.a());
        }

        private final void g() {
            if (this.f4843k) {
                g0.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
        }

        private final C0048a h() {
            Object d11;
            d11 = d.d(this.f4841i);
            return (C0048a) d11;
        }

        public final a a(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list) {
            g();
            d.f(this.f4841i, new C0048a(str, f11, f12, f13, f14, f15, f16, f17, list, null, 512, null));
            return this;
        }

        public final a c(List list, int i11, String str, j1 j1Var, float f11, j1 j1Var2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17) {
            g();
            h().a().add(new n(str, list, i11, j1Var, f11, j1Var2, f12, f13, i12, i13, f14, f15, f16, f17, null));
            return this;
        }

        public final c e() {
            g();
            while (this.f4841i.size() > 1) {
                f();
            }
            c cVar = new c(this.f4833a, this.f4834b, this.f4835c, this.f4836d, this.f4837e, d(this.f4842j), this.f4838f, this.f4839g, this.f4840h, 0, 512, null);
            this.f4843k = true;
            return cVar;
        }

        public final a f() {
            Object e11;
            g();
            e11 = d.e(this.f4841i);
            h().a().add(d((C0048a) e11));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            int i11;
            synchronized (this) {
                i11 = c.f4822l;
                c.f4822l = i11 + 1;
            }
            return i11;
        }
    }

    private c(String str, float f11, float f12, float f13, float f14, j jVar, long j11, int i11, boolean z10, int i12) {
        this.f4823a = str;
        this.f4824b = f11;
        this.f4825c = f12;
        this.f4826d = f13;
        this.f4827e = f14;
        this.f4828f = jVar;
        this.f4829g = j11;
        this.f4830h = i11;
        this.f4831i = z10;
        this.f4832j = i12;
    }

    public /* synthetic */ c(String str, float f11, float f12, float f13, float f14, j jVar, long j11, int i11, boolean z10, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f11, f12, f13, f14, jVar, j11, i11, z10, (i13 & 512) != 0 ? f4821k.a() : i12, null);
    }

    public /* synthetic */ c(String str, float f11, float f12, float f13, float f14, j jVar, long j11, int i11, boolean z10, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f11, f12, f13, f14, jVar, j11, i11, z10, i12);
    }

    public final boolean c() {
        return this.f4831i;
    }

    public final float d() {
        return this.f4825c;
    }

    public final float e() {
        return this.f4824b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f4823a, cVar.f4823a) && o0.i.i(this.f4824b, cVar.f4824b) && o0.i.i(this.f4825c, cVar.f4825c) && this.f4826d == cVar.f4826d && this.f4827e == cVar.f4827e && Intrinsics.c(this.f4828f, cVar.f4828f) && u1.m(this.f4829g, cVar.f4829g) && c1.E(this.f4830h, cVar.f4830h) && this.f4831i == cVar.f4831i;
    }

    public final int f() {
        return this.f4832j;
    }

    public final String g() {
        return this.f4823a;
    }

    public final j h() {
        return this.f4828f;
    }

    public int hashCode() {
        return (((((((((((((((this.f4823a.hashCode() * 31) + o0.i.j(this.f4824b)) * 31) + o0.i.j(this.f4825c)) * 31) + Float.floatToIntBits(this.f4826d)) * 31) + Float.floatToIntBits(this.f4827e)) * 31) + this.f4828f.hashCode()) * 31) + u1.s(this.f4829g)) * 31) + c1.F(this.f4830h)) * 31) + androidx.compose.foundation.e.a(this.f4831i);
    }

    public final int i() {
        return this.f4830h;
    }

    public final long j() {
        return this.f4829g;
    }

    public final float k() {
        return this.f4827e;
    }

    public final float l() {
        return this.f4826d;
    }
}
