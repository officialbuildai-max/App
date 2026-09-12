package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4854a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4855b;

    /* loaded from: classes.dex */
    public static final class a extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4856c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4857d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4858e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f4859f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f4860g;

        /* renamed from: h, reason: collision with root package name */
        private final float f4861h;

        /* renamed from: i, reason: collision with root package name */
        private final float f4862i;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(float r4, float r5, float r6, boolean r7, boolean r8, float r9, float r10) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4856c = r4
                r3.f4857d = r5
                r3.f4858e = r6
                r3.f4859f = r7
                r3.f4860g = r8
                r3.f4861h = r9
                r3.f4862i = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.a.<init>(float, float, float, boolean, boolean, float, float):void");
        }

        public final float c() {
            return this.f4861h;
        }

        public final float d() {
            return this.f4862i;
        }

        public final float e() {
            return this.f4856c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.f4856c, aVar.f4856c) == 0 && Float.compare(this.f4857d, aVar.f4857d) == 0 && Float.compare(this.f4858e, aVar.f4858e) == 0 && this.f4859f == aVar.f4859f && this.f4860g == aVar.f4860g && Float.compare(this.f4861h, aVar.f4861h) == 0 && Float.compare(this.f4862i, aVar.f4862i) == 0;
        }

        public final float f() {
            return this.f4858e;
        }

        public final float g() {
            return this.f4857d;
        }

        public final boolean h() {
            return this.f4859f;
        }

        public int hashCode() {
            return (((((((((((Float.floatToIntBits(this.f4856c) * 31) + Float.floatToIntBits(this.f4857d)) * 31) + Float.floatToIntBits(this.f4858e)) * 31) + androidx.compose.foundation.e.a(this.f4859f)) * 31) + androidx.compose.foundation.e.a(this.f4860g)) * 31) + Float.floatToIntBits(this.f4861h)) * 31) + Float.floatToIntBits(this.f4862i);
        }

        public final boolean i() {
            return this.f4860g;
        }

        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.f4856c + ", verticalEllipseRadius=" + this.f4857d + ", theta=" + this.f4858e + ", isMoreThanHalf=" + this.f4859f + ", isPositiveArc=" + this.f4860g + ", arcStartX=" + this.f4861h + ", arcStartY=" + this.f4862i + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e {

        /* renamed from: c, reason: collision with root package name */
        public static final b f4863c = new b();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private b() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.b.<init>():void");
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4864c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4865d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4866e;

        /* renamed from: f, reason: collision with root package name */
        private final float f4867f;

        /* renamed from: g, reason: collision with root package name */
        private final float f4868g;

        /* renamed from: h, reason: collision with root package name */
        private final float f4869h;

        public c(float f11, float f12, float f13, float f14, float f15, float f16) {
            super(true, false, 2, null);
            this.f4864c = f11;
            this.f4865d = f12;
            this.f4866e = f13;
            this.f4867f = f14;
            this.f4868g = f15;
            this.f4869h = f16;
        }

        public final float c() {
            return this.f4864c;
        }

        public final float d() {
            return this.f4866e;
        }

        public final float e() {
            return this.f4868g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Float.compare(this.f4864c, cVar.f4864c) == 0 && Float.compare(this.f4865d, cVar.f4865d) == 0 && Float.compare(this.f4866e, cVar.f4866e) == 0 && Float.compare(this.f4867f, cVar.f4867f) == 0 && Float.compare(this.f4868g, cVar.f4868g) == 0 && Float.compare(this.f4869h, cVar.f4869h) == 0;
        }

        public final float f() {
            return this.f4865d;
        }

        public final float g() {
            return this.f4867f;
        }

        public final float h() {
            return this.f4869h;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f4864c) * 31) + Float.floatToIntBits(this.f4865d)) * 31) + Float.floatToIntBits(this.f4866e)) * 31) + Float.floatToIntBits(this.f4867f)) * 31) + Float.floatToIntBits(this.f4868g)) * 31) + Float.floatToIntBits(this.f4869h);
        }

        public String toString() {
            return "CurveTo(x1=" + this.f4864c + ", y1=" + this.f4865d + ", x2=" + this.f4866e + ", y2=" + this.f4867f + ", x3=" + this.f4868g + ", y3=" + this.f4869h + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4870c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public d(float r4) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4870c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.d.<init>(float):void");
        }

        public final float c() {
            return this.f4870c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Float.compare(this.f4870c, ((d) obj).f4870c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4870c);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.f4870c + ')';
        }
    }

    /* renamed from: androidx.compose.ui.graphics.vector.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0049e extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4871c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4872d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public C0049e(float r4, float r5) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4871c = r4
                r3.f4872d = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.C0049e.<init>(float, float):void");
        }

        public final float c() {
            return this.f4871c;
        }

        public final float d() {
            return this.f4872d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0049e)) {
                return false;
            }
            C0049e c0049e = (C0049e) obj;
            return Float.compare(this.f4871c, c0049e.f4871c) == 0 && Float.compare(this.f4872d, c0049e.f4872d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4871c) * 31) + Float.floatToIntBits(this.f4872d);
        }

        public String toString() {
            return "LineTo(x=" + this.f4871c + ", y=" + this.f4872d + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4873c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4874d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public f(float r4, float r5) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4873c = r4
                r3.f4874d = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.f.<init>(float, float):void");
        }

        public final float c() {
            return this.f4873c;
        }

        public final float d() {
            return this.f4874d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Float.compare(this.f4873c, fVar.f4873c) == 0 && Float.compare(this.f4874d, fVar.f4874d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4873c) * 31) + Float.floatToIntBits(this.f4874d);
        }

        public String toString() {
            return "MoveTo(x=" + this.f4873c + ", y=" + this.f4874d + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4875c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4876d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4877e;

        /* renamed from: f, reason: collision with root package name */
        private final float f4878f;

        public g(float f11, float f12, float f13, float f14) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4875c = f11;
            this.f4876d = f12;
            this.f4877e = f13;
            this.f4878f = f14;
        }

        public final float c() {
            return this.f4875c;
        }

        public final float d() {
            return this.f4877e;
        }

        public final float e() {
            return this.f4876d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Float.compare(this.f4875c, gVar.f4875c) == 0 && Float.compare(this.f4876d, gVar.f4876d) == 0 && Float.compare(this.f4877e, gVar.f4877e) == 0 && Float.compare(this.f4878f, gVar.f4878f) == 0;
        }

        public final float f() {
            return this.f4878f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4875c) * 31) + Float.floatToIntBits(this.f4876d)) * 31) + Float.floatToIntBits(this.f4877e)) * 31) + Float.floatToIntBits(this.f4878f);
        }

        public String toString() {
            return "QuadTo(x1=" + this.f4875c + ", y1=" + this.f4876d + ", x2=" + this.f4877e + ", y2=" + this.f4878f + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4879c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4880d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4881e;

        /* renamed from: f, reason: collision with root package name */
        private final float f4882f;

        public h(float f11, float f12, float f13, float f14) {
            super(true, false, 2, null);
            this.f4879c = f11;
            this.f4880d = f12;
            this.f4881e = f13;
            this.f4882f = f14;
        }

        public final float c() {
            return this.f4879c;
        }

        public final float d() {
            return this.f4881e;
        }

        public final float e() {
            return this.f4880d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Float.compare(this.f4879c, hVar.f4879c) == 0 && Float.compare(this.f4880d, hVar.f4880d) == 0 && Float.compare(this.f4881e, hVar.f4881e) == 0 && Float.compare(this.f4882f, hVar.f4882f) == 0;
        }

        public final float f() {
            return this.f4882f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4879c) * 31) + Float.floatToIntBits(this.f4880d)) * 31) + Float.floatToIntBits(this.f4881e)) * 31) + Float.floatToIntBits(this.f4882f);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f4879c + ", y1=" + this.f4880d + ", x2=" + this.f4881e + ", y2=" + this.f4882f + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4883c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4884d;

        public i(float f11, float f12) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4883c = f11;
            this.f4884d = f12;
        }

        public final float c() {
            return this.f4883c;
        }

        public final float d() {
            return this.f4884d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Float.compare(this.f4883c, iVar.f4883c) == 0 && Float.compare(this.f4884d, iVar.f4884d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4883c) * 31) + Float.floatToIntBits(this.f4884d);
        }

        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f4883c + ", y=" + this.f4884d + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class j extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4885c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4886d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4887e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f4888f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f4889g;

        /* renamed from: h, reason: collision with root package name */
        private final float f4890h;

        /* renamed from: i, reason: collision with root package name */
        private final float f4891i;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public j(float r4, float r5, float r6, boolean r7, boolean r8, float r9, float r10) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4885c = r4
                r3.f4886d = r5
                r3.f4887e = r6
                r3.f4888f = r7
                r3.f4889g = r8
                r3.f4890h = r9
                r3.f4891i = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.j.<init>(float, float, float, boolean, boolean, float, float):void");
        }

        public final float c() {
            return this.f4890h;
        }

        public final float d() {
            return this.f4891i;
        }

        public final float e() {
            return this.f4885c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return Float.compare(this.f4885c, jVar.f4885c) == 0 && Float.compare(this.f4886d, jVar.f4886d) == 0 && Float.compare(this.f4887e, jVar.f4887e) == 0 && this.f4888f == jVar.f4888f && this.f4889g == jVar.f4889g && Float.compare(this.f4890h, jVar.f4890h) == 0 && Float.compare(this.f4891i, jVar.f4891i) == 0;
        }

        public final float f() {
            return this.f4887e;
        }

        public final float g() {
            return this.f4886d;
        }

        public final boolean h() {
            return this.f4888f;
        }

        public int hashCode() {
            return (((((((((((Float.floatToIntBits(this.f4885c) * 31) + Float.floatToIntBits(this.f4886d)) * 31) + Float.floatToIntBits(this.f4887e)) * 31) + androidx.compose.foundation.e.a(this.f4888f)) * 31) + androidx.compose.foundation.e.a(this.f4889g)) * 31) + Float.floatToIntBits(this.f4890h)) * 31) + Float.floatToIntBits(this.f4891i);
        }

        public final boolean i() {
            return this.f4889g;
        }

        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.f4885c + ", verticalEllipseRadius=" + this.f4886d + ", theta=" + this.f4887e + ", isMoreThanHalf=" + this.f4888f + ", isPositiveArc=" + this.f4889g + ", arcStartDx=" + this.f4890h + ", arcStartDy=" + this.f4891i + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class k extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4892c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4893d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4894e;

        /* renamed from: f, reason: collision with root package name */
        private final float f4895f;

        /* renamed from: g, reason: collision with root package name */
        private final float f4896g;

        /* renamed from: h, reason: collision with root package name */
        private final float f4897h;

        public k(float f11, float f12, float f13, float f14, float f15, float f16) {
            super(true, false, 2, null);
            this.f4892c = f11;
            this.f4893d = f12;
            this.f4894e = f13;
            this.f4895f = f14;
            this.f4896g = f15;
            this.f4897h = f16;
        }

        public final float c() {
            return this.f4892c;
        }

        public final float d() {
            return this.f4894e;
        }

        public final float e() {
            return this.f4896g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return Float.compare(this.f4892c, kVar.f4892c) == 0 && Float.compare(this.f4893d, kVar.f4893d) == 0 && Float.compare(this.f4894e, kVar.f4894e) == 0 && Float.compare(this.f4895f, kVar.f4895f) == 0 && Float.compare(this.f4896g, kVar.f4896g) == 0 && Float.compare(this.f4897h, kVar.f4897h) == 0;
        }

        public final float f() {
            return this.f4893d;
        }

        public final float g() {
            return this.f4895f;
        }

        public final float h() {
            return this.f4897h;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f4892c) * 31) + Float.floatToIntBits(this.f4893d)) * 31) + Float.floatToIntBits(this.f4894e)) * 31) + Float.floatToIntBits(this.f4895f)) * 31) + Float.floatToIntBits(this.f4896g)) * 31) + Float.floatToIntBits(this.f4897h);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.f4892c + ", dy1=" + this.f4893d + ", dx2=" + this.f4894e + ", dy2=" + this.f4895f + ", dx3=" + this.f4896g + ", dy3=" + this.f4897h + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class l extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4898c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l(float r4) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4898c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.l.<init>(float):void");
        }

        public final float c() {
            return this.f4898c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && Float.compare(this.f4898c, ((l) obj).f4898c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4898c);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.f4898c + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class m extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4899c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4900d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public m(float r4, float r5) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4899c = r4
                r3.f4900d = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.m.<init>(float, float):void");
        }

        public final float c() {
            return this.f4899c;
        }

        public final float d() {
            return this.f4900d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return Float.compare(this.f4899c, mVar.f4899c) == 0 && Float.compare(this.f4900d, mVar.f4900d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4899c) * 31) + Float.floatToIntBits(this.f4900d);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.f4899c + ", dy=" + this.f4900d + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class n extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4901c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4902d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public n(float r4, float r5) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4901c = r4
                r3.f4902d = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.n.<init>(float, float):void");
        }

        public final float c() {
            return this.f4901c;
        }

        public final float d() {
            return this.f4902d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return Float.compare(this.f4901c, nVar.f4901c) == 0 && Float.compare(this.f4902d, nVar.f4902d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4901c) * 31) + Float.floatToIntBits(this.f4902d);
        }

        public String toString() {
            return "RelativeMoveTo(dx=" + this.f4901c + ", dy=" + this.f4902d + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class o extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4903c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4904d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4905e;

        /* renamed from: f, reason: collision with root package name */
        private final float f4906f;

        public o(float f11, float f12, float f13, float f14) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4903c = f11;
            this.f4904d = f12;
            this.f4905e = f13;
            this.f4906f = f14;
        }

        public final float c() {
            return this.f4903c;
        }

        public final float d() {
            return this.f4905e;
        }

        public final float e() {
            return this.f4904d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return Float.compare(this.f4903c, oVar.f4903c) == 0 && Float.compare(this.f4904d, oVar.f4904d) == 0 && Float.compare(this.f4905e, oVar.f4905e) == 0 && Float.compare(this.f4906f, oVar.f4906f) == 0;
        }

        public final float f() {
            return this.f4906f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4903c) * 31) + Float.floatToIntBits(this.f4904d)) * 31) + Float.floatToIntBits(this.f4905e)) * 31) + Float.floatToIntBits(this.f4906f);
        }

        public String toString() {
            return "RelativeQuadTo(dx1=" + this.f4903c + ", dy1=" + this.f4904d + ", dx2=" + this.f4905e + ", dy2=" + this.f4906f + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class p extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4907c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4908d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4909e;

        /* renamed from: f, reason: collision with root package name */
        private final float f4910f;

        public p(float f11, float f12, float f13, float f14) {
            super(true, false, 2, null);
            this.f4907c = f11;
            this.f4908d = f12;
            this.f4909e = f13;
            this.f4910f = f14;
        }

        public final float c() {
            return this.f4907c;
        }

        public final float d() {
            return this.f4909e;
        }

        public final float e() {
            return this.f4908d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            return Float.compare(this.f4907c, pVar.f4907c) == 0 && Float.compare(this.f4908d, pVar.f4908d) == 0 && Float.compare(this.f4909e, pVar.f4909e) == 0 && Float.compare(this.f4910f, pVar.f4910f) == 0;
        }

        public final float f() {
            return this.f4910f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4907c) * 31) + Float.floatToIntBits(this.f4908d)) * 31) + Float.floatToIntBits(this.f4909e)) * 31) + Float.floatToIntBits(this.f4910f);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.f4907c + ", dy1=" + this.f4908d + ", dx2=" + this.f4909e + ", dy2=" + this.f4910f + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class q extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4911c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4912d;

        public q(float f11, float f12) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4911c = f11;
            this.f4912d = f12;
        }

        public final float c() {
            return this.f4911c;
        }

        public final float d() {
            return this.f4912d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            return Float.compare(this.f4911c, qVar.f4911c) == 0 && Float.compare(this.f4912d, qVar.f4912d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4911c) * 31) + Float.floatToIntBits(this.f4912d);
        }

        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.f4911c + ", dy=" + this.f4912d + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class r extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4913c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public r(float r4) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4913c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.r.<init>(float):void");
        }

        public final float c() {
            return this.f4913c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && Float.compare(this.f4913c, ((r) obj).f4913c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4913c);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.f4913c + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class s extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f4914c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public s(float r4) {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                r3.f4914c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.e.s.<init>(float):void");
        }

        public final float c() {
            return this.f4914c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && Float.compare(this.f4914c, ((s) obj).f4914c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4914c);
        }

        public String toString() {
            return "VerticalTo(y=" + this.f4914c + ')';
        }
    }

    private e(boolean z10, boolean z11) {
        this.f4854a = z10;
        this.f4855b = z11;
    }

    public /* synthetic */ e(boolean z10, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? false : z11, null);
    }

    public /* synthetic */ e(boolean z10, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, z11);
    }

    public final boolean a() {
        return this.f4854a;
    }

    public final boolean b() {
        return this.f4855b;
    }
}
