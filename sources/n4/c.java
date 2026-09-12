package n4;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import n4.a;

/* loaded from: classes2.dex */
public class c implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f70313a;

    /* renamed from: b, reason: collision with root package name */
    private final a.b f70314b;

    /* renamed from: c, reason: collision with root package name */
    private final n4.a f70315c;

    /* renamed from: d, reason: collision with root package name */
    private final d f70316d;

    /* renamed from: e, reason: collision with root package name */
    private final d f70317e;

    /* renamed from: f, reason: collision with root package name */
    private final d f70318f;

    /* renamed from: g, reason: collision with root package name */
    private final d f70319g;

    /* renamed from: h, reason: collision with root package name */
    private float f70320h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    private float f70321i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    private float f70322j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    private int f70323k = 0;

    /* renamed from: l, reason: collision with root package name */
    private final float[] f70324l = new float[9];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends w4.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ w4.c f70325d;

        a(w4.c cVar) {
            this.f70325d = cVar;
        }

        @Override // w4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(w4.b bVar) {
            Float f11 = (Float) this.f70325d.a(bVar);
            if (f11 == null) {
                return null;
            }
            return Float.valueOf(f11.floatValue() * 2.55f);
        }
    }

    public c(a.b bVar, com.airbnb.lottie.model.layer.a aVar, u4.j jVar) {
        this.f70314b = bVar;
        this.f70313a = aVar;
        n4.a a11 = jVar.a().a();
        this.f70315c = a11;
        a11.a(this);
        aVar.i(a11);
        d a12 = jVar.d().a();
        this.f70316d = a12;
        a12.a(this);
        aVar.i(a12);
        d a13 = jVar.b().a();
        this.f70317e = a13;
        a13.a(this);
        aVar.i(a13);
        d a14 = jVar.c().a();
        this.f70318f = a14;
        a14.a(this);
        aVar.i(a14);
        d a15 = jVar.e().a();
        this.f70319g = a15;
        a15.a(this);
        aVar.i(a15);
    }

    @Override // n4.a.b
    public void a() {
        this.f70314b.a();
    }

    public void b(Paint paint, Matrix matrix, int i11) {
        float q11 = this.f70317e.q() * 0.017453292f;
        float floatValue = ((Float) this.f70318f.h()).floatValue();
        double d11 = q11;
        float sin = ((float) Math.sin(d11)) * floatValue;
        float cos = ((float) Math.cos(d11 + 3.141592653589793d)) * floatValue;
        this.f70313a.f17963x.f().getValues(this.f70324l);
        float[] fArr = this.f70324l;
        float f11 = fArr[0];
        float f12 = fArr[4];
        matrix.getValues(fArr);
        float[] fArr2 = this.f70324l;
        float f13 = fArr2[0] / f11;
        float f14 = sin * f13;
        float f15 = cos * (fArr2[4] / f12);
        int intValue = ((Integer) this.f70315c.h()).intValue();
        int argb = Color.argb(Math.round((((Float) this.f70316d.h()).floatValue() * i11) / 255.0f), Color.red(intValue), Color.green(intValue), Color.blue(intValue));
        float max = Math.max(((Float) this.f70319g.h()).floatValue() * f13, Float.MIN_VALUE);
        if (this.f70320h == max && this.f70321i == f14 && this.f70322j == f15 && this.f70323k == argb) {
            return;
        }
        this.f70320h = max;
        this.f70321i = f14;
        this.f70322j = f15;
        this.f70323k = argb;
        paint.setShadowLayer(max, f14, f15, argb);
    }

    public void c(w4.c cVar) {
        this.f70315c.o(cVar);
    }

    public void d(w4.c cVar) {
        this.f70317e.o(cVar);
    }

    public void e(w4.c cVar) {
        this.f70318f.o(cVar);
    }

    public void f(w4.c cVar) {
        if (cVar == null) {
            this.f70316d.o(null);
        } else {
            this.f70316d.o(new a(cVar));
        }
    }

    public void g(w4.c cVar) {
        this.f70319g.o(cVar);
    }
}
