package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.y;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.tn.lib.view.FlowLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class[] f1355e;

    /* renamed from: f, reason: collision with root package name */
    static final Class[] f1356f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f1357a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f1358b;

    /* renamed from: c, reason: collision with root package name */
    Context f1359c;

    /* renamed from: d, reason: collision with root package name */
    private Object f1360d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class[] f1361c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f1362a;

        /* renamed from: b, reason: collision with root package name */
        private Method f1363b;

        public a(Object obj, String str) {
            this.f1362a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1363b = cls.getMethod(str, f1361c);
            } catch (Exception e11) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e11);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1363b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1363b.invoke(this.f1362a, menuItem)).booleanValue();
                }
                this.f1363b.invoke(this.f1362a, menuItem);
                return true;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ActionProvider A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f1364a;

        /* renamed from: b, reason: collision with root package name */
        private int f1365b;

        /* renamed from: c, reason: collision with root package name */
        private int f1366c;

        /* renamed from: d, reason: collision with root package name */
        private int f1367d;

        /* renamed from: e, reason: collision with root package name */
        private int f1368e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f1369f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f1370g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1371h;

        /* renamed from: i, reason: collision with root package name */
        private int f1372i;

        /* renamed from: j, reason: collision with root package name */
        private int f1373j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f1374k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f1375l;

        /* renamed from: m, reason: collision with root package name */
        private int f1376m;

        /* renamed from: n, reason: collision with root package name */
        private char f1377n;

        /* renamed from: o, reason: collision with root package name */
        private int f1378o;

        /* renamed from: p, reason: collision with root package name */
        private char f1379p;

        /* renamed from: q, reason: collision with root package name */
        private int f1380q;

        /* renamed from: r, reason: collision with root package name */
        private int f1381r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f1382s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f1383t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f1384u;

        /* renamed from: v, reason: collision with root package name */
        private int f1385v;

        /* renamed from: w, reason: collision with root package name */
        private int f1386w;

        /* renamed from: x, reason: collision with root package name */
        private String f1387x;

        /* renamed from: y, reason: collision with root package name */
        private String f1388y;

        /* renamed from: z, reason: collision with root package name */
        private String f1389z;

        public b(Menu menu) {
            this.f1364a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f1359c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e11) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e11);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z10 = false;
            menuItem.setChecked(this.f1382s).setVisible(this.f1383t).setEnabled(this.f1384u).setCheckable(this.f1381r >= 1).setTitleCondensed(this.f1375l).setIcon(this.f1376m);
            int i11 = this.f1385v;
            if (i11 >= 0) {
                menuItem.setShowAsAction(i11);
            }
            if (this.f1389z != null) {
                if (g.this.f1359c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f1389z));
            }
            if (this.f1381r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    ((androidx.appcompat.view.menu.h) menuItem).t(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).h(true);
                }
            }
            String str = this.f1387x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f1355e, g.this.f1357a));
                z10 = true;
            }
            int i12 = this.f1386w;
            if (i12 > 0) {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i12);
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.B);
            MenuItemCompat.setTooltipText(menuItem, this.C);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.f1377n, this.f1378o);
            MenuItemCompat.setNumericShortcut(menuItem, this.f1379p, this.f1380q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f1371h = true;
            i(this.f1364a.add(this.f1365b, this.f1372i, this.f1373j, this.f1374k));
        }

        public SubMenu b() {
            this.f1371h = true;
            SubMenu addSubMenu = this.f1364a.addSubMenu(this.f1365b, this.f1372i, this.f1373j, this.f1374k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f1371h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f1359c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f1365b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f1366c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f1367d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f1368e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1369f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f1370g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            j0 u11 = j0.u(g.this.f1359c, attributeSet, R$styleable.MenuItem);
            this.f1372i = u11.n(R$styleable.MenuItem_android_id, 0);
            this.f1373j = (u11.k(R$styleable.MenuItem_android_menuCategory, this.f1366c) & FlowLayout.SPACING_AUTO) | (u11.k(R$styleable.MenuItem_android_orderInCategory, this.f1367d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f1374k = u11.p(R$styleable.MenuItem_android_title);
            this.f1375l = u11.p(R$styleable.MenuItem_android_titleCondensed);
            this.f1376m = u11.n(R$styleable.MenuItem_android_icon, 0);
            this.f1377n = c(u11.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f1378o = u11.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f1379p = c(u11.o(R$styleable.MenuItem_android_numericShortcut));
            this.f1380q = u11.k(R$styleable.MenuItem_numericModifiers, 4096);
            if (u11.s(R$styleable.MenuItem_android_checkable)) {
                this.f1381r = u11.a(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1381r = this.f1368e;
            }
            this.f1382s = u11.a(R$styleable.MenuItem_android_checked, false);
            this.f1383t = u11.a(R$styleable.MenuItem_android_visible, this.f1369f);
            this.f1384u = u11.a(R$styleable.MenuItem_android_enabled, this.f1370g);
            this.f1385v = u11.k(R$styleable.MenuItem_showAsAction, -1);
            this.f1389z = u11.o(R$styleable.MenuItem_android_onClick);
            this.f1386w = u11.n(R$styleable.MenuItem_actionLayout, 0);
            this.f1387x = u11.o(R$styleable.MenuItem_actionViewClass);
            String o11 = u11.o(R$styleable.MenuItem_actionProviderClass);
            this.f1388y = o11;
            boolean z10 = o11 != null;
            if (z10 && this.f1386w == 0 && this.f1387x == null) {
                this.A = (ActionProvider) e(o11, g.f1356f, g.this.f1358b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u11.p(R$styleable.MenuItem_contentDescription);
            this.C = u11.p(R$styleable.MenuItem_tooltipText);
            if (u11.s(R$styleable.MenuItem_iconTintMode)) {
                this.E = y.e(u11.k(R$styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (u11.s(R$styleable.MenuItem_iconTint)) {
                this.D = u11.c(R$styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            u11.x();
            this.f1371h = false;
        }

        public void h() {
            this.f1365b = 0;
            this.f1366c = 0;
            this.f1367d = 0;
            this.f1368e = 0;
            this.f1369f = true;
            this.f1370g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f1355e = clsArr;
        f1356f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f1359c = context;
        Object[] objArr = {context};
        this.f1357a = objArr;
        this.f1358b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r7 = false;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals(com.transsion.web.api.WebConstants.FIELD_ITEM) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.hasSubMenu() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals(com.transsion.web.api.WebConstants.FIELD_ITEM) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r6 = false;
        r7 = false;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
            r12 = this;
            androidx.appcompat.view.g$b r0 = new androidx.appcompat.view.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r6
            r8 = r5
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r7 = r4
            r8 = r5
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            androidx.core.view.ActionProvider r15 = r0.A
            if (r15 == 0) goto L82
            boolean r15 = r15.hasSubMenu()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = r3
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = r3
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object b() {
        if (this.f1360d == null) {
            this.f1360d = a(this.f1359c);
        }
        return this.f1360d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i11, Menu menu) {
        if (!(menu instanceof b1.a)) {
            super.inflate(i11, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z10 = false;
        try {
            try {
                xmlResourceParser = this.f1359c.getResources().getLayout(i11);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof androidx.appcompat.view.menu.f) {
                    androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) menu;
                    if (fVar.H()) {
                        fVar.i0();
                        z10 = true;
                    }
                }
                c(xmlResourceParser, asAttributeSet, menu);
                if (z10) {
                    ((androidx.appcompat.view.menu.f) menu).h0();
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            } catch (XmlPullParserException e12) {
                throw new InflateException("Error inflating menu XML", e12);
            }
        } catch (Throwable th2) {
            if (z10) {
                ((androidx.appcompat.view.menu.f) menu).h0();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th2;
        }
    }
}
