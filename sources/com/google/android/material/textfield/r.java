package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
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
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class r extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    final TextInputLayout f30000a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f30001b;

    /* renamed from: c, reason: collision with root package name */
    private final CheckableImageButton f30002c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f30003d;

    /* renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f30004e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnLongClickListener f30005f;

    /* renamed from: g, reason: collision with root package name */
    private final CheckableImageButton f30006g;

    /* renamed from: h, reason: collision with root package name */
    private final d f30007h;

    /* renamed from: i, reason: collision with root package name */
    private int f30008i;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashSet f30009j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f30010k;

    /* renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f30011l;

    /* renamed from: m, reason: collision with root package name */
    private int f30012m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView.ScaleType f30013n;

    /* renamed from: o, reason: collision with root package name */
    private View.OnLongClickListener f30014o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f30015p;

    /* renamed from: q, reason: collision with root package name */
    private final TextView f30016q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f30017r;

    /* renamed from: s, reason: collision with root package name */
    private EditText f30018s;

    /* renamed from: t, reason: collision with root package name */
    private final AccessibilityManager f30019t;

    /* renamed from: u, reason: collision with root package name */
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener f30020u;

    /* renamed from: v, reason: collision with root package name */
    private final TextWatcher f30021v;

    /* renamed from: w, reason: collision with root package name */
    private final TextInputLayout.e f30022w;

    /* loaded from: classes4.dex */
    class a extends com.google.android.material.internal.a0 {
        a() {
        }

        @Override // com.google.android.material.internal.a0, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r.this.o().a(editable);
        }

        @Override // com.google.android.material.internal.a0, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            r.this.o().b(charSequence, i11, i12, i13);
        }
    }

    /* loaded from: classes4.dex */
    class b implements TextInputLayout.e {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e
        public void a(TextInputLayout textInputLayout) {
            if (r.this.f30018s == textInputLayout.getEditText()) {
                return;
            }
            if (r.this.f30018s != null) {
                r.this.f30018s.removeTextChangedListener(r.this.f30021v);
                if (r.this.f30018s.getOnFocusChangeListener() == r.this.o().e()) {
                    r.this.f30018s.setOnFocusChangeListener(null);
                }
            }
            r.this.f30018s = textInputLayout.getEditText();
            if (r.this.f30018s != null) {
                r.this.f30018s.addTextChangedListener(r.this.f30021v);
            }
            r.this.o().n(r.this.f30018s);
            r rVar = r.this;
            rVar.m0(rVar.o());
        }
    }

    /* loaded from: classes4.dex */
    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.h();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray f30026a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        private final r f30027b;

        /* renamed from: c, reason: collision with root package name */
        private final int f30028c;

        /* renamed from: d, reason: collision with root package name */
        private final int f30029d;

        d(r rVar, j0 j0Var) {
            this.f30027b = rVar;
            this.f30028c = j0Var.n(R$styleable.TextInputLayout_endIconDrawable, 0);
            this.f30029d = j0Var.n(R$styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        private s b(int i11) {
            if (i11 == -1) {
                return new g(this.f30027b);
            }
            if (i11 == 0) {
                return new v(this.f30027b);
            }
            if (i11 == 1) {
                return new x(this.f30027b, this.f30029d);
            }
            if (i11 == 2) {
                return new f(this.f30027b);
            }
            if (i11 == 3) {
                return new p(this.f30027b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i11);
        }

        s c(int i11) {
            s sVar = (s) this.f30026a.get(i11);
            if (sVar != null) {
                return sVar;
            }
            s b11 = b(i11);
            this.f30026a.append(i11, b11);
            return b11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TextInputLayout textInputLayout, j0 j0Var) {
        super(textInputLayout.getContext());
        this.f30008i = 0;
        this.f30009j = new LinkedHashSet();
        this.f30021v = new a();
        b bVar = new b();
        this.f30022w = bVar;
        this.f30019t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f30000a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f30001b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton k11 = k(this, from, R$id.text_input_error_icon);
        this.f30002c = k11;
        CheckableImageButton k12 = k(frameLayout, from, R$id.text_input_end_icon);
        this.f30006g = k12;
        this.f30007h = new d(this, j0Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f30016q = appCompatTextView;
        E(j0Var);
        D(j0Var);
        F(j0Var);
        frameLayout.addView(k12);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(k11);
        textInputLayout.addOnEditTextAttachedListener(bVar);
        addOnAttachStateChangeListener(new c());
    }

    private void B0() {
        this.f30001b.setVisibility((this.f30006g.getVisibility() != 0 || J()) ? 8 : 0);
        setVisibility((I() || J() || !((this.f30015p == null || this.f30017r) ? 8 : false)) ? 0 : 8);
    }

    private void C0() {
        this.f30002c.setVisibility(u() != null && this.f30000a.isErrorEnabled() && this.f30000a.X() ? 0 : 8);
        B0();
        D0();
        if (C()) {
            return;
        }
        this.f30000a.i0();
    }

    private void D(j0 j0Var) {
        if (!j0Var.s(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            if (j0Var.s(R$styleable.TextInputLayout_endIconTint)) {
                this.f30010k = xa.c.b(getContext(), j0Var, R$styleable.TextInputLayout_endIconTint);
            }
            if (j0Var.s(R$styleable.TextInputLayout_endIconTintMode)) {
                this.f30011l = com.google.android.material.internal.f0.r(j0Var.k(R$styleable.TextInputLayout_endIconTintMode, -1), null);
            }
        }
        if (j0Var.s(R$styleable.TextInputLayout_endIconMode)) {
            Z(j0Var.k(R$styleable.TextInputLayout_endIconMode, 0));
            if (j0Var.s(R$styleable.TextInputLayout_endIconContentDescription)) {
                V(j0Var.p(R$styleable.TextInputLayout_endIconContentDescription));
            }
            T(j0Var.a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else if (j0Var.s(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            if (j0Var.s(R$styleable.TextInputLayout_passwordToggleTint)) {
                this.f30010k = xa.c.b(getContext(), j0Var, R$styleable.TextInputLayout_passwordToggleTint);
            }
            if (j0Var.s(R$styleable.TextInputLayout_passwordToggleTintMode)) {
                this.f30011l = com.google.android.material.internal.f0.r(j0Var.k(R$styleable.TextInputLayout_passwordToggleTintMode, -1), null);
            }
            Z(j0Var.a(R$styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            V(j0Var.p(R$styleable.TextInputLayout_passwordToggleContentDescription));
        }
        Y(j0Var.f(R$styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        if (j0Var.s(R$styleable.TextInputLayout_endIconScaleType)) {
            c0(t.b(j0Var.k(R$styleable.TextInputLayout_endIconScaleType, -1)));
        }
    }

    private void E(j0 j0Var) {
        if (j0Var.s(R$styleable.TextInputLayout_errorIconTint)) {
            this.f30003d = xa.c.b(getContext(), j0Var, R$styleable.TextInputLayout_errorIconTint);
        }
        if (j0Var.s(R$styleable.TextInputLayout_errorIconTintMode)) {
            this.f30004e = com.google.android.material.internal.f0.r(j0Var.k(R$styleable.TextInputLayout_errorIconTintMode, -1), null);
        }
        if (j0Var.s(R$styleable.TextInputLayout_errorIconDrawable)) {
            h0(j0Var.g(R$styleable.TextInputLayout_errorIconDrawable));
        }
        this.f30002c.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.f30002c, 2);
        this.f30002c.setClickable(false);
        this.f30002c.setPressable(false);
        this.f30002c.setFocusable(false);
    }

    private void E0() {
        int visibility = this.f30016q.getVisibility();
        int i11 = (this.f30015p == null || this.f30017r) ? 8 : 0;
        if (visibility != i11) {
            o().q(i11 == 0);
        }
        B0();
        this.f30016q.setVisibility(i11);
        this.f30000a.i0();
    }

    private void F(j0 j0Var) {
        this.f30016q.setVisibility(8);
        this.f30016q.setId(R$id.textinput_suffix_text);
        this.f30016q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.f30016q, 1);
        v0(j0Var.n(R$styleable.TextInputLayout_suffixTextAppearance, 0));
        if (j0Var.s(R$styleable.TextInputLayout_suffixTextColor)) {
            w0(j0Var.c(R$styleable.TextInputLayout_suffixTextColor));
        }
        u0(j0Var.p(R$styleable.TextInputLayout_suffixText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f30020u;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.f30019t) == null) {
            return;
        }
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f30020u == null || this.f30019t == null || !ViewCompat.isAttachedToWindow(this)) {
            return;
        }
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.f30019t, this.f30020u);
    }

    private CheckableImageButton k(ViewGroup viewGroup, LayoutInflater layoutInflater, int i11) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R$layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i11);
        t.e(checkableImageButton);
        if (xa.c.j(getContext())) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void l(int i11) {
        Iterator it = this.f30009j.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(s sVar) {
        if (this.f30018s == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f30018s.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f30006g.setOnFocusChangeListener(sVar.g());
        }
    }

    private int v(s sVar) {
        int i11 = this.f30007h.f30028c;
        return i11 == 0 ? sVar.d() : i11;
    }

    private void x0(s sVar) {
        sVar.s();
        this.f30020u = sVar.h();
        h();
    }

    private void y0(s sVar) {
        R();
        this.f30020u = null;
        sVar.u();
    }

    private void z0(boolean z10) {
        if (!z10 || p() == null) {
            t.a(this.f30000a, this.f30006g, this.f30010k, this.f30011l);
            return;
        }
        Drawable mutate = a1.a.r(p()).mutate();
        a1.a.n(mutate, this.f30000a.getErrorCurrentTextColors());
        this.f30006g.setImageDrawable(mutate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int A() {
        return ViewCompat.getPaddingEnd(this) + ViewCompat.getPaddingEnd(this.f30016q) + ((I() || J()) ? this.f30006g.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) this.f30006g.getLayoutParams()) : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A0(boolean z10) {
        if (this.f30008i == 1) {
            this.f30006g.performClick();
            if (z10) {
                this.f30006g.jumpDrawablesToCurrentState();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView B() {
        return this.f30016q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.f30008i != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D0() {
        if (this.f30000a.f29905d == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.f30016q, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f30000a.f29905d.getPaddingTop(), (I() || J()) ? 0 : ViewCompat.getPaddingEnd(this.f30000a.f29905d), this.f30000a.f29905d.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.f30006g.isCheckable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H() {
        return C() && this.f30006g.isChecked();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I() {
        return this.f30001b.getVisibility() == 0 && this.f30006g.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J() {
        return this.f30002c.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K() {
        return this.f30008i == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z10) {
        this.f30017r = z10;
        E0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        C0();
        O();
        N();
        if (o().t()) {
            z0(this.f30000a.X());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        t.d(this.f30000a, this.f30006g, this.f30010k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        t.d(this.f30000a, this.f30002c, this.f30003d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(boolean z10) {
        boolean z11;
        boolean isActivated;
        boolean isChecked;
        s o11 = o();
        boolean z12 = true;
        if (!o11.l() || (isChecked = this.f30006g.isChecked()) == o11.m()) {
            z11 = false;
        } else {
            this.f30006g.setChecked(!isChecked);
            z11 = true;
        }
        if (!o11.j() || (isActivated = this.f30006g.isActivated()) == o11.k()) {
            z12 = z11;
        } else {
            S(!isActivated);
        }
        if (z10 || z12) {
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(TextInputLayout.f fVar) {
        this.f30009j.remove(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(boolean z10) {
        this.f30006g.setActivated(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(boolean z10) {
        this.f30006g.setCheckable(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i11) {
        V(i11 != 0 ? getResources().getText(i11) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(CharSequence charSequence) {
        if (n() != charSequence) {
            this.f30006g.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i11) {
        X(i11 != 0 ? g.a.b(getContext(), i11) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(Drawable drawable) {
        this.f30006g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f30000a, this.f30006g, this.f30010k, this.f30011l);
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i11 != this.f30012m) {
            this.f30012m = i11;
            t.g(this.f30006g, i11);
            t.g(this.f30002c, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(int i11) {
        if (this.f30008i == i11) {
            return;
        }
        y0(o());
        int i12 = this.f30008i;
        this.f30008i = i11;
        l(i12);
        f0(i11 != 0);
        s o11 = o();
        W(v(o11));
        U(o11.c());
        T(o11.l());
        if (!o11.i(this.f30000a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f30000a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i11);
        }
        x0(o11);
        a0(o11.f());
        EditText editText = this.f30018s;
        if (editText != null) {
            o11.n(editText);
            m0(o11);
        }
        t.a(this.f30000a, this.f30006g, this.f30010k, this.f30011l);
        P(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(View.OnClickListener onClickListener) {
        t.h(this.f30006g, onClickListener, this.f30014o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(View.OnLongClickListener onLongClickListener) {
        this.f30014o = onLongClickListener;
        t.i(this.f30006g, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(ImageView.ScaleType scaleType) {
        this.f30013n = scaleType;
        t.j(this.f30006g, scaleType);
        t.j(this.f30002c, scaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(ColorStateList colorStateList) {
        if (this.f30010k != colorStateList) {
            this.f30010k = colorStateList;
            t.a(this.f30000a, this.f30006g, colorStateList, this.f30011l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(PorterDuff.Mode mode) {
        if (this.f30011l != mode) {
            this.f30011l = mode;
            t.a(this.f30000a, this.f30006g, this.f30010k, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0(boolean z10) {
        if (I() != z10) {
            this.f30006g.setVisibility(z10 ? 0 : 8);
            B0();
            D0();
            this.f30000a.i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(TextInputLayout.f fVar) {
        this.f30009j.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0(int i11) {
        h0(i11 != 0 ? g.a.b(getContext(), i11) : null);
        O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(Drawable drawable) {
        this.f30002c.setImageDrawable(drawable);
        C0();
        t.a(this.f30000a, this.f30002c, this.f30003d, this.f30004e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.f30006g.performClick();
        this.f30006g.jumpDrawablesToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(View.OnClickListener onClickListener) {
        t.h(this.f30002c, onClickListener, this.f30005f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f30009j.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(View.OnLongClickListener onLongClickListener) {
        this.f30005f = onLongClickListener;
        t.i(this.f30002c, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0(ColorStateList colorStateList) {
        if (this.f30003d != colorStateList) {
            this.f30003d = colorStateList;
            t.a(this.f30000a, this.f30002c, colorStateList, this.f30004e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0(PorterDuff.Mode mode) {
        if (this.f30004e != mode) {
            this.f30004e = mode;
            t.a(this.f30000a, this.f30002c, this.f30003d, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton m() {
        if (J()) {
            return this.f30002c;
        }
        if (C() && I()) {
            return this.f30006g;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence n() {
        return this.f30006g.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0(int i11) {
        o0(i11 != 0 ? getResources().getText(i11) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s o() {
        return this.f30007h.c(this.f30008i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(CharSequence charSequence) {
        this.f30006g.setContentDescription(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable p() {
        return this.f30006g.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0(int i11) {
        q0(i11 != 0 ? g.a.b(getContext(), i11) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f30012m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0(Drawable drawable) {
        this.f30006g.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.f30008i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r0(boolean z10) {
        if (z10 && this.f30008i != 1) {
            Z(1);
        } else {
            if (z10) {
                return;
            }
            Z(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView.ScaleType s() {
        return this.f30013n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s0(ColorStateList colorStateList) {
        this.f30010k = colorStateList;
        t.a(this.f30000a, this.f30006g, colorStateList, this.f30011l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton t() {
        return this.f30006g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0(PorterDuff.Mode mode) {
        this.f30011l = mode;
        t.a(this.f30000a, this.f30006g, this.f30010k, mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable u() {
        return this.f30002c.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0(CharSequence charSequence) {
        this.f30015p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f30016q.setText(charSequence);
        E0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v0(int i11) {
        androidx.core.widget.m.q(this.f30016q, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence w() {
        return this.f30006g.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w0(ColorStateList colorStateList) {
        this.f30016q.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable x() {
        return this.f30006g.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence y() {
        return this.f30015p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList z() {
        return this.f30016q.getTextColors();
    }
}
