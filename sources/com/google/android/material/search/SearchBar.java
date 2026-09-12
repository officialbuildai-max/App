package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$style;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ToolbarUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes4.dex */
public class SearchBar extends Toolbar {

    /* renamed from: m0, reason: collision with root package name */
    private static final int f29569m0 = R$style.Widget_Material3_SearchBar;
    private final TextView U;
    private final boolean V;
    private final boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private final i f29570a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Drawable f29571b0;

    /* renamed from: c0, reason: collision with root package name */
    private final boolean f29572c0;

    /* renamed from: d0, reason: collision with root package name */
    private final boolean f29573d0;

    /* renamed from: e0, reason: collision with root package name */
    private View f29574e0;

    /* renamed from: f0, reason: collision with root package name */
    private Integer f29575f0;

    /* renamed from: g0, reason: collision with root package name */
    private Drawable f29576g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f29577h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f29578i0;

    /* renamed from: j0, reason: collision with root package name */
    private ab.i f29579j0;

    /* renamed from: k0, reason: collision with root package name */
    private final AccessibilityManager f29580k0;

    /* renamed from: l0, reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f29581l0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f29582a;

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
            this.f29582a = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f29582a);
        }
    }

    /* loaded from: classes4.dex */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: h, reason: collision with root package name */
        private boolean f29583h;

        public ScrollingViewBehavior() {
            this.f29583h = false;
        }

