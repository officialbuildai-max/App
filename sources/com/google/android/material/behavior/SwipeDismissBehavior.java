package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* loaded from: classes4.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    ViewDragHelper f28376a;

    /* renamed from: b, reason: collision with root package name */
    c f28377b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f28378c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f28379d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28381f;

    /* renamed from: e, reason: collision with root package name */
    private float f28380e = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    int f28382g = 2;

    /* renamed from: h, reason: collision with root package name */
    float f28383h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    float f28384i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    float f28385j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    private final ViewDragHelper.b f28386k = new a();

    /* loaded from: classes4.dex */
    private class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        SettleRunnable(View view, boolean z10) {
            this.view = view;
            this.dismiss = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f28376a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else {
                if (!this.dismiss || (cVar = SwipeDismissBehavior.this.f28377b) == null) {
                    return;
                }
                cVar.a(this.view);
            }
        }
    }

    /* loaded from: classes4.dex */
    class a extends ViewDragHelper.b {

        /* renamed from: a, reason: collision with root package name */
        private int f28387a;

        /* renamed from: b, reason: collision with root package name */
        private int f28388b = -1;

        a() {
        }

        private boolean a(View view, float f11) {
            if (f11 == 0.0f) {
                return Math.abs(view.getLeft() - this.f28387a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f28383h);
            }
            boolean z10 = ViewCompat.getLayoutDirection(view) == 1;
            int i11 = SwipeDismissBehavior.this.f28382g;
            if (i11 == 2) {
                return true;
            }
            if (i11 == 0) {
                if (z10) {
                    if (f11 >= 0.0f) {
                        return false;
                    }
                } else if (f11 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i11 != 1) {
                return false;
            }
            if (z10) {
                if (f11 <= 0.0f) {
                    return false;
                }
            } else if (f11 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            int width;
            int width2;
            int width3;
            boolean z10 = ViewCompat.getLayoutDirection(view) == 1;
            int i13 = SwipeDismissBehavior.this.f28382g;
            if (i13 == 0) {
                if (z10) {
                    width = this.f28387a - view.getWidth();
                    width2 = this.f28387a;
                } else {
                    width = this.f28387a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i13 != 1) {
                width = this.f28387a - view.getWidth();
                width2 = view.getWidth() + this.f28387a;
            } else if (z10) {
                width = this.f28387a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f28387a - view.getWidth();
                width2 = this.f28387a;
            }
            return SwipeDismissBehavior.H(width, i11, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewCaptured(View view, int i11) {
            this.f28388b = i11;
            this.f28387a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f28379d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f28379d = false;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewDragStateChanged(int i11) {
            c cVar = SwipeDismissBehavior.this.f28377b;
            if (cVar != null) {
                cVar.b(i11);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f28384i;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f28385j;
            float abs = Math.abs(i11 - this.f28387a);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.G(0.0f, 1.0f - SwipeDismissBehavior.J(width, width2, abs), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            boolean z10;
            c cVar;
            this.f28388b = -1;
            int width = view.getWidth();
            if (a(view, f11)) {
                if (f11 >= 0.0f) {
                    int left = view.getLeft();
                    int i12 = this.f28387a;
                    if (left >= i12) {
                        i11 = i12 + width;
                        z10 = true;
                    }
                }
                i11 = this.f28387a - width;
                z10 = true;
            } else {
                i11 = this.f28387a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.f28376a.settleCapturedViewAt(i11, view.getTop())) {
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, z10));
            } else {
                if (!z10 || (cVar = SwipeDismissBehavior.this.f28377b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean tryCaptureView(View view, int i11) {
            int i12 = this.f28388b;
            return (i12 == -1 || i12 == i11) && SwipeDismissBehavior.this.F(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements AccessibilityViewCommand {
        b() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            if (!SwipeDismissBehavior.this.F(view)) {
                return false;
            }
            boolean z10 = ViewCompat.getLayoutDirection(view) == 1;
            int i11 = SwipeDismissBehavior.this.f28382g;
            ViewCompat.offsetLeftAndRight(view, (!(i11 == 0 && z10) && (i11 != 1 || z10)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f28377b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view);

        void b(int i11);
    }

    static float G(float f11, float f12, float f13) {
        return Math.min(Math.max(f11, f12), f13);
    }

    static int H(int i11, int i12, int i13) {
        return Math.min(Math.max(i11, i12), i13);
    }

    private void I(ViewGroup viewGroup) {
        if (this.f28376a == null) {
            this.f28376a = this.f28381f ? ViewDragHelper.create(viewGroup, this.f28380e, this.f28386k) : ViewDragHelper.create(viewGroup, this.f28386k);
        }
    }

    static float J(float f11, float f12, float f13) {
        return (f13 - f11) / (f12 - f11);
    }

    private void O(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (F(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f28376a == null) {
            return false;
        }
        if (this.f28379d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f28376a.processTouchEvent(motionEvent);
        return true;
    }

    public boolean F(View view) {
        return true;
    }

    public void K(float f11) {
        this.f28385j = G(0.0f, f11, 1.0f);
    }

    public void L(c cVar) {
        this.f28377b = cVar;
    }

    public void M(float f11) {
        this.f28384i = G(0.0f, f11, 1.0f);
    }

    public void N(int i11) {
        this.f28382g = i11;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10 = this.f28378c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f28378c = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f28378c = false;
        }
        if (!z10) {
            return false;
        }
        I(coordinatorLayout);
        return !this.f28379d && this.f28376a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i11) {
        boolean l11 = super.l(coordinatorLayout, view, i11);
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
            O(view);
        }
        return l11;
    }
}
