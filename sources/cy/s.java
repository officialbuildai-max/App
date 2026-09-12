package cy;

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

/* loaded from: classes7.dex */
public final class s extends com.transsion.ad.bidding.base.u {

    /* renamed from: b, reason: collision with root package name */
    private final ey.d f61080b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        ey.d c11 = ey.d.c(LayoutInflater.from(context), null, false);
        Intrinsics.g(c11, "inflate(...)");
        this.f61080b = c11;
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
        return this.f61080b.f62207c;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView e() {
        return this.f61080b.f62209e;
    }

    @Override // com.transsion.ad.bidding.base.u
    public ImageView f() {
        AppCompatImageView nativeAdIcon = this.f61080b.f62210f;
        Intrinsics.g(nativeAdIcon, "nativeAdIcon");
        return nativeAdIcon;
    }

    @Override // com.transsion.ad.bidding.base.u
    public MediaView g() {
        MediaView nativeAdMedia = this.f61080b.f62211g;
        Intrinsics.g(nativeAdMedia, "nativeAdMedia");
        return nativeAdMedia;
    }

    @Override // com.transsion.ad.bidding.base.u
    public StoreMarkView h() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public View i() {
        CardView root = this.f61080b.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView j() {
        return this.f61080b.f62213i;
    }
}
