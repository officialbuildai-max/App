package h0;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.platform.actionmodecallback.MenuItemOption;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y.i;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f64167a;

    /* renamed from: b, reason: collision with root package name */
    private i f64168b;

    /* renamed from: c, reason: collision with root package name */
    private Function0 f64169c;

    /* renamed from: d, reason: collision with root package name */
    private Function0 f64170d;

    /* renamed from: e, reason: collision with root package name */
    private Function0 f64171e;

    /* renamed from: f, reason: collision with root package name */
    private Function0 f64172f;

    public b() {
        this(null, null, null, null, null, null, 63, null);
    }

    public b(Function0 function0, i iVar, Function0 function02, Function0 function03, Function0 function04, Function0 function05) {
        this.f64167a = function0;
        this.f64168b = iVar;
        this.f64169c = function02;
        this.f64170d = function03;
        this.f64171e = function04;
        this.f64172f = function05;
    }

    public /* synthetic */ b(Function0 function0, i iVar, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : function0, (i11 & 2) != 0 ? i.f78598e.a() : iVar, (i11 & 4) != 0 ? null : function02, (i11 & 8) != 0 ? null : function03, (i11 & 16) != 0 ? null : function04, (i11 & 32) != 0 ? null : function05);
    }

    private final void b(Menu menu, MenuItemOption menuItemOption, Function0 function0) {
        if (function0 != null && menu.findItem(menuItemOption.getId()) == null) {
            a(menu, menuItemOption);
        } else {
            if (function0 != null || menu.findItem(menuItemOption.getId()) == null) {
                return;
            }
            menu.removeItem(menuItemOption.getId());
        }
    }

    public final void a(Menu menu, MenuItemOption menuItemOption) {
        menu.add(0, menuItemOption.getId(), menuItemOption.getOrder(), menuItemOption.getTitleResource()).setShowAsAction(1);
    }

    public final i c() {
        return this.f64168b;
    }

    public final boolean d(ActionMode actionMode, MenuItem menuItem) {
        Intrinsics.e(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            Function0 function0 = this.f64169c;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (itemId == MenuItemOption.Paste.getId()) {
            Function0 function02 = this.f64170d;
            if (function02 != null) {
                function02.invoke();
            }
        } else if (itemId == MenuItemOption.Cut.getId()) {
            Function0 function03 = this.f64171e;
            if (function03 != null) {
                function03.invoke();
            }
        } else {
            if (itemId != MenuItemOption.SelectAll.getId()) {
                return false;
            }
            Function0 function04 = this.f64172f;
            if (function04 != null) {
                function04.invoke();
            }
        }
        if (actionMode == null) {
            return true;
        }
        actionMode.finish();
        return true;
    }

    public final boolean e(ActionMode actionMode, Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null menu");
        }
        if (actionMode == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null mode");
        }
        if (this.f64169c != null) {
            a(menu, MenuItemOption.Copy);
        }
        if (this.f64170d != null) {
            a(menu, MenuItemOption.Paste);
        }
        if (this.f64171e != null) {
            a(menu, MenuItemOption.Cut);
        }
        if (this.f64172f == null) {
            return true;
        }
        a(menu, MenuItemOption.SelectAll);
        return true;
    }

    public final void f() {
        Function0 function0 = this.f64167a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean g(ActionMode actionMode, Menu menu) {
        if (actionMode == null || menu == null) {
            return false;
        }
        m(menu);
        return true;
    }

    public final void h(Function0 function0) {
        this.f64169c = function0;
    }

    public final void i(Function0 function0) {
        this.f64171e = function0;
    }

    public final void j(Function0 function0) {
        this.f64170d = function0;
    }

    public final void k(Function0 function0) {
        this.f64172f = function0;
    }

    public final void l(i iVar) {
        this.f64168b = iVar;
    }

    public final void m(Menu menu) {
        b(menu, MenuItemOption.Copy, this.f64169c);
        b(menu, MenuItemOption.Paste, this.f64170d);
        b(menu, MenuItemOption.Cut, this.f64171e);
        b(menu, MenuItemOption.SelectAll, this.f64172f);
    }
}
