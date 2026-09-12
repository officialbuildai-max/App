package androidx.navigation;

import androidx.navigation.Navigator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: b, reason: collision with root package name */
    public static final a f14037b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Map f14038c = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Map f14039a = new LinkedHashMap();

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Class navigatorClass) {
            Intrinsics.h(navigatorClass, "navigatorClass");
            String str = (String) q.f14038c.get(navigatorClass);
            if (str == null) {
                Navigator.b bVar = (Navigator.b) navigatorClass.getAnnotation(Navigator.b.class);
                str = bVar == null ? null : bVar.value();
                if (!b(str)) {
                    throw new IllegalArgumentException(Intrinsics.q("No @Navigator.Name annotation found for ", navigatorClass.getSimpleName()).toString());
                }
                q.f14038c.put(navigatorClass, str);
            }
            Intrinsics.e(str);
            return str;
        }

        public final boolean b(String str) {
            return str != null && str.length() > 0;
        }
    }

    public final Navigator b(Navigator navigator) {
        Intrinsics.h(navigator, "navigator");
        return c(f14037b.a(navigator.getClass()), navigator);
    }

    public Navigator c(String name, Navigator navigator) {
        Intrinsics.h(name, "name");
        Intrinsics.h(navigator, "navigator");
        if (!f14037b.b(name)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        Navigator navigator2 = (Navigator) this.f14039a.get(name);
        if (Intrinsics.c(navigator2, navigator)) {
            return navigator;
        }
        boolean z10 = false;
        if (navigator2 != null && navigator2.c()) {
            z10 = true;
        }
        if (z10) {
            throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
        }
        if (!navigator.c()) {
            return (Navigator) this.f14039a.put(name, navigator);
        }
        throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
    }

    public Navigator d(String name) {
        Intrinsics.h(name, "name");
        if (!f14037b.b(name)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        Navigator navigator = (Navigator) this.f14039a.get(name);
        if (navigator != null) {
            return navigator;
        }
        throw new IllegalStateException("Could not find Navigator with name \"" + name + "\". You must call NavController.addNavigator() for each navigation type.");
    }

    public final Map e() {
        return MapsKt.u(this.f14039a);
    }
}
