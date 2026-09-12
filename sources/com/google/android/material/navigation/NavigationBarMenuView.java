package com.google.android.material.navigation;

import ab.i;
import ab.n;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.s;
import androidx.transition.u;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.z;
import java.util.HashSet;
import wa.j;

/* loaded from: classes4.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements m {
    private static final int[] F = {R.attr.state_checked};
    private static final int[] G = {-16842910};
    private n A;
    private boolean B;
    private ColorStateList C;
    private NavigationBarPresenter D;
    private androidx.appcompat.view.menu.f E;

    /* renamed from: a, reason: collision with root package name */
    private final u f29383a;

    /* renamed from: b, reason: collision with root package name */
    private final View.OnClickListener f29384b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.core.util.f f29385c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray f29386d;

    /* renamed from: e, reason: collision with root package name */
    private int f29387e;

    /* renamed from: f, reason: collision with root package name */
    private NavigationBarItemView[] f29388f;

    /* renamed from: g, reason: collision with root package name */
    private int f29389g;

    /* renamed from: h, reason: collision with root package name */
    private int f29390h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f29391i;

    /* renamed from: j, reason: collision with root package name */
    private int f29392j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f29393k;

    /* renamed from: l, reason: collision with root package name */
    private final ColorStateList f29394l;

    /* renamed from: m, reason: collision with root package name */
    private int f29395m;

    /* renamed from: n, reason: collision with root package name */
    private int f29396n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f29397o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f29398p;

    /* renamed from: q, reason: collision with root package name */
    private ColorStateList f29399q;

    /* renamed from: r, reason: collision with root package name */
    private int f29400r;

    /* renamed from: s, reason: collision with root package name */
    private final SparseArray f29401s;

    /* renamed from: t, reason: collision with root package name */
    private int f29402t;

    /* renamed from: u, reason: collision with root package name */
    private int f29403u;

    /* renamed from: v, reason: collision with root package name */
    private int f29404v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f29405w;

    /* renamed from: x, reason: collision with root package name */
    private int f29406x;

    /* renamed from: y, reason: collision with root package name */
    private int f29407y;

    /* renamed from: z, reason: collision with root package name */
    private int f29408z;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h itemData = ((NavigationBarItemView) view).getItemData();
            if (NavigationBarMenuView.this.E.P(itemData, NavigationBarMenuView.this.D, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.f29385c = new androidx.core.util.h(5);
        this.f29386d = new SparseArray(5);
        this.f29389g = 0;
        this.f29390h = 0;
        this.f29401s = new SparseArray(5);
        this.f29402t = -1;
        this.f29403u = -1;
        this.f29404v = -1;
        this.B = false;
        this.f29394l = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.f29383a = null;
        } else {
            androidx.transition.a aVar = new androidx.transition.a();
            this.f29383a = aVar;
            aVar.p0(0);
            aVar.X(j.f(getContext(), R$attr.motionDurationMedium4, getResources().getInteger(R$integer.material_motion_duration_long_1)));
            aVar.Z(j.g(getContext(), R$attr.motionEasingStandard, oa.a.f71042b));
            aVar.h0(new z());
        }
        this.f29384b = new a();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private Drawable c() {
        if (this.A == null || this.C == null) {
            return null;
        }
        i iVar = new i(this.A);
        iVar.d0(this.C);
        return iVar;
    }

    private boolean g(int i11) {
        return i11 != -1;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.f29385c.acquire();
        return navigationBarItemView == null ? d(getContext()) : navigationBarItemView;
    }

    private void i() {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < this.E.size(); i11++) {
            hashSet.add(Integer.valueOf(this.E.getItem(i11).getItemId()));
        }
        for (int i12 = 0; i12 < this.f29401s.size(); i12++) {
            int keyAt = this.f29401s.keyAt(i12);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.f29401s.delete(keyAt);
            }
        }
    }

    private void l(int i11) {
        if (g(i11)) {
            return;
        }
        throw new IllegalArgumentException(i11 + " is not a valid view id");
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id2 = navigationBarItemView.getId();
        if (g(id2) && (badgeDrawable = (BadgeDrawable) this.f29401s.get(id2)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f29385c.release(navigationBarItemView);
                    navigationBarItemView.f();
                }
            }
        }
        if (this.E.size() == 0) {
            this.f29389g = 0;
            this.f29390h = 0;
            this.f29388f = null;
            return;
        }
        i();
        this.f29388f = new NavigationBarItemView[this.E.size()];
        boolean f11 = f(this.f29387e, this.E.G().size());
        for (int i11 = 0; i11 < this.E.size(); i11++) {
            this.D.m(true);
            this.E.getItem(i11).setCheckable(true);
            this.D.m(false);
            NavigationBarItemView newItem = getNewItem();
            this.f29388f[i11] = newItem;
            newItem.setIconTintList(this.f29391i);
            newItem.setIconSize(this.f29392j);
            newItem.setTextColor(this.f29394l);
            newItem.setTextAppearanceInactive(this.f29395m);
            newItem.setTextAppearanceActive(this.f29396n);
            newItem.setTextAppearanceActiveBoldEnabled(this.f29397o);
            newItem.setTextColor(this.f29393k);
            int i12 = this.f29402t;
            if (i12 != -1) {
                newItem.setItemPaddingTop(i12);
            }
            int i13 = this.f29403u;
            if (i13 != -1) {
                newItem.setItemPaddingBottom(i13);
            }
            int i14 = this.f29404v;
            if (i14 != -1) {
                newItem.setActiveIndicatorLabelPadding(i14);
            }
            newItem.setActiveIndicatorWidth(this.f29406x);
            newItem.setActiveIndicatorHeight(this.f29407y);
            newItem.setActiveIndicatorMarginHorizontal(this.f29408z);
            newItem.setActiveIndicatorDrawable(c());
            newItem.setActiveIndicatorResizeable(this.B);
            newItem.setActiveIndicatorEnabled(this.f29405w);
            Drawable drawable = this.f29398p;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f29400r);
            }
            newItem.setItemRippleColor(this.f29399q);
            newItem.setShifting(f11);
            newItem.setLabelVisibilityMode(this.f29387e);
            h hVar = (h) this.E.getItem(i11);
            newItem.initialize(hVar, 0);
            newItem.setItemPosition(i11);
            int itemId = hVar.getItemId();
            newItem.setOnTouchListener((View.OnTouchListener) this.f29386d.get(itemId));
            newItem.setOnClickListener(this.f29384b);
            int i15 = this.f29389g;
            if (i15 != 0 && itemId == i15) {
                this.f29390h = i11;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.E.size() - 1, this.f29390h);
        this.f29390h = min;
        this.E.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i11) {
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
        int[] iArr = G;
        return new ColorStateList(new int[][]{iArr, F, ViewGroup.EMPTY_STATE_SET}, new int[]{a11.getColorForState(iArr, defaultColor), i12, defaultColor});
    }

    protected abstract NavigationBarItemView d(Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeDrawable e(int i11) {
        l(i11);
        BadgeDrawable badgeDrawable = (BadgeDrawable) this.f29401s.get(i11);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.d(getContext());
            this.f29401s.put(i11, badgeDrawable);
        }
        NavigationBarItemView findItemView = findItemView(i11);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(int i11, int i12) {
        if (i11 == -1) {
            if (i12 <= 3) {
                return false;
            }
        } else if (i11 != 0) {
            return false;
        }
        return true;
    }

    @Nullable
    public NavigationBarItemView findItemView(int i11) {
        l(i11);
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr == null) {
            return null;
        }
        for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
            if (navigationBarItemView.getId() == i11) {
                return navigationBarItemView;
            }
        }
        return null;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f29404v;
    }

    @Nullable
    public BadgeDrawable getBadge(int i11) {
        return (BadgeDrawable) this.f29401s.get(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f29401s;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.f29391i;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.C;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f29405w;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f29407y;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f29408z;
    }

    @Nullable
    public n getItemActiveIndicatorShapeAppearance() {
        return this.A;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f29406x;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f29398p : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f29400r;
    }

    public int getItemIconSize() {
        return this.f29392j;
    }

    public int getItemPaddingBottom() {
        return this.f29403u;
    }

    public int getItemPaddingTop() {
        return this.f29402t;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f29399q;
    }

    public int getItemTextAppearanceActive() {
        return this.f29396n;
    }

    public int getItemTextAppearanceInactive() {
        return this.f29395m;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f29393k;
    }

    public int getLabelVisibilityMode() {
        return this.f29387e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public androidx.appcompat.view.menu.f getMenu() {
        return this.E;
    }

    public int getSelectedItemId() {
        return this.f29389g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.f29390h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i11) {
        l(i11);
        NavigationBarItemView findItemView = findItemView(i11);
        if (findItemView != null) {
            findItemView.n();
        }
        this.f29401s.put(i11, null);
    }

    @Override // androidx.appcompat.view.menu.m
    public void initialize(@NonNull androidx.appcompat.view.menu.f fVar) {
        this.E = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(SparseArray sparseArray) {
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            int keyAt = sparseArray.keyAt(i11);
            if (this.f29401s.indexOfKey(keyAt) < 0) {
                this.f29401s.append(keyAt, (BadgeDrawable) sparseArray.get(keyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                BadgeDrawable badgeDrawable = (BadgeDrawable) this.f29401s.get(navigationBarItemView.getId());
                if (badgeDrawable != null) {
                    navigationBarItemView.setBadge(badgeDrawable);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i11) {
        int size = this.E.size();
        for (int i12 = 0; i12 < size; i12++) {
            MenuItem item = this.E.getItem(i12);
            if (i11 == item.getItemId()) {
                this.f29389g = i11;
                this.f29390h = i12;
                item.setChecked(true);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.E.G().size(), false, 1));
    }

    public void setActiveIndicatorLabelPadding(int i11) {
        this.f29404v = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorLabelPadding(i11);
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f29391i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.C = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f29405w = z10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z10);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i11) {
        this.f29407y = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i11);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i11) {
        this.f29408z = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemActiveIndicatorResizeable(boolean z10) {
        this.B = z10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z10);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable n nVar) {
        this.A = nVar;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i11) {
        this.f29406x = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i11);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f29398p = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i11) {
        this.f29400r = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i11);
            }
        }
    }

    public void setItemIconSize(int i11) {
        this.f29392j = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i11);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i11, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f29386d.remove(i11);
        } else {
            this.f29386d.put(i11, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i11) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i11) {
        this.f29403u = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i11);
            }
        }
    }

    public void setItemPaddingTop(int i11) {
        this.f29402t = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i11);
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f29399q = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i11) {
        this.f29396n = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i11);
                ColorStateList colorStateList = this.f29393k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f29397o = z10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActiveBoldEnabled(z10);
            }
        }
    }

    public void setItemTextAppearanceInactive(int i11) {
        this.f29395m = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i11);
                ColorStateList colorStateList = this.f29393k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f29393k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f29388f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i11) {
        this.f29387e = i11;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.D = navigationBarPresenter;
    }

    public void updateMenuView() {
        u uVar;
        androidx.appcompat.view.menu.f fVar = this.E;
        if (fVar == null || this.f29388f == null) {
            return;
        }
        int size = fVar.size();
        if (size != this.f29388f.length) {
            buildMenuView();
            return;
        }
        int i11 = this.f29389g;
        for (int i12 = 0; i12 < size; i12++) {
            MenuItem item = this.E.getItem(i12);
            if (item.isChecked()) {
                this.f29389g = item.getItemId();
                this.f29390h = i12;
            }
        }
        if (i11 != this.f29389g && (uVar = this.f29383a) != null) {
            s.a(this, uVar);
        }
        boolean f11 = f(this.f29387e, this.E.G().size());
        for (int i13 = 0; i13 < size; i13++) {
            this.D.m(true);
            this.f29388f[i13].setLabelVisibilityMode(this.f29387e);
            this.f29388f[i13].setShifting(f11);
            this.f29388f[i13].initialize((h) this.E.getItem(i13), 0);
            this.D.m(false);
        }
    }
}
