package m4;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.x;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class h implements e, a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final String f69337a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f69338b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f69339c;

    /* renamed from: d, reason: collision with root package name */
    private final x f69340d = new x();

    /* renamed from: e, reason: collision with root package name */
    private final x f69341e = new x();

    /* renamed from: f, reason: collision with root package name */
    private final Path f69342f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f69343g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f69344h;

    /* renamed from: i, reason: collision with root package name */
    private final List f69345i;

    /* renamed from: j, reason: collision with root package name */
    private final GradientType f69346j;

    /* renamed from: k, reason: collision with root package name */
    private final n4.a f69347k;

    /* renamed from: l, reason: collision with root package name */
    private final n4.a f69348l;

    /* renamed from: m, reason: collision with root package name */
    private final n4.a f69349m;

    /* renamed from: n, reason: collision with root package name */
    private final n4.a f69350n;

    /* renamed from: o, reason: collision with root package name */
    private n4.a f69351o;

    /* renamed from: p, reason: collision with root package name */
    private n4.q f69352p;

    /* renamed from: q, reason: collision with root package name */
    private final LottieDrawable f69353q;

    /* renamed from: r, reason: collision with root package name */
    private final int f69354r;

    /* renamed from: s, reason: collision with root package name */
    private n4.a f69355s;

    /* renamed from: t, reason: collision with root package name */
    float f69356t;

    /* renamed from: u, reason: collision with root package name */
    private n4.c f69357u;

    public h(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, r4.e eVar) {
        Path path = new Path();
        this.f69342f = path;
        this.f69343g = new l4.a(1);
        this.f69344h = new RectF();
        this.f69345i = new ArrayList();
        this.f69356t = 0.0f;
        this.f69339c = aVar;
        this.f69337a = eVar.f();
        this.f69338b = eVar.i();
        this.f69353q = lottieDrawable;
        this.f69346j = eVar.e();
        path.setFillType(eVar.c());
        this.f69354r = (int) (hVar.d() / 32.0f);
        n4.a a11 = eVar.d().a();
        this.f69347k = a11;
        a11.a(this);
        aVar.i(a11);
        n4.a a12 = eVar.g().a();
        this.f69348l = a12;
        a12.a(this);
        aVar.i(a12);
        n4.a a13 = eVar.h().a();
        this.f69349m = a13;
        a13.a(this);
        aVar.i(a13);
        n4.a a14 = eVar.b().a();
        this.f69350n = a14;
        a14.a(this);
        aVar.i(a14);
        if (aVar.w() != null) {
            n4.d a15 = aVar.w().a().a();
            this.f69355s = a15;
            a15.a(this);
            aVar.i(this.f69355s);
        }
        if (aVar.y() != null) {
            this.f69357u = new n4.c(this, aVar, aVar.y());
        }
    }

    private int[] g(int[] iArr) {
        n4.q qVar = this.f69352p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i11 = 0;
            if (iArr.length == numArr.length) {
                while (i11 < iArr.length) {
                    iArr[i11] = numArr[i11].intValue();
                    i11++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i11 < numArr.length) {
                    iArr[i11] = numArr[i11].intValue();
                    i11++;
                }
            }
        }
        return iArr;
    }

    private int i() {
        int round = Math.round(this.f69349m.f() * this.f69354r);
        int round2 = Math.round(this.f69350n.f() * this.f69354r);
        int round3 = Math.round(this.f69347k.f() * this.f69354r);
        int i11 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i11 = i11 * 31 * round2;
        }
        return round3 != 0 ? i11 * 31 * round3 : i11;
    }

    private LinearGradient j() {
        long i11 = i();
        LinearGradient linearGradient = (LinearGradient) this.f69340d.e(i11);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f69349m.h();
        PointF pointF2 = (PointF) this.f69350n.h();
        r4.d dVar = (r4.d) this.f69347k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, g(dVar.d()), dVar.e(), Shader.TileMode.CLAMP);
        this.f69340d.k(i11, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient k() {
        long i11 = i();
        RadialGradient radialGradient = (RadialGradient) this.f69341e.e(i11);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f69349m.h();
        PointF pointF2 = (PointF) this.f69350n.h();
        r4.d dVar = (r4.d) this.f69347k.h();
        int[] g11 = g(dVar.d());
        float[] e11 = dVar.e();
        float f11 = pointF.x;
        float f12 = pointF.y;
        float hypot = (float) Math.hypot(pointF2.x - f11, pointF2.y - f12);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f11, f12, hypot, g11, e11, Shader.TileMode.CLAMP);
        this.f69341e.k(i11, radialGradient2);
        return radialGradient2;
    }

    @Override // n4.a.b
    public void a() {
        this.f69353q.invalidateSelf();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        n4.c cVar2;
        n4.c cVar3;
        n4.c cVar4;
        n4.c cVar5;
        n4.c cVar6;
        if (obj == p0.f17988d) {
            this.f69348l.o(cVar);
            return;
        }
        if (obj == p0.K) {
            n4.a aVar = this.f69351o;
            if (aVar != null) {
                this.f69339c.H(aVar);
            }
            if (cVar == null) {
                this.f69351o = null;
                return;
            }
            n4.q qVar = new n4.q(cVar);
            this.f69351o = qVar;
            qVar.a(this);
            this.f69339c.i(this.f69351o);
            return;
        }
        if (obj == p0.L) {
            n4.q qVar2 = this.f69352p;
            if (qVar2 != null) {
                this.f69339c.H(qVar2);
            }
            if (cVar == null) {
                this.f69352p = null;
                return;
            }
            this.f69340d.b();
            this.f69341e.b();
            n4.q qVar3 = new n4.q(cVar);
            this.f69352p = qVar3;
            qVar3.a(this);
            this.f69339c.i(this.f69352p);
            return;
        }
        if (obj == p0.f17994j) {
            n4.a aVar2 = this.f69355s;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            n4.q qVar4 = new n4.q(cVar);
            this.f69355s = qVar4;
            qVar4.a(this);
            this.f69339c.i(this.f69355s);
            return;
        }
        if (obj == p0.f17989e && (cVar6 = this.f69357u) != null) {
            cVar6.c(cVar);
            return;
        }
        if (obj == p0.G && (cVar5 = this.f69357u) != null) {
            cVar5.f(cVar);
            return;
        }
        if (obj == p0.H && (cVar4 = this.f69357u) != null) {
            cVar4.d(cVar);
            return;
        }
        if (obj == p0.I && (cVar3 = this.f69357u) != null) {
            cVar3.e(cVar);
        } else {
            if (obj != p0.J || (cVar2 = this.f69357u) == null) {
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
                this.f69345i.add((m) cVar);
            }
        }
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        v4.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // m4.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f69342f.reset();
        for (int i11 = 0; i11 < this.f69345i.size(); i11++) {
            this.f69342f.addPath(((m) this.f69345i.get(i11)).getPath(), matrix);
        }
        this.f69342f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // m4.c
    public String getName() {
        return this.f69337a;
    }

    @Override // m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f69338b) {
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("GradientFillContent#draw");
        }
        this.f69342f.reset();
        for (int i12 = 0; i12 < this.f69345i.size(); i12++) {
            this.f69342f.addPath(((m) this.f69345i.get(i12)).getPath(), matrix);
        }
        this.f69342f.computeBounds(this.f69344h, false);
        Shader j11 = this.f69346j == GradientType.LINEAR ? j() : k();
        j11.setLocalMatrix(matrix);
        this.f69343g.setShader(j11);
        n4.a aVar = this.f69351o;
        if (aVar != null) {
            this.f69343g.setColorFilter((ColorFilter) aVar.h());
        }
        n4.a aVar2 = this.f69355s;
        if (aVar2 != null) {
            float floatValue = ((Float) aVar2.h()).floatValue();
            if (floatValue == 0.0f) {
                this.f69343g.setMaskFilter(null);
            } else if (floatValue != this.f69356t) {
                this.f69343g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f69356t = floatValue;
        }
        int intValue = (int) ((((i11 / 255.0f) * ((Integer) this.f69348l.h()).intValue()) / 100.0f) * 255.0f);
        this.f69343g.setAlpha(v4.k.c(intValue, 0, 255));
        n4.c cVar = this.f69357u;
        if (cVar != null) {
            cVar.b(this.f69343g, matrix, v4.l.l(i11, intValue));
        }
        canvas.drawPath(this.f69342f, this.f69343g);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("GradientFillContent#draw");
        }
    }
}
