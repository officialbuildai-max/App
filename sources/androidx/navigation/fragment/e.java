package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.l;
import be.g;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.j;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001d\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Landroidx/navigation/fragment/e;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/e$b;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "containerId", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/navigation/l;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "", "m", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/l;Landroidx/navigation/Navigator$a;)V", "popUpTo", "", "savedState", j.f35620b, "(Landroidx/navigation/NavBackStackEntry;Z)V", "l", "()Landroidx/navigation/fragment/e$b;", "", "entries", "e", "(Ljava/util/List;Landroidx/navigation/l;Landroidx/navigation/Navigator$a;)V", "Landroid/os/Bundle;", "i", "()Landroid/os/Bundle;", "h", "(Landroid/os/Bundle;)V", "c", "Landroid/content/Context;", "d", "Landroidx/fragment/app/FragmentManager;", "I", "", "", "f", "Ljava/util/Set;", "savedIds", g.f16474b, "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@Navigator.b("fragment")
/* loaded from: classes2.dex */
public class e extends Navigator {

    /* renamed from: g, reason: collision with root package name */
    private static final a f13977g = new a(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FragmentManager fragmentManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int containerId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Set savedIds;

    /* loaded from: classes2.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends NavDestination {

        /* renamed from: l, reason: collision with root package name */
        private String f13982l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Navigator fragmentNavigator) {
            super(fragmentNavigator);
            Intrinsics.h(fragmentNavigator, "fragmentNavigator");
        }

        public final b A(String className) {
            Intrinsics.h(className, "className");
            this.f13982l = className;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object obj) {
            return obj != null && (obj instanceof b) && super.equals(obj) && Intrinsics.c(this.f13982l, ((b) obj).f13982l);
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            String str = this.f13982l;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        @Override // androidx.navigation.NavDestination
        public void s(Context context, AttributeSet attrs) {
            Intrinsics.h(context, "context");
            Intrinsics.h(attrs, "attrs");
            super.s(context, attrs);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, R$styleable.FragmentNavigator);
            Intrinsics.g(obtainAttributes, "context.resources.obtain…leable.FragmentNavigator)");
            String string = obtainAttributes.getString(R$styleable.FragmentNavigator_android_name);
            if (string != null) {
                A(string);
            }
            Unit unit = Unit.f67184a;
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            sb2.append(" class=");
            String str = this.f13982l;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            String sb3 = sb2.toString();
            Intrinsics.g(sb3, "sb.toString()");
            return sb3;
        }

        public final String z() {
            String str = this.f13982l;
            if (str == null) {
                throw new IllegalStateException("Fragment class was not set");
            }
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public e(Context context, FragmentManager fragmentManager, int i11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(fragmentManager, "fragmentManager");
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.containerId = i11;
        this.savedIds = new LinkedHashSet();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m(androidx.navigation.NavBackStackEntry r11, androidx.navigation.l r12, androidx.navigation.Navigator.a r13) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.e.m(androidx.navigation.NavBackStackEntry, androidx.navigation.l, androidx.navigation.Navigator$a):void");
    }

    @Override // androidx.navigation.Navigator
    public void e(List entries, l navOptions, Navigator.a navigatorExtras) {
        Intrinsics.h(entries, "entries");
        if (this.fragmentManager.T0()) {
            return;
        }
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            m((NavBackStackEntry) it.next(), navOptions, navigatorExtras);
        }
    }

    @Override // androidx.navigation.Navigator
    public void h(Bundle savedState) {
        Intrinsics.h(savedState, "savedState");
        ArrayList<String> stringArrayList = savedState.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            this.savedIds.clear();
            CollectionsKt.B(this.savedIds, stringArrayList);
        }
    }

    @Override // androidx.navigation.Navigator
    public Bundle i() {
        if (this.savedIds.isEmpty()) {
            return null;
        }
        return androidx.core.os.d.b(TuplesKt.a("androidx-nav-fragment:navigator:savedIds", new ArrayList(this.savedIds)));
    }

    @Override // androidx.navigation.Navigator
    public void j(NavBackStackEntry popUpTo, boolean savedState) {
        Intrinsics.h(popUpTo, "popUpTo");
        if (this.fragmentManager.T0()) {
            return;
        }
        if (savedState) {
            List list = (List) b().b().getValue();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.i0(list);
            for (NavBackStackEntry navBackStackEntry2 : CollectionsKt.D0(list.subList(list.indexOf(popUpTo), list.size()))) {
                if (Intrinsics.c(navBackStackEntry2, navBackStackEntry)) {
                    Intrinsics.q("FragmentManager cannot save the state of the initial destination ", navBackStackEntry2);
                } else {
                    this.fragmentManager.z1(navBackStackEntry2.g());
                    this.savedIds.add(navBackStackEntry2.g());
                }
            }
        } else {
            this.fragmentManager.i1(popUpTo.g(), 1);
        }
        b().g(popUpTo, savedState);
    }

    @Override // androidx.navigation.Navigator
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this);
    }
}
