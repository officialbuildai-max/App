package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.MenuPopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends j implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, l, View.OnKeyListener {

    /* renamed from: v, reason: collision with root package name */
    private static final int f1596v = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1597b;

    /* renamed from: c, reason: collision with root package name */
    private final f f1598c;

    /* renamed from: d, reason: collision with root package name */
    private final e f1599d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f1600e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1601f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1602g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1603h;

    /* renamed from: i, reason: collision with root package name */
    final MenuPopupWindow f1604i;

    /* renamed from: l, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1607l;

    /* renamed from: m, reason: collision with root package name */
    private View f1608m;

    /* renamed from: n, reason: collision with root package name */
    View f1609n;

    /* renamed from: o, reason: collision with root package name */
    private l.a f1610o;

    /* renamed from: p, reason: collision with root package name */
    ViewTreeObserver f1611p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1612q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1613r;

    /* renamed from: s, reason: collision with root package name */
    private int f1614s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f1616u;

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1605j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1606k = new b();

    /* renamed from: t, reason: collision with root package name */
    private int f1615t = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!p.this.a() || p.this.f1604i.A()) {
                return;
            }
            View view = p.this.f1609n;
            if (view == null || !view.isShown()) {
                p.this.dismiss();
            } else {
                p.this.f1604i.show();
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
            ViewTreeObserver viewTreeObserver = p.this.f1611p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    p.this.f1611p = view.getViewTreeObserver();
                }
                p pVar = p.this;
                pVar.f1611p.removeGlobalOnLayoutListener(pVar.f1605j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public p(Context context, f fVar, View view, int i11, int i12, boolean z10) {
        this.f1597b = context;
        this.f1598c = fVar;
        this.f1600e = z10;
        this.f1599d = new e(fVar, LayoutInflater.from(context), z10, f1596v);
        this.f1602g = i11;
        this.f1603h = i12;
        Resources resources = context.getResources();
        this.f1601f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1608m = view;
        this.f1604i = new MenuPopupWindow(context, null, i11, i12);
        fVar.c(this, context);
    }

    private boolean A() {
        View view;
        if (a()) {
            return true;
        }
        if (this.f1612q || (view = this.f1608m) == null) {
            return false;
        }
        this.f1609n = view;
        this.f1604i.J(this);
        this.f1604i.K(this);
        this.f1604i.I(true);
        View view2 = this.f1609n;
        boolean z10 = this.f1611p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1611p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1605j);
        }
        view2.addOnAttachStateChangeListener(this.f1606k);
        this.f1604i.C(view2);
        this.f1604i.F(this.f1615t);
        if (!this.f1613r) {
            this.f1614s = j.p(this.f1599d, null, this.f1597b, this.f1601f);
            this.f1613r = true;
        }
        this.f1604i.E(this.f1614s);
        this.f1604i.H(2);
        this.f1604i.G(n());
        this.f1604i.show();
        ListView o11 = this.f1604i.o();
        o11.setOnKeyListener(this);
        if (this.f1616u && this.f1598c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1597b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) o11, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1598c.z());
            }
            frameLayout.setEnabled(false);
            o11.addHeaderView(frameLayout, null, false);
        }
        this.f1604i.m(this.f1599d);
        this.f1604i.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a() {
        return !this.f1612q && this.f1604i.a();
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z10) {
        if (fVar != this.f1598c) {
            return;
        }
        dismiss();
        l.a aVar = this.f1610o;
        if (aVar != null) {
            aVar.b(fVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1610o = aVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        if (a()) {
            this.f1604i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        if (qVar.hasVisibleItems()) {
            k kVar = new k(this.f1597b, qVar, this.f1609n, this.f1600e, this.f1602g, this.f1603h);
            kVar.j(this.f1610o);
            kVar.g(j.y(qVar));
            kVar.i(this.f1607l);
            this.f1607l = null;
            this.f1598c.e(false);
            int c11 = this.f1604i.c();
            int l11 = this.f1604i.l();
            if ((Gravity.getAbsoluteGravity(this.f1615t, this.f1608m.getLayoutDirection()) & 7) == 5) {
                c11 += this.f1608m.getWidth();
            }
            if (kVar.n(c11, l11)) {
                l.a aVar = this.f1610o;
                if (aVar == null) {
                    return true;
                }
                aVar.c(qVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        this.f1613r = false;
        e eVar = this.f1599d;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void l(f fVar) {
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView o() {
        return this.f1604i.o();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1612q = true;
        this.f1598c.close();
        ViewTreeObserver viewTreeObserver = this.f1611p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1611p = this.f1609n.getViewTreeObserver();
            }
            this.f1611p.removeGlobalOnLayoutListener(this.f1605j);
            this.f1611p = null;
        }
        this.f1609n.removeOnAttachStateChangeListener(this.f1606k);
        PopupWindow.OnDismissListener onDismissListener = this.f1607l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        this.f1608m = view;
    }

    @Override // androidx.appcompat.view.menu.j
    public void s(boolean z10) {
        this.f1599d.d(z10);
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        if (!A()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void t(int i11) {
        this.f1615t = i11;
    }

    @Override // androidx.appcompat.view.menu.j
    public void u(int i11) {
        this.f1604i.e(i11);
    }

    @Override // androidx.appcompat.view.menu.j
    public void v(PopupWindow.OnDismissListener onDismissListener) {
        this.f1607l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.j
    public void w(boolean z10) {
        this.f1616u = z10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void x(int i11) {
        this.f1604i.i(i11);
    }
}
