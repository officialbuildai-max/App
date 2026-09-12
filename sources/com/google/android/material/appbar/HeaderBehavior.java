package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class HeaderBehavior extends i {

    /* renamed from: d, reason: collision with root package name */
    private Runnable f28301d;

    /* renamed from: e, reason: collision with root package name */
    OverScroller f28302e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28303f;

    /* renamed from: g, reason: collision with root package name */
    private int f28304g;

    /* renamed from: h, reason: collision with root package name */
    private int f28305h;

    /* renamed from: i, reason: collision with root package name */
    private int f28306i;

    /* renamed from: j, reason: collision with root package name */
    private VelocityTracker f28307j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class FlingRunnable implements Runnable {
        private final View layout;
        private final CoordinatorLayout parent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, View view) {
            this.parent = coordinatorLayout;
            this.layout = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.layout == null || (overScroller = HeaderBehavior.this.f28302e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.N(this.parent, this.layout);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.P(this.parent, this.layout, headerBehavior.f28302e.getCurrY());
            ViewCompat.postOnAnimation(this.layout, this);
        }
    }

    public HeaderBehavior() {
        this.f28304g = -1;
        this.f28306i = -1;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28304g = -1;
        this.f28306i = -1;
    }

    private void I() {
        if (this.f28307j == null) {
            this.f28307j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean D(androidx.coordinatorlayout.widget.CoordinatorLayout r12, android.view.View r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f28304g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f28305h = r12
            goto L4c
        L2d:
            int r0 = r11.f28304g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f28305h
            int r7 = r1 - r0
            r11.f28305h = r0
            int r8 = r11.K(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.O(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f28307j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f28307j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f28307j
            int r4 = r11.f28304g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.L(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.J(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.f28303f = r3
            r11.f28304g = r1
            android.view.VelocityTracker r13 = r11.f28307j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f28307j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f28307j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f28303f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    boolean H(View view) {
        return false;
    }

    final boolean J(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, float f11) {
        Runnable runnable = this.f28301d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f28301d = null;
        }
        if (this.f28302e == null) {
            this.f28302e = new OverScroller(view.getContext());
        }
        this.f28302e.fling(0, E(), 0, Math.round(f11), 0, 0, i11, i12);
        if (!this.f28302e.computeScrollOffset()) {
            N(coordinatorLayout, view);
            return false;
        }
        FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, view);
        this.f28301d = flingRunnable;
        ViewCompat.postOnAnimation(view, flingRunnable);
        return true;
    }

    int K(View view) {
        return -view.getHeight();
    }

    int L(View view) {
        return view.getHeight();
    }

    int M() {
        return E();
    }

    void N(CoordinatorLayout coordinatorLayout, View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int O(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13) {
        return Q(coordinatorLayout, view, M() - i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int P(CoordinatorLayout coordinatorLayout, View view, int i11) {
        return Q(coordinatorLayout, view, i11, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int Q(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13) {
        int b11;
        int E = E();
        if (i12 == 0 || E < i12 || E > i13 || E == (b11 = d1.a.b(i11, i12, i13))) {
            return 0;
        }
        G(b11);
        return E - b11;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f28306i < 0) {
            this.f28306i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f28303f) {
            int i11 = this.f28304g;
            if (i11 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i11)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y10 - this.f28305h) > this.f28306i) {
                this.f28305h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f28304g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = H(view) && coordinatorLayout.isPointInChildBounds(view, x10, y11);
            this.f28303f = z10;
            if (z10) {
                this.f28305h = y11;
                this.f28304g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f28302e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f28302e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f28307j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
