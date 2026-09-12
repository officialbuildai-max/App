package gw;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import fw.u0;
import jw.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c extends BaseItemBindingProvider {

    /* renamed from: h, reason: collision with root package name */
    public static final a f64140h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final int f64141g = 5;

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
    public void y(u0 binding, BaseViewHolder helper, jw.a item) {
        Intrinsics.h(binding, "binding");
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        a.b bVar = item instanceof a.b ? (a.b) item : null;
        if (bVar == null) {
            return;
        }
        binding.f63068b.setText(bVar.a());
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public u0 z(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        u0 c11 = u0.c(inflater, parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f64141g;
    }
}
