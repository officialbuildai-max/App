package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f2114a;

    /* renamed from: b, reason: collision with root package name */
    private h0 f2115b;

    /* renamed from: c, reason: collision with root package name */
    private h0 f2116c;

    /* renamed from: d, reason: collision with root package name */
    private h0 f2117d;

    /* renamed from: e, reason: collision with root package name */
    private int f2118e = 0;

    public j(ImageView imageView) {
        this.f2114a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f2117d == null) {
            this.f2117d = new h0();
        }
        h0 h0Var = this.f2117d;
        h0Var.a();
        ColorStateList a11 = androidx.core.widget.i.a(this.f2114a);
        if (a11 != null) {
            h0Var.f2112d = true;
            h0Var.f2109a = a11;
        }
        PorterDuff.Mode b11 = androidx.core.widget.i.b(this.f2114a);
        if (b11 != null) {
            h0Var.f2111c = true;
            h0Var.f2110b = b11;
        }
        if (!h0Var.f2112d && !h0Var.f2111c) {
            return false;
        }
        f.i(drawable, h0Var, this.f2114a.getDrawableState());
        return true;
    }

    private boolean l() {
        return this.f2115b != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f2114a.getDrawable() != null) {
            this.f2114a.getDrawable().setLevel(this.f2118e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f2114a.getDrawable();
        if (drawable != null) {
            y.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            h0 h0Var = this.f2116c;
            if (h0Var != null) {
                f.i(drawable, h0Var, this.f2114a.getDrawableState());
                return;
            }
            h0 h0Var2 = this.f2115b;
            if (h0Var2 != null) {
                f.i(drawable, h0Var2, this.f2114a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList d() {
        h0 h0Var = this.f2116c;
        if (h0Var != null) {
            return h0Var.f2109a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        h0 h0Var = this.f2116c;
        if (h0Var != null) {
            return h0Var.f2110b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return !(this.f2114a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i11) {
        int n11;
        j0 v11 = j0.v(this.f2114a.getContext(), attributeSet, R$styleable.AppCompatImageView, i11, 0);
        ImageView imageView = this.f2114a;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), R$styleable.AppCompatImageView, attributeSet, v11.r(), i11, 0);
        try {
            Drawable drawable = this.f2114a.getDrawable();
            if (drawable == null && (n11 = v11.n(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = g.a.b(this.f2114a.getContext(), n11)) != null) {
                this.f2114a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                y.b(drawable);
            }
            if (v11.s(R$styleable.AppCompatImageView_tint)) {
                androidx.core.widget.i.c(this.f2114a, v11.c(R$styleable.AppCompatImageView_tint));
            }
            if (v11.s(R$styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.i.d(this.f2114a, y.e(v11.k(R$styleable.AppCompatImageView_tintMode, -1), null));
            }
            v11.x();
        } catch (Throwable th2) {
            v11.x();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Drawable drawable) {
        this.f2118e = drawable.getLevel();
    }

    public void i(int i11) {
        if (i11 != 0) {
            Drawable b11 = g.a.b(this.f2114a.getContext(), i11);
            if (b11 != null) {
                y.b(b11);
            }
            this.f2114a.setImageDrawable(b11);
        } else {
            this.f2114a.setImageDrawable(null);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (this.f2116c == null) {
            this.f2116c = new h0();
        }
        h0 h0Var = this.f2116c;
        h0Var.f2109a = colorStateList;
        h0Var.f2112d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(PorterDuff.Mode mode) {
        if (this.f2116c == null) {
            this.f2116c = new h0();
        }
        h0 h0Var = this.f2116c;
        h0Var.f2110b = mode;
        h0Var.f2111c = true;
        c();
    }
}
