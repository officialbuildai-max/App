package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SingleImagePage;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.PostItemType;
import ej.f;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class b0 extends BaseItemBindingProvider {

    /* renamed from: h, reason: collision with root package name */
    public static final int f44774h = BaseItemBindingProvider.f43464f;

    /* renamed from: g, reason: collision with root package name */
    private final int f44775g = com.blankj.utilcode.util.y.e() - dk.a.b(24);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(BaseViewHolder baseViewHolder, OperateItem operateItem, View view) {
        String deepLink;
        rl.c.f74670a.f(baseViewHolder.getBindingAdapterPosition(), operateItem);
        SingleImagePage page = operateItem.getPage();
        if (page == null || (deepLink = page.getDeepLink()) == null) {
            deepLink = operateItem.getDeepLink();
        }
        if (deepLink != null) {
            ak.k.h(deepLink, null, 1, null);
        }
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(gl.j0 binding, final BaseViewHolder helper, final OperateItem item) {
        Image image;
        String url;
        String str;
        Image image2;
        Image image3;
        Image image4;
        Integer width;
        Image image5;
        Integer height;
        Intrinsics.h(binding, "binding");
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        binding.f63871c.setText(item.getTitle());
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b0.C(BaseViewHolder.this, item, view);
            }
        });
        SingleImagePage page = item.getPage();
        int intValue = (page == null || (image5 = page.getImage()) == null || (height = image5.getHeight()) == null) ? 0 : height.intValue();
        SingleImagePage page2 = item.getPage();
        int intValue2 = (page2 == null || (image4 = page2.getImage()) == null || (width = image4.getWidth()) == null) ? 1 : width.intValue();
        int i11 = this.f44775g;
        float f11 = ((i11 * intValue) * 1.0f) / intValue2;
        a.C0856a c0856a = lg.a.f68962a;
        SingleImagePage page3 = item.getPage();
        a.C0856a.f(c0856a, "SingleImage", "imgH:" + intValue + ",imgW:" + intValue2 + " imageViewHeight:" + f11 + ", imageViewWidth:" + i11 + "， url:" + ((page3 == null || (image3 = page3.getImage()) == null) ? null : image3.getUrl()), false, 4, null);
        ViewGroup.LayoutParams layoutParams = binding.f63870b.getLayoutParams();
        layoutParams.height = (int) f11;
        binding.f63870b.setLayoutParams(layoutParams);
        SingleImagePage page4 = item.getPage();
        if (page4 == null || (image = page4.getImage()) == null || (url = image.getUrl()) == null) {
            return;
        }
        f.a aVar = ej.f.f62005a;
        Context context = binding.f63870b.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b g11 = aVar.m(context).g(url);
        SingleImagePage page5 = item.getPage();
        if (page5 == null || (image2 = page5.getImage()) == null || (str = image2.getThumbnail()) == null) {
            str = "";
        }
        f.b m11 = g11.l(str).m(this.f44775g);
        ShapeableImageView ivCover = binding.f63870b;
        Intrinsics.g(ivCover, "ivCover");
        m11.d(ivCover);
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public gl.j0 z(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        gl.j0 c11 = gl.j0.c(LayoutInflater.from(k()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.SINGLE_IMAGE.ordinal();
    }
}
