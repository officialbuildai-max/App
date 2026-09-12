package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final v.c f14478a;

    /* renamed from: b, reason: collision with root package name */
    private final s.d f14479b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView.Adapter f14480c;

    /* renamed from: d, reason: collision with root package name */
    final b f14481d;

    /* renamed from: e, reason: collision with root package name */
    int f14482e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView.g f14483f = new a();

    /* loaded from: classes2.dex */
    class a extends RecyclerView.g {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            k kVar = k.this;
            kVar.f14482e = kVar.f14480c.getItemCount();
            k kVar2 = k.this;
            kVar2.f14481d.e(kVar2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeChanged(int i11, int i12) {
            k kVar = k.this;
            kVar.f14481d.a(kVar, i11, i12, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeChanged(int i11, int i12, Object obj) {
            k kVar = k.this;
            kVar.f14481d.a(kVar, i11, i12, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeInserted(int i11, int i12) {
            k kVar = k.this;
            kVar.f14482e += i12;
            kVar.f14481d.b(kVar, i11, i12);
            k kVar2 = k.this;
            if (kVar2.f14482e <= 0 || kVar2.f14480c.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            k kVar3 = k.this;
            kVar3.f14481d.d(kVar3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeMoved(int i11, int i12, int i13) {
            androidx.core.util.i.b(i13 == 1, "moving more than 1 item is not supported in RecyclerView");
            k kVar = k.this;
            kVar.f14481d.c(kVar, i11, i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeRemoved(int i11, int i12) {
            k kVar = k.this;
            kVar.f14482e -= i12;
            kVar.f14481d.f(kVar, i11, i12);
            k kVar2 = k.this;
            if (kVar2.f14482e >= 1 || kVar2.f14480c.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            k kVar3 = k.this;
            kVar3.f14481d.d(kVar3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onStateRestorationPolicyChanged() {
            k kVar = k.this;
            kVar.f14481d.d(kVar);
        }
    }

    /* loaded from: classes2.dex */
    interface b {
        void a(k kVar, int i11, int i12, Object obj);

        void b(k kVar, int i11, int i12);

        void c(k kVar, int i11, int i12);

        void d(k kVar);

        void e(k kVar);

        void f(k kVar, int i11, int i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(RecyclerView.Adapter adapter, b bVar, v vVar, s.d dVar) {
        this.f14480c = adapter;
        this.f14481d = bVar;
        this.f14478a = vVar.b(this);
        this.f14479b = dVar;
        this.f14482e = adapter.getItemCount();
        adapter.registerAdapterDataObserver(this.f14483f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f14482e;
    }

    public long b(int i11) {
        return this.f14479b.a(this.f14480c.getItemId(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i11) {
        return this.f14478a.b(this.f14480c.getItemViewType(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.b0 b0Var, int i11) {
        this.f14480c.bindViewHolder(b0Var, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.b0 e(ViewGroup viewGroup, int i11) {
        return this.f14480c.onCreateViewHolder(viewGroup, this.f14478a.a(i11));
    }
}
