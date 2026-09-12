package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.h;

/* loaded from: classes4.dex */
final class k extends h {

    /* renamed from: b, reason: collision with root package name */
    private float f29535b;

    /* renamed from: c, reason: collision with root package name */
    private float f29536c;

    /* renamed from: d, reason: collision with root package name */
    private float f29537d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f29538e;

    /* renamed from: f, reason: collision with root package name */
    private float f29539f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(n nVar) {
        super(nVar);
        this.f29535b = 300.0f;
    }

    private void h(Canvas canvas, Paint paint, float f11, float f12, int i11, int i12, int i13) {
        float a11 = d1.a.a(f11, 0.0f, 1.0f);
        float a12 = d1.a.a(f12, 0.0f, 1.0f);
        float d11 = va.a.d(1.0f - this.f29539f, 1.0f, a11);
        float d12 = va.a.d(1.0f - this.f29539f, 1.0f, a12);
        int a13 = (int) ((i12 * d1.a.a(d11, 0.0f, 0.01f)) / 0.01f);
        int a14 = (int) ((i13 * (1.0f - d1.a.a(d12, 0.99f, 1.0f))) / 0.01f);
        float f13 = this.f29535b;
        int i14 = (int) ((d11 * f13) + a13);
        int i15 = (int) ((d12 * f13) - a14);
        float f14 = (-f13) / 2.0f;
        if (i14 <= i15) {
            float f15 = this.f29537d;
            float f16 = i14 + f15;
            float f17 = i15 - f15;
            float f18 = f15 * 2.0f;
            paint.setColor(i11);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.f29536c);
            if (f16 >= f17) {
                j(canvas, paint, new PointF(f16 + f14, 0.0f), new PointF(f17 + f14, 0.0f), f18, this.f29536c);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.f29538e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f19 = f16 + f14;
            float f20 = f17 + f14;
            canvas.drawLine(f19, 0.0f, f20, 0.0f, paint);
            if (this.f29538e || this.f29537d <= 0.0f) {
                return;
            }
            paint.setStyle(Paint.Style.FILL);
            if (f16 > 0.0f) {
                i(canvas, paint, new PointF(f19, 0.0f), f18, this.f29536c);
            }
            if (f17 < this.f29535b) {
                i(canvas, paint, new PointF(f20, 0.0f), f18, this.f29536c);
            }
        }
    }

    private void i(Canvas canvas, Paint paint, PointF pointF, float f11, float f12) {
        j(canvas, paint, pointF, null, f11, f12);
    }

    private void j(Canvas canvas, Paint paint, PointF pointF, PointF pointF2, float f11, float f12) {
        float min = Math.min(f12, this.f29536c);
        float f13 = f11 / 2.0f;
        float min2 = Math.min(f13, (this.f29537d * min) / this.f29536c);
        RectF rectF = new RectF((-f11) / 2.0f, (-min) / 2.0f, f13, min / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, min2, min2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.h
    void a(Canvas canvas, Rect rect, float f11, boolean z10, boolean z11) {
        this.f29535b = rect.width();
        float f12 = ((n) this.f29525a).f29472a;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - f12) / 2.0f));
        if (((n) this.f29525a).f29563j) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f13 = this.f29535b / 2.0f;
        float f14 = f12 / 2.0f;
        canvas.clipRect(-f13, -f14, f13, f14);
        b bVar = this.f29525a;
        this.f29538e = ((n) bVar).f29472a / 2 == ((n) bVar).f29473b;
        this.f29536c = ((n) bVar).f29472a * f11;
        this.f29537d = Math.min(((n) bVar).f29472a / 2, ((n) bVar).f29473b) * f11;
        if (z10 || z11) {
            if ((z10 && ((n) this.f29525a).f29476e == 2) || (z11 && ((n) this.f29525a).f29477f == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z10 || (z11 && ((n) this.f29525a).f29477f != 3)) {
                canvas.translate(0.0f, (((n) this.f29525a).f29472a * (1.0f - f11)) / 2.0f);
            }
        }
        if (z11 && ((n) this.f29525a).f29477f == 3) {
            this.f29539f = f11;
        } else {
            this.f29539f = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void b(Canvas canvas, Paint paint, int i11, int i12) {
        int a11 = com.google.android.material.color.b.a(i11, i12);
        if (((n) this.f29525a).f29564k <= 0 || a11 == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(a11);
        PointF pointF = new PointF((this.f29535b / 2.0f) - (this.f29536c / 2.0f), 0.0f);
        b bVar = this.f29525a;
        i(canvas, paint, pointF, ((n) bVar).f29564k, ((n) bVar).f29564k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void c(Canvas canvas, Paint paint, h.a aVar, int i11) {
        int a11 = com.google.android.material.color.b.a(aVar.f29528c, i11);
        float f11 = aVar.f29526a;
        float f12 = aVar.f29527b;
        int i12 = aVar.f29529d;
        h(canvas, paint, f11, f12, a11, i12, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void d(Canvas canvas, Paint paint, float f11, float f12, int i11, int i12, int i13) {
        h(canvas, paint, f11, f12, com.google.android.material.color.b.a(i11, i12), i13, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public int e() {
        return ((n) this.f29525a).f29472a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public int f() {
        return -1;
    }
}
