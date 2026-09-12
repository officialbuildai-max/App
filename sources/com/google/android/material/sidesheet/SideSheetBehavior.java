package com.google.android.material.sidesheet;

import ab.n;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c implements wa.b {

    /* renamed from: a, reason: collision with root package name */
    private d f29686a;

    /* renamed from: b, reason: collision with root package name */
    private float f29687b;

    /* renamed from: c, reason: collision with root package name */
    private ab.i f29688c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f29689d;

    /* renamed from: e, reason: collision with root package name */
    private n f29690e;

    /* renamed from: f, reason: collision with root package name */
    private final c f29691f;

    /* renamed from: g, reason: collision with root package name */
    private float f29692g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f29693h;

    /* renamed from: i, reason: collision with root package name */
    private int f29694i;

    /* renamed from: j, reason: collision with root package name */
    private int f29695j;

    /* renamed from: k, reason: collision with root package name */
    private ViewDragHelper f29696k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f29697l;

    /* renamed from: m, reason: collision with root package name */
    private float f29698m;

    /* renamed from: n, reason: collision with root package name */
    private int f29699n;

    /* renamed from: o, reason: collision with root package name */
    private int f29700o;

    /* renamed from: p, reason: collision with root package name */
    private int f29701p;

    /* renamed from: q, reason: collision with root package name */
    private int f29702q;

    /* renamed from: r, reason: collision with root package name */
    private WeakReference f29703r;

    /* renamed from: s, reason: collision with root package name */
    private WeakReference f29704s;

    /* renamed from: t, reason: collision with root package name */
    private int f29705t;

    /* renamed from: u, reason: collision with root package name */
    private VelocityTracker f29706u;

    /* renamed from: v, reason: collision with root package name */
    private wa.i f29707v;

    /* renamed from: w, reason: collision with root package name */
    private int f29708w;

    /* renamed from: x, reason: collision with root package name */
    private final Set f29709x;

    /* renamed from: y, reason: collision with root package name */
    private final ViewDragHelper.b f29710y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f29685z = R$string.side_sheet_accessibility_pane_title;
    private static final int A = R$style.Widget_Material3_SideSheet;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int state;

        /* loaded from: classes4.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = ((SideSheetBehavior) sideSheetBehavior).f29694i;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.state);
        }
    }

    /* loaded from: classes4.dex */
    class a extends ViewDragHelper.b {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            return d1.a.b(i11, SideSheetBehavior.this.f29686a.g(), SideSheetBehavior.this.f29686a.f());
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int getViewHorizontalDragRange(View view) {
            return SideSheetBehavior.this.f29699n + SideSheetBehavior.this.g0();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewDragStateChanged(int i11) {
            if (i11 == 1 && SideSheetBehavior.this.f29693h) {
                SideSheetBehavior.this.F0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View b02 = SideSheetBehavior.this.b0();
            if (b02 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) b02.getLayoutParams()) != null) {
                SideSheetBehavior.this.f29686a.p(marginLayoutParams, view.getLeft(), view.getRight());
                b02.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.W(view, i11);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewReleased(View view, float f11, float f12) {
            int S = SideSheetBehavior.this.S(view, f11, f12);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.K0(view, S, sideSheetBehavior.J0());
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean tryCaptureView(View view, int i11) {
            return (SideSheetBehavior.this.f29694i == 1 || SideSheetBehavior.this.f29703r == null || SideSheetBehavior.this.f29703r.get() != view) ? false : true;
        }
    }

    /* loaded from: classes4.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.F0(5);
            if (SideSheetBehavior.this.f29703r == null || SideSheetBehavior.this.f29703r.get() == null) {
                return;
            }
            ((View) SideSheetBehavior.this.f29703r.get()).requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private int f29713a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f29714b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f29715c = new Runnable() { // from class: com.google.android.material.sidesheet.i
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.c.this.c();
            }
        };

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f29714b = false;
            if (SideSheetBehavior.this.f29696k != null && SideSheetBehavior.this.f29696k.continueSettling(true)) {
                b(this.f29713a);
            } else if (SideSheetBehavior.this.f29694i == 2) {
                SideSheetBehavior.this.F0(this.f29713a);
            }
        }

        void b(int i11) {
            if (SideSheetBehavior.this.f29703r == null || SideSheetBehavior.this.f29703r.get() == null) {
                return;
            }
            this.f29713a = i11;
            if (this.f29714b) {
                return;
            }
            ViewCompat.postOnAnimation((View) SideSheetBehavior.this.f29703r.get(), this.f29715c);
            this.f29714b = true;
        }
    }

    public SideSheetBehavior() {
        this.f29691f = new c();
        this.f29693h = true;
        this.f29694i = 5;
        this.f29695j = 5;
        this.f29698m = 0.1f;
        this.f29705t = -1;
        this.f29709x = new LinkedHashSet();
        this.f29710y = new a();
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29691f = new c();
        this.f29693h = true;
        this.f29694i = 5;
        this.f29695j = 5;
        this.f29698m = 0.1f;
        this.f29705t = -1;
        this.f29709x = new LinkedHashSet();
        this.f29710y = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SideSheetBehavior_Layout);
        if (obtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_backgroundTint)) {
            this.f29689d = xa.c.a(context, obtainStyledAttributes, R$styleable.SideSheetBehavior_Layout_backgroundTint);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f29690e = n.e(context, attributeSet, 0, A).m();
        }
        if (obtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_coplanarSiblingViewId)) {
            A0(obtainStyledAttributes.getResourceId(R$styleable.SideSheetBehavior_Layout_coplanarSiblingViewId, -1));
        }
        V(context);
        this.f29692g = obtainStyledAttributes.getDimension(R$styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        B0(obtainStyledAttributes.getBoolean(R$styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        obtainStyledAttributes.recycle();
        this.f29687b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void C0(int i11) {
        d dVar = this.f29686a;
        if (dVar == null || dVar.j() != i11) {
            if (i11 == 0) {
                this.f29686a = new com.google.android.material.sidesheet.b(this);
                if (this.f29690e == null || o0()) {
                    return;
                }
                n.b v11 = this.f29690e.v();
                v11.M(0.0f).B(0.0f);
                N0(v11.m());
                return;
            }
            if (i11 == 1) {
                this.f29686a = new com.google.android.material.sidesheet.a(this);
                if (this.f29690e == null || n0()) {
                    return;
                }
                n.b v12 = this.f29690e.v();
                v12.H(0.0f).w(0.0f);
                N0(v12.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i11 + ". Must be 0 or 1.");
        }
    }

    private void D0(View view, int i11) {
        C0(GravityCompat.getAbsoluteGravity(((CoordinatorLayout.f) view.getLayoutParams()).f7984c, i11) == 3 ? 1 : 0);
    }

    private boolean G0() {
        return this.f29696k != null && (this.f29693h || this.f29694i == 1);
    }

    private boolean I0(View view) {
        return (view.isShown() || ViewCompat.getAccessibilityPaneTitle(view) != null) && this.f29693h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(View view, int i11, boolean z10) {
        if (!s0(view, i11, z10)) {
            F0(i11);
        } else {
            F0(2);
            this.f29691f.b(i11);
        }
    }

    private void L0() {
        View view;
        WeakReference weakReference = this.f29703r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (this.f29694i != 5) {
            x0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        if (this.f29694i != 3) {
            x0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void M0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference weakReference = this.f29703r;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.f29703r.get();
        View b02 = b0();
        if (b02 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) b02.getLayoutParams()) == null) {
            return;
        }
        this.f29686a.o(marginLayoutParams, (int) ((this.f29699n * view.getScaleX()) + this.f29702q));
        b02.requestLayout();
    }

    private void N0(n nVar) {
        ab.i iVar = this.f29688c;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
    }

    private void O0(View view) {
        int i11 = this.f29694i == 5 ? 4 : 0;
        if (view.getVisibility() != i11) {
            view.setVisibility(i11);
        }
    }

    private int Q(int i11, View view) {
        int i12 = this.f29694i;
        if (i12 == 1 || i12 == 2) {
            return i11 - this.f29686a.h(view);
        }
        if (i12 == 3) {
            return 0;
        }
        if (i12 == 5) {
            return this.f29686a.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.f29694i);
    }

    private float R(float f11, float f12) {
        return Math.abs(f11 - f12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int S(View view, float f11, float f12) {
        if (q0(f11)) {
            return 3;
        }
        if (H0(view, f11)) {
            if (!this.f29686a.m(f11, f12) && !this.f29686a.l(view)) {
                return 3;
            }
        } else if (f11 == 0.0f || !e.a(f11, f12)) {
            int left = view.getLeft();
            if (Math.abs(left - c0()) < Math.abs(left - this.f29686a.e())) {
                return 3;
            }
        }
        return 5;
    }

    private void T() {
        WeakReference weakReference = this.f29704s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f29704s = null;
    }

    private AccessibilityViewCommand U(final int i11) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.f
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                boolean t02;
                t02 = SideSheetBehavior.this.t0(i11, view, commandArguments);
                return t02;
            }
        };
    }

    private void V(Context context) {
        if (this.f29690e == null) {
            return;
        }
        ab.i iVar = new ab.i(this.f29690e);
        this.f29688c = iVar;
        iVar.S(context);
        ColorStateList colorStateList = this.f29689d;
        if (colorStateList != null) {
            this.f29688c.d0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f29688c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(View view, int i11) {
        if (this.f29709x.isEmpty()) {
            return;
        }
        float b11 = this.f29686a.b(i11);
        Iterator it = this.f29709x.iterator();
        while (it.hasNext()) {
            ((com.google.android.material.sidesheet.c) it.next()).b(view, b11);
        }
    }

    private void X(View view) {
        if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
            ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(f29685z));
        }
    }

    private int Y(int i11, int i12, int i13, int i14) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, i12, i14);
        if (i13 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i13), 1073741824);
        }
        if (size != 0) {
            i13 = Math.min(size, i13);
        }
        return View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
    }

    private ValueAnimator.AnimatorUpdateListener a0() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View b02 = b0();
        if (b02 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) b02.getLayoutParams()) == null) {
            return null;
        }
        final int c11 = this.f29686a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SideSheetBehavior.this.u0(marginLayoutParams, c11, b02, valueAnimator);
            }
        };
    }

    private int d0() {
        d dVar = this.f29686a;
        return (dVar == null || dVar.j() == 0) ? 5 : 3;
    }

    private CoordinatorLayout.f m0() {
        View view;
        WeakReference weakReference = this.f29703r;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) view.getLayoutParams();
    }

    private boolean n0() {
        CoordinatorLayout.f m02 = m0();
        return m02 != null && ((ViewGroup.MarginLayoutParams) m02).leftMargin > 0;
    }

    private boolean o0() {
        CoordinatorLayout.f m02 = m0();
        return m02 != null && ((ViewGroup.MarginLayoutParams) m02).rightMargin > 0;
    }

    private boolean p0(MotionEvent motionEvent) {
        return G0() && R((float) this.f29708w, motionEvent.getX()) > ((float) this.f29696k.getTouchSlop());
    }

    private boolean q0(float f11) {
        return this.f29686a.k(f11);
    }

    private boolean r0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(view);
    }

    private boolean s0(View view, int i11, boolean z10) {
        int h02 = h0(i11);
        ViewDragHelper l02 = l0();
        return l02 != null && (!z10 ? !l02.smoothSlideViewTo(view, h02, view.getTop()) : !l02.settleCapturedViewAt(h02, view.getTop()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean t0(int i11, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        E0(i11);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, View view, ValueAnimator valueAnimator) {
        this.f29686a.o(marginLayoutParams, oa.a.c(i11, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(int i11) {
        View view = (View) this.f29703r.get();
        if (view != null) {
            K0(view, i11, false);
        }
    }

    private void w0(CoordinatorLayout coordinatorLayout) {
        int i11;
        View findViewById;
        if (this.f29704s != null || (i11 = this.f29705t) == -1 || (findViewById = coordinatorLayout.findViewById(i11)) == null) {
            return;
        }
        this.f29704s = new WeakReference(findViewById);
    }

    private void x0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i11) {
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, U(i11));
    }

    private void y0() {
        VelocityTracker velocityTracker = this.f29706u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f29706u = null;
        }
    }

    private void z0(View view, Runnable runnable) {
        if (r0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void A0(int i11) {
        this.f29705t = i11;
        T();
        WeakReference weakReference = this.f29703r;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i11 == -1 || !ViewCompat.isLaidOut(view)) {
                return;
            }
            view.requestLayout();
        }
    }

    public void B0(boolean z10) {
        this.f29693h = z10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f29694i == 1 && actionMasked == 0) {
            return true;
        }
        if (G0()) {
            this.f29696k.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            y0();
        }
        if (this.f29706u == null) {
            this.f29706u = VelocityTracker.obtain();
        }
        this.f29706u.addMovement(motionEvent);
        if (G0() && actionMasked == 2 && !this.f29697l && p0(motionEvent)) {
            this.f29696k.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f29697l;
    }

    public void E0(final int i11) {
        if (i11 == 1 || i11 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i11 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        WeakReference weakReference = this.f29703r;
        if (weakReference == null || weakReference.get() == null) {
            F0(i11);
        } else {
            z0((View) this.f29703r.get(), new Runnable() { // from class: com.google.android.material.sidesheet.g
                @Override // java.lang.Runnable
                public final void run() {
                    SideSheetBehavior.this.v0(i11);
                }
            });
        }
    }

    void F0(int i11) {
        View view;
        if (this.f29694i == i11) {
            return;
        }
        this.f29694i = i11;
        if (i11 == 3 || i11 == 5) {
            this.f29695j = i11;
        }
        WeakReference weakReference = this.f29703r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        O0(view);
        Iterator it = this.f29709x.iterator();
        while (it.hasNext()) {
            ((com.google.android.material.sidesheet.c) it.next()).a(view, i11);
        }
        L0();
    }

    boolean H0(View view, float f11) {
        return this.f29686a.n(view, f11);
    }

    public boolean J0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Z() {
        return this.f29699n;
    }

    public View b0() {
        WeakReference weakReference = this.f29704s;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public int c0() {
        return this.f29686a.d();
    }

    @Override // wa.b
    public void cancelBackProgress() {
        wa.i iVar = this.f29707v;
        if (iVar == null) {
            return;
        }
        iVar.f();
    }

    public float e0() {
        return this.f29698m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f0() {
        return 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.f29703r = null;
        this.f29696k = null;
        this.f29707v = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g0() {
        return this.f29702q;
    }

    int h0(int i11) {
        if (i11 == 3) {
            return c0();
        }
        if (i11 == 5) {
            return this.f29686a.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i11);
    }

    @Override // wa.b
    public void handleBackInvoked() {
        wa.i iVar = this.f29707v;
        if (iVar == null) {
            return;
        }
        androidx.activity.b c11 = iVar.c();
        if (c11 == null || Build.VERSION.SDK_INT < 34) {
            E0(5);
        } else {
            this.f29707v.h(c11, d0(), new b(), a0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i0() {
        return this.f29701p;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.f29703r = null;
        this.f29696k = null;
        this.f29707v = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j0() {
        return this.f29700o;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!I0(view)) {
            this.f29697l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            y0();
        }
        if (this.f29706u == null) {
            this.f29706u = VelocityTracker.obtain();
        }
        this.f29706u.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f29708w = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f29697l) {
            this.f29697l = false;
            return false;
        }
        return (this.f29697l || (viewDragHelper = this.f29696k) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k0() {
        return 500;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i11) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f29703r == null) {
            this.f29703r = new WeakReference(view);
            this.f29707v = new wa.i(view);
            ab.i iVar = this.f29688c;
            if (iVar != null) {
                ViewCompat.setBackground(view, iVar);
                ab.i iVar2 = this.f29688c;
                float f11 = this.f29692g;
                if (f11 == -1.0f) {
                    f11 = ViewCompat.getElevation(view);
                }
                iVar2.c0(f11);
            } else {
                ColorStateList colorStateList = this.f29689d;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            O0(view);
            L0();
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
            X(view);
        }
        D0(view, i11);
        if (this.f29696k == null) {
            this.f29696k = ViewDragHelper.create(coordinatorLayout, this.f29710y);
        }
        int h11 = this.f29686a.h(view);
        coordinatorLayout.onLayoutChild(view, i11);
        this.f29700o = coordinatorLayout.getWidth();
        this.f29701p = this.f29686a.i(coordinatorLayout);
        this.f29699n = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f29702q = marginLayoutParams != null ? this.f29686a.a(marginLayoutParams) : 0;
        ViewCompat.offsetLeftAndRight(view, Q(h11, view));
        w0(coordinatorLayout);
        for (com.google.android.material.sidesheet.c cVar : this.f29709x) {
            if (cVar instanceof j) {
                ((j) cVar).c(view);
            }
        }
        return true;
    }

    ViewDragHelper l0() {
        return this.f29696k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(Y(i11, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, -1, marginLayoutParams.width), Y(i13, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, -1, marginLayoutParams.height));
        return true;
    }

    @Override // wa.b
    public void startBackProgress(androidx.activity.b bVar) {
        wa.i iVar = this.f29707v;
        if (iVar == null) {
            return;
        }
        iVar.j(bVar);
    }

    @Override // wa.b
    public void updateBackProgress(androidx.activity.b bVar) {
        wa.i iVar = this.f29707v;
        if (iVar == null) {
            return;
        }
        iVar.l(bVar, d0());
        M0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.x(coordinatorLayout, view, savedState.getSuperState());
        }
        int i11 = savedState.state;
        if (i11 == 1 || i11 == 2) {
            i11 = 5;
        }
        this.f29694i = i11;
        this.f29695j = i11;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.y(coordinatorLayout, view), (SideSheetBehavior<?>) this);
    }
}
