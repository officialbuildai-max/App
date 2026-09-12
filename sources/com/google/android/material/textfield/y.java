package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.j0;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class y extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final TextInputLayout f30070a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f30071b;

    /* renamed from: c, reason: collision with root package name */
    private CharSequence f30072c;

    /* renamed from: d, reason: collision with root package name */
    private final CheckableImageButton f30073d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f30074e;

    /* renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f30075f;

    /* renamed from: g, reason: collision with root package name */
    private int f30076g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView.ScaleType f30077h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnLongClickListener f30078i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30079j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TextInputLayout textInputLayout, j0 j0Var) {
        super(textInputLayout.getContext());
        this.f30070a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f30073d = checkableImageButton;
        t.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f30071b = appCompatTextView;
        j(j0Var);
        i(j0Var);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void D() {
        int i11 = (this.f30072c == null || this.f30079j) ? 8 : 0;
        setVisibility((this.f30073d.getVisibility() == 0 || i11 == 0) ? 0 : 8);
        this.f30071b.setVisibility(i11);
        this.f30070a.i0();
    }

    private void i(j0 j0Var) {
        this.f30071b.setVisibility(8);
        this.f30071b.setId(R$id.textinput_prefix_text);
        this.f30071b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f30071b, 1);
        p(j0Var.n(R$styleable.TextInputLayout_prefixTextAppearance, 0));
        if (j0Var.s(R$styleable.TextInputLayout_prefixTextColor)) {
            q(j0Var.c(R$styleable.TextInputLayout_prefixTextColor));
        }
        o(j0Var.p(R$styleable.TextInputLayout_prefixText));
    }

    private void j(j0 j0Var) {
        if (xa.c.j(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f30073d.getLayoutParams(), 0);
        }
        v(null);
        w(null);
        if (j0Var.s(R$styleable.TextInputLayout_startIconTint)) {
            this.f30074e = xa.c.b(getContext(), j0Var, R$styleable.TextInputLayout_startIconTint);
        }
        if (j0Var.s(R$styleable.TextInputLayout_startIconTintMode)) {
            this.f30075f = com.google.android.material.internal.f0.r(j0Var.k(R$styleable.TextInputLayout_startIconTintMode, -1), null);
        }
        if (j0Var.s(R$styleable.TextInputLayout_startIconDrawable)) {
            t(j0Var.g(R$styleable.TextInputLayout_startIconDrawable));
            if (j0Var.s(R$styleable.TextInputLayout_startIconContentDescription)) {
                s(j0Var.p(R$styleable.TextInputLayout_startIconContentDescription));
            }
            r(j0Var.a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        u(j0Var.f(R$styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        if (j0Var.s(R$styleable.TextInputLayout_startIconScaleType)) {
            x(t.b(j0Var.k(R$styleable.TextInputLayout_startIconScaleType, -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(boolean z10) {
        if (l() != z10) {
            this.f30073d.setVisibility(z10 ? 0 : 8);
            C();
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f30071b.getVisibility() != 0) {
            accessibilityNodeInfoCompat.setTraversalAfter(this.f30073d);
        } else {
            accessibilityNodeInfoCompat.setLabelFor(this.f30071b);
            accessibilityNodeInfoCompat.setTraversalAfter(this.f30071b);
        }
    }

    void C() {
        EditText editText = this.f30070a.f29905d;
        if (editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.f30071b, l() ? 0 : ViewCompat.getPaddingStart(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a() {
        return this.f30072c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f30071b.getTextColors();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return ViewCompat.getPaddingStart(this) + ViewCompat.getPaddingStart(this.f30071b) + (l() ? this.f30073d.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) this.f30073d.getLayoutParams()) : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView d() {
        return this.f30071b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence e() {
        return this.f30073d.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable f() {
        return this.f30073d.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f30076g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView.ScaleType h() {
        return this.f30077h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f30073d.isCheckable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f30073d.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z10) {
        this.f30079j = z10;
        D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        t.d(this.f30070a, this.f30073d, this.f30074e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(CharSequence charSequence) {
        this.f30072c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f30071b.setText(charSequence);
        D();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i11) {
        androidx.core.widget.m.q(this.f30071b, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(ColorStateList colorStateList) {
        this.f30071b.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z10) {
        this.f30073d.setCheckable(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f30073d.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Drawable drawable) {
        this.f30073d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f30070a, this.f30073d, this.f30074e, this.f30075f);
            A(true);
            n();
        } else {
            A(false);
            v(null);
            w(null);
            s(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i11 != this.f30076g) {
            this.f30076g = i11;
            t.g(this.f30073d, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(View.OnClickListener onClickListener) {
        t.h(this.f30073d, onClickListener, this.f30078i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(View.OnLongClickListener onLongClickListener) {
        this.f30078i = onLongClickListener;
        t.i(this.f30073d, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ImageView.ScaleType scaleType) {
        this.f30077h = scaleType;
        t.j(this.f30073d, scaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        if (this.f30074e != colorStateList) {
            this.f30074e = colorStateList;
            t.a(this.f30070a, this.f30073d, colorStateList, this.f30075f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(PorterDuff.Mode mode) {
        if (this.f30075f != mode) {
            this.f30075f = mode;
            t.a(this.f30070a, this.f30073d, this.f30074e, mode);
        }
    }
}