        public ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f29583h = false;
        }

        private void U(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.h
        protected boolean P() {
            return true;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean h11 = super.h(coordinatorLayout, view, view2);
            if (!this.f29583h && (view2 instanceof AppBarLayout)) {
                this.f29583h = true;
                U((AppBarLayout) view2);
            }
            return h11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(SearchBar.this.f29580k0, SearchBar.this.f29581l0);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(SearchBar.this.f29580k0, SearchBar.this.f29581l0);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b {
        public void a() {
        }

        public void b() {
        }
    }

    public SearchBar(@NonNull Context context) {
        this(context, null);
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSearchBarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SearchBar(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = com.google.android.material.search.SearchBar.f29569m0
            android.content.Context r11 = bb.a.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            r11 = -1
            r10.f29577h0 = r11
            com.google.android.material.search.c r0 = new com.google.android.material.search.c
            r0.<init>()
            r10.f29581l0 = r0
            android.content.Context r7 = r10.getContext()
            r10.U(r12)
            int r0 = r10.getDefaultNavigationIconResource()
            android.graphics.drawable.Drawable r0 = g.a.b(r7, r0)
            r10.f29571b0 = r0
            com.google.android.material.search.i r0 = new com.google.android.material.search.i
            r0.<init>()
            r10.f29570a0 = r0
            int[] r2 = com.google.android.material.R$styleable.SearchBar
            r8 = 0
            int[] r5 = new int[r8]
            r0 = r7
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            ab.n$b r12 = ab.n.e(r7, r12, r13, r6)
            ab.n r2 = r12.m()
            int r12 = com.google.android.material.R$styleable.SearchBar_backgroundTint
            int r3 = r0.getColor(r12, r8)
            int r12 = com.google.android.material.R$styleable.SearchBar_elevation
            r13 = 0
            float r4 = r0.getDimension(r12, r13)
            int r12 = com.google.android.material.R$styleable.SearchBar_defaultMarginsEnabled
            r13 = 1
            boolean r12 = r0.getBoolean(r12, r13)
            r10.W = r12
            int r12 = com.google.android.material.R$styleable.SearchBar_defaultScrollFlagsEnabled
            boolean r12 = r0.getBoolean(r12, r13)
            r10.f29578i0 = r12
            int r12 = com.google.android.material.R$styleable.SearchBar_hideNavigationIcon
            boolean r12 = r0.getBoolean(r12, r8)
            int r1 = com.google.android.material.R$styleable.SearchBar_forceDefaultNavigationOnClickListener
            boolean r1 = r0.getBoolean(r1, r8)
            r10.f29573d0 = r1
            int r1 = com.google.android.material.R$styleable.SearchBar_tintNavigationIcon
            boolean r1 = r0.getBoolean(r1, r13)
            r10.f29572c0 = r1
            int r1 = com.google.android.material.R$styleable.SearchBar_navigationIconTint
            boolean r1 = r0.hasValue(r1)
            if (r1 == 0) goto L88
            int r1 = com.google.android.material.R$styleable.SearchBar_navigationIconTint
            int r1 = r0.getColor(r1, r11)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.f29575f0 = r1
        L88:
            int r1 = com.google.android.material.R$styleable.SearchBar_android_textAppearance
            int r11 = r0.getResourceId(r1, r11)
            int r1 = com.google.android.material.R$styleable.SearchBar_android_text
            java.lang.String r1 = r0.getString(r1)
            int r5 = com.google.android.material.R$styleable.SearchBar_android_hint
            java.lang.String r5 = r0.getString(r5)
            int r6 = com.google.android.material.R$styleable.SearchBar_strokeWidth
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r6 = r0.getDimension(r6, r9)
            int r9 = com.google.android.material.R$styleable.SearchBar_strokeColor
            int r8 = r0.getColor(r9, r8)
            r0.recycle()
            if (r12 != 0) goto Lb0
            r10.I()
        Lb0:
            r10.setClickable(r13)
            r10.setFocusable(r13)
            android.view.LayoutInflater r12 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R$layout.mtrl_search_bar
            r12.inflate(r0, r10)
            r10.V = r13
            int r12 = com.google.android.material.R$id.open_search_bar_text_view
            android.view.View r12 = r10.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r10.U = r12
            androidx.core.view.ViewCompat.setElevation(r10, r4)
            r10.J(r11, r1, r5)
            r1 = r10
            r5 = r6
            r6 = r8
            r1.H(r2, r3, r4, r5, r6)
            android.content.Context r11 = r10.getContext()
            java.lang.String r12 = "accessibility"
            java.lang.Object r11 = r11.getSystemService(r12)
            android.view.accessibility.AccessibilityManager r11 = (android.view.accessibility.AccessibilityManager) r11
            r10.f29580k0 = r11
            r10.T()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private int G(int i11, int i12) {
        return i11 == 0 ? i12 : i11;
    }

    private void H(ab.n nVar, int i11, float f11, float f12, int i12) {
        ab.i iVar = new ab.i(nVar);
        this.f29579j0 = iVar;
        iVar.S(getContext());
        this.f29579j0.c0(f11);
        if (f12 >= 0.0f) {
            this.f29579j0.l0(f12, i12);
        }
        int d11 = com.google.android.material.color.b.d(this, R$attr.colorControlHighlight);
        this.f29579j0.d0(ColorStateList.valueOf(i11));
        ColorStateList valueOf = ColorStateList.valueOf(d11);
        ab.i iVar2 = this.f29579j0;
        ViewCompat.setBackground(this, new RippleDrawable(valueOf, iVar2, iVar2));
    }

    private void I() {
        setNavigationIcon(getNavigationIcon() == null ? this.f29571b0 : getNavigationIcon());
        setNavigationIconDecorative(true);
    }

    private void J(int i11, String str, String str2) {
        if (i11 != -1) {
            androidx.core.widget.m.q(this.U, i11);
        }
        setText(str);
        setHint(str2);
        if (getNavigationIcon() == null) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.U.getLayoutParams(), getResources().getDimensionPixelSize(R$dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(boolean z10) {
        setFocusableInTouchMode(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f29570a0.J(this);
    }

    private void M() {
        View view = this.f29574e0;
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i11 = measuredWidth2 + measuredWidth;
        int measuredHeight = this.f29574e0.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        N(this.f29574e0, measuredWidth2, measuredHeight2, i11, measuredHeight2 + measuredHeight);
    }

    private void N(View view, int i11, int i12, int i13, int i14) {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            view.layout(getMeasuredWidth() - i13, i12, getMeasuredWidth() - i11, i14);
        } else {
            view.layout(i11, i12, i13, i14);
        }
    }

    private Drawable O(Drawable drawable) {
        int d11;
        if (!this.f29572c0 || drawable == null) {
            return drawable;
        }
        Integer num = this.f29575f0;
        if (num != null) {
            d11 = num.intValue();
        } else {
            d11 = com.google.android.material.color.b.d(this, drawable == this.f29571b0 ? R$attr.colorOnSurfaceVariant : R$attr.colorOnSurface);
        }
        Drawable r11 = a1.a.r(drawable.mutate());
        a1.a.n(r11, d11);
        return r11;
    }

    private void P(int i11, int i12) {
        View view = this.f29574e0;
        if (view != null) {
            view.measure(i11, i12);
        }
    }

    private void Q() {
        if (this.W && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = G(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = G(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = G(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = G(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void R() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z10 = getLayoutDirection() == 1;
        ImageButton e11 = ToolbarUtils.e(this);
        int width = (e11 == null || !e11.isClickable()) ? 0 : z10 ? getWidth() - e11.getLeft() : e11.getRight();
        ActionMenuView b11 = ToolbarUtils.b(this);
        int right = b11 != null ? z10 ? b11.getRight() : getWidth() - b11.getLeft() : 0;
        float f11 = -(z10 ? right : width);
        if (!z10) {
            width = right;
        }
        setHandwritingBoundsOffsets(f11, 0.0f, -width, 0.0f);
    }

    private void S() {
        if (getLayoutParams() instanceof AppBarLayout.e) {
            AppBarLayout.e eVar = (AppBarLayout.e) getLayoutParams();
            if (this.f29578i0) {
                if (eVar.c() == 0) {
                    eVar.g(53);
                }
            } else if (eVar.c() == 53) {
                eVar.g(0);
            }
        }
    }

    private void T() {
        AccessibilityManager accessibilityManager = this.f29580k0;
        if (accessibilityManager != null) {
            if (accessibilityManager.isEnabled() && this.f29580k0.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new a());
        }
    }

    private void U(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", CampaignEx.JSON_KEY_TITLE) != null) {
            throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "subtitle") != null) {
            throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
        }
    }

    private void setNavigationIconDecorative(boolean z10) {
        ImageButton e11 = ToolbarUtils.e(this);
        if (e11 == null) {
            return;
        }
        e11.setClickable(!z10);
        e11.setFocusable(!z10);
        Drawable background = e11.getBackground();
        if (background != null) {
            this.f29576g0 = background;
        }
        e11.setBackgroundDrawable(z10 ? null : this.f29576g0);
        R();
    }

    public void addCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f29570a0.h(animatorListenerAdapter);
    }

    public void addExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f29570a0.i(animatorListenerAdapter);
    }

    public void addOnLoadAnimationCallback(@NonNull b bVar) {
        this.f29570a0.j(bVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.V && this.f29574e0 == null && !(view instanceof ActionMenuView)) {
            this.f29574e0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i11, layoutParams);
    }

    public void clearText() {
        this.U.setText("");
    }

    public boolean collapse(@NonNull View view) {
        return collapse(view, null);
    }

    public boolean collapse(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return collapse(view, appBarLayout, false);
    }

    public boolean collapse(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z10) {
        if ((view.getVisibility() != 0 || isCollapsing()) && !isExpanding()) {
            return false;
        }
        this.f29570a0.H(this, view, appBarLayout, z10);
        return true;
    }

    public boolean expand(@NonNull View view) {
        return expand(view, null);
    }

    public boolean expand(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return expand(view, appBarLayout, false);
    }

    public boolean expand(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z10) {
        if ((view.getVisibility() == 0 || isExpanding()) && !isCollapsing()) {
            return false;
        }
        this.f29570a0.I(this, view, appBarLayout, z10);
        return true;
    }

    @Nullable
    public View getCenterView() {
        return this.f29574e0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCompatElevation() {
        ab.i iVar = this.f29579j0;
        return iVar != null ? iVar.y() : ViewCompat.getElevation(this);
    }

    public float getCornerSize() {
        return this.f29579j0.L();
    }

    protected int getDefaultMarginVerticalResource() {
        return R$dimen.m3_searchbar_margin_vertical;
    }

    protected int getDefaultNavigationIconResource() {
        return R$drawable.ic_search_black_24;
    }

    @Nullable
    public CharSequence getHint() {
        return this.U.getHint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMenuResId() {
        return this.f29577h0;
    }

    public int getStrokeColor() {
        return this.f29579j0.H().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f29579j0.J();
    }

    @NonNull
    public CharSequence getText() {
        return this.U.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.U;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i11) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof androidx.appcompat.view.menu.f;
        if (z10) {
            ((androidx.appcompat.view.menu.f) menu).i0();
        }
        super.inflateMenu(i11);
        this.f29577h0 = i11;
        if (z10) {
            ((androidx.appcompat.view.menu.f) menu).h0();
        }
    }

    public boolean isCollapsing() {
        return this.f29570a0.x();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.f29578i0;
    }

    public boolean isExpanding() {
        return this.f29570a0.y();
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.f29570a0.z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ab.j.f(this, this.f29579j0);
        Q();
        S();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        int i11 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (i11 >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        M();
        R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        P(i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.f29582a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.f29582a = text == null ? null : text.toString();
        return savedState;
    }

    public boolean removeCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f29570a0.D(animatorListenerAdapter);
    }

    public boolean removeExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f29570a0.E(animatorListenerAdapter);
    }

    public boolean removeOnLoadAnimationCallback(@NonNull b bVar) {
        return this.f29570a0.F(bVar);
    }

    public void setCenterView(@Nullable View view) {
        View view2 = this.f29574e0;
        if (view2 != null) {
            removeView(view2);
            this.f29574e0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z10) {
        this.f29578i0 = z10;
        S();
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        ab.i iVar = this.f29579j0;
        if (iVar != null) {
            iVar.c0(f11);
        }
    }

    public void setHint(int i11) {
        this.U.setHint(i11);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.U.setHint(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(O(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.f29573d0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z10) {
        this.f29570a0.G(z10);
    }

    public void setStrokeColor(int i11) {
        if (getStrokeColor() != i11) {
            this.f29579j0.n0(ColorStateList.valueOf(i11));
        }
    }

    public void setStrokeWidth(float f11) {
        if (getStrokeWidth() != f11) {
            this.f29579j0.o0(f11);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(int i11) {
        this.U.setText(i11);
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.U.setText(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void startOnLoadAnimation() {
        post(new Runnable() { // from class: com.google.android.material.search.b
            @Override // java.lang.Runnable
            public final void run() {
                SearchBar.this.L();
            }
        });
    }

    public void stopOnLoadAnimation() {
        this.f29570a0.K(this);
    }
}
