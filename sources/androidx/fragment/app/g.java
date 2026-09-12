package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final i f9514a;

    private g(i iVar) {
        this.f9514a = iVar;
    }

    public static g b(i iVar) {
        return new g((i) androidx.core.util.i.h(iVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        i iVar = this.f9514a;
        iVar.f9519e.n(iVar, iVar, fragment);
    }

    public void c() {
        this.f9514a.f9519e.z();
    }

    public boolean d(MenuItem menuItem) {
        return this.f9514a.f9519e.C(menuItem);
    }

    public void e() {
        this.f9514a.f9519e.D();
    }

    public void f() {
        this.f9514a.f9519e.F();
    }

    public void g() {
        this.f9514a.f9519e.O();
    }

    public void h() {
        this.f9514a.f9519e.S();
    }

    public void i() {
        this.f9514a.f9519e.T();
    }

    public void j() {
        this.f9514a.f9519e.V();
    }

    public boolean k() {
        return this.f9514a.f9519e.c0(true);
    }

    public FragmentManager l() {
        return this.f9514a.f9519e;
    }

    public void m() {
        this.f9514a.f9519e.d1();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f9514a.f9519e.A0().onCreateView(view, str, context, attributeSet);
    }
}
