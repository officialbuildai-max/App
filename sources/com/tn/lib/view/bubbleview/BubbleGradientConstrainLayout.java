package com.tn.lib.view.bubbleview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class BubbleGradientConstrainLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f41233a;

    /* renamed from: b, reason: collision with root package name */
    private BubbleDrawable f41234b;

    /* renamed from: c, reason: collision with root package name */
    private float f41235c;

    /* renamed from: d, reason: collision with root package name */
    private int f41236d;

    /* renamed from: e, reason: collision with root package name */
    private float f41237e;

    /* renamed from: f, reason: collision with root package name */
    private float f41238f;

    /* renamed from: g, reason: collision with root package name */
    private float f41239g;

    /* renamed from: h, reason: collision with root package name */
    private float f41240h;

    /* renamed from: i, reason: collision with root package name */
    private float f41241i;

    /* renamed from: j, reason: collision with root package name */
    private float f41242j;

    /* renamed from: k, reason: collision with root package name */
    private BubbleDrawable.ArrowLocation f41243k;

    /* renamed from: l, reason: collision with root package name */
    private BubbleDrawable.GradientDirection f41244l;

    /* renamed from: m, reason: collision with root package name */
    private int f41245m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f41246n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f41247o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f41248p;

    /* renamed from: q, reason: collision with root package name */
    private int f41249q;

    /* renamed from: r, reason: collision with root package name */
    private int f41250r;

    /* renamed from: s, reason: collision with root package name */
    private int f41251s;

    /* renamed from: t, reason: collision with root package name */
    private ObjectAnimator f41252t;

    /* renamed from: u, reason: collision with root package name */
    private ObjectAnimator f41253u;

    /* renamed from: v, reason: collision with root package name */
    private AnimatorSet f41254v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f41255w;

    /* loaded from: classes4.dex */
    class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f41256a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f41257b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f41258c;

        a(float f11, ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            this.f41256a = f11;
            this.f41257b = marginLayoutParams;
            this.f41258c = i11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            BubbleGradientConstrainLayout.this.setX(this.f41256a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f41257b;
            marginLayoutParams.leftMargin = this.f41258c;
            BubbleGradientConstrainLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleGradientConstrainLayout.this.setX(this.f41256a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f41257b;
            marginLayoutParams.leftMargin = this.f41258c;
            BubbleGradientConstrainLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public BubbleGradientConstrainLayout(Context context) {
        super(context);
        this.f41233a = "BubbleGradientLinearLayout";
        l(null);
    }

    public BubbleGradientConstrainLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41233a = "BubbleGradientLinearLayout";
        l(attributeSet);
    }

    private void i() {
        ObjectAnimator objectAnimator = this.f41252t;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f41252t.cancel();
    }

    private static int j(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private float[] k(BubbleDrawable.GradientDirection gradientDirection) {
        return gradientDirection == BubbleDrawable.GradientDirection.getDefault() ? new float[]{0.0f, 0.0f, 0.0f, getHeight()} : new float[]{0.0f, 0.0f, getWidth(), 0.0f};
    }

    private void l(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f41235c = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f41236d = obtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f41237e = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f41238f = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f41239g = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f41195u);
            this.f41241i = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f41196v);
            this.f41240h = obtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f41197w);
            this.f41242j = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f41198x);
            this.f41245m = obtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f41199y);
            this.f41249q = obtainStyledAttributes.getColor(R$styleable.BubbleView_gradientStartColor, BubbleDrawable.b.f41199y);
            this.f41250r = obtainStyledAttributes.getColor(R$styleable.BubbleView_gradientEndColor, BubbleDrawable.b.f41199y);
            this.f41251s = obtainStyledAttributes.getColor(R$styleable.BubbleView_gradientCenterColor, -1);
            this.f41255w = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_isOpenAnimator, false);
            this.f41243k = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f41244l = BubbleDrawable.GradientDirection.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_gradient_orientation, 0));
            this.f41246n = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
            int i11 = this.f41251s;
            if (i11 > 0) {
                this.f41247o = new int[]{this.f41249q, i11, this.f41250r};
            } else {
                this.f41247o = new int[]{this.f41249q, this.f41250r};
            }
        }
    }

    private void m() {
        n(getWidth(), getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i11, int i12) {
        o((int) ((getPaddingLeft() + this.f41235c) - this.f41237e), (int) (((i11 - getPaddingRight()) - this.f41235c) - this.f41237e), (int) ((getPaddingTop() + this.f41235c) - this.f41238f), (int) (((i12 - getPaddingBottom()) - this.f41235c) - this.f41238f));
        setBackgroundDrawable(this.f41234b);
    }

    private void o(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        RectF rectF = new RectF(i11, i13, i12, i14);
        this.f41248p = k(this.f41244l);
        BubbleDrawable.b u11 = new BubbleDrawable.b().B(rectF).t(this.f41243k).z(BubbleDrawable.BubbleType.SHADER).q(this.f41240h).s(this.f41241i).v(this.f41239g).u(this.f41242j);
        float[] fArr = this.f41248p;
        this.f41234b = u11.y(fArr[0], fArr[1], fArr[2], fArr[3], this.f41247o).r(this.f41246n).F(this.f41235c).C(this.f41236d).D(this.f41237e).E(this.f41238f).A();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startTransAnim();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        n(i11, i12);
    }

    public void setLocation(BubbleDrawable.ArrowLocation arrowLocation) {
        this.f41243k = arrowLocation;
        n(getWidth(), getHeight());
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleGradientConstrainLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleGradientConstrainLayout bubbleGradientConstrainLayout = BubbleGradientConstrainLayout.this;
                bubbleGradientConstrainLayout.n(bubbleGradientConstrainLayout.getWidth(), BubbleGradientConstrainLayout.this.getHeight());
            }
        });
    }

    public void setmArrowPosition(float f11) {
        this.f41242j = f11;
        m();
    }

    public void startShowRemindAnim() {
        AnimatorSet animatorSet = this.f41254v;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f41254v = null;
        }
        this.f41254v = new AnimatorSet();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        float x10 = getX();
        int i11 = marginLayoutParams.leftMargin;
        if (this.f41253u == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", x10 - (Math.abs(i11) + j(getContext(), 4.0f)), j(getContext(), 4.0f) + x10, x10 - (Math.abs(marginLayoutParams.leftMargin) + j(getContext(), 4.0f)));
            this.f41253u = ofFloat;
            ofFloat.setDuration(100L);
            this.f41253u.setInterpolator(new LinearInterpolator());
            this.f41253u.setRepeatCount(1);
            this.f41253u.addListener(new a(x10, marginLayoutParams, i11));
        }
        this.f41254v.play(this.f41253u).with(this.f41252t);
        this.f41254v.start();
    }

    public void startTransAnim() {
        if (this.f41255w) {
            if (this.f41252t == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", getY(), getY() - j(getContext(), 6.0f), getY());
                this.f41252t = ofFloat;
                ofFloat.setDuration(2000L);
                this.f41252t.setInterpolator(new LinearInterpolator());
                this.f41252t.setRepeatCount(-1);
            }
            if (this.f41252t.isStarted()) {
                return;
            }
            this.f41252t.start();
        }
    }
}
