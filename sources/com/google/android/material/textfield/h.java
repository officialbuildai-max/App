package com.google.android.material.textfield;

import ab.i;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: classes4.dex */
abstract class h extends ab.i {

    /* renamed from: z, reason: collision with root package name */
    b f29975z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b extends i.c {

        /* renamed from: w, reason: collision with root package name */
        private final RectF f29976w;

        private b(ab.n nVar, RectF rectF) {
            super(nVar, null);
            this.f29976w = rectF;
        }

        private b(b bVar) {
            super(bVar);
            this.f29976w = bVar.f29976w;
        }

        @Override // ab.i.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h u02 = h.u0(this);
            u02.invalidateSelf();
            return u02;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends h {
        c(b bVar) {
            super(bVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ab.i
        public void t(Canvas canvas) {
            if (this.f29975z.f29976w.isEmpty()) {
                super.t(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.f29975z.f29976w);
            } else {
                canvas.clipRect(this.f29975z.f29976w, Region.Op.DIFFERENCE);
            }
            super.t(canvas);
            canvas.restore();
        }
    }

    private h(b bVar) {
        super(bVar);
        this.f29975z = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h t0(ab.n nVar) {
        if (nVar == null) {
            nVar = new ab.n();
        }
        return u0(new b(nVar, new RectF()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h u0(b bVar) {
        return new c(bVar);
    }

    @Override // ab.i, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f29975z = new b(this.f29975z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v0() {
        return !this.f29975z.f29976w.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w0() {
        x0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void x0(float f11, float f12, float f13, float f14) {
        if (f11 == this.f29975z.f29976w.left && f12 == this.f29975z.f29976w.top && f13 == this.f29975z.f29976w.right && f14 == this.f29975z.f29976w.bottom) {
            return;
        }
        this.f29975z.f29976w.set(f11, f12, f13, f14);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y0(RectF rectF) {
        x0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
