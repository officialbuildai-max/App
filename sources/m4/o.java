package m4;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class o implements a.b, k, m {

    /* renamed from: c, reason: collision with root package name */
    private final String f69395c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f69396d;

    /* renamed from: e, reason: collision with root package name */
    private final LottieDrawable f69397e;

    /* renamed from: f, reason: collision with root package name */
    private final n4.a f69398f;

    /* renamed from: g, reason: collision with root package name */
    private final n4.a f69399g;

    /* renamed from: h, reason: collision with root package name */
    private final n4.a f69400h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f69403k;

    /* renamed from: a, reason: collision with root package name */
    private final Path f69393a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f69394b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private final b f69401i = new b();

    /* renamed from: j, reason: collision with root package name */
    private n4.a f69402j = null;

    public o(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, r4.f fVar) {
        this.f69395c = fVar.c();
        this.f69396d = fVar.f();
        this.f69397e = lottieDrawable;
        n4.a a11 = fVar.d().a();
        this.f69398f = a11;
        n4.a a12 = fVar.e().a();
        this.f69399g = a12;
        n4.d a13 = fVar.b().a();
        this.f69400h = a13;
        aVar.i(a11);
        aVar.i(a12);
        aVar.i(a13);
        a11.a(this);
        a12.a(this);
        a13.a(this);
    }

    private void g() {
        this.f69403k = false;
        this.f69397e.invalidateSelf();
    }

    @Override // n4.a.b
    public void a() {
        g();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        if (obj == p0.f17996l) {
            this.f69399g.o(cVar);
        } else if (obj == p0.f17998n) {
            this.f69398f.o(cVar);
        } else if (obj == p0.f17997m) {
            this.f69400h.o(cVar);
        }
    }

    @Override // m4.c
    public void c(List list, List list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = (c) list.get(i11);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f69401i.a(uVar);
                    uVar.b(this);
                }
            }
            if (cVar instanceof q) {
                this.f69402j = ((q) cVar).g();
            }
        }
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        v4.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // m4.c
    public String getName() {
        return this.f69395c;
    }

    @Override // m4.m
    public Path getPath() {
        n4.a aVar;
        if (this.f69403k) {
            return this.f69393a;
        }
        this.f69393a.reset();
        if (this.f69396d) {
            this.f69403k = true;
            return this.f69393a;
        }
        PointF pointF = (PointF) this.f69399g.h();
        float f11 = pointF.x / 2.0f;
        float f12 = pointF.y / 2.0f;
        n4.a aVar2 = this.f69400h;
        float q11 = aVar2 == null ? 0.0f : ((n4.d) aVar2).q();
        if (q11 == 0.0f && (aVar = this.f69402j) != null) {
            q11 = Math.min(((Float) aVar.h()).floatValue(), Math.min(f11, f12));
        }
        float min = Math.min(f11, f12);
        if (q11 > min) {
            q11 = min;
        }
        PointF pointF2 = (PointF) this.f69398f.h();
        this.f69393a.moveTo(pointF2.x + f11, (pointF2.y - f12) + q11);
        this.f69393a.lineTo(pointF2.x + f11, (pointF2.y + f12) - q11);
        if (q11 > 0.0f) {
            RectF rectF = this.f69394b;
            float f13 = pointF2.x;
            float f14 = q11 * 2.0f;
            float f15 = pointF2.y;
            rectF.set((f13 + f11) - f14, (f15 + f12) - f14, f13 + f11, f15 + f12);
            this.f69393a.arcTo(this.f69394b, 0.0f, 90.0f, false);
        }
        this.f69393a.lineTo((pointF2.x - f11) + q11, pointF2.y + f12);
        if (q11 > 0.0f) {
            RectF rectF2 = this.f69394b;
            float f16 = pointF2.x;
            float f17 = pointF2.y;
            float f18 = q11 * 2.0f;
            rectF2.set(f16 - f11, (f17 + f12) - f18, (f16 - f11) + f18, f17 + f12);
            this.f69393a.arcTo(this.f69394b, 90.0f, 90.0f, false);
        }
        this.f69393a.lineTo(pointF2.x - f11, (pointF2.y - f12) + q11);
        if (q11 > 0.0f) {
            RectF rectF3 = this.f69394b;
            float f19 = pointF2.x;
            float f20 = pointF2.y;
            float f21 = q11 * 2.0f;
            rectF3.set(f19 - f11, f20 - f12, (f19 - f11) + f21, (f20 - f12) + f21);
            this.f69393a.arcTo(this.f69394b, 180.0f, 90.0f, false);
        }
        this.f69393a.lineTo((pointF2.x + f11) - q11, pointF2.y - f12);
        if (q11 > 0.0f) {
            RectF rectF4 = this.f69394b;
            float f22 = pointF2.x;
            float f23 = q11 * 2.0f;
            float f24 = pointF2.y;
            rectF4.set((f22 + f11) - f23, f24 - f12, f22 + f11, (f24 - f12) + f23);
            this.f69393a.arcTo(this.f69394b, 270.0f, 90.0f, false);
        }
        this.f69393a.close();
        this.f69401i.b(this.f69393a);
        this.f69403k = true;
        return this.f69393a;
    }
}
