package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.b;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f1179a;

        public C0021a(int i11, int i12) {
            super(i11, i12);
            this.f1179a = 8388627;
        }

        public C0021a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1179a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f1179a = obtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0021a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1179a = 0;
        }

        public C0021a(C0021a c0021a) {
            super((ViewGroup.MarginLayoutParams) c0021a);
            this.f1179a = 0;
            this.f1179a = c0021a.f1179a;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public void i(boolean z10) {
    }

    public abstract int j();

    public Context k() {
        return null;
    }

    public abstract void l();

    public boolean m() {
        return false;
    }

    public void n(Configuration configuration) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
    }

    public boolean p(int i11, KeyEvent keyEvent) {
        return false;
    }

    public boolean q(KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public void s(boolean z10) {
    }

    public void t(boolean z10) {
    }

    public void u(CharSequence charSequence) {
    }

    public androidx.appcompat.view.b v(b.a aVar) {
        return null;
    }
}
