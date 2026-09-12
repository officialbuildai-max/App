package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.view.Lifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    private ColorStateList A;
    private boolean B;
    private boolean C;
    private final ArrayList D;
    private final ArrayList E;
    private final int[] F;
    final MenuHostHelper G;
    private ArrayList H;
    g I;
    private final ActionMenuView.e J;
    private n0 K;
    private ActionMenuPresenter L;
    private e M;
    private l.a N;
    f.a O;
    private boolean P;
    private OnBackInvokedCallback Q;
    private OnBackInvokedDispatcher R;
    private boolean S;
    private final Runnable T;

    /* renamed from: a, reason: collision with root package name */
    ActionMenuView f1988a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f1989b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f1990c;

    /* renamed from: d, reason: collision with root package name */
    private ImageButton f1991d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f1992e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f1993f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f1994g;

    /* renamed from: h, reason: collision with root package name */
    ImageButton f1995h;

    /* renamed from: i, reason: collision with root package name */
    View f1996i;

    /* renamed from: j, reason: collision with root package name */
    private Context f1997j;

    /* renamed from: k, reason: collision with root package name */
    private int f1998k;

    /* renamed from: l, reason: collision with root package name */
    private int f1999l;

    /* renamed from: m, reason: collision with root package name */
    private int f2000m;

    /* renamed from: n, reason: collision with root package name */
    int f2001n;

    /* renamed from: o, reason: collision with root package name */
    private int f2002o;

    /* renamed from: p, reason: collision with root package name */
    private int f2003p;

    /* renamed from: q, reason: collision with root package name */
    private int f2004q;

    /* renamed from: r, reason: collision with root package name */
    private int f2005r;

    /* renamed from: s, reason: collision with root package name */
    private int f2006s;

    /* renamed from: t, reason: collision with root package name */
    private d0 f2007t;

    /* renamed from: u, reason: collision with root package name */
    private int f2008u;

    /* renamed from: v, reason: collision with root package name */
    private int f2009v;

    /* renamed from: w, reason: collision with root package name */
    private int f2010w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f2011x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f2012y;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f2013z;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        /* loaded from: classes.dex */
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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.G.onMenuItemSelected(menuItem)) {
                return true;
            }
            g gVar = Toolbar.this.I;
            if (gVar != null) {
                return gVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements f.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            f.a aVar = Toolbar.this.O;
            return aVar != null && aVar.a(fVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
            if (!Toolbar.this.f1988a.isOverflowMenuShowing()) {
                Toolbar.this.G.onPrepareMenu(fVar);
            }
            f.a aVar = Toolbar.this.O;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.collapseActionView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        @Nullable
        static OnBackInvokedDispatcher a(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @NonNull
        static OnBackInvokedCallback b(@NonNull final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.m0
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        static void c(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements androidx.appcompat.view.menu.l {

        /* renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.f f2017a;

        /* renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.h f2018b;

        e() {
        }

        @Override // androidx.appcompat.view.menu.l
        public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean c(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
            Toolbar.this.d();
            ViewParent parent = Toolbar.this.f1995h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1995h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1995h);
            }
            Toolbar.this.f1996i = hVar.getActionView();
            this.f2018b = hVar;
            ViewParent parent2 = Toolbar.this.f1996i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1996i);
                }
                f generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f1179a = (toolbar4.f2001n & 112) | GravityCompat.START;
                generateDefaultLayoutParams.f2020b = 2;
                toolbar4.f1996i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1996i);
            }
            Toolbar.this.y();
            Toolbar.this.requestLayout();
            hVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f1996i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewExpanded();
            }
            Toolbar.this.B();
            return true;
        }

        @Override // androidx.appcompat.view.menu.l
        public void e(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean f(androidx.appcompat.view.menu.q qVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.l
        public Parcelable g() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.l
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.l
        public void h(boolean z10) {
            if (this.f2018b != null) {
                androidx.appcompat.view.menu.f fVar = this.f2017a;
                if (fVar != null) {
                    int size = fVar.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        if (this.f2017a.getItem(i11) == this.f2018b) {
                            return;
                        }
                    }
                }
                j(this.f2017a, this.f2018b);
            }
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean i() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean j(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
            KeyEvent.Callback callback = Toolbar.this.f1996i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1996i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1995h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1996i = null;
            toolbar3.a();
            this.f2018b = null;
            Toolbar.this.requestLayout();
            hVar.r(false);
            Toolbar.this.B();
            return true;
        }

        @Override // androidx.appcompat.view.menu.l
        public void k(Context context, androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.h hVar;
            androidx.appcompat.view.menu.f fVar2 = this.f2017a;
            if (fVar2 != null && (hVar = this.f2018b) != null) {
                fVar2.f(hVar);
            }
            this.f2017a = fVar;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends a.C0021a {

        /* renamed from: b, reason: collision with root package name */
        int f2020b;

        public f(int i11, int i12) {
            super(i11, i12);
            this.f2020b = 0;
            this.f1179a = 8388627;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2020b = 0;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2020b = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2020b = 0;
            a(marginLayoutParams);
        }

        public f(a.C0021a c0021a) {
            super(c0021a);
            this.f2020b = 0;
        }

        public f(f fVar) {
            super((a.C0021a) fVar);
            this.f2020b = 0;
            this.f2020b = fVar.f2020b;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(@NonNull Context context) {
        this(context, null);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f2010w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new MenuHostHelper(new Runnable() { // from class: androidx.appcompat.widget.l0
            @Override // java.lang.Runnable
            public final void run() {
                Toolbar.this.invalidateMenu();
            }
        });
        this.H = new ArrayList();
        this.J = new a();
        this.T = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        j0 v11 = j0.v(getContext(), attributeSet, R$styleable.Toolbar, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.Toolbar, attributeSet, v11.r(), i11, 0);
        this.f1999l = v11.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f2000m = v11.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f2010w = v11.l(R$styleable.Toolbar_android_gravity, this.f2010w);
        this.f2001n = v11.l(R$styleable.Toolbar_buttonGravity, 48);
        int e11 = v11.e(R$styleable.Toolbar_titleMargin, 0);
        e11 = v11.s(R$styleable.Toolbar_titleMargins) ? v11.e(R$styleable.Toolbar_titleMargins, e11) : e11;
        this.f2006s = e11;
        this.f2005r = e11;
        this.f2004q = e11;
        this.f2003p = e11;
        int e12 = v11.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (e12 >= 0) {
            this.f2003p = e12;
        }
        int e13 = v11.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (e13 >= 0) {
            this.f2004q = e13;
        }
        int e14 = v11.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (e14 >= 0) {
            this.f2005r = e14;
        }
        int e15 = v11.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (e15 >= 0) {
            this.f2006s = e15;
        }
        this.f2002o = v11.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int e16 = v11.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e17 = v11.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int f11 = v11.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int f12 = v11.f(R$styleable.Toolbar_contentInsetRight, 0);
        e();
        this.f2007t.e(f11, f12);
        if (e16 != Integer.MIN_VALUE || e17 != Integer.MIN_VALUE) {
            this.f2007t.g(e16, e17);
        }
        this.f2008u = v11.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f2009v = v11.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1993f = v11.g(R$styleable.Toolbar_collapseIcon);
        this.f1994g = v11.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence p11 = v11.p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(p11)) {
            setTitle(p11);
        }
        CharSequence p12 = v11.p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(p12)) {
            setSubtitle(p12);
        }
        this.f1997j = getContext();
        setPopupTheme(v11.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable g11 = v11.g(R$styleable.Toolbar_navigationIcon);
        if (g11 != null) {
            setNavigationIcon(g11);
        }
        CharSequence p13 = v11.p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(p13)) {
            setNavigationContentDescription(p13);
        }
        Drawable g12 = v11.g(R$styleable.Toolbar_logo);
        if (g12 != null) {
            setLogo(g12);
        }
        CharSequence p14 = v11.p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(p14)) {
            setLogoDescription(p14);
        }
        if (v11.s(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(v11.c(R$styleable.Toolbar_titleTextColor));
        }
        if (v11.s(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(v11.c(R$styleable.Toolbar_subtitleTextColor));
        }
        if (v11.s(R$styleable.Toolbar_menu)) {
            inflateMenu(v11.n(R$styleable.Toolbar_menu, 0));
        }
        v11.x();
    }

    private boolean A(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i11) {
        boolean z10 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, getLayoutDirection());
        list.clear();
        if (!z10) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f2020b == 0 && A(childAt) && l(fVar.f1179a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i13 = childCount - 1; i13 >= 0; i13--) {
            View childAt2 = getChildAt(i13);
            f fVar2 = (f) childAt2.getLayoutParams();
            if (fVar2.f2020b == 0 && A(childAt2) && l(fVar2.f1179a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        f generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (f) layoutParams;
        generateDefaultLayoutParams.f2020b = 1;
        if (!z10 || this.f1996i == null) {
            addView(view, generateDefaultLayoutParams);
        } else {
            view.setLayoutParams(generateDefaultLayoutParams);
            this.E.add(view);
        }
    }

    private void e() {
        if (this.f2007t == null) {
            this.f2007t = new d0();
        }
    }

    private void f() {
        if (this.f1992e == null) {
            this.f1992e = new AppCompatImageView(getContext());
        }
    }

    private void g() {
        h();
        if (this.f1988a.peekMenu() == null) {
            androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) this.f1988a.getMenu();
            if (this.M == null) {
                this.M = new e();
            }
            this.f1988a.setExpandedActionViewsExclusive(true);
            fVar.c(this.M, this.f1997j);
            B();
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i11 = 0; i11 < menu.size(); i11++) {
            arrayList.add(menu.getItem(i11));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f1988a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1988a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1998k);
            this.f1988a.setOnMenuItemClickListener(this.J);
            this.f1988a.setMenuCallbacks(this.N, new b());
            f generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1179a = (this.f2001n & 112) | GravityCompat.END;
            this.f1988a.setLayoutParams(generateDefaultLayoutParams);
            c(this.f1988a, false);
        }
    }

    private void i() {
        if (this.f1991d == null) {
            this.f1991d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            f generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1179a = (this.f2001n & 112) | GravityCompat.START;
            this.f1991d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int l(int i11) {
        int layoutDirection = getLayoutDirection();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, layoutDirection) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : layoutDirection == 1 ? 5 : 3;
    }

    private int m(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = i11 > 0 ? (measuredHeight - i11) / 2 : 0;
        int n11 = n(fVar.f1179a);
        if (n11 == 48) {
            return getPaddingTop() - i12;
        }
        if (n11 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - i12;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i13 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i14 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
        if (i13 < i14) {
            i13 = i14;
        } else {
            int i15 = (((height - paddingBottom) - measuredHeight) - i13) - paddingTop;
            int i16 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            if (i15 < i16) {
                i13 = Math.max(0, i13 - (i16 - i15));
            }
        }
        return paddingTop + i13;
    }

    private int n(int i11) {
        int i12 = i11 & 112;
        return (i12 == 16 || i12 == 48 || i12 == 80) ? i12 : this.f2010w & 112;
    }

    private int o(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int p(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int q(List list, int[] iArr) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int size = list.size();
        int i13 = 0;
        int i14 = 0;
        while (i13 < size) {
            View view = (View) list.get(i13);
            f fVar = (f) view.getLayoutParams();
            int i15 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - i11;
            int i16 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - i12;
            int max = Math.max(0, i15);
            int max2 = Math.max(0, i16);
            int max3 = Math.max(0, -i15);
            int max4 = Math.max(0, -i16);
            i14 += max + view.getMeasuredWidth() + max2;
            i13++;
            i12 = max4;
            i11 = max3;
        }
        return i14;
    }

    private boolean r(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    private int s(View view, int i11, int[] iArr, int i12) {
        f fVar = (f) view.getLayoutParams();
        int i13 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - iArr[0];
        int max = i11 + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        int m11 = m(view, i12);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, m11, max + measuredWidth, view.getMeasuredHeight() + m11);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
    }

    private int t(View view, int i11, int[] iArr, int i12) {
        f fVar = (f) view.getLayoutParams();
        int i13 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - iArr[1];
        int max = i11 - Math.max(0, i13);
        iArr[1] = Math.max(0, -i13);
        int m11 = m(view, i12);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, m11, max, view.getMeasuredHeight() + m11);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).leftMargin);
    }

    private int u(View view, int i11, int i12, int i13, int i14, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i15 = marginLayoutParams.leftMargin - iArr[0];
        int i16 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i15) + Math.max(0, i16);
        iArr[0] = Math.max(0, -i15);
        iArr[1] = Math.max(0, -i16);
        view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + max + i12, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i13, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void v(View view, int i11, int i12, int i13, int i14, int i15) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i13, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i15 >= 0) {
            if (mode != 0) {
                i15 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i15);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void w() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.G.onCreateMenu(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
    }

    private void x() {
        removeCallbacks(this.T);
        post(this.T);
    }

    private boolean z() {
        if (!this.P) {
            return false;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (A(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    void B() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a11 = d.a(this);
            boolean z10 = hasExpandedActionView() && a11 != null && isAttachedToWindow() && this.S;
            if (z10 && this.R == null) {
                if (this.Q == null) {
                    this.Q = d.b(new Runnable() { // from class: androidx.appcompat.widget.k0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Toolbar.this.collapseActionView();
                        }
                    });
                }
                d.c(a11, this.Q);
                this.R = a11;
                return;
            }
            if (z10 || (onBackInvokedDispatcher = this.R) == null) {
                return;
            }
            d.d(onBackInvokedDispatcher, this.Q);
            this.R = null;
        }
    }

    void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView((View) this.E.get(size));
        }
        this.E.clear();
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.G.addMenuProvider(menuProvider);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.view.u uVar) {
        this.G.addMenuProvider(menuProvider, uVar);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.view.u uVar, @NonNull Lifecycle.State state) {
        this.G.addMenuProvider(menuProvider, uVar, state);
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f1988a) != null && actionMenuView.isOverflowReserved();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof f);
    }

    public void collapseActionView() {
        e eVar = this.M;
        androidx.appcompat.view.menu.h hVar = eVar == null ? null : eVar.f2018b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    void d() {
        if (this.f1995h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f1995h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1993f);
            this.f1995h.setContentDescription(this.f1994g);
            f generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1179a = (this.f2001n & 112) | GravityCompat.START;
            generateDefaultLayoutParams.f2020b = 2;
            this.f1995h.setLayoutParams(generateDefaultLayoutParams);
            this.f1995h.setOnClickListener(new c());
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.f1988a;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1995h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1995h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        d0 d0Var = this.f2007t;
        if (d0Var != null) {
            return d0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i11 = this.f2009v;
        return i11 != Integer.MIN_VALUE ? i11 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        d0 d0Var = this.f2007t;
        if (d0Var != null) {
            return d0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        d0 d0Var = this.f2007t;
        if (d0Var != null) {
            return d0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        d0 d0Var = this.f2007t;
        if (d0Var != null) {
            return d0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i11 = this.f2008u;
        return i11 != Integer.MIN_VALUE ? i11 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.f peekMenu;
        ActionMenuView actionMenuView = this.f1988a;
        return (actionMenuView == null || (peekMenu = actionMenuView.peekMenu()) == null || !peekMenu.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f2009v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2008u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1992e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1992e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        g();
        return this.f1988a.getMenu();
    }

    @Nullable
    View getNavButtonView() {
        return this.f1991d;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1991d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1991d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.L;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        g();
        return this.f1988a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1997j;
    }

    public int getPopupTheme() {
        return this.f1998k;
    }

    public CharSequence getSubtitle() {
        return this.f2012y;
    }

    @Nullable
    final TextView getSubtitleTextView() {
        return this.f1990c;
    }

    public CharSequence getTitle() {
        return this.f2011x;
    }

    public int getTitleMarginBottom() {
        return this.f2006s;
    }

    public int getTitleMarginEnd() {
        return this.f2004q;
    }

    public int getTitleMarginStart() {
        return this.f2003p;
    }

    public int getTitleMarginTop() {
        return this.f2005r;
    }

    @Nullable
    final TextView getTitleTextView() {
        return this.f1989b;
    }

    public t getWrapper() {
        if (this.K == null) {
            this.K = new n0(this, true);
        }
        return this.K;
    }

    public boolean hasExpandedActionView() {
        e eVar = this.M;
        return (eVar == null || eVar.f2018b == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.f1988a;
        return actionMenuView != null && actionMenuView.hideOverflowMenu();
    }

    public void inflateMenu(int i11) {
        getMenuInflater().inflate(i11, getMenu());
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        w();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.S;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.f1988a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.f1988a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.f1989b;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i11 = 0; i11 < lineCount; i11++) {
            if (layout.getEllipsisCount(i11) > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof a.C0021a ? new f((a.C0021a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        B();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.T);
        B();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02a1 A[LOOP:0: B:41:0x029f->B:42:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c3 A[LOOP:1: B:45:0x02c1->B:46:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02fc A[LOOP:2: B:54:0x02fa->B:55:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int[] iArr = this.F;
        boolean b11 = u0.b(this);
        int i20 = !b11 ? 1 : 0;
        if (A(this.f1991d)) {
            v(this.f1991d, i11, 0, i12, 0, this.f2002o);
            i13 = this.f1991d.getMeasuredWidth() + o(this.f1991d);
            i14 = Math.max(0, this.f1991d.getMeasuredHeight() + p(this.f1991d));
            i15 = View.combineMeasuredStates(0, this.f1991d.getMeasuredState());
        } else {
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        if (A(this.f1995h)) {
            v(this.f1995h, i11, 0, i12, 0, this.f2002o);
            i13 = this.f1995h.getMeasuredWidth() + o(this.f1995h);
            i14 = Math.max(i14, this.f1995h.getMeasuredHeight() + p(this.f1995h));
            i15 = View.combineMeasuredStates(i15, this.f1995h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i13);
        iArr[b11 ? 1 : 0] = Math.max(0, currentContentInsetStart - i13);
        if (A(this.f1988a)) {
            v(this.f1988a, i11, max, i12, 0, this.f2002o);
            i16 = this.f1988a.getMeasuredWidth() + o(this.f1988a);
            i14 = Math.max(i14, this.f1988a.getMeasuredHeight() + p(this.f1988a));
            i15 = View.combineMeasuredStates(i15, this.f1988a.getMeasuredState());
        } else {
            i16 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i16);
        iArr[i20] = Math.max(0, currentContentInsetEnd - i16);
        if (A(this.f1996i)) {
            max2 += u(this.f1996i, i11, max2, i12, 0, iArr);
            i14 = Math.max(i14, this.f1996i.getMeasuredHeight() + p(this.f1996i));
            i15 = View.combineMeasuredStates(i15, this.f1996i.getMeasuredState());
        }
        if (A(this.f1992e)) {
            max2 += u(this.f1992e, i11, max2, i12, 0, iArr);
            i14 = Math.max(i14, this.f1992e.getMeasuredHeight() + p(this.f1992e));
            i15 = View.combineMeasuredStates(i15, this.f1992e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (((f) childAt.getLayoutParams()).f2020b == 0 && A(childAt)) {
                max2 += u(childAt, i11, max2, i12, 0, iArr);
                i14 = Math.max(i14, childAt.getMeasuredHeight() + p(childAt));
                i15 = View.combineMeasuredStates(i15, childAt.getMeasuredState());
            }
        }
        int i22 = this.f2005r + this.f2006s;
        int i23 = this.f2003p + this.f2004q;
        if (A(this.f1989b)) {
            u(this.f1989b, i11, max2 + i23, i12, i22, iArr);
            int measuredWidth = this.f1989b.getMeasuredWidth() + o(this.f1989b);
            i17 = this.f1989b.getMeasuredHeight() + p(this.f1989b);
            i18 = View.combineMeasuredStates(i15, this.f1989b.getMeasuredState());
            i19 = measuredWidth;
        } else {
            i17 = 0;
            i18 = i15;
            i19 = 0;
        }
        if (A(this.f1990c)) {
            i19 = Math.max(i19, u(this.f1990c, i11, max2 + i23, i12, i17 + i22, iArr));
            i17 += this.f1990c.getMeasuredHeight() + p(this.f1990c);
            i18 = View.combineMeasuredStates(i18, this.f1990c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i19 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i11, (-16777216) & i18), z() ? 0 : View.resolveSizeAndState(Math.max(Math.max(i14, i17) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i12, i18 << 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f1988a;
        androidx.appcompat.view.menu.f peekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
        int i11 = savedState.expandedMenuItemId;
        if (i11 != 0 && this.M != null && peekMenu != null && (findItem = peekMenu.findItem(i11)) != null) {
            findItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            x();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        super.onRtlPropertiesChanged(i11);
        e();
        this.f2007t.f(i11 == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.h hVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        e eVar = this.M;
        if (eVar != null && (hVar = eVar.f2018b) != null) {
            savedState.expandedMenuItemId = hVar.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.G.removeMenuProvider(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.S != z10) {
            this.S = z10;
            B();
        }
    }

    public void setCollapseContentDescription(int i11) {
        setCollapseContentDescription(i11 != 0 ? getContext().getText(i11) : null);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            d();
        }
        ImageButton imageButton = this.f1995h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i11) {
        setCollapseIcon(g.a.b(getContext(), i11));
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            d();
            this.f1995h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f1995h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f1993f);
            }
        }
    }

    public void setCollapsible(boolean z10) {
        this.P = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i11) {
        if (i11 < 0) {
            i11 = Integer.MIN_VALUE;
        }
        if (i11 != this.f2009v) {
            this.f2009v = i11;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i11) {
        if (i11 < 0) {
            i11 = Integer.MIN_VALUE;
        }
        if (i11 != this.f2008u) {
            this.f2008u = i11;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i11, int i12) {
        e();
        this.f2007t.e(i11, i12);
    }

    public void setContentInsetsRelative(int i11, int i12) {
        e();
        this.f2007t.g(i11, i12);
    }

    public void setLogo(int i11) {
        setLogo(g.a.b(getContext(), i11));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!r(this.f1992e)) {
                c(this.f1992e, true);
            }
        } else {
            ImageView imageView = this.f1992e;
            if (imageView != null && r(imageView)) {
                removeView(this.f1992e);
                this.E.remove(this.f1992e);
            }
        }
        ImageView imageView2 = this.f1992e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i11) {
        setLogoDescription(getContext().getText(i11));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        ImageView imageView = this.f1992e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setMenu(androidx.appcompat.view.menu.f fVar, ActionMenuPresenter actionMenuPresenter) {
        if (fVar == null && this.f1988a == null) {
            return;
        }
        h();
        androidx.appcompat.view.menu.f peekMenu = this.f1988a.peekMenu();
        if (peekMenu == fVar) {
            return;
        }
        if (peekMenu != null) {
            peekMenu.R(this.L);
            peekMenu.R(this.M);
        }
        if (this.M == null) {
            this.M = new e();
        }
        actionMenuPresenter.J(true);
        if (fVar != null) {
            fVar.c(actionMenuPresenter, this.f1997j);
            fVar.c(this.M, this.f1997j);
        } else {
            actionMenuPresenter.k(this.f1997j, null);
            this.M.k(this.f1997j, null);
            actionMenuPresenter.h(true);
            this.M.h(true);
        }
        this.f1988a.setPopupTheme(this.f1998k);
        this.f1988a.setPresenter(actionMenuPresenter);
        this.L = actionMenuPresenter;
        B();
    }

    public void setMenuCallbacks(l.a aVar, f.a aVar2) {
        this.N = aVar;
        this.O = aVar2;
        ActionMenuView actionMenuView = this.f1988a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(int i11) {
        setNavigationContentDescription(i11 != 0 ? getContext().getText(i11) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageButton imageButton = this.f1991d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            o0.a(this.f1991d, charSequence);
        }
    }

    public void setNavigationIcon(int i11) {
        setNavigationIcon(g.a.b(getContext(), i11));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            i();
            if (!r(this.f1991d)) {
                c(this.f1991d, true);
            }
        } else {
            ImageButton imageButton = this.f1991d;
            if (imageButton != null && r(imageButton)) {
                removeView(this.f1991d);
                this.E.remove(this.f1991d);
            }
        }
        ImageButton imageButton2 = this.f1991d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        i();
        this.f1991d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(g gVar) {
        this.I = gVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        g();
        this.f1988a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i11) {
        if (this.f1998k != i11) {
            this.f1998k = i11;
            if (i11 == 0) {
                this.f1997j = getContext();
            } else {
                this.f1997j = new ContextThemeWrapper(getContext(), i11);
            }
        }
    }

    public void setSubtitle(int i11) {
        setSubtitle(getContext().getText(i11));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1990c;
            if (textView != null && r(textView)) {
                removeView(this.f1990c);
                this.E.remove(this.f1990c);
            }
        } else {
            if (this.f1990c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1990c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1990c.setEllipsize(TextUtils.TruncateAt.END);
                int i11 = this.f2000m;
                if (i11 != 0) {
                    this.f1990c.setTextAppearance(context, i11);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1990c.setTextColor(colorStateList);
                }
            }
            if (!r(this.f1990c)) {
                c(this.f1990c, true);
            }
        }
        TextView textView2 = this.f1990c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2012y = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int i11) {
        this.f2000m = i11;
        TextView textView = this.f1990c;
        if (textView != null) {
            textView.setTextAppearance(context, i11);
        }
    }

    public void setSubtitleTextColor(int i11) {
        setSubtitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f1990c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i11) {
        setTitle(getContext().getText(i11));
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1989b;
            if (textView != null && r(textView)) {
                removeView(this.f1989b);
                this.E.remove(this.f1989b);
            }
        } else {
            if (this.f1989b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1989b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1989b.setEllipsize(TextUtils.TruncateAt.END);
                int i11 = this.f1999l;
                if (i11 != 0) {
                    this.f1989b.setTextAppearance(context, i11);
                }
                ColorStateList colorStateList = this.f2013z;
                if (colorStateList != null) {
                    this.f1989b.setTextColor(colorStateList);
                }
            }
            if (!r(this.f1989b)) {
                c(this.f1989b, true);
            }
        }
        TextView textView2 = this.f1989b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2011x = charSequence;
    }

    public void setTitleMargin(int i11, int i12, int i13, int i14) {
        this.f2003p = i11;
        this.f2005r = i12;
        this.f2004q = i13;
        this.f2006s = i14;
        requestLayout();
    }

    public void setTitleMarginBottom(int i11) {
        this.f2006s = i11;
        requestLayout();
    }

    public void setTitleMarginEnd(int i11) {
        this.f2004q = i11;
        requestLayout();
    }

    public void setTitleMarginStart(int i11) {
        this.f2003p = i11;
        requestLayout();
    }

    public void setTitleMarginTop(int i11) {
        this.f2005r = i11;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i11) {
        this.f1999l = i11;
        TextView textView = this.f1989b;
        if (textView != null) {
            textView.setTextAppearance(context, i11);
        }
    }

    public void setTitleTextColor(int i11) {
        setTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f2013z = colorStateList;
        TextView textView = this.f1989b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.f1988a;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    void y() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((f) childAt.getLayoutParams()).f2020b != 2 && childAt != this.f1988a) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }
}
