package androidx.view;

import android.os.Bundle;
import androidx.view.C1011a;
import androidx.view.Lifecycle;
import androidx.view.r;
import androidx.view.u;
import java.util.Iterator;
import java.util.Map;
import k.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.savedstate.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1013c {

    /* renamed from: g, reason: collision with root package name */
    private static final b f14909g = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private boolean f14911b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f14912c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14913d;

    /* renamed from: e, reason: collision with root package name */
    private C1011a.b f14914e;

    /* renamed from: a, reason: collision with root package name */
    private final k.b f14910a = new k.b();

    /* renamed from: f, reason: collision with root package name */
    private boolean f14915f = true;

    /* renamed from: androidx.savedstate.c$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(InterfaceC1015e interfaceC1015e);
    }

    /* renamed from: androidx.savedstate.c$b */
    /* loaded from: classes2.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: androidx.savedstate.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0130c {
        Bundle saveState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C1013c this$0, u uVar, Lifecycle.Event event) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(uVar, "<anonymous parameter 0>");
        Intrinsics.h(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.f14915f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.f14915f = false;
        }
    }

    public final Bundle b(String key) {
        Intrinsics.h(key, "key");
        if (!this.f14913d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f14912c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f14912c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f14912c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f14912c = null;
        }
        return bundle2;
    }

    public final InterfaceC0130c c(String key) {
        Intrinsics.h(key, "key");
        Iterator it = this.f14910a.iterator();
        while (it.hasNext()) {
            Map.Entry components = (Map.Entry) it.next();
            Intrinsics.g(components, "components");
            String str = (String) components.getKey();
            InterfaceC0130c interfaceC0130c = (InterfaceC0130c) components.getValue();
            if (Intrinsics.c(str, key)) {
                return interfaceC0130c;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        Intrinsics.h(lifecycle, "lifecycle");
        if (this.f14911b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new r() { // from class: androidx.savedstate.b
            @Override // androidx.view.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                C1013c.d(C1013c.this, uVar, event);
            }
        });
        this.f14911b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f14911b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f14913d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f14912c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f14913d = true;
    }

    public final void g(Bundle outBundle) {
        Intrinsics.h(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f14912c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        b.d c11 = this.f14910a.c();
        Intrinsics.g(c11, "this.components.iteratorWithAdditions()");
        while (c11.hasNext()) {
            Map.Entry entry = (Map.Entry) c11.next();
            bundle.putBundle((String) entry.getKey(), ((InterfaceC0130c) entry.getValue()).saveState());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, InterfaceC0130c provider) {
        Intrinsics.h(key, "key");
        Intrinsics.h(provider, "provider");
        if (((InterfaceC0130c) this.f14910a.g(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class clazz) {
        Intrinsics.h(clazz, "clazz");
        if (!this.f14915f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        C1011a.b bVar = this.f14914e;
        if (bVar == null) {
            bVar = new C1011a.b(this);
        }
        this.f14914e = bVar;
        try {
            clazz.getDeclaredConstructor(null);
            C1011a.b bVar2 = this.f14914e;
            if (bVar2 != null) {
                String name = clazz.getName();
                Intrinsics.g(name, "clazz.name");
                bVar2.a(name);
            }
        } catch (NoSuchMethodException e11) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
        }
    }

    public final void j(String key) {
        Intrinsics.h(key, "key");
        this.f14910a.h(key);
    }
}
