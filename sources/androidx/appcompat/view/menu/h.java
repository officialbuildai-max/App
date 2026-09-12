package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.m;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public final class h implements b1.b {
    private View A;
    private ActionProvider B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a, reason: collision with root package name */
    private final int f1544a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1545b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1546c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1547d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f1548e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f1549f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f1550g;

    /* renamed from: h, reason: collision with root package name */
    private char f1551h;

    /* renamed from: j, reason: collision with root package name */
    private char f1553j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f1555l;

    /* renamed from: n, reason: collision with root package name */
    f f1557n;

    /* renamed from: o, reason: collision with root package name */
    private q f1558o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f1559p;

    /* renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1560q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f1561r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f1562s;

    /* renamed from: z, reason: collision with root package name */
    private int f1569z;

    /* renamed from: i, reason: collision with root package name */
    private int f1552i = 4096;

    /* renamed from: k, reason: collision with root package name */
    private int f1554k = 4096;

    /* renamed from: m, reason: collision with root package name */
    private int f1556m = 0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f1563t = null;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f1564u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1565v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1566w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f1567x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f1568y = 16;
    private boolean D = false;

    /* loaded from: classes.dex */
    class a implements ActionProvider.VisibilityListener {
        a() {
        }

        @Override // androidx.core.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z10) {
            h hVar = h.this;
            hVar.f1557n.M(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        this.f1557n = fVar;
        this.f1544a = i12;
        this.f1545b = i11;
        this.f1546c = i13;
        this.f1547d = i14;
        this.f1548e = charSequence;
        this.f1569z = i15;
    }

    private static void d(StringBuilder sb2, int i11, int i12, String str) {
        if ((i11 & i12) == i12) {
            sb2.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f1567x && (this.f1565v || this.f1566w)) {
            drawable = a1.a.r(drawable).mutate();
            if (this.f1565v) {
                a1.a.o(drawable, this.f1563t);
            }
            if (this.f1566w) {
                a1.a.p(drawable, this.f1564u);
            }
            this.f1567x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f1557n.K() && g() != 0;
    }

    public boolean B() {
        return (this.f1569z & 4) == 4;
    }

    @Override // b1.b
    public ActionProvider a() {
        return this.B;
    }

    @Override // b1.b
    public b1.b b(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.B;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.A = null;
        this.B = actionProvider;
        this.f1557n.N(true);
        ActionProvider actionProvider3 = this.B;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new a());
        }
        return this;
    }

    public void c() {
        this.f1557n.L(this);
    }

    @Override // b1.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1569z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1557n.f(this);
        }
        return false;
    }

    @Override // b1.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1557n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f1547d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.f1557n.J() ? this.f1553j : this.f1551h;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // b1.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.B;
        if (actionProvider == null) {
            return null;
        }
        View onCreateActionView = actionProvider.onCreateActionView(this);
        this.A = onCreateActionView;
        return onCreateActionView;
    }

    @Override // b1.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1554k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1553j;
    }

    @Override // b1.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1561r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1545b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1555l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f1556m == 0) {
            return null;
        }
        Drawable b11 = g.a.b(this.f1557n.w(), this.f1556m);
        this.f1556m = 0;
        this.f1555l = b11;
        return e(b11);
    }

    @Override // b1.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1563t;
    }

    @Override // b1.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1564u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1550g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1544a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // b1.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1552i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1551h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1546c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1558o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1548e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1549f;
        return charSequence != null ? charSequence : this.f1548e;
    }

    @Override // b1.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1562s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        char g11 = g();
        if (g11 == 0) {
            return "";
        }
        Resources resources = this.f1557n.w().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f1557n.w()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i11 = this.f1557n.J() ? this.f1554k : this.f1552i;
        d(sb2, i11, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb2, i11, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb2, i11, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb2, i11, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb2, i11, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb2, i11, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (g11 == '\b') {
            sb2.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (g11 == '\n') {
            sb2.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (g11 != ' ') {
            sb2.append(g11);
        } else {
            sb2.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1558o != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(m.a aVar) {
        return (aVar == null || !aVar.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    @Override // b1.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1568y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1568y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1568y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.B;
        return (actionProvider == null || !actionProvider.overridesItemVisibility()) ? (this.f1568y & 8) == 0 : (this.f1568y & 8) == 0 && this.B.isVisible();
    }

    public boolean j() {
        ActionProvider actionProvider;
        if ((this.f1569z & 8) == 0) {
            return false;
        }
        if (this.A == null && (actionProvider = this.B) != null) {
            this.A = actionProvider.onCreateActionView(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1560q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        f fVar = this.f1557n;
        if (fVar.h(fVar, this)) {
            return true;
        }
        Runnable runnable = this.f1559p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1550g != null) {
            try {
                this.f1557n.w().startActivity(this.f1550g);
                return true;
            } catch (ActivityNotFoundException e11) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e11);
            }
        }
        ActionProvider actionProvider = this.B;
        return actionProvider != null && actionProvider.onPerformDefaultAction();
    }

    public boolean l() {
        return (this.f1568y & 32) == 32;
    }

    public boolean m() {
        return (this.f1568y & 4) != 0;
    }

    public boolean n() {
        return (this.f1569z & 1) == 1;
    }

    public boolean o() {
        return (this.f1569z & 2) == 2;
    }

    @Override // b1.b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b1.b setActionView(int i11) {
        Context w11 = this.f1557n.w();
        setActionView(LayoutInflater.from(w11).inflate(i11, (ViewGroup) new LinearLayout(w11), false));
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b1.b setActionView(View view) {
        int i11;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i11 = this.f1544a) > 0) {
            view.setId(i11);
        }
        this.f1557n.L(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f1557n.N(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        int i11 = this.f1568y;
        int i12 = (z10 ? 2 : 0) | (i11 & (-3));
        this.f1568y = i12;
        if (i11 != i12) {
            this.f1557n.N(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11) {
        if (this.f1553j == c11) {
            return this;
        }
        this.f1553j = Character.toLowerCase(c11);
        this.f1557n.N(false);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        if (this.f1553j == c11 && this.f1554k == i11) {
            return this;
        }
        this.f1553j = Character.toLowerCase(c11);
        this.f1554k = KeyEvent.normalizeMetaState(i11);
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i11 = this.f1568y;
        int i12 = (z10 ? 1 : 0) | (i11 & (-2));
        this.f1568y = i12;
        if (i11 != i12) {
            this.f1557n.N(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f1568y & 4) != 0) {
            this.f1557n.Y(this);
        } else {
            s(z10);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public b1.b setContentDescription(CharSequence charSequence) {
        this.f1561r = charSequence;
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f1568y |= 16;
        } else {
            this.f1568y &= -17;
        }
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i11) {
        this.f1555l = null;
        this.f1556m = i11;
        this.f1567x = true;
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1556m = 0;
        this.f1555l = drawable;
        this.f1567x = true;
        this.f1557n.N(false);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1563t = colorStateList;
        this.f1565v = true;
        this.f1567x = true;
        this.f1557n.N(false);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1564u = mode;
        this.f1566w = true;
        this.f1567x = true;
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1550g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c11) {
        if (this.f1551h == c11) {
            return this;
        }
        this.f1551h = c11;
        this.f1557n.N(false);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c11, int i11) {
        if (this.f1551h == c11 && this.f1552i == i11) {
            return this;
        }
        this.f1551h = c11;
        this.f1552i = KeyEvent.normalizeMetaState(i11);
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1560q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12) {
        this.f1551h = c11;
        this.f1553j = Character.toLowerCase(c12);
        this.f1557n.N(false);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f1551h = c11;
        this.f1552i = KeyEvent.normalizeMetaState(i11);
        this.f1553j = Character.toLowerCase(c12);
        this.f1554k = KeyEvent.normalizeMetaState(i12);
        this.f1557n.N(false);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public void setShowAsAction(int i11) {
        int i12 = i11 & 3;
        if (i12 != 0 && i12 != 1 && i12 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1569z = i11;
        this.f1557n.L(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i11) {
        return setTitle(this.f1557n.w().getString(i11));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1548e = charSequence;
        this.f1557n.N(false);
        q qVar = this.f1558o;
        if (qVar != null) {
            qVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1549f = charSequence;
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public b1.b setTooltipText(CharSequence charSequence) {
        this.f1562s = charSequence;
        this.f1557n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f1557n.M(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.f1568y = (z10 ? 4 : 0) | (this.f1568y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f1548e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        if (z10) {
            this.f1568y |= 32;
        } else {
            this.f1568y &= -33;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // b1.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public b1.b setShowAsActionFlags(int i11) {
        setShowAsAction(i11);
        return this;
    }

    public void x(q qVar) {
        this.f1558o = qVar;
        qVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z10) {
        int i11 = this.f1568y;
        int i12 = (z10 ? 0 : 8) | (i11 & (-9));
        this.f1568y = i12;
        return i11 != i12;
    }

    public boolean z() {
        return this.f1557n.C();
    }
}
