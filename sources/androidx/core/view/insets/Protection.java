package androidx.core.view.insets;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public abstract class Protection {
    private static final long DEFAULT_DURATION_IN = 333;
    private static final long DEFAULT_DURATION_OUT = 166;
    private final a mAttributes = new a();
    private Object mController;
    private z0.c mInsets;
    private z0.c mInsetsIgnoringVisibility;
    private final int mSide;
    private float mSystemAlpha;
    private float mSystemInsetAmount;
    private float mUserAlpha;
    private ValueAnimator mUserAlphaAnimator;
    private float mUserInsetAmount;
    private ValueAnimator mUserInsetAmountAnimator;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_IN = new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_OUT = new PathInterpolator(0.6f, 0.0f, 1.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_IN = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_OUT = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f8474a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f8475b = -1;

        /* renamed from: c, reason: collision with root package name */
        private z0.c f8476c = z0.c.f79247e;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8477d = false;

        /* renamed from: e, reason: collision with root package name */
        private Drawable f8478e = null;

        /* renamed from: f, reason: collision with root package name */
        private float f8479f = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        private float f8480g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        private float f8481h = 1.0f;

        /* renamed from: i, reason: collision with root package name */
        private InterfaceC0076a f8482i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.core.view.insets.Protection$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0076a {
            void a(int i11);

            void b(z0.c cVar);

            void c(float f11);

            void d(int i11);

            void e(float f11);

            void f(float f11);

            void g(Drawable drawable);

            void onVisibilityChanged(boolean z10);
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A(int i11) {
            if (this.f8474a != i11) {
                this.f8474a = i11;
                InterfaceC0076a interfaceC0076a = this.f8482i;
                if (interfaceC0076a != null) {
                    interfaceC0076a.d(i11);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f11) {
            if (this.f8481h != f11) {
                this.f8481h = f11;
                InterfaceC0076a interfaceC0076a = this.f8482i;
                if (interfaceC0076a != null) {
                    interfaceC0076a.c(f11);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Drawable drawable) {
            this.f8478e = drawable;
            InterfaceC0076a interfaceC0076a = this.f8482i;
            if (interfaceC0076a != null) {
                interfaceC0076a.g(drawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(int i11) {
            if (this.f8475b != i11) {
                this.f8475b = i11;
                InterfaceC0076a interfaceC0076a = this.f8482i;
                if (interfaceC0076a != null) {
                    interfaceC0076a.a(i11);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(z0.c cVar) {
            if (this.f8476c.equals(cVar)) {
                return;
            }
            this.f8476c = cVar;
            InterfaceC0076a interfaceC0076a = this.f8482i;
            if (interfaceC0076a != null) {
                interfaceC0076a.b(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(float f11) {
            if (this.f8479f != f11) {
                this.f8479f = f11;
                InterfaceC0076a interfaceC0076a = this.f8482i;
                if (interfaceC0076a != null) {
                    interfaceC0076a.e(f11);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(float f11) {
            if (this.f8480g != f11) {
                this.f8480g = f11;
                InterfaceC0076a interfaceC0076a = this.f8482i;
                if (interfaceC0076a != null) {
                    interfaceC0076a.f(f11);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(boolean z10) {
            if (this.f8477d != z10) {
                this.f8477d = z10;
                InterfaceC0076a interfaceC0076a = this.f8482i;
                if (interfaceC0076a != null) {
                    interfaceC0076a.onVisibilityChanged(z10);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float k() {
            return this.f8481h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Drawable l() {
            return this.f8478e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int m() {
            return this.f8475b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public z0.c n() {
            return this.f8476c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float o() {
            return this.f8479f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float p() {
            return this.f8480g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int q() {
            return this.f8474a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean r() {
            return this.f8477d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void t(InterfaceC0076a interfaceC0076a) {
            if (this.f8482i != null && interfaceC0076a != null) {
                throw new IllegalStateException("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
            }
            this.f8482i = interfaceC0076a;
        }
    }

    public Protection(int i11) {
        z0.c cVar = z0.c.f79247e;
        this.mInsets = cVar;
        this.mInsetsIgnoringVisibility = cVar;
        this.mSystemAlpha = 1.0f;
        this.mUserAlpha = 1.0f;
        this.mSystemInsetAmount = 1.0f;
        this.mUserInsetAmount = 1.0f;
        this.mController = null;
        this.mUserAlphaAnimator = null;
        this.mUserInsetAmountAnimator = null;
        if (i11 == 1 || i11 == 2 || i11 == 4 || i11 == 8) {
            this.mSide = i11;
            return;
        }
        throw new IllegalArgumentException("Unexpected side: " + i11);
    }

    private void cancelUserAlphaAnimation() {
        ValueAnimator valueAnimator = this.mUserAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserAlphaAnimator = null;
        }
    }

    private void cancelUserInsetsAmountAnimation() {
        ValueAnimator valueAnimator = this.mUserInsetAmountAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserInsetAmountAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateAlpha$0(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateInsetsAmount$1(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void setAlphaInternal(float f11) {
        this.mUserAlpha = f11;
        updateAlpha();
    }

    private void setInsetAmountInternal(float f11) {
        this.mUserInsetAmount = f11;
        updateInsetAmount();
    }

    private void updateAlpha() {
        this.mAttributes.s(this.mSystemAlpha * this.mUserAlpha);
    }

    private void updateInsetAmount() {
        float f11 = this.mUserInsetAmount * this.mSystemInsetAmount;
        int i11 = this.mSide;
        if (i11 == 1) {
            this.mAttributes.x((-(1.0f - f11)) * r1.f8474a);
            return;
        }
        if (i11 == 2) {
            this.mAttributes.y((-(1.0f - f11)) * r1.f8475b);
        } else if (i11 == 4) {
            this.mAttributes.x((1.0f - f11) * r1.f8474a);
        } else {
            if (i11 != 8) {
                return;
            }
            this.mAttributes.y((1.0f - f11) * r1.f8475b);
        }
    }

    public void animateAlpha(float f11) {
        cancelUserAlphaAnimation();
        float f12 = this.mUserAlpha;
        if (f11 == f12) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f12, f11);
        this.mUserAlphaAnimator = ofFloat;
        if (this.mUserAlpha < f11) {
            ofFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_IN);
        } else {
            ofFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_OUT);
        }
        this.mUserAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.insets.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Protection.this.lambda$animateAlpha$0(valueAnimator);
            }
        });
        this.mUserAlphaAnimator.start();
    }

    public void animateInsetsAmount(float f11) {
        cancelUserInsetsAmountAnimation();
        float f12 = this.mUserInsetAmount;
        if (f11 == f12) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f12, f11);
        this.mUserInsetAmountAnimator = ofFloat;
        if (this.mUserInsetAmount < f11) {
            ofFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_IN);
        } else {
            ofFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_OUT);
        }
        this.mUserInsetAmountAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.insets.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Protection.this.lambda$animateInsetsAmount$1(valueAnimator);
            }
        });
        this.mUserInsetAmountAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchColorHint(int i11) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0.c dispatchInsets(z0.c cVar, z0.c cVar2, z0.c cVar3) {
        this.mInsets = cVar;
        this.mInsetsIgnoringVisibility = cVar2;
        this.mAttributes.w(cVar3);
        return updateLayout();
    }

    public float getAlpha() {
        return this.mUserAlpha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a getAttributes() {
        return this.mAttributes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getController() {
        return this.mController;
    }

    public float getInsetAmount() {
        return this.mUserInsetAmount;
    }

    public int getSide() {
        return this.mSide;
    }

    int getThickness(int i11) {
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean occupiesCorners() {
        return false;
    }

    public void setAlpha(float f11) {
        if (f11 >= 0.0f && f11 <= 1.0f) {
            cancelUserAlphaAnimation();
            setAlphaInternal(f11);
        } else {
            throw new IllegalArgumentException("Alpha must in a range of [0, 1]. Got: " + f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setController(Object obj) {
        this.mController = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDrawable(Drawable drawable) {
        this.mAttributes.u(drawable);
    }

    public void setInsetAmount(float f11) {
        if (f11 >= 0.0f && f11 <= 1.0f) {
            cancelUserInsetsAmountAnimation();
            setInsetAmountInternal(f11);
        } else {
            throw new IllegalArgumentException("Inset amount must in a range of [0, 1]. Got: " + f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemAlpha(float f11) {
        this.mSystemAlpha = f11;
        updateAlpha();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemInsetAmount(float f11) {
        this.mSystemInsetAmount = f11;
        updateInsetAmount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemVisible(boolean z10) {
        this.mAttributes.z(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0.c updateLayout() {
        int i11;
        z0.c cVar = z0.c.f79247e;
        int i12 = this.mSide;
        if (i12 == 1) {
            i11 = this.mInsets.f79248a;
            this.mAttributes.A(getThickness(this.mInsetsIgnoringVisibility.f79248a));
            if (occupiesCorners()) {
                cVar = z0.c.c(getThickness(i11), 0, 0, 0);
            }
        } else if (i12 == 2) {
            i11 = this.mInsets.f79249b;
            this.mAttributes.v(getThickness(this.mInsetsIgnoringVisibility.f79249b));
            if (occupiesCorners()) {
                cVar = z0.c.c(0, getThickness(i11), 0, 0);
            }
        } else if (i12 == 4) {
            i11 = this.mInsets.f79250c;
            this.mAttributes.A(getThickness(this.mInsetsIgnoringVisibility.f79250c));
            if (occupiesCorners()) {
                cVar = z0.c.c(0, 0, getThickness(i11), 0);
            }
        } else if (i12 != 8) {
            i11 = 0;
        } else {
            i11 = this.mInsets.f79251d;
            this.mAttributes.v(getThickness(this.mInsetsIgnoringVisibility.f79251d));
            if (occupiesCorners()) {
                cVar = z0.c.c(0, 0, 0, getThickness(i11));
            }
        }
        setSystemVisible(i11 > 0);
        setSystemAlpha(i11 > 0 ? 1.0f : 0.0f);
        setSystemInsetAmount(i11 > 0 ? 1.0f : 0.0f);
        return cVar;
    }
}
