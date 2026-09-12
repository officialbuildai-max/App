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
import android.widget.LinearLayout;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class BubbleGradientLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f41260a;

    /* renamed from: b, reason: collision with root package name */
    private BubbleDrawable f41261b;

    /* renamed from: c, reason: collision with root package name */
    private float f41262c;

    /* renamed from: d, reason: collision with root package name */
    private int f41263d;

    /* renamed from: e, reason: collision with root package name */
    private float f41264e;

    /* renamed from: f, reason: collision with root package name */
    private float f41265f;

    /* renamed from: g, reason: collision with root package name */
    private float f41266g;

    /* renamed from: h, reason: collision with root package name */
    private float f41267h;

    /* renamed from: i, reason: collision with root package name */
    private float f41268i;

    /* renamed from: j, reason: collision with root package name */
    private float f41269j;

    /* renamed from: k, reason: collision with root package name */
    private BubbleDrawable.ArrowLocation f41270k;

    /* renamed from: l, reason: collision with root package name */
    private BubbleDrawable.GradientDirection f41271l;

    /* renamed from: m, reason: collision with root package name */
    private int f41272m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f41273n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f41274o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f41275p;

    /* renamed from: q, reason: collision with root package name */
    private int f41276q;

    /* renamed from: r, reason: collision with root package name */
    private int f41277r;

    /* renamed from: s, reason: collision with root package name */
    private int f41278s;

    /* renamed from: t, reason: collision with root package name */
    private ObjectAnimator f41279t;

    /* renamed from: u, reason: collision with root package name */
    private ObjectAnimator f41280u;

    /* renamed from: v, reason: collision with root package name */
    private AnimatorSet f41281v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f41282w;

    /* loaded from: classes4.dex */
    class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f41283a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f41284b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f41285c;

        a(float f11, ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            this.f41283a = f11;
            this.f41284b = marginLayoutParams;
            this.f41285c = i11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            BubbleGradientLinearLayout.this.setX(this.f41283a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f41284b;
            marginLayoutParams.leftMargin = this.f41285c;
            BubbleGradientLinearLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleGradientLinearLayout.this.setX(this.f41283a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f41284b;
            marginLayoutParams.leftMargin = this.f41285c;
            BubbleGradientLinearLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f41287a;

        static {
            int[] iArr = new int[BubbleDrawable.GradientDirection.values().length];
            f41287a = iArr;
            try {
                iArr[BubbleDrawable.GradientDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41287a[BubbleDrawable.GradientDirection.TOP_LEFT_BOTTOM_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41287a[BubbleDrawable.GradientDirection.TOP_RIGHT_BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41287a[BubbleDrawable.GradientDirection.BOTTOM_LEFT_TOP_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41287a[BubbleDrawable.GradientDirection.BOTTOM_RIGHT_TOP_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BubbleGradientLinearLayout(Context context) {
        super(context);
        this.f41260a = "BubbleGradientLinearLayout";
        e(null);
    }

    public BubbleGradientLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41260a = "BubbleGradientLinearLayout";
        e(attributeSet);
    }

    private void b() {
        ObjectAnimator objectAnimator = this.f41279t;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f41279t.cancel();
    }

    private static int c(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private float[] d(BubbleDrawable.GradientDirection gradientDirection) {
        int i11 = b.f41287a[gradientDirection.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? new float[]{0.0f, 0.0f, 0.0f, getHeight()} : new float[]{getWidth(), getHeight(), 0.0f, 0.0f} : new float[]{0.0f, getHeight(), getWidth(), 0.0f} : new float[]{getWidth(), 0.0f, 0.0f, getHeight()} : new float[]{0.0f, 0.0f, getWidth(), getHeight()} : new float[]{0.0f, 0.0f, getWidth(), 0.0f};
    }

    private void e(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f41262c = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f41263d = obtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f41264e = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f41265f = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f41266g = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f41195u);
            this.f41268i = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f41196v);
            this.f41267h = obtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f41197w);
            this.f41269j = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f41198x);
            this.f41272m = obtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f41199y);
            this.f41276q = obtainStyledAttributes.getColor(R$styleable.BubbleView_gradientStartColor, BubbleDrawable.b.f41199y);
            this.f41277r = obtainStyledAttributes.getColor(R$styleable.BubbleView_gradientEndColor, BubbleDrawable.b.f41199y);
            this.f41278s = obtainStyledAttributes.getColor(R$styleable.BubbleView_gradientCenterColor, BubbleDrawable.b.f41199y);
            this.f41282w = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_isOpenAnimator, false);
            this.f41270k = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f41271l = BubbleDrawable.GradientDirection.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_gradient_orientation, 0));
            this.f41273n = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
            int i11 = this.f41278s;
            if (i11 != BubbleDrawable.b.f41199y) {
                this.f41274o = new int[]{this.f41276q, i11, this.f41277r};
            } else {
                this.f41274o = new int[]{this.f41276q, this.f41277r};
            }
        }
    }

    private void f() {
        g(getWidth(), getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i11, int i12) {
        h((int) ((getPaddingLeft() + this.f41262c) - this.f41264e), (int) (((i11 - getPaddingRight()) - this.f41262c) - this.f41264e), (int) ((getPaddingTop() + this.f41262c) - this.f41265f), (int) (((i12 - getPaddingBottom()) - this.f41262c) - this.f41265f));
        setBackgroundDrawable(this.f41261b);
    }

    private void h(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        RectF rectF = new RectF(i11, i13, i12, i14);
        this.f41275p = d(this.f41271l);
        BubbleDrawable.b u11 = new BubbleDrawable.b().B(rectF).t(this.f41270k).z(BubbleDrawable.BubbleType.SHADER).q(this.f41267h).s(this.f41268i).v(this.f41266g).u(this.f41269j);
        float[] fArr = this.f41275p;
        this.f41261b = u11.y(fArr[0], fArr[1], fArr[2], fArr[3], this.f41274o).r(this.f41273n).F(this.f41262c).C(this.f41263d).D(this.f41264e).E(this.f41265f).A();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startTransAnim();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        g(i11, i12);
    }

    public void setGradientColors(int i11, int i12, int i13) {
        this.f41276q = i11;
        this.f41277r = i12;
        this.f41278s = i13;
        f();
    }

    public void setLocation(BubbleDrawable.ArrowLocation arrowLocation) {
        this.f41270k = arrowLocation;
        g(getWidth(), getHeight());
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleGradientLinearLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleGradientLinearLayout bubbleGradientLinearLayout = BubbleGradientLinearLayout.this;
                bubbleGradientLinearLayout.g(bubbleGradientLinearLayout.getWidth(), BubbleGradientLinearLayout.this.getHeight());
            }
        });
    }

    public void setmArrowPosition(float f11) {
        this.f41269j = f11;
        f();
    }

    public void startShowRemindAnim() {
        AnimatorSet animatorSet = this.f41281v;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f41281v = null;
        }
        this.f41281v = new AnimatorSet();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        float x10 = getX();
        int i11 = marginLayoutParams.leftMargin;
        if (this.f41280u == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", x10 - (Math.abs(i11) + c(getContext(), 4.0f)), c(getContext(), 4.0f) + x10, x10 - (Math.abs(marginLayoutParams.leftMargin) + c(getContext(), 4.0f)));
            this.f41280u = ofFloat;
            ofFloat.setDuration(100L);
            this.f41280u.setInterpolator(new LinearInterpolator());
            this.f41280u.setRepeatCount(1);
            this.f41280u.addListener(new a(x10, marginLayoutParams, i11));
        }
        this.f41281v.play(this.f41280u).with(this.f41279t);
        this.f41281v.start();
    }

    public void startTransAnim() {
        if (this.f41282w) {
            if (this.f41279t == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", getY(), getY() - c(getContext(), 6.0f), getY());
                this.f41279t = ofFloat;
                ofFloat.setDuration(2000L);
                this.f41279t.setInterpolator(new LinearInterpolator());
                this.f41279t.setRepeatCount(-1);
            }
            if (this.f41279t.isStarted()) {
                return;
            }
            this.f41279t.start();
        }
    }
}
