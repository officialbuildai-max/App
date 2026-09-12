package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.y0;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends AccessibilityDelegateCompat {

    /* renamed from: k, reason: collision with root package name */
    private static final Rect f8598k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    private static final FocusStrategy.a f8599l = new C0080a();

    /* renamed from: m, reason: collision with root package name */
    private static final FocusStrategy.b f8600m = new b();

    /* renamed from: e, reason: collision with root package name */
    private final AccessibilityManager f8605e;

    /* renamed from: f, reason: collision with root package name */
    private final View f8606f;

    /* renamed from: g, reason: collision with root package name */
    private c f8607g;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f8601a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private final Rect f8602b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    private final Rect f8603c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f8604d = new int[2];

    /* renamed from: h, reason: collision with root package name */
    int f8608h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    int f8609i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private int f8610j = Integer.MIN_VALUE;

    /* renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0080a implements FocusStrategy.a {
        C0080a() {
        }

        @Override // androidx.customview.widget.FocusStrategy.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    }

    /* loaded from: classes.dex */
    class b implements FocusStrategy.b {
        b() {
        }

        @Override // androidx.customview.widget.FocusStrategy.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AccessibilityNodeInfoCompat a(y0 y0Var, int i11) {
            return (AccessibilityNodeInfoCompat) y0Var.q(i11);
        }

        @Override // androidx.customview.widget.FocusStrategy.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(y0 y0Var) {
            return y0Var.p();
        }
    }

    /* loaded from: classes.dex */
    private class c extends AccessibilityNodeProviderCompat {
        c() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i11) {
            return AccessibilityNodeInfoCompat.obtain(a.this.w(i11));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i11) {
            int i12 = i11 == 2 ? a.this.f8608h : a.this.f8609i;
            if (i12 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i12);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i11, int i12, Bundle bundle) {
            return a.this.E(i11, i12, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f8606f = view;
        this.f8605e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
    }

    private boolean F(int i11, int i12, Bundle bundle) {
        return i12 != 1 ? i12 != 2 ? i12 != 64 ? i12 != 128 ? y(i11, i12, bundle) : a(i11) : H(i11) : b(i11) : I(i11);
    }

    private boolean G(int i11, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.f8606f, i11, bundle);
    }

    private boolean H(int i11) {
        int i12;
        if (!this.f8605e.isEnabled() || !this.f8605e.isTouchExplorationEnabled() || (i12 = this.f8608h) == i11) {
            return false;
        }
        if (i12 != Integer.MIN_VALUE) {
            a(i12);
        }
        this.f8608h = i11;
        this.f8606f.invalidate();
        J(i11, 32768);
        return true;
    }

    private void K(int i11) {
        int i12 = this.f8610j;
        if (i12 == i11) {
            return;
        }
        this.f8610j = i11;
        J(i11, 128);
        J(i12, 256);
    }

    private boolean a(int i11) {
        if (this.f8608h != i11) {
            return false;
        }
        this.f8608h = Integer.MIN_VALUE;
        this.f8606f.invalidate();
        J(i11, 65536);
        return true;
    }

    private boolean c() {
        int i11 = this.f8609i;
        return i11 != Integer.MIN_VALUE && y(i11, 16, null);
    }

    private AccessibilityEvent d(int i11, int i12) {
        return i11 != -1 ? e(i11, i12) : f(i12);
    }

    private AccessibilityEvent e(int i11, int i12) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i12);
        AccessibilityNodeInfoCompat w11 = w(i11);
        obtain.getText().add(w11.getText());
        obtain.setContentDescription(w11.getContentDescription());
        obtain.setScrollable(w11.isScrollable());
        obtain.setPassword(w11.isPassword());
        obtain.setEnabled(w11.isEnabled());
        obtain.setChecked(w11.isChecked());
        A(i11, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(w11.getClassName());
        AccessibilityRecordCompat.setSource(obtain, this.f8606f, i11);
        obtain.setPackageName(this.f8606f.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent f(int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        this.f8606f.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private AccessibilityNodeInfoCompat g(int i11) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        Rect rect = f8598k;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.f8606f);
        C(i11, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.f8602b);
        if (this.f8602b.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(this.f8606f.getContext().getPackageName());
        obtain.setSource(this.f8606f, i11);
        if (this.f8608h == i11) {
            obtain.setAccessibilityFocused(true);
            obtain.addAction(128);
        } else {
            obtain.setAccessibilityFocused(false);
            obtain.addAction(64);
        }
        boolean z10 = this.f8609i == i11;
        if (z10) {
            obtain.addAction(2);
        } else if (obtain.isFocusable()) {
            obtain.addAction(1);
        }
        obtain.setFocused(z10);
        this.f8606f.getLocationOnScreen(this.f8604d);
        obtain.getBoundsInScreen(this.f8601a);
        if (this.f8601a.equals(rect)) {
            obtain.getBoundsInParent(this.f8601a);
            if (obtain.mParentVirtualDescendantId != -1) {
                AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                for (int i12 = obtain.mParentVirtualDescendantId; i12 != -1; i12 = obtain2.mParentVirtualDescendantId) {
                    obtain2.setParent(this.f8606f, -1);
                    obtain2.setBoundsInParent(f8598k);
                    C(i12, obtain2);
                    obtain2.getBoundsInParent(this.f8602b);
                    Rect rect2 = this.f8601a;
                    Rect rect3 = this.f8602b;
                    rect2.offset(rect3.left, rect3.top);
                }
                obtain2.recycle();
            }
            this.f8601a.offset(this.f8604d[0] - this.f8606f.getScrollX(), this.f8604d[1] - this.f8606f.getScrollY());
        }
        if (this.f8606f.getLocalVisibleRect(this.f8603c)) {
            this.f8603c.offset(this.f8604d[0] - this.f8606f.getScrollX(), this.f8604d[1] - this.f8606f.getScrollY());
            if (this.f8601a.intersect(this.f8603c)) {
                obtain.setBoundsInScreen(this.f8601a);
                if (t(this.f8601a)) {
                    obtain.setVisibleToUser(true);
                }
            }
        }
        return obtain;
    }

    private AccessibilityNodeInfoCompat h() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.f8606f);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.f8606f, obtain);
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            obtain.addChild(this.f8606f, ((Integer) arrayList.get(i11)).intValue());
        }
        return obtain;
    }

    private y0 l() {
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        y0 y0Var = new y0();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            y0Var.l(((Integer) arrayList.get(i11)).intValue(), g(((Integer) arrayList.get(i11)).intValue()));
        }
        return y0Var;
    }

    private void m(int i11, Rect rect) {
        w(i11).getBoundsInParent(rect);
    }

    private static Rect q(View view, int i11, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i11 == 17) {
            rect.set(width, 0, width, height);
        } else if (i11 == 33) {
            rect.set(0, height, width, height);
        } else if (i11 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i11 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean t(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f8606f.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f8606f.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int u(int i11) {
        if (i11 == 19) {
            return 33;
        }
        if (i11 != 21) {
            return i11 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean v(int i11, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        y0 l11 = l();
        int i12 = this.f8609i;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i12 == Integer.MIN_VALUE ? null : (AccessibilityNodeInfoCompat) l11.f(i12);
        if (i11 == 1 || i11 == 2) {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.d(l11, f8600m, f8599l, accessibilityNodeInfoCompat2, i11, ViewCompat.getLayoutDirection(this.f8606f) == 1, false);
        } else {
            if (i11 != 17 && i11 != 33 && i11 != 66 && i11 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i13 = this.f8609i;
            if (i13 != Integer.MIN_VALUE) {
                m(i13, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                q(this.f8606f, i11, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.c(l11, f8600m, f8599l, accessibilityNodeInfoCompat2, rect2, i11);
        }
        return I(accessibilityNodeInfoCompat != null ? l11.k(l11.j(accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
    }

    protected void A(int i11, AccessibilityEvent accessibilityEvent) {
    }

    protected void B(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected abstract void C(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected void D(int i11, boolean z10) {
    }

    boolean E(int i11, int i12, Bundle bundle) {
        return i11 != -1 ? F(i11, i12, bundle) : G(i12, bundle);
    }

    public final boolean I(int i11) {
        int i12;
        if ((!this.f8606f.isFocused() && !this.f8606f.requestFocus()) || (i12 = this.f8609i) == i11) {
            return false;
        }
        if (i12 != Integer.MIN_VALUE) {
            b(i12);
        }
        if (i11 == Integer.MIN_VALUE) {
            return false;
        }
        this.f8609i = i11;
        D(i11, true);
        J(i11, 8);
        return true;
    }

    public final boolean J(int i11, int i12) {
        ViewParent parent;
        if (i11 == Integer.MIN_VALUE || !this.f8605e.isEnabled() || (parent = this.f8606f.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f8606f, d(i11, i12));
    }

    public final boolean b(int i11) {
        if (this.f8609i != i11) {
            return false;
        }
        this.f8609i = Integer.MIN_VALUE;
        D(i11, false);
        J(i11, 8);
        return true;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f8607g == null) {
            this.f8607g = new c();
        }
        return this.f8607g;
    }

    public final boolean i(MotionEvent motionEvent) {
        if (!this.f8605e.isEnabled() || !this.f8605e.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int o11 = o(motionEvent.getX(), motionEvent.getY());
            K(o11);
            return o11 != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f8610j == Integer.MIN_VALUE) {
            return false;
        }
        K(Integer.MIN_VALUE);
        return true;
    }

    public final boolean j(KeyEvent keyEvent) {
        int i11 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return v(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return v(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int u11 = u(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z10 = false;
                    while (i11 < repeatCount && v(u11, null)) {
                        i11++;
                        z10 = true;
                    }
                    return z10;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        c();
        return true;
    }

    public final int k() {
        return this.f8608h;
    }

    public final int n() {
        return this.f8609i;
    }

    protected abstract int o(float f11, float f12);

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        z(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        B(accessibilityNodeInfoCompat);
    }

    protected abstract void p(List list);

    public final void r(int i11) {
        s(i11, 0);
    }

    public final void s(int i11, int i12) {
        ViewParent parent;
        if (i11 == Integer.MIN_VALUE || !this.f8605e.isEnabled() || (parent = this.f8606f.getParent()) == null) {
            return;
        }
        AccessibilityEvent d11 = d(i11, 2048);
        AccessibilityEventCompat.setContentChangeTypes(d11, i12);
        parent.requestSendAccessibilityEvent(this.f8606f, d11);
    }

    AccessibilityNodeInfoCompat w(int i11) {
        return i11 == -1 ? h() : g(i11);
    }

    public final void x(boolean z10, int i11, Rect rect) {
        int i12 = this.f8609i;
        if (i12 != Integer.MIN_VALUE) {
            b(i12);
        }
        if (z10) {
            v(i11, rect);
        }
    }

    protected abstract boolean y(int i11, int i12, Bundle bundle);

    protected void z(AccessibilityEvent accessibilityEvent) {
    }
}
