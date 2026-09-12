package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class u {
    private ColorStateList A;
    private Typeface B;

    /* renamed from: a, reason: collision with root package name */
    private final int f30034a;

    /* renamed from: b, reason: collision with root package name */
    private final int f30035b;

    /* renamed from: c, reason: collision with root package name */
    private final int f30036c;

    /* renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f30037d;

    /* renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f30038e;

    /* renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f30039f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f30040g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout f30041h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f30042i;

    /* renamed from: j, reason: collision with root package name */
    private int f30043j;

    /* renamed from: k, reason: collision with root package name */
    private FrameLayout f30044k;

    /* renamed from: l, reason: collision with root package name */
    private Animator f30045l;

    /* renamed from: m, reason: collision with root package name */
    private final float f30046m;

    /* renamed from: n, reason: collision with root package name */
    private int f30047n;

    /* renamed from: o, reason: collision with root package name */
    private int f30048o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f30049p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f30050q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f30051r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f30052s;

    /* renamed from: t, reason: collision with root package name */
    private int f30053t;

    /* renamed from: u, reason: collision with root package name */
    private int f30054u;

    /* renamed from: v, reason: collision with root package name */
    private ColorStateList f30055v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f30056w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f30057x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f30058y;

    /* renamed from: z, reason: collision with root package name */
    private int f30059z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f30060a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f30061b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f30062c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f30063d;

        a(int i11, TextView textView, int i12, TextView textView2) {
            this.f30060a = i11;
            this.f30061b = textView;
            this.f30062c = i12;
            this.f30063d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.f30047n = this.f30060a;
            u.this.f30045l = null;
            TextView textView = this.f30061b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f30062c == 1 && u.this.f30051r != null) {
                    u.this.f30051r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f30063d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f30063d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f30063d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f30063d.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = u.this.f30041h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public u(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f30040g = context;
        this.f30041h = textInputLayout;
        this.f30046m = context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
        this.f30034a = wa.j.f(context, R$attr.motionDurationShort4, Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE);
        this.f30035b = wa.j.f(context, R$attr.motionDurationMedium4, 167);
        this.f30036c = wa.j.f(context, R$attr.motionDurationShort4, 167);
        this.f30037d = wa.j.g(context, R$attr.motionEasingEmphasizedDecelerateInterpolator, oa.a.f71044d);
        int i11 = R$attr.motionEasingEmphasizedDecelerateInterpolator;
        TimeInterpolator timeInterpolator = oa.a.f71041a;
        this.f30038e = wa.j.g(context, i11, timeInterpolator);
        this.f30039f = wa.j.g(context, R$attr.motionEasingLinearInterpolator, timeInterpolator);
    }

    private void D(int i11, int i12) {
        TextView m11;
        TextView m12;
        if (i11 == i12) {
            return;
        }
        if (i12 != 0 && (m12 = m(i12)) != null) {
            m12.setVisibility(0);
            m12.setAlpha(1.0f);
        }
        if (i11 != 0 && (m11 = m(i11)) != null) {
            m11.setVisibility(4);
            if (i11 == 1) {
                m11.setText((CharSequence) null);
            }
        }
        this.f30047n = i12;
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(ViewGroup viewGroup, int i11) {
        if (i11 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f30041h) && this.f30041h.isEnabled() && !(this.f30048o == this.f30047n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void S(int i11, int i12, boolean z10) {
        if (i11 == i12) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f30045l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f30057x, this.f30058y, 2, i11, i12);
            i(arrayList, this.f30050q, this.f30051r, 1, i11, i12);
            oa.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i12, m(i11), i11, m(i12)));
            animatorSet.start();
        } else {
            D(i11, i12);
        }
        this.f30041h.j0();
        this.f30041h.o0(z10);
        this.f30041h.u0();
    }

    private boolean g() {
        return (this.f30042i == null || this.f30041h.getEditText() == null) ? false : true;
    }

    private void i(List list, boolean z10, TextView textView, int i11, int i12, int i13) {
        if (textView == null || !z10) {
            return;
        }
        if (i11 == i13 || i11 == i12) {
            ObjectAnimator j11 = j(textView, i13 == i11);
            if (i11 == i13 && i12 != 0) {
                j11.setStartDelay(this.f30036c);
            }
            list.add(j11);
            if (i13 != i11 || i12 == 0) {
                return;
            }
            ObjectAnimator k11 = k(textView);
            k11.setStartDelay(this.f30036c);
            list.add(k11);
        }
    }

    private ObjectAnimator j(TextView textView, boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
        ofFloat.setDuration(z10 ? this.f30035b : this.f30036c);
        ofFloat.setInterpolator(z10 ? this.f30038e : this.f30039f);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f30046m, 0.0f);
        ofFloat.setDuration(this.f30034a);
        ofFloat.setInterpolator(this.f30037d);
        return ofFloat;
    }

    private TextView m(int i11) {
        if (i11 == 1) {
            return this.f30051r;
        }
        if (i11 != 2) {
            return null;
        }
        return this.f30058y;
    }

    private int v(boolean z10, int i11, int i12) {
        return z10 ? this.f30040g.getResources().getDimensionPixelSize(i11) : i12;
    }

    private boolean y(int i11) {
        return (i11 != 1 || this.f30051r == null || TextUtils.isEmpty(this.f30049p)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f30050q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f30057x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(TextView textView, int i11) {
        FrameLayout frameLayout;
        if (this.f30042i == null) {
            return;
        }
        if (!z(i11) || (frameLayout = this.f30044k) == null) {
            this.f30042i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i12 = this.f30043j - 1;
        this.f30043j = i12;
        O(this.f30042i, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i11) {
        this.f30053t = i11;
        TextView textView = this.f30051r;
        if (textView != null) {
            ViewCompat.setAccessibilityLiveRegion(textView, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(CharSequence charSequence) {
        this.f30052s = charSequence;
        TextView textView = this.f30051r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z10) {
        if (this.f30050q == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f30040g);
            this.f30051r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            this.f30051r.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f30051r.setTypeface(typeface);
            }
            H(this.f30054u);
            I(this.f30055v);
            F(this.f30052s);
            E(this.f30053t);
            this.f30051r.setVisibility(4);
            e(this.f30051r, 0);
        } else {
            w();
            C(this.f30051r, 0);
            this.f30051r = null;
            this.f30041h.j0();
            this.f30041h.u0();
        }
        this.f30050q = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i11) {
        this.f30054u = i11;
        TextView textView = this.f30051r;
        if (textView != null) {
            this.f30041h.W(textView, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(ColorStateList colorStateList) {
        this.f30055v = colorStateList;
        TextView textView = this.f30051r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i11) {
        this.f30059z = i11;
        TextView textView = this.f30058y;
        if (textView != null) {
            androidx.core.widget.m.q(textView, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(boolean z10) {
        if (this.f30057x == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f30040g);
            this.f30058y = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            this.f30058y.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f30058y.setTypeface(typeface);
            }
            this.f30058y.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f30058y, 1);
            J(this.f30059z);
            L(this.A);
            e(this.f30058y, 1);
            this.f30058y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f30058y, 1);
            this.f30058y = null;
            this.f30041h.j0();
            this.f30041h.u0();
        }
        this.f30057x = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f30058y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.f30051r, typeface);
            M(this.f30058y, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(CharSequence charSequence) {
        h();
        this.f30049p = charSequence;
        this.f30051r.setText(charSequence);
        int i11 = this.f30047n;
        if (i11 != 1) {
            this.f30048o = 1;
        }
        S(i11, this.f30048o, P(this.f30051r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(CharSequence charSequence) {
        h();
        this.f30056w = charSequence;
        this.f30058y.setText(charSequence);
        int i11 = this.f30047n;
        if (i11 != 2) {
            this.f30048o = 2;
        }
        S(i11, this.f30048o, P(this.f30058y, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(TextView textView, int i11) {
        if (this.f30042i == null && this.f30044k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f30040g);
            this.f30042i = linearLayout;
            linearLayout.setOrientation(0);
            this.f30041h.addView(this.f30042i, -1, -2);
            this.f30044k = new FrameLayout(this.f30040g);
            this.f30042i.addView(this.f30044k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f30041h.getEditText() != null) {
                f();
            }
        }
        if (z(i11)) {
            this.f30044k.setVisibility(0);
            this.f30044k.addView(textView);
        } else {
            this.f30042i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f30042i.setVisibility(0);
        this.f30043j++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText editText = this.f30041h.getEditText();
            boolean j11 = xa.c.j(this.f30040g);
            ViewCompat.setPaddingRelative(this.f30042i, v(j11, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(editText)), v(j11, R$dimen.material_helper_text_font_1_3_padding_top, this.f30040g.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), v(j11, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    void h() {
        Animator animator = this.f30045l;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return y(this.f30048o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f30053t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f30052s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f30049p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.f30051r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList r() {
        TextView textView = this.f30051r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence s() {
        return this.f30056w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View t() {
        return this.f30058y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u() {
        TextView textView = this.f30058y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f30049p = null;
        h();
        if (this.f30047n == 1) {
            if (!this.f30057x || TextUtils.isEmpty(this.f30056w)) {
                this.f30048o = 0;
            } else {
                this.f30048o = 2;
            }
        }
        S(this.f30047n, this.f30048o, P(this.f30051r, ""));
    }

    void x() {
        h();
        int i11 = this.f30047n;
        if (i11 == 2) {
            this.f30048o = 0;
        }
        S(i11, this.f30048o, P(this.f30058y, ""));
    }

    boolean z(int i11) {
        return i11 == 0 || i11 == 1;
    }
}
