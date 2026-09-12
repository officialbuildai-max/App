package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.a1;
import androidx.collection.y0;
import androidx.navigation.NavDeepLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public abstract class NavDestination {

    /* renamed from: j, reason: collision with root package name */
    public static final Companion f13911j = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    private static final Map f13912k = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final String f13913a;

    /* renamed from: b, reason: collision with root package name */
    private NavGraph f13914b;

    /* renamed from: c, reason: collision with root package name */
    private String f13915c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f13916d;

    /* renamed from: e, reason: collision with root package name */
    private final List f13917e;

    /* renamed from: f, reason: collision with root package name */
    private final y0 f13918f;

    /* renamed from: g, reason: collision with root package name */
    private Map f13919g;

    /* renamed from: h, reason: collision with root package name */
    private int f13920h;

    /* renamed from: i, reason: collision with root package name */
    private String f13921i;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            return str != null ? Intrinsics.q("android-app://androidx.navigation/", str) : "";
        }

        public final String b(Context context, int i11) {
            String valueOf;
            Intrinsics.h(context, "context");
            if (i11 <= 16777215) {
                return String.valueOf(i11);
            }
            try {
                valueOf = context.getResources().getResourceName(i11);
            } catch (Resources.NotFoundException unused) {
                valueOf = String.valueOf(i11);
            }
            Intrinsics.g(valueOf, "try {\n                co….toString()\n            }");
            return valueOf;
        }

        public final Sequence c(NavDestination navDestination) {
            Intrinsics.h(navDestination, "<this>");
            return SequencesKt.h(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavDestination$Companion$hierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.h(it, "it");
                    return it.p();
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final NavDestination f13922a;

        /* renamed from: b, reason: collision with root package name */
        private final Bundle f13923b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f13924c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f13925d;

        /* renamed from: e, reason: collision with root package name */
        private final int f13926e;

        public a(NavDestination destination, Bundle bundle, boolean z10, boolean z11, int i11) {
            Intrinsics.h(destination, "destination");
            this.f13922a = destination;
            this.f13923b = bundle;
            this.f13924c = z10;
            this.f13925d = z11;
            this.f13926e = i11;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a other) {
            Intrinsics.h(other, "other");
            boolean z10 = this.f13924c;
            if (z10 && !other.f13924c) {
                return 1;
            }
            if (!z10 && other.f13924c) {
                return -1;
            }
            Bundle bundle = this.f13923b;
            if (bundle != null && other.f13923b == null) {
                return 1;
            }
            if (bundle == null && other.f13923b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = other.f13923b;
                Intrinsics.e(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z11 = this.f13925d;
            if (z11 && !other.f13925d) {
                return 1;
            }
            if (z11 || !other.f13925d) {
                return this.f13926e - other.f13926e;
            }
            return -1;
        }

        public final NavDestination b() {
            return this.f13922a;
        }

        public final Bundle d() {
            return this.f13923b;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestination(Navigator navigator) {
        this(q.f14037b.a(navigator.getClass()));
        Intrinsics.h(navigator, "navigator");
    }

    public NavDestination(String navigatorName) {
        Intrinsics.h(navigatorName, "navigatorName");
        this.f13913a = navigatorName;
        this.f13917e = new ArrayList();
        this.f13918f = new y0();
        this.f13919g = new LinkedHashMap();
    }

    public static /* synthetic */ int[] j(NavDestination navDestination, NavDestination navDestination2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i11 & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.h(navDestination2);
    }

    public final void a(String argumentName, d argument) {
        Intrinsics.h(argumentName, "argumentName");
        Intrinsics.h(argument, "argument");
        this.f13919g.put(argumentName, argument);
    }

    public final void c(NavDeepLink navDeepLink) {
        Intrinsics.h(navDeepLink, "navDeepLink");
        Map l11 = l();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : l11.entrySet()) {
            d dVar = (d) entry.getValue();
            if (!dVar.c() && !dVar.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (!navDeepLink.e().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            this.f13917e.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + ((Object) navDeepLink.k()) + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + arrayList).toString());
    }

    public final void e(String uriPattern) {
        Intrinsics.h(uriPattern, "uriPattern");
        c(new NavDeepLink.a().d(uriPattern).a());
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (obj == null || !(obj instanceof NavDestination)) {
            return false;
        }
        NavDestination navDestination = (NavDestination) obj;
        boolean z12 = CollectionsKt.o0(this.f13917e, navDestination.f13917e).size() == this.f13917e.size();
        if (this.f13918f.p() == navDestination.f13918f.p()) {
            Iterator f67553a = SequencesKt.e(a1.a(this.f13918f)).getF67553a();
            while (true) {
                if (f67553a.hasNext()) {
                    if (!navDestination.f13918f.e((c) f67553a.next())) {
                        break;
                    }
                } else {
                    Iterator f67553a2 = SequencesKt.e(a1.a(navDestination.f13918f)).getF67553a();
                    while (f67553a2.hasNext()) {
                        if (!this.f13918f.e((c) f67553a2.next())) {
                        }
                    }
                    z10 = true;
                }
            }
        }
        z10 = false;
        if (l().size() == navDestination.l().size()) {
            Iterator f67553a3 = MapsKt.x(l()).getF67553a();
            while (true) {
                if (f67553a3.hasNext()) {
                    Map.Entry entry = (Map.Entry) f67553a3.next();
                    if (!navDestination.l().containsKey(entry.getKey()) || !Intrinsics.c(navDestination.l().get(entry.getKey()), entry.getValue())) {
                        break;
                    }
                } else {
                    for (Map.Entry entry2 : MapsKt.x(navDestination.l())) {
                        if (l().containsKey(entry2.getKey()) && Intrinsics.c(l().get(entry2.getKey()), entry2.getValue())) {
                        }
                    }
                    z11 = true;
                }
            }
        }
        z11 = false;
        return this.f13920h == navDestination.f13920h && Intrinsics.c(this.f13921i, navDestination.f13921i) && z12 && z10 && z11;
    }

    public final Bundle f(Bundle bundle) {
        Map map;
        if (bundle == null && ((map = this.f13919g) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.f13919g.entrySet()) {
            ((d) entry.getValue()).d((String) entry.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry entry2 : this.f13919g.entrySet()) {
                String str = (String) entry2.getKey();
                d dVar = (d) entry2.getValue();
                if (!dVar.e(str, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + str + "' in argument bundle. " + dVar.a().b() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    public final int[] h(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination2 = this;
        while (true) {
            Intrinsics.e(navDestination2);
            NavGraph navGraph = navDestination2.f13914b;
            if ((navDestination == null ? null : navDestination.f13914b) != null) {
                NavGraph navGraph2 = navDestination.f13914b;
                Intrinsics.e(navGraph2);
                if (navGraph2.A(navDestination2.f13920h) == navDestination2) {
                    arrayDeque.addFirst(navDestination2);
                    break;
                }
            }
            if (navGraph == null || navGraph.G() != navDestination2.f13920h) {
                arrayDeque.addFirst(navDestination2);
            }
            if (Intrinsics.c(navGraph, navDestination) || navGraph == null) {
                break;
            }
            navDestination2 = navGraph;
        }
        List R0 = CollectionsKt.R0(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt.v(R0, 10));
        Iterator it = R0.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it.next()).n()));
        }
        return CollectionsKt.Q0(arrayList);
    }

    public int hashCode() {
        Set<String> keySet;
        int i11 = this.f13920h * 31;
        String str = this.f13921i;
        int hashCode = i11 + (str == null ? 0 : str.hashCode());
        for (NavDeepLink navDeepLink : this.f13917e) {
            int i12 = hashCode * 31;
            String k11 = navDeepLink.k();
            int hashCode2 = (i12 + (k11 == null ? 0 : k11.hashCode())) * 31;
            String d11 = navDeepLink.d();
            int hashCode3 = (hashCode2 + (d11 == null ? 0 : d11.hashCode())) * 31;
            String g11 = navDeepLink.g();
            hashCode = hashCode3 + (g11 == null ? 0 : g11.hashCode());
        }
        Iterator a11 = a1.a(this.f13918f);
        while (a11.hasNext()) {
            c cVar = (c) a11.next();
            int b11 = ((hashCode * 31) + cVar.b()) * 31;
            l c11 = cVar.c();
            hashCode = b11 + (c11 == null ? 0 : c11.hashCode());
            Bundle a12 = cVar.a();
            if (a12 != null && (keySet = a12.keySet()) != null) {
                for (String str2 : keySet) {
                    int i13 = hashCode * 31;
                    Bundle a13 = cVar.a();
                    Intrinsics.e(a13);
                    Object obj = a13.get(str2);
                    hashCode = i13 + (obj == null ? 0 : obj.hashCode());
                }
            }
        }
        for (String str3 : l().keySet()) {
            int hashCode4 = ((hashCode * 31) + str3.hashCode()) * 31;
            Object obj2 = l().get(str3);
            hashCode = hashCode4 + (obj2 == null ? 0 : obj2.hashCode());
        }
        return hashCode;
    }

    public final Map l() {
        return MapsKt.u(this.f13919g);
    }

    public String m() {
        String str = this.f13915c;
        return str == null ? String.valueOf(this.f13920h) : str;
    }

    public final int n() {
        return this.f13920h;
    }

    public final String o() {
        return this.f13913a;
    }

    public final NavGraph p() {
        return this.f13914b;
    }

    public final String q() {
        return this.f13921i;
    }

    public a r(g navDeepLinkRequest) {
        Intrinsics.h(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.f13917e.isEmpty()) {
            return null;
        }
        a aVar = null;
        for (NavDeepLink navDeepLink : this.f13917e) {
            Uri c11 = navDeepLinkRequest.c();
            Bundle f11 = c11 != null ? navDeepLink.f(c11, l()) : null;
            String a11 = navDeepLinkRequest.a();
            boolean z10 = a11 != null && Intrinsics.c(a11, navDeepLink.d());
            String b11 = navDeepLinkRequest.b();
            int h11 = b11 != null ? navDeepLink.h(b11) : -1;
            if (f11 != null || z10 || h11 > -1) {
                a aVar2 = new a(this, f11, navDeepLink.l(), z10, h11);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public void s(Context context, AttributeSet attrs) {
        Intrinsics.h(context, "context");
        Intrinsics.h(attrs, "attrs");
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R$styleable.Navigator);
        Intrinsics.g(obtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        x(obtainAttributes.getString(androidx.navigation.common.R$styleable.Navigator_route));
        if (obtainAttributes.hasValue(androidx.navigation.common.R$styleable.Navigator_android_id)) {
            u(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.Navigator_android_id, 0));
            this.f13915c = f13911j.b(context, n());
        }
        v(obtainAttributes.getText(androidx.navigation.common.R$styleable.Navigator_android_label));
        Unit unit = Unit.f67184a;
        obtainAttributes.recycle();
    }

    public final void t(int i11, c action) {
        Intrinsics.h(action, "action");
        if (y()) {
            if (i11 == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            this.f13918f.l(i11, action);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + i11 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        String str = this.f13915c;
        if (str == null) {
            sb2.append("0x");
            sb2.append(Integer.toHexString(this.f13920h));
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        String str2 = this.f13921i;
        if (str2 != null && !StringsKt.q0(str2)) {
            sb2.append(" route=");
            sb2.append(this.f13921i);
        }
        if (this.f13916d != null) {
            sb2.append(" label=");
            sb2.append(this.f13916d);
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "sb.toString()");
        return sb3;
    }

    public final void u(int i11) {
        this.f13920h = i11;
        this.f13915c = null;
    }

    public final void v(CharSequence charSequence) {
        this.f13916d = charSequence;
    }

    public final void w(NavGraph navGraph) {
        this.f13914b = navGraph;
    }

    public final void x(String str) {
        Object obj;
        if (str == null) {
            u(0);
        } else {
            if (StringsKt.q0(str)) {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
            String a11 = f13911j.a(str);
            u(a11.hashCode());
            e(a11);
        }
        List list = this.f13917e;
        List list2 = list;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((NavDeepLink) obj).k(), f13911j.a(this.f13921i))) {
                    break;
                }
            }
        }
        list2.remove(obj);
        this.f13921i = str;
    }

    public boolean y() {
        return true;
    }
}
