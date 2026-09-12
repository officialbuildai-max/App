package com.google.android.material.bottomsheet;

import ab.i;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.w;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.f0;

/* loaded from: classes4.dex */
public class c extends w {

    /* renamed from: a, reason: collision with root package name */
    private BottomSheetBehavior f28507a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f28508b;

    /* renamed from: c, reason: collision with root package name */
    private CoordinatorLayout f28509c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f28510d;

    /* renamed from: e, reason: collision with root package name */
    boolean f28511e;

    /* renamed from: f, reason: collision with root package name */
    boolean f28512f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28513g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f28514h;

    /* renamed from: i, reason: collision with root package name */
    private f f28515i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f28516j;

    /* renamed from: k, reason: collision with root package name */
    private wa.c f28517k;

    /* renamed from: l, reason: collision with root package name */
    private BottomSheetBehavior.f f28518l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (c.this.f28515i != null) {
                c.this.f28507a.B0(c.this.f28515i);
            }
            if (windowInsetsCompat != null) {
                c cVar = c.this;
                cVar.f28515i = new f(cVar.f28510d, windowInsetsCompat, null);
                c.this.f28515i.b(c.this.getWindow());
                c.this.f28507a.Y(c.this.f28515i);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            if (cVar.f28512f && cVar.isShowing() && c.this.n()) {
                c.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.bottomsheet.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0393c extends AccessibilityDelegateCompat {
        C0393c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!c.this.f28512f) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (i11 == 1048576) {
                c cVar = c.this;
                if (cVar.f28512f) {
                    cVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i11, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    class e extends BottomSheetBehavior.f {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onSlide(View view, float f11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onStateChanged(View view, int i11) {
            if (i11 == 5) {
                c.this.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class f extends BottomSheetBehavior.f {

        /* renamed from: a, reason: collision with root package name */
        private final Boolean f28524a;

        /* renamed from: b, reason: collision with root package name */
        private final WindowInsetsCompat f28525b;

        /* renamed from: c, reason: collision with root package name */
        private Window f28526c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f28527d;

        private f(View view, WindowInsetsCompat windowInsetsCompat) {
            this.f28525b = windowInsetsCompat;
            i p02 = BottomSheetBehavior.m0(view).p0();
            ColorStateList z10 = p02 != null ? p02.z() : ViewCompat.getBackgroundTintList(view);
            if (z10 != null) {
                this.f28524a = Boolean.valueOf(com.google.android.material.color.b.h(z10.getDefaultColor()));
                return;
            }
            Integer h11 = f0.h(view);
            if (h11 != null) {
                this.f28524a = Boolean.valueOf(com.google.android.material.color.b.h(h11.intValue()));
            } else {
                this.f28524a = null;
            }
        }

        /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, a aVar) {
            this(view, windowInsetsCompat);
        }

        private void a(View view) {
            if (view.getTop() < this.f28525b.getSystemWindowInsetTop()) {
                Window window = this.f28526c;
                if (window != null) {
                    Boolean bool = this.f28524a;
                    com.google.android.material.internal.e.f(window, bool == null ? this.f28527d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f28525b.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f28526c;
                if (window2 != null) {
                    com.google.android.material.internal.e.f(window2, this.f28527d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        void b(Window window) {
            if (this.f28526c == window) {
                return;
            }
            this.f28526c = window;
            if (window != null) {
                this.f28527d = WindowCompat.getInsetsController(window, window.getDecorView()).isAppearanceLightStatusBars();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        void onLayout(View view) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onSlide(View view, float f11) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onStateChanged(View view, int i11) {
            a(view);
        }
    }

    public c(Context context) {
        this(context, 0);
        this.f28516j = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public c(Context context, int i11) {
        super(context, d(context, i11));
        this.f28512f = true;
        this.f28513g = true;
        this.f28518l = new e();
        supportRequestWindowFeature(1);
        this.f28516j = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int d(Context context, int i11) {
        if (i11 != 0) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
    }

    private FrameLayout j() {
        if (this.f28508b == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.f28508b = frameLayout;
            this.f28509c = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f28508b.findViewById(R$id.design_bottom_sheet);
            this.f28510d = frameLayout2;
            BottomSheetBehavior m02 = BottomSheetBehavior.m0(frameLayout2);
            this.f28507a = m02;
            m02.Y(this.f28518l);
            this.f28507a.M0(this.f28512f);
            this.f28517k = new wa.c(this.f28507a, this.f28510d);
        }
        return this.f28508b;
    }

    private void o() {
        wa.c cVar = this.f28517k;
        if (cVar == null) {
            return;
        }
        if (this.f28512f) {
            cVar.c();
        } else {
            cVar.f();
        }
    }

    private View p(int i11, View view, ViewGroup.LayoutParams layoutParams) {
        j();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f28508b.findViewById(R$id.coordinator);
        if (i11 != 0 && view == null) {
            view = getLayoutInflater().inflate(i11, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f28516j) {
            ViewCompat.setOnApplyWindowInsetsListener(this.f28510d, new a());
        }
        this.f28510d.removeAllViews();
        if (layoutParams == null) {
            this.f28510d.addView(view);
        } else {
            this.f28510d.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(this.f28510d, new C0393c());
        this.f28510d.setOnTouchListener(new d());
        return this.f28508b;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior k11 = k();
        if (!this.f28511e || k11.q0() == 5) {
            super.cancel();
        } else {
            k11.U0(5);
        }
    }

    public BottomSheetBehavior k() {
        if (this.f28507a == null) {
            j();
        }
        return this.f28507a;
    }

    public boolean l() {
        return this.f28511e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.f28507a.B0(this.f28518l);
    }

    boolean n() {
        if (!this.f28514h) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.f28513g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f28514h = true;
        }
        return this.f28513g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z10 = this.f28516j && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f28508b;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.f28509c;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            WindowCompat.setDecorFitsSystemWindows(window, !z10);
            f fVar = this.f28515i;
            if (fVar != null) {
                fVar.b(window);
            }
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.f28515i;
        if (fVar != null) {
            fVar.b(null);
        }
        wa.c cVar = this.f28517k;
        if (cVar != null) {
            cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.q, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f28507a;
        if (bottomSheetBehavior == null || bottomSheetBehavior.q0() != 5) {
            return;
        }
        this.f28507a.U0(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.f28512f != z10) {
            this.f28512f = z10;
            BottomSheetBehavior bottomSheetBehavior = this.f28507a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.M0(z10);
            }
            if (getWindow() != null) {
                o();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.f28512f) {
            this.f28512f = true;
        }
        this.f28513g = z10;
        this.f28514h = true;
    }

    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void setContentView(int i11) {
        super.setContentView(p(i11, null, null));
    }

    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(p(0, view, null));
    }

    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(p(0, view, layoutParams));
    }
}
