package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.n;
import androidx.collection.x0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f1349a;

    /* renamed from: b, reason: collision with root package name */
    final b f1350b;

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f1351a;

        /* renamed from: b, reason: collision with root package name */
        final Context f1352b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList f1353c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        final x0 f1354d = new x0();

        public a(Context context, ActionMode.Callback callback) {
            this.f1352b = context;
            this.f1351a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f1354d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            n nVar = new n(this.f1352b, (b1.a) menu);
            this.f1354d.put(menu, nVar);
            return nVar;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(b bVar) {
            this.f1351a.onDestroyActionMode(e(bVar));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f1351a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, MenuItem menuItem) {
            return this.f1351a.onActionItemClicked(e(bVar), new androidx.appcompat.view.menu.i(this.f1352b, (b1.b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f1351a.onPrepareActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f1353c.size();
            for (int i11 = 0; i11 < size; i11++) {
                f fVar = (f) this.f1353c.get(i11);
                if (fVar != null && fVar.f1350b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f1352b, bVar);
            this.f1353c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f1349a = context;
        this.f1350b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1350b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1350b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new n(this.f1349a, (b1.a) this.f1350b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1350b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1350b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1350b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1350b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1350b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1350b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1350b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1350b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i11) {
        this.f1350b.n(i11);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1350b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1350b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i11) {
        this.f1350b.q(i11);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1350b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f1350b.s(z10);
    }
}
