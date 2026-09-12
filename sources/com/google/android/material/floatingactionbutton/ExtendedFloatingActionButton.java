package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private static final int I = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property J = new f(Float.class, "width");
    static final Property K = new g(Float.class, "height");
    static final Property L = new h(Float.class, "paddingStart");
    static final Property M = new i(Float.class, "paddingEnd");
    private final CoordinatorLayout.c A;
    private boolean B;
    private boolean C;
    private boolean D;
    protected ColorStateList E;
    private int F;
    private int G;
    private final int H;

    /* renamed from: r, reason: collision with root package name */
    private int f28978r;

    /* renamed from: s, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f28979s;

    /* renamed from: t, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.f f28980t;

    /* renamed from: u, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.f f28981u;

    /* renamed from: v, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.f f28982v;

    /* renamed from: w, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.f f28983w;

    /* renamed from: x, reason: collision with root package name */
    private final int f28984x;

    /* renamed from: y, reason: collision with root package name */
    private int f28985y;

    /* renamed from: z, reason: collision with root package name */
    private int f28986z;

    /* loaded from: classes4.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c {

        /* renamed from: a, reason: collision with root package name */
        private Rect f28987a;

        /* renamed from: b, reason: collision with root package name */
        private l f28988b;

        /* renamed from: c, reason: collision with root package name */
        private l f28989c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f28990d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f28991e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f28990d = false;
            this.f28991e = true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f28990d = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f28991e = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f28990d || this.f28991e) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f28987a == null) {
                this.f28987a = new Rect();
            }
            Rect rect = this.f28987a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        protected void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z10 = this.f28991e;
            extendedFloatingActionButton.y(z10 ? 3 : 0, z10 ? this.f28989c : this.f28988b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i11) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i12 = 0; i12 < size; i12++) {
                View view = dependencies.get(i12);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i11);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z10 = this.f28991e;
            extendedFloatingActionButton.y(z10 ? 2 : 1, z10 ? this.f28989c : this.f28988b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f7989h == 0) {
                fVar.f7989h = 80;
            }
        }
    }

    /* loaded from: classes4.dex */
    class a implements n {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements n {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.f28986z;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f28985y;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.f28985y + ExtendedFloatingActionButton.this.f28986z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f28994a;

        c(n nVar) {
            this.f28994a = nVar;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(-1, ExtendedFloatingActionButton.this.G == 0 ? -2 : ExtendedFloatingActionButton.this.G);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (ExtendedFloatingActionButton.this.G != -1) {
                return (ExtendedFloatingActionButton.this.G == 0 || ExtendedFloatingActionButton.this.G == -2) ? this.f28994a.getHeight() : ExtendedFloatingActionButton.this.G;
            }
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.f28994a.getHeight();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                return (view.getHeight() - ((!(ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) == null) ? 0 : marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)) - (view.getPaddingTop() + view.getPaddingBottom());
            }
            return this.f28994a.getHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.f28986z;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f28985y;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.f28994a.getWidth();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.width != -2) {
                return (view.getWidth() - ((!(ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) == null) ? 0 : marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)) - (view.getPaddingLeft() + view.getPaddingRight());
            }
            return this.f28994a.getWidth();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f28996a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f28997b;

        d(n nVar, n nVar2) {
            this.f28996a = nVar;
            this.f28997b = nVar2;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.this.F == 0 ? -2 : ExtendedFloatingActionButton.this.F, ExtendedFloatingActionButton.this.G != 0 ? ExtendedFloatingActionButton.this.G : -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.G == -1 ? this.f28996a.getHeight() : (ExtendedFloatingActionButton.this.G == 0 || ExtendedFloatingActionButton.this.G == -2) ? this.f28997b.getHeight() : ExtendedFloatingActionButton.this.G;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.f28986z;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f28985y;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return ExtendedFloatingActionButton.this.F == -1 ? this.f28996a.getWidth() : (ExtendedFloatingActionButton.this.F == 0 || ExtendedFloatingActionButton.this.F == -2) ? this.f28997b.getWidth() : ExtendedFloatingActionButton.this.F;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f28999a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.f f29000b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f29001c;

        e(com.google.android.material.floatingactionbutton.f fVar, l lVar) {
            this.f29000b = fVar;
            this.f29001c = lVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f28999a = true;
            this.f29000b.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f29000b.a();
            if (this.f28999a) {
                return;
            }
            this.f29000b.l(this.f29001c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f29000b.onAnimationStart(animator);
            this.f28999a = false;
        }
    }

    /* loaded from: classes4.dex */
    class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f11) {
            view.getLayoutParams().width = f11.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f11) {
            view.getLayoutParams().height = f11.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    class h extends Property {
        h(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f11) {
            ViewCompat.setPaddingRelative(view, f11.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    /* loaded from: classes4.dex */
    class i extends Property {
        i(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f11) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f11.intValue(), view.getPaddingBottom());
        }
    }

    /* loaded from: classes4.dex */
    class j extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g, reason: collision with root package name */
        private final n f29003g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f29004h;

        j(com.google.android.material.floatingactionbutton.a aVar, n nVar, boolean z10) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f29003g = nVar;
            this.f29004h = z10;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.C = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f29003g.a().width;
            layoutParams.height = this.f29003g.a().height;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.B = this.f29004h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.f29004h) {
                ExtendedFloatingActionButton.this.F = layoutParams.width;
                ExtendedFloatingActionButton.this.G = layoutParams.height;
            }
            layoutParams.width = this.f29003g.a().width;
            layoutParams.height = this.f29003g.a().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f29003g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f29003g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return this.f29004h == ExtendedFloatingActionButton.this.B || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return this.f29004h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public AnimatorSet j() {
            oa.h o11 = o();
            if (o11.j("width")) {
                PropertyValuesHolder[] g11 = o11.g("width");
                g11[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f29003g.getWidth());
                o11.l("width", g11);
            }
            if (o11.j("height")) {
                PropertyValuesHolder[] g12 = o11.g("height");
                g12[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f29003g.getHeight());
                o11.l("height", g12);
            }
            if (o11.j("paddingStart")) {
                PropertyValuesHolder[] g13 = o11.g("paddingStart");
                g13[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f29003g.getPaddingStart());
                o11.l("paddingStart", g13);
            }
            if (o11.j("paddingEnd")) {
                PropertyValuesHolder[] g14 = o11.g("paddingEnd");
                g14[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f29003g.getPaddingEnd());
                o11.l("paddingEnd", g14);
            }
            if (o11.j("labelOpacity")) {
                PropertyValuesHolder[] g15 = o11.g("labelOpacity");
                boolean z10 = this.f29004h;
                g15[0].setFloatValues(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
                o11.l("labelOpacity", g15);
            }
            return super.n(o11);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void l(l lVar) {
            if (lVar == null) {
                return;
            }
            if (this.f29004h) {
                lVar.a(ExtendedFloatingActionButton.this);
            } else {
                lVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.B = this.f29004h;
            ExtendedFloatingActionButton.this.C = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* loaded from: classes4.dex */
    class k extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g, reason: collision with root package name */
        private boolean f29006g;

        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.f28978r = 0;
            if (this.f29006g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.w();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void f() {
            super.f();
            this.f29006g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void l(l lVar) {
            if (lVar != null) {
                lVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f29006g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f28978r = 1;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class l {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    /* loaded from: classes4.dex */
    class m extends com.google.android.material.floatingactionbutton.b {
        public m(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.f28978r = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.x();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void l(l lVar) {
            if (lVar != null) {
                lVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f28978r = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface n {
        ViewGroup.LayoutParams a();

        int getHeight();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.I
            r1 = r17
            android.content.Context r1 = bb.a.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.f28978r = r10
            com.google.android.material.floatingactionbutton.a r1 = new com.google.android.material.floatingactionbutton.a
            r1.<init>()
            r0.f28979s = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$m r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$m
            r11.<init>(r1)
            r0.f28982v = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
            r12.<init>(r1)
            r0.f28983w = r12
            r13 = 1
            r0.B = r13
            r0.C = r10
            r0.D = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.A = r1
            int[] r3 = com.google.android.material.R$styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.b0.i(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_showMotionSpec
            oa.h r2 = oa.h.c(r14, r1, r2)
            int r3 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_hideMotionSpec
            oa.h r3 = oa.h.c(r14, r1, r3)
            int r4 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_extendMotionSpec
            oa.h r4 = oa.h.c(r14, r1, r4)
            int r5 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            oa.h r5 = oa.h.c(r14, r1, r5)
            int r6 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.f28984x = r6
            int r6 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_extendStrategy
            int r6 = r1.getInt(r6, r13)
            r0.H = r6
            int r15 = androidx.core.view.ViewCompat.getPaddingStart(r16)
            r0.f28985y = r15
            int r15 = androidx.core.view.ViewCompat.getPaddingEnd(r16)
            r0.f28986z = r15
            com.google.android.material.floatingactionbutton.a r15 = new com.google.android.material.floatingactionbutton.a
            r15.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$n r6 = r0.v(r6)
            r10.<init>(r15, r6, r13)
            r0.f28981u = r10
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j r6 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            r13.<init>()
            r7 = 0
            r6.<init>(r15, r13, r7)
            r0.f28980t = r6
            r11.i(r2)
            r12.i(r3)
            r10.i(r4)
            r6.i(r5)
            r1.recycle()
            ab.d r1 = ab.n.f601m
            r2 = r18
            ab.n$b r1 = ab.n.g(r14, r2, r8, r9, r1)
            ab.n r1 = r1.m()
            r0.setShapeAppearanceModel(r1)
            r16.z()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private boolean A() {
        return (ViewCompat.isLaidOut(this) || (!x() && this.D)) && !isInEditMode();
    }

    private n v(int i11) {
        b bVar = new b();
        c cVar = new c(bVar);
        return i11 != 1 ? i11 != 2 ? new d(cVar, bVar) : cVar : bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return getVisibility() == 0 ? this.f28978r == 1 : this.f28978r != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        return getVisibility() != 0 ? this.f28978r == 2 : this.f28978r != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i11, l lVar) {
        com.google.android.material.floatingactionbutton.f fVar;
        if (i11 == 0) {
            fVar = this.f28982v;
        } else if (i11 == 1) {
            fVar = this.f28983w;
        } else if (i11 == 2) {
            fVar = this.f28980t;
        } else {
            if (i11 != 3) {
                throw new IllegalStateException("Unknown strategy type: " + i11);
            }
            fVar = this.f28981u;
        }
        if (fVar.d()) {
            return;
        }
        if (!A()) {
            fVar.b();
            fVar.l(lVar);
            return;
        }
        if (i11 == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.F = layoutParams.width;
                this.G = layoutParams.height;
            } else {
                this.F = getWidth();
                this.G = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet j11 = fVar.j();
        j11.addListener(new e(fVar, lVar));
        Iterator it = fVar.k().iterator();
        while (it.hasNext()) {
            j11.addListener((Animator.AnimatorListener) it.next());
        }
        j11.start();
    }

    private void z() {
        this.E = getTextColors();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28981u.h(animatorListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28983w.h(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28982v.h(animatorListener);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28980t.h(animatorListener);
    }

    public void extend() {
        y(3, null);
    }

    public void extend(@NonNull l lVar) {
        y(3, lVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public CoordinatorLayout.c getBehavior() {
        return this.A;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i11 = this.f28984x;
        return i11 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i11;
    }

    @Nullable
    public oa.h getExtendMotionSpec() {
        return this.f28981u.c();
    }

    @Nullable
    public oa.h getHideMotionSpec() {
        return this.f28983w.c();
    }

    @Nullable
    public oa.h getShowMotionSpec() {
        return this.f28982v.c();
    }

    @Nullable
    public oa.h getShrinkMotionSpec() {
        return this.f28980t.c();
    }

    public void hide() {
        y(1, null);
    }

    public void hide(@NonNull l lVar) {
        y(1, lVar);
    }

    public final boolean isExtended() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.B && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.B = false;
            this.f28980t.b();
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28981u.e(animatorListener);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28983w.e(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28982v.e(animatorListener);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f28980t.e(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.D = z10;
    }

    public void setExtendMotionSpec(@Nullable oa.h hVar) {
        this.f28981u.i(hVar);
    }

    public void setExtendMotionSpecResource(int i11) {
        setExtendMotionSpec(oa.h.d(getContext(), i11));
    }

    public void setExtended(boolean z10) {
        if (this.B == z10) {
            return;
        }
        com.google.android.material.floatingactionbutton.f fVar = z10 ? this.f28981u : this.f28980t;
        if (fVar.d()) {
            return;
        }
        fVar.b();
    }

    public void setHideMotionSpec(@Nullable oa.h hVar) {
        this.f28983w.i(hVar);
    }

    public void setHideMotionSpecResource(int i11) {
        setHideMotionSpec(oa.h.d(getContext(), i11));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
        if (!this.B || this.C) {
            return;
        }
        this.f28985y = ViewCompat.getPaddingStart(this);
        this.f28986z = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
        super.setPaddingRelative(i11, i12, i13, i14);
        if (!this.B || this.C) {
            return;
        }
        this.f28985y = i11;
        this.f28986z = i13;
    }

    public void setShowMotionSpec(@Nullable oa.h hVar) {
        this.f28982v.i(hVar);
    }

    public void setShowMotionSpecResource(int i11) {
        setShowMotionSpec(oa.h.d(getContext(), i11));
    }

    public void setShrinkMotionSpec(@Nullable oa.h hVar) {
        this.f28980t.i(hVar);
    }

    public void setShrinkMotionSpecResource(int i11) {
        setShrinkMotionSpec(oa.h.d(getContext(), i11));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i11) {
        super.setTextColor(i11);
        z();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        z();
    }

    public void show() {
        y(0, null);
    }

    public void show(@NonNull l lVar) {
        y(0, lVar);
    }

    public void shrink() {
        y(2, null);
    }

    public void shrink(@NonNull l lVar) {
        y(2, lVar);
    }
}
