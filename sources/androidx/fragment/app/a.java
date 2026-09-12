package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.view.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends w implements FragmentManager.m {

    /* renamed from: t, reason: collision with root package name */
    final FragmentManager f9504t;

    /* renamed from: u, reason: collision with root package name */
    boolean f9505u;

    /* renamed from: v, reason: collision with root package name */
    int f9506v;

    /* renamed from: w, reason: collision with root package name */
    boolean f9507w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentManager fragmentManager) {
        super(fragmentManager.w0(), fragmentManager.z0() != null ? fragmentManager.z0().f().getClassLoader() : null);
        this.f9506v = -1;
        this.f9507w = false;
        this.f9504t = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(a aVar) {
        super(aVar.f9504t.w0(), aVar.f9504t.z0() != null ? aVar.f9504t.z0().f().getClassLoader() : null, aVar);
        this.f9506v = -1;
        this.f9507w = false;
        this.f9504t = aVar.f9504t;
        this.f9505u = aVar.f9505u;
        this.f9506v = aVar.f9506v;
        this.f9507w = aVar.f9507w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        int size = this.f9560c.size() - 1;
        while (size >= 0) {
            w.a aVar = (w.a) this.f9560c.get(size);
            if (aVar.f9579c) {
                if (aVar.f9577a == 8) {
                    aVar.f9579c = false;
                    this.f9560c.remove(size - 1);
                    size--;
                } else {
                    int i11 = aVar.f9578b.mContainerId;
                    aVar.f9577a = 2;
                    aVar.f9579c = false;
                    for (int i12 = size - 1; i12 >= 0; i12--) {
                        w.a aVar2 = (w.a) this.f9560c.get(i12);
                        if (aVar2.f9579c && aVar2.f9578b.mContainerId == i11) {
                            this.f9560c.remove(i12);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    int B(boolean z10) {
        if (this.f9505u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new a0("FragmentManager"));
            C("  ", printWriter);
            printWriter.close();
        }
        this.f9505u = true;
        if (this.f9566i) {
            this.f9506v = this.f9504t.m();
        } else {
            this.f9506v = -1;
        }
        this.f9504t.a0(this, z10);
        return this.f9506v;
    }

    public void C(String str, PrintWriter printWriter) {
        D(str, printWriter, true);
    }

    public void D(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f9568k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f9506v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f9505u);
            if (this.f9565h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f9565h));
            }
            if (this.f9561d != 0 || this.f9562e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f9561d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f9562e));
            }
            if (this.f9563f != 0 || this.f9564g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f9563f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f9564g));
            }
            if (this.f9569l != 0 || this.f9570m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f9569l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f9570m);
            }
            if (this.f9571n != 0 || this.f9572o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f9571n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f9572o);
            }
        }
        if (this.f9560c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f9560c.size();
        for (int i11 = 0; i11 < size; i11++) {
            w.a aVar = (w.a) this.f9560c.get(i11);
            switch (aVar.f9577a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f9577a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i11);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f9578b);
            if (z10) {
                if (aVar.f9580d != 0 || aVar.f9581e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f9580d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f9581e));
                }
                if (aVar.f9582f != 0 || aVar.f9583g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f9582f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f9583g));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        int size = this.f9560c.size();
        for (int i11 = 0; i11 < size; i11++) {
            w.a aVar = (w.a) this.f9560c.get(i11);
            Fragment fragment = aVar.f9578b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f9507w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f9565h);
                fragment.setSharedElementNames(this.f9573p, this.f9574q);
            }
            switch (aVar.f9577a) {
                case 1:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.D1(fragment, false);
                    this.f9504t.j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f9577a);
                case 3:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.q1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.J0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.D1(fragment, false);
                    this.f9504t.K1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.y(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.D1(fragment, false);
                    this.f9504t.o(fragment);
                    break;
                case 8:
                    this.f9504t.I1(fragment);
                    break;
                case 9:
                    this.f9504t.I1(null);
                    break;
                case 10:
                    this.f9504t.H1(fragment, aVar.f9585i);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        for (int size = this.f9560c.size() - 1; size >= 0; size--) {
            w.a aVar = (w.a) this.f9560c.get(size);
            Fragment fragment = aVar.f9578b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f9507w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.x1(this.f9565h));
                fragment.setSharedElementNames(this.f9574q, this.f9573p);
            }
            switch (aVar.f9577a) {
                case 1:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.D1(fragment, true);
                    this.f9504t.q1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f9577a);
                case 3:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.K1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.D1(fragment, true);
                    this.f9504t.J0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.o(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f9580d, aVar.f9581e, aVar.f9582f, aVar.f9583g);
                    this.f9504t.D1(fragment, true);
                    this.f9504t.y(fragment);
                    break;
                case 8:
                    this.f9504t.I1(null);
                    break;
                case 9:
                    this.f9504t.I1(fragment);
                    break;
                case 10:
                    this.f9504t.H1(fragment, aVar.f9584h);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment G(ArrayList arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i11 = 0;
        while (i11 < this.f9560c.size()) {
            w.a aVar = (w.a) this.f9560c.get(i11);
            int i12 = aVar.f9577a;
            if (i12 != 1) {
                if (i12 == 2) {
                    Fragment fragment3 = aVar.f9578b;
                    int i13 = fragment3.mContainerId;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = (Fragment) arrayList.get(size);
                        if (fragment4.mContainerId == i13) {
                            if (fragment4 == fragment3) {
                                z10 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f9560c.add(i11, new w.a(9, fragment4, true));
                                    i11++;
                                    fragment2 = null;
                                }
                                w.a aVar2 = new w.a(3, fragment4, true);
                                aVar2.f9580d = aVar.f9580d;
                                aVar2.f9582f = aVar.f9582f;
                                aVar2.f9581e = aVar.f9581e;
                                aVar2.f9583g = aVar.f9583g;
                                this.f9560c.add(i11, aVar2);
                                arrayList.remove(fragment4);
                                i11++;
                            }
                        }
                    }
                    if (z10) {
                        this.f9560c.remove(i11);
                        i11--;
                    } else {
                        aVar.f9577a = 1;
                        aVar.f9579c = true;
                        arrayList.add(fragment3);
                    }
                } else if (i12 == 3 || i12 == 6) {
                    arrayList.remove(aVar.f9578b);
                    Fragment fragment5 = aVar.f9578b;
                    if (fragment5 == fragment2) {
                        this.f9560c.add(i11, new w.a(9, fragment5));
                        i11++;
                        fragment2 = null;
                    }
                } else if (i12 != 7) {
                    if (i12 == 8) {
                        this.f9560c.add(i11, new w.a(9, fragment2, true));
                        aVar.f9579c = true;
                        i11++;
                        fragment2 = aVar.f9578b;
                    }
                }
                i11++;
            }
            arrayList.add(aVar.f9578b);
            i11++;
        }
        return fragment2;
    }

    public String H() {
        return this.f9568k;
    }

    public void I() {
        if (this.f9576s != null) {
            for (int i11 = 0; i11 < this.f9576s.size(); i11++) {
                ((Runnable) this.f9576s.get(i11)).run();
            }
            this.f9576s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment J(ArrayList arrayList, Fragment fragment) {
        for (int size = this.f9560c.size() - 1; size >= 0; size--) {
            w.a aVar = (w.a) this.f9560c.get(size);
            int i11 = aVar.f9577a;
            if (i11 != 1) {
                if (i11 != 3) {
                    switch (i11) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f9578b;
                            break;
                        case 10:
                            aVar.f9585i = aVar.f9584h;
                            break;
                    }
                }
                arrayList.add(aVar.f9578b);
            }
            arrayList.remove(aVar.f9578b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager.m
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f9566i) {
            return true;
        }
        this.f9504t.i(this);
        return true;
    }

    @Override // androidx.fragment.app.w
    public int i() {
        return B(false);
    }

    @Override // androidx.fragment.app.w
    public int j() {
        return B(true);
    }

    @Override // androidx.fragment.app.w
    public void k() {
        n();
        this.f9504t.d0(this, false);
    }

    @Override // androidx.fragment.app.w
    public void l() {
        n();
        this.f9504t.d0(this, true);
    }

    @Override // androidx.fragment.app.w
    public w m(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9504t) {
            return super.m(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.w
    public void o(int i11, Fragment fragment, String str, int i12) {
        super.o(i11, fragment, str, i12);
        fragment.mFragmentManager = this.f9504t;
    }

    @Override // androidx.fragment.app.w
    public w p(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9504t) {
            return super.p(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.w
    public boolean q() {
        return this.f9560c.isEmpty();
    }

    @Override // androidx.fragment.app.w
    public w r(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9504t) {
            return super.r(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f9506v >= 0) {
            sb2.append(" #");
            sb2.append(this.f9506v);
        }
        if (this.f9568k != null) {
            sb2.append(" ");
            sb2.append(this.f9568k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // androidx.fragment.app.w
    public w v(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f9504t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f9504t);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.v(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    @Override // androidx.fragment.app.w
    public w w(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.f9504t) {
            return super.w(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.w
    public w y(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9504t) {
            return super.y(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i11) {
        if (this.f9566i) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i11);
            }
            int size = this.f9560c.size();
            for (int i12 = 0; i12 < size; i12++) {
                w.a aVar = (w.a) this.f9560c.get(i12);
                Fragment fragment = aVar.f9578b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i11;
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f9578b + " to " + aVar.f9578b.mBackStackNesting);
                    }
                }
            }
        }
    }
}
