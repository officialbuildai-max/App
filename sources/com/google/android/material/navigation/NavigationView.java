package com.google.android.material.navigation;

import ab.j;
import ab.n;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.j0;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.g0;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import java.util.Objects;
import pa.a;
import wa.i;

/* loaded from: classes4.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements wa.b {

    /* renamed from: w, reason: collision with root package name */
    private static final int[] f29422w = {R.attr.state_checked};

    /* renamed from: x, reason: collision with root package name */
    private static final int[] f29423x = {-16842910};

    /* renamed from: y, reason: collision with root package name */
    private static final int f29424y = R$style.Widget_Design_NavigationView;

    /* renamed from: h, reason: collision with root package name */
    private final r f29425h;

    /* renamed from: i, reason: collision with root package name */
    private final s f29426i;

    /* renamed from: j, reason: collision with root package name */
    private final int f29427j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f29428k;

    /* renamed from: l, reason: collision with root package name */
    private MenuInflater f29429l;

    /* renamed from: m, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f29430m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f29431n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f29432o;

    /* renamed from: p, reason: collision with root package name */
    private int f29433p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f29434q;

    /* renamed from: r, reason: collision with root package name */
    private final int f29435r;

    /* renamed from: s, reason: collision with root package name */
    private final ab.r f29436s;

    /* renamed from: t, reason: collision with root package name */
    private final i f29437t;

    /* renamed from: u, reason: collision with root package name */
    private final wa.c f29438u;

    /* renamed from: v, reason: collision with root package name */
    private final DrawerLayout.e f29439v;

    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        @Nullable
        public Bundle menuState;

        /* loaded from: classes4.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeBundle(this.menuState);
        }
    }

    /* loaded from: classes4.dex */
    class a extends DrawerLayout.g {
        a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.g, androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                final wa.c cVar = navigationView.f29438u;
                Objects.requireNonNull(cVar);
                view.post(new Runnable() { // from class: com.google.android.material.navigation.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        wa.c.this.e();
                    }
                });
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.g, androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                navigationView.f29438u.f();
                NavigationView.this.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    class b implements f.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f29428k);
            boolean z10 = true;
            boolean z11 = NavigationView.this.f29428k[1] == 0;
            NavigationView.this.f29426i.F(z11);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z11 && navigationView2.isTopInsetScrimEnabled());
            NavigationView.this.setDrawLeftInsetForeground(NavigationView.this.f29428k[0] == 0 || NavigationView.this.f29428k[0] + NavigationView.this.getWidth() == 0);
            Activity a11 = com.google.android.material.internal.c.a(NavigationView.this.getContext());
            if (a11 != null) {
                Rect a12 = g0.a(a11);
                boolean z12 = a12.height() - NavigationView.this.getHeight() == NavigationView.this.f29428k[1];
                boolean z13 = Color.alpha(a11.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView3 = NavigationView.this;
                navigationView3.setDrawBottomInsetForeground(z12 && z13 && navigationView3.isBottomInsetScrimEnabled());
                if (a12.width() != NavigationView.this.f29428k[0] && a12.width() - NavigationView.this.getWidth() != NavigationView.this.f29428k[0]) {
                    z10 = false;
                }
                NavigationView.this.setDrawRightInsetForeground(z10);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private ColorStateList g(int i11) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i11, typedValue, true)) {
            return null;
        }
        ColorStateList a11 = g.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i12 = typedValue.data;
        int defaultColor = a11.getDefaultColor();
        int[] iArr = f29423x;
        return new ColorStateList(new int[][]{iArr, f29422w, FrameLayout.EMPTY_STATE_SET}, new int[]{a11.getColorForState(iArr, defaultColor), i12, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.f29429l == null) {
            this.f29429l = new g(getContext());
        }
        return this.f29429l;
    }

    private Drawable h(j0 j0Var) {
        return i(j0Var, xa.c.b(getContext(), j0Var, R$styleable.NavigationView_itemShapeFillColor));
    }

    private Drawable i(j0 j0Var, ColorStateList colorStateList) {
        ab.i iVar = new ab.i(n.b(getContext(), j0Var.n(R$styleable.NavigationView_itemShapeAppearance, 0), j0Var.n(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        iVar.d0(colorStateList);
        return new InsetDrawable((Drawable) iVar, j0Var.f(R$styleable.NavigationView_itemShapeInsetStart, 0), j0Var.f(R$styleable.NavigationView_itemShapeInsetTop, 0), j0Var.f(R$styleable.NavigationView_itemShapeInsetEnd, 0), j0Var.f(R$styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private boolean j(j0 j0Var) {
        return j0Var.s(R$styleable.NavigationView_itemShapeAppearance) || j0Var.s(R$styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.f29434q || this.f29433p == 0) {
            return;
        }
        this.f29433p = 0;
        m(getWidth(), getHeight());
    }

    private void m(int i11, int i12) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.f)) {
            if ((this.f29433p > 0 || this.f29434q) && (getBackground() instanceof ab.i)) {
                boolean z10 = GravityCompat.getAbsoluteGravity(((DrawerLayout.f) getLayoutParams()).f9058a, ViewCompat.getLayoutDirection(this)) == 3;
                ab.i iVar = (ab.i) getBackground();
                n.b o11 = iVar.G().v().o(this.f29433p);
                if (z10) {
                    o11.H(0.0f);
                    o11.w(0.0f);
                } else {
                    o11.M(0.0f);
                    o11.B(0.0f);
                }
                n m11 = o11.m();
                iVar.setShapeAppearanceModel(m11);
                this.f29436s.g(this, m11);
                this.f29436s.f(this, new RectF(0.0f, 0.0f, i11, i12));
                this.f29436s.i(this, true);
            }
        }
    }

    private Pair n() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.f)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.f) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    private void o() {
        this.f29430m = new c();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f29430m);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void a(WindowInsetsCompat windowInsetsCompat) {
        this.f29426i.m(windowInsetsCompat);
    }

    public void addHeaderView(@NonNull View view) {
        this.f29426i.l(view);
    }

    @Override // wa.b
    public void cancelBackProgress() {
        n();
        this.f29437t.f();
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f29436s.e(canvas, new a.InterfaceC0910a() { // from class: com.google.android.material.navigation.e
            @Override // pa.a.InterfaceC0910a
            public final void a(Canvas canvas2) {
                NavigationView.this.k(canvas2);
            }
        });
    }

    i getBackHelper() {
        return this.f29437t;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f29426i.n();
    }

    public int getDividerInsetEnd() {
        return this.f29426i.o();
    }

    public int getDividerInsetStart() {
        return this.f29426i.p();
    }

    public int getHeaderCount() {
        return this.f29426i.q();
    }

    public View getHeaderView(int i11) {
        return this.f29426i.r(i11);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f29426i.s();
    }

    public int getItemHorizontalPadding() {
        return this.f29426i.t();
    }

    public int getItemIconPadding() {
        return this.f29426i.u();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f29426i.x();
    }

    public int getItemMaxLines() {
        return this.f29426i.v();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f29426i.w();
    }

    public int getItemVerticalPadding() {
        return this.f29426i.y();
    }

    @NonNull
    public Menu getMenu() {
        return this.f29425h;
    }

    public int getSubheaderInsetEnd() {
        return this.f29426i.A();
    }

    public int getSubheaderInsetStart() {
        return this.f29426i.B();
    }

    @Override // wa.b
    public void handleBackInvoked() {
        Pair n11 = n();
        DrawerLayout drawerLayout = (DrawerLayout) n11.first;
        androidx.activity.b c11 = this.f29437t.c();
        if (c11 == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.closeDrawer(this);
            return;
        }
        this.f29437t.h(c11, ((DrawerLayout.f) n11.second).f9058a, com.google.android.material.navigation.b.b(drawerLayout, this), com.google.android.material.navigation.b.c(drawerLayout));
    }

    public View inflateHeaderView(int i11) {
        return this.f29426i.D(i11);
    }

    public void inflateMenu(int i11) {
        this.f29426i.a0(true);
        getMenuInflater().inflate(i11, this.f29425h);
        this.f29426i.a0(false);
        this.f29426i.h(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.f29432o;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.f29431n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f29438u.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.removeDrawerListener(this.f29439v);
            drawerLayout.addDrawerListener(this.f29439v);
            if (drawerLayout.isDrawerOpen(this)) {
                this.f29438u.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f29430m);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).removeDrawerListener(this.f29439v);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), this.f29427j), 1073741824);
        } else if (mode == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(this.f29427j, 1073741824);
        }
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f29425h.T(savedState.menuState);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.f29425h.V(bundle);
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        m(i11, i12);
    }

    public void removeHeaderView(@NonNull View view) {
        this.f29426i.E(view);
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.f29432o = z10;
    }

    public void setCheckedItem(int i11) {
        MenuItem findItem = this.f29425h.findItem(i11);
        if (findItem != null) {
            this.f29426i.G((h) findItem);
        }
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.f29425h.findItem(menuItem.getItemId());
        if (findItem == null) {
            throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        }
        this.f29426i.G((h) findItem);
    }

    public void setDividerInsetEnd(int i11) {
        this.f29426i.H(i11);
    }

    public void setDividerInsetStart(int i11) {
        this.f29426i.I(i11);
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        j.d(this, f11);
    }

    public void setForceCompatClippingEnabled(boolean z10) {
        this.f29436s.h(this, z10);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f29426i.K(drawable);
    }

    public void setItemBackgroundResource(int i11) {
        setItemBackground(androidx.core.content.b.getDrawable(getContext(), i11));
    }

    public void setItemHorizontalPadding(int i11) {
        this.f29426i.M(i11);
    }

    public void setItemHorizontalPaddingResource(int i11) {
        this.f29426i.M(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconPadding(int i11) {
        this.f29426i.N(i11);
    }

    public void setItemIconPaddingResource(int i11) {
        this.f29426i.N(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconSize(int i11) {
        this.f29426i.O(i11);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f29426i.P(colorStateList);
    }

    public void setItemMaxLines(int i11) {
        this.f29426i.Q(i11);
    }

    public void setItemTextAppearance(int i11) {
        this.f29426i.R(i11);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f29426i.S(z10);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f29426i.T(colorStateList);
    }

    public void setItemVerticalPadding(int i11) {
        this.f29426i.U(i11);
    }

    public void setItemVerticalPaddingResource(int i11) {
        this.f29426i.U(getResources().getDimensionPixelSize(i11));
    }

    public void setNavigationItemSelectedListener(@Nullable d dVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i11) {
        super.setOverScrollMode(i11);
        s sVar = this.f29426i;
        if (sVar != null) {
            sVar.V(i11);
        }
    }

    public void setSubheaderInsetEnd(int i11) {
        this.f29426i.X(i11);
    }

    public void setSubheaderInsetStart(int i11) {
        this.f29426i.Y(i11);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.f29431n = z10;
    }

    @Override // wa.b
    public void startBackProgress(@NonNull androidx.activity.b bVar) {
        n();
        this.f29437t.j(bVar);
    }

    @Override // wa.b
    public void updateBackProgress(@NonNull androidx.activity.b bVar) {
        this.f29437t.l(bVar, ((DrawerLayout.f) n().second).f9058a);
        if (this.f29434q) {
            this.f29433p = oa.a.c(0, this.f29435r, this.f29437t.a(bVar.a()));
            m(getWidth(), getHeight());
        }
    }
}
