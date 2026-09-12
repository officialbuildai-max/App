package gw;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import fw.v0;
import jw.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d extends BaseItemBindingProvider {

    /* renamed from: h, reason: collision with root package name */
    public static final a f64142h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final int f64143g = 4;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(v0 binding, BaseViewHolder helper, jw.a item) {
        Intrinsics.h(binding, "binding");
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        a.c cVar = item instanceof a.c ? (a.c) item : null;
        if (cVar == null) {
            return;
        }
        RecyclerView.Adapter adapter = binding.f63076b.getAdapter();
        com.transsion.usercenter.devicemanagement.adapter.b bVar = adapter instanceof com.transsion.usercenter.devicemanagement.adapter.b ? (com.transsion.usercenter.devicemanagement.adapter.b) adapter : null;
        if (bVar == null) {
            bVar = new com.transsion.usercenter.devicemanagement.adapter.b();
            binding.f63076b.setLayoutManager(new LinearLayoutManager(k()));
            binding.f63076b.setAdapter(bVar);
            binding.f63076b.setNestedScrollingEnabled(false);
            binding.f63076b.setOverScrollMode(2);
        }
        bVar.n1(cVar.a());
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public v0 z(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        v0 c11 = v0.c(inflater, parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f64143g;
    }
}
