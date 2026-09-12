package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.tn.lib.widget.R$string;
import com.transsion.gslb.Utils;
import com.transsion.home.R$id;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Image;
import com.transsnet.downloader.DownloadManagerApi;
import ej.f;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubBannerViewHolder extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f44506a;

    /* renamed from: b, reason: collision with root package name */
    private final com.transsion.home.adapter.suboperate.provider.i f44507b;

    /* renamed from: c, reason: collision with root package name */
    private final OperateItem f44508c;

    /* renamed from: d, reason: collision with root package name */
    private final View f44509d;

    /* renamed from: e, reason: collision with root package name */
    private final View f44510e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f44511f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubBannerViewHolder(View itemView, int i11, com.transsion.home.adapter.suboperate.provider.i bannerProvider, OperateItem operateItem) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        Intrinsics.h(bannerProvider, "bannerProvider");
        Intrinsics.h(operateItem, "operateItem");
        this.f44506a = i11;
        this.f44507b = bannerProvider;
        this.f44508c = operateItem;
        View findViewById = itemView.findViewById(R$id.home_sub_pager_items_status);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f44509d = findViewById;
        View findViewById2 = itemView.findViewById(R$id.home_sub_pager_items_top_mask);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f44510e = findViewById2;
        View findViewById3 = itemView.findViewById(R$id.home_sub_pager_item_image);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f44511f = (ImageView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(BannerData bannerData, SubBannerViewHolder subBannerViewHolder, int i11, View view) {
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            if (!nh.m.f70597a.e()) {
                uh.b.f76876a.d(R$string.no_network_toast);
                return;
            }
            Uri g11 = com.transsion.baselib.helper.b.f43318a.g(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
            if (g11 != null) {
                ak.k.o(g11);
            }
            subBannerViewHolder.k(bannerData, i11, DownloadManagerApi.x0(DownloadManagerApi.f58521j.a(), bannerData.getSubjectId(), null, false, false, 12, null) ? "play_subject" : "download_subject");
        }
    }

    private final GradientDrawable i(String str) {
        int parseColor = Color.parseColor(str);
        int red = Color.red(parseColor);
        int green = Color.green(parseColor);
        int blue = Color.blue(parseColor);
        int argb = Color.argb(255, red, green, blue);
        int argb2 = Color.argb(153, red, green, blue);
        int argb3 = Color.argb(0, red, green, blue);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{argb, argb2, argb3});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    private final void j(BannerData bannerData, int i11) {
        if (this.f44507b.T(bannerData != null ? bannerData.getSubjectId() : null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "browse_banner");
            hashMap.put("sequence", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(this.f44506a));
            if (bannerData != null) {
                il.b.c(bannerData, hashMap);
            }
            il.b.a(this.f44508c, hashMap);
            com.transsion.baselib.helper.a.f43316a.e(SubTabFragment.INSTANCE.a(this.f44506a), hashMap);
        }
    }

    private final void k(BannerData bannerData, int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_banner_poster");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("module_name", str);
        hashMap.put("tabId", String.valueOf(this.f44506a));
        if (bannerData != null) {
            il.b.c(bannerData, hashMap);
        }
        il.b.a(this.f44508c, hashMap);
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44506a), hashMap);
    }

    public final void g(final BannerData bannerData, final int i11) {
        String str;
        String thumbnail;
        if (bannerData == null) {
            return;
        }
        oh.h hVar = oh.h.f71144a;
        Context context = this.f44511f.getContext();
        Intrinsics.g(context, "getContext(...)");
        int e11 = hVar.e(context);
        if (bannerData.getBuiltIn()) {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new SubBannerViewHolder$bindData$1(bannerData, this, null), 3, null);
        } else {
            f.a aVar = ej.f.f62005a;
            Context context2 = this.f44511f.getContext();
            Intrinsics.g(context2, "getContext(...)");
            f.b m11 = aVar.m(context2);
            Image image = bannerData.getImage();
            String str2 = "";
            if (image == null || (str = image.getUrl()) == null) {
                str = "";
            }
            f.b m12 = m11.g(str).m(e11);
            Image image2 = bannerData.getImage();
            if (image2 != null && (thumbnail = image2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            m12.l(str2).d(this.f44511f);
        }
        this.f44509d.getLayoutParams().height = com.blankj.utilcode.util.d.c() + a0.a(44.0f);
        Image image3 = bannerData.getImage();
        String averageHueDark = image3 != null ? image3.getAverageHueDark() : null;
        if (averageHueDark != null && StringsKt.c0(averageHueDark, Utils.SEPARATOR, false, 2, null)) {
            this.f44509d.setBackgroundColor(Color.parseColor(averageHueDark));
            this.f44510e.setBackground(i(averageHueDark));
        }
        j(bannerData, i11);
        this.f44511f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubBannerViewHolder.h(BannerData.this, this, i11, view);
            }
        });
    }

    public final ImageView getImageView() {
        return this.f44511f;
    }
}
