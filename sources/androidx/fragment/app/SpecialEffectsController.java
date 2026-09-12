package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.os.e;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f9488a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f9489b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f9490c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    boolean f9491d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f9492e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Operation {

        /* renamed from: a, reason: collision with root package name */
        private State f9493a;

        /* renamed from: b, reason: collision with root package name */
        private LifecycleImpact f9494b;

        /* renamed from: c, reason: collision with root package name */
        private final Fragment f9495c;

        /* renamed from: d, reason: collision with root package name */
        private final List f9496d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final HashSet f9497e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        private boolean f9498f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f9499g = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* JADX INFO: Access modifiers changed from: package-private */
            @NonNull
            public static State from(int i11) {
                if (i11 == 0) {
                    return VISIBLE;
                }
                if (i11 == 4) {
                    return INVISIBLE;
                }
                if (i11 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i11);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @NonNull
            public static State from(@NonNull View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void applyState(@NonNull View view) {
                int i11 = a.f9501a[ordinal()];
                if (i11 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.M0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i11 == 2) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i11 == 3) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i11 != 4) {
                    return;
                }
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        /* loaded from: classes.dex */
        class a implements e.a {
            a() {
            }

            @Override // androidx.core.os.e.a
            public void onCancel() {
                Operation.this.b();
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, androidx.core.os.e eVar) {
            this.f9493a = state;
            this.f9494b = lifecycleImpact;
            this.f9495c = fragment;
            eVar.b(new a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f9496d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f9498f = true;
            if (this.f9497e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f9497e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.e) it.next()).a();
            }
        }

        public void c() {
            if (this.f9499g) {
                return;
            }
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f9499g = true;
            Iterator it = this.f9496d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(androidx.core.os.e eVar) {
            if (this.f9497e.remove(eVar) && this.f9497e.isEmpty()) {
                c();
            }
        }

        public State e() {
            return this.f9493a;
        }

        public final Fragment f() {
            return this.f9495c;
        }

        LifecycleImpact g() {
            return this.f9494b;
        }

        final boolean h() {
            return this.f9498f;
        }

        final boolean i() {
            return this.f9499g;
        }

        public final void j(androidx.core.os.e eVar) {
            l();
            this.f9497e.add(eVar);
        }

        final void k(State state, LifecycleImpact lifecycleImpact) {
            int i11 = a.f9502b[lifecycleImpact.ordinal()];
            if (i11 == 1) {
                if (this.f9493a == State.REMOVED) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f9495c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f9494b + " to ADDING.");
                    }
                    this.f9493a = State.VISIBLE;
                    this.f9494b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i11 == 2) {
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f9495c + " mFinalState = " + this.f9493a + " -> REMOVED. mLifecycleImpact  = " + this.f9494b + " to REMOVING.");
                }
                this.f9493a = State.REMOVED;
                this.f9494b = LifecycleImpact.REMOVING;
                return;
            }
            if (i11 == 3 && this.f9493a != State.REMOVED) {
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f9495c + " mFinalState = " + this.f9493a + " -> " + state + ". ");
                }
                this.f9493a = state;
            }
        }

        abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f9493a + "} {mLifecycleImpact = " + this.f9494b + "} {mFragment = " + this.f9495c + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9501a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f9502b;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            f9502b = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9502b[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9502b[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            f9501a = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9501a[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9501a[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9501a[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends Operation {

        /* renamed from: h, reason: collision with root package name */
        private final u f9503h;

        b(Operation.State state, Operation.LifecycleImpact lifecycleImpact, u uVar, androidx.core.os.e eVar) {
            super(state, lifecycleImpact, uVar.k(), eVar);
            this.f9503h = uVar;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void c() {
            super.c();
            this.f9503h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void l() {
            if (g() != Operation.LifecycleImpact.ADDING) {
                if (g() == Operation.LifecycleImpact.REMOVING) {
                    Fragment k11 = this.f9503h.k();
                    View requireView = k11.requireView();
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + requireView.findFocus() + " on view " + requireView + " for Fragment " + k11);
                    }
                    requireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment k12 = this.f9503h.k();
            View findFocus = k12.mView.findFocus();
            if (findFocus != null) {
                k12.setFocusedView(findFocus);
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k12);
                }
            }
            View requireView2 = f().requireView();
            if (requireView2.getParent() == null) {
                this.f9503h.b();
                requireView2.setAlpha(0.0f);
            }
            if (requireView2.getAlpha() == 0.0f && requireView2.getVisibility() == 0) {
                requireView2.setVisibility(4);
            }
            requireView2.setAlpha(k12.getPostOnViewCreatedAlpha());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpecialEffectsController(ViewGroup viewGroup) {
        this.f9488a = viewGroup;
    }

    private void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, u uVar) {
        synchronized (this.f9489b) {
            try {
                androidx.core.os.e eVar = new androidx.core.os.e();
                Operation h11 = h(uVar.k());
                if (h11 != null) {
                    h11.k(state, lifecycleImpact);
                    return;
                }
                final b bVar = new b(state, lifecycleImpact, uVar, eVar);
                this.f9489b.add(bVar);
                bVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpecialEffectsController.this.f9489b.contains(bVar)) {
                            bVar.e().applyState(bVar.f().mView);
                        }
                    }
                });
                bVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SpecialEffectsController.this.f9489b.remove(bVar);
                        SpecialEffectsController.this.f9490c.remove(bVar);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private Operation h(Fragment fragment) {
        Iterator it = this.f9489b.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    private Operation i(Fragment fragment) {
        Iterator it = this.f9490c.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.E0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController o(ViewGroup viewGroup, b0 b0Var) {
        Object tag = viewGroup.getTag(R$id.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a11 = b0Var.a(viewGroup);
        viewGroup.setTag(R$id.special_effects_controller_view_tag, a11);
        return a11;
    }

    private void q() {
        Iterator it = this.f9489b.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.g() == Operation.LifecycleImpact.ADDING) {
                operation.k(Operation.State.from(operation.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Operation.State state, u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + uVar.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + uVar.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + uVar.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + uVar.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, uVar);
    }

    abstract void f(List list, boolean z10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f9492e) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this.f9488a)) {
            j();
            this.f9491d = false;
            return;
        }
        synchronized (this.f9489b) {
            try {
                if (!this.f9489b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f9490c);
                    this.f9490c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Operation operation = (Operation) it.next();
                        if (FragmentManager.M0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.b();
                        if (!operation.i()) {
                            this.f9490c.add(operation);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f9489b);
                    this.f9489b.clear();
                    this.f9490c.addAll(arrayList2);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((Operation) it2.next()).l();
                    }
                    f(arrayList2, this.f9491d);
                    this.f9491d = false;
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = ViewCompat.isAttachedToWindow(this.f9488a);
        synchronized (this.f9489b) {
            try {
                q();
                Iterator it = this.f9489b.iterator();
                while (it.hasNext()) {
                    ((Operation) it.next()).l();
                }
                Iterator it2 = new ArrayList(this.f9490c).iterator();
                while (it2.hasNext()) {
                    Operation operation = (Operation) it2.next();
                    if (FragmentManager.M0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f9488a + " is not attached to window. ";
                        }
                        sb2.append(str2);
                        sb2.append("Cancelling running operation ");
                        sb2.append(operation);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    operation.b();
                }
                Iterator it3 = new ArrayList(this.f9489b).iterator();
                while (it3.hasNext()) {
                    Operation operation2 = (Operation) it3.next();
                    if (FragmentManager.M0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f9488a + " is not attached to window. ";
                        }
                        sb3.append(str);
                        sb3.append("Cancelling pending operation ");
                        sb3.append(operation2);
                        Log.v("FragmentManager", sb3.toString());
                    }
                    operation2.b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (this.f9492e) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f9492e = false;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Operation.LifecycleImpact l(u uVar) {
        Operation h11 = h(uVar.k());
        Operation.LifecycleImpact g11 = h11 != null ? h11.g() : null;
        Operation i11 = i(uVar.k());
        return (i11 == null || !(g11 == null || g11 == Operation.LifecycleImpact.NONE)) ? g11 : i11.g();
    }

    public ViewGroup m() {
        return this.f9488a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f9489b) {
            try {
                q();
                this.f9492e = false;
                int size = this.f9489b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Operation operation = (Operation) this.f9489b.get(size);
                    Operation.State from = Operation.State.from(operation.f().mView);
                    Operation.State e11 = operation.e();
                    Operation.State state = Operation.State.VISIBLE;
                    if (e11 == state && from != state) {
                        this.f9492e = operation.f().isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z10) {
        this.f9491d = z10;
    }
}
