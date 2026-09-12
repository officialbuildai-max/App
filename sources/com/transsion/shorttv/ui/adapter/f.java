package com.transsion.shorttv.ui.adapter;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f53178e = R$layout.short_tv_item_immersion_ad;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f53178e;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, js.k item) {
        NativeWrapperAdView nativeWrapperAdView;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (!(item instanceof js.c) || (nativeWrapperAdView = (NativeWrapperAdView) helper.getViewOrNull(R$id.flRoot)) == null) {
            return;
        }
        ur.b bVar = ur.b.f77013a;
        Context k11 = k();
        js.c cVar = (js.c) item;
        BiddingNativeManager a11 = cVar.a();
        com.transsion.ad.bidding.base.r a12 = bVar.a(k11, a11 != null ? a11.getMSceneId() : null);
        BiddingNativeManager a13 = cVar.a();
        BiddingNativeManager a14 = cVar.a();
        nativeWrapperAdView.bindNativeView(a13, a12, a14 != null ? a14.n0() : null);
    }
}
