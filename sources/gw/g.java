package gw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.R$string;
import ej.f;
import fw.x0;
import jw.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class g extends BaseItemBindingProvider {

    /* renamed from: h, reason: collision with root package name */
    public static final a f64147h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final int f64148g = 1;

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
    public void y(x0 binding, BaseViewHolder helper, jw.a item) {
        Intrinsics.h(binding, "binding");
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        a.e eVar = item instanceof a.e ? (a.e) item : null;
        if (eVar == null) {
            return;
        }
        jw.b a11 = eVar.a();
        binding.f63111f.setText(a11.h());
        String a12 = a11.a();
        if (a12 == null || StringsKt.q0(a12)) {
            binding.f63109d.setImageResource(R$drawable.ic_default_avatar);
        } else {
            f.a aVar = ej.f.f62005a;
            Context context = binding.f63109d.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b i11 = aVar.m(context).g(a11.a()).i(R$drawable.ic_default_avatar);
            ShapeableImageView userAvatar = binding.f63109d;
            Intrinsics.g(userAvatar, "userAvatar");
            i11.d(userAvatar);
        }
        binding.f63107b.setSelected(a11.i());
        binding.f63107b.setText(a11.i() ? R$string.user_center_device_management_pro : R$string.user_center_device_management_basic);
        binding.f63108c.setImageResource(a11.i() ? R$mipmap.ic_premium_avatar_pro : R$mipmap.ic_premium_avatar_basic);
        TnTextView validUntil = binding.f63112g;
        Intrinsics.g(validUntil, "validUntil");
        String e11 = a11.e();
        validUntil.setVisibility(!(e11 == null || StringsKt.q0(e11)) ? 0 : 8);
        TnTextView tnTextView = binding.f63112g;
        Context k11 = k();
        int i12 = R$string.user_center_device_management_valid_until;
        String e12 = a11.e();
        if (e12 == null) {
            e12 = "";
        }
        tnTextView.setText(k11.getString(i12, e12));
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public x0 z(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        x0 c11 = x0.c(inflater, parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f64148g;
    }
}
