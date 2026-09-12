package androidx.view;

import android.os.Bundle;
import androidx.view.C1013c;
import androidx.view.InterfaceC1015e;
import androidx.view.v0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public abstract class a extends v0.e implements v0.c {

    /* renamed from: a, reason: collision with root package name */
    private C1013c f9655a;

    /* renamed from: b, reason: collision with root package name */
    private Lifecycle f9656b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f9657c;

    public a() {
    }

    public a(InterfaceC1015e owner, Bundle bundle) {
        Intrinsics.h(owner, "owner");
        this.f9655a = owner.getSavedStateRegistry();
        this.f9656b = owner.getLifecycle();
        this.f9657c = bundle;
    }

    private final t0 b(String str, Class cls) {
        C1013c c1013c = this.f9655a;
        Intrinsics.e(c1013c);
        Lifecycle lifecycle = this.f9656b;
        Intrinsics.e(lifecycle);
        n0 b11 = n.b(c1013c, lifecycle, str, this.f9657c);
        t0 c11 = c(str, cls, b11.d());
        c11.addCloseable("androidx.lifecycle.savedstate.vm.tag", b11);
        return c11;
    }

    @Override // androidx.lifecycle.v0.e
    public void a(t0 viewModel) {
        Intrinsics.h(viewModel, "viewModel");
        C1013c c1013c = this.f9655a;
        if (c1013c != null) {
            Intrinsics.e(c1013c);
            Lifecycle lifecycle = this.f9656b;
            Intrinsics.e(lifecycle);
            n.a(viewModel, c1013c, lifecycle);
        }
    }

    protected abstract t0 c(String str, Class cls, l0 l0Var);

    @Override // androidx.lifecycle.v0.c
    public t0 create(Class modelClass) {
        Intrinsics.h(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (this.f9656b != null) {
            return b(canonicalName, modelClass);
        }
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.v0.c
    public t0 create(Class modelClass, p1.a extras) {
        Intrinsics.h(modelClass, "modelClass");
        Intrinsics.h(extras, "extras");
        String str = (String) extras.a(v0.d.f9740c);
        if (str != null) {
            return this.f9655a != null ? b(str, modelClass) : c(str, modelClass, o0.b(extras));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.v0.c
    public /* synthetic */ t0 create(KClass kClass, p1.a aVar) {
        return w0.c(this, kClass, aVar);
    }
}
