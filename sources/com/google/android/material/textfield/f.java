package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends s {

    /* renamed from: e, reason: collision with root package name */
    private final int f29963e;

    /* renamed from: f, reason: collision with root package name */
    private final int f29964f;

    /* renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f29965g;

    /* renamed from: h, reason: collision with root package name */
    private final TimeInterpolator f29966h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f29967i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnClickListener f29968j;

    /* renamed from: k, reason: collision with root package name */
    private final View.OnFocusChangeListener f29969k;

    /* renamed from: l, reason: collision with root package name */
    private AnimatorSet f29970l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f29971m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f30031b.f0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f30031b.f0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(r rVar) {
        super(rVar);
        this.f29968j = new View.OnClickListener() { // from class: com.google.android.material.textfield.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.G(view);
            }
        };
        this.f29969k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                f.this.H(view, z10);
            }
        };
        this.f29963e = wa.j.f(rVar.getContext(), R$attr.motionDurationShort3, 100);
        this.f29964f = wa.j.f(rVar.getContext(), R$attr.motionDurationShort3, 150);
        this.f29965g = wa.j.g(rVar.getContext(), R$attr.motionEasingLinearInterpolator, oa.a.f71041a);
        this.f29966h = wa.j.g(rVar.getContext(), R$attr.motionEasingEmphasizedInterpolator, oa.a.f71044d);
    }

    private void A(boolean z10) {
        boolean z11 = this.f30031b.I() == z10;
        if (z10 && !this.f29970l.isRunning()) {
            this.f29971m.cancel();
            this.f29970l.start();
            if (z11) {
                this.f29970l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f29970l.cancel();
        this.f29971m.start();
        if (z11) {
            this.f29971m.end();
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f29965g);
        ofFloat.setDuration(this.f29963e);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.E(valueAnimator);
            }
        });
        return ofFloat;
    }

    private ValueAnimator C() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f29966h);
        ofFloat.setDuration(this.f29964f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.F(valueAnimator);
            }
        });
        return ofFloat;
    }

    private void D() {
        ValueAnimator C = C();
        ValueAnimator B = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f29970l = animatorSet;
        animatorSet.playTogether(C, B);
        this.f29970l.addListener(new a());
        ValueAnimator B2 = B(1.0f, 0.0f);
        this.f29971m = B2;
        B2.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f30033d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f30033d.setScaleX(floatValue);
        this.f30033d.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f29967i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z10) {
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    private boolean J() {
        EditText editText = this.f29967i;
        return editText != null && (editText.hasFocus() || this.f30033d.hasFocus()) && this.f29967i.getText().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f30031b.y() != null) {
            return;
        }
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int c() {
        return R$string.clear_text_end_icon_content_description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int d() {
        return R$drawable.mtrl_ic_cancel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f29969k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f29968j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener g() {
        return this.f29969k;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f29967i = editText;
        this.f30030a.setEndIconVisible(J());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void q(boolean z10) {
        if (this.f30031b.y() == null) {
            return;
        }
        A(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void s() {
        D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f29967i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.I();
                }
            });
        }
    }
}
