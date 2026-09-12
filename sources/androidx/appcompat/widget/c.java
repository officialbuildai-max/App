package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final View f2036a;

    /* renamed from: d, reason: collision with root package name */
    private h0 f2039d;

    /* renamed from: e, reason: collision with root package name */
    private h0 f2040e;

    /* renamed from: f, reason: collision with root package name */
    private h0 f2041f;

    /* renamed from: c, reason: collision with root package name */
    private int f2038c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final f f2037b = f.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(View view) {
        this.f2036a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f2041f == null) {
            this.f2041f = new h0();
        }
        h0 h0Var = this.f2041f;
        h0Var.a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f2036a);
        if (backgroundTintList != null) {
            h0Var.f2112d = true;
            h0Var.f2109a = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f2036a);
        if (backgroundTintMode != null) {
            h0Var.f2111c = true;
            h0Var.f2110b = backgroundTintMode;
        }
        if (!h0Var.f2112d && !h0Var.f2111c) {
            return false;
        }
        f.i(drawable, h0Var, this.f2036a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f2039d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f2036a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            h0 h0Var = this.f2040e;
            if (h0Var != null) {
                f.i(background, h0Var, this.f2036a.getDrawableState());
                return;
            }
            h0 h0Var2 = this.f2039d;
            if (h0Var2 != null) {
                f.i(background, h0Var2, this.f2036a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        h0 h0Var = this.f2040e;
        if (h0Var != null) {
            return h0Var.f2109a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        h0 h0Var = this.f2040e;
        if (h0Var != null) {
            return h0Var.f2110b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i11) {
        j0 v11 = j0.v(this.f2036a.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i11, 0);
        View view = this.f2036a;
        ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), R$styleable.ViewBackgroundHelper, attributeSet, v11.r(), i11, 0);
        try {
            if (v11.s(R$styleable.ViewBackgroundHelper_android_background)) {
                this.f2038c = v11.n(R$styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList f11 = this.f2037b.f(this.f2036a.getContext(), this.f2038c);
                if (f11 != null) {
                    h(f11);
                }
            }
            if (v11.s(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f2036a, v11.c(R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (v11.s(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f2036a, y.e(v11.k(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            v11.x();
        } catch (Throwable th2) {
            v11.x();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f2038c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i11) {
        this.f2038c = i11;
        f fVar = this.f2037b;
        h(fVar != null ? fVar.f(this.f2036a.getContext(), i11) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2039d == null) {
                this.f2039d = new h0();
            }
            h0 h0Var = this.f2039d;
            h0Var.f2109a = colorStateList;
            h0Var.f2112d = true;
        } else {
            this.f2039d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f2040e == null) {
            this.f2040e = new h0();
        }
        h0 h0Var = this.f2040e;
        h0Var.f2109a = colorStateList;
        h0Var.f2112d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f2040e == null) {
            this.f2040e = new h0();
        }
        h0 h0Var = this.f2040e;
        h0Var.f2110b = mode;
        h0Var.f2111c = true;
        b();
    }
}
