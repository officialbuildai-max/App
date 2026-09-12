package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f9523a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final FragmentManager f9524b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final FragmentManager.k f9525a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f9526b;

        a(FragmentManager.k kVar, boolean z10) {
            this.f9525a = kVar;
            this.f9526b = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FragmentManager fragmentManager) {
        this.f9524b = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().a(fragment, bundle, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentActivityCreated(this.f9524b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z10) {
        Context f11 = this.f9524b.z0().f();
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().b(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentAttached(this.f9524b, fragment, f11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().c(fragment, bundle, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentCreated(this.f9524b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().d(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentDestroyed(this.f9524b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().e(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentDetached(this.f9524b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().f(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentPaused(this.f9524b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z10) {
        Context f11 = this.f9524b.z0().f();
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().g(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentPreAttached(this.f9524b, fragment, f11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().h(fragment, bundle, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentPreCreated(this.f9524b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().i(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentResumed(this.f9524b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().j(fragment, bundle, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentSaveInstanceState(this.f9524b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().k(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentStarted(this.f9524b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().l(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentStopped(this.f9524b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().m(fragment, view, bundle, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentViewCreated(this.f9524b, fragment, view, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z10) {
        Fragment C0 = this.f9524b.C0();
        if (C0 != null) {
            C0.getParentFragmentManager().B0().n(fragment, true);
        }
        Iterator it = this.f9523a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f9526b) {
                aVar.f9525a.onFragmentViewDestroyed(this.f9524b, fragment);
            }
        }
    }

    public void o(FragmentManager.k kVar, boolean z10) {
        this.f9523a.add(new a(kVar, z10));
    }

    public void p(FragmentManager.k kVar) {
        synchronized (this.f9523a) {
            try {
                int size = this.f9523a.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    if (((a) this.f9523a.get(i11)).f9525a == kVar) {
                        this.f9523a.remove(i11);
                        break;
                    }
                    i11++;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
