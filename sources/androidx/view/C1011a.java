package androidx.view;

import android.os.Bundle;
import androidx.view.C1013c;
import androidx.view.Lifecycle;
import androidx.view.r;
import androidx.view.u;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.savedstate.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1011a implements r {

    /* renamed from: b, reason: collision with root package name */
    public static final C0129a f14905b = new C0129a(null);

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC1015e f14906a;

    /* renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0129a {
        private C0129a() {
        }

        public /* synthetic */ C0129a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: androidx.savedstate.a$b */
    /* loaded from: classes2.dex */
    public static final class b implements C1013c.InterfaceC0130c {

        /* renamed from: a, reason: collision with root package name */
        private final Set f14907a;

        public b(C1013c registry) {
            Intrinsics.h(registry, "registry");
            this.f14907a = new LinkedHashSet();
            registry.h("androidx.savedstate.Restarter", this);
        }

        public final void a(String className) {
            Intrinsics.h(className, "className");
            this.f14907a.add(className);
        }

        @Override // androidx.view.C1013c.InterfaceC0130c
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f14907a));
            return bundle;
        }
    }

    public C1011a(InterfaceC1015e owner) {
        Intrinsics.h(owner, "owner");
        this.f14906a = owner;
    }

    private final void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, C1011a.class.getClassLoader()).asSubclass(C1013c.a.class);
            Intrinsics.g(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(null);
                    Intrinsics.g(newInstance, "{\n                constr…wInstance()\n            }");
                    ((C1013c.a) newInstance).a(this.f14906a);
                } catch (Exception e11) {
                    throw new RuntimeException("Failed to instantiate " + str, e11);
                }
            } catch (NoSuchMethodException e12) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e12);
            }
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException("Class " + str + " wasn't found", e13);
        }
    }

    @Override // androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().d(this);
        Bundle b11 = this.f14906a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (b11 == null) {
            return;
        }
        ArrayList<String> stringArrayList = b11.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
