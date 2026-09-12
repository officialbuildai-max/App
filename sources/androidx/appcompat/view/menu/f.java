package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public class f implements b1.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f1514a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f1515b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1516c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1517d;

    /* renamed from: e, reason: collision with root package name */
    private a f1518e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f1526m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f1527n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f1528o;

    /* renamed from: p, reason: collision with root package name */
    View f1529p;

    /* renamed from: x, reason: collision with root package name */
    private h f1537x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f1539z;

    /* renamed from: l, reason: collision with root package name */
    private int f1525l = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1530q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1531r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1532s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f1533t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f1534u = false;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList f1535v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList f1536w = new CopyOnWriteArrayList();

    /* renamed from: y, reason: collision with root package name */
    private boolean f1538y = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f1519f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f1520g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private boolean f1521h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f1522i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f1523j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private boolean f1524k = true;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean invokeItem(h hVar);
    }

    public f(Context context) {
        this.f1514a = context;
        this.f1515b = context.getResources();
        g0(true);
    }

    private static int D(int i11) {
        int i12 = ((-65536) & i11) >> 16;
        if (i12 >= 0) {
            int[] iArr = A;
            if (i12 < iArr.length) {
                return (i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (iArr[i12] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void Q(int i11, boolean z10) {
        if (i11 < 0 || i11 >= this.f1519f.size()) {
            return;
        }
        this.f1519f.remove(i11);
        if (z10) {
            N(true);
        }
    }

    private void b0(int i11, CharSequence charSequence, int i12, Drawable drawable, View view) {
        Resources E = E();
        if (view != null) {
            this.f1529p = view;
            this.f1527n = null;
            this.f1528o = null;
        } else {
            if (i11 > 0) {
                this.f1527n = E.getText(i11);
            } else if (charSequence != null) {
                this.f1527n = charSequence;
            }
            if (i12 > 0) {
                this.f1528o = androidx.core.content.b.getDrawable(w(), i12);
            } else if (drawable != null) {
                this.f1528o = drawable;
            }
            this.f1529p = null;
        }
        N(false);
    }

    private h g(int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        return new h(this, i11, i12, i13, i14, charSequence, i15);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(android.view.ViewConfiguration.get(r2.f1514a), r2.f1514a) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f1515b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f1514a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f1514a
            boolean r3 = androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f1517d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.f.g0(boolean):void");
    }

    private void i(boolean z10) {
        if (this.f1536w.isEmpty()) {
            return;
        }
        i0();
        Iterator it = this.f1536w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f1536w.remove(weakReference);
            } else {
                lVar.h(z10);
            }
        }
        h0();
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f1536w.isEmpty()) {
            return;
        }
        Iterator it = this.f1536w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f1536w.remove(weakReference);
            } else {
                int id2 = lVar.getId();
                if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                    lVar.e(parcelable);
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable g11;
        if (this.f1536w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator it = this.f1536w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f1536w.remove(weakReference);
            } else {
                int id2 = lVar.getId();
                if (id2 > 0 && (g11 = lVar.g()) != null) {
                    sparseArray.put(id2, g11);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(q qVar, l lVar) {
        if (this.f1536w.isEmpty()) {
            return false;
        }
        boolean f11 = lVar != null ? lVar.f(qVar) : false;
        Iterator it = this.f1536w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null) {
                this.f1536w.remove(weakReference);
            } else if (!f11) {
                f11 = lVar2.f(qVar);
            }
        }
        return f11;
    }

    private static int p(ArrayList arrayList, int i11) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((h) arrayList.get(size)).f() <= i11) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f1529p;
    }

    public ArrayList B() {
        t();
        return this.f1523j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.f1533t;
    }

    Resources E() {
        return this.f1515b;
    }

    public f F() {
        return this;
    }

    public ArrayList G() {
        if (!this.f1521h) {
            return this.f1520g;
        }
        this.f1520g.clear();
        int size = this.f1519f.size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = (h) this.f1519f.get(i11);
            if (hVar.isVisible()) {
                this.f1520g.add(hVar);
            }
        }
        this.f1521h = false;
        this.f1524k = true;
        return this.f1520g;
    }

    public boolean H() {
        return !this.f1530q;
    }

    public boolean I() {
        return this.f1538y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J() {
        return this.f1516c;
    }

    public boolean K() {
        return this.f1517d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(h hVar) {
        this.f1524k = true;
        N(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(h hVar) {
        this.f1521h = true;
        N(true);
    }

    public void N(boolean z10) {
        if (this.f1530q) {
            this.f1531r = true;
            if (z10) {
                this.f1532s = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f1521h = true;
            this.f1524k = true;
        }
        i(z10);
    }

    public boolean O(MenuItem menuItem, int i11) {
        return P(menuItem, null, i11);
    }

    public boolean P(MenuItem menuItem, l lVar, int i11) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean k11 = hVar.k();
        ActionProvider a11 = hVar.a();
        boolean z10 = a11 != null && a11.hasSubMenu();
        if (hVar.j()) {
            k11 |= hVar.expandActionView();
            if (k11) {
                e(true);
            }
        } else if (hVar.hasSubMenu() || z10) {
            if ((i11 & 4) == 0) {
                e(false);
            }
            if (!hVar.hasSubMenu()) {
                hVar.x(new q(w(), this, hVar));
            }
            q qVar = (q) hVar.getSubMenu();
            if (z10) {
                a11.onPrepareSubMenu(qVar);
            }
            k11 |= l(qVar, lVar);
            if (!k11) {
                e(true);
            }
        } else if ((i11 & 1) == 0) {
            e(true);
        }
        return k11;
    }

    public void R(l lVar) {
        Iterator it = this.f1536w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.f1536w.remove(weakReference);
            }
        }
    }

    public void S(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = getItem(i11);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((q) item.getSubMenu()).S(bundle);
            }
        }
        int i12 = bundle.getInt("android:menu:expandedactionview");
        if (i12 <= 0 || (findItem = findItem(i12)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void T(Bundle bundle) {
        j(bundle);
    }

    public void U(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = getItem(i11);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((q) item.getSubMenu()).U(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void V(Bundle bundle) {
        k(bundle);
    }

    public void W(a aVar) {
        this.f1518e = aVar;
    }

    public f X(int i11) {
        this.f1525l = i11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1519f.size();
        i0();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = (h) this.f1519f.get(i11);
            if (hVar.getGroupId() == groupId && hVar.m() && hVar.isCheckable()) {
                hVar.s(hVar == menuItem);
            }
        }
        h0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f Z(int i11) {
        b0(0, null, i11, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuItem a(int i11, int i12, int i13, CharSequence charSequence) {
        int D = D(i13);
        h g11 = g(i11, i12, i13, D, charSequence, this.f1525l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1526m;
        if (contextMenuInfo != null) {
            g11.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f1519f;
        arrayList.add(p(arrayList, D), g11);
        N(true);
        return g11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f a0(Drawable drawable) {
        b0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i11) {
        return a(0, 0, 0, this.f1515b.getString(i11));
    }

    @Override // android.view.Menu
    public MenuItem add(int i11, int i12, int i13, int i14) {
        return a(i11, i12, i13, this.f1515b.getString(i14));
    }

    @Override // android.view.Menu
    public MenuItem add(int i11, int i12, int i13, CharSequence charSequence) {
        return a(i11, i12, i13, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i11, int i12, int i13, ComponentName componentName, Intent[] intentArr, Intent intent, int i14, MenuItem[] menuItemArr) {
        int i15;
        PackageManager packageManager = this.f1514a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i14 & 1) == 0) {
            removeGroup(i11);
        }
        for (int i16 = 0; i16 < size; i16++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i16);
            int i17 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i17 < 0 ? intent : intentArr[i17]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i11, i12, i13, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i15 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i15] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i11) {
        return addSubMenu(0, 0, 0, this.f1515b.getString(i11));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i11, int i12, int i13, int i14) {
        return addSubMenu(i11, i12, i13, this.f1515b.getString(i14));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        h hVar = (h) a(i11, i12, i13, charSequence);
        q qVar = new q(this.f1514a, this, hVar);
        hVar.x(qVar);
        return qVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(l lVar) {
        c(lVar, this.f1514a);
    }

    public void c(l lVar, Context context) {
        this.f1536w.add(new WeakReference(lVar));
        lVar.k(context, this);
        this.f1524k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f c0(int i11) {
        b0(i11, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        h hVar = this.f1537x;
        if (hVar != null) {
            f(hVar);
        }
        this.f1519f.clear();
        N(true);
    }

    public void clearHeader() {
        this.f1528o = null;
        this.f1527n = null;
        this.f1529p = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f1518e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f d0(CharSequence charSequence) {
        b0(0, charSequence, 0, null, null);
        return this;
    }

    public final void e(boolean z10) {
        if (this.f1534u) {
            return;
        }
        this.f1534u = true;
        Iterator it = this.f1536w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f1536w.remove(weakReference);
            } else {
                lVar.b(this, z10);
            }
        }
        this.f1534u = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f e0(View view) {
        b0(0, null, 0, null, view);
        return this;
    }

    public boolean f(h hVar) {
        boolean z10 = false;
        if (!this.f1536w.isEmpty() && this.f1537x == hVar) {
            i0();
            Iterator it = this.f1536w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.f1536w.remove(weakReference);
                } else {
                    z10 = lVar.j(this, hVar);
                    if (z10) {
                        break;
                    }
                }
            }
            h0();
            if (z10) {
                this.f1537x = null;
            }
        }
        return z10;
    }

    public void f0(boolean z10) {
        this.f1539z = z10;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i11) {
        MenuItem findItem;
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = (h) this.f1519f.get(i12);
            if (hVar.getItemId() == i11) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (findItem = hVar.getSubMenu().findItem(i11)) != null) {
                return findItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i11) {
        return (MenuItem) this.f1519f.get(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(f fVar, MenuItem menuItem) {
        a aVar = this.f1518e;
        return aVar != null && aVar.a(fVar, menuItem);
    }

    public void h0() {
        this.f1530q = false;
        if (this.f1531r) {
            this.f1531r = false;
            N(this.f1532s);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1539z) {
            return true;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((h) this.f1519f.get(i11)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i0() {
        if (this.f1530q) {
            return;
        }
        this.f1530q = true;
        this.f1531r = false;
        this.f1532s = false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i11, KeyEvent keyEvent) {
        return r(i11, keyEvent) != null;
    }

    public boolean m(h hVar) {
        boolean z10 = false;
        if (this.f1536w.isEmpty()) {
            return false;
        }
        i0();
        Iterator it = this.f1536w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f1536w.remove(weakReference);
            } else {
                z10 = lVar.c(this, hVar);
                if (z10) {
                    break;
                }
            }
        }
        h0();
        if (z10) {
            this.f1537x = hVar;
        }
        return z10;
    }

    public int n(int i11) {
        return o(i11, 0);
    }

    public int o(int i11, int i12) {
        int size = size();
        if (i12 < 0) {
            i12 = 0;
        }
        while (i12 < size) {
            if (((h) this.f1519f.get(i12)).getGroupId() == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i11, int i12) {
        return O(findItem(i11), i12);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i11, KeyEvent keyEvent, int i12) {
        h r11 = r(i11, keyEvent);
        boolean O = r11 != null ? O(r11, i12) : false;
        if ((i12 & 2) != 0) {
            e(true);
        }
        return O;
    }

    public int q(int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            if (((h) this.f1519f.get(i12)).getItemId() == i11) {
                return i12;
            }
        }
        return -1;
    }

    h r(int i11, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1535v;
        arrayList.clear();
        s(arrayList, i11, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (h) arrayList.get(0);
        }
        boolean J = J();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = (h) arrayList.get(i12);
            char alphabeticShortcut = J ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (J && alphabeticShortcut == '\b' && i11 == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i11) {
        int n11 = n(i11);
        if (n11 >= 0) {
            int size = this.f1519f.size() - n11;
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (i12 >= size || ((h) this.f1519f.get(n11)).getGroupId() != i11) {
                    break;
                }
                Q(n11, false);
                i12 = i13;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i11) {
        Q(q(i11), true);
    }

    void s(List list, int i11, KeyEvent keyEvent) {
        boolean J = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i11 == 67) {
            int size = this.f1519f.size();
            for (int i12 = 0; i12 < size; i12++) {
                h hVar = (h) this.f1519f.get(i12);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).s(list, i11, keyEvent);
                }
                char alphabeticShortcut = J ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((modifiers & 69647) == ((J ? hVar.getAlphabeticModifiers() : hVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (J && alphabeticShortcut == '\b' && i11 == 67)) && hVar.isEnabled()) {
                        list.add(hVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i11, boolean z10, boolean z11) {
        int size = this.f1519f.size();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = (h) this.f1519f.get(i12);
            if (hVar.getGroupId() == i11) {
                hVar.t(z11);
                hVar.setCheckable(z10);
            }
        }
    }

    @Override // b1.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f1538y = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i11, boolean z10) {
        int size = this.f1519f.size();
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = (h) this.f1519f.get(i12);
            if (hVar.getGroupId() == i11) {
                hVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i11, boolean z10) {
        int size = this.f1519f.size();
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            h hVar = (h) this.f1519f.get(i12);
            if (hVar.getGroupId() == i11 && hVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f1516c = z10;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1519f.size();
    }

    public void t() {
        ArrayList G = G();
        if (this.f1524k) {
            Iterator it = this.f1536w.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.f1536w.remove(weakReference);
                } else {
                    z10 |= lVar.i();
                }
            }
            if (z10) {
                this.f1522i.clear();
                this.f1523j.clear();
                int size = G.size();
                for (int i11 = 0; i11 < size; i11++) {
                    h hVar = (h) G.get(i11);
                    if (hVar.l()) {
                        this.f1522i.add(hVar);
                    } else {
                        this.f1523j.add(hVar);
                    }
                }
            } else {
                this.f1522i.clear();
                this.f1523j.clear();
                this.f1523j.addAll(G());
            }
            this.f1524k = false;
        }
    }

    public ArrayList u() {
        t();
        return this.f1522i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f1514a;
    }

    public h x() {
        return this.f1537x;
    }

    public Drawable y() {
        return this.f1528o;
    }

    public CharSequence z() {
        return this.f1527n;
    }
}
