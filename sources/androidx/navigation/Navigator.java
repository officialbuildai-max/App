package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
public abstract class Navigator {

    /* renamed from: a, reason: collision with root package name */
    private r f13936a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f13937b;

    /* loaded from: classes2.dex */
    public interface a {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface b {
        String value();
    }

    public abstract NavDestination a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final r b() {
        r rVar = this.f13936a;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    public final boolean c() {
        return this.f13937b;
    }

    public NavDestination d(NavDestination destination, Bundle bundle, l lVar, a aVar) {
        Intrinsics.h(destination, "destination");
        return destination;
    }

    public void e(List entries, final l lVar, final a aVar) {
        Intrinsics.h(entries, "entries");
        Iterator f67553a = SequencesKt.r(SequencesKt.y(CollectionsKt.Z(entries), new Function1<NavBackStackEntry, NavBackStackEntry>(lVar, aVar) { // from class: androidx.navigation.Navigator$navigate$1
            final /* synthetic */ l $navOptions;
            final /* synthetic */ Navigator.a $navigatorExtras;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavBackStackEntry invoke(NavBackStackEntry backStackEntry) {
                NavDestination d11;
                Intrinsics.h(backStackEntry, "backStackEntry");
                NavDestination f11 = backStackEntry.f();
                if (!(f11 instanceof NavDestination)) {
                    f11 = null;
                }
                if (f11 != null && (d11 = Navigator.this.d(f11, backStackEntry.d(), this.$navOptions, null)) != null) {
                    return Intrinsics.c(d11, f11) ? backStackEntry : Navigator.this.b().a(d11, d11.f(backStackEntry.d()));
                }
                return null;
            }
        })).getF67553a();
        while (f67553a.hasNext()) {
            b().h((NavBackStackEntry) f67553a.next());
        }
    }

    public void f(r state) {
        Intrinsics.h(state, "state");
        this.f13936a = state;
        this.f13937b = true;
    }

    public void g(NavBackStackEntry backStackEntry) {
        Intrinsics.h(backStackEntry, "backStackEntry");
        NavDestination f11 = backStackEntry.f();
        if (!(f11 instanceof NavDestination)) {
            f11 = null;
        }
        if (f11 == null) {
            return;
        }
        d(f11, null, n.a(new Function1<m, Unit>() { // from class: androidx.navigation.Navigator$onLaunchSingleTop$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((m) obj);
                return Unit.f67184a;
            }

            public final void invoke(m navOptions) {
                Intrinsics.h(navOptions, "$this$navOptions");
                navOptions.h(true);
            }
        }), null);
        b().f(backStackEntry);
    }

    public void h(Bundle savedState) {
        Intrinsics.h(savedState, "savedState");
    }

    public Bundle i() {
        return null;
    }

    public void j(NavBackStackEntry popUpTo, boolean z10) {
        Intrinsics.h(popUpTo, "popUpTo");
        List list = (List) b().b().getValue();
        if (!list.contains(popUpTo)) {
            throw new IllegalStateException(("popBackStack was called with " + popUpTo + " which does not exist in back stack " + list).toString());
        }
        ListIterator listIterator = list.listIterator(list.size());
        NavBackStackEntry navBackStackEntry = null;
        while (k()) {
            navBackStackEntry = (NavBackStackEntry) listIterator.previous();
            if (Intrinsics.c(navBackStackEntry, popUpTo)) {
                break;
            }
        }
        if (navBackStackEntry != null) {
            b().g(navBackStackEntry, z10);
        }
    }

    public boolean k() {
        return true;
    }
}
