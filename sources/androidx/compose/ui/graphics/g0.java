package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.graphics.t4;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g0 implements m1 {

    /* renamed from: a, reason: collision with root package name */
    private Canvas f4521a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f4522b;

    /* renamed from: c, reason: collision with root package name */
    private Rect f4523c;

    public g0() {
        Canvas canvas;
        canvas = h0.f4524a;
        this.f4521a = canvas;
    }

    private final void t(List list, m4 m4Var, int i11) {
        if (list.size() >= 2) {
            Paint w11 = m4Var.w();
            int i12 = 0;
            while (i12 < list.size() - 1) {
                long v11 = ((y.g) list.get(i12)).v();
                long v12 = ((y.g) list.get(i12 + 1)).v();
                this.f4521a.drawLine(y.g.m(v11), y.g.n(v11), y.g.m(v12), y.g.n(v12), w11);
                i12 += i11;
            }
        }
    }

    private final void u(List list, m4 m4Var) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            long v11 = ((y.g) list.get(i11)).v();
            this.f4521a.drawPoint(y.g.m(v11), y.g.n(v11), m4Var.w());
        }
    }

    @Override // androidx.compose.ui.graphics.m1
    public void a(float f11, float f12, float f13, float f14, int i11) {
        this.f4521a.clipRect(f11, f12, f13, f14, x(i11));
    }

    @Override // androidx.compose.ui.graphics.m1
    public void b(Path path, int i11) {
        Canvas canvas = this.f4521a;
        if (!(path instanceof u0)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((u0) path).p(), x(i11));
    }

    @Override // androidx.compose.ui.graphics.m1
    public void c(float f11, float f12) {
        this.f4521a.translate(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.m1
    public void d(y.i iVar, m4 m4Var) {
        this.f4521a.saveLayer(iVar.f(), iVar.i(), iVar.g(), iVar.c(), m4Var.w(), 31);
    }

    @Override // androidx.compose.ui.graphics.m1
    public void e(float f11, float f12) {
        this.f4521a.scale(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.m1
    public void f(float f11, float f12, float f13, float f14, m4 m4Var) {
        this.f4521a.drawRect(f11, f12, f13, f14, m4Var.w());
    }

    @Override // androidx.compose.ui.graphics.m1
    public void g(int i11, List list, m4 m4Var) {
        t4.a aVar = t4.f4726a;
        if (t4.e(i11, aVar.a())) {
            t(list, m4Var, 2);
        } else if (t4.e(i11, aVar.c())) {
            t(list, m4Var, 1);
        } else if (t4.e(i11, aVar.b())) {
            u(list, m4Var);
        }
    }

    @Override // androidx.compose.ui.graphics.m1
    public void h(e4 e4Var, long j11, long j12, long j13, long j14, m4 m4Var) {
        if (this.f4522b == null) {
            this.f4522b = new Rect();
            this.f4523c = new Rect();
        }
        Canvas canvas = this.f4521a;
        Bitmap b11 = q0.b(e4Var);
        Rect rect = this.f4522b;
        Intrinsics.e(rect);
        rect.left = o0.p.h(j11);
        rect.top = o0.p.i(j11);
        rect.right = o0.p.h(j11) + o0.t.g(j12);
        rect.bottom = o0.p.i(j11) + o0.t.f(j12);
        Unit unit = Unit.f67184a;
        Rect rect2 = this.f4523c;
        Intrinsics.e(rect2);
        rect2.left = o0.p.h(j13);
        rect2.top = o0.p.i(j13);
        rect2.right = o0.p.h(j13) + o0.t.g(j14);
        rect2.bottom = o0.p.i(j13) + o0.t.f(j14);
        canvas.drawBitmap(b11, rect, rect2, m4Var.w());
    }

    @Override // androidx.compose.ui.graphics.m1
    public /* synthetic */ void i(y.i iVar, m4 m4Var) {
        l1.b(this, iVar, m4Var);
    }

    @Override // androidx.compose.ui.graphics.m1
    public void j() {
        this.f4521a.restore();
    }

    @Override // androidx.compose.ui.graphics.m1
    public void k() {
        p1.f4686a.a(this.f4521a, true);
    }

    @Override // androidx.compose.ui.graphics.m1
    public /* synthetic */ void l(y.i iVar, int i11) {
        l1.a(this, iVar, i11);
    }

    @Override // androidx.compose.ui.graphics.m1
    public void m(long j11, long j12, m4 m4Var) {
        this.f4521a.drawLine(y.g.m(j11), y.g.n(j11), y.g.m(j12), y.g.n(j12), m4Var.w());
    }

    @Override // androidx.compose.ui.graphics.m1
    public void n() {
        this.f4521a.save();
    }

    @Override // androidx.compose.ui.graphics.m1
    public void o() {
        p1.f4686a.a(this.f4521a, false);
    }

    @Override // androidx.compose.ui.graphics.m1
    public void p(float[] fArr) {
        if (j4.c(fArr)) {
            return;
        }
        Matrix matrix = new Matrix();
        r0.a(matrix, fArr);
        this.f4521a.concat(matrix);
    }

    @Override // androidx.compose.ui.graphics.m1
    public void q(Path path, m4 m4Var) {
        Canvas canvas = this.f4521a;
        if (!(path instanceof u0)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((u0) path).p(), m4Var.w());
    }

    @Override // androidx.compose.ui.graphics.m1
    public void r(long j11, float f11, m4 m4Var) {
        this.f4521a.drawCircle(y.g.m(j11), y.g.n(j11), f11, m4Var.w());
    }

    @Override // androidx.compose.ui.graphics.m1
    public void s(float f11, float f12, float f13, float f14, float f15, float f16, m4 m4Var) {
        this.f4521a.drawRoundRect(f11, f12, f13, f14, f15, f16, m4Var.w());
    }

    public final Canvas v() {
        return this.f4521a;
    }

    public final void w(Canvas canvas) {
        this.f4521a = canvas;
    }

    public final Region.Op x(int i11) {
        return t1.d(i11, t1.f4722a.a()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }
}
