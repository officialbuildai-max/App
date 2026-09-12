package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class FragmentStrictMode {

    /* renamed from: a, reason: collision with root package name */
    public static final FragmentStrictMode f9540a = new FragmentStrictMode();

    /* renamed from: b, reason: collision with root package name */
    private static b f9541b = b.f9543d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final a f9542c = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final b f9543d = new b(SetsKt.f(), null, MapsKt.h());

        /* renamed from: a, reason: collision with root package name */
        private final Set f9544a;

        /* renamed from: b, reason: collision with root package name */
        private final Map f9545b;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(Set flags, a aVar, Map allowedViolations) {
            Intrinsics.h(flags, "flags");
            Intrinsics.h(allowedViolations, "allowedViolations");
            this.f9544a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : allowedViolations.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f9545b = linkedHashMap;
        }

        public final Set a() {
            return this.f9544a;
        }

        public final a b() {
            return null;
        }

        public final Map c() {
            return this.f9545b;
        }
    }

    private FragmentStrictMode() {
    }

    private final b b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.g(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.F0() != null) {
                    b F0 = parentFragmentManager.F0();
                    Intrinsics.e(F0);
                    return F0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f9541b;
    }

    private final void c(b bVar, final Violation violation) {
        Fragment fragment = violation.getFragment();
        final String name = fragment.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Policy violation in ");
            sb2.append(name);
        }
        bVar.b();
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            o(fragment, new Runnable() { // from class: m1.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.d(name, violation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, Violation violation) {
        Intrinsics.h(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void e(Violation violation) {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("StrictMode violation in ");
            sb2.append(violation.getFragment().getClass().getName());
        }
    }

    public static final void f(Fragment fragment, String previousFragmentId) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(fragmentReuseViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.p(b11, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.c(b11, fragmentReuseViolation);
        }
    }

    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        Intrinsics.h(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(fragmentTagUsageViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.p(b11, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.c(b11, fragmentTagUsageViolation);
        }
    }

    public static final void h(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(getRetainInstanceUsageViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(b11, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(b11, getRetainInstanceUsageViolation);
        }
    }

    public static final void i(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(getTargetFragmentRequestCodeUsageViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b11, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.c(b11, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(getTargetFragmentUsageViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b11, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(b11, getTargetFragmentUsageViolation);
        }
    }

    public static final void k(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(setRetainInstanceUsageViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(b11, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(b11, setRetainInstanceUsageViolation);
        }
    }

    public static final void l(Fragment violatingFragment, Fragment targetFragment, int i11) {
        Intrinsics.h(violatingFragment, "violatingFragment");
        Intrinsics.h(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, i11);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(setTargetFragmentUsageViolation);
        b b11 = fragmentStrictMode.b(violatingFragment);
        if (b11.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b11, violatingFragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(b11, setTargetFragmentUsageViolation);
        }
    }

    public static final void m(Fragment fragment, boolean z10) {
        Intrinsics.h(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z10);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(setUserVisibleHintViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.p(b11, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.c(b11, setUserVisibleHintViolation);
        }
    }

    public static final void n(Fragment fragment, ViewGroup container) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f9540a;
        fragmentStrictMode.e(wrongFragmentContainerViolation);
        b b11 = fragmentStrictMode.b(fragment);
        if (b11.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.p(b11, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.c(b11, wrongFragmentContainerViolation);
        }
    }

    private final void o(Fragment fragment, Runnable runnable) {
        if (!fragment.isAdded()) {
            runnable.run();
            return;
        }
        Handler g11 = fragment.getParentFragmentManager().z0().g();
        Intrinsics.g(g11, "fragment.parentFragmentManager.host.handler");
        if (Intrinsics.c(g11.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            g11.post(runnable);
        }
    }

    private final boolean p(b bVar, Class cls, Class cls2) {
        Set set = (Set) bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.c(cls2.getSuperclass(), Violation.class) || !CollectionsKt.b0(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
