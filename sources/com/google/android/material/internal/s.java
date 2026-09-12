package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.l;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class s implements androidx.appcompat.view.menu.l {
    private int A;
    int B;

    /* renamed from: a, reason: collision with root package name */
    private NavigationMenuView f29284a;

    /* renamed from: b, reason: collision with root package name */
    LinearLayout f29285b;

    /* renamed from: c, reason: collision with root package name */
    private l.a f29286c;

    /* renamed from: d, reason: collision with root package name */
    androidx.appcompat.view.menu.f f29287d;

    /* renamed from: e, reason: collision with root package name */
    private int f29288e;

    /* renamed from: f, reason: collision with root package name */
    c f29289f;

    /* renamed from: g, reason: collision with root package name */
    LayoutInflater f29290g;

    /* renamed from: i, reason: collision with root package name */
    ColorStateList f29292i;

    /* renamed from: l, reason: collision with root package name */
    ColorStateList f29295l;

    /* renamed from: m, reason: collision with root package name */
    ColorStateList f29296m;

    /* renamed from: n, reason: collision with root package name */
    Drawable f29297n;

    /* renamed from: o, reason: collision with root package name */
    RippleDrawable f29298o;

    /* renamed from: p, reason: collision with root package name */
    int f29299p;

    /* renamed from: q, reason: collision with root package name */
    int f29300q;

    /* renamed from: r, reason: collision with root package name */
    int f29301r;

    /* renamed from: s, reason: collision with root package name */
    int f29302s;

    /* renamed from: t, reason: collision with root package name */
    int f29303t;

    /* renamed from: u, reason: collision with root package name */
    int f29304u;

    /* renamed from: v, reason: collision with root package name */
    int f29305v;

    /* renamed from: w, reason: collision with root package name */
    int f29306w;

    /* renamed from: x, reason: collision with root package name */
    boolean f29307x;

    /* renamed from: z, reason: collision with root package name */
    private int f29309z;

    /* renamed from: h, reason: collision with root package name */
    int f29291h = 0;

    /* renamed from: j, reason: collision with root package name */
    int f29293j = 0;

    /* renamed from: k, reason: collision with root package name */
    boolean f29294k = true;

    /* renamed from: y, reason: collision with root package name */
    boolean f29308y = true;
    private int C = -1;
    final View.OnClickListener D = new a();

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z10 = true;
            s.this.a0(true);
            androidx.appcompat.view.menu.h itemData = ((NavigationMenuItemView) view).getItemData();
            s sVar = s.this;
            boolean P = sVar.f29287d.P(itemData, sVar, 0);
            if (itemData != null && itemData.isCheckable() && P) {
                s.this.f29289f.s(itemData);
            } else {
                z10 = false;
            }
            s.this.a0(false);
            if (z10) {
                s.this.h(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayList f29311a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private androidx.appcompat.view.menu.h f29312b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f29313c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends AccessibilityDelegateCompat {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f29315a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f29316b;

            a(int i11, boolean z10) {
                this.f29315a = i11;
                this.f29316b = z10;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(c.this.h(this.f29315a), 1, 1, 1, this.f29316b, view.isSelected()));
            }
        }

        c() {
            p();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h(int i11) {
            int i12 = i11;
            for (int i13 = 0; i13 < i11; i13++) {
                if (s.this.f29289f.getItemViewType(i13) == 2 || s.this.f29289f.getItemViewType(i13) == 3) {
                    i12--;
                }
            }
            return i12;
        }

        private void i(int i11, int i12) {
            while (i11 < i12) {
                ((g) this.f29311a.get(i11)).f29321b = true;
                i11++;
            }
        }

        private void p() {
            if (this.f29313c) {
                return;
            }
            boolean z10 = true;
            this.f29313c = true;
            this.f29311a.clear();
            this.f29311a.add(new d());
            int size = s.this.f29287d.G().size();
            int i11 = -1;
            int i12 = 0;
            boolean z11 = false;
            int i13 = 0;
            while (i12 < size) {
                androidx.appcompat.view.menu.h hVar = (androidx.appcompat.view.menu.h) s.this.f29287d.G().get(i12);
                if (hVar.isChecked()) {
                    s(hVar);
                }
                if (hVar.isCheckable()) {
                    hVar.t(false);
                }
                if (hVar.hasSubMenu()) {
                    SubMenu subMenu = hVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i12 != 0) {
                            this.f29311a.add(new f(s.this.B, 0));
                        }
                        this.f29311a.add(new g(hVar));
                        int size2 = this.f29311a.size();
                        int size3 = subMenu.size();
                        int i14 = 0;
                        boolean z12 = false;
                        while (i14 < size3) {
                            androidx.appcompat.view.menu.h hVar2 = (androidx.appcompat.view.menu.h) subMenu.getItem(i14);
                            if (hVar2.isVisible()) {
                                if (!z12 && hVar2.getIcon() != null) {
                                    z12 = z10;
                                }
                                if (hVar2.isCheckable()) {
                                    hVar2.t(false);
                                }
                                if (hVar.isChecked()) {
                                    s(hVar);
                                }
                                this.f29311a.add(new g(hVar2));
                            }
                            i14++;
                            z10 = true;
                        }
                        if (z12) {
                            i(size2, this.f29311a.size());
                        }
                    }
                } else {
                    int groupId = hVar.getGroupId();
                    if (groupId != i11) {
                        i13 = this.f29311a.size();
                        z11 = hVar.getIcon() != null;
                        if (i12 != 0) {
                            i13++;
                            ArrayList arrayList = this.f29311a;
                            int i15 = s.this.B;
                            arrayList.add(new f(i15, i15));
                        }
                    } else if (!z11 && hVar.getIcon() != null) {
                        i(i13, this.f29311a.size());
                        z11 = true;
                    }
                    g gVar = new g(hVar);
                    gVar.f29321b = z11;
                    this.f29311a.add(gVar);
                    i11 = groupId;
                }
                i12++;
                z10 = true;
            }
            this.f29313c = false;
        }

        private void r(View view, int i11, boolean z10) {
            ViewCompat.setAccessibilityDelegate(view, new a(i11, z10));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f29311a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i11) {
            e eVar = (e) this.f29311a.get(i11);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public Bundle j() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.h hVar = this.f29312b;
            if (hVar != null) {
                bundle.putInt("android:menu:checked", hVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f29311a.size();
            for (int i11 = 0; i11 < size; i11++) {
                e eVar = (e) this.f29311a.get(i11);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.h a11 = ((g) eVar).a();
                    View actionView = a11 != null ? a11.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a11.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.h k() {
            return this.f29312b;
        }

        int l() {
            int i11 = 0;
            for (int i12 = 0; i12 < s.this.f29289f.getItemCount(); i12++) {
                int itemViewType = s.this.f29289f.getItemViewType(i12);
                if (itemViewType == 0 || itemViewType == 1) {
                    i11++;
                }
            }
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(l lVar, int i11) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    f fVar = (f) this.f29311a.get(i11);
                    lVar.itemView.setPadding(s.this.f29303t, fVar.b(), s.this.f29304u, fVar.a());
                    return;
                }
                TextView textView = (TextView) lVar.itemView;
                textView.setText(((g) this.f29311a.get(i11)).a().getTitle());
                androidx.core.widget.m.q(textView, s.this.f29291h);
                textView.setPadding(s.this.f29305v, textView.getPaddingTop(), s.this.f29306w, textView.getPaddingBottom());
                ColorStateList colorStateList = s.this.f29292i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                r(textView, i11, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(s.this.f29296m);
            navigationMenuItemView.setTextAppearance(s.this.f29293j);
            ColorStateList colorStateList2 = s.this.f29295l;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = s.this.f29297n;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = s.this.f29298o;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f29311a.get(i11);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f29321b);
            s sVar = s.this;
            int i12 = sVar.f29299p;
            int i13 = sVar.f29300q;
            navigationMenuItemView.setPadding(i12, i13, i12, i13);
            navigationMenuItemView.setIconPadding(s.this.f29301r);
            s sVar2 = s.this;
            if (sVar2.f29307x) {
                navigationMenuItemView.setIconSize(sVar2.f29302s);
            }
            navigationMenuItemView.setMaxLines(s.this.f29309z);
            navigationMenuItemView.initialize(gVar.a(), s.this.f29294k);
            r(navigationMenuItemView, i11, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public l onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == 0) {
                s sVar = s.this;
                return new i(sVar.f29290g, viewGroup, sVar.D);
            }
            if (i11 == 1) {
                return new k(s.this.f29290g, viewGroup);
            }
            if (i11 == 2) {
                return new j(s.this.f29290g, viewGroup);
            }
            if (i11 != 3) {
                return null;
            }
            return new b(s.this.f29285b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).recycle();
            }
        }

        public void q(Bundle bundle) {
            androidx.appcompat.view.menu.h a11;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.h a12;
            int i11 = bundle.getInt("android:menu:checked", 0);
            if (i11 != 0) {
                this.f29313c = true;
                int size = this.f29311a.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size) {
                        break;
                    }
                    e eVar = (e) this.f29311a.get(i12);
                    if ((eVar instanceof g) && (a12 = ((g) eVar).a()) != null && a12.getItemId() == i11) {
                        s(a12);
                        break;
                    }
                    i12++;
                }
                this.f29313c = false;
                p();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f29311a.size();
                for (int i13 = 0; i13 < size2; i13++) {
                    e eVar2 = (e) this.f29311a.get(i13);
                    if ((eVar2 instanceof g) && (a11 = ((g) eVar2).a()) != null && (actionView = a11.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a11.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void s(androidx.appcompat.view.menu.h hVar) {
            if (this.f29312b == hVar || !hVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.h hVar2 = this.f29312b;
            if (hVar2 != null) {
                hVar2.setChecked(false);
            }
            this.f29312b = hVar;
            hVar.setChecked(true);
        }

        public void t(boolean z10) {
            this.f29313c = z10;
        }

        public void u() {
            p();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d implements e {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f implements e {

        /* renamed from: a, reason: collision with root package name */
        private final int f29318a;

        /* renamed from: b, reason: collision with root package name */
        private final int f29319b;

        public f(int i11, int i12) {
            this.f29318a = i11;
            this.f29319b = i12;
        }

        public int a() {
            return this.f29319b;
        }

        public int b() {
            return this.f29318a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.appcompat.view.menu.h f29320a;

        /* renamed from: b, reason: collision with root package name */
        boolean f29321b;

        g(androidx.appcompat.view.menu.h hVar) {
            this.f29320a = hVar;
        }

        public androidx.appcompat.view.menu.h a() {
            return this.f29320a;
        }
    }

    /* loaded from: classes4.dex */
    private class h extends androidx.recyclerview.widget.o {
        h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.o, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(s.this.f29289f.l(), 1, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    private static abstract class l extends RecyclerView.b0 {
        public l(View view) {
            super(view);
        }
    }

    private boolean C() {
        return q() > 0;
    }

    private void b0() {
        int i11 = (C() || !this.f29308y) ? 0 : this.A;
        NavigationMenuView navigationMenuView = this.f29284a;
        navigationMenuView.setPadding(0, i11, 0, navigationMenuView.getPaddingBottom());
    }

    public int A() {
        return this.f29306w;
    }

    public int B() {
        return this.f29305v;
    }

    public View D(int i11) {
        View inflate = this.f29290g.inflate(i11, (ViewGroup) this.f29285b, false);
        l(inflate);
        return inflate;
    }

    public void E(View view) {
        this.f29285b.removeView(view);
        if (C()) {
            return;
        }
        NavigationMenuView navigationMenuView = this.f29284a;
        navigationMenuView.setPadding(0, this.A, 0, navigationMenuView.getPaddingBottom());
    }

    public void F(boolean z10) {
        if (this.f29308y != z10) {
            this.f29308y = z10;
            b0();
        }
    }

    public void G(androidx.appcompat.view.menu.h hVar) {
        this.f29289f.s(hVar);
    }

    public void H(int i11) {
        this.f29304u = i11;
        h(false);
    }

    public void I(int i11) {
        this.f29303t = i11;
        h(false);
    }

    public void J(int i11) {
        this.f29288e = i11;
    }

    public void K(Drawable drawable) {
        this.f29297n = drawable;
        h(false);
    }

    public void L(RippleDrawable rippleDrawable) {
        this.f29298o = rippleDrawable;
        h(false);
    }

    public void M(int i11) {
        this.f29299p = i11;
        h(false);
    }

    public void N(int i11) {
        this.f29301r = i11;
        h(false);
    }

    public void O(int i11) {
        if (this.f29302s != i11) {
            this.f29302s = i11;
            this.f29307x = true;
            h(false);
        }
    }

    public void P(ColorStateList colorStateList) {
        this.f29296m = colorStateList;
        h(false);
    }

    public void Q(int i11) {
        this.f29309z = i11;
        h(false);
    }

    public void R(int i11) {
        this.f29293j = i11;
        h(false);
    }

    public void S(boolean z10) {
        this.f29294k = z10;
        h(false);
    }

    public void T(ColorStateList colorStateList) {
        this.f29295l = colorStateList;
        h(false);
    }

    public void U(int i11) {
        this.f29300q = i11;
        h(false);
    }

    public void V(int i11) {
        this.C = i11;
        NavigationMenuView navigationMenuView = this.f29284a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i11);
        }
    }

    public void W(ColorStateList colorStateList) {
        this.f29292i = colorStateList;
        h(false);
    }

    public void X(int i11) {
        this.f29306w = i11;
        h(false);
    }

    public void Y(int i11) {
        this.f29305v = i11;
        h(false);
    }

    public void Z(int i11) {
        this.f29291h = i11;
        h(false);
    }

    public void a0(boolean z10) {
        c cVar = this.f29289f;
        if (cVar != null) {
            cVar.t(z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
        l.a aVar = this.f29286c;
        if (aVar != null) {
            aVar.b(fVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f29284a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f29289f.q(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f29285b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(androidx.appcompat.view.menu.q qVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        Bundle bundle = new Bundle();
        if (this.f29284a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f29284a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f29289f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.j());
        }
        if (this.f29285b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f29285b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f29288e;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        c cVar = this.f29289f;
        if (cVar != null) {
            cVar.u();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, androidx.appcompat.view.menu.f fVar) {
        this.f29290g = LayoutInflater.from(context);
        this.f29287d = fVar;
        this.B = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public void l(View view) {
        this.f29285b.addView(view);
        NavigationMenuView navigationMenuView = this.f29284a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void m(WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.A != systemWindowInsetTop) {
            this.A = systemWindowInsetTop;
            b0();
        }
        NavigationMenuView navigationMenuView = this.f29284a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.f29285b, windowInsetsCompat);
    }

    public androidx.appcompat.view.menu.h n() {
        return this.f29289f.k();
    }

    public int o() {
        return this.f29304u;
    }

    public int p() {
        return this.f29303t;
    }

    public int q() {
        return this.f29285b.getChildCount();
    }

    public View r(int i11) {
        return this.f29285b.getChildAt(i11);
    }

    public Drawable s() {
        return this.f29297n;
    }

    public int t() {
        return this.f29299p;
    }

    public int u() {
        return this.f29301r;
    }

    public int v() {
        return this.f29309z;
    }

    public ColorStateList w() {
        return this.f29295l;
    }

    public ColorStateList x() {
        return this.f29296m;
    }

    public int y() {
        return this.f29300q;
    }

    public androidx.appcompat.view.menu.m z(ViewGroup viewGroup) {
        if (this.f29284a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f29290g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.f29284a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f29284a));
            if (this.f29289f == null) {
                c cVar = new c();
                this.f29289f = cVar;
                cVar.setHasStableIds(true);
            }
            int i11 = this.C;
            if (i11 != -1) {
                this.f29284a.setOverScrollMode(i11);
            }
            LinearLayout linearLayout = (LinearLayout) this.f29290g.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.f29284a, false);
            this.f29285b = linearLayout;
            ViewCompat.setImportantForAccessibility(linearLayout, 2);
            this.f29284a.setAdapter(this.f29289f);
        }
        return this.f29284a;
    }
}
