package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements f.a {

    /* renamed from: c, reason: collision with root package name */
    private Context f1342c;

    /* renamed from: d, reason: collision with root package name */
    private ActionBarContextView f1343d;

    /* renamed from: e, reason: collision with root package name */
    private b.a f1344e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference f1345f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1346g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1347h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.appcompat.view.menu.f f1348i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f1342c = context;
        this.f1343d = actionBarContextView;
        this.f1344e = aVar;
        androidx.appcompat.view.menu.f X = new androidx.appcompat.view.menu.f(actionBarContextView.getContext()).X(1);
        this.f1348i = X;
        X.W(this);
        this.f1347h = z10;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        return this.f1344e.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public void b(androidx.appcompat.view.menu.f fVar) {
        k();
        this.f1343d.showOverflowMenu();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f1346g) {
            return;
        }
        this.f1346g = true;
        this.f1344e.a(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference weakReference = this.f1345f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f1348i;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f1343d.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f1343d.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f1343d.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f1344e.d(this, this.f1348i);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f1343d.isTitleOptional();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        this.f1343d.setCustomView(view);
        this.f1345f = view != null ? new WeakReference(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i11) {
        o(this.f1342c.getString(i11));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f1343d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i11) {
        r(this.f1342c.getString(i11));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f1343d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z10) {
        super.s(z10);
        this.f1343d.setTitleOptional(z10);
    }
}
