package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class n extends l {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f2130d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f2131e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f2132f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f2133g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2134h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2135i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SeekBar seekBar) {
        super(seekBar);
        this.f2132f = null;
        this.f2133g = null;
        this.f2134h = false;
        this.f2135i = false;
        this.f2130d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f2131e;
        if (drawable != null) {
            if (this.f2134h || this.f2135i) {
                Drawable r11 = a1.a.r(drawable.mutate());
                this.f2131e = r11;
                if (this.f2134h) {
                    a1.a.o(r11, this.f2132f);
                }
                if (this.f2135i) {
                    a1.a.p(this.f2131e, this.f2133g);
                }
                if (this.f2131e.isStateful()) {
                    this.f2131e.setState(this.f2130d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.l
    public void c(AttributeSet attributeSet, int i11) {
        super.c(attributeSet, i11);
        j0 v11 = j0.v(this.f2130d.getContext(), attributeSet, R$styleable.AppCompatSeekBar, i11, 0);
        SeekBar seekBar = this.f2130d;
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), R$styleable.AppCompatSeekBar, attributeSet, v11.r(), i11, 0);
        Drawable h11 = v11.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h11 != null) {
            this.f2130d.setThumb(h11);
        }
        j(v11.g(R$styleable.AppCompatSeekBar_tickMark));
        if (v11.s(R$styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f2133g = y.e(v11.k(R$styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f2133g);
            this.f2135i = true;
        }
        if (v11.s(R$styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f2132f = v11.c(R$styleable.AppCompatSeekBar_tickMarkTint);
            this.f2134h = true;
        }
        v11.x();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f2131e != null) {
            int max = this.f2130d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2131e.getIntrinsicWidth();
                int intrinsicHeight = this.f2131e.getIntrinsicHeight();
                int i11 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i12 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f2131e.setBounds(-i11, -i12, i11, i12);
                float width = ((this.f2130d.getWidth() - this.f2130d.getPaddingLeft()) - this.f2130d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f2130d.getPaddingLeft(), this.f2130d.getHeight() / 2);
                for (int i13 = 0; i13 <= max; i13++) {
                    this.f2131e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f2131e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2130d.getDrawableState())) {
            this.f2130d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f2131e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f2131e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2131e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2130d);
            a1.a.m(drawable, this.f2130d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f2130d.getDrawableState());
            }
            f();
        }
        this.f2130d.invalidate();
    }
}
