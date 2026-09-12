package m4;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class n implements m, a.b, k {

    /* renamed from: e, reason: collision with root package name */
    private final String f69378e;

    /* renamed from: f, reason: collision with root package name */
    private final LottieDrawable f69379f;

    /* renamed from: g, reason: collision with root package name */
    private final PolystarShape.Type f69380g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f69381h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f69382i;

    /* renamed from: j, reason: collision with root package name */
    private final n4.a f69383j;

    /* renamed from: k, reason: collision with root package name */
    private final n4.a f69384k;

    /* renamed from: l, reason: collision with root package name */
    private final n4.a f69385l;

    /* renamed from: m, reason: collision with root package name */
    private final n4.a f69386m;

    /* renamed from: n, reason: collision with root package name */
    private final n4.a f69387n;

    /* renamed from: o, reason: collision with root package name */
    private final n4.a f69388o;

    /* renamed from: p, reason: collision with root package name */
    private final n4.a f69389p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f69391r;

    /* renamed from: a, reason: collision with root package name */
    private final Path f69374a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f69375b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final PathMeasure f69376c = new PathMeasure();

    /* renamed from: d, reason: collision with root package name */
    private final float[] f69377d = new float[2];

    /* renamed from: q, reason: collision with root package name */
    private final b f69390q = new b();

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f69392a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f69392a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69392a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.f69379f = lottieDrawable;
        this.f69378e = polystarShape.d();
        PolystarShape.Type j11 = polystarShape.j();
        this.f69380g = j11;
        this.f69381h = polystarShape.k();
        this.f69382i = polystarShape.l();
        n4.d a11 = polystarShape.g().a();
        this.f69383j = a11;
        n4.a a12 = polystarShape.h().a();
        this.f69384k = a12;
        n4.d a13 = polystarShape.i().a();
        this.f69385l = a13;
        n4.d a14 = polystarShape.e().a();
        this.f69387n = a14;
        n4.d a15 = polystarShape.f().a();
        this.f69389p = a15;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (j11 == type) {
            this.f69386m = polystarShape.b().a();
            this.f69388o = polystarShape.c().a();
        } else {
            this.f69386m = null;
            this.f69388o = null;
        }
        aVar.i(a11);
        aVar.i(a12);
        aVar.i(a13);
        aVar.i(a14);
        aVar.i(a15);
        if (j11 == type) {
            aVar.i(this.f69386m);
            aVar.i(this.f69388o);
        }
        a11.a(this);
        a12.a(this);
        a13.a(this);
        a14.a(this);
        a15.a(this);
        if (j11 == type) {
            this.f69386m.a(this);
            this.f69388o.a(this);
        }
    }

    private void g() {
        double d11;
        float f11;
        n nVar;
        n nVar2 = this;
        int floor = (int) Math.floor(((Float) nVar2.f69383j.h()).floatValue());
        double radians = Math.toRadians((nVar2.f69385l == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d12 = floor;
        float floatValue = ((Float) nVar2.f69389p.h()).floatValue() / 100.0f;
        float floatValue2 = ((Float) nVar2.f69387n.h()).floatValue();
        double d13 = floatValue2;
        float cos = (float) (Math.cos(radians) * d13);
        float sin = (float) (Math.sin(radians) * d13);
        nVar2.f69374a.moveTo(cos, sin);
        double d14 = (float) (6.283185307179586d / d12);
        double ceil = Math.ceil(d12);
        double d15 = radians + d14;
        int i11 = 0;
        while (true) {
            double d16 = i11;
            if (d16 >= ceil) {
                n nVar3 = nVar2;
                PointF pointF = (PointF) nVar3.f69384k.h();
                nVar3.f69374a.offset(pointF.x, pointF.y);
                nVar3.f69374a.close();
                return;
            }
            int i12 = i11;
            float cos2 = (float) (d13 * Math.cos(d15));
            double d17 = d14;
            float sin2 = (float) (d13 * Math.sin(d15));
            if (floatValue != 0.0f) {
                d11 = d13;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                f11 = sin2;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f12 = floatValue2 * floatValue * 0.25f;
                float f13 = cos3 * f12;
                float f14 = sin3 * f12;
                float cos4 = ((float) Math.cos(atan22)) * f12;
                float sin4 = f12 * ((float) Math.sin(atan22));
                if (d16 == ceil - 1.0d) {
                    nVar = this;
                    nVar.f69375b.reset();
                    nVar.f69375b.moveTo(cos, sin);
                    float f15 = cos - f13;
                    float f16 = sin - f14;
                    float f17 = cos2 + cos4;
                    float f18 = sin4 + f11;
                    nVar.f69375b.cubicTo(f15, f16, f17, f18, cos2, f11);
                    nVar.f69376c.setPath(nVar.f69375b, false);
                    PathMeasure pathMeasure = nVar.f69376c;
                    pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, nVar.f69377d, null);
                    Path path = nVar.f69374a;
                    float[] fArr = nVar.f69377d;
                    path.cubicTo(f15, f16, f17, f18, fArr[0], fArr[1]);
                } else {
                    nVar = this;
                    nVar.f69374a.cubicTo(cos - f13, sin - f14, cos2 + cos4, f11 + sin4, cos2, f11);
                }
            } else {
                d11 = d13;
                f11 = sin2;
                nVar = nVar2;
                if (d16 == ceil - 1.0d) {
                    sin = f11;
                    cos = cos2;
                    d14 = d17;
                    i11 = i12 + 1;
                    nVar2 = nVar;
                    d13 = d11;
                } else {
                    nVar.f69374a.lineTo(cos2, f11);
                }
            }
            d15 += d17;
            sin = f11;
            cos = cos2;
            d14 = d17;
            i11 = i12 + 1;
            nVar2 = nVar;
            d13 = d11;
        }
    }

    private void i() {
        int i11;
        float f11;
        float f12;
        double d11;
        float f13;
        float f14;
        float f15;
        float f16;
        double d12;
        float f17;
        float f18;
        float f19;
        double d13;
        float floatValue = ((Float) this.f69383j.h()).floatValue();
        double radians = Math.toRadians((this.f69385l == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d14 = floatValue;
        float f20 = (float) (6.283185307179586d / d14);
        if (this.f69382i) {
            f20 *= -1.0f;
        }
        float f21 = f20 / 2.0f;
        float f22 = floatValue - ((int) floatValue);
        int i12 = (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1));
        if (i12 != 0) {
            radians += (1.0f - f22) * f21;
        }
        float floatValue2 = ((Float) this.f69387n.h()).floatValue();
        float floatValue3 = ((Float) this.f69386m.h()).floatValue();
        n4.a aVar = this.f69388o;
        float floatValue4 = aVar != null ? ((Float) aVar.h()).floatValue() / 100.0f : 0.0f;
        n4.a aVar2 = this.f69389p;
        float floatValue5 = aVar2 != null ? ((Float) aVar2.h()).floatValue() / 100.0f : 0.0f;
        if (i12 != 0) {
            f14 = ((floatValue2 - floatValue3) * f22) + floatValue3;
            i11 = i12;
            double d15 = f14;
            float cos = (float) (d15 * Math.cos(radians));
            f13 = (float) (d15 * Math.sin(radians));
            this.f69374a.moveTo(cos, f13);
            d11 = radians + ((f20 * f22) / 2.0f);
            f11 = cos;
            f12 = f21;
        } else {
            i11 = i12;
            double d16 = floatValue2;
            float cos2 = (float) (Math.cos(radians) * d16);
            float sin = (float) (d16 * Math.sin(radians));
            this.f69374a.moveTo(cos2, sin);
            f11 = cos2;
            f12 = f21;
            d11 = radians + f12;
            f13 = sin;
            f14 = 0.0f;
        }
        double ceil = Math.ceil(d14) * 2.0d;
        int i13 = 0;
        float f23 = f12;
        float f24 = f11;
        boolean z10 = false;
        while (true) {
            double d17 = i13;
            if (d17 >= ceil) {
                PointF pointF = (PointF) this.f69384k.h();
                this.f69374a.offset(pointF.x, pointF.y);
                this.f69374a.close();
                return;
            }
            float f25 = z10 ? floatValue2 : floatValue3;
            if (f14 == 0.0f || d17 != ceil - 2.0d) {
                f15 = f20;
                f16 = f23;
            } else {
                f15 = f20;
                f16 = (f20 * f22) / 2.0f;
            }
            if (f14 == 0.0f || d17 != ceil - 1.0d) {
                d12 = d17;
                f17 = f14;
                f14 = f25;
            } else {
                d12 = d17;
                f17 = f14;
            }
            double d18 = f14;
            double d19 = ceil;
            float cos3 = (float) (d18 * Math.cos(d11));
            float sin2 = (float) (d18 * Math.sin(d11));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.f69374a.lineTo(cos3, sin2);
                d13 = d11;
                f18 = floatValue4;
                f19 = floatValue5;
            } else {
                f18 = floatValue4;
                double atan2 = (float) (Math.atan2(f13, f24) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                f19 = floatValue5;
                d13 = d11;
                double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f26 = z10 ? f18 : f19;
                float f27 = z10 ? f19 : f18;
                float f28 = (z10 ? floatValue3 : floatValue2) * f26 * 0.47829f;
                float f29 = cos4 * f28;
                float f30 = f28 * sin3;
                float f31 = (z10 ? floatValue2 : floatValue3) * f27 * 0.47829f;
                float f32 = cos5 * f31;
                float f33 = f31 * sin4;
                if (i11 != 0) {
                    if (i13 == 0) {
                        f29 *= f22;
                        f30 *= f22;
                    } else if (d12 == d19 - 1.0d) {
                        f32 *= f22;
                        f33 *= f22;
                    }
                }
                this.f69374a.cubicTo(f24 - f29, f13 - f30, cos3 + f32, sin2 + f33, cos3, sin2);
            }
            d11 = d13 + f16;
            z10 = !z10;
            i13++;
            f24 = cos3;
            f13 = sin2;
            floatValue5 = f19;
            floatValue4 = f18;
            f14 = f17;
            f20 = f15;
            ceil = d19;
        }
    }

    private void j() {
        this.f69391r = false;
        this.f69379f.invalidateSelf();
    }

    @Override // n4.a.b
    public void a() {
        j();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        n4.a aVar;
        n4.a aVar2;
        if (obj == p0.f18007w) {
            this.f69383j.o(cVar);
            return;
        }
        if (obj == p0.f18008x) {
            this.f69385l.o(cVar);
            return;
        }
        if (obj == p0.f17998n) {
            this.f69384k.o(cVar);
            return;
        }
        if (obj == p0.f18009y && (aVar2 = this.f69386m) != null) {
            aVar2.o(cVar);
            return;
        }
        if (obj == p0.f18010z) {
            this.f69387n.o(cVar);
            return;
        }
        if (obj == p0.A && (aVar = this.f69388o) != null) {
            aVar.o(cVar);
        } else if (obj == p0.B) {
            this.f69389p.o(cVar);
        }
    }

    @Override // m4.c
    public void c(List list, List list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = (c) list.get(i11);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f69390q.a(uVar);
                    uVar.b(this);
                }
            }
        }
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        v4.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // m4.c
    public String getName() {
        return this.f69378e;
    }

    @Override // m4.m
    public Path getPath() {
        if (this.f69391r) {
            return this.f69374a;
        }
        this.f69374a.reset();
        if (this.f69381h) {
            this.f69391r = true;
            return this.f69374a;
        }
        int i11 = a.f69392a[this.f69380g.ordinal()];
        if (i11 == 1) {
            i();
        } else if (i11 == 2) {
            g();
        }
        this.f69374a.close();
        this.f69390q.b(this.f69374a);
        this.f69391r = true;
        return this.f69374a;
    }
}
