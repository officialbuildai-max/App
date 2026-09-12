package gw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.base.report.athena.ClickType;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import fw.w0;
import hj.i;
import jw.a;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f extends BaseItemBindingProvider {

    /* renamed from: h, reason: collision with root package name */
    public static final a f64145h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final int f64146g = 3;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(f fVar, View view) {
        fVar.E();
        Navigator.x(TheRouter.c("/profile/qr_code"), fVar.k(), null, 2, null);
    }

    private final void E() {
        i.f64628a.q("/profile/device_management", MapsKt.j(TuplesKt.a("module_name", "link_device"), TuplesKt.a(NativeComponentConstants.KEY_COMPONENT_TYPE, "pro")), ClickType.FEATURE);
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(w0 binding, BaseViewHolder helper, jw.a item) {
        Intrinsics.h(binding, "binding");
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (item != a.d.f66429a) {
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: gw.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.C(f.this, view);
            }
        };
        binding.f63094b.setOnClickListener(onClickListener);
        binding.f63095c.setOnClickListener(onClickListener);
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public w0 z(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        w0 c11 = w0.c(inflater, parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f64146g;
    }
}
