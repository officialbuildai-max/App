package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.j;
import androidx.navigation.q;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0015¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001aH\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\"2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b&\u0010'J)\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\nH\u0017¢\u0006\u0004\b-\u0010\rJ\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010\u0010R\u0014\u0010?\u001a\u0002078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment;", "Landroidx/fragment/app/Fragment;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/navigation/j;", "navHostController", "Z", "(Landroidx/navigation/j;)V", "Landroidx/navigation/NavController;", "navController", "Y", "(Landroidx/navigation/NavController;)V", "", "isPrimaryNavigationFragment", "onPrimaryNavigationFragmentChanged", "(Z)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/e$b;", "W", "()Landroidx/navigation/Navigator;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/util/AttributeSet;", "attrs", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "a", "Landroidx/navigation/j;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Boolean;", "isPrimaryBeforeOnCreate", "c", "Landroid/view/View;", "viewParent", "", "d", "I", "graphId", "e", "defaultNavHost", "X", "()I", "containerId", "f", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public class NavHostFragment extends Fragment {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private j navHostController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Boolean isPrimaryBeforeOnCreate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View viewParent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int graphId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean defaultNavHost;

    /* renamed from: androidx.navigation.fragment.NavHostFragment$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavHostFragment b(Companion companion, int i11, Bundle bundle, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                bundle = null;
            }
            return companion.a(i11, bundle);
        }

        public final NavHostFragment a(int i11, Bundle bundle) {
            Bundle bundle2;
            if (i11 != 0) {
                bundle2 = new Bundle();
                bundle2.putInt("android-support-nav:fragment:graphId", i11);
            } else {
                bundle2 = null;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBundle("android-support-nav:fragment:startDestinationArgs", bundle);
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle2 != null) {
                navHostFragment.setArguments(bundle2);
            }
            return navHostFragment;
        }

        public final NavController c(Fragment fragment) {
            Dialog dialog;
            Window window;
            Intrinsics.h(fragment, "fragment");
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
                if (fragment2 instanceof NavHostFragment) {
                    j jVar = ((NavHostFragment) fragment2).navHostController;
                    if (jVar != null) {
                        return jVar;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
                Fragment D0 = fragment2.getParentFragmentManager().D0();
                if (D0 instanceof NavHostFragment) {
                    j jVar2 = ((NavHostFragment) D0).navHostController;
                    if (jVar2 != null) {
                        return jVar2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
            }
            View view = fragment.getView();
            if (view != null) {
                return Navigation.b(view);
            }
            View view2 = null;
            DialogFragment dialogFragment = fragment instanceof DialogFragment ? (DialogFragment) fragment : null;
            if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null) {
                view2 = window.getDecorView();
            }
            if (view2 != null) {
                return Navigation.b(view2);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
        }
    }

    private final int X() {
        int id2 = getId();
        return (id2 == 0 || id2 == -1) ? R$id.nav_host_fragment_container : id2;
    }

    protected Navigator W() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "childFragmentManager");
        return new e(requireContext, childFragmentManager, X());
    }

    protected void Y(NavController navController) {
        Intrinsics.h(navController, "navController");
        q F = navController.F();
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "childFragmentManager");
        F.b(new c(requireContext, childFragmentManager));
        navController.F().b(W());
    }

    protected void Z(j navHostController) {
        Intrinsics.h(navHostController, "navHostController");
        Y(navHostController);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.h(context, "context");
        super.onAttach(context);
        if (this.defaultNavHost) {
            getParentFragmentManager().p().w(this).i();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.requireContext()
            java.lang.String r1 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            androidx.navigation.j r1 = new androidx.navigation.j
            r1.<init>(r0)
            r6.navHostController = r1
            kotlin.jvm.internal.Intrinsics.e(r1)
            r1.d0(r6)
        L16:
            boolean r1 = r0 instanceof android.content.ContextWrapper
            if (r1 == 0) goto L3e
            boolean r1 = r0 instanceof androidx.activity.x
            if (r1 == 0) goto L32
            androidx.navigation.j r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.e(r1)
            androidx.activity.x r0 = (androidx.activity.x) r0
            androidx.activity.OnBackPressedDispatcher r0 = r0.getOnBackPressedDispatcher()
            java.lang.String r2 = "context as OnBackPressed…).onBackPressedDispatcher"
            kotlin.jvm.internal.Intrinsics.g(r0, r2)
            r1.e0(r0)
            goto L3e
        L32:
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            java.lang.String r1 = "context.baseContext"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            goto L16
        L3e:
            androidx.navigation.j r0 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.e(r0)
            java.lang.Boolean r1 = r6.isPrimaryBeforeOnCreate
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L5b
            if (r1 == 0) goto L53
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L5b
            r1 = r2
            goto L5c
        L53:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Boolean"
            r7.<init>(r0)
            throw r7
        L5b:
            r1 = r3
        L5c:
            r0.r(r1)
            r0 = 0
            r6.isPrimaryBeforeOnCreate = r0
            androidx.navigation.j r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.e(r1)
            androidx.lifecycle.x0 r4 = r6.getViewModelStore()
            java.lang.String r5 = "viewModelStore"
            kotlin.jvm.internal.Intrinsics.g(r4, r5)
            r1.f0(r4)
            androidx.navigation.j r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.e(r1)
            r6.Z(r1)
            java.lang.String r1 = "android-support-nav:fragment:graphId"
            if (r7 == 0) goto La5
            java.lang.String r4 = "android-support-nav:fragment:navControllerState"
            android.os.Bundle r4 = r7.getBundle(r4)
            java.lang.String r5 = "android-support-nav:fragment:defaultHost"
            boolean r5 = r7.getBoolean(r5, r3)
            if (r5 == 0) goto L9e
            r6.defaultNavHost = r2
            androidx.fragment.app.FragmentManager r2 = r6.getParentFragmentManager()
            androidx.fragment.app.w r2 = r2.p()
            androidx.fragment.app.w r2 = r2.w(r6)
            r2.i()
        L9e:
            int r2 = r7.getInt(r1)
            r6.graphId = r2
            goto La6
        La5:
            r4 = r0
        La6:
            if (r4 == 0) goto Lb0
            androidx.navigation.j r2 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.e(r2)
            r2.X(r4)
        Lb0:
            int r2 = r6.graphId
            if (r2 == 0) goto Lbf
            androidx.navigation.j r0 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.e(r0)
            int r1 = r6.graphId
            r0.a0(r1)
            goto Ldd
        Lbf:
            android.os.Bundle r2 = r6.getArguments()
            if (r2 != 0) goto Lc6
            goto Lca
        Lc6:
            int r3 = r2.getInt(r1)
        Lca:
            if (r2 != 0) goto Lcd
            goto Ld3
        Lcd:
            java.lang.String r0 = "android-support-nav:fragment:startDestinationArgs"
            android.os.Bundle r0 = r2.getBundle(r0)
        Ld3:
            if (r3 == 0) goto Ldd
            androidx.navigation.j r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.e(r1)
            r1.b0(r3, r0)
        Ldd:
            super.onCreate(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.NavHostFragment.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.g(context, "inflater.context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(X());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.viewParent;
        if (view != null && Navigation.b(view) == this.navHostController) {
            Navigation.e(view, null);
        }
        this.viewParent = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Intrinsics.h(context, "context");
        Intrinsics.h(attrs, "attrs");
        super.onInflate(context, attrs, savedInstanceState);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, androidx.navigation.R$styleable.NavHost);
        Intrinsics.g(obtainStyledAttributes, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int resourceId = obtainStyledAttributes.getResourceId(androidx.navigation.R$styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.graphId = resourceId;
        }
        Unit unit = Unit.f67184a;
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attrs, R$styleable.NavHostFragment);
        Intrinsics.g(obtainStyledAttributes2, "context.obtainStyledAttr…tyleable.NavHostFragment)");
        if (obtainStyledAttributes2.getBoolean(R$styleable.NavHostFragment_defaultNavHost, false)) {
            this.defaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrimaryNavigationFragmentChanged(boolean isPrimaryNavigationFragment) {
        j jVar = this.navHostController;
        if (jVar == null) {
            this.isPrimaryBeforeOnCreate = Boolean.valueOf(isPrimaryNavigationFragment);
        } else {
            if (jVar == null) {
                return;
            }
            jVar.r(isPrimaryNavigationFragment);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        j jVar = this.navHostController;
        Intrinsics.e(jVar);
        Bundle Z = jVar.Z();
        if (Z != null) {
            outState.putBundle("android-support-nav:fragment:navControllerState", Z);
        }
        if (this.defaultNavHost) {
            outState.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i11 = this.graphId;
        if (i11 != 0) {
            outState.putInt("android-support-nav:fragment:graphId", i11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
        }
        Navigation.e(view, this.navHostController);
        if (view.getParent() != null) {
            Object parent = view.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            View view2 = (View) parent;
            this.viewParent = view2;
            Intrinsics.e(view2);
            if (view2.getId() == getId()) {
                View view3 = this.viewParent;
                Intrinsics.e(view3);
                Navigation.e(view3, this.navHostController);
            }
        }
    }
}
