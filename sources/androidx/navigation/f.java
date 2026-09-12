package androidx.navigation;

import androidx.view.t0;
import androidx.view.v0;
import androidx.view.w0;
import androidx.view.x0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes2.dex */
public final class f extends t0 implements p {

    /* renamed from: b, reason: collision with root package name */
    public static final b f13954b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final v0.c f13955c = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map f13956a = new LinkedHashMap();

    /* loaded from: classes2.dex */
    public static final class a implements v0.c {
        a() {
        }

        @Override // androidx.lifecycle.v0.c
        public t0 create(Class modelClass) {
            Intrinsics.h(modelClass, "modelClass");
            return new f();
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(Class cls, p1.a aVar) {
            return w0.b(this, cls, aVar);
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(KClass kClass, p1.a aVar) {
            return w0.c(this, kClass, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(x0 viewModelStore) {
            Intrinsics.h(viewModelStore, "viewModelStore");
            t0 a11 = new v0(viewModelStore, f.f13955c).a(f.class);
            Intrinsics.g(a11, "get(VM::class.java)");
            return (f) a11;
        }
    }

    @Override // androidx.navigation.p
    public x0 a(String backStackEntryId) {
        Intrinsics.h(backStackEntryId, "backStackEntryId");
        x0 x0Var = (x0) this.f13956a.get(backStackEntryId);
        if (x0Var != null) {
            return x0Var;
        }
        x0 x0Var2 = new x0();
        this.f13956a.put(backStackEntryId, x0Var2);
        return x0Var2;
    }

    public final void c(String backStackEntryId) {
        Intrinsics.h(backStackEntryId, "backStackEntryId");
        x0 x0Var = (x0) this.f13956a.remove(backStackEntryId);
        if (x0Var == null) {
            return;
        }
        x0Var.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        Iterator it = this.f13956a.values().iterator();
        while (it.hasNext()) {
            ((x0) it.next()).a();
        }
        this.f13956a.clear();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NavControllerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} ViewModelStores (");
        Iterator it = this.f13956a.keySet().iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "sb.toString()");
        return sb3;
    }
}
