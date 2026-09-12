package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class n0 implements t {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f2136a;

    /* renamed from: b, reason: collision with root package name */
    private int f2137b;

    /* renamed from: c, reason: collision with root package name */
    private View f2138c;

    /* renamed from: d, reason: collision with root package name */
    private View f2139d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f2140e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f2141f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f2142g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2143h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f2144i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f2145j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f2146k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f2147l;

    /* renamed from: m, reason: collision with root package name */
    boolean f2148m;

    /* renamed from: n, reason: collision with root package name */
    private ActionMenuPresenter f2149n;

    /* renamed from: o, reason: collision with root package name */
    private int f2150o;

    /* renamed from: p, reason: collision with root package name */
    private int f2151p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f2152q;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f2153a;

        a() {
            this.f2153a = new androidx.appcompat.view.menu.a(n0.this.f2136a.getContext(), 0, R.id.home, 0, 0, n0.this.f2144i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n0 n0Var = n0.this;
            Window.Callback callback = n0Var.f2147l;
            if (callback == null || !n0Var.f2148m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f2153a);
        }
    }

    /* loaded from: classes.dex */
    class b extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2155a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f2156b;

        b(int i11) {
            this.f2156b = i11;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            this.f2155a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (this.f2155a) {
                return;
            }
            n0.this.f2136a.setVisibility(this.f2156b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            n0.this.f2136a.setVisibility(0);
        }
    }

    public n0(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public n0(Toolbar toolbar, boolean z10, int i11, int i12) {
        Drawable drawable;
        this.f2150o = 0;
        this.f2151p = 0;
        this.f2136a = toolbar;
        this.f2144i = toolbar.getTitle();
        this.f2145j = toolbar.getSubtitle();
        this.f2143h = this.f2144i != null;
        this.f2142g = toolbar.getNavigationIcon();
        j0 v11 = j0.v(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f2152q = v11.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence p11 = v11.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(p11)) {
                B(p11);
            }
            CharSequence p12 = v11.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p12)) {
                A(p12);
            }
            Drawable g11 = v11.g(R$styleable.ActionBar_logo);
            if (g11 != null) {
                w(g11);
            }
            Drawable g12 = v11.g(R$styleable.ActionBar_icon);
            if (g12 != null) {
                setIcon(g12);
            }
            if (this.f2142g == null && (drawable = this.f2152q) != null) {
                z(drawable);
            }
            b(v11.k(R$styleable.ActionBar_displayOptions, 0));
            int n11 = v11.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (n11 != 0) {
                u(LayoutInflater.from(this.f2136a.getContext()).inflate(n11, (ViewGroup) this.f2136a, false));
                b(this.f2137b | 16);
            }
            int m11 = v11.m(R$styleable.ActionBar_height, 0);
            if (m11 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2136a.getLayoutParams();
                layoutParams.height = m11;
                this.f2136a.setLayoutParams(layoutParams);
            }
            int e11 = v11.e(R$styleable.ActionBar_contentInsetStart, -1);
            int e12 = v11.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (e11 >= 0 || e12 >= 0) {
                this.f2136a.setContentInsetsRelative(Math.max(e11, 0), Math.max(e12, 0));
            }
            int n12 = v11.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (n12 != 0) {
                Toolbar toolbar2 = this.f2136a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n12);
            }
            int n13 = v11.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (n13 != 0) {
                Toolbar toolbar3 = this.f2136a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n13);
            }
            int n14 = v11.n(R$styleable.ActionBar_popupTheme, 0);
            if (n14 != 0) {
                this.f2136a.setPopupTheme(n14);
            }
        } else {
            this.f2137b = t();
        }
        v11.x();
        v(i11);
        this.f2146k = this.f2136a.getNavigationContentDescription();
        this.f2136a.setNavigationOnClickListener(new a());
    }

    private void C(CharSequence charSequence) {
        this.f2144i = charSequence;
        if ((this.f2137b & 8) != 0) {
            this.f2136a.setTitle(charSequence);
            if (this.f2143h) {
                ViewCompat.setAccessibilityPaneTitle(this.f2136a.getRootView(), charSequence);
            }
        }
    }

    private void D() {
        if ((this.f2137b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2146k)) {
                this.f2136a.setNavigationContentDescription(this.f2151p);
            } else {
                this.f2136a.setNavigationContentDescription(this.f2146k);
            }
        }
    }

    private void E() {
        if ((this.f2137b & 4) == 0) {
            this.f2136a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f2136a;
        Drawable drawable = this.f2142g;
        if (drawable == null) {
            drawable = this.f2152q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void F() {
        Drawable drawable;
        int i11 = this.f2137b;
        if ((i11 & 2) == 0) {
            drawable = null;
        } else if ((i11 & 1) != 0) {
            drawable = this.f2141f;
            if (drawable == null) {
                drawable = this.f2140e;
            }
        } else {
            drawable = this.f2140e;
        }
        this.f2136a.setLogo(drawable);
    }

    private int t() {
        if (this.f2136a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2152q = this.f2136a.getNavigationIcon();
        return 15;
    }

    public void A(CharSequence charSequence) {
        this.f2145j = charSequence;
        if ((this.f2137b & 8) != 0) {
            this.f2136a.setSubtitle(charSequence);
        }
    }

    public void B(CharSequence charSequence) {
        this.f2143h = true;
        C(charSequence);
    }

    @Override // androidx.appcompat.widget.t
    public boolean a() {
        return this.f2136a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.t
    public void b(int i11) {
        View view;
        int i12 = this.f2137b ^ i11;
        this.f2137b = i11;
        if (i12 != 0) {
            if ((i12 & 4) != 0) {
                if ((i11 & 4) != 0) {
                    D();
                }
                E();
            }
            if ((i12 & 3) != 0) {
                F();
            }
            if ((i12 & 8) != 0) {
                if ((i11 & 8) != 0) {
                    this.f2136a.setTitle(this.f2144i);
                    this.f2136a.setSubtitle(this.f2145j);
                } else {
                    this.f2136a.setTitle((CharSequence) null);
                    this.f2136a.setSubtitle((CharSequence) null);
                }
            }
            if ((i12 & 16) == 0 || (view = this.f2139d) == null) {
                return;
            }
            if ((i11 & 16) != 0) {
                this.f2136a.addView(view);
            } else {
                this.f2136a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.t
    public Menu c() {
        return this.f2136a.getMenu();
    }

    @Override // androidx.appcompat.widget.t
    public boolean canShowOverflowMenu() {
        return this.f2136a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.t
    public void collapseActionView() {
        this.f2136a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.t
    public int d() {
        return this.f2150o;
    }

    @Override // androidx.appcompat.widget.t
    public ViewPropertyAnimatorCompat e(int i11, long j11) {
        return ViewCompat.animate(this.f2136a).alpha(i11 == 0 ? 1.0f : 0.0f).setDuration(j11).setListener(new b(i11));
    }

    @Override // androidx.appcompat.widget.t
    public boolean f() {
        return this.f2140e != null;
    }

    @Override // androidx.appcompat.widget.t
    public ViewGroup g() {
        return this.f2136a;
    }

    @Override // androidx.appcompat.widget.t
    public Context getContext() {
        return this.f2136a.getContext();
    }

    @Override // androidx.appcompat.widget.t
    public CharSequence getTitle() {
        return this.f2136a.getTitle();
    }

    @Override // androidx.appcompat.widget.t
    public void h(boolean z10) {
    }

    @Override // androidx.appcompat.widget.t
    public boolean hideOverflowMenu() {
        return this.f2136a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.t
    public void i() {
    }

    @Override // androidx.appcompat.widget.t
    public boolean isOverflowMenuShowPending() {
        return this.f2136a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.t
    public boolean isOverflowMenuShowing() {
        return this.f2136a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.t
    public void j(boolean z10) {
        this.f2136a.setCollapsible(z10);
    }

    @Override // androidx.appcompat.widget.t
    public void k() {
        this.f2136a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.t
    public void l(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2138c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2136a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2138c);
            }
        }
        this.f2138c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f2150o != 2) {
            return;
        }
        this.f2136a.addView(scrollingTabContainerView, 0);
        Toolbar.f fVar = (Toolbar.f) this.f2138c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) fVar).width = -2;
        ((ViewGroup.MarginLayoutParams) fVar).height = -2;
        fVar.f1179a = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.t
    public void m(SparseArray sparseArray) {
        this.f2136a.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.t
    public void n(int i11) {
        w(i11 != 0 ? g.a.b(getContext(), i11) : null);
    }

    @Override // androidx.appcompat.widget.t
    public void o(l.a aVar, f.a aVar2) {
        this.f2136a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.t
    public void p(SparseArray sparseArray) {
        this.f2136a.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.t
    public boolean q() {
        return this.f2141f != null;
    }

    @Override // androidx.appcompat.widget.t
    public int r() {
        return this.f2137b;
    }

    @Override // androidx.appcompat.widget.t
    public void s() {
    }

    @Override // androidx.appcompat.widget.t
    public void setIcon(int i11) {
        setIcon(i11 != 0 ? g.a.b(getContext(), i11) : null);
    }

    @Override // androidx.appcompat.widget.t
    public void setIcon(Drawable drawable) {
        this.f2140e = drawable;
        F();
    }

    @Override // androidx.appcompat.widget.t
    public void setMenu(Menu menu, l.a aVar) {
        if (this.f2149n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f2136a.getContext());
            this.f2149n = actionMenuPresenter;
            actionMenuPresenter.r(R$id.action_menu_presenter);
        }
        this.f2149n.d(aVar);
        this.f2136a.setMenu((androidx.appcompat.view.menu.f) menu, this.f2149n);
    }

    @Override // androidx.appcompat.widget.t
    public void setMenuPrepared() {
        this.f2148m = true;
    }

    @Override // androidx.appcompat.widget.t
    public void setVisibility(int i11) {
        this.f2136a.setVisibility(i11);
    }

    @Override // androidx.appcompat.widget.t
    public void setWindowCallback(Window.Callback callback) {
        this.f2147l = callback;
    }

    @Override // androidx.appcompat.widget.t
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f2143h) {
            return;
        }
        C(charSequence);
    }

    @Override // androidx.appcompat.widget.t
    public boolean showOverflowMenu() {
        return this.f2136a.showOverflowMenu();
    }

    public void u(View view) {
        View view2 = this.f2139d;
        if (view2 != null && (this.f2137b & 16) != 0) {
            this.f2136a.removeView(view2);
        }
        this.f2139d = view;
        if (view == null || (this.f2137b & 16) == 0) {
            return;
        }
        this.f2136a.addView(view);
    }

    public void v(int i11) {
        if (i11 == this.f2151p) {
            return;
        }
        this.f2151p = i11;
        if (TextUtils.isEmpty(this.f2136a.getNavigationContentDescription())) {
            x(this.f2151p);
        }
    }

    public void w(Drawable drawable) {
        this.f2141f = drawable;
        F();
    }

    public void x(int i11) {
        y(i11 == 0 ? null : getContext().getString(i11));
    }

    public void y(CharSequence charSequence) {
        this.f2146k = charSequence;
        D();
    }

    public void z(Drawable drawable) {
        this.f2142g = drawable;
        E();
    }
}
