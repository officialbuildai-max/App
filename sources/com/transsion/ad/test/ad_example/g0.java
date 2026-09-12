package com.transsion.ad.test.ad_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g0 extends com.transsion.ad.bidding.base.u {

    /* renamed from: b, reason: collision with root package name */
    private final ji.e0 f42392b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        ji.e0 c11 = ji.e0.c(LayoutInflater.from(context), null, false);
        Intrinsics.g(c11, "inflate(...)");
        this.f42392b = c11;
    }

    @Override // com.transsion.ad.bidding.base.u
    public AdChoicesView a() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public AdCloseView b() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView c() {
        return this.f42392b.f66187c;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView e() {
        return this.f42392b.f66189e;
    }

    @Override // com.transsion.ad.bidding.base.u
    public ImageView f() {
        AppCompatImageView nativeAdIcon = this.f42392b.f66190f;
        Intrinsics.g(nativeAdIcon, "nativeAdIcon");
        return nativeAdIcon;
    }

    @Override // com.transsion.ad.bidding.base.u
    public MediaView g() {
        MediaView nativeAdMedia = this.f42392b.f66191g;
        Intrinsics.g(nativeAdMedia, "nativeAdMedia");
        return nativeAdMedia;
    }

    @Override // com.transsion.ad.bidding.base.u
    public StoreMarkView h() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public View i() {
        CardView root = this.f42392b.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView j() {
        return this.f42392b.f66193i;
    }
}
