package ab;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final p[] f626a = new p[4];

    /* renamed from: b, reason: collision with root package name */
    private final Matrix[] f627b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix[] f628c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    private final PointF f629d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final Path f630e = new Path();

    /* renamed from: f, reason: collision with root package name */
    private final Path f631f = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final p f632g = new p();

    /* renamed from: h, reason: collision with root package name */
    private final float[] f633h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private final float[] f634i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private final Path f635j = new Path();

    /* renamed from: k, reason: collision with root package name */
    private final Path f636k = new Path();

    /* renamed from: l, reason: collision with root package name */
    private boolean f637l = true;

    /* loaded from: classes4.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final o f638a = new o();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(p pVar, Matrix matrix, int i11);

        void b(p pVar, Matrix matrix, int i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final n f639a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f640b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f641c;

        /* renamed from: d, reason: collision with root package name */
        public final b f642d;

        /* renamed from: e, reason: collision with root package name */
        public final float f643e;

        c(n nVar, float f11, RectF rectF, b bVar, Path path) {
            this.f642d = bVar;
            this.f639a = nVar;
            this.f643e = f11;
            this.f641c = rectF;
            this.f640b = path;
        }
    }

    public o() {
        for (int i11 = 0; i11 < 4; i11++) {
            this.f626a[i11] = new p();
            this.f627b[i11] = new Matrix();
            this.f628c[i11] = new Matrix();
        }
    }

    private float a(int i11) {
        return ((i11 + 1) % 4) * 90;
    }

    private void b(c cVar, int i11) {
        this.f633h[0] = this.f626a[i11].k();
        this.f633h[1] = this.f626a[i11].l();
        this.f627b[i11].mapPoints(this.f633h);
        if (i11 == 0) {
            Path path = cVar.f640b;
            float[] fArr = this.f633h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f640b;
            float[] fArr2 = this.f633h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f626a[i11].d(this.f627b[i11], cVar.f640b);
        b bVar = cVar.f642d;
        if (bVar != null) {
            bVar.b(this.f626a[i11], this.f627b[i11], i11);
        }
    }

    private void c(c cVar, int i11) {
        int i12 = (i11 + 1) % 4;
        this.f633h[0] = this.f626a[i11].i();
        this.f633h[1] = this.f626a[i11].j();
        this.f627b[i11].mapPoints(this.f633h);
        this.f634i[0] = this.f626a[i12].k();
        this.f634i[1] = this.f626a[i12].l();
        this.f627b[i12].mapPoints(this.f634i);
        float f11 = this.f633h[0];
        float[] fArr = this.f634i;
        float max = Math.max(((float) Math.hypot(f11 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i13 = i(cVar.f641c, i11);
        this.f632g.n(0.0f, 0.0f);
        g j11 = j(i11, cVar.f639a);
        j11.b(max, i13, cVar.f643e, this.f632g);
        this.f635j.reset();
        this.f632g.d(this.f628c[i11], this.f635j);
        if (this.f637l && (j11.a() || l(this.f635j, i11) || l(this.f635j, i12))) {
            Path path = this.f635j;
            path.op(path, this.f631f, Path.Op.DIFFERENCE);
            this.f633h[0] = this.f632g.k();
            this.f633h[1] = this.f632g.l();
            this.f628c[i11].mapPoints(this.f633h);
            Path path2 = this.f630e;
            float[] fArr2 = this.f633h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f632g.d(this.f628c[i11], this.f630e);
        } else {
            this.f632g.d(this.f628c[i11], cVar.f640b);
        }
        b bVar = cVar.f642d;
        if (bVar != null) {
            bVar.a(this.f632g, this.f628c[i11], i11);
        }
    }

    private void f(int i11, RectF rectF, PointF pointF) {
        if (i11 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i11 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i11 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private d g(int i11, n nVar) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? nVar.t() : nVar.r() : nVar.j() : nVar.l();
    }

    private e h(int i11, n nVar) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? nVar.s() : nVar.q() : nVar.i() : nVar.k();
    }

    private float i(RectF rectF, int i11) {
        float[] fArr = this.f633h;
        p pVar = this.f626a[i11];
        fArr[0] = pVar.f646c;
        fArr[1] = pVar.f647d;
        this.f627b[i11].mapPoints(fArr);
        return (i11 == 1 || i11 == 3) ? Math.abs(rectF.centerX() - this.f633h[0]) : Math.abs(rectF.centerY() - this.f633h[1]);
    }

    private g j(int i11, n nVar) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? nVar.o() : nVar.p() : nVar.n() : nVar.h();
    }

    public static o k() {
        return a.f638a;
    }

    private boolean l(Path path, int i11) {
        this.f636k.reset();
        this.f626a[i11].d(this.f627b[i11], this.f636k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f636k.computeBounds(rectF, true);
        path.op(this.f636k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(c cVar, int i11) {
        h(i11, cVar.f639a).c(this.f626a[i11], 90.0f, cVar.f643e, cVar.f641c, g(i11, cVar.f639a));
        float a11 = a(i11);
        this.f627b[i11].reset();
        f(i11, cVar.f641c, this.f629d);
        Matrix matrix = this.f627b[i11];
        PointF pointF = this.f629d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f627b[i11].preRotate(a11);
    }

    private void n(int i11) {
        this.f633h[0] = this.f626a[i11].i();
        this.f633h[1] = this.f626a[i11].j();
        this.f627b[i11].mapPoints(this.f633h);
        float a11 = a(i11);
        this.f628c[i11].reset();
        Matrix matrix = this.f628c[i11];
        float[] fArr = this.f633h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f628c[i11].preRotate(a11);
    }

    public void d(n nVar, float f11, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f630e.rewind();
        this.f631f.rewind();
        this.f631f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(nVar, f11, rectF, bVar, path);
        for (int i11 = 0; i11 < 4; i11++) {
            m(cVar, i11);
            n(i11);
        }
        for (int i12 = 0; i12 < 4; i12++) {
            b(cVar, i12);
            c(cVar, i12);
        }
        path.close();
        this.f630e.close();
        if (this.f630e.isEmpty()) {
            return;
        }
        path.op(this.f630e, Path.Op.UNION);
    }

    public void e(n nVar, float f11, RectF rectF, Path path) {
        d(nVar, f11, rectF, null, path);
    }
}
