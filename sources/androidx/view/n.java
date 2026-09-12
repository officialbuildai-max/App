package androidx.view;

import android.os.Bundle;
import androidx.view.C1013c;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f9705a = new n();

    /* loaded from: classes.dex */
    public static final class a implements C1013c.a {
        @Override // androidx.view.C1013c.a
        public void a(InterfaceC1015e owner) {
            Intrinsics.h(owner, "owner");
            if (!(owner instanceof y0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            x0 viewModelStore = ((y0) owner).getViewModelStore();
            C1013c savedStateRegistry = owner.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                t0 b11 = viewModelStore.b((String) it.next());
                Intrinsics.e(b11);
                n.a(b11, savedStateRegistry, owner.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Lifecycle f9706a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C1013c f9707b;

        b(Lifecycle lifecycle, C1013c c1013c) {
            this.f9706a = lifecycle;
            this.f9707b = c1013c;
        }

        @Override // androidx.view.r
        public void onStateChanged(u source, Lifecycle.Event event) {
            Intrinsics.h(source, "source");
            Intrinsics.h(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f9706a.d(this);
                this.f9707b.i(a.class);
            }
        }
    }

    private n() {
    }

    public static final void a(t0 viewModel, C1013c registry, Lifecycle lifecycle) {
        Intrinsics.h(viewModel, "viewModel");
        Intrinsics.h(registry, "registry");
        Intrinsics.h(lifecycle, "lifecycle");
        n0 n0Var = (n0) viewModel.getCloseable("androidx.lifecycle.savedstate.vm.tag");
        if (n0Var == null || n0Var.h()) {
            return;
        }
        n0Var.b(registry, lifecycle);
        f9705a.c(registry, lifecycle);
    }

    public static final n0 b(C1013c registry, Lifecycle lifecycle, String str, Bundle bundle) {
        Intrinsics.h(registry, "registry");
        Intrinsics.h(lifecycle, "lifecycle");
        Intrinsics.e(str);
        n0 n0Var = new n0(str, l0.f9697f.a(registry.b(str), bundle));
        n0Var.b(registry, lifecycle);
        f9705a.c(registry, lifecycle);
        return n0Var;
    }

    private final void c(C1013c c1013c, Lifecycle lifecycle) {
        Lifecycle.State b11 = lifecycle.b();
        if (b11 == Lifecycle.State.INITIALIZED || b11.isAtLeast(Lifecycle.State.STARTED)) {
            c1013c.i(a.class);
        } else {
            lifecycle.a(new b(lifecycle, c1013c));
        }
    }
}
