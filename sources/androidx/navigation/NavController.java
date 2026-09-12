package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.b0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.f;
import androidx.navigation.l;
import androidx.view.Lifecycle;
import androidx.view.t;
import androidx.view.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.flow.y0;

/* loaded from: classes.dex */
public abstract class NavController {
    public static final a G = new a(null);
    private static boolean H = true;
    private final Map A;
    private int B;
    private final List C;
    private final Lazy D;
    private final x0 E;
    private final kotlinx.coroutines.flow.b F;

    /* renamed from: a, reason: collision with root package name */
    private final Context f13861a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f13862b;

    /* renamed from: c, reason: collision with root package name */
    private k f13863c;

    /* renamed from: d, reason: collision with root package name */
    private NavGraph f13864d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f13865e;

    /* renamed from: f, reason: collision with root package name */
    private Parcelable[] f13866f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13867g;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayDeque f13868h;

    /* renamed from: i, reason: collision with root package name */
    private final y0 f13869i;

    /* renamed from: j, reason: collision with root package name */
    private final i1 f13870j;

    /* renamed from: k, reason: collision with root package name */
    private final Map f13871k;

    /* renamed from: l, reason: collision with root package name */
    private final Map f13872l;

    /* renamed from: m, reason: collision with root package name */
    private final Map f13873m;

    /* renamed from: n, reason: collision with root package name */
    private final Map f13874n;

    /* renamed from: o, reason: collision with root package name */
    private u f13875o;

    /* renamed from: p, reason: collision with root package name */
    private OnBackPressedDispatcher f13876p;

    /* renamed from: q, reason: collision with root package name */
    private f f13877q;

    /* renamed from: r, reason: collision with root package name */
    private final CopyOnWriteArrayList f13878r;

    /* renamed from: s, reason: collision with root package name */
    private Lifecycle.State f13879s;

    /* renamed from: t, reason: collision with root package name */
    private final t f13880t;

    /* renamed from: u, reason: collision with root package name */
    private final androidx.activity.u f13881u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f13882v;

    /* renamed from: w, reason: collision with root package name */
    private q f13883w;

    /* renamed from: x, reason: collision with root package name */
    private final Map f13884x;

    /* renamed from: y, reason: collision with root package name */
    private Function1 f13885y;

