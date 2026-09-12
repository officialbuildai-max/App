package androidx.view;

import android.os.Bundle;
import androidx.view.C1013c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements C1013c.InterfaceC0130c {

    /* renamed from: a, reason: collision with root package name */
    private final C1013c f9642a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9643b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f9644c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f9645d;

    public SavedStateHandlesProvider(C1013c savedStateRegistry, final y0 viewModelStoreOwner) {
        Intrinsics.h(savedStateRegistry, "savedStateRegistry");
        Intrinsics.h(viewModelStoreOwner, "viewModelStoreOwner");
        this.f9642a = savedStateRegistry;
        this.f9645d = LazyKt.b(new Function0<p0>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p0 invoke() {
                return o0.e(y0.this);
            }
        });
    }

    private final p0 b() {
        return (p0) this.f9645d.getValue();
    }

    public final Bundle a(String key) {
        Intrinsics.h(key, "key");
        c();
        Bundle bundle = this.f9644c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f9644c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f9644c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f9644c = null;
        }
        return bundle2;
    }

    public final void c() {
        if (this.f9643b) {
            return;
        }
        Bundle b11 = this.f9642a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f9644c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (b11 != null) {
            bundle.putAll(b11);
        }
        this.f9644c = bundle;
        this.f9643b = true;
        b();
    }

    @Override // androidx.view.C1013c.InterfaceC0130c
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f9644c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : b().b().entrySet()) {
            String str = (String) entry.getKey();
            Bundle saveState = ((l0) entry.getValue()).c().saveState();
            if (!Intrinsics.c(saveState, Bundle.EMPTY)) {
                bundle.putBundle(str, saveState);
            }
        }
        this.f9643b = false;
        return bundle;
    }
}
