package com.transsion.home.adapter.operateUGC.adapter;

import ak.k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.tn.lib.widget.R$string;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Image;
import ej.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import nh.m;

/* loaded from: classes5.dex */
public final class BannerUGCAdapter extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final List f44330a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44331b;

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.home.adapter.operateUGC.provider.c f44332c;

    /* renamed from: d, reason: collision with root package name */
    private final OperateItem f44333d;

    /* renamed from: e, reason: collision with root package name */
    private final int f44334e;

    /* renamed from: f, reason: collision with root package name */
    private final int f44335f;

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final ImageView f44336a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView f44337b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.h(itemView, "itemView");
            View findViewById = itemView.findViewById(R$id.home_ugc_banner_item_image);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.f44336a = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R$id.home_ugc_banner_title);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.f44337b = (TextView) findViewById2;
        }

        public final TextView f() {
            return this.f44337b;
        }

        public final ImageView getImageView() {
            return this.f44336a;
        }
    }

    public BannerUGCAdapter(List banners, int i11, com.transsion.home.adapter.operateUGC.provider.c bannerProvider, OperateItem operateItem) {
        Intrinsics.h(banners, "banners");
        Intrinsics.h(bannerProvider, "bannerProvider");
        Intrinsics.h(operateItem, "operateItem");
        this.f44330a = banners;
        this.f44331b = i11;
        this.f44332c = bannerProvider;
        this.f44333d = operateItem;
        int e11 = y.e() - (a0.a(12.0f) * 2);
        this.f44334e = e11;
        this.f44335f = Intrinsics.c(operateItem.getStyleTemplate(), "BANNER_NARROW") ? (e11 * 5) / 14 : (e11 * 9) / 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BannerData bannerData, BannerUGCAdapter bannerUGCAdapter, int i11, View view) {
        String deepLink;
        if (bannerData == null || (deepLink = bannerData.getDeepLink()) == null) {
            return;
        }
        if (!m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        k.g(deepLink, "&module_name=opt_banner_free&from_opt_id=" + bannerUGCAdapter.f44333d.getOpId() + "&ops=" + bannerData.getOps() + "&tab_id=" + bannerUGCAdapter.f44331b);
        hl.d.f64648c.b(bannerUGCAdapter.f44331b, i11, bannerUGCAdapter.f44333d, bannerData);
    }

    private final void k(BannerData bannerData, int i11) {
        if (this.f44332c.I(bannerData != null ? bannerData.getDeepLink() : null)) {
            hl.d.f64648c.a(this.f44331b, i11, this.f44333d, bannerData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        String str;
        String str2;
        Image image;
        Image image2;
        String content;
        Intrinsics.h(holder, "holder");
        if (this.f44330a.isEmpty()) {
            return;
        }
        final int size = i11 % this.f44330a.size();
        final BannerData bannerData = (BannerData) this.f44330a.get(size);
        String str3 = "";
        if (bannerData == null || !bannerData.getBuiltIn()) {
            f.a aVar = ej.f.f62005a;
            Context context = holder.getImageView().getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m11 = aVar.m(context);
            if (bannerData == null || (image2 = bannerData.getImage()) == null || (str = image2.getUrl()) == null) {
                str = "";
            }
            f.b m12 = m11.g(str).m(this.f44334e);
            if (bannerData == null || (image = bannerData.getImage()) == null || (str2 = image.getThumbnail()) == null) {
                str2 = "";
            }
            m12.l(str2).d(holder.getImageView());
        } else {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new BannerUGCAdapter$onBindViewHolder$1(bannerData, holder, null), 3, null);
        }
        TextView f11 = holder.f();
        if (bannerData != null && (content = bannerData.getContent()) != null) {
            str3 = content;
        }
        f11.setText(str3);
        k(bannerData, size);
        holder.getImageView().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerUGCAdapter.i(BannerData.this, this, size, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_ugc_banner, parent, false);
        Intrinsics.e(inflate);
        a aVar = new a(inflate);
        aVar.getImageView().getLayoutParams().height = this.f44335f;
        return aVar;
    }
}
