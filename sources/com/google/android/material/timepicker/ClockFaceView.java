package com.google.android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

/* loaded from: classes4.dex */
class ClockFaceView extends g implements ClockHandView.c {

    /* renamed from: d, reason: collision with root package name */
    private final ClockHandView f30086d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f30087e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f30088f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f30089g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray f30090h;

    /* renamed from: i, reason: collision with root package name */
    private final AccessibilityDelegateCompat f30091i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f30092j;

    /* renamed from: k, reason: collision with root package name */
    private final float[] f30093k;

    /* renamed from: l, reason: collision with root package name */
    private final int f30094l;

    /* renamed from: m, reason: collision with root package name */
    private final int f30095m;

    /* renamed from: n, reason: collision with root package name */
    private final int f30096n;

    /* renamed from: o, reason: collision with root package name */
    private final int f30097o;

    /* renamed from: p, reason: collision with root package name */
    private String[] f30098p;

    /* renamed from: q, reason: collision with root package name */
    private float f30099q;

    /* renamed from: r, reason: collision with root package name */
    private final ColorStateList f30100r;

    /* loaded from: classes4.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.l(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f30086d.j()) - ClockFaceView.this.f30094l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (intValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f30090h.get(intValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, false, view.isSelected()));
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (i11 != 16) {
                return super.performAccessibilityAction(view, i11, bundle);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.f30087e);
            float centerX = ClockFaceView.this.f30087e.centerX();
            float centerY = ClockFaceView.this.f30087e.centerY();
            ClockFaceView.this.f30086d.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
            ClockFaceView.this.f30086d.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
            return true;
        }
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f30087e = new Rect();
        this.f30088f = new RectF();
        this.f30089g = new Rect();
        this.f30090h = new SparseArray();
        this.f30093k = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i11, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a11 = xa.c.a(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.f30100r = a11;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.f30086d = clockHandView;
        this.f30094l = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = a11.getColorForState(new int[]{R.attr.state_selected}, a11.getDefaultColor());
        this.f30092j = new int[]{colorForState, colorForState, a11.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = g.a.a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a12 = xa.c.a(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(a12 != null ? a12.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f30091i = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        z(strArr, 0);
        this.f30095m = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.f30096n = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.f30097o = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }

    private void A(int i11) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f30090h.size();
        boolean z10 = false;
        for (int i12 = 0; i12 < Math.max(this.f30098p.length, size); i12++) {
            TextView textView = (TextView) this.f30090h.get(i12);
            if (i12 >= this.f30098p.length) {
                removeView(textView);
                this.f30090h.remove(i12);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f30090h.put(i12, textView);
                    addView(textView);
                }
                textView.setText(this.f30098p[i12]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i12));
                int i13 = (i12 / 12) + 1;
                textView.setTag(R$id.material_clock_level, Integer.valueOf(i13));
                if (i13 > 1) {
                    z10 = true;
                }
                ViewCompat.setAccessibilityDelegate(textView, this.f30091i);
                textView.setTextColor(this.f30100r);
                if (i11 != 0) {
                    textView.setContentDescription(getResources().getString(i11, this.f30098p[i12]));
                }
            }
        }
        this.f30086d.t(z10);
    }

    private void t() {
        RectF f11 = this.f30086d.f();
        TextView w11 = w(f11);
        for (int i11 = 0; i11 < this.f30090h.size(); i11++) {
            TextView textView = (TextView) this.f30090h.get(i11);
            if (textView != null) {
                textView.setSelected(textView == w11);
                textView.getPaint().setShader(v(f11, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient v(RectF rectF, TextView textView) {
        textView.getHitRect(this.f30087e);
        this.f30088f.set(this.f30087e);
        textView.getLineBounds(0, this.f30089g);
        RectF rectF2 = this.f30088f;
        Rect rect = this.f30089g;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f30088f)) {
            return new RadialGradient(rectF.centerX() - this.f30088f.left, rectF.centerY() - this.f30088f.top, rectF.width() * 0.5f, this.f30092j, this.f30093k, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private TextView w(RectF rectF) {
        float f11 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i11 = 0; i11 < this.f30090h.size(); i11++) {
            TextView textView2 = (TextView) this.f30090h.get(i11);
            if (textView2 != null) {
                textView2.getHitRect(this.f30087e);
                this.f30088f.set(this.f30087e);
                this.f30088f.union(rectF);
                float width = this.f30088f.width() * this.f30088f.height();
                if (width < f11) {
                    textView = textView2;
                    f11 = width;
                }
            }
        }
        return textView;
    }

    private static float x(float f11, float f12, float f13) {
        return Math.max(Math.max(f11, f12), f13);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void d(float f11, boolean z10) {
        if (Math.abs(this.f30099q - f11) > 0.001f) {
            this.f30099q = f11;
            t();
        }
    }

    @Override // com.google.android.material.timepicker.g
    public void l(int i11) {
        if (i11 != k()) {
            super.l(i11);
            this.f30086d.o(k());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.timepicker.g
    public void n() {
        super.n();
        for (int i11 = 0; i11 < this.f30090h.size(); i11++) {
            ((TextView) this.f30090h.get(i11)).setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f30098p.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int x10 = (int) (this.f30097o / x(this.f30095m / displayMetrics.heightPixels, this.f30096n / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(x10, 1073741824);
        setMeasuredDimension(x10, x10);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u() {
        return this.f30086d.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i11) {
        this.f30086d.p(i11);
    }

    public void z(String[] strArr, int i11) {
        this.f30098p = strArr;
        A(i11);
    }
}
