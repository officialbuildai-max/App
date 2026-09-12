package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.circularreveal.c;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: j, reason: collision with root package name */
    public static final int f28796j = 2;

    /* renamed from: a, reason: collision with root package name */
    private final a f28797a;

    /* renamed from: b, reason: collision with root package name */
    private final View f28798b;

    /* renamed from: c, reason: collision with root package name */
    private final Path f28799c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f28800d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f28801e;

    /* renamed from: f, reason: collision with root package name */
    private c.e f28802f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f28803g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f28804h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f28805i;

    /* loaded from: classes4.dex */
    public interface a {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f28797a = aVar;
        View view = (View) aVar;
        this.f28798b = view;
        view.setWillNotDraw(false);
        this.f28799c = new Path();
        this.f28800d = new Paint(7);
        Paint paint = new Paint(1);
        this.f28801e = paint;
        paint.setColor(0);
    }

    private void d(Canvas canvas) {
        if (o()) {
            Rect bounds = this.f28803g.getBounds();
            float width = this.f28802f.f28810a - (bounds.width() / 2.0f);
            float height = this.f28802f.f28811b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f28803g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float g(c.e eVar) {
        return va.a.b(eVar.f28810a, eVar.f28811b, 0.0f, 0.0f, this.f28798b.getWidth(), this.f28798b.getHeight());
    }

    private void i() {
        if (f28796j == 1) {
            this.f28799c.rewind();
            c.e eVar = this.f28802f;
            if (eVar != null) {
                this.f28799c.addCircle(eVar.f28810a, eVar.f28811b, eVar.f28812c, Path.Direction.CW);
            }
        }
        this.f28798b.invalidate();
    }

    private boolean n() {
        c.e eVar = this.f28802f;
        boolean z10 = eVar == null || eVar.a();
        return f28796j == 0 ? !z10 && this.f28805i : !z10;
    }

    private boolean o() {
        return (this.f28804h || this.f28803g == null || this.f28802f == null) ? false : true;
    }

    private boolean p() {
        return (this.f28804h || Color.alpha(this.f28801e.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f28796j == 0) {
            this.f28804h = true;
            this.f28805i = false;
            this.f28798b.buildDrawingCache();
            Bitmap drawingCache = this.f28798b.getDrawingCache();
            if (drawingCache == null && this.f28798b.getWidth() != 0 && this.f28798b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f28798b.getWidth(), this.f28798b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f28798b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f28800d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f28804h = false;
            this.f28805i = true;
        }
    }

    public void b() {
        if (f28796j == 0) {
            this.f28805i = false;
            this.f28798b.destroyDrawingCache();
            this.f28800d.setShader(null);
            this.f28798b.invalidate();
        }
    }

    public void c(Canvas canvas) {
        if (n()) {
            int i11 = f28796j;
            if (i11 == 0) {
                c.e eVar = this.f28802f;
                canvas.drawCircle(eVar.f28810a, eVar.f28811b, eVar.f28812c, this.f28800d);
                if (p()) {
                    c.e eVar2 = this.f28802f;
                    canvas.drawCircle(eVar2.f28810a, eVar2.f28811b, eVar2.f28812c, this.f28801e);
                }
            } else if (i11 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.f28799c);
                this.f28797a.actualDraw(canvas);
                if (p()) {
                    canvas.drawRect(0.0f, 0.0f, this.f28798b.getWidth(), this.f28798b.getHeight(), this.f28801e);
                }
                canvas.restoreToCount(save);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i11);
                }
                this.f28797a.actualDraw(canvas);
                if (p()) {
                    canvas.drawRect(0.0f, 0.0f, this.f28798b.getWidth(), this.f28798b.getHeight(), this.f28801e);
                }
            }
        } else {
            this.f28797a.actualDraw(canvas);
            if (p()) {
                canvas.drawRect(0.0f, 0.0f, this.f28798b.getWidth(), this.f28798b.getHeight(), this.f28801e);
            }
        }
        d(canvas);
    }

    public Drawable e() {
        return this.f28803g;
    }

    public int f() {
        return this.f28801e.getColor();
    }

    public c.e h() {
        c.e eVar = this.f28802f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f28812c = g(eVar2);
        }
        return eVar2;
    }

    public boolean j() {
        return this.f28797a.actualIsOpaque() && !n();
    }

    public void k(Drawable drawable) {
        this.f28803g = drawable;
        this.f28798b.invalidate();
    }

    public void l(int i11) {
        this.f28801e.setColor(i11);
        this.f28798b.invalidate();
    }

    public void m(c.e eVar) {
        if (eVar == null) {
            this.f28802f = null;
        } else {
            c.e eVar2 = this.f28802f;
            if (eVar2 == null) {
                this.f28802f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (va.a.c(eVar.f28812c, g(eVar), 1.0E-4f)) {
                this.f28802f.f28812c = Float.MAX_VALUE;
            }
        }
        i();
    }
}
