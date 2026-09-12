package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes4.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: m, reason: collision with root package name */
    private static final int f28495m = R$style.Widget_Material3_BottomSheet_DragHandle;

    /* renamed from: d, reason: collision with root package name */
    private final AccessibilityManager f28496d;

    /* renamed from: e, reason: collision with root package name */
    private BottomSheetBehavior f28497e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28498f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28499g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f28500h;

    /* renamed from: i, reason: collision with root package name */
    private final String f28501i;

    /* renamed from: j, reason: collision with root package name */
    private final String f28502j;

    /* renamed from: k, reason: collision with root package name */
    private final String f28503k;

    /* renamed from: l, reason: collision with root package name */
    private final BottomSheetBehavior.f f28504l;

    /* loaded from: classes4.dex */
    class a extends BottomSheetBehavior.f {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onSlide(View view, float f11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onStateChanged(View view, int i11) {
            BottomSheetDragHandleView.this.i(i11);
        }
    }

    /* loaded from: classes4.dex */
    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                BottomSheetDragHandleView.this.e();
            }
        }
    }

    public BottomSheetDragHandleView(@NonNull Context context) {
        this(context, null);
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(bb.a.c(context, attributeSet, i11, f28495m), attributeSet, i11);
        this.f28501i = getResources().getString(R$string.bottomsheet_action_expand);
        this.f28502j = getResources().getString(R$string.bottomsheet_action_collapse);
        this.f28503k = getResources().getString(R$string.bottomsheet_drag_handle_clicked);
        this.f28504l = new a();
        this.f28496d = (AccessibilityManager) getContext().getSystemService("accessibility");
        j();
        ViewCompat.setAccessibilityDelegate(this, new b());
    }

    private void d(String str) {
        if (this.f28496d == null) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
        obtain.getText().add(str);
        this.f28496d.sendAccessibilityEvent(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r1 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e() {
        /*
            r6 = this;
            boolean r0 = r6.f28499g
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.String r0 = r6.f28503k
            r6.d(r0)
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f28497e
            boolean r0 = r0.v0()
            r2 = 1
            if (r0 != 0) goto L1d
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f28497e
            boolean r0 = r0.a1()
            if (r0 != 0) goto L1d
            r1 = r2
        L1d:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f28497e
            int r0 = r0.q0()
            r3 = 6
            r4 = 3
            r5 = 4
            if (r0 != r5) goto L2b
            if (r1 == 0) goto L38
            goto L39
        L2b:
            if (r0 != r4) goto L32
            if (r1 == 0) goto L30
            goto L39
        L30:
            r3 = r5
            goto L39
        L32:
            boolean r0 = r6.f28500h
            if (r0 == 0) goto L37
            goto L38
        L37:
            r4 = r5
        L38:
            r3 = r4
        L39:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f28497e
            r0.U0(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetDragHandleView.e():boolean");
    }

    private BottomSheetBehavior f() {
        View view = this;
        while (true) {
            view = g(view);
            if (view == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                CoordinatorLayout.c f11 = ((CoordinatorLayout.f) layoutParams).f();
                if (f11 instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) f11;
                }
            }
        }
    }

    private static View g(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i11) {
        if (i11 == 4) {
            this.f28500h = true;
        } else if (i11 == 3) {
            this.f28500h = false;
        }
        ViewCompat.replaceAccessibilityAction(this, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK, this.f28500h ? this.f28501i : this.f28502j, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.d
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                boolean h11;
                h11 = BottomSheetDragHandleView.this.h(view, commandArguments);
                return h11;
            }
        });
    }

    private void j() {
        this.f28499g = this.f28498f && this.f28497e != null;
        ViewCompat.setImportantForAccessibility(this, this.f28497e == null ? 2 : 1);
        setClickable(this.f28499g);
    }

    private void setBottomSheetBehavior(@Nullable BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior bottomSheetBehavior2 = this.f28497e;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.B0(this.f28504l);
            this.f28497e.G0(null);
        }
        this.f28497e = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.G0(this);
            i(this.f28497e.q0());
            this.f28497e.Y(this.f28504l);
        }
        j();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z10) {
        this.f28498f = z10;
        j();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(f());
        AccessibilityManager accessibilityManager = this.f28496d;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.f28496d.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f28496d;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }
}
