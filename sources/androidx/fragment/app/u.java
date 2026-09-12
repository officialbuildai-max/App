package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.view.Lifecycle;
import androidx.view.y0;
import com.cloud.tmc.kernel.constants.TmcConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private final k f9546a;

    /* renamed from: b, reason: collision with root package name */
    private final v f9547b;

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f9548c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9549d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f9550e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9551a;

        a(View view) {
            this.f9551a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f9551a.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(this.f9551a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9553a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f9553a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9553a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9553a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9553a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(k kVar, v vVar, Fragment fragment) {
        this.f9546a = kVar;
        this.f9547b = vVar;
        this.f9548c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(k kVar, v vVar, Fragment fragment, FragmentState fragmentState) {
        this.f9546a = kVar;
        this.f9547b = vVar;
        this.f9548c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f9461m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(k kVar, v vVar, ClassLoader classLoader, h hVar, FragmentState fragmentState) {
        this.f9546a = kVar;
        this.f9547b = vVar;
        Fragment a11 = fragmentState.a(hVar, classLoader);
        this.f9548c = a11;
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a11);
        }
    }

    private boolean l(View view) {
        if (view == this.f9548c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f9548c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f9548c.performSaveInstanceState(bundle);
        this.f9546a.j(this.f9548c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f9548c.mView != null) {
            t();
        }
        if (this.f9548c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f9548c.mSavedViewState);
        }
        if (this.f9548c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f9548c.mSavedViewRegistryState);
        }
        if (!this.f9548c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f9548c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ACTIVITY_CREATED: ");
            sb2.append(this.f9548c);
        }
        Fragment fragment = this.f9548c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        k kVar = this.f9546a;
        Fragment fragment2 = this.f9548c;
        kVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int j11 = this.f9547b.j(this.f9548c);
        Fragment fragment = this.f9548c;
        fragment.mContainer.addView(fragment.mView, j11);
    }

    void c() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ATTACHED: ");
            sb2.append(this.f9548c);
        }
        Fragment fragment = this.f9548c;
        Fragment fragment2 = fragment.mTarget;
        u uVar = null;
        if (fragment2 != null) {
            u n11 = this.f9547b.n(fragment2.mWho);
            if (n11 == null) {
                throw new IllegalStateException("Fragment " + this.f9548c + " declared target fragment " + this.f9548c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f9548c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            uVar = n11;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (uVar = this.f9547b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f9548c + " declared target fragment " + this.f9548c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (uVar != null) {
            uVar.m();
        }
        Fragment fragment4 = this.f9548c;
        fragment4.mHost = fragment4.mFragmentManager.z0();
        Fragment fragment5 = this.f9548c;
        fragment5.mParentFragment = fragment5.mFragmentManager.C0();
        this.f9546a.g(this.f9548c, false);
        this.f9548c.performAttach();
        this.f9546a.b(this.f9548c, false);
    }

    int d() {
        Fragment fragment = this.f9548c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i11 = this.f9550e;
        int i12 = b.f9553a[fragment.mMaxState.ordinal()];
        if (i12 != 1) {
            i11 = i12 != 2 ? i12 != 3 ? i12 != 4 ? Math.min(i11, -1) : Math.min(i11, 0) : Math.min(i11, 1) : Math.min(i11, 5);
        }
        Fragment fragment2 = this.f9548c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i11 = Math.max(this.f9550e, 2);
                View view = this.f9548c.mView;
                if (view != null && view.getParent() == null) {
                    i11 = Math.min(i11, 2);
                }
            } else {
                i11 = this.f9550e < 4 ? Math.min(i11, fragment2.mState) : Math.min(i11, 1);
            }
        }
        if (!this.f9548c.mAdded) {
            i11 = Math.min(i11, 1);
        }
        Fragment fragment3 = this.f9548c;
        ViewGroup viewGroup = fragment3.mContainer;
        SpecialEffectsController.Operation.LifecycleImpact l11 = viewGroup != null ? SpecialEffectsController.n(viewGroup, fragment3.getParentFragmentManager()).l(this) : null;
        if (l11 == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i11 = Math.min(i11, 6);
        } else if (l11 == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i11 = Math.max(i11, 3);
        } else {
            Fragment fragment4 = this.f9548c;
            if (fragment4.mRemoving) {
                i11 = fragment4.isInBackStack() ? Math.min(i11, 1) : Math.min(i11, -1);
            }
        }
        Fragment fragment5 = this.f9548c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i11 = Math.min(i11, 4);
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i11 + " for " + this.f9548c);
        }
        return i11;
    }

    void e() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATED: ");
            sb2.append(this.f9548c);
        }
        Fragment fragment = this.f9548c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f9548c.mState = 1;
            return;
        }
        this.f9546a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f9548c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        k kVar = this.f9546a;
        Fragment fragment3 = this.f9548c;
        kVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    void f() {
        String str;
        if (this.f9548c.mFromLayout) {
            return;
        }
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATE_VIEW: ");
            sb2.append(this.f9548c);
        }
        Fragment fragment = this.f9548c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.f9548c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i11 = fragment2.mContainerId;
            if (i11 == 0) {
                viewGroup = null;
            } else {
                if (i11 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f9548c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.t0().c(this.f9548c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f9548c;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.f9548c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = TmcConstants.ROUTE_UNKNOWN;
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f9548c.mContainerId) + " (" + str + ") for fragment " + this.f9548c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.n(this.f9548c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f9548c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f9548c.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f9548c;
            fragment5.mView.setTag(R$id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f9548c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (ViewCompat.isAttachedToWindow(this.f9548c.mView)) {
                ViewCompat.requestApplyInsets(this.f9548c.mView);
            } else {
                View view2 = this.f9548c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f9548c.performViewCreated();
            k kVar = this.f9546a;
            Fragment fragment7 = this.f9548c;
            kVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f9548c.mView.getVisibility();
            this.f9548c.setPostOnViewCreatedAlpha(this.f9548c.mView.getAlpha());
            Fragment fragment8 = this.f9548c;
            if (fragment8.mContainer != null && visibility == 0) {
                View findFocus = fragment8.mView.findFocus();
                if (findFocus != null) {
                    this.f9548c.setFocusedView(findFocus);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f9548c);
                    }
                }
                this.f9548c.mView.setAlpha(0.0f);
            }
        }
        this.f9548c.mState = 2;
    }

    void g() {
        Fragment f11;
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATED: ");
            sb2.append(this.f9548c);
        }
        Fragment fragment = this.f9548c;
        boolean z10 = true;
        boolean z11 = fragment.mRemoving && !fragment.isInBackStack();
        if (z11) {
            Fragment fragment2 = this.f9548c;
            if (!fragment2.mBeingSaved) {
                this.f9547b.B(fragment2.mWho, null);
            }
        }
        if (!z11 && !this.f9547b.p().n(this.f9548c)) {
            String str = this.f9548c.mTargetWho;
            if (str != null && (f11 = this.f9547b.f(str)) != null && f11.mRetainInstance) {
                this.f9548c.mTarget = f11;
            }
            this.f9548c.mState = 0;
            return;
        }
        i iVar = this.f9548c.mHost;
        if (iVar instanceof y0) {
            z10 = this.f9547b.p().k();
        } else if (iVar.f() instanceof Activity) {
            z10 = true ^ ((Activity) iVar.f()).isChangingConfigurations();
        }
        if ((z11 && !this.f9548c.mBeingSaved) || z10) {
            this.f9547b.p().c(this.f9548c);
        }
        this.f9548c.performDestroy();
        this.f9546a.d(this.f9548c, false);
        for (u uVar : this.f9547b.k()) {
            if (uVar != null) {
                Fragment k11 = uVar.k();
                if (this.f9548c.mWho.equals(k11.mTargetWho)) {
                    k11.mTarget = this.f9548c;
                    k11.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.f9548c;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.f9547b.f(str2);
        }
        this.f9547b.s(this);
    }

    void h() {
        View view;
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATE_VIEW: ");
            sb2.append(this.f9548c);
        }
        Fragment fragment = this.f9548c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f9548c.performDestroyView();
        this.f9546a.n(this.f9548c, false);
        Fragment fragment2 = this.f9548c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.q(null);
        this.f9548c.mInLayout = false;
    }

    void i() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom ATTACHED: ");
            sb2.append(this.f9548c);
        }
        this.f9548c.performDetach();
        this.f9546a.e(this.f9548c, false);
        Fragment fragment = this.f9548c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((!fragment.mRemoving || fragment.isInBackStack()) && !this.f9547b.p().n(this.f9548c)) {
            return;
        }
        if (FragmentManager.M0(3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("initState called for fragment: ");
            sb3.append(this.f9548c);
        }
        this.f9548c.initState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f9548c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.M0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveto CREATE_VIEW: ");
                sb2.append(this.f9548c);
            }
            Fragment fragment2 = this.f9548c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f9548c.mSavedFragmentState);
            View view = this.f9548c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f9548c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f9548c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f9548c.performViewCreated();
                k kVar = this.f9546a;
                Fragment fragment5 = this.f9548c;
                kVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f9548c.mState = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment k() {
        return this.f9548c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f9549d) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f9549d = true;
            boolean z10 = false;
            while (true) {
                int d11 = d();
                Fragment fragment = this.f9548c;
                int i11 = fragment.mState;
                if (d11 == i11) {
                    if (!z10 && i11 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f9548c.mBeingSaved) {
                        if (FragmentManager.M0(3)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Cleaning up state of never attached fragment: ");
                            sb2.append(this.f9548c);
                        }
                        this.f9547b.p().c(this.f9548c);
                        this.f9547b.s(this);
                        if (FragmentManager.M0(3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("initState called for fragment: ");
                            sb3.append(this.f9548c);
                        }
                        this.f9548c.initState();
                    }
                    Fragment fragment2 = this.f9548c;
                    if (fragment2.mHiddenChanged) {
                        if (fragment2.mView != null && (viewGroup = fragment2.mContainer) != null) {
                            SpecialEffectsController n11 = SpecialEffectsController.n(viewGroup, fragment2.getParentFragmentManager());
                            if (this.f9548c.mHidden) {
                                n11.c(this);
                            } else {
                                n11.e(this);
                            }
                        }
                        Fragment fragment3 = this.f9548c;
                        FragmentManager fragmentManager = fragment3.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.K0(fragment3);
                        }
                        Fragment fragment4 = this.f9548c;
                        fragment4.mHiddenChanged = false;
                        fragment4.onHiddenChanged(fragment4.mHidden);
                        this.f9548c.mChildFragmentManager.K();
                    }
                    this.f9549d = false;
                    return;
                }
                if (d11 <= i11) {
                    switch (i11 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.mBeingSaved && this.f9547b.q(fragment.mWho) == null) {
                                s();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f9548c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.M0(3)) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("movefrom ACTIVITY_CREATED: ");
                                sb4.append(this.f9548c);
                            }
                            Fragment fragment5 = this.f9548c;
                            if (fragment5.mBeingSaved) {
                                s();
                            } else if (fragment5.mView != null && fragment5.mSavedViewState == null) {
                                t();
                            }
                            Fragment fragment6 = this.f9548c;
                            if (fragment6.mView != null && (viewGroup2 = fragment6.mContainer) != null) {
                                SpecialEffectsController.n(viewGroup2, fragment6.getParentFragmentManager()).d(this);
                            }
                            this.f9548c.mState = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i11 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                SpecialEffectsController.n(viewGroup3, fragment.getParentFragmentManager()).b(SpecialEffectsController.Operation.State.from(this.f9548c.mView.getVisibility()), this);
                            }
                            this.f9548c.mState = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } catch (Throwable th2) {
            this.f9549d = false;
            throw th2;
        }
    }

    void n() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom RESUMED: ");
            sb2.append(this.f9548c);
        }
        this.f9548c.performPause();
        this.f9546a.f(this.f9548c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f9548c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f9548c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f9548c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f9548c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f9548c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f9548c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f9548c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f9548c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    void p() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESUMED: ");
            sb2.append(this.f9548c);
        }
        View focusedView = this.f9548c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.M0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("requestFocus: Restoring focused view ");
                sb3.append(focusedView);
                sb3.append(" ");
                sb3.append(requestFocus ? "succeeded" : "failed");
                sb3.append(" on Fragment ");
                sb3.append(this.f9548c);
                sb3.append(" resulting in focused view ");
                sb3.append(this.f9548c.mView.findFocus());
                Log.v("FragmentManager", sb3.toString());
            }
        }
        this.f9548c.setFocusedView(null);
        this.f9548c.performResume();
        this.f9546a.i(this.f9548c, false);
        Fragment fragment = this.f9548c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment.SavedState r() {
        Bundle q11;
        if (this.f9548c.mState <= -1 || (q11 = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        FragmentState fragmentState = new FragmentState(this.f9548c);
        Fragment fragment = this.f9548c;
        if (fragment.mState <= -1 || fragmentState.f9461m != null) {
            fragmentState.f9461m = fragment.mSavedFragmentState;
        } else {
            Bundle q11 = q();
            fragmentState.f9461m = q11;
            if (this.f9548c.mTargetWho != null) {
                if (q11 == null) {
                    fragmentState.f9461m = new Bundle();
                }
                fragmentState.f9461m.putString("android:target_state", this.f9548c.mTargetWho);
                int i11 = this.f9548c.mTargetRequestCode;
                if (i11 != 0) {
                    fragmentState.f9461m.putInt("android:target_req_state", i11);
                }
            }
        }
        this.f9547b.B(this.f9548c.mWho, fragmentState);
    }

    void t() {
        if (this.f9548c.mView == null) {
            return;
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f9548c + " with view " + this.f9548c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f9548c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f9548c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f9548c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f9548c.mSavedViewRegistryState = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i11) {
        this.f9550e = i11;
    }

    void v() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto STARTED: ");
            sb2.append(this.f9548c);
        }
        this.f9548c.performStart();
        this.f9546a.k(this.f9548c, false);
    }

    void w() {
        if (FragmentManager.M0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom STARTED: ");
            sb2.append(this.f9548c);
        }
        this.f9548c.performStop();
        this.f9546a.l(this.f9548c, false);
    }
}
