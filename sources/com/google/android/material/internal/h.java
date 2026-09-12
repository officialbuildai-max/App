package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public class h extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f29275a;

    /* renamed from: b, reason: collision with root package name */
    private final Drawable f29276b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f29277c;

    /* renamed from: d, reason: collision with root package name */
    private float f29278d;

    public h(Drawable drawable, Drawable drawable2) {
        this.f29275a = drawable.getConstantState().newDrawable().mutate();
        Drawable mutate = drawable2.getConstantState().newDrawable().mutate();
        this.f29276b = mutate;
        mutate.setAlpha(0);
        this.f29277c = new float[2];
    }

    public void a(float f11) {
        if (this.f29278d != f11) {
            this.f29278d = f11;
            j.a(f11, this.f29277c);
            this.f29275a.setAlpha((int) (this.f29277c[0] * 255.0f));
            this.f29276b.setAlpha((int) (this.f29277c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f29275a.draw(canvas);
        this.f29276b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f29275a.getIntrinsicHeight(), this.f29276b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f29275a.getIntrinsicWidth(), this.f29276b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f29275a.getMinimumHeight(), this.f29276b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f29275a.getMinimumWidth(), this.f29276b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f29275a.isStateful() || this.f29276b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        if (this.f29278d <= 0.5f) {
            this.f29275a.setAlpha(i11);
            this.f29276b.setAlpha(0);
        } else {
            this.f29275a.setAlpha(0);
            this.f29276b.setAlpha(i11);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i11, int i12, int i13, int i14) {
        super.setBounds(i11, i12, i13, i14);
        this.f29275a.setBounds(i11, i12, i13, i14);
        this.f29276b.setBounds(i11, i12, i13, i14);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f29275a.setColorFilter(colorFilter);
        this.f29276b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f29275a.setState(iArr) || this.f29276b.setState(iArr);
    }
}
