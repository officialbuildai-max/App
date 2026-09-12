package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.view.C1013c;
import androidx.view.C1014d;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.o0;
import androidx.view.q0;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements androidx.view.m, InterfaceC1015e, y0 {

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f9604a;

    /* renamed from: b, reason: collision with root package name */
    private final x0 f9605b;

    /* renamed from: c, reason: collision with root package name */
    private v0.c f9606c;

    /* renamed from: d, reason: collision with root package name */
    private androidx.view.w f9607d = null;

    /* renamed from: e, reason: collision with root package name */
    private C1014d f9608e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Fragment fragment, x0 x0Var) {
        this.f9604a = fragment;
        this.f9605b = x0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle.Event event) {
        this.f9607d.i(event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f9607d == null) {
            this.f9607d = new androidx.view.w(this);
            C1014d a11 = C1014d.a(this);
            this.f9608e = a11;
            a11.c();
            o0.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f9607d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f9608e.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f9608e.e(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Lifecycle.State state) {
        this.f9607d.n(state);
    }

    @Override // androidx.view.m
    public p1.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f9604a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        p1.b bVar = new p1.b();
        if (application != null) {
            bVar.c(v0.a.f9736g, application);
        }
        bVar.c(o0.f9713a, this);
        bVar.c(o0.f9714b, this);
        if (this.f9604a.getArguments() != null) {
            bVar.c(o0.f9715c, this.f9604a.getArguments());
        }
        return bVar;
    }

    @Override // androidx.view.m
    public v0.c getDefaultViewModelProviderFactory() {
        Application application;
        v0.c defaultViewModelProviderFactory = this.f9604a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f9604a.mDefaultFactory)) {
            this.f9606c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f9606c == null) {
            Context applicationContext = this.f9604a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f9606c = new q0(application, this, this.f9604a.getArguments());
        }
        return this.f9606c;
    }

    @Override // androidx.view.u
    public Lifecycle getLifecycle() {
        b();
        return this.f9607d;
    }

    @Override // androidx.view.InterfaceC1015e
    public C1013c getSavedStateRegistry() {
        b();
        return this.f9608e.b();
    }

    @Override // androidx.view.y0
    public x0 getViewModelStore() {
        b();
        return this.f9605b;
    }
}
