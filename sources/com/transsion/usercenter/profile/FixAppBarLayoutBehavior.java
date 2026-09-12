package com.transsion.usercenter.profile;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.usercenter.R$id;

/* loaded from: classes6.dex */
public class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private View A;
    private d B;
    private int C;
    private int D;
    private boolean E;
    private VelocityTracker F;
    private int G;
    private RecyclerView H;

    /* renamed from: q, reason: collision with root package name */
    private boolean f57164q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f57165r;

    /* renamed from: s, reason: collision with root package name */
    private float f57166s;

    /* renamed from: t, reason: collision with root package name */
    private float f57167t;

    /* renamed from: u, reason: collision with root package name */
    private int f57168u;

    /* renamed from: v, reason: collision with root package name */
    private int f57169v;

    /* renamed from: w, reason: collision with root package name */
    private int f57170w;

    /* renamed from: x, reason: collision with root package name */
    private int[] f57171x;

    /* renamed from: y, reason: collision with root package name */
    private View f57172y;

    /* renamed from: z, reason: collision with root package name */
    private ViewPager2 f57173z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends AppBarLayout.Behavior.a {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.c
        public boolean a(AppBarLayout appBarLayout) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            View childAt = FixAppBarLayoutBehavior.this.f57173z.getChildAt(i11);
            if (childAt != null) {
                FixAppBarLayoutBehavior.this.F0(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FixAppBarLayoutBehavior.this.f57165r = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(float f11, boolean z10);
    }

    public FixAppBarLayoutBehavior() {
        this.f57165r = false;
        this.f57171x = null;
        this.C = -1;
        this.D = -1;
        this.E = false;
        R0();
    }

    public FixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57165r = false;
        this.f57171x = null;
        this.C = -1;
        this.D = -1;
        this.E = false;
        R0();
    }

    private void D0() {
        ViewPager2 viewPager2 = this.f57173z;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new b());
        }
    }

    private boolean E0() {
        RecyclerView.m layoutManager;
        RecyclerView recyclerView = this.H;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return true;
        }
        View findViewByPosition = layoutManager.findViewByPosition(0);
        return findViewByPosition != null && findViewByPosition.getTop() >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt instanceof RecyclerView) {
                    this.H = (RecyclerView) childAt;
                }
            }
        }
    }

    private boolean H0() {
        return this.f57172y != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(AppBarLayout appBarLayout, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f57172y.setScaleX(floatValue);
        this.f57172y.setScaleY(floatValue);
        O0(appBarLayout, (int) ((1.0f - valueAnimator.getAnimatedFraction()) * this.f57168u));
        if (this.B != null) {
            this.B.a(Math.min((floatValue - 1.0f) / 0.3f, 1.0f), true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0 != 3) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean M0(com.google.android.material.appbar.AppBarLayout r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getActionMasked()
            int r1 = r6.D
            if (r1 >= 0) goto L16
            android.content.Context r1 = r7.getContext()
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r1)
            int r1 = r1.getScaledTouchSlop()
            r6.D = r1
        L16:
            r1 = 1056964608(0x3f000000, float:0.5)
            r2 = 0
            if (r0 == 0) goto Lbc
            r3 = 1
            if (r0 == r3) goto L87
            r4 = 2
            if (r0 == r4) goto L26
            r7 = 3
            if (r0 == r7) goto Lac
            goto Ld4
        L26:
            int r0 = r6.C
            int r0 = r8.findPointerIndex(r0)
            if (r0 >= 0) goto L4f
            lg.a$a r7 = lg.a.f68962a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.C
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FixAppBarLayoutBehavior"
            r7.i(r1, r0, r2)
            goto Ld4
        L4f:
            float r0 = r8.getY(r0)
            float r0 = r0 + r1
            int r0 = (int) r0
            int r1 = r6.G
            int r1 = r1 - r0
            boolean r4 = r6.E
            if (r4 != 0) goto L6b
            int r4 = java.lang.Math.abs(r1)
            int r5 = r6.D
            if (r4 <= r5) goto L6b
            r6.E = r3
            if (r1 <= 0) goto L6a
            int r1 = r1 - r5
            goto L6b
        L6a:
            int r1 = r1 + r5
        L6b:
            boolean r3 = r6.E
            if (r3 == 0) goto Ld4
            r6.G = r0
            boolean r0 = r6.G0(r0)
            if (r0 == 0) goto L7c
            boolean r7 = r6.Q0(r7, r7, r1)
            return r7
        L7c:
            boolean r0 = r6.E0()
            if (r0 == 0) goto Ld4
            boolean r7 = r6.Q0(r7, r7, r1)
            return r7
        L87:
            android.view.VelocityTracker r0 = r6.F
            if (r0 == 0) goto L9e
            r0.addMovement(r8)
            android.view.VelocityTracker r0 = r6.F
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r1)
            android.view.VelocityTracker r0 = r6.F
            int r1 = r6.C
            float r0 = r0.getYVelocity(r1)
            goto L9f
        L9e:
            r0 = 0
        L9f:
            r1 = 1120403456(0x42c80000, float:100.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto La6
            goto La7
        La6:
            r3 = r2
        La7:
            r6.f57164q = r3
            r6.P0(r7)
        Lac:
            r6.E = r2
            r7 = -1
            r6.C = r7
            android.view.VelocityTracker r7 = r6.F
            if (r7 == 0) goto Ld4
            r7.recycle()
            r7 = 0
            r6.F = r7
            goto Ld4
        Lbc:
            int r7 = r8.getPointerId(r2)
            r6.C = r7
            float r7 = r8.getY()
            float r7 = r7 + r1
            int r7 = (int) r7
            r6.G = r7
            android.view.VelocityTracker r7 = r6.F
            if (r7 != 0) goto Ld4
            android.view.VelocityTracker r7 = android.view.VelocityTracker.obtain()
            r6.F = r7
        Ld4:
            android.view.VelocityTracker r7 = r6.F
            if (r7 == 0) goto Ldb
            r7.addMovement(r8)
        Ldb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.FixAppBarLayoutBehavior.M0(com.google.android.material.appbar.AppBarLayout, android.view.MotionEvent):boolean");
    }

    private void O0(ViewGroup viewGroup, int i11) {
        int childCount = viewGroup.getChildCount();
        int[] iArr = this.f57171x;
        if (iArr == null || iArr.length != childCount) {
            this.f57171x = new int[childCount];
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = viewGroup.getChildAt(i12);
                if (childAt != null) {
                    this.f57171x[i12] = childAt.getTop();
                } else {
                    this.f57171x[i12] = -1;
                }
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = viewGroup.getChildAt(i13);
            if (childAt2.getId() != R$id.toolbar) {
                if (childAt2.getId() == R$id.collapsing) {
                    O0((ViewGroup) childAt2, i11);
                } else if (this.f57171x[i13] >= 0) {
                    childAt2.getMeasuredHeight();
                    childAt2.setTranslationY(i11);
                }
            }
        }
        ViewPager2 viewPager2 = this.f57173z;
        if (viewPager2 != null) {
            viewPager2.setTranslationY(i11);
        }
    }

    private void P0(final AppBarLayout appBarLayout) {
        if (!H0() || this.f57165r || this.f57167t <= 0.0f) {
            return;
        }
        this.f57165r = true;
        this.f57167t = 0.0f;
        if (this.f57164q) {
            ValueAnimator duration = ValueAnimator.ofFloat(this.f57166s, 1.0f).setDuration(300L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.usercenter.profile.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FixAppBarLayoutBehavior.this.I0(appBarLayout, valueAnimator);
                }
            });
            duration.addListener(new c());
            duration.start();
            return;
        }
        this.f57172y.setScaleX(1.0f);
        this.f57172y.setScaleY(1.0f);
        O0(appBarLayout, 0);
        this.f57165r = false;
        d dVar = this.B;
        if (dVar != null) {
            dVar.a(0.0f, true);
        }
    }

    private boolean Q0(AppBarLayout appBarLayout, View view, int i11) {
        if (this.f57165r || !H0() || ((i11 >= 0 || appBarLayout.getBottom() < this.f57169v) && (i11 <= 0 || appBarLayout.getBottom() <= this.f57169v))) {
            return false;
        }
        float f11 = this.f57167t + (-i11);
        this.f57167t = f11;
        float min = Math.min(f11, 500.0f);
        this.f57167t = min;
        float max = Math.max(1.0f, (min / 500.0f) + 1.0f);
        this.f57166s = max;
        this.f57168u = (int) ((this.f57170w / 2) * (max - 1.0f));
        this.f57172y.setScaleX(max);
        this.f57172y.setScaleY(this.f57166s);
        O0(appBarLayout, this.f57168u);
        view.setScrollY(0);
        if (this.B == null) {
            return true;
        }
        this.B.a(Math.min((this.f57166s - 1.0f) / 0.3f, 1.0f), false);
        return true;
    }

    private void R0() {
        u0(new a());
    }

    private void T0(int i11, AppBarLayout appBarLayout, View view, int i12) {
        if (i12 == 1) {
            int E = E();
            if ((i11 >= 0 || E != 0) && (i11 <= 0 || E != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            ViewCompat.stopNestedScroll(view, 1);
        }
    }

    public boolean G0(int i11) {
        View view = this.A;
        return view == null || i11 < view.getTop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean k(androidx.coordinatorlayout.widget.CoordinatorLayout r7, com.google.android.material.appbar.AppBarLayout r8, android.view.MotionEvent r9) {
        /*
            r6 = this;
            lg.a$a r0 = lg.a.f68962a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "---onInterceptTouchEvent isOnInterceptTouchEvent: "
            r1.append(r2)
            boolean r2 = super.k(r7, r8, r9)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FixAppBarLayoutBehavior"
            r3 = 0
            r0.c(r2, r1, r3)
            boolean r0 = r6.H0()
            if (r0 != 0) goto L28
            boolean r7 = super.k(r7, r8, r9)
            return r7
        L28:
            int r0 = r9.getActionMasked()
            int r1 = r6.D
            if (r1 >= 0) goto L3e
            android.content.Context r1 = r8.getContext()
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r1)
            int r1 = r1.getScaledTouchSlop()
            r6.D = r1
        L3e:
            r1 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L7d
            r2 = -1
            r4 = 1
            if (r0 == r4) goto L6e
            r5 = 2
            if (r0 == r5) goto L4d
            r1 = 3
            if (r0 == r1) goto L6e
            goto La7
        L4d:
            int r0 = r6.C
            if (r0 == r2) goto La7
            int r0 = r9.findPointerIndex(r0)
            if (r0 >= 0) goto L58
            goto La7
        L58:
            float r0 = r9.getY(r0)
            float r0 = r0 + r1
            int r0 = (int) r0
            int r1 = r6.G
            int r1 = r1 - r0
            int r1 = java.lang.Math.abs(r1)
            int r2 = r6.D
            if (r1 <= r2) goto La7
            r6.E = r4
            r6.G = r0
            return r4
        L6e:
            r6.E = r3
            r6.C = r2
            android.view.VelocityTracker r0 = r6.F
            if (r0 == 0) goto La7
            r0.recycle()
            r0 = 0
            r6.F = r0
            goto La7
        L7d:
            r6.E = r3
            float r0 = r9.getX()
            int r0 = (int) r0
            float r2 = r9.getY()
            int r2 = (int) r2
            boolean r0 = r7.isPointInChildBounds(r8, r0, r2)
            if (r0 == 0) goto La7
            int r0 = r9.getPointerId(r3)
            r6.C = r0
            float r0 = r9.getY()
            float r0 = r0 + r1
            int r0 = (int) r0
            r6.G = r0
            android.view.VelocityTracker r0 = r6.F
            if (r0 != 0) goto La7
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.F = r0
        La7:
            android.view.VelocityTracker r0 = r6.F
            if (r0 == 0) goto Lae
            r0.addMovement(r9)
        Lae:
            boolean r7 = super.k(r7, r8, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.FixAppBarLayoutBehavior.k(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.MotionEvent):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public boolean o(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f11, float f12) {
        if (f12 > 100.0f) {
            this.f57164q = false;
        }
        return super.o(coordinatorLayout, appBarLayout, view, f11, f12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int i13, int i14, int i15) {
        super.s(coordinatorLayout, appBarLayout, view, i11, i12, i13, i14, i15);
        T0(i14, appBarLayout, view, i15);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        lg.a.f68962a.c("FixAppBarLayoutBehavior", appBarLayout.getScrollY() + "   onTouchEvent " + motionEvent.toString(), false);
        if (H0() && M0(appBarLayout, motionEvent)) {
            return true;
        }
        return super.D(coordinatorLayout, appBarLayout, motionEvent);
    }

    public void S0(d dVar) {
        this.B = dVar;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.i, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: k0 */
    public boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11) {
        boolean l11 = super.l(coordinatorLayout, appBarLayout, i11);
        if (this.f57172y == null) {
            View findViewWithTag = coordinatorLayout.findViewWithTag("largeScale");
            this.f57172y = findViewWithTag;
            if (findViewWithTag != null) {
                appBarLayout.setClipChildren(false);
                this.f57170w = this.f57172y.getHeight();
            }
        }
        if (this.f57173z == null) {
            this.f57173z = (ViewPager2) coordinatorLayout.findViewWithTag("viewPager");
            D0();
        }
        if (this.A == null) {
            this.A = coordinatorLayout.findViewWithTag("emptyView");
        }
        this.f57169v = appBarLayout.getHeight();
        this.f57171x = null;
        return l11;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: m0 */
    public void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
        if (E0() && Q0(appBarLayout, view, i12)) {
            return;
        }
        super.q(coordinatorLayout, appBarLayout, view, i11, i12, iArr, i13);
        T0(i12, appBarLayout, view, i13);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: q0 */
    public boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i11, int i12) {
        this.f57164q = true;
        return super.A(coordinatorLayout, appBarLayout, view, view2, i11, i12);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: r0 */
    public void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11) {
        if (H0()) {
            P0(appBarLayout);
        }
        super.C(coordinatorLayout, appBarLayout, view, i11);
    }
}
