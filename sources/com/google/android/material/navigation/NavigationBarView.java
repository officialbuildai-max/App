package com.google.android.material.navigation;

import ab.i;
import ab.j;
import ab.n;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.j0;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.b0;

/* loaded from: classes4.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;

    /* renamed from: a, reason: collision with root package name */
    private final d f29416a;

    /* renamed from: b, reason: collision with root package name */
    private final NavigationBarMenuView f29417b;

    /* renamed from: c, reason: collision with root package name */
    private final NavigationBarPresenter f29418c;

    /* renamed from: d, reason: collision with root package name */
    private MenuInflater f29419d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        Bundle f29420a;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f29420a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeBundle(this.f29420a);
        }
    }

    /* loaded from: classes4.dex */
    class a implements f.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            NavigationBarView.a(NavigationBarView.this);
            NavigationBarView.b(NavigationBarView.this);
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    /* loaded from: classes4.dex */
    public interface c {
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(bb.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f29418c = navigationBarPresenter;
        Context context2 = getContext();
        j0 j11 = b0.j(context2, attributeSet, R$styleable.NavigationBarView, i11, i12, R$styleable.NavigationBarView_itemTextAppearanceInactive, R$styleable.NavigationBarView_itemTextAppearanceActive);
        d dVar = new d(context2, getClass(), getMaxItemCount());
        this.f29416a = dVar;
        NavigationBarMenuView c11 = c(context2);
        this.f29417b = c11;
        navigationBarPresenter.l(c11);
        navigationBarPresenter.a(1);
        c11.setPresenter(navigationBarPresenter);
        dVar.b(navigationBarPresenter);
        navigationBarPresenter.k(getContext(), dVar);
        if (j11.s(R$styleable.NavigationBarView_itemIconTint)) {
            c11.setIconTintList(j11.c(R$styleable.NavigationBarView_itemIconTint));
        } else {
            c11.setIconTintList(c11.createDefaultColorStateList(R.attr.textColorSecondary));
        }
        setItemIconSize(j11.f(R$styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (j11.s(R$styleable.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(j11.n(R$styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (j11.s(R$styleable.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(j11.n(R$styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(j11.a(R$styleable.NavigationBarView_itemTextAppearanceActiveBoldEnabled, true));
        if (j11.s(R$styleable.NavigationBarView_itemTextColor)) {
            setItemTextColor(j11.c(R$styleable.NavigationBarView_itemTextColor));
        }
        Drawable background = getBackground();
        ColorStateList g11 = com.google.android.material.drawable.d.g(background);
        if (background == null || g11 != null) {
            i iVar = new i(n.e(context2, attributeSet, i11, i12).m());
            if (g11 != null) {
                iVar.d0(g11);
            }
            iVar.S(context2);
            ViewCompat.setBackground(this, iVar);
        }
        if (j11.s(R$styleable.NavigationBarView_itemPaddingTop)) {
            setItemPaddingTop(j11.f(R$styleable.NavigationBarView_itemPaddingTop, 0));
        }
        if (j11.s(R$styleable.NavigationBarView_itemPaddingBottom)) {
            setItemPaddingBottom(j11.f(R$styleable.NavigationBarView_itemPaddingBottom, 0));
        }
        if (j11.s(R$styleable.NavigationBarView_activeIndicatorLabelPadding)) {
            setActiveIndicatorLabelPadding(j11.f(R$styleable.NavigationBarView_activeIndicatorLabelPadding, 0));
        }
        if (j11.s(R$styleable.NavigationBarView_elevation)) {
            setElevation(j11.f(R$styleable.NavigationBarView_elevation, 0));
        }
        a1.a.o(getBackground().mutate(), xa.c.b(context2, j11, R$styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(j11.l(R$styleable.NavigationBarView_labelVisibilityMode, -1));
        int n11 = j11.n(R$styleable.NavigationBarView_itemBackground, 0);
        if (n11 != 0) {
            c11.setItemBackgroundRes(n11);
        } else {
            setItemRippleColor(xa.c.b(context2, j11, R$styleable.NavigationBarView_itemRippleColor));
        }
        int n12 = j11.n(R$styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (n12 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(n12, R$styleable.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(R$styleable.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R$styleable.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(xa.c.a(context2, obtainStyledAttributes, R$styleable.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(n.b(context2, obtainStyledAttributes.getResourceId(R$styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
            obtainStyledAttributes.recycle();
        }
        if (j11.s(R$styleable.NavigationBarView_menu)) {
            inflateMenu(j11.n(R$styleable.NavigationBarView_menu, 0));
        }
        j11.x();
        addView(c11);
        dVar.W(new a());
    }

    static /* synthetic */ b a(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    static /* synthetic */ c b(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    private MenuInflater getMenuInflater() {
        if (this.f29419d == null) {
            this.f29419d = new g(getContext());
        }
        return this.f29419d;
    }

    protected abstract NavigationBarMenuView c(Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.f29417b.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public BadgeDrawable getBadge(int i11) {
        return this.f29417b.getBadge(i11);
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f29417b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f29417b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f29417b.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public n getItemActiveIndicatorShapeAppearance() {
        return this.f29417b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f29417b.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f29417b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f29417b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f29417b.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f29417b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f29417b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f29417b.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f29417b.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f29417b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f29417b.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f29417b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f29417b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.f29416a;
    }

    @NonNull
    public m getMenuView() {
        return this.f29417b;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int i11) {
        return this.f29417b.e(i11);
    }

    @NonNull
    public NavigationBarPresenter getPresenter() {
        return this.f29418c;
    }

    public int getSelectedItemId() {
        return this.f29417b.getSelectedItemId();
    }

    public void inflateMenu(int i11) {
        this.f29418c.m(true);
        getMenuInflater().inflate(i11, this.f29416a);
        this.f29418c.m(false);
        this.f29418c.h(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.f29417b.getItemActiveIndicatorEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f29416a.T(savedState.f29420a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f29420a = bundle;
        this.f29416a.V(bundle);
        return savedState;
    }

    public void removeBadge(int i11) {
        this.f29417b.h(i11);
    }

    public void setActiveIndicatorLabelPadding(int i11) {
        this.f29417b.setActiveIndicatorLabelPadding(i11);
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        j.d(this, f11);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.f29417b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f29417b.setItemActiveIndicatorEnabled(z10);
    }

    public void setItemActiveIndicatorHeight(int i11) {
        this.f29417b.setItemActiveIndicatorHeight(i11);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i11) {
        this.f29417b.setItemActiveIndicatorMarginHorizontal(i11);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable n nVar) {
        this.f29417b.setItemActiveIndicatorShapeAppearance(nVar);
    }

    public void setItemActiveIndicatorWidth(int i11) {
        this.f29417b.setItemActiveIndicatorWidth(i11);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f29417b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i11) {
        this.f29417b.setItemBackgroundRes(i11);
    }

    public void setItemIconSize(int i11) {
        this.f29417b.setItemIconSize(i11);
    }

    public void setItemIconSizeRes(int i11) {
        setItemIconSize(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f29417b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i11, @Nullable View.OnTouchListener onTouchListener) {
        this.f29417b.setItemOnTouchListener(i11, onTouchListener);
    }

    public void setItemPaddingBottom(int i11) {
        this.f29417b.setItemPaddingBottom(i11);
    }

    public void setItemPaddingTop(int i11) {
        this.f29417b.setItemPaddingTop(i11);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f29417b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i11) {
        this.f29417b.setItemTextAppearanceActive(i11);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f29417b.setItemTextAppearanceActiveBoldEnabled(z10);
    }

    public void setItemTextAppearanceInactive(int i11) {
        this.f29417b.setItemTextAppearanceInactive(i11);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f29417b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i11) {
        if (this.f29417b.getLabelVisibilityMode() != i11) {
            this.f29417b.setLabelVisibilityMode(i11);
            this.f29418c.h(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable b bVar) {
    }

    public void setOnItemSelectedListener(@Nullable c cVar) {
    }

    public void setSelectedItemId(int i11) {
        MenuItem findItem = this.f29416a.findItem(i11);
        if (findItem == null || this.f29416a.P(findItem, this.f29418c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }
}
