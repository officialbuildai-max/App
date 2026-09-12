package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public class a implements b1.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f1463a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1464b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1465c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f1466d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f1467e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f1468f;

    /* renamed from: g, reason: collision with root package name */
    private char f1469g;

    /* renamed from: i, reason: collision with root package name */
    private char f1471i;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f1473k;

    /* renamed from: l, reason: collision with root package name */
    private Context f1474l;

    /* renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1475m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f1476n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f1477o;

    /* renamed from: h, reason: collision with root package name */
    private int f1470h = 4096;

    /* renamed from: j, reason: collision with root package name */
    private int f1472j = 4096;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f1478p = null;

    /* renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f1479q = null;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1480r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1481s = false;

    /* renamed from: t, reason: collision with root package name */
    private int f1482t = 16;

    public a(Context context, int i11, int i12, int i13, int i14, CharSequence charSequence) {
        this.f1474l = context;
        this.f1463a = i12;
        this.f1464b = i11;
        this.f1465c = i14;
        this.f1466d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f1473k;
        if (drawable != null) {
            if (this.f1480r || this.f1481s) {
                Drawable r11 = a1.a.r(drawable);
                this.f1473k = r11;
                Drawable mutate = r11.mutate();
                this.f1473k = mutate;
                if (this.f1480r) {
                    a1.a.o(mutate, this.f1478p);
                }
                if (this.f1481s) {
                    a1.a.p(this.f1473k, this.f1479q);
                }
            }
        }
    }

    @Override // b1.b
    public ActionProvider a() {
        return null;
    }

    @Override // b1.b
    public b1.b b(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // b1.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // b1.b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b1.b setActionView(int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // b1.b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b1.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // b1.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // b1.b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b1.b setShowAsActionFlags(int i11) {
        setShowAsAction(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // b1.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // b1.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1472j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1471i;
    }

    @Override // b1.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1476n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1464b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1473k;
    }

    @Override // b1.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1478p;
    }

    @Override // b1.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1479q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1468f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1463a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // b1.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1470h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1469g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1465c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1466d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1467e;
        return charSequence != null ? charSequence : this.f1466d;
    }

    @Override // b1.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1477o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // b1.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1482t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1482t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1482t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1482t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11) {
        this.f1471i = Character.toLowerCase(c11);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        this.f1471i = Character.toLowerCase(c11);
        this.f1472j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f1482t = (z10 ? 1 : 0) | (this.f1482t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f1482t = (z10 ? 2 : 0) | (this.f1482t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public b1.b setContentDescription(CharSequence charSequence) {
        this.f1476n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f1482t = (z10 ? 16 : 0) | (this.f1482t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i11) {
        this.f1473k = androidx.core.content.b.getDrawable(this.f1474l, i11);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1473k = drawable;
        c();
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1478p = colorStateList;
        this.f1480r = true;
        c();
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1479q = mode;
        this.f1481s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1468f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c11) {
        this.f1469g = c11;
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c11, int i11) {
        this.f1469g = c11;
        this.f1470h = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1475m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12) {
        this.f1469g = c11;
        this.f1471i = Character.toLowerCase(c12);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f1469g = c11;
        this.f1470h = KeyEvent.normalizeMetaState(i11);
        this.f1471i = Character.toLowerCase(c12);
        this.f1472j = KeyEvent.normalizeMetaState(i12);
        return this;
    }

    @Override // b1.b, android.view.MenuItem
    public void setShowAsAction(int i11) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i11) {
        this.f1466d = this.f1474l.getResources().getString(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1466d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1467e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public b1.b setTooltipText(CharSequence charSequence) {
        this.f1477o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f1482t = (this.f1482t & 8) | (z10 ? 0 : 8);
        return this;
    }
}
