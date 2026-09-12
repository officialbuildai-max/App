package m4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e, reason: collision with root package name */
    private final LottieDrawable f69289e;

    /* renamed from: f, reason: collision with root package name */
    protected final com.airbnb.lottie.model.layer.a f69290f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f69292h;

    /* renamed from: i, reason: collision with root package name */
    final Paint f69293i;

    /* renamed from: j, reason: collision with root package name */
    private final n4.a f69294j;

    /* renamed from: k, reason: collision with root package name */
    private final n4.a f69295k;

    /* renamed from: l, reason: collision with root package name */
    private final List f69296l;

    /* renamed from: m, reason: collision with root package name */
    private final n4.a f69297m;

    /* renamed from: n, reason: collision with root package name */
    private n4.a f69298n;

    /* renamed from: o, reason: collision with root package name */
    private n4.a f69299o;

    /* renamed from: p, reason: collision with root package name */
    float f69300p;

    /* renamed from: q, reason: collision with root package name */
    private n4.c f69301q;

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f69285a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private final Path f69286b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f69287c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f69288d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List f69291g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f69302a;

        /* renamed from: b, reason: collision with root package name */
        private final u f69303b;

        private b(u uVar) {
            this.f69302a = new ArrayList();
            this.f69303b = uVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f11, q4.d dVar, q4.b bVar, List list, q4.b bVar2) {
        l4.a aVar2 = new l4.a(1);
        this.f69293i = aVar2;
        this.f69300p = 0.0f;
        this.f69289e = lottieDrawable;
        this.f69290f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f11);
        this.f69295k = dVar.a();
        this.f69294j = bVar.a();
        if (bVar2 == null) {
            this.f69297m = null;
        } else {
            this.f69297m = bVar2.a();
        }
        this.f69296l = new ArrayList(list.size());
        this.f69292h = new float[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f69296l.add(((q4.b) list.get(i11)).a());
        }
        aVar.i(this.f69295k);
        aVar.i(this.f69294j);
        for (int i12 = 0; i12 < this.f69296l.size(); i12++) {
            aVar.i((n4.a) this.f69296l.get(i12));
        }
        n4.a aVar3 = this.f69297m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.f69295k.a(this);
        this.f69294j.a(this);
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((n4.a) this.f69296l.get(i13)).a(this);
        }
        n4.a aVar4 = this.f69297m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
        if (aVar.w() != null) {
            n4.d a11 = aVar.w().a().a();
            this.f69299o = a11;
            a11.a(this);
            aVar.i(this.f69299o);
        }
        if (aVar.y() != null) {
            this.f69301q = new n4.c(this, aVar, aVar.y());
        }
    }

    private void g(Matrix matrix) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#applyDashPattern");
        }
        if (this.f69296l.isEmpty()) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#applyDashPattern");
                return;
            }
            return;
        }
        float g11 = v4.l.g(matrix);
        for (int i11 = 0; i11 < this.f69296l.size(); i11++) {
            this.f69292h[i11] = ((Float) ((n4.a) this.f69296l.get(i11)).h()).floatValue();
            if (i11 % 2 == 0) {
                float[] fArr = this.f69292h;
                if (fArr[i11] < 1.0f) {
                    fArr[i11] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f69292h;
                if (fArr2[i11] < 0.1f) {
                    fArr2[i11] = 0.1f;
                }
            }
            float[] fArr3 = this.f69292h;
            fArr3[i11] = fArr3[i11] * g11;
        }
        n4.a aVar = this.f69297m;
        this.f69293i.setPathEffect(new DashPathEffect(this.f69292h, aVar == null ? 0.0f : g11 * ((Float) aVar.h()).floatValue()));
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#applyDashPattern");
        }
    }

    private void i(Canvas canvas, b bVar, Matrix matrix) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#applyTrimPath");
        }
        if (bVar.f69303b == null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.f69286b.reset();
        for (int size = bVar.f69302a.size() - 1; size >= 0; size--) {
            this.f69286b.addPath(((m) bVar.f69302a.get(size)).getPath(), matrix);
        }
        float floatValue = ((Float) bVar.f69303b.i().h()).floatValue() / 100.0f;
        float floatValue2 = ((Float) bVar.f69303b.d().h()).floatValue() / 100.0f;
        float floatValue3 = ((Float) bVar.f69303b.g().h()).floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.f69286b, this.f69293i);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.f69285a.setPath(this.f69286b, false);
        float length = this.f69285a.getLength();
        while (this.f69285a.nextContour()) {
            length += this.f69285a.getLength();
        }
        float f11 = floatValue3 * length;
        float f12 = (floatValue * length) + f11;
        float min = Math.min((floatValue2 * length) + f11, (f12 + length) - 1.0f);
        float f13 = 0.0f;
        for (int size2 = bVar.f69302a.size() - 1; size2 >= 0; size2--) {
            this.f69287c.set(((m) bVar.f69302a.get(size2)).getPath());
            this.f69287c.transform(matrix);
            this.f69285a.setPath(this.f69287c, false);
            float length2 = this.f69285a.getLength();
            if (min > length) {
                float f14 = min - length;
                if (f14 < f13 + length2 && f13 < f14) {
                    v4.l.a(this.f69287c, f12 > length ? (f12 - length) / length2 : 0.0f, Math.min(f14 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f69287c, this.f69293i);
                    f13 += length2;
                }
            }
            float f15 = f13 + length2;
            if (f15 >= f12 && f13 <= min) {
                if (f15 > min || f12 >= f13) {
                    v4.l.a(this.f69287c, f12 < f13 ? 0.0f : (f12 - f13) / length2, min > f15 ? 1.0f : (min - f13) / length2, 0.0f);
                    canvas.drawPath(this.f69287c, this.f69293i);
                } else {
                    canvas.drawPath(this.f69287c, this.f69293i);
                }
            }
            f13 += length2;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#applyTrimPath");
        }
    }

    @Override // n4.a.b
    public void a() {
        this.f69289e.invalidateSelf();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        n4.c cVar2;
        n4.c cVar3;
        n4.c cVar4;
        n4.c cVar5;
        n4.c cVar6;
        if (obj == p0.f17988d) {
            this.f69295k.o(cVar);
            return;
        }
        if (obj == p0.f18003s) {
            this.f69294j.o(cVar);
            return;
        }
        if (obj == p0.K) {
            n4.a aVar = this.f69298n;
            if (aVar != null) {
                this.f69290f.H(aVar);
            }
            if (cVar == null) {
                this.f69298n = null;
                return;
            }
            n4.q qVar = new n4.q(cVar);
            this.f69298n = qVar;
            qVar.a(this);
            this.f69290f.i(this.f69298n);
            return;
        }
        if (obj == p0.f17994j) {
            n4.a aVar2 = this.f69299o;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            n4.q qVar2 = new n4.q(cVar);
            this.f69299o = qVar2;
            qVar2.a(this);
            this.f69290f.i(this.f69299o);
            return;
        }
        if (obj == p0.f17989e && (cVar6 = this.f69301q) != null) {
            cVar6.c(cVar);
            return;
        }
        if (obj == p0.G && (cVar5 = this.f69301q) != null) {
            cVar5.f(cVar);
            return;
        }
        if (obj == p0.H && (cVar4 = this.f69301q) != null) {
            cVar4.d(cVar);
            return;
        }
        if (obj == p0.I && (cVar3 = this.f69301q) != null) {
            cVar3.e(cVar);
        } else {
            if (obj != p0.J || (cVar2 = this.f69301q) == null) {
                return;
            }
            cVar2.g(cVar);
        }
    }

    @Override // m4.c
    public void c(List list, List list2) {
        u uVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof u) {
                u uVar2 = (u) cVar;
                if (uVar2.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    uVar = uVar2;
                }
            }
        }
        if (uVar != null) {
            uVar.b(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = (c) list2.get(size2);
            if (cVar2 instanceof u) {
                u uVar3 = (u) cVar2;
                if (uVar3.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f69291g.add(bVar);
                    }
                    bVar = new b(uVar3);
                    uVar3.b(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(uVar);
                }
                bVar.f69302a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f69291g.add(bVar);
        }
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        v4.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // m4.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#getBounds");
        }
        this.f69286b.reset();
        for (int i11 = 0; i11 < this.f69291g.size(); i11++) {
            b bVar = (b) this.f69291g.get(i11);
            for (int i12 = 0; i12 < bVar.f69302a.size(); i12++) {
                this.f69286b.addPath(((m) bVar.f69302a.get(i12)).getPath(), matrix);
            }
        }
        this.f69286b.computeBounds(this.f69288d, false);
        float q11 = ((n4.d) this.f69294j).q();
        RectF rectF2 = this.f69288d;
        float f11 = q11 / 2.0f;
        rectF2.set(rectF2.left - f11, rectF2.top - f11, rectF2.right + f11, rectF2.bottom + f11);
        rectF.set(this.f69288d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#getBounds");
        }
    }

    @Override // m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#draw");
        }
        if (v4.l.h(matrix)) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#draw");
                return;
            }
            return;
        }
        int q11 = (int) ((((i11 / 255.0f) * ((n4.f) this.f69295k).q()) / 100.0f) * 255.0f);
        this.f69293i.setAlpha(v4.k.c(q11, 0, 255));
        this.f69293i.setStrokeWidth(((n4.d) this.f69294j).q() * v4.l.g(matrix));
        if (this.f69293i.getStrokeWidth() <= 0.0f) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#draw");
                return;
            }
            return;
        }
        g(matrix);
        n4.a aVar = this.f69298n;
        if (aVar != null) {
            this.f69293i.setColorFilter((ColorFilter) aVar.h());
        }
        n4.a aVar2 = this.f69299o;
        if (aVar2 != null) {
            float floatValue = ((Float) aVar2.h()).floatValue();
            if (floatValue == 0.0f) {
                this.f69293i.setMaskFilter(null);
            } else if (floatValue != this.f69300p) {
                this.f69293i.setMaskFilter(this.f69290f.x(floatValue));
            }
            this.f69300p = floatValue;
        }
        n4.c cVar = this.f69301q;
        if (cVar != null) {
            cVar.b(this.f69293i, matrix, v4.l.l(i11, q11));
        }
        for (int i12 = 0; i12 < this.f69291g.size(); i12++) {
            b bVar = (b) this.f69291g.get(i12);
            if (bVar.f69303b != null) {
                i(canvas, bVar, matrix);
            } else {
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.b("StrokeContent#buildPath");
                }
                this.f69286b.reset();
                for (int size = bVar.f69302a.size() - 1; size >= 0; size--) {
                    this.f69286b.addPath(((m) bVar.f69302a.get(size)).getPath(), matrix);
                }
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("StrokeContent#buildPath");
                    com.airbnb.lottie.d.b("StrokeContent#drawPath");
                }
                canvas.drawPath(this.f69286b, this.f69293i);
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("StrokeContent#drawPath");
                }
            }
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#draw");
        }
    }
}
