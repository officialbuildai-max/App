package m4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class g implements e, a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final Path f69324a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f69325b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f69326c;

    /* renamed from: d, reason: collision with root package name */
    private final String f69327d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f69328e;

    /* renamed from: f, reason: collision with root package name */
    private final List f69329f;

    /* renamed from: g, reason: collision with root package name */
    private final n4.a f69330g;

    /* renamed from: h, reason: collision with root package name */
    private final n4.a f69331h;

    /* renamed from: i, reason: collision with root package name */
    private n4.a f69332i;

    /* renamed from: j, reason: collision with root package name */
    private final LottieDrawable f69333j;

    /* renamed from: k, reason: collision with root package name */
    private n4.a f69334k;

    /* renamed from: l, reason: collision with root package name */
    float f69335l;

    /* renamed from: m, reason: collision with root package name */
    private n4.c f69336m;

    public g(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, r4.j jVar) {
        Path path = new Path();
        this.f69324a = path;
        this.f69325b = new l4.a(1);
        this.f69329f = new ArrayList();
        this.f69326c = aVar;
        this.f69327d = jVar.d();
        this.f69328e = jVar.f();
        this.f69333j = lottieDrawable;
        if (aVar.w() != null) {
            n4.d a11 = aVar.w().a().a();
            this.f69334k = a11;
            a11.a(this);
            aVar.i(this.f69334k);
        }
        if (aVar.y() != null) {
            this.f69336m = new n4.c(this, aVar, aVar.y());
        }
        if (jVar.b() == null || jVar.e() == null) {
            this.f69330g = null;
            this.f69331h = null;
            return;
        }
        path.setFillType(jVar.c());
        n4.a a12 = jVar.b().a();
        this.f69330g = a12;
        a12.a(this);
        aVar.i(a12);
        n4.a a13 = jVar.e().a();
        this.f69331h = a13;
        a13.a(this);
        aVar.i(a13);
    }

    @Override // n4.a.b
    public void a() {
        this.f69333j.invalidateSelf();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        n4.c cVar2;
        n4.c cVar3;
        n4.c cVar4;
        n4.c cVar5;
        n4.c cVar6;
        if (obj == p0.f17985a) {
            this.f69330g.o(cVar);
            return;
        }
        if (obj == p0.f17988d) {
            this.f69331h.o(cVar);
            return;
        }
        if (obj == p0.K) {
            n4.a aVar = this.f69332i;
            if (aVar != null) {
                this.f69326c.H(aVar);
            }
            if (cVar == null) {
                this.f69332i = null;
                return;
            }
            n4.q qVar = new n4.q(cVar);
            this.f69332i = qVar;
            qVar.a(this);
            this.f69326c.i(this.f69332i);
            return;
        }
        if (obj == p0.f17994j) {
            n4.a aVar2 = this.f69334k;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            n4.q qVar2 = new n4.q(cVar);
            this.f69334k = qVar2;
            qVar2.a(this);
            this.f69326c.i(this.f69334k);
            return;
        }
        if (obj == p0.f17989e && (cVar6 = this.f69336m) != null) {
            cVar6.c(cVar);
            return;
        }
        if (obj == p0.G && (cVar5 = this.f69336m) != null) {
            cVar5.f(cVar);
            return;
        }
        if (obj == p0.H && (cVar4 = this.f69336m) != null) {
            cVar4.d(cVar);
            return;
        }
        if (obj == p0.I && (cVar3 = this.f69336m) != null) {
            cVar3.e(cVar);
        } else {
            if (obj != p0.J || (cVar2 = this.f69336m) == null) {
                return;
            }
            cVar2.g(cVar);
        }
    }

    @Override // m4.c
    public void c(List list, List list2) {
        for (int i11 = 0; i11 < list2.size(); i11++) {
            c cVar = (c) list2.get(i11);
            if (cVar instanceof m) {
                this.f69329f.add((m) cVar);
            }
        }
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        v4.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // m4.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f69324a.reset();
        for (int i11 = 0; i11 < this.f69329f.size(); i11++) {
            this.f69324a.addPath(((m) this.f69329f.get(i11)).getPath(), matrix);
        }
        this.f69324a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // m4.c
    public String getName() {
        return this.f69327d;
    }

    @Override // m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f69328e) {
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("FillContent#draw");
        }
        int intValue = (int) ((((i11 / 255.0f) * ((Integer) this.f69331h.h()).intValue()) / 100.0f) * 255.0f);
        this.f69325b.setColor((((n4.b) this.f69330g).q() & 16777215) | (v4.k.c(intValue, 0, 255) << 24));
        n4.a aVar = this.f69332i;
        if (aVar != null) {
            this.f69325b.setColorFilter((ColorFilter) aVar.h());
        }
        n4.a aVar2 = this.f69334k;
        if (aVar2 != null) {
            float floatValue = ((Float) aVar2.h()).floatValue();
            if (floatValue == 0.0f) {
                this.f69325b.setMaskFilter(null);
            } else if (floatValue != this.f69335l) {
                this.f69325b.setMaskFilter(this.f69326c.x(floatValue));
            }
            this.f69335l = floatValue;
        }
        n4.c cVar = this.f69336m;
        if (cVar != null) {
            cVar.b(this.f69325b, matrix, v4.l.l(i11, intValue));
        }
        this.f69324a.reset();
        for (int i12 = 0; i12 < this.f69329f.size(); i12++) {
            this.f69324a.addPath(((m) this.f69329f.get(i12)).getPath(), matrix);
        }
        canvas.drawPath(this.f69324a, this.f69325b);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("FillContent#draw");
        }
    }
}
