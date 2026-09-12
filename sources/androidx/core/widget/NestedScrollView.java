package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R$attr;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollFeedbackProviderCompat;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    private static final float C = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final a D = new a();
    private static final int[] E = {R.attr.fillViewport};
    final d A;
    DifferentialMotionFlingController B;

    /* renamed from: a, reason: collision with root package name */
    private final float f8558a;

    /* renamed from: b, reason: collision with root package name */
    private long f8559b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f8560c;

    /* renamed from: d, reason: collision with root package name */
    private OverScroller f8561d;

    /* renamed from: e, reason: collision with root package name */
    ScrollFeedbackProviderCompat f8562e;

    /* renamed from: f, reason: collision with root package name */
    private int f8563f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8564g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8565h;

    /* renamed from: i, reason: collision with root package name */
    private View f8566i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8567j;

    /* renamed from: k, reason: collision with root package name */
    private VelocityTracker f8568k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8569l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8570m;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;

    /* renamed from: n, reason: collision with root package name */
    private int f8571n;

    /* renamed from: o, reason: collision with root package name */
    private int f8572o;

    /* renamed from: p, reason: collision with root package name */
    private int f8573p;

    /* renamed from: q, reason: collision with root package name */
    private int f8574q;

    /* renamed from: r, reason: collision with root package name */
    private final int[] f8575r;

    /* renamed from: s, reason: collision with root package name */
    private final int[] f8576s;

    /* renamed from: t, reason: collision with root package name */
    private int f8577t;

    /* renamed from: u, reason: collision with root package name */
    private int f8578u;

    /* renamed from: v, reason: collision with root package name */
    private SavedState f8579v;

    /* renamed from: w, reason: collision with root package name */
    private final NestedScrollingParentHelper f8580w;

    /* renamed from: x, reason: collision with root package name */
    private final NestedScrollingChildHelper f8581x;

    /* renamed from: y, reason: collision with root package name */
    private float f8582y;

    /* renamed from: z, reason: collision with root package name */
    private e f8583z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int scrollPosition;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.scrollPosition);
        }
    }

    /* loaded from: classes.dex */
    static class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (super.performAccessibilityAction(view, i11, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i11 != 4096) {
                if (i11 == 8192 || i11 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.I(0, max, true);
                    return true;
                }
                if (i11 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.I(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        public static void a(View view, float f11) {
            try {
                view.setFrameContentVelocity(f11);
            } catch (LinkageError unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements DifferentialMotionFlingTarget {
        d() {
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float f11) {
            if (f11 == 0.0f) {
                return false;
            }
            stopDifferentialMotionFling();
            NestedScrollView.this.fling((int) f11);
            return true;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.this.f8561d.abortAnimation();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f8560c = new Rect();
        this.f8564g = true;
        this.f8565h = false;
        this.f8566i = null;
        this.f8567j = false;
        this.f8570m = true;
        this.f8574q = -1;
        this.f8575r = new int[2];
        this.f8576s = new int[2];
        d dVar = new d();
        this.A = dVar;
        this.B = new DifferentialMotionFlingController(getContext(), dVar);
        this.mEdgeGlowTop = h.a(context, attributeSet);
        this.mEdgeGlowBottom = h.a(context, attributeSet);
        this.f8558a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        o();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E, i11, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f8580w = new NestedScrollingParentHelper(this);
        this.f8581x = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, D);
    }

    private boolean A(int i11, int i12, int i13) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i14 = height + scrollY;
        boolean z10 = false;
        boolean z11 = i11 == 33;
        View k11 = k(z11, i12, i13);
        if (k11 == null) {
            k11 = this;
        }
        if (i12 < scrollY || i13 > i14) {
            B(z11 ? i12 - scrollY : i13 - i14, 0, 1, true);
            z10 = true;
        }
        if (k11 != findFocus()) {
            k11.requestFocus(i11);
        }
        return z10;
    }

    private int B(int i11, int i12, int i13, boolean z10) {
        return C(i11, -1, null, i12, i13, z10);
    }

    private void D(View view) {
        view.getDrawingRect(this.f8560c);
        offsetDescendantRectToMyCoords(view, this.f8560c);
        int f11 = f(this.f8560c);
        if (f11 != 0) {
            scrollBy(0, f11);
        }
    }

    private boolean E(Rect rect, boolean z10) {
        int f11 = f(rect);
        boolean z11 = f11 != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, f11);
            } else {
                smoothScrollBy(0, f11);
            }
        }
        return z11;
    }

    private boolean F(EdgeEffect edgeEffect, int i11) {
        if (i11 > 0) {
            return true;
        }
        return l(-i11) < h.b(edgeEffect) * ((float) getHeight());
    }

    private void G(int i11, int i12, int i13, boolean z10) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f8559b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f8561d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i12 + scrollY, Math.max(0, height - height2))) - scrollY, i13);
            z(z10);
        } else {
            if (!this.f8561d.isFinished()) {
                a();
            }
            scrollBy(i11, i12);
        }
        this.f8559b = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean J(MotionEvent motionEvent) {
        boolean z10;
        if (h.b(this.mEdgeGlowTop) != 0.0f) {
            h.d(this.mEdgeGlowTop, 0.0f, motionEvent.getX() / getWidth());
            z10 = true;
        } else {
            z10 = false;
        }
        if (h.b(this.mEdgeGlowBottom) == 0.0f) {
            return z10;
        }
        h.d(this.mEdgeGlowBottom, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void a() {
        this.f8561d.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int e(int i11, int i12, int i13) {
        if (i12 >= i13 || i11 < 0) {
            return 0;
        }
        return i12 + i11 > i13 ? i13 - i12 : i11;
    }

    private ScrollFeedbackProviderCompat getScrollFeedbackProvider() {
        if (this.f8562e == null) {
            this.f8562e = ScrollFeedbackProviderCompat.createProvider(this);
        }
        return this.f8562e;
    }

    private void h(int i11) {
        if (i11 != 0) {
            if (this.f8570m) {
                smoothScrollBy(0, i11);
            } else {
                scrollBy(0, i11);
            }
        }
    }

    private boolean i(int i11) {
        if (h.b(this.mEdgeGlowTop) != 0.0f) {
            if (F(this.mEdgeGlowTop, i11)) {
                this.mEdgeGlowTop.onAbsorb(i11);
            } else {
                fling(-i11);
            }
        } else {
            if (h.b(this.mEdgeGlowBottom) == 0.0f) {
                return false;
            }
            int i12 = -i11;
            if (F(this.mEdgeGlowBottom, i12)) {
                this.mEdgeGlowBottom.onAbsorb(i12);
            } else {
                fling(i12);
            }
        }
        return true;
    }

    private void j() {
        this.f8574q = -1;
        this.f8567j = false;
        x();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View k(boolean z10, int i11, int i12) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z11 = false;
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = focusables.get(i13);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i11 < bottom && top < i12) {
                boolean z12 = i11 < top && bottom < i12;
                if (view == null) {
                    view = view2;
                    z11 = z12;
                } else {
                    boolean z13 = (z10 && top < view.getTop()) || (!z10 && bottom > view.getBottom());
                    if (z11) {
                        if (z12) {
                            if (!z13) {
                            }
                            view = view2;
                        }
                    } else if (z12) {
                        view = view2;
                        z11 = true;
                    } else {
                        if (!z13) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private float l(int i11) {
        double log = Math.log((Math.abs(i11) * 0.35f) / (this.f8558a * 0.015f));
        float f11 = C;
        return (float) (this.f8558a * 0.015f * Math.exp((f11 / (f11 - 1.0d)) * log));
    }

    private boolean m(int i11, int i12) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i12 >= childAt.getTop() - scrollY && i12 < childAt.getBottom() - scrollY && i11 >= childAt.getLeft() && i11 < childAt.getRight();
    }

    private void n() {
        VelocityTracker velocityTracker = this.f8568k;
        if (velocityTracker == null) {
            this.f8568k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void o() {
        this.f8561d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f8571n = viewConfiguration.getScaledTouchSlop();
        this.f8572o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8573p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void p() {
        if (this.f8568k == null) {
            this.f8568k = VelocityTracker.obtain();
        }
    }

    private void q(int i11, int i12) {
        this.f8563f = i11;
        this.f8574q = i12;
        startNestedScroll(2, 0);
    }

    private boolean r(View view) {
        return !t(view, 0, getHeight());
    }

    private static boolean s(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && s((View) parent, view2);
    }

    private boolean t(View view, int i11, int i12) {
        view.getDrawingRect(this.f8560c);
        offsetDescendantRectToMyCoords(view, this.f8560c);
        return this.f8560c.bottom + i11 >= getScrollY() && this.f8560c.top - i11 <= getScrollY() + i12;
    }

    private void u(int i11, int i12, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i11);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f8581x.dispatchNestedScroll(0, scrollY2, 0, i11 - scrollY2, null, i12, iArr);
    }

    private void v(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f8574q) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.f8563f = (int) motionEvent.getY(i11);
            this.f8574q = motionEvent.getPointerId(i11);
            VelocityTracker velocityTracker = this.f8568k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void x() {
        VelocityTracker velocityTracker = this.f8568k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8568k = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int y(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r0 = androidx.core.widget.h.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r4 = -r4
            float r4 = androidx.core.widget.h.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            float r5 = androidx.core.widget.h.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            float r0 = androidx.core.widget.h.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.h.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            float r5 = androidx.core.widget.h.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L63
            r3.invalidate()
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.y(int, float):int");
    }

    private void z(boolean z10) {
        if (z10) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.f8578u = getScrollY();
        postInvalidateOnAnimation();
    }

    int C(int i11, int i12, MotionEvent motionEvent, int i13, int i14, boolean z10) {
        int i15;
        int i16;
        VelocityTracker velocityTracker;
        if (i14 == 1) {
            startNestedScroll(2, i14);
        }
        boolean z11 = false;
        if (dispatchNestedPreScroll(0, i11, this.f8576s, this.f8575r, i14)) {
            i15 = i11 - this.f8576s[1];
            i16 = this.f8575r[1];
        } else {
            i15 = i11;
            i16 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z12 = c() && !z10;
        boolean z13 = w(0, i15, 0, scrollY, 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(i14);
        int scrollY2 = getScrollY() - scrollY;
        if (motionEvent != null && scrollY2 != 0) {
            getScrollFeedbackProvider().onScrollProgress(motionEvent.getDeviceId(), motionEvent.getSource(), i12, scrollY2);
        }
        int[] iArr = this.f8576s;
        iArr[1] = 0;
        dispatchNestedScroll(0, scrollY2, 0, i15 - scrollY2, this.f8575r, i14, iArr);
        int i17 = i16 + this.f8575r[1];
        int i18 = i15 - this.f8576s[1];
        int i19 = scrollY + i18;
        if (i19 < 0) {
            if (z12) {
                h.d(this.mEdgeGlowTop, (-i18) / getHeight(), i13 / getWidth());
                if (motionEvent != null) {
                    getScrollFeedbackProvider().onScrollLimit(motionEvent.getDeviceId(), motionEvent.getSource(), i12, true);
                }
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (i19 > scrollRange && z12) {
            h.d(this.mEdgeGlowBottom, i18 / getHeight(), 1.0f - (i13 / getWidth()));
            if (motionEvent != null) {
                getScrollFeedbackProvider().onScrollLimit(motionEvent.getDeviceId(), motionEvent.getSource(), i12, false);
            }
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (this.mEdgeGlowTop.isFinished() && this.mEdgeGlowBottom.isFinished()) {
            z11 = z13;
        } else {
            postInvalidateOnAnimation();
        }
        if (z11 && i14 == 0 && (velocityTracker = this.f8568k) != null) {
            velocityTracker.clear();
        }
        if (i14 == 1) {
            stopNestedScroll(i14);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return i17;
    }

    void H(int i11, int i12, int i13, boolean z10) {
        G(i11 - getScrollX(), i12 - getScrollY(), i13, z10);
    }

    void I(int i11, int i12, boolean z10) {
        H(i11, i12, 250, z10);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i11);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public boolean arrowScroll(int i11) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i11);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !t(findNextFocus, maxScrollAmount, getHeight())) {
            if (i11 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i11 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i11 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            B(maxScrollAmount, 0, 1, true);
        } else {
            findNextFocus.getDrawingRect(this.f8560c);
            offsetDescendantRectToMyCoords(findNextFocus, this.f8560c);
            B(f(this.f8560c), 0, 1, true);
            findNextFocus.requestFocus(i11);
        }
        if (findFocus != null && findFocus.isFocused() && r(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f8561d.isFinished()) {
            return;
        }
        this.f8561d.computeScrollOffset();
        int currY = this.f8561d.getCurrY();
        int g11 = g(currY - this.f8578u);
        this.f8578u = currY;
        int[] iArr = this.f8576s;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, g11, iArr, null, 1);
        int i11 = g11 - this.f8576s[1];
        int scrollRange = getScrollRange();
        if (Build.VERSION.SDK_INT >= 35) {
            c.a(this, Math.abs(this.f8561d.getCurrVelocity()));
        }
        if (i11 != 0) {
            int scrollY = getScrollY();
            w(0, i11, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i12 = i11 - scrollY2;
            int[] iArr2 = this.f8576s;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i12, this.f8575r, 1, iArr2);
            i11 = i12 - this.f8576s[1];
        }
        if (i11 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i11 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.f8561d.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.f8561d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f8561d.isFinished()) {
            stopNestedScroll(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f11, float f12, boolean z10) {
        return this.f8581x.dispatchNestedFling(f11, f12, z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.f8581x.dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i11, i12, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return this.f8581x.dispatchNestedPreScroll(i11, i12, iArr, iArr2, i13);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15, int[] iArr2) {
        this.f8581x.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return this.f8581x.dispatchNestedScroll(i11, i12, i13, i14, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return this.f8581x.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i11;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i12 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i11 = getPaddingLeft();
            } else {
                i11 = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(i11, min);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        if (this.mEdgeGlowBottom.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            i12 = getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            max -= getPaddingBottom();
        }
        canvas.translate(i12 - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        this.mEdgeGlowBottom.setSize(width2, height2);
        if (this.mEdgeGlowBottom.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(save2);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.f8560c.setEmpty();
        if (!d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return keyEvent.isAltPressed() ? fullScroll(33) : arrowScroll(33);
        }
        if (keyCode == 20) {
            return keyEvent.isAltPressed() ? fullScroll(130) : arrowScroll(130);
        }
        if (keyCode == 62) {
            pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
            return false;
        }
        if (keyCode == 92) {
            return fullScroll(33);
        }
        if (keyCode == 93) {
            return fullScroll(130);
        }
        if (keyCode == 122) {
            pageScroll(33);
            return false;
        }
        if (keyCode != 123) {
            return false;
        }
        pageScroll(130);
        return false;
    }

    protected int f(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i11 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i12 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i11 - verticalFadingEdgeLength : i11;
        int i13 = rect.bottom;
        if (i13 > i12 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i12, (childAt.getBottom() + layoutParams.bottomMargin) - i11);
        }
        if (rect.top >= scrollY || i13 >= i12) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i12 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public void fling(int i11) {
        if (getChildCount() > 0) {
            this.f8561d.fling(getScrollX(), getScrollY(), 0, i11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            z(true);
            if (Build.VERSION.SDK_INT >= 35) {
                c.a(this, Math.abs(this.f8561d.getCurrVelocity()));
            }
        }
    }

    public boolean fullScroll(int i11) {
        int childCount;
        boolean z10 = i11 == 130;
        int height = getHeight();
        Rect rect = this.f8560c;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f8560c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f8560c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f8560c;
        return A(i11, rect3.top, rect3.bottom);
    }

    int g(int i11) {
        int height = getHeight();
        if (i11 > 0 && h.b(this.mEdgeGlowTop) != 0.0f) {
            int round = Math.round(((-height) / 4.0f) * h.d(this.mEdgeGlowTop, ((-i11) * 4.0f) / height, 0.5f));
            if (round != i11) {
                this.mEdgeGlowTop.finish();
            }
            return i11 - round;
        }
        if (i11 >= 0 || h.b(this.mEdgeGlowBottom) == 0.0f) {
            return i11;
        }
        float f11 = height;
        int round2 = Math.round((f11 / 4.0f) * h.d(this.mEdgeGlowBottom, (i11 * 4.0f) / f11, 0.5f));
        if (round2 != i11) {
            this.mEdgeGlowBottom.finish();
        }
        return i11 - round2;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f8580w.getNestedScrollAxes();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    float getVerticalScrollFactorCompat() {
        if (this.f8582y == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f8582y = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f8582y;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i11) {
        return this.f8581x.hasNestedScrollingParent(i11);
    }

    public boolean isFillViewport() {
        return this.f8569l;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f8581x.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.f8570m;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i11, int i12) {
        view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8565h = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i11;
        int i12;
        float f11;
        if (motionEvent.getAction() == 8 && !this.f8567j) {
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                i11 = 9;
                f11 = motionEvent.getAxisValue(9);
                i12 = (int) motionEvent.getX();
            } else if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                float axisValue = motionEvent.getAxisValue(26);
                i12 = getWidth() / 2;
                i11 = 26;
                f11 = axisValue;
            } else {
                i11 = 0;
                i12 = 0;
                f11 = 0.0f;
            }
            if (f11 != 0.0f) {
                C(-((int) (f11 * getVerticalScrollFactorCompat())), i11, motionEvent, i12, 1, MotionEventCompat.isFromSource(motionEvent, InputDeviceCompat.SOURCE_MOUSE));
                if (i11 == 0) {
                    return true;
                }
                this.B.onMotionEvent(motionEvent, i11);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action == 2 && this.f8567j) {
            return true;
        }
        int i11 = action & 255;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    int i12 = this.f8574q;
                    if (i12 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i12);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i12 + " in onInterceptTouchEvent");
                        } else {
                            int y10 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y10 - this.f8563f) > this.f8571n && (2 & getNestedScrollAxes()) == 0) {
                                this.f8567j = true;
                                this.f8563f = y10;
                                p();
                                this.f8568k.addMovement(motionEvent);
                                this.f8577t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i11 != 3) {
                    if (i11 == 6) {
                        v(motionEvent);
                    }
                }
            }
            this.f8567j = false;
            this.f8574q = -1;
            x();
            if (this.f8561d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else {
            int y11 = (int) motionEvent.getY();
            if (m((int) motionEvent.getX(), y11)) {
                this.f8563f = y11;
                this.f8574q = motionEvent.getPointerId(0);
                n();
                this.f8568k.addMovement(motionEvent);
                this.f8561d.computeScrollOffset();
                if (!J(motionEvent) && this.f8561d.isFinished()) {
                    z10 = false;
                }
                this.f8567j = z10;
                startNestedScroll(2, 0);
            } else {
                if (!J(motionEvent) && this.f8561d.isFinished()) {
                    z10 = false;
                }
                this.f8567j = z10;
                x();
            }
        }
        return this.f8567j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        int i15 = 0;
        this.f8564g = false;
        View view = this.f8566i;
        if (view != null && s(view, this)) {
            D(this.f8566i);
        }
        this.f8566i = null;
        if (!this.f8565h) {
            if (this.f8579v != null) {
                scrollTo(getScrollX(), this.f8579v.scrollPosition);
                this.f8579v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i15 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i14 - i12) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e11 = e(scrollY, paddingTop, i15);
            if (e11 != scrollY) {
                scrollTo(getScrollX(), e11);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f8565h = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f8569l && View.MeasureSpec.getMode(i12) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f12, true);
        fling((int) f12);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        return dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        onNestedPreScroll(view, i11, i12, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        dispatchNestedPreScroll(i11, i12, iArr, null, i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        u(i14, 0, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        u(i14, i15, null);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        u(i14, i15, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i11) {
        onNestedScrollAccepted(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        this.f8580w.onNestedScrollAccepted(view, view2, i11, i12);
        startNestedScroll(2, i12);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i11, int i12, boolean z10, boolean z11) {
        super.scrollTo(i11, i12);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i11, Rect rect) {
        if (i11 == 2) {
            i11 = 130;
        } else if (i11 == 1) {
            i11 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i11) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i11);
        if (findNextFocus == null || r(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i11, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8579v = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        e eVar = this.f8583z;
        if (eVar != null) {
            eVar.a(this, i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !t(findFocus, 0, i14)) {
            return;
        }
        findFocus.getDrawingRect(this.f8560c);
        offsetDescendantRectToMyCoords(findFocus, this.f8560c);
        h(f(this.f8560c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return onStartNestedScroll(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        return (i11 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        this.f8580w.onStopNestedScroll(view, i11);
        stopNestedScroll(i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        p();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8577t = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f8577t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f8568k;
                velocityTracker.computeCurrentVelocity(1000, this.f8573p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f8574q);
                if (Math.abs(yVelocity) >= this.f8572o) {
                    if (!i(yVelocity)) {
                        int i11 = -yVelocity;
                        float f11 = i11;
                        if (!dispatchNestedPreFling(0.0f, f11)) {
                            dispatchNestedFling(0.0f, f11, true);
                            fling(i11);
                        }
                    }
                } else if (this.f8561d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                j();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f8574q);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f8574q + " in onTouchEvent");
                } else {
                    int y10 = (int) motionEvent.getY(findPointerIndex);
                    int i12 = this.f8563f - y10;
                    int y11 = i12 - y(i12, motionEvent.getX(findPointerIndex));
                    if (!this.f8567j && Math.abs(y11) > this.f8571n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f8567j = true;
                        y11 = y11 > 0 ? y11 - this.f8571n : y11 + this.f8571n;
                    }
                    int i13 = y11;
                    if (this.f8567j) {
                        int C2 = C(i13, 1, motionEvent, (int) motionEvent.getX(findPointerIndex), 0, false);
                        this.f8563f = y10 - C2;
                        this.f8577t += C2;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f8567j && getChildCount() > 0 && this.f8561d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                j();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f8563f = (int) motionEvent.getY(actionIndex);
                this.f8574q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                v(motionEvent);
                this.f8563f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f8574q));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f8567j && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f8561d.isFinished()) {
                a();
            }
            q((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f8568k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public boolean pageScroll(int i11) {
        boolean z10 = i11 == 130;
        int height = getHeight();
        if (z10) {
            this.f8560c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f8560c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f8560c.top = getScrollY() - height;
            Rect rect2 = this.f8560c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f8560c;
        int i12 = rect3.top;
        int i13 = height + i12;
        rect3.bottom = i13;
        return A(i11, i12, i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f8564g) {
            this.f8566i = view2;
        } else {
            D(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return E(rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            x();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f8564g = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i11, int i12) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int e11 = e(i11, width, width2);
            int e12 = e(i12, height, height2);
            if (e11 == getScrollX() && e12 == getScrollY()) {
                return;
            }
            super.scrollTo(e11, e12);
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f8569l) {
            this.f8569l = z10;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        this.f8581x.setNestedScrollingEnabled(z10);
    }

    public void setOnScrollChangeListener(e eVar) {
        this.f8583z = eVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f8570m = z10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i11, int i12) {
        G(i11, i12, 250, false);
    }

    public final void smoothScrollBy(int i11, int i12, int i13) {
        G(i11, i12, i13, false);
    }

    public final void smoothScrollTo(int i11, int i12) {
        H(i11, i12, 250, false);
    }

    public final void smoothScrollTo(int i11, int i12, int i13) {
        H(i11, i12, i13, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i11) {
        return startNestedScroll(i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i11, int i12) {
        return this.f8581x.startNestedScroll(i11, i12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i11) {
        this.f8581x.stopNestedScroll(i11);
    }

    boolean w(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z10) {
        boolean z11;
        boolean z12;
        int overScrollMode = getOverScrollMode();
        boolean z13 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z14 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z15 = overScrollMode == 0 || (overScrollMode == 1 && z13);
        boolean z16 = overScrollMode == 0 || (overScrollMode == 1 && z14);
        int i19 = i13 + i11;
        int i20 = !z15 ? 0 : i17;
        int i21 = i14 + i12;
        int i22 = !z16 ? 0 : i18;
        int i23 = -i20;
        int i24 = i20 + i15;
        int i25 = -i22;
        int i26 = i22 + i16;
        if (i19 > i24) {
            i19 = i24;
            z11 = true;
        } else if (i19 < i23) {
            z11 = true;
            i19 = i23;
        } else {
            z11 = false;
        }
        if (i21 > i26) {
            i21 = i26;
            z12 = true;
        } else if (i21 < i25) {
            z12 = true;
            i21 = i25;
        } else {
            z12 = false;
        }
        if (z12 && !hasNestedScrollingParent(1)) {
            this.f8561d.springBack(i19, i21, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i19, i21, z11, z12);
        return z11 || z12;
    }
}
