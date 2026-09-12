package com.tn.lib.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.tn.lib.widget.R$style;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class SwitchButton extends View implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private float f41102a;

    /* renamed from: b, reason: collision with root package name */
    private int f41103b;

    /* renamed from: c, reason: collision with root package name */
    private int f41104c;

    /* renamed from: d, reason: collision with root package name */
    private int f41105d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f41106e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f41107f;

    /* renamed from: g, reason: collision with root package name */
    private int f41108g;

    /* renamed from: h, reason: collision with root package name */
    private int f41109h;

    /* renamed from: i, reason: collision with root package name */
    private int f41110i;

    /* renamed from: j, reason: collision with root package name */
    private float f41111j;

    /* renamed from: k, reason: collision with root package name */
    private RectF f41112k;

    /* renamed from: l, reason: collision with root package name */
    private int f41113l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f41114m;

    /* renamed from: n, reason: collision with root package name */
    private float f41115n;

    /* renamed from: o, reason: collision with root package name */
    private State f41116o;

    /* renamed from: p, reason: collision with root package name */
    private d f41117p;

    /* renamed from: q, reason: collision with root package name */
    private int f41118q;

    /* renamed from: r, reason: collision with root package name */
    private int f41119r;

    /* renamed from: s, reason: collision with root package name */
    private int f41120s;

    /* renamed from: t, reason: collision with root package name */
    private int f41121t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f41122u;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum State {
        OPEN,
        CLOSE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwitchButton.this.f41115n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SwitchButton.this.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwitchButton.this.f41103b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SwitchButton.this.f41107f.setColor(SwitchButton.this.f41103b);
            SwitchButton.this.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwitchButton.this.setClickable(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwitchButton.this.setClickable(false);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(SwitchButton switchButton, boolean z10);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41111j = 10.0f;
        this.f41122u = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SwitchView, i11, R$style.def_switch_view);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i12 = 0; i12 < indexCount; i12++) {
            int index = obtainStyledAttributes.getIndex(i12);
            if (index == R$styleable.SwitchView_switch_bg_color) {
                this.f41103b = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_ball_color) {
                this.f41105d = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_checked_bg_color) {
                this.f41104c = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_radius) {
                this.f41111j = obtainStyledAttributes.getInteger(index, 10);
            } else if (index == R$styleable.SwitchView_switch_gradient_start_color) {
                this.f41120s = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_gradient_end_color) {
                this.f41121t = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            }
        }
        obtainStyledAttributes.recycle();
        i();
    }

    private void e(int i11, int i12, int i13, int i14) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i11, i12);
        ofFloat.addUpdateListener(new a());
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i13), Integer.valueOf(i14));
        ofObject.addUpdateListener(new b());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofObject);
        animatorSet.setDuration(50L);
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    private Paint f(int i11, int i12, Paint.Style style, int i13) {
        Paint paint = new Paint(1);
        paint.setColor(i11);
        paint.setStrokeWidth(i13);
        paint.setDither(true);
        paint.setTextSize(i12);
        paint.setStyle(style);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        return paint;
    }

    private void g(Canvas canvas) {
        this.f41106e.setColor(this.f41105d);
        canvas.drawCircle(this.f41115n, this.f41110i, this.f41111j, this.f41106e);
    }

    private void h(Canvas canvas) {
        if (this.f41116o != State.OPEN) {
            RectF rectF = this.f41112k;
            int i11 = this.f41110i;
            canvas.drawRoundRect(rectF, i11, i11, this.f41107f);
        } else {
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, 0.0f, this.f41109h, 0.0f, this.f41120s, this.f41121t, Shader.TileMode.CLAMP));
            RectF rectF2 = this.f41112k;
            int i12 = this.f41110i;
            canvas.drawRoundRect(rectF2, i12, i12, paint);
        }
    }

    private void i() {
        this.f41118q = this.f41103b;
        this.f41119r = this.f41104c;
        int i11 = this.f41105d;
        Paint.Style style = Paint.Style.FILL;
        this.f41106e = f(i11, 0, style, 0);
        this.f41107f = f(this.f41103b, 0, style, 0);
        this.f41116o = State.CLOSE;
        setOnClickListener(this);
        this.f41107f.setColor(this.f41103b);
        this.f41111j = oh.h.f71144a.a(getContext(), this.f41111j);
    }

    public boolean isChecked() {
        return this.f41114m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f41122u) {
            State state = this.f41116o;
            State state2 = State.CLOSE;
            State state3 = state == state2 ? State.OPEN : state2;
            this.f41116o = state3;
            if (state3 == state2) {
                e(this.f41113l, this.f41110i, this.f41119r, this.f41118q);
            } else {
                e(this.f41110i, this.f41113l, this.f41118q, this.f41119r);
            }
            d dVar = this.f41117p;
            if (dVar != null) {
                dVar.a(this, this.f41116o == State.OPEN);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        h(canvas);
        g(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 44.0f, getResources().getDisplayMetrics()), 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i12 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()), 1073741824);
        }
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        this.f41108g = i12;
        this.f41109h = i11;
        this.f41102a = (i11 * 1.0f) / 30.0f;
        int i15 = i12 / 2;
        this.f41110i = i15;
        int i16 = i11 - i15;
        this.f41113l = i16;
        this.f41115n = this.f41114m ? i16 : i15;
        this.f41112k = new RectF(0.0f, 0.0f, this.f41109h, this.f41108g);
    }

    public void setChecked(boolean z10) {
        this.f41114m = z10;
        State state = z10 ? State.OPEN : State.CLOSE;
        if (this.f41116o == state) {
            return;
        }
        this.f41116o = state;
        if (z10 && this.f41113l == 0) {
            this.f41115n = oh.h.f71144a.a(getContext(), 32.0f);
            int i11 = this.f41119r;
            this.f41103b = i11;
            this.f41107f.setColor(i11);
            postInvalidate();
        } else if (state == State.CLOSE) {
            e(this.f41113l, this.f41110i, this.f41119r, this.f41118q);
        } else {
            e(this.f41110i, this.f41113l, this.f41118q, this.f41119r);
        }
        d dVar = this.f41117p;
        if (dVar != null) {
            dVar.a(this, this.f41116o == State.OPEN);
        }
    }

    public void setColor(Integer num, Integer num2, Integer num3) {
        this.f41118q = num.intValue();
        this.f41119r = num2.intValue();
        this.f41105d = num3.intValue();
        this.f41106e.setColor(num3.intValue());
        postInvalidate();
    }

    public void setEnable(boolean z10) {
        this.f41122u = z10;
    }

    public void setGradientColors(int i11, int i12, Integer num) {
        this.f41120s = i11;
        this.f41121t = i12;
        this.f41105d = num.intValue();
        postInvalidate();
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f41117p = dVar;
    }
}
