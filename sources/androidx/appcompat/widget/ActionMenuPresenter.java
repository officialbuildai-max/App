package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements ActionProvider.SubUiVisibilityListener {
    OpenOverflowRunnable A;
    private b B;
    final e C;
    int D;

    /* renamed from: k, reason: collision with root package name */
    c f1681k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f1682l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1683m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1684n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1685o;

    /* renamed from: p, reason: collision with root package name */
    private int f1686p;

    /* renamed from: q, reason: collision with root package name */
    private int f1687q;

    /* renamed from: r, reason: collision with root package name */
    private int f1688r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1689s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f1690t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f1691u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1692v;

    /* renamed from: w, reason: collision with root package name */
    private int f1693w;

    /* renamed from: x, reason: collision with root package name */
    private final SparseBooleanArray f1694x;

    /* renamed from: y, reason: collision with root package name */
    d f1695y;

    /* renamed from: z, reason: collision with root package name */
    a f1696z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OpenOverflowRunnable implements Runnable {
        private d mPopup;

        public OpenOverflowRunnable(d dVar) {
            this.mPopup = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1485c != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1485c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1491i;
            if (view != null && view.getWindowToken() != null && this.mPopup.m()) {
                ActionMenuPresenter.this.f1695y = this.mPopup;
            }
            ActionMenuPresenter.this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int openSubMenuId;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.k {
        public a(Context context, androidx.appcompat.view.menu.q qVar, View view) {
            super(context, qVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.h) qVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f1681k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1491i : view2);
            }
            j(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.k
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f1696z = null;
            actionMenuPresenter.D = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.o a() {
            a aVar = ActionMenuPresenter.this.f1696z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends AppCompatImageView implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends ForwardingListener {

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ ActionMenuPresenter f1700j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f1700j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public androidx.appcompat.view.menu.o b() {
                d dVar = ActionMenuPresenter.this.f1695y;
                if (dVar == null) {
                    return null;
                }
                return dVar.c();
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean c() {
                ActionMenuPresenter.this.N();
                return true;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.A != null) {
                    return false;
                }
                actionMenuPresenter.D();
                return true;
            }
        }

        public c(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            o0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.N();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i11, int i12, int i13, int i14) {
            boolean frame = super.setFrame(i11, i12, i13, i14);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                a1.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends androidx.appcompat.view.menu.k {
        public d(Context context, androidx.appcompat.view.menu.f fVar, View view, boolean z10) {
            super(context, fVar, view, z10, R$attr.actionOverflowMenuStyle);
            h(GravityCompat.END);
            j(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.k
        protected void e() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1485c != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1485c.close();
            }
            ActionMenuPresenter.this.f1695y = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class e implements l.a {
        e() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
            if (fVar instanceof androidx.appcompat.view.menu.q) {
                fVar.F().e(false);
            }
            l.a o11 = ActionMenuPresenter.this.o();
            if (o11 != null) {
                o11.b(fVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(androidx.appcompat.view.menu.f fVar) {
            if (fVar == ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1485c) {
                return false;
            }
            ActionMenuPresenter.this.D = ((androidx.appcompat.view.menu.q) fVar).getItem().getItemId();
            l.a o11 = ActionMenuPresenter.this.o();
            if (o11 != null) {
                return o11.c(fVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.f1694x = new SparseBooleanArray();
        this.C = new e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1491i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof m.a) && ((m.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        return D() | E();
    }

    public Drawable C() {
        c cVar = this.f1681k;
        if (cVar != null) {
            return cVar.getDrawable();
        }
        if (this.f1683m) {
            return this.f1682l;
        }
        return null;
    }

    public boolean D() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.A;
        if (openOverflowRunnable != null && (obj = this.f1491i) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.A = null;
            return true;
        }
        d dVar = this.f1695y;
        if (dVar == null) {
            return false;
        }
        dVar.b();
        return true;
    }

    public boolean E() {
        a aVar = this.f1696z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean F() {
        return this.A != null || G();
    }

    public boolean G() {
        d dVar = this.f1695y;
        return dVar != null && dVar.d();
    }

    public boolean H() {
        return this.f1684n;
    }

    public void I(Configuration configuration) {
        if (!this.f1689s) {
            this.f1688r = androidx.appcompat.view.a.b(this.f1484b).d();
        }
        androidx.appcompat.view.menu.f fVar = this.f1485c;
        if (fVar != null) {
            fVar.N(true);
        }
    }

    public void J(boolean z10) {
        this.f1692v = z10;
    }

    public void K(ActionMenuView actionMenuView) {
        this.f1491i = actionMenuView;
        actionMenuView.initialize(this.f1485c);
    }

    public void L(Drawable drawable) {
        c cVar = this.f1681k;
        if (cVar != null) {
            cVar.setImageDrawable(drawable);
        } else {
            this.f1683m = true;
            this.f1682l = drawable;
        }
    }

    public void M(boolean z10) {
        this.f1684n = z10;
        this.f1685o = true;
    }

    public boolean N() {
        androidx.appcompat.view.menu.f fVar;
        if (!this.f1684n || G() || (fVar = this.f1485c) == null || this.f1491i == null || this.A != null || fVar.B().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new d(this.f1484b, this.f1485c, this.f1681k, true));
        this.A = openOverflowRunnable;
        ((View) this.f1491i).post(openOverflowRunnable);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
        A();
        super.b(fVar, z10);
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
        int i11;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i11 = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.f1485c.findItem(i11)) != null) {
            f((androidx.appcompat.view.menu.q) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public boolean f(androidx.appcompat.view.menu.q qVar) {
        boolean z10 = false;
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.q qVar2 = qVar;
        while (qVar2.j0() != this.f1485c) {
            qVar2 = (androidx.appcompat.view.menu.q) qVar2.j0();
        }
        View B = B(qVar2.getItem());
        if (B == null) {
            return false;
        }
        this.D = qVar.getItem().getItemId();
        int size = qVar.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            MenuItem item = qVar.getItem(i11);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i11++;
        }
        a aVar = new a(this.f1484b, qVar, B);
        this.f1696z = aVar;
        aVar.g(z10);
        this.f1696z.k();
        super.f(qVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.D;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        super.h(z10);
        ((View) this.f1491i).requestLayout();
        androidx.appcompat.view.menu.f fVar = this.f1485c;
        boolean z11 = false;
        if (fVar != null) {
            ArrayList u11 = fVar.u();
            int size = u11.size();
            for (int i11 = 0; i11 < size; i11++) {
                ActionProvider a11 = ((androidx.appcompat.view.menu.h) u11.get(i11)).a();
                if (a11 != null) {
                    a11.setSubUiVisibilityListener(this);
                }
            }
        }
        androidx.appcompat.view.menu.f fVar2 = this.f1485c;
        ArrayList B = fVar2 != null ? fVar2.B() : null;
        if (this.f1684n && B != null) {
            int size2 = B.size();
            if (size2 == 1) {
                z11 = !((androidx.appcompat.view.menu.h) B.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f1681k == null) {
                this.f1681k = new c(this.f1483a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1681k.getParent();
            if (viewGroup != this.f1491i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1681k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1491i;
                actionMenuView.addView(this.f1681k, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            c cVar = this.f1681k;
            if (cVar != null) {
                Object parent = cVar.getParent();
                Object obj = this.f1491i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1681k);
                }
            }
        }
        ((ActionMenuView) this.f1491i).setOverflowReserved(this.f1684n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        ArrayList arrayList;
        int i11;
        int i12;
        int i13;
        boolean z10;
        int i14;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.f fVar = actionMenuPresenter.f1485c;
        View view = null;
        ?? r32 = 0;
        if (fVar != null) {
            arrayList = fVar.G();
            i11 = arrayList.size();
        } else {
            arrayList = null;
            i11 = 0;
        }
        int i15 = actionMenuPresenter.f1688r;
        int i16 = actionMenuPresenter.f1687q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1491i;
        boolean z11 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i11; i19++) {
            androidx.appcompat.view.menu.h hVar = (androidx.appcompat.view.menu.h) arrayList.get(i19);
            if (hVar.o()) {
                i17++;
            } else if (hVar.n()) {
                i18++;
            } else {
                z11 = true;
            }
            if (actionMenuPresenter.f1692v && hVar.isActionViewExpanded()) {
                i15 = 0;
            }
        }
        if (actionMenuPresenter.f1684n && (z11 || i18 + i17 > i15)) {
            i15--;
        }
        int i20 = i15 - i17;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1694x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1690t) {
            int i21 = actionMenuPresenter.f1693w;
            i13 = i16 / i21;
            i12 = i21 + ((i16 % i21) / i13);
        } else {
            i12 = 0;
            i13 = 0;
        }
        int i22 = 0;
        int i23 = 0;
        while (i22 < i11) {
            androidx.appcompat.view.menu.h hVar2 = (androidx.appcompat.view.menu.h) arrayList.get(i22);
            if (hVar2.o()) {
                View p11 = actionMenuPresenter.p(hVar2, view, viewGroup);
                if (actionMenuPresenter.f1690t) {
                    i13 -= ActionMenuView.g(p11, i12, i13, makeMeasureSpec, r32);
                } else {
                    p11.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = p11.getMeasuredWidth();
                i16 -= measuredWidth;
                if (i23 == 0) {
                    i23 = measuredWidth;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                hVar2.u(true);
                z10 = r32;
                i14 = i11;
            } else if (hVar2.n()) {
                int groupId2 = hVar2.getGroupId();
                boolean z12 = sparseBooleanArray.get(groupId2);
                boolean z13 = (i20 > 0 || z12) && i16 > 0 && (!actionMenuPresenter.f1690t || i13 > 0);
                boolean z14 = z13;
                i14 = i11;
                if (z13) {
                    View p12 = actionMenuPresenter.p(hVar2, null, viewGroup);
                    if (actionMenuPresenter.f1690t) {
                        int g11 = ActionMenuView.g(p12, i12, i13, makeMeasureSpec, 0);
                        i13 -= g11;
                        if (g11 == 0) {
                            z14 = false;
                        }
                    } else {
                        p12.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z15 = z14;
                    int measuredWidth2 = p12.getMeasuredWidth();
                    i16 -= measuredWidth2;
                    if (i23 == 0) {
                        i23 = measuredWidth2;
                    }
                    z13 = z15 & (!actionMenuPresenter.f1690t ? i16 + i23 <= 0 : i16 < 0);
                }
                if (z13 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z12) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i24 = 0; i24 < i22; i24++) {
                        androidx.appcompat.view.menu.h hVar3 = (androidx.appcompat.view.menu.h) arrayList.get(i24);
                        if (hVar3.getGroupId() == groupId2) {
                            if (hVar3.l()) {
                                i20++;
                            }
                            hVar3.u(false);
                        }
                    }
                }
                if (z13) {
                    i20--;
                }
                hVar2.u(z13);
                z10 = false;
            } else {
                z10 = r32;
                i14 = i11;
                hVar2.u(z10);
            }
            i22++;
            r32 = z10;
            i11 = i14;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void k(Context context, androidx.appcompat.view.menu.f fVar) {
        super.k(context, fVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a b11 = androidx.appcompat.view.a.b(context);
        if (!this.f1685o) {
            this.f1684n = b11.h();
        }
        if (!this.f1691u) {
            this.f1686p = b11.c();
        }
        if (!this.f1689s) {
            this.f1688r = b11.d();
        }
        int i11 = this.f1686p;
        if (this.f1684n) {
            if (this.f1681k == null) {
                c cVar = new c(this.f1483a);
                this.f1681k = cVar;
                if (this.f1683m) {
                    cVar.setImageDrawable(this.f1682l);
                    this.f1682l = null;
                    this.f1683m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1681k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i11 -= this.f1681k.getMeasuredWidth();
        } else {
            this.f1681k = null;
        }
        this.f1687q = i11;
        this.f1693w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b
    public void l(androidx.appcompat.view.menu.h hVar, m.a aVar) {
        aVar.initialize(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1491i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean n(ViewGroup viewGroup, int i11) {
        if (viewGroup.getChildAt(i11) == this.f1681k) {
            return false;
        }
        return super.n(viewGroup, i11);
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z10) {
        if (z10) {
            super.f(null);
            return;
        }
        androidx.appcompat.view.menu.f fVar = this.f1485c;
        if (fVar != null) {
            fVar.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public View p(androidx.appcompat.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.j()) {
            actionView = super.p(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.m q(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.m mVar = this.f1491i;
        androidx.appcompat.view.menu.m q11 = super.q(viewGroup);
        if (mVar != q11) {
            ((ActionMenuView) q11).setPresenter(this);
        }
        return q11;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean s(int i11, androidx.appcompat.view.menu.h hVar) {
        return hVar.l();
    }
}
