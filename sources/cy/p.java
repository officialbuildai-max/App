package cy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class p extends com.transsion.ad.bidding.base.u {

    /* renamed from: b, reason: collision with root package name */
    private final ey.b f61079b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        ey.b c11 = ey.b.c(LayoutInflater.from(context), null, false);
        Intrinsics.g(c11, "inflate(...)");
        this.f61079b = c11;
    }

    @Override // com.transsion.ad.bidding.base.u
    public AdChoicesView a() {
        return this.f61079b.f62195b;
    }

    @Override // com.transsion.ad.bidding.base.u
    public AdCloseView b() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView c() {
        return this.f61079b.f62197d;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView e() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public ImageView f() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public MediaView g() {
        MediaView nativeAdMedia = this.f61079b.f62198e;
        Intrinsics.g(nativeAdMedia, "nativeAdMedia");
        return nativeAdMedia;
    }

    @Override // com.transsion.ad.bidding.base.u
    public StoreMarkView h() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.u
    public View i() {
        ConstraintLayout root = this.f61079b.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    @Override // com.transsion.ad.bidding.base.u
    public TextView j() {
        return null;
    }
}
