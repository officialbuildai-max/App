package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d0 extends androidx.appcompat.app.a implements ActionBarOverlayLayout.b {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;

    /* renamed from: a, reason: collision with root package name */
    Context f1201a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1202b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f1203c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f1204d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarContainer f1205e;

    /* renamed from: f, reason: collision with root package name */
    androidx.appcompat.widget.t f1206f;

    /* renamed from: g, reason: collision with root package name */
    ActionBarContextView f1207g;

    /* renamed from: h, reason: collision with root package name */
    View f1208h;

    /* renamed from: i, reason: collision with root package name */
    ScrollingTabContainerView f1209i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1212l;

    /* renamed from: m, reason: collision with root package name */
    d f1213m;

    /* renamed from: n, reason: collision with root package name */
    androidx.appcompat.view.b f1214n;

    /* renamed from: o, reason: collision with root package name */
    b.a f1215o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1216p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1218r;

    /* renamed from: u, reason: collision with root package name */
    boolean f1221u;

    /* renamed from: v, reason: collision with root package name */
    boolean f1222v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1223w;

    /* renamed from: y, reason: collision with root package name */
    androidx.appcompat.view.h f1225y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f1226z;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f1210j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private int f1211k = -1;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList f1217q = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    private int f1219s = 0;

    /* renamed from: t, reason: collision with root package name */
    boolean f1220t = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f1224x = true;
    final ViewPropertyAnimatorListener B = new a();
    final ViewPropertyAnimatorListener C = new b();
    final ViewPropertyAnimatorUpdateListener D = new c();

    /* loaded from: classes.dex */
    class a extends ViewPropertyAnimatorListenerAdapter {
        a() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            View view2;
            d0 d0Var = d0.this;
            if (d0Var.f1220t && (view2 = d0Var.f1208h) != null) {
                view2.setTranslationY(0.0f);
                d0.this.f1205e.setTranslationY(0.0f);
            }
            d0.this.f1205e.setVisibility(8);
            d0.this.f1205e.setTransitioning(false);
            d0 d0Var2 = d0.this;
            d0Var2.f1225y = null;
            d0Var2.y();
            ActionBarOverlayLayout actionBarOverlayLayout = d0.this.f1204d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends ViewPropertyAnimatorListenerAdapter {
        b() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            d0 d0Var = d0.this;
            d0Var.f1225y = null;
            d0Var.f1205e.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements ViewPropertyAnimatorUpdateListener {
        c() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) d0.this.f1205e.getParent()).invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends androidx.appcompat.view.b implements f.a {

        /* renamed from: c, reason: collision with root package name */
        private final Context f1230c;

        /* renamed from: d, reason: collision with root package name */
        private final androidx.appcompat.view.menu.f f1231d;

        /* renamed from: e, reason: collision with root package name */
        private b.a f1232e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference f1233f;

        public d(Context context, b.a aVar) {
            this.f1230c = context;
            this.f1232e = aVar;
            androidx.appcompat.view.menu.f X = new androidx.appcompat.view.menu.f(context).X(1);
            this.f1231d = X;
            X.W(this);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            b.a aVar = this.f1232e;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
            if (this.f1232e == null) {
                return;
            }
            k();
            d0.this.f1207g.showOverflowMenu();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            d0 d0Var = d0.this;
            if (d0Var.f1213m != this) {
                return;
            }
            if (d0.x(d0Var.f1221u, d0Var.f1222v, false)) {
                this.f1232e.a(this);
            } else {
                d0 d0Var2 = d0.this;
                d0Var2.f1214n = this;
                d0Var2.f1215o = this.f1232e;
            }
            this.f1232e = null;
            d0.this.w(false);
            d0.this.f1207g.closeMode();
            d0 d0Var3 = d0.this;
            d0Var3.f1204d.setHideOnContentScrollEnabled(d0Var3.A);
            d0.this.f1213m = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference weakReference = this.f1233f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f1231d;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f1230c);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return d0.this.f1207g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return d0.this.f1207g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (d0.this.f1213m != this) {
                return;
            }
            this.f1231d.i0();
            try {
                this.f1232e.d(this, this.f1231d);
            } finally {
                this.f1231d.h0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return d0.this.f1207g.isTitleOptional();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            d0.this.f1207g.setCustomView(view);
            this.f1233f = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i11) {
            o(d0.this.f1201a.getResources().getString(i11));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            d0.this.f1207g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i11) {
            r(d0.this.f1201a.getResources().getString(i11));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            d0.this.f1207g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z10) {
            super.s(z10);
            d0.this.f1207g.setTitleOptional(z10);
        }

        public boolean t() {
            this.f1231d.i0();
            try {
                return this.f1232e.b(this, this.f1231d);
            } finally {
                this.f1231d.h0();
            }
        }
    }

    public d0(Activity activity, boolean z10) {
        this.f1203c = activity;
        View decorView = activity.getWindow().getDecorView();
        E(decorView);
        if (z10) {
            return;
        }
        this.f1208h = decorView.findViewById(R.id.content);
    }

    public d0(Dialog dialog) {
        E(dialog.getWindow().getDecorView());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private androidx.appcompat.widget.t B(View view) {
        if (view instanceof androidx.appcompat.widget.t) {
            return (androidx.appcompat.widget.t) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb2.toString());
    }

    private void D() {
        if (this.f1223w) {
            this.f1223w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1204d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            N(false);
        }
    }

    private void E(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f1204d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1206f = B(view.findViewById(R$id.action_bar));
        this.f1207g = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f1205e = actionBarContainer;
        androidx.appcompat.widget.t tVar = this.f1206f;
        if (tVar == null || this.f1207g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1201a = tVar.getContext();
        boolean z10 = (this.f1206f.r() & 4) != 0;
        if (z10) {
            this.f1212l = true;
        }
        androidx.appcompat.view.a b11 = androidx.appcompat.view.a.b(this.f1201a);
        K(b11.a() || z10);
        I(b11.g());
        TypedArray obtainStyledAttributes = this.f1201a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            J(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            H(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void I(boolean z10) {
        this.f1218r = z10;
        if (z10) {
            this.f1205e.setTabContainer(null);
            this.f1206f.l(this.f1209i);
        } else {
            this.f1206f.l(null);
            this.f1205e.setTabContainer(this.f1209i);
        }
        boolean z11 = C() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f1209i;
        if (scrollingTabContainerView != null) {
            if (z11) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1204d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f1206f.j(!this.f1218r && z11);
        this.f1204d.setHasNonEmbeddedTabs(!this.f1218r && z11);
    }

    private boolean L() {
        return this.f1205e.isLaidOut();
    }

    private void M() {
        if (this.f1223w) {
            return;
        }
        this.f1223w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1204d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        N(false);
    }

    private void N(boolean z10) {
        if (x(this.f1221u, this.f1222v, this.f1223w)) {
            if (this.f1224x) {
                return;
            }
            this.f1224x = true;
            A(z10);
            return;
        }
        if (this.f1224x) {
            this.f1224x = false;
            z(z10);
        }
    }

    static boolean x(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    public void A(boolean z10) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f1225y;
        if (hVar != null) {
            hVar.a();
        }
        this.f1205e.setVisibility(0);
        if (this.f1219s == 0 && (this.f1226z || z10)) {
            this.f1205e.setTranslationY(0.0f);
            float f11 = -this.f1205e.getHeight();
            if (z10) {
                this.f1205e.getLocationInWindow(new int[]{0, 0});
                f11 -= r5[1];
            }
            this.f1205e.setTranslationY(f11);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1205e).translationY(0.0f);
            translationY.setUpdateListener(this.D);
            hVar2.c(translationY);
            if (this.f1220t && (view2 = this.f1208h) != null) {
                view2.setTranslationY(f11);
                hVar2.c(ViewCompat.animate(this.f1208h).translationY(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250L);
            hVar2.g(this.C);
            this.f1225y = hVar2;
            hVar2.h();
        } else {
            this.f1205e.setAlpha(1.0f);
            this.f1205e.setTranslationY(0.0f);
            if (this.f1220t && (view = this.f1208h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1204d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public int C() {
        return this.f1206f.d();
    }

    public void F(boolean z10) {
        G(z10 ? 4 : 0, 4);
    }

    public void G(int i11, int i12) {
        int r11 = this.f1206f.r();
        if ((i12 & 4) != 0) {
            this.f1212l = true;
        }
        this.f1206f.b((i11 & i12) | ((~i12) & r11));
    }

    public void H(float f11) {
        ViewCompat.setElevation(this.f1205e, f11);
    }

    public void J(boolean z10) {
        if (z10 && !this.f1204d.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z10;
        this.f1204d.setHideOnContentScrollEnabled(z10);
    }

    public void K(boolean z10) {
        this.f1206f.h(z10);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void a() {
        if (this.f1222v) {
            this.f1222v = false;
            N(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void b(int i11) {
        this.f1219s = i11;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void c() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void d(boolean z10) {
        this.f1220t = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void e() {
        if (this.f1222v) {
            return;
        }
        this.f1222v = true;
        N(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void f() {
        androidx.appcompat.view.h hVar = this.f1225y;
        if (hVar != null) {
            hVar.a();
            this.f1225y = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        androidx.appcompat.widget.t tVar = this.f1206f;
        if (tVar == null || !tVar.a()) {
            return false;
        }
        this.f1206f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 == this.f1216p) {
            return;
        }
        this.f1216p = z10;
        if (this.f1217q.size() <= 0) {
            return;
        }
        android.support.v4.media.session.c.a(this.f1217q.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f1206f.r();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f1202b == null) {
            TypedValue typedValue = new TypedValue();
            this.f1201a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                this.f1202b = new ContextThemeWrapper(this.f1201a, i11);
            } else {
                this.f1202b = this.f1201a;
            }
        }
        return this.f1202b;
    }

    @Override // androidx.appcompat.app.a
    public void l() {
        if (this.f1221u) {
            return;
        }
        this.f1221u = true;
        N(false);
    }

    @Override // androidx.appcompat.app.a
    public void n(Configuration configuration) {
        I(androidx.appcompat.view.a.b(this.f1201a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean p(int i11, KeyEvent keyEvent) {
        Menu e11;
        d dVar = this.f1213m;
        if (dVar == null || (e11 = dVar.e()) == null) {
            return false;
        }
        e11.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return e11.performShortcut(i11, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        if (this.f1212l) {
            return;
        }
        F(z10);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
        androidx.appcompat.view.h hVar;
        this.f1226z = z10;
        if (z10 || (hVar = this.f1225y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void u(CharSequence charSequence) {
        this.f1206f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b v(b.a aVar) {
        d dVar = this.f1213m;
        if (dVar != null) {
            dVar.c();
        }
        this.f1204d.setHideOnContentScrollEnabled(false);
        this.f1207g.killMode();
        d dVar2 = new d(this.f1207g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f1213m = dVar2;
        dVar2.k();
        this.f1207g.initForMode(dVar2);
        w(true);
        return dVar2;
    }

    public void w(boolean z10) {
        ViewPropertyAnimatorCompat e11;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (z10) {
            M();
        } else {
            D();
        }
        if (!L()) {
            if (z10) {
                this.f1206f.setVisibility(4);
                this.f1207g.setVisibility(0);
                return;
            } else {
                this.f1206f.setVisibility(0);
                this.f1207g.setVisibility(8);
                return;
            }
        }
        if (z10) {
            viewPropertyAnimatorCompat = this.f1206f.e(4, 100L);
            e11 = this.f1207g.setupAnimatorToVisibility(0, 200L);
        } else {
            e11 = this.f1206f.e(0, 200L);
            viewPropertyAnimatorCompat = this.f1207g.setupAnimatorToVisibility(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(viewPropertyAnimatorCompat, e11);
        hVar.h();
    }

    void y() {
        b.a aVar = this.f1215o;
        if (aVar != null) {
            aVar.a(this.f1214n);
            this.f1214n = null;
            this.f1215o = null;
        }
    }

    public void z(boolean z10) {
        View view;
        androidx.appcompat.view.h hVar = this.f1225y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f1219s != 0 || (!this.f1226z && !z10)) {
            this.B.onAnimationEnd(null);
            return;
        }
        this.f1205e.setAlpha(1.0f);
        this.f1205e.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f11 = -this.f1205e.getHeight();
        if (z10) {
            this.f1205e.getLocationInWindow(new int[]{0, 0});
            f11 -= r5[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1205e).translationY(f11);
        translationY.setUpdateListener(this.D);
        hVar2.c(translationY);
        if (this.f1220t && (view = this.f1208h) != null) {
            hVar2.c(ViewCompat.animate(view).translationY(f11));
        }
        hVar2.f(E);
        hVar2.e(250L);
        hVar2.g(this.B);
        this.f1225y = hVar2;
        hVar2.h();
    }
}
