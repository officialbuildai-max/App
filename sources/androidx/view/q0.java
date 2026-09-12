package androidx.view;

import android.app.Application;
import android.os.Bundle;
import androidx.view.C1013c;
import androidx.view.InterfaceC1015e;
import androidx.view.v0;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p1.a;

/* loaded from: classes.dex */
public final class q0 extends v0.e implements v0.c {

    /* renamed from: a, reason: collision with root package name */
    private Application f9723a;

    /* renamed from: b, reason: collision with root package name */
    private final v0.c f9724b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f9725c;

    /* renamed from: d, reason: collision with root package name */
    private Lifecycle f9726d;

    /* renamed from: e, reason: collision with root package name */
    private C1013c f9727e;

    public q0() {
        this.f9724b = new v0.a();
    }

    public q0(Application application, InterfaceC1015e owner, Bundle bundle) {
        Intrinsics.h(owner, "owner");
        this.f9727e = owner.getSavedStateRegistry();
        this.f9726d = owner.getLifecycle();
        this.f9725c = bundle;
        this.f9723a = application;
        this.f9724b = application != null ? v0.a.f9734e.a(application) : new v0.a();
    }

    @Override // androidx.lifecycle.v0.e
    public void a(t0 viewModel) {
        Intrinsics.h(viewModel, "viewModel");
        if (this.f9726d != null) {
            C1013c c1013c = this.f9727e;
            Intrinsics.e(c1013c);
            Lifecycle lifecycle = this.f9726d;
            Intrinsics.e(lifecycle);
            n.a(viewModel, c1013c, lifecycle);
        }
    }

    public final t0 b(String key, Class modelClass) {
        t0 d11;
        Application application;
        Intrinsics.h(key, "key");
        Intrinsics.h(modelClass, "modelClass");
        Lifecycle lifecycle = this.f9726d;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean isAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor c11 = (!isAssignableFrom || this.f9723a == null) ? r0.c(modelClass, r0.b()) : r0.c(modelClass, r0.a());
        if (c11 == null) {
            return this.f9723a != null ? this.f9724b.create(modelClass) : v0.d.f9738a.a().create(modelClass);
        }
        C1013c c1013c = this.f9727e;
        Intrinsics.e(c1013c);
        n0 b11 = n.b(c1013c, lifecycle, key, this.f9725c);
        if (!isAssignableFrom || (application = this.f9723a) == null) {
            d11 = r0.d(modelClass, c11, b11.d());
        } else {
            Intrinsics.e(application);
            d11 = r0.d(modelClass, c11, application, b11.d());
        }
        d11.addCloseable("androidx.lifecycle.savedstate.vm.tag", b11);
        return d11;
    }

    @Override // androidx.lifecycle.v0.c
    public t0 create(Class modelClass) {
        Intrinsics.h(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return b(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.v0.c
    public t0 create(Class modelClass, a extras) {
        Intrinsics.h(modelClass, "modelClass");
        Intrinsics.h(extras, "extras");
        String str = (String) extras.a(v0.d.f9740c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(o0.f9713a) == null || extras.a(o0.f9714b) == null) {
            if (this.f9726d != null) {
                return b(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(v0.a.f9736g);
        boolean isAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor c11 = (!isAssignableFrom || application == null) ? r0.c(modelClass, r0.b()) : r0.c(modelClass, r0.a());
        return c11 == null ? this.f9724b.create(modelClass, extras) : (!isAssignableFrom || application == null) ? r0.d(modelClass, c11, o0.b(extras)) : r0.d(modelClass, c11, application, o0.b(extras));
    }

    @Override // androidx.lifecycle.v0.c
    public /* synthetic */ t0 create(KClass kClass, a aVar) {
        return w0.c(this, kClass, aVar);
    }
}
