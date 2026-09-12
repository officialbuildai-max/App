package com.warkiz.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.same.report.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* loaded from: classes7.dex */
public class IndicatorSeekBar extends View {
    private float[] A;
    private int A0;
    private boolean B;
    private Drawable B0;
    private boolean C;
    private Bitmap C0;
    private boolean D;
    private int D0;
    private int E;
    private boolean E0;
    private String[] F;
    private float F0;
    private float[] G;
    private int G0;
    private float[] H;
    private boolean H0;
    private float I;
    private boolean I0;
    private int J;
    private Typeface K;
    private int L;
    private int M;
    private int N;
    private CharSequence[] O;
    private d P;
    private int Q;
    private int R;
    private boolean S;
    private int T;
    private View U;
    private View V;
    private int W;

    /* renamed from: a, reason: collision with root package name */
    private Context f60823a;

    /* renamed from: a0, reason: collision with root package name */
    private String f60824a0;

    /* renamed from: b, reason: collision with root package name */
    private Paint f60825b;

    /* renamed from: b0, reason: collision with root package name */
    private float[] f60826b0;

    /* renamed from: c, reason: collision with root package name */
    private TextPaint f60827c;

    /* renamed from: c0, reason: collision with root package name */
    private int f60828c0;

    /* renamed from: d, reason: collision with root package name */
    private e f60829d;

    /* renamed from: d0, reason: collision with root package name */
    private int f60830d0;

    /* renamed from: e, reason: collision with root package name */
    private Rect f60831e;

    /* renamed from: e0, reason: collision with root package name */
    private int f60832e0;

    /* renamed from: f, reason: collision with root package name */
    private float f60833f;

    /* renamed from: f0, reason: collision with root package name */
    private float f60834f0;

    /* renamed from: g, reason: collision with root package name */
    private float f60835g;

    /* renamed from: g0, reason: collision with root package name */
    private Bitmap f60836g0;

    /* renamed from: h, reason: collision with root package name */
    private float f60837h;

    /* renamed from: h0, reason: collision with root package name */
    private Bitmap f60838h0;

    /* renamed from: i, reason: collision with root package name */
    private float f60839i;

    /* renamed from: i0, reason: collision with root package name */
    private Drawable f60840i0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f60841j;

    /* renamed from: j0, reason: collision with root package name */
    private int f60842j0;

    /* renamed from: k, reason: collision with root package name */
    private f f60843k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f60844k0;

    /* renamed from: l, reason: collision with root package name */
    private int f60845l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f60846l0;

    /* renamed from: m, reason: collision with root package name */
    private int f60847m;

    /* renamed from: m0, reason: collision with root package name */
    private int f60848m0;

    /* renamed from: n, reason: collision with root package name */
    private int f60849n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f60850n0;

    /* renamed from: o, reason: collision with root package name */
    private int f60851o;

    /* renamed from: o0, reason: collision with root package name */
    private RectF f60852o0;

    /* renamed from: p, reason: collision with root package name */
    private float f60853p;

    /* renamed from: p0, reason: collision with root package name */
    private RectF f60854p0;

    /* renamed from: q, reason: collision with root package name */
    private float f60855q;

    /* renamed from: q0, reason: collision with root package name */
    private int f60856q0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f60857r;

    /* renamed from: r0, reason: collision with root package name */
    private int f60858r0;

    /* renamed from: s, reason: collision with root package name */
    private float f60859s;

    /* renamed from: s0, reason: collision with root package name */
    private int f60860s0;

    /* renamed from: t, reason: collision with root package name */
    private float f60861t;

    /* renamed from: t0, reason: collision with root package name */
    private int f60862t0;

    /* renamed from: u, reason: collision with root package name */
    private float f60863u;

    /* renamed from: u0, reason: collision with root package name */
    private int[] f60864u0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f60865v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f60866v0;

    /* renamed from: w, reason: collision with root package name */
    private int f60867w;

    /* renamed from: w0, reason: collision with root package name */
    private float f60868w0;

    /* renamed from: x, reason: collision with root package name */
    private boolean f60869x;

    /* renamed from: x0, reason: collision with root package name */
    private float f60870x0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f60871y;

    /* renamed from: y0, reason: collision with root package name */
    private Bitmap f60872y0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f60873z;

    /* renamed from: z0, reason: collision with root package name */
    private int f60874z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f60875a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f60876b;

        a(float f11, int i11) {
            this.f60875a = f11;
            this.f60876b = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IndicatorSeekBar indicatorSeekBar = IndicatorSeekBar.this;
            indicatorSeekBar.f60835g = indicatorSeekBar.f60863u;
            if (this.f60875a - IndicatorSeekBar.this.A[this.f60876b] > 0.0f) {
                IndicatorSeekBar.this.f60863u = this.f60875a - ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else {
                IndicatorSeekBar.this.f60863u = this.f60875a + ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
            IndicatorSeekBar indicatorSeekBar2 = IndicatorSeekBar.this;
            indicatorSeekBar2.X(indicatorSeekBar2.f60863u);
            IndicatorSeekBar.this.setSeekListener(false);
            if (IndicatorSeekBar.this.P != null && IndicatorSeekBar.this.S) {
                IndicatorSeekBar.this.P.j();
                IndicatorSeekBar.this.a0();
            }
            IndicatorSeekBar.this.invalidate();
        }
    }

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60837h = -1.0f;
        this.f60839i = -1.0f;
        this.f60867w = 1;
        this.f60823a = context;
        A(context, attributeSet);
        D();
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f60837h = -1.0f;
        this.f60839i = -1.0f;
        this.f60867w = 1;
        this.f60823a = context;
        A(context, attributeSet);
        D();
    }

