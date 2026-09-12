package androidx.fragment.app;

import android.util.Log;
import androidx.view.t0;
import androidx.view.v0;
import androidx.view.w0;
import androidx.view.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends t0 {

    /* renamed from: h, reason: collision with root package name */
    private static final v0.c f9532h = new a();

    /* renamed from: d, reason: collision with root package name */
    private final boolean f9536d;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f9533a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f9534b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f9535c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private boolean f9537e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9538f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9539g = false;

    /* loaded from: classes.dex */
    class a implements v0.c {
        a() {
        }

        @Override // androidx.lifecycle.v0.c
        public t0 create(Class cls) {
            return new r(true);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(boolean z10) {
        this.f9536d = z10;
    }

    private void e(String str) {
        r rVar = (r) this.f9534b.get(str);
        if (rVar != null) {
            rVar.onCleared();
            this.f9534b.remove(str);
        }
        x0 x0Var = (x0) this.f9535c.get(str);
        if (x0Var != null) {
            x0Var.a();
            this.f9535c.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r h(x0 x0Var) {
        return (r) new v0(x0Var, f9532h).a(r.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        if (this.f9539g) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f9533a.containsKey(fragment.mWho)) {
                return;
            }
            this.f9533a.put(fragment.mWho, fragment);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment) {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for ");
            sb2.append(fragment);
        }
        e(fragment.mWho);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for saved state of Fragment ");
            sb2.append(str);
        }
        e(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.f9533a.equals(rVar.f9533a) && this.f9534b.equals(rVar.f9534b) && this.f9535c.equals(rVar.f9535c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f(String str) {
        return (Fragment) this.f9533a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r g(Fragment fragment) {
        r rVar = (r) this.f9534b.get(fragment.mWho);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(this.f9536d);
        this.f9534b.put(fragment.mWho, rVar2);
        return rVar2;
    }

    public int hashCode() {
        return (((this.f9533a.hashCode() * 31) + this.f9534b.hashCode()) * 31) + this.f9535c.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection i() {
        return new ArrayList(this.f9533a.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0 j(Fragment fragment) {
        x0 x0Var = (x0) this.f9535c.get(fragment.mWho);
        if (x0Var != null) {
            return x0Var;
        }
        x0 x0Var2 = new x0();
        this.f9535c.put(fragment.mWho, x0Var2);
        return x0Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f9537e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        if (this.f9539g) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f9533a.remove(fragment.mWho) == null || !FragmentManager.M0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z10) {
        this.f9539g = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(Fragment fragment) {
        if (this.f9533a.containsKey(fragment.mWho)) {
            return this.f9536d ? this.f9537e : !this.f9538f;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCleared called for ");
            sb2.append(this);
        }
        this.f9537e = true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f9533a.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f9534b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f9535c.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