    /* renamed from: z, reason: collision with root package name */
    private Function1 f13886z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class NavControllerNavigatorState extends r {

        /* renamed from: g, reason: collision with root package name */
        private final Navigator f13887g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ NavController f13888h;

        public NavControllerNavigatorState(NavController this$0, Navigator navigator) {
            Intrinsics.h(this$0, "this$0");
            Intrinsics.h(navigator, "navigator");
            this.f13888h = this$0;
            this.f13887g = navigator;
        }

        @Override // androidx.navigation.r
        public NavBackStackEntry a(NavDestination destination, Bundle bundle) {
            Intrinsics.h(destination, "destination");
            return NavBackStackEntry.a.b(NavBackStackEntry.f13845n, this.f13888h.y(), destination, bundle, this.f13888h.D(), this.f13888h.f13877q, null, null, 96, null);
        }

        @Override // androidx.navigation.r
        public void e(NavBackStackEntry entry) {
            f fVar;
            Intrinsics.h(entry, "entry");
            boolean c11 = Intrinsics.c(this.f13888h.A.get(entry), Boolean.TRUE);
            super.e(entry);
            this.f13888h.A.remove(entry);
            if (this.f13888h.v().contains(entry)) {
                if (d()) {
                    return;
                }
                this.f13888h.h0();
                this.f13888h.f13869i.b(this.f13888h.W());
                return;
            }
            this.f13888h.g0(entry);
            if (entry.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                entry.l(Lifecycle.State.DESTROYED);
            }
            ArrayDeque v11 = this.f13888h.v();
            if (!(v11 instanceof Collection) || !v11.isEmpty()) {
                Iterator<E> it = v11.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.c(((NavBackStackEntry) it.next()).g(), entry.g())) {
                        break;
                    }
                }
            }
            if (!c11 && (fVar = this.f13888h.f13877q) != null) {
                fVar.c(entry.g());
            }
            this.f13888h.h0();
            this.f13888h.f13869i.b(this.f13888h.W());
        }

        @Override // androidx.navigation.r
        public void g(final NavBackStackEntry popUpTo, final boolean z10) {
            Intrinsics.h(popUpTo, "popUpTo");
            Navigator d11 = this.f13888h.f13883w.d(popUpTo.f().o());
            if (!Intrinsics.c(d11, this.f13887g)) {
                Object obj = this.f13888h.f13884x.get(d11);
                Intrinsics.e(obj);
                ((NavControllerNavigatorState) obj).g(popUpTo, z10);
            } else {
                Function1 function1 = this.f13888h.f13886z;
                if (function1 == null) {
                    this.f13888h.Q(popUpTo, new Function0<Unit>() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$pop$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m473invoke();
                            return Unit.f67184a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m473invoke() {
                            super/*androidx.navigation.r*/.g(popUpTo, z10);
                        }
                    });
                } else {
                    function1.invoke(popUpTo);
                    super.g(popUpTo, z10);
                }
            }
        }

        @Override // androidx.navigation.r
        public void h(NavBackStackEntry backStackEntry) {
            Intrinsics.h(backStackEntry, "backStackEntry");
            Navigator d11 = this.f13888h.f13883w.d(backStackEntry.f().o());
            if (!Intrinsics.c(d11, this.f13887g)) {
                Object obj = this.f13888h.f13884x.get(d11);
                if (obj != null) {
                    ((NavControllerNavigatorState) obj).h(backStackEntry);
                    return;
                }
                throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.f().o() + " should already be created").toString());
            }
            Function1 function1 = this.f13888h.f13885y;
            if (function1 != null) {
                function1.invoke(backStackEntry);
                k(backStackEntry);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Ignoring add of destination ");
                sb2.append(backStackEntry.f());
                sb2.append(" outside of the call to navigate(). ");
            }
        }

        public final void k(NavBackStackEntry backStackEntry) {
            Intrinsics.h(backStackEntry, "backStackEntry");
            super.h(backStackEntry);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends androidx.activity.u {
        b() {
            super(false);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            NavController.this.N();
        }
    }

    public NavController(Context context) {
        Object obj;
        Intrinsics.h(context, "context");
        this.f13861a = context;
        Iterator f67553a = SequencesKt.h(context, new Function1<Context, Context>() { // from class: androidx.navigation.NavController$activity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it) {
                Intrinsics.h(it, "it");
                if (it instanceof ContextWrapper) {
                    return ((ContextWrapper) it).getBaseContext();
                }
                return null;
            }
        }).getF67553a();
        while (true) {
            if (!f67553a.hasNext()) {
                obj = null;
                break;
            } else {
                obj = f67553a.next();
                if (((Context) obj) instanceof Activity) {
                    break;
                }
            }
        }
        this.f13862b = (Activity) obj;
        this.f13868h = new ArrayDeque();
        y0 a11 = j1.a(CollectionsKt.l());
        this.f13869i = a11;
        this.f13870j = kotlinx.coroutines.flow.d.b(a11);
        this.f13871k = new LinkedHashMap();
        this.f13872l = new LinkedHashMap();
        this.f13873m = new LinkedHashMap();
        this.f13874n = new LinkedHashMap();
        this.f13878r = new CopyOnWriteArrayList();
        this.f13879s = Lifecycle.State.INITIALIZED;
        this.f13880t = new androidx.view.r() { // from class: androidx.navigation.e
            @Override // androidx.view.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                NavController.I(NavController.this, uVar, event);
            }
        };
        this.f13881u = new b();
        this.f13882v = true;
        this.f13883w = new q();
        this.f13884x = new LinkedHashMap();
        this.A = new LinkedHashMap();
        q qVar = this.f13883w;
        qVar.b(new h(qVar));
        this.f13883w.b(new ActivityNavigator(this.f13861a));
        this.C = new ArrayList();
        this.D = LazyKt.b(new Function0<k>() { // from class: androidx.navigation.NavController$navInflater$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final k invoke() {
                k kVar;
                kVar = NavController.this.f13863c;
                return kVar == null ? new k(NavController.this.y(), NavController.this.f13883w) : kVar;
            }
        });
        x0 b11 = d1.b(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this.E = b11;
        this.F = kotlinx.coroutines.flow.d.a(b11);
    }

    private final int B() {
        ArrayDeque v11 = v();
        int i11 = 0;
        if (!(v11 instanceof Collection) || !v11.isEmpty()) {
            Iterator<E> it = v11.iterator();
            while (it.hasNext()) {
                if (!(((NavBackStackEntry) it.next()).f() instanceof NavGraph) && (i11 = i11 + 1) < 0) {
                    CollectionsKt.t();
                }
            }
        }
        return i11;
    }

    private final List H(ArrayDeque arrayDeque) {
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) v().l();
        NavDestination f11 = navBackStackEntry == null ? null : navBackStackEntry.f();
        if (f11 == null) {
            f11 = C();
        }
        if (arrayDeque != null) {
            Iterator<E> it = arrayDeque.iterator();
            while (it.hasNext()) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) it.next();
                NavDestination t11 = t(f11, navBackStackEntryState.getDestinationId());
                if (t11 == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.f13911j.b(y(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + f11).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(y(), t11, D(), this.f13877q));
                f11 = t11;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(NavController this$0, u noName_0, Lifecycle.Event event) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(noName_0, "$noName_0");
        Intrinsics.h(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.g(targetState, "event.targetState");
        this$0.f13879s = targetState;
        if (this$0.f13864d != null) {
            Iterator<E> it = this$0.v().iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).i(event);
            }
        }
    }

    private final void J(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.f13871k.put(navBackStackEntry, navBackStackEntry2);
        if (this.f13872l.get(navBackStackEntry2) == null) {
            this.f13872l.put(navBackStackEntry2, new AtomicInteger(0));
        }
        Object obj = this.f13872l.get(navBackStackEntry2);
        Intrinsics.e(obj);
        ((AtomicInteger) obj).incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0112 A[LOOP:1: B:20:0x010c->B:22:0x0112, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K(final androidx.navigation.NavDestination r21, android.os.Bundle r22, androidx.navigation.l r23, androidx.navigation.Navigator.a r24) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.K(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.l, androidx.navigation.Navigator$a):void");
    }

    private final void L(Navigator navigator, List list, l lVar, Navigator.a aVar, Function1 function1) {
        this.f13885y = function1;
        navigator.e(list, lVar, aVar);
        this.f13885y = null;
    }

    private final void M(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f13865e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String name = it.next();
                q qVar = this.f13883w;
                Intrinsics.g(name, "name");
                Navigator d11 = qVar.d(name);
                Bundle bundle3 = bundle2.getBundle(name);
                if (bundle3 != null) {
                    d11.h(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f13866f;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i11 = 0;
            while (i11 < length) {
                Parcelable parcelable = parcelableArr[i11];
                i11++;
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination s11 = s(navBackStackEntryState.getDestinationId());
                if (s11 == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.f13911j.b(y(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + A());
                }
                NavBackStackEntry instantiate = navBackStackEntryState.instantiate(y(), s11, D(), this.f13877q);
                Navigator d12 = this.f13883w.d(s11.o());
                Map map = this.f13884x;
                Object obj = map.get(d12);
                if (obj == null) {
                    obj = new NavControllerNavigatorState(this, d12);
                    map.put(d12, obj);
                }
                v().add(instantiate);
                ((NavControllerNavigatorState) obj).k(instantiate);
                NavGraph p11 = instantiate.f().p();
                if (p11 != null) {
                    J(instantiate, w(p11.n()));
                }
            }
            i0();
            this.f13866f = null;
        }
        Collection values = this.f13883w.e().values();
        ArrayList<Navigator> arrayList = new ArrayList();
        for (Object obj2 : values) {
            if (!((Navigator) obj2).c()) {
                arrayList.add(obj2);
            }
        }
        for (Navigator navigator : arrayList) {
            Map map2 = this.f13884x;
            Object obj3 = map2.get(navigator);
            if (obj3 == null) {
                obj3 = new NavControllerNavigatorState(this, navigator);
                map2.put(navigator, obj3);
            }
            navigator.f((NavControllerNavigatorState) obj3);
        }
        if (this.f13864d == null || !v().isEmpty()) {
            q();
            return;
        }
        if (!this.f13867g && (activity = this.f13862b) != null) {
            Intrinsics.e(activity);
            if (G(activity.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this.f13864d;
        Intrinsics.e(navGraph);
        K(navGraph, bundle, null, null);
    }

    private final void R(Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z10, Function1 function1) {
        this.f13886z = function1;
        navigator.j(navBackStackEntry, z10);
        this.f13886z = null;
    }

    private final boolean S(int i11, boolean z10, final boolean z11) {
        NavDestination navDestination;
        if (v().isEmpty()) {
            return false;
        }
        ArrayList<Navigator> arrayList = new ArrayList();
        Iterator it = CollectionsKt.D0(v()).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination f11 = ((NavBackStackEntry) it.next()).f();
            Navigator d11 = this.f13883w.d(f11.o());
            if (z10 || f11.n() != i11) {
                arrayList.add(d11);
            }
            if (f11.n() == i11) {
                navDestination = f11;
                break;
            }
        }
        if (navDestination == null) {
            String b11 = NavDestination.f13911j.b(this.f13861a, i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring popBackStack to destination ");
            sb2.append(b11);
            sb2.append(" as it was not found on the current back stack");
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ArrayDeque arrayDeque = new ArrayDeque();
        for (Navigator navigator : arrayList) {
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            R(navigator, (NavBackStackEntry) v().last(), z11, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$popBackStackInternal$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((NavBackStackEntry) obj);
                    return Unit.f67184a;
                }

                public final void invoke(NavBackStackEntry entry) {
                    Intrinsics.h(entry, "entry");
                    Ref.BooleanRef.this.element = true;
                    booleanRef.element = true;
                    this.U(entry, z11, arrayDeque);
                }
            });
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z11) {
            if (!z10) {
                for (NavDestination navDestination2 : SequencesKt.B(SequencesKt.h(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$popBackStackInternal$3
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.h(destination, "destination");
                        NavGraph p11 = destination.p();
                        if (p11 != null && p11.G() == destination.n()) {
                            return destination.p();
                        }
                        return null;
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$popBackStackInternal$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Map map;
                        Intrinsics.h(destination, "destination");
                        map = NavController.this.f13873m;
                        return Boolean.valueOf(!map.containsKey(Integer.valueOf(destination.n())));
                    }
                })) {
                    Map map = this.f13873m;
                    Integer valueOf = Integer.valueOf(navDestination2.n());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.h();
                    map.put(valueOf, navBackStackEntryState == null ? null : navBackStackEntryState.getId());
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                Iterator f67553a = SequencesKt.B(SequencesKt.h(s(navBackStackEntryState2.getDestinationId()), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$popBackStackInternal$6
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.h(destination, "destination");
                        NavGraph p11 = destination.p();
                        if (p11 != null && p11.G() == destination.n()) {
                            return destination.p();
                        }
                        return null;
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$popBackStackInternal$7
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Map map2;
                        Intrinsics.h(destination, "destination");
                        map2 = NavController.this.f13873m;
                        return Boolean.valueOf(!map2.containsKey(Integer.valueOf(destination.n())));
                    }
                }).getF67553a();
                while (f67553a.hasNext()) {
                    this.f13873m.put(Integer.valueOf(((NavDestination) f67553a.next()).n()), navBackStackEntryState2.getId());
                }
                this.f13874n.put(navBackStackEntryState2.getId(), arrayDeque);
            }
        }
        i0();
        return booleanRef.element;
    }

    static /* synthetic */ boolean T(NavController navController, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return navController.S(i11, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(NavBackStackEntry navBackStackEntry, boolean z10, ArrayDeque arrayDeque) {
        f fVar;
        i1 c11;
        Set set;
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) v().last();
        if (!Intrinsics.c(navBackStackEntry2, navBackStackEntry)) {
            throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.f() + ", which is not the top of the back stack (" + navBackStackEntry2.f() + ')').toString());
        }
        v().removeLast();
        NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.f13884x.get(F().d(navBackStackEntry2.f().o()));
        boolean z11 = true;
        if ((navControllerNavigatorState == null || (c11 = navControllerNavigatorState.c()) == null || (set = (Set) c11.getValue()) == null || !set.contains(navBackStackEntry2)) && !this.f13872l.containsKey(navBackStackEntry2)) {
            z11 = false;
        }
        Lifecycle.State b11 = navBackStackEntry2.getLifecycle().b();
        Lifecycle.State state = Lifecycle.State.CREATED;
        if (b11.isAtLeast(state)) {
            if (z10) {
                navBackStackEntry2.l(state);
                arrayDeque.addFirst(new NavBackStackEntryState(navBackStackEntry2));
            }
            if (z11) {
                navBackStackEntry2.l(state);
            } else {
                navBackStackEntry2.l(Lifecycle.State.DESTROYED);
                g0(navBackStackEntry2);
            }
        }
        if (z10 || z11 || (fVar = this.f13877q) == null) {
            return;
        }
        fVar.c(navBackStackEntry2.g());
    }

    static /* synthetic */ void V(NavController navController, NavBackStackEntry navBackStackEntry, boolean z10, ArrayDeque arrayDeque, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navController.U(navBackStackEntry, z10, arrayDeque);
    }

    private final boolean Y(int i11, final Bundle bundle, l lVar, Navigator.a aVar) {
        NavBackStackEntry navBackStackEntry;
        NavDestination f11;
        if (!this.f13873m.containsKey(Integer.valueOf(i11))) {
            return false;
        }
        final String str = (String) this.f13873m.get(Integer.valueOf(i11));
        CollectionsKt.G(this.f13873m.values(), new Function1<String, Boolean>() { // from class: androidx.navigation.NavController$restoreStateInternal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                return Boolean.valueOf(Intrinsics.c(str2, str));
            }
        });
        final List H2 = H((ArrayDeque) this.f13874n.remove(str));
        ArrayList<List> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : H2) {
            if (!(((NavBackStackEntry) obj).f() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt.v0(arrayList);
            String str2 = null;
            if (list != null && (navBackStackEntry = (NavBackStackEntry) CollectionsKt.u0(list)) != null && (f11 = navBackStackEntry.f()) != null) {
                str2 = f11.o();
            }
            if (Intrinsics.c(str2, navBackStackEntry2.f().o())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.q(navBackStackEntry2));
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List list2 : arrayList) {
            Navigator d11 = this.f13883w.d(((NavBackStackEntry) CollectionsKt.i0(list2)).f().o());
            final Ref.IntRef intRef = new Ref.IntRef();
            L(d11, list2, lVar, aVar, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$restoreStateInternal$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((NavBackStackEntry) obj2);
                    return Unit.f67184a;
                }

                public final void invoke(NavBackStackEntry entry) {
                    List<NavBackStackEntry> l11;
                    Intrinsics.h(entry, "entry");
                    Ref.BooleanRef.this.element = true;
                    int indexOf = H2.indexOf(entry);
                    if (indexOf != -1) {
                        int i12 = indexOf + 1;
                        l11 = H2.subList(intRef.element, i12);
                        intRef.element = i12;
                    } else {
                        l11 = CollectionsKt.l();
                    }
                    this.n(entry.f(), bundle, entry, l11);
                }
            });
        }
        return booleanRef.element;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (B() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void i0() {
        /*
            r3 = this;
            androidx.activity.u r0 = r3.f13881u
            boolean r1 = r3.f13882v
            if (r1 == 0) goto Le
            int r1 = r3.B()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.i0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0274, code lost:
    
        ((androidx.navigation.NavController.NavControllerNavigatorState) r2).k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x029d, code lost:
    
        throw new java.lang.IllegalStateException(("NavigatorBackStack for " + r31.o() + " should already be created").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x029e, code lost:
    
        v().addAll(r8);
        v().add(r11);
        r0 = kotlin.collections.CollectionsKt.C0(r8, r11).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02ba, code lost:
    
        if (r0.hasNext() == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02bc, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r0.next();
        r2 = r1.f().p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02ca, code lost:
    
        if (r2 == null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02cc, code lost:
    
        J(r1, w(r2.n()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d8, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01e9, code lost:
    
        r0 = r0.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x017c, code lost:
    
        r14 = ((androidx.navigation.NavBackStackEntry) r8.last()).f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x010d, code lost:
    
        r14 = ((androidx.navigation.NavBackStackEntry) r8.first()).f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00de, code lost:
    
        r10 = r32;
        r11 = r33;
        r12 = r34;
        r13 = r4;
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00a0, code lost:
    
        r19 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x007e, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00e7, code lost:
    
        r10 = r32;
        r11 = r33;
        r13 = r4;
        r8 = r5;
        r19 = r14;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00fc, code lost:
    
        r10 = r32;
        r11 = r33;
        r8 = r5;
        r19 = r14;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        r5 = new kotlin.collections.ArrayDeque();
        r18 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        if ((r31 instanceof androidx.navigation.NavGraph) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        kotlin.jvm.internal.Intrinsics.e(r0);
        r4 = r0.p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        if (r4 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
    
        r0 = r15.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r0.hasPrevious() == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        r1 = r0.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(((androidx.navigation.NavBackStackEntry) r1).f(), r4) == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
    
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        r19 = r14;
        r1 = androidx.navigation.NavBackStackEntry.a.b(androidx.navigation.NavBackStackEntry.f13845n, r30.f13861a, r4, r32, D(), r30.f13877q, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a2, code lost:
    
        r5.addFirst(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ad, code lost:
    
        if (v().isEmpty() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000c, code lost:
    
        if ((r14 instanceof androidx.navigation.b) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bd, code lost:
    
        if (((androidx.navigation.NavBackStackEntry) v().last()).f() != r4) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bf, code lost:
    
        r10 = r32;
        r11 = r33;
        r12 = r34;
        r13 = r4;
        r8 = r5;
        V(r30, (androidx.navigation.NavBackStackEntry) v().last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f0, code lost:
    
        if (r13 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f2, code lost:
    
        if (r13 != r31) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
    
        r5 = r8;
        r15 = r12;
        r0 = r13;
        r14 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0108, code lost:
    
        if (r8.isEmpty() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010a, code lost:
    
        r14 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0117, code lost:
    
        if (r14 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0121, code lost:
    
        if (s(r14.n()) != null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0123, code lost:
    
        r14 = r14.p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0127, code lost:
    
        if (r14 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0129, code lost:
    
        r0 = r12.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0135, code lost:
    
        if (r0.hasPrevious() == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0137, code lost:
    
        r1 = r0.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (v().isEmpty() != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0146, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(((androidx.navigation.NavBackStackEntry) r1).f(), r14) == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014b, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x014d, code lost:
    
        if (r1 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014f, code lost:
    
        r1 = androidx.navigation.NavBackStackEntry.a.b(androidx.navigation.NavBackStackEntry.f13845n, r30.f13861a, r14, r14.f(r10), D(), r30.f13877q, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016f, code lost:
    
        r8.addFirst(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0149, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0177, code lost:
    
        if (r8.isEmpty() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0179, code lost:
    
        r14 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018e, code lost:
    
        if (v().isEmpty() != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if ((((androidx.navigation.NavBackStackEntry) v().last()).f() instanceof androidx.navigation.b) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a0, code lost:
    
        if ((((androidx.navigation.NavBackStackEntry) v().last()).f() instanceof androidx.navigation.NavGraph) == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01bb, code lost:
    
        if (((androidx.navigation.NavGraph) ((androidx.navigation.NavBackStackEntry) v().last()).f()).B(r14.n(), false) != null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bd, code lost:
    
        V(r30, (androidx.navigation.NavBackStackEntry) v().last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01d2, code lost:
    
        r0 = (androidx.navigation.NavBackStackEntry) v().h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01dc, code lost:
    
        if (r0 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01de, code lost:
    
        r0 = (androidx.navigation.NavBackStackEntry) r8.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e4, code lost:
    
        if (r0 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e6, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f3, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r0, r30.f13864d) != false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01f5, code lost:
    
        r0 = r12.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0201, code lost:
    
        if (r0.hasPrevious() == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0203, code lost:
    
        r1 = r0.previous();
        r2 = ((androidx.navigation.NavBackStackEntry) r1).f();
        r3 = r30.f13864d;
        kotlin.jvm.internal.Intrinsics.e(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0217, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r2, r3) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0219, code lost:
    
        r18 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x021b, code lost:
    
        r18 = (androidx.navigation.NavBackStackEntry) r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0046, code lost:
    
        if (T(r30, ((androidx.navigation.NavBackStackEntry) v().last()).f().n(), true, false, 4, null) == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x021d, code lost:
    
        if (r18 != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x021f, code lost:
    
        r19 = androidx.navigation.NavBackStackEntry.f13845n;
        r0 = r30.f13861a;
        r1 = r30.f13864d;
        kotlin.jvm.internal.Intrinsics.e(r1);
        r2 = r30.f13864d;
        kotlin.jvm.internal.Intrinsics.e(r2);
        r18 = androidx.navigation.NavBackStackEntry.a.b(r19, r0, r1, r2.f(r10), D(), r30.f13877q, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0249, code lost:
    
        r8.addFirst(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x024e, code lost:
    
        r0 = r8.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0256, code lost:
    
        if (r0.hasNext() == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0258, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r0.next();
        r2 = r30.f13884x.get(r30.f13883w.d(r1.f().o()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0272, code lost:
    
        if (r2 == null) goto L129;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(androidx.navigation.NavDestination r31, android.os.Bundle r32, androidx.navigation.NavBackStackEntry r33, java.util.List r34) {
        /*
            Method dump skipped, instructions count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.n(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavBackStackEntry, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i11 & 8) != 0) {
            list = CollectionsKt.l();
        }
        navController.n(navDestination, bundle, navBackStackEntry, list);
    }

    private final boolean p(int i11) {
        Iterator it = this.f13884x.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).i(true);
        }
        boolean Y = Y(i11, null, null, null);
        Iterator it2 = this.f13884x.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).i(false);
        }
        return Y && S(i11, true, false);
    }

    private final boolean q() {
        while (!v().isEmpty() && (((NavBackStackEntry) v().last()).f() instanceof NavGraph)) {
            V(this, (NavBackStackEntry) v().last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) v().l();
        if (navBackStackEntry != null) {
            this.C.add(navBackStackEntry);
        }
        this.B++;
        h0();
        int i11 = this.B - 1;
        this.B = i11;
        if (i11 == 0) {
            List<NavBackStackEntry> U0 = CollectionsKt.U0(this.C);
            this.C.clear();
            for (NavBackStackEntry navBackStackEntry2 : U0) {
                Iterator it = this.f13878r.iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(it.next());
                    navBackStackEntry2.f();
                    navBackStackEntry2.d();
                    throw null;
                }
                this.E.b(navBackStackEntry2);
            }
            this.f13869i.b(W());
        }
        return navBackStackEntry != null;
    }

    private final NavDestination t(NavDestination navDestination, int i11) {
        NavGraph p11;
        if (navDestination.n() == i11) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            p11 = (NavGraph) navDestination;
        } else {
            p11 = navDestination.p();
            Intrinsics.e(p11);
        }
        return p11.A(i11);
    }

    private final String u(int[] iArr) {
        NavGraph navGraph = this.f13864d;
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i11 >= length) {
                return null;
            }
            int i12 = i11 + 1;
            int i13 = iArr[i11];
            if (i11 == 0) {
                NavGraph navGraph2 = this.f13864d;
                Intrinsics.e(navGraph2);
                if (navGraph2.n() == i13) {
                    navDestination = this.f13864d;
                }
            } else {
                Intrinsics.e(navGraph);
                navDestination = navGraph.A(i13);
            }
            if (navDestination == null) {
                return NavDestination.f13911j.b(this.f13861a, i13);
            }
            if (i11 != iArr.length - 1 && (navDestination instanceof NavGraph)) {
                navGraph = (NavGraph) navDestination;
                while (true) {
                    Intrinsics.e(navGraph);
                    if (navGraph.A(navGraph.G()) instanceof NavGraph) {
                        navGraph = (NavGraph) navGraph.A(navGraph.G());
                    }
                }
            }
            i11 = i12;
        }
    }

    public NavDestination A() {
        NavBackStackEntry z10 = z();
        if (z10 == null) {
            return null;
        }
        return z10.f();
    }

    public NavGraph C() {
        NavGraph navGraph = this.f13864d;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        if (navGraph != null) {
            return navGraph;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
    }

    public final Lifecycle.State D() {
        return this.f13875o == null ? Lifecycle.State.CREATED : this.f13879s;
    }

    public k E() {
        return (k) this.D.getValue();
    }

    public q F() {
        return this.f13883w;
    }

    public boolean G(Intent intent) {
        int[] iArr;
        NavDestination A;
        Bundle bundle;
        int i11 = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras == null ? null : extras.getIntArray("android-support-nav:controller:deepLinkIds");
        ArrayList parcelableArrayList = extras == null ? null : extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = extras == null ? null : extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        if (intArray == null || intArray.length == 0) {
            NavGraph navGraph = this.f13864d;
            Intrinsics.e(navGraph);
            NavDestination.a r11 = navGraph.r(new g(intent));
            if (r11 != null) {
                NavDestination b11 = r11.b();
                int[] j11 = NavDestination.j(b11, null, 1, null);
                Bundle f11 = b11.f(r11.d());
                if (f11 != null) {
                    bundle2.putAll(f11);
                }
                iArr = j11;
                parcelableArrayList = null;
                if (iArr != null || iArr.length == 0) {
                    return false;
                }
                String u11 = u(iArr);
                if (u11 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not find destination ");
                    sb2.append((Object) u11);
                    sb2.append(" in the navigation graph, ignoring the deep link from ");
                    sb2.append(intent);
                    return false;
                }
                bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                int length = iArr.length;
                Bundle[] bundleArr = new Bundle[length];
                int i12 = 0;
                while (i12 < length) {
                    int i13 = i12 + 1;
                    Bundle bundle4 = new Bundle();
                    bundle4.putAll(bundle2);
                    if (parcelableArrayList != null && (bundle = (Bundle) parcelableArrayList.get(i12)) != null) {
                        bundle4.putAll(bundle);
                    }
                    bundleArr[i12] = bundle4;
                    i12 = i13;
                }
                int flags = intent.getFlags();
                int i14 = 268435456 & flags;
                if (i14 != 0 && (flags & 32768) == 0) {
                    intent.addFlags(32768);
                    b0 b12 = b0.f(this.f13861a).b(intent);
                    Intrinsics.g(b12, "create(context)\n        …ntWithParentStack(intent)");
                    b12.g();
                    Activity activity = this.f13862b;
                    if (activity != null) {
                        activity.finish();
                        activity.overridePendingTransition(0, 0);
                    }
                    return true;
                }
                if (i14 != 0) {
                    if (!v().isEmpty()) {
                        NavGraph navGraph2 = this.f13864d;
                        Intrinsics.e(navGraph2);
                        T(this, navGraph2.n(), true, false, 4, null);
                    }
                    while (i11 < iArr.length) {
                        int i15 = iArr[i11];
                        int i16 = i11 + 1;
                        Bundle bundle5 = bundleArr[i11];
                        final NavDestination s11 = s(i15);
                        if (s11 == null) {
                            throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f13911j.b(this.f13861a, i15) + " cannot be found from the current destination " + A());
                        }
                        K(s11, bundle5, n.a(new Function1<m, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((m) obj);
                                return Unit.f67184a;
                            }

                            public final void invoke(m navOptions) {
                                boolean z10;
                                Intrinsics.h(navOptions, "$this$navOptions");
                                navOptions.a(new Function1<a, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((a) obj);
                                        return Unit.f67184a;
                                    }

                                    public final void invoke(a anim) {
                                        Intrinsics.h(anim, "$this$anim");
                                        anim.e(0);
                                        anim.f(0);
                                    }
                                });
                                NavDestination navDestination = NavDestination.this;
                                if (navDestination instanceof NavGraph) {
                                    Sequence<NavDestination> c11 = NavDestination.f13911j.c(navDestination);
                                    NavController navController = this;
                                    for (NavDestination navDestination2 : c11) {
                                        NavDestination A2 = navController.A();
                                        if (Intrinsics.c(navDestination2, A2 == null ? null : A2.p())) {
                                            return;
                                        }
                                    }
                                    z10 = NavController.H;
                                    if (z10) {
                                        navOptions.g(NavGraph.f13927p.a(this.C()).n(), new Function1<s, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((s) obj);
                                                return Unit.f67184a;
                                            }

                                            public final void invoke(s popUpTo) {
                                                Intrinsics.h(popUpTo, "$this$popUpTo");
                                                popUpTo.c(true);
                                            }
                                        });
                                    }
                                }
                            }
                        }), null);
                        i11 = i16;
                    }
                    return true;
                }
                NavGraph navGraph3 = this.f13864d;
                int length2 = iArr.length;
                int i17 = 0;
                while (i17 < length2) {
                    int i18 = i17 + 1;
                    int i19 = iArr[i17];
                    Bundle bundle6 = bundleArr[i17];
                    if (i17 == 0) {
                        A = this.f13864d;
                    } else {
                        Intrinsics.e(navGraph3);
                        A = navGraph3.A(i19);
                    }
                    if (A == null) {
                        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f13911j.b(this.f13861a, i19) + " cannot be found in graph " + navGraph3);
                    }
                    if (i17 == iArr.length - 1) {
                        l.a aVar = new l.a();
                        NavGraph navGraph4 = this.f13864d;
                        Intrinsics.e(navGraph4);
                        K(A, bundle6, l.a.i(aVar, navGraph4.n(), true, false, 4, null).b(0).c(0).a(), null);
                    } else if (A instanceof NavGraph) {
                        navGraph3 = (NavGraph) A;
                        while (true) {
                            Intrinsics.e(navGraph3);
                            if (navGraph3.A(navGraph3.G()) instanceof NavGraph) {
                                navGraph3 = (NavGraph) navGraph3.A(navGraph3.G());
                            }
                        }
                    }
                    i17 = i18;
                }
                this.f13867g = true;
                return true;
            }
        }
        iArr = intArray;
        if (iArr != null) {
        }
        return false;
    }

    public boolean N() {
        if (v().isEmpty()) {
            return false;
        }
        NavDestination A = A();
        Intrinsics.e(A);
        return O(A.n(), true);
    }

    public boolean O(int i11, boolean z10) {
        return P(i11, z10, false);
    }

    public boolean P(int i11, boolean z10, boolean z11) {
        return S(i11, z10, z11) && q();
    }

    public final void Q(NavBackStackEntry popUpTo, Function0 onComplete) {
        Intrinsics.h(popUpTo, "popUpTo");
        Intrinsics.h(onComplete, "onComplete");
        int indexOf = v().indexOf(popUpTo);
        if (indexOf < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring pop of ");
            sb2.append(popUpTo);
            sb2.append(" as it was not found on the current back stack");
            return;
        }
        int i11 = indexOf + 1;
        if (i11 != v().size()) {
            S(((NavBackStackEntry) v().get(i11)).f().n(), true, false);
        }
        V(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        i0();
        q();
    }

    public final List W() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f13884x.values().iterator();
        while (it.hasNext()) {
            Iterable iterable = (Iterable) ((NavControllerNavigatorState) it.next()).c().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : iterable) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt.B(arrayList, arrayList2);
        }
        ArrayDeque v11 = v();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : v11) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(obj2);
            }
        }
        CollectionsKt.B(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (!(((NavBackStackEntry) obj3).f() instanceof NavGraph)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public void X(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.f13861a.getClassLoader());
        this.f13865e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f13866f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.f13874n.clear();
        int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = intArray[i11];
                i11++;
                this.f13873m.put(Integer.valueOf(i13), stringArrayList.get(i12));
                i12++;
            }
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
        if (stringArrayList2 != null) {
            for (String id2 : stringArrayList2) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(Intrinsics.q("android-support-nav:controller:backStackStates:", id2));
                if (parcelableArray != null) {
                    Map map = this.f13874n;
                    Intrinsics.g(id2, "id");
                    ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                    Iterator a11 = ArrayIteratorKt.a(parcelableArray);
                    while (a11.hasNext()) {
                        Parcelable parcelable = (Parcelable) a11.next();
                        if (parcelable == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        }
                        arrayDeque.add((NavBackStackEntryState) parcelable);
                    }
                    Unit unit = Unit.f67184a;
                    map.put(id2, arrayDeque);
                }
            }
        }
        this.f13867g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public Bundle Z() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.f13883w.e().entrySet()) {
            String str = (String) entry.getKey();
            Bundle i11 = ((Navigator) entry.getValue()).i();
            if (i11 != null) {
                arrayList.add(str);
                bundle2.putBundle(str, i11);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        }
        if (!v().isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[v().size()];
            Iterator<E> it = v().iterator();
            int i12 = 0;
            while (it.hasNext()) {
                parcelableArr[i12] = new NavBackStackEntryState((NavBackStackEntry) it.next());
                i12++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (!this.f13873m.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.f13873m.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i13 = 0;
            for (Map.Entry entry2 : this.f13873m.entrySet()) {
                int intValue = ((Number) entry2.getKey()).intValue();
                String str2 = (String) entry2.getValue();
                iArr[i13] = intValue;
                arrayList2.add(str2);
                i13++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if (!this.f13874n.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry entry3 : this.f13874n.entrySet()) {
                String str3 = (String) entry3.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) entry3.getValue();
                arrayList3.add(str3);
                Parcelable[] parcelableArr2 = new Parcelable[arrayDeque.size()];
                int i14 = 0;
                for (Object obj : arrayDeque) {
                    int i15 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.u();
                    }
                    parcelableArr2[i14] = (NavBackStackEntryState) obj;
                    i14 = i15;
                }
                bundle.putParcelableArray(Intrinsics.q("android-support-nav:controller:backStackStates:", str3), parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (this.f13867g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.f13867g);
        }
        return bundle;
    }

    public void a0(int i11) {
        c0(E().b(i11), null);
    }

    public void b0(int i11, Bundle bundle) {
        c0(E().b(i11), bundle);
    }

    public void c0(NavGraph graph, Bundle bundle) {
        Intrinsics.h(graph, "graph");
        if (!Intrinsics.c(this.f13864d, graph)) {
            NavGraph navGraph = this.f13864d;
            if (navGraph != null) {
                for (Integer id2 : new ArrayList(this.f13873m.keySet())) {
                    Intrinsics.g(id2, "id");
                    p(id2.intValue());
                }
                T(this, navGraph.n(), true, false, 4, null);
            }
            this.f13864d = graph;
            M(bundle);
            return;
        }
        int p11 = graph.E().p();
        int i11 = 0;
        while (i11 < p11) {
            int i12 = i11 + 1;
            NavDestination newDestination = (NavDestination) graph.E().q(i11);
            NavGraph navGraph2 = this.f13864d;
            Intrinsics.e(navGraph2);
            navGraph2.E().o(i11, newDestination);
            ArrayDeque v11 = v();
            ArrayList<NavBackStackEntry> arrayList = new ArrayList();
            for (Object obj : v11) {
                int n11 = ((NavBackStackEntry) obj).f().n();
                if (newDestination != null && n11 == newDestination.n()) {
                    arrayList.add(obj);
                }
            }
            for (NavBackStackEntry navBackStackEntry : arrayList) {
                Intrinsics.g(newDestination, "newDestination");
                navBackStackEntry.k(newDestination);
            }
            i11 = i12;
        }
    }

    public void d0(u owner) {
        Lifecycle lifecycle;
        Intrinsics.h(owner, "owner");
        if (Intrinsics.c(owner, this.f13875o)) {
            return;
        }
        u uVar = this.f13875o;
        if (uVar != null && (lifecycle = uVar.getLifecycle()) != null) {
            lifecycle.d(this.f13880t);
        }
        this.f13875o = owner;
        owner.getLifecycle().a(this.f13880t);
    }

    public void e0(OnBackPressedDispatcher dispatcher) {
        Intrinsics.h(dispatcher, "dispatcher");
        if (Intrinsics.c(dispatcher, this.f13876p)) {
            return;
        }
        u uVar = this.f13875o;
        if (uVar == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.f13881u.remove();
        this.f13876p = dispatcher;
        dispatcher.i(uVar, this.f13881u);
        Lifecycle lifecycle = uVar.getLifecycle();
        lifecycle.d(this.f13880t);
        lifecycle.a(this.f13880t);
    }

    public void f0(androidx.view.x0 viewModelStore) {
        Intrinsics.h(viewModelStore, "viewModelStore");
        f fVar = this.f13877q;
        f.b bVar = f.f13954b;
        if (Intrinsics.c(fVar, bVar.a(viewModelStore))) {
            return;
        }
        if (!v().isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.f13877q = bVar.a(viewModelStore);
    }

    public final NavBackStackEntry g0(NavBackStackEntry child) {
        Intrinsics.h(child, "child");
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f13871k.remove(child);
        if (navBackStackEntry == null) {
            return null;
        }
        AtomicInteger atomicInteger = (AtomicInteger) this.f13872l.get(navBackStackEntry);
        Integer valueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.f13884x.get(this.f13883w.d(navBackStackEntry.f().o()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.e(navBackStackEntry);
            }
            this.f13872l.remove(navBackStackEntry);
        }
        return navBackStackEntry;
    }

    public final void h0() {
        NavDestination navDestination;
        i1 c11;
        Set set;
        AtomicInteger atomicInteger;
        List<NavBackStackEntry> U0 = CollectionsKt.U0(v());
        if (U0.isEmpty()) {
            return;
        }
        NavDestination f11 = ((NavBackStackEntry) CollectionsKt.u0(U0)).f();
        if (f11 instanceof androidx.navigation.b) {
            Iterator it = CollectionsKt.D0(U0).iterator();
            while (it.hasNext()) {
                navDestination = ((NavBackStackEntry) it.next()).f();
                if (!(navDestination instanceof NavGraph) && !(navDestination instanceof androidx.navigation.b)) {
                    break;
                }
            }
        }
        navDestination = null;
        HashMap hashMap = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.D0(U0)) {
            Lifecycle.State h11 = navBackStackEntry.h();
            NavDestination f12 = navBackStackEntry.f();
            if (f11 != null && f12.n() == f11.n()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (h11 != state) {
                    NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.f13884x.get(F().d(navBackStackEntry.f().o()));
                    if (Intrinsics.c((navControllerNavigatorState == null || (c11 = navControllerNavigatorState.c()) == null || (set = (Set) c11.getValue()) == null) ? null : Boolean.valueOf(set.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInteger = (AtomicInteger) this.f13872l.get(navBackStackEntry)) != null && atomicInteger.get() == 0)) {
                        hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                    } else {
                        hashMap.put(navBackStackEntry, state);
                    }
                }
                f11 = f11.p();
            } else if (navDestination == null || f12.n() != navDestination.n()) {
                navBackStackEntry.l(Lifecycle.State.CREATED);
            } else {
                if (h11 == Lifecycle.State.RESUMED) {
                    navBackStackEntry.l(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (h11 != state2) {
                        hashMap.put(navBackStackEntry, state2);
                    }
                }
                navDestination = navDestination.p();
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : U0) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.l(state3);
            } else {
                navBackStackEntry2.m();
            }
        }
    }

    public void r(boolean z10) {
        this.f13882v = z10;
        i0();
    }

    public final NavDestination s(int i11) {
        NavGraph navGraph = this.f13864d;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.e(navGraph);
        if (navGraph.n() == i11) {
            return this.f13864d;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) v().l();
        NavDestination f11 = navBackStackEntry != null ? navBackStackEntry.f() : null;
        if (f11 == null) {
            f11 = this.f13864d;
            Intrinsics.e(f11);
        }
        return t(f11, i11);
    }

    public ArrayDeque v() {
        return this.f13868h;
    }

    public NavBackStackEntry w(int i11) {
        Object obj;
        ArrayDeque v11 = v();
        ListIterator<E> listIterator = v11.listIterator(v11.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((NavBackStackEntry) obj).f().n() == i11) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + i11 + " is on the NavController's back stack. The current destination is " + A()).toString());
    }

    public final NavBackStackEntry x(String route) {
        Object obj;
        Intrinsics.h(route, "route");
        ArrayDeque v11 = v();
        ListIterator<E> listIterator = v11.listIterator(v11.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (Intrinsics.c(((NavBackStackEntry) obj).f().q(), route)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + A()).toString());
    }

    public final Context y() {
        return this.f13861a;
    }

    public NavBackStackEntry z() {
        return (NavBackStackEntry) v().l();
    }
}
