package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class p extends s {

    /* renamed from: s, reason: collision with root package name */
    private static final boolean f29984s = true;

    /* renamed from: e, reason: collision with root package name */
    private final int f29985e;

    /* renamed from: f, reason: collision with root package name */
    private final int f29986f;

    /* renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f29987g;

    /* renamed from: h, reason: collision with root package name */
    private AutoCompleteTextView f29988h;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f29989i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnFocusChangeListener f29990j;

    /* renamed from: k, reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f29991k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f29992l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f29993m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f29994n;

    /* renamed from: o, reason: collision with root package name */
    private long f29995o;

    /* renamed from: p, reason: collision with root package name */
    private AccessibilityManager f29996p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f29997q;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f29998r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.f29998r.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(r rVar) {
        super(rVar);
        this.f29989i = new View.OnClickListener() { // from class: com.google.android.material.textfield.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.this.J(view);
            }
        };
        this.f29990j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                p.this.K(view, z10);
            }
        };
        this.f29991k = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.n
            @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                p.this.L(z10);
            }
        };
        this.f29995o = Long.MAX_VALUE;
        this.f29986f = wa.j.f(rVar.getContext(), R$attr.motionDurationShort3, 67);
        this.f29985e = wa.j.f(rVar.getContext(), R$attr.motionDurationShort3, 50);
        this.f29987g = wa.j.g(rVar.getContext(), R$attr.motionEasingLinearInterpolator, oa.a.f71041a);
    }

    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i11, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f29987g);
        ofFloat.setDuration(i11);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                p.this.I(valueAnimator);
            }
        });
        return ofFloat;
    }

    private void F() {
        this.f29998r = E(this.f29986f, 0.0f, 1.0f);
        ValueAnimator E = E(this.f29985e, 1.0f, 0.0f);
        this.f29997q = E;
        E.addListener(new a());
    }

    private boolean G() {
        long currentTimeMillis = System.currentTimeMillis() - this.f29995o;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean isPopupShowing = this.f29988h.isPopupShowing();
        O(isPopupShowing);
        this.f29993m = isPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f30033d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z10) {
        this.f29992l = z10;
        r();
        if (z10) {
            return;
        }
        O(false);
        this.f29993m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z10) {
        AutoCompleteTextView autoCompleteTextView = this.f29988h;
        if (autoCompleteTextView == null || q.a(autoCompleteTextView)) {
            return;
        }
        ViewCompat.setImportantForAccessibility(this.f30033d, z10 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f29993m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z10) {
        if (this.f29994n != z10) {
            this.f29994n = z10;
            this.f29998r.cancel();
            this.f29997q.start();
        }
    }

    private void P() {
        this.f29988h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean M;
                M = p.this.M(view, motionEvent);
                return M;
            }
        });
        if (f29984s) {
            this.f29988h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.k
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    p.this.N();
                }
            });
        }
        this.f29988h.setThreshold(0);
    }

    private void Q() {
        if (this.f29988h == null) {
            return;
        }
        if (G()) {
            this.f29993m = false;
        }
        if (this.f29993m) {
            this.f29993m = false;
            return;
        }
        if (f29984s) {
            O(!this.f29994n);
        } else {
            this.f29994n = !this.f29994n;
            r();
        }
        if (!this.f29994n) {
            this.f29988h.dismissDropDown();
        } else {
            this.f29988h.requestFocus();
            this.f29988h.showDropDown();
        }
    }

    private void R() {
        this.f29993m = true;
        this.f29995o = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f29996p.isTouchExplorationEnabled() && q.a(this.f29988h) && !this.f30033d.hasFocus()) {
            this.f29988h.dismissDropDown();
        }
        this.f29988h.post(new Runnable() { // from class: com.google.android.material.textfield.o
            @Override // java.lang.Runnable
            public final void run() {
                p.this.H();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int c() {
        return R$string.exposed_dropdown_menu_content_description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int d() {
        return f29984s ? R$drawable.mtrl_dropdown_arrow : R$drawable.mtrl_ic_arrow_drop_down;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f29990j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f29989i;
    }

    @Override // com.google.android.material.textfield.s
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f29991k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean i(int i11) {
        return i11 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean j() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean k() {
        return this.f29992l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return this.f29994n;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f29988h = D(editText);
        P();
        this.f30030a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f29996p.isTouchExplorationEnabled()) {
            ViewCompat.setImportantForAccessibility(this.f30033d, 2);
        }
        this.f30030a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!q.a(this.f29988h)) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.f29996p.isEnabled() || q.a(this.f29988h)) {
            return;
        }
        boolean z10 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f29994n && !this.f29988h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z10) {
            Q();
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void s() {
        F();
        this.f29996p = (AccessibilityManager) this.f30032c.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f29988h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f29984s) {
                this.f29988h.setOnDismissListener(null);
            }
        }
    }
}
