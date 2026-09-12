package ii;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f65373c;

    /* renamed from: d, reason: collision with root package name */
    private static long f65374d;

    /* renamed from: e, reason: collision with root package name */
    private static String f65375e;

    /* renamed from: a, reason: collision with root package name */
    public static final b f65371a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Map f65372b = MapsKt.h();

    /* renamed from: f, reason: collision with root package name */
    private static final Set f65376f = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f65377a;

        /* renamed from: b, reason: collision with root package name */
        private final Function0 f65378b;

        public a(String sceneId, Function0 function0) {
            Intrinsics.h(sceneId, "sceneId");
            this.f65377a = sceneId;
            this.f65378b = function0;
        }

        public final Function0 a() {
            return this.f65378b;
        }

        public final String b() {
            return this.f65377a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f65377a, aVar.f65377a) && Intrinsics.c(this.f65378b, aVar.f65378b);
        }

        public int hashCode() {
            int hashCode = this.f65377a.hashCode() * 31;
            Function0 function0 = this.f65378b;
            return hashCode + (function0 == null ? 0 : function0.hashCode());
        }

        public String toString() {
            return "ShowingScene(sceneId=" + this.f65377a + ", handle=" + this.f65378b + ")";
        }
    }

    private b() {
    }

    private final void b(String str) {
        oi.a.f71145a.f("AdSceneCoordinator", str, 3, false);
    }

    public static /* synthetic */ void d(b bVar, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        bVar.c(str, z10);
    }

    public static /* synthetic */ void g(b bVar, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        bVar.f(str, function0);
    }

    public final boolean a(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        ii.a aVar = (ii.a) f65372b.get(sceneId);
        a aVar2 = f65373c;
        ii.a aVar3 = aVar2 != null ? (ii.a) f65372b.get(aVar2.b()) : null;
        if (aVar3 != null && aVar != null) {
            if (aVar.a() < aVar3.a()) {
                b("Scene " + sceneId + " preempting " + aVar2.b() + ".");
            } else {
                if (aVar.a() != aVar3.a()) {
                    b("Scene " + sceneId + " blocked by " + aVar2.b() + " (new=" + aVar.a() + ", current=" + aVar3.a() + ").");
                    return false;
                }
                b("Scene " + sceneId + " same priority as " + aVar2.b() + ", allow show.");
            }
            return true;
        }
        if (aVar2 != null && aVar == null) {
            b("Scene " + sceneId + " not registered, allow show.");
            return true;
        }
        if (aVar != null) {
            int a11 = aVar.a();
            Collection<ii.a> values = f65372b.values();
            if (!(values instanceof Collection) || !values.isEmpty()) {
                for (ii.a aVar4 : values) {
                    if (aVar4.a() < a11 && !f65376f.contains(Integer.valueOf(aVar4.a()))) {
                        b("Scene " + sceneId + " blocked: higher priority scenes not yet attempted.");
                        return false;
                    }
                }
            }
            if (aVar.b() != 0 && System.currentTimeMillis() - f65374d < aVar.b()) {
                b("Scene " + sceneId + " blocked by interval limit.");
                return false;
            }
            b("Scene " + sceneId + " allow show.");
        }
        return true;
    }

    public final void c(String sceneId, boolean z10) {
        Intrinsics.h(sceneId, "sceneId");
        if (z10) {
            b("Scene " + sceneId + " attempted.");
        }
        ii.a aVar = (ii.a) f65372b.get(sceneId);
        if (aVar != null) {
            f65376f.add(Integer.valueOf(aVar.a()));
        }
    }

    public final void e(String sceneId, boolean z10) {
        Intrinsics.h(sceneId, "sceneId");
        a aVar = f65373c;
        if (Intrinsics.c(aVar != null ? aVar.b() : null, sceneId)) {
            f65373c = null;
        }
        c(sceneId, false);
        if (!z10) {
            b("Dismiss scene: " + sceneId + " (wasShown=false)");
            return;
        }
        ii.a aVar2 = (ii.a) f65372b.get(sceneId);
        if (aVar2 == null || aVar2.b() != 0) {
            f65374d = System.currentTimeMillis();
        }
        f65375e = sceneId;
        b("Dismiss scene: " + sceneId + " (wasShown=true)");
    }

    public final void f(String sceneId, Function0 function0) {
        Function0 a11;
        Intrinsics.h(sceneId, "sceneId");
        a aVar = f65373c;
        if (Intrinsics.c(aVar != null ? aVar.b() : null, sceneId)) {
            b("Scene " + sceneId + " already showing.");
            return;
        }
        a aVar2 = f65373c;
        if (aVar2 != null && (a11 = aVar2.a()) != null) {
            a11.invoke();
        }
        f65373c = new a(sceneId, function0);
        b("Showing scene: " + sceneId);
    }

    public final void h(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        ii.a aVar = (ii.a) f65372b.get(sceneId);
        if (aVar != null) {
            int a11 = aVar.a();
            f65376f.remove(Integer.valueOf(a11));
            b("Session reset for scene " + sceneId + " (priority=" + a11 + ").");
        }
    }

    public final void i(Map sceneMap) {
        Intrinsics.h(sceneMap, "sceneMap");
        f65372b = sceneMap;
    }
}
