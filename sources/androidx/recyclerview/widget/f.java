package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f implements k.b {

    /* renamed from: a, reason: collision with root package name */
    private final ConcatAdapter f14449a;

    /* renamed from: b, reason: collision with root package name */
    private final v f14450b;

    /* renamed from: c, reason: collision with root package name */
    private List f14451c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final IdentityHashMap f14452d = new IdentityHashMap();

    /* renamed from: e, reason: collision with root package name */
    private List f14453e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private a f14454f = new a();

    /* renamed from: g, reason: collision with root package name */
    private final ConcatAdapter.Config.StableIdMode f14455g;

    /* renamed from: h, reason: collision with root package name */
    private final s f14456h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        k f14457a;

        /* renamed from: b, reason: collision with root package name */
        int f14458b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14459c;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.f14449a = concatAdapter;
        if (config.f14173a) {
            this.f14450b = new v.a();
        } else {
            this.f14450b = new v.b();
        }
        ConcatAdapter.Config.StableIdMode stableIdMode = config.f14174b;
        this.f14455g = stableIdMode;
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.f14456h = new s.b();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.f14456h = new s.a();
        } else {
            if (stableIdMode != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
                throw new IllegalArgumentException("unknown stable id mode");
            }
            this.f14456h = new s.c();
        }
    }

    private void D(a aVar) {
        aVar.f14459c = false;
        aVar.f14457a = null;
        aVar.f14458b = -1;
        this.f14454f = aVar;
    }

    private void i() {
        RecyclerView.Adapter.StateRestorationPolicy j11 = j();
        if (j11 != this.f14449a.getStateRestorationPolicy()) {
            this.f14449a.h(j11);
        }
    }

    private RecyclerView.Adapter.StateRestorationPolicy j() {
        for (k kVar : this.f14453e) {
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = kVar.f14480c.getStateRestorationPolicy();
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == stateRestorationPolicy2) {
                return stateRestorationPolicy2;
            }
            if (stateRestorationPolicy == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && kVar.a() == 0) {
                return stateRestorationPolicy2;
            }
        }
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int k(k kVar) {
        k kVar2;
        Iterator it = this.f14453e.iterator();
        int i11 = 0;
        while (it.hasNext() && (kVar2 = (k) it.next()) != kVar) {
            i11 += kVar2.a();
        }
        return i11;
    }

    private a l(int i11) {
        a aVar = this.f14454f;
        if (aVar.f14459c) {
            aVar = new a();
        } else {
            aVar.f14459c = true;
        }
        Iterator it = this.f14453e.iterator();
        int i12 = i11;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k kVar = (k) it.next();
            if (kVar.a() > i12) {
                aVar.f14457a = kVar;
                aVar.f14458b = i12;
                break;
            }
            i12 -= kVar.a();
        }
        if (aVar.f14457a != null) {
            return aVar;
        }
        throw new IllegalArgumentException("Cannot find wrapper for " + i11);
    }

    private k m(RecyclerView.Adapter adapter) {
        int t11 = t(adapter);
        if (t11 == -1) {
            return null;
        }
        return (k) this.f14453e.get(t11);
    }

    private k r(RecyclerView.b0 b0Var) {
        k kVar = (k) this.f14452d.get(b0Var);
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("Cannot find wrapper for " + b0Var + ", seems like it is not bound by this adapter: " + this);
    }

    private int t(RecyclerView.Adapter adapter) {
        int size = this.f14453e.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((k) this.f14453e.get(i11)).f14480c == adapter) {
                return i11;
            }
        }
        return -1;
    }

    private boolean u(RecyclerView recyclerView) {
        Iterator it = this.f14451c.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    public void A(RecyclerView.b0 b0Var) {
        r(b0Var).f14480c.onViewAttachedToWindow(b0Var);
    }

    public void B(RecyclerView.b0 b0Var) {
        r(b0Var).f14480c.onViewDetachedFromWindow(b0Var);
    }

    public void C(RecyclerView.b0 b0Var) {
        k kVar = (k) this.f14452d.get(b0Var);
        if (kVar != null) {
            kVar.f14480c.onViewRecycled(b0Var);
            this.f14452d.remove(b0Var);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + b0Var + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // androidx.recyclerview.widget.k.b
    public void a(k kVar, int i11, int i12, Object obj) {
        this.f14449a.notifyItemRangeChanged(i11 + k(kVar), i12, obj);
    }

    @Override // androidx.recyclerview.widget.k.b
    public void b(k kVar, int i11, int i12) {
        this.f14449a.notifyItemRangeInserted(i11 + k(kVar), i12);
    }

    @Override // androidx.recyclerview.widget.k.b
    public void c(k kVar, int i11, int i12) {
        int k11 = k(kVar);
        this.f14449a.notifyItemMoved(i11 + k11, i12 + k11);
    }

    @Override // androidx.recyclerview.widget.k.b
    public void d(k kVar) {
        i();
    }

    @Override // androidx.recyclerview.widget.k.b
    public void e(k kVar) {
        this.f14449a.notifyDataSetChanged();
        i();
    }

    @Override // androidx.recyclerview.widget.k.b
    public void f(k kVar, int i11, int i12) {
        this.f14449a.notifyItemRangeRemoved(i11 + k(kVar), i12);
    }

    boolean g(int i11, RecyclerView.Adapter adapter) {
        if (i11 < 0 || i11 > this.f14453e.size()) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.f14453e.size() + ". Given:" + i11);
        }
        if (s()) {
            androidx.core.util.i.b(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (adapter.hasStableIds()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (m(adapter) != null) {
            return false;
        }
        k kVar = new k(adapter, this, this.f14450b, this.f14456h.a());
        this.f14453e.add(i11, kVar);
        Iterator it = this.f14451c.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = (RecyclerView) ((WeakReference) it.next()).get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (kVar.a() > 0) {
            this.f14449a.notifyItemRangeInserted(k(kVar), kVar.a());
        }
        i();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.Adapter adapter) {
        return g(this.f14453e.size(), adapter);
    }

    public long n(int i11) {
        a l11 = l(i11);
        long b11 = l11.f14457a.b(l11.f14458b);
        D(l11);
        return b11;
    }

    public int o(int i11) {
        a l11 = l(i11);
        int c11 = l11.f14457a.c(l11.f14458b);
        D(l11);
        return c11;
    }

    public int p(RecyclerView.Adapter adapter, RecyclerView.b0 b0Var, int i11) {
        k kVar = (k) this.f14452d.get(b0Var);
        if (kVar == null) {
            return -1;
        }
        int k11 = i11 - k(kVar);
        int itemCount = kVar.f14480c.getItemCount();
        if (k11 >= 0 && k11 < itemCount) {
            return kVar.f14480c.findRelativeAdapterPositionIn(adapter, b0Var, k11);
        }
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + k11 + " which is out of bounds for the adapter with size " + itemCount + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + b0Var + "adapter:" + adapter);
    }

    public int q() {
        Iterator it = this.f14453e.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += ((k) it.next()).a();
        }
        return i11;
    }

    public boolean s() {
        return this.f14455g != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }

    public void v(RecyclerView recyclerView) {
        if (u(recyclerView)) {
            return;
        }
        this.f14451c.add(new WeakReference(recyclerView));
        Iterator it = this.f14453e.iterator();
        while (it.hasNext()) {
            ((k) it.next()).f14480c.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void w(RecyclerView.b0 b0Var, int i11) {
        a l11 = l(i11);
        this.f14452d.put(b0Var, l11.f14457a);
        l11.f14457a.d(b0Var, l11.f14458b);
        D(l11);
    }

    public RecyclerView.b0 x(ViewGroup viewGroup, int i11) {
        return this.f14450b.a(i11).e(viewGroup, i11);
    }

    public void y(RecyclerView recyclerView) {
        int size = this.f14451c.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference weakReference = (WeakReference) this.f14451c.get(size);
            if (weakReference.get() == null) {
                this.f14451c.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.f14451c.remove(size);
                break;
            }
            size--;
        }
        Iterator it = this.f14453e.iterator();
        while (it.hasNext()) {
            ((k) it.next()).f14480c.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean z(RecyclerView.b0 b0Var) {
        k kVar = (k) this.f14452d.get(b0Var);
        if (kVar != null) {
            boolean onFailedToRecycleView = kVar.f14480c.onFailedToRecycleView(b0Var);
            this.f14452d.remove(b0Var);
            return onFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + b0Var + ", seems like it is not bound by this adapter: " + this);
    }
}
