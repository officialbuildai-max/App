package n4;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.p0;
import java.util.Collections;
import n4.a;

/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f70355a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f70356b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f70357c;

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f70358d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f70359e;

    /* renamed from: f, reason: collision with root package name */
    private a f70360f;

    /* renamed from: g, reason: collision with root package name */
    private a f70361g;

    /* renamed from: h, reason: collision with root package name */
    private a f70362h;

    /* renamed from: i, reason: collision with root package name */
    private a f70363i;

    /* renamed from: j, reason: collision with root package name */
    private a f70364j;

    /* renamed from: k, reason: collision with root package name */
    private d f70365k;

    /* renamed from: l, reason: collision with root package name */
    private d f70366l;

    /* renamed from: m, reason: collision with root package name */
    private a f70367m;

    /* renamed from: n, reason: collision with root package name */
    private a f70368n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f70369o;

    public p(q4.n nVar) {
        this.f70360f = nVar.c() == null ? null : nVar.c().a();
        this.f70361g = nVar.f() == null ? null : nVar.f().a();
        this.f70362h = nVar.h() == null ? null : nVar.h().a();
        this.f70363i = nVar.g() == null ? null : nVar.g().a();
        this.f70365k = nVar.i() == null ? null : nVar.i().a();
        this.f70369o = nVar.l();
        if (this.f70365k != null) {
            this.f70356b = new Matrix();
            this.f70357c = new Matrix();
            this.f70358d = new Matrix();
            this.f70359e = new float[9];
        } else {
            this.f70356b = null;
            this.f70357c = null;
            this.f70358d = null;
            this.f70359e = null;
        }
        this.f70366l = nVar.j() == null ? null : nVar.j().a();
        if (nVar.e() != null) {
            this.f70364j = nVar.e().a();
        }
        if (nVar.k() != null) {
            this.f70367m = nVar.k().a();
        } else {
            this.f70367m = null;
        }
        if (nVar.d() != null) {
            this.f70368n = nVar.d().a();
        } else {
            this.f70368n = null;
        }
    }

    private void d() {
        for (int i11 = 0; i11 < 9; i11++) {
            this.f70359e[i11] = 0.0f;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.i(this.f70364j);
        aVar.i(this.f70367m);
        aVar.i(this.f70368n);
        aVar.i(this.f70360f);
        aVar.i(this.f70361g);
        aVar.i(this.f70362h);
        aVar.i(this.f70363i);
        aVar.i(this.f70365k);
        aVar.i(this.f70366l);
    }

    public void b(a.b bVar) {
        a aVar = this.f70364j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a aVar2 = this.f70367m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a aVar3 = this.f70368n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a aVar4 = this.f70360f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a aVar5 = this.f70361g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a aVar6 = this.f70362h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a aVar7 = this.f70363i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        d dVar = this.f70365k;
        if (dVar != null) {
            dVar.a(bVar);
        }
        d dVar2 = this.f70366l;
        if (dVar2 != null) {
            dVar2.a(bVar);
        }
    }

    public boolean c(Object obj, w4.c cVar) {
        if (obj == p0.f17990f) {
            a aVar = this.f70360f;
            if (aVar == null) {
                this.f70360f = new q(cVar, new PointF());
                return true;
            }
            aVar.o(cVar);
            return true;
        }
        if (obj == p0.f17991g) {
            a aVar2 = this.f70361g;
            if (aVar2 == null) {
                this.f70361g = new q(cVar, new PointF());
                return true;
            }
            aVar2.o(cVar);
            return true;
        }
        if (obj == p0.f17992h) {
            a aVar3 = this.f70361g;
            if (aVar3 instanceof n) {
                ((n) aVar3).s(cVar);
                return true;
            }
        }
        if (obj == p0.f17993i) {
            a aVar4 = this.f70361g;
            if (aVar4 instanceof n) {
                ((n) aVar4).t(cVar);
                return true;
            }
        }
        if (obj == p0.f17999o) {
            a aVar5 = this.f70362h;
            if (aVar5 == null) {
                this.f70362h = new q(cVar, new w4.d());
                return true;
            }
            aVar5.o(cVar);
            return true;
        }
        if (obj == p0.f18000p) {
            a aVar6 = this.f70363i;
            if (aVar6 == null) {
                this.f70363i = new q(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.o(cVar);
            return true;
        }
        if (obj == p0.f17987c) {
            a aVar7 = this.f70364j;
            if (aVar7 == null) {
                this.f70364j = new q(cVar, 100);
                return true;
            }
            aVar7.o(cVar);
            return true;
        }
        if (obj == p0.C) {
            a aVar8 = this.f70367m;
            if (aVar8 == null) {
                this.f70367m = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar8.o(cVar);
            return true;
        }
        if (obj == p0.D) {
            a aVar9 = this.f70368n;
            if (aVar9 == null) {
                this.f70368n = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar9.o(cVar);
            return true;
        }
        if (obj == p0.f18001q) {
            if (this.f70365k == null) {
                this.f70365k = new d(Collections.singletonList(new w4.a(Float.valueOf(0.0f))));
            }
            this.f70365k.o(cVar);
            return true;
        }
        if (obj != p0.f18002r) {
            return false;
        }
        if (this.f70366l == null) {
            this.f70366l = new d(Collections.singletonList(new w4.a(Float.valueOf(0.0f))));
        }
        this.f70366l.o(cVar);
        return true;
    }

    public a e() {
        return this.f70368n;
    }

    public Matrix f() {
        PointF pointF;
        w4.d dVar;
        PointF pointF2;
        this.f70355a.reset();
        a aVar = this.f70361g;
        if (aVar != null && (pointF2 = (PointF) aVar.h()) != null) {
            float f11 = pointF2.x;
            if (f11 != 0.0f || pointF2.y != 0.0f) {
                this.f70355a.preTranslate(f11, pointF2.y);
            }
        }
        if (!this.f70369o) {
            a aVar2 = this.f70363i;
            if (aVar2 != null) {
                float floatValue = aVar2 instanceof q ? ((Float) aVar2.h()).floatValue() : ((d) aVar2).q();
                if (floatValue != 0.0f) {
                    this.f70355a.preRotate(floatValue);
                }
            }
        } else if (aVar != null) {
            float f12 = aVar.f();
            PointF pointF3 = (PointF) aVar.h();
            float f13 = pointF3.x;
            float f14 = pointF3.y;
            aVar.n(1.0E-4f + f12);
            PointF pointF4 = (PointF) aVar.h();
            aVar.n(f12);
            this.f70355a.preRotate((float) Math.toDegrees(Math.atan2(pointF4.y - f14, pointF4.x - f13)));
        }
        if (this.f70365k != null) {
            float cos = this.f70366l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.q()) + 90.0f));
            float sin = this.f70366l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.q()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.q()));
            d();
            float[] fArr = this.f70359e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f15 = -sin;
            fArr[3] = f15;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f70356b.setValues(fArr);
            d();
            float[] fArr2 = this.f70359e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f70357c.setValues(fArr2);
            d();
            float[] fArr3 = this.f70359e;
            fArr3[0] = cos;
            fArr3[1] = f15;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f70358d.setValues(fArr3);
            this.f70357c.preConcat(this.f70356b);
            this.f70358d.preConcat(this.f70357c);
            this.f70355a.preConcat(this.f70358d);
        }
        a aVar3 = this.f70362h;
        if (aVar3 != null && (dVar = (w4.d) aVar3.h()) != null && (dVar.b() != 1.0f || dVar.c() != 1.0f)) {
            this.f70355a.preScale(dVar.b(), dVar.c());
        }
        a aVar4 = this.f70360f;
        if (aVar4 != null && (pointF = (PointF) aVar4.h()) != null) {
            float f16 = pointF.x;
            if (f16 != 0.0f || pointF.y != 0.0f) {
                this.f70355a.preTranslate(-f16, -pointF.y);
            }
        }
        return this.f70355a;
    }

    public Matrix g(float f11) {
        a aVar = this.f70361g;
        PointF pointF = aVar == null ? null : (PointF) aVar.h();
        a aVar2 = this.f70362h;
        w4.d dVar = aVar2 == null ? null : (w4.d) aVar2.h();
        this.f70355a.reset();
        if (pointF != null) {
            this.f70355a.preTranslate(pointF.x * f11, pointF.y * f11);
        }
        if (dVar != null) {
            double d11 = f11;
            this.f70355a.preScale((float) Math.pow(dVar.b(), d11), (float) Math.pow(dVar.c(), d11));
        }
        a aVar3 = this.f70363i;
        if (aVar3 != null) {
            float floatValue = ((Float) aVar3.h()).floatValue();
            a aVar4 = this.f70360f;
            PointF pointF2 = aVar4 != null ? (PointF) aVar4.h() : null;
            this.f70355a.preRotate(floatValue * f11, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return this.f70355a;
    }

    public a h() {
        return this.f70364j;
    }

    public a i() {
        return this.f70367m;
    }

    public void j(float f11) {
        a aVar = this.f70364j;
        if (aVar != null) {
            aVar.n(f11);
        }
        a aVar2 = this.f70367m;
        if (aVar2 != null) {
            aVar2.n(f11);
        }
        a aVar3 = this.f70368n;
        if (aVar3 != null) {
            aVar3.n(f11);
        }
        a aVar4 = this.f70360f;
        if (aVar4 != null) {
            aVar4.n(f11);
        }
        a aVar5 = this.f70361g;
        if (aVar5 != null) {
            aVar5.n(f11);
        }
        a aVar6 = this.f70362h;
        if (aVar6 != null) {
            aVar6.n(f11);
        }
        a aVar7 = this.f70363i;
        if (aVar7 != null) {
            aVar7.n(f11);
        }
        d dVar = this.f70365k;
        if (dVar != null) {
            dVar.n(f11);
        }
        d dVar2 = this.f70366l;
        if (dVar2 != null) {
            dVar2.n(f11);
        }
    }
}
