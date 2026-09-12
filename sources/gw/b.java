package gw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.base.report.athena.ClickType;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import fw.t0;
import hj.i;
import jw.a;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ti.n;

/* loaded from: classes7.dex */
public final class b extends BaseItemBindingProvider {

    /* renamed from: i, reason: collision with root package name */
    public static final a f64137i = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final String f64138g = n.f76387a.b();

    /* renamed from: h, reason: collision with root package name */
    private final int f64139h = 2;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(b bVar, View view) {
        bVar.E();
        Navigator.x(TheRouter.c("/member/MemberActivity"), bVar.k(), null, 2, null);
    }

    private final void E() {
        i.f64628a.q("/profile/device_management", MapsKt.j(TuplesKt.a("module_name", "unlock_premium"), TuplesKt.a(NativeComponentConstants.KEY_COMPONENT_TYPE, "button")), ClickType.FEATURE);
        com.transsion.baselib.helper.f.g(com.transsion.baselib.helper.f.f43323a, "/profile/device_management", "linked_device/vip_entry", this.f64138g, null, 4, 8, null);
    }

    private final void F() {
        com.transsion.baselib.helper.f.i(com.transsion.baselib.helper.f.f43323a, "/profile/device_management", "linked_device/vip_entry", this.f64138g, null, 4, 8, null);
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(t0 binding, BaseViewHolder helper, jw.a item) {
        Intrinsics.h(binding, "binding");
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        a.C0831a c0831a = item instanceof a.C0831a ? (a.C0831a) item : null;
        if (c0831a == null) {
            return;
        }
        binding.f63036d.setText(String.valueOf(c0831a.a().b()));
        binding.f63047o.setText(String.valueOf(c0831a.a().f()));
        RecyclerView.Adapter adapter = binding.f63053u.getAdapter();
        com.transsion.usercenter.devicemanagement.adapter.d dVar = adapter instanceof com.transsion.usercenter.devicemanagement.adapter.d ? (com.transsion.usercenter.devicemanagement.adapter.d) adapter : null;
        if (dVar == null) {
            dVar = new com.transsion.usercenter.devicemanagement.adapter.d();
            binding.f63053u.setLayoutManager(new LinearLayoutManager(k()));
            binding.f63053u.setAdapter(dVar);
            binding.f63053u.setNestedScrollingEnabled(false);
            binding.f63053u.setOverScrollMode(2);
        }
        dVar.n1(c0831a.a().g());
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: gw.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.C(b.this, view);
            }
        };
        binding.f63055w.setOnClickListener(onClickListener);
        binding.f63054v.setOnClickListener(onClickListener);
        F();
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public t0 z(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        t0 c11 = t0.c(inflater, parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f64139h;
    }
}
