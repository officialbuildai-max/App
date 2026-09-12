package ua;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final View f76829a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f76830b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f76831c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f76829a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.f76829a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.f76829a);
        }
    }

    public int b() {
        return this.f76831c;
    }

    public boolean c() {
        return this.f76830b;
    }

    public void d(Bundle bundle) {
        this.f76830b = bundle.getBoolean("expanded", false);
        this.f76831c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f76830b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f76830b);
        bundle.putInt("expandedComponentIdHint", this.f76831c);
        return bundle;
    }

    public boolean f(boolean z10) {
        if (this.f76830b == z10) {
            return false;
        }
        this.f76830b = z10;
        a();
        return true;
    }

    public void g(int i11) {
        this.f76831c = i11;
    }
}
