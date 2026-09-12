package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f9554a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f9555b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f9556c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private r f9557d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(r rVar) {
        this.f9557d = rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState B(String str, FragmentState fragmentState) {
        return fragmentState != null ? (FragmentState) this.f9556c.put(str, fragmentState) : (FragmentState) this.f9556c.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f9554a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f9554a) {
            this.f9554a.add(fragment);
        }
        fragment.mAdded = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f9555b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f9555b.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i11) {
        for (u uVar : this.f9555b.values()) {
            if (uVar != null) {
                uVar.u(i11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f9555b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (u uVar : this.f9555b.values()) {
                printWriter.print(str);
                if (uVar != null) {
                    Fragment k11 = uVar.k();
                    printWriter.println(k11);
                    k11.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f9554a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i11 = 0; i11 < size; i11++) {
                Fragment fragment = (Fragment) this.f9554a.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f(String str) {
        u uVar = (u) this.f9555b.get(str);
        if (uVar != null) {
            return uVar.k();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment g(int i11) {
        for (int size = this.f9554a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f9554a.get(size);
            if (fragment != null && fragment.mFragmentId == i11) {
                return fragment;
            }
        }
        for (u uVar : this.f9555b.values()) {
            if (uVar != null) {
                Fragment k11 = uVar.k();
                if (k11.mFragmentId == i11) {
                    return k11;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f9554a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f9554a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (u uVar : this.f9555b.values()) {
            if (uVar != null) {
                Fragment k11 = uVar.k();
                if (str.equals(k11.mTag)) {
                    return k11;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (u uVar : this.f9555b.values()) {
            if (uVar != null && (findFragmentByWho = uVar.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f9554a.indexOf(fragment);
        for (int i11 = indexOf - 1; i11 >= 0; i11--) {
            Fragment fragment2 = (Fragment) this.f9554a.get(i11);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f9554a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f9554a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List k() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.f9555b.values()) {
            if (uVar != null) {
                arrayList.add(uVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List l() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.f9555b.values()) {
            if (uVar != null) {
                arrayList.add(uVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList m() {
        return new ArrayList(this.f9556c.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u n(String str) {
        return (u) this.f9555b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List o() {
        ArrayList arrayList;
        if (this.f9554a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f9554a) {
            arrayList = new ArrayList(this.f9554a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r p() {
        return this.f9557d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState q(String str) {
        return (FragmentState) this.f9556c.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(u uVar) {
        Fragment k11 = uVar.k();
        if (c(k11.mWho)) {
            return;
        }
        this.f9555b.put(k11.mWho, uVar);
        if (k11.mRetainInstanceChangedWhileDetached) {
            if (k11.mRetainInstance) {
                this.f9557d.b(k11);
            } else {
                this.f9557d.l(k11);
            }
            k11.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(u uVar) {
        Fragment k11 = uVar.k();
        if (k11.mRetainInstance) {
            this.f9557d.l(k11);
        }
        if (((u) this.f9555b.put(k11.mWho, null)) != null && FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        Iterator it = this.f9554a.iterator();
        while (it.hasNext()) {
            u uVar = (u) this.f9555b.get(((Fragment) it.next()).mWho);
            if (uVar != null) {
                uVar.m();
            }
        }
        for (u uVar2 : this.f9555b.values()) {
            if (uVar2 != null) {
                uVar2.m();
                Fragment k11 = uVar2.k();
                if (k11.mRemoving && !k11.isInBackStack()) {
                    if (k11.mBeingSaved && !this.f9556c.containsKey(k11.mWho)) {
                        uVar2.s();
                    }
                    s(uVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(Fragment fragment) {
        synchronized (this.f9554a) {
            this.f9554a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.f9555b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(List list) {
        this.f9554a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment f11 = f(str);
                if (f11 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f11);
                }
                a(f11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ArrayList arrayList) {
        this.f9556c.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FragmentState fragmentState = (FragmentState) it.next();
            this.f9556c.put(fragmentState.f9450b, fragmentState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f9555b.size());
        for (u uVar : this.f9555b.values()) {
            if (uVar != null) {
                Fragment k11 = uVar.k();
                uVar.s();
                arrayList.add(k11.mWho);
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k11 + ": " + k11.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList z() {
        synchronized (this.f9554a) {
            try {
                if (this.f9554a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f9554a.size());
                Iterator it = this.f9554a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.mWho);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
