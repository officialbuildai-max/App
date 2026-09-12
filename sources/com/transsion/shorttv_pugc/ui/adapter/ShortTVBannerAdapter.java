package com.transsion.shorttv_pugc.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.bean.BannerData;
import com.transsion.shorttv_pugc.bean.Image;
import et.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ShortTVBannerAdapter extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final List f54056a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private Function3 f54057b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BannerData bannerData, ShortTVBannerAdapter shortTVBannerAdapter, int i11, View view) {
        Function3 function3;
        if (bannerData == null || (function3 = shortTVBannerAdapter.f54057b) == null) {
            return;
        }
        Intrinsics.e(view);
        function3.invoke(view, Integer.valueOf(i11), bannerData);
    }

    public final List getData() {
        return this.f54056a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f54056a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, final int i11) {
        Image image;
        String thumbnail;
        Image image2;
        String url;
        Boolean hasResource;
        Intrinsics.h(holder, "holder");
        final BannerData bannerData = (BannerData) this.f54056a.get(i11);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv_pugc.ui.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVBannerAdapter.i(BannerData.this, this, i11, view);
            }
        });
        if (bannerData == null || !bannerData.getBuiltIn()) {
            b.a aVar = et.b.f62118a;
            Context context = holder.itemView.getContext();
            Intrinsics.g(context, "getContext(...)");
            ShapeableImageView ivCover = holder.f().f69887b;
            Intrinsics.g(ivCover, "ivCover");
            aVar.j(context, ivCover, (bannerData == null || (image2 = bannerData.getImage()) == null || (url = image2.getUrl()) == null) ? "" : url, (r30 & 8) != 0 ? aVar.c() : R$color.short_tv_module_04, (r30 & 16) != 0 ? aVar.b() : 0, (r30 & 32) != 0, (r30 & 64) != 0 ? "" : (bannerData == null || (image = bannerData.getImage()) == null || (thumbnail = image.getThumbnail()) == null) ? "" : thumbnail, (r30 & 128) != 0, (r30 & 256) != 0, (r30 & 512) != 0 ? false : false, (r30 & 1024) != 0 ? false : false, (r30 & 2048) != 0 ? false : false, (r30 & 4096) != 0 ? 25 : 0);
        } else {
            kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new ShortTVBannerAdapter$onBindViewHolder$1$2(bannerData, holder, null), 3, null);
        }
        holder.f().f69889d.setText(bannerData != null ? bannerData.getContent() : null);
        AppCompatImageView ivPlay = holder.f().f69888c;
        Intrinsics.g(ivPlay, "ivPlay");
        ivPlay.setVisibility((bannerData == null || (hasResource = bannerData.getHasResource()) == null) ? false : hasResource.booleanValue() ? 0 : 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.short_tv_item_banner, parent, false);
        Intrinsics.e(inflate);
        return new b(inflate);
    }

    public final void k(Function3 listener) {
        Intrinsics.h(listener, "listener");
        this.f54057b = listener;
    }

    public final void setData(List list) {
        Intrinsics.h(list, "list");
        this.f54056a.clear();
        this.f54056a.addAll(list);
        notifyDataSetChanged();
    }
}
