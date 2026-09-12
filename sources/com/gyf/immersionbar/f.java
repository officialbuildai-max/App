package com.gyf.immersionbar;

import android.R;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private ImmersionBar f33161a;

    /* renamed from: b, reason: collision with root package name */
    private Window f33162b;

    /* renamed from: c, reason: collision with root package name */
    private View f33163c;

    /* renamed from: d, reason: collision with root package name */
    private View f33164d;

    /* renamed from: e, reason: collision with root package name */
    private View f33165e;

    /* renamed from: f, reason: collision with root package name */
    private int f33166f;

    /* renamed from: g, reason: collision with root package name */
    private int f33167g;

    /* renamed from: h, reason: collision with root package name */
    private int f33168h;

    /* renamed from: i, reason: collision with root package name */
    private int f33169i;

    /* renamed from: j, reason: collision with root package name */
    private int f33170j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f33171k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View] */
    public f(ImmersionBar immersionBar) {
        this.f33166f = 0;
        this.f33167g = 0;
        this.f33168h = 0;
        this.f33169i = 0;
        this.f33161a = immersionBar;
        Window window = immersionBar.getWindow();
        this.f33162b = window;
        View decorView = window.getDecorView();
        this.f33163c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        if (immersionBar.isDialogFragment()) {
            Fragment supportFragment = immersionBar.getSupportFragment();
            if (supportFragment != null) {
                this.f33165e = supportFragment.getView();
            } else {
                android.app.Fragment fragment = immersionBar.getFragment();
                if (fragment != null) {
                    this.f33165e = fragment.getView();
                }
            }
        } else {
            View childAt = frameLayout.getChildAt(0);
            this.f33165e = childAt;
            if (childAt != null && (childAt instanceof DrawerLayout)) {
                this.f33165e = ((DrawerLayout) childAt).getChildAt(0);
            }
        }
        View view = this.f33165e;
        if (view != null) {
            this.f33166f = view.getPaddingLeft();
            this.f33167g = this.f33165e.getPaddingTop();
            this.f33168h = this.f33165e.getPaddingRight();
            this.f33169i = this.f33165e.getPaddingBottom();
        }
        ?? r42 = this.f33165e;
        this.f33164d = r42 != 0 ? r42 : frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f33171k) {
            this.f33163c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f33171k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f33171k) {
            if (this.f33165e != null) {
                this.f33164d.setPadding(this.f33166f, this.f33167g, this.f33168h, this.f33169i);
            } else {
                this.f33164d.setPadding(this.f33161a.getPaddingLeft(), this.f33161a.getPaddingTop(), this.f33161a.getPaddingRight(), this.f33161a.getPaddingBottom());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i11) {
        this.f33162b.setSoftInputMode(i11);
        if (this.f33171k) {
            return;
        }
        this.f33163c.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f33171k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f33170j = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
    
        if ((r3 - r1) > r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onGlobalLayout() {
        /*
            r7 = this;
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            if (r0 == 0) goto Le0
            com.gyf.immersionbar.b r0 = r0.getBarParams()
            if (r0 == 0) goto Le0
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            com.gyf.immersionbar.b r0 = r0.getBarParams()
            boolean r0 = r0.F
            if (r0 == 0) goto Le0
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            com.gyf.immersionbar.a r0 = r0.getBarConfig()
            boolean r1 = r0.n()
            if (r1 == 0) goto L25
            int r1 = r0.d()
            goto L29
        L25:
            int r1 = r0.g()
        L29:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.view.View r3 = r7.f33163c
            r3.getWindowVisibleDisplayFrame(r2)
            android.view.View r3 = r7.f33164d
            int r3 = r3.getHeight()
            int r2 = r2.bottom
            int r3 = r3 - r2
            int r2 = r7.f33170j
            if (r3 == r2) goto Le0
            r7.f33170j = r3
            android.view.Window r2 = r7.f33162b
            android.view.View r2 = r2.getDecorView()
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r2.findViewById(r4)
            boolean r2 = com.gyf.immersionbar.ImmersionBar.checkFitsSystemWindows(r2)
            r4 = 0
            r5 = 1
            if (r2 != 0) goto Lb9
            android.view.View r2 = r7.f33165e
            if (r2 == 0) goto L95
            com.gyf.immersionbar.ImmersionBar r2 = r7.f33161a
            com.gyf.immersionbar.b r2 = r2.getBarParams()
            boolean r2 = r2.E
            if (r2 == 0) goto L71
            com.gyf.immersionbar.ImmersionBar r2 = r7.f33161a
            int r2 = r2.getActionBarHeight()
            int r6 = r0.k()
            int r2 = r2 + r6
            int r3 = r3 + r2
        L71:
            com.gyf.immersionbar.ImmersionBar r2 = r7.f33161a
            com.gyf.immersionbar.b r2 = r2.getBarParams()
            boolean r2 = r2.f33146y
            if (r2 == 0) goto L80
            int r0 = r0.k()
            int r3 = r3 + r0
        L80:
            if (r3 <= r1) goto L87
            int r0 = r7.f33169i
            int r4 = r3 + r0
            goto L88
        L87:
            r5 = r4
        L88:
            android.view.View r0 = r7.f33164d
            int r1 = r7.f33166f
            int r2 = r7.f33167g
            int r3 = r7.f33168h
            r0.setPadding(r1, r2, r3, r4)
        L93:
            r4 = r5
            goto Lbd
        L95:
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            int r0 = r0.getPaddingBottom()
            int r3 = r3 - r1
            if (r3 <= r1) goto La1
            int r0 = r3 + r1
            r4 = r5
        La1:
            android.view.View r1 = r7.f33164d
            com.gyf.immersionbar.ImmersionBar r2 = r7.f33161a
            int r2 = r2.getPaddingLeft()
            com.gyf.immersionbar.ImmersionBar r3 = r7.f33161a
            int r3 = r3.getPaddingTop()
            com.gyf.immersionbar.ImmersionBar r5 = r7.f33161a
            int r5 = r5.getPaddingRight()
            r1.setPadding(r2, r3, r5, r0)
            goto Lbd
        Lb9:
            int r3 = r3 - r1
            if (r3 <= r1) goto Lbd
            goto L93
        Lbd:
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            com.gyf.immersionbar.b r0 = r0.getBarParams()
            r0.getClass()
            if (r4 != 0) goto Ld9
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            com.gyf.immersionbar.b r0 = r0.getBarParams()
            com.gyf.immersionbar.BarHide r0 = r0.f33131j
            com.gyf.immersionbar.BarHide r1 = com.gyf.immersionbar.BarHide.FLAG_SHOW_BAR
            if (r0 == r1) goto Ld9
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            r0.setBar()
        Ld9:
            if (r4 != 0) goto Le0
            com.gyf.immersionbar.ImmersionBar r0 = r7.f33161a
            r0.fitsParentBarKeyboard()
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.f.onGlobalLayout():void");
    }
}
