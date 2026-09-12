package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.h;

/* loaded from: classes4.dex */
final class c extends h {

    /* renamed from: b, reason: collision with root package name */
    private float f29479b;

    /* renamed from: c, reason: collision with root package name */
    private float f29480c;

    /* renamed from: d, reason: collision with root package name */
    private float f29481d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f29482e;

    /* renamed from: f, reason: collision with root package name */
    private float f29483f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar) {
        super(eVar);
    }

    private void h(Canvas canvas, Paint paint, float f11, float f12, int i11, int i12, int i13) {
        float f13 = f12 >= f11 ? f12 - f11 : (f12 + 1.0f) - f11;
        float f14 = f11 % 1.0f;
        if (this.f29483f < 1.0f) {
            float f15 = f14 + f13;
            if (f15 > 1.0f) {
                h(canvas, paint, f14, 1.0f, i11, i12, 0);
                h(canvas, paint, 1.0f, f15, i11, 0, i13);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.f29480c / this.f29481d);
        if (f14 == 0.0f && f13 >= 0.99f) {
            f13 += ((f13 - 0.99f) * ((degrees * 2.0f) / 360.0f)) / 0.01f;
        }
        float d11 = va.a.d(1.0f - this.f29483f, 1.0f, f14);
        float d12 = va.a.d(0.0f, this.f29483f, f13);
        float degrees2 = (float) Math.toDegrees(i12 / this.f29481d);
        float degrees3 = ((d12 * 360.0f) - degrees2) - ((float) Math.toDegrees(i13 / this.f29481d));
        float f16 = (d11 * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i11);
        paint.setStrokeWidth(this.f29479b);
        float f17 = degrees * 2.0f;
        if (degrees3 < f17) {
            float f18 = degrees3 / f17;
            paint.setStyle(Paint.Style.FILL);
            j(canvas, paint, f16 + (degrees * f18), this.f29480c * 2.0f, this.f29479b, f18);
            return;
        }
        float f19 = this.f29481d;
        RectF rectF = new RectF(-f19, -f19, f19, f19);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.f29482e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f20 = f16 + degrees;
        canvas.drawArc(rectF, f20, degrees3 - f17, false, paint);
        if (this.f29482e || this.f29480c <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        i(canvas, paint, f20, this.f29480c * 2.0f, this.f29479b);
        i(canvas, paint, (f16 + degrees3) - degrees, this.f29480c * 2.0f, this.f29479b);
    }

    private void i(Canvas canvas, Paint paint, float f11, float f12, float f13) {
        j(canvas, paint, f11, f12, f13, 1.0f);
    }

    private void j(Canvas canvas, Paint paint, float f11, float f12, float f13, float f14) {
        float min = (int) Math.min(f13, this.f29479b);
        float f15 = f12 / 2.0f;
        float min2 = Math.min(f15, (this.f29480c * min) / this.f29479b);
        RectF rectF = new RectF((-min) / 2.0f, (-f12) / 2.0f, min / 2.0f, f15);
        canvas.save();
        double d11 = f11;
        canvas.translate((float) (this.f29481d * Math.cos(Math.toRadians(d11))), (float) (this.f29481d * Math.sin(Math.toRadians(d11))));
        canvas.rotate(f11);
        canvas.scale(f14, f14);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    private int k() {
        b bVar = this.f29525a;
        return ((e) bVar).f29499h + (((e) bVar).f29500i * 2);
    }

    @Override // com.google.android.material.progressindicator.h
    void a(Canvas canvas, Rect rect, float f11, boolean z10, boolean z11) {
        float width = rect.width() / f();
        float height = rect.height() / e();
        b bVar = this.f29525a;
        float f12 = (((e) bVar).f29499h / 2.0f) + ((e) bVar).f29500i;
        canvas.translate((f12 * width) + rect.left, (f12 * height) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((e) this.f29525a).f29501j != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f13 = -f12;
        canvas.clipRect(f13, f13, f12, f12);
        b bVar2 = this.f29525a;
        this.f29482e = ((e) bVar2).f29472a / 2 <= ((e) bVar2).f29473b;
        this.f29479b = ((e) bVar2).f29472a * f11;
        this.f29480c = Math.min(((e) bVar2).f29472a / 2, ((e) bVar2).f29473b) * f11;
        b bVar3 = this.f29525a;
        float f14 = (((e) bVar3).f29499h - ((e) bVar3).f29472a) / 2.0f;
        this.f29481d = f14;
        if (z10 || z11) {
            if ((z10 && ((e) bVar3).f29476e == 2) || (z11 && ((e) bVar3).f29477f == 1)) {
                this.f29481d = f14 + (((1.0f - f11) * ((e) bVar3).f29472a) / 2.0f);
            } else if ((z10 && ((e) bVar3).f29476e == 1) || (z11 && ((e) bVar3).f29477f == 2)) {
                this.f29481d = f14 - (((1.0f - f11) * ((e) bVar3).f29472a) / 2.0f);
            }
        }
        if (z11 && ((e) bVar3).f29477f == 3) {
            this.f29483f = f11;
        } else {
            this.f29483f = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void b(Canvas canvas, Paint paint, int i11, int i12) {
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
        return k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public int f() {
        return k();
    }
}