    private void A(Context context, AttributeSet attributeSet) {
        com.warkiz.widget.a aVar = new com.warkiz.widget.a(context);
        if (attributeSet == null) {
            l(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndicatorSeekBar);
        this.f60859s = obtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_max, aVar.f60879b);
        this.f60861t = obtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_min, aVar.f60880c);
        this.f60863u = obtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_progress, aVar.f60881d);
        this.f60865v = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_progress_value_float, aVar.f60882e);
        this.f60869x = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_user_seekable, aVar.f60885h);
        this.f60841j = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_clear_default_padding, aVar.f60887j);
        this.f60871y = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_only_thumb_draggable, aVar.f60886i);
        this.f60873z = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_seek_smoothly, aVar.f60883f);
        this.B = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_r2l, aVar.f60884g);
        this.f60856q0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_track_background_size, aVar.f60894q);
        this.f60858r0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_track_progress_size, aVar.f60896s);
        this.f60860s0 = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_track_background_color, aVar.f60895r);
        this.f60862t0 = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_track_progress_color, aVar.f60897t);
        this.f60850n0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_track_rounded_corners, aVar.f60898u);
        this.A0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_thumb_size, aVar.f60901x);
        this.B0 = obtainStyledAttributes.getDrawable(R$styleable.IndicatorSeekBar_isb_thumb_drawable);
        this.I0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        L(obtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_thumb_color), aVar.f60902y);
        this.E0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_show_thumb_text, aVar.f60900w);
        this.G0 = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_thumb_text_color, aVar.f60899v);
        this.f60828c0 = obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_ticks_count, aVar.H);
        this.f60842j0 = obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_show_tick_marks_type, aVar.I);
        this.f60848m0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_tick_marks_size, aVar.K);
        N(obtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_tick_marks_color), aVar.J);
        this.f60840i0 = obtainStyledAttributes.getDrawable(R$styleable.IndicatorSeekBar_isb_tick_marks_drawable);
        this.f60846l0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.N);
        this.f60844k0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.M);
        this.C = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_show_tick_texts, aVar.B);
        this.J = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_tick_texts_size, aVar.D);
        O(obtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_tick_texts_color), aVar.C);
        this.O = obtainStyledAttributes.getTextArray(R$styleable.IndicatorSeekBar_isb_tick_texts_array);
        J(obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.F);
        this.W = obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_show_indicator, aVar.f60888k);
        this.Q = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_indicator_color, aVar.f60889l);
        this.T = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_indicator_text_size, aVar.f60891n);
        this.R = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_indicator_text_color, aVar.f60890m);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.U = View.inflate(this.f60823a, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.V = View.inflate(this.f60823a, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void B() {
        if (this.f60841j) {
            return;
        }
        int a11 = g.a(this.f60823a, 16.0f);
        if (getPaddingLeft() == 0) {
            setPadding(a11, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (getPaddingRight() == 0) {
            setPadding(getPaddingLeft(), getPaddingTop(), a11, getPaddingBottom());
        }
    }

    private void C() {
        int i11 = this.W;
        if (i11 != 0 && this.P == null) {
            d dVar = new d(this.f60823a, this, this.Q, i11, this.T, this.R, this.U, this.V);
            this.P = dVar;
            this.U = dVar.d();
        }
    }

    private void D() {
        E();
        int i11 = this.f60856q0;
        int i12 = this.f60858r0;
        if (i11 > i12) {
            this.f60856q0 = i12;
        }
        if (this.B0 == null) {
            float f11 = this.A0 / 2.0f;
            this.f60868w0 = f11;
            this.f60870x0 = f11 * 1.2f;
        } else {
            float min = Math.min(g.a(this.f60823a, 30.0f), this.A0) / 2.0f;
            this.f60868w0 = min;
            this.f60870x0 = min;
        }
        if (this.f60840i0 == null) {
            this.f60834f0 = this.f60848m0 / 2.0f;
        } else {
            this.f60834f0 = Math.min(g.a(this.f60823a, 30.0f), this.f60848m0) / 2.0f;
        }
        this.f60833f = Math.max(this.f60870x0, this.f60834f0) * 2.0f;
        G();
        S();
        this.f60835g = this.f60863u;
        q();
        this.f60852o0 = new RectF();
        this.f60854p0 = new RectF();
        B();
        C();
    }

    private void E() {
        float f11 = this.f60859s;
        float f12 = this.f60861t;
        if (f11 < f12) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.f60863u < f12) {
            this.f60863u = f12;
        }
        if (this.f60863u > f11) {
            this.f60863u = f11;
        }
    }

    private void F() {
        this.f60849n = getMeasuredWidth();
        this.f60845l = getPaddingStart();
        this.f60847m = getPaddingEnd();
        this.f60851o = getPaddingTop();
        float f11 = (this.f60849n - this.f60845l) - this.f60847m;
        this.f60853p = f11;
        this.f60855q = f11 / (this.f60828c0 + (-1) > 0 ? r1 - 1 : 1);
    }

    private void G() {
        if (this.f60825b == null) {
            this.f60825b = new Paint();
        }
        if (this.f60850n0) {
            this.f60825b.setStrokeCap(Paint.Cap.ROUND);
        }
        this.f60825b.setAntiAlias(true);
        int i11 = this.f60856q0;
        if (i11 > this.f60858r0) {
            this.f60858r0 = i11;
        }
    }

    private void H() {
        if (this.f60827c == null) {
            TextPaint textPaint = new TextPaint();
            this.f60827c = textPaint;
            textPaint.setAntiAlias(true);
            this.f60827c.setTextAlign(Paint.Align.CENTER);
            this.f60827c.setTextSize(this.J);
        }
        if (this.f60831e == null) {
            this.f60831e = new Rect();
        }
    }

    private void I() {
        int i11 = this.f60828c0;
        if (i11 == 0) {
            return;
        }
        if (this.C) {
            this.F = new String[i11];
        }
        for (int i12 = 0; i12 < this.f60826b0.length; i12++) {
            if (this.C) {
                this.F[i12] = z(i12);
                TextPaint textPaint = this.f60827c;
                String str = this.F[i12];
                textPaint.getTextBounds(str, 0, str.length(), this.f60831e);
                this.G[i12] = this.f60831e.width();
                this.H[i12] = this.f60845l + (this.f60855q * i12);
            }
            this.f60826b0[i12] = this.f60845l + (this.f60855q * i12);
        }
    }

    private void J(int i11, Typeface typeface) {
        if (i11 == 0) {
            this.K = Typeface.DEFAULT;
            return;
        }
        if (i11 == 1) {
            this.K = Typeface.MONOSPACE;
            return;
        }
        if (i11 == 2) {
            this.K = Typeface.SANS_SERIF;
            return;
        }
        if (i11 == 3) {
            this.K = Typeface.SERIF;
        } else if (typeface == null) {
            this.K = Typeface.DEFAULT;
        } else {
            this.K = typeface;
        }
    }

    private void K() {
        Drawable drawable = this.B0;
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap w11 = w(drawable, true);
            this.f60872y0 = w11;
            this.C0 = w11;
            return;
        }
        try {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            Class<?> cls = stateListDrawable.getClass();
            int intValue = ((Integer) cls.getMethod("getStateCount", null).invoke(stateListDrawable, null)).intValue();
            if (intValue != 2) {
                throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
            }
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i11 = 0; i11 < intValue; i11++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i11));
                if (iArr.length <= 0) {
                    this.f60872y0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), true);
                } else {
                    if (iArr[0] != 16842919) {
                        throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                    }
                    this.C0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), true);
                }
            }
        } catch (Exception unused) {
            Bitmap w12 = w(this.B0, true);
            this.f60872y0 = w12;
            this.C0 = w12;
        }
    }

    private void L(ColorStateList colorStateList, int i11) {
        if (colorStateList == null) {
            this.f60874z0 = i11;
            this.D0 = i11;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i12 = iArr2[0];
                this.f60874z0 = i12;
                this.D0 = i12;
            } else {
                if (iArr.length != 2) {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                }
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    int[] iArr3 = iArr[i13];
                    if (iArr3.length == 0) {
                        this.D0 = iArr2[i13];
                    } else {
                        if (iArr3[0] != 16842919) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                        }
                        this.f60874z0 = iArr2[i13];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void M() {
        Drawable drawable = this.f60840i0;
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap w11 = w(drawable, false);
            this.f60836g0 = w11;
            this.f60838h0 = w11;
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        try {
            Class<?> cls = stateListDrawable.getClass();
            int intValue = ((Integer) cls.getMethod("getStateCount", null).invoke(stateListDrawable, null)).intValue();
            if (intValue != 2) {
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            }
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i11 = 0; i11 < intValue; i11++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i11));
                if (iArr.length <= 0) {
                    this.f60836g0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), false);
                } else {
                    if (iArr[0] != 16842913) {
                        throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                    }
                    this.f60838h0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), false);
                }
            }
        } catch (Exception unused) {
            Bitmap w12 = w(this.f60840i0, false);
            this.f60836g0 = w12;
            this.f60838h0 = w12;
        }
    }

    private void N(ColorStateList colorStateList, int i11) {
        if (colorStateList == null) {
            this.f60832e0 = i11;
            this.f60830d0 = i11;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i12 = iArr2[0];
                this.f60832e0 = i12;
                this.f60830d0 = i12;
            } else {
                if (iArr.length != 2) {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                }
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    int[] iArr3 = iArr[i13];
                    if (iArr3.length == 0) {
                        this.f60830d0 = iArr2[i13];
                    } else {
                        if (iArr3[0] != 16842913) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                        }
                        this.f60832e0 = iArr2[i13];
                    }
                }
            }
        } catch (Exception e11) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e11.getMessage());
        }
    }

    private void O(ColorStateList colorStateList, int i11) {
        if (colorStateList == null) {
            this.M = i11;
            this.L = i11;
            this.N = i11;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i12 = iArr2[0];
                this.M = i12;
                this.L = i12;
                this.N = i12;
                return;
            }
            if (iArr.length != 3) {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
            }
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int[] iArr3 = iArr[i13];
                if (iArr3.length == 0) {
                    this.M = iArr2[i13];
                } else {
                    int i14 = iArr3[0];
                    if (i14 == 16842913) {
                        this.L = iArr2[i13];
                    } else {
                        if (i14 != 16843623) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                        }
                        this.N = iArr2[i13];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void P() {
        if (!this.B) {
            RectF rectF = this.f60852o0;
            rectF.left = this.f60845l;
            rectF.top = this.f60851o + this.f60870x0;
            rectF.right = (((this.f60863u - this.f60861t) * this.f60853p) / getAmplitude()) + this.f60845l;
            RectF rectF2 = this.f60852o0;
            float f11 = rectF2.top;
            rectF2.bottom = f11;
            RectF rectF3 = this.f60854p0;
            rectF3.left = rectF2.right;
            rectF3.top = f11;
            rectF3.right = this.f60849n - this.f60847m;
            rectF3.bottom = f11;
            return;
        }
        RectF rectF4 = this.f60854p0;
        int i11 = this.f60845l;
        rectF4.left = i11;
        rectF4.top = this.f60851o + this.f60870x0;
        rectF4.right = i11 + (this.f60853p * (1.0f - ((this.f60863u - this.f60861t) / getAmplitude())));
        RectF rectF5 = this.f60854p0;
        float f12 = rectF5.top;
        rectF5.bottom = f12;
        RectF rectF6 = this.f60852o0;
        rectF6.left = rectF5.right;
        rectF6.top = f12;
        rectF6.right = this.f60849n - this.f60847m;
        rectF6.bottom = f12;
    }

    private boolean Q(float f11, float f12) {
        if (this.f60837h == -1.0f) {
            this.f60837h = g.a(this.f60823a, 5.0f);
        }
        float f13 = this.f60845l;
        float f14 = this.f60837h;
        boolean z10 = f11 >= f13 - (f14 * 2.0f) && f11 <= ((float) (this.f60849n - this.f60847m)) + (2.0f * f14);
        float f15 = this.f60852o0.top;
        float f16 = this.f60870x0;
        return z10 && ((f12 > ((f15 - f16) - f14) ? 1 : (f12 == ((f15 - f16) - f14) ? 0 : -1)) >= 0 && (f12 > ((f15 + f16) + f14) ? 1 : (f12 == ((f15 + f16) + f14) ? 0 : -1)) <= 0);
    }

    private boolean R(float f11) {
        X(this.f60863u);
        float f12 = this.B ? this.f60854p0.right : this.f60852o0.right;
        int i11 = this.A0;
        return f12 - (((float) i11) / 2.0f) <= f11 && f11 <= f12 + (((float) i11) / 2.0f);
    }

    private void S() {
        if (T()) {
            H();
            this.f60827c.setTypeface(this.K);
            this.f60827c.getTextBounds(j.f35620b, 0, 1, this.f60831e);
            this.E = this.f60831e.height() + g.a(this.f60823a, 3.0f);
        }
    }

    private boolean T() {
        return this.E0 || (this.f60828c0 != 0 && this.C);
    }

    private boolean U() {
        return this.f60865v ? this.f60835g != this.f60863u : Math.round(this.f60835g) != Math.round(this.f60863u);
    }

    private void V(MotionEvent motionEvent) {
        X(n(o(k(motionEvent))));
        setSeekListener(true);
        invalidate();
        Z();
    }

    private void W() {
        P();
        if (T()) {
            this.f60827c.getTextBounds(j.f35620b, 0, 1, this.f60831e);
            float round = this.f60851o + this.f60833f + Math.round(this.f60831e.height() - this.f60827c.descent()) + g.a(this.f60823a, 3.0f);
            this.I = round;
            this.F0 = round;
        }
        if (this.f60826b0 == null) {
            return;
        }
        I();
        if (this.f60828c0 > 2) {
            float f11 = this.A[getClosestIndex()];
            this.f60863u = f11;
            this.f60835g = f11;
        }
        X(this.f60863u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(float f11) {
        if (this.B) {
            this.f60854p0.right = this.f60845l + (this.f60853p * (1.0f - ((f11 - this.f60861t) / getAmplitude())));
            this.f60852o0.left = this.f60854p0.right;
            return;
        }
        this.f60852o0.right = (((f11 - this.f60861t) * this.f60853p) / getAmplitude()) + this.f60845l;
        this.f60854p0.left = this.f60852o0.right;
    }

    private void Z() {
        if (this.S) {
            a0();
            return;
        }
        d dVar = this.P;
        if (dVar == null) {
            return;
        }
        dVar.g();
        if (this.P.i()) {
            this.P.p(getThumbCenterX());
        } else {
            this.P.o(getThumbCenterX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        d dVar;
        int i11;
        if (!this.S || (dVar = this.P) == null) {
            return;
        }
        dVar.l(getIndicatorTextString());
        int i12 = 0;
        this.U.measure(0, 0);
        int measuredWidth = this.U.getMeasuredWidth();
        float thumbCenterX = getThumbCenterX();
        if (this.f60839i == -1.0f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) this.f60823a.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                this.f60839i = displayMetrics.widthPixels;
            }
        }
        float f11 = measuredWidth / 2;
        float f12 = f11 + thumbCenterX;
        int i13 = this.f60849n;
        if (f12 > i13) {
            i12 = i13 - measuredWidth;
            i11 = (int) ((thumbCenterX - i12) - f11);
        } else if (thumbCenterX - f11 < 0.0f) {
            i11 = -((int) (f11 - thumbCenterX));
        } else {
            i12 = (int) (getThumbCenterX() - f11);
            i11 = 0;
        }
        this.P.r(i12);
        this.P.q(i11);
    }

    private float getAmplitude() {
        float f11 = this.f60859s;
        float f12 = this.f60861t;
        if (f11 - f12 > 0.0f) {
            return f11 - f12;
        }
        return 1.0f;
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.f60859s - this.f60861t);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            float[] fArr = this.A;
            if (i11 >= fArr.length) {
                return i12;
            }
            float abs2 = Math.abs(fArr[i11] - this.f60863u);
            if (abs2 <= abs) {
                i12 = i11;
                abs = abs2;
            }
            i11++;
        }
    }

    private int getLeftSideTickColor() {
        return this.B ? this.f60830d0 : this.f60832e0;
    }

    private int getLeftSideTickTextsColor() {
        return this.B ? this.M : this.L;
    }

    private int getLeftSideTrackSize() {
        return this.B ? this.f60856q0 : this.f60858r0;
    }

    private int getRightSideTickColor() {
        return this.B ? this.f60832e0 : this.f60830d0;
    }

    private int getRightSideTickTextsColor() {
        return this.B ? this.L : this.M;
    }

    private int getRightSideTrackSize() {
        return this.B ? this.f60858r0 : this.f60856q0;
    }

    private float getThumbCenterX() {
        return this.B ? this.f60854p0.right : this.f60852o0.right;
    }

    private int getThumbPosOnTick() {
        if (this.f60828c0 != 0) {
            return Math.round((getThumbCenterX() - this.f60845l) / this.f60855q);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.f60828c0 != 0) {
            return (getThumbCenterX() - this.f60845l) / this.f60855q;
        }
        return 0.0f;
    }

    private float k(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        int i11 = this.f60845l;
        if (x10 >= i11) {
            float x11 = motionEvent.getX();
            int i12 = this.f60849n;
            int i13 = this.f60847m;
            if (x11 <= i12 - i13) {
                return motionEvent.getX();
            }
            i11 = i12 - i13;
        }
        return i11;
    }

    private void l(com.warkiz.widget.a aVar) {
        this.f60859s = aVar.f60879b;
        this.f60861t = aVar.f60880c;
        this.f60863u = aVar.f60881d;
        this.f60865v = aVar.f60882e;
        this.f60828c0 = aVar.H;
        this.f60873z = aVar.f60883f;
        this.B = aVar.f60884g;
        this.f60869x = aVar.f60885h;
        this.f60841j = aVar.f60887j;
        this.f60871y = aVar.f60886i;
        this.W = aVar.f60888k;
        this.Q = aVar.f60889l;
        this.R = aVar.f60890m;
        this.T = aVar.f60891n;
        this.U = aVar.f60892o;
        this.V = aVar.f60893p;
        this.f60856q0 = aVar.f60894q;
        this.f60860s0 = aVar.f60895r;
        this.f60858r0 = aVar.f60896s;
        this.f60862t0 = aVar.f60897t;
        this.f60850n0 = aVar.f60898u;
        this.A0 = aVar.f60901x;
        this.B0 = aVar.A;
        this.G0 = aVar.f60899v;
        L(aVar.f60903z, aVar.f60902y);
        this.E0 = aVar.f60900w;
        this.f60842j0 = aVar.I;
        this.f60848m0 = aVar.K;
        this.f60840i0 = aVar.L;
        this.f60844k0 = aVar.M;
        this.f60846l0 = aVar.N;
        N(aVar.O, aVar.J);
        this.C = aVar.B;
        this.J = aVar.D;
        this.O = aVar.E;
        this.K = aVar.F;
        O(aVar.G, aVar.C);
    }

    private boolean m() {
        if (this.f60828c0 < 3 || !this.f60873z || !this.I0) {
            return false;
        }
        int closestIndex = getClosestIndex();
        float f11 = this.f60863u;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f11 - this.A[closestIndex]));
        ofFloat.start();
        ofFloat.addUpdateListener(new a(f11, closestIndex));
        return true;
    }

    private float n(float f11) {
        this.f60835g = this.f60863u;
        float amplitude = this.f60861t + ((getAmplitude() * (f11 - this.f60845l)) / this.f60853p);
        this.f60863u = amplitude;
        return amplitude;
    }

    private float o(float f11) {
        if (this.f60828c0 > 2 && !this.f60873z) {
            f11 = this.f60845l + (this.f60855q * Math.round((f11 - this.f60845l) / this.f60855q));
        }
        return this.B ? (this.f60853p - f11) + (this.f60845l * 2) : f11;
    }

    private f p(boolean z10) {
        String[] strArr;
        if (this.f60843k == null) {
            this.f60843k = new f(this);
        }
        this.f60843k.f60922b = getProgress();
        this.f60843k.f60923c = getProgressFloat();
        this.f60843k.f60924d = z10;
        if (this.f60828c0 > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.C && (strArr = this.F) != null) {
                this.f60843k.f60926f = strArr[thumbPosOnTick];
            }
            if (this.B) {
                this.f60843k.f60925e = (this.f60828c0 - thumbPosOnTick) - 1;
            } else {
                this.f60843k.f60925e = thumbPosOnTick;
            }
        }
        return this.f60843k;
    }

    private void q() {
        int i11 = this.f60828c0;
        if (i11 < 0 || i11 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.f60828c0);
        }
        if (i11 == 0) {
            return;
        }
        this.f60826b0 = new float[i11];
        if (this.C) {
            this.H = new float[i11];
            this.G = new float[i11];
        }
        this.A = new float[i11];
        int i12 = 0;
        while (true) {
            float[] fArr = this.A;
            if (i12 >= fArr.length) {
                return;
            }
            float f11 = this.f60861t;
            fArr[i12] = f11 + ((i12 * (this.f60859s - f11)) / (this.f60828c0 + (-1) > 0 ? r4 - 1 : 1));
            i12++;
        }
    }

    private void r(Canvas canvas) {
        if (this.H0) {
            return;
        }
        float thumbCenterX = getThumbCenterX();
        if (this.B0 == null) {
            if (this.f60857r) {
                this.f60825b.setColor(this.D0);
            } else {
                this.f60825b.setColor(this.f60874z0);
            }
            canvas.drawCircle(thumbCenterX, this.f60852o0.top, this.f60857r ? this.f60870x0 : this.f60868w0, this.f60825b);
            return;
        }
        if (this.f60872y0 == null || this.C0 == null) {
            K();
        }
        if (this.f60872y0 == null || this.C0 == null) {
            throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
        }
        this.f60825b.setAlpha(255);
        if (this.f60857r) {
            canvas.drawBitmap(this.C0, thumbCenterX - (r1.getWidth() / 2.0f), this.f60852o0.top - (this.C0.getHeight() / 2.0f), this.f60825b);
        } else {
            canvas.drawBitmap(this.f60872y0, thumbCenterX - (r1.getWidth() / 2.0f), this.f60852o0.top - (this.f60872y0.getHeight() / 2.0f), this.f60825b);
        }
    }

    private void s(Canvas canvas) {
        if (this.E0) {
            if (!this.C || this.f60828c0 <= 2) {
                this.f60827c.setColor(this.G0);
                canvas.drawText(y(this.f60863u), getThumbCenterX(), this.F0, this.f60827c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z10) {
        if (this.f60829d != null && U()) {
            this.f60829d.c(p(z10));
        }
    }

    private void t(Canvas canvas) {
        Bitmap bitmap;
        if (this.f60828c0 != 0) {
            if (this.f60842j0 == 0 && this.f60840i0 == null) {
                return;
            }
            float thumbCenterX = getThumbCenterX();
            for (int i11 = 0; i11 < this.f60826b0.length; i11++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.f60846l0 || thumbCenterX < this.f60826b0[i11]) && ((!this.f60844k0 || (i11 != 0 && i11 != this.f60826b0.length - 1)) && (i11 != getThumbPosOnTick() || this.f60828c0 <= 2 || this.f60873z))) {
                    float f11 = i11;
                    if (f11 <= thumbPosOnTickFloat) {
                        this.f60825b.setColor(getLeftSideTickColor());
                    } else {
                        this.f60825b.setColor(getRightSideTickColor());
                    }
                    if (this.f60840i0 != null) {
                        if (this.f60838h0 == null || this.f60836g0 == null) {
                            M();
                        }
                        Bitmap bitmap2 = this.f60838h0;
                        if (bitmap2 == null || (bitmap = this.f60836g0) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        }
                        if (f11 <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, this.f60826b0[i11] - (bitmap.getWidth() / 2.0f), this.f60852o0.top - (this.f60836g0.getHeight() / 2.0f), this.f60825b);
                        } else {
                            canvas.drawBitmap(bitmap, this.f60826b0[i11] - (bitmap.getWidth() / 2.0f), this.f60852o0.top - (this.f60836g0.getHeight() / 2.0f), this.f60825b);
                        }
                    } else {
                        int i12 = this.f60842j0;
                        if (i12 == 1) {
                            canvas.drawCircle(this.f60826b0[i11], this.f60852o0.top, this.f60834f0, this.f60825b);
                        } else if (i12 == 3) {
                            int a11 = g.a(this.f60823a, 1.0f);
                            float leftSideTrackSize = thumbCenterX >= this.f60826b0[i11] ? getLeftSideTrackSize() : getRightSideTrackSize();
                            float f12 = this.f60826b0[i11];
                            float f13 = a11;
                            float f14 = this.f60852o0.top;
                            float f15 = leftSideTrackSize / 2.0f;
                            canvas.drawRect(f12 - f13, f14 - f15, f12 + f13, f14 + f15, this.f60825b);
                        } else if (i12 == 2) {
                            float f16 = this.f60826b0[i11];
                            int i13 = this.f60848m0;
                            float f17 = this.f60852o0.top;
                            canvas.drawRect(f16 - (i13 / 2.0f), f17 - (i13 / 2.0f), f16 + (i13 / 2.0f), f17 + (i13 / 2.0f), this.f60825b);
                        }
                    }
                }
            }
        }
    }

    private void u(Canvas canvas) {
        if (this.F == null) {
            return;
        }
        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
        int i11 = 0;
        while (true) {
            if (i11 >= this.F.length) {
                return;
            }
            if (!this.D || i11 == 0 || i11 == r2.length - 1) {
                if (i11 == getThumbPosOnTick() && i11 == thumbPosOnTickFloat) {
                    this.f60827c.setColor(this.N);
                } else if (i11 < thumbPosOnTickFloat) {
                    this.f60827c.setColor(getLeftSideTickTextsColor());
                } else {
                    this.f60827c.setColor(getRightSideTickTextsColor());
                }
                int length = this.B ? (this.F.length - i11) - 1 : i11;
                if (i11 == 0) {
                    canvas.drawText(this.F[length], this.H[i11] + (this.G[length] / 2.0f), this.I, this.f60827c);
                } else {
                    String[] strArr = this.F;
                    if (i11 == strArr.length - 1) {
                        canvas.drawText(strArr[length], this.H[i11] - (this.G[length] / 2.0f), this.I, this.f60827c);
                    } else {
                        canvas.drawText(strArr[length], this.H[i11], this.I, this.f60827c);
                    }
                }
            }
            i11++;
        }
    }

    private void v(Canvas canvas) {
        if (!this.f60866v0) {
            this.f60825b.setColor(this.f60862t0);
            this.f60825b.setStrokeWidth(this.f60858r0);
            RectF rectF = this.f60852o0;
            canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, this.f60825b);
            this.f60825b.setColor(this.f60860s0);
            this.f60825b.setStrokeWidth(this.f60856q0);
            RectF rectF2 = this.f60854p0;
            canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.f60825b);
            return;
        }
        int i11 = this.f60828c0;
        int i12 = i11 + (-1) > 0 ? i11 - 1 : 1;
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.B) {
                this.f60825b.setColor(this.f60864u0[(i12 - i13) - 1]);
            } else {
                this.f60825b.setColor(this.f60864u0[i13]);
            }
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            float f11 = i13;
            if (f11 < thumbPosOnTickFloat) {
                int i14 = i13 + 1;
                if (thumbPosOnTickFloat < i14) {
                    float thumbCenterX = getThumbCenterX();
                    this.f60825b.setStrokeWidth(getLeftSideTrackSize());
                    float f12 = this.f60826b0[i13];
                    RectF rectF3 = this.f60852o0;
                    canvas.drawLine(f12, rectF3.top, thumbCenterX, rectF3.bottom, this.f60825b);
                    this.f60825b.setStrokeWidth(getRightSideTrackSize());
                    RectF rectF4 = this.f60852o0;
                    canvas.drawLine(thumbCenterX, rectF4.top, this.f60826b0[i14], rectF4.bottom, this.f60825b);
                }
            }
            if (f11 < thumbPosOnTickFloat) {
                this.f60825b.setStrokeWidth(getLeftSideTrackSize());
            } else {
                this.f60825b.setStrokeWidth(getRightSideTrackSize());
            }
            float[] fArr = this.f60826b0;
            float f13 = fArr[i13];
            RectF rectF5 = this.f60852o0;
            canvas.drawLine(f13, rectF5.top, fArr[i13 + 1], rectF5.bottom, this.f60825b);
        }
    }

    private Bitmap w(Drawable drawable, boolean z10) {
        int intrinsicHeight;
        if (drawable == null) {
            return null;
        }
        int a11 = g.a(this.f60823a, 30.0f);
        if (drawable.getIntrinsicWidth() > a11) {
            int i11 = z10 ? this.A0 : this.f60848m0;
            intrinsicHeight = x(drawable, i11);
            if (i11 > a11) {
                intrinsicHeight = x(drawable, a11);
            } else {
                a11 = i11;
            }
        } else {
            a11 = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(a11, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static com.warkiz.widget.a with(@NonNull Context context) {
        return new com.warkiz.widget.a(context);
    }

    private int x(Drawable drawable, int i11) {
        return Math.round(((i11 * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
    }

    private String y(float f11) {
        return this.f60865v ? c.b(f11, this.f60867w) : String.valueOf(Math.round(f11));
    }

    private String z(int i11) {
        CharSequence[] charSequenceArr = this.O;
        return charSequenceArr == null ? y(this.A[i11]) : i11 < charSequenceArr.length ? String.valueOf(charSequenceArr[i11]) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        this.U.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.warkiz.widget.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.U.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.a0();
                IndicatorSeekBar.this.U.setVisibility(0);
            }
        }, 300L);
    }

    public void customSectionTrackColor(@NonNull b bVar) {
        int i11 = this.f60828c0;
        int i12 = i11 + (-1) > 0 ? i11 - 1 : 1;
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i13] = this.f60860s0;
        }
        this.f60866v0 = bVar.a(iArr);
        this.f60864u0 = iArr;
        invalidate();
    }

    public void customTickTexts(@NonNull String[] strArr) {
        this.O = strArr;
        if (this.F != null) {
            int i11 = 0;
            while (i11 < this.F.length) {
                String valueOf = i11 < strArr.length ? String.valueOf(strArr[i11]) : "";
                int i12 = this.B ? (this.f60828c0 - 1) - i11 : i11;
                this.F[i12] = valueOf;
                TextPaint textPaint = this.f60827c;
                if (textPaint != null && this.f60831e != null) {
                    textPaint.getTextBounds(valueOf, 0, valueOf.length(), this.f60831e);
                    this.G[i12] = this.f60831e.width();
                }
                i11++;
            }
            invalidate();
        }
    }

    public void customTickTextsTypeface(@NonNull Typeface typeface) {
        this.K = typeface;
        S();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public d getIndicator() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        String[] strArr;
        String str = this.f60824a0;
        if (str == null || !str.contains("${TICK_TEXT}")) {
            String str2 = this.f60824a0;
            if (str2 != null && str2.contains("${PROGRESS}")) {
                return this.f60824a0.replace("${PROGRESS}", y(this.f60863u));
            }
        } else if (this.f60828c0 > 2 && (strArr = this.F) != null) {
            return this.f60824a0.replace("${TICK_TEXT}", strArr[getThumbPosOnTick()]);
        }
        return y(this.f60863u);
    }

    public float getMax() {
        return this.f60859s;
    }

    public float getMin() {
        return this.f60861t;
    }

    public e getOnSeekChangeListener() {
        return this.f60829d;
    }

    public int getProgress() {
        return Math.round(this.f60863u);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.f60863u).setScale(this.f60867w, 4).floatValue();
    }

    public int getTickCount() {
        return this.f60828c0;
    }

    public void hideThumb(boolean z10) {
        this.H0 = z10;
        invalidate();
    }

    public void hideThumbText(boolean z10) {
        this.E0 = !z10;
        invalidate();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        v(canvas);
        t(canvas);
        u(canvas);
        r(canvas);
        s(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMeasuredDimension(View.resolveSize(g.a(this.f60823a, 170.0f), i11), Math.round(this.f60833f + getPaddingTop() + getPaddingBottom()) + this.E);
        F();
        W();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        setProgress(bundle.getFloat("isb_progress"));
        super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.f60863u);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        post(new Runnable() { // from class: com.warkiz.widget.IndicatorSeekBar.1
            @Override // java.lang.Runnable
            public void run() {
                IndicatorSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r0 != 3) goto L37;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.f60869x
            r1 = 0
            if (r0 == 0) goto L68
            boolean r0 = r4.isEnabled()
            if (r0 != 0) goto Lc
            goto L68
        Lc:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L20
            r2 = 2
            if (r0 == r2) goto L1c
            r2 = 3
            if (r0 == r2) goto L20
            goto L63
        L1c:
            r4.V(r5)
            goto L63
        L20:
            r4.f60857r = r1
            com.warkiz.widget.e r0 = r4.f60829d
            if (r0 == 0) goto L29
            r0.b(r4)
        L29:
            boolean r0 = r4.m()
            if (r0 != 0) goto L32
            r4.invalidate()
        L32:
            com.warkiz.widget.d r0 = r4.P
            if (r0 == 0) goto L63
            r0.f()
            goto L63
        L3a:
            r4.performClick()
            float r0 = r5.getX()
            float r3 = r5.getY()
            boolean r3 = r4.Q(r0, r3)
            if (r3 == 0) goto L63
            boolean r3 = r4.f60871y
            if (r3 == 0) goto L56
            boolean r0 = r4.R(r0)
            if (r0 != 0) goto L56
            return r1
        L56:
            r4.f60857r = r2
            com.warkiz.widget.e r0 = r4.f60829d
            if (r0 == 0) goto L5f
            r0.a(r4)
        L5f:
            r4.V(r5)
            return r2
        L63:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.widget.IndicatorSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setDecimalScale(int i11) {
        this.f60867w = i11;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (z10 == isEnabled()) {
            return;
        }
        super.setEnabled(z10);
        if (isEnabled()) {
            setAlpha(1.0f);
            if (this.S) {
                this.U.setAlpha(1.0f);
                return;
            }
            return;
        }
        setAlpha(0.3f);
        if (this.S) {
            this.U.setAlpha(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z10) {
        this.S = z10;
    }

    public void setIndicatorTextFormat(String str) {
        this.f60824a0 = str;
        I();
        a0();
    }

    public synchronized void setMax(float f11) {
        this.f60859s = Math.max(this.f60861t, f11);
        E();
        q();
        W();
        invalidate();
        a0();
    }

    public synchronized void setMin(float f11) {
        this.f60861t = Math.min(this.f60859s, f11);
        E();
        q();
        W();
        invalidate();
        a0();
    }

    public void setOnSeekChangeListener(@NonNull e eVar) {
        this.f60829d = eVar;
    }

    public synchronized void setProgress(float f11) {
        try {
            this.f60835g = this.f60863u;
            float f12 = this.f60861t;
            if (f11 >= f12) {
                f12 = this.f60859s;
                if (f11 > f12) {
                }
                this.f60863u = f11;
                if (!this.f60873z && this.f60828c0 > 2) {
                    this.f60863u = this.A[getClosestIndex()];
                }
                setSeekListener(false);
                X(this.f60863u);
                postInvalidate();
                a0();
            }
            f11 = f12;
            this.f60863u = f11;
            if (!this.f60873z) {
                this.f60863u = this.A[getClosestIndex()];
            }
            setSeekListener(false);
            X(this.f60863u);
            postInvalidate();
            a0();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void setR2L(boolean z10) {
        this.B = z10;
        requestLayout();
        invalidate();
        a0();
    }

    public void setThumbAdjustAuto(boolean z10) {
        this.I0 = z10;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.B0 = null;
            this.f60872y0 = null;
            this.C0 = null;
        } else {
            this.B0 = drawable;
            float min = Math.min(g.a(this.f60823a, 30.0f), this.A0) / 2.0f;
            this.f60868w0 = min;
            this.f60870x0 = min;
            this.f60833f = Math.max(min, this.f60834f0) * 2.0f;
            K();
        }
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i11) {
        int i12 = this.f60828c0;
        if (i12 < 0 || i12 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.f60828c0);
        }
        this.f60828c0 = i11;
        q();
        I();
        F();
        W();
        invalidate();
        a0();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.f60840i0 = null;
            this.f60836g0 = null;
            this.f60838h0 = null;
        } else {
            this.f60840i0 = drawable;
            float min = Math.min(g.a(this.f60823a, 30.0f), this.f60848m0) / 2.0f;
            this.f60834f0 = min;
            this.f60833f = Math.max(this.f60870x0, min) * 2.0f;
            M();
        }
        invalidate();
    }

    public void setUserSeekAble(boolean z10) {
        this.f60869x = z10;
    }

    public void showBothEndsTickTextsOnly(boolean z10) {
        this.D = z10;
    }

    public void thumbColor(int i11) {
        this.f60874z0 = i11;
        this.D0 = i11;
        invalidate();
    }

    public void thumbColorStateList(@NonNull ColorStateList colorStateList) {
        L(colorStateList, this.f60874z0);
        invalidate();
    }

    public void tickMarksColor(int i11) {
        this.f60832e0 = i11;
        this.f60830d0 = i11;
        invalidate();
    }

    public void tickMarksColor(@NonNull ColorStateList colorStateList) {
        N(colorStateList, this.f60832e0);
        invalidate();
    }

    public void tickTextsColor(int i11) {
        this.M = i11;
        this.L = i11;
        this.N = i11;
        invalidate();
    }

    public void tickTextsColorStateList(@NonNull ColorStateList colorStateList) {
        O(colorStateList, this.L);
        invalidate();
    }
}
