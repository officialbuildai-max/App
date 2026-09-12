package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.navigation.NavBackStackEntry;
import androidx.view.C1013c;
import androidx.view.C1014d;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.l0;
import androidx.view.q0;
import androidx.view.t0;
import androidx.view.u;
import androidx.view.v0;
import androidx.view.w;
import androidx.view.x0;
import androidx.view.y0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class NavBackStackEntry implements u, y0, androidx.view.m, InterfaceC1015e {

    /* renamed from: n, reason: collision with root package name */
    public static final a f13845n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Context f13846a;

    /* renamed from: b, reason: collision with root package name */
    private NavDestination f13847b;

    /* renamed from: c, reason: collision with root package name */
    private final Bundle f13848c;

    /* renamed from: d, reason: collision with root package name */
    private Lifecycle.State f13849d;

    /* renamed from: e, reason: collision with root package name */
    private final p f13850e;

    /* renamed from: f, reason: collision with root package name */
    private final String f13851f;

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f13852g;

    /* renamed from: h, reason: collision with root package name */
    private w f13853h;

    /* renamed from: i, reason: collision with root package name */
    private final C1014d f13854i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13855j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f13856k;

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f13857l;

    /* renamed from: m, reason: collision with root package name */
    private Lifecycle.State f13858m;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry b(a aVar, Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2, int i11, Object obj) {
            String str2;
            Bundle bundle3 = (i11 & 4) != 0 ? null : bundle;
            Lifecycle.State state2 = (i11 & 8) != 0 ? Lifecycle.State.CREATED : state;
            p pVar2 = (i11 & 16) != 0 ? null : pVar;
            if ((i11 & 32) != 0) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.g(uuid, "randomUUID().toString()");
                str2 = uuid;
            } else {
                str2 = str;
            }
            return aVar.a(context, navDestination, bundle3, state2, pVar2, str2, (i11 & 64) != 0 ? null : bundle2);
        }

        public final NavBackStackEntry a(Context context, NavDestination destination, Bundle bundle, Lifecycle.State hostLifecycleState, p pVar, String id2, Bundle bundle2) {
            Intrinsics.h(destination, "destination");
            Intrinsics.h(hostLifecycleState, "hostLifecycleState");
            Intrinsics.h(id2, "id");
            return new NavBackStackEntry(context, destination, bundle, hostLifecycleState, pVar, id2, bundle2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends androidx.view.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC1015e owner, Bundle bundle) {
            super(owner, bundle);
            Intrinsics.h(owner, "owner");
        }

        @Override // androidx.view.a
        protected t0 c(String key, Class modelClass, l0 handle) {
            Intrinsics.h(key, "key");
            Intrinsics.h(modelClass, "modelClass");
            Intrinsics.h(handle, "handle");
            return new c(handle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c extends t0 {

        /* renamed from: a, reason: collision with root package name */
        private final l0 f13859a;

        public c(l0 handle) {
            Intrinsics.h(handle, "handle");
            this.f13859a = handle;
        }

        public final l0 b() {
            return this.f13859a;
        }
    }

    private NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2) {
        this.f13846a = context;
        this.f13847b = navDestination;
        this.f13848c = bundle;
        this.f13849d = state;
        this.f13850e = pVar;
        this.f13851f = str;
        this.f13852g = bundle2;
        this.f13853h = new w(this);
        C1014d a11 = C1014d.a(this);
        Intrinsics.g(a11, "create(this)");
        this.f13854i = a11;
        this.f13856k = LazyKt.b(new Function0<q0>() { // from class: androidx.navigation.NavBackStackEntry$defaultFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final q0 invoke() {
                Context context2;
                context2 = NavBackStackEntry.this.f13846a;
                Context applicationContext = context2 == null ? null : context2.getApplicationContext();
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                NavBackStackEntry navBackStackEntry = NavBackStackEntry.this;
                return new q0(application, navBackStackEntry, navBackStackEntry.d());
            }
        });
        this.f13857l = LazyKt.b(new Function0<l0>() { // from class: androidx.navigation.NavBackStackEntry$savedStateHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final l0 invoke() {
                boolean z10;
                w wVar;
                z10 = NavBackStackEntry.this.f13855j;
                if (!z10) {
                    throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
                }
                wVar = NavBackStackEntry.this.f13853h;
                if (wVar.b() == Lifecycle.State.DESTROYED) {
                    throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.");
                }
                NavBackStackEntry navBackStackEntry = NavBackStackEntry.this;
                return ((NavBackStackEntry.c) new v0(navBackStackEntry, new NavBackStackEntry.b(navBackStackEntry, null)).a(NavBackStackEntry.c.class)).b();
            }
        });
        this.f13858m = Lifecycle.State.INITIALIZED;
    }

    public /* synthetic */ NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, navDestination, bundle, state, pVar, str, bundle2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry(NavBackStackEntry entry, Bundle bundle) {
        this(entry.f13846a, entry.f13847b, bundle, entry.f13849d, entry.f13850e, entry.f13851f, entry.f13852g);
        Intrinsics.h(entry, "entry");
        this.f13849d = entry.f13849d;
        l(entry.f13858m);
    }

    private final q0 e() {
        return (q0) this.f13856k.getValue();
    }

    public final Bundle d() {
        return this.f13848c;
    }

    public boolean equals(Object obj) {
        Set<String> keySet;
        if (obj == null || !(obj instanceof NavBackStackEntry)) {
            return false;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (!Intrinsics.c(this.f13851f, navBackStackEntry.f13851f) || !Intrinsics.c(this.f13847b, navBackStackEntry.f13847b) || !Intrinsics.c(this.f13853h, navBackStackEntry.f13853h) || !Intrinsics.c(getSavedStateRegistry(), navBackStackEntry.getSavedStateRegistry())) {
            return false;
        }
        if (!Intrinsics.c(this.f13848c, navBackStackEntry.f13848c)) {
            Bundle bundle = this.f13848c;
            if (bundle == null || (keySet = bundle.keySet()) == null) {
                return false;
            }
            Set<String> set = keySet;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                for (String str : set) {
                    Object obj2 = d().get(str);
                    Bundle d11 = navBackStackEntry.d();
                    if (!Intrinsics.c(obj2, d11 == null ? null : d11.get(str))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final NavDestination f() {
        return this.f13847b;
    }

    public final String g() {
        return this.f13851f;
    }

    @Override // androidx.view.m
    public /* synthetic */ p1.a getDefaultViewModelCreationExtras() {
        return androidx.view.l.a(this);
    }

    @Override // androidx.view.m
    public v0.c getDefaultViewModelProviderFactory() {
        return e();
    }

    @Override // androidx.view.u
    public Lifecycle getLifecycle() {
        return this.f13853h;
    }

    @Override // androidx.view.InterfaceC1015e
    public C1013c getSavedStateRegistry() {
        C1013c b11 = this.f13854i.b();
        Intrinsics.g(b11, "savedStateRegistryController.savedStateRegistry");
        return b11;
    }

    @Override // androidx.view.y0
    public x0 getViewModelStore() {
        if (!this.f13855j) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        }
        if (this.f13853h.b() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
        }
        p pVar = this.f13850e;
        if (pVar != null) {
            return pVar.a(this.f13851f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public final Lifecycle.State h() {
        return this.f13858m;
    }

    public int hashCode() {
        Set<String> keySet;
        int hashCode = (this.f13851f.hashCode() * 31) + this.f13847b.hashCode();
        Bundle bundle = this.f13848c;
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                int i11 = hashCode * 31;
                Object obj = d().get((String) it.next());
                hashCode = i11 + (obj == null ? 0 : obj.hashCode());
            }
        }
        return (((hashCode * 31) + this.f13853h.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final void i(Lifecycle.Event event) {
        Intrinsics.h(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.g(targetState, "event.targetState");
        this.f13849d = targetState;
        m();
    }

    public final void j(Bundle outBundle) {
        Intrinsics.h(outBundle, "outBundle");
        this.f13854i.e(outBundle);
    }

    public final void k(NavDestination navDestination) {
        Intrinsics.h(navDestination, "<set-?>");
        this.f13847b = navDestination;
    }

    public final void l(Lifecycle.State maxState) {
        Intrinsics.h(maxState, "maxState");
        this.f13858m = maxState;
        m();
    }

    public final void m() {
        if (!this.f13855j) {
            this.f13854i.d(this.f13852g);
            this.f13855j = true;
        }
        if (this.f13849d.ordinal() < this.f13858m.ordinal()) {
            this.f13853h.n(this.f13849d);
        } else {
            this.f13853h.n(this.f13858m);
        }
    }
}
