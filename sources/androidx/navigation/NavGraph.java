package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.a1;
import androidx.collection.y0;
import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable, KMappedMarker {

    /* renamed from: p, reason: collision with root package name */
    public static final Companion f13927p = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    private final y0 f13928l;

    /* renamed from: m, reason: collision with root package name */
    private int f13929m;

    /* renamed from: n, reason: collision with root package name */
    private String f13930n;

    /* renamed from: o, reason: collision with root package name */
    private String f13931o;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDestination a(NavGraph navGraph) {
            Intrinsics.h(navGraph, "<this>");
            return (NavDestination) SequencesKt.x(SequencesKt.h(navGraph.A(navGraph.G()), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavGraph$Companion$findStartDestination$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.h(it, "it");
                    if (!(it instanceof NavGraph)) {
                        return null;
                    }
                    NavGraph navGraph2 = (NavGraph) it;
                    return navGraph2.A(navGraph2.G());
                }
            }));
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements Iterator, KMutableIterator {

        /* renamed from: a, reason: collision with root package name */
        private int f13932a = -1;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13933b;

        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavDestination next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f13933b = true;
            y0 E = NavGraph.this.E();
            int i11 = this.f13932a + 1;
            this.f13932a = i11;
            Object q11 = E.q(i11);
            Intrinsics.g(q11, "nodes.valueAt(++index)");
            return (NavDestination) q11;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13932a + 1 < NavGraph.this.E().p();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f13933b) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            y0 E = NavGraph.this.E();
            ((NavDestination) E.q(this.f13932a)).w(null);
            E.n(this.f13932a);
            this.f13932a--;
            this.f13933b = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator navGraphNavigator) {
        super(navGraphNavigator);
        Intrinsics.h(navGraphNavigator, "navGraphNavigator");
        this.f13928l = new y0();
    }

    private final void I(int i11) {
        if (i11 != n()) {
            if (this.f13931o != null) {
                J(null);
            }
            this.f13929m = i11;
            this.f13930n = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i11 + " cannot use the same id as the graph " + this).toString());
    }

    private final void J(String str) {
        int hashCode;
        if (str == null) {
            hashCode = 0;
        } else {
            if (Intrinsics.c(str, q())) {
                throw new IllegalArgumentException(("Start destination " + ((Object) str) + " cannot use the same route as the graph " + this).toString());
            }
            if (StringsKt.q0(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            hashCode = NavDestination.f13911j.a(str).hashCode();
        }
        this.f13929m = hashCode;
        this.f13931o = str;
    }

    public final NavDestination A(int i11) {
        return B(i11, true);
    }

    public final NavDestination B(int i11, boolean z10) {
        NavDestination navDestination = (NavDestination) this.f13928l.f(i11);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z10 || p() == null) {
            return null;
        }
        NavGraph p11 = p();
        Intrinsics.e(p11);
        return p11.A(i11);
    }

    public final NavDestination C(String str) {
        if (str == null || StringsKt.q0(str)) {
            return null;
        }
        return D(str, true);
    }

    public final NavDestination D(String route, boolean z10) {
        Intrinsics.h(route, "route");
        NavDestination navDestination = (NavDestination) this.f13928l.f(NavDestination.f13911j.a(route).hashCode());
        if (navDestination != null) {
            return navDestination;
        }
        if (!z10 || p() == null) {
            return null;
        }
        NavGraph p11 = p();
        Intrinsics.e(p11);
        return p11.C(route);
    }

    public final y0 E() {
        return this.f13928l;
    }

    public final String F() {
        if (this.f13930n == null) {
            String str = this.f13931o;
            if (str == null) {
                str = String.valueOf(this.f13929m);
            }
            this.f13930n = str;
        }
        String str2 = this.f13930n;
        Intrinsics.e(str2);
        return str2;
    }

    public final int G() {
        return this.f13929m;
    }

    public final String H() {
        return this.f13931o;
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavGraph)) {
            return false;
        }
        List E = SequencesKt.E(SequencesKt.e(a1.a(this.f13928l)));
        NavGraph navGraph = (NavGraph) obj;
        Iterator a11 = a1.a(navGraph.f13928l);
        while (a11.hasNext()) {
            E.remove((NavDestination) a11.next());
        }
        return super.equals(obj) && this.f13928l.p() == navGraph.f13928l.p() && G() == navGraph.G() && E.isEmpty();
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int G = G();
        y0 y0Var = this.f13928l;
        int p11 = y0Var.p();
        for (int i11 = 0; i11 < p11; i11++) {
            G = (((G * 31) + y0Var.k(i11)) * 31) + ((NavDestination) y0Var.q(i11)).hashCode();
        }
        return G;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a();
    }

    @Override // androidx.navigation.NavDestination
    public String m() {
        return n() != 0 ? super.m() : "the root navigation";
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.a r(g navDeepLinkRequest) {
        Intrinsics.h(navDeepLinkRequest, "navDeepLinkRequest");
        NavDestination.a r11 = super.r(navDeepLinkRequest);
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            NavDestination.a r12 = ((NavDestination) it.next()).r(navDeepLinkRequest);
            if (r12 != null) {
                arrayList.add(r12);
            }
        }
        return (NavDestination.a) CollectionsKt.w0(CollectionsKt.p(r11, (NavDestination.a) CollectionsKt.w0(arrayList)));
    }

    @Override // androidx.navigation.NavDestination
    public void s(Context context, AttributeSet attrs) {
        Intrinsics.h(context, "context");
        Intrinsics.h(attrs, "attrs");
        super.s(context, attrs);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R$styleable.NavGraphNavigator);
        Intrinsics.g(obtainAttributes, "context.resources.obtain…vGraphNavigator\n        )");
        I(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.NavGraphNavigator_startDestination, 0));
        this.f13930n = NavDestination.f13911j.b(context, this.f13929m);
        Unit unit = Unit.f67184a;
        obtainAttributes.recycle();
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        NavDestination C = C(this.f13931o);
        if (C == null) {
            C = A(G());
        }
        sb2.append(" startDestination=");
        if (C == null) {
            String str = this.f13931o;
            if (str != null) {
                sb2.append(str);
            } else {
                String str2 = this.f13930n;
                if (str2 != null) {
                    sb2.append(str2);
                } else {
                    sb2.append(Intrinsics.q("0x", Integer.toHexString(this.f13929m)));
                }
            }
        } else {
            sb2.append("{");
            sb2.append(C.toString());
            sb2.append("}");
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "sb.toString()");
        return sb3;
    }

    public final void z(NavDestination node) {
        Intrinsics.h(node, "node");
        int n11 = node.n();
        String q11 = node.q();
        if (n11 == 0 && q11 == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (q() != null && Intrinsics.c(q11, q())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this).toString());
        }
        if (n11 == n()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this).toString());
        }
        NavDestination navDestination = (NavDestination) this.f13928l.f(n11);
        if (navDestination == node) {
            return;
        }
        if (node.p() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination != null) {
            navDestination.w(null);
        }
        node.w(this);
        this.f13928l.l(node.n(), node);
    }
}
