package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.a0;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CascadingMenuPopup extends j implements l, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int B = R$layout.abc_cascading_menu_item_layout;
    boolean A;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1412b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1413c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1414d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1415e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f1416f;

    /* renamed from: g, reason: collision with root package name */
    final Handler f1417g;

    /* renamed from: o, reason: collision with root package name */
    private View f1425o;

    /* renamed from: p, reason: collision with root package name */
    View f1426p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1428r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1429s;

    /* renamed from: t, reason: collision with root package name */
    private int f1430t;

    /* renamed from: u, reason: collision with root package name */
    private int f1431u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1433w;

    /* renamed from: x, reason: collision with root package name */
    private l.a f1434x;

    /* renamed from: y, reason: collision with root package name */
    ViewTreeObserver f1435y;

    /* renamed from: z, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1436z;

    /* renamed from: h, reason: collision with root package name */
    private final List f1418h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    final List f1419i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1420j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1421k = new b();

    /* renamed from: l, reason: collision with root package name */
    private final a0 f1422l = new a0() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.a0
        public void d(final f fVar, final MenuItem menuItem) {
            CascadingMenuPopup.this.f1417g.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.f1419i.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (fVar == ((c) CascadingMenuPopup.this.f1419i.get(i11)).f1441b) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 == -1) {
                return;
            }
            int i12 = i11 + 1;
            final c cVar = i12 < CascadingMenuPopup.this.f1419i.size() ? (c) CascadingMenuPopup.this.f1419i.get(i12) : null;
            CascadingMenuPopup.this.f1417g.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        CascadingMenuPopup.this.A = true;
                        cVar2.f1441b.e(false);
                        CascadingMenuPopup.this.A = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        fVar.O(menuItem, 4);
                    }
                }
            }, fVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.a0
        public void n(f fVar, MenuItem menuItem) {
            CascadingMenuPopup.this.f1417g.removeCallbacksAndMessages(fVar);
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private int f1423m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f1424n = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1432v = false;

    /* renamed from: q, reason: collision with root package name */
    private int f1427q = E();

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.a() || CascadingMenuPopup.this.f1419i.size() <= 0 || ((c) CascadingMenuPopup.this.f1419i.get(0)).f1440a.A()) {
                return;
            }
            View view = CascadingMenuPopup.this.f1426p;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.dismiss();
                return;
            }
            Iterator it = CascadingMenuPopup.this.f1419i.iterator();
            while (it.hasNext()) {
                ((c) it.next()).f1440a.show();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.f1435y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.f1435y = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.f1435y.removeGlobalOnLayoutListener(cascadingMenuPopup.f1420j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f1440a;

        /* renamed from: b, reason: collision with root package name */
        public final f f1441b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1442c;

        public c(MenuPopupWindow menuPopupWindow, f fVar, int i11) {
            this.f1440a = menuPopupWindow;
            this.f1441b = fVar;
            this.f1442c = i11;
        }

        public ListView a() {
            return this.f1440a.o();
        }
    }

    public CascadingMenuPopup(Context context, View view, int i11, int i12, boolean z10) {
        this.f1412b = context;
        this.f1425o = view;
        this.f1414d = i11;
        this.f1415e = i12;
        this.f1416f = z10;
        Resources resources = context.getResources();
        this.f1413c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1417g = new Handler();
    }

    private MenuPopupWindow A() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f1412b, null, this.f1414d, this.f1415e);
        menuPopupWindow.T(this.f1422l);
        menuPopupWindow.K(this);
        menuPopupWindow.J(this);
        menuPopupWindow.C(this.f1425o);
        menuPopupWindow.F(this.f1424n);
        menuPopupWindow.I(true);
        menuPopupWindow.H(2);
        return menuPopupWindow;
    }

    private int B(f fVar) {
        int size = this.f1419i.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (fVar == ((c) this.f1419i.get(i11)).f1441b) {
                return i11;
            }
        }
        return -1;
    }

    private MenuItem C(f fVar, f fVar2) {
        int size = fVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = fVar.getItem(i11);
            if (item.hasSubMenu() && fVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View D(c cVar, f fVar) {
        e eVar;
        int i11;
        int firstVisiblePosition;
        MenuItem C = C(cVar.f1441b, fVar);
        if (C == null) {
            return null;
        }
        ListView a11 = cVar.a();
        ListAdapter adapter = a11.getAdapter();
        int i12 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i11 = headerViewListAdapter.getHeadersCount();
            eVar = (e) headerViewListAdapter.getWrappedAdapter();
        } else {
            eVar = (e) adapter;
            i11 = 0;
        }
        int count = eVar.getCount();
        while (true) {
            if (i12 >= count) {
                i12 = -1;
                break;
            }
            if (C == eVar.getItem(i12)) {
                break;
            }
            i12++;
        }
        if (i12 != -1 && (firstVisiblePosition = (i12 + i11) - a11.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a11.getChildCount()) {
            return a11.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int E() {
        return this.f1425o.getLayoutDirection() == 1 ? 0 : 1;
    }

    private int F(int i11) {
        List list = this.f1419i;
        ListView a11 = ((c) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a11.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1426p.getWindowVisibleDisplayFrame(rect);
        return this.f1427q == 1 ? (iArr[0] + a11.getWidth()) + i11 > rect.right ? 0 : 1 : iArr[0] - i11 < 0 ? 1 : 0;
    }

    private void G(f fVar) {
        c cVar;
        View view;
        int i11;
        int i12;
        int i13;
        LayoutInflater from = LayoutInflater.from(this.f1412b);
        e eVar = new e(fVar, from, this.f1416f, B);
        if (!a() && this.f1432v) {
            eVar.d(true);
        } else if (a()) {
            eVar.d(j.y(fVar));
        }
        int p11 = j.p(eVar, null, this.f1412b, this.f1413c);
        MenuPopupWindow A = A();
        A.m(eVar);
        A.E(p11);
        A.F(this.f1424n);
        if (this.f1419i.size() > 0) {
            List list = this.f1419i;
            cVar = (c) list.get(list.size() - 1);
            view = D(cVar, fVar);
        } else {
            cVar = null;
            view = null;
        }
        if (view != null) {
            A.U(false);
            A.R(null);
            int F = F(p11);
            boolean z10 = F == 1;
            this.f1427q = F;
            if (Build.VERSION.SDK_INT >= 26) {
                A.C(view);
                i12 = 0;
                i11 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1425o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f1424n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1425o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i11 = iArr2[0] - iArr[0];
                i12 = iArr2[1] - iArr[1];
            }
            if ((this.f1424n & 5) == 5) {
                if (!z10) {
                    p11 = view.getWidth();
                    i13 = i11 - p11;
                }
                i13 = i11 + p11;
            } else {
                if (z10) {
                    p11 = view.getWidth();
                    i13 = i11 + p11;
                }
                i13 = i11 - p11;
            }
            A.e(i13);
            A.M(true);
            A.i(i12);
        } else {
            if (this.f1428r) {
                A.e(this.f1430t);
            }
            if (this.f1429s) {
                A.i(this.f1431u);
            }
            A.G(n());
        }
        this.f1419i.add(new c(A, fVar, this.f1427q));
        A.show();
        ListView o11 = A.o();
        o11.setOnKeyListener(this);
        if (cVar == null && this.f1433w && fVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) o11, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(fVar.z());
            o11.addHeaderView(frameLayout, null, false);
            A.show();
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a() {
        return this.f1419i.size() > 0 && ((c) this.f1419i.get(0)).f1440a.a();
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z10) {
        int B2 = B(fVar);
        if (B2 < 0) {
            return;
        }
        int i11 = B2 + 1;
        if (i11 < this.f1419i.size()) {
            ((c) this.f1419i.get(i11)).f1441b.e(false);
        }
        c cVar = (c) this.f1419i.remove(B2);
        cVar.f1441b.R(this);
        if (this.A) {
            cVar.f1440a.S(null);
            cVar.f1440a.D(0);
        }
        cVar.f1440a.dismiss();
        int size = this.f1419i.size();
        if (size > 0) {
            this.f1427q = ((c) this.f1419i.get(size - 1)).f1442c;
        } else {
            this.f1427q = E();
        }
        if (size != 0) {
            if (z10) {
                ((c) this.f1419i.get(0)).f1441b.e(false);
                return;
            }
            return;
        }
        dismiss();
        l.a aVar = this.f1434x;
        if (aVar != null) {
            aVar.b(fVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1435y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1435y.removeGlobalOnLayoutListener(this.f1420j);
            }
            this.f1435y = null;
        }
        this.f1426p.removeOnAttachStateChangeListener(this.f1421k);
        this.f1436z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1434x = aVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        int size = this.f1419i.size();
        if (size > 0) {
            c[] cVarArr = (c[]) this.f1419i.toArray(new c[size]);
            for (int i11 = size - 1; i11 >= 0; i11--) {
                c cVar = cVarArr[i11];
                if (cVar.f1440a.a()) {
                    cVar.f1440a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        for (c cVar : this.f1419i) {
            if (qVar == cVar.f1441b) {
                cVar.a().requestFocus();
                return true;
            }
        }
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        l(qVar);
        l.a aVar = this.f1434x;
        if (aVar != null) {
            aVar.c(qVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        Iterator it = this.f1419i.iterator();
        while (it.hasNext()) {
            j.z(((c) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void l(f fVar) {
        fVar.c(this, this.f1412b);
        if (a()) {
            G(fVar);
        } else {
            this.f1418h.add(fVar);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    protected boolean m() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView o() {
        if (this.f1419i.isEmpty()) {
            return null;
        }
        return ((c) this.f1419i.get(r0.size() - 1)).a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        c cVar;
        int size = this.f1419i.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                cVar = null;
                break;
            }
            cVar = (c) this.f1419i.get(i11);
            if (!cVar.f1440a.a()) {
                break;
            } else {
                i11++;
            }
        }
        if (cVar != null) {
            cVar.f1441b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i11 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void q(View view) {
        if (this.f1425o != view) {
            this.f1425o = view;
            this.f1424n = GravityCompat.getAbsoluteGravity(this.f1423m, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void s(boolean z10) {
        this.f1432v = z10;
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        if (a()) {
            return;
        }
        Iterator it = this.f1418h.iterator();
        while (it.hasNext()) {
            G((f) it.next());
        }
        this.f1418h.clear();
        View view = this.f1425o;
        this.f1426p = view;
        if (view != null) {
            boolean z10 = this.f1435y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1435y = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1420j);
            }
            this.f1426p.addOnAttachStateChangeListener(this.f1421k);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void t(int i11) {
        if (this.f1423m != i11) {
            this.f1423m = i11;
            this.f1424n = GravityCompat.getAbsoluteGravity(i11, this.f1425o.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void u(int i11) {
        this.f1428r = true;
        this.f1430t = i11;
    }

    @Override // androidx.appcompat.view.menu.j
    public void v(PopupWindow.OnDismissListener onDismissListener) {
        this.f1436z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.j
    public void w(boolean z10) {
        this.f1433w = z10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void x(int i11) {
        this.f1429s = true;
        this.f1431u = i11;
    }
}
