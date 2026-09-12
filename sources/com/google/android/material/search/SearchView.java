package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$style;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.f0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.b, wa.b {
    private static final int D = R$style.Widget_Material3_SearchView;
    private boolean A;
    private TransitionState B;
    private Map C;

    /* renamed from: a, reason: collision with root package name */
    final View f29585a;

    /* renamed from: b, reason: collision with root package name */
    final ClippableRoundedCornerLayout f29586b;

    /* renamed from: c, reason: collision with root package name */
    final View f29587c;

    /* renamed from: d, reason: collision with root package name */
    final View f29588d;

    /* renamed from: e, reason: collision with root package name */
    final FrameLayout f29589e;

    /* renamed from: f, reason: collision with root package name */
    final FrameLayout f29590f;

    /* renamed from: g, reason: collision with root package name */
    final MaterialToolbar f29591g;

    /* renamed from: h, reason: collision with root package name */
    final Toolbar f29592h;

    /* renamed from: i, reason: collision with root package name */
    final TextView f29593i;

    /* renamed from: j, reason: collision with root package name */
    final EditText f29594j;

    /* renamed from: k, reason: collision with root package name */
    final ImageButton f29595k;

    /* renamed from: l, reason: collision with root package name */
    final View f29596l;

    /* renamed from: m, reason: collision with root package name */
    final TouchObserverFrameLayout f29597m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f29598n;

    /* renamed from: o, reason: collision with root package name */
    private final f0 f29599o;

    /* renamed from: p, reason: collision with root package name */
    private final wa.c f29600p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f29601q;

    /* renamed from: r, reason: collision with root package name */
    private final ta.a f29602r;

    /* renamed from: s, reason: collision with root package name */
    private final Set f29603s;

    /* renamed from: t, reason: collision with root package name */
    private SearchBar f29604t;

    /* renamed from: u, reason: collision with root package name */
    private int f29605u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f29606v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f29607w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f29608x;

    /* renamed from: y, reason: collision with root package name */
    private final int f29609y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f29610z;

    /* loaded from: classes4.dex */
    public static class Behavior extends CoordinatorLayout.c {
        public Behavior() {
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (searchView.isSetupWithSearchBar() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f29611a;

        /* renamed from: b, reason: collision with root package name */
        int f29612b;

        /* loaded from: classes4.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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
            this.f29611a = parcel.readString();
            this.f29612b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f29611a);
            parcel.writeInt(this.f29612b);
        }
    }

    /* loaded from: classes4.dex */
    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            SearchView.this.f29595k.setVisibility(charSequence.length() > 0 ? 0 : 8);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSearchViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SearchView(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void A() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void B() {
        this.f29595k.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.this.q(view);
            }
        });
        this.f29594j.addTextChangedListener(new a());
    }

    private void C() {
        this.f29597m.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.v
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r11;
                r11 = SearchView.this.r(view, motionEvent);
                return r11;
            }
        });
    }

    private void D() {
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f29596l.getLayoutParams();
        final int i11 = marginLayoutParams.leftMargin;
        final int i12 = marginLayoutParams.rightMargin;
        ViewCompat.setOnApplyWindowInsetsListener(this.f29596l, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.search.o
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat s11;
                s11 = SearchView.s(marginLayoutParams, i11, i12, view, windowInsetsCompat);
                return s11;
            }
        });
    }

    private void E(int i11, String str, String str2) {
        if (i11 != -1) {
            androidx.core.widget.m.q(this.f29594j, i11);
        }
        this.f29594j.setText(str);
        this.f29594j.setHint(str2);
    }

    private void F() {
        I();
        D();
        H();
    }

    private void G() {
        this.f29586b.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.u
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean t11;
                t11 = SearchView.t(view, motionEvent);
                return t11;
            }
        });
    }

    private void H() {
        setUpStatusBarSpacer(getStatusBarHeight());
        ViewCompat.setOnApplyWindowInsetsListener(this.f29588d, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.search.r
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat u11;
                u11 = SearchView.this.u(view, windowInsetsCompat);
                return u11;
            }
        });
    }

    private void I() {
        com.google.android.material.internal.f0.f(this.f29591g, new f0.d() { // from class: com.google.android.material.search.q
            @Override // com.google.android.material.internal.f0.d
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f0.e eVar) {
                WindowInsetsCompat v11;
                v11 = SearchView.this.v(view, windowInsetsCompat, eVar);
                return v11;
            }
        });
    }

    private void J(ViewGroup viewGroup, boolean z10) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt != this) {
                if (childAt.findViewById(this.f29586b.getId()) != null) {
                    J((ViewGroup) childAt, z10);
                } else if (z10) {
                    this.C.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                } else {
                    Map map = this.C;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, ((Integer) this.C.get(childAt)).intValue());
                    }
                }
            }
        }
    }

    private void K(TransitionState transitionState) {
        if (this.f29604t == null || !this.f29601q) {
            return;
        }
        if (transitionState.equals(TransitionState.SHOWN)) {
            this.f29600p.c();
        } else if (transitionState.equals(TransitionState.HIDDEN)) {
            this.f29600p.f();
        }
    }

    private void L() {
        MaterialToolbar materialToolbar = this.f29591g;
        if (materialToolbar == null || m(materialToolbar)) {
            return;
        }
        int defaultNavigationIconResource = getDefaultNavigationIconResource();
        if (this.f29604t == null) {
            this.f29591g.setNavigationIcon(defaultNavigationIconResource);
            return;
        }
        Drawable r11 = a1.a.r(g.a.b(getContext(), defaultNavigationIconResource).mutate());
        if (this.f29591g.getNavigationIconTint() != null) {
            a1.a.n(r11, this.f29591g.getNavigationIconTint().intValue());
        }
        this.f29591g.setNavigationIcon(new com.google.android.material.internal.h(this.f29604t.getNavigationIcon(), r11));
        M();
    }

    private void M() {
        ImageButton e11 = ToolbarUtils.e(this.f29591g);
        if (e11 == null) {
            return;
        }
        int i11 = this.f29586b.getVisibility() == 0 ? 1 : 0;
        Drawable q11 = a1.a.q(e11.getDrawable());
        if (q11 instanceof androidx.appcompat.graphics.drawable.c) {
            ((androidx.appcompat.graphics.drawable.c) q11).setProgress(i11);
        }
        if (q11 instanceof com.google.android.material.internal.h) {
            ((com.google.android.material.internal.h) q11).a(i11);
        }
    }

    @Nullable
    private Window getActivityWindow() {
        Activity a11 = com.google.android.material.internal.c.a(getContext());
        if (a11 == null) {
            return null;
        }
        return a11.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f29604t;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R$dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private boolean l() {
        return this.B.equals(TransitionState.HIDDEN) || this.B.equals(TransitionState.HIDING);
    }

    private boolean m(Toolbar toolbar) {
        return a1.a.q(toolbar.getNavigationIcon()) instanceof androidx.appcompat.graphics.drawable.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f29594j.clearFocus();
        SearchBar searchBar = this.f29604t;
        if (searchBar != null) {
            searchBar.requestFocus();
        }
        com.google.android.material.internal.f0.o(this.f29594j, this.f29610z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (this.f29594j.requestFocus()) {
            this.f29594j.sendAccessibilityEvent(8);
        }
        com.google.android.material.internal.f0.v(this.f29594j, this.f29610z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        clearText();
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean r(View view, MotionEvent motionEvent) {
        if (!k()) {
            return false;
        }
        clearFocusAndHideKeyboard();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat s(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12, View view, WindowInsetsCompat windowInsetsCompat) {
        marginLayoutParams.leftMargin = i11 + windowInsetsCompat.getSystemWindowInsetLeft();
        marginLayoutParams.rightMargin = i12 + windowInsetsCompat.getSystemWindowInsetRight();
        return windowInsetsCompat;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z10) {
        this.f29588d.setVisibility(z10 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f11) {
        ta.a aVar = this.f29602r;
        if (aVar == null || this.f29587c == null) {
            return;
        }
        this.f29587c.setBackgroundColor(aVar.c(this.f29609y, f11));
    }

    private void setUpHeaderLayout(int i11) {
        if (i11 != -1) {
            addHeaderView(LayoutInflater.from(getContext()).inflate(i11, (ViewGroup) this.f29589e, false));
        }
    }

    private void setUpStatusBarSpacer(int i11) {
        if (this.f29588d.getLayoutParams().height != i11) {
            this.f29588d.getLayoutParams().height = i11;
            this.f29588d.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean t(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat u(View view, WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        setUpStatusBarSpacer(systemWindowInsetTop);
        if (!this.A) {
            setStatusBarSpacerEnabledInternal(systemWindowInsetTop > 0);
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat v(View view, WindowInsetsCompat windowInsetsCompat, f0.e eVar) {
        boolean p11 = com.google.android.material.internal.f0.p(this.f29591g);
        this.f29591g.setPadding((p11 ? eVar.f29263c : eVar.f29261a) + windowInsetsCompat.getSystemWindowInsetLeft(), eVar.f29262b, (p11 ? eVar.f29261a : eVar.f29263c) + windowInsetsCompat.getSystemWindowInsetRight(), eVar.f29264d);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        show();
    }

    private void y(TransitionState transitionState, boolean z10) {
        if (this.B.equals(transitionState)) {
            return;
        }
        if (z10) {
            if (transitionState == TransitionState.SHOWN) {
                setModalForAccessibility(true);
            } else if (transitionState == TransitionState.HIDDEN) {
                setModalForAccessibility(false);
            }
        }
        this.B = transitionState;
        Iterator it = new LinkedHashSet(this.f29603s).iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
        K(transitionState);
    }

    private void z(boolean z10, boolean z11) {
        if (z11) {
            this.f29591g.setNavigationIcon((Drawable) null);
            return;
        }
        this.f29591g.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.this.p(view);
            }
        });
        if (z10) {
            androidx.appcompat.graphics.drawable.c cVar = new androidx.appcompat.graphics.drawable.c(getContext());
            cVar.c(com.google.android.material.color.b.d(this, R$attr.colorOnSurface));
            this.f29591g.setNavigationIcon(cVar);
        }
    }

    public void addHeaderView(@NonNull View view) {
        this.f29589e.addView(view);
        this.f29589e.setVisibility(0);
    }

    public void addTransitionListener(@NonNull b bVar) {
        this.f29603s.add(bVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.f29598n) {
            this.f29597m.addView(view, i11, layoutParams);
        } else {
            super.addView(view, i11, layoutParams);
        }
    }

    @Override // wa.b
    public void cancelBackProgress() {
        if (l() || this.f29604t == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.f29599o.o();
    }

    public void clearFocusAndHideKeyboard() {
        this.f29594j.post(new Runnable() { // from class: com.google.android.material.search.m
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.n();
            }
        });
    }

    public void clearText() {
        this.f29594j.setText("");
    }

    wa.h getBackHelper() {
        return this.f29599o.r();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public CoordinatorLayout.c getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.B;
    }

    protected int getDefaultNavigationIconResource() {
        return R$drawable.ic_arrow_back_black_24;
    }

    @NonNull
    public EditText getEditText() {
        return this.f29594j;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f29594j.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.f29593i;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.f29593i.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f29605u;
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f29594j.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.f29591g;
    }

    @Override // wa.b
    public void handleBackInvoked() {
        if (l()) {
            return;
        }
        androidx.activity.b S = this.f29599o.S();
        if (Build.VERSION.SDK_INT < 34 || this.f29604t == null || S == null) {
            hide();
        } else {
            this.f29599o.p();
        }
    }

    public void hide() {
        if (this.B.equals(TransitionState.HIDDEN) || this.B.equals(TransitionState.HIDING)) {
            return;
        }
        this.f29599o.M();
    }

    public void inflateMenu(int i11) {
        this.f29591g.inflateMenu(i11);
    }

    public boolean isAnimatedNavigationIcon() {
        return this.f29606v;
    }

    public boolean isAutoShowKeyboard() {
        return this.f29608x;
    }

    public boolean isMenuItemsAnimated() {
        return this.f29607w;
    }

    public boolean isSetupWithSearchBar() {
        return this.f29604t != null;
    }

    public boolean isShowing() {
        return this.B.equals(TransitionState.SHOWN) || this.B.equals(TransitionState.SHOWING);
    }

    public boolean isUseWindowInsetsController() {
        return this.f29610z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f29605u == 48;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ab.j.e(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateSoftInputMode();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.f29611a);
        setVisible(savedState.f29612b == 0);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.f29611a = text == null ? null : text.toString();
        savedState.f29612b = this.f29586b.getVisibility();
        return savedState;
    }

    public void removeAllHeaderViews() {
        this.f29589e.removeAllViews();
        this.f29589e.setVisibility(8);
    }

    public void removeHeaderView(@NonNull View view) {
        this.f29589e.removeView(view);
        if (this.f29589e.getChildCount() == 0) {
            this.f29589e.setVisibility(8);
        }
    }

    public void removeTransitionListener(@NonNull b bVar) {
        this.f29603s.remove(bVar);
    }

    public void requestFocusAndShowKeyboard() {
        this.f29594j.postDelayed(new Runnable() { // from class: com.google.android.material.search.p
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.o();
            }
        }, 100L);
    }

    public void setAnimatedNavigationIcon(boolean z10) {
        this.f29606v = z10;
    }

    public void setAutoShowKeyboard(boolean z10) {
        this.f29608x = z10;
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        setUpBackgroundViewElevationOverlay(f11);
    }

    public void setHint(int i11) {
        this.f29594j.setHint(i11);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f29594j.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z10) {
        this.f29607w = z10;
    }

    public void setModalForAccessibility(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z10) {
            this.C = new HashMap(viewGroup.getChildCount());
        }
        J(viewGroup, z10);
        if (z10) {
            return;
        }
        this.C = null;
    }

    public void setOnMenuItemClickListener(@Nullable Toolbar.g gVar) {
        this.f29591g.setOnMenuItemClickListener(gVar);
    }

    public void setSearchPrefixText(@Nullable CharSequence charSequence) {
        this.f29593i.setText(charSequence);
        this.f29593i.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setStatusBarSpacerEnabled(boolean z10) {
        this.A = true;
        setStatusBarSpacerEnabledInternal(z10);
    }

    public void setText(int i11) {
        this.f29594j.setText(i11);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence charSequence) {
        this.f29594j.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z10) {
        this.f29591g.setTouchscreenBlocksFocus(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTransitionState(@NonNull TransitionState transitionState) {
        y(transitionState, true);
    }

    public void setUseWindowInsetsController(boolean z10) {
        this.f29610z = z10;
    }

    public void setVisible(boolean z10) {
        boolean z11 = this.f29586b.getVisibility() == 0;
        this.f29586b.setVisibility(z10 ? 0 : 8);
        M();
        y(z10 ? TransitionState.SHOWN : TransitionState.HIDDEN, z11 != z10);
    }

    public void setupWithSearchBar(@Nullable SearchBar searchBar) {
        this.f29604t = searchBar;
        this.f29599o.X(searchBar);
        if (searchBar != null) {
            searchBar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchView.this.w(view);
                }
            });
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new Runnable() { // from class: com.google.android.material.search.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            SearchView.this.show();
                        }
                    });
                    this.f29594j.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        L();
        A();
        K(getCurrentTransitionState());
    }

    public void show() {
        if (this.B.equals(TransitionState.SHOWN) || this.B.equals(TransitionState.SHOWING)) {
            return;
        }
        this.f29599o.Z();
    }

    @Override // wa.b
    public void startBackProgress(@NonNull androidx.activity.b bVar) {
        if (l() || this.f29604t == null) {
            return;
        }
        this.f29599o.a0(bVar);
    }

    @Override // wa.b
    public void updateBackProgress(@NonNull androidx.activity.b bVar) {
        if (l() || this.f29604t == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.f29599o.f0(bVar);
    }

    public void updateSoftInputMode() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f29605u = activityWindow.getAttributes().softInputMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        if (this.f29608x) {
            requestFocusAndShowKeyboard();
        }
    }
}
