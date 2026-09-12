package androidx.view;

import android.os.Bundle;
import androidx.view.C1013c;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.v0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p1.a;

/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a.b f9713a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b f9714b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a.b f9715c = new a();

    /* loaded from: classes.dex */
    public static final class a implements a.b {
        a() {
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements a.b {
        b() {
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements a.b {
        c() {
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements v0.c {
        d() {
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(Class cls) {
            return w0.a(this, cls);
        }

        @Override // androidx.lifecycle.v0.c
        public t0 create(Class modelClass, p1.a extras) {
            Intrinsics.h(modelClass, "modelClass");
            Intrinsics.h(extras, "extras");
            return new p0();
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(KClass kClass, p1.a aVar) {
            return w0.c(this, kClass, aVar);
        }
    }

    private static final l0 a(InterfaceC1015e interfaceC1015e, y0 y0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider d11 = d(interfaceC1015e);
        p0 e11 = e(y0Var);
        l0 l0Var = (l0) e11.b().get(str);
        if (l0Var != null) {
            return l0Var;
        }
        l0 a11 = l0.f9697f.a(d11.a(str), bundle);
        e11.b().put(str, a11);
        return a11;
    }

    public static final l0 b(p1.a aVar) {
        Intrinsics.h(aVar, "<this>");
        InterfaceC1015e interfaceC1015e = (InterfaceC1015e) aVar.a(f9713a);
        if (interfaceC1015e == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        y0 y0Var = (y0) aVar.a(f9714b);
        if (y0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f9715c);
        String str = (String) aVar.a(v0.d.f9740c);
        if (str != null) {
            return a(interfaceC1015e, y0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final void c(InterfaceC1015e interfaceC1015e) {
        Intrinsics.h(interfaceC1015e, "<this>");
        Lifecycle.State b11 = interfaceC1015e.getLifecycle().b();
        if (b11 != Lifecycle.State.INITIALIZED && b11 != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (interfaceC1015e.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(interfaceC1015e.getSavedStateRegistry(), (y0) interfaceC1015e);
            interfaceC1015e.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            interfaceC1015e.getLifecycle().a(new m0(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(InterfaceC1015e interfaceC1015e) {
        Intrinsics.h(interfaceC1015e, "<this>");
        C1013c.InterfaceC0130c c11 = interfaceC1015e.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = c11 instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) c11 : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final p0 e(y0 y0Var) {
        Intrinsics.h(y0Var, "<this>");
        return (p0) new v0(y0Var, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", p0.class);
    }
}
