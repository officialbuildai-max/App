package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.h;

/* loaded from: classes4.dex */
public final class f extends g {

    /* renamed from: u, reason: collision with root package name */
    private static final androidx.dynamicanimation.animation.c f29502u = new a("indicatorLevel");

    /* renamed from: p, reason: collision with root package name */
    private h f29503p;

    /* renamed from: q, reason: collision with root package name */
    private final androidx.dynamicanimation.animation.e f29504q;

    /* renamed from: r, reason: collision with root package name */
    private final androidx.dynamicanimation.animation.d f29505r;

    /* renamed from: s, reason: collision with root package name */
    private final h.a f29506s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f29507t;

    /* loaded from: classes4.dex */
    class a extends androidx.dynamicanimation.animation.c {
        a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(f fVar) {
            return fVar.y() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, float f11) {
            fVar.A(f11 / 10000.0f);
        }
    }

    f(Context context, b bVar, h hVar) {
        super(context, bVar);
        this.f29507t = false;
        z(hVar);
        this.f29506s = new h.a();
        androidx.dynamicanimation.animation.e eVar = new androidx.dynamicanimation.animation.e();
        this.f29504q = eVar;
        eVar.d(1.0f);
        eVar.f(50.0f);
        androidx.dynamicanimation.animation.d dVar = new androidx.dynamicanimation.animation.d(this, f29502u);
        this.f29505r = dVar;
        dVar.q(eVar);
        n(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f11) {
        this.f29506s.f29527b = f11;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f v(Context context, e eVar, c cVar) {
        return new f(context, eVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f w(Context context, n nVar, k kVar) {
        return new f(context, nVar, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float y() {
        return this.f29506s.f29527b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(float f11) {
        setLevel((int) (f11 * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f29503p.g(canvas, getBounds(), h(), k(), j());
            this.f29521m.setStyle(Paint.Style.FILL);
            this.f29521m.setAntiAlias(true);
            h.a aVar = this.f29506s;
            b bVar = this.f29510b;
            aVar.f29528c = bVar.f29474c[0];
            int i11 = bVar.f29478g;
            if (i11 > 0) {
                if (!(this.f29503p instanceof k)) {
                    i11 = (int) ((i11 * d1.a.a(y(), 0.0f, 0.01f)) / 0.01f);
                }
                this.f29503p.d(canvas, this.f29521m, y(), 1.0f, this.f29510b.f29475d, getAlpha(), i11);
            } else {
                this.f29503p.d(canvas, this.f29521m, 0.0f, 1.0f, bVar.f29475d, getAlpha(), 0);
            }
            this.f29503p.c(canvas, this.f29521m, this.f29506s, getAlpha());
            this.f29503p.b(canvas, this.f29521m, this.f29510b.f29474c[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f29503p.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f29503p.f();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f29505r.r();
        A(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ void m(androidx.vectordrawable.graphics.drawable.b bVar) {
        super.m(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i11) {
        if (this.f29507t) {
            this.f29505r.r();
            A(i11 / 10000.0f);
            return true;
        }
        this.f29505r.h(y() * 10000.0f);
        this.f29505r.l(i11);
        return true;
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean q(boolean z10, boolean z11, boolean z12) {
        return super.q(z10, z11, z12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public boolean r(boolean z10, boolean z11, boolean z12) {
        boolean r11 = super.r(z10, z11, z12);
        float a11 = this.f29511c.a(this.f29509a.getContentResolver());
        if (a11 == 0.0f) {
            this.f29507t = true;
        } else {
            this.f29507t = false;
            this.f29504q.f(50.0f / a11);
        }
        return r11;
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean s(androidx.vectordrawable.graphics.drawable.b bVar) {
        return super.s(bVar);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i11) {
        super.setAlpha(i11);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h x() {
        return this.f29503p;
    }

    void z(h hVar) {
        this.f29503p = hVar;
    }
}
