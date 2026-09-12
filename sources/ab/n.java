package ab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: m, reason: collision with root package name */
    public static final d f601m = new l(0.5f);

    /* renamed from: a, reason: collision with root package name */
    e f602a;

    /* renamed from: b, reason: collision with root package name */
    e f603b;

    /* renamed from: c, reason: collision with root package name */
    e f604c;

    /* renamed from: d, reason: collision with root package name */
    e f605d;

    /* renamed from: e, reason: collision with root package name */
    d f606e;

    /* renamed from: f, reason: collision with root package name */
    d f607f;

    /* renamed from: g, reason: collision with root package name */
    d f608g;

    /* renamed from: h, reason: collision with root package name */
    d f609h;

    /* renamed from: i, reason: collision with root package name */
    g f610i;

    /* renamed from: j, reason: collision with root package name */
    g f611j;

    /* renamed from: k, reason: collision with root package name */
    g f612k;

    /* renamed from: l, reason: collision with root package name */
    g f613l;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private e f614a;

        /* renamed from: b, reason: collision with root package name */
        private e f615b;

        /* renamed from: c, reason: collision with root package name */
        private e f616c;

        /* renamed from: d, reason: collision with root package name */
        private e f617d;

        /* renamed from: e, reason: collision with root package name */
        private d f618e;

        /* renamed from: f, reason: collision with root package name */
        private d f619f;

        /* renamed from: g, reason: collision with root package name */
        private d f620g;

        /* renamed from: h, reason: collision with root package name */
        private d f621h;

        /* renamed from: i, reason: collision with root package name */
        private g f622i;

        /* renamed from: j, reason: collision with root package name */
        private g f623j;

        /* renamed from: k, reason: collision with root package name */
        private g f624k;

        /* renamed from: l, reason: collision with root package name */
        private g f625l;

        public b() {
            this.f614a = j.b();
            this.f615b = j.b();
            this.f616c = j.b();
            this.f617d = j.b();
            this.f618e = new ab.a(0.0f);
            this.f619f = new ab.a(0.0f);
            this.f620g = new ab.a(0.0f);
            this.f621h = new ab.a(0.0f);
            this.f622i = j.c();
            this.f623j = j.c();
            this.f624k = j.c();
            this.f625l = j.c();
        }

        public b(n nVar) {
            this.f614a = j.b();
            this.f615b = j.b();
            this.f616c = j.b();
            this.f617d = j.b();
            this.f618e = new ab.a(0.0f);
            this.f619f = new ab.a(0.0f);
            this.f620g = new ab.a(0.0f);
            this.f621h = new ab.a(0.0f);
            this.f622i = j.c();
            this.f623j = j.c();
            this.f624k = j.c();
            this.f625l = j.c();
            this.f614a = nVar.f602a;
            this.f615b = nVar.f603b;
            this.f616c = nVar.f604c;
            this.f617d = nVar.f605d;
            this.f618e = nVar.f606e;
            this.f619f = nVar.f607f;
            this.f620g = nVar.f608g;
            this.f621h = nVar.f609h;
            this.f622i = nVar.f610i;
            this.f623j = nVar.f611j;
            this.f624k = nVar.f612k;
            this.f625l = nVar.f613l;
        }

        private static float n(e eVar) {
            if (eVar instanceof m) {
                return ((m) eVar).f600a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f545a;
            }
            return -1.0f;
        }

        public b A(e eVar) {
            this.f616c = eVar;
            float n11 = n(eVar);
            if (n11 != -1.0f) {
                B(n11);
            }
            return this;
        }

        public b B(float f11) {
            this.f620g = new ab.a(f11);
            return this;
        }

        public b C(d dVar) {
            this.f620g = dVar;
            return this;
        }

        public b D(g gVar) {
            this.f622i = gVar;
            return this;
        }

        public b E(int i11, float f11) {
            return G(j.a(i11)).H(f11);
        }

        public b F(int i11, d dVar) {
            return G(j.a(i11)).I(dVar);
        }

        public b G(e eVar) {
            this.f614a = eVar;
            float n11 = n(eVar);
            if (n11 != -1.0f) {
                H(n11);
            }
            return this;
        }

        public b H(float f11) {
            this.f618e = new ab.a(f11);
            return this;
        }

        public b I(d dVar) {
            this.f618e = dVar;
            return this;
        }

        public b J(int i11, float f11) {
            return L(j.a(i11)).M(f11);
        }

        public b K(int i11, d dVar) {
            return L(j.a(i11)).N(dVar);
        }

        public b L(e eVar) {
            this.f615b = eVar;
            float n11 = n(eVar);
            if (n11 != -1.0f) {
                M(n11);
            }
            return this;
        }

        public b M(float f11) {
            this.f619f = new ab.a(f11);
            return this;
        }

        public b N(d dVar) {
            this.f619f = dVar;
            return this;
        }

        public n m() {
            return new n(this);
        }

        public b o(float f11) {
            return H(f11).M(f11).B(f11).w(f11);
        }

        public b p(d dVar) {
            return I(dVar).N(dVar).C(dVar).x(dVar);
        }

        public b q(int i11, float f11) {
            return r(j.a(i11)).o(f11);
        }

        public b r(e eVar) {
            return G(eVar).L(eVar).A(eVar).v(eVar);
        }

        public b s(g gVar) {
            this.f624k = gVar;
            return this;
        }

        public b t(int i11, float f11) {
            return v(j.a(i11)).w(f11);
        }

        public b u(int i11, d dVar) {
            return v(j.a(i11)).x(dVar);
        }

        public b v(e eVar) {
            this.f617d = eVar;
            float n11 = n(eVar);
            if (n11 != -1.0f) {
                w(n11);
            }
            return this;
        }

        public b w(float f11) {
            this.f621h = new ab.a(f11);
            return this;
        }

        public b x(d dVar) {
            this.f621h = dVar;
            return this;
        }

        public b y(int i11, float f11) {
            return A(j.a(i11)).B(f11);
        }

        public b z(int i11, d dVar) {
            return A(j.a(i11)).C(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        d a(d dVar);
    }

    public n() {
        this.f602a = j.b();
        this.f603b = j.b();
        this.f604c = j.b();
        this.f605d = j.b();
        this.f606e = new ab.a(0.0f);
        this.f607f = new ab.a(0.0f);
        this.f608g = new ab.a(0.0f);
        this.f609h = new ab.a(0.0f);
        this.f610i = j.c();
        this.f611j = j.c();
        this.f612k = j.c();
        this.f613l = j.c();
    }

    private n(b bVar) {
        this.f602a = bVar.f614a;
        this.f603b = bVar.f615b;
        this.f604c = bVar.f616c;
        this.f605d = bVar.f617d;
        this.f606e = bVar.f618e;
        this.f607f = bVar.f619f;
        this.f608g = bVar.f620g;
        this.f609h = bVar.f621h;
        this.f610i = bVar.f622i;
        this.f611j = bVar.f623j;
        this.f612k = bVar.f624k;
        this.f613l = bVar.f625l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i11, int i12) {
        return c(context, i11, i12, 0);
    }

    private static b c(Context context, int i11, int i12, int i13) {
        return d(context, i11, i12, new ab.a(i13));
    }

    private static b d(Context context, int i11, int i12, d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i11);
        if (i12 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i12);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.ShapeAppearance);
        try {
            int i13 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i14 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i13);
            int i15 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i13);
            int i16 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i13);
            int i17 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i13);
            d m11 = m(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, dVar);
            d m12 = m(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, m11);
            d m13 = m(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, m11);
            d m14 = m(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, m11);
            return new b().F(i14, m12).K(i15, m13).z(i16, m14).u(i17, m(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, m11));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i11, int i12) {
        return f(context, attributeSet, i11, i12, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i11, int i12, int i13) {
        return g(context, attributeSet, i11, i12, new ab.a(i13));
    }

    public static b g(Context context, AttributeSet attributeSet, int i11, int i12, d dVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i11, i12);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    private static d m(TypedArray typedArray, int i11, d dVar) {
        TypedValue peekValue = typedArray.peekValue(i11);
        if (peekValue == null) {
            return dVar;
        }
        int i12 = peekValue.type;
        return i12 == 5 ? new ab.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i12 == 6 ? new l(peekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    public g h() {
        return this.f612k;
    }

    public e i() {
        return this.f605d;
    }

    public d j() {
        return this.f609h;
    }

    public e k() {
        return this.f604c;
    }

    public d l() {
        return this.f608g;
    }

    public g n() {
        return this.f613l;
    }

    public g o() {
        return this.f611j;
    }

    public g p() {
        return this.f610i;
    }

    public e q() {
        return this.f602a;
    }

    public d r() {
        return this.f606e;
    }

    public e s() {
        return this.f603b;
    }

    public d t() {
        return this.f607f;
    }

    public boolean u(RectF rectF) {
        boolean z10 = this.f613l.getClass().equals(g.class) && this.f611j.getClass().equals(g.class) && this.f610i.getClass().equals(g.class) && this.f612k.getClass().equals(g.class);
        float a11 = this.f606e.a(rectF);
        return z10 && ((this.f607f.a(rectF) > a11 ? 1 : (this.f607f.a(rectF) == a11 ? 0 : -1)) == 0 && (this.f609h.a(rectF) > a11 ? 1 : (this.f609h.a(rectF) == a11 ? 0 : -1)) == 0 && (this.f608g.a(rectF) > a11 ? 1 : (this.f608g.a(rectF) == a11 ? 0 : -1)) == 0) && ((this.f603b instanceof m) && (this.f602a instanceof m) && (this.f604c instanceof m) && (this.f605d instanceof m));
    }

    public b v() {
        return new b(this);
    }

    public n w(float f11) {
        return v().o(f11).m();
    }

    public n x(d dVar) {
        return v().p(dVar).m();
    }

    public n y(c cVar) {
        return v().I(cVar.a(r())).N(cVar.a(t())).x(cVar.a(j())).C(cVar.a(l())).m();
    }
}
