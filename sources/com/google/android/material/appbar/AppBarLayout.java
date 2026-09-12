package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: z, reason: collision with root package name */
    private static final int f28226z = R$style.Widget_Design_AppBarLayout;

    /* renamed from: a, reason: collision with root package name */
    private int f28227a;

    /* renamed from: b, reason: collision with root package name */
    private int f28228b;

    /* renamed from: c, reason: collision with root package name */
    private int f28229c;

    /* renamed from: d, reason: collision with root package name */
    private int f28230d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f28231e;

    /* renamed from: f, reason: collision with root package name */
    private int f28232f;

    /* renamed from: g, reason: collision with root package name */
    private WindowInsetsCompat f28233g;

    /* renamed from: h, reason: collision with root package name */
    private List f28234h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f28235i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f28236j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f28237k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f28238l;

    /* renamed from: m, reason: collision with root package name */
    private int f28239m;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference f28240n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f28241o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f28242p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f28243q;

    /* renamed from: r, reason: collision with root package name */
    private final List f28244r;

    /* renamed from: s, reason: collision with root package name */
    private final long f28245s;

    /* renamed from: t, reason: collision with root package name */
    private final TimeInterpolator f28246t;

    /* renamed from: u, reason: collision with root package name */
    private int[] f28247u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f28248v;

    /* renamed from: w, reason: collision with root package name */
    private Integer f28249w;

    /* renamed from: x, reason: collision with root package name */
    private final float f28250x;

    /* renamed from: y, reason: collision with root package name */
    private Behavior f28251y;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior {

        /* renamed from: k, reason: collision with root package name */
        private int f28252k;

        /* renamed from: l, reason: collision with root package name */
        private int f28253l;

        /* renamed from: m, reason: collision with root package name */
        private ValueAnimator f28254m;

        /* renamed from: n, reason: collision with root package name */
        private SavedState f28255n;

        /* renamed from: o, reason: collision with root package name */
        private WeakReference f28256o;

        /* renamed from: p, reason: collision with root package name */
        private c f28257p;

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes4.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            /* loaded from: classes4.dex */
            class a implements Parcelable.ClassLoaderCreator {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i11) {
                    return new SavedState[i11];
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i11) {
                super.writeToParcel(parcel, i11);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f28258a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f28259b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f28258a = coordinatorLayout;
                this.f28259b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f28258a, this.f28259b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class b extends AccessibilityDelegateCompat {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f28261a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f28262b;

            b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.f28261a = appBarLayout;
                this.f28262b = coordinatorLayout;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                View f02;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                if (this.f28261a.getTotalScrollRange() == 0 || (f02 = BaseBehavior.this.f0(this.f28262b)) == null || !BaseBehavior.this.b0(this.f28261a)) {
                    return;
                }
                if (BaseBehavior.this.M() != (-this.f28261a.getTotalScrollRange())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.setScrollable(true);
                }
                if (BaseBehavior.this.M() != 0) {
                    if (!f02.canScrollVertically(-1)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                    } else if ((-this.f28261a.getDownNestedPreScrollRange()) != 0) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                    }
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
                if (i11 == 4096) {
                    this.f28261a.setExpanded(false);
                    return true;
                }
                if (i11 != 8192) {
                    return super.performAccessibilityAction(view, i11, bundle);
                }
                if (BaseBehavior.this.M() != 0) {
                    View f02 = BaseBehavior.this.f0(this.f28262b);
                    if (!f02.canScrollVertically(-1)) {
                        this.f28261a.setExpanded(true);
                        return true;
                    }
                    int i12 = -this.f28261a.getDownNestedPreScrollRange();
                    if (i12 != 0) {
                        BaseBehavior.this.q(this.f28262b, this.f28261a, f02, 0, i12, new int[]{0, 0}, 1);
                        return true;
                    }
                }
                return false;
            }
        }

        /* loaded from: classes4.dex */
        public static abstract class c {
            public abstract boolean a(AppBarLayout appBarLayout);
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private void U(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            if (ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout, new b(appBarLayout, coordinatorLayout));
        }

        private void V(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11, float f11) {
            int abs = Math.abs(M() - i11);
            float abs2 = Math.abs(f11);
            W(coordinatorLayout, appBarLayout, i11, abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        private void W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11, int i12) {
            int M = M();
            if (M == i11) {
                ValueAnimator valueAnimator = this.f28254m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f28254m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f28254m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f28254m = valueAnimator3;
                valueAnimator3.setInterpolator(oa.a.f71045e);
                this.f28254m.addUpdateListener(new a(coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f28254m.setDuration(Math.min(i12, 600));
            this.f28254m.setIntValues(M, i11);
            this.f28254m.start();
        }

        private int X(int i11, int i12, int i13) {
            return i11 < (i12 + i13) / 2 ? i12 : i13;
        }

        private boolean Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            return appBarLayout.j() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        }

        private static boolean a0(int i11, int i12) {
            return (i11 & i12) == i12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (((e) appBarLayout.getChildAt(i11).getLayoutParams()).f28267a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View c0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View d0(AppBarLayout appBarLayout, int i11) {
            int abs = Math.abs(i11);
            int childCount = appBarLayout.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = appBarLayout.getChildAt(i12);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int e0(AppBarLayout appBarLayout, int i11) {
            int childCount = appBarLayout.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = appBarLayout.getChildAt(i12);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (a0(eVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i13 = -i11;
                if (top <= i13 && bottom >= i13) {
                    return i12;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View f0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int i0(AppBarLayout appBarLayout, int i11) {
            int abs = Math.abs(i11);
            int childCount = appBarLayout.getChildCount();
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                }
                View childAt = appBarLayout.getChildAt(i13);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator d11 = eVar.d();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i13++;
                } else if (d11 != null) {
                    int c11 = eVar.c();
                    if ((c11 & 1) != 0) {
                        i12 = childAt.getHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                        if ((c11 & 2) != 0) {
                            i12 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        i12 -= appBarLayout.getTopInset();
                    }
                    if (i12 > 0) {
                        float f11 = i12;
                        return Integer.signum(i11) * (childAt.getTop() + Math.round(f11 * d11.getInterpolation((abs - childAt.getTop()) / f11)));
                    }
                }
            }
            return i11;
        }

        private boolean w0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List<View> dependents = coordinatorLayout.getDependents(appBarLayout);
            int size = dependents.size();
            for (int i11 = 0; i11 < size; i11++) {
                CoordinatorLayout.c f11 = ((CoordinatorLayout.f) dependents.get(i11).getLayoutParams()).f();
                if (f11 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) f11).K() != 0;
                }
            }
            return false;
        }

        private void x0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topInset = appBarLayout.getTopInset() + appBarLayout.getPaddingTop();
            int M = M() - topInset;
            int e02 = e0(appBarLayout, M);
            if (e02 >= 0) {
                View childAt = appBarLayout.getChildAt(e02);
                e eVar = (e) childAt.getLayoutParams();
                int c11 = eVar.c();
                if ((c11 & 17) == 17) {
                    int i11 = -childAt.getTop();
                    int i12 = -childAt.getBottom();
                    if (e02 == 0 && ViewCompat.getFitsSystemWindows(appBarLayout) && ViewCompat.getFitsSystemWindows(childAt)) {
                        i11 -= appBarLayout.getTopInset();
                    }
                    if (a0(c11, 2)) {
                        i12 += ViewCompat.getMinimumHeight(childAt);
                    } else if (a0(c11, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i12;
                        if (M < minimumHeight) {
                            i11 = minimumHeight;
                        } else {
                            i12 = minimumHeight;
                        }
                    }
                    if (a0(c11, 32)) {
                        i11 += ((LinearLayout.LayoutParams) eVar).topMargin;
                        i12 -= ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    }
                    V(coordinatorLayout, appBarLayout, d1.a.b(X(M, i12, i11) + topInset, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void y0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11, int i12, boolean z10) {
            View d02 = d0(appBarLayout, i11);
            boolean z11 = false;
            if (d02 != null) {
                int c11 = ((e) d02.getLayoutParams()).c();
                if ((c11 & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(d02);
                    if (i12 <= 0 || (c11 & 12) == 0 ? !((c11 & 2) == 0 || (-i11) < (d02.getBottom() - minimumHeight) - appBarLayout.getTopInset()) : (-i11) >= (d02.getBottom() - minimumHeight) - appBarLayout.getTopInset()) {
                        z11 = true;
                    }
                }
            }
            if (appBarLayout.isLiftOnScroll()) {
                z11 = appBarLayout.y(c0(coordinatorLayout));
            }
            boolean v11 = appBarLayout.v(z11);
            if (z10 || (v11 && w0(coordinatorLayout, appBarLayout))) {
                if (appBarLayout.getBackground() != null) {
                    appBarLayout.getBackground().jumpToCurrentState();
                }
                if (appBarLayout.getForeground() != null) {
                    appBarLayout.getForeground().jumpToCurrentState();
                }
                if (appBarLayout.getStateListAnimator() != null) {
                    appBarLayout.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int M() {
            return E() + this.f28252k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: Y, reason: merged with bridge method [inline-methods] */
        public boolean H(AppBarLayout appBarLayout) {
            c cVar = this.f28257p;
            if (cVar != null) {
                return cVar.a(appBarLayout);
            }
            WeakReference weakReference = this.f28256o;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: g0, reason: merged with bridge method [inline-methods] */
        public int K(AppBarLayout appBarLayout) {
            return (-appBarLayout.getDownNestedScrollRange()) + appBarLayout.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: h0, reason: merged with bridge method [inline-methods] */
        public int L(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            x0(coordinatorLayout, appBarLayout);
            if (appBarLayout.isLiftOnScroll()) {
                appBarLayout.v(appBarLayout.y(c0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.i, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11) {
            boolean l11 = super.l(coordinatorLayout, appBarLayout, i11);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.f28255n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i12 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z10) {
                            V(coordinatorLayout, appBarLayout, i12, 0.0f);
                        } else {
                            P(coordinatorLayout, appBarLayout, i12);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            V(coordinatorLayout, appBarLayout, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.fullyScrolled) {
                P(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.fullyExpanded) {
                P(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.firstVisibleChildIndex);
                P(coordinatorLayout, appBarLayout, (-childAt.getBottom()) + (this.f28255n.firstVisibleChildAtMinimumHeight ? ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset() : Math.round(childAt.getHeight() * this.f28255n.firstVisibleChildPercentageShown)));
            }
            appBarLayout.s();
            this.f28255n = null;
            G(d1.a.b(E(), -appBarLayout.getTotalScrollRange(), 0));
            y0(coordinatorLayout, appBarLayout, E(), 0, true);
            appBarLayout.q(E());
            U(coordinatorLayout, appBarLayout);
            return l11;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11, int i12, int i13, int i14) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, appBarLayout, i11, i12, i13, i14);
            }
            coordinatorLayout.onMeasureChild(appBarLayout, i11, i12, View.MeasureSpec.makeMeasureSpec(0, 0), i14);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
            int i14;
            int i15;
            if (i12 != 0) {
                if (i12 < 0) {
                    i14 = -appBarLayout.getTotalScrollRange();
                    i15 = appBarLayout.getDownNestedPreScrollRange() + i14;
                } else {
                    i14 = -appBarLayout.getUpNestedPreScrollRange();
                    i15 = 0;
                }
                int i16 = i14;
                int i17 = i15;
                if (i16 != i17) {
                    iArr[1] = O(coordinatorLayout, appBarLayout, i12, i16, i17);
                }
            }
            if (appBarLayout.isLiftOnScroll()) {
                appBarLayout.v(appBarLayout.y(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            if (i14 < 0) {
                iArr[1] = O(coordinatorLayout, appBarLayout, i14, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i14 == 0) {
                U(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                s0((SavedState) parcelable, true);
                super.x(coordinatorLayout, appBarLayout, this.f28255n.getSuperState());
            } else {
                super.x(coordinatorLayout, appBarLayout, parcelable);
                this.f28255n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable y10 = super.y(coordinatorLayout, appBarLayout);
            SavedState t02 = t0(y10, appBarLayout);
            return t02 == null ? y10 : t02;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i11, int i12) {
            ValueAnimator valueAnimator;
            boolean z10 = (i11 & 2) != 0 && (appBarLayout.isLiftOnScroll() || Z(coordinatorLayout, appBarLayout, view));
            if (z10 && (valueAnimator = this.f28254m) != null) {
                valueAnimator.cancel();
            }
            this.f28256o = null;
            this.f28253l = i12;
            return z10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11) {
            if (this.f28253l == 0 || i11 == 1) {
                x0(coordinatorLayout, appBarLayout);
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.v(appBarLayout.y(view));
                }
            }
            this.f28256o = new WeakReference(view);
        }

        void s0(SavedState savedState, boolean z10) {
            if (this.f28255n == null || z10) {
                this.f28255n = savedState;
            }
        }

        SavedState t0(Parcelable parcelable, AppBarLayout appBarLayout) {
            int E = E();
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z10 = E == 0;
                    savedState.fullyExpanded = z10;
                    savedState.fullyScrolled = !z10 && (-E) >= appBarLayout.getTotalScrollRange();
                    savedState.firstVisibleChildIndex = i11;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public void u0(c cVar) {
            this.f28257p = cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: v0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11, int i12, int i13) {
            int M = M();
            int i14 = 0;
            if (i12 == 0 || M < i12 || M > i13) {
                this.f28252k = 0;
            } else {
                int b11 = d1.a.b(i11, i12, i13);
                if (M != b11) {
                    int i02 = appBarLayout.h() ? i0(appBarLayout, b11) : b11;
                    boolean G = G(i02);
                    int i15 = M - b11;
                    this.f28252k = b11 - i02;
                    if (G) {
                        while (i14 < appBarLayout.getChildCount()) {
                            e eVar = (e) appBarLayout.getChildAt(i14).getLayoutParams();
                            c b12 = eVar.b();
                            if (b12 != null && (eVar.c() & 1) != 0) {
                                b12.a(appBarLayout, appBarLayout.getChildAt(i14), E());
                            }
                            i14++;
                        }
                    }
                    if (!G && appBarLayout.h()) {
                        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                    }
                    appBarLayout.q(E());
                    y0(coordinatorLayout, appBarLayout, b11, b11 < M ? -1 : 1, false);
                    i14 = i15;
                }
            }
            U(coordinatorLayout, appBarLayout);
            return i14;
        }
    }

    /* loaded from: classes4.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* loaded from: classes4.dex */
        public static abstract class a extends BaseBehavior.c {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.D(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.i
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.i
        public /* bridge */ /* synthetic */ boolean G(int i11) {
            return super.G(i11);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.k(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: k0 */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11) {
            return super.l(coordinatorLayout, appBarLayout, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: l0 */
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11, int i12, int i13, int i14) {
            return super.m(coordinatorLayout, appBarLayout, i11, i12, i13, i14);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: m0 */
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
            super.q(coordinatorLayout, appBarLayout, view, i11, i12, iArr, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: n0 */
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i11, i12, i13, i14, i15, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: o0 */
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: p0 */
        public /* bridge */ /* synthetic */ Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i11, int i12) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i11, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: r0 */
        public /* bridge */ /* synthetic */ void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11) {
            super.C(coordinatorLayout, appBarLayout, view, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void u0(BaseBehavior.c cVar) {
            super.u0(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class ScrollingViewBehavior extends h {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            O(obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f11 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f11 instanceof BaseBehavior) {
                return ((BaseBehavior) f11).M();
            }
            return 0;
        }

        private void S(View view, View view2) {
            CoordinatorLayout.c f11 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f11 instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f11).f28252k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.v(appBarLayout.y(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.h
        float J(View view) {
            int i11;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int R = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + R > downNestedPreScrollRange) && (i11 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (R / i11) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.h
        int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.h
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List list) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = (View) list.get(i11);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.i, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i11) {
            return super.l(coordinatorLayout, view, i11);
        }

        @Override // com.google.android.material.appbar.h, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13, int i14) {
            return super.m(coordinatorLayout, view, i11, i12, i13, i14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout H = H(coordinatorLayout.getDependencies(view));
            if (H != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.f28319d;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    H.setExpanded(false, !z10);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return AppBarLayout.this.r(windowInsetsCompat);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onOffsetChanged(AppBarLayout appBarLayout, int i11);
    }

    /* loaded from: classes4.dex */
    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f11);
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f28265a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private final Rect f28266b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, View view, float f11) {
            b(this.f28265a, appBarLayout, view);
            float abs = this.f28265a.top - Math.abs(f11);
            if (abs > 0.0f) {
                ViewCompat.setClipBounds(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float a11 = 1.0f - d1.a.a(Math.abs(abs / this.f28265a.height()), 0.0f, 1.0f);
            float height = (-abs) - ((this.f28265a.height() * 0.3f) * (1.0f - (a11 * a11)));
            view.setTranslationY(height);
            view.getDrawingRect(this.f28266b);
            this.f28266b.offset(0, (int) (-height));
            if (height >= this.f28266b.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            ViewCompat.setClipBounds(view, this.f28266b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f28267a;

        /* renamed from: b, reason: collision with root package name */
        private c f28268b;

        /* renamed from: c, reason: collision with root package name */
        Interpolator f28269c;

        public e(int i11, int i12) {
            super(i11, i12);
            this.f28267a = 1;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f28267a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.f28267a = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            if (obtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f28269c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f28267a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f28267a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f28267a = 1;
        }

        private c a(int i11) {
            if (i11 != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.f28268b;
        }

        public int c() {
            return this.f28267a;
        }

        public Interpolator d() {
            return this.f28269c;
        }

        boolean e() {
            int i11 = this.f28267a;
            return (i11 & 1) == 1 && (i11 & 10) != 0;
        }

        public void f(int i11) {
            this.f28268b = a(i11);
        }

        public void g(int i11) {
            this.f28267a = i11;
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
    }

    /* loaded from: classes4.dex */
    public interface g extends b {
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void A(float f11, float f12) {
        ValueAnimator valueAnimator = this.f28242p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f11, f12);
        this.f28242p = ofFloat;
        ofFloat.setDuration(this.f28245s);
        this.f28242p.setInterpolator(this.f28246t);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f28243q;
        if (animatorUpdateListener != null) {
            this.f28242p.addUpdateListener(animatorUpdateListener);
        }
        this.f28242p.start();
    }

    private void B() {
        setWillNotDraw(!x());
    }

    private void c() {
        WeakReference weakReference = this.f28240n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f28240n = null;
    }

    private Integer d() {
        Drawable drawable = this.f28248v;
        if (drawable instanceof ab.i) {
            return Integer.valueOf(((ab.i) drawable).C());
        }
        ColorStateList g11 = com.google.android.material.drawable.d.g(drawable);
        if (g11 != null) {
            return Integer.valueOf(g11.getDefaultColor());
        }
        return null;
    }

    private View e(View view) {
        int i11;
        if (this.f28240n == null && (i11 = this.f28239m) != -1) {
            View findViewById = view != null ? view.findViewById(i11) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f28239m);
            }
            if (findViewById != null) {
                this.f28240n = new WeakReference(findViewById);
            }
        }
        WeakReference weakReference = this.f28240n;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private boolean i() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((e) getChildAt(i11).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void k(final ab.i iVar, final ColorStateList colorStateList, final ColorStateList colorStateList2) {
        final Integer f11 = com.google.android.material.color.b.f(getContext(), R$attr.colorSurface);
        this.f28243q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.this.o(colorStateList, colorStateList2, iVar, f11, valueAnimator);
            }
        };
        ViewCompat.setBackground(this, iVar);
    }

    private void l(Context context, final ab.i iVar) {
        iVar.S(context);
        this.f28243q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.this.p(iVar, valueAnimator);
            }
        };
        ViewCompat.setBackground(this, iVar);
    }

    private void m() {
        Behavior behavior = this.f28251y;
        BaseBehavior.SavedState t02 = (behavior == null || this.f28228b == -1 || this.f28232f != 0) ? null : behavior.t0(AbsSavedState.EMPTY_STATE, this);
        this.f28228b = -1;
        this.f28229c = -1;
        this.f28230d = -1;
        if (t02 != null) {
            this.f28251y.s0(t02, false);
        }
    }

    private boolean n() {
        return getBackground() instanceof ab.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ColorStateList colorStateList, ColorStateList colorStateList2, ab.i iVar, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        int j11 = com.google.android.material.color.b.j(colorStateList.getDefaultColor(), colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        iVar.d0(ColorStateList.valueOf(j11));
        if (this.f28248v != null && (num2 = this.f28249w) != null && num2.equals(num)) {
            a1.a.n(this.f28248v, j11);
        }
        if (this.f28244r.isEmpty()) {
            return;
        }
        Iterator it = this.f28244r.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            if (iVar.z() != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(ab.i iVar, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        iVar.c0(floatValue);
        Drawable drawable = this.f28248v;
        if (drawable instanceof ab.i) {
            ((ab.i) drawable).c0(floatValue);
        }
        Iterator it = this.f28244r.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            iVar.C();
            throw null;
        }
    }

    private void t(boolean z10, boolean z11, boolean z12) {
        this.f28232f = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    private boolean u(boolean z10) {
        if (this.f28236j == z10) {
            return false;
        }
        this.f28236j = z10;
        refreshDrawableState();
        return true;
    }

    private boolean x() {
        return this.f28248v != null && getTopInset() > 0;
    }

    private boolean z() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
    }

    public void addLiftOnScrollListener(@NonNull f fVar) {
        this.f28244r.add(fVar);
    }

    public void addOnOffsetChangedListener(@Nullable b bVar) {
        if (this.f28234h == null) {
            this.f28234h = new ArrayList();
        }
        if (bVar == null || this.f28234h.contains(bVar)) {
            return;
        }
        this.f28234h.add(bVar);
    }

    public void addOnOffsetChangedListener(g gVar) {
        addOnOffsetChangedListener((b) gVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public void clearLiftOnScrollListener() {
        this.f28244r.clear();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (x()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f28227a);
            this.f28248v.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f28248v;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new e((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public CoordinatorLayout.c getBehavior() {
        Behavior behavior = new Behavior();
        this.f28251y = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int i11;
        int minimumHeight;
        int i12 = this.f28229c;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i14 = eVar.f28267a;
                if ((i14 & 5) != 5) {
                    if (i13 > 0) {
                        break;
                    }
                } else {
                    int i15 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    if ((i14 & 8) != 0) {
                        minimumHeight = ViewCompat.getMinimumHeight(childAt);
                    } else if ((i14 & 2) != 0) {
                        minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                    } else {
                        i11 = i15 + measuredHeight;
                        if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                            i11 = Math.min(i11, measuredHeight - getTopInset());
                        }
                        i13 += i11;
                    }
                    i11 = i15 + minimumHeight;
                    if (childCount == 0) {
                        i11 = Math.min(i11, measuredHeight - getTopInset());
                    }
                    i13 += i11;
                }
            }
        }
        int max = Math.max(0, i13);
        this.f28229c = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i11 = this.f28230d;
        if (i11 != -1) {
            return i11;
        }
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                int i14 = eVar.f28267a;
                if ((i14 & 1) == 0) {
                    break;
                }
                i13 += measuredHeight;
                if ((i14 & 2) != 0) {
                    i13 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
            i12++;
        }
        int max = Math.max(0, i13);
        this.f28230d = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f28239m;
    }

    @Nullable
    public ab.i getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof ab.i) {
            return (ab.i) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    int getPendingAction() {
        return this.f28232f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f28248v;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f28233g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i11 = this.f28228b;
        if (i11 != -1) {
            return i11;
        }
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i14 = eVar.f28267a;
                if ((i14 & 1) == 0) {
                    break;
                }
                i13 += measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                if (i12 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                    i13 -= getTopInset();
                }
                if ((i14 & 2) != 0) {
                    i13 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
            i12++;
        }
        int max = Math.max(0, i13);
        this.f28228b = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean h() {
        return this.f28231e;
    }

    public boolean isLiftOnScroll() {
        return this.f28238l;
    }

    public boolean isLifted() {
        return this.f28237k;
    }

    boolean j() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ab.j.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i11) {
        if (this.f28247u == null) {
            this.f28247u = new int[4];
        }
        int[] iArr = this.f28247u;
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + iArr.length);
        boolean z10 = this.f28236j;
        int i12 = R$attr.state_liftable;
        if (!z10) {
            i12 = -i12;
        }
        iArr[0] = i12;
        iArr[1] = (z10 && this.f28237k) ? R$attr.state_lifted : -R$attr.state_lifted;
        int i13 = R$attr.state_collapsible;
        if (!z10) {
            i13 = -i13;
        }
        iArr[2] = i13;
        iArr[3] = (z10 && this.f28237k) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        boolean z11 = true;
        if (ViewCompat.getFitsSystemWindows(this) && z()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        m();
        this.f28231e = false;
        int childCount2 = getChildCount();
        int i15 = 0;
        while (true) {
            if (i15 >= childCount2) {
                break;
            }
            if (((e) getChildAt(i15).getLayoutParams()).d() != null) {
                this.f28231e = true;
                break;
            }
            i15++;
        }
        Drawable drawable = this.f28248v;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f28235i) {
            return;
        }
        if (!this.f28238l && !i()) {
            z11 = false;
        }
        u(z11);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && z()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = d1.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i12));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        m();
    }

    void q(int i11) {
        this.f28227a = i11;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List list = this.f28234h;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                b bVar = (b) this.f28234h.get(i12);
                if (bVar != null) {
                    bVar.onOffsetChanged(this, i11);
                }
            }
        }
    }

    WindowInsetsCompat r(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!androidx.core.util.d.a(this.f28233g, windowInsetsCompat2)) {
            this.f28233g = windowInsetsCompat2;
            B();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public boolean removeLiftOnScrollListener(@NonNull f fVar) {
        return this.f28244r.remove(fVar);
    }

    public void removeOnOffsetChangedListener(@Nullable b bVar) {
        List list = this.f28234h;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void removeOnOffsetChangedListener(g gVar) {
        removeOnOffsetChangedListener((b) gVar);
    }

    void s() {
        this.f28232f = 0;
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        ab.j.d(this, f11);
    }

    public void setExpanded(boolean z10) {
        setExpanded(z10, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean z10, boolean z11) {
        t(z10, z11, true);
    }

    public void setLiftOnScroll(boolean z10) {
        this.f28238l = z10;
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.f28239m = -1;
        if (view == null) {
            c();
        } else {
            this.f28240n = new WeakReference(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i11) {
        this.f28239m = i11;
        c();
    }

    public boolean setLiftable(boolean z10) {
        this.f28235i = true;
        return u(z10);
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f28235i = z10;
    }

    public boolean setLifted(boolean z10) {
        return w(z10, true);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i11) {
        if (i11 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i11);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f28248v;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f28248v = drawable != null ? drawable.mutate() : null;
            this.f28249w = d();
            Drawable drawable3 = this.f28248v;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f28248v.setState(getDrawableState());
                }
                a1.a.m(this.f28248v, ViewCompat.getLayoutDirection(this));
                this.f28248v.setVisible(getVisibility() == 0, false);
                this.f28248v.setCallback(this);
            }
            B();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(int i11) {
        setStatusBarForeground(new ColorDrawable(i11));
    }

    public void setStatusBarForegroundResource(int i11) {
        setStatusBarForeground(g.a.b(getContext(), i11));
    }

    @Deprecated
    public void setTargetElevation(float f11) {
        k.b(this, f11);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z10 = i11 == 0;
        Drawable drawable = this.f28248v;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    boolean v(boolean z10) {
        return w(z10, !this.f28235i);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f28248v;
    }

    boolean w(boolean z10, boolean z11) {
        if (!z11 || this.f28237k == z10) {
            return false;
        }
        this.f28237k = z10;
        refreshDrawableState();
        if (!n()) {
            return true;
        }
        if (this.f28241o) {
            A(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f28238l) {
            return true;
        }
        A(z10 ? 0.0f : this.f28250x, z10 ? this.f28250x : 0.0f);
        return true;
    }

    boolean y(View view) {
        View e11 = e(view);
        if (e11 != null) {
            view = e11;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }
}
