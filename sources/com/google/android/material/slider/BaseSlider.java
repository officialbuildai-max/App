package com.google.android.material.slider;

import ab.i;
import ab.n;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.d0;
import com.google.android.material.internal.f0;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import wa.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class BaseSlider extends View {

    /* renamed from: v0, reason: collision with root package name */
    private static final String f29728v0 = "BaseSlider";
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private float N;
    private MotionEvent O;
    private boolean P;
    private float Q;
    private float R;
    private ArrayList S;
    private int T;
    private int U;
    private float V;
    private float[] W;

    /* renamed from: a, reason: collision with root package name */
    private final Paint f29733a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f29734a0;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f29735b;

    /* renamed from: b0, reason: collision with root package name */
    private int f29736b0;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f29737c;

    /* renamed from: c0, reason: collision with root package name */
    private int f29738c0;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f29739d;

    /* renamed from: d0, reason: collision with root package name */
    private int f29740d0;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f29741e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f29742e0;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f29743f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f29744f0;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f29745g;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f29746g0;

    /* renamed from: h, reason: collision with root package name */
    private final d f29747h;

    /* renamed from: h0, reason: collision with root package name */
    private ColorStateList f29748h0;

    /* renamed from: i, reason: collision with root package name */
    private final AccessibilityManager f29749i;

    /* renamed from: i0, reason: collision with root package name */
    private ColorStateList f29750i0;

    /* renamed from: j, reason: collision with root package name */
    private AccessibilityEventSender f29751j;

    /* renamed from: j0, reason: collision with root package name */
    private ColorStateList f29752j0;

    /* renamed from: k, reason: collision with root package name */
    private int f29753k;

    /* renamed from: k0, reason: collision with root package name */
    private ColorStateList f29754k0;

    /* renamed from: l, reason: collision with root package name */
    private final List f29755l;

    /* renamed from: l0, reason: collision with root package name */
    private ColorStateList f29756l0;

    /* renamed from: m, reason: collision with root package name */
    private final List f29757m;

    /* renamed from: m0, reason: collision with root package name */
    private final Path f29758m0;

    /* renamed from: n, reason: collision with root package name */
    private final List f29759n;

    /* renamed from: n0, reason: collision with root package name */
    private final RectF f29760n0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f29761o;

    /* renamed from: o0, reason: collision with root package name */
    private final RectF f29762o0;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f29763p;

    /* renamed from: p0, reason: collision with root package name */
    private final i f29764p0;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f29765q;

    /* renamed from: q0, reason: collision with root package name */
    private Drawable f29766q0;

    /* renamed from: r, reason: collision with root package name */
    private final int f29767r;

    /* renamed from: r0, reason: collision with root package name */
    private List f29768r0;

    /* renamed from: s, reason: collision with root package name */
    private int f29769s;

    /* renamed from: s0, reason: collision with root package name */
    private float f29770s0;

    /* renamed from: t, reason: collision with root package name */
    private int f29771t;

    /* renamed from: t0, reason: collision with root package name */
    private int f29772t0;

    /* renamed from: u, reason: collision with root package name */
    private int f29773u;

    /* renamed from: u0, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f29774u0;

    /* renamed from: v, reason: collision with root package name */
    private int f29775v;

    /* renamed from: w, reason: collision with root package name */
    private int f29776w;

    /* renamed from: x, reason: collision with root package name */
    private int f29777x;

    /* renamed from: y, reason: collision with root package name */
    private int f29778y;

    /* renamed from: z, reason: collision with root package name */
    private int f29779z;

    /* renamed from: w0, reason: collision with root package name */
    static final int f29729w0 = R$style.Widget_MaterialComponents_Slider;

    /* renamed from: x0, reason: collision with root package name */
    private static final int f29730x0 = R$attr.motionDurationMedium4;

    /* renamed from: y0, reason: collision with root package name */
    private static final int f29731y0 = R$attr.motionDurationShort3;

    /* renamed from: z0, reason: collision with root package name */
    private static final int f29732z0 = R$attr.motionEasingEmphasizedInterpolator;
    private static final int A0 = R$attr.motionEasingEmphasizedAccelerateInterpolator;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        /* synthetic */ AccessibilityEventSender(BaseSlider baseSlider, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f29747h.J(this.virtualViewId, 4);
        }

        void setVirtualViewId(int i11) {
            this.virtualViewId = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        float f29780a;

        /* renamed from: b, reason: collision with root package name */
        float f29781b;

        /* renamed from: c, reason: collision with root package name */
        ArrayList f29782c;

        /* renamed from: d, reason: collision with root package name */
        float f29783d;

        /* renamed from: e, reason: collision with root package name */
        boolean f29784e;

        /* loaded from: classes4.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i11) {
                return new SliderState[i11];
            }
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.f29780a = parcel.readFloat();
            this.f29781b = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.f29782c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f29783d = parcel.readFloat();
            this.f29784e = parcel.createBooleanArray()[0];
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeFloat(this.f29780a);
            parcel.writeFloat(this.f29781b);
            parcel.writeList(this.f29782c);
            parcel.writeFloat(this.f29783d);
            parcel.writeBooleanArray(new boolean[]{this.f29784e});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.f29755l.iterator();
            while (it.hasNext()) {
                ((cb.a) it.next()).D0(floatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d0 k11 = f0.k(BaseSlider.this);
            Iterator it = BaseSlider.this.f29755l.iterator();
            while (it.hasNext()) {
                k11.b((cb.a) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f29787a;

        static {
            int[] iArr = new int[FullCornerDirection.values().length];
            f29787a = iArr;
            try {
                iArr[FullCornerDirection.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29787a[FullCornerDirection.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29787a[FullCornerDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29787a[FullCornerDirection.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class d extends androidx.customview.widget.a {

        /* renamed from: n, reason: collision with root package name */
        private final BaseSlider f29788n;

        /* renamed from: o, reason: collision with root package name */
        final Rect f29789o;

        d(BaseSlider baseSlider) {
            super(baseSlider);
            this.f29789o = new Rect();
            this.f29788n = baseSlider;
        }

        private String L(int i11) {
            return i11 == this.f29788n.getValues().size() + (-1) ? this.f29788n.getContext().getString(R$string.material_slider_range_end) : i11 == 0 ? this.f29788n.getContext().getString(R$string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.a
        protected void C(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.f29788n.getValues();
            float floatValue = values.get(i11).floatValue();
            float valueFrom = this.f29788n.getValueFrom();
            float valueTo = this.f29788n.getValueTo();
            if (this.f29788n.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb2 = new StringBuilder();
            if (this.f29788n.getContentDescription() != null) {
                sb2.append(this.f29788n.getContentDescription());
                sb2.append(",");
            }
            String A = this.f29788n.A(floatValue);
            String string = this.f29788n.getContext().getString(R$string.material_slider_value);
            if (values.size() > 1) {
                string = L(i11);
            }
            sb2.append(String.format(Locale.US, "%s, %s", string, A));
            accessibilityNodeInfoCompat.setContentDescription(sb2.toString());
            this.f29788n.q0(i11, this.f29789o);
            accessibilityNodeInfoCompat.setBoundsInParent(this.f29789o);
        }

        @Override // androidx.customview.widget.a
        protected int o(float f11, float f12) {
            for (int i11 = 0; i11 < this.f29788n.getValues().size(); i11++) {
                this.f29788n.q0(i11, this.f29789o);
                if (this.f29789o.contains((int) f11, (int) f12)) {
                    return i11;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.a
        protected void p(List list) {
            for (int i11 = 0; i11 < this.f29788n.getValues().size(); i11++) {
                list.add(Integer.valueOf(i11));
            }
        }

        @Override // androidx.customview.widget.a
        protected boolean y(int i11, int i12, Bundle bundle) {
            if (!this.f29788n.isEnabled()) {
                return false;
            }
            if (i12 != 4096 && i12 != 8192) {
                if (i12 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.f29788n.o0(i11, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.f29788n.r0();
                        this.f29788n.postInvalidate();
                        r(i11);
                        return true;
                    }
                }
                return false;
            }
            float l11 = this.f29788n.l(20);
            if (i12 == 8192) {
                l11 = -l11;
            }
            if (this.f29788n.P()) {
                l11 = -l11;
            }
            if (!this.f29788n.o0(i11, d1.a.a(this.f29788n.getValues().get(i11).floatValue() + l11, this.f29788n.getValueFrom(), this.f29788n.getValueTo()))) {
                return false;
            }
            this.f29788n.r0();
            this.f29788n.postInvalidate();
            r(i11);
            return true;
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i11) {
        super(bb.a.c(context, attributeSet, i11, f29729w0), attributeSet, i11);
        this.f29755l = new ArrayList();
        this.f29757m = new ArrayList();
        this.f29759n = new ArrayList();
        this.f29761o = false;
        this.I = -1;
        this.J = -1;
        this.P = false;
        this.S = new ArrayList();
        this.T = -1;
        this.U = -1;
        this.V = 0.0f;
        this.f29734a0 = true;
        this.f29744f0 = false;
        this.f29758m0 = new Path();
        this.f29760n0 = new RectF();
        this.f29762o0 = new RectF();
        i iVar = new i();
        this.f29764p0 = iVar;
        this.f29768r0 = Collections.emptyList();
        this.f29772t0 = 0;
        this.f29774u0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.c
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                BaseSlider.this.s0();
            }
        };
        Context context2 = getContext();
        this.f29733a = new Paint();
        this.f29735b = new Paint();
        Paint paint = new Paint(1);
        this.f29737c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.f29739d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f29741e = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f29743f = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.f29745g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        R(context2.getResources());
        g0(context2, attributeSet, i11);
        setFocusable(true);
        setClickable(true);
        iVar.k0(2);
        this.f29767r = ViewConfiguration.get(context2).getScaledTouchSlop();
        d dVar = new d(this);
        this.f29747h = dVar;
        ViewCompat.setAccessibilityDelegate(this, dVar);
        this.f29749i = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A(float f11) {
        if (hasLabelFormatter()) {
            throw null;
        }
        return String.format(((float) ((int) f11)) == f11 ? "%.0f" : "%.2f", Float.valueOf(f11));
    }

    private void A0() {
        if (this.R <= this.Q) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.R), Float.valueOf(this.Q)));
        }
    }

    private float[] B() {
        float floatValue = ((Float) this.S.get(0)).floatValue();
        ArrayList arrayList = this.S;
        float floatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (this.S.size() == 1) {
            floatValue = this.Q;
        }
        float a02 = a0(floatValue);
        float a03 = a0(floatValue2);
        return P() ? new float[]{a03, a02} : new float[]{a02, a03};
    }

    private void B0() {
        Iterator it = this.S.iterator();
        while (it.hasNext()) {
            Float f11 = (Float) it.next();
            if (f11.floatValue() < this.Q || f11.floatValue() > this.R) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", f11, Float.valueOf(this.Q), Float.valueOf(this.R)));
            }
            if (this.V > 0.0f && !C0(f11.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", f11, Float.valueOf(this.Q), Float.valueOf(this.V), Float.valueOf(this.V)));
            }
        }
    }

    private static float C(ValueAnimator valueAnimator, float f11) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f11;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private boolean C0(float f11) {
        return N(new BigDecimal(Float.toString(f11)).subtract(new BigDecimal(Float.toString(this.Q)), MathContext.DECIMAL64).doubleValue());
    }

    private float D(int i11, float f11) {
        float minSeparation = getMinSeparation();
        if (this.f29772t0 == 0) {
            minSeparation = q(minSeparation);
        }
        if (P()) {
            minSeparation = -minSeparation;
        }
        int i12 = i11 + 1;
        int i13 = i11 - 1;
        return d1.a.a(f11, i13 < 0 ? this.Q : ((Float) this.S.get(i13)).floatValue() + minSeparation, i12 >= this.S.size() ? this.R : ((Float) this.S.get(i12)).floatValue() - minSeparation);
    }

    private float D0(float f11) {
        return (a0(f11) * this.f29740d0) + this.D;
    }

    private int E(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private void E0() {
        float f11 = this.V;
        if (f11 == 0.0f) {
            return;
        }
        if (((int) f11) != f11) {
            Log.w(f29728v0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f11)));
        }
        float f12 = this.Q;
        if (((int) f12) != f12) {
            Log.w(f29728v0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f12)));
        }
        float f13 = this.R;
        if (((int) f13) != f13) {
            Log.w(f29728v0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f13)));
        }
    }

    private float[] F(float f11, float f12) {
        return new float[]{f11, f11, f12, f12, f12, f12, f11, f11};
    }

    private float G() {
        double n02 = n0(this.f29770s0);
        if (P()) {
            n02 = 1.0d - n02;
        }
        float f11 = this.R;
        return (float) ((n02 * (f11 - r3)) + this.Q);
    }

    private float H() {
        float f11 = this.f29770s0;
        if (P()) {
            f11 = 1.0f - f11;
        }
        float f12 = this.R;
        float f13 = this.Q;
        return (f11 * (f12 - f13)) + f13;
    }

    private boolean I() {
        return this.H > 0;
    }

    private Drawable J(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        h(newDrawable);
        return newDrawable;
    }

    private void K() {
        this.f29733a.setStrokeWidth(this.C);
        this.f29735b.setStrokeWidth(this.C);
    }

    private boolean L() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private static boolean M(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean N(double d11) {
        double doubleValue = new BigDecimal(Double.toString(d11)).divide(new BigDecimal(Float.toString(this.V)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    private boolean O(MotionEvent motionEvent) {
        return !M(motionEvent) && L();
    }

    private boolean Q() {
        Rect rect = new Rect();
        f0.j(this).getHitRect(rect);
        return getLocalVisibleRect(rect);
    }

    private void R(Resources resources) {
        this.f29779z = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.f29769s = dimensionPixelOffset;
        this.D = dimensionPixelOffset;
        this.f29771t = resources.getDimensionPixelSize(R$dimen.mtrl_slider_thumb_radius);
        this.f29773u = resources.getDimensionPixelSize(R$dimen.mtrl_slider_track_height);
        this.f29775v = resources.getDimensionPixelSize(R$dimen.mtrl_slider_tick_radius);
        this.f29776w = resources.getDimensionPixelSize(R$dimen.mtrl_slider_tick_radius);
        this.f29777x = resources.getDimensionPixelSize(R$dimen.mtrl_slider_tick_min_spacing);
        this.M = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
    }

    private void S() {
        if (this.V <= 0.0f) {
            return;
        }
        w0();
        int min = Math.min((int) (((this.R - this.Q) / this.V) + 1.0f), (this.f29740d0 / this.f29777x) + 1);
        float[] fArr = this.W;
        if (fArr == null || fArr.length != min * 2) {
            this.W = new float[min * 2];
        }
        float f11 = this.f29740d0 / (min - 1);
        for (int i11 = 0; i11 < min * 2; i11 += 2) {
            float[] fArr2 = this.W;
            fArr2[i11] = this.D + ((i11 / 2.0f) * f11);
            fArr2[i11 + 1] = m();
        }
    }

    private void T(Canvas canvas, int i11, int i12) {
        if (l0()) {
            int a02 = (int) (this.D + (a0(((Float) this.S.get(this.U)).floatValue()) * i11));
            if (Build.VERSION.SDK_INT < 28) {
                int i13 = this.G;
                canvas.clipRect(a02 - i13, i12 - i13, a02 + i13, i13 + i12, Region.Op.UNION);
            }
            canvas.drawCircle(a02, i12, this.G, this.f29739d);
        }
    }

    private void U(Canvas canvas, int i11) {
        if (this.K <= 0) {
            return;
        }
        if (this.S.size() >= 1) {
            ArrayList arrayList = this.S;
            float floatValue = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
            float f11 = this.R;
            if (floatValue < f11) {
                canvas.drawPoint(D0(f11), i11, this.f29745g);
            }
        }
        if (this.S.size() > 1) {
            float floatValue2 = ((Float) this.S.get(0)).floatValue();
            float f12 = this.Q;
            if (floatValue2 > f12) {
                canvas.drawPoint(D0(f12), i11, this.f29745g);
            }
        }
    }

    private void V(Canvas canvas) {
        if (!this.f29734a0 || this.V <= 0.0f) {
            return;
        }
        float[] B = B();
        int ceil = (int) Math.ceil(B[0] * ((this.W.length / 2.0f) - 1.0f));
        int floor = (int) Math.floor(B[1] * ((this.W.length / 2.0f) - 1.0f));
        if (ceil > 0) {
            canvas.drawPoints(this.W, 0, ceil * 2, this.f29741e);
        }
        if (ceil <= floor) {
            canvas.drawPoints(this.W, ceil * 2, ((floor - ceil) + 1) * 2, this.f29743f);
        }
        int i11 = (floor + 1) * 2;
        float[] fArr = this.W;
        if (i11 < fArr.length) {
            canvas.drawPoints(fArr, i11, fArr.length - i11, this.f29741e);
        }
    }

    private boolean W() {
        int max = this.f29769s + Math.max(Math.max(Math.max((this.E / 2) - this.f29771t, 0), Math.max((this.C - this.f29773u) / 2, 0)), Math.max(Math.max(this.f29736b0 - this.f29775v, 0), Math.max(this.f29738c0 - this.f29776w, 0)));
        if (this.D == max) {
            return false;
        }
        this.D = max;
        if (!ViewCompat.isLaidOut(this)) {
            return true;
        }
        u0(getWidth());
        return true;
    }

    private boolean X() {
        int max = Math.max(this.f29779z, Math.max(this.C + getPaddingTop() + getPaddingBottom(), this.F + getPaddingTop() + getPaddingBottom()));
        if (max == this.A) {
            return false;
        }
        this.A = max;
        return true;
    }

    private boolean Y(int i11) {
        int i12 = this.U;
        int c11 = (int) d1.a.c(i12 + i11, 0L, this.S.size() - 1);
        this.U = c11;
        if (c11 == i12) {
            return false;
        }
        if (this.T != -1) {
            this.T = c11;
        }
        r0();
        postInvalidate();
        return true;
    }

    private boolean Z(int i11) {
        if (P()) {
            i11 = i11 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i11;
        }
        return Y(i11);
    }

    private float a0(float f11) {
        float f12 = this.Q;
        float f13 = (f11 - f12) / (this.R - f12);
        return P() ? 1.0f - f13 : f13;
    }

    private Boolean b0(int i11, KeyEvent keyEvent) {
        if (i11 == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(Y(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(Y(-1)) : Boolean.FALSE;
        }
        if (i11 != 66) {
            if (i11 != 81) {
                if (i11 == 69) {
                    Y(-1);
                    return Boolean.TRUE;
                }
                if (i11 != 70) {
                    switch (i11) {
                        case 21:
                            Z(-1);
                            return Boolean.TRUE;
                        case 22:
                            Z(1);
                            return Boolean.TRUE;
                        case 23:
                            break;
                        default:
                            return null;
                    }
                }
            }
            Y(1);
            return Boolean.TRUE;
        }
        this.T = this.U;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void c0() {
        Iterator it = this.f29759n.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    private void d0() {
        Iterator it = this.f29759n.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    private void f0(cb.a aVar, float f11) {
        int a02 = (this.D + ((int) (a0(f11) * this.f29740d0))) - (aVar.getIntrinsicWidth() / 2);
        int m11 = m() - (this.M + (this.F / 2));
        aVar.setBounds(a02, m11 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + a02, m11);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.d.c(f0.j(this), this, rect);
        aVar.setBounds(rect);
    }

    private void g0(Context context, AttributeSet attributeSet, int i11) {
        TypedArray i12 = b0.i(context, attributeSet, R$styleable.Slider, i11, f29729w0, new int[0]);
        this.f29753k = i12.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip);
        this.Q = i12.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.R = i12.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.Q));
        this.V = i12.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        this.f29778y = (int) Math.ceil(i12.getDimension(R$styleable.Slider_minTouchTargetSize, (float) Math.ceil(f0.g(getContext(), 48))));
        boolean hasValue = i12.hasValue(R$styleable.Slider_trackColor);
        int i13 = hasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorInactive;
        int i14 = hasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorActive;
        ColorStateList a11 = xa.c.a(context, i12, i13);
        if (a11 == null) {
            a11 = g.a.a(context, R$color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(a11);
        ColorStateList a12 = xa.c.a(context, i12, i14);
        if (a12 == null) {
            a12 = g.a.a(context, R$color.material_slider_active_track_color);
        }
        setTrackActiveTintList(a12);
        this.f29764p0.d0(xa.c.a(context, i12, R$styleable.Slider_thumbColor));
        if (i12.hasValue(R$styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(xa.c.a(context, i12, R$styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(i12.getDimension(R$styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList a13 = xa.c.a(context, i12, R$styleable.Slider_haloColor);
        if (a13 == null) {
            a13 = g.a.a(context, R$color.material_slider_halo_color);
        }
        setHaloTintList(a13);
        this.f29734a0 = i12.getBoolean(R$styleable.Slider_tickVisible, true);
        boolean hasValue2 = i12.hasValue(R$styleable.Slider_tickColor);
        int i15 = hasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorInactive;
        int i16 = hasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorActive;
        ColorStateList a14 = xa.c.a(context, i12, i15);
        if (a14 == null) {
            a14 = g.a.a(context, R$color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(a14);
        ColorStateList a15 = xa.c.a(context, i12, i16);
        if (a15 == null) {
            a15 = g.a.a(context, R$color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(a15);
        setThumbTrackGapSize(i12.getDimensionPixelSize(R$styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(i12.getDimensionPixelSize(R$styleable.Slider_trackStopIndicatorSize, 0));
        setTrackInsideCornerSize(i12.getDimensionPixelSize(R$styleable.Slider_trackInsideCornerSize, 0));
        int dimensionPixelSize = i12.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0) * 2;
        int dimensionPixelSize2 = i12.getDimensionPixelSize(R$styleable.Slider_thumbWidth, dimensionPixelSize);
        int dimensionPixelSize3 = i12.getDimensionPixelSize(R$styleable.Slider_thumbHeight, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(i12.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(i12.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(i12.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        setTickActiveRadius(i12.getDimensionPixelSize(R$styleable.Slider_tickRadiusActive, this.K / 2));
        setTickInactiveRadius(i12.getDimensionPixelSize(R$styleable.Slider_tickRadiusInactive, this.K / 2));
        setLabelBehavior(i12.getInt(R$styleable.Slider_labelBehavior, 0));
        if (!i12.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        i12.recycle();
    }

    private void h(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.E, this.F);
        } else {
            float max = Math.max(this.E, this.F) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    private void h0(int i11) {
        AccessibilityEventSender accessibilityEventSender = this.f29751j;
        if (accessibilityEventSender == null) {
            this.f29751j = new AccessibilityEventSender(this, null);
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.f29751j.setVirtualViewId(i11);
        postDelayed(this.f29751j, 200L);
    }

    private void i(cb.a aVar) {
        aVar.C0(f0.j(this));
    }

    private void i0(cb.a aVar, float f11) {
        aVar.E0(A(f11));
        f0(aVar, f11);
        f0.k(this).a(aVar);
    }

    private Float j(int i11) {
        float l11 = this.f29744f0 ? l(20) : k();
        if (i11 == 21) {
            if (!P()) {
                l11 = -l11;
            }
            return Float.valueOf(l11);
        }
        if (i11 == 22) {
            if (P()) {
                l11 = -l11;
            }
            return Float.valueOf(l11);
        }
        if (i11 == 69) {
            return Float.valueOf(-l11);
        }
        if (i11 == 70 || i11 == 81) {
            return Float.valueOf(l11);
        }
        return null;
    }

    private void j0(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.S.size() == arrayList.size() && this.S.equals(arrayList)) {
            return;
        }
        this.S = arrayList;
        this.f29746g0 = true;
        this.U = 0;
        r0();
        o();
        s();
        postInvalidate();
    }

    private float k() {
        float f11 = this.V;
        if (f11 == 0.0f) {
            return 1.0f;
        }
        return f11;
    }

    private boolean k0() {
        return this.B == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float l(int i11) {
        float k11 = k();
        return (this.R - this.Q) / k11 <= i11 ? k11 : Math.round(r1 / r4) * k11;
    }

    private boolean l0() {
        return this.f29742e0 || !(getBackground() instanceof RippleDrawable);
    }

    private int m() {
        return (this.A / 2) + ((this.B == 1 || k0()) ? ((cb.a) this.f29755l.get(0)).getIntrinsicHeight() : 0);
    }

    private boolean m0(float f11) {
        return o0(this.T, f11);
    }

    private ValueAnimator n(boolean z10) {
        int f11;
        TimeInterpolator g11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(C(z10 ? this.f29765q : this.f29763p, z10 ? 0.0f : 1.0f), z10 ? 1.0f : 0.0f);
        if (z10) {
            f11 = j.f(getContext(), f29730x0, 83);
            g11 = j.g(getContext(), f29732z0, oa.a.f71045e);
        } else {
            f11 = j.f(getContext(), f29731y0, Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE);
            g11 = j.g(getContext(), A0, oa.a.f71043c);
        }
        ofFloat.setDuration(f11);
        ofFloat.setInterpolator(g11);
        ofFloat.addUpdateListener(new a());
        return ofFloat;
    }

    private double n0(float f11) {
        float f12 = this.V;
        if (f12 <= 0.0f) {
            return f11;
        }
        return Math.round(f11 * r0) / ((int) ((this.R - this.Q) / f12));
    }

    private void o() {
        if (this.f29755l.size() > this.S.size()) {
            List<cb.a> subList = this.f29755l.subList(this.S.size(), this.f29755l.size());
            for (cb.a aVar : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    p(aVar);
                }
            }
            subList.clear();
        }
        while (true) {
            if (this.f29755l.size() >= this.S.size()) {
                break;
            }
            cb.a w02 = cb.a.w0(getContext(), null, 0, this.f29753k);
            this.f29755l.add(w02);
            if (ViewCompat.isAttachedToWindow(this)) {
                i(w02);
            }
        }
        int i11 = this.f29755l.size() != 1 ? 1 : 0;
        Iterator it = this.f29755l.iterator();
        while (it.hasNext()) {
            ((cb.a) it.next()).o0(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o0(int i11, float f11) {
        this.U = i11;
        if (Math.abs(f11 - ((Float) this.S.get(i11)).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.S.set(i11, Float.valueOf(D(i11, f11)));
        r(i11);
        return true;
    }

    private void p(cb.a aVar) {
        d0 k11 = f0.k(this);
        if (k11 != null) {
            k11.b(aVar);
            aVar.y0(f0.j(this));
        }
    }

    private boolean p0() {
        return m0(G());
    }

    private float q(float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        float f12 = (f11 - this.D) / this.f29740d0;
        float f13 = this.Q;
        return (f12 * (f13 - this.R)) + f13;
    }

    private void r(int i11) {
        Iterator it = this.f29757m.iterator();
        while (it.hasNext()) {
            ((com.google.android.material.slider.a) it.next()).a(this, ((Float) this.S.get(i11)).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f29749i;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        h0(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (l0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int a02 = (int) ((a0(((Float) this.S.get(this.U)).floatValue()) * this.f29740d0) + this.D);
            int m11 = m();
            int i11 = this.G;
            a1.a.l(background, a02 - i11, m11 - i11, a02 + i11, m11 + i11);
        }
    }

    private void s() {
        for (com.google.android.material.slider.a aVar : this.f29757m) {
            Iterator it = this.S.iterator();
            while (it.hasNext()) {
                aVar.a(this, ((Float) it.next()).floatValue(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        int i11 = this.B;
        if (i11 == 0 || i11 == 1) {
            if (this.T == -1 || !isEnabled()) {
                y();
                return;
            } else {
                x();
                return;
            }
        }
        if (i11 == 2) {
            y();
            return;
        }
        if (i11 != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.B);
        }
        if (isEnabled() && Q()) {
            x();
        } else {
            y();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void t(android.graphics.Canvas r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.t(android.graphics.Canvas, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void t0(android.graphics.Canvas r9, android.graphics.Paint r10, android.graphics.RectF r11, com.google.android.material.slider.BaseSlider.FullCornerDirection r12) {
        /*
            r8 = this;
            int r0 = r8.C
            float r1 = (float) r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r0 = (float) r0
            float r0 = r0 / r2
            int[] r3 = com.google.android.material.slider.BaseSlider.c.f29787a
            int r4 = r12.ordinal()
            r4 = r3[r4]
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == r7) goto L22
            if (r4 == r6) goto L1e
            if (r4 == r5) goto L1a
            goto L26
        L1a:
            int r1 = r8.L
            float r1 = (float) r1
            goto L26
        L1e:
            int r0 = r8.L
        L20:
            float r0 = (float) r0
            goto L26
        L22:
            int r0 = r8.L
            float r1 = (float) r0
            goto L20
        L26:
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r10.setStyle(r4)
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.BUTT
            r10.setStrokeCap(r4)
            r10.setAntiAlias(r7)
            android.graphics.Path r4 = r8.f29758m0
            r4.reset()
            float r4 = r11.width()
            float r7 = r1 + r0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 < 0) goto L53
            android.graphics.Path r12 = r8.f29758m0
            float[] r0 = r8.F(r1, r0)
            android.graphics.Path$Direction r1 = android.graphics.Path.Direction.CW
            r12.addRoundRect(r11, r0, r1)
            android.graphics.Path r11 = r8.f29758m0
            r9.drawPath(r11, r10)
            goto Lac
        L53:
            float r4 = java.lang.Math.min(r1, r0)
            float r0 = java.lang.Math.max(r1, r0)
            r9.save()
            android.graphics.Path r1 = r8.f29758m0
            android.graphics.Path$Direction r7 = android.graphics.Path.Direction.CW
            r1.addRoundRect(r11, r4, r4, r7)
            android.graphics.Path r1 = r8.f29758m0
            r9.clipPath(r1)
            int r12 = r12.ordinal()
            r12 = r3[r12]
            if (r12 == r6) goto L97
            if (r12 == r5) goto L88
            android.graphics.RectF r12 = r8.f29762o0
            float r1 = r11.centerX()
            float r1 = r1 - r0
            float r2 = r11.top
            float r3 = r11.centerX()
            float r3 = r3 + r0
            float r11 = r11.bottom
            r12.set(r1, r2, r3, r11)
            goto La4
        L88:
            android.graphics.RectF r12 = r8.f29762o0
            float r1 = r11.right
            float r2 = r2 * r0
            float r2 = r1 - r2
            float r3 = r11.top
            float r11 = r11.bottom
            r12.set(r2, r3, r1, r11)
            goto La4
        L97:
            android.graphics.RectF r12 = r8.f29762o0
            float r1 = r11.left
            float r3 = r11.top
            float r2 = r2 * r0
            float r2 = r2 + r1
            float r11 = r11.bottom
            r12.set(r1, r3, r2, r11)
        La4:
            android.graphics.RectF r11 = r8.f29762o0
            r9.drawRoundRect(r11, r0, r0, r10)
            r9.restore()
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.t0(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, com.google.android.material.slider.BaseSlider$FullCornerDirection):void");
    }

    private void u(Canvas canvas, int i11, int i12) {
        float[] B = B();
        float f11 = i11;
        float f12 = this.D + (B[1] * f11);
        if (f12 < r1 + i11) {
            if (I()) {
                float f13 = i12;
                int i13 = this.C;
                this.f29760n0.set(f12 + this.H, f13 - (i13 / 2.0f), this.D + i11 + (i13 / 2.0f), f13 + (i13 / 2.0f));
                t0(canvas, this.f29733a, this.f29760n0, FullCornerDirection.RIGHT);
            } else {
                this.f29733a.setStyle(Paint.Style.STROKE);
                this.f29733a.setStrokeCap(Paint.Cap.ROUND);
                float f14 = i12;
                canvas.drawLine(f12, f14, this.D + i11, f14, this.f29733a);
            }
        }
        int i14 = this.D;
        float f15 = i14 + (B[0] * f11);
        if (f15 > i14) {
            if (!I()) {
                this.f29733a.setStyle(Paint.Style.STROKE);
                this.f29733a.setStrokeCap(Paint.Cap.ROUND);
                float f16 = i12;
                canvas.drawLine(this.D, f16, f15, f16, this.f29733a);
                return;
            }
            RectF rectF = this.f29760n0;
            float f17 = this.D;
            int i15 = this.C;
            float f18 = i12;
            rectF.set(f17 - (i15 / 2.0f), f18 - (i15 / 2.0f), f15 - this.H, f18 + (i15 / 2.0f));
            t0(canvas, this.f29733a, this.f29760n0, FullCornerDirection.LEFT);
        }
    }

    private void u0(int i11) {
        this.f29740d0 = Math.max(i11 - (this.D * 2), 0);
        S();
    }

    private void v(Canvas canvas, int i11, int i12, float f11, Drawable drawable) {
        canvas.save();
        canvas.translate((this.D + ((int) (a0(f11) * i11))) - (drawable.getBounds().width() / 2.0f), i12 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void v0() {
        boolean X = X();
        boolean W = W();
        if (X) {
            requestLayout();
        } else if (W) {
            postInvalidate();
        }
    }

    private void w(Canvas canvas, int i11, int i12) {
        for (int i13 = 0; i13 < this.S.size(); i13++) {
            float floatValue = ((Float) this.S.get(i13)).floatValue();
            Drawable drawable = this.f29766q0;
            if (drawable != null) {
                v(canvas, i11, i12, floatValue, drawable);
            } else if (i13 < this.f29768r0.size()) {
                v(canvas, i11, i12, floatValue, (Drawable) this.f29768r0.get(i13));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.D + (a0(floatValue) * i11), i12, getThumbRadius(), this.f29737c);
                }
                v(canvas, i11, i12, floatValue, this.f29764p0);
            }
        }
    }

    private void w0() {
        if (this.f29746g0) {
            z0();
            A0();
            y0();
            B0();
            x0();
            E0();
            this.f29746g0 = false;
        }
    }

    private void x() {
        if (!this.f29761o) {
            this.f29761o = true;
            ValueAnimator n11 = n(true);
            this.f29763p = n11;
            this.f29765q = null;
            n11.start();
        }
        Iterator it = this.f29755l.iterator();
        for (int i11 = 0; i11 < this.S.size() && it.hasNext(); i11++) {
            if (i11 != this.U) {
                i0((cb.a) it.next(), ((Float) this.S.get(i11)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f29755l.size()), Integer.valueOf(this.S.size())));
        }
        i0((cb.a) it.next(), ((Float) this.S.get(this.U)).floatValue());
    }

    private void x0() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
        }
        float f11 = this.V;
        if (f11 <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.f29772t0 != 1) {
            throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.V)));
        }
        if (minSeparation < f11 || !N(minSeparation)) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.V), Float.valueOf(this.V)));
        }
    }

    private void y() {
        if (this.f29761o) {
            this.f29761o = false;
            ValueAnimator n11 = n(false);
            this.f29765q = n11;
            this.f29763p = null;
            n11.addListener(new b());
            this.f29765q.start();
        }
    }

    private void y0() {
        if (this.V > 0.0f && !C0(this.R)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.V), Float.valueOf(this.Q), Float.valueOf(this.R)));
        }
    }

    private void z(int i11) {
        if (i11 == 1) {
            Y(Integer.MAX_VALUE);
            return;
        }
        if (i11 == 2) {
            Y(Integer.MIN_VALUE);
        } else if (i11 == 17) {
            Z(Integer.MAX_VALUE);
        } else {
            if (i11 != 66) {
                return;
            }
            Z(Integer.MIN_VALUE);
        }
    }

    private void z0() {
        if (this.Q >= this.R) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.Q), Float.valueOf(this.R)));
        }
    }

    final boolean P() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public void addOnChangeListener(com.google.android.material.slider.a aVar) {
        this.f29757m.add(aVar);
    }

    public void addOnSliderTouchListener(com.google.android.material.slider.b bVar) {
        this.f29759n.add(bVar);
    }

    public void clearOnChangeListeners() {
        this.f29757m.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.f29759n.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f29747h.i(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f29733a.setColor(E(this.f29756l0));
        this.f29735b.setColor(E(this.f29754k0));
        this.f29741e.setColor(E(this.f29752j0));
        this.f29743f.setColor(E(this.f29750i0));
        this.f29745g.setColor(E(this.f29754k0));
        for (cb.a aVar : this.f29755l) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.f29764p0.isStateful()) {
            this.f29764p0.setState(getDrawableState());
        }
        this.f29739d.setColor(E(this.f29748h0));
        this.f29739d.setAlpha(63);
    }

    protected boolean e0() {
        if (this.T != -1) {
            return true;
        }
        float H = H();
        float D0 = D0(H);
        this.T = 0;
        float abs = Math.abs(((Float) this.S.get(0)).floatValue() - H);
        for (int i11 = 1; i11 < this.S.size(); i11++) {
            float abs2 = Math.abs(((Float) this.S.get(i11)).floatValue() - H);
            float D02 = D0(((Float) this.S.get(i11)).floatValue());
            if (Float.compare(abs2, abs) > 0) {
                break;
            }
            boolean z10 = !P() ? D02 - D0 >= 0.0f : D02 - D0 <= 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.T = i11;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(D02 - D0) < this.f29767r) {
                        this.T = -1;
                        return false;
                    }
                    if (z10) {
                        this.T = i11;
                    }
                }
            }
            abs = abs2;
        }
        return this.T != -1;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.f29747h.k();
    }

    public int getActiveThumbIndex() {
        return this.T;
    }

    public int getFocusedThumbIndex() {
        return this.U;
    }

    public int getHaloRadius() {
        return this.G;
    }

    public ColorStateList getHaloTintList() {
        return this.f29748h0;
    }

    public int getLabelBehavior() {
        return this.B;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.V;
    }

    public float getThumbElevation() {
        return this.f29764p0.y();
    }

    public int getThumbHeight() {
        return this.F;
    }

    public int getThumbRadius() {
        return this.E / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f29764p0.H();
    }

    public float getThumbStrokeWidth() {
        return this.f29764p0.J();
    }

    public ColorStateList getThumbTintList() {
        return this.f29764p0.z();
    }

    public int getThumbTrackGapSize() {
        return this.H;
    }

    public int getThumbWidth() {
        return this.E;
    }

    public int getTickActiveRadius() {
        return this.f29736b0;
    }

    public ColorStateList getTickActiveTintList() {
        return this.f29750i0;
    }

    public int getTickInactiveRadius() {
        return this.f29738c0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f29752j0;
    }

    public ColorStateList getTickTintList() {
        if (this.f29752j0.equals(this.f29750i0)) {
            return this.f29750i0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.f29754k0;
    }

    public int getTrackHeight() {
        return this.C;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f29756l0;
    }

    public int getTrackInsideCornerSize() {
        return this.L;
    }

    public int getTrackSidePadding() {
        return this.D;
    }

    public int getTrackStopIndicatorSize() {
        return this.K;
    }

    public ColorStateList getTrackTintList() {
        if (this.f29756l0.equals(this.f29754k0)) {
            return this.f29754k0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f29740d0;
    }

    public float getValueFrom() {
        return this.Q;
    }

    public float getValueTo() {
        return this.R;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.S);
    }

    public boolean hasLabelFormatter() {
        return false;
    }

    public boolean isTickVisible() {
        return this.f29734a0;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f29774u0);
        Iterator it = this.f29755l.iterator();
        while (it.hasNext()) {
            i((cb.a) it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender = this.f29751j;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.f29761o = false;
        Iterator it = this.f29755l.iterator();
        while (it.hasNext()) {
            p((cb.a) it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.f29774u0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f29746g0) {
            w0();
            S();
        }
        super.onDraw(canvas);
        int m11 = m();
        float floatValue = ((Float) this.S.get(0)).floatValue();
        ArrayList arrayList = this.S;
        float floatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (floatValue2 < this.R || (this.S.size() > 1 && floatValue > this.Q)) {
            u(canvas, this.f29740d0, m11);
        }
        if (floatValue2 > this.Q) {
            t(canvas, this.f29740d0, m11);
        }
        V(canvas);
        U(canvas, m11);
        if ((this.P || isFocused()) && isEnabled()) {
            T(canvas, this.f29740d0, m11);
        }
        s0();
        w(canvas, this.f29740d0, m11);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i11, Rect rect) {
        super.onFocusChanged(z10, i11, rect);
        if (z10) {
            z(i11);
            this.f29747h.I(this.U);
        } else {
            this.T = -1;
            this.f29747h.b(this.U);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i11, keyEvent);
        }
        if (this.S.size() == 1) {
            this.T = 0;
        }
        if (this.T == -1) {
            Boolean b02 = b0(i11, keyEvent);
            return b02 != null ? b02.booleanValue() : super.onKeyDown(i11, keyEvent);
        }
        this.f29744f0 |= keyEvent.isLongPress();
        Float j11 = j(i11);
        if (j11 != null) {
            if (m0(((Float) this.S.get(this.T)).floatValue() + j11.floatValue())) {
                r0();
                postInvalidate();
            }
            return true;
        }
        if (i11 != 23) {
            if (i11 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return Y(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return Y(-1);
                }
                return false;
            }
            if (i11 != 66) {
                return super.onKeyDown(i11, keyEvent);
            }
        }
        this.T = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        this.f29744f0 = false;
        return super.onKeyUp(i11, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(this.A + ((this.B == 1 || k0()) ? ((cb.a) this.f29755l.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.Q = sliderState.f29780a;
        this.R = sliderState.f29781b;
        j0(sliderState.f29782c);
        this.V = sliderState.f29783d;
        if (sliderState.f29784e) {
            requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f29780a = this.Q;
        sliderState.f29781b = this.R;
        sliderState.f29782c = new ArrayList(this.S);
        sliderState.f29783d = this.V;
        sliderState.f29784e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        u0(i11);
        r0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r2 != 3) goto L56;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i11) {
        d0 k11;
        super.onVisibilityChanged(view, i11);
        if (i11 == 0 || (k11 = f0.k(this)) == null) {
            return;
        }
        Iterator it = this.f29755l.iterator();
        while (it.hasNext()) {
            k11.b((cb.a) it.next());
        }
    }

    void q0(int i11, Rect rect) {
        int a02 = this.D + ((int) (a0(getValues().get(i11).floatValue()) * this.f29740d0));
        int m11 = m();
        int max = Math.max(this.E / 2, this.f29778y / 2);
        int max2 = Math.max(this.F / 2, this.f29778y / 2);
        rect.set(a02 - max, m11 - max2, a02 + max, m11 + max2);
    }

    public void removeOnChangeListener(com.google.android.material.slider.a aVar) {
        this.f29757m.remove(aVar);
    }

    public void removeOnSliderTouchListener(com.google.android.material.slider.b bVar) {
        this.f29759n.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActiveThumbIndex(int i11) {
        this.T = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(int i11) {
        setCustomThumbDrawable(getResources().getDrawable(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(Drawable drawable) {
        this.f29766q0 = J(drawable);
        this.f29768r0.clear();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            drawableArr[i11] = getResources().getDrawable(iArr[i11]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.f29766q0 = null;
        this.f29768r0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.f29768r0.add(J(drawable));
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        setLayerType(z10 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i11) {
        if (i11 < 0 || i11 >= this.S.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.U = i11;
        this.f29747h.I(i11);
        postInvalidate();
    }

    public void setHaloRadius(int i11) {
        if (i11 == this.G) {
            return;
        }
        this.G = i11;
        Drawable background = getBackground();
        if (l0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            com.google.android.material.drawable.d.m((RippleDrawable) background, this.G);
        }
    }

    public void setHaloRadiusResource(int i11) {
        setHaloRadius(getResources().getDimensionPixelSize(i11));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f29748h0)) {
            return;
        }
        this.f29748h0 = colorStateList;
        Drawable background = getBackground();
        if (!l0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f29739d.setColor(E(colorStateList));
        this.f29739d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i11) {
        if (this.B != i11) {
            this.B = i11;
            requestLayout();
        }
    }

    public void setLabelFormatter(com.google.android.material.slider.d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSeparationUnit(int i11) {
        this.f29772t0 = i11;
        this.f29746g0 = true;
        postInvalidate();
    }

    public void setStepSize(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f11), Float.valueOf(this.Q), Float.valueOf(this.R)));
        }
        if (this.V != f11) {
            this.V = f11;
            this.f29746g0 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f11) {
        this.f29764p0.c0(f11);
    }

    public void setThumbElevationResource(int i11) {
        setThumbElevation(getResources().getDimension(i11));
    }

    public void setThumbHeight(int i11) {
        if (i11 == this.F) {
            return;
        }
        this.F = i11;
        this.f29764p0.setBounds(0, 0, this.E, i11);
        Drawable drawable = this.f29766q0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator it = this.f29768r0.iterator();
        while (it.hasNext()) {
            h((Drawable) it.next());
        }
        v0();
    }

    public void setThumbHeightResource(int i11) {
        setThumbHeight(getResources().getDimensionPixelSize(i11));
    }

    public void setThumbRadius(int i11) {
        int i12 = i11 * 2;
        setThumbWidth(i12);
        setThumbHeight(i12);
    }

    public void setThumbRadiusResource(int i11) {
        setThumbRadius(getResources().getDimensionPixelSize(i11));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f29764p0.n0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i11) {
        if (i11 != 0) {
            setThumbStrokeColor(g.a.a(getContext(), i11));
        }
    }

    public void setThumbStrokeWidth(float f11) {
        this.f29764p0.o0(f11);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i11) {
        if (i11 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i11));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f29764p0.z())) {
            return;
        }
        this.f29764p0.d0(colorStateList);
        invalidate();
    }

    public void setThumbTrackGapSize(int i11) {
        if (this.H == i11) {
            return;
        }
        this.H = i11;
        invalidate();
    }

    public void setThumbWidth(int i11) {
        if (i11 == this.E) {
            return;
        }
        this.E = i11;
        this.f29764p0.setShapeAppearanceModel(n.a().q(0, this.E / 2.0f).m());
        this.f29764p0.setBounds(0, 0, this.E, this.F);
        Drawable drawable = this.f29766q0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator it = this.f29768r0.iterator();
        while (it.hasNext()) {
            h((Drawable) it.next());
        }
        v0();
    }

    public void setThumbWidthResource(int i11) {
        setThumbWidth(getResources().getDimensionPixelSize(i11));
    }

    public void setTickActiveRadius(int i11) {
        if (this.f29736b0 != i11) {
            this.f29736b0 = i11;
            this.f29743f.setStrokeWidth(i11 * 2);
            v0();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f29750i0)) {
            return;
        }
        this.f29750i0 = colorStateList;
        this.f29743f.setColor(E(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i11) {
        if (this.f29738c0 != i11) {
            this.f29738c0 = i11;
            this.f29741e.setStrokeWidth(i11 * 2);
            v0();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f29752j0)) {
            return;
        }
        this.f29752j0 = colorStateList;
        this.f29741e.setColor(E(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z10) {
        if (this.f29734a0 != z10) {
            this.f29734a0 = z10;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f29754k0)) {
            return;
        }
        this.f29754k0 = colorStateList;
        this.f29735b.setColor(E(colorStateList));
        this.f29745g.setColor(E(this.f29754k0));
        invalidate();
    }

    public void setTrackHeight(int i11) {
        if (this.C != i11) {
            this.C = i11;
            K();
            v0();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f29756l0)) {
            return;
        }
        this.f29756l0 = colorStateList;
        this.f29733a.setColor(E(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i11) {
        if (this.L == i11) {
            return;
        }
        this.L = i11;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i11) {
        if (this.K == i11) {
            return;
        }
        this.K = i11;
        this.f29745g.setStrokeWidth(i11);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f11) {
        this.Q = f11;
        this.f29746g0 = true;
        postInvalidate();
    }

    public void setValueTo(float f11) {
        this.R = f11;
        this.f29746g0 = true;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull List<Float> list) {
        j0(new ArrayList(list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        j0(arrayList);
    }
}
