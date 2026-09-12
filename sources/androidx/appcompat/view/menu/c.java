package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.x0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    final Context f1493a;

    /* renamed from: b, reason: collision with root package name */
    private x0 f1494b;

    /* renamed from: c, reason: collision with root package name */
    private x0 f1495c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f1493a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b1.b)) {
            return menuItem;
        }
        b1.b bVar = (b1.b) menuItem;
        if (this.f1494b == null) {
            this.f1494b = new x0();
        }
        MenuItem menuItem2 = (MenuItem) this.f1494b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        i iVar = new i(this.f1493a, bVar);
        this.f1494b.put(bVar, iVar);
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        x0 x0Var = this.f1494b;
        if (x0Var != null) {
            x0Var.clear();
        }
        x0 x0Var2 = this.f1495c;
        if (x0Var2 != null) {
            x0Var2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i11) {
        if (this.f1494b == null) {
            return;
        }
        int i12 = 0;
        while (i12 < this.f1494b.size()) {
            if (((b1.b) this.f1494b.keyAt(i12)).getGroupId() == i11) {
                this.f1494b.removeAt(i12);
                i12--;
            }
            i12++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i11) {
        if (this.f1494b == null) {
            return;
        }
        for (int i12 = 0; i12 < this.f1494b.size(); i12++) {
            if (((b1.b) this.f1494b.keyAt(i12)).getItemId() == i11) {
                this.f1494b.removeAt(i12);
                return;
            }
        }
    }
}
